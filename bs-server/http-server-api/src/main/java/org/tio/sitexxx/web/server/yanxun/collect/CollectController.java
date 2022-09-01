package org.tio.sitexxx.web.server.yanxun.collect;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.sitexxx.service.model.main.YxCollect;
import org.tio.sitexxx.service.service.yanxun.collect.CollectService;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zlb
 */
@RequestPath("/collect")
public class CollectController {

    private static Logger log = LoggerFactory.getLogger(CollectController.class);

    public static final CollectService collectService = CollectService.me;
    /**
     *
     * @param request
     * @param  0-表情收藏
     * @return
     */
    @RequestPath(value = "/addEmotion")
    public Resp addEmotion(HttpRequest request, String url, int width, int height){
        Integer userId = WebUtils.currUserId(request);
        if (userId == null){
            return Resp.fail("未登录或登录超时");
        }
        YxCollect collect = new YxCollect();
        collect.setUserId(userId);
        collect.setCollectType(0);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", url);
        jsonObject.put("width", width);
        jsonObject.put("height", height);
        collect.setContent(jsonObject.toJSONString());
        if (collect.save()){
            return Resp.ok("收藏成功");
        }
        return Resp.fail("收藏失败");
    }

    @RequestPath(value = "/emotionList")
    public Resp emotionList(HttpRequest request){
        Integer userId = WebUtils.currUserId(request);
        if (userId == null){
            return Resp.fail("未登录或登录超时");
        }
        List<YxCollect> yxCollects = collectService.queryList(0, userId);
        Map<String, Object> map = new HashMap<>();
        map.put("count", yxCollects.size());
        map.put("data", yxCollects);
        return Resp.ok(map);
    }
    @RequestPath(value = "/deleteEmotion")
    public Resp deleteEmotion(HttpRequest request, Integer emotionId){
        Integer userId = WebUtils.currUserId(request);
        if (userId == null){
            return Resp.fail("未登录或登录超时");
        }
        collectService.deleteCollect(emotionId);
        return Resp.ok();
    }
}
