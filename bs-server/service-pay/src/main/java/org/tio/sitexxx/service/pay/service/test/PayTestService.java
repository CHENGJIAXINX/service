/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.service.pay.service.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;

import com.alibaba.fastjson15.JSONObject;
import com.upay.sdk.exception.HmacVerifyException;
import com.upay.sdk.exception.RequestException;
import com.upay.sdk.exception.ResponseException;
import com.upay.sdk.exception.UnknownException;
import com.upay.sdk.executer.ResultListenerAdpater;
import com.upay.sdk.webox.builder.WalletCreateBuilder;
import com.upay.sdk.webox.executer.WalletExecuter;

/**
 * 
 * @author xufei 2020年11月2日 下午5:22:30
 */
public class PayTestService {

	/**
	 * 
	 */
	public PayTestService() {
	}

	private static Logger log = LoggerFactory.getLogger(PayTestService.class);

	public static final PayTestService me = new PayTestService();

	public Ret open() {
		Ret ret = Ret.ok();
		WalletCreateBuilder builder = new WalletCreateBuilder("890000595");
		builder.setRequestId("202011021604306995219").setMerchantId("890000595").setMerchantUserId("89666819200402")
				.setName("徐飞").setIdCardType("IDCARD").setIdCardNo("41152819880314003X").setMobile("18158182228")
				.setProfession("A").setIp("192.168.1.1").setMac("0.0.0.0").setNickName("徐飞");

//		log.info("WalletCreateServlet builder:" + ToStringBuilder.reflectionToString(builder));

		WalletExecuter executer = new WalletExecuter();
		try {
			executer.bothCreate(builder, new ResultListenerAdpater() {
				@Override
				public void success(JSONObject jsonObject) {
					ret.set("msg", jsonObject.toJSONString());
				}

				@Override
				public void failure(JSONObject jsonObject) {
					ret.set("msg", jsonObject.toJSONString());
				}

				@Override
				public void pending(JSONObject jsonObject) {
					ret.set("msg", jsonObject.toJSONString());
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常</br>");
		} catch (HmacVerifyException e) {
			log.error("签名验证异常</br>");
		} catch (RequestException e) {
			log.error("请求异常</br>");
		} catch (UnknownException e) {
			log.error("未知异常</br>");
		}
		return ret;
	}

}
