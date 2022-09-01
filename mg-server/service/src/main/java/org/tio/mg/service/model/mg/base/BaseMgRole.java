package org.tio.mg.service.model.mg.base;

import org.tio.mg.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMgRole<M extends BaseMgRole<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 角色名称
	 */
	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	/**
	 * 角色名称
	 */
	public java.lang.String getName() {
		return getStr("name");
	}

	/**
	 * 备注
	 */
	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}
	
	/**
	 * 备注
	 */
	public java.lang.String getRemark() {
		return getStr("remark");
	}

	/**
	 * 状态：1：正常：2：不可用
	 */
	public void setStatus(java.lang.Byte status) {
		set("status", status);
	}
	
	/**
	 * 状态：1：正常：2：不可用
	 */
	public java.lang.Byte getStatus() {
		return getByte("status");
	}

	/**
	 * 排序字段
	 */
	public void setSort(java.lang.Short sort) {
		set("sort", sort);
	}
	
	/**
	 * 排序字段
	 */
	public java.lang.Short getSort() {
		return getShort("sort");
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
