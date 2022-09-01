/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */package org.tio.sitexxx.service.model.main;

import org.tio.sitexxx.service.model.main.base.BaseWxUserSendRedItem;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class WxUserSendRedItem extends BaseWxUserSendRedItem<WxUserSendRedItem> {
	public static final WxUserSendRedItem dao = new WxUserSendRedItem().dao();
	
	public void setNick(java.lang.String nick) {
		put("nick", nick);
	}

	public java.lang.String getNick() {
		return getStr("nick");
	}

	public void setAvatar(java.lang.String avatar) {
		put("avatar", avatar);
	}

	public java.lang.String getAvatar() {
		return getStr("avatar");
	}
}
