package org.tio.mg.service.vo;

import java.io.Serializable;

import org.tio.sitexxx.servicecommon.vo.Const;

/**
 * 权限信息表
 * @author xufei
 * 2020年5月27日 下午1:48:56
 */
public class MgAuthVo implements Serializable {

	private static final long serialVersionUID = 1678786699869005882L;

	/**
	 * vue页面组件：对于字段authurl，代表的是服务端的是html的相对路径/操作权限的请求url
	 */
	private String component;//

	/**
	 * vue页面路由：对于字段routekey，代表的是地址栏中的页面路由字段/操作权限的key值
	 */
	private String path;//

	/**
	 * 权限名称
	 */
	private String name;

	/**
	 * 权限类型
	 */
	private Byte type;

	/**
	 * 权限类型
	 */
	private Byte operstatus = Const.Status.NORMAL;

	/**
	 * icon
	 */
	private String icon;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Byte getOperstatus() {
		return operstatus;
	}

	public void setOperstatus(Byte operstatus) {
		this.operstatus = operstatus;
	}

}
