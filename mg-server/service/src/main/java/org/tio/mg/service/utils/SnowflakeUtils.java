/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.utils;

import org.tio.mg.service.init.PropInit;
import org.tio.utils.hutool.Snowflake;
import org.tio.utils.jfinal.P;

/**
 * 本类不能单独使用，需要系统初始化后才可使用
 * @author tanyaowu 
 * 2019年7月14日 下午5:48:45
 */
public class SnowflakeUtils {

	private static Snowflake snowflake;

	static {
		PropInit.init();
		int workerid = P.getInt("uuid.workerid");
		int datacenter = P.getInt("uuid.datacenter");
		snowflake = new Snowflake(workerid, datacenter);
	}

	public static long nextId() {
		return snowflake.nextId();
	}

}
