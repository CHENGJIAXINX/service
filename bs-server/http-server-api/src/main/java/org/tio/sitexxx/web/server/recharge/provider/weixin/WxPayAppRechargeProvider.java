/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.recharge.provider.weixin;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.util.Resps;
import org.tio.jfinal.kit.HashKit;
import org.tio.sitexxx.service.model.main.RechargeItem;
import org.tio.sitexxx.service.service.recharge.RechargeItemService;
import org.tio.sitexxx.servicecommon.utils.LogUtils;
import org.tio.sitexxx.web.server.recharge.RechargeUtils;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 微信APP支付
 * @author tanyaowu
 */
public class WxPayAppRechargeProvider extends WxPayScan2RechargeProvider {
	private static Logger log = LogUtils.getCoinLog();

	public static final WxPayAppRechargeProvider me = new WxPayAppRechargeProvider();

	protected WxPayAppRechargeProvider() {
		super();
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
		//		String total_fee = String.valueOf((int) (rechargeItem.getAmount() * 100));
		String total_fee = String.valueOf((int) NumberUtil.mul((double) rechargeItem.getAmount(), (float) 100));

		String tradeno = rechargeItem.getTradeno();

		String ip = request.getClientIp();

		Map<String, String> data = new HashMap<String, String>();
		data.put("body", _subject);//"腾讯充值中心-QQ会员充值"
		data.put("out_trade_no", tradeno);
		data.put("device_info", "");
		data.put("fee_type", "CNY");
		data.put("total_fee", total_fee);
		data.put("spbill_create_ip", ip);
		data.put("notify_url", RechargeUtils.getNotifyUrl(paytype, request));
		data.put("trade_type", TradeType.APP.getValue());
		//		data.put("product_id", "12235413214070356458058");
		data.put("product_id", tradeno);

		// data.put("time_expire", "20170112104120");

		try {
			Map<String, String> r = wxpay.unifiedOrder(data);
			String returnCode = r.get("return_code");
			if ("SUCCESS".equals(returnCode)) {
				String result_code = r.get("result_code");
				if ("SUCCESS".equals(result_code)) {
					String prepay_id = r.get("prepay_id");
					if (StrUtil.isNotBlank(prepay_id)) {
						rechargeItem.setThirdtradeno(prepay_id);
						RechargeItemService.me.update(rechargeItem);
						//						String prepay_id = r.get("prepay_id");
						//封装调起微信支付的参数 https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_12
						Map<String, String> packageParams = new HashMap<>();
						packageParams.put("appid", config.getAppID());
						packageParams.put("partnerid", config.getMchID());
						packageParams.put("prepayid", prepay_id);
						packageParams.put("package", "Sign=WXPay");
						packageParams.put("noncestr", System.currentTimeMillis() + "");
						packageParams.put("timestamp", System.currentTimeMillis() / 1000 + "");

						String packageSign = createSign(packageParams, config.getKey());//  WXPayUtil.generateSignature(packageParams, config.getKey());//.getPaternerKey()
						packageParams.put("sign", packageSign);

						Map<String, Object> ret = new HashMap<>();
						ret.put("wechat", packageParams);

						return Resps.json(request, Resp.ok(ret));
					}
				} else {
					log.error("微信APP充值，提交失败:{}", Json.toJson(r));
				}
			} else {
				log.error("微信APP充值，提交失败:{}", Json.toJson(r));
			}
		} catch (Exception e) {
			log.error("", e);
		}

		return Resps.json(request, Resp.fail("未知异常"));
	}

	public static String createSign(Map<String, String> params, String partnerKey) {
		// 生成签名前先去除sign
		params.remove("sign");
		String stringA = packageSign(params, false);
		String stringSignTemp = stringA + "&key=" + partnerKey;
		return HashKit.md5(stringSignTemp).toUpperCase();
	}

	/**
	 * 组装签名的字段
	 * 
	 * @param params
	 *            参数
	 * @param urlEncoder
	 *            是否urlEncoder
	 * @return {String}
	 */
	public static String packageSign(Map<String, String> params, boolean urlEncoder) {
		// 先将参数以其参数名的字典序升序进行排序
		TreeMap<String, String> sortedParams = new TreeMap<String, String>(params);
		// 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Entry<String, String> param : sortedParams.entrySet()) {
			String value = param.getValue();
			if (StrUtil.isBlank(value)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				sb.append("&");
			}
			sb.append(param.getKey()).append("=");
			if (urlEncoder) {
				try {
					value = urlEncode(value);
				} catch (UnsupportedEncodingException e) {
				}
			}
			sb.append(value);
		}
		return sb.toString();
	}

	/**
	 * urlEncode
	 * 
	 * @param src
	 *            微信参数
	 * @return String
	 * @throws UnsupportedEncodingException
	 *             编码错误
	 */
	public static String urlEncode(String src) throws UnsupportedEncodingException {
		return URLEncoder.encode(src, "utf-8").replace("+", "%20");
	}
}
