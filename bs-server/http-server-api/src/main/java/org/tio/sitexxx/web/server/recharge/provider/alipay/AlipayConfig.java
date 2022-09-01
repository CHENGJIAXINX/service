/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.recharge.provider.alipay;

import org.tio.utils.jfinal.P;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;

/**
 * @author tanyaowu
 *
 */
public class AlipayConfig {

	public static final String charset = "utf-8";

	/**
	 * recharge.alipay.url=https://openapi.alipay.com/gateway.do
		recharge.alipay.appId=2088221416653785
		recharge.alipay.privateKey=rxmbpeehkmksrg3axfdkuhzv1y6v33xu
		recharge.alipay.account=hz86076876@163.com
	 */
	public static final String url = P.get("recharge.alipay.url");

	public static final String appId = P.get("recharge.alipay.appId");

	public static final String privateKey = P.get("recharge.alipay.privateKey");

	public static final String publicKey = P.get("recharge.alipay.publicKey", "");

	public static final String account = P.get("recharge.alipay.account");

	// 签名方式
	public static final String sign_type = "RSA2";//"RSA2";

	//String format,  String charset, String alipayPulicKey
	public static final AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.url, AlipayConfig.appId, AlipayConfig.privateKey, AlipayConstants.FORMAT_JSON, charset,
	        publicKey, sign_type);

	/**
	 * 
	 */
	public AlipayConfig() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
