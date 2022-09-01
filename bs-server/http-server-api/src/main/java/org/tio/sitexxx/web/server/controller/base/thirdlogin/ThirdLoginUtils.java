/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.controller.base.thirdlogin;

import org.tio.http.common.HttpConfig;
import org.tio.sitexxx.servicecommon.vo.Const;

/**
 * @author tanyaowu
 *
 */
public class ThirdLoginUtils {

	/**
	 * 
	 */
	public ThirdLoginUtils() {

	}

	/**
	 * 
	 * @param httpConfig
	 * @param type
	 * @return
	 */
	public static String getCallbackUrl(HttpConfig httpConfig, Integer type) {
		return Const.SITE + httpConfig.getContextPath() + "/tlogin/cb/p/" + type + httpConfig.getSuffix();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
