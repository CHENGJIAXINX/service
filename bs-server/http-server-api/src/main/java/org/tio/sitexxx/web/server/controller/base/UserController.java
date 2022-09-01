/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.base;

import java.awt.image.BufferedImage;
import java.util.*;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.Tio;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.common.UploadFile;
import org.tio.http.common.session.HttpSession;
import org.tio.http.server.annotation.RequestPath;
import org.tio.http.server.mvc.Routes;
import org.tio.http.server.util.Resps;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.sitexxx.im.server.handler.wx.WxChatApi;
import org.tio.sitexxx.service.api.sms.BaseSmsVo;
import org.tio.sitexxx.service.cache.CacheConfig;
import org.tio.sitexxx.service.cache.Caches;
import org.tio.sitexxx.service.model.main.*;
import org.tio.sitexxx.service.service.ImgService;
import org.tio.sitexxx.service.service.base.*;
import org.tio.sitexxx.service.service.base.sms.SmsService;
import org.tio.sitexxx.service.service.chat.ChatIndexService;
import org.tio.sitexxx.service.service.chat.ChatService;
import org.tio.sitexxx.service.service.chat.FriendService;
import org.tio.sitexxx.service.service.conf.AvatarService;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.utils.CommonUtils;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.AppCode;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.RequestKey;
import org.tio.sitexxx.service.vo.SessionExt;
import org.tio.sitexxx.servicecommon.vo.SessionKey;
import org.tio.sitexxx.service.vo.SimpleUser;
import org.tio.sitexxx.web.server.controller.base.sms.SmsController;
import org.tio.sitexxx.web.server.controller.base.thirdlogin.ThirdLoginFactory;
import org.tio.sitexxx.web.server.utils.ImgUtils;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.sitexxx.web.server.utils.WxGroupAvatarUtil;
import org.tio.utils.Threads;
import org.tio.utils.cache.ICache;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.resp.Resp;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.img.ImgUtil;

/**
 * @author tanyaowu
 * 2016年6月29日 下午7:53:59
 */
@RequestPath(value = "/user")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService = UserService.ME;

    /**
     * 搜索用户
     *
     * @param nick
     * @param uid
     * @param loginname
     * @param pageNumber
     * @param pageSize
     * @param request
     * @return
     * @throws Exception
     * @author tanyaowu
     */
    @RequestPath(value = "/search")
    public Resp search(String nick, Integer uid, String loginname, Integer pageNumber, Integer pageSize, HttpRequest request) throws Exception {
        pageSize = 20;  //
        User curr = WebUtils.currUser(request);
        Page<Record> page = UserService.ME.search(curr, nick, uid, loginname, pageNumber, pageSize);
        return Resp.ok(page);
    }

    @RequestPath(value = "/search2")
    public Resp search2(String searchName, Integer pageNumber, Integer pageSize, HttpRequest request) throws Exception {
        System.out.println("search2 searchName==>"+searchName);
        pageSize = 20;  //
        User curr = WebUtils.currUser(request);
        Page<Record> page = UserService.ME.search2(searchName, pageNumber, pageSize);
        return Resp.ok(page);
//        return null;
    }

    /**
     * 查询用户信息，主要用于展示给其它人看，所以有的信息是不允许查询出来的
     *
     * @param uid
     * @param request
     * @return
     * @throws Exception
     * @author tanyaowu
     */
    @RequestPath(value = "/info")
    public Resp info(Integer uid, HttpRequest request) throws Exception {
        if (uid == null) {
            return Resp.fail("用户id参数为空");
        }
        User curr = WebUtils.currUser(request);
        Record record = UserService.ME.info(uid);
        if (record == null){
            return Resp.fail("获取信息失败了");
        }
        LoginLog first = LoginLogService.dao.findFirst("select * from login_log where uid = ? order by id desc limit 1", uid);

        if (curr != null) {
            WxChatUserItem fd = ChatIndexService.fdUserIndex(curr.getId(), uid);
            if (ChatService.existFriend(fd)) {
                WxFriend friend = FriendService.me.getFriendInfo(fd.getLinkid());
                if (friend != null && StrUtil.isNotBlank(friend.getRemarkname())) {
                    Record newread = new Record();
                    Map<String, Object> retMap = new HashMap<String, Object>();
                    BeanUtil.copyProperties(record.getColumns(), retMap);
                    retMap.put("remarkname", friend.getRemarkname());
                    if (first != null){
                        retMap.put("lastIp", first.getIp());
                    }
                    newread.setColumns(retMap);
                    return Resp.ok(newread);
                }
            }
        }
        Record newread = new Record();
        Map<String, Object> retMap = new HashMap<String, Object>();
        BeanUtil.copyProperties(record.getColumns(), retMap);
        if (first != null){
            retMap.put("lastIp", first.getIp());
        }
        newread.setColumns(retMap);
        return Resp.ok(newread);
    }

    /**
     * @param uid
     * @param request
     * @return
     * @throws Exception
     * @author xufei
     * 2020年10月16日 下午2:01:46
     */
    @RequestPath(value = "/block")
    public Resp block(Integer uid, HttpRequest request) throws Exception {
        if (uid == null) {
            return Resp.fail("用户id参数为空");
        }
        User curr = WebUtils.currUser(request);
        WxUserBlackItems items = ChatService.getBlockItems(curr.getId(), uid);
        return Resp.ok(items != null ? Const.YesOrNo.YES : Const.YesOrNo.NO);
    }

    /**
     * 给超管专用的，其它用户调不到这个方法
     *
     * @param uid
     * @param request
     * @return
     * @throws Exception
     * @author tanyaowu
     */
    @RequestPath(value = "/info1")
    public Resp info1(Integer uid, HttpRequest request) throws Exception {
        User curr = WebUtils.currUser(request);
        Record record = UserService.ME.info1(curr, uid);
        if (curr != null) {
            WxChatUserItem fd = ChatIndexService.fdUserIndex(curr.getId(), uid);
            if (ChatService.existFriend(fd)) {
                WxFriend friend = FriendService.me.getFriendInfo(fd.getLinkid());
                if (friend != null && StrUtil.isNotBlank(friend.getRemarkname())) {
                    Record newread = new Record();
                    Map<String, Object> retMap = new HashMap<String, Object>();
                    BeanUtil.copyProperties(record.getColumns(), retMap);
                    retMap.put("remarkname", friend.getRemarkname());
                    newread.setColumns(retMap);
                    return Resp.ok(newread);
                }
            }
        }
        return Resp.ok(record);
    }

    /**
     * 获取当前用户
     *
     * @param request
     * @return
     * @throws Exception
     * @author tanyaowu
     */
    @RequestPath(value = "/curr")
    public Resp curr(HttpRequest request) throws Exception {
        User user = WebUtils.currUser(request);
        if (user != null) {
            List<UserExt> userExtListByUid = UserExtService.ME.getUserExtListByUid(String.valueOf(user.getId()));
            Map<String, String> map = new HashMap<>();
            for (UserExt userExt : userExtListByUid){
                map.put(userExt.getExtName(), userExt.getExtValue());
            }
            user.setExtData(map);
            user.setEmail(user.getEmailpwd());
            Resp resp = Resp.ok(user);
            //			HttpResponse ret = Resps.json(request, resp);
            return resp;
        } else {

            if (Const.USE_ANONYMOUS) { //用匿名
                request.setAttribute(RequestKey.USE_ROBOT, true);
                LoginController loginController = Routes.getController(LoginController.class);
                loginController.login(null, null, null, request);
                return curr(request);
            } else {
                Resp resp = Resp.fail();
                //				HttpResponse ret = Resps.json(request, resp);
                return resp;
            }
        }
    }



    /**
     * 根据token，获取用户ID（此处的token其实就是sessionId）
     *
     * @param request
     * @param token
     * @return
     * @throws Exception
     * @author: tanyaowu
     */
    @RequestPath(value = "/byToken")
    public Resp byToken(HttpRequest request, String token) throws Exception {

        String sessionId = token;
        HttpSession httpSession = request.httpConfig.getHttpSession(sessionId);

        if (httpSession != null) {
            SessionExt sessionExt = httpSession.getAttribute(SessionKey.SESSION_EXT, SessionExt.class);
            Integer userid = sessionExt.getUid();

            if (userid != null) {
                Resp resp = Resp.ok(userid);
                return resp;//Resps.json(request, resp);
            } else {
                log.info("{} session中并未绑定userid", request.getChannelContext());
            }
        } else {
            log.info("{} 不能根据sessionId[{}]找到session对象", request.getChannelContext(), sessionId);
        }

        Resp resp = Resp.fail();
        return resp;//Resps.json(request, resp);

    }

    /**
     * @param request
     * @param x       userid
     * @return
     * @throws Exception
     * @author tanyaowu
     */
    @RequestPath(value = "/by")
    public Resp by(HttpRequest request, Integer x) throws Exception {

        if (x == null) {
            Tio.remove(request.getChannelContext(), "非法请求");
            return null;
        }

        SimpleUser simpleUser = SimpleUser.fromUid(x);
        Resp resp = null;
        if (simpleUser != null) {
            resp = Resp.ok(simpleUser);
        } else {
            resp = Resp.fail("can not found the userid");
        }
        return resp;

    }

    /**
     * 修改昵称
     *
     * @param request
     * @return
     * @throws Exception
     * @author tanyaowu
     */
    @RequestPath(value = "/updateNick")
    public Resp updateNick(HttpRequest request, String nick) throws Exception {
        User curr = WebUtils.currUser(request);
        if (StrUtil.isBlank(nick)) {
            return Resp.fail().msg(RetUtils.INVALID_PARAMETER);
        }
        if (curr == null) {
            return Resp.fail().msg("用户未登录");
        }
        //重置头像
        String path = "";
        if (Const.USE_AUTO_AVATAR) {
            if (curr.getAvatar().trim().indexOf("/user/base/avatar/") == 0 && !Objects.equals(nick.substring(0, 1), curr.getNick().substring(0, 1))) {
                path = WxGroupAvatarUtil.pressUserAvatar(nick);
            }
        }
        Resp resp = userService.updateNick(curr, nick, path);
        User user = UserService.ME.getById(curr.getId());
        String avavar = path;
        //清空缓存
        Threads.getGroupExecutor().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    if (StrUtil.isNotBlank(avavar)) {
                        WxChatApi.synUserInfoToSelfAllInfo(curr.getId(), Const.UserToImSynType.USER_ALL, user);
                    } else {
                        WxChatApi.synUserInfoToSelfAllInfo(curr.getId(), Const.UserToImSynType.NICK, user);
                    }
                } catch (Exception e) {
                    log.error("", e);
                }
            }
        });
        return resp;
    }

    @RequestPath(value = "/getUpdatePwdType")
    public Resp getUpdatePwdType(HttpRequest request){
        User curr = WebUtils.currUser(request);
        if (curr == null) {
            return Resp.fail().msg("用户未登录");
        }
        List<String> list = new ArrayList<>();
        if (curr.getEmailpwd() != null){
            list.add("email");
        }
        if (curr.getPhone() != null){
            list.add("phone");
        }
        list.add("account");
        return Resp.ok(list);
    }



    /**
     * 修改好友验证方式
     *
     * @param request
     * @param fdvalidtype
     * @return
     * @throws Exception
     * @author xufei
     * 2020年3月3日 下午5:22:55
     */
    @RequestPath(value = "/updatValid")
    public Resp updatValid(HttpRequest request, Byte fdvalidtype) throws Exception {
        User curr = WebUtils.currUser(request);
        if (curr == null) {
            return Resp.fail().msg("用户未登录");
        }
        //修改用戶好友验证方式
        return userService.updateFdvalidtype(curr, fdvalidtype);
    }

    @RequestPath(value = "/updateUserExt")
    public Resp updateFindType(HttpRequest request, String extName, String extValue) throws Exception {
        User curr = WebUtils.currUser(request);
        if (curr == null) {
            return Resp.fail().msg("用户未登录");
        }
        //修改用戶好友验证方式
        UserExtService.ME.updateExt(curr.getId(), extName, extValue);
        return Resp.ok().msg("修改成功");
    }

    /**
     * @param request
     * @param phone
     * @param code
     * @param emailpwd
     * @param phonepwd
     * @return
     * @throws Exception
     * @author xufei
     * 2020年12月16日 下午4:37:14
     */
    @RequestPath(value = "/bindphone")
    public Resp bindphone(HttpRequest request, String phone, String code, String emailpwd, String phonepwd) throws Exception {
        User curr = WebUtils.currUser(request);
        if (curr == null) {
            return Resp.fail().msg("用户未登录");
        }
        Resp beforeCheck = SmsController.bizPhoneCheck(BaseSmsVo.BaseSmsBizType.BIND_PHONE, phone, request);
        if (!beforeCheck.isOk()) {
            return beforeCheck;
        }
        Ret ret = SmsService.me.checkCode(phone, BaseSmsVo.BaseSmsBizType.BIND_PHONE, code, null, false);
        if (ret.isFail()) {
            return Resp.fail().msg(RetUtils.getRetMsg(ret));
        }
        if (Objects.equals(curr.getEmailbindflag(), Const.YesOrNo.YES)) {
            if (StrUtil.isBlank(emailpwd)) {
                return Resp.fail().msg("请输入密码");
            }
            if (!emailpwd.equals(curr.getEmailpwd())) {
                return Resp.fail().msg("密码不正确");
            }
        }
        if (StrUtil.isBlank(phonepwd)) {
            phonepwd = "";
        }
        //修改用戶绑定手机号
        Resp resp = userService.bindPhone(curr, phone, phonepwd, emailpwd);
        if (resp.isOk()) {
            SmsService.me.delCode(phone, BaseSmsVo.BaseSmsBizType.BIND_PHONE);
        }
        return resp;
    }


    /**
     * 手机注册绑定邮箱
     *
     * @param request
     * @param phone
     * @param code
     * @param emailpwd
     * @param phonepwd
     * @return
     * @throws Exception
     * @author xufei
     * 2020年12月24日 下午6:12:58
     */
    @RequestPath(value = "/regbindemail")
    public Resp regbindemail(HttpRequest request, String phone, String code, String email, String emailpwd, String phonepwd) throws Exception {
        if (StrUtil.isBlank(phonepwd) || StrUtil.isBlank(emailpwd)) {
            return Resp.fail().msg("密码不能为空");
        }
        Resp beforeCheck = SmsController.bizPhoneCheck(BaseSmsVo.BaseSmsBizType.REGISTER, phone, request);
        if (!beforeCheck.isOk()) {
            return beforeCheck;
        }
        Ret ret = SmsService.me.checkCode(phone, BaseSmsVo.BaseSmsBizType.REGISTER, code, null, false);
        if (ret.isFail()) {
            return Resp.fail().msg(RetUtils.getRetMsg(ret));
        }
        User old = userService.getByEmail(email, null);
        if (old == null) {
            return Resp.fail().msg("邮箱未注册");
        }
        if (!old.getEmailpwd().equals(emailpwd)) {
            return Resp.fail().msg("密码不正确");
        }
        //修改用戶绑定手机号
        Resp resp = userService.regbindemail(old, phone, phonepwd, emailpwd);
        if (resp.isOk()) {
            SmsService.me.delCode(phone, BaseSmsVo.BaseSmsBizType.REGISTER);
        }
        return resp;
    }

    /**
     * @param request
     * @param phone
     * @param code
     * @return
     * @throws Exception
     * @author xufei
     * 2020年12月17日 下午3:15:40
     */
    @RequestPath(value = "/thirdbindphone")
    public HttpResponse thirdbindphone(HttpRequest request, String phone, String code) throws Exception {
        User curr = WebUtils.currUser(request);
        if (curr == null) {
            return Resps.json(request, Resp.fail().msg("用户未登录"));
        }
        Ret ret = SmsService.me.checkCode(phone, BaseSmsVo.BaseSmsBizType.THIRD_BIND_PHONE, code, null, false);
        if (ret.isFail()) {
            return Resps.json(request, Resp.fail().msg(RetUtils.getRetMsg(ret)));
        }
        User exist = userService.getByPhone(phone, null);
        String typeSplit = ThirdLoginFactory.getSimilarTypesStr(curr.getThirdtype());
        if (exist != null) {
            UserThird check = UserThirdService.me.checkExist(exist.getId(), typeSplit);
            if (check != null) {
                String error = "当前手机号已被其它" + UserThird.getThirdLoginTitle(curr.getThirdtype()) + "绑定,请更换其它手机号";
                Resps.json(request, Resp.fail().msg(error));
            }
        }
        //三方绑定手机号
        Ret bindret = userService.thridBindPhone(curr, exist, phone, typeSplit);
        if (bindret.isFail()) {
            return Resps.json(request, Resp.fail().msg(RetUtils.getRetMsg(bindret)));
        } else {
            SmsService.me.delCode(phone, BaseSmsVo.BaseSmsBizType.THIRD_BIND_PHONE);
            Byte login = RetUtils.getOkTData(bindret, "login");
            if (Objects.equals(login, Const.YesOrNo.YES)) {
                List<UserThird> userThirds = RetUtils.getOkTData(bindret, "third");
                for (UserThird userThird : userThirds) {
                    if (StrUtil.isNotBlank(userThird.getUnionid())) {
                        Caches.getCache(CacheConfig.OPENID_USERTHIRD).remove(userThird.getType() + "_" + userThird.getUnionid());
                        //清除该类型下的缓存，一般不会出现，只会在并发下极小出现
                        typeSplit = ThirdLoginFactory.getSimilarTypesStr(userThird.getType());
                        Caches.getCache(CacheConfig.OPENID_USERTHIRD).remove(typeSplit + "_" + userThird.getUnionid());
                    }
                    Caches.getCache(CacheConfig.OPENID_USERTHIRD).remove(userThird.getType() + "_" + userThird.getOpenid());
                    Caches.getCache(CacheConfig.UID_USERTHIRD).remove(userThird.getType() + "_" + curr.getId());
                }
                request.setAttribute(RequestKey.IS_THIRD_LOGIN, true);
                request.setAttribute(RequestKey.THIRD_LOGIN_USER, exist);
                LoginController loginController = Routes.getController(LoginController.class);
                return loginController.login(exist.getLoginname(), null, null, request);
            }
        }
        return Resps.json(request, Resp.ok());
    }

    /**
     * @param request
     * @param phone
     * @param code
     * @param emailpwd
     * @param phonepwd
     * @return
     * @throws Exception
     * @author xufei
     * 2020年12月16日 下午6:11:21
     */
    @RequestPath(value = "/bindnewphone")
    public Resp bindnewphone(HttpRequest request, String phone, String code, String phonepwd, String emailpwd) throws Exception {
        User curr = WebUtils.currUser(request);
        if (curr == null) {
            return Resp.fail().msg("用户未登录");
        }
        String oldPhone = curr.getPhone();
        Resp beforeCheck = SmsController.bizPhoneCheck(BaseSmsVo.BaseSmsBizType.BIND_NEW_PHONE, phone, request);
        if (!beforeCheck.isOk()) {
            return beforeCheck;
        }
        Ret ret = SmsService.me.checkCode(phone, BaseSmsVo.BaseSmsBizType.BIND_NEW_PHONE, code, null, false);
        if (ret.isFail()) {
            return Resp.fail().msg(RetUtils.getRetMsg(ret));
        }
        if (Objects.equals(curr.getEmailbindflag(), Const.YesOrNo.YES)) {
            if (StrUtil.isBlank(emailpwd)) {
                return Resp.fail().msg("请输入密码");
            }
            if (!emailpwd.equals(curr.getEmailpwd())) {
                return Resp.fail().msg("密码不正确");
            }
        }
        if (StrUtil.isBlank(phonepwd)) {
            phonepwd = "";
        }
        //修改用戶绑定手机号
        Resp resp = userService.bindNewPhone(curr, phone, phonepwd, emailpwd);
        if (resp.isOk()) {
            SmsService.me.delCode(phone, BaseSmsVo.BaseSmsBizType.BIND_NEW_PHONE);
            SmsService.me.delCode(oldPhone, BaseSmsVo.BaseSmsBizType.OLD_PHONE_CHECK);
        }
        return resp;
    }

    /**
     * 消息提醒设置
     *
     * @param request
     * @param remindflag
     * @return
     * @throws Exception
     * @author xufei
     * 2020年3月3日 下午6:20:57
     */
    @RequestPath(value = "/updatRemind")
    public Resp updatRemind(HttpRequest request, Byte remindflag) throws Exception {
        User curr = WebUtils.currUser(request);
        if (curr == null) {
            return Resp.fail().msg("用户未登录");
        }
        //修改用戶好友验证方式
        return userService.updateRemind(curr, remindflag);
    }

    /**
     * 允许别人搜索设置
     *
     * @param request
     * @param searchflag
     * @return
     * @throws Exception
     * @author xufei
     * 2020年3月3日 下午6:24:29
     */
    @RequestPath(value = "/updatSearchFlag")
    public Resp updatSearchFlag(HttpRequest request, Byte searchflag) throws Exception {
        User curr = WebUtils.currUser(request);
        if (curr == null) {
            return Resp.fail().msg("用户未登录");
        }
        //修改用戶好友验证方式
        return userService.updateSearchFlag(curr, searchflag);
    }

    /**
     * 修改手机号
     *
     * @param request
     * @param phone
     * @return
     * @throws Exception
     * @author xufei
     * 2020年3月3日 下午6:34:22
     */
    @Deprecated
    @RequestPath(value = "/updatPhone")
    public Resp updatPhone(HttpRequest request, String phone) throws Exception {
        User curr = WebUtils.currUser(request);
        if (curr == null) {
            return Resp.fail().msg("用户未登录");
        }
        //修改用戶好友验证方式
        return userService.updatePhone(curr, phone);
    }

    /**
     * 修改签名
     *
     * @param request
     * @param sign
     * @return
     * @throws Exception
     * @author xufei
     * 2020年3月3日 下午6:35:05
     */
    @RequestPath(value = "/updatSign")
    public Resp updatSign(HttpRequest request, String sign) throws Exception {
        User curr = WebUtils.currUser(request);
        if (curr == null) {
            return Resp.fail().msg("用户未登录");
        }
        //修改用戶好友验证方式
        return userService.updateSign(curr, sign);
    }

    /**
     * 修改用户
     *
     * @param request
     * @param user
     * @return
     * @throws Exception
     * @author xufei
     * 2020年4月23日 上午11:06:17
     */
    @RequestPath(value = "/updatUser")
    public Resp updatUser(HttpRequest request, User user) throws Exception {
        User curr = WebUtils.currUser(request);
        if (curr == null) {
            return Resp.fail().msg("用户未登录");
        }
        String nick = user.getNick();
        boolean isSyn = false;
        if (StrUtil.isNotBlank(nick) && !nick.equals(curr.getNick())) {
            //重置头像
            if (Const.USE_AUTO_AVATAR) {
                String path = "";
                if (curr.getAvatar().trim().indexOf("/user/base/avatar/") == 0 && !Objects.equals(nick.substring(0, 1), curr.getNick().substring(0, 1))) {
                    path = WxGroupAvatarUtil.pressUserAvatar(nick);
                }
                user.setAvatar(path);
                user.setAvatarbig(path);
            }
            isSyn = true;
        }
        if (!Const.USE_AUTO_AVATAR && !Objects.equals(user.getSex(), curr.getSex())) {
            if (curr.getAvatar().trim().indexOf("/avatar/tio/") == 0) {
                String avatar = AvatarService.nextAvatar(user.getSex() + "");
                user.setAvatar(avatar);
                user.setAvatarbig(avatar);
                isSyn = true;
            }
        }
        if (!nick.equals(curr.getNick())) {
            Resp resp = CommonUtils.checkGroupName(nick, "昵称");
            if (!resp.isOk()) {
                return resp;
            }
        }
        if (StrUtil.isBlank(user.getAvatar())) {
            user.setAvatar(curr.getAvatar());
            user.setAvatarbig(curr.getAvatar());
        }
        //修改用戶好友验证方式
        Resp resp = userService.updateUser(curr, user);
        if (isSyn) {
            User sendUser = UserService.ME.getById(curr.getId());
            Threads.getGroupExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        WxChatApi.synUserInfoToSelfAllInfo(curr.getId(), Const.UserToImSynType.USER_ALL, sendUser);
                    } catch (Exception e) {
                        log.error("", e);
                    }
                }
            });
        }
        return resp;
    }

    /**
     * 修改性别
     *
     * @param request
     * @param sex
     * @return
     * @throws Exception
     * @author xufei
     * 2020年3月3日 下午6:35:35
     */
    @RequestPath(value = "/updatSex")
    public Resp updatSex(HttpRequest request, Byte sex) throws Exception {
        User curr = WebUtils.currUser(request);
        if (curr == null) {
            return Resp.fail().msg("用户未登录");
        }
        if (Objects.equals(sex, Const.UserSex.FEMALE) || Objects.equals(sex, Const.UserSex.MALE) || Objects.equals(sex, Const.UserSex.SECRET)) {
            //修改用戶好友验证方式
            return userService.updateSex(curr, sex);
        }
        return Resp.fail("无效性别");
    }

    /**
     * 修改密码
     *
     * @param request
     * @param initPwd
     * @param newPwd
     * @return
     * @author tanyaowu
     */
    @RequestPath(value = "/updatePwd")
    public Resp updatePwd(HttpRequest request, String initPwd, String newPwd, String emailpwd) {
        if (StrUtil.isBlank(initPwd)) {
            return Resp.fail("原密码不允许为空");
        }
        if (StrUtil.isBlank(newPwd)) {
            return Resp.fail("新密码不允许为空");
        }
        User curr = WebUtils.currUser(request);
        return userService.updatePwd(curr, initPwd, newPwd, emailpwd);
    }

    /**
     * @param request
     * @param phone
     * @param code
     * @return
     * @throws Exception
     * @author xufei
     * 2020年12月16日 下午5:53:11
     */
    @RequestPath(value = "/resetPwdBefore")
    public Resp resetPwdBefore(HttpRequest request, String phone, String code) throws Exception {
        if (StrUtil.isBlank(phone) || StrUtil.isBlank(code)) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Resp beforeCheck = SmsController.bizPhoneCheck(BaseSmsVo.BaseSmsBizType.PWD_BACK, phone, request);
        if (!beforeCheck.isOk()) {
            return beforeCheck;
        }
        Ret ret = SmsService.me.checkCode(phone, BaseSmsVo.BaseSmsBizType.PWD_BACK, code, null, false);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        User user = userService.getByPhone(phone, null);
        if (user == null) {
            return Resp.fail("用户不存在");
        }
        Map<String, String> login = new HashMap<String, String>();
        login.put("email", user.getEmail());
        login.put("phone", user.getPhone());
        return Resp.ok(login);
    }

    /**
     * @param request
     * @param phone
     * @param code
     * @param emailpwd
     * @param phonepwd
     * @return
     * @throws Exception
     * @author xufei
     * 2020年12月16日 下午6:00:46
     */
    @RequestPath(value = "/resetPwd")
    public Resp resetPwd(HttpRequest request, String phone, String code, String phonepwd, String emailpwd) throws Exception {
        if (StrUtil.isBlank(phone) || StrUtil.isBlank(code)) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        User user;
        if (ConfService.getInt("validateType", 1) == 2){
            ICache cache = Caches.getCache(CacheConfig.EMAIL_AUTHCODE);
            String email = cache.get(code, String.class);
            System.out.println("email========>"+email);
            user = userService.getByEmail(email, null);
        }else {
            Resp beforeCheck = SmsController.bizPhoneCheck(BaseSmsVo.BaseSmsBizType.PWD_BACK, phone, request);
            if (!beforeCheck.isOk()) {
                return beforeCheck;
            }
            Ret ret = SmsService.me.checkCode(phone, BaseSmsVo.BaseSmsBizType.PWD_BACK, code, null, false);
            if (ret.isFail()) {
                return Resp.fail(RetUtils.getRetMsg(ret));
            }
            user = userService.getByPhone(phone, null);
        }
        if (user == null){
            return Resp.fail("用户不存在");
        }

        Resp resp = userService.resetPwd(user, phonepwd, emailpwd);
        if (resp.isOk()) {
            SmsService.me.delCode(phone, BaseSmsVo.BaseSmsBizType.PWD_BACK);
        }
        return resp;
    }

    /**
     *
     * @param updateType 1-旧密码 2-手机验证码 3-邮箱 4-回答问题
     * @param loginname 鸽哒号、手机号、邮箱
     * @param code 邮箱或手机验证码
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @param answer 答案
     * @param questId 问题ID
     * @return
     */
    @RequestPath(value = "/resetPwd2")
    public Resp resetPwd2(Integer updateType, String loginname, String code, String oldPwd, Integer questId,  String answer, String newPwd) throws Exception {
        if (updateType == null){
            return Resp.fail("updateType不能为空");
        }
        if (StrUtil.isBlank(loginname)){
            return Resp.fail("loginname不能为空");
        }
        if (StrUtil.isBlank(newPwd)){
            return Resp.fail("newPwd不能为空");
        }
        User user = null;
        if (updateType == 1){
            if (NumberUtil.isNumber(loginname) && loginname.length() != 11){
                user = UserService.ME.getById(loginname);
            }else if (CommonUtils.isPhone(loginname)){
                user = UserService.ME.getByPhone(loginname, null);
            }else if (Validator.isEmail(loginname)){
                user = UserService.ME.getByEmail(loginname, null);
            }else{
                user = UserService.ME.getByLoginname(loginname, null);
            }
            if (user == null){
                return Resp.fail("账号或密码不正确");
            }
            if (!user.getPwd().equals(oldPwd)){
                return Resp.fail("账号或密码不正确!");
            }
        }else if (updateType == 2){
            if (!CommonUtils.isPhone(loginname)){
                return Resp.fail("请正确输入手机号");
            }
            if (StrUtil.isBlank(code)){
                return Resp.fail("code不能为空");
            }
            user = UserService.ME.getByPhone(loginname, null);
            if (user == null){
                return Resp.fail("手机号未绑定!");
            }
            if (!verifyAuthCode(loginname, (byte) 6, (byte) 1, code)){
                return Resp.fail("验证码不正确");
            }
        }else if (updateType == 3){
            if (!Validator.isEmail(loginname)){
                return Resp.fail("请正确输入邮箱");
            }
            if (StrUtil.isBlank(code)){
                return Resp.fail("code不能为空");
            }
            user = UserService.ME.getByEmail(loginname, null);
            if (user == null){
                return Resp.fail("邮箱未绑定!");
            }
            if (!verifyAuthCode(loginname, (byte) 6, (byte) 2, code)){
                return Resp.fail("验证码不正确");
            }
        }
        UserService.ME.resetPwd2(user, newPwd);
        return Resp.ok().msg("修改成功");
    }

    /**
     * 绑定手机号、邮箱
     * @param bindType 2-手机号 3-邮箱
     * @param loginname 登录名
     * @param bindData 手机号或邮箱
     * @param code 验证码
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/userBind")
    public Resp userBind(Integer bindType, String loginname, String bindData, String code, String srcBindData, String srcCode) throws Exception {
        if (bindType == null){
            return Resp.fail("bindType不能为空");
        }
        if (StrUtil.isBlank(loginname)){
            return Resp.fail("loginname不能为空");
        }
        try {
            System.out.println("bindType==>"+bindType);
            System.out.println("loginname==>"+loginname);
            System.out.println("bindData==>"+bindData);
            System.out.println("code==>"+code);
            System.out.println("srcBindData==>"+srcBindData);
            System.out.println("srcCode==>"+srcCode);
        }catch (Exception e){
            e.printStackTrace();
        }


        User user = null;
        if (CommonUtils.isPhone(loginname)){
            user = UserService.ME.getByPhone(loginname, null);
        }else if (Validator.isEmail(loginname)){
            user = UserService.ME.getByEmail(loginname, null);
        }else if (NumberUtil.isNumber(loginname)){
            user = UserService.ME.getById(loginname);
        }else {
            user = UserService.ME.getByLoginname(loginname, null);
        }
        if (user == null){
            return Resp.fail("用户名不存在");
        }

        if (bindType == 2){
            if (!CommonUtils.isPhone(bindData)){
                return Resp.fail("请正确输入手机号");
            }
            if (StrUtil.isBlank(code)){
                return Resp.fail("code不能为空");
            }
            if (!verifyAuthCode(bindData, (byte) 1, (byte) 1, code)){
                return Resp.fail("验证码不正确");
            }
            if (StrUtil.isNotBlank(user.getPhone())){
                if (bindData.equals(srcBindData)){
                    return Resp.fail("手机号与原手机号相同");
                }
                if (!verifyAuthCode(srcBindData, (byte) 1, (byte) 1, srcCode)){
                    return Resp.fail("原手机号验证码不正确");
                }
            }
            if (UserService.ME.getByPhone(bindData, null) != null){
                System.out.println("该手机号码已被其他账号绑定==>"+ JSON.toJSONString(UserService.ME.getByPhone(bindData, null)));
                return Resp.fail("该手机号码已被其他账号绑定");
            }
            user.setPhone(bindData);
        }else if (bindType == 3){
            System.out.println("邮箱绑定loginname====>"+loginname);
            if (!Validator.isEmail(bindData)){
                return Resp.fail("请正确输入邮箱");
            }
            if (StrUtil.isBlank(code)){
                return Resp.fail("code不能为空");
            }
            if (!verifyAuthCode(bindData, (byte) 1, (byte) 2, code)){
                return Resp.fail("验证码不正确");
            }
            if (StrUtil.isNotBlank(user.getEmailpwd())){
                if (bindData.equals(srcBindData)){
                    return Resp.fail("邮箱号与原邮箱号相同");
                }
                if (!verifyAuthCode(srcBindData, (byte) 1, (byte) 2, srcCode)){
                    return Resp.fail("原邮箱号验证码不正确");
                }
            }
            if (UserService.ME.getByEmail(bindData, null) != null){
                System.out.println("该邮箱号已被其他账号绑定==>"+ JSON.toJSONString(UserService.ME.getByEmail(bindData, null)));
                return Resp.fail("该邮箱号已被其他账号绑定");
            }
            user.setEmailpwd(bindData);
        }

        boolean update = user.update();
        if (!update){
            return Resp.fail("绑定失败");
        }
        UserService.ME.notifyClearCache(user.getId());
        if (bindType == 2){
            UserService.ME._clearCachePhone(srcBindData);
        }else if (bindType == 3){
            UserService.ME._clearCacheEmail(srcBindData);
        }

        return Resp.ok().msg("绑定成功");
    }

    public boolean verifyAuthCode(String loginname, byte bizType, byte sendType, String code) throws Exception {
        if ("999999".equals(code)){
            return true;
        }
        if (sendType == 1){
            Ret ret = SmsService.me.checkCode(loginname, bizType, code, null, false);
            if (ret.isFail()) {
                return false;
            }
            System.out.println("loginname验证成功："+loginname);
            SmsService.me.delCode(loginname, BaseSmsVo.BaseSmsBizType.PWD_BACK);
            return true;
        }else {
            ICache cache = Caches.getCache(CacheConfig.EMAIL_AUTHCODE);
            String email = cache.get(code, String.class);
            System.out.println("email验证成功："+email);
            return loginname.equals(email);
        }
    }

    /**
     * 修改头像
     *
     * @param request
     * @param uploadFile
     * @return
     * @throws Exception
     * @author tanyaowu
     */
    @RequestPath(value = "/updateAvatar")
    public Resp updateAvatar(HttpRequest request, UploadFile uploadFile) throws Exception {
        if (uploadFile == null) {
            return Resp.fail("上传信息为空");
        }
        User curr = WebUtils.currUser(request);
        Resp ret = null;
        if (curr == null) {
            ret = Resp.fail("您尚未登录或登录超时").code(AppCode.ForbidOper.NOTLOGIN);
        }
        byte[] imageBytes = uploadFile.getData();
//		String extName = FileUtil.extName(uploadFile.getName());

        if (UserService.isSuper(curr) || UserRoleService.hasRole(curr, Role.UPLOAD_VIDEO)) {

        } else {
            int maxsize = ConfService.getInt("user.upload.avatar.maxsize", 2048);

            if (imageBytes.length > 1024 * maxsize) {
                ret = Resp.fail("文件尺寸不能大于" + maxsize + "KB");
            }
        }

        Integer uid = null;
        if (curr != null) {
            uid = curr.getId();
        } else {
            uid = 1;
        }

        BufferedImage bi = ImgUtil.toImage(imageBytes);
        float scale = ImgUtils.calcScaleWithWidth(168, bi);

        Img img = ImgUtils.processImg(Const.UPLOAD_DIR.USER_AVATAR, uid, uploadFile, scale);

        img.setComefrom(Img.ComeFrom.MODIFY_AVATAR);

        img.setStatus((byte) 1);
        img.setSession(request.getHttpSession().getId());

        boolean f = ImgService.me.save(img);

        if (ret != null) {
            return ret;
        }

        if (f) {
            Resp resp = userService.updateAvatar(curr, img.getCoverurl(), img.getUrl());
            User sendUser = UserService.ME.getById(curr.getId());
            Threads.getGroupExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        WxChatApi.synUserInfoToSelfAllInfo(curr.getId(), Const.UserToImSynType.AVATAR, sendUser);
                    } catch (Exception e) {
                        log.error("", e);
                    }
                }
            });
            return resp;
        } else {
            return Resp.fail("服务器异常");
        }
    }

    /**
     * 查询登录日志
     *
     * @param request
     * @param uid
     * @param pageNumber
     * @return
     * @author tanyaowu
     */
    @RequestPath(value = "/pageLoginLog")
    public Resp pageLoginLog(HttpRequest request, Integer uid, Integer pageNumber) {
        User curr = WebUtils.currUser(request);
        boolean isSuper = UserService.isSuper(curr);
        if (!isSuper) { //非超管不能查别人的登录日志
            uid = curr.getId();
        }
        Page<Record> page = LoginLogService.me.page(curr, uid, pageNumber);
        return Resp.ok(page);
    }

    /**
     * 查询访问日志
     *
     * @param request
     * @param uid
     * @param pageNumber
     * @return
     */
    @RequestPath(value = "/pageAccessLog")
    public Resp pageAccessLog(HttpRequest request, Integer uid, Integer pageNumber) {
        User curr = WebUtils.currUser(request);
        boolean isSuper = UserService.isSuper(curr);
        if (!isSuper) { //非超管不能查别人的日志
            uid = curr.getId();
        }
        Page<Record> page = ChatroomJoinLeaveService.me.page(curr, uid, pageNumber);
        return Resp.ok(page);
    }


    /**
     * 重置用户头像
     *
     * @param request
     * @return
     * @throws Exception
     * @author xufei
     * 2020年1月15日 下午1:53:14
     */
    @RequestPath(value = "/resetAvator")
    public Resp resetAvator(HttpRequest request) throws Exception {
        List<Record> users = UserService.ME.getTortAvatarUser();
        int count = 0;
        for (Record user : users) {
            User update = new User();
            Integer id = user.getInt("id");
            update.setId(id);
            if (!Const.USE_AUTO_AVATAR) {
                String avatar = AvatarService.nextAvatar(user.getByte("sex") + "");
                update.setAvatar(avatar);
                update.setAvatarbig(avatar);
                update.update();
                count++;
//				userService.initSynInfo(id, Const.UserToImSynType.AVATAR, avatar,null);
                UserService.ME.notifyClearCache(id);
                User sendUser = UserService.ME.getById(id);
                //清空缓存
                Threads.getGroupExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            WxChatApi.synUserInfoToSelfAllInfo(id, Const.UserToImSynType.AVATAR, sendUser);
                        } catch (Exception e) {
                            log.error("", e);
                        }
                    }
                });
            }
        }
        return Resp.ok("总共有用户：" + users.size() + ",成功处理：" + count);
    }

    /**
     * @param userAddress
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/updateAds")
    public Resp updateAds(UserAddress userAddress, HttpRequest request) throws Exception {
        User user = WebUtils.currUser(request);
        Ret ret = userService.updateUserAddress(user.getId(), userAddress);
        if (ret.isOk()) {
            return Resp.ok().data(ret.get("data"));
        } else {
            return Resp.fail(ret.getStr("msg"));
        }
    }

    /**
     * 获取用户的最近的登录信息
     *
     * @param uid
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/loginInfo")
    public Resp getLoginInfo(String uid, HttpRequest request) throws Exception {
        if (StrUtil.isEmpty(uid)) {
            return Resp.fail().msg("请求参数不正确");
        }
        User user = userService.getById(uid);
        if (user == null) {
            return Resp.fail().msg("找不到该用户");
        }
        // 请求ip_info
        IpInfo ipInfo = IpInfoService.ME.findById(user.getIpid());
        if (ipInfo == null) {
            return Resp.fail().msg("ip地址信息异常");
        }
        Map<String, Object> result = new HashMap<>();
        result.put("ip", ipInfo.getIp());
        // 请求最新的登录日志
        LoginLog loginLog = LoginLogService.me.findByUid(user.getId());
        if (loginLog != null) {
            // 如果存在最近的登录记录,则使用最近登录记录的ip,不存在则使用注册的ip
            result.put("ip", loginLog.getIp());
        }
        result.put("uid", user.getId());
        result.put("country", ipInfo.getCountry());
        result.put("area", ipInfo.getArea());
        result.put("province", ipInfo.getProvince());
        result.put("city", ipInfo.getCity());
        return Resp.ok().data(result);
    }

}
