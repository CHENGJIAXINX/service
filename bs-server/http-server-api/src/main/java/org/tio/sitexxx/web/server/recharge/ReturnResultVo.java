/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * **************************************************************************
 *
 * @说明: 
 * @项目名称: talent-app-mm
 *
 * @author: tanyaowu 
 * @创建时间: 2016年5月25日 下午1:45:17
 *
 * **************************************************************************
 */
package org.tio.sitexxx.web.server.recharge;

/**
 * 
 * @author tanyaowu 
 * @创建时间 2016年5月25日 下午1:45:17
 *
 * @操作列表
 *  编号	| 操作时间	| 操作人员	 | 操作说明
 *  (1) | 2016年5月25日 | tanyaowu | 新建类
 *
 */
public class ReturnResultVo {
	//	private static Logger log = LoggerFactory.getLogger(ReturnResultVo.class);

	/**
	 * 支付平台调用本系统的returnurl时，订单的支付状态
	 * @author tanyaowu 
	 * @创建时间 2016年6月2日 下午5:37:02
	 *
	 * @操作列表
	 *  编号	| 操作时间	| 操作人员	 | 操作说明
	 *  (1) | 2016年6月2日 | tanyaowu | 新建类
	 */
	public static interface TradeStatus {
		/**
		 * 付款成功
		 */
		public static final Integer SUCCESS = 1;

		/**
		 * 付款成功且完成
		 */
		public static final Integer FINISHED = 2;

		/**
		 * 付款交易关闭
		 */
		public static final Integer CLOSED = 3;

		/**
		 * 其它
		 */
		public static final Integer OTHER = 4;
	}

	/**
	 * 
	 */
	private Integer tradeStatus;

	/**
	 * 
	 */
	private String tradeNo;

	/**
	 * true: 是合法的回调，即与支付平台验证通过
	 */
	private Boolean isValidCallback = false;

	/**
	 * 
	 *
	 * @author: tanyaowu
	 * @创建时间:　2016年5月25日 下午1:45:17
	 * 
	 */
	public ReturnResultVo() {
	}

	public ReturnResultVo(Integer tradeStatus, String tradeNo, Boolean isValidCallback) {
		super();
		this.tradeStatus = tradeStatus;
		this.tradeNo = tradeNo;
		this.isValidCallback = isValidCallback;
	}

	/**
	 * @param args
	 *
	 * @author: tanyaowu
	 * @创建时间:　2016年5月25日 下午1:45:17
	 * 
	 */
	public static void main(String[] args) {

	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Integer getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(Integer tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public Boolean getIsValidCallback() {
		return isValidCallback;
	}

	public void setIsValidCallback(Boolean isValidCallback) {
		this.isValidCallback = isValidCallback;
	}
}
