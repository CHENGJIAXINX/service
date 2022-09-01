package org.tio.sitexxx.service.model.main.base;

import org.tio.sitexxx.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseWxFriendMeta<M extends BaseWxFriendMeta<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	/**
	 * 好友id
	 */
	public void setUid(java.lang.Integer uid) {
		set("uid", uid);
	}
	
	/**
	 * 好友id
	 */
	public java.lang.Integer getUid() {
		return getInt("uid");
	}

	/**
	 * 好友id
	 */
	public void setTouid(java.lang.Integer touid) {
		set("touid", touid);
	}
	
	/**
	 * 好友id
	 */
	public java.lang.Integer getTouid() {
		return getInt("touid");
	}

	/**
	 * 还有关联key
	 */
	public void setFidkey(java.lang.String fidkey) {
		set("fidkey", fidkey);
	}
	
	/**
	 * 还有关联key
	 */
	public java.lang.String getFidkey() {
		return getStr("fidkey");
	}

	/**
	 * 最后一条消息id
	 */
	public void setLastmsgid(java.lang.Long lastmsgid) {
		set("lastmsgid", lastmsgid);
	}
	
	/**
	 * 最后一条消息id
	 */
	public java.lang.Long getLastmsgid() {
		return getLong("lastmsgid");
	}

	/**
	 * 消息条数
	 */
	public void setMsgcount(java.lang.Integer msgcount) {
		set("msgcount", msgcount);
	}
	
	/**
	 * 消息条数
	 */
	public java.lang.Integer getMsgcount() {
		return getInt("msgcount");
	}

	/**
	 * 更新时间
	 */
	public void setUpdatetime(java.util.Date updatetime) {
		set("updatetime", updatetime);
	}
	
	/**
	 * 更新时间
	 */
	public java.util.Date getUpdatetime() {
		return get("updatetime");
	}

	/**
	 * 创建时间
	 */
	public void setCreatetime(java.util.Date createtime) {
		set("createtime", createtime);
	}
	
	/**
	 * 创建时间
	 */
	public java.util.Date getCreatetime() {
		return get("createtime");
	}

}
