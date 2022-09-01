/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.recharge.provider.alipay;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.util.Resps;
import org.tio.sitexxx.service.model.main.RechargeItem;
import org.tio.sitexxx.servicecommon.utils.LogUtils;
import org.tio.sitexxx.web.server.recharge.RechargeUtils;
import org.tio.utils.resp.Resp;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

import cn.hutool.core.util.StrUtil;

/**
 * 
 * @author tanyaowu
 */
public class AlipayAppRechargeProvider extends AlipayRechargeProvider {
	private static Logger log = LogUtils.getCoinLog();

	public static final AlipayAppRechargeProvider me = new AlipayAppRechargeProvider();

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

		AlipayTradePayModel model = new AlipayTradePayModel();
		model.setOutTradeNo(rechargeItem.getTradeno());
		model.setProductCode("QUICK_MSECURITY_PAY");
		model.setTotalAmount(total_fee);
		model.setTimeoutExpress("30m");
		model.setSubject(_subject);
		model.setBody(body);

		//String serverUrl, String appId, String privateKey
		AlipayClient alipayClient = AlipayConfig.alipayClient;

		AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();//创建API对应的request
		alipayRequest.setReturnUrl(RechargeUtils.getReturnUrl(paytype, request));//"http://domain.com/CallBack/return_url.jsp"
		alipayRequest.setNotifyUrl(RechargeUtils.getNotifyUrl(paytype, request));//"http://domain.com/CallBack/notify_url.jsp" 在公共参数中设置回跳和通知地址
		alipayRequest.setBizModel(model);

		String retBody = "";
		try {
			AlipayTradeAppPayResponse alipayTradeAppPayResponse = alipayClient.sdkExecute(alipayRequest);
			if (alipayTradeAppPayResponse != null) {
				retBody = alipayTradeAppPayResponse.getBody();

				Map<String, Object> ret = new HashMap<>();
				ret.put("alipay", retBody);

				return Resps.json(request, Resp.ok(ret));
			} else {
				return Resps.json(request, Resp.fail("支付宝SDK生成的"));
			}
		} catch (AlipayApiException e) {
			log.error("支付宝支付生成APP支付页面时产生异常", e);
			return Resps.json(request, Resp.fail("支付宝支付生成APP支付页面时产生异常"));
		}

	}
}
