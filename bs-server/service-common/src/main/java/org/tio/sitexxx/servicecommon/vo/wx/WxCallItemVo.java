/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo.wx;

import java.io.Serializable;

/**
 * 音视频对象
 * 
 * @author xufei 2020年2月10日 下午3:12:31
 */
public class WxCallItemVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5500652530550301909L;

	/**
	 * 音视频类型
	 */
	private Byte calltype;

	/**
	 * 挂断类型
	 */
	private Byte hanguptype;
	
	/**
	 * 挂断用户
	 */
	private Integer hangupuid;
	
	private Byte devicetype;
	
	/**
	 * 通话时长
	 */
	private Long duration;
	
	public Byte getDevicetype() {
		return devicetype;
	}

	public void setDevicetype(Byte devicetype) {
		this.devicetype = devicetype;
	}

	public Byte getCalltype() {
		return calltype;
	}

	public void setCalltype(Byte calltype) {
		this.calltype = calltype;
	}

	public Byte getHanguptype() {
		return hanguptype;
	}

	public void setHanguptype(Byte hanguptype) {
		this.hanguptype = hanguptype;
	}

	public Integer getHangupuid() {
		return hangupuid;
	}

	public void setHangupuid(Integer hangupuid) {
		this.hangupuid = hangupuid;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param args
	 * @author xufei 2020年2月10日 下午3:12:59
	 */
	public static void main(String[] args) {

	}
}
