/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.service.UserCoinItemService;
import org.tio.sitexxx.service.service.UserCoinService;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

/**
 * 用户财务信息请求类
 * 
 */
@RequestPath(value = "/usercoin")
public class UserCoinController {

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(UserCoinController.class);

	/**
	 * 
	 * 
	 */
	public UserCoinController() {
	}

	/**
	 * 充值记录
	 * @param request
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws Exception
	 * 
	 */
	@RequestPath(value = "/getRechargeList")
	public Resp getRechargeList(HttpRequest request, Integer pageNumber, Integer pageSize) throws Exception {
		User user = WebUtils.currUser(request);
		Map<String, Object> params = WebUtils.getMapParams(request);
		Ret ret = UserCoinService.me.getUserRecharge(user.getId(), params, pageNumber, pageSize);
		if (ret.isOk()) {
			return Resp.ok().data(ret.get("data"));
		} else {
			return Resp.fail(ret.getStr("msg"));
		}
	}

	/**
	 * 用户资产明细
	 * @param request
	 * @param coinmode
	 * @param month
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @throws Exception
	 * 
	 */
	@RequestPath(value = "/getCoinDetail")
	public Resp getCoinDetail(HttpRequest request, Byte coinmode, String month, Integer pageNumber, Integer pageSize) throws Exception {
		User user = WebUtils.currUser(request);
		Ret ret = UserCoinItemService.me.getUserCoinItem(user.getId(), coinmode, month, pageNumber, pageSize);
		if (ret.isOk()) {
			return Resp.ok().data(ret.get("data"));
		} else {
			return Resp.fail(ret.getStr("msg"));
		}
	}

}
