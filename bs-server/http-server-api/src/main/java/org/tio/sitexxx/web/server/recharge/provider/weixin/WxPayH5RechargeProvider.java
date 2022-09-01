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
import org.tio.sitexxx.web.server.recharge.RechargeUtils;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

import com.github.wxpay.sdk.WXPayConfig;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

/**
 *文档
 *	地址：https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=9_20&index=1
 *回调页面
 *	参数：redirect_url
 *	文档：https://pay.weixin.qq.com/wiki/doc/api/H5.php?chapter=15_4
 * 微信H5支付
 * @author tanyaowu
 */
public class WxPayH5RechargeProvider extends WxPayScan2RechargeProvider {
	private static Logger log = LogUtils.getCoinLog();

	public static final WxPayH5RechargeProvider me = new WxPayH5RechargeProvider();

	//	protected WXPay wxpay;
	//	protected WXPayConfigImpl config;

	protected WxPayH5RechargeProvider() {
		super();
		//		config = WXPayConfigImpl.getInstance();
		//		wxpay = new WXPay(config);
	}

	@Override
	public WXPayConfig getWXPayConfig() {
		return WXPayConfigImpl.getInstance();
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

		/**
		 * <appid>wx2421b1c4370ec43b</appid>
			<attach>支付测试</attach>
			<body>H5支付测试</body>
			<mch_id>10000100</mch_id>      //sdk中传了
			<nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>  //sdk中传了
			<notify_url>http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php</notify_url>
			<openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>
			<out_trade_no>1415659990</out_trade_no>
			<spbill_create_ip>14.23.150.211</spbill_create_ip>
			<total_fee>1</total_fee>
			<trade_type>MWEB</trade_type>
			<scene_info>{"h5_info": {"type":"IOS","app_name": "王者荣耀","package_name": "com.tencent.tmgp.sgame"}}</scene_info>
			<sign>0CB01533B8C1EF103065174F50BCA001</sign>
		 */
		Map<String, String> data = new HashMap<String, String>();
		data.put("body", _subject);//"腾讯充值中心-QQ会员充值"
		data.put("out_trade_no", tradeno);
		data.put("device_info", "");
		data.put("fee_type", "CNY");
		data.put("total_fee", total_fee);
		data.put("spbill_create_ip", ip);
		data.put("notify_url", RechargeUtils.getNotifyUrl(paytype, request));
		data.put("trade_type", TradeType.MWEB.getValue());
		//		data.put("product_id", "12235413214070356458058");
		data.put("product_id", tradeno);
		// data.put("time_expire", "20170112104120");

		//		String errormsg = null;

		try {
			Map<String, String> r = wxpay.unifiedOrder(data);

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
						 * mweb_url为拉起微信支付收银台的中间页面，可通过访问该url来拉起微信客户端，完成支付,mweb_url的有效期为5分钟。
						 * 示例：https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb?prepay_id=wx2016121516420242444321ca0631331346&package=1405458241	
						 */
						String mweb_url = r.get("mweb_url");

						Map<String, String> respData = new HashMap<>();
						respData.put("mweb_url", mweb_url);
						respData.put("tradeno", tradeno);
						return Resps.json(request, Resp.ok(respData));
					}
				} else {
					log.error("微信H5充值，提交失败:{}", Json.toJson(r));
				}
			} else {
				//				errormsg = "通讯失败";
				log.error("微信H5充值，通讯失败:{}", Json.toJson(r));
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
