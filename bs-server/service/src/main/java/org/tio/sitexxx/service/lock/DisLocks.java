/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.service.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import org.redisson.api.RedissonClient;
import org.tio.sitexxx.service.init.RedisInit;

/**
 * 分布式锁
 * @author tanyaowu
 *
 */
public class DisLocks {

	/**
	 * 
	 */
	public DisLocks() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Lock getLock(String name) {
		RedissonClient redisson = RedisInit.get();
		return redisson.getLock(name);
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public static ReadWriteLock getReadWriteLock(String name) {
		RedissonClient redisson = RedisInit.get();
		return redisson.getReadWriteLock(name);
	}

}
