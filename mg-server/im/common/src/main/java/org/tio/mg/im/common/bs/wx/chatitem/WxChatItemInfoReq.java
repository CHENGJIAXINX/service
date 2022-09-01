/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.common.bs.wx.chatitem;

import java.io.Serializable;

/**
 * 获取会话信息--请求-- Client-->Server
 * 
 * @author xufei
 * 2020年3月10日 下午4:16:52
 */
public class WxChatItemInfoReq implements Serializable {
	
	private static final long	serialVersionUID	= 5486977980835561814L;
	/**
	 * 聊天会话
	 */
	private Long				chatlinkid;
	

	public WxChatItemInfoReq() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	public Long getChatlinkid() {
		return chatlinkid;
	}

	public void setChatlinkid(Long chatlinkid) {
		this.chatlinkid = chatlinkid;
	}

}
