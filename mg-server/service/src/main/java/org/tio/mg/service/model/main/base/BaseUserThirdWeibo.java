package org.tio.mg.service.model.main.base;

import org.tio.mg.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUserThirdWeibo<M extends BaseUserThirdWeibo<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * user_third表的id字段
	 */
	public void setUserThirdId(java.lang.Integer userThirdId) {
		set("user_third_id", userThirdId);
	}
	
	/**
	 * user_third表的id字段
	 */
	public java.lang.Integer getUserThirdId() {
		return getInt("user_third_id");
	}

	/**
	 * 是否认证过了，1：认证过，2：未认证过，其它值：未知
	 */
	public void setVerified(java.lang.Byte verified) {
		set("verified", verified);
	}
	
	/**
	 * 是否认证过了，1：认证过，2：未认证过，其它值：未知
	 */
	public java.lang.Byte getVerified() {
		return getByte("verified");
	}

	/**
	 * 国家
	 */
	public void setCountry(java.lang.String country) {
		set("country", country);
	}
	
	/**
	 * 国家
	 */
	public java.lang.String getCountry() {
		return getStr("country");
	}

	/**
	 * 省
	 */
	public void setProvince(java.lang.String province) {
		set("province", province);
	}
	
	/**
	 * 省
	 */
	public java.lang.String getProvince() {
		return getStr("province");
	}

	/**
	 * 城市
	 */
	public void setCity(java.lang.String city) {
		set("city", city);
	}
	
	/**
	 * 城市
	 */
	public java.lang.String getCity() {
		return getStr("city");
	}

	/**
	 * 关注数（该用户关注了多少其它人）
	 */
	public void setFriends(java.lang.Integer friends) {
		set("friends", friends);
	}
	
	/**
	 * 关注数（该用户关注了多少其它人）
	 */
	public java.lang.Integer getFriends() {
		return getInt("friends");
	}

	/**
	 * 粉丝数
	 */
	public void setFollowers(java.lang.Integer followers) {
		set("followers", followers);
	}
	
	/**
	 * 粉丝数
	 */
	public java.lang.Integer getFollowers() {
		return getInt("followers");
	}

	/**
	 * 微博数
	 */
	public void setStatuses(java.lang.Integer statuses) {
		set("statuses", statuses);
	}
	
	/**
	 * 微博数
	 */
	public java.lang.Integer getStatuses() {
		return getInt("statuses");
	}

	public void setFavourites(java.lang.Integer favourites) {
		set("favourites", favourites);
	}
	
	public java.lang.Integer getFavourites() {
		return getInt("favourites");
	}

	public void setCreatedAt(java.util.Date createdAt) {
		set("created_at", createdAt);
	}
	
	public java.util.Date getCreatedAt() {
		return get("created_at");
	}

	/**
	 * 微号
	 */
	public void setWeihao(java.lang.String weihao) {
		set("weihao", weihao);
	}
	
	/**
	 * 微号
	 */
	public java.lang.String getWeihao() {
		return getStr("weihao");
	}

	/**
	 * 用户个人描述
	 */
	public void setDescription(java.lang.String description) {
		set("description", description);
	}
	
	/**
	 * 用户个人描述
	 */
	public java.lang.String getDescription() {
		return getStr("description");
	}

	/**
	 * 用户个性化域名
	 */
	public void setDomain(java.lang.String domain) {
		set("domain", domain);
	}
	
	/**
	 * 用户个性化域名
	 */
	public java.lang.String getDomain() {
		return getStr("domain");
	}

}
