/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.servicecommon.vo.topic;

import java.io.Serializable;

/**
 * 将ip拉黑的vo
 * @author tanyaowu
 *
 */
public class PullIpToBlackVo implements Serializable {

	public static interface Type {
		/**
		 * 添加ip到黑名单
		 */
		Byte ADD_BLACK_IP = 1;

		/**
		 * 
		 */
		Byte DELETE_IP_FROM_BLACK = 2;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1993070969721194485L;

	/**
	 * 
	 */
	public PullIpToBlackVo() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	private String	ip;
	private String	remark;

	/**
	 * 操作类型，1：把ip加到黑名单中，2：把ip从黑名单中删除
	 */
	private Byte type = PullIpToBlackVo.Type.ADD_BLACK_IP;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

}
