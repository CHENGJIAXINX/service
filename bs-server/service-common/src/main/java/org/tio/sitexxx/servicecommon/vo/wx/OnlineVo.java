/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo.wx;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在线对象
 * 
 * @author xufei
 * 2020年9月14日 上午11:44:43
 */
public class OnlineVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8393515913684620621L;

	/**
	 * 设备类型
	 */
	private Byte devicetype;
	
	/**
	 * 通道
	 */
	private String channelid;

	/**
	 * ipid
	 */
	private Integer ipid;
	
	/**
	 * 同设备在线数
	 */
	public AtomicInteger count = new AtomicInteger(1);

	/**
	 * 用户id
	 */
	private Integer uid;
	
	public Byte getDevicetype() {
		return devicetype;
	}

	public void setDevicetype(Byte devicetype) {
		this.devicetype = devicetype;
	}

	public Integer getIpid() {
		return ipid;
	}

	public void setIpid(Integer ipid) {
		this.ipid = ipid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getChannelid() {
		return channelid;
	}

	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}

	/**
	 * @param args
	 * @author xufei 2020年2月10日 下午3:12:59
	 */
	public static void main(String[] args) {

	}
}
