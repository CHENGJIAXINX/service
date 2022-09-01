package org.tio.mg.service.model.stat.base;

import org.tio.mg.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseTioIpPullblackLog<M extends BaseTioIpPullblackLog<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 被拉黑的ip
	 */
	public void setIp(java.lang.String ip) {
		set("ip", ip);
	}
	
	/**
	 * 被拉黑的ip
	 */
	public java.lang.String getIp() {
		return getStr("ip");
	}

	public void setIpid(java.lang.Integer ipid) {
		set("ipid", ipid);
	}
	
	public java.lang.Integer getIpid() {
		return getInt("ipid");
	}

	public void setUid(java.lang.Integer uid) {
		set("uid", uid);
	}
	
	public java.lang.Integer getUid() {
		return getInt("uid");
	}

	public void setSessionid(java.lang.String sessionid) {
		set("sessionid", sessionid);
	}
	
	public java.lang.String getSessionid() {
		return getStr("sessionid");
	}

	public void setInitpath(java.lang.String initpath) {
		set("initpath", initpath);
	}
	
	public java.lang.String getInitpath() {
		return getStr("initpath");
	}

	public void setPath(java.lang.String path) {
		set("path", path);
	}
	
	public java.lang.String getPath() {
		return getStr("path");
	}

	public void setRequestline(java.lang.String requestline) {
		set("requestline", requestline);
	}
	
	public java.lang.String getRequestline() {
		return getStr("requestline");
	}

	/**
	 * cookie串
	 */
	public void setCookie(java.lang.String cookie) {
		set("cookie", cookie);
	}
	
	/**
	 * cookie串
	 */
	public java.lang.String getCookie() {
		return getStr("cookie");
	}

	/**
	 *  服务器ip，my.ip配的值
	 */
	public void setServer(java.lang.String server) {
		set("server", server);
	}
	
	/**
	 *  服务器ip，my.ip配的值
	 */
	public java.lang.String getServer() {
		return getStr("server");
	}

	/**
	 * 服务器port
	 */
	public void setServerport(java.lang.Integer serverport) {
		set("serverport", serverport);
	}
	
	/**
	 * 服务器port
	 */
	public java.lang.Integer getServerport() {
		return getInt("serverport");
	}

	public void setTime(java.util.Date time) {
		set("time", time);
	}
	
	public java.util.Date getTime() {
		return get("time");
	}

	/**
	 * 拉黑类型。1：http请求过快，2：恶意攻击，3：人工拉黑
	 */
	public void setType(java.lang.Byte type) {
		set("type", type);
	}
	
	/**
	 * 拉黑类型。1：http请求过快，2：恶意攻击，3：人工拉黑
	 */
	public java.lang.Byte getType() {
		return getByte("type");
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

}
