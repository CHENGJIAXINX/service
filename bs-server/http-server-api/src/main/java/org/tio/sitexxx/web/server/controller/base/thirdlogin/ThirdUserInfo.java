/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.controller.base.thirdlogin;

import java.io.Serializable;

/**
 * 第三方登录的用户信息
 * @author tanyaowu
 *
 */
public class ThirdUserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2611183869310773035L;

	/**
	 * 
	 */
	private String	openid;
	/**
	 * 用户头像
	 */
	private String	avatar;

	/**
	 * 用户昵称
	 */
	private String nick;

	private Integer sex;

	private String city;

	/**
	 * 
	 */
	public ThirdUserInfo() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
