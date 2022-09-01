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
public class GrabRedpacketVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7132289661870632884L;

	/**
	 * uid-Y
	 */
	private Integer uid;
	
	/**
	 * 钱包id
	 */
	private String walletid;
	
	/**
	 * 红包流水
	 */
	private String serialnumber;
	
	/**
	 * 会话信息
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
	
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public Long getChatlinkid() {
		return chatlinkid;
	}

	public void setChatlinkid(Long chatlinkid) {
		this.chatlinkid = chatlinkid;
	}

	public Long getBizid() {
		return bizid;
	}

	public void setBizid(Long bizid) {
		this.bizid = bizid;
	}

	public Byte getChatmode() {
		return chatmode;
	}

	public void setChatmode(Byte chatmode) {
		this.chatmode = chatmode;
	}

	public String getWalletid() {
		return walletid;
	}

	public void setWalletid(String walletid) {
		this.walletid = walletid;
	}

	
	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
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
	public static GrabRedpacketVo toBean(Map<String, Object> map) {
		return BeanUtil.fillBeanWithMap(map, new GrabRedpacketVo(), true);
	}
}
