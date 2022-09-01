/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.sitexxx.im.common.bs.wx.webrtc;

import java.util.Map;

import org.tio.sitexxx.im.common.bs.wx.webrtc.base.WxCallBase;

/**
 * a向b提供offer，需要提供 e.candidate
 * @author tanyaowu 
 * 2016年9月12日 下午3:09:08
 */
public class WxCall10OfferIceNtf extends WxCallBase {

	private static final long serialVersionUID = -838442191359172734L;

	private Map<String, Object> candidate = null;

	/**
	 * @return the candidate
	 */
	public Map<String, Object> getCandidate() {
		return candidate;
	}

	/**
	 * @param candidate the candidate to set
	 */
	public void setCandidate(Map<String, Object> candidate) {
		this.candidate = candidate;
	}

}
