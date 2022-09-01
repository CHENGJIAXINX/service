/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.servicecommon.vo.im;

import java.io.Serializable;

/**
 * @author tanyaowu
 * 图片卡片消息
 */
public class CardImg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5855736475582799144L;

	private String small;

	private String path;

	public CardImg(String small, String path) {
		super();
		this.small = small;
		this.path = path;
	}

	public String getSmall() {
		return small;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 
	 */
	public CardImg() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
