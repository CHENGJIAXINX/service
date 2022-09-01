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

package org.tio.jfinal.plugin.activerecord;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 用于支持查询出来的字段次序与 select a, b, c... 的次序一致
 * 
 * 通常用于查询类系统，字段是不确定的，字段显示的次序要与 select
 * 字句保持一致
 * 
 * 用法：
 * arp.setContainerFactory(new OrderedFieldContainerFactory())
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class OrderedFieldContainerFactory implements IContainerFactory {
	
	public Map<String, Object> getAttrsMap() {
		return new LinkedHashMap();
	}
	
	public Map<String, Object> getColumnsMap() {
		return new LinkedHashMap();
	}
	
	public Set<String> getModifyFlagSet() {
		return new HashSet();
	}
}
