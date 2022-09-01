/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.model.main;

import org.tio.sitexxx.service.model.main.base.BaseWxFriend;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class WxFriend extends BaseWxFriend<WxFriend> {
	public static final WxFriend dao = new WxFriend().dao();
	
	/**
	 * 好友状态
	 * @author xufei
	 */
	public static interface Status {
		/**
		 *  正常
		 */
		byte NORMAL = 1;

		/**
		 * 拉黑-废弃
		 */
		byte OUT = 2;
	}
	
	/**
	 * 添加好友验证码
	 * @author xufei
	 * 2020年1月9日 下午5:33:23
	 */
	public static interface AddRespCode {
		
		/**
		 * 错误码
		 */
		Byte ERROR = -1;
		
		/**
		 * 需要验证
		 */
		Byte WHERE = 1;
		
		/**
		 *  无条件
		 */
		Byte NO_WHERE = 2;
	}
}
