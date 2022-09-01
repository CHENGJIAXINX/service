/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.recharge.provider.apple;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.tio.http.common.HttpRequest;
import org.tio.sitexxx.service.model.main.RechargeItem;
import org.tio.sitexxx.servicecommon.utils.LogUtils;
import org.tio.sitexxx.web.server.recharge.provider.apple.vo.In_app;
import org.tio.sitexxx.web.server.recharge.provider.apple.vo.Receipt;
import org.tio.sitexxx.web.server.recharge.provider.apple.vo.ReceiptResult;
import org.tio.utils.http.HttpUtils;
import org.tio.utils.jfinal.P;
import org.tio.utils.json.Json;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author tanyaowu
 *
 */
public class IosVerify {
	private static Logger log = LogUtils.getCoinLog();

	private static final String URL_SANDBOX = "https://sandbox.itunes.apple.com/verifyReceipt";

	private static final String URL_ONLINE = "https://buy.itunes.apple.com/verifyReceipt";

	/**
	 * 
	 * @param request
	 * @param receipt
	 * @param rechargeItem
	 * @return
	 * @throws Exception
	 * @author tanyaowu
	 */
	public static ReceiptResult verifyReceipt(HttpRequest request, String receipt, RechargeItem rechargeItem) throws Exception {
		//		RequestExt requestExt = WebUtils.getRequestExt(request);
		String url = URL_ONLINE;
		//		if (Objects.equals(IosCheckConf.Value.IN_VERIFY, value)) {
		//			url = URL_SANDBOX;
		//		} else {
		//			url = URL_ONLINE;
		//		}

		return verifyReceipt(request, url, receipt, true, rechargeItem);
	}

	/**
	 * 服务器二次验证代码  
	    * 21000 App Store不能读取你提供的JSON对象  
	    * 21002 receipt-data域的数据有问题  
	    * 21003 receipt无法通过验证  
	    * 21004 提供的shared secret不匹配你账号中的shared secret  
	    * 21005 receipt服务器当前不可用  
	    * 21006 receipt合法，但是订阅已过期。服务器接收到这个状态码时，receipt数据仍然会解码并一起发送  
	    * 21007 receipt是Sandbox receipt，但却发送至生产系统的验证服务  
	    * 21008 receipt是生产receipt，但却发送至Sandbox环境的验证服务
	 * @param request
	 * @param url
	 * @param receipt
	 * @param switchWhenFail
	 * @param rechargeItem
	 * @return
	 */
	public static ReceiptResult verifyReceipt(HttpRequest request, String url, String receipt, boolean switchWhenFail, RechargeItem rechargeItem) throws Exception {
		JSONObject data = new JSONObject();
		data.put("receipt-data", receipt);

		//            Map<String, String> headerMap = null;
		//            headerMap = new HashMap<>();
		//            headerMap.put("Content-Type", "application/json");
		String bodyString = data.toJSONString();
		okhttp3.Response response = HttpUtils.post(url, null, bodyString);
		String resultStr = response.body().string();

		//            String resultStr = EntityUtils.toString(httpEntity);  
		ReceiptResult receiptResult = Json.toBean(resultStr, ReceiptResult.class);
		Receipt receipt1 = receiptResult.getReceipt();
		String mybundleid = P.get("recharge.ios.bundleid");
		String bundleid = receipt1.getBundle_id();
		if (!Objects.equals(bundleid, mybundleid)) {
			throw new Exception("verifyReceipt fail， bundleid is " + bundleid + ", expected value is " + P.get("recharge.ios.bundleid"));
		}
		
		List<In_app> list = receipt1.getIn_app();
		if (CollUtil.isEmpty(list)) {
			throw new Exception("verifyReceipt fail，in_app 是空的");
		} else {
			In_app in_app = list.get(0);
			if (!StrUtil.startWith(in_app.getProduct_id(), mybundleid)) {
				throw new Exception("verifyReceipt fail， product_id is not " + mybundleid);
			}
		}
		
		Integer status = receiptResult.getStatus();
		rechargeItem.setRemark(url);
		if (Objects.equals(status, 0)) {
			log.info("苹果充值成功，resultStr:{}", resultStr);
		} else {
			log.error("苹果充值不成功，resultStr:{}", resultStr);
			if (switchWhenFail) {
				if (Objects.equals(status, 21007) && Objects.equals(URL_ONLINE, url)) {
					return verifyReceipt(request, URL_SANDBOX, receipt, false, rechargeItem);
				} else if (Objects.equals(status, 21008) && Objects.equals(URL_SANDBOX, url)) {
					return verifyReceipt(request, URL_ONLINE, receipt, false, rechargeItem);
				}
			}
		}
		return receiptResult;
	}

}
