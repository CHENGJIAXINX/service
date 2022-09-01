package org.tio.mg.service.model.main.base;

import org.tio.mg.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseWxUserGrabRedItem<M extends BaseWxUserGrabRedItem<M>> extends TioModel<M> implements IBean {

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
	 * 业务id；私聊：touid；群聊：groupid
	 */
	public void setChatbizid(java.lang.Long chatbizid) {
		set("chatbizid", chatbizid);
	}
	
	/**
	 * 业务id；私聊：touid；群聊：groupid
	 */
	public java.lang.Long getChatbizid() {
		return getLong("chatbizid");
	}

	/**
	 * 聊天模式：1：私聊；2：群聊
	 */
	public void setChatmode(java.lang.Byte chatmode) {
		set("chatmode", chatmode);
	}
	
	/**
	 * 聊天模式：1：私聊；2：群聊
	 */
	public java.lang.Byte getChatmode() {
		return getByte("chatmode");
	}

	/**
	 * 发送方uid
	 */
	public void setSenduid(java.lang.Integer senduid) {
		set("senduid", senduid);
	}
	
	/**
	 * 发送方uid
	 */
	public java.lang.Integer getSenduid() {
		return getInt("senduid");
	}

	/**
	 * 发送方钱包id
	 */
	public void setSendwalletid(java.lang.String sendwalletid) {
		set("sendwalletid", sendwalletid);
	}
	
	/**
	 * 发送方钱包id
	 */
	public java.lang.String getSendwalletid() {
		return getStr("sendwalletid");
	}

	/**
	 * 发红包的id
	 */
	public void setSendid(java.lang.Integer sendid) {
		set("sendid", sendid);
	}
	
	/**
	 * 发红包的id
	 */
	public java.lang.Integer getSendid() {
		return getInt("sendid");
	}

	public void setSendserialnumber(java.lang.String sendserialnumber) {
		set("sendserialnumber", sendserialnumber);
	}
	
	public java.lang.String getSendserialnumber() {
		return getStr("sendserialnumber");
	}

	/**
	 * 钱包id
	 */
	public void setWalletid(java.lang.String walletid) {
		set("walletid", walletid);
	}
	
	/**
	 * 钱包id
	 */
	public java.lang.String getWalletid() {
		return getStr("walletid");
	}

	/**
	 * 商户号
	 */
	public void setBizid(java.lang.String bizid) {
		set("bizid", bizid);
	}
	
	/**
	 * 商户号
	 */
	public java.lang.String getBizid() {
		return getStr("bizid");
	}

	/**
	 * 请求id
	 */
	public void setReqid(java.lang.String reqid) {
		set("reqid", reqid);
	}
	
	/**
	 * 请求id
	 */
	public java.lang.String getReqid() {
		return getStr("reqid");
	}

	/**
	 * 发红包流水号
	 */
	public void setSerialnumber(java.lang.String serialnumber) {
		set("serialnumber", serialnumber);
	}
	
	/**
	 * 发红包流水号
	 */
	public java.lang.String getSerialnumber() {
		return getStr("serialnumber");
	}

	/**
	 * 红包总金额(分）
	 */
	public void setAmount(java.lang.Integer amount) {
		set("amount", amount);
	}
	
	/**
	 * 红包总金额(分）
	 */
	public java.lang.Integer getAmount() {
		return getInt("amount");
	}

	/**
	 * 初始化状态：INIT；成功：SUCCESS；取消：CANCEL
	 */
	public void setStatus(java.lang.String status) {
		set("status", status);
	}
	
	/**
	 * 初始化状态：INIT；成功：SUCCESS；取消：CANCEL
	 */
	public java.lang.String getStatus() {
		return getStr("status");
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
	 * 红包完成时间-抢完/超市
	 */
	public void setBizcompletetime(java.lang.String bizcompletetime) {
		set("bizcompletetime", bizcompletetime);
	}
	
	/**
	 * 红包完成时间-抢完/超市
	 */
	public java.lang.String getBizcompletetime() {
		return getStr("bizcompletetime");
	}

	/**
	 * 订单错误信息
	 */
	public void setOrdererrormsg(java.lang.String ordererrormsg) {
		set("ordererrormsg", ordererrormsg);
	}
	
	/**
	 * 订单错误信息
	 */
	public java.lang.String getOrdererrormsg() {
		return getStr("ordererrormsg");
	}

	/**
	 * 本地错误
	 */
	public void setLocalerrormsg(java.lang.String localerrormsg) {
		set("localerrormsg", localerrormsg);
	}
	
	/**
	 * 本地错误
	 */
	public java.lang.String getLocalerrormsg() {
		return getStr("localerrormsg");
	}

	/**
	 * 同步状态：1：已完成；2：未完成
	 */
	public void setCoinsyn(java.lang.Byte coinsyn) {
		set("coinsyn", coinsyn);
	}
	
	/**
	 * 同步状态：1：已完成；2：未完成
	 */
	public java.lang.Byte getCoinsyn() {
		return getByte("coinsyn");
	}

	/**
	 * 发起的ip
	 */
	public void setIp(java.lang.String ip) {
		set("ip", ip);
	}
	
	/**
	 * 发起的ip
	 */
	public java.lang.String getIp() {
		return getStr("ip");
	}

	/**
	 * 发起的设备类型（DeviceType），1：PC，2：安卓，3：IOS
	 */
	public void setDevice(java.lang.Byte device) {
		set("device", device);
	}
	
	/**
	 * 发起的设备类型（DeviceType），1：PC，2：安卓，3：IOS
	 */
	public java.lang.Byte getDevice() {
		return getByte("device");
	}

	/**
	 * 发起的app版本号
	 */
	public void setAppversion(java.lang.String appversion) {
		set("appversion", appversion);
	}
	
	/**
	 * 发起的app版本号
	 */
	public java.lang.String getAppversion() {
		return getStr("appversion");
	}

	/**
	 * 队列处理时间
	 */
	public void setQueuetime(java.util.Date queuetime) {
		set("queuetime", queuetime);
	}
	
	/**
	 * 队列处理时间
	 */
	public java.util.Date getQueuetime() {
		return get("queuetime");
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
