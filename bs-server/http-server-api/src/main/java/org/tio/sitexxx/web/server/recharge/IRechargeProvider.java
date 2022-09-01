/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.recharge;

import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.sitexxx.service.model.main.RechargeItem;

/**
 * @author tanyaowu
 * 对应原来的IRechargeProvider
 */
public interface IRechargeProvider {

	/**
	 * 支付平台回调类型
	 * @author tanyaowu
	 *
	 */
	public static interface CallType {
		/**
		 * 回调类型：return
		 */
		int RETURN = 1;

		/**
		 * 回调类型：notify
		 */
		int NOTIFY = 2;
	}

	/**
	 * 是否是合法的回调
	 * @param request
	 * @param callbackType
	 * @return
	 * @throws Exception
	 */
	public boolean isValidCallback(HttpRequest request, int callbackType) throws Exception;

	/**
	 * 获取本平台的订单号
	 * @param request
	 * @param callbackType
	 * @return
	 */
	public String getTradeno(HttpRequest request, int callbackType);

	/**
	 * 支付平台回调时，填充RechargeItem对象<br>
	 * 需要填充如下字段
	 * <li>status, 实现类必须根据第三方支付平台返回的status转换成本系统统一的status</li>
	 * <li>thirdtradeno(可选)</li>
	 * <li>thirdstatus(可选)</li>
	 * <li>thirdaccount(可选)</li>
	 * <li>thirdamount(可选)</li>
	 * <li>thirdnotifyid(可选)</li>
	 * <li>thirdtradetime(可选)</li>
	 * <li>remark(可选)</li>
	 * 
	 * @param request
	 * @param rechargeItem 是从数据库根据本系统订单号查询出来的记录
	 * @param callbackType
	 * @return
	 * @throws Exception 
	 */
	public void fillOnNotify(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception;

	//	/**
	//	 * 支付平台return回调时，充值结果
	//	 * @param request
	//	 * @return true: 充值成功， false: 充值失败
	//	 */
	//	public boolean returnCallResult(HttpRequest request);

	/**
	 * 跳转到第三方充值界面
	 * @param request
	 * @param rechargeItem
	 * @param callbackType
	 * @return
	 *
	 * @author: tanyaowu
	 * @throws Exception
	 *
	 */
	public HttpResponse toThirdRechargePage(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception;

	/**
	 * 支付平台异步回调时，本系统的业务处理成功后返回给支付平台的响应
	 * @param request
	 * @param rechargeItem
	 * @return
	 * @throws Exception
	 */
	public HttpResponse notifySuccess(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception;

	/**
	 * 支付平台异步回调时，本系统的业务处理失败后返回给支付平台的响应
	 * @param request
	 * @param rechargeItem
	 * @param callbackType
	 * @return
	 * @throws Exception
	 */
	public HttpResponse notifyFail(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception;

}
