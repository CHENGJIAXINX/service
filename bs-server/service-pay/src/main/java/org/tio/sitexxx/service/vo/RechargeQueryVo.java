/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.vo;

import java.io.Serializable;
import java.util.Map;

import cn.hutool.core.bean.BeanUtil;

/**
 * 充值chax vo
 * @author xufei
 * 2020年11月2日 下午7:07:44
 */
/**
 * 
 * @author xufei
 * 2020年11月25日 上午10:52:42
 */
public class RechargeQueryVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6366423991922966177L;

	/**
	 * uid-Y
	 */
	private Integer uid;
	
	/**
	 * 钱包id
	 */
	private String walletid;
	
	/**
	 * 序列号
	 */
	private String serialnumber;
	
	/**
	 * 请求id
	 */
	private String reqid;
	
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

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	
	public String getReqid() {
		return reqid;
	}

	public void setReqid(String reqid) {
		this.reqid = reqid;
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
	public static RechargeQueryVo toBean(Map<String, Object> map) {
		return BeanUtil.fillBeanWithMap(map, new RechargeQueryVo(), true);
	}
}
