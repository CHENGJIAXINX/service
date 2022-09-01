/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.service.model.stat.TioIpPathAccessStat;
import org.tio.sitexxx.servicecommon.vo.Const;

/**
 * @author tanyaowu 
 * 2016年10月30日 下午2:33:15
 */
public class TioIpPathAccessStatService {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(TioIpPathAccessStatService.class);

	public static final TioIpPathAccessStatService ME = new TioIpPathAccessStatService();

	/**
	 * 
	 * @author tanyaowu
	 */
	public TioIpPathAccessStatService() {
	}

	/**
	 * 
	 * @param tioIpPathAccessStat
	 * @return
	 * @author tanyaowu
	 */
	public boolean save(TioIpPathAccessStat tioIpPathAccessStat) {
		if (tioIpPathAccessStat != null) {
			return tioIpPathAccessStat.save();
		}
		return false;
	}

	public int[] batchSave(List<TioIpPathAccessStat> modelList) {
		return Db.use(Const.Db.TIO_SITE_STAT).batchSave(modelList, 100);
	}
}
