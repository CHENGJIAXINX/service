/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.cache;

/**
 * @author tanyaowu
 * 2016年8月16日 上午10:22:25
 */
public enum CacheType {

	REDIS(), CAFFEINE(), CAFFEINE_REDIS();

	private CacheType() {
	}
}
