/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.hutool.core.util.RandomUtil;

/**
 * @author tanyaowu 
 * 2019年7月21日 上午11:20:15
 */
public class IpUtils {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(IpUtils.class);

	/**
	 * 
	 * @author tanyaowu
	 */
	public IpUtils() {
		

	}
	
	public static String randomIp() {
		String ip = RandomUtil.randomInt(2, 100) + "." + RandomUtil.randomInt(2, 100) + "." + RandomUtil.randomInt(2, 100) + "." + RandomUtil.randomInt(2, 100);
		return ip;
	}

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}
}
