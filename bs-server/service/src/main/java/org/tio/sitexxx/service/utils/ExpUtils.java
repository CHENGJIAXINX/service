/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpUtils {

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(ExpUtils.class);

	//	/**
	//	 * 缓存处理
	//	 * @param uid
	//	 * @param type
	//	 * @return
	//	 * 
	//	 */
	//	public static LevelRunnable getLevelRunnableByUidAndType(Integer uid,Byte type) {
	//		ICache expRunnableCaches = Caches.getCache(CacheConfig.EXP_DEAL_RUNNABLE);
	//		String key = Math.abs(uid.hashCode() % Const.LEVEL_THREAD_MAX_SIZE) + "_" + type;
	//		LevelRunnable levelRunnable = expRunnableCaches.get(key,LevelRunnable.class);
	//		if(levelRunnable == null) {
	//			synchronized (log) {
	//				levelRunnable = expRunnableCaches.get(key,LevelRunnable.class);
	//				if(levelRunnable == null) {
	//					levelRunnable = new LevelRunnable(Threads.levelExecutor, type);
	//					expRunnableCaches.put(key, levelRunnable);
	//				}
	//			}
	//		}
	//		return levelRunnable;
	//	}

}
