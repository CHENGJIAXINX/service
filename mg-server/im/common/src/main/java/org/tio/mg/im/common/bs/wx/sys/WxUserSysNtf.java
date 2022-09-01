/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.mg.im.common.bs.wx.sys;


import java.io.Serializable;

import org.tio.mg.service.model.main.WxFriendMsg;

/**
 * 用户系统通知-- Server-->Client
 * @author xufei
 * 2020年2月19日 下午2:56:14
 */
public class WxUserSysNtf implements Serializable {
	private static final long	serialVersionUID	= 4487525418584644680L;
	private Long				mid;										//消息id，全局唯一，一条消息一个id
	private Long				t;											//消息发送时间
	private String				c;											//聊天内容
	private Integer				uid;										//发送方的userid
	private Byte				code;										//操作码：30:好友申请
	
	private String				bizdata;									//业务数据
	
	private String				fiddata;									//好友业务数据
	
	public static WxUserSysNtf from(WxFriendMsg wxFriendMsg) {
		WxUserSysNtf ret = new WxUserSysNtf();
		ret.setC(wxFriendMsg.getText());
		ret.setMid(wxFriendMsg.getId());
		ret.setT(wxFriendMsg.getTime().getTime());
		ret.setUid(wxFriendMsg.getUid());
		return ret;
	}
	
	public String getBizdata() {
		return bizdata;
	}

	public String getFiddata() {
		return fiddata;
	}

	public void setFiddata(String fiddata) {
		this.fiddata = fiddata;
	}

	public void setBizdata(String bizdata) {
		this.bizdata = bizdata;
	}

	public Byte getCode() {
		return code;
	}

	public void setCode(Byte code) {
		this.code = code;
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public Long getT() {
		return t;
	}

	public void setT(Long t) {
		this.t = t;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
}
