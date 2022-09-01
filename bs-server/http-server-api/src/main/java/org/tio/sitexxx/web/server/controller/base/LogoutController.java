/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.base;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpConfig;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.session.HttpSession;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.im.server.handler.wx.WxChatQueueApi;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.UserToken;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.base.UserTokenService;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.Devicetype;
import org.tio.sitexxx.service.vo.RequestExt;
import org.tio.sitexxx.service.vo.SessionExt;
import org.tio.sitexxx.servicecommon.vo.SessionKey;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

/**
 * @author tanyaowu
 * 2016年6月29日 下午7:53:59
 */
@RequestPath(value = "/logout")
public class LogoutController {
	private static Logger log = LoggerFactory.getLogger(LogoutController.class);

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

	@SuppressWarnings("unused")
	private UserService userService = UserService.ME;

	/**
	 *
	 * @author tanyaowu
	 */
	public LogoutController() {
	}

	/**
	 * 退出登录
	 * @param request
	 * @return
	 * @throws Exception
	 * @author: tanyaowu
	 */
	@RequestPath(value = "")
	public Resp logout(HttpRequest request) throws Exception {
		HttpConfig httpConfig = request.getHttpConfig();
		HttpSession httpSession = request.getHttpSession();
		String sessionId = httpSession.getId();
		User user = WebUtils.currUser(request);
		if (user != null) {

			SessionExt sessionExt = httpSession.getAttribute(SessionKey.SESSION_EXT, SessionExt.class);
			sessionExt.setUid(null);
			sessionExt.setLoginTime(null);
			sessionExt.setKickedInfo(null);
			httpSession.update(httpConfig);//切记：每次修改SessionExt后，要调用一下update把数据更新到分布式缓存中
			RequestExt requestExt = WebUtils.getRequestExt(request);
			WxChatQueueApi.leaveFocusQueue(user, requestExt.getAppDevice(),"");
//			//离线
//			SynService.me.outline(user.getId(), requestExt.getDeviceType());
			//极光推送
			if (Objects.equals(ConfService.getByte(Const.JPushConfig.OPENFLAG,(byte)1),Const.YesOrNo.YES) && Objects.equals(requestExt.getAppDevice(), Devicetype.APP.getValue())) {
				Db.use(Const.Db.TIO_SITE_MAIN).update("delete from wx_jpush_user WHERE uid = ?",user.getId());
			}
			int c = UserTokenService.me.delete(requestExt.getAppDevice(), user.getId(), sessionId);
			if (c <= 0) {
				log.warn("can find usertoken by devicetype【{}】 and uid【{}】 and token:【{}】", requestExt.getAppDevice(), user.getId(), sessionId);

				UserToken userToken = UserTokenService.me.find(requestExt.getAppDevice(), user.getId());
				if (userToken != null) {
					String tokenInDb = userToken.getToken();
					HttpSession otherHttpSession = httpConfig.getHttpSession(tokenInDb);
					if (otherHttpSession != null) {
						Integer useridInOtherSession = WebUtils.getUserIdBySession(otherHttpSession);
						if (useridInOtherSession != null) {
							SessionExt sessionExtInOtherSession = otherHttpSession.getAttribute(SessionKey.SESSION_EXT, SessionExt.class);
							if (sessionExtInOtherSession != null) {
								sessionExtInOtherSession.setUid(null);
								otherHttpSession.update(httpConfig);
							}
						}
					}

				}
			}

			Resp resp = Resp.ok();
			return resp;
		} else {
			Resp resp = Resp.fail("你并未登录");
			return resp;
		}
	}
}
