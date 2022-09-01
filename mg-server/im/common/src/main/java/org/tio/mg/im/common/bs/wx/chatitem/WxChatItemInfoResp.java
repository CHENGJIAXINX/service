/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.common.bs.wx.chatitem;

import java.io.Serializable;

import org.tio.mg.service.model.main.WxChatItems;


/**
 * 获取会话信息--响应-- Server-->Client
 * @author xufei
 * 2020年3月10日 下午3:18:01
 */
public class WxChatItemInfoResp implements Serializable {
	private static final long serialVersionUID = -526032926464073384L;
	private WxChatItems data;
	
	private Long chatlinkid;

	public Long getChatlinkid() {
		return chatlinkid;
	}
	
	public void setChatlinkid(Long chatlinkid) {
		this.chatlinkid = chatlinkid;
	}

	public WxChatItems getData() {
		return data;
	}

	public void setData(WxChatItems data) {
		this.data = data;
	}
}
