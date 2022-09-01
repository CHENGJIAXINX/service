/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.conf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.service.model.conf.BankConf;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.lock.LockUtils;

import cn.hutool.core.util.StrUtil;

/**
 * 银行配置加载
 * @author tanyaowu
 *
 */
public class BankConfService {
	private static Logger				log			= LoggerFactory.getLogger(BankConfService.class);
	public static final BankConfService		me			= new BankConfService();
	final static BankConf					confDao		= new BankConf().dao();

	/**
	 * key: name, value: value
	 */
	private static Map<String, String>	cacheData	= null;

	/**
	 * 
	 */
	public static void clearCache() {
		synchronized (BankConfService.class) {
			cacheData = null;
		}
	}

	private static void loadData() {
		//		clearCache();

		Map<String, String> tempCache = new HashMap<>();
		List<BankConf> list = null;
		try {
			list = confDao.find("select * from bank_conf");
			if (list == null) {
				list = new ArrayList<>();
			}
			if (list.size() == 0) {
				return;
			}
			for (BankConf conf : list) {
				tempCache.put(conf.getBankcode(), conf.getBankicon());
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			cacheData = tempCache;
		}
	}

	/**
	 * 根据参数名字获取参数值
	 * @param name
	 * @param defaultValue 默认值
	 * @return
	 */
	public static String getString(String name) {
		if (cacheData == null) {
			try {
				LockUtils.runWriteOrWaitRead(BankConfService.class.getName(), BankConfService.class, () -> {
//					@Override
//					public void read() {
//					}

//					@Override
//					public void write() {
						if (cacheData == null) {
							loadData();
						}
//					}
				});
			} catch (Exception e) {
				log.error("", e);
			}
		}
		if (cacheData == null) {
			return "";
		}
		String value = cacheData.get(name);
		if (!StrUtil.isBlank(value)) {
			return Const.SITE + "/bank/" + value;
		} else {
			return Const.SITE + "/bank/default.png";
		}
	}
}
