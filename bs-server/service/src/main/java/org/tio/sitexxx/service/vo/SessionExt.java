/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.vo;

import org.tio.sitexxx.service.model.main.LoginLog;

/**
 * @author tanyaowu 
 * 2016年9月27日 上午10:42:10
 */
public class SessionExt implements java.io.Serializable {
	private static final long serialVersionUID = 801028575637420672L;

	public SessionExt() {
		super();
	}

	/**
	 * 当前用户id
	 */
	private Integer		uid			= null;
	/**
	 * 登录时间
	 */
	private Long		loginTime	= null;
	/**
	 * 被T信息
	 */
	private LoginLog	kickedInfo	= null;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}

	public LoginLog getKickedInfo() {
		return kickedInfo;
	}

	public void setKickedInfo(LoginLog kickedInfo) {
		this.kickedInfo = kickedInfo;
	}

}
