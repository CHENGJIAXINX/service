/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.mg.im.common.bs.wx.webrtc;

import org.tio.mg.im.common.bs.wx.webrtc.base.WxCallBase;

/**
 * a或b --> s   发起结束通话请求
 * 需要传hanguptype
 * @author tanyaowu
 */
public class WxCall13EndReq extends WxCallBase {
	private static final long serialVersionUID = -45874627811555944L;
	private String msg = null;
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
