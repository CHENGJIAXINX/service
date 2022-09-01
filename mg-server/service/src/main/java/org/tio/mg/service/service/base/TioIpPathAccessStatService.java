package org.tio.mg.service.service.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.mg.service.model.stat.TioIpPathAccessStat;
import org.tio.sitexxx.servicecommon.vo.Const;

import java.util.List;

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
