package org.tio.mg.service.model.main.base;

import org.tio.mg.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseWxJpushUser<M extends BaseWxJpushUser<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 用户id
	 */
	public void setUid(java.lang.Integer uid) {
		set("uid", uid);
	}
	
	/**
	 * 用户id
	 */
	public java.lang.Integer getUid() {
		return getInt("uid");
	}

	/**
	 * 极光推送设备注册id
	 */
	public void setRegid(java.lang.String regid) {
		set("regid", regid);
	}
	
	/**
	 * 极光推送设备注册id
	 */
	public java.lang.String getRegid() {
		return getStr("regid");
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
	 * 该记录更新时间
	 */
	public void setUpdatetime(java.util.Date updatetime) {
		set("updatetime", updatetime);
	}
	
	/**
	 * 该记录更新时间
	 */
	public java.util.Date getUpdatetime() {
		return get("updatetime");
	}

}
