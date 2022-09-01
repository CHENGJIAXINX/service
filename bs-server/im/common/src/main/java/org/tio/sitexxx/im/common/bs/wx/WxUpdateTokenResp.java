/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.sitexxx.im.common.bs.wx;

import java.io.Serializable;

/**
 * 
 * @author xufei
 * 2020年6月2日 上午10:22:45
 */
public class WxUpdateTokenResp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6762250307386131429L;
	
	private Byte code = 1;

	public Byte getCode() {
		return code;
	}

	public void setCode(Byte code) {
		this.code = code;
	}
}
