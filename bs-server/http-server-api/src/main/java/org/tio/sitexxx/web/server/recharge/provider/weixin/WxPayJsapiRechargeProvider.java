/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.recharge.provider.weixin;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.util.Resps;
import org.tio.sitexxx.service.model.main.RechargeItem;
import org.tio.sitexxx.service.service.recharge.RechargeItemService;
import org.tio.sitexxx.servicecommon.utils.LogUtils;
import org.tio.sitexxx.servicecommon.vo.SessionKey;
import org.tio.sitexxx.web.server.recharge.RechargeUtils;
import org.tio.sitexxx.web.server.utils.SessionCacheUtils;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayConstants.SignType;
import com.github.wxpay.sdk.WXPayUtil;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 微信公众号支付
 *文档
 *	地址：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=7_1
 *回调页面
 *	参数：redirect_url
 *	文档：https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=15_4
 * 
 * @author tanyaowu
 */
public class WxPayJsapiRechargeProvider extends WxPayScan2RechargeProvider {
	private static Logger log = LogUtils.getCoinLog();

	public static final WxPayJsapiRechargeProvider me = new WxPayJsapiRechargeProvider();

	//	protected WXPay wxpay;
	//	protected WXJsapiPayConfigImpl config;
	//	
	//	protected WxPayJsapiRechargeProvider() {
	//		super();
	//	}

	@Override
	public WXPayConfig getWXPayConfig() {
		return WXJsapiPayConfigImpl.getInstance();
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

		String openid = (String) SessionCacheUtils.get(request, SessionKey.WX_PAY_OPENID);
		if (StrUtil.isBlank(openid)) {
			log.error("没有获取到openid");
			return Resps.json(request, Resp.fail());
		}
		//		SessionCacheUtils.remove(request, SessionKey.WX_PAY_OPENID);

		//付款金额 
		//		String total_fee = String.valueOf((int) (rechargeItem.getAmount() * 100));
		String total_fee = String.valueOf((int) NumberUtil.mul((double) rechargeItem.getAmount(), (float) 100));

		String tradeno = rechargeItem.getTradeno();
		String ip = request.getClientIp();

		Map<String, String> data = new HashMap<String, String>();
		data.put("body", _subject);
		data.put("out_trade_no", tradeno);
		data.put("device_info", "");
		data.put("fee_type", "CNY");
		data.put("total_fee", total_fee);
		data.put("spbill_create_ip", ip);
		data.put("notify_url", RechargeUtils.getNotifyUrl(paytype, request));
		data.put("trade_type", TradeType.JSAPI.getValue());
		data.put("product_id", tradeno);
		data.put("openid", openid);

		try {
			Map<String, String> r = wxpay.unifiedOrder(data);

			log.info("微信JSAPI支付，统一下单收到微信的响应：\r\n{}", Json.toFormatedJson(r));
			//			System.out.println("微信JSAPI支付：\r\n" + Json.toFormatedJson(r));

			/*
			 * SUCCESS/FAIL此字段是通信标识，非交易标识，交易是否成功需要查看trade_state来判断
			 */
			String returnCode = r.get("return_code");
			if ("SUCCESS".equals(returnCode)) {
				String result_code = r.get("result_code");
				if ("SUCCESS".equals(result_code)) {
					String prepay_id = r.get("prepay_id");
					if (StrUtil.isNotBlank(prepay_id)) {
						rechargeItem.setThirdtradeno(prepay_id);
						RechargeItemService.me.update(rechargeItem);
						/**
						 * 参考了：com.jpay.ext.kit.PaymentKit.prepayIdCreateSign(String)
						 * packageParams.put("appId", WxPayApiConfigKit.getWxPayApiConfig().getAppId());
							packageParams.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000));
							packageParams.put("nonceStr", String.valueOf(System.currentTimeMillis()));
							packageParams.put("package", "prepay_id=" + prepay_id);
							packageParams.put("signType", "MD5");
						 */
						Map<String, String> respData = new HashMap<>();
						respData.put("appId", config.getAppID());
						respData.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000));
						respData.put("nonceStr", String.valueOf(System.currentTimeMillis()));
						respData.put("package", "prepay_id=" + prepay_id);
						respData.put("signType", "MD5");
						String paySign = WXPayUtil.generateSignature(respData, config.getKey(), SignType.MD5);
						respData.put("paySign", paySign);

						respData.put("tradeno", tradeno);

						log.info("微信JSAPI充值，返回给前端页面的参数:\r\n{}", Json.toFormatedJson(respData));

						return Resps.json(request, Resp.ok(respData));
					}
				} else {
					log.error("微信JSAPI充值，提交失败:{}", Json.toJson(r));
				}
			} else {
				//				errormsg = "通讯失败";
				log.error("微信JSAPI充值，通讯失败:{}", Json.toJson(r));
			}
		} catch (Exception e) {
			log.error("", e);
		}

		//		Map<String, String> respData = new HashMap<>();
		//		respData.put("msg", errormsg);
		//		Resp ret = Resp.fail();
		//		ret.setData(respData);
		return Resps.json(request, Resp.fail());
	}

	//	/**
	//	 * 把HttpRequest对象转换成Map，便于对请求进行验签
	//	 * @param request
	//	 * @return
	//	 */
	//	@SuppressWarnings({ "rawtypes", "unchecked" })
	//	protected static Map<String, String> toMap(HttpRequest request) throws Exception {
	//		String arrName = "wxPay_params";
	//		HashMap<String, String> ret = (HashMap) request.getAttribute(arrName);
	//		if (ret != null) {
	//			return ret;
	//		}
	//		String bodyString = request.getBodyString();
	//		ret = (HashMap) WXPayUtil.xmlToMap(bodyString);
	//		request.setAttribute(arrName, ret);
	//
	//		return ret;
	//	}

	//	@Override
	//	public boolean isValidCallback(HttpRequest request, int callbackType) throws Exception {
	//		Map<String, String> params = toMap(request);
	//		String sign_type = params.get("sign_type");
	//		boolean verify_result = false;
	//		if (StrUtil.isNotBlank(sign_type)) {
	//			if ("MD5".equalsIgnoreCase(sign_type)) {
	//				verify_result = WXPayUtil.isSignatureValid(params, config.getKey(), SignType.MD5);
	//			} else if ("HMAC-SHA256".equalsIgnoreCase(sign_type)) {
	//				verify_result = WXPayUtil.isSignatureValid(params, config.getKey(), SignType.HMACSHA256);
	//			} else {
	//				verify_result = WXPayUtil.isSignatureValid(params, config.getKey());
	//			}
	//		} else {
	//			verify_result = WXPayUtil.isSignatureValid(params, config.getKey());
	//		}
	//		return verify_result;
	//	}
	//
	//	@Override
	//	public String getTradeno(HttpRequest request, int callbackType) {
	//		Map<String, String> params = null;
	//		try {
	//			params = toMap(request);
	//		} catch (Exception e) {
	//			log.error("", e);
	//			return null;
	//		}
	//		String out_trade_no = params.get("out_trade_no");
	//		return out_trade_no;
	//	}
	//
	//	@Override
	//	public void fillOnNotify(HttpRequest request, RechargeItem rechargeItem, int callbackType) {
	//		Map<String, String> params = null;
	//		try {
	//			params = toMap(request);
	//		} catch (Exception e) {
	//			log.error("", e);
	//			return;
	//		}
	//
	//		String return_code = params.get("return_code");
	//		//商户订单号
	//		//		String out_trade_no = params.get("out_trade_no");
	//		//微信支付订单号
	//		String transaction_id = params.get("transaction_id");
	//		//签名类型
	//		//				String sign_type = params.get("sign_type");
	//		//交易状态
	//		String result_code = params.get("result_code");
	//		//付款银行
	//		String bank_type = params.get("bank_type");
	//		//交易金额
	//		String total_fee = params.get("total_fee");
	//		Integer totalfee1 = Integer.parseInt(total_fee);
	//		double totalfee = totalfee1 / 100;
	//		//			thirdamount = thirdamount / 100;    //因为支付宝的金额单位是分，所以这里要除以100
	//		//交易付款时间
	//		String time_end = params.get("time_end");
	//		String nonce_str = params.get("nonce_str");
	//
	//		rechargeItem.setThirdtradeno(transaction_id);
	//		rechargeItem.setThirdstatus(result_code);
	//		rechargeItem.setThirdaccount(bank_type);
	//		rechargeItem.setThirdamount(totalfee);
	//		rechargeItem.setThirdnotifyid(nonce_str);
	//
	//		try {
	//			rechargeItem.setThirdtradetime(new SimpleDateFormat("yyyyMMddHHmmss").parse(time_end));
	//		} catch (Exception e) {
	//			LogUtils.getCoinLog().error(time_end + "进行日期转换出错了", e);
	//		}
	//
	//		if ("SUCCESS".equals(return_code) && "SUCCESS".equals(result_code)) {
	//			rechargeItem.setStatus(RechargeItem.Status.SUCCESS);
	//		} else if ("FAIL".equals(result_code)) {
	//			rechargeItem.setStatus(RechargeItem.Status.CANCELED);
	//		} else {
	//			rechargeItem.setStatus(RechargeItem.Status.OTHER);
	//		}
	//
	//		rechargeItem.setRemark(StringUtils.left(request.getHeaderString() + request.getBodyString(), 2048));
	//	}
	//
	//	@Override
	//	public HttpResponse notifySuccess(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception {
	//		return Resps.html(request, "<xml><return_code>SUCCESS</return_code><return_msg>OK</return_msg></xml>");
	//	}
	//
	//	@Override
	//	public HttpResponse notifyFail(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception {
	//		return Resps.html(request, "<xml><return_code>FAIL</return_code><return_msg>fail</return_msg></xml>");
	//	}

}
