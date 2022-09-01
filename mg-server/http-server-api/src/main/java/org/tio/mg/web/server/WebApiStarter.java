package org.tio.mg.web.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.mg.service.init.*;
import org.tio.mg.service.ip2region.Ip2RegionInit;
import org.tio.mg.service.service.base.SensitiveWordsService;
import org.tio.mg.web.server.init.TopicInit;
import org.tio.mg.web.server.init.WebApiInit;
import org.tio.utils.quartz.QuartzUtils;

import java.io.IOException;

/**
 * @author tanyaowu
 * 2016年8月7日 上午10:58:03
 */
public class WebApiStarter {

    private static Logger log = LoggerFactory.getLogger(WebApiStarter.class);

    public WebApiStarter() {
    }

    public static void main(String[] args) throws Exception {
        try {
            //
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

            // 接口初始化
            WebApiInit.init();

            //启动定时任务
            QuartzUtils.start();

        } catch (Throwable e) {
            log.error(e.toString(), e);
            System.exit(1);
        }
    }

}
