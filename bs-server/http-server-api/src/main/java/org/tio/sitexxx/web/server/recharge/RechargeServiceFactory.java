/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * **************************************************************************
 *
 * @说明: 
 * @项目名称: talent-app-mm
 *
 * @author: tanyaowu 
 * @创建时间: 2016年5月23日 下午3:48:59
 *
 * **************************************************************************
 */
package org.tio.sitexxx.web.server.recharge;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.service.model.main.RechargeItem;
import org.tio.sitexxx.web.server.recharge.provider.alipay.AlipayAppRechargeProvider;
import org.tio.sitexxx.web.server.recharge.provider.alipay.AlipayH5RechargeProvider;
import org.tio.sitexxx.web.server.recharge.provider.alipay.AlipayRechargeProvider;
import org.tio.sitexxx.web.server.recharge.provider.apple.AppleRechargeProvider;
import org.tio.sitexxx.web.server.recharge.provider.weixin.WxPayAppRechargeProvider;
import org.tio.sitexxx.web.server.recharge.provider.weixin.WxPayH5RechargeProvider;
import org.tio.sitexxx.web.server.recharge.provider.weixin.WxPayJsapiRechargeProvider;
import org.tio.sitexxx.web.server.recharge.provider.weixin.WxPayScan2RechargeProvider;

/**
 * 
 * @author tanyaowu 
 * @创建时间 2016年5月23日 下午3:48:59
 *
 * @操作列表
 *  编号	| 操作时间	| 操作人员	 | 操作说明
 *  (1) | 2016年5月23日 | tanyaowu | 新建类
 *
 */
public class RechargeServiceFactory {
	private static Logger log = LoggerFactory.getLogger(RechargeServiceFactory.class);

	/**
	 * 
	 *
	 * @author: tanyaowu
	 * @创建时间:　2016年5月23日 下午3:49:00
	 * 
	 */
	public RechargeServiceFactory() {
	}

	/**
		1:    支付宝<hr>
		11:   支付宝APP<hr>
		111:  支付宝H5<hr>
		2:    微信扫码<hr>
		22:   微信APP<hr>
		33:   苹果内购<hr>
	 * @param paytype
	 * @return
	 * @author: tanyaowu
	 * @创建时间:　2016年6月2日 下午1:25:52
	 */
	public static IRechargeProvider getThirdRechargeService(Integer paytype) {
		if (Objects.equals(paytype, RechargeItem.Paytype.ALIPAY)) {
			return AlipayRechargeProvider.me;
		} else if (Objects.equals(paytype, RechargeItem.Paytype.ALIPAY_APP)) {
			return AlipayAppRechargeProvider.me;
		} else if (Objects.equals(paytype, RechargeItem.Paytype.ALIPAY_H5)) {
			return AlipayH5RechargeProvider.me;
		} else if (Objects.equals(paytype, RechargeItem.Paytype.WEIXIN)) {
			return WxPayScan2RechargeProvider.me;
		} else if (Objects.equals(paytype, RechargeItem.Paytype.WEIXIN_APP)) {
			return WxPayAppRechargeProvider.me;
		} else if (Objects.equals(paytype, RechargeItem.Paytype.WEIXIN_H5)) {
			return WxPayH5RechargeProvider.me;
		} else if (Objects.equals(paytype, RechargeItem.Paytype.WEIXIN_JSAPI)) {
			return WxPayJsapiRechargeProvider.me;
		} else if (Objects.equals(paytype, RechargeItem.Paytype.APPLE_APP)) {
			return AppleRechargeProvider.me;
		}

		log.error("paytype:{}, 找不到相应的处理类", paytype);
		return null;
	}

	/**
	 * @param args
	 *
	 * @author: tanyaowu
	 * @创建时间:　2016年5月23日 下午3:49:00
	 * 
	 */
	public static void main(String[] args) {
		//				1:支付宝
		//				2:微信
		//		
		//				101:银联(网关支付)
		//				102:银联(无跳转支付)
		//				103:银联(企业网银支付)
		//				104:银联(手机控件支付)
		//				105:银联(手机网页支付)
		//				106:银联(银联云闪付)
	}
}
