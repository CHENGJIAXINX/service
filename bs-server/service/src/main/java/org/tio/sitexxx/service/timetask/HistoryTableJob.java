/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.timetask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.service.tool.MysqlTool;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.quartz.AbstractJobWithLog;

/**
 * 
 * @author tanyaowu 
 * 2016年11月5日 下午8:31:30
 */
public class HistoryTableJob extends AbstractJobWithLog {

	private static Logger log = LoggerFactory.getLogger(HistoryTableJob.class);

	private static final Map<String, Set<String>> map = new HashMap<>();
	static {
		map.put(Const.Db.TIO_SITE_CONF, new HashSet<>());
		map.put(Const.Db.TIO_SITE_MAIN, new HashSet<>());
		map.put(Const.Db.TIO_SITE_STAT, new HashSet<>());

		addTable(Const.Db.TIO_SITE_STAT, "tio_token_path_access_stat");
		addTable(Const.Db.TIO_SITE_STAT, "tio_ip_path_access_stat");

		addTable(Const.Db.TIO_SITE_STAT, "tio_slow_request");
		addTable(Const.Db.TIO_SITE_STAT, "tio_ip_stat");
		addTable(Const.Db.TIO_SITE_STAT, "tio_channel_stat");
	}

	private static void addTable(String dbName, String tableName) {
		map.get(dbName).add(tableName);
	}

	public static HistoryTableJob me = new HistoryTableJob();

	@Override
	public void run(JobExecutionContext context) throws Exception {
		Set<Entry<String, Set<String>>> set = map.entrySet();
		for (Entry<String, Set<String>> entry : set) {
			String dbName = entry.getKey();
			Set<String> tableNames = entry.getValue();
			for (String tableName : tableNames) {
				try {
					String sql = "select count(*) from " + tableName;
					Long c = Db.use(dbName).queryLong(sql);
					if (c >= 800 * 10000) {
						MysqlTool.toHistory(dbName, tableName);
					}
				} catch (Exception e) {
					log.error("", e);
				}
			}
		}
	}

}
