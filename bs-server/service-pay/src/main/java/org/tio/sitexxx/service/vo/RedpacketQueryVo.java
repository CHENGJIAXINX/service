/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.vo;

import java.io.Serializable;
import java.util.Map;

import org.tio.sitexxx.service.model.main.WxUserSendRedItem;

import cn.hutool.core.bean.BeanUtil;

/**
 * 查红包vo
 * @author xufei
 * 2020年11月2日 下午7:07:44
 */
public class RedpacketQueryVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5027807607213742040L;

	/**
	 * uid-Y
	 */
	private Integer uid;
	
	/**
	 * 钱包id
	 */
	private String walletid;
	
	/**
	 * 查询方式：SIMPLE-简单
	 * 细节：DETAIL
	 * 
	 */
	private String queryType;
	
	/**
	 * 序列号
	 */
	private String serialnumber;
	
	/**
	 * 
	 */
	private WxUserSendRedItem send;
	
	
	/**
	 * 请求号
	 */
	private String reqid;
	
	public WxUserSendRedItem getSend() {
		return send;
	}

	public void setSend(WxUserSendRedItem send) {
		this.send = send;
	}

	public String getReqid() {
		return reqid;
	}

	public void setReqid(String reqid) {
		this.reqid = reqid;
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

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
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
	public static RedpacketQueryVo toBean(Map<String, Object> map) {
		return BeanUtil.fillBeanWithMap(map, new RedpacketQueryVo(), true);
	}
}
