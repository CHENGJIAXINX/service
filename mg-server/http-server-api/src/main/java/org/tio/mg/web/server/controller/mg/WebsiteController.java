package org.tio.mg.web.server.controller.mg;

import com.alibaba.fastjson.JSONObject;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.init.RedisInit;
import org.tio.mg.service.model.conf.Website;
import org.tio.mg.service.service.conf.MgWebsiteService;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.topic.TopicVo;
import org.tio.utils.resp.Resp;

/**
 * 自定义网站控制器
 */
@RequestPath(value = "/website")
public class WebsiteController {

    private Logger log = LoggerFactory.getLogger(WebsiteController.class);

    private MgWebsiteService mgWebsiteService = MgWebsiteService.me;

    /**
     * 添加自定义网站
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/add")
    public Resp add(HttpRequest request) {
        Website website = JSONObject.parseObject(request.getBodyString(), Website.class);
        if (website == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = mgWebsiteService.add(website);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        RedissonClient redisson = RedisInit.get();
        RTopic topic = redisson.getTopic(Const.Topic.COMMON_TOPIC);
        TopicVo topicVo = new TopicVo();
        topicVo.setType(TopicVo.Type.CLEAR_CONF);
        topic.publish(topicVo);

        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "自定义网站新增",
                        MgConst.OperLogTypes.add,
                        "新增自定义网站" + website.getSiteurl());
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 修改自定义网站
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/update")
    public Resp update(HttpRequest request) {
        Website website = JSONObject.parseObject(request.getBodyString(), Website.class);
        if (website == null || website.getId() < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = mgWebsiteService.update(website);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        RedissonClient redisson = RedisInit.get();
        RTopic topic = redisson.getTopic(Const.Topic.COMMON_TOPIC);
        TopicVo topicVo = new TopicVo();
        topicVo.setType(TopicVo.Type.CLEAR_CONF);
        topic.publish(topicVo);
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "自定义网站修改",
                        MgConst.OperLogTypes.update,
                        "修改自定义网站" + website.getSiteurl());
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 查询网站列表
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/list")
    public Resp list(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = mgWebsiteService.queryList(requestVo);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 删除自定义网站
     *
     * @param request
     * @param id
     * @return
     */
    @RequestPath(value = "/del")
    public Resp del(HttpRequest request, Integer id) {
        if (id == null || id < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret del = mgWebsiteService.del(id);
        RedissonClient redisson = RedisInit.get();
        RTopic topic = redisson.getTopic(Const.Topic.COMMON_TOPIC);
        TopicVo topicVo = new TopicVo();
        topicVo.setType(TopicVo.Type.CLEAR_CONF);
        topic.publish(topicVo);
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "自定义网站删除",
                        MgConst.OperLogTypes.del,
                        "删除自定义网站id:" + id);
            }
        }).start();
        return Resp.ok(RetUtils.getRetMsg(del));
    }
}
