/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.base;

import java.util.HashMap;
import java.util.Map;

import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.sitexxx.service.init.PropInit;
import org.tio.sitexxx.service.init.RedisInit;
import org.tio.sitexxx.service.model.conf.YxConf;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.service.conf.MgWebsiteService;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.topic.TopicVo;
import org.tio.utils.jfinal.P;
import org.tio.utils.resp.Resp;

/**
 * @author tanyaowu
 * 2016年6月29日 下午7:53:59
 */
@RequestPath(value = "/config")
public class ConfigController {
    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(ConfigController.class);
    public static Map<String, Object> CONFIG_MAP = new HashMap<>();
    public static Map<String, Object> VIEW_MODEL = new HashMap<>();

    static {
        String title = ConfService.getString("seo.title", "t-io - 解决其它网络框架没有解决的痛点");
        String keywords = ConfService.getString("seo.keywords", "t-io,tio,开源,netty,mina,rpc,jfinal,layui,hutool,osc,io,socket,tcp,nio,aio,nio2,im,游戏,java,长连接");
        String description = ConfService.getString("seo.description",
                "t-io - 解决其它网络框架没有解决的痛点");
        String jsVersion = ConfService.getString("js_version", "1");

        CONFIG_MAP.put(Const.ModelKey.RES_SERVER, Const.RES_SERVER); //用户上传数据服务器
        CONFIG_MAP.put(Const.ModelKey.HTTP_SESSION_COOKIE_NAME, Const.Http.SESSION_COOKIE_NAME);
        CONFIG_MAP.put(Const.ModelKey.API_CONTEXTPATH, org.tio.sitexxx.servicecommon.vo.Const.API_CONTEXTPATH);
        CONFIG_MAP.put(Const.ModelKey.API_SUFFIX, org.tio.sitexxx.servicecommon.vo.Const.API_SUFFIX);
        CONFIG_MAP.put(Const.ModelKey.JS_VERSION, jsVersion); //js版本号
        CONFIG_MAP.put(Const.ModelKey.SITE_NAME, ConfService.getString("sitename", "t-io社交IM平台"));
        CONFIG_MAP.put("im_heartbeat_timeout", Const.IM_HEARTBEAT_TIMEOUT);
        CONFIG_MAP.put("check_code", ConfService.getString("phone.register.code.check", "0"));
//		CONFIG_MAP.put("website", MgWebsiteService.me.list());

        String tioim_title = ConfService.getString("tioim.title", "谭聊，让所有公司用得上靠谱的IM");
        String tioim_keywords = ConfService.getString("tioim.keywords", "IM,t-io,高并发,集群,私有部署");
        String tioim_description = ConfService.getString("tioim.description", "谭聊是基于t-io研发的类似微信的完整IM，支持集群、语音通话、视频通话、私聊、群聊");
        VIEW_MODEL.put("tioim_title", tioim_title);
        VIEW_MODEL.put("tioim_keywords", tioim_keywords);
        VIEW_MODEL.put("tioim_description", tioim_description);

        VIEW_MODEL.put(Const.ModelKey.TITLE, title);
        VIEW_MODEL.put(Const.ModelKey.KEYWORDS, keywords);
        VIEW_MODEL.put(Const.ModelKey.DESCRIPTION, description);
        VIEW_MODEL.put("check_code", ConfService.getString("phone.register.code.check", "0"));

        VIEW_MODEL.putAll(CONFIG_MAP);
    }

    /**
     * @param args
     * @author tanyaowu
     */
    public static void main(String[] args) {

    }

    /**
     * @author tanyaowu
     */
    public ConfigController() {
    }

    /**
     * 更新app-xxx.properties文件
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/update")
    public Resp update(HttpRequest request) throws Exception {
        P.clear();
        PropInit.forceInit();
        return Resp.ok();
    }

    /**
     * 清空conf缓存
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/clearConf")
    public Resp clearConf(HttpRequest request) throws Exception {
        ConfService.clearCache();

        RedissonClient redisson = RedisInit.get();
        RTopic topic1 = redisson.getTopic(Const.Topic.COMMON_TOPIC);
        TopicVo topicVo = new TopicVo();
        topicVo.setType(TopicVo.Type.CLEAR_CONF);
        topic1.publish(topicVo);

        return Resp.ok();
    }

    /**
     * 清空所有配置项：包括conf、conf_dev表、app.properties、app-env.properties、app-host.properties
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/clearAll")
    public Resp clearAll(HttpRequest request) throws Exception {
        clearConf(request);
        update(request);
        return Resp.ok();
    }

    /**
     * 获取view model数据，主要用于vue
     *
     * @param request
     * @return
     * @throws Exception
     * @author tanyaowu
     */
    @RequestPath(value = "/viewmodel")
    public Resp viewmodel(HttpRequest request) throws Exception {
        return Resp.ok(VIEW_MODEL);
    }

    /**
     * 获取基础配置信息
     *
     * @param request
     * @return
     * @author tanyaowu
     */
    @RequestPath(value = "/base")
    public Resp config(HttpRequest request){
        CONFIG_MAP.put("website", MgWebsiteService.me.list());
        CONFIG_MAP.put("conf", ConfService.getClientCacheData());
        return Resp.ok(CONFIG_MAP);
    }

    /**
     * 根据配置名称获取配置
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/query")
    public Resp query(HttpRequest request, String configName) {
        YxConf yxConf = ConfService.getYxConfigByName(configName);
        if (yxConf != null) {
            return Resp.ok(yxConf);
        }
        return Resp.fail();
    }
}
