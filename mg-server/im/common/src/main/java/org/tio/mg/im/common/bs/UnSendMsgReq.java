/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.common.bs;

import java.io.Serializable;

/**
 * 撤回消息请求体
 * @author tanyaowu 
 * 2016年11月24日 下午2:25:55
 */
public class UnSendMsgReq implements Serializable {

	private static final long serialVersionUID = 2796430713670650904L;

	/**
	 * mid
	 */
	private String mid;

	/**
	 * 群组，如果这空则表示是私聊
	 */
	private String g = null;

	/**
	 * @return the mid
	 */
	public String getMid() {
		return mid;
	}

	/**
	 * @param mid the mid to set
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}

	/**
	 * @return the g
	 */
	public String getG() {
		return g;
	}

	/**
	 * @param g the g to set
	 */
	public void setG(String g) {
		this.g = g;
	}

}
