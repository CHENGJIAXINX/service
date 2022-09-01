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
 * 群聊
 * @author tanyaowu
 */
public class GroupChatReq implements Serializable {
	private static final long	serialVersionUID	= 623723297327475963L;
	private String				c;											//聊天内容	//举例：大家好
	private Integer[]			at;											//艾特哪些用户。此值可为null	  //举例：[434343, 9898989]
	private String				g;											//groupid	//举例：45454

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Integer[] getAt() {
		return at;
	}

	public void setAt(Integer[] at) {
		this.at = at;
	}

	public String getG() {
		return g;
	}

	public void setG(String g) {
		this.g = g;
	}

}
