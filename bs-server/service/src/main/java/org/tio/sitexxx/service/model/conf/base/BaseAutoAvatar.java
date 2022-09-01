package org.tio.sitexxx.service.model.conf.base;

import org.tio.sitexxx.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAutoAvatar<M extends BaseAutoAvatar<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 字符
	 */
	public void setChatindex(java.lang.String chatindex) {
		set("chatindex", chatindex);
	}
	
	/**
	 * 字符
	 */
	public java.lang.String getChatindex() {
		return getStr("chatindex");
	}

	/**
	 * 本服务器上有路径
	 */
	public void setPath(java.lang.String path) {
		set("path", path);
	}
	
	/**
	 * 本服务器上有路径
	 */
	public java.lang.String getPath() {
		return getStr("path");
	}

	/**
	 * 原始的网址地址
	 */
	public void setInitUrl(java.lang.String initUrl) {
		set("init_url", initUrl);
	}
	
	/**
	 * 原始的网址地址
	 */
	public java.lang.String getInitUrl() {
		return getStr("init_url");
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

	public void setCreatetime(java.util.Date createtime) {
		set("createtime", createtime);
	}
	
	public java.util.Date getCreatetime() {
		return get("createtime");
	}

	public void setUpdatetime(java.util.Date updatetime) {
		set("updatetime", updatetime);
	}
	
	public java.util.Date getUpdatetime() {
		return get("updatetime");
	}

}
