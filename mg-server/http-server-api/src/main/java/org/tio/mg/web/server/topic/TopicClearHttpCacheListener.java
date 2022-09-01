/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.mg.web.server.topic;

import java.util.Map;

import org.redisson.api.listener.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.mg.web.server.http.WebApiHttpServerInterceptor;
import org.tio.sitexxx.servicecommon.vo.ClearHttpCache;
import org.tio.utils.json.Json;

import cn.hutool.core.util.StrUtil;

/**
 * @author tanyaowu
 *
 */
public class TopicClearHttpCacheListener implements MessageListener<ClearHttpCache> {
    private static Logger log = LoggerFactory.getLogger(TopicClearHttpCacheListener.class);

    public static final TopicClearHttpCacheListener me = new TopicClearHttpCacheListener();

    /**
     *
     */
    public TopicClearHttpCacheListener() {
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
    }

    @Override
    public void onMessage(CharSequence channel, ClearHttpCache clearHttpCache) {
        String path = clearHttpCache.getPath();
        if (StrUtil.isBlank(path)) {
            return;
        }
        int clearType = clearHttpCache.getClearType();
        if (clearType == ClearHttpCache.ClearType.CLEAR) {
            WebApiHttpServerInterceptor.clearHttpCache(path);
        } else {
            Map<String, Object> param = clearHttpCache.getParam();
            Integer userid = clearHttpCache.getUserid();

            WebApiHttpServerInterceptor.removeHttpCache(path, param, userid);
        }

        if (log.isInfoEnabled()) {
            log.info("收到通知，已经清除httpcache[{}], clearHttpCache:{}", path, Json.toJson(clearHttpCache));
        }
    }

}
