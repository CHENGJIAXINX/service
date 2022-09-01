package org.tio.mg.web.server.controller.tioim;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.service.tioim.TioFriendService;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.utils.resp.Resp;

import java.util.HashMap;
import java.util.Map;

/**
 * 好友聊天管理控制器
 */
@RequestPath(value = "/friend")
public class TioFriendController {

    private Logger log = LoggerFactory.getLogger(TioFriendController.class);

    private TioFriendService friendService = TioFriendService.me;

    /**
     * 消息模型下的好友列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/recordList")
    public Resp recordList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = friendService.recordList(requestVo);
        if (ret.isFail()) {
            log.error("获取好友列表(消息模型)失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 清除所有聊天记录
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/clearAllMsg")
    public Resp clearAllMsg(HttpRequest request) throws Exception {
        Ret ret = friendService.cleanAllMsg();
        if (ret.isFail()) {
            log.error("清除好友列表(消息模型)失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "聊天记录清除",
                        MgConst.OperLogTypes.del,
                        "聊天记录清除，id为" + RetUtils.getOkList(ret));
            }
        }).start();
        return Resp.ok("清除成功");
    }

    /**
     * 清除单个聊天记录
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
        Ret ret = friendService.cleanMsg(id);
        if (ret.isFail()) {
            log.error("清除好友消息列表(消息模型)失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "好友聊天记录清除",
                        MgConst.OperLogTypes.del,
                        "清除的会话id" + id);
            }
        }).start();
        return Resp.ok("清除成功");
    }

}
