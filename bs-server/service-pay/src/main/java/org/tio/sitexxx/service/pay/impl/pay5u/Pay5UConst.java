/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */package org.tio.sitexxx.service.pay.impl.pay5u;

import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.PayConst;

public class Pay5UConst extends PayConst {

	public static interface CallBackUrl {
		
		/**
		 * 充值回调
		 */
		String RECHARGE = Const.SITE + "/mytio/paycallback/recharge"   + ".tio_x?uid=";
		
		/**
		 * 提现回调
		 */
		String WITHHOLD = Const.SITE + "/mytio/paycallback/withhold"   + ".tio_x?uid=";
		
		/**
		 * 红包
		 */
		String REDPACKET = Const.SITE + "/mytio/paycallback/redpacket"   + ".tio_x?uid=";
	}
	
	
	/**
	 * 响应状态
	 * @author xufei
	 * 2020年11月3日 下午6:33:23
	 */
	public static interface Status {
		/**
		 * 正常
		 */
		String	SUCCESS		= "SUCCESS";
		/**
		 * 禁用/处理中
		 */
		String	FAIL	= "FAIL";
		
		/**
		 * 初始化
		 */
		String	INIT	= "INIT";

	}
	
	/**
	 * 充值状态
	 * @author xufei
	 * 2020年11月15日 下午9:47:03
	 */
	public static interface RechargeStatus {
		/**
		 * 正常
		 */
		String	SUCCESS		= "SUCCESS";
		/**
		 * 失败
		 */
		String	FAIL	= "FAIL";
		
		/**
		 * 处理中
		 */
		String	PROCESS	= "PROCESS";
		
		/**
		 * 初始化
		 */
		String	INIT	= "INIT";
		
		/**
		 * 取消
		 */
		String	CANCEL	= "CANCEL";

	}
	
	/**
	 * 提现状态
	 * @author xufei
	 * 2020年11月26日 下午4:40:20
	 */
	public static interface WithholdStatus {
		/**
		 * 正常
		 */
		String	SUCCESS		= "SUCCESS";
		/**
		 * 失败
		 */
		String	FAIL	= "FAIL";
		
		/**
		 * 处理中
		 */
		String	PROCESS	= "PROCESS";
		
		/**
		 * 初始化
		 */
		String	INIT	= "INIT";
		
		/**
		 * 取消
		 */
		String	CANCEL	= "CANCEL";

	}
	
	public static interface RedPacketStatus {
		/**
		 * 结束成功
		 */
		String	SUCCESS		= "SUCCESS";
		
		/**
		 * 处理中
		 */
		String	PROCESS		= "PROCESS";
		/**
		 * 失败
		 */
		String	FAIL	= "FAIL";
		
		/**
		 * 超时
		 */
		String	TIMEOUT	= "TIMEOUT";
		
		/**
		 * 抢红包中
		 */
		String	SEND	= "SEND";
		
		/**
		 * 取消
		 */
		String	CANCEL	= "CANCEL";

	}
	
	/**
	 * 支付方式
	 * @author xufei
	 * 2020年11月18日 下午6:53:27
	 */
	public static interface PaymentType {
		/**
		 * 余额
		 */
		String	BALANCE		= "BALANCE";
		/**
		 * 银行卡
		 */
		String	BANK_CRAD	= "BANK_CRAD";
	}
	
	/**
	 * 红包类型
	 * @author xufei
	 * 2020年11月18日 下午6:53:27
	 */
	public static interface RedPacketType {
		/**
		 * 一对一
		 */
		String	ONE_TO_ONE		= "ONE_TO_ONE";
		/**
		 * 普通群红包
		 */
		String	GROUP_NORMAL	= "GROUP_NORMAL";
		
		/**
		 * 拼手气红包
		 */
		String	GROUP_LUCK	= "GROUP_LUCK";
	}
	
	/**
	 * 钱包状态
	 * @author xufei
	 * 2020年11月3日 下午6:34:03
	 */
	public static interface WalletStatus {
		/**
		 * 正常
		 */
		String	ACTIVATE		= "ACTIVATE";
		/**
		 * 禁用/处理中
		 */
		String	FAIL	= "FAIL";
	}

	/**
	 * 客户端业务类型
	 * @author xufei
	 * 2020年11月15日 下午6:48:36
	 */
	public static interface ClientBizType {
		/**
		 * 唤起安全设置页面
		 */
		String	ACCESS_SAFETY		= "ACCESS_SAFETY";
		/**
		 * 唤起卡列表页面
		 */
		String	ACCESS_CARDlIST	= "ACCESS_CARDlIST";
	}
}
