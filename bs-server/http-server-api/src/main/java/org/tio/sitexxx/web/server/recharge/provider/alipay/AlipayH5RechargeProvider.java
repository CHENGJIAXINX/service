/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.recharge.provider.alipay;

import org.slf4j.Logger;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.util.Resps;
import org.tio.sitexxx.service.model.main.RechargeItem;
import org.tio.sitexxx.servicecommon.utils.LogUtils;
import org.tio.sitexxx.web.server.recharge.RechargeUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;

import cn.hutool.core.util.StrUtil;

/**
 * 
 * @author tanyaowu
 */
public class AlipayH5RechargeProvider extends AlipayRechargeProvider {
	private static Logger log = LogUtils.getCoinLog();

	public static final AlipayH5RechargeProvider me = new AlipayH5RechargeProvider();

	@Override
	public HttpResponse toThirdRechargePage(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception {
		//支付类型
		Integer paytype = rechargeItem.getPaytype();

		//订单名称
		String _subject = rechargeItem.getGoods();
		if (StrUtil.isBlank(_subject)) {
			_subject = "充值";
		}

		//付款金额 
		String total_fee = String.valueOf(rechargeItem.getAmount());
		//订单描述
		String body = "";//new String(request.getParam("WIDbody"));

		AlipayClient alipayClient = AlipayConfig.alipayClient;
		AlipayTradeWapPayRequest alipay_request = new AlipayTradeWapPayRequest();

		// 封装请求支付信息
		AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
		model.setOutTradeNo(rechargeItem.getTradeno());
		model.setSubject(_subject);
		model.setTotalAmount(total_fee);
		model.setBody(body);
		model.setTimeoutExpress("30m");
		model.setProductCode("QUICK_WAP_WAY");
		alipay_request.setBizModel(model);
		// 设置异步通知地址
		alipay_request.setNotifyUrl(RechargeUtils.getNotifyUrl(paytype, request));
		// 设置同步地址
		alipay_request.setReturnUrl(RechargeUtils.getReturnUrl(paytype, request));

		// form表单生产
		String form = "";
		try {
			// 调用SDK生成表单
			form = alipayClient.pageExecute(alipay_request).getBody();
			log.info("支付宝生成的h5页面\r\n{}", form);
			return Resps.html(request, form);
		} catch (AlipayApiException e) {
			log.error("支付宝支付生成H5支付页面时产生异常", e);
			throw e;
		}
	}
}
