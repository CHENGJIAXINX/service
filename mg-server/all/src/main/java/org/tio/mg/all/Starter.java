/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.mg.all;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.Tio;
import org.tio.flash.policy.server.FlashPolicyServerStarter;
import org.tio.mg.im.server.TioSiteImServerStarter;
import org.tio.mg.service.init.*;
import org.tio.mg.service.ip2region.Ip2RegionInit;
import org.tio.mg.service.model.conf.IpBlackList;
import org.tio.mg.service.service.base.SensitiveWordsService;
import org.tio.mg.service.service.conf.AreaService;
import org.tio.mg.service.service.conf.AvatarService;
import org.tio.mg.service.service.conf.IpBlackListService;
import org.tio.mg.service.utils.LogUtils;
import org.tio.mg.view.WebViewStarter;
import org.tio.mg.view.http.WebViewInit;
import org.tio.mg.web.server.init.WebApiInit;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.Threads;
import org.tio.utils.jfinal.P;
import org.tio.utils.quartz.QuartzUtils;

import java.sql.SQLException;
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
        LogUtils.logJvmStartTime("PropInit.init()");

        // redis初始化，里面会有topic等的初始化
        RedisInit.init(true);
        LogUtils.logJvmStartTime("RedisInit.init()");

        // ip2region初始化
        Ip2RegionInit.init();
        LogUtils.logJvmStartTime("Ip2RegionInit.init()");

        // Json配置初始化
        JsonInit.init();
        LogUtils.logJvmStartTime("JsonInit.init()");

        // jfinal 初始化
        JFInit.init();
        LogUtils.logJvmStartTime("JFInit.init()");

        // 敏感词初始化
        SensitiveWordsService.init();
        LogUtils.logJvmStartTime("SensitiveWordsService.init()");

        // 缓存初始化
        CacheInit.init(true);
        LogUtils.logJvmStartTime("CacheInit.init()");

        AreaService.init();
        LogUtils.logJvmStartTime("AreaService.init()");

    }

    /**
     * @param args
     * @author tanyaowu
     */
    public static void main(String[] args) {
        try {
            initBase();
            LogUtils.logJvmStartTime("initBase()");

            boolean startFlashPolicyServer = P.getInt("start.flash.policy.server", 1) == 1;

            org.tio.mg.web.server.init.TopicInit.init();
            LogUtils.logJvmStartTime("org.tio.mg.web.server.init.TopicInit.init()");

            // 加载头像数据
            AvatarService.loadData();
            LogUtils.logJvmStartTime("AvatarService.loadData()");

			if (Const.IS_START_IM) {
				//先启动聊天服务器，再启动zk
				TioSiteImServerStarter.initImServer();
				LogUtils.logJvmStartTime("TioSiteImServerStarter.imServerInit()");
			}

            if (startFlashPolicyServer) {
                FlashPolicyServerStarter.start(null, null, Threads.getTioExecutor(), Threads.getGroupExecutor());
                LogUtils.logJvmStartTime("FlashPolicyServerStarter.start(null, null, Threads.getTioExecutor(), Threads.getGroupExecutor())");
            }

            // 启动Api服务器
            WebApiInit.init();
            LogUtils.logJvmStartTime("WebApiInit.init()");

			if (Const.IS_START_IM) {
				org.tio.mg.im.server.init.TopicInit.init();
				LogUtils.logJvmStartTime("org.tio.mg.im.server.init.TopicInit.init()");
			}

            //启动View服务器
			if (Const.IS_START_VIEW) {
				org.tio.mg.view.init.TopicInit.init();
				LogUtils.logJvmStartTime("org.tio.mg.view.init.TopicInit.init()");
				WebViewStarter.initView(args);
				WebViewInit.httpServerStarter.getServerTioConfig().share(WebApiInit.httpServerStarter.getServerTioConfig());
				LogUtils.logJvmStartTime("WebViewStarter.initView(args)");
			}

            //启动定时任务
            QuartzUtils.start();
            LogUtils.logJvmStartTime("QuartzUtils.start()");

            // 初始化ip黑名单
            initIpBlackList();
            LogUtils.logJvmStartTime("initIpBlackList()");

        } catch (Throwable e) {
            log.error(e.toString(), e);
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
