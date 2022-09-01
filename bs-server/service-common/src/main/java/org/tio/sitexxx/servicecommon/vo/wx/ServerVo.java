/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo.wx;

/**
 *
 * @author tanyaowu
 * 2016年9月20日 下午4:35:34
 */
public class ServerVo implements java.io.Serializable {
	/**
	 * @含义:
	 * @类型: long
	 */
	private static final long serialVersionUID = -6697549331008077293L;

	private String ip;

	private Integer clientCount;

	public ServerVo(String ip, Integer clientCount) {
		super();
		this.ip = ip;
		this.clientCount = clientCount;
	}

	public Integer getClientCount() {
		return clientCount;
	}

	public String getIp() {
		return ip;
	}

	public void setClientCount(Integer clientCount) {
		this.clientCount = clientCount;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
