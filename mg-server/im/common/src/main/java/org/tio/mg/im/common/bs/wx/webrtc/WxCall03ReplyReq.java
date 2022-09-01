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
 * b回复s：同意通话，或拒绝通话（1、同意通话、2、拒接）
 * @author tanyaowu
 */
public class WxCall03ReplyReq extends WxCallBase {

	private static final long serialVersionUID = -4127892663683835026L;

	/**
	 * 1、同意通话、2、拒接
	 */
	private Byte result = null;
	/**
	 * 如果拒接，可以提供拒接原因
	 */
	private String reason = null;

	/**
	 * @return the result
	 */
	public Byte getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Byte result) {
		this.result = result;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

}
