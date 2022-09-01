/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.common.bs.wx;

import java.io.Serializable;

/**
 * 
 * @author xufei
 * 2020年6月2日 上午10:27:37
 */
public class WxUpdateTokenReq implements Serializable {

	private static final long serialVersionUID = 2796430713670650904L;

	/**
	 * token
	 */
	private String t;
	
	/**
	 * token
	 */
	private String o;

	/**
	 * token
	 * @return
	 */
	public String getT() {
		return t;
	}

	/**
	 * token
	 */
	public void setT(String t) {
		this.t = t;
	}

	public String getO() {
		return o;
	}

	public void setO(String o) {
		this.o = o;
	}
}
