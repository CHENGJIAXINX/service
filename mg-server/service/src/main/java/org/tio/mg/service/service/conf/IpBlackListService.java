/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.service.conf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.mg.service.model.conf.IpBlackList;
import org.tio.sitexxx.servicecommon.vo.Const;

import cn.hutool.core.util.StrUtil;

/**
 * 
 * @author tanyaowu
 *
 */
public class IpBlackListService {

	private static Logger log = LoggerFactory.getLogger(IpBlackListService.class);

	public static final IpBlackListService me = new IpBlackListService();

	final static IpBlackList dao = IpBlackList.dao;

	/**
	 * key: name, value: IpBlackList
	 */
	private static Map<String, IpBlackList> cacheData = null;

	/**
	 * 
	 * @return
	 * @author tanyaowu
	 */
	public Map<String, IpBlackList> getAll() {
		if (cacheData == null) {
			synchronized (IpBlackListService.class) {
				if (cacheData == null) {
					loadData();
				}
			}
		}
		return cacheData;
	}

	public boolean save(String ip, String remark) {
		IpBlackList ipBlackList = new IpBlackList();
		ipBlackList.setIp(StrUtil.trim(ip));
		ipBlackList.setStatus((byte) 1);
		ipBlackList.setRemark(StrUtil.trim(remark));
		boolean ret = ipBlackList.save();

		clearCache();
		return ret;
	}

	/**
	 * 删除白名单
	 * @param ip
	 * @param remark
	 * @return
	 */
	public int delete(String ip, String remark) {
		int ret = Db.use(Const.Db.TIO_SITE_CONF).update("update ip_black_list set status = ?, remark = ? where ip = ?", 2, remark, ip);

		clearCache();
		return ret;
	}

	/**
	 * 
	 */
	public static void clearCache() {
		synchronized (IpBlackListService.class) {
			cacheData = null;
		}
	}

	private static void loadData() {
		Map<String, IpBlackList> cacheData1 = new HashMap<>();
		List<IpBlackList> list = null;
		try {
			list = dao.find("select * from ip_black_list where status=1");
			if (list == null) {
				list = new ArrayList<>();
				return;
			}

			for (IpBlackList conf : list) {
				cacheData1.put(conf.getIp(), conf);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			cacheData = cacheData1;
		}

	}

	/**
	 * 是否是白名单ip
	 * @param ip
	 * @return true: 是白名单ip
	 */
	public static boolean isBlackIp(String ip) {
		if (StrUtil.isBlank(ip)) {
			return false;
		}

		if (cacheData == null) {
			synchronized (IpBlackListService.class) {
				if (cacheData == null) {
					loadData();
				}
			}
		}

		return cacheData.containsKey(ip);
	}
}
