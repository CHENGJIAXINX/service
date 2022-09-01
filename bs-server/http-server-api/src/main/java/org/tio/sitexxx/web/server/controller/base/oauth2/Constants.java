/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.base.oauth2;

public class Constants {
	public static final String	RESOURCE_SERVER_NAME	= "oauth-server";
	public static final String	INVALID_CLIENT_ID		= "客户端验证失败，如错误的client_id/client_secret。";
	public static final String	INVALID_ACCESS_TOKEN	= "accessToken无效或已过期。";
	public static final String	INVALID_REDIRECT_URI	= "缺少授权成功后的回调地址。";
	public static final String	INVALID_AUTH_CODE		= "错误的授权码。";
	// 验证accessToken
	public static final String CHECK_ACCESS_CODE_URL = "http://localhost:8080/zetark-oauth2-server/checkAccessToken?accessToken=";

}
