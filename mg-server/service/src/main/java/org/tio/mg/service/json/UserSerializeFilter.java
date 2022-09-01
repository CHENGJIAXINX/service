/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.serializer.PropertyFilter;

/**
 * @author tanyaowu
 * 2016年8月17日 上午10:49:33
 */
public class UserSerializeFilter implements PropertyFilter {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(UserSerializeFilter.class);

	public static final UserSerializeFilter me = new UserSerializeFilter();

	private UserSerializeFilter() {
	}

	@Override
	public boolean apply(Object object, String name, Object value) {
		if (object == null) {
			return false;
		}

		if ("pwd".equals(name)) {
			return false;
		}

		return true;
	}
}
