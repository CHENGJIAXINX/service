/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.service.model.stat.TioTokenPathAccessStat;
import org.tio.sitexxx.servicecommon.vo.Const;

/**
 * 
 * @author tanyaowu
 *
 */
public class TioTokenPathAccessStatService {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(TioTokenPathAccessStatService.class);

	public static final TioTokenPathAccessStatService ME = new TioTokenPathAccessStatService();

	/**
	 * 
	 * @author tanyaowu
	 */
	public TioTokenPathAccessStatService() {
	}

	/**
	 * 
	 * @param tioIpPathAccessStat
	 * @return
	 * @author tanyaowu
	 */
	public boolean save(TioTokenPathAccessStat tioTokenPathAccessStat) {
		if (tioTokenPathAccessStat != null) {
			return tioTokenPathAccessStat.save();
		}
		return false;
	}

	public int[] batchSave(List<TioTokenPathAccessStat> modelList) {
		return Db.use(Const.Db.TIO_SITE_STAT).batchSave(modelList, 100);
	}
}
