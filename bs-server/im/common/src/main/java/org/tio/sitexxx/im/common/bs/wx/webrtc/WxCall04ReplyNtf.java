/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.sitexxx.im.common.bs.wx.webrtc;

import org.tio.sitexxx.im.common.bs.wx.webrtc.base.WxCallBase;
import org.tio.sitexxx.servicecommon.vo.Const;

/**
 * b回复s：同意通话，或拒绝通话（1、同意通话、2、拒接）
 * @author tanyaowu 
 * 2016年9月12日 下午3:09:08
 */
public class WxCall04ReplyNtf extends WxCallBase {

	private static final long serialVersionUID = -7629291844755041469L;

	/**
	 * 不能通话的原因，当result=2时，此字段才有值
	 */
	private String reason = null;

	/**
	 * 1、同意通话、2、拒接
	 */
	private Byte result = null;
	
	/**
	 * 是否是自己的回辞消息
	 */
	private Byte self = Const.YesOrNo.NO;

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


	public Byte getSelf() {
		return self;
	}

	public void setSelf(Byte self) {
		this.self = self;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
}
