/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.vo;

import java.io.Serializable;
import java.util.Map;

import cn.hutool.core.bean.BeanUtil;

/**
 * 提现vo
 * @author xufei
 * 2020年11月2日 下午7:07:44
 */
public class WithholdVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1672752228173101766L;

	/**
	 * uid-Y
	 */
	private Integer uid;
	
	/**
	 * 钱包id
	 */
	private String walletid;
	
	/**
	 * 通知地址
	 */
	private String notifyUrl;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 金额
	 */
	private String amount;
	
	/**
	 * 币种
	 */
	private String currency = "CNY";
	
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getWalletid() {
		return walletid;
	}

	public void setWalletid(String walletid) {
		this.walletid = walletid;
	}
	
	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return
	 * @author xufei
	 * 2020年11月3日 下午4:58:24
	 */
	public Map<String, Object> toMap() {
		return BeanUtil.beanToMap(this);
	}
	
	/**
	 * @param userVo
	 * @return
	 * @author xufei
	 * 2020年11月3日 下午4:58:23
	 */
	public static WithholdVo toBean(Map<String, Object> map) {
		return BeanUtil.fillBeanWithMap(map, new WithholdVo(), true);
	}
}
