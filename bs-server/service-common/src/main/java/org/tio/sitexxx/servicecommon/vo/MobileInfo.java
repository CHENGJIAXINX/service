/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo;

import java.io.Serializable;

/**
 * @author tanyaowu
 * 2016年10月16日 下午4:03:25
 */
public class MobileInfo implements Serializable {
	private static final long serialVersionUID = 4976062686930336478L;

	/**
	 * @param args
	 * @author: tanyaowu
	 */
	public static void main(String[] args) {

	}

	public MobileInfo() {
	}

	/**
	 * 2：安卓，3：IOS
	 */
	private Byte devicetype;
	
	/**
	 * 手机型号, 形如：huawei p6
	 */
	private String deviceinfo;
	
	/**
	 * 是否是app
	 */
	private boolean	 fromApp = false;

	/**
	 *
	 */
	private String imei;

	/**
	 * App版本
	 */
	private String appversion;

	/**
	 * 渠道
	 */
	private String cid;

	/**
	 * 分辨率
	 */
	private String resolution;

	/**
	 * 手机屏幕，多少英寸
	 */
	private String size;

	/**
	 * 运营商
	 */
	private String operator;

	public String getAppversion() {
		return appversion;
	}

	public String getCid() {
		return cid;
	}

	public String getDeviceinfo() {
		return deviceinfo;
	}

	public Byte getDevicetype() {
		return devicetype;
	}

	public String getImei() {
		return imei;
	}

	public String getOperator() {
		return operator;
	}

	public String getResolution() {
		return resolution;
	}

	public String getSize() {
		return size;
	}

	public void setAppversion(String appversion) {
		this.appversion = appversion;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public void setDeviceinfo(String deviceinfo) {
		this.deviceinfo = deviceinfo;
	}

	public void setDevicetype(Byte devicetype) {
		this.devicetype = devicetype;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public boolean isFromApp() {
		return fromApp;
	}

	public void setFromApp(boolean fromApp) {
		this.fromApp = fromApp;
	}
}
