package org.tio.mg.web.server.http;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HeaderName;
import org.tio.http.common.HeaderValue;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.common.session.limiter.SessionRateLimiter;
import org.tio.http.common.session.limiter.SessionRateVo;
import org.tio.mg.service.service.conf.IpWhiteListService;
import org.tio.sitexxx.servicecommon.vo.AppCode;
import org.tio.utils.SystemTimer;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WebApiSessionRateLimiter implements SessionRateLimiter {
    private static Logger log = LoggerFactory.getLogger(WebApiSessionRateLimiter.class);

    public static final WebApiSessionRateLimiter me = new WebApiSessionRateLimiter();

    /**
     * key:   访问路径<br>
     * value: 相邻两次访问必须间隔的最小时间，单位：毫秒<br>
     */
    private final Map<String, Integer> intervalMap = new HashMap<>();

    /**
     * key:   访问路径的前缀<br>
     * value: 相邻两次访问必须间隔的最小时间，单位：毫秒<br>
     */
    private final Map<String, Integer> prefixMap = new HashMap<>();

    /**
     * 每分钟允许访问的次数
     */
    private final Map<String, Integer> allowCountMap = new HashMap<>();

    private HttpResponse response;

    private WebApiSessionRateLimiter() {
        prefixMap.put("/product/download/", 1000 * 120);
        allowCountMap.put("/tiomsg/groupmodelist", 9999);
        allowCountMap.put("/tiouser/statlist", 9999);
        allowCountMap.put("/tiomsg/grouplist", 9999);
        allowCountMap.put("/friend/fdlist", 9999);
        allowCountMap.put("/tiomsg/p2plist", 9999);
        response = new HttpResponse();
        try {
            response.setBody(Json.toJson(Resp.fail("小兄Dei，你的手速有点快，单身多少年了？").code(AppCode.ForbidOper.REFUSE)).getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            log.error(e.toString(), e);
        }
        response.addHeader(HeaderName.Content_Type, HeaderValue.Content_Type.TEXT_PLAIN_JSON);
    }

    @Override
    public boolean allow(HttpRequest request, SessionRateVo sessionRateVo) {
        if (IpWhiteListService.isWhiteIp(request.getClientIp())) {
            return true;
        }

        String path = request.getRequestLine().getPath();

        Integer allowCount = allowCountMap.get(path);
        if (allowCount == null) {
            allowCount = 120;
        }
        if (sessionRateVo.getAccessCount().get() > allowCount) {
            return false;
        }

        Integer iv = intervalMap.get(path);
        if (iv == null) {
            if (prefixMap.size() > 0) {
                Set<Entry<String, Integer>> set = prefixMap.entrySet();
                for (Entry<String, Integer> entry : set) {
                    if (StrUtil.startWith(path, entry.getKey())) {
                        iv = entry.getValue();
                        break;
                    }
                }
            }
        }

        if (iv != null) {
            if (SystemTimer.currTime - sessionRateVo.getLastAccessTime() < iv) {
                return false;
            }
        }

        return true;
    }

    @Override
    public HttpResponse response(HttpRequest request, SessionRateVo sessionRateVo) {
        return response;
        //		return Resps.json(request, Resp.fail("小兄Dei，你的手速有点快，单身多少年了？").code(AppCode.ForbidOper.REFUSE));
    }

}
