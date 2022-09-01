package org.tio.sitexxx.service.model.stat.base;

import org.tio.sitexxx.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseImeiStat<M extends BaseImeiStat<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * imei
	 */
	public void setImei(java.lang.String imei) {
		set("imei", imei);
	}
	
	/**
	 * imei
	 */
	public java.lang.String getImei() {
		return getStr("imei");
	}

	/**
	 * 第一次访问时的版本号
	 */
	public void setAppversion(java.lang.String appversion) {
		set("appversion", appversion);
	}
	
	/**
	 * 第一次访问时的版本号
	 */
	public java.lang.String getAppversion() {
		return getStr("appversion");
	}

	/**
	 * 第一次访问时的渠道号
	 */
	public void setCid(java.lang.String cid) {
		set("cid", cid);
	}
	
	/**
	 * 第一次访问时的渠道号
	 */
	public java.lang.String getCid() {
		return getStr("cid");
	}

	/**
	 * 手机分辨率，譬如1080,1344
	 */
	public void setResolution(java.lang.String resolution) {
		set("resolution", resolution);
	}
	
	/**
	 * 手机分辨率，譬如1080,1344
	 */
	public java.lang.String getResolution() {
		return getStr("resolution");
	}

	/**
	 * 手机尺寸
	 */
	public void setSize(java.lang.String size) {
		set("size", size);
	}
	
	/**
	 * 手机尺寸
	 */
	public java.lang.String getSize() {
		return getStr("size");
	}

	/**
	 * 手机信息
	 */
	public void setDeviceinfo(java.lang.String deviceinfo) {
		set("deviceinfo", deviceinfo);
	}
	
	/**
	 * 手机信息
	 */
	public java.lang.String getDeviceinfo() {
		return getStr("deviceinfo");
	}

	/**
	 * 类型。2：安卓，3：IOS
	 */
	public void setType(java.lang.Byte type) {
		set("type", type);
	}
	
	/**
	 * 类型。2：安卓，3：IOS
	 */
	public java.lang.Byte getType() {
		return getByte("type");
	}

	/**
	 * 第一次访问时间
	 */
	public void setTime(java.util.Date time) {
		set("time", time);
	}
	
	/**
	 * 第一次访问时间
	 */
	public java.util.Date getTime() {
		return get("time");
	}

	/**
	 * 第一次访问ip
	 */
	public void setIp(java.lang.String ip) {
		set("ip", ip);
	}
	
	/**
	 * 第一次访问ip
	 */
	public java.lang.String getIp() {
		return getStr("ip");
	}

	/**
	 * ipinfo表的id
	 */
	public void setIpid(java.lang.Integer ipid) {
		set("ipid", ipid);
	}
	
	/**
	 * ipinfo表的id
	 */
	public java.lang.Integer getIpid() {
		return getInt("ipid");
	}

	/**
	 * 第一次访问url
	 */
	public void setUrl(java.lang.String url) {
		set("url", url);
	}
	
	/**
	 * 第一次访问url
	 */
	public java.lang.String getUrl() {
		return getStr("url");
	}

	/**
	 * idfa
	 */
	public void setIdfa(java.lang.String idfa) {
		set("idfa", idfa);
	}
	
	/**
	 * idfa
	 */
	public java.lang.String getIdfa() {
		return getStr("idfa");
	}

}
