package org.tio.mg.service.model.mg.base;

import org.tio.mg.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMgUserToken<M extends BaseMgUserToken<M>> extends TioModel<M> implements IBean {

	/**
	 * userid
	 */
	public void setMguid(java.lang.Integer mguid) {
		set("mguid", mguid);
	}
	
	/**
	 * userid
	 */
	public java.lang.Integer getMguid() {
		return getInt("mguid");
	}

	/**
	 * 1：pc， 2：安卓，3：IOS
	 */
	public void setDevicetype(java.lang.Byte devicetype) {
		set("devicetype", devicetype);
	}
	
	/**
	 * 1：pc， 2：安卓，3：IOS
	 */
	public java.lang.Byte getDevicetype() {
		return getByte("devicetype");
	}

	public void setToken(java.lang.String token) {
		set("token", token);
	}
	
	public java.lang.String getToken() {
		return getStr("token");
	}

}
