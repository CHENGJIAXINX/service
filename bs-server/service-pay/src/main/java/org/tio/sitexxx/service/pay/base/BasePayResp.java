/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */package org.tio.sitexxx.service.pay.base;

import java.util.Map;

/**
 * 请求
 * @param <Req>
 * @author xufei
 * 2020年11月2日 下午6:53:23
 */
/**
 * 
 * @author xufei
 * 2020年11月3日 下午4:45:13
 */
/**
 * 
 * @author xufei
 * 2020年11月3日 下午4:45:14
 */
public class BasePayResp {
	
	/**
	 * 响应数据
	 */
	private Map<String, Object> resp;
	
	/**
	 * 成功与否
	 */
	private boolean ok;
	
	/**
	 * 返回状态
	 */
	private String status;
	
	/**
	 * code码
	 */
	private int code;
	
	/**
	 * 消息
	 */
	private String msg;
	

	public Map<String, Object> getResp() {
		return resp;
	}

	public void setResp(Map<String, Object> resp) {
		this.resp = resp;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static BasePayResp fail(String msg) {
		BasePayResp payResp = new BasePayResp();
		payResp.setOk(false);
		payResp.setMsg(msg);
		return payResp;
	}
}
