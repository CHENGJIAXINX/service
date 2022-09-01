package org.tio.mg.service.service.mg;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.cache.CacheConfig;
import org.tio.mg.service.cache.Caches;
import org.tio.mg.service.model.mg.MgMenu;
import org.tio.mg.service.model.mg.MgRole;
import org.tio.mg.service.model.mg.MgRoleMenu;
import org.tio.mg.service.model.mg.MgUserRole;
import org.tio.mg.service.service.atom.AbsTxAtom;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.sitexxx.servicecommon.vo.Const;

import java.util.ArrayList;
import java.util.List;

/**
 * 后台用户接口
 *
 * @author xufei
 * 2020年5月25日 下午4:46:25
 */
public class MgRoleService {

    private static Logger log = LoggerFactory.getLogger(MgRoleService.class);

    public static final MgRoleService ME = new MgRoleService();

    /**
     * 查询的角色列表
     * @param status
     * @return
     */
    public Ret list(Byte status) {
        Kv params = Kv.create();
        if (status != null) {
            params.set("status", status);
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_MG).getSqlPara("sys.rolelist", params);
        List<Record> list = Db.use(MgConst.Db.TIO_MG).find(sqlPara);
        return RetUtils.okList(list);
    }

    /**
     * 根据用户id获取菜单路由
     *
     * @param uid
     * @return
     */
    public Ret getRoutes(Integer uid) {
        List<MgMenu> result = new ArrayList<>();
        // 通过用户id查询角色
        MgUserRole mgUserRole = MgUserRole.dao.findFirst("select rid from mg_user_role where uid = ?", uid);
        if (mgUserRole == null) {
            return RetUtils.failMsg("获取用户角色失败");
        }
        // 通过用户角色查询角色菜单
        List<MgRoleMenu> mgRoleMenuList = MgRoleMenu.dao.find("select menu_id from mg_role_menu where role_id = ?", mgUserRole.getRid());
        List<Integer> menuIds = new ArrayList<>();
        if (mgRoleMenuList.size() > 0) {
            for (int i = 0; i < mgRoleMenuList.size(); i++) {
                MgMenu mgMenu = MgMenu.dao.findFirst("select * from mg_menu where id = ?", mgRoleMenuList.get(i).getMenuId());
                if (mgMenu == null) {
                    continue;
                }
                result.add(mgMenu);
                // 添加菜单Id(重复也没有关系)
                menuIds.add(mgMenu.getId());
                if (mgMenu.getParentId() != -1 && !isExist(menuIds, mgMenu.getParentId())) {
                    MgMenu parentMgMenu = MgMenu.dao.findFirst("select * from mg_menu where id = ?", mgMenu.getParentId());
                    // 添加父级菜单Id（防止只选了父级下面的子菜单 而没有选择父级）
                    if (parentMgMenu == null) {
                        continue;
                    }
                    result.add(parentMgMenu);
                    menuIds.add(parentMgMenu.getId());
                }
            }
        }
        return RetUtils.okList(result);
    }

    /**
     * 判断是否存在
     *
     * @param list
     * @param value
     * @return
     */
    private boolean isExist(List<Integer> list, Integer value) {
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).intValue() == value.intValue()) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 获取用户的角色信息
     *
     * @param uid
     * @return
     */
    public MgUserRole getRoleByUid(Integer uid) {
        return MgUserRole.dao.findFirst("select * from mg_user_role where uid = ?", uid);
    }

    /**
     * 校验用户角色是否存在
     *
     * @param roleId
     * @return
     */
    public MgRole getRoleByRoleId(Integer roleId) {
        return MgRole.dao.findFirst("select * from mg_role where id = ?", roleId);
    }

    /**
     * 新增角色
     *
     * @param role
     * @return
     * @author xufei
     * 2020年5月29日 上午10:18:31
     */
    public Ret add(MgRole role) {
        if (role == null || StrUtil.isBlank(role.getName())) {
            log.error("新增角色，参数为空");
            return RetUtils.invalidParam();
        }
        boolean save = role.save();
        if (!save) {
            return RetUtils.failMsg("新增失败");
        }
        return RetUtils.okOper();
    }

    /**
     * 角色修改
     *
     * @param role
     * @return
     * @author xufei
     * 2020年5月29日 上午10:18:33
     */
    public Ret update(MgRole role) {
        if (role == null || role.getId() == null || StrUtil.isBlank(role.getName())) {
            return RetUtils.invalidParam();
        }
        boolean update = role.update();
        if (!update) {
            return RetUtils.failMsg("修改失败");
        }
        return RetUtils.okOper();
    }

    /**
     * 角色删除-深度删除
     *
     * @param rid
     * @return
     * @author xufei
     * 2020年6月2日 下午4:37:27
     */
    public Ret del(Integer rid) {
        MgRole role = MgRole.dao.findById(rid);
        if (role == null) {
            return RetUtils.failMsg("角色不存在");
        }
        AbsTxAtom atom = new AbsTxAtom() {

            @Override
            public boolean noTxRun() {
                //删除关联用户
                delRoleUser(rid);
                //删除关联权限
                delRoleAuth(rid);
                //删除角色
                boolean del = MgRole.dao.deleteById(rid);
                if (!del) {
                    return false;
                }
                return true;
            }
        };
        boolean commit = Db.use(MgConst.Db.TIO_MG).tx(atom);
        if (!commit) {
            return RetUtils.failOper();
        }
        Caches.getCache(CacheConfig.MG_USER_MENU_AUTH).clear();
        return RetUtils.okOper();
    }


    /**
     * 删除角色的权限列表
     *
     * @param rid
     * @author xufei
     * 2020年6月8日 下午4:15:35
     */
    public void delRoleAuth(Integer rid) {
        Db.use(MgConst.Db.TIO_MG).delete("delete from mg_role_auth where rid = ?", rid);
    }

    /**
     * 删除角色的用户
     *
     * @param rid
     * @author xufei
     * 2020年6月8日 下午4:15:36
     */
    public void delRoleUser(Integer rid) {
        Db.use(MgConst.Db.TIO_MG).delete("delete from mg_user_role where rid = ?", rid);
    }

}
