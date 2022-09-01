/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.jfinal.plugin.activerecord.sql.proxy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tanyaowu
 *
 */
public class SqlLog {

	public static final Logger slowsqlLog = LoggerFactory.getLogger("slowsqlLog");

	public static final Logger querysqlLog = LoggerFactory.getLogger("querysqlLog");

	public static final Logger updatesqlLog = LoggerFactory.getLogger("updatesqlLog");

	public static final Logger errorsqlLog = LoggerFactory.getLogger("errorsqlLog");

	static final String NULL = "null";

	static final long SLOWSQL_COST = 1000L;

	/**
	 * 
	 * @param sql
	 * @param pps
	 * @param cost
	 * @param e
	 * @author tanyaowu
	 */
	public static void logUpdate(String sql, ProxyPreparedStatement pps, long cost, Throwable e) {
		log(sql, pps, cost, e, updatesqlLog);
	}

	/**
	 * 
	 * @param sql
	 * @param pps
	 * @param cost
	 * @param e
	 * @author tanyaowu
	 */
	public static void logQuery(String sql, ProxyPreparedStatement pps, long cost, Throwable e) {
		log(sql, pps, cost, e, querysqlLog);
	}

	/**
	 * 
	 * @param sql
	 * @param pps
	 * @param cost
	 * @param e
	 * @param log
	 * @author tanyaowu
	 */
	private static void log(String sql, ProxyPreparedStatement pps, long cost, Throwable e, Logger log) {
		if (org.tio.jfinal.kit.StrKit.isBlank(sql)) {
			sql = pps.sql;
		}
		Map<Integer, Object> params = pps.params;
		String realSql = realSql(sql, params);
		
		String logStr = cost + "ms\r\n" + realSql;
		
		log.info(logStr);


		logSlowAndError(logStr, cost, e);
	}

	/**
	 * 
	 * @param pps
	 * @param cost
	 * @param e
	 * @author tanyaowu
	 */
	public static void logBatch(ProxyPreparedStatement pps, long cost, Throwable e) {
		List<String> sqlList = pps.sqlList;
		StringBuilder sb = null;
		if (sqlList != null && sqlList.size() > 0) {
			sb = new StringBuilder(sqlList.size() * sqlList.get(0).length());
			sb.append("batch sql_list:").append(sqlList.size()).append(", ").append(cost).append("ms\r\n");
			
			for (String sql : sqlList) {
				sb.append(sql).append(";\r\n");
			}

		} else {
			List<Map<Integer, Object>> paramsList = pps.paramsList;
			if (paramsList != null && paramsList.size() > 0) {
				sb = new StringBuilder(paramsList.size() * (pps.sql.length() + 20));
				sb.append("batch params_list:").append(paramsList.size()).append(", ").append(cost).append("ms\r\n");
				
				for (Map<Integer, Object> params : paramsList) {
					String realSql = realSql(pps.sql, params);
					sb.append(realSql).append(";\r\n");
				}
			}
		}

		String logStr = sb.toString();

		updatesqlLog.info(logStr);

		logSlowAndError(logStr, cost, e);
	}

	/**
	 * 
	 * @param logStr
	 * @param cost
	 * @param e
	 * @author tanyaowu
	 */
	private static void logSlowAndError(String logStr, long cost, Throwable e) {
		if (cost >= SLOWSQL_COST) {
			slowsqlLog.info(logStr);
		}

		if (e != null) {
			errorsqlLog.error(logStr, e);
		}
	}

	/**
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @author tanyaowu
	 */
	public static String realSql(String sql, Map<Integer, Object> params) {
		if (params == null || params.size() == 0) {
			return sql;
		}

		int len = sql.length();

		StringBuilder sb = new StringBuilder(len + params.size() * 10);
		int indexOfParams = 1;
		for (int i = 0; i < len; i++) {
			char c = sql.charAt(i);
			if (c == '?') {
				Object obj = params.get(indexOfParams++);
				if (obj == null) {
					sb.append(NULL);
				} else {
					if (obj instanceof String) {
						sb.append("'").append(obj).append("'");
					} else if (obj instanceof Date) {
						SimpleDateFormat aDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						sb.append("'").append(aDate.format((Date) obj)).append("'");
					} else {
						sb.append(obj);
					}
				}
				//				sb.append(obj);
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	private SqlLog() {
	}
}
