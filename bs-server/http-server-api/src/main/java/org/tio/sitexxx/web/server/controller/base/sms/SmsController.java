/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.base.sms;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.kit.StrKit;
import org.tio.sitexxx.service.api.sms.BaseSmsVo;
import org.tio.sitexxx.service.cache.CacheConfig;
import org.tio.sitexxx.service.cache.Caches;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.UserThird;
import org.tio.sitexxx.service.service.base.RegisterService;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.base.UserThirdService;
import org.tio.sitexxx.service.service.base.sms.SmsService;
import org.tio.sitexxx.service.service.captcha.CaptchaLocalService;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.utils.CommonUtils;
import org.tio.sitexxx.service.utils.EmailKit;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.web.server.controller.base.thirdlogin.ThirdLoginFactory;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.cache.ICache;
import org.tio.utils.resp.Resp;

import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaService;

import cn.hutool.core.lang.Validator;

/**
 * 短信
 *
 * @author xufei
 * 2020年12月18日 下午1:39:38
 */
@RequestPath(value = "/sms")
public class SmsController {


    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(SmsController.class);

    private static final CaptchaService captchaService = CaptchaLocalService.captchaService;

    /**
     * @param args
     * @author tanyaowu
     */
    public static void main(String[] args) {

    }

    /**
     * @author tanyaowu
     */
    public SmsController() {
    }

    /**
     * 发送短信
     *
     * @param captchaVO
     * @param biztype
     * @param mobile
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/send")
    public Resp send(CaptchaVO captchaVO, Byte biztype, String mobile, HttpRequest request) throws Exception {
        if (biztype == null || mobile == null || captchaVO == null) {
            return Resp.fail().msg(RetUtils.INVALID_PARAMETER);
        }
        // biztype = 3 且 验证码开关打开时校验用户是否注册

        if (ConfService.getInt("validateType", 1) == 2){
            //邮箱认证
            //biztype=2，注册
            if (biztype == 2){
                String code = RandomUtils.nextInt(100000, 999999) + "";
                ICache cache = Caches.getCache(CacheConfig.EMAIL_AUTHCODE);
                cache.put(code, mobile);
                System.out.println("当前验证码是："+code);
                boolean result = RegisterService.me.sendRegiestCodeEmail((byte) 2, "注册验证码", code, mobile, request.getClientIp(), request.getHttpSession().getId(), WebUtils.getRequestExt(request));
                if (!result){
                    return Resp.fail("验证码发送失败");
                }
                return Resp.ok("验证码已发送");
            }else if (biztype == 6){
                User byLoginname = UserService.ME.getByLoginname(mobile, null);
                if (byLoginname == null){
                    return Resp.fail("账号不存在");
                }
                String email = byLoginname.getEmailpwd();
                if (StrUtil.isBlank(email)){
                    return Resp.fail("未绑定邮箱");
                }
                System.out.println("email=====>"+email);
                String code = RandomUtils.nextInt(100000, 999999) + "";
                ICache cache = Caches.getCache(CacheConfig.EMAIL_AUTHCODE);
                cache.put(code, email);
                System.out.println("当前验证码是："+code);
                boolean result = RegisterService.me.sendRegiestCodeEmail((byte) 2, "修改密码验证码", code, email, request.getClientIp(), request.getHttpSession().getId(), WebUtils.getRequestExt(request));
                if (!result){
                    return Resp.fail("验证码发送失败");
                }
                return Resp.ok("验证码已发送");
            }else if (biztype == 3){
                return Resp.fail("不支持");
            }

        }

        if (biztype == 3) {
            // 验证用户是否注册
            User first = User.dao.findFirst("select * from user where phone = ?", mobile);
            if (first == null) {
                if ("1".equals(ConfService.getString("inviteEnable", "2"))){
                    return Resp.fail().msg(RetUtils.REGISTER_FIRST);
                }
                return Resp.fail("请先注册").code(98);
            }
        }
        ResponseModel model = captchaService.verification(captchaVO);
        if (model.isError()) {
            return Resp.fail(model.getRepMsg());
        }
        String ip = request.getClientIp();
        String sessionid = request.getHttpSession().getId();
        String referer = request.getReferer();
        Ret ret = SmsService.me.send(mobile, biztype, ip, sessionid, referer, "", null);
        if (ret.isFail()) {
            return Resp.fail().msg(RetUtils.getRetMsg(ret));
        }
//		return Resp.ok(RetUtils.getOkData(ret));
        return Resp.ok(RetUtils.OPER_RIGHT);
    }

    /**
     *
     * @param captchaVO
     * @param sendType
     * @param loginname
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/resetPwdSend")
    public Resp resetPwdSend(CaptchaVO captchaVO, Integer sendType, String loginname, HttpRequest request) throws Exception {
        if (sendType == null || loginname == null || captchaVO == null) {
            return Resp.fail().msg(RetUtils.INVALID_PARAMETER);
        }
        ResponseModel model = captchaService.verification(captchaVO);
        if (model.isError()) {
            return Resp.fail(model.getRepMsg());
        }
        Ret ret = null;
        if (sendType == 2){
            if (!CommonUtils.isPhone(loginname)){
                return Resp.fail("请输入正确手机号");
            }
            User user = UserService.ME.getByPhone(loginname, null);
            if (user == null){
                return Resp.fail("该手机号不存在");
            }
            ret = sendAuthCode(request, (byte) 1, (byte) 6, loginname);
        }else if (sendType == 3){
            if (!Validator.isEmail(loginname)){
                return Resp.fail("请输入合法邮箱");
            }
            User user = UserService.ME.getByEmail(loginname, null);
            if (user == null){
                return Resp.fail("该邮箱不存在");
            }
            ret = sendAuthCode(request, (byte) 2, (byte) 6, loginname);
        }else {
            return Resp.fail("不支持的sendType");
        }
        if (ret.isFail()) {
            return Resp.fail().msg(RetUtils.getRetMsg(ret));
        }
        return Resp.ok().msg("验证码发送成功，请查看");
    }


    /**
     *
     * @param captchaVO
     * @param sendType
     * @param bindData
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/userBindSend")
    public Resp userBindSend(CaptchaVO captchaVO, Integer sendType, String bindData, HttpRequest request) throws Exception {
        if (sendType == null || bindData == null || captchaVO == null) {
            return Resp.fail().msg(RetUtils.INVALID_PARAMETER);
        }
        ResponseModel model = captchaService.verification(captchaVO);
        if (model.isError()) {
            return Resp.fail(model.getRepMsg());
        }
        Ret ret = null;
        if (sendType == 2){
            if (!CommonUtils.isPhone(bindData)){
                return Resp.fail("请输入正确手机号");
            }
            ret = sendAuthCode(request, (byte) 1, (byte) 1, bindData);
        }else if (sendType == 3){
            if (!Validator.isEmail(bindData)){
                return Resp.fail("请输入合法邮箱");
            }
            ret = sendAuthCode(request, (byte) 2, (byte) 1, bindData);
        }else {
            return Resp.fail("不支持的sendType");
        }
        if (ret.isFail()) {
            return Resp.fail().msg(RetUtils.getRetMsg(ret));
        }
        return Resp.ok().msg("验证码发送成功，请查看");
    }

    public Ret sendAuthCode(HttpRequest request, byte sendType, byte bizType, String loginname) throws Exception {
        if (sendType == 1){
            String ip = request.getClientIp();
            String sessionid = request.getHttpSession().getId();
            String referer = request.getReferer();
            return SmsService.me.send(loginname, bizType, ip, sessionid, referer, "", null);
        }else {
            String code = RandomUtils.nextInt(100000, 999999) + "";
            ICache cache = Caches.getCache(CacheConfig.EMAIL_AUTHCODE);
            cache.put(code, loginname);
            System.out.println("当前验证码是："+code);
            boolean result = RegisterService.me.sendRegiestCodeEmail((byte) 2, "修改密码验证码", code, loginname, request.getClientIp(), request.getHttpSession().getId(), WebUtils.getRequestExt(request));
            if (result){
                return Ret.ok();
            }else {
                return Ret.fail("msg", "发送失败");
            }
        }
    }

    /**
     * 手机短信前检查
     *
     * @param biztype
     * @param mobile
     * @param request
     * @return
     * @throws Exception
     * @author xufei
     * 2020年12月16日 下午4:06:10
     */
    @RequestPath(value = "/beforeCheck")
    public Resp beforeCheck(Byte biztype, String mobile, HttpRequest request) throws Exception {
        return bizPhoneCheck(biztype, mobile, request);
    }

    /**
     * 验证短信code
     *
     * @param type
     * @param code
     * @param request
     * @return
     * @throws Exception
     * @author xufei
     * 2020年12月10日 下午2:59:56
     */
    @RequestPath(value = "/check")
    public Resp check(Byte biztype, String mobile, String code, HttpRequest request) throws Exception {
        Ret ret = SmsService.me.checkCode(mobile, biztype, code, null, false);
        if (ret.isFail()) {
            return Resp.fail().msg(RetUtils.getRetMsg(ret));
        }
        return Resp.ok("验证码正确");
    }

    /**
     * @param biztype
     * @param mobile
     * @param request
     * @return
     * @author xufei
     * 2020年12月24日 下午4:56:49
     */
    public static Resp bizPhoneCheck(Byte biztype, String mobile, HttpRequest request) {
        if (biztype == null || mobile == null) {
            return Resp.fail().msg(RetUtils.INVALID_PARAMETER);
        }
        if (!Validator.isMobile(mobile)) {
            return Resp.fail().msg("无效手机号");
        }
        switch (biztype) {
            case BaseSmsVo.BaseSmsBizType.REGISTER:
            case BaseSmsVo.BaseSmsBizType.BIND_NEW_PHONE:
            case BaseSmsVo.BaseSmsBizType.BIND_PHONE:
                User register = UserService.ME.getByPhone(mobile, null);
                if (register != null) {
                    return Resp.fail("手机号已注册");
                }
                break;
            case BaseSmsVo.BaseSmsBizType.THIRD_BIND_PHONE:
                User bindUser = UserService.ME.getByPhone(mobile, null);
                if (bindUser != null) {
                    User curr = WebUtils.currUser(request);
                    String typeSplit = ThirdLoginFactory.getSimilarTypesStr(curr.getThirdtype());
                    UserThird check = UserThirdService.me.checkExist(bindUser.getId(), typeSplit);
                    if (check != null) {
                        return Resp.fail("当前手机号已被其它" + UserThird.getThirdLoginTitle(curr.getThirdtype()) + "绑定,请更换其它手机号");
                    }
                    return Resp.ok(Const.YesOrNo.YES);
                } else {
                    return Resp.ok(Const.YesOrNo.NO);
                }
            case BaseSmsVo.BaseSmsBizType.PWD_BACK:
            case BaseSmsVo.BaseSmsBizType.PWD_UPDATE:
            case BaseSmsVo.BaseSmsBizType.OLD_PHONE_CHECK:
            case BaseSmsVo.BaseSmsBizType.LOGIN:
                User login = UserService.ME.getByPhone(mobile, null);
                if (login == null) {
                    if ("1".equals(ConfService.getString("inviteEnable", "2"))){
                        return Resp.fail().msg(RetUtils.REGISTER_FIRST);
                    }
                    return Resp.fail("手机号未注册").code(98);
                }
                break;
            default:
        }
        return Resp.ok();
    }
}
