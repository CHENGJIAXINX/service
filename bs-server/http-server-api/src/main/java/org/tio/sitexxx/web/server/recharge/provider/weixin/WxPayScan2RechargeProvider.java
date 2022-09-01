/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.recharge.provider.weixin;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.mvc.Routes;
import org.tio.http.server.util.Resps;
import org.tio.sitexxx.service.model.main.RechargeItem;
import org.tio.sitexxx.service.service.recharge.RechargeItemService;
import org.tio.sitexxx.servicecommon.utils.LogUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.SessionKey;
import org.tio.sitexxx.web.server.controller.base.QrCodeController;
import org.tio.sitexxx.web.server.recharge.IRechargeProvider;
import org.tio.sitexxx.web.server.recharge.RechargeUtils;
import org.tio.sitexxx.web.server.utils.SessionCacheUtils;
import org.tio.utils.json.Json;
import org.tio.websocket.common.util.BASE64Util;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayConstants.SignType;
import com.github.wxpay.sdk.WXPayUtil;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;

/**
 * 微信扫码支付（模式2）
 * @author tanyaowu
 */
public class WxPayScan2RechargeProvider implements IRechargeProvider {
	private static Logger log = LogUtils.getCoinLog();

	public static final WxPayScan2RechargeProvider me = new WxPayScan2RechargeProvider();

	protected WXPay			wxpay;
	protected WXPayConfig	config;

	protected WxPayScan2RechargeProvider() {
		config = getWXPayConfig();
		wxpay = new WXPay(config);
	}

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
		data.put("trade_type", TradeType.NATIVE.getValue());
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

						String code_url = r.get("code_url"); //二维码

						Integer recharge_only_qr = (Integer) request.getAttribute("recharge_only_qr");
						Integer width = (Integer) request.getAttribute("recharge_only_qr_width");
						Integer height = (Integer) request.getAttribute("recharge_only_qr_height");
						if (Objects.equals(recharge_only_qr, 1)) {
							QrCodeController qrCodeController = Routes.getController(QrCodeController.class);
							return qrCodeController.index(width, height, null, null, code_url, request);
						}

						Map<String, String> retData = new HashMap<>();
						retData.put("code_url", code_url);

						BufferedImage bufferedImage = QrCodeUtil.generate(code_url, 190, 190);//.generate(code_url, width, height, imageType, out);
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						ImageIO.write(bufferedImage, "png", out);
						byte[] bs = out.toByteArray();

						String ss = BASE64Util.byteArrayToBase64(bs);

						SessionCacheUtils.put(request, SessionKey.WX_PAY_QR_BASE64, ss);
						SessionCacheUtils.put(request, SessionKey.WX_PAY_AMOUNT, rechargeItem.getAmount());
						SessionCacheUtils.put(request, SessionKey.WX_PAY_SUBJECT, _subject);
						SessionCacheUtils.put(request, SessionKey.WX_PAY_TRADENO, tradeno);

						return Resps.redirect(request, Const.Path.WECHAT_PAY);//.json(request, Resp.ok(retData));
					}
				} else {
					log.error("微信扫码充值，提交失败:{}", Json.toJson(r));
				}
			} else {
				log.error("微信扫码充值，提交失败:{}", Json.toJson(r));
			}
		} catch (Exception e) {
			log.error("", e);
		}

		return null;
	}

	/**
	 * 把HttpRequest对象转换成Map，便于对请求进行验签
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected static Map<String, String> toMap(HttpRequest request) throws Exception {
		String arrName = "wxPay_params";
		HashMap<String, String> ret = (HashMap) request.getAttribute(arrName);
		if (ret != null) {
			return ret;
		}
		String bodyString = request.getBodyString();
		ret = (HashMap) WXPayUtil.xmlToMap(bodyString);
		request.setAttribute(arrName, ret);

		return ret;
	}

	@Override
	public boolean isValidCallback(HttpRequest request, int callbackType) throws Exception {
		Map<String, String> params = toMap(request);
		String sign_type = params.get("sign_type");
		boolean verify_result = false;
		if (StrUtil.isNotBlank(sign_type)) {
			if ("MD5".equalsIgnoreCase(sign_type)) {
				verify_result = WXPayUtil.isSignatureValid(params, config.getKey(), SignType.MD5);
			} else if ("HMAC-SHA256".equalsIgnoreCase(sign_type)) {
				verify_result = WXPayUtil.isSignatureValid(params, config.getKey(), SignType.HMACSHA256);
			} else {
				verify_result = WXPayUtil.isSignatureValid(params, config.getKey());
			}
		} else {
			verify_result = WXPayUtil.isSignatureValid(params, config.getKey());
		}
		return verify_result;
	}

	@Override
	public String getTradeno(HttpRequest request, int callbackType) {
		Map<String, String> params = null;
		try {
			params = toMap(request);
		} catch (Exception e) {
			log.error("", e);
			return null;
		}
		String out_trade_no = params.get("out_trade_no");
		return out_trade_no;
	}

	@Override
	public void fillOnNotify(HttpRequest request, RechargeItem rechargeItem, int callbackType) {
		Map<String, String> params = null;
		try {
			params = toMap(request);
		} catch (Exception e) {
			log.error("", e);
			return;
		}

		String return_code = params.get("return_code");
		//商户订单号
		//		String out_trade_no = params.get("out_trade_no");
		//微信支付订单号
		String transaction_id = params.get("transaction_id");
		//签名类型
		//				String sign_type = params.get("sign_type");
		//交易状态
		String result_code = params.get("result_code");
		//付款银行
		String bank_type = params.get("bank_type");
		//交易金额
		String total_fee = params.get("total_fee");
		Integer totalfee1 = Integer.parseInt(total_fee);
		double totalfee = totalfee1 / 100;
		//			thirdamount = thirdamount / 100;    //因为支付宝的金额单位是分，所以这里要除以100
		//交易付款时间
		String time_end = params.get("time_end");
		String nonce_str = params.get("nonce_str");

		rechargeItem.setThirdtradeno(transaction_id);
		rechargeItem.setThirdstatus(result_code);
		rechargeItem.setThirdaccount(bank_type);
		rechargeItem.setThirdamount(totalfee);
		rechargeItem.setThirdnotifyid(nonce_str);

		try {
			rechargeItem.setThirdtradetime(new SimpleDateFormat("yyyyMMddHHmmss").parse(time_end));
		} catch (Exception e) {
			LogUtils.getCoinLog().error(time_end + "进行日期转换出错了", e);
		}

		if ("SUCCESS".equals(return_code) && "SUCCESS".equals(result_code)) {
			rechargeItem.setStatus(RechargeItem.Status.SUCCESS);
		} else if ("FAIL".equals(result_code)) {
			rechargeItem.setStatus(RechargeItem.Status.CANCELED);
		} else {
			rechargeItem.setStatus(RechargeItem.Status.OTHER);
		}

		rechargeItem.setRemark(StringUtils.left(request.getHeaderString() + request.getBodyString(), 2048));
	}

	@Override
	public HttpResponse notifySuccess(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception {
		return Resps.html(request, "<xml><return_code>SUCCESS</return_code><return_msg>OK</return_msg></xml>");
	}

	@Override
	public HttpResponse notifyFail(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception {
		return Resps.html(request, "<xml><return_code>FAIL</return_code><return_msg>fail</return_msg></xml>");
	}

	public static void main(String[] args) {
		double xx = NumberUtil.mul((double) 2.07, (float) 100);
		System.out.println(xx);
	}

}
