package org.tio.mg.service.model.main.base;

import org.tio.mg.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseWxUserRechargeItem<M extends BaseWxUserRechargeItem<M>> extends TioModel<M> implements IBean {

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
	 * 支付流水号
	 */
	public void setSerialnumber(java.lang.String serialnumber) {
		set("serialnumber", serialnumber);
	}
	
	/**
	 * 支付流水号
	 */
	public java.lang.String getSerialnumber() {
		return getStr("serialnumber");
	}

	/**
	 * 币种
	 */
	public void setCurrency(java.lang.String currency) {
		set("currency", currency);
	}
	
	/**
	 * 币种
	 */
	public java.lang.String getCurrency() {
		return getStr("currency");
	}

	/**
	 * 充值金额(分)
	 */
	public void setAmount(java.lang.Integer amount) {
		set("amount", amount);
	}
	
	/**
	 * 充值金额(分)
	 */
	public java.lang.Integer getAmount() {
		return getInt("amount");
	}

	/**
	 * 预支付的token值
	 */
	public void setToken(java.lang.String token) {
		set("token", token);
	}
	
	/**
	 * 预支付的token值
	 */
	public java.lang.String getToken() {
		return getStr("token");
	}

	/**
	 * 备注：商户传输附加值
	 */
	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}
	
	/**
	 * 备注：商户传输附加值
	 */
	public java.lang.String getRemark() {
		return getStr("remark");
	}

	/**
	 * 状态：初始化：INIT;成功：SUCCESS;取消：CANCEL;失败：FAIL
	 */
	public void setStatus(java.lang.String status) {
		set("status", status);
	}
	
	/**
	 * 状态：初始化：INIT;成功：SUCCESS;取消：CANCEL;失败：FAIL
	 */
	public java.lang.String getStatus() {
		return getStr("status");
	}

	/**
	 * 超时设置：1-1440分
	 */
	public void setTimeout(java.lang.Short timeout) {
		set("timeout", timeout);
	}
	
	/**
	 * 超时设置：1-1440分
	 */
	public java.lang.Short getTimeout() {
		return getShort("timeout");
	}

	/**
	 * 回调url
	 */
	public void setNotifyurl(java.lang.String notifyurl) {
		set("notifyurl", notifyurl);
	}
	
	/**
	 * 回调url
	 */
	public java.lang.String getNotifyurl() {
		return getStr("notifyurl");
	}

	/**
	 * 银行卡卡号-掩码
	 */
	public void setBankcardnumber(java.lang.String bankcardnumber) {
		set("bankcardnumber", bankcardnumber);
	}
	
	/**
	 * 银行卡卡号-掩码
	 */
	public java.lang.String getBankcardnumber() {
		return getStr("bankcardnumber");
	}

	/**
	 * 银行代码
	 */
	public void setBankcode(java.lang.String bankcode) {
		set("bankcode", bankcode);
	}
	
	/**
	 * 银行代码
	 */
	public java.lang.String getBankcode() {
		return getStr("bankcode");
	}

	/**
	 * 银行名称
	 */
	public void setBankname(java.lang.String bankname) {
		set("bankname", bankname);
	}
	
	/**
	 * 银行名称
	 */
	public java.lang.String getBankname() {
		return getStr("bankname");
	}

	/**
	 * 银行icon
	 */
	public void setBankicon(java.lang.String bankicon) {
		set("bankicon", bankicon);
	}
	
	/**
	 * 银行icon
	 */
	public java.lang.String getBankicon() {
		return getStr("bankicon");
	}

	/**
	 * 查询同步:1：回调成功；2：否；3：查询同步
	 */
	public void setQuerysyn(java.lang.Byte querysyn) {
		set("querysyn", querysyn);
	}
	
	/**
	 * 查询同步:1：回调成功；2：否；3：查询同步
	 */
	public java.lang.Byte getQuerysyn() {
		return getByte("querysyn");
	}

	/**
	 * 预下单创建时间
	 */
	public void setBizcreattime(java.lang.String bizcreattime) {
		set("bizcreattime", bizcreattime);
	}
	
	/**
	 * 预下单创建时间
	 */
	public java.lang.String getBizcreattime() {
		return getStr("bizcreattime");
	}

	/**
	 * 订单完成时间
	 */
	public void setBizcompletetime(java.lang.String bizcompletetime) {
		set("bizcompletetime", bizcompletetime);
	}
	
	/**
	 * 订单完成时间
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
	 * 同步状态：1：初始化处理；2：未处理；3：完成
	 */
	public void setCoinsyn(java.lang.Byte coinsyn) {
		set("coinsyn", coinsyn);
	}
	
	/**
	 * 同步状态：1：初始化处理；2：未处理；3：完成
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
