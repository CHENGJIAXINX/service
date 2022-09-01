/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.mg.im.common.bs.wx;

import java.io.Serializable;

/**
 * 心跳包-- Client-->Server
 * @author xufei
 * 2020年2月3日 下午3:23:44
 */
public class HeartbeatReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -462048823973668176L;
	private Long				chatlinkid;											//	聊天会话
	public Long getChatlinkid() {
		return chatlinkid;
	}
	public void setChatlinkid(Long chatlinkid) {
		this.chatlinkid = chatlinkid;
	}
}
