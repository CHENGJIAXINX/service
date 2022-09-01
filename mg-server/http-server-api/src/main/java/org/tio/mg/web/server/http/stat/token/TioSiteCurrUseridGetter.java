/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.mg.web.server.http.stat.token;

import org.tio.http.common.HttpRequest;
import org.tio.http.server.intf.CurrUseridGetter;
import org.tio.mg.web.server.utils.WebUtils;

/**
 * @author tanyaowu
 *
 */
public class TioSiteCurrUseridGetter implements CurrUseridGetter {

	public static TioSiteCurrUseridGetter me = new TioSiteCurrUseridGetter();

	/**
	 * 
	 */
	private TioSiteCurrUseridGetter() {
	}

	@Override
	public String getUserid(HttpRequest request) {
		Integer ret = WebUtils.currUserId(request);
		if (ret != null) {
			return ret + "";
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
