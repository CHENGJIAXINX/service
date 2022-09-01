/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.jfinal.plugin.activerecord.sql;

import org.tio.jfinal.template.source.ISource;

/**
 * 封装 sql 模板源
 */
class SqlSource {
	
	String file;
	ISource source;
	
	SqlSource(String file) {
		this.file = file;
		this.source = null;
	}
	
	SqlSource(ISource source) {
		this.file = null;
		this.source = source;
	}
	
	boolean isFile() {
		return file != null;
	}
}



