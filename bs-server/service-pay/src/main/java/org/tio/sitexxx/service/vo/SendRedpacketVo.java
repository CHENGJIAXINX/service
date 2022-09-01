/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.vo;

import java.io.Serializable;
import java.util.Map;

import cn.hutool.core.bean.BeanUtil;

/**
 * 发红包vo
 * @author xufei
 * 2020年11月2日 下午7:07:44
 */
public class SendRedpacketVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4464819506130930255L;

	/**
	 * uid-Y
	 */
	private Integer uid;

	private String nick;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * 钱包id
	 */
	private String walletid;

	private Long timestamp;

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * 
	 * GROUP_NORMAL 普通群红包:每个最大金额为 200 元
	 * ONE_TO_ONE 一对一:最大金额为 200 元
	 * GROUP_LUCK 拼手气红包:总金额=人数*200 元
	 * 
	 * 普通红包:1;手气红包:2
	 */
	private Byte packetType;
	
	/**
	 * 单笔金额:以分为单位普通红包、一对一红包必传此值
	 */
	private String singleAmount;
	
	/**
	 * 总金额：以分为单位拼手气红包必传此值
	 */
	private String amount;
	
	/**
	 * 红包数量:一对一红包数量为 1，普通群红包和拼手气红包 数量最大 100 个
	 */
	private Short packetCount;
	
	/**
	 * 通知地址
	 */
	private String notifyUrl;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 会话id
	 */
	private Long chatlinkid;
	
	/**
	 * 会话业务id
	 */
	private Long bizid;
	
	/**
	 * 会话模型
	 */
	private Byte chatmode;
	
	/**
	 * 币种
	 */
	private String currency = "CNY";

	private String passwd;

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Byte getChatmode() {
		return chatmode;
	}

	public void setChatmode(Byte chatmode) {
		this.chatmode = chatmode;
	}

	public Byte getPacketType() {
		return packetType;
	}
	
	public Long getBizid() {
		return bizid;
	}

	public void setBizid(Long bizid) {
		this.bizid = bizid;
	}



	public void setPacketType(Byte packetType) {
		this.packetType = packetType;
	}

	public String getSingleAmount() {
		return singleAmount;
	}

	public void setSingleAmount(String singleAmount) {
		this.singleAmount = singleAmount;
	}

	public Short getPacketCount() {
		return packetCount;
	}

	public void setPacketCount(Short packetCount) {
		this.packetCount = packetCount;
	}

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

	public Long getChatlinkid() {
		return chatlinkid;
	}

	public void setChatlinkid(Long chatlinkid) {
		this.chatlinkid = chatlinkid;
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
	public static SendRedpacketVo toBean(Map<String, Object> map) {
		return BeanUtil.fillBeanWithMap(map, new SendRedpacketVo(), true);
	}
}
