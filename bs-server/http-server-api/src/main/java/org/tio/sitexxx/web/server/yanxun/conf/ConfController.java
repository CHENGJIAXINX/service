package org.tio.sitexxx.web.server.yanxun.conf;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.sitexxx.im.server.handler.wx.WxChatApi;
import org.tio.utils.resp.Resp;

import java.util.List;

@RequestPath(value = "/conf")
public class ConfController {
    private static Logger log = LoggerFactory.getLogger(ConfController.class);

    @RequestPath(value = "/sendMsgInfo")
    public Resp sendMsgInfo(HttpRequest request, Integer type, String token, List<Integer> ids){
        log.warn("收到来自后台的通知：\n地址：{}；\n参数：{}",request.getRequestLine().getPath(), JSONObject.toJSONString(request.getParams()));
        WxChatApi.sendAdminDelMsg(type,ids);
        return null;
    }

}
