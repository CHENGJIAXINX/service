/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.sitexxx.im.common.bs.wx.friend;

import java.io.Serializable;

/**
 * 新版朋友间的聊天请求-- Client-->Server
 * 
 * @author xufei 2020年2月13日 下午6:28:03
 */
public class WxFriendChatReq implements Serializable {
	private static final long serialVersionUID = 7365945567713702051L;
	private String 			c; 				// 聊天内容
//	TODO:XUFEI-删除to
	private Integer 		to; 			// 消息接收者的userid
	private Long 			chatlinkid; 	// 用户聊天会话
	
	private Long				cardid;										//名片id
	private Byte				cardtype;									//名片类型
	public String getC() {
		return c;
	}

	public Long getCardid() {
		return cardid;
	}

	public void setCardid(Long cardid) {
		this.cardid = cardid;
	}

	public Byte getCardtype() {
		return cardtype;
	}

	public void setCardtype(Byte cardtype) {
		this.cardtype = cardtype;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	public Long getChatlinkid() {
		return chatlinkid;
	}

	public void setChatlinkid(Long chatlinkid) {
		this.chatlinkid = chatlinkid;
	}
}
