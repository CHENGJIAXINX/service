/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */package org.tio.sitexxx.service.pay.impl.pay5u.resp;

import java.util.Map;

import cn.hutool.core.bean.BeanUtil;

/**
 * 异常信息resp
 * @author xufei
 * 2020年11月3日 下午6:31:35
 */
public class Excep5UResp {
	
	private String code;
	
	private String errorMessage;
	
	private String status;
	
	private String walletid;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWalletid() {
		return walletid;
	}

	public void setWalletid(String walletid) {
		this.walletid = walletid;
	}
	
	public Map<String, Object> toMap() {
		return BeanUtil.beanToMap(this);
	}
}
