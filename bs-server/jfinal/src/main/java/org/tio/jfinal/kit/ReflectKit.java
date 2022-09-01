/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * Copyright (c) 2011-2019, James Zhan 詹波 (jfinal@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tio.jfinal.kit;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 反射工具类
 */
public class ReflectKit {
	
	public static Object newInstance(Class<?> clazz) {
		try {
			return clazz.newInstance();
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getMethodSignature(Method method) {
		StringBuilder ret = new StringBuilder()
				.append(method.getDeclaringClass().getName())
				.append(".")
				.append(method.getName())
				.append("(");
		
		int index = 0;
		Parameter[] paras = method.getParameters();
		for (Parameter p : paras) {
			if (index++ > 0) {
				ret.append(", ");
			}
			ret.append(p.getParameterizedType().getTypeName());
		}
		
		return ret.append(")").toString();
	}
	
	/*
	public static String getMethodSignature(Method method) {
		StringBuilder ret = new StringBuilder()
				.append(method.getDeclaringClass().getName())
				.append(".")
				.append(method.getName())
				.append("(");
		
		int index = 0;
		java.lang.reflect.Type[] paraTypes = method.getGenericParameterTypes();
		for (java.lang.reflect.Type type : paraTypes) {
			if (index++ > 0) {
				ret.append(", ");
			}
			ret.append(type.getTypeName());
		}
		
		return ret.append(")").toString();
	}*/
	
}






