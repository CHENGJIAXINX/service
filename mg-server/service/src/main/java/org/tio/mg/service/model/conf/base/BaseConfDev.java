package org.tio.mg.service.model.conf.base;

import org.tio.mg.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseConfDev<M extends BaseConfDev<M>> extends TioModel<M> implements IBean {

	/**
	 * 配置标题
	 */
	public void setTitle(java.lang.String title) {
		set("title", title);
	}
	
	/**
	 * 配置标题
	 */
	public java.lang.String getTitle() {
		return getStr("title");
	}

	/**
	 * 键
	 */
	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	/**
	 * 键
	 */
	public java.lang.String getName() {
		return getStr("name");
	}

	/**
	 * 值
	 */
	public void setValue(java.lang.String value) {
		set("value", value);
	}
	
	/**
	 * 值
	 */
	public java.lang.String getValue() {
		return getStr("value");
	}

	/**
	 * 单位
	 */
	public void setUnit(java.lang.String unit) {
		set("unit", unit);
	}
	
	/**
	 * 单位
	 */
	public java.lang.String getUnit() {
		return getStr("unit");
	}

	/**
	 * 类型：1：系统；2：业务
	 */
	public void setType(java.lang.Byte type) {
		set("type", type);
	}
	
	/**
	 * 类型：1：系统；2：业务
	 */
	public java.lang.Byte getType() {
		return getByte("type");
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
	 * 该条记录更新时间
	 */
	public void setUpdatetime(java.util.Date updatetime) {
		set("updatetime", updatetime);
	}
	
	/**
	 * 该条记录更新时间
	 */
	public java.util.Date getUpdatetime() {
		return get("updatetime");
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

}
