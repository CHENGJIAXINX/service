/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.all;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.Tio;
import org.tio.flash.policy.server.FlashPolicyServerStarter;
import org.tio.sitexxx.im.server.TioSiteImServerStarter;
import org.tio.sitexxx.im.server.handler.wx.WxChatQueueApi;
import org.tio.sitexxx.service.cache.CacheConfig;
import org.tio.sitexxx.service.cache.Caches;
import org.tio.sitexxx.service.init.*;
import org.tio.sitexxx.service.ip2region.Ip2RegionInit;
import org.tio.sitexxx.service.model.conf.IpBlackList;
import org.tio.sitexxx.service.pay.service.WalletQueueApi;
import org.tio.sitexxx.service.service.base.SensitiveWordsService;
import org.tio.sitexxx.service.service.conf.AreaService;
import org.tio.sitexxx.service.service.conf.AvatarService;
import org.tio.sitexxx.service.service.conf.IpBlackListService;
import org.tio.sitexxx.service.service.yanxun.utils.DateUtil;
import org.tio.sitexxx.servicecommon.utils.LogUtils;
import org.tio.sitexxx.view.WebViewStarter;
import org.tio.sitexxx.view.http.WebViewInit;
import org.tio.sitexxx.web.server.init.WebApiInit;
import org.tio.utils.Threads;
import org.tio.utils.jfinal.P;
import org.tio.utils.quartz.QuartzUtils;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author tanyaowu
 *
 */
public class Starter {
	private static Logger log = LoggerFactory.getLogger(Starter.class);

	/**
	 * 
	 */
	public Starter() {
	}

	/**
	 * 基本的初始化，一般用于单元小测试
	 * @throws SQLException 
	 */
	public static void initBase() throws SQLException {
		PropInit.init();
		LogUtils.logJvmStartTime(PropInit.class.getName() + ".init()");

		// redis初始化，里面会有topic等的初始化
		RedisInit.init(true);
		LogUtils.logJvmStartTime(RedisInit.class.getName() + ".init()");

		// ip2region初始化
		Ip2RegionInit.init();
		LogUtils.logJvmStartTime(Ip2RegionInit.class.getName() + ".init()");

		// Json配置初始化
		JsonInit.init();
		LogUtils.logJvmStartTime(JsonInit.class.getName() + ".init()");

		// jfinal 初始化
		JFInit.init();
		LogUtils.logJvmStartTime(JFInit.class.getName() + ".init()");

		// 敏感词初始化
		SensitiveWordsService.init();
		LogUtils.logJvmStartTime(SensitiveWordsService.class.getName() + ".init()");

		// 缓存初始化
		CacheInit.init(true);
		LogUtils.logJvmStartTime(CacheInit.class.getName() + ".init()");

		AreaService.init();
		LogUtils.logJvmStartTime(AreaService.class.getName() + ".init()");
	}

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {
		try {
			initBase();
			LogUtils.logJvmStartTime(org.tio.sitexxx.all.Starter.class.getName() + ".initBase()");

			boolean startFlashPolicyServer = P.getInt("start.flash.policy.server", 1) == 1;

			org.tio.sitexxx.web.server.init.TopicInit.init();
			LogUtils.logJvmStartTime(org.tio.sitexxx.web.server.init.TopicInit.class.getName() + ".init()");

			// 阿里直播初始化
			//			AliLiveUtils.init();

			// 加载头像数据
			AvatarService.loadData();
			LogUtils.logJvmStartTime(AvatarService.class.getName() + ".loadData()");

			if (org.tio.sitexxx.servicecommon.vo.Const.IS_START_IM) {
				//先启动聊天服务器，再启动zk
				TioSiteImServerStarter.initImServer();
				LogUtils.logJvmStartTime(TioSiteImServerStarter.class.getName() + ".initImServer()");
				//队列初始化
				WxChatQueueApi.wxQueueInit();
				LogUtils.logJvmStartTime(WxChatQueueApi.class.getName() + ".wxQueueInit()");
			}

			if (startFlashPolicyServer) {
				FlashPolicyServerStarter.start(null, null, Threads.getTioExecutor(), Threads.getGroupExecutor());
				LogUtils.logJvmStartTime(FlashPolicyServerStarter.class.getName() + ".start()");
			}

			// 启动Api服务器
			WebApiInit.init();
			LogUtils.logJvmStartTime(WebApiInit.class.getName() + ".init()");

			if (org.tio.sitexxx.servicecommon.vo.Const.IS_START_IM) {
				org.tio.sitexxx.im.server.init.TopicInit.init();
				LogUtils.logJvmStartTime(org.tio.sitexxx.im.server.init.TopicInit.class.getName() + ".init()");
			}

			//启动View服务器
			if (org.tio.sitexxx.servicecommon.vo.Const.IS_START_VIEW) {
				org.tio.sitexxx.view.init.TopicInit.init();
				LogUtils.logJvmStartTime(org.tio.sitexxx.view.init.TopicInit.class.getName() + ".init()");
				WebViewStarter.initView(args);
				WebViewInit.httpServerStarter.getServerTioConfig().share(WebApiInit.httpServerStarter.getServerTioConfig());
				LogUtils.logJvmStartTime(WebViewStarter.class.getName() + ".initView()");
			}
			
			//钱包功能
			if (org.tio.sitexxx.servicecommon.vo.Const.IS_OPEN_WALLET) {
				WalletQueueApi.init();
			}

			//启动定时任务
			QuartzUtils.start();
			LogUtils.logJvmStartTime(QuartzUtils.class.getName() + ".start()");

			// 初始化ip黑名单
			initIpBlackList();
			LogUtils.logJvmStartTime(org.tio.sitexxx.all.Starter.class.getName() + ".initIpBlackList()");

			//redis缓存测试
			try {
				String lastStartTime = Caches.getCache(CacheConfig.USER_ONLINE_TIME).get("start_time", String.class);
				if (lastStartTime == null){
					System.out.println("上次无缓存");
				}else {
					System.out.println("上次缓存时间是："+lastStartTime);
				}
			}catch (Exception e){
				e.printStackTrace();
			}
			String st = DateUtil.format(new Date());
			Caches.getCache(CacheConfig.USER_ONLINE_TIME).put("start_time", st);
			System.out.println("存储时间为："+st);
		} catch (Throwable e) {
			log.error("", e);
			System.exit(1);
		}

	}

	/**
	 * 初始化ip黑名单
	 * 
	 * @author tanyaowu
	 */
	private static void initIpBlackList() {
		Map<String, IpBlackList> map = IpBlackListService.me.getAll();
		if (map != null) {
			map.forEach(new BiConsumer<String, IpBlackList>() {

				@Override
				public void accept(String ip, IpBlackList ipBlackList) {
					Tio.IpBlacklist.add(ip);
				}
			});
		}
	}

}
