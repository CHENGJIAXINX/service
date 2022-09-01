package org.tio.mg.web.server.controller.mg;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.service.mg.MgLoginStatService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.RequestVo;
import org.tio.utils.resp.Resp;

/**
 * 后台登录统计管理控制器
 */
@RequestPath(value = "/mgloginstat")
public class MgLoginStatController {

    private Logger log = LoggerFactory.getLogger(MgLoginStatController.class);

    private MgLoginStatService loginStatService = MgLoginStatService.ME;


    /**
     * 登录-时间-统计
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/timeList")
    public Resp timeList(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = loginStatService.statTimeList(requestVo);
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
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/timeUserList")
    public Resp timeUserList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = loginStatService.statTimeUserList(requestVo);
        if (ret.isFail()) {
            log.error("获取登录-时间-用户-统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 登录-用户-统计
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/userList")
    public Resp userList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = loginStatService.statUserList(requestVo);
        if (ret.isFail()) {
            log.error("获取登录-用户-统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 登录日志列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/loginList")
    public Resp loginList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = loginStatService.loginList(requestVo);
        if (ret.isFail()) {
            log.error("获取日志列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 登录-时间-用户-日志-统计
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/loginInfoList")
    public Resp loginInfoList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = loginStatService.statLoginList(requestVo);
        if (ret.isFail()) {
            log.error("获取登录-时间-用户-日志-统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkList(ret));
    }

    /**
     * 登录-用户-天-统计
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/userDayList")
    public Resp userDayList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = loginStatService.statUserDayList(requestVo);
        if (ret.isFail()) {
            log.error("获取登录-IP-天-统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }
}
