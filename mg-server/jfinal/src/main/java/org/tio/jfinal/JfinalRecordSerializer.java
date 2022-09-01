/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.jfinal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import org.tio.jfinal.plugin.activerecord.Record;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

/**
 * @author tanyaowu
 * 2017年8月20日 上午8:49:05
 */
public class JfinalRecordSerializer implements ObjectSerializer {
	public static final JfinalRecordSerializer me = new JfinalRecordSerializer();

	/**
	 *
	 * @author tanyaowu
	 */
	public JfinalRecordSerializer() {
	}

	/**
	 * @param serializer
	 * @param object
	 * @param fieldName
	 * @param fieldType
	 * @param features
	 * @throws IOException
	 * @author tanyaowu
	 */
	@Override
	public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
		if (object == null) {
			serializer.out.writeNull();
			return;
		}

		Record record = (Record) object;

		Map<String, Object> map = record.getColumns();
		serializer.write(map);
	}
}
