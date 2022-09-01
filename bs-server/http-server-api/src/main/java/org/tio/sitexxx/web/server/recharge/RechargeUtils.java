/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.recharge;

import org.slf4j.Logger;
import org.tio.http.common.HttpRequest;
import org.tio.sitexxx.servicecommon.utils.LogUtils;
import org.tio.sitexxx.servicecommon.vo.Const;

/**
 * 
 * @author tanyaowu
 *
 */
public class RechargeUtils {
	@SuppressWarnings("unused")
	private static Logger log = LogUtils.getCoinLog();

	/**
	 * 
	 * @param paytype
	 * @param request
	 * @return
	 */
	public static String getReturnUrl(Integer paytype, HttpRequest request) {
		return Const.SITE + request.getHttpConfig().getContextPath() + "/recharge/rt/" + paytype + request.getHttpConfig().getSuffix();
		//		return "http://202.91.234.133:8080/api/recharge/rt/" + paytype + ".php";
	}

	/**
	 * 
	 * @param paytype
	 * @param request
	 * @return
	 */
	public static String getNotifyUrl(Integer paytype, HttpRequest request) {
		return Const.SITE + request.getHttpConfig().getContextPath() + "/recharge/nf/" + paytype + request.getHttpConfig().getSuffix();
		//		return "http://202.91.234.133:8080/api/recharge/nf/" + paytype + ".php";
	}

	/**
	 * 充值平台回调时(notify时)，检查订单号
	 * @param tradeno 本系统的订单号
	 * @param request
	 * @param response
	 * @return null: 表示检查不通过
	 * @throws Exception
	 *
	 * @author: tanyaowu
	 *
	 */
	//	public static RechargeItem checkTradeno(String tradeno) throws Exception
	//	{
	//		RechargeItem rechargeItem = RechargeItemService.me.selectByTradeno(tradeno);
	//		if (rechargeItem == null)
	//		{
	//			log.error("找不到记录, tradeno: {}", tradeno);
	//			return null;
	//		}
	//
	//		if (Objects.equals(rechargeItem.getStatus(), RechargeItem.Status.SUCCESS) || Objects.equals(rechargeItem.getStatus(), RechargeItem.Status.FINISHED))
	//		{
	//			log.error("该订单充值已经到帐, 不允许再次加币 tradeno: {}", tradeno);
	//			return null;
	//		}
	//		return rechargeItem;
	//	}
}
