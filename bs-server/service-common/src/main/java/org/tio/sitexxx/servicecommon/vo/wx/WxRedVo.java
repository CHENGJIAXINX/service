/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo.wx;

import java.io.Serializable;

/**
 * 红包vo
 * 
 * @author xufei 2020年2月10日 下午3:12:31
 */
public class WxRedVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4279416613620223037L;

	/**
	 * 红包订单号
	 */
	private String serialnumber;
	
	/**
	 * 红包文案
	 */
	private String text;
	
	/**
	 * 类型：1：普通红包；2：手气红包
	 */
	private Byte mode;
	
	/**
	 * 状态
	 */
	private String status;

	public Byte getMode() {
		return mode;
	}

	public void setMode(Byte mode) {
		this.mode = mode;
	}

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param args
	 * @author xufei 2020年2月10日 下午3:12:59
	 */
	public static void main(String[] args) {

	}
}
