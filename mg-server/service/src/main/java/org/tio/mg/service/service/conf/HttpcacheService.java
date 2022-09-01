/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.service.conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.mg.service.model.conf.Httpcache;
import org.tio.utils.cache.ICache;
import org.tio.utils.cache.caffeine.CaffeineCache;
import org.tio.utils.lock.LockUtils;

import cn.hutool.core.util.StrUtil;

/**
 * Httpcache配置信息加载
 * @author tanyaowu
 *
 */
public class HttpcacheService {
	private static Logger						log				= LoggerFactory.getLogger(HttpcacheService.class);
	private static final String					cacheNamePrefix	= "tiosite_httpcache_";
	public static final HttpcacheService		me				= new HttpcacheService();
	final static Httpcache						dao				= new Httpcache().dao();
	/**
	 * key: path, value: Httpcache
	 */
	private static Map<String, Httpcache>		map				= null;
	private static List<Httpcache>				list			= null;
	/**
	 * key: path, value: CaffeineCache
	 */
	private static Map<String, CaffeineCache>	pathCacheMap	= null;

	/**
	 *
	 */
	public static void clearCache() {
		synchronized (HttpcacheService.class) {
			map = null;
			list = null;
		}
	}

	/**
	 *
	 * @return
	 */
	private static List<Httpcache> selectAll() {
		List<Httpcache> list1 = dao.find("select * from httpcache where status = 1"); //"select * from httpcache where status = 1"
		if (list1 != null) {
			for (Httpcache httpcache : list1) {
				String path = httpcache.getPath();
				if (!StrUtil.startWith(path, "/")) {
					path += "/" + path;
				}
				String params = httpcache.getParams();
				if (StrUtil.isNotBlank(params)) {
					String[] paramArray = StrUtil.split(params, ",");
					StrUtil.trim(paramArray);
					httpcache.setParamArray(paramArray);
				}
				String cookies = httpcache.getCookies();
				if (StrUtil.isNotBlank(cookies)) {
					String[] cookieArray = StrUtil.split(cookies, ",");
					StrUtil.trim(cookieArray);
					httpcache.setCookieArray(cookieArray);
				}
				Byte uid = httpcache.getUid();
				boolean useUidAsKey = Objects.equals(uid, (byte) 1); //是否使用userid作为cachekey
				httpcache.setUseUidAsKey(useUidAsKey);

				Byte login = httpcache.getLogin();
				boolean useLoginedAsKey = Objects.equals(login, (byte) 1);
				httpcache.setUseLoginedAsKey(useLoginedAsKey);

				String metaClass = httpcache.getMetaclass();
				if (StrUtil.isNotBlank(metaClass)) {
					try {
						Object httpCacheMeta = Class.forName(metaClass).newInstance();
						httpcache.setHttpCacheMeta(httpCacheMeta);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
						log.error(e.toString(), e);
					}
				}
			}
		}
		list = list1;
		return list;
	}

	/**
	 *
	 * @return
	 */
	public static List<Httpcache> getAll() {
		if (list == null) {
			loadData();
		}
		return list;
	}

	/**
	 *
	 */
	private static void loadData() {
		try {
			LockUtils.runWriteOrWaitRead(HttpcacheService.class.getName(), HttpcacheService.class, () -> {
//				@Override
//				public void read() {
//				}

//				@Override
//				public void write() {
					if (list == null) {
						Map<String, Httpcache> map1 = new HashMap<>();
						Map<String, CaffeineCache> pathCacheMap1 = new HashMap<>();
						try {
							List<Httpcache> list = selectAll();
							if (list != null) {
								for (Httpcache httpcache : list) {
									String path = httpcache.getPath();
									map1.put(path, httpcache);
									Long timeToLiveSeconds = httpcache.getExpireafterwrite();
									Long timeToIdleSeconds = httpcache.getExpireafteraccess();
									CaffeineCache caffeineCache = CaffeineCache.getCache(cacheNamePrefix + path, true);
									if (caffeineCache == null) {
										caffeineCache = CaffeineCache.register(cacheNamePrefix + path, timeToLiveSeconds, timeToIdleSeconds);
									}
									pathCacheMap1.put(path, caffeineCache);
								}
							}
						} catch (Exception e) {
							log.error(e.getMessage(), e);
						}
						map = map1;
						pathCacheMap = pathCacheMap1;
					}
//				}

			});
		} catch (Exception e) {
			log.error(e.toString(), e);
		}

	}

	/**
	 * 根据path获取Httpcache对象
	 * @param path 形如：/user/xx
	 * @return
	 */
	public static Httpcache get(String path) {
		if (map == null) {
			loadData();
		}
		Httpcache value = map.get(path);
		return value;
	}

	/**
	 *
	 * @param path 形如：/user/xx
	 * @return
	 */
	public static ICache getCache(String path) {
		if (pathCacheMap == null) {
			loadData();
		}
		ICache value = pathCacheMap.get(path);
		return value;
	}
}
