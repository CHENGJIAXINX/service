/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.mg.im.common.bs;

import java.io.Serializable;

/**
 * 私 聊
 * @author tanyaowu 

 */
public class P2PChatReq implements Serializable {
	private static final long	serialVersionUID	= 7365945567713702051L;
	private String				c;											//	聊天内容
	private Integer				to;											//	消息接收者的userid

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

}
