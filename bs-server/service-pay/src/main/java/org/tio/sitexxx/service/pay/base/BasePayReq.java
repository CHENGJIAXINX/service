/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */package org.tio.sitexxx.service.pay.base;

import java.util.Map;

import org.tio.http.common.HttpRequest;

/**
 * 请求
 * @author xufei
 * 2020年11月2日 下午6:53:23
 */
public class BasePayReq{
	
	/**
	 * @param request
	 */
	public BasePayReq(HttpRequest request) {
		this.request = request;
	}
	
	/**
	 * 
	 */
	private Map<String, Object> params;
	
	/**
	 * 
	 */
	private String singleParam;
	
	/**
	 * 请求的request
	 */
	private HttpRequest request;

	public Map<String, Object> getParams() {
		return params;
	}

	public String getSingleParam() {
		return singleParam;
	}

	public void setSingleParam(String singleParam) {
		this.singleParam = singleParam;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}
