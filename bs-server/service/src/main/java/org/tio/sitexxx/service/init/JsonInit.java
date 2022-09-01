/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.init;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.JfinalRecordSerializer;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.sitexxx.service.json.IpInfoSerializeFilter;
import org.tio.sitexxx.service.json.UserSerializeFilter;
import org.tio.sitexxx.service.model.main.IpInfo;
import org.tio.sitexxx.service.model.main.User;
import org.tio.utils.json.Json;

import com.alibaba.fastjson.serializer.ToStringSerializer;

/**
 * @author tanyaowu
 * 2016年8月18日 下午4:52:28
 */
public class JsonInit {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(JsonInit.class);

	public static void init() {
		Json.put(User.class, UserSerializeFilter.me);
		Json.put(IpInfo.class, IpInfoSerializeFilter.ME);
		Json.put(Record.class, JfinalRecordSerializer.me);
		
		
		Json.put(BigInteger.class, ToStringSerializer.instance);
		Json.put(Long.class, ToStringSerializer.instance);
		Json.put(Long.TYPE, ToStringSerializer.instance);
	}
}
