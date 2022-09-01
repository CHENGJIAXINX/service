/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.atom;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.cache.CacheConfig;
import org.tio.sitexxx.service.cache.Caches;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.UserThird;
import org.tio.sitexxx.service.service.base.RegisterService;
import org.tio.sitexxx.service.service.base.TioInviteService;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.base.UserThirdService;
import org.tio.sitexxx.service.service.chat.FriendService;
import org.tio.sitexxx.service.service.stat.StatService;
import org.tio.sitexxx.service.utils.RetUtils;

import java.sql.SQLException;

public class RegisterAtom extends AbsAtom {

    private static Logger log = LoggerFactory.getLogger(RegisterAtom.class);

    private boolean isThird = false;

    private User user;

    private boolean isOpenInviteCode; // 是否打开邀请码开关

    public static void main(String[] args) {
    }

    public RegisterAtom(User user, boolean isOpenInviteCode) {
        this.user = user;
        this.isOpenInviteCode = isOpenInviteCode;
    }

    @Override
    public boolean run() throws SQLException {
        user.setInvFlag(false);
        if (RegisterService.me.isLoginnameExists(user.getLoginname())) {
            msg = "该账号已注册，如忘记密码，请找回";
            log.error(msg + ",loginname:{},nick:{},pwd:{}", user.getLoginname(), user.getNick(), user.getPwd());
            return false;
        }
        if (UserService.ME.save(user) == null) {
            msg = "账号注册失败：账号信息有误";
            log.error(msg + ",loginname:{},nick:{},pwd:{}", user.getLoginname(), user.getNick(), user.getPwd());
            return false;
        }
        user.update();
        if (user.getUserThird() != null) {
            UserThird userThird = user.getUserThird();
            userThird.setUid(user.getId());
            boolean thirdFlag = UserThirdService.me.save(userThird); //userThird.save();

            if (!thirdFlag) {
                msg = "账号注册失败：三方登录关联信息保存异常";
                log.error(msg + ",openid:{},type:{}", userThird.getOpenid(), userThird.getType());
                return false;
            }
        }
        System.out.println("user7==============>"+ JSON.toJSON(user));
        boolean baseResult = RegisterService.me.initBaseInfo(user);
        if (!baseResult) {
            msg = "账号注册失败：基础数据初始化失败";
            log.error(msg + ",loginname:{},nick:{},pwd:{}", user.getLoginname(), user.getNick(), user.getPwd());
            return false;
        }
        System.out.println("user58==============>"+ JSON.toJSON(user));
        boolean coinResult = RegisterService.me.initCoinInfo(user);
        if (!coinResult) {
            msg = "账号注册失败：财务初始化失败";
            log.error(msg + ",loginname:{},nick:{},pwd:{}", user.getLoginname(), user.getNick(), user.getPwd());
            return false;
        }
        System.out.println("user9==============>"+ JSON.toJSON(user));
        boolean roleResult = RegisterService.me.initRole(user);
        if (!roleResult) {
            msg = "账号注册失败：角色数据初始化失败";
            log.error(msg + ",loginname:{},nick:{},pwd:{}", user.getLoginname(), user.getNick(), user.getPwd());
            return false;
        }
        // 是否打开了推荐码
        if (isOpenInviteCode && !StrUtil.isEmpty(user.getInviteCode())) {
            // 验证推荐码是否正确
            User byId = User.dao.findFirst("select * from user where invitecode = ?", user.getInviteCode());
            if (byId == null) {
                msg = "推荐码不正确";
                return false;
            }
            user.setInviteUid(byId.getId());
            // 插入关联的记录
            Ret ret = TioInviteService.me.add(user.getInviteUid(), user.getInviteCode(), user.getId());
            if (ret.isFail()) {
                msg = RetUtils.getRetMsg(ret);
                return false;
            }
            // 添加推荐人为好友
//            try {
//                Ret retf = FriendService.me.addFriend(user, user.getInviteUid());
//                if (retf.isFail()) {
//                    msg = RetUtils.getRetMsg(retf);
//                    return false;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                msg = "添加好友失败";
//                return false;
//            }
        }
        RegisterService.me.initWx(user);
        //清空当前用户数
        Caches.getCache(CacheConfig.USER_COUNT).clear();
        if (StrUtil.isBlank(msg)) {
            msg = "注册成功";
        }
        StatService.me.userRegisterStat(user);
        System.out.println("user10==============>"+ JSON.toJSON(user));
        System.out.println("user11==============>"+ JSON.toJSON(UserService.ME.getById(user.getId())));
        return true;
    }

    public boolean isThird() {
        return isThird;
    }

    public void setThird(boolean isThird) {
        this.isThird = isThird;
    }
}
