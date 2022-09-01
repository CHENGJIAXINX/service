/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.jf;

import javax.sql.DataSource;

import org.tio.jfinal.plugin.activerecord.generator.MetaBuilder;

/**
 * @author tanyw
 *
 */
public class TioSiteMetaBuilder extends MetaBuilder {

	/**
	 * 
	 */
	public TioSiteMetaBuilder(DataSource dataSource) {
		super(dataSource);
	}

	protected boolean isSkipTable(String tableName) {
		if (tableName.endsWith(org.tio.sitexxx.servicecommon.vo.Const.HistoryTable.HISTORY_TABLE_SUFFIX)) {
			System.out.println("历史表不生成代码：" + tableName);
			return true;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
