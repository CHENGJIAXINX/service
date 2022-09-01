/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.http.stat.token;

import org.tio.http.server.stat.token.DefaultTokenGetter;

/**
 * @author tanyaowu
 */
public class TioSiteTokenGetter extends DefaultTokenGetter {

	public static TioSiteTokenGetter me = new TioSiteTokenGetter();

	/**
	 * 
	 */
	private TioSiteTokenGetter() {

	}

	//	@Override
	//	public String getToken(HttpRequest request) {
	//		HttpSession httpSession = request.getHttpSession();
	//		if (httpSession != null) {
	//			return httpSession.getId();
	//		}
	//		Cookie cookie = DefaultHttpRequestHandler.getSessionCookie(request, request.getHttpConfig());
	//		if (cookie != null) {
	//			return cookie.getValue();
	//		}
	//		return null;
	//	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
