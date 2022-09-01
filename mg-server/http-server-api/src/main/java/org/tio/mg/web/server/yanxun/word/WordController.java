package org.tio.mg.web.server.yanxun.word;

import com.alibaba.fastjson.JSONObject;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.init.RedisInit;
import org.tio.mg.service.model.conf.SensitiveWordsList;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.service.yxnxun.word.WordService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.mg.web.server.utils.WebUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.topic.TopicVo;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.resp.Resp;

/**
 * 敏感词管理控制器
 */
@RequestPath(value = "/word")
public class WordController {

    private Logger log = LoggerFactory.getLogger(WordController.class);

    private WordService service = WordService.ME;

    /**
     * 添加敏感词
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/add")
    public Resp add(HttpRequest request) throws Exception {
        SensitiveWordsList sensitiveWordsList = JSONObject.parseObject(request.getBodyString(), SensitiveWordsList.class);
        if (sensitiveWordsList == null || StrUtil.isBlank(sensitiveWordsList.getWord())) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Integer mgUid = WebUtils.currUserId(request);
        sensitiveWordsList.setMguid(mgUid);
        Ret ret = service.add(sensitiveWordsList);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        RedissonClient redisson = RedisInit.get();
        RTopic topic = redisson.getTopic(Const.Topic.COMMON_TOPIC);
        TopicVo topicVo = new TopicVo();
        topicVo.setType(TopicVo.Type.CLEAR_WORD);
        topic.publish(topicVo);
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "添加敏感词",
                        MgConst.OperLogTypes.add,
                        "添加敏感词：" + sensitiveWordsList.getWord());
            }
        }).start();
        return Resp.ok("敏感词添加成功");
    }

    /**
     * 删除敏感词
     *
     * @param request
     * @param id
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/del")
    public Resp del(HttpRequest request, Integer id) throws Exception {
        if (id == null || id < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = service.del(id);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.OPER_ERROR);
        }
        RedissonClient redisson = RedisInit.get();
        RTopic topic = redisson.getTopic(Const.Topic.COMMON_TOPIC);
        TopicVo topicVo = new TopicVo();
        topicVo.setType(TopicVo.Type.CLEAR_WORD);
        topic.publish(topicVo);
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "删除敏感词",
                        MgConst.OperLogTypes.del,
                        "删除敏感词id：" + id);
            }
        }).start();
        return Resp.ok("删除成功");
    }

    /**
     * 修改敏感词
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/update")
    public Resp update(HttpRequest request) throws Exception {
        SensitiveWordsList sensitiveWordsList = JSONObject.parseObject(request.getBodyString(), SensitiveWordsList.class);
        if (sensitiveWordsList == null || sensitiveWordsList.getId() == null || sensitiveWordsList.getId() < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Integer mgUid = WebUtils.currUserId(request);
        sensitiveWordsList.setMguid(mgUid);
        Ret ret = service.update(sensitiveWordsList);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.OPER_ERROR);
        }
        RedissonClient redisson = RedisInit.get();
        RTopic topic = redisson.getTopic(Const.Topic.COMMON_TOPIC);
        TopicVo topicVo = new TopicVo();
        topicVo.setType(TopicVo.Type.CLEAR_WORD);
        topic.publish(topicVo);
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "修改敏感词",
                        MgConst.OperLogTypes.update,
                        "敏感词：" + sensitiveWordsList.getWord());
            }
        }).start();
        return Resp.ok("修改成功");
    }

    /**
     * 查询敏感词列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath("/query")
    public Resp query(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = service.query(requestVo);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }
}
