package org.tio.sitexxx.service.model.stat.base;

import org.tio.sitexxx.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseTioIpPathAccessStat<M extends BaseTioIpPathAccessStat<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	/**
	 * path不为null：这个ip访问这个路径的次数；path为 null：这个ip访问的次数
	 */
	public void setRequestCount(java.lang.Integer requestCount) {
		set("requestCount", requestCount);
	}
	
	/**
	 * path不为null：这个ip访问这个路径的次数；path为 null：这个ip访问的次数
	 */
	public java.lang.Integer getRequestCount() {
		return getInt("requestCount");
	}

	/**
	 * 平均每秒多少次请求
	 */
	public void setRequestCountPerSecond(java.lang.Double requestCountPerSecond) {
		set("requestCountPerSecond", requestCountPerSecond);
	}
	
	/**
	 * 平均每秒多少次请求
	 */
	public java.lang.Double getRequestCountPerSecond() {
		return getDouble("requestCountPerSecond");
	}

	/**
	 * 消耗服务器的时间，单位：毫秒
	 */
	public void setTimeCost(java.lang.Long timeCost) {
		set("timeCost", timeCost);
	}
	
	/**
	 * 消耗服务器的时间，单位：毫秒
	 */
	public java.lang.Long getTimeCost() {
		return getLong("timeCost");
	}

	/**
	 * 平均每次请求消耗服务器的时间，单位：毫秒
	 */
	public void setTimeCostPerRequest(java.lang.Double timeCostPerRequest) {
		set("timeCostPerRequest", timeCostPerRequest);
	}
	
	/**
	 * 平均每次请求消耗服务器的时间，单位：毫秒
	 */
	public java.lang.Double getTimeCostPerRequest() {
		return getDouble("timeCostPerRequest");
	}

	/**
	 * 同count字段，只是这个只统计不带session的访问次数
	 */
	public void setNoSessionCount(java.lang.Integer noSessionCount) {
		set("noSessionCount", noSessionCount);
	}
	
	/**
	 * 同count字段，只是这个只统计不带session的访问次数
	 */
	public java.lang.Integer getNoSessionCount() {
		return getInt("noSessionCount");
	}

	/**
	 * ip，此处还要有一个ip字段是因为ipid不一样的，可能ip一样
	 */
	public void setIp(java.lang.String ip) {
		set("ip", ip);
	}
	
	/**
	 * ip，此处还要有一个ip字段是因为ipid不一样的，可能ip一样
	 */
	public java.lang.String getIp() {
		return getStr("ip");
	}

	/**
	 * 客户端ip， 对应到ip表的id字段
	 */
	public void setIpid(java.lang.Integer ipid) {
		set("ipid", ipid);
	}
	
	/**
	 * 客户端ip， 对应到ip表的id字段
	 */
	public java.lang.Integer getIpid() {
		return getInt("ipid");
	}

	/**
	 * 路径，形如/user/login，如果为null则表示此条记录为ip的统计数据
	 */
	public void setPath(java.lang.String path) {
		set("path", path);
	}
	
	/**
	 * 路径，形如/user/login，如果为null则表示此条记录为ip的统计数据
	 */
	public java.lang.String getPath() {
		return getStr("path");
	}

	/**
	 * 资源类型，html, api, js, css, jpg等
	 */
	public void setRestype(java.lang.String restype) {
		set("restype", restype);
	}
	
	/**
	 * 资源类型，html, api, js, css, jpg等
	 */
	public java.lang.String getRestype() {
		return getStr("restype");
	}

	/**
	 * 形如：59分45秒717毫秒
	 */
	public void setFormatedDuration(java.lang.String formatedDuration) {
		set("formatedDuration", formatedDuration);
	}
	
	/**
	 * 形如：59分45秒717毫秒
	 */
	public java.lang.String getFormatedDuration() {
		return getStr("formatedDuration");
	}

	/**
	 * 应用类型：9、网站页面，8、网站API，1：socket pc，2、socket android，3、socket ios
	 */
	public void setAppType(java.lang.Byte appType) {
		set("appType", appType);
	}
	
	/**
	 * 应用类型：9、网站页面，8、网站API，1：socket pc，2、socket android，3、socket ios
	 */
	public java.lang.Byte getAppType() {
		return getByte("appType");
	}

	/**
	 * 服务器，可以是域名也可以是ip，配置文件中的my.ip
	 */
	public void setServer(java.lang.String server) {
		set("server", server);
	}
	
	/**
	 * 服务器，可以是域名也可以是ip，配置文件中的my.ip
	 */
	public java.lang.String getServer() {
		return getStr("server");
	}

	/**
	 * 时长类型，单位：秒，譬如60，3600等
	 */
	public void setDurationType(java.lang.Long durationType) {
		set("durationType", durationType);
	}
	
	/**
	 * 时长类型，单位：秒，譬如60，3600等
	 */
	public java.lang.Long getDurationType() {
		return getLong("durationType");
	}

	/**
	 * 当前统计了多久，单位：毫秒
	 */
	public void setDuration(java.lang.Long duration) {
		set("duration", duration);
	}
	
	/**
	 * 当前统计了多久，单位：毫秒
	 */
	public java.lang.Long getDuration() {
		return getLong("duration");
	}

	public void setFirstAccessTime(java.util.Date firstAccessTime) {
		set("firstAccessTime", firstAccessTime);
	}
	
	public java.util.Date getFirstAccessTime() {
		return get("firstAccessTime");
	}

}
