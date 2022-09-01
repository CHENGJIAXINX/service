/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.mg.im.common.bs;

import java.io.Serializable;
import java.util.Objects;



/**
 * 
 * @author tanyaowu 
 * 2016年9月12日 下午3:09:08
 */
public class JoinGroupResp implements Serializable {
	private static final long serialVersionUID = -1153163111359189882L;

	private String	g;
	/**
	 * @see org.tio.mg.im.common.bs.JoinGroupResp.JoinGroupResult
	 */
	private Byte	result;

	public String getG() {
		return g;
	}

	public void setG(String g) {
		this.g = g;
	}

	public Byte getResult() {
		return result;
	}

	public void setResult(Byte result) {
		this.result = result;
	}

	public JoinGroupResp() {
	}
	
	
	/**
	 * 加入群组响应码
	 * 
	 */
	public enum JoinGroupResult {
		/**
		 * 进入成功
		 */
		OK((byte) 1),

		/**
		 * 组不存在
		 */
		FAIL_GROUP_NOT_EXIST((byte) 2),

		/**
		 * 组满
		 */
		FAIL_GROUP_FULL((byte) 3),

		/**
		 * 你在黑名单中
		 */
		FAIL_IN_BLACK_LIST((byte) 4),
		/**
		 * 被踢
		 */
		FAIL_KICKED((byte) 5),
		/**
		 * 不允许游客进行
		 */
		FAIL_TOURIST_NOT_ALLOWED((byte) 6),
		/**
		 * 其它原因
		 */
		FAIL_OTHER((byte) 99);

		public static JoinGroupResult from(Byte value) {
			JoinGroupResult[] values = JoinGroupResult.values();
			for (JoinGroupResult v : values) {
				if (Objects.equals(v.value, value)) {
					return v;
				}
			}
			return null;
		}

		Byte value;

		private JoinGroupResult(Byte value) {
			this.value = value;
		}

		public Byte getValue() {
			return value;
		}

		public void setValue(Byte value) {
			this.value = value;
		}
	}

}
