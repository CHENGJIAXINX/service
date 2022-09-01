/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author tanyaowu 
 * 2016年11月8日 下午4:02:58
 */
public class ExeTaskVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3963364892525730869L;

	public static final String CLIENTID = UUID.randomUUID().toString();

	public static interface Type {
		/**
		 * 经验计划任务执行
		 */
		byte EXP = 1;

	}

	private Byte type = null;

	private String params;

	private String clientId = CLIENTID;

	/**
	 * 
	 * @author tanyaowu
	 */
	public ExeTaskVo() {
	}

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the type
	 */
	public Byte getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Byte type) {
		this.type = type;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
}
