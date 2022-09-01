/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.clu.client.CluClientStarter;
import org.tio.clu.client.handler.rpc.demo.RpcDemoImpl;
import org.tio.clu.common.bs.rpc.RpcApi;
import org.tio.core.Node;
import org.tio.core.OnOfflineListener;
import org.tio.flash.policy.server.FlashPolicyServerStarter;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.server.ServerTioConfig;
import org.tio.server.TioServer;
import org.tio.server.intf.ServerAioHandler;
import org.tio.server.intf.ServerAioListener;
import org.tio.sitexxx.im.common.ImPacket;
import org.tio.sitexxx.im.common.ImTioUuid;
import org.tio.sitexxx.im.server.clu.ImTransferListener;
import org.tio.sitexxx.im.server.handler.ImServerHandler;
import org.tio.sitexxx.im.server.handler.wx.OnOffLineApi;
import org.tio.sitexxx.im.server.handler.wx.call.WxCallUtils;
import org.tio.sitexxx.im.server.init.TopicInit;
import org.tio.sitexxx.im.server.ws.ImWsStarter;
import org.tio.sitexxx.service.init.CacheInit;
import org.tio.sitexxx.service.init.JFInit;
import org.tio.sitexxx.service.init.JsonInit;
import org.tio.sitexxx.service.init.PropInit;
import org.tio.sitexxx.service.init.RedisInit;
import org.tio.sitexxx.service.ip2region.Ip2RegionInit;
import org.tio.sitexxx.service.service.base.SensitiveWordsService;
import org.tio.sitexxx.service.tio.TioSiteIpStatListener;
import org.tio.sitexxx.servicecommon.utils.LogUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.Threads;
import org.tio.utils.jfinal.P;
import org.tio.utils.quartz.QuartzUtils;

/**
 * 
 * @author tanyaowu 
 * 2016年9月8日 上午11:39:30
 */
public class TioSiteImServerStarter {
	private static Logger log = LoggerFactory.getLogger(TioSiteImServerStarter.class);

	public static ImTioUuid imTioUuid;

	public static PacketDispatcher packetDispatcher = null;

	public static ServerAioHandler			tioSiteImServerAioHandler	= null;
	public static ServerAioListener			tioSiteImServerAioListener	= null;
	public static TioSiteImGroupListener	tioSiteImGroupListener		= null;

	//绑定服务ip，一般用null
	public static String bindIp = null;//"127.0.0.1";

	//app
	public static ServerTioConfig	serverTioConfigApp	= null;
	public static TioServer			tioServerApp		= null;

	//WS
	public static ServerTioConfig	serverTioConfigWs	= null;
	public static ImWsStarter		imWsStarter			= null;

	//集群
	public static CluClientStarter cluClientStarter = null;

	/**
	 * @param args
	 *
	 * @author tanyaowu
	 * @throws IOException
	 * 2016年11月17日 下午5:59:24
	 *
	 */
	public static void main(String[] args) throws Exception {
		try {
			// 属性初始化
			PropInit.init();

			// ip2region初始化
			Ip2RegionInit.init();

			// 敏感词初始化
			SensitiveWordsService.init();

			// Json配置初始化
			JsonInit.init();

			// jfinal 初始化
			JFInit.init();

			// 缓存初始化
			CacheInit.init(true);

			// redis初始化，里面会有topic等的初始化
			RedisInit.init(true);

			TopicInit.init();

			// 阿里直播初始化
			// AliLiveUtils.init();

			//先启动聊天服务器，再启动zk
			initImServer();

			FlashPolicyServerStarter.start(null, null, Threads.getTioExecutor(), Threads.getGroupExecutor());

			//启动定时任务，配置文件在：config/tio-quartz.properties
			QuartzUtils.start();

		} catch (Throwable e) {
			log.error("", e);
			System.exit(1);
		}

	}

	public static void initImServer() throws Exception {
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				// 启动时更新chatroom_join_leave表的数据
				String sql1 = "update chatroom_join_leave set leavetime=DATE_ADD(jointime, INTERVAL 5 second), cost=5000, status = 2 where status = 9 and server = ?";
				String sql2 = "update chatroom_join_leave set status = 2 where status = 3 and server = ?";
				Db.use(Const.Db.TIO_SITE_MAIN).update(sql1, Const.MY_IP_API);
				Db.use(Const.Db.TIO_SITE_MAIN).update(sql2, Const.MY_IP_API);

				WxCallUtils.endAllCall();
			}
		});

		packetDispatcher = new PacketDispatcher(new String[] { ImServerHandler.class.getPackage().getName() });

		tioSiteImServerAioHandler = new TioSiteImServerAioHandler(packetDispatcher);
		tioSiteImServerAioListener = TioSiteImServerAioListener.me;
		tioSiteImGroupListener = TioSiteImGroupListener.me;
		serverTioConfigApp = new ServerTioConfig("Tio Site App Im Server", tioSiteImServerAioHandler, tioSiteImServerAioListener, Threads.getTioExecutor(),
		        Threads.getGroupExecutor());
		serverTioConfigApp.setOnOfflineListener(new OnOffLineApi());
		serverTioConfigApp.setHeartbeatTimeout(Const.IM_HEARTBEAT_TIMEOUT);
		serverTioConfigApp.setReadBufferSize(P.getInt("im.socket.readbuffersize", 1024));
		serverTioConfigApp.logWhenDecodeError = P.getBoolean("im.logWhenDecodeError", false);

		serverTioConfigApp.groups.setChannelContextComparator(ChannelContextComparator.me);
		long workerId = P.getLong("uuid.workerid");
		long datacenterId = P.getLong("uuid.datacenter");
		imTioUuid = new ImTioUuid(workerId, datacenterId);
		LogUtils.logJvmStartTime(TioSiteImServerStarter.class.getName() + "：imTioUuid = new ImTioUuid(workerId, datacenterId)");

		serverTioConfigApp.setTioUuid(imTioUuid);
		serverTioConfigApp.setGroupListener(tioSiteImGroupListener);
		serverTioConfigApp.setIpStatListener(TioSiteIpStatListener.app);
		serverTioConfigApp.ipStats.addDurations(Const.IpStatDuration.IPSTAT_DURATIONS);
		useSsl("app", serverTioConfigApp);
		tioServerApp = new TioServer(serverTioConfigApp);
		tioServerApp.setCheckLastVersion(P.getBoolean("tio.setCheckLastVersion", false));

		if (Const.USE_TIO_CLU) {
			Node cluServerNode = new Node(P.get("tio.clu.server.ip"), P.getInt("tio.clu.server.port"));
			cluClientStarter = new CluClientStarter(false, serverTioConfigApp, cluServerNode, ImPacket.class);

			//org.tio.sitexxx.servicecommon.vo.Const.Protocol
			Map<String, Node> clientAccessNodeMap = new HashMap<>(2);
			Node node_app = new Node(Const.MY_IP_APP, Const.ImPort.APP, Const.IM_SSL_FLAG);
			Node node_ws = new Node(Const.MY_IP_WEB, Const.ImPort.WS, Const.IM_SSL_FLAG);
			clientAccessNodeMap.put(Const.Protocol.IM_APP, node_app);
			clientAccessNodeMap.put(Const.Protocol.IM_WS, node_ws);
			serverTioConfigApp.setClientAccessNodeMap(clientAccessNodeMap);

			//			initRpc(cluClientStarter);

			cluClientStarter.start(); //start()只需要调一次，并且是在不用进行packet转换的那个调
			serverTioConfigApp.setCluClientChannelContexts(cluClientStarter.getClientChannelContexts());
			serverTioConfigApp.setCluClientTioConfig(cluClientStarter.getClientTioConfig());
			serverTioConfigApp.setTransferListener(ImTransferListener.me);
		}
		LogUtils.logJvmStartTime(TioSiteImServerStarter.class.getName() + "：cluClientStarter.getClientTioConfig()");
		tioServerApp.start(bindIp, Const.ImPort.APP);
		LogUtils.logJvmStartTime(TioSiteImServerStarter.class.getName() + "：tioServerApp.start(bindIp, Const.ImPort.APP)");

		//启动websocket服务器
		imWsStarter = new ImWsStarter(Const.ImPort.WS, imTioUuid, packetDispatcher);
		imWsStarter.getWsServerStarter().getTioServer().setCheckLastVersion(P.getBoolean("tio.setCheckLastVersion", false));
		serverTioConfigWs = imWsStarter.getServerTioConfig();
		serverTioConfigWs.setOnOfflineListener(new OnOffLineApi());
		serverTioConfigWs.setHeartbeatTimeout(Const.IM_HEARTBEAT_TIMEOUT);
		serverTioConfigWs.setReadBufferSize(P.getInt("im.ws.readbuffersize", 1024));
		serverTioConfigWs.logWhenDecodeError = P.getBoolean("im.ws.logWhenDecodeError", false);
		serverTioConfigWs.groups.setChannelContextComparator(ChannelContextComparator.me);
		serverTioConfigWs.setName("Tio Site WS Im Server");

		serverTioConfigWs.setIpStatListener(TioSiteIpStatListener.ws);
		serverTioConfigWs.ipStats.addDurations(Const.IpStatDuration.IPSTAT_DURATIONS);
		useSsl("web", serverTioConfigWs);
		serverTioConfigWs.share(serverTioConfigApp);
		serverTioConfigWs.packetConverter = ImToWsPacketConverter.me;

		if (Const.USE_TIO_CLU) {
			// ws只需要设置两个属性，
			serverTioConfigWs.setCluClientChannelContexts(cluClientStarter.getClientChannelContexts());
			serverTioConfigWs.setCluClientTioConfig(cluClientStarter.getClientTioConfig());
			serverTioConfigWs.setTransferListener(ImTransferListener.me);

			//		serverTioConfigWs.setClientAccessNode(new Node(Const.MY_IP, Const.ImPort.WS, Const.IM_SSL_FLAG));
		}

		imWsStarter.start();
		LogUtils.logJvmStartTime(TioSiteImServerStarter.class.getName() + "：imWsStarter.start()");

		if (Boolean.getBoolean("tio.clu.client.starttest")) {
			//启动测试程序，生产环境要去掉
			cluClientStarter.startTest();
		}
	}

	@SuppressWarnings("unused")
	private static void initRpc(CluClientStarter cluClientStarter) {
		// 注册RPC服务
		RpcApi.scan(new String[] { RpcDemoImpl.class.getPackage().getName() }, cluClientStarter.getClientTioConfig());
	}

	private static void useSsl(String flag, ServerTioConfig serverTioConfig) throws Exception {
		String keyStoreFile = P.get("ssl.keystore."+flag, null);
//		String trustStoreFile = P.get("ssl.truststore", null);
		String keyStorePwd = P.get("ssl.pwd."+flag, null);
		serverTioConfig.useSsl(keyStoreFile, keyStoreFile, keyStorePwd);
	}

	public TioSiteImServerStarter() {

	}
}
