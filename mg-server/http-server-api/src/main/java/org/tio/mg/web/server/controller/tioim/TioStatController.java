/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.web.server.controller.tioim;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.service.tioim.TioGroupService;
import org.tio.mg.service.service.tioim.TioLoginService;
import org.tio.mg.service.service.tioim.TioStatService;
import org.tio.mg.service.service.tioim.TioUserService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.utils.resp.Resp;

/**
 * IM 统计管理控制器
 */
@RequestPath(value = "/stat")
public class TioStatController {

    private static Logger log = LoggerFactory.getLogger(TioStatController.class);

    private TioStatService statService = TioStatService.me;

    private TioUserService userService = TioUserService.me;

    private TioGroupService groupService = TioGroupService.me;

    private TioLoginService loginService = TioLoginService.me;

    /**
     * 用户总数
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/userCount")
    public Resp userCount(HttpRequest request) {
        Ret ret = userService.getUserCount(null);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 当日用户注册
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/userRegisterCount")
    public Resp userRegisterCount(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = userService.getUserCount(requestVo);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 当日用户登录
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/userLoginCount")
    public Resp userLoginCount(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = loginService.getLoginCount(requestVo);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 群组数量
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/userGroupCount")
    public Resp userGroupCount(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = groupService.getGroupCount(requestVo);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 用户注册统计
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/userRegisterStat")
    public Resp userRegisterStat(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        if (requestVo == null || requestVo.getType() == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = statService.userRegisterStat(requestVo);
        if (ret.isFail()) {
            log.error("获取用户统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 获取用户统计状态（1.注册  2.登录）
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/statUser")
    public Resp userLoginRegiestCount(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        if (requestVo == null || StrUtil.isEmpty(requestVo.getStartTime()) || StrUtil.isEmpty(requestVo.getEndTime()) || requestVo.getStatType() == null || requestVo.getStatPeriod() == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Kv params = Kv.by("startTime", requestVo.getStartTime())
                .set("endTime", requestVo.getEndTime())
                .set("statType", requestVo.getStatType())
                .set("statPeriod", requestVo.getStatPeriod());
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_STAT).getSqlPara("stat.statUser", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_STAT).paginate(1, 30, sqlPara);
        return Resp.ok(records.getList());
    }

    /**
     * 获取用户统计列表
     *
     * @param request
     * @param searchkey
     * @param pageNumber
     * @param pageSize
     * @return
     * @throws Exception
     * @author xufei
     * 2020年6月28日 下午4:30:22
     */
    @RequestPath(value = "/userstatlist")
    public Resp userstatlist(HttpRequest request, String searchkey, Integer pageNumber, Integer pageSize) throws Exception {
        Ret ret = statService.userStatList(pageNumber, pageSize, searchkey);
        if (ret.isFail()) {
            log.error("获取用户统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 群统计列表
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/groupList")
    public Resp groupList(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        if (requestVo == null || requestVo.getType() == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = statService.groupStat(requestVo);
        if (ret.isFail()) {
            log.error("获取用户统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 获取用户注册下的ip周期统计
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/userIpTimeRegisterStat")
    public Resp userIpTimeRegisterStat(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = statService.userIpTimeRegisterStat(requestVo);
        if (ret.isFail()) {
            log.error("获取用户ip下的时间统计列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }


    /**
     * 获取指定用户登录次数
     *
     * @param request
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/loginCountById")
    public Resp loginCountById(HttpRequest request, Integer uid) throws Exception {
        if (uid == null || uid < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = statService.userLoginCount(uid);
        if (ret.isFail()) {
            log.error("获取总登录次数：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 获取ip关联人数
     *
     * @param request
     * @param ip
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/ipRelateCount")
    public Resp ipRelateCount(HttpRequest request, String ip) throws Exception {
        if (StrUtil.isEmpty(ip)) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = statService.ipRegisterCount(ip);
        if (ret.isFail()) {
            log.error("获取ip注册次数：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 区域关联人数
     *
     * @param request
     * @param province
     * @param city
     * @return
     * @throws Exception
     * @author xufei
     * 2020年7月23日 下午5:24:04
     */
    @RequestPath(value = "/areaRelateCount")
    public Resp areaRelateCount(HttpRequest request, String province, String city) throws Exception {
        if (StrUtil.isEmpty(province) || StrUtil.isEmpty(city)) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = statService.areaRegisterCount(province, city);
        if (ret.isFail()) {
            log.error("获取区域注册次数：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 时间关联人数
     *
     * @param request
     * @param period
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/timeRelateCount")
    public Resp timeRelateCount(HttpRequest request, String period) throws Exception {
        if (StrUtil.isEmpty(period)) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = statService.timeRegisterCount(period);
        if (ret.isFail()) {
            log.error("获取时间注册次数：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 区域列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/areaList")
    public Resp areaList(HttpRequest request) throws Exception {
        Ret ret = statService.areadict();
        if (ret.isFail()) {
            log.error("获取区域字典失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkList(ret));
    }

}
