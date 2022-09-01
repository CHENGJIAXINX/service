/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.common.bs;

import java.io.Serializable;

/**
 * 获取p2p聊天记录数据-请求
 * @author tanyaowu
 *
 */
public class P2pQueryChatRecordReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2935567695412664238L;

	/**
	 * 对方的uid
	 */
	private Integer uid;

	public P2pQueryChatRecordReq() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}
