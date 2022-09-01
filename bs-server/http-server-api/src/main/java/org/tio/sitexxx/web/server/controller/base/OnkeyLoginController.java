package org.tio.sitexxx.web.server.controller.base;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.annotation.RequestPath;
import org.tio.http.server.util.Resps;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.utils.resp.Resp;

import java.util.HashMap;
import java.util.Map;

@RequestPath(value = "/onkeyLogin")
public class OnkeyLoginController {

    private UserService userService = UserService.ME;

    @RequestPath(value = "/onkeyLogin")
    public HttpResponse login(String token, String appKey, HttpRequest request) throws Exception {

        if (token == null || appKey == null){
            return Resps.json(request, Resp.fail("缺少参数"));
        }

        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        String post = HttpUtil.post("https://verify5.market.alicloudapi.com/api/v1/mobile/info?appkey=" + appKey, JSON.toJSONString(map));
        JSONObject jsonObject = JSONObject.parseObject(post);
        if (!jsonObject.getBoolean("success")){
            return Resps.json(request, Resp.fail(jsonObject.getString("message")));
        }
        String mobile = jsonObject.getJSONObject("data").getString("mobile");
        if (mobile == null){
            return Resps.json(request, Resp.fail("解析手机号码失败"));
        }
        User byLoginname = userService.getByLoginname(mobile, null);
        if (byLoginname == null){
            //未注册用户，让用户设置用户名，然后调（新增 注册+登录一体化）接口
        }else {
            //接口登录，走正常登录流程
        }

        return null;
    }


    public static void main(String[] args) {
        String token = "eyJjIjoiWW9qQW50cEVISEVqM2VrXC9jSCtBSVk3WXd0SmpVUDhjZFFrRTlWKytBUFwvYjJOYkppKzlIR1BHU01QeTRKdkZGQjhnZlNUcnNIeEQyXG4rRWQrXC83UnNLanRydDBNMnk1cFhtNGpHeU8wdnNBNGJNSWNLZ2hjK21CenpMMVJPWDIrMFVHeGlUSDNJUitKOERQUFVsSmJuTEtOTFxuSUFaeStFdFFpTFNkTkpKeTJjU0VIUnk3VHFNU3Z4akY2K2hTZ0IzUWNjOUxCOTMwb1gzaTdoZ0xHbTRycXg1enJsUTBXM2VUTFJWM1xuZzJsTWl4dnZIamc4d2JLSDNLdXZHSzNnZVlEQUo5cXYwOHU1RU4rNEFwZFRNbWsrVlVBekUxNmFTRjVQdDJIenlqZlBxdTFqSDYrR1xuUXVjZWZMeXYyZ3FEZE12bnJnMEx5RzdQZVVUc2txTThZMFhrQ2lmZlNmZGlpb3dLb25hMXJYZFczVGF6UmdtbUhSN2s0V1dPUXNGeVxuQUdscGErKzNxa2RLUGVSRmFEK3VvR01oOXR3UnRvbmk0RE8reVwvRFQyQUEydEQ5Ykdlck04d0xGa0N6cmJcL216OXpTRHZ1a01hZllEXG5VXC8zckRDM3VVWFhJV2l4UEJEWitoZjlNXC9yXC9xZU5QakRFcVJyVzZ1MnJFOXZrQURlUnI0SWE1MnBUaGwrUTd4QlNrdUlpdXlQb3B0XG5tc1wvU29GcU5FdGdYcjRiZzMwUCttSGUxejlldHhHOTFXYzhiQ1wvSlwvU1dIR0pCdVhOUVhxMko1b1NJc0dhM1d5Q3c9PVxuIiwiayI6IkF2RDdGRlUyUVpTbDg0VENESDk5RGhZdEdyZ2hMVUdIaExTK1lMcjlGVllEQ203VnU3aGZ1dG9WelFnamYwZE80bnhsRHJsUVFmXC9oTFwvRkVUcDcwVFNHblhLTk1xQWcwY3NhNkVuUWtTV28yc2JoWndZMGprUlpLU2NmUzg4VUZOXC9paElRc0g2SlVpSWFpejdYbEl6Y2l2clwvRDNyR2tJcUZmN0JMeng1ZHhKeXVaYUs1cWo2MWxPYnU0ZWVFejBzMDlleklWUjJyUG1OTjN0NEphMVM5TzNvM290b0NwMmJvYm00bmFmcGJrRVwvbmhcL1pWWGUxTVE1RU1BYzhLeXFSYzFJcVV5OWt2WUNTVjlPNGxaSlwvMnRwMXh3UlpBMFZYNDdjRjB4T1o0MVpnZ2s0YjV4VlowNzE3T2JWbGdITjU4WTdOQ1dkNGJoU3YwOFFEcFhjbWc9PSIsIm8iOiJBbmRyb2lkIn0";
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        String post = HttpUtil.post("http://verify5.market.alicloudapi.com/api/v1/mobile/info?appCode=fe1a9ba7bdae483dbeb482b2ac333eca&appkey=" + "60583f8db8c8d45c13a99bdb", JSON.toJSONString(map));
        System.out.println("result===>"+post);
    }
}
