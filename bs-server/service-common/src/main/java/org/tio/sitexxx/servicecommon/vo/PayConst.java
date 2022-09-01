/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */package org.tio.sitexxx.servicecommon.vo;

public class PayConst {
	
	public static interface RedPackMode {
		/**
		 * 普通红包
		 */
		byte NORMAL = 1;

		/**
		 * 手气红包
		 */
		byte LUCK = 2;
	}
	
	/**
	 * 钱包模型
	 * @author xufei
	 * 2020年11月26日 下午1:47:44
	 */
	public static interface WalletMode {
		/**
		 * 充值
		 */
		byte RECHARGE = 1;

		/**
		 * 提现
		 */
		byte WIHTHOLD = 2;
		
		/**
		 * 红包
		 */
		byte REDPACKET = 3;
	}
	
	/**
	 * 明细同步
	 * @author xufei
	 * 2020年11月26日 下午2:34:01
	 */
	public static interface CoinSyn {
		/**
		 * 初始化
		 */
		byte INIT = 1;

		/**
		 * 未处理
		 */
		byte NO = 2;
		
		/**
		 * 成功
		 */
		byte SUCCESS = 3;
	}
	
	/**
	 * 查询同步
	 * @author xufei
	 * 2020年11月26日 下午5:00:00
	 */
	public static interface QuerySyn {
		/**
		 * 回调成功
		 */
		byte CALLBACK = 1;

		/**
		 * 否
		 */
		byte NO = 2;
		
		/**
		 * 成功
		 */
		byte SUCCESS = 3;
	}
	
	/**
	 * api class名称
	 * @author xufei
	 * 2020年11月3日 下午6:34:03
	 */
	public static interface ApiClassName {
		
		/**
		 * map的key
		 */
		String API_MAP_KEY = "apiclassname";
		
		/**
		 * 钱包信息
		 */
		String	WALLET_INFO		= "walletinfo";
		
		/**
		 * 充值
		 */
		String	RECHARGE		= "recharge";
		
		
		/**
		 * 充值查询
		 */
		String	RECHARGE_QUERY		= "rechargequery";
		
		/**
		 * 提现
		 */
		String	WITHHOLD		= "withhold";
		
		/**
		 * 提现查询
		 */
		String	WITHHOLD_QUERY		= "withholdquery";
		
		/**
		 * 发红包
		 */
		String	REDPACKET		= "redpacket";
		
		/**
		 * 抢红包
		 */
		String	GRAB_REDPACKET		= "grabredpacket";
		
		/**
		 * 充值回调
		 */
		String	RECHARGE_CALLBACK		= "rechargecallback";
		
		/**
		 * 提现回调
		 */
		String	WITHHOLD_CALLBACK		= "withholdcallback";
		
		/**
		 * 发红包回调
		 */
		String	REDPACKET_CALLBACK		= "redpacketcallback";
		
		/**
		 * 发红包查询
		 */
		String	REDPACKET_QUERY		= "redpacketquery";

	}
}
