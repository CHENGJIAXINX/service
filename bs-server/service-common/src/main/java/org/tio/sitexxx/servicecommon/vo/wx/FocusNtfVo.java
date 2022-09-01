/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo.wx;

import java.io.Serializable;

/**
 * 焦点通知对象
 * 
 * @author xufei 2020年8月25日 下午3:12:31
 */
public class FocusNtfVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5308233215714622555L;

	/**
	 * 设备类型
	 */
	private Byte devicetype;
	
	/**
	 * 通道
	 */
	private String channelid;

	/**
	 * 会话id
	 */
	private Long chatlinkid;
	
	/**
	 * 群id
	 */
	private Long groupid;
	
	/**
	 * 会话模型
	 */
	private Byte chatmode;

	/**
	 * ipid
	 */
	private Integer ipid;

	/**
	 * 用户id
	 */
	private Integer uid;
	
	/**
	 * 
	 */
	private Byte oper;
	
	/**
	 * 操作Code
	 * @author xufei
	 * 2020年6月5日 下午2:18:37
	 */
	public static interface operCode {
		/**
		 * 进入
		 */
		byte JOIN = 1;

		/**
		 * 离开
		 */
		byte LEAVE = 2;
		
		/**
		 * 刷新
		 */
		byte REFRESH = 3;
	}

	public String getChannelid() {
		return channelid;
	}

	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}

	public Byte getOper() {
		return oper;
	}

	public void setOper(Byte oper) {
		this.oper = oper;
	}

	public Byte getChatmode() {
		return chatmode;
	}

	public Long getGroupid() {
		return groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	public void setChatmode(Byte chatmode) {
		this.chatmode = chatmode;
	}

	public Byte getDevicetype() {
		return devicetype;
	}

	public void setDevicetype(Byte devicetype) {
		this.devicetype = devicetype;
	}

	public Long getChatlinkid() {
		return chatlinkid;
	}

	public void setChatlinkid(Long chatlinkid) {
		this.chatlinkid = chatlinkid;
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

	/**
	 * @param args
	 * @author xufei 2020年2月10日 下午3:12:59
	 */
	public static void main(String[] args) {

	}
}
