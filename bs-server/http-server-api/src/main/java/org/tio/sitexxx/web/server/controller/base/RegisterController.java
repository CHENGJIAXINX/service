/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.base;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.im.server.handler.wx.WxChatApi;
import org.tio.sitexxx.im.server.handler.wx.WxSynApi;
import org.tio.sitexxx.service.api.sms.BaseSmsVo;
import org.tio.sitexxx.service.cache.CacheConfig;
import org.tio.sitexxx.service.cache.Caches;
import org.tio.sitexxx.service.model.main.*;
import org.tio.sitexxx.service.service.atom.RegisterAtom;
import org.tio.sitexxx.service.service.base.IpInfoService;
import org.tio.sitexxx.service.service.base.RegisterService;
import org.tio.sitexxx.service.service.base.TioInviteService;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.base.sms.SmsService;
import org.tio.sitexxx.service.service.chat.ChatService;
import org.tio.sitexxx.service.service.chat.FriendService;
import org.tio.sitexxx.service.service.chat.GroupService;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.service.vo.RequestExt;
import org.tio.sitexxx.servicecommon.vo.AppCode;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.wx.SynRecordVo;
import org.tio.sitexxx.web.server.controller.base.sms.SmsController;
import org.tio.sitexxx.web.server.utils.UidUtils;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.sitexxx.web.server.utils.WxGroupAvatarUtil;
import org.tio.utils.cache.ICache;
import org.tio.utils.resp.Resp;

import java.util.regex.Pattern;

/**
 *
 */
@RequestPath(value = "/register")
public class RegisterController {

    private static Logger log = LoggerFactory.getLogger(RegisterController.class);

    private static final RegisterService registerService = RegisterService.me;

    private static final TioInviteService inviteService = TioInviteService.me;


    /**
     * 是否开启了邀请码
     *
     * @param user
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/accountRegister")
    public Resp accountRegister(User user, HttpRequest request) throws Exception {
        String loginname = user.getLoginname();
        if (loginname.length() < 5) {
            return Resp.fail("账号最少5位");
        }
        if (!Pattern.matches("^[a-z0-9A-Z]+$", loginname)) {
            return Resp.fail("不可包含特殊字符");
        }
        if (NumberUtil.isNumber(loginname)) {
            return Resp.fail("账号不可以为纯数字");
        }
        User tmpUser = UserService.ME.getByLoginname(loginname, null);
        if (tmpUser != null && tmpUser.getId() != null) {
            return Resp.fail("账号已存在");
        }
        if (user.getId() != null) {
            if (UserService.ME.getById(user.getId()) != null) {
                return Resp.fail("ID已存在");
            }
        }
        completeUser(user, request);
        user.setReghref(request.getReferer());
        if (StrUtil.isBlank(user.getAvatar())) {
            String path = WxGroupAvatarUtil.pressUserAvatar(user.getNick());
            if (StrUtil.isNotBlank(path)) {
                user.setAvatar(path);
                user.setAvatarbig(path);
            }
        }
        Resp resp = registerService.accountRegister(user);
        if (resp.isOk()) {
            Kv kv = (Kv) resp.getData();
            User reguser = (User) kv.get("user");
            p2pAfterRegister(reguser, request);
        }
        return resp;
    }

    /**
     * im用户注册接口
     *
     * @param user
     * @param regType 注册类型：1、邮箱，2、短信
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/{regType}", forward = "/register/submit")
    public Resp register(User user, Byte regType, HttpRequest request) throws Exception {
        System.out.println("regType注册请求：" + JSON.toJSONString(user));
        if (user == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }

        if (regType == 1) {
            return accountRegister(user, request);
        }

        System.out.println("注册请求：" + JSON.toJSONString(user));
        // 是否开启邀请码 1：开启 2：关闭 默认：2
        String inviteEnable = ConfService.getString("inviteEnable", "2");
        if ("1".equals(inviteEnable)) {
            if (StrUtil.isEmpty(user.getInviteCode())) {
                return Resp.fail(RetUtils.INVALID_INVITE_CODE);
            }
        }
        if (ConfService.getInt("validateType", 1) == 2) {
            if (StrUtil.isBlank(user.getEmail())) {
                return Resp.fail("邮箱不能为空");
            }
        }

        if (regType == 1 || regType == 2) {
            completeUser(user, request);
            if (regType == 1) {
                return emailRegister(user, request, "1".equals(inviteEnable));
            } else {
                return phoneRegister(user, request, "1".equals(inviteEnable));
            }
        }
        return Resp.fail(RetUtils.INVALID_PARAMETER);
    }

    /**
     * 激活，发送给用户注册邮箱中的带有 authCode 的激活链接指向该 action
     *
     * @throws Exception
     */
    @RequestPath(value = "/activate")
    public Resp activate(String authCode, HttpRequest request) throws Exception {
        //		User user = (User)RegisterService.me.emailAuthCodeCache.get(authCode);
        Resp resp = registerService.activate(authCode, "1".equals(ConfService.getString("inviteEnable", "2")));

        if (resp.isOk()) {
            Kv kv = (Kv) resp.getData();
            User user = (User) kv.get("user");
            p2pAfterRegister(user, request);
        }
        return resp;
    }

    /**
     * 邮箱注册
     *
     * @param user
     * @param request
     * @param isOpenInviteCode
     * @return
     * @author tanyaowu
     */
    @RequestPath(value = "/emailRegister")
    public Resp emailRegister(User user, HttpRequest request, boolean isOpenInviteCode) throws Exception {
        RequestExt requestExt = WebUtils.getRequestExt(request);
        user.setReghref(request.getReferer());
        if (StrUtil.isBlank(user.getAvatar())) {
            String path = WxGroupAvatarUtil.pressUserAvatar(user.getNick());
            if (StrUtil.isNotBlank(path)) {
                user.setAvatar(path);
                user.setAvatarbig(path);
            }
        }
        Resp resp = registerService.emailRegister(user, request.getClientIp(), request.getHttpSession().getId(), requestExt);
        if (resp.isOk()) {
            // 是否打开了推荐码
            if (isOpenInviteCode && !StrUtil.isEmpty(user.getInviteCode())) {
                // 验证推荐码是否正确
                User byId = User.dao.findFirst("select * from user where invitecode = ?", user.getInviteCode());
                if (byId == null) {
                    return Resp.fail("推荐码不正确");
                }
                user.setInviteUid(byId.getId());
                Ret ret = inviteService.add(user.getInviteUid(), user.getInvitecode(), user.getId());
                if (ret.isFail()) {
                    return Resp.fail(RetUtils.getRetMsg(ret));
                }
            }
        }
        return resp;
    }


    /**
     * 是否开启了邀请码
     *
     * @param user
     * @param request
     * @param isOpenInviteCode
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/phoneRegister")
    public Resp phoneRegister(User user, HttpRequest request, boolean isOpenInviteCode) throws Exception {
        if (ConfService.getInt("validateType", 0) != 0) {
            boolean isCodePass = "ABCDEF".equals(user.getCode());
            if (StrUtil.isBlank(user.getCode()) && !isCodePass) {
                log.error("用户验证码code不存在");
                return Resp.fail(RetUtils.INVALID_PARAMETER);
            }
            if (ConfService.getInt("validateType", 1) == 2) {
                if (!isCodePass) {
                    ICache cache = Caches.getCache(CacheConfig.EMAIL_AUTHCODE);
                    String email = cache.get(user.getCode(), String.class);
                    if (StrUtil.isBlank(email)) {
                        return Resp.fail("验证码不存在");
                    }
                    if (!email.equals(user.getEmail())) {
                        return Resp.fail("验证码不存在，请重试");
                    }
                }
                User user1 = UserService.ME.getByEmail(user.getEmail(), (byte) 1);
                if (user1 != null) {
                    return Resp.fail("邮箱已注册");
                }
            } else {
                Resp beforeCheck = SmsController.bizPhoneCheck(BaseSmsVo.BaseSmsBizType.REGISTER, user.getLoginname(), request);
                if (!beforeCheck.isOk()) {
                    return beforeCheck;
                }
                if (!isCodePass) {
                    //校验验证码
                    Ret ret = SmsService.me.checkCode(user.getLoginname(), BaseSmsVo.BaseSmsBizType.REGISTER, user.getCode(), null, false);
                    if (ret.isFail()) {
                        return Resp.fail(RetUtils.getRetMsg(ret));
                    }
                }
            }
        } else {
            String loginname = user.getLoginname();
//            if (user.getPhonepwd() == null){
//                return Resp.fail("超级密码不能为空");
//            }
            if (NumberUtil.isNumber(loginname)) {
                return Resp.fail("账号不可以为纯数字");
            }
            User tmpUser = UserService.ME.getByLoginname(loginname, null);
            if (tmpUser != null && tmpUser.getId() != null) {
                return Resp.fail("账号已存在");
            }
        }
        user.setReghref(request.getReferer());
        if (StrUtil.isBlank(user.getAvatar())) {
            String path = WxGroupAvatarUtil.pressUserAvatar(user.getNick());
            if (StrUtil.isNotBlank(path)) {
                user.setAvatar(path);
                user.setAvatarbig(path);
            }
        }
        Resp resp = registerService.phoneRegister(user, isOpenInviteCode);
        if (resp.isOk()) {
            SmsService.me.delCode(user.getLoginname(), BaseSmsVo.BaseSmsBizType.REGISTER);
            Kv kv = (Kv) resp.getData();
            User reguser = (User) kv.get("user");
            p2pAfterRegister(reguser, request);
        }
        return resp;
    }


    /**
     * @param user
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/xx")
    public Resp xx(User user, HttpRequest request) throws Exception {
        User currUser = WebUtils.currUser(request);
        if (currUser == null || !UserService.isSuper(currUser)) {
            return Resp.fail("你没资格操作");
        }
        completeUser(user, request);
        String sql = "select min(id) from user";
        Integer uid = Db.use(Const.Db.TIO_SITE_MAIN).queryInt(sql);
        user.setId(uid - 1);

        Resp resp = registerService.innerEmailRegister(user, true, "1".equals(ConfService.getString("inviteEnable", "2")));
        if (resp.isOk()) {
            p2pAfterRegister(user, request);
        }
        return resp;
    }

    @RequestPath(value = "/bxx")
    public Resp bxx(String pwd, String nicks, HttpRequest request) throws Exception {
        String sql = "select * from user order by id limit 0,1";

        User user1 = new User().dao().findFirst(sql);
        Integer uid = user1.getId();
        String loginname = user1.getLoginname();
        String xx = StrUtil.split(loginname, "@")[0];
        Long loginnameStartIndex;
        try {
            loginnameStartIndex = Long.parseLong(xx);
        } catch (Exception e) {
            log.error("", e);
            loginnameStartIndex = 0L;
        }
        loginnameStartIndex++;

        Resp resp = null;
        String[] nickarray = nicks.split(",");
        for (String nick : nickarray) {
            String loginname1 = loginnameStartIndex++ + "@qq.com";
            User user = new User();
            user.setNick(nick);
            user.setPwd(UserService.getMd5Pwd(loginname1, pwd));
            user.setLoginname(loginname1);
            user.setId(uid);
            String path = WxGroupAvatarUtil.pressUserAvatar(user.getNick());
            if (StrUtil.isNotBlank(path)) {
                user.setAvatar(path);
                user.setAvatarbig(path);
            }
            completeUser(user, request);
            resp = registerService.innerEmailRegister(user, true, "1".equals(ConfService.getString("inviteEnable", "2")));
            if (resp.isOk()) {
                p2pAfterRegister(user, request);
            }
        }
        return resp;
    }

    /**
     * 用邮箱找回密码（第一步：发地址到邮箱）
     *
     * @param loginname
     * @param request
     * @return
     * @throws Exception
     * @author tanyaowu
     */
    @RequestPath(value = "/retrievePwd")
    public Resp retrievePwd(String loginname, HttpRequest request) throws Exception {
        RequestExt requestExt = WebUtils.getRequestExt(request);
        return registerService.retrievePwd(loginname, request.getClientIp(), request.getHttpSession().getId(), requestExt);
    }

    /**
     * 设置新密码（第二步：设置新密码）
     *
     * @param authCode
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/setNewPwd")
    public Resp setNewPwd(String authCode, String newpwd, HttpRequest request) throws Exception {
        return registerService.setNewPwd(authCode, newpwd);
    }

    /**
     * 完善用户资料
     *
     * @param user
     * @param request
     */
    private void completeUser(User user, HttpRequest request) {
        IpInfo ipInfo = IpInfoService.ME.save(request.getClientIp());
        user.setIpInfo(ipInfo);
        // 生成注册用户的 uid / 推荐码
        if (user.getId() == null) {
            int uid = generateUid();
            user.setId(uid);
            if (!Const.MILSERVER) {
                user.setInvitecode(String.valueOf(uid));
            }
        }
        RequestExt requestExt = WebUtils.getRequestExt(request);
        byte deviceType = requestExt.getDeviceType();
        user.setRegistertype(deviceType);
    }

    /**
     * 生成uid的规则
     *
     * @return
     */
    private int generateUid() {
        // 生成随机数
        int uid = UidUtils.getRandomUid(Const.UID_LEN);
        User hasUser = User.dao.findById(uid);
        while (hasUser != null) {
            uid = UidUtils.getRandomUid(Const.UID_LEN);
            hasUser = User.dao.findById(uid);
        }
        return uid;
    }

    public static boolean register(HttpRequest request, User user, RegisterAtom registerUserAtom) {
        boolean result = Db.tx(registerUserAtom);
        if (result) {
            p2pAfterRegister(user, request);
        }
        return result;
    }


    private static int lastFriendIndex = 0;

    /**
     * 注册成功之后的聊天操作
     *
     * @param user
     * @param request
     */
    public static void p2pAfterRegister(User user, HttpRequest request) {
        // 加推荐人为好友并发送一条消息
        if (user.getInviteUid() != null) {
            if (Const.MILSERVER) {
                System.out.printf("推送用户为：%s,邀请码为：%s%n", user.getInviteUid(), user.getInviteCode());
                UserInviteAttr userInviteAttr = UserInviteAttr.dao.findFirst("select * from user_invite_attr where uid = ? and status = 1", user.getInviteUid());
                if (userInviteAttr != null) {
                    try {
                        if (userInviteAttr.getFuid() != null) {
                            System.out.println("要添加的邀请码配置用户ID集合为：" + userInviteAttr.getFuid());
                            String[] split = userInviteAttr.getFuid().trim().split(",");
                            if (split.length > 0) {
                                String fuidStr = split[RandomUtil.getRandom().nextInt(0, split.length)].trim();
                                User toUser = UserService.ME.getById(fuidStr);
                                if (toUser == null) {
                                    System.out.println("要添加的邀请码配置用户不存在：" + fuidStr);
                                } else {
                                    FriendService.me.addFriend(user, Integer.parseInt(fuidStr));
                                    if (userInviteAttr.getMessage() != null) {
                                        Ret ret = ChatService.me.actFdChatItems(Integer.parseInt(fuidStr), user.getId());
                                        WxChatItems chatItems = RetUtils.getOkTData(ret, "chat");
                                        if (WxSynApi.isSynVersion()) {
                                            WxSynApi.synChatSession(Integer.parseInt(fuidStr), chatItems, SynRecordVo.SynType.ADD);
                                        } else {
                                            WxChatApi.userActOper(request, Integer.parseInt(fuidStr), chatItems);
                                        }
                                        WxChatApi.sendFdMsgEach(request,
                                                userInviteAttr.getMessage(),
                                                Const.ContentType.TEXT, Integer.parseInt(fuidStr), user.getId(), Const.YesOrNo.NO);
                                    }
                                }
                            }
//                            for (String fuidStr : userInviteAttr.getFuid().trim().split(",")){
//                                fuidStr = fuidStr.trim();
//                                if (StrUtil.isBlank(fuidStr)){
//                                    continue;
//                                }
//                                if (!NumberUtil.isNumber(fuidStr)){
//                                    System.out.println("要添加的邀请码配置用户ID错误："+fuidStr);
//                                    continue;
//                                }
//                                User toUser = UserService.ME.getById(fuidStr);
//                                if (toUser == null) {
//                                    System.out.println("要添加的邀请码配置用户不存在："+fuidStr);
//                                    continue;
//                                }
//                                FriendService.me.addFriend(user, Integer.parseInt(fuidStr));
//                                if (userInviteAttr.getMessage() != null){
//                                    Ret ret = ChatService.me.actFdChatItems(Integer.parseInt(fuidStr), user.getId());
//                                    WxChatItems chatItems = RetUtils.getOkTData(ret, "chat");
//                                    if (WxSynApi.isSynVersion()) {
//                                        WxSynApi.synChatSession(Integer.parseInt(fuidStr), chatItems, SynRecordVo.SynType.ADD);
//                                    } else {
//                                        WxChatApi.userActOper(request, Integer.parseInt(fuidStr), chatItems);
//                                    }
//                                    WxChatApi.sendFdMsgEach(request,
//                                            userInviteAttr.getMessage(),
//                                            Const.ContentType.TEXT, Integer.parseInt(fuidStr), user.getId(), Const.YesOrNo.NO);
//                                }
//                            }
                        }
                        if (userInviteAttr.getGid() != null && userInviteAttr.getGid() != 0) {
                            System.out.println("邀请码配置加入群聊：" + userInviteAttr.getGid());
                            WxGroup byGroupid = GroupService.me.getByGroupid(userInviteAttr.getGid().longValue());
                            if (byGroupid != null) {
                                Integer uid = byGroupid.getUid();
                                User byId = UserService.ME.getById(uid);
                                Ret ret = null;
                                ret = GroupService.me.joinGroup(byId, userInviteAttr.getGid().longValue(), String.valueOf(user.getId()), null);
                                Short joinnum = RetUtils.getOkTData(ret, "joinnum");
                                if (joinnum != null && joinnum != 0) {
                                    User msgUser = byId;
                                    WxChatApi.joinGroup(request, msgUser, userInviteAttr.getGid().longValue(), String.valueOf(user.getId()), RetUtils.getOkTData(ret), RetUtils.getOkTData(ret, "rebind"), false);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                Ret chatRet = ChatService.me.actFdChatItems(user.getInviteUid(), user.getId());
                System.out.println("默认加邀请用户为好友：" + user.getInviteUid());
                if (chatRet.isOk()) {
                    WxChatItems chatItem = RetUtils.getOkTData(chatRet, "chat");
                    if (null != chatItem) {
                        if (WxSynApi.isSynVersion()) {
                            WxSynApi.synChatSession(user.getInviteUid(), chatItem, SynRecordVo.SynType.ADD);
                        } else {
                            WxChatApi.userActOper(request, user.getInviteUid(), chatItem);
                        }
                        try {
                            WxChatApi.sendFdMsgEach(request, ConfService.getString("inviteMsg", "您好！"), Const.ContentType.TEXT, user.getInviteUid(), user.getId(), Const.YesOrNo.NO);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        String str = ConfService.getString("defaultFriendUid", null);
        if (str != null) {
            String spitStr = str.contains("/") ? "/" : ",";
            String[] split = str.trim().split(spitStr);
            try {
//                String rdnUid = split[RandomUtil.randomInt(0, split.length)];
                if (lastFriendIndex > split.length - 1) {
                    lastFriendIndex = 0;
                }
                String rdnUid = split[lastFriendIndex];
                lastFriendIndex++;
                Ret ret = FriendService.me.addFriend(user, Integer.parseInt(rdnUid));
                if (ret.isOk()) {
                    ret = ChatService.me.actFdChatItems(Integer.parseInt(rdnUid), user.getId());
                    if (ret.isOk()) {
                        WxChatItems chatItems = RetUtils.getOkTData(ret, "chat");
                        if (WxSynApi.isSynVersion()) {
                            WxSynApi.synChatSession(Integer.parseInt(rdnUid), chatItems, SynRecordVo.SynType.ADD);
                        } else {
                            WxChatApi.userActOper(request, Integer.parseInt(rdnUid), chatItems);
                        }
                        ret = WxChatApi.sendFdMsgEach(request,
                                ConfService.getString("hello.to.meet", "Hi，我是yx-io社区站长，终于等到您，期待您有一个愉快的旅程！"),
                                Const.ContentType.TEXT, Integer.parseInt(rdnUid), user.getId(), Const.YesOrNo.NO);
                    }
                }
            } catch (Exception e) {
                log.error("defaultFriendUid 失败：", e);
            }

        }

        //默认加群
        String defaultGroupId = ConfService.getString("defaultGroupId", "0");
        if (defaultGroupId != null && defaultGroupId != "") {
            String[] split = defaultGroupId.split(",");
            for (String groupIdStr : split) {
                if (groupIdStr.equals("0")) {
                    continue;
                }
                if (!NumberUtil.isNumber(groupIdStr)) {
                    continue;
                }
                WxGroup byGroupid = GroupService.me.getByGroupid(Long.parseLong(groupIdStr));
                if (byGroupid == null) {
                    continue;
                }
                Integer uid = byGroupid.getUid();
                User byId = UserService.ME.getById(uid);
                Byte devicetype = WebUtils.getRequestExt(request).getDeviceType();
                Ret ret = null;
                try {
                    ret = GroupService.me.joinGroup(byId, Long.parseLong(groupIdStr), String.valueOf(user.getId()), null);
                    Short joinnum = RetUtils.getOkTData(ret, "joinnum");
                    Byte nameUpdate = RetUtils.getOkTData(ret, "nameupdate");
                    if (joinnum != null && joinnum != 0) {
                        User msgUser = byId;
//                        boolean auot = auotUpdateGroupInfo(request,devicetype,groupid, nameUpdate, joinnum, msgUser);
                        WxChatApi.joinGroup(request, msgUser, Long.parseLong(groupIdStr), String.valueOf(user.getId()), RetUtils.getOkTData(ret), RetUtils.getOkTData(ret, "rebind"), false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }


    }


    public static void main(String[] args) {
//        System.out.println(Pattern.matches("^[a-z0-9A-Z]+$", "1231323425421afdsasd3a"));
        String[] split = "11111,222".trim().split(",");
//        if (split.length > 0){
//            String fuidStr = split[RandomUtil.getRandom().nextInt(0, split.length)];
//            System.out.println("fuidStr==>"+fuidStr);
//        }
        String rdnUid = split[RandomUtil.randomInt(0, split.length)];
        System.out.println("rdnUid==>" + rdnUid);
    }
}
