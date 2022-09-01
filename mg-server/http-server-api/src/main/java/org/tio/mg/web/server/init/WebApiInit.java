package org.tio.mg.web.server.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpConfig;
import org.tio.http.common.HttpResponse;
import org.tio.http.common.session.id.impl.SnowflakeSessionIdGenerator;
import org.tio.http.server.HttpServerStarter;
import org.tio.http.server.handler.DefaultHttpRequestHandler;
import org.tio.http.server.mvc.Routes;
import org.tio.http.server.session.DomainSessionCookieDecorator;
import org.tio.http.server.stat.ip.path.IpPathAccessStats;
import org.tio.http.server.stat.token.TokenPathAccessStats;
import org.tio.mg.service.init.PropInit;
import org.tio.mg.service.init.RedisInit;
import org.tio.mg.service.tio.TioSiteIpStatListener;
import org.tio.mg.web.server.WebApiRoot;
import org.tio.mg.web.server.http.TioSiteThrowableHandler;
import org.tio.mg.web.server.http.WebApiHttpServerInterceptor;
import org.tio.mg.web.server.http.WebApiHttpSessionListener;
import org.tio.mg.web.server.http.WebApiSessionRateLimiter;
import org.tio.mg.web.server.http.stat.TioSiteStatPathFilter;
import org.tio.mg.web.server.http.stat.ip.TioSiteIpPathAccessStatListener;
import org.tio.mg.web.server.http.stat.token.TioSiteCurrUseridGetter;
import org.tio.mg.web.server.http.stat.token.TioSiteTokenGetter;
import org.tio.mg.web.server.http.stat.token.TioSiteTokenPathAccessStatListener;
import org.tio.server.ServerTioConfig;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.Const.TokenPathAccessStatDuration;
import org.tio.utils.Threads;
import org.tio.utils.cache.caffeineredis.CaffeineRedisCache;
import org.tio.utils.jfinal.P;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

/**
 * @author tanyaowu
 * 2016年7月19日 下午4:59:04
 */
public class WebApiInit {
    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(WebApiInit.class);
    public static HttpServerStarter httpServerStarter;
    public static ServerTioConfig serverTioConfig;
    public static HttpConfig httpConfig;
    public static Routes routes;
    public static DefaultHttpRequestHandler requestHandler;
    public static SnowflakeSessionIdGenerator sessionIdGenerator = null;

    public static void init() throws Exception {
        PropInit.init();

        //【【------------ 设置 httpconfig start ------------------
        //监听端口
        int port = P.getInt("http.api.port");
        //session超时时间
        long sessionTimeout = P.getLong("http.session.timeout", HttpConfig.DEFAULT_SESSION_TIMEOUT);
        String contextpath = Const.API_CONTEXTPATH;
        String suffix = Const.API_SUFFIX;
        httpConfig = new HttpConfig(port, sessionTimeout, contextpath, suffix);
        httpConfig.setSessionCacheName(P.get("http.session.cache.name", HttpConfig.SESSION_CACHE_NAME));

        Integer maxLiveTimeOfStaticRes = P.getInt("http.maxLiveTimeOfStaticRes");
        if (maxLiveTimeOfStaticRes != null) {
            httpConfig.setMaxLiveTimeOfStaticRes(maxLiveTimeOfStaticRes);
        }
        // 上传时，允许的最大长度，单位：KB
        Integer max_length_of_multi_body = P.getInt("http.max_length_of_multi_body");
        if (max_length_of_multi_body != null) {
            httpConfig.setMaxLengthOfMultiBody(max_length_of_multi_body * 1024);
        }
        // POST时，允许的最大长度，单位：KB
        Integer max_length_of_post_body = P.getInt("http.max_length_of_post_body");
        if (max_length_of_post_body != null) {
            httpConfig.setMaxLengthOfPostBody(max_length_of_post_body * 1024);
        }
        //分布式环境中，用于高效生成uuid的
        int workerid = P.getInt("uuid.workerid");
        int datacenter = P.getInt("uuid.datacenter");
        sessionIdGenerator = new SnowflakeSessionIdGenerator(workerid, datacenter);//更高效的Snowflake sessionId生成器，取代默认的sessionId生成器
        httpConfig.setSessionIdGenerator(sessionIdGenerator);
        httpConfig.setAppendRequestHeaderString(true);

        httpConfig.setPage500(P.get("http.api.page500", "/500.html"));
        httpConfig.setPage404(P.get("http.api.page404", "/404.html"));

        httpConfig.setSessionCookieName(Const.Http.SESSION_COOKIE_NAME);

        //html/css/js等的根目录，支持classpath:，也支持绝对路径
        String pageRoot = P.get("http.api.page", null);
        httpConfig.setPageRoot(pageRoot);

        //用于存储HttpSession对象
        CaffeineRedisCache caffeineRedisCache = CaffeineRedisCache.register(RedisInit.get(), httpConfig.getSessionCacheName(), null, sessionTimeout);
        //		CaffeineCache caffeineRedisCache = CaffeineCache.register(httpConfig.getSessionCacheName(), null, sessionTimeout);
        httpConfig.setSessionStore(caffeineRedisCache);
        httpConfig.setProxied(P.getBoolean("http.isproxied", false));

        byte[] bs = Json.toJson(Resp.fail("Your IP is on the blacklist")).getBytes();
        httpConfig.setRespForBlackIp(new HttpResponse(null, bs));
        httpConfig.setSessionRateLimiter(WebApiSessionRateLimiter.me);

        //------------ 设置 httpconfig end ------------------】】

        //【【------------ 设置 Routes start ------------------

        String[] scanPackages = new String[]{WebApiRoot.class.getPackage().getName()};//tio-mvc需要扫描的根目录包
        routes = new Routes(scanPackages);
        //------------ 设置 Routes end ------------------】】

        //【【------------ 设置 DefaultHttpRequestHandler start ------------------
        requestHandler = new DefaultHttpRequestHandler(httpConfig, routes);
        requestHandler.setCompatibilityAssignment(false);

        requestHandler.setHttpServerInterceptor(WebApiHttpServerInterceptor.ME);
        requestHandler.setHttpSessionListener(WebApiHttpSessionListener.ME);

        String cookieDomain = P.get("http.cookie.domain"); // 形如: ".baidu.com"
        DomainSessionCookieDecorator domainSessionCookieDecorator = new DomainSessionCookieDecorator(cookieDomain);
        requestHandler.setSessionCookieDecorator(domainSessionCookieDecorator);

        requestHandler.setThrowableHandler(TioSiteThrowableHandler.ME);
        //------------ 设置 DefaultHttpRequestHandler end ------------------】】

        httpConfig.setName("Web-Api");
        //创建HttpServerStarter
        httpServerStarter = new HttpServerStarter(httpConfig, requestHandler, Threads.getTioExecutor(), Threads.getGroupExecutor());
        httpServerStarter.getTioServer().setCheckLastVersion(P.getBoolean("tio.setCheckLastVersion", false));

        serverTioConfig = httpServerStarter.getServerTioConfig();
        serverTioConfig.logWhenDecodeError = P.getBoolean("http.api.logWhenDecodeError", false);
        serverTioConfig.setName("Tio-Site Api HttpServer");
        serverTioConfig.setReadBufferSize(P.getInt("http.api.readbuffersize", 20480));
        serverTioConfig.setIpStatListener(TioSiteIpStatListener.web_api);
        serverTioConfig.ipStats.addDurations(Const.IpStatDuration.IPSTAT_DURATIONS);

        //		serverTioConfig.ipStats.addDurations(Const.IpStatDuration.IPSTAT_DURATIONS, TioSiteIpStatListener.web);

        boolean isWebApiUseSsl = P.getInt("web.api.use.ssl", 2) == 1;
        if (isWebApiUseSsl) {
            String keyStoreFile = P.get("ssl.keystore", null);
            String trustStoreFile = P.get("ssl.truststore", null);
            String keyStorePwd = P.get("ssl.pwd", null);
            serverTioConfig.useSsl(keyStoreFile, trustStoreFile, keyStorePwd);
        }

        IpPathAccessStats ipPathAccessStats = new IpPathAccessStats(TioSiteStatPathFilter.me, serverTioConfig, TioSiteIpPathAccessStatListener.ME_SITE_API,
                Const.IpPathAccessStatDuration.IP_PATH_ACCESS_STAT_DURATIONS);
        requestHandler.setIpPathAccessStats(ipPathAccessStats);

        TokenPathAccessStats tokenPathAccessStats = new TokenPathAccessStats(TioSiteStatPathFilter.me, TioSiteTokenGetter.me, TioSiteCurrUseridGetter.me, serverTioConfig,
                TioSiteTokenPathAccessStatListener.ME_SITE_API, TokenPathAccessStatDuration.TOKEN_PATH_ACCESS_STAT_DURATIONS);
        requestHandler.setTokenPathAccessStats(tokenPathAccessStats);

        HttpcacheInit.init(routes);

        //启动httpserver
        httpServerStarter.start();
    }
}
