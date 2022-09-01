/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.recharge.provider.weixin;

import java.util.Objects;

/**
 *    交易类型枚举 统一下单接口trade_type的传参可参考这里 
 * <li>JSAPI--公众号支付、小程序支付</li>
 * <li>NATIVE--原生扫码支付</li>
 * <li>APP--APP支付</li>
 * <li>MWEB--WAP支付(H5支付)</li>
 * <li>MICROPAY--刷卡支付,刷卡支付有单独的支付接口，不调用统一下单接口</li>
 * @author tanyaowu
 */
public enum TradeType {

	/**
	 * 公众号支付、小程序支付
	 */
	JSAPI("JSAPI"),
	/**
	 * 扫码支付
	 */
	NATIVE("NATIVE"), APP("APP"), WAP("WAP"),
	/**
	 * 刷卡支付,刷卡支付有单独的支付接口，不调用统一下单接口
	 */
	MICROPAY("MICROPAY"),

	/**
	 * H5支付
	 */
	MWEB("MWEB"), PAP("PAP");

	public static TradeType from(String value) {
		TradeType[] values = TradeType.values();
		for (TradeType v : values) {
			if (Objects.equals(v.value, value)) {
				return v;
			}
		}
		return null;
	}

	String value;

	private TradeType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}