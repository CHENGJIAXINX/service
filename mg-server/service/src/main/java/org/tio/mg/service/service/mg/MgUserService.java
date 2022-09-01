package org.tio.mg.service.service.mg;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.cache.CacheConfig;
import org.tio.mg.service.cache.Caches;
import org.tio.mg.service.model.mg.MgRole;
import org.tio.mg.service.model.mg.MgUser;
import org.tio.mg.service.model.mg.MgUserBase;
import org.tio.mg.service.model.mg.MgUserRole;
import org.tio.mg.service.service.atom.AbsTxAtom;
import org.tio.mg.service.service.conf.MgConfService;
import org.tio.mg.service.utils.CommonUtils;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.MgLoginVo;
import org.tio.mg.service.vo.RequestVo;
import org.tio.sitexxx.servicecommon.utils.GoogleAuthenticator;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.resp.Resp;

import java.util.Objects;

/**
 * 后台用户接口
 */
public class MgUserService {

    private static Logger log = LoggerFactory.getLogger(MgUserService.class);

    public static final MgUserService ME = new MgUserService();

    /**
     * 登录
     *
     * @param mgLoginVo
     * @return
     */
    public Ret login(MgLoginVo mgLoginVo) {
        MgUser user = getUserByLoginName(mgLoginVo.getLoginName());
        if (user == null) {
            return RetUtils.failMsg("账号不存在", 1);
        }
        if (!user.getPwd().equals(mgLoginVo.getPd5())) {
            return RetUtils.failMsg("密码错误", 2);
        }
        if (Objects.equals(MgConfService.getByte("isOpen.admin.googleCheck", Const.YesOrNo.NO), Const.YesOrNo.YES)) {
            GoogleAuthenticator ga = new GoogleAuthenticator();
            ga.setWindowSize(5); //should give 5 * 30 seconds of grace...
            if (!ga.check_code(user.getSecret(), mgLoginVo.getGoogleCode())) {
                return RetUtils.failMsg("谷歌验证码错误", 3);
            }
        }
        return RetUtils.okData(user);
    }

    /**
     * 修改密码
     *
     * @param requestVo
     * @return
     */
    public Ret updatePwd(RequestVo requestVo) {
        MgUser userById = MgUser.dao.findById(requestVo.getId());
        if (userById == null) {
            return RetUtils.failMsg("用户未找到");
        }
        if (!userById.getPwd().equals(requestVo.getOldPwd())) {
            return RetUtils.failMsg("旧密码不正确");
        }
        if (requestVo.getNewPwd().equals(requestVo.getOldPwd())) {
            return RetUtils.failMsg("新密码和旧密码一致，无需修改");
        }
        userById.setPwd(requestVo.getNewPwd());
        boolean update = userById.update();
        if (!update) {
            return RetUtils.failMsg("密码修改失败");
        }
        return RetUtils.okOper();
    }

    /**
     * 获取后台用户
     *
     * @param id
     * @return
     */
    public MgUser getUserById(Integer id) {
        if (id == null) {
            return null;
        }
        MgUser user = MgUser.dao.findById(id);
        if (user == null || !Objects.equals(user.getStatus(), Const.Status.NORMAL)) {
            return null;
        }
        return user;
    }

    /**
     * 查询用户列表
     *
     * @param requestVo
     * @return
     */
    public Ret userList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.create();
        if (requestVo.getStatus() != null) {
            params.set("status", requestVo.getStatus());
        } else {
            params.set("status", Const.Status.NORMAL);
        }
        if (requestVo.getRoleId() != null) {
            params.set("rid", requestVo.getRoleId());
        }
        if (StrUtil.isNotBlank(requestVo.getSearchKey())) {
            params.set("searchkey", "%" + requestVo.getSearchKey() + "%");
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_MG).getSqlPara("mguser.mguserlist", params);
        Page<Record> userPage = Db.use(MgConst.Db.TIO_MG).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(userPage);
    }

    /**
     * 重置密码
     *
     * @param mguid
     * @return
     * @author xufei
     * 2020年6月2日 下午3:14:48
     */
    public Ret resetPwd(Integer mguid) {
        if (mguid == null) {
            return RetUtils.invalidParam();
        }
        MgUser user = MgUser.dao.findById(mguid);
        if (user == null) {
            return RetUtils.failMsg("用户不存在");
        }
        String resetPwd = CommonUtils.getMd5Pwd(MgConst.MG_USER_DEFAULT_PWD);
        MgUser update = new MgUser();
        update.setId(user.getId());
        update.setPwd(resetPwd);
        boolean ret = update.update();
        if (!ret) {
            return RetUtils.failOper();
        }
        return RetUtils.okOper();
    }

    /**
     * 保存
     *
     * @param user
     * @return
     * @author xufei
     * 2020年6月2日 下午3:22:13
     */
    public Ret add(MgUser user) {
        MgUser mgUser = user.findFirst("select * from mg_user where loginname = ?", user.getLoginname());
        if (mgUser != null) {
            return RetUtils.failMsg("登录名已存在");
        }
        AbsTxAtom add = new AbsTxAtom() {

            @Override
            public boolean noTxRun() {
                String secret = GoogleAuthenticator.generateSecretKey();
                user.setSecret(secret);
                boolean init = user.save();
                if (!init) {
                    return failRet("保存失败");
                }
                MgUserBase base = new MgUserBase();
                base.setUid(user.getId());
                base.setSex(user.getSex());
                base.setRealname(user.getRealname());
                base.setPhone(user.getPhone());
                base.setEmail(user.getEmail());
                boolean b = base.save();
                if (!b) {
                    return failRet("附属信息保存异常");
                }
                Integer roleId = user.getRid();
                MgRole role = MgRole.dao.findById(roleId);
                if (role == null) {

                }
                MgUserRole userRole = new MgUserRole();
                userRole.setUid(user.getId());
                userRole.setRid(user.getRid());
                userRole.replaceSave();
                return true;
            }
        };
        boolean commit = Db.use(MgConst.Db.TIO_MG).tx(add);
        if (!commit) {
            return add.getRetObj();
        }
        return RetUtils.okOper();
    }

    /**
     * 修改用户资料
     *
     * @param user
     * @return
     * @author xufei
     * 2020年6月2日 下午3:22:15
     */
    public Ret update(MgUser user) {
        MgUser mgUser = MgUser.dao.findById(user.getId());
        if (mgUser == null) {
            return RetUtils.failMsg("用户不存在");
        }
        AbsTxAtom atom = new AbsTxAtom() {

            @Override
            public boolean noTxRun() {
                // 这么做的目的是修改指定的资料，其他的不能修改
                MgUser updateMgUser = new MgUser();
                updateMgUser.setId(user.getId());
                updateMgUser.setNick(user.getNick());
                updateMgUser.setStatus(user.getStatus());
                updateMgUser.setSex(user.getSex());
                updateMgUser.setPhone(user.getPhone());
                updateMgUser.setEmail(user.getEmail());
                updateMgUser.setRealname(user.getRealname());
                updateMgUser.setRid(user.getRid());
                boolean update = updateMgUser.update();
                if (!update) {
                    return failRet("修改失败");
                }
                MgUserBase userBase = getBase(updateMgUser.getId());
                MgUserBase baseUpdate = new MgUserBase();
                baseUpdate.setId(userBase.getId());
                if (updateMgUser.getSex() != null) {
                    baseUpdate.setSex(updateMgUser.getSex());
                }
                if (StrUtil.isNotEmpty(updateMgUser.getPhone())) {
                    baseUpdate.setPhone(updateMgUser.getPhone());
                }
                if (StrUtil.isNotEmpty(updateMgUser.getEmail())) {
                    baseUpdate.setPhone(updateMgUser.getEmail());
                }
                if (StrUtil.isNotEmpty(updateMgUser.getRealname())) {
                    baseUpdate.setRealname(updateMgUser.getRealname());
                }
                boolean b = baseUpdate.update();
                if (!b) {
                    return failRet("附属信息修改失败");
                }
                if (updateMgUser.getRid() != null) {
                    delUserRole(updateMgUser.getId());
                    MgRole role = MgRole.dao.findById(updateMgUser.getRid());
                    if (role == null) {
                        return failRet("用户角色不存在");
                    }
                    MgUserRole userRole = new MgUserRole();
                    userRole.setUid(updateMgUser.getId());
                    userRole.setRid(updateMgUser.getRid());
                    userRole.replaceSave();
                }
                return true;
            }
        };
        boolean commit = Db.use(MgConst.Db.TIO_MG).tx(atom);
        if (!commit) {
            return atom.getRetObj();
        }
        Caches.getCache(CacheConfig.MG_USER_MENU_AUTH).remove(mgUser.getId() + "");
        return RetUtils.okOper();
    }


    /**
     * 通过登录名获取后台用户
     *
     * @param loginName
     * @return
     */
    public MgUser getUserByLoginName(String loginName) {
        return MgUser.dao.findFirst("select * from mg_user where loginname = ?", loginName);
    }

    /**
     * 删除用户的角色
     *
     * @param uid
     * @author xufei
     * 2020年6月2日 下午3:54:18
     */
    public void delUserRole(Integer uid) {
        int delete = Db.use(MgConst.Db.TIO_MG).delete("delete from mg_user_role where uid = ?", uid);
    }

    /**
     * 获取用户的基础数据
     *
     * @param uid
     * @return
     * @author xufei
     * 2020年6月18日 下午3:24:58
     */
    public MgUserBase getBase(Integer uid) {
        return MgUserBase.dao.findFirst("select * from mg_user_base where uid = ?", uid);
    }

    /**
     * 删除用户-模拟删除（实际数据并未删除，只是将状态设为删除状态）
     *
     * @param mguid
     * @return
     * @author xufei
     * 2020年6月2日 下午3:22:42
     */
    public Ret del(Integer mguid) {
        MgUser user = MgUser.dao.findById(mguid);
        if (user == null) {
            return RetUtils.failMsg("用户不存在");
        }
        if (Objects.equals(user.getStatus(), Const.Status.DELETE)) {
            return RetUtils.failMsg("用户已删除");
        }
        MgUser update = new MgUser();
        update.setId(mguid);
        update.setStatus(Const.Status.DELETE);
        boolean del = update.update();
        if (!del) {
            return RetUtils.failOper();
        }
        Caches.getCache(CacheConfig.MG_USER_MENU_AUTH).remove(mguid + "");
        return RetUtils.okOper();
    }

}
