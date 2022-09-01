/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.utils;

import java.io.Serializable;

import org.tio.http.common.HttpRequest;
import org.tio.http.common.session.HttpSession;
import org.tio.sitexxx.service.cache.CacheConfig;
import org.tio.sitexxx.service.cache.Caches;
import org.tio.utils.cache.ICache;

/**
 * 给当前会话用的缓存
 * 一些数据的存活期不需要很长，就用这个来存取。
 * @author tanyaowu
 */
public class SessionCacheUtils {

	/**
	 * 
	 */
	private SessionCacheUtils() {

	}

	private static String key(HttpRequest request, String sessionKey) {
		HttpSession httpSession = request.getHttpSession();
		String sessionId = httpSession.getId();
		return sessionId + ".key." + sessionKey;
	}

	/**
	 * 
	 * @param request
	 * @param sessionKey
	 * @param value
	 */
	public static void put(HttpRequest request, String sessionKey, Serializable value) {
		String key1 = key(request, sessionKey);
		ICache cache = getCache();
		cache.put(key1, value);
	}

	/**
	 * 
	 * @param request
	 * @param sessionKey
	 * @author tanyaowu
	 */
	public static void remove(HttpRequest request, String sessionKey) {
		String key1 = key(request, sessionKey);
		ICache cache = getCache();
		cache.remove(key1);
	}

	/**
	 * 
	 * @param request
	 * @param sessionKey
	 * @return
	 */
	public static Serializable get(HttpRequest request, String sessionKey) {
		String key1 = key(request, sessionKey);
		ICache cache = getCache();
		Serializable ret = cache.get(key1);
		return ret;
	}

	private static ICache getCache() {
		return Caches.getCache(CacheConfig.SESSION_5_MINUTES);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
