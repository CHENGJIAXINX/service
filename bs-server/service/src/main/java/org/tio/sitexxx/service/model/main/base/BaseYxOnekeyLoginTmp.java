package org.tio.sitexxx.service.model.main.base;

import org.tio.sitexxx.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseYxOnekeyLoginTmp<M extends BaseYxOnekeyLoginTmp<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public void setMobile(java.lang.String mobile) {
		set("mobile", mobile);
	}
	
	public java.lang.String getMobile() {
		return getStr("mobile");
	}

	public void setToken(java.lang.String token) {
		set("token", token);
	}
	
	public java.lang.String getToken() {
		return getStr("token");
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

	public void setTodaytimes(java.lang.Integer todaytimes) {
		set("todaytimes", todaytimes);
	}
	
	public java.lang.Integer getTodaytimes() {
		return getInt("todaytimes");
	}

}
