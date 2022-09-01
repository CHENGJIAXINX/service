package org.tio.mg.service.model.stat.base;

import org.tio.mg.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAreaStat<M extends BaseAreaStat<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 市
	 */
	public void setCity(java.lang.String city) {
		set("city", city);
	}
	
	/**
	 * 市
	 */
	public java.lang.String getCity() {
		return getStr("city");
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
	 * 类型：1：注册
	 */
	public void setType(java.lang.Byte type) {
		set("type", type);
	}
	
	/**
	 * 类型：1：注册
	 */
	public java.lang.Byte getType() {
		return getByte("type");
	}

	/**
	 * 统计数据
	 */
	public void setBizcount(java.lang.Integer bizcount) {
		set("bizcount", bizcount);
	}
	
	/**
	 * 统计数据
	 */
	public java.lang.Integer getBizcount() {
		return getInt("bizcount");
	}

	public void setCitychatindex(java.lang.String citychatindex) {
		set("citychatindex", citychatindex);
	}
	
	public java.lang.String getCitychatindex() {
		return getStr("citychatindex");
	}

	/**
	 * 字母排序
	 */
	public void setCharindex(java.lang.String charindex) {
		set("charindex", charindex);
	}
	
	/**
	 * 字母排序
	 */
	public java.lang.String getCharindex() {
		return getStr("charindex");
	}

	/**
	 * 创建时间
	 */
	public void setCreatetime(java.util.Date createtime) {
		set("createtime", createtime);
	}
	
	/**
	 * 创建时间
	 */
	public java.util.Date getCreatetime() {
		return get("createtime");
	}

	/**
	 * 修改时间
	 */
	public void setUpdatetime(java.util.Date updatetime) {
		set("updatetime", updatetime);
	}
	
	/**
	 * 修改时间
	 */
	public java.util.Date getUpdatetime() {
		return get("updatetime");
	}

}
