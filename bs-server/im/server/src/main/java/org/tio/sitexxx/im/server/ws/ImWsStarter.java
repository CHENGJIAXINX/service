/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server.ws;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.intf.TioUuid;
import org.tio.server.ServerTioConfig;
import org.tio.sitexxx.im.server.PacketDispatcher;
import org.tio.utils.Threads;
import org.tio.websocket.server.WsServerConfig;
import org.tio.websocket.server.WsServerStarter;

/**
 * @author tanyaowu
 * 2016年6月28日 下午5:34:04
 */
public class ImWsStarter {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(ImWsStarter.class);

	/**
	 * @param args
	 * @author tanyaowu
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//		ImWsStarter imWsStarter = new ImWsStarter(9321);
		//		imWsStarter.start();
	}

	private WsServerStarter wsServerStarter;
	private ServerTioConfig serverTioConfig;

	/**
	 *
	 * @author tanyaowu
	 */
	public ImWsStarter(int port, TioUuid tioUuid, PacketDispatcher packetDispatcher) throws IOException {
		WsServerConfig wsServerConfig = new WsServerConfig(port);
		wsServerStarter = new WsServerStarter(wsServerConfig, new ImWsMsgHandler(packetDispatcher), tioUuid, Threads.getTioExecutor(), Threads.getGroupExecutor());
		serverTioConfig = wsServerStarter.getServerTioConfig();

		ImWsGroupListener imWsGroupListener = ImWsGroupListener.me;
		serverTioConfig.setGroupListener(imWsGroupListener);
		serverTioConfig.setServerAioListener(ImWsServerAioListener.me);

	}

	public WsServerStarter getWsServerStarter() {
		return wsServerStarter;
	}

	public void start() throws IOException {
		wsServerStarter.start();
	}

	/**
	 * @return the serverTioConfig
	 */
	public ServerTioConfig getServerTioConfig() {
		return serverTioConfig;
	}

}
