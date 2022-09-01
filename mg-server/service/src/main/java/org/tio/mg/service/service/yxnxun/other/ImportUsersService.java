package org.tio.mg.service.service.yxnxun.other;

import cn.hutool.core.lang.Validator;
import cn.hutool.crypto.SecureUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.kit.StrKit;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.mg.service.model.main.*;
import org.tio.mg.service.service.atom.AbsAtom;
import org.tio.mg.service.service.base.UserService;
import org.tio.mg.service.service.conf.AvatarService;
import org.tio.mg.service.service.stat.StatService;
import org.tio.mg.service.service.yxnxun.wallet.utils.DateUtil;
import org.tio.mg.service.utils.CommonUtils;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.utils.UidUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.resp.Resp;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ImportUsersService {
    private static Logger log = LoggerFactory.getLogger(ImportUsersService.class);

    public static final ImportUsersService ME = new ImportUsersService();


    public Ret addUsers(List<String> fileContent, String clientIp) throws Exception {
        AbsAtom atom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                int line = 0;
                String msg = "";
                boolean flag = true;
                for (String item : fileContent) {
                    line += 1;
                    String loginname = null;
                    String nick = null;
                    String pwd = null;
                    try {
                        loginname = item.substring(0, item.indexOf(":"));
                        nick = item.substring(item.lastIndexOf(":") + 1);
                        pwd = item.substring(item.indexOf(":") + 1, item.lastIndexOf(":"));
                    } catch (StringIndexOutOfBoundsException e) {
                        log.error("文本解析失败：格式错误");
                        this.msg = "第" + line + "行错误，文本解析失败：格式错误";
                        return false;
                    }

                    if (StrUtil.isBlank(loginname.trim()) || StrUtil.isBlank(nick.trim()) || StrUtil.isBlank(pwd.trim())) {
                        msg = "第" + line + "行格式错误";
                        flag = false;
                        break;
                    }
                    User user = new User();
                    user.setLoginname(loginname);
                    user.setPwd(CommonUtils.getMd5Pwd(pwd));
                    user.setNick(nick);
                    user.setAgreement("on");
                    Resp resp = null;
                    try {
                        IpInfo ipInfo = new IpInfo();
                        ipInfo.setIp(clientIp);
                        ipInfo.setTime(DateUtil.format(DateUtil.getCurrDate()));
                        user.setIpInfo(ipInfo);
                        resp = phoneRegister(user);
                    } catch (Exception e) {
                        this.msg = "第" + line + "行错误，原因程序异常捕获";
                        e.printStackTrace();
                        return false;
                    }
                    if (!resp.isOk()) {
                        this.msg = "第" + line + "行错误，原因：" + resp.getMsg();
                        return false;
                    }
                }
                if (!flag) {
                    this.msg = msg;
                }
                return flag;
            }
        };

        boolean tx = Db.use(MgConst.Db.TIO_SITE_MAIN).tx(atom);
        if (!tx) {
            return RetUtils.failMsg(atom.getMsg());
        }
        return RetUtils.okMsg("添加成功");
    }

    public Ret addUser(RequestVo requestVo) {
        AbsAtom atom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                User user = new User();
                if (null == requestVo.getUid()) {
                    // 生成注册用户的 uid / 推荐码
                    int randomUid = generateUid();
                    user.setId(randomUid);
                    user.setInvitecode(String.valueOf(randomUid));
                } else {
                    user.setId(requestVo.getUid());
                    user.setInvitecode(String.valueOf(requestVo.getUid()));
                }
                user.setLoginname(requestVo.getLoginName());
                user.setPwd(requestVo.getPd5());
                user.setNick(requestVo.getNick());
                user.setAgreement("on");
                if (StrUtil.isNotBlank(requestVo.getAvatar())) {
                    user.setAvatar(requestVo.getAvatar());
                    user.setAvatarbig(requestVo.getAvatar());
                }
                IpInfo ipInfo = new IpInfo();
                ipInfo.setIp(requestVo.getIp());
                ipInfo.setTime(DateUtil.format(DateUtil.getCurrDate()));
                if (!ipInfo.save()) {
                    return failRet("ip保存失敗");
                }
                user.setIpInfo(ipInfo);
                try {
                    Resp resp = phoneRegister(user);
                    if (!resp.isOk()) {
                        return failRet(resp.getMsg());
                    }
                } catch (Exception e) {
                    return failRet("注册错误:" + e.getMessage());
                }
                return true;
            }
        };
        boolean tx = Db.use(MgConst.Db.TIO_SITE_MAIN).tx(atom);
        if (!tx) {
            return RetUtils.failMsg(atom.getMsg());
        }
        return RetUtils.okMsg("添加成功");
    }

    /**
     * 生成uid的规则
     *
     * @return
     */
    private int generateUid() {
        // 生成随机数
        int uid = UidUtils.getRandomUid(8);
        User hasUser = User.dao.findById(uid);
        while (hasUser != null) {
            uid = UidUtils.getRandomUid(8);
            hasUser = User.dao.findById(uid);
        }
        return uid;
    }

    private Resp phoneRegister(User user) throws Exception {
        Resp resp = regCheckAndSet(user, Const.RegisterType.PHONE);
        if (resp.isOk()) {
            user.setInvFlag(false);
            if (UserService.ME.save(user) == null) {
                return Resp.fail("账号注册失败：账号信息有误");
            }
            user.update();
            boolean baseResult = initBaseInfo(user);
            if (!baseResult) {
                return Resp.fail("账号注册失败：基础数据初始化失败");
            }
            boolean coinResult = initCoinInfo(user);
            if (!coinResult) {
                return Resp.fail("账号注册失败：财务初始化失败");
            }
            boolean roleResult = initRole(user);
            if (!roleResult) {
                return Resp.fail("账号注册失败：角色数据初始化失败");
            }
            UserService.ME.notifyClearCache(user.getId());
            StatService.me.userRegisterStat(user);
            return Resp.ok("注册成功");
        } else {
            return resp;
        }
    }

    /**
     * 初始化基础信息
     *
     * @param user
     * @return
     */
    private boolean initBaseInfo(User user) {
        UserBase baseInfo = new UserBase();
        baseInfo.setUid(user.getId());
        if (user.getUserThird() != null) {
            baseInfo.setPhone("");
        } else {
            baseInfo.setEmail(user.getLoginname());
        }
        return baseInfo.save();
    }

    /**
     * 初始化财务信息
     *
     * @param user
     * @return
     */
    private boolean initCoinInfo(User user) {
        UserCoin coinInfo = new UserCoin();
        coinInfo.setUid(user.getId());
        return coinInfo.save();
    }

    /**
     * 初始化角色信息
     *
     * @param user
     * @return
     */
    private boolean initRole(User user) {
        UserRole userRoleRel = new UserRole();
        userRoleRel.setUid(user.getId());
        userRoleRel.setRid(Role.NORMAL);
        userRoleRel.setStatus(Const.Status.NORMAL);
        boolean roleResult = userRoleRel.save();
        return roleResult;
    }

    private Resp regCheckAndSet(User user, int regType) throws Exception {
        String loginname = StrUtil.trim(user.getLoginname());
        String pwd = StrUtil.trim(user.getPwd());
        String nick = StrUtil.trim(user.getNick());
        if (StrUtil.isBlank(user.getAgreement())) {
            return Resp.fail("您必须 [同意用户服务条款] 才能注册");
        }
        if (StrUtil.isBlank(pwd)) {
            return Resp.fail("密码不能为空");
        }
        Resp resp = CommonUtils.checkGroupName(nick, "昵称");
        if (!resp.isOk()) {
            return resp;
        }
        if (Objects.equals(regType, Const.RegisterType.EMAIL)) {
            if (loginname.length() > 48) {
                return Resp.fail("邮箱过长");
            }
            if (!Validator.isEmail(loginname)) {
                return Resp.fail("不是合法的邮箱");
            }
            user.setEmail(loginname);
            user.setEmailpwd(pwd);
            user.setEmailbindflag(Const.YesOrNo.YES);
        } else {
            user.setPhone(loginname);
            user.setPhonepwd(pwd);
            user.setPhonebindflag(Const.YesOrNo.YES);
        }
        if (StrKit.isBlank(nick)) {
            return Resp.fail("昵称不能为空");
        }
//        if (isNickExists(nick)) {
//            return Resp.fail("昵称已被注册，请换一个昵称");
//        }
        if (isLoginnameExists(loginname)) {
            return Resp.fail("该账号已注册，如忘记密码，请找回");
        }
        user.setLoginname(loginname);
        user.setNick(nick);
        user.setStatus(org.tio.mg.service.model.main.User.Status.NORMAL);
        user.setCreatetime(new Date());
        user.setThirdstatus(Const.UserThirdStatus.NORMAL);
        if (StrUtil.isBlank(user.getAvatar())) {
            String avatar = AvatarService.nextAvatar();
            user.setAvatar(avatar);
            user.setAvatarbig(avatar);
        }
        return Resp.ok();
    }

    private boolean isNickExists(String nick) {
        nick = nick.toLowerCase().trim();
        return Db.use(Const.Db.TIO_SITE_MAIN).queryInt("select id from user where nick = ? limit 1", nick) != null;
    }

    private boolean isLoginnameExists(String loginname) {
        loginname = loginname.trim();
        User user = UserService.ME.getByLoginname(loginname, null);
        return user != null;
    }
}
