/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.conf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.model.conf.Conf;
import org.tio.sitexxx.service.model.conf.ConfDev;
import org.tio.sitexxx.service.model.conf.YxConf;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.utils.lock.LockUtils;

import cn.hutool.core.util.StrUtil;

/**
 * 配置信息加载
 * @author tanyaowu
 *
 */
public class ConfService {
	private static Logger				log			= LoggerFactory.getLogger(ConfService.class);
	public static final ConfService		me			= new ConfService();
	final static YxConf					confDao		= new YxConf().dao();
	final static ConfDev				confDevDao	= new ConfDev().dao();
	/**
	 * key: name, value: value
	 */
	private static Map<String, String>	cacheData	= null;

	private static Map<String, String>	clientConfData	= null;

	/**
	 *
	 */
	public static void clearCache() {
		synchronized (ConfService.class) {
			cacheData = null;
			clientConfData = null;
		}
	}
	public static void main(String[] args) {
		System.out.print('*'+0);
		System.out.print('#'+0);
		System.out.print('+'+0);
	}
	private static void loadData() {
		Map<String, String> tempCache = new HashMap<>();
		Map<String, String> tempClientCache = new HashMap<>();
		List<YxConf> list = null;
		try {
			list = confDao.find("select * from yx_conf");
			if (list == null) {
				list = new ArrayList<>();
			}
			System.out.println("查询出yx_conf参数："+JSON.toJSON(list));
			List<ConfDev> list2 = confDevDao.find("select * from conf_dev");

			if (list2 != null) {
				for (ConfDev item : list2) {
					YxConf conf = new YxConf();
					conf.setName(item.getName());
					conf.setValue(item.getValue());
					conf.setRemark(item.getRemark());
					conf.setClientConf((byte) 0);
					list.add(conf);
				}
			}

			if (list.size() == 0) {
				return;
			}

			for (YxConf conf : list) {
				tempCache.put(conf.getName(), conf.getValue());
				if (conf.getClientConf().byteValue() == 0){
					tempClientCache.put(conf.getName(), conf.getValue());
				}
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			cacheData = tempCache;
			clientConfData = tempClientCache;
			System.out.println("cacheData==>"+JSON.toJSON(cacheData));
			System.out.println("clientConfData==>"+JSON.toJSON(clientConfData));
		}
	}

	/**
	 * 根据参数名字获取参数值
	 * @param name
	 * @param defaultValue 默认值
	 * @return
	 */
	public static String getString(String name, String defaultValue) {
		if (cacheData == null) {
			try {
				LockUtils.runWriteOrWaitRead(ConfService.class.getName(), ConfService.class, () -> {
//					@Override
//					public void read() {
//					}

//					@Override
//					public void write() {
//						if (cacheData == null) {
							loadData();
//						}
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
			return value;
		} else {
			return defaultValue;
		}
	}

	/**
	 *
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public static Integer getInt(String name, Integer defaultValue) {
		String value = getString(name, null);
		if (value == null) {
			return defaultValue;
		}
		return Integer.parseInt(value);
	}

	/**
	 * @param name
	 * @param defaultValue
	 * @return
	 * @author xufei
	 * 2020年12月3日 上午10:45:21
	 */
	public static Short getShort(String name, Short defaultValue) {
		String value = getString(name, null);
		if (value == null) {
			return defaultValue;
		}
		return Short.parseShort(value);
	}

	/**
	 *
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public static Byte getByte(String name, Byte defaultValue) {
		String value = getString(name, null);
		if (value == null) {
			return defaultValue;
		}
		return Byte.parseByte(value);
	}

	/**
	 *
	 * @param name
	 * @param defaultValue
	 * @return
	 *
	 */
	public static Float getFloat(String name, Float defaultValue) {
		String value = getString(name, null);
		if (value == null) {
			return defaultValue;
		}
		return Float.parseFloat(value);
	}

	/**
	 *
	 * @param name
	 * @param defaultValue
	 * @return
	 *
	 */
	public static Double getDouble(String name, Double defaultValue) {
		String value = getString(name, null);
		if (value == null) {
			return defaultValue;
		}
		return Double.parseDouble(value);
	}

	/**
	 *
	 * @param name
	 * @param defaultValue
	 * @param trueValue
	 * @return
	 */
	public static Boolean getBoolean(String name, String defaultValue, String trueValue) {
		String value = getString(name, defaultValue);
		return value.equalsIgnoreCase(trueValue);
	}

	/**
	 * 值为true、TRUE的返回true
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public static Boolean getBoolean(String name, String defaultValue) {
		String value = getString(name, defaultValue);
		return value.equalsIgnoreCase("true");
	}

	/**
	 * @param name
	 * @param defaultValue
	 * @return
	 * @author tanyaowu
	 */
	public static Long getLong(String name, Long defaultValue) {
		String value = getString(name, null);
		if (value == null) {
			return defaultValue;
		}
		return Long.parseLong(value);
	}

	public static Map<String, String> getCacheData (){
		if(cacheData==null){
			System.out.println("配置为空，加载配置=================>");
			loadData();
		}
		return cacheData;
	}

	public static Map<String, String> getClientCacheData (){
		if(clientConfData==null){
			System.out.println("配置为空，加载配置=================>");
			loadData();
		}
		return clientConfData;
	}

	/**
	 * 根据配置名称获取配置
	 * @param configName
	 * @return
	 */
	public static YxConf getYxConfigByName(String configName){
		return confDao.findFirst("select * from yx_conf where name = ?", configName);
	}
}
