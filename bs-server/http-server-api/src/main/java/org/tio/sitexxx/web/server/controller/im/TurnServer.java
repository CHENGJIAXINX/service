/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.im;

/**
 * @author tanyaowu 
 * 2020年1月20日 下午4:45:32
 */
public class TurnServer {
	private String	urls			= null;
	private String	username	= null;
	private String	credential	= null;

	/**
	 * 
	 * @author tanyaowu
	 */
	public TurnServer() {
	}

	/**
	 * @return the url
	 */
	public String getUrls() {
		return urls;
	}

	/**
	 * @param urls the url to set
	 */
	public void setUrls(String urls) {
		this.urls = urls;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the credential
	 */
	public String getCredential() {
		return credential;
	}

	/**
	 * @param credential the credential to set
	 */
	public void setCredential(String credential) {
		this.credential = credential;
	}
}
