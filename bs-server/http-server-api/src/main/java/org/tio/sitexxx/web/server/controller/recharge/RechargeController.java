/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.controller.recharge;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.tio.http.common.HttpConfig;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.annotation.RequestPath;
import org.tio.http.server.mvc.Routes;
import org.tio.http.server.util.Resps;
import org.tio.sitexxx.service.cache.CacheConfig;
import org.tio.sitexxx.service.cache.Caches;
import org.tio.sitexxx.service.model.main.RechargeItem;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.UserAgent;
import org.tio.sitexxx.service.service.base.UserAgentService;
import org.tio.sitexxx.service.service.recharge.RechargeItemService;
import org.tio.sitexxx.servicecommon.utils.LogUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.service.vo.RequestExt;
import org.tio.sitexxx.web.server.controller.base.QrCodeController;
import org.tio.sitexxx.web.server.recharge.IRechargeProvider;
import org.tio.sitexxx.web.server.recharge.RechargeServiceFactory;
import org.tio.sitexxx.web.server.recharge.provider.weixin.WxPayScan2RechargeProvider;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.cache.ICache;
import org.tio.utils.jfinal.P;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

import cn.hutool.core.util.StrUtil;

/**
 * 
 * 
 * @author tanyaowu 
 * @创建时间 2016年5月23日 上午10:28:13
 *
 * @操作列表
 *  编号	| 操作时间	| 操作人员	 | 操作说明
 *  (1) | 2016年5月23日 | tanyaowu | 新建类
 *
 */
@RequestPath("/recharge")
public class RechargeController {
	private static Logger log = LogUtils.getCoinLog();

	/**
	 * 
	 */
	public RechargeController() {

	}

	/**
	 * 生成本系统的订单号
	 * @return
	 */
	public static String newTradeno(HttpRequest request) {
		String ret = WebUtils.currUserId(request) + RandomStringUtils.randomAlphabetic(5) + new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date());
		return ret;
	}

	public static boolean isFromWeixin(HttpRequest request) {
		String userAgent = request.getUserAgent();
		if (userAgent != null && userAgent.contains("MicroMessenger")) {
			return true;
		}
		return false;
	}

	public static boolean isFromAlipay(HttpRequest request) {
		String userAgent = request.getUserAgent();
		if (userAgent != null && userAgent.contains("AlipayClient")) {
			return true;
		}
		return false;
	}

	/**
	 * 生成支付二维码
	 * @param request
	 * @param rechargeItem
	 * @param width
	 * @param height
	 * @return
	 * @throws Exception
	 * @author tanyaowu
	 */
	@RequestPath(value = "/qr")
	public HttpResponse qr(HttpRequest request, RechargeItem rechargeItem, Integer width, Integer height) throws Exception {
		if (width == null) {
			width = 200;
		}
		if (height == null) {
			height = 200;
		}

		width = Math.min(width, 1200);
		height = Math.min(height, 1200);

		IRechargeProvider rechargeProvider = RechargeServiceFactory.getThirdRechargeService(rechargeItem.getPaytype());
		QrCodeController qrCodeController = Routes.getController(QrCodeController.class);
		if (rechargeProvider instanceof WxPayScan2RechargeProvider) {
			request.setAttribute("recharge_only_qr", 1);
			request.setAttribute("recharge_only_qr_width", width);
			request.setAttribute("recharge_only_qr_height", height);
			return submit(request, rechargeItem);
		}

		HttpConfig httpConfig = request.httpConfig;
		String uuid = httpConfig.getSessionIdGenerator().sessionId(httpConfig, request);
		ICache cache = Caches.getCache(CacheConfig.RECHARGE_QR);
		cache.put(uuid, rechargeItem);

		String str = Const.SITE + httpConfig.getContextPath() + "/recharge/qrSubmit/" + uuid + "/" + request.getHttpSession().getId() + httpConfig.getSuffix();
		//		QrCodeController qrCodeController = Routes.getController(QrCodeController.class);
		return qrCodeController.index(width, height, null, null, str, request);
	}

	/**
	 * 用户扫码后提交
	 * @param request
	 * @param uuid
	 * @param tio_http_sessionid
	 * @return
	 * @throws Exception
	 * @author tanyaowu
	 */
	@RequestPath(value = "/qrSubmit/{uuid}/{tio_http_sessionid}")
	public HttpResponse qrSubmit(HttpRequest request, String uuid, String tio_http_sessionid) throws Exception {
		ICache cache = Caches.getCache(CacheConfig.RECHARGE_QR);
		RechargeItem rechargeItem = (RechargeItem) cache.get(uuid);
		if (rechargeItem == null) {
			return Resps.json(request, Resp.fail("二维码失效或过期"));
		}

		if (isFromAlipay(request)) {
			rechargeItem.setPaytype(RechargeItem.Paytype.ALIPAY_H5);
		}
		//		else if (isFromWeixin(request)) {
		//			rechargeItem.setPaytype(RechargeItem.Paytype.WEIXIN);
		//			request.setAttribute("recharge_only_qr", 1);
		//		}
		else {
			return Resps.html(request, "请用支付宝");
		}

		//		cache.remove(uuid);
		request.setAttribute("rechargeItem", rechargeItem);
		return Resps.forward(request, "/recharge");
	}

	/**
	 * 用户点击"充值"后执行的方法<br>
	 * 本方法将会把待充值的记录添加到数据库中
	 * 前台需要传
	 * <li>
	 * amount(充值金额元)
	 * </li>
	 * <li>
	 * goods(商品名字，可以为空)
	 * </li>
	 * <li>
	 * goodscount(商品数量，可以为空)
	 * </li>
	 * <li>
	 * paytype(支付方式)
	 * </li>
	 * 
	 * @param request
	 * @param rechargeItem
	 * @throws Exception
	 */
	@RequestPath(value = "")
	public HttpResponse submit(HttpRequest request, RechargeItem rechargeItem) throws Exception {
		RechargeItem rechargeItem1 = (RechargeItem) request.getAttribute("rechargeItem");
		if (rechargeItem1 != null) {
			rechargeItem = rechargeItem1;
		}

		Double costmoney = rechargeItem.getAmount();
		Double MIN_PAY = Double.valueOf(P.get("recharge.least.money", "1"));

		if (costmoney == null || costmoney < MIN_PAY) {
			return Resps.json(request, Resp.fail().msg("最低充值额为" + MIN_PAY + "元哦"));
		}
		Integer paytype = rechargeItem.getPaytype();

		IRechargeProvider rechargeProvider = RechargeServiceFactory.getThirdRechargeService(paytype);
		if (rechargeProvider == null) {
			return Resps.html(request, "请选择正确的支付方式!");
		}

		User user = WebUtils.currUser(request);
		if (user == null) {
			return Resps.html(request, "请先登录!");
		}
		//		String referer = request.getParam("");//.getHeader(HttpConst.RequestHeaderKey.Referer);
		//		rechargeItem.setReferer(referer);
		if (StrUtil.isBlank(rechargeItem.getCallback())) {
			rechargeItem.setCallback(rechargeItem.getReferer());
		}
		//		else if(StrUtil.isBlank(rechargeItem.getCallback())){
		//			rechargeItem.setCallback(Const.SITE + "/");
		//		}
		Integer userid = user.getId();

		//本系统的订单号
		String tradeno = newTradeno(request);
		rechargeItem.setStatus(RechargeItem.Status.NO_PAY);
		rechargeItem.setUserid(userid);
		rechargeItem.setTradeno(tradeno);

		RequestExt requestExt = WebUtils.getRequestExt(request);
		rechargeItem.setClienttype((int) requestExt.getDeviceType());

		String userAgentStr = request.getUserAgent();
		UserAgent userAgent = UserAgentService.ME.save(userAgentStr);
		if (userAgent.getId() != null) {
			rechargeItem.setUseragentid(userAgent.getId());
		} else {
			rechargeItem.setClientinfo(StringUtils.left(userAgentStr, 255));
		}

		rechargeItem.setRemoteip(request.getClientIp());
		Date date = new Date();
		rechargeItem.setCreatetime(date);
		rechargeItem.setUpdatetime(date);

		RechargeItemService.me.save(rechargeItem);
		return rechargeProvider.toThirdRechargePage(request, rechargeItem, paytype);
	}

	/**
	 * 
	 * @param request
	 * @param paytype
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "/rt/{paytype}")
	public HttpResponse returnurl(HttpRequest request, Integer paytype) throws Exception {
		IRechargeProvider rechargeProvider = RechargeServiceFactory.getThirdRechargeService(paytype);
		if (rechargeProvider == null) {
			request.close();
			return null;
		}

		Boolean isValidCallback = rechargeProvider.isValidCallback(request, IRechargeProvider.CallType.RETURN); //是不是合法的回调
		if (!isValidCallback) {
			log.error("非法return url回调\r\n{}", request.toString());
			request.close();
			return null;
		}

		//本系统的订单号
		String tradeno = rechargeProvider.getTradeno(request, IRechargeProvider.CallType.RETURN);

		RechargeItem rechargeItem = RechargeItemService.me.selectByTradeno(tradeno);
		//TO:此处添加中间页面处理逻辑
		if (rechargeItem == null) {
			log.error("找不到充值记录, tradeno: {}\r\n{}", tradeno, request.toString());
			return Resps.redirect(request, Const.SITE + "/");
		} else {
			return Resps.redirect(request, rechargeItem.getCallback());
		}

	}

	/**
	 * 
	 * @param request
	 * @param paytype
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "/nf/{paytype}")
	public HttpResponse notifyurl(HttpRequest request, Integer paytype) throws Exception {
		log.info("收到notifyurl回调,from {}\r\n{}", request.getClientIp(), request.toString());

		IRechargeProvider rechargeProvider = RechargeServiceFactory.getThirdRechargeService(paytype);
		if (rechargeProvider == null) {
			request.close();
			return null;
		}

		Boolean isValidCallback = rechargeProvider.isValidCallback(request, IRechargeProvider.CallType.NOTIFY);
		if (!isValidCallback) {
			log.info("非法notifyurl回调,from {}\r\n{}", request.getClientIp(), request.toString());
			request.close();
			return null;
		}

		//本系统的订单号
		String tradeno = rechargeProvider.getTradeno(request, IRechargeProvider.CallType.NOTIFY);

		RechargeItem rechargeItem = RechargeItemService.me.selectByTradeno(tradeno);
		if (rechargeItem == null) {
			log.error("找不到充值记录, tradeno: {}\r\n{}", tradeno, request.toString());
			return rechargeProvider.notifyFail(request, rechargeItem, paytype);
		}
		rechargeItem.setRemoteipnotify(request.getClientIp());

		if (!Objects.equals(rechargeItem.getStatus(), RechargeItem.Status.NO_PAY)) {
			log.error("该订单已经处理， 不允许再次处理 tradeno: {}\r\n{}", tradeno, request.toString());
			return rechargeProvider.notifySuccess(request, rechargeItem, paytype); //已经加币成功，也告诉支付平台成功
		}

		try {
			rechargeProvider.fillOnNotify(request, rechargeItem, paytype);
		} catch (Exception e1) {
			log.error("充值回调异常", e1);
			throw e1;
		}

		Integer tradeStatus = rechargeItem.getStatus();//订单状态

		if (Objects.equals(tradeStatus, RechargeItem.Status.SUCCESS) || Objects.equals(tradeStatus, RechargeItem.Status.FINISHED)) {
			try {
				log.info("充值成功了:{}", Json.toFormatedJson(rechargeItem));
				RechargeItemService.me.updateUserAndRecharge(rechargeItem);
				return rechargeProvider.notifySuccess(request, rechargeItem, paytype);
			} catch (Exception e) {
				Map<String, Object> map = new HashMap<>();
				map.put("msg", "充值交易成功，但更新数据库时出现异常");
				map.put("recharge", rechargeItem);
				map.put("exception", ExceptionUtils.getStackTrace(e));
				log.error(Json.toFormatedJson(map));
				return rechargeProvider.notifyFail(request, rechargeItem, paytype);
			}
		} else if (Objects.equals(tradeStatus, RechargeItem.Status.CANCELED)) {
			try {
				log.error("充值取消了:{}", Json.toFormatedJson(rechargeItem));
				RechargeItemService.me.update(rechargeItem);
				return rechargeProvider.notifySuccess(request, rechargeItem, paytype);
			} catch (Exception e) {
				Map<String, Object> map = new HashMap<>();
				map.put("msg", "充值交易关闭，更新数据库时出现异常");
				map.put("recharge", rechargeItem);
				map.put("exception", ExceptionUtils.getStackTrace(e));
				log.error(Json.toFormatedJson(map));
				return rechargeProvider.notifyFail(request, rechargeItem, paytype);
			}
		} else if (Objects.equals(tradeStatus, RechargeItem.Status.ATTACK)) {//是受到攻击的充值
			try {
				log.error("充值受到攻击了:{}", Json.toFormatedJson(rechargeItem));

				RechargeItemService.me.attackRecharge(rechargeItem);
				return rechargeProvider.notifySuccess(request, rechargeItem, paytype);
			} catch (Exception e) {
				Map<String, Object> map = new HashMap<>();
				map.put("msg", "充值交易状态为未知状态，更新数据库时出现异常");
				map.put("recharge", rechargeItem);
				map.put("exception", ExceptionUtils.getStackTrace(e));
				log.error(Json.toFormatedJson(map));
				return rechargeProvider.notifyFail(request, rechargeItem, paytype);
			}
		} else if (Objects.equals(tradeStatus, RechargeItem.Status.OTHER)) {
			try {
				log.error("充值异常了:{}", Json.toFormatedJson(rechargeItem));
				RechargeItemService.me.update(rechargeItem);
				return rechargeProvider.notifySuccess(request, rechargeItem, paytype);
			} catch (Exception e) {
				Map<String, Object> map = new HashMap<>();
				map.put("msg", "充值交易状态为未知状态，更新数据库时出现异常");
				map.put("recharge", rechargeItem);
				map.put("exception", ExceptionUtils.getStackTrace(e));
				log.error(Json.toFormatedJson(map));
				return rechargeProvider.notifyFail(request, rechargeItem, paytype);
			}
		} else if (Objects.equals(tradeStatus, RechargeItem.Status.NO_PAY)) {
			try {
				log.error(rechargeProvider.getClass().getName() + ".fillOnNotify()没有修改订单状态:{}", Json.toFormatedJson(rechargeItem));
				//				RechargeItemService.me.update(rechargeItem);
				return rechargeProvider.notifyFail(request, rechargeItem, paytype);
			} catch (Exception e) {
				Map<String, Object> map = new HashMap<>();
				map.put("msg", "notifyFail时异常了");
				map.put("recharge", rechargeItem);
				map.put("exception", ExceptionUtils.getStackTrace(e));
				log.error(Json.toFormatedJson(map));
				return rechargeProvider.notifyFail(request, rechargeItem, paytype);
			}
		}
		return rechargeProvider.notifyFail(request, rechargeItem, paytype);
	}

	/**
	 * 充值跳转信息
	 * @param request
	 * @param tradeno
	 * @return
	 * @throws Exception
	 * 
	 * @date 2016年5月14日 上午11:02:46
	 */
	@RequestPath(value = "/getCallback")
	public Resp getCallback(HttpRequest request, String tradeno) throws Exception {
		User user = WebUtils.currUser(request);
		RechargeItem rechargeItem = RechargeItemService.me.selectByTradeno(tradeno);
		if (rechargeItem == null) {
			log.error("找不到充值记录, tradeno: {}\r\n{}", tradeno, request.toString());
			return Resp.ok().data("/");
		}
		if (!Objects.equals(rechargeItem.getUserid(), user.getId())) {
			log.error("无效用户充值记录, tradeno: {}\r\n{}", tradeno, request.toString());
			return Resp.ok().data("/");
		}
		if (Objects.equals(rechargeItem.getStatus(), RechargeItem.Status.SUCCESS) || Objects.equals(rechargeItem.getStatus(), RechargeItem.Status.FINISHED)) {
			String path = rechargeItem.getCallback();
			if (StrUtil.isBlank(path)) {
				path = "/";
			}

			return Resp.ok().data(path);
		} else {
			return Resp.fail();
		}
	}

	//
	//	/**
	//	 * @param args
	//	 */
	public static void main(String[] args) {
		Byte xx = 2;
		int xxx = (int) xx;

		System.out.println(xxx);
	}
}
