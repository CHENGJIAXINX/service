/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.intf.TioUuid;

import cn.hutool.core.lang.Snowflake;

/**
 * @author tanyaowu
 * 2016年6月5日 上午10:44:26
 */
public class ImTioUuid implements TioUuid {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(ImTioUuid.class);

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

	//	private long workerId;
	//	private long datacenterId;
	//
	private Snowflake snowflake;

	/**
	 *
	 * @author tanyaowu
	 */
	public ImTioUuid(long workerId, long datacenterId) {
		snowflake = new Snowflake(workerId, datacenterId);
	}

	/**
	 * @return
	 * @author tanyaowu
	 */
	@Override
	public String uuid() {
		return snowflake.nextId() + "";
	}
}
