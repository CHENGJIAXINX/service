/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.recharge.provider.alipay;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.util.Resps;
import org.tio.sitexxx.service.model.main.RechargeItem;
import org.tio.sitexxx.servicecommon.utils.LogUtils;
import org.tio.sitexxx.web.server.recharge.IRechargeProvider;
import org.tio.sitexxx.web.server.recharge.RechargeUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 
 * @author tanyaowu
 */
public class AlipayRechargeProvider implements IRechargeProvider {
	private static Logger log = LogUtils.getCoinLog();

	public static final AlipayRechargeProvider me = new AlipayRechargeProvider();

	protected AlipayRechargeProvider() {
	}

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
		model.setProductCode("FAST_INSTANT_TRADE_PAY");
		model.setTotalAmount(total_fee);
		model.setSubject(_subject);
		model.setBody(body);

		//String serverUrl, String appId, String privateKey
		AlipayClient alipayClient = AlipayConfig.alipayClient;

		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
		alipayRequest.setReturnUrl(RechargeUtils.getReturnUrl(paytype, request));//"http://domain.com/CallBack/return_url.jsp"
		alipayRequest.setNotifyUrl(RechargeUtils.getNotifyUrl(paytype, request));//"http://domain.com/CallBack/notify_url.jsp" 在公共参数中设置回跳和通知地址
		alipayRequest.setBizModel(model);

		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
		} catch (AlipayApiException e) {
			log.error("支付宝支付生成支付页面时产生异常", e);
			throw e;
		}

		return Resps.html(request, form);
	}

	/**
	 * 把HttpRequest对象转换成Map，便于对请求进行验签
	 * @param request
	 * @return
	 */
	private static Map<String, String> toMap(HttpRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		Map<String, Object[]> requestParams = request.getParams();
		Set<Entry<String, Object[]>> set = requestParams.entrySet();//.keySet();
		for (Entry<String, Object[]> entry : set) {
			String name = entry.getKey();
			if ("paytype".equals(name)) {
				continue;
			}
			Object[] values = entry.getValue();
			String valueStr = ArrayUtil.join(values, ",");
			params.put(name, valueStr == null ? "" : valueStr);
		}
		return params;
	}

	@Override
	public boolean isValidCallback(HttpRequest request, int callbackType) throws Exception {
		Map<String, String> params = toMap(request);
		boolean verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.publicKey, AlipayConfig.charset, AlipayConfig.sign_type);
		return verify_result;
	}

	@Override
	public String getTradeno(HttpRequest request, int callbackType) {
		String out_trade_no = request.getParam("out_trade_no");
		return out_trade_no;
	}

	@Override
	public void fillOnNotify(HttpRequest request, RechargeItem rechargeItem, int callbackType) {
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号
		//		String out_trade_no = request.getParam("out_trade_no");
		//支付宝交易号
		String trade_no = request.getParam("trade_no");
		//签名类型
		//				String sign_type = request.getParam("sign_type");
		//交易状态
		String trade_status = request.getParam("trade_status");
		//买家帐号
		String buyer_id = request.getParam("buyer_id");
		//交易金额
		String total_amount = request.getParam("total_amount");
		Double thirdamount = Double.parseDouble(total_amount);
		//			thirdamount = thirdamount / 100;    //因为支付宝的金额单位是分，所以这里要除以100
		//交易付款时间
		String gmt_payment = request.getParam("gmt_payment");
		String notify_id = request.getParam("notify_id");

		rechargeItem.setThirdtradeno(trade_no);
		rechargeItem.setThirdstatus(trade_status);
		rechargeItem.setThirdaccount(buyer_id);
		rechargeItem.setThirdamount(thirdamount);
		rechargeItem.setThirdnotifyid(notify_id);

		try {
			rechargeItem.setThirdtradetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(gmt_payment));
		} catch (Exception e) {
			LogUtils.getCoinLog().error(gmt_payment + "进行日期转换出错了", e);
		}

		if ("TRADE_SUCCESS".equals(trade_status)) {
			rechargeItem.setStatus(RechargeItem.Status.SUCCESS);
		} else if ("TRADE_FINISHED".equals(trade_status)) {
			rechargeItem.setStatus(RechargeItem.Status.FINISHED);
		} else if ("TRADE_CLOSED".equals(trade_status)) {
			rechargeItem.setStatus(RechargeItem.Status.CANCELED);
		} else {
			rechargeItem.setStatus(RechargeItem.Status.OTHER);
		}

		rechargeItem.setRemark(StringUtils.left(request.getHeaderString() + request.getBodyString(), 2048));
	}

	@Override
	public HttpResponse notifySuccess(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception {
		return Resps.html(request, "success");
	}

	@Override
	public HttpResponse notifyFail(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception {
		return Resps.html(request, "fail");
	}
}
