/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo;

/**
 * @author tanyaowu
 * 2016年8月10日 上午10:58:36
 */
public interface RequestKey {
	/**
	 * 存放RequestExt对象
	 */
	String REQUEST_EXT = "TIO_SITE_REQUESTEXT";

	/**
	 * 是否是第三方登录
	 * 存的是Boolean
	 */
	String IS_THIRD_LOGIN = "IS_THIRD_LOGIN";

	/**
	 * 第三方登录时，有时候需要暂存User
	 * 存的是User对象
	 */
	String THIRD_LOGIN_USER = "THIRD_LOGIN_USER";
	
	/**
	 * 第三方登录时的HttpResponse对象
	 * 存的是HttpResponse对象
	 */
	String THIRD_LOGIN_RESPONSE = "THIRD_LOGIN_RESPONSE";

	/**
	 * 微信公众号授权信息
	 * 存的是授权标识
	 */
	String WX_OPENID_GRANT = "WX_OPENID_GRANT";

	/**
	 * 是否用机器人登录
	 * 存的是Boolean
	 */
	String USE_ROBOT = "USE_ROBOT";

}
