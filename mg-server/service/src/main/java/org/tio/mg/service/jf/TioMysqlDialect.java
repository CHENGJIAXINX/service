/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.jf;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.tio.jfinal.plugin.activerecord.Table;
import org.tio.jfinal.plugin.activerecord.dialect.MysqlDialect;

/**
 * 
 * @author xufei
 * 2020年1月9日 下午1:46:11
 */
public class TioMysqlDialect extends MysqlDialect {

	@Override
	public void forModelSave(Table table, Map<String, Object> attrs, StringBuilder sql, List<Object> paras) {
//		sql.append("insert into `").append(table.getName()).append("`(");
		//此处重写父类保存sql起始语句，以实现replace into,insert ignore into
		if(sql.length() <= 0) {
			sql.append("insert into ");
		}
		sql.append(" `").append(table.getName()).append("`(");
		StringBuilder temp = new StringBuilder(") values(");
		for (Entry<String, Object> e: attrs.entrySet()) {
			String colName = e.getKey();
			if (table.hasColumnLabel(colName)) {
				if (paras.size() > 0) {
					sql.append(", ");
					temp.append(", ");
				}
				sql.append('`').append(colName).append('`');
				temp.append('?');
				paras.add(e.getValue());
			}
		}
		sql.append(temp.toString()).append(')');
	}

}
