/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */package org.tio.sitexxx.service.pay.impl.pay5u.resp;

import java.util.HashMap;
import java.util.Map;

/**
 * 修改开户信息响应
 * @author xufei
 * 2020年11月3日 下午6:31:35
 */
public class ClientToken5UResp {
	
	/**
	 * 创建状态
	 */
	private String createStatus;
	
	/**
	 * 创建时间
	 */
	private String createDateTime;
	
	/**
	 * 票据
	 */
	private String token;
	
	/**
	 * 钱包 ID -Y
	 */
	private String walletId;
	
	/**
	 * 响应状态-N
	 */
	private String status;
	
	/**
	 * 商户号-N
	 */
	private String merchantId;
	
	/**
	 * 请求id-N
	 */
	private String requestId;
	
	
	/**
	 * 参数-N
	 */
	private String hmac;
	
	/**
	 * 错误日志
	 */
	private String errorMessage;
	
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

	public String getCreateStatus() {
		return createStatus;
	}

	public void setCreateStatus(String createStatus) {
		this.createStatus = createStatus;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}


	public String getWalletId() {
		return walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}
	
	public String getHmac() {
		return hmac;
	}

	public void setHmac(String hmac) {
		this.hmac = hmac;
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("token",this.token);
		map.put("walletId",this.walletId);
		map.put("createDateTime",this.createDateTime);
		return map;
	}
}
