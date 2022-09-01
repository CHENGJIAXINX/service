package org.tio.mg.web.server.controller.mg;

import java.util.Date;
import java.util.Objects;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpConfig;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.common.session.HttpSession;
import org.tio.http.server.annotation.RequestPath;
import org.tio.http.server.util.Resps;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.model.main.UserAgent;
import org.tio.mg.service.model.mg.MgIpInfo;
import org.tio.mg.service.model.mg.MgOperLog;
import org.tio.mg.service.model.mg.MgUser;
import org.tio.mg.service.model.mg.MgUserLoginLog;
import org.tio.mg.service.model.mg.MgUserToken;
import org.tio.mg.service.service.base.IpInfoService;
import org.tio.mg.service.service.conf.MgConfService;
import org.tio.mg.service.service.mg.MgUserService;
import org.tio.mg.service.service.mg.MgUserTokenService;
import org.tio.mg.service.utils.PeriodUtils;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.MgLoginVo;
import org.tio.mg.service.vo.RequestExt;
import org.tio.mg.service.vo.SessionExt;
import org.tio.mg.web.server.init.WebApiInit;
import org.tio.mg.web.server.utils.WebUtils;
import org.tio.mg.web.server.vo.LoginResult.ErrorCode;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.SessionKey;
import org.tio.utils.SystemTimer;
import org.tio.utils.jfinal.P;
import org.tio.utils.resp.Resp;

import cn.hutool.core.util.StrUtil;

/**
 * 后台登录控制器
 */
@RequestPath(value = "/mgLogin")
public class MgLoginController {

    private static Logger log = LoggerFactory.getLogger(MgLoginController.class);

    private MgUserService userService = MgUserService.ME;

    private IpInfoService ipInfoService = IpInfoService.ME;

    private MgUserTokenService mgUserTokenService = MgUserTokenService.me;

    /**
     * 登录
     *
     * @param request
     * @return
     */
    @RequestPath(value = "")
    public HttpResponse login(HttpRequest request) {
        MgLoginVo mgLoginVo = JSONObject.parseObject(request.getBodyString(), MgLoginVo.class);
        // 验证登录信息
        if (mgLoginVo == null || StrUtil.isEmpty(mgLoginVo.getLoginName()) || StrUtil.isEmpty(mgLoginVo.getPd5())) {
            return Resps.json(request, Resp.fail(RetUtils.INVALID_PARAMETER));
        }
        String sessionId = request.getHttpSession().getId();
        MgUser user = null;
        HttpSession httpSession = request.getHttpSession();
        HttpConfig httpConfig = request.getHttpConfig();
        Ret ret = this.doLogin(mgLoginVo, request);
        if (ret.isOk()) {
            user = (MgUser) ret.get("user");
            RequestExt requestExt = WebUtils.getRequestExt(request);
            byte deviceType = requestExt.getDeviceType();
            //是否是从手机端过来的请求
            boolean fromApp = requestExt.isFromApp();
            //添加登录日志
            String ip = request.getClientIp();
            MgIpInfo ipinfo = ipInfoService.mgSave(ip);
            // 添加操作日志
            MgOperLog operLog = new MgOperLog();
            operLog.setModename("登录");
            operLog.setAid(-1);
            operLog.setOperip(ip);
            operLog.setOperparam(mgLoginVo.getLoginName() + "****" + mgLoginVo.getAuthCode());
            operLog.setOpertype(MgConst.OperLogType.SYS);
            if (fromApp) {
                operLog.setDeviceinfo(StringUtils.substring(requestExt.getDeviceinfo(), 0, 128));
            } else {
                operLog.setDeviceinfo(StringUtils.substring(request.getUserAgent(), 0, 128));
            }
            operLog.save();
            // 添加用户登录日志
            MgUserLoginLog userLoginLog = new MgUserLoginLog();
            Date time = new Date();
            userLoginLog.setIp(ip);
            userLoginLog.setIpid(ipinfo.getId());
            userLoginLog.setSessionid(sessionId);
            userLoginLog.setMguid(user.getId());
            userLoginLog.setDevicetype(deviceType);
            userLoginLog.setDayperiod(PeriodUtils.dateToPeriodByType(time, Const.PeriodType.DAY));
            userLoginLog.setTimeperiod(PeriodUtils.dateToPeriodByType(time, Const.PeriodType.TIME));
            userLoginLog.setHourperiod(PeriodUtils.dateToPeriodByType(time, Const.PeriodType.HOUR));
            userLoginLog.setTime(time);
            if (fromApp) {
                userLoginLog.setDeviceinfo(StringUtils.substring(requestExt.getDeviceinfo(), 0, 128));
                userLoginLog.setImei(requestExt.getImei());
            } else {
                UserAgent userAgent = requestExt.getUserAgent();
                if (userAgent != null) {
                    userLoginLog.setDeviceinfo(userAgent.getOsName() + " " + userAgent.getOsVersion() + "/" + userAgent.getAgentName() + " " + userAgent.getAgentVersionMajor());
                } else {
                    userLoginLog.setDeviceinfo(StringUtils.substring(request.getUserAgent(), 0, 128));
                }
            }
            userLoginLog.save();
            HttpResponse httpResponse = Resps.json(request, Resp.ok());
            // 先更新sessionId，防止一个sessionId存留过久，减少sessionId被盗的风险
            WebApiInit.requestHandler.updateSessionId(request, httpSession, httpResponse);
            String newSeesionId = request.getHttpSession().getId();
            // 创建用户token
            MgUserToken userToken = mgUserTokenService.find(deviceType, user.getId());
            if (userToken == null) {
                userToken = new MgUserToken();
                userToken.setMguid(user.getId());
                userToken.setDevicetype(deviceType);
                userToken.setToken(newSeesionId);
                mgUserTokenService.add(userToken);
            } else {
                //  单点登录 踢人操作
                String oldToken = userToken.getToken();
                HttpSession oldHttpSession = (HttpSession) httpConfig.getSessionStore().get(oldToken);
                if (oldHttpSession != null) {
                    SessionExt oldSessionExt = oldHttpSession.getAttribute(SessionKey.SESSION_EXT, SessionExt.class, new SessionExt(), httpConfig);
                    oldSessionExt.setUid(null);
                    oldHttpSession.update(httpConfig);//切记：每次修改SessionExt后，要调用一下update把数据更新到分布式缓存中
                }
                userToken.setToken(newSeesionId);
                mgUserTokenService.update(userToken);
            }
            SessionExt sessionExt = httpSession.getAttribute(SessionKey.SESSION_EXT, SessionExt.class);
            sessionExt.setUid(user.getId());
            sessionExt.setLoginTime(SystemTimer.currTime);
            httpSession.update(httpConfig);//切记：每次修改SessionExt后，要调用一下update把数据更新到分布式缓存中
            return httpResponse;
        } else {
            HttpResponse httpResponse = (HttpResponse) ret.get("resp");
            if (httpResponse == null) {
                log.error("doLogin(loginname, pwd, authcode, request)返回值没有包含response信息");
                return Resps.json(request, Resp.fail("服务器异常"));
            }
            return httpResponse;
        }
    }

    /**
     * 具体的登录实现
     *
     * @param mgLoginVo
     * @param request
     * @return
     */
    private Ret doLogin(MgLoginVo mgLoginVo, HttpRequest request) {
        Ret ret = null;
        MgUser user = null;
        ret = userService.login(mgLoginVo);
        if (ret.isFail()) {
            Resp resp = Resp.fail();
            Integer code = RetUtils.getIntCode(ret);
            if (code == null || code == 1 || code == 2) {
                resp.code(1);
                resp.msg(ErrorCode.USER_OR_PWD_ERROR.value);
            } else {
                resp.msg(ErrorCode.AUTH_CODE_ERROR.value);
                resp.code(3);
            }
            HttpResponse httpResponse = Resps.json(request, resp);
            return Ret.fail().set("resp", httpResponse);
        }
        user = RetUtils.getOkTData(ret);
        if (user != null) {
            Resp resp = checkStatus(user);
            if (resp.isOk()) {
                return Ret.ok().set("user", user);
            } else {
                HttpResponse httpResponse = Resps.json(request, resp);
                return Ret.fail().set("resp", httpResponse);
            }
        } else {
            Resp resp = Resp.fail();
            resp.code(ErrorCode.USER_OR_PWD_ERROR.code).msg(ErrorCode.USER_OR_PWD_ERROR.value);
            HttpResponse httpResponse = Resps.json(request, resp);
            return Ret.fail().set("resp", httpResponse);
        }
    }

    /**
     * @param user
     * @return
     * @author xufei
     * 2020年5月26日 下午3:11:48
     */
    private static Resp checkStatus(MgUser user) {
        if (Objects.equals(user.getStatus(), MgConst.MgUserStatus.NORMAL)) {
            return Resp.ok();
        } else {
            if (Objects.equals(user.getStatus(), MgConst.MgUserStatus.INBLACK)) {
                return Resp.fail().code(ErrorCode.USER_INBLACK_ERROR.code).msg(ErrorCode.USER_INBLACK_ERROR.value);
            } else {
                return Resp.fail().code(ErrorCode.USER_STATUS_ERROR.code).msg(ErrorCode.USER_STATUS_ERROR.value);
            }
        }
    }
}
