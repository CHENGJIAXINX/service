/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.base.thirdlogin.provider.qq;

public class UnionID {

	public UnionID() {
	}

	/**
	 * 用户登录unionID
	 */
	private String	unionID;
	/**
	 * 应用的 appID
	 */
	private String	clientID;
	/**
	 * QQ 用户的唯一帐号标识，对当前开发者帐号唯一
	 */
	private String	openid;
	/**
	 * 请求错误码
	 */
	private String	error;
	/**
	 * 请求错误描述
	 */
	private String	errorDescription;

	public String getUnionID() {
		return unionID;
	}

	public void setUnionID(String unionID) {
		this.unionID = unionID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

}
