/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.vo;

import java.io.Serializable;
import java.util.Map;

import cn.hutool.core.bean.BeanUtil;

/**
 * 客户端token信息vo
 * @author xufei
 * 2020年11月2日 下午7:07:44
 */
public class ClientTokenVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4085453581573585030L;

	/**
	 * uid-Y
	 */
	private Integer uid;
	
	/**
	 * 钱包id
	 */
	private String walletid;
	
	/**
	 * 业务类型：
	 * 唤起安全设置页面： ACCESS_SAFETY
	 * 唤起卡列表页面： ACCESS_CARDlIST
	 */
	private String bizType;
	
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
	
	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
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
	public static ClientTokenVo toBean(Map<String, Object> walletMap) {
		return BeanUtil.fillBeanWithMap(walletMap, new ClientTokenVo(), true);
	}
}
