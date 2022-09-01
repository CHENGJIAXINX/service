/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.all;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.service.timetask.HistoryTableJob;

/**
 * @author tanyw
 *
 */
public class MysqlToolTest {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(MysqlToolTest.class);

	/**
	 * 
	 */
	public MysqlToolTest() {

	}

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws Exception {
		org.tio.sitexxx.all.Starter.initBase();

		//		String createSql = showCreateSql(Const.Db.TIO_SITE_MAIN, "user");
		//		System.out.println(createSql);

		//		MysqlTool.toHistory(Const.Db.TIO_SITE_STAT, "tio_token_path_access_stat");

		HistoryTableJob.me.run(null);

	}

}
