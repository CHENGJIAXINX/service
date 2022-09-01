/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.model.main;

import org.tio.mg.service.model.main.base.BaseUserThird;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class UserThird extends BaseUserThird<UserThird> {
	public static final UserThird dao = new UserThird().dao();

	/**
	 * 第三方登录类型
	 * @author tanyaowu
	 *
	 */
	public interface Type {
		/**
		 * PC版QQ
		 */
		int QQ = 1;

		/**
		 *  移动版QQ
		 */
		int QQ_MOBILE = 11;

		/**
		 * PC版微信
		 */
		int WX = 2;

		/**
		 *  移动版微信
		 */
		int WX_MOBILE = 22;

		/**
		 *  微信公众号
		 */
		int WX_OPEN = 222;

		/**
		 * PC版微博
		 */
		int WB = 3;

		/**
		 *  移动版微博
		 */
		int WB_MOBILE = 33;
		
		/**
		 * PC版抖音
		 */
		int DOUYIN = 4;
		
		/**
		 * PC版OSC
		 */
		int OSC = 5;

		/**
		 * IOS游客登录
		 */
		int APPLE = 9999;
	}

	private SubTable subTable = null;

	public SubTable getSubTable() {
		return subTable;
	}

	public void setSubTable(SubTable subTable) {
		this.subTable = subTable;
	}
	
	public static interface SubTable {
		/**
		 * user_third表的id字段
		 */
		public void setUserThirdId(java.lang.Integer userThirdId);
		
		public boolean save();
//		{
//			set("user_third_id", userThirdId);
//		}
		
//		/**
//		 * user_third表的id字段
//		 */
//		public java.lang.Integer getUserThirdId() {
//			return getInt("user_third_id");
//		}
	}
}
