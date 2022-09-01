package org.tio.sitexxx.service.model.stat.base;

import org.tio.sitexxx.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseStatUser<M extends BaseStatUser<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 1-注册统计 2-登录统计
	 */
	public void setStatType(java.lang.Integer statType) {
		set("stat_type", statType);
	}
	
	/**
	 * 1-注册统计 2-登录统计
	 */
	public java.lang.Integer getStatType() {
		return getInt("stat_type");
	}

	/**
	 * 1-分 2-时 3-日 4-月
	 */
	public void setStatPeriod(java.lang.Integer statPeriod) {
		set("stat_period", statPeriod);
	}
	
	/**
	 * 1-分 2-时 3-日 4-月
	 */
	public java.lang.Integer getStatPeriod() {
		return getInt("stat_period");
	}

	public void setStatTime(java.lang.String statTime) {
		set("stat_time", statTime);
	}
	
	public java.lang.String getStatTime() {
		return getStr("stat_time");
	}

	public void setStatCount(java.lang.Integer statCount) {
		set("stat_count", statCount);
	}
	
	public java.lang.Integer getStatCount() {
		return getInt("stat_count");
	}

}
