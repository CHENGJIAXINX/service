/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.vo;

import java.io.Serializable;
import java.util.Map;

import cn.hutool.core.bean.BeanUtil;

/**
 * 修改开户信息vo
 * @author xufei
 * 2020年11月2日 下午7:07:44
 */
public class UpdateOpenVo implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2143659843199864954L;

	/**
	 * uid-Y
	 */
	private Integer uid;
	
	/**
	 * 钱包id
	 */
	private String walletid;
	
	/**
	 * 手机号-Y
	 */
	private String mobile;
	
	
	/**
	 * nickName-S
	 */
	private String nickName;
	
	/**
	 * @param args
	 * @author xufei 2020年2月10日 下午3:12:59
	 */
	public static void main(String[] args) {

	}
	
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getWalletid() {
		return walletid;
	}

	public void setWalletid(String walletid) {
		this.walletid = walletid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public static UpdateOpenVo toBean(Map<String, Object> userVo) {
		return BeanUtil.fillBeanWithMap(userVo, new UpdateOpenVo(), true);
	}
}
