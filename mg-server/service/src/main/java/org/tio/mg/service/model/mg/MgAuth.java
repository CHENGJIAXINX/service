/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.model.mg;

import java.util.List;

import org.tio.mg.service.model.mg.base.BaseMgAuth;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class MgAuth extends BaseMgAuth<MgAuth> {
	public static final MgAuth dao = new MgAuth().dao();
	
	private String childids = "";
	
	private String inchildids = "";
	
	public String getInchildids() {
		return inchildids;
	}

	public void setInchildids(String inchildids) {
		this.inchildids = inchildids;
	}

	public java.lang.Integer getSelid() {
		return getInt("selid");
	}

	public void setSelid(java.lang.Integer selid) {
		put("selid", selid);
	}
	
	public String getChildids() {
		return childids;
	}

	public void setChildids(String childids) {
		this.childids = childids;
	}

	private List<MgAuth> childs;

	public List<MgAuth> getChilds() {
		return childs;
	}

	public void setChilds(List<MgAuth> childs) {
		this.childs = childs;
	}
	
	/**
	 * 父级权限名称
	 */
	public void setPname(java.lang.String pname) {
		put("pname", pname);
	}
	
	/**
	 * 权限名称
	 */
	public java.lang.String getPname() {
		return getStr("pname");
	}
}
