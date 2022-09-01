/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.http.common.HttpRequest;
import org.tio.mg.im.common.Command;
import org.tio.mg.im.common.CommandHandler;
import org.tio.mg.im.common.ImPacket;
import org.tio.mg.im.server.utils.ImUtils;
import org.tio.mg.service.model.main.User;
import org.tio.mg.service.model.main.UserActionLog;
import org.tio.mg.service.model.main.UserAgent;
import org.tio.mg.service.service.base.UserAgentService;
import org.tio.mg.service.vo.SimpleUser;
import org.tio.utils.json.Json;

/**
 * 
 * @author tanyaowu 
 * 2016年12月29日 下午10:16:51
 */
@CommandHandler(Command.UserActionLogReq)
public class UserActionLogReqHandler implements ImServerHandler {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(UserActionLogReqHandler.class);

	public UserActionLogReqHandler() {
	}

	@Override
	public void handler(ImPacket packet, ChannelContext channelContext, boolean isWebsocket) throws Exception {
		User curr = ImUtils.getUser(channelContext);
		//		boolean isSuper = false;
		//		if (curr != null && (UserService.isSuper(curr.getLoginname()) || curr.isAdmin())) {
		//			isSuper = true;// null;
		//		}

		//path actiontype
		UserActionLog userActionLog = Json.toBean(packet.getBodyStr(), UserActionLog.class);
		userActionLog.setActiondesc(UserActionLog.Action.getName(userActionLog.getActiontype()));
		userActionLog.setInitpath(userActionLog.getPath()); //先这么做
		userActionLog.setSession(ImUtils.getToken(channelContext));

		if (curr != null) {
			userActionLog.setMayuid(curr.getId());
			userActionLog.setUid(curr.getId());
		} else {
			SimpleUser fromUser = ImUtils.getHandshakeSimpleUser(channelContext);

			if (fromUser != null) {
				if (fromUser.getMay() != null) {
					userActionLog.setMayuid(fromUser.getMay().getI());
				} else {
					userActionLog.setMayuid(fromUser.getI());
				}

				userActionLog.setUid(fromUser.getI());
			}
		}

		if (isWebsocket) {
			HttpRequest httpRequest = ImUtils.getHandshakeRequest(channelContext);
			String ua = httpRequest.getUserAgent();
			UserAgent userAgent = UserAgentService.ME.save(ua);
			userActionLog.setUaid(userAgent.getId());
		}

		userActionLog.save();
	}
}
