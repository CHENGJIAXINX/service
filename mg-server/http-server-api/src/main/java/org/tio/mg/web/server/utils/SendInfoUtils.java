package org.tio.mg.web.server.utils;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.mg.service.vo.MgConst;
import org.tio.sitexxx.servicecommon.vo.Const;

import java.util.HashMap;
import java.util.Map;

public class SendInfoUtils {

    private static Logger log = LoggerFactory.getLogger(SendInfoUtils.class);

    private static final String url = "http://127.0.0.1:6060/mytio/";
    private static final String TOKEN = MgConst.BsToken.TOKEN;

    public static void sendInfo(String path,Map param)throws Exception{
        param.put("token",TOKEN);
        String bsUrl = url+path+ Const.API_SUFFIX;
        HttpResponse execute = HttpUtil.createPost(bsUrl).body(JSONObject.toJSONString(param)).execute();
        log.warn("--------发送服务端通知--------\n地址：{};参数：{};\n返回信息：{}；",bsUrl,JSONObject.toJSONString(param),execute.body());
    }
}
