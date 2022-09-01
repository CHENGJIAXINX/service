/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */

package org.tio.sitexxx.im.common.bs.wx;

import java.io.Serializable;

/**
 * 我告诉服务器，张三发给我的私聊消息已读
 * @author tanyaowu 

 */
public class WxFriendAlreadyReadReq implements Serializable {
	private static final long serialVersionUID = -5440095646275589930L;

	/**
	 * 聊天对方的userid
	 */
	private Integer uid;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}