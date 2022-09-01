/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.ip2region;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.hutool.core.io.FileUtil;

/**
 * @author tanyaowu 
 * 2016年10月19日 下午4:50:04
 */
public class Ip2RegionInit {
	private static Logger log = LoggerFactory.getLogger(Ip2RegionInit.class);

	public static void init() {
		String dbpath = FileUtil.getAbsolutePath("config/ip2region/ip2region.db");
		Ip2Region.dbSearcher = DbSearcherFactory.getDbSearcher(dbpath);

		//防止并发问题，先各查一遍
		try {
			String ip = "192.168.1.166";
			Ip2Region.dbSearcher.memorySearch(ip);
			Ip2Region.dbSearcher.binarySearch(ip);
			Ip2Region.dbSearcher.btreeSearch(ip);
		} catch (IOException e) {
			log.error("", e);
		}
	}
}
