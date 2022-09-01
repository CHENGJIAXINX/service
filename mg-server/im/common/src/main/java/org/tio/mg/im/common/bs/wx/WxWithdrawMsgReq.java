/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.common.bs.wx;

import java.io.Serializable;

/**
 * 撤回消息请求体
 * @author tanyaowu 
 * 2016年11月24日 下午2:25:55
 */
public class WxWithdrawMsgReq implements Serializable {
	private static final long serialVersionUID = -8956671394570248443L;

	/**
	 * mid
	 */
	private Long mid;

	/**
	 * 群组，如果这空则表示是私聊
	 */
	private Long g = null;

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public Long getG() {
		return g;
	}

	public void setG(Long g) {
		this.g = g;
	}


}
