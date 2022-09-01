/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.sitexxx.service.pay.base.BasePayResp;
import org.tio.sitexxx.service.pay.impl.pay5u.Pay5UConst;
import org.tio.sitexxx.service.pay.service.PayService;

/**
 * 支付回调
 * 
 */
@RequestPath(value = "/paycallback")
public class PayCallbackController {

	private static Logger log = LoggerFactory.getLogger(PayCallbackController.class);

	/**
	 * 
	 * 
	 */
	public PayCallbackController() {
	}

	/**
	 * 充值接口
	 * @param request
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月6日 下午4:25:37
	 */
	@RequestPath(value = "/recharge")
	public String recharge(HttpRequest request,Integer uid) throws Exception {
		BasePayResp resp = PayService.me.rechargeCallback(request,uid);
		if(!resp.isOk()) {
			return Pay5UConst.Status.SUCCESS;
		}
		return Pay5UConst.Status.SUCCESS;
	}
	
	
	/**
	 * 提现接口
	 * @param request
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月6日 下午4:26:20
	 */
	@RequestPath(value = "/withhold")
	public String withhold(HttpRequest request,Integer uid) throws Exception {
		BasePayResp resp = PayService.me.withholdCallback(request,uid);
		if(!resp.isOk()) {
			log.error(resp.getMsg());
			return Pay5UConst.Status.SUCCESS;
		}
		return Pay5UConst.Status.SUCCESS;
	}
	
	/**
	 * 发红包接口
	 * @param request
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月6日 下午4:27:04
	 */
	@RequestPath(value = "/redpacket")
	public String redpacket(HttpRequest request,Integer uid) throws Exception {
		BasePayResp resp = PayService.me.redpacketCallback(request,uid);
		if(!resp.isOk()) {
			log.error(resp.getMsg());
			return Pay5UConst.Status.SUCCESS;
		}
		return Pay5UConst.Status.SUCCESS;
	}
}
