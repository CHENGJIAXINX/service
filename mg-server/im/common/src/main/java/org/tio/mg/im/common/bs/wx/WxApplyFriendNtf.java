/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.common.bs.wx;


import java.io.Serializable;

import org.tio.mg.service.vo.SimpleUser;

/**
 *  服务器通知用户"有人请求加你为好友啦"-- Server-->Client
 * @author tanyaowu
 */
public class WxApplyFriendNtf implements Serializable {
	private static final long serialVersionUID = -5030663203373490706L;

	private SimpleUser from;

	public SimpleUser getFrom() {
		return from;
	}

	public void setFrom(SimpleUser from) {
		this.from = from;
	}
}
