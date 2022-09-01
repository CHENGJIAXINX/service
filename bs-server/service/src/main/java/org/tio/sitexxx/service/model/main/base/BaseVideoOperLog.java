package org.tio.sitexxx.service.model.main.base;

import org.tio.sitexxx.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseVideoOperLog<M extends BaseVideoOperLog<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * video的id
	 */
	public void setVid(java.lang.Integer vid) {
		set("vid", vid);
	}
	
	/**
	 * video的id
	 */
	public java.lang.Integer getVid() {
		return getInt("vid");
	}

	/**
	 * 操作人员id
	 */
	public void setUid(java.lang.Integer uid) {
		set("uid", uid);
	}
	
	/**
	 * 操作人员id
	 */
	public java.lang.Integer getUid() {
		return getInt("uid");
	}

	public void setSession(java.lang.String session) {
		set("session", session);
	}
	
	public java.lang.String getSession() {
		return getStr("session");
	}

	/**
	 * 1、点赞，2、评分，3：播放
	 */
	public void setType(java.lang.Integer type) {
		set("type", type);
	}
	
	/**
	 * 1、点赞，2、评分，3：播放
	 */
	public java.lang.Integer getType() {
		return getInt("type");
	}

	/**
	 * 操作时间
	 */
	public void setTime(java.util.Date time) {
		set("time", time);
	}
	
	/**
	 * 操作时间
	 */
	public java.util.Date getTime() {
		return get("time");
	}

	/**
	 * user_agent表的id
	 */
	public void setUaid(java.lang.Integer uaid) {
		set("uaid", uaid);
	}
	
	/**
	 * user_agent表的id
	 */
	public java.lang.Integer getUaid() {
		return getInt("uaid");
	}

	/**
	 * 操作时所在的页面
	 */
	public void setReferer(java.lang.String referer) {
		set("referer", referer);
	}
	
	/**
	 * 操作时所在的页面
	 */
	public java.lang.String getReferer() {
		return getStr("referer");
	}

	/**
	 * 操作时的设备类型
	 */
	public void setDevice(java.lang.Byte device) {
		set("device", device);
	}
	
	/**
	 * 操作时的设备类型
	 */
	public java.lang.Byte getDevice() {
		return getByte("device");
	}

}
