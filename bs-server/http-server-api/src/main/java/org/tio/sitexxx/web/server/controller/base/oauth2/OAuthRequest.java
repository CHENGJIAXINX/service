/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.controller.base.oauth2;

import java.util.Set;

import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.tio.http.common.HttpRequest;

/**
 * 本类参考了:org.apache.oltu.oauth2.as.request.OAuthRequest
 * @author tanyaowu
 *
 */
public class OAuthRequest {

	private HttpRequest request;

	/**
	 * 
	 */
	public OAuthRequest(HttpRequest request) {
		this.request = request;
	}

	public String getParam(String name) {
		return request.getParam(name);
	}

	public String getClientId() {
		String[] creds = OAuthUtils.decodeClientAuthenticationHeader(request.getHeader(OAuth.HeaderType.AUTHORIZATION));
		if (creds != null) {
			return creds[0];
		}
		return getParam(OAuth.OAUTH_CLIENT_ID);
	}

	public String getRedirectURI() {
		return getParam(OAuth.OAUTH_REDIRECT_URI);
	}

	public String getClientSecret() {
		String[] creds = OAuthUtils.decodeClientAuthenticationHeader(request.getHeader(OAuth.HeaderType.AUTHORIZATION));
		if (creds != null) {
			return creds[1];
		}
		return getParam(OAuth.OAUTH_CLIENT_SECRET);
	}

	/**
	 * 
	 * @return
	 */
	public boolean isClientAuthHeaderUsed() {
		return OAuthUtils.decodeClientAuthenticationHeader(request.getHeader(OAuth.HeaderType.AUTHORIZATION)) != null;
	}

	/**
	 * scope
	 * @return
	 */
	public Set<String> getScopes() {
		String scopes = getParam(OAuth.OAUTH_SCOPE);
		return OAuthUtils.decodeScopes(scopes);
	}

	/**
	 * response_type
	 * @return
	 */
	public String getResponseType() {
		return getParam(OAuth.OAUTH_RESPONSE_TYPE);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
