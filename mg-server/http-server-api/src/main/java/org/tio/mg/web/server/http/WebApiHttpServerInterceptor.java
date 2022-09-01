package org.tio.mg.web.server.http;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.*;
import org.tio.http.common.session.HttpSession;
import org.tio.http.common.utils.HttpGzipUtils;
import org.tio.http.server.intf.HttpServerInterceptor;
import org.tio.http.server.util.Resps;
import org.tio.mg.service.cache.CacheConfig;
import org.tio.mg.service.cache.Caches;
import org.tio.mg.service.model.conf.Httpcache;
import org.tio.mg.service.model.main.IpInfo;
import org.tio.mg.service.model.main.UserAgent;
import org.tio.mg.service.model.mg.MgOperLog;
import org.tio.mg.service.model.mg.MgUser;
import org.tio.mg.service.model.stat.TioSlowRequest;
import org.tio.mg.service.service.base.IpInfoService;
import org.tio.mg.service.service.base.UserAgentService;
import org.tio.mg.service.service.conf.HttpcacheService;
import org.tio.mg.service.service.conf.IpWhiteListService;
import org.tio.mg.service.service.conf.MgConfService;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestExt;
import org.tio.mg.service.vo.SessionExt;
import org.tio.mg.web.server.utils.WebUtils;
import org.tio.sitexxx.servicecommon.vo.AppCode;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.RequestKey;
import org.tio.utils.SystemTimer;
import org.tio.utils.cache.ICache;
import org.tio.utils.jfinal.P;
import org.tio.utils.json.Json;
import org.tio.utils.lock.LockUtils;
import org.tio.utils.resp.Resp;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author tanyaowu
 * 2016年8月3日 下午1:27:05
 */
public class WebApiHttpServerInterceptor implements HttpServerInterceptor {

    private static Logger log = LoggerFactory.getLogger(WebApiHttpServerInterceptor.class);

    public static final WebApiHttpServerInterceptor ME = new WebApiHttpServerInterceptor();

    private final String httpCacheLockKey = this.getClass().getName() + ".httpCacheLockKey";

    private static final HeaderName HTTPCACHE_FLAG_HEADER_NAME = HeaderName.from("tio-httpcache-old");
    private static final HeaderName HTTPCACHE_FIRST_HEADER_NAME = HeaderName.from("tio-httpcache-new");
    private static final HeaderName HEADER_NAME_WEBAPI_SERVER = HeaderName.from("tio-webapi-server");
    private static final HeaderValue HEADER_VALUE_WHICH_API = HeaderValue.from(Const.MY_IP_API);
    private static final Object lockForGetLock = new Object();
    private static byte[] BODY_BYTES_NEED_ACCESS_TOKEN = null;

    private static boolean userHttpCache = P.getInt("web.api.use.http.cache", 1) == 1;

    /**
     * 白名单请求集合（无需检查token）
     */
    private static Set<String> pathWhiteSet;

    /**
     * 静态代码块中添加白名单path
     */
    static {
        pathWhiteSet = new HashSet<>();
        pathWhiteSet.add("/mgLogin");
        pathWhiteSet.add("/sys/params");
        pathWhiteSet.add("/common/file");
        pathWhiteSet.add("/conf");
        pathWhiteSet.add("/conf/getByName");
        pathWhiteSet.add("/stat");
    }

    /**
     * 是否是白名单路径
     *
     * @param path
     * @return { true: }
     */
    private static boolean isWhitePath(String path) {
//        if (path.startsWith("/")) { // 开发模式
        if (pathWhiteSet.contains(path)) { // TODO 打包时一定要修改
            return true;
        }
        return false;
    }

    @Override
    public HttpResponse doBeforeHandler(HttpRequest request, RequestLine requestLine, HttpResponse httpResponseFromCache) throws Exception {
        RequestExt requestExt = new RequestExt();
        request.setAttribute(RequestKey.REQUEST_EXT, requestExt);
        requestExt.setCanCache(false);

        String path = requestLine.getPath();

        // 获取请求方法
        Method method = requestLine.getMethod();
        String params = "";
        if (method == Method.GET) {
            params = Json.toJson(request.getParams());
        } else if (method == Method.POST) {
            params = request.getBodyString();
        }

        log.warn("请求URL：{};\n请求方式：{};\n请求IP：{};\n请求参数：\n{}", requestLine.getPathAndQuery(), method.toString(), request.getClientIp(), params);

        // 保存登录的ip信息
        IpInfo ipInfo = IpInfoService.ME.save(request.getClientIp());
        requestExt.setIpInfo(ipInfo);

        //从浏览器（Browser）过来的
        String userAgentStr = request.getUserAgent();
        UserAgent userAgent = UserAgentService.ME.save(userAgentStr);
        requestExt.setUserAgent(userAgent);
        requestExt.setFromBrowser(true);
        requestExt.setFromBrowserPc(true); //不是移动浏览器就是PC浏览器

        // 是否在白名单
        boolean isWhitePath = isWhitePath(path);

        if (!isWhitePath) {
            // 白名单权限控制
            boolean isWhiteIp = IpWhiteListService.isWhiteIp(request.getClientIp());

            // 是否开启accessToken验证
            int accessTokenOn = MgConfService.getInt("use.access.token.pc", 2);

            if (!isWhiteIp && accessTokenOn == 1) {
                //检查 MG_TIO_ACCESS_TOKEN
                Cookie cookie = request.getCookie(MgConst.AccessToken.COOKIENAME_FOR_ACCESSTOKEN);
                boolean needNewAccessToken = true;
                if (cookie != null && StrUtil.isNotBlank(cookie.getValue())) {
                    ICache cache2 = Caches.getCache(CacheConfig.MG_TIO_ACCESS_TOKEN);
                    String valueInCache = cache2.get(request.getHttpSession().getId(), String.class);
                    if (Objects.equals(cookie.getValue(), valueInCache)) {
                        needNewAccessToken = false;
                    }
                }
                if (needNewAccessToken) {
                    return Resps.bytesWithContentType(request, BODY_BYTES_NEED_ACCESS_TOKEN, MimeType.TEXT_PLAIN_JSON.getType());
                }
            }

            // 获取用户
            MgUser user = WebUtils.currUser(request);
            if (user == null) {
                HttpSession session = request.getHttpSession();
                SessionExt sessionExt = WebUtils.getSessionExt(session);
                MgOperLog loginLog = sessionExt.getKickedInfo();
                if (loginLog != null) {
                    String ip = loginLog.getOperip();
                    Date time = loginLog.getUpdatetime();
                    String deviceinfo = loginLog.getDeviceinfo();
                    String msg = "异地登录，您的帐号于" + DateUtil.formatDateTime(time) + "在" + ip + "登录过";
                    if (StrUtil.isNotBlank(deviceinfo)) {
                        msg += "，登录设备【" + deviceinfo + "】";
                    }
                    Resp resp = Resp.fail(msg).code(AppCode.ForbidOper.KICKTED);
                    return Resps.json(request, resp);
                } else {
                    Resp resp = Resp.fail("您尚未登录或登录超时").code(AppCode.ForbidOper.NOTLOGIN);
                    return Resps.json(request, resp);
                }
            }
        }
        requestExt.setCanCache(true);

        return doHttpCacheOnBeforeHandler(request, requestExt, path, httpCacheLockKey, userHttpCache);
    }

    public static HttpResponse doHttpCacheOnBeforeHandler(HttpRequest request, RequestExt requestExt, String path, String httpCacheLockKey, boolean userHttpCache) throws Exception {
        ICache cache = null;
        if (userHttpCache) {
            cache = HttpcacheService.getCache(path);
        }
        //在表中配了http缓存
        if (userHttpCache && cache != null) {
            Httpcache httpcache = HttpcacheService.get(path);
            if (httpcache != null) {
                String cacheKey = getHttpCacheKey(request, cache, httpcache);
                HttpResponse httpResponse = cache.get(cacheKey, HttpResponse.class);
                if (httpResponse != null) {
                    return cloneAnd304(request, requestExt, httpResponse);
                } else {
                    ReentrantReadWriteLock lock = LockUtils.getReentrantReadWriteLock(cacheKey, lockForGetLock);//(cacheKey);
                    WriteLock writeLock = lock.writeLock();
                    boolean tryWrite = writeLock.tryLock();
                    if (tryWrite) {
                        request.setAttribute(httpCacheLockKey, writeLock);
                        httpResponse = cache.get(cacheKey, HttpResponse.class);
                        if (httpResponse != null) {
                            return cloneAnd304(request, requestExt, httpResponse);
                        }
                        return null;
                    } else {
                        ReadLock readLock = lock.readLock();
                        boolean tryRead = readLock.tryLock(10, TimeUnit.SECONDS);
                        if (tryRead) {
                            request.setAttribute(httpCacheLockKey, readLock);
                            httpResponse = cache.get(cacheKey, HttpResponse.class);
                            if (httpResponse != null) {
                                return cloneAnd304(request, requestExt, httpResponse);
                            }
                            return null;
                        } else {
                            return null;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static HttpResponse cloneAnd304(HttpRequest request, RequestExt requestExt, HttpResponse httpResponse) {
        HttpResponse clone = HttpResponse.cloneResponse(request, httpResponse);
        requestExt.setFromCache(true);

        HeaderValue lastModified = clone.getLastModified();
        if (lastModified != null) {
            try {
                long _lastModified = Long.parseLong(lastModified.value);
                HttpResponse r304 = Resps.try304(request, _lastModified);
                if (r304 != null) {
                    r304.addHeader(HTTPCACHE_FLAG_HEADER_NAME, clone.getHeader(HTTPCACHE_FLAG_HEADER_NAME));
                    return r304;
                }
            } catch (NumberFormatException e) {
                return clone;
            }
        }
        return clone;
    }

    @Override
    public void doAfterHandler(HttpRequest request, RequestLine requestLine, HttpResponse response, long cost) throws Exception {
        RequestExt requestExt = WebUtils.getRequestExt(request);
        try {
        } catch (Exception e) {
            log.error(e.toString(), e);
        } finally {
            response.addHeader(HeaderName.Access_Control_Allow_Credentials, HeaderValue.TRUE);
            doHttpCacheOnAfterHandler(response, request, requestExt, requestLine.path, userHttpCache, httpCacheLockKey);
            WebApiHttpServerInterceptor.saveSlowRequest(request, requestLine, response, cost, (byte) 1);
        }
    }

    public static HttpResponse doHttpCacheOnAfterHandler(HttpResponse response, HttpRequest request, RequestExt requestExt, String path, boolean userHttpCache,
                                                         String httpCacheLockKey) {
        String cacheKey = null;
        try {
            if (requestExt.isFromCache()) {
                return response;
            }
            ICache cache = null;
            if (userHttpCache) {
                cache = HttpcacheService.getCache(path);
            }
            //在表中配了http缓存
            if (userHttpCache && cache != null) {
                Httpcache httpcache = HttpcacheService.get(path);
                if (httpcache != null) {
                    if (response != null) {
                        if (response.getStatus() == HttpResponseStatus.C200 && requestExt.isCanCache()) {
                            cacheKey = getHttpCacheKey(request, cache, httpcache);
                            HeaderValue headerValueCacheKey = HeaderValue.from(cacheKey);
                            HeaderValue lastModified = HeaderValue.from(SystemTimer.currTime + "");

                            response.setLastModified(lastModified);
                            HttpGzipUtils.gzip(request, response);

                            HttpResponse responseForCache = HttpResponse.cloneResponse(request, response);
                            responseForCache.addHeader(HTTPCACHE_FLAG_HEADER_NAME, headerValueCacheKey);
                            cache.put(cacheKey, responseForCache);

                            response.addHeader(HTTPCACHE_FIRST_HEADER_NAME, headerValueCacheKey);

                            response.addHeader(HEADER_NAME_WEBAPI_SERVER, HEADER_VALUE_WHICH_API);

                            return response;
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.toString(), e);
        } finally {
            try {
                Lock lock = (Lock) request.getAttribute(httpCacheLockKey);
                if (lock != null) {
                    if (path == null) {
                        path = request.requestLine.getPath();
                    }
                    log.info("httpcache释放锁【{}】, 这是正常日志. path:【{}】, cacheKey:{}", lock.getClass().getName(), path, cacheKey);
                    lock.unlock();
                }
            } catch (Exception e) {
                log.error(request.requestLine.toString(), e);
            }
        }
        return response;
    }

    public static void saveSlowRequest(HttpRequest request, RequestLine requestLine, HttpResponse response, long cost, byte type) {
        int slow_request_cost = MgConfService.getInt("slow_request_cost", 2000);
        if (cost >= slow_request_cost) {
            try {
                Date endtime = new Date();
                Date starttime = new Date(endtime.getTime() - cost);

                Integer uid = WebUtils.currUserId(request);

                String path = requestLine.getPathAndQuery();
                TioSlowRequest tioSlowRequest = new TioSlowRequest();
                tioSlowRequest.setType(type);
                tioSlowRequest.setCost(cost);
                tioSlowRequest.setPath(path);
                if (!Objects.equals("/register/submit", path)) {
                    tioSlowRequest.setBody(StrUtil.subPre(request.getBodyString(), 1024));
                }
                tioSlowRequest.setEndtime(endtime);
                tioSlowRequest.setStarttime(starttime);
                tioSlowRequest.setUid(uid);
                tioSlowRequest.setSession(request.getHttpSession().getId());

                tioSlowRequest.save();
            } catch (Exception e) {
                log.error(e.toString(), e);
            }
        }
    }

    /**
     * @param request
     * @param cache
     * @param httpcache
     * @return
     */
    private static String getHttpCacheKey(HttpRequest request, ICache cache, Httpcache httpcache) {
        Integer currUid = WebUtils.currUserId(request);
        Map<String, Object> params = null;
        String[] paramArray = httpcache.getParamArray();
        if (paramArray != null && paramArray.length > 0) {
            params = new HashMap<>();
            for (String name : paramArray) {
                String value = request.getParam(name);
                params.put(name, value);
            }
        }

        return getHttpCacheKey(currUid, params, cache, httpcache);
    }

    public static String getHttpCacheKey(Integer currUid, Map<String, Object> params, ICache cache, Httpcache httpcache) {
        String[] paramArray = httpcache.getParamArray();
        //		String[] cookieArray = httpcache.getCookieArray();
        boolean isUseUidAsKey = httpcache.isUseUidAsKey(); //是否使用userid作为cachekey
        boolean isUseLoginedAsKey = httpcache.isUseLoginedAsKey(); //是否使用登录状态作为cachekey

        StringBuilder key = new StringBuilder(30);
        if (isUseUidAsKey && currUid != null) {
            key.append("u{").append(currUid).append("}");
        }

        if (isUseLoginedAsKey) {
            if (currUid != null) {
                key.append("l{1}");
            } else {
                key.append("l{0}");
            }
        }

        if (paramArray != null && params != null) {
            key.append("p{");
            for (String name : paramArray) {
                Object value = params.get(name);
                if (value != null) {
                    key.append(name).append("=").append(value).append("&");
                }
            }
            key.append("}");
        }
        if (key.length() == 0) {
            return "t-io";
        } else {
            return key.toString();
        }
    }

    /**
     * @param path
     * @param params
     * @param currUid
     */
    public static void removeHttpCache(String path, Map<String, Object> params, Integer currUid) {
        ICache cache = HttpcacheService.getCache(path);
        if (cache != null) {
            Httpcache httpcache = HttpcacheService.get(path);
            if (httpcache != null) {
                if (httpcache.isHasPageNumber()) {
                    if (params == null) {
                        params = new HashMap<>();
                    }
                    for (int i = 0; i < 15; i++) {
                        params.put(Const.PARAM_NAME_PAGENUMBER, i);
                        String cacheKey = getHttpCacheKey(currUid, params, cache, httpcache);
                        cache.remove(cacheKey);
                    }
                } else {
                    String cacheKey = getHttpCacheKey(currUid, params, cache, httpcache);
                    cache.remove(cacheKey);
                }
            }
        }
    }

    /**
     * 清除缓存
     *
     * @param path
     */
    public static void clearHttpCache(String path) {
        ICache cache = HttpcacheService.getCache(path);
        if (cache != null) {
            cache.clear();
        }
//        ICache cache2 = Caches.getCache(CacheConfig.MG_TIO_ACCESS_TOKEN);
//        cache2.remove(request.getHttpSession().getId());
    }
}
