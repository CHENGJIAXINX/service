package org.tio.mg.web.server.controller.tioim;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.service.tioim.TioLoginService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.RequestVo;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.resp.Resp;

/**
 * im登录管理控制器
 */
@RequestPath(value = "/tiologin")
public class TioLoginController {

    private static Logger log = LoggerFactory.getLogger(TioLoginController.class);

    private TioLoginService loginService = TioLoginService.me;

    /**
     * 登录日志
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/loginLogList")
    public Resp loginLogList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = loginService.loginList(requestVo);
        if (ret.isFail()) {
            log.error("获取日志列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 登录-时间-统计
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/timeList")
    public Resp timeList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = loginService.statTimeList(requestVo);
        if (ret.isFail()) {
            log.error("获取登录-时间-统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 登录-用户-统计
     *
     * @param request
     * @param period
     * @param pageNumber
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/timeUserList")
    public Resp timeUserList(HttpRequest request, String period, Integer pageNumber, Integer pageSize) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = loginService.statTimeUserList(requestVo);
        if (ret.isFail()) {
            log.error("获取登录-时间-用户-统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 登录-时间-用户-日志-统计
     *
     * @param request
     * @param period
     * @param uid
     * @return
     * @throws Exception
     * @author xufei
     * 2020年7月16日 下午4:36:40
     */
    @RequestPath(value = "/timeloginlist")
    public Resp timeLoginList(HttpRequest request, String period, Integer uid) throws Exception {
        Ret ret = loginService.statTimeLoginList(period, uid);
        if (ret.isFail()) {
            log.error("获取登录-时间-用户-日志-统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkList(ret));
    }


    /**
     * 登录-ip-统计
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/ipList")
    public Resp ipList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = loginService.statIpList(requestVo);
        if (ret.isFail()) {
            log.error("获取登录-ip-统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 登录-IP-天-统计
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/ipDayList")
    public Resp ipDayList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        if (requestVo == null || StrUtil.isEmpty(requestVo.getIp())) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = loginService.statIpDayList(requestVo);
        if (ret.isFail()) {
            log.error("获取登录-IP-天-统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 登录-ip-用户-统计
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/ipUserList")
    public Resp ipUserList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        if (requestVo == null || StrUtil.isEmpty(requestVo.getPeriod()) || StrUtil.isEmpty(requestVo.getIp())) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = loginService.statIpUserList(requestVo);
        if (ret.isFail()) {
            log.error("获取登录-ip-用户-统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 登录-ip-用户-日志-统计
     *
     * @param request
     * @param period
     * @param uid
     * @return
     * @throws Exception
     * @author xufei
     * 2020年7月16日 下午4:36:40
     */
    @RequestPath(value = "/iploginlist")
    public Resp iploginlist(HttpRequest request, String period, Integer uid, String ip) throws Exception {
        Ret ret = loginService.statIpLoginList(period, uid, ip);
        if (ret.isFail()) {
            log.error("获取登录-ip-用户-日志-统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkList(ret));
    }


}
