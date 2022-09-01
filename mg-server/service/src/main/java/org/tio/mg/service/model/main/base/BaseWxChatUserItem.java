package org.tio.mg.service.model.main.base;

import org.tio.mg.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseWxChatUserItem<M extends BaseWxChatUserItem<M>> extends TioModel<M> implements IBean {

	/**
	 * 用户的uid
	 */
	public void setUid(java.lang.Integer uid) {
		set("uid", uid);
	}
	
	/**
	 * 用户的uid
	 */
	public java.lang.Integer getUid() {
		return getInt("uid");
	}

	/**
	 * 聊天模型：1：私聊；2：群聊
	 */
	public void setChatmode(java.lang.Byte chatmode) {
		set("chatmode", chatmode);
	}
	
	/**
	 * 聊天模型：1：私聊；2：群聊
	 */
	public java.lang.Byte getChatmode() {
		return getByte("chatmode");
	}

	/**
	 * 业务id：群聊-groupid；私聊：对方uid
	 */
	public void setBizid(java.lang.Long bizid) {
		set("bizid", bizid);
	}
	
	/**
	 * 业务id：群聊-groupid；私聊：对方uid
	 */
	public java.lang.Long getBizid() {
		return getLong("bizid");
	}

	/**
	 * 聊天id
	 */
	public void setChatlinkid(java.lang.Long chatlinkid) {
		set("chatlinkid", chatlinkid);
	}
	
	/**
	 * 聊天id
	 */
	public java.lang.Long getChatlinkid() {
		return getLong("chatlinkid");
	}

	public void setChatlinkmetaid(java.lang.Long chatlinkmetaid) {
		set("chatlinkmetaid", chatlinkmetaid);
	}
	
	public java.lang.Long getChatlinkmetaid() {
		return getLong("chatlinkmetaid");
	}

	/**
	 * 私聊对方的聊天列表id
	 */
	public void setTochatlinkid(java.lang.Long tochatlinkid) {
		set("tochatlinkid", tochatlinkid);
	}
	
	/**
	 * 私聊对方的聊天列表id
	 */
	public java.lang.Long getTochatlinkid() {
		return getLong("tochatlinkid");
	}

	public void setTochatlinkmetaid(java.lang.Long tochatlinkmetaid) {
		set("tochatlinkmetaid", tochatlinkmetaid);
	}
	
	public java.lang.Long getTochatlinkmetaid() {
		return getLong("tochatlinkmetaid");
	}

	/**
	 * 私聊好友id/群用户id
	 */
	public void setLinkid(java.lang.Long linkid) {
		set("linkid", linkid);
	}
	
	/**
	 * 私聊好友id/群用户id
	 */
	public java.lang.Long getLinkid() {
		return getLong("linkid");
	}

	/**
	 * 好友组合uid的key-twouid
	 */
	public void setFidkey(java.lang.String fidkey) {
		set("fidkey", fidkey);
	}
	
	/**
	 * 好友组合uid的key-twouid
	 */
	public java.lang.String getFidkey() {
		return getStr("fidkey");
	}

	/**
	 * 是否是有效连接（是否是有效的聊天信息）：1：是；2：否
	 */
	public void setLinkflag(java.lang.Byte linkflag) {
		set("linkflag", linkflag);
	}
	
	/**
	 * 是否是有效连接（是否是有效的聊天信息）：1：是；2：否
	 */
	public java.lang.Byte getLinkflag() {
		return getByte("linkflag");
	}

	/**
	 * 从哪个消息开始有阅读权限-群组无效
	 */
	public void setStartmsgid(java.lang.Long startmsgid) {
		set("startmsgid", startmsgid);
	}
	
	/**
	 * 从哪个消息开始有阅读权限-群组无效
	 */
	public java.lang.Long getStartmsgid() {
		return getLong("startmsgid");
	}

	/**
	 * 记录创建时间
	 */
	public void setCreatetime(java.util.Date createtime) {
		set("createtime", createtime);
	}
	
	/**
	 * 记录创建时间
	 */
	public java.util.Date getCreatetime() {
		return get("createtime");
	}

	/**
	 * 记录更新时间
	 */
	public void setUpdatetime(java.util.Date updatetime) {
		set("updatetime", updatetime);
	}
	
	/**
	 * 记录更新时间
	 */
	public java.util.Date getUpdatetime() {
		return get("updatetime");
	}

}
