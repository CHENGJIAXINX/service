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

import org.tio.http.common.HttpResponse;
import org.tio.sitexxx.service.model.main.RechargeItem;

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
public class NotifyResultVo {
	//	private static Logger log = LoggerFactory.getLogger(ReturnResultVo.class);

	private HttpResponse response;

	/**
	 * 支付平台调用本系统的notifyurl时，订单的支付状态
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
	}

	/**
	 * 
	 */
	private Integer tradeStatus;

	/**
	 * 
	 */
	private RechargeItem rechargeItem;

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
	public NotifyResultVo() {
	}

	public NotifyResultVo(Integer tradeStatus, RechargeItem rechargeItem, HttpResponse response, Boolean isValidCallback) {
		super();
		this.tradeStatus = tradeStatus;
		this.setRechargeItem(rechargeItem);
		this.response = response;
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

	public RechargeItem getRechargeItem() {
		return rechargeItem;
	}

	public void setRechargeItem(RechargeItem rechargeItem) {
		this.rechargeItem = rechargeItem;
	}

	public HttpResponse getResponse() {
		return response;
	}

	public void setResponse(HttpResponse response) {
		this.response = response;
	}
}
