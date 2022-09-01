/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.sitexxx.im.common.ImPacket;
import org.tio.sitexxx.im.common.ImSessionContext;
import org.tio.sitexxx.im.common.WsResponseExt;
import org.tio.sitexxx.im.common.utils.ImUtils;
import org.tio.sitexxx.im.server.TioSiteImServerAioListener;
import org.tio.websocket.common.Opcode;
import org.tio.websocket.common.WsRequest;
import org.tio.websocket.common.WsSessionContext;
import org.tio.websocket.server.WsServerAioListener;

/**
 * @author tanyaowu 
 * 2016年9月8日 上午10:51:37
 */
public class ImWsServerAioListener extends WsServerAioListener {
	private static Logger log = LoggerFactory.getLogger(ImWsServerAioListener.class);

	/**
	 * @param args
	 * @author: tanyaowu
	 */
	public static void main(String[] args) {

	}

	public static final ImWsServerAioListener me = new ImWsServerAioListener();

	private ImWsServerAioListener() {
		super();
	}

	@Override
	public void onAfterConnected(ChannelContext channelContext, boolean isConnected, boolean isReconnect) throws Exception {
		super.onAfterConnected(channelContext, isConnected, isReconnect);
		WsSessionContext wsSessionContext = (WsSessionContext) channelContext.get();

		TioSiteImServerAioListener.me.onAfterConnected(channelContext, isConnected, isReconnect);

		ImSessionContext imSessionContext = ImUtils.getImSessionContext(channelContext);
		imSessionContext.setWebsocket(true);
		imSessionContext.setWsSessionContext(wsSessionContext);
	}

	@Override
	public void onAfterDecoded(ChannelContext channelContext, Packet packet, int packetSize) throws Exception {
		super.onAfterDecoded(channelContext, packet, packetSize);
		WsRequest wsRequest = (WsRequest) packet;
		Opcode opcode = wsRequest.getWsOpcode();
		if (opcode == Opcode.PONG) {
			return;
		}

		ImPacket imPacket = ImWsMsgHandler.toImPacket(wsRequest, channelContext);
		if (imPacket != null) {
			TioSiteImServerAioListener.me.onAfterDecoded(channelContext, imPacket, packetSize);
		}
	}

	@Override
	public void onAfterSent(ChannelContext channelContext, Packet packet, boolean isSentSuccess) throws Exception {
		super.onAfterSent(channelContext, packet, isSentSuccess);
		if (packet instanceof WsResponseExt) {
			WsResponseExt wsResponse = (WsResponseExt) packet;
			ImPacket imPacket = wsResponse.getInitPacket();
			TioSiteImServerAioListener.me.onAfterSent(channelContext, imPacket, isSentSuccess);
		} else {
			log.debug("握手包");
		}
	}

	@Override
	public void onBeforeClose(ChannelContext channelContext, Throwable throwable, String remark, boolean isRemove) throws Exception {
		super.onBeforeClose(channelContext, throwable, remark, isRemove);
		TioSiteImServerAioListener.me.onBeforeClose(channelContext, throwable, remark, isRemove);
	}
}
