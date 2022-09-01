/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.model.main;

import org.tio.sitexxx.service.model.main.base.BaseWxGroupUser;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class WxGroupUser extends BaseWxGroupUser<WxGroupUser> {
	public static final WxGroupUser dao = new WxGroupUser().dao();
	
	/**
	 * 群列表展示字段
	 * @author xufei
	 */
	public static interface ViewStatus {
		/**
		 *  正常
		 */
		byte NORMAL = 1;

		/**
		 * 未消息激活
		 */
		byte NO_ACT = 2;
		
		/**
		 * 删除
		 */
		byte DEL = 3;
	}
	
	/**
	 * 禁言标志
	 * @author xufei
	 * 2021年1月5日 上午11:18:43
	 */
	public static interface Forbiddenflag {
		/**
		 *  时长禁言
		 */
		byte DURATION = 1;

		/**
		 * 不禁言
		 */
		byte NO = 2;
		
		/**
		 * 长久
		 */
		byte LONGTERM = 3;
	}

	/**
	 * 群用户状态
	 * @author xufei
	 */
	public static interface Status {
		/**
		 *  正常
		 */
		byte NORMAL = 1;

		/**
		 * 退出
		 */
		byte OUT = 2;
		
		/**
		 * 被踢
		 */
		byte KICK = 3;
	}
}
