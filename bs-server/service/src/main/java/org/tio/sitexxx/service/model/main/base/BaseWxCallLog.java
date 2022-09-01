package org.tio.sitexxx.service.model.main.base;

import org.tio.sitexxx.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseWxCallLog<M extends BaseWxCallLog<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	/**
	 * wx_call_item的id
	 */
	public void setCallid(java.lang.Long callid) {
		set("callid", callid);
	}
	
	/**
	 * wx_call_item的id
	 */
	public java.lang.Long getCallid() {
		return getLong("callid");
	}

	/**
	 * 日志描述
	 */
	public void setSummary(java.lang.String summary) {
		set("summary", summary);
	}
	
	/**
	 * 日志描述
	 */
	public java.lang.String getSummary() {
		return getStr("summary");
	}

	/**
	 * 日志数据
	 */
	public void setData(java.lang.String data) {
		set("data", data);
	}
	
	/**
	 * 日志数据
	 */
	public java.lang.String getData() {
		return getStr("data");
	}

	/**
	 * 触发日志的uid，如果是系统触发，则是-1
	 */
	public void setUid(java.lang.Integer uid) {
		set("uid", uid);
	}
	
	/**
	 * 触发日志的uid，如果是系统触发，则是-1
	 */
	public java.lang.Integer getUid() {
		return getInt("uid");
	}

	/**
	 * 记录时间
	 */
	public void setTime(java.util.Date time) {
		set("time", time);
	}
	
	/**
	 * 记录时间
	 */
	public java.util.Date getTime() {
		return get("time");
	}

}
