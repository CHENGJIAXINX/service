/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.common.bs;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.servicecommon.vo.MobileInfo;

public class HandshakeReq implements Serializable {
	private static final long	serialVersionUID	= -8074137966541427395L;
	@SuppressWarnings("unused")
	private static Logger		log					= LoggerFactory.getLogger(HandshakeReq.class);

	private String token; //客户端通过http登录后，服务器返回给客户端的token值，没登录则为空串

	private String sign; //签名

	/**
	 * org.tio.mg.service.vo.Devicetype的枚举值
	 */
	private Byte				devicetype			= null;
	private MobileInfo			mobileInfo;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 *
	 */
	public HandshakeReq() {

	}

	public Byte getDevicetype() {
		return devicetype;
	}

	public void setDevicetype(Byte devicetype) {
		this.devicetype = devicetype;
	}

	public MobileInfo getMobileInfo() {
		return mobileInfo;
	}

	public void setMobileInfo(MobileInfo mobileInfo) {
		this.mobileInfo = mobileInfo;
	}
}
