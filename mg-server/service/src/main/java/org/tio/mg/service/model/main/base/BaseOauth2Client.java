package org.tio.mg.service.model.main.base;

import org.tio.mg.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseOauth2Client<M extends BaseOauth2Client<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public void setClientName(java.lang.String clientName) {
		set("client_name", clientName);
	}
	
	public java.lang.String getClientName() {
		return getStr("client_name");
	}

	/**
	 * 很多平台叫app_id
	 */
	public void setClientId(java.lang.String clientId) {
		set("client_id", clientId);
	}
	
	/**
	 * 很多平台叫app_id
	 */
	public java.lang.String getClientId() {
		return getStr("client_id");
	}

	public void setClientSecret(java.lang.String clientSecret) {
		set("client_secret", clientSecret);
	}
	
	public java.lang.String getClientSecret() {
		return getStr("client_secret");
	}

	/**
	 * 状态：1、有效，2、无效
	 */
	public void setStatus(java.lang.Byte status) {
		set("status", status);
	}
	
	/**
	 * 状态：1、有效，2、无效
	 */
	public java.lang.Byte getStatus() {
		return getByte("status");
	}

	/**
	 * 备注
	 */
	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}
	
	/**
	 * 备注
	 */
	public java.lang.String getRemark() {
		return getStr("remark");
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

}
