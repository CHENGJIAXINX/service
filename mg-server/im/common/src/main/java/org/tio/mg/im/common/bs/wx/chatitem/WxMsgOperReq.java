/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.common.bs.wx.chatitem;

import java.io.Serializable;

/**
 * 会话消息操作
 * @author tanyaowu 

 */
public class WxMsgOperReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8838786116225726932L;
	/**
	 * 会话id
	 */
	private Long chatlinkid;
	
	/**
	 * 操作码：1：进入；2；离开会话
	 */
	private Byte oper;
	
	public Long getChatlinkid() {
		return chatlinkid;
	}
	public void setChatlinkid(Long chatlinkid) {
		this.chatlinkid = chatlinkid;
	}
	public Byte getOper() {
		return oper;
	}
	public void setOper(Byte oper) {
		this.oper = oper;
	}

}