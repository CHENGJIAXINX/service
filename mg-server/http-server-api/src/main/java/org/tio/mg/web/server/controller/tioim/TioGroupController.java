package org.tio.mg.web.server.controller.tioim;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.service.tioim.TioGroupService;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.resp.Resp;

import java.util.Objects;

/**
 * 群管理
 */
@RequestPath(value = "/group")
public class TioGroupController {

    private Logger log = LoggerFactory.getLogger(TioGroupController.class);

    private TioGroupService groupService = TioGroupService.me;

    /**
     * 获取群列表
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/list")
    public Resp list(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = groupService.groupList(requestVo);
        if (ret.isFail()) {
            log.error("获取群列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 获取无效群列表
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/dellist")
    public Resp delList(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = groupService.delgroupList(requestVo);
        if (ret.isFail()) {
            log.error("获取群列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 群列表
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/alllist")
    public Resp allList(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = null;
        if (Objects.equals(requestVo.getType(), Const.Status.NORMAL)) {
            ret = groupService.groupList(requestVo);
        } else {
            ret = groupService.delgroupList(requestVo);
        }
        if (ret.isFail()) {
            log.error("获取群列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 消息模型下的群聊记录列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/recordList")
    public Resp recordList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = groupService.recordList(requestVo);
        if (ret.isFail()) {
            log.error("获取群列表(消息模型)失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 清除所有群聊消息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/clearAllMsg")
    public Resp clearAllMsg(HttpRequest request) throws Exception {
        Ret ret = groupService.cleanAllMsg();
        if (ret.isFail()) {
            log.error("清除群列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "群聊天记录清除",
                        MgConst.OperLogTypes.del,
                        "群聊天记录清除，id为" + RetUtils.getOkList(ret));
            }
        }).start();
        return Resp.ok("清除成功");
    }

    /**
     * 清除单个群聊消息
     *
     * @param request
     * @param id
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/clearMsg")
    public Resp clearMsg(HttpRequest request, Integer id) throws Exception {
        if (id == null || id < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = groupService.cleanMsg(id);
        if (ret.isFail()) {
            log.error("清除群消息列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "群聊天记录清除",
                        MgConst.OperLogTypes.del,
                        "群聊天记录清除，id为" + RetUtils.getOkList(ret));
            }
        }).start();
        return Resp.ok("清除成功");
    }

}
