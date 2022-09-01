/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo.topic;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

/**
 * @author tanyaowu 
 * 2016年11月8日 下午4:02:58
 */
public class TopicVo implements Serializable {
	private static final long	serialVersionUID	= -3043791690152475450L;
	public static final String	CLIENTID			= UUID.randomUUID().toString();
	private Byte				type				= null;
	private Serializable		value;
	private Map<String, Object>	params;
	private String				clientId			= CLIENTID;

	public static interface Type {
		/**
		 * 清空数据字典
		 */
		byte CLEAR_DICT = 1;

		/**
		 * 清空Conf和ConfDev
		 */
		byte CLEAR_CONF = 3;

		/**
		 * 移除user缓存,params为uid
		 */
		byte CLEAR_USER = 4;
		
		/**
		 * 清空所有用户
		 */
		byte CLEAR_ALL_USER = 5;

		/**
		 * 清空配置
		 */
		byte CLEAR_ALL_CONF = 6;
		
		/**
		 * ip白名单缓存清空
		 */
		byte CLEAR_IP_WHITE_LIST = 9;

		/**
		 * 清空敏感词缓存
		 */
		byte CLEAR_WORD = 10;

		/**
		 * 清除聊天记录
		 */
		byte CLEAR_FRIEND_MSG_INFO = 11;

	}

	/**
	 * 
	 * @author tanyaowu
	 */
	public TopicVo() {
	}

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the type
	 */
	public Byte getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Byte type) {
		this.type = type;
	}

	public java.io.Serializable getValue() {
		return value;
	}

	public void setValue(Serializable value) {
		this.value = value;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}
