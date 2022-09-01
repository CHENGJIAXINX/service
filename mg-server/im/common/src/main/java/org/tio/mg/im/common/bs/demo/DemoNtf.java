/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.mg.im.common.bs.demo;

import java.io.Serializable;

/**
 * 
 * @author tanyaowu 
 * 2016年9月12日 下午3:09:08
 */
public class DemoNtf implements Serializable {

	private static final long serialVersionUID = 2088352299449577670L;
	private String msg;

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
