package org.tio.mg.web.server.controller.tioim;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.service.tioim.TioMsgService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.RequestVo;
import org.tio.utils.resp.Resp;

/**
 * 消息管理控制器
 */
@RequestPath(value = "/tiomsg")
public class TioMsgController {

    private Logger log = LoggerFactory.getLogger(TioMsgController.class);

    private TioMsgService msgService = TioMsgService.me;

    /**
     * 模型下私聊消息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/singleList")
    public Resp singleList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = msgService.p2pList(requestVo);
        if (ret.isFail()) {
            log.error("获取私聊消息列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 模型下的群消息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/groupList")
    public Resp groupList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = msgService.groupList(requestVo);
        if (ret.isFail()) {
            log.error("获取群聊消息列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }
}
