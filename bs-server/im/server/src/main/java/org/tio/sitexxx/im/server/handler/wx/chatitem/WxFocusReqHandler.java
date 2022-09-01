/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server.handler.wx.chatitem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.sitexxx.im.common.Command;
import org.tio.sitexxx.im.common.CommandHandler;
import org.tio.sitexxx.im.common.ImPacket;
import org.tio.sitexxx.im.server.handler.AbsImServerHandler;
import org.tio.sitexxx.im.server.handler.wx.WxChatApi;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.vo.SimpleUser;

/**
 * 焦点同步请求，Client-->Server
 * 
 * @author xufei
 * 2020年8月27日 下午3:14:44
 */
@CommandHandler(Command.WxFocusReq)
public class WxFocusReqHandler extends AbsImServerHandler {

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(WxFocusReqHandler.class);

	public static final WxFocusReqHandler me = new WxFocusReqHandler();

	public WxFocusReqHandler() {
	}

	@Override
	public void handler(ImPacket packet, ChannelContext channelContext, boolean isWebsocket, User curr, SimpleUser currSimpleUser) throws Exception {
		WxChatApi.focusNtf(curr.getId(), null);
	}
}
