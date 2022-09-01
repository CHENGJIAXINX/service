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

package org.tio.jfinal.plugin.activerecord.generator;

import java.io.Serializable;

/**
 * ColumnMeta
 */
@SuppressWarnings("serial")
public class ColumnMeta implements Serializable  {
	
	public String name;				// 字段名
	public String javaType;			// 字段对应的 java 类型
	public String attrName;			// 字段对应的属性名
	
	// ---------
	
	/*
	-----------+---------+------+-----+---------+----------------
	 Field     | Type    | Null | Key | Default | Remarks
	-----------+---------+------+-----+---------+----------------
	 id		   | int(11) | NO	| PRI | NULL	| remarks here	
	*/
	public String type;				// 字段类型(附带字段长度与小数点)，例如：decimal(11,2)
	public String isNullable;		// 是否允许空值
	public String isPrimaryKey;		// 是否主键
	public String defaultValue;		// 默认值
	public String remarks;			// 字段备注
}

