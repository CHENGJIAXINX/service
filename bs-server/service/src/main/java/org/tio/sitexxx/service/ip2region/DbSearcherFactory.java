/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.service.ip2region;

import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tanyaowu
 * 2016年5月16日 下午10:15:04
 */
public class DbSearcherFactory {
	private static Logger log = LoggerFactory.getLogger(DbSearcherFactory.class);

	private static DbSearcher dbSearcher = null;

	public static DbSearcher getDbSearcher(String dbpath) {

		try {
			if (dbSearcher == null) {
				synchronized (log) {
					if (dbSearcher == null) {
						DbConfig config = new DbConfig();
						dbSearcher = new DbSearcher(config, dbpath);
					}
				}
			}
			return dbSearcher;
		} catch (Throwable e) {
			log.error("", e);
			return null;
		}
	}
}
