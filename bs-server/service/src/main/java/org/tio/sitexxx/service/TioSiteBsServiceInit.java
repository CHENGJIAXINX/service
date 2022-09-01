/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service;

import java.io.IOException;

import org.tio.sitexxx.service.init.CacheInit;
import org.tio.sitexxx.service.init.JFInit;
import org.tio.sitexxx.service.init.JsonInit;
import org.tio.sitexxx.service.init.PropInit;
import org.tio.sitexxx.service.init.RedisInit;
import org.tio.sitexxx.service.ip2region.Ip2RegionInit;
import org.tio.sitexxx.service.service.base.SensitiveWordsService;
import org.tio.sitexxx.service.utils.AliLiveUtils;

/**
 * 
 * @author tanyaowu
 */
public class TioSiteBsServiceInit {

	/**
	 * @param args
	 * @author tanyaowu
	 * @throws Exception 
	 * @throws IOException
	 */
	public static void init() throws Exception {
		// 属性初始化
		PropInit.init();

		// ip2region初始化
		Ip2RegionInit.init();

		// 敏感词初始化
		SensitiveWordsService.init();

		// Json配置初始化
		JsonInit.init();

		// jfinal 初始化
		JFInit.init();

		// redis初始化，里面会有topic等的初始化
		RedisInit.init(true);

		// 缓存初始化
		CacheInit.init(true);

		// 阿里直播初始化
		AliLiveUtils.init();

	}

	/**
	 * @author tanyaowu
	 */
	public TioSiteBsServiceInit() {
	}
}
