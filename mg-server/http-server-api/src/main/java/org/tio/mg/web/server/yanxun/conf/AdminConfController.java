package org.tio.mg.web.server.yanxun.conf;

import com.alibaba.fastjson.JSONObject;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.init.RedisInit;
import org.tio.mg.service.model.conf.YxConf;
import org.tio.mg.service.service.conf.MgConfService;
import org.tio.mg.service.service.yxnxun.conf.AdminConfService;
import org.tio.mg.service.service.yxnxun.conf.UserMemberService;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.*;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.topic.TopicVo;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.resp.Resp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 后台配置控制器
 */
@RequestPath(value = "/conf")
public class AdminConfController {

    private Logger log = LoggerFactory.getLogger(AdminConfController.class);

    private AdminConfService service = AdminConfService.ME;

    /**
     * 添加新参数并发送通知
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/add")
    public Resp add(HttpRequest request) throws Exception {
        YxConf yxConf = JSONObject.parseObject(request.getBodyString(), YxConf.class);
        if (yxConf == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = checkConf(yxConf);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        if (!service.add(yxConf)) {
            return Resp.fail(RetUtils.OPER_ERROR);
        }
        clearConfigCache();
        return Resp.ok(RetUtils.OPER_RIGHT);
    }

    /**
     * 通知bs清除配置缓存
     */
    public void clearConfigCache() {
        RedissonClient redissonClient = RedisInit.get();
        RTopic topic = redissonClient.getTopic(Const.Topic.COMMON_TOPIC);
        TopicVo topicVo = new TopicVo();
        topicVo.setType(TopicVo.Type.CLEAR_CONF);
        topic.publish(topicVo);
    }

    /**
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/del")
    public Resp del(HttpRequest request, Integer id) throws Exception {
        if (id == null || id < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        if (!service.del(id)) {
            return Resp.fail(RetUtils.OPER_ERROR);
        }
        clearConfigCache();
        return Resp.ok(RetUtils.OPER_RIGHT);
    }


    @RequestPath("/update")
    public Resp update(HttpRequest request) {
        YxConf yxConf = JSONObject.parseObject(request.getBodyString(), YxConf.class);
        if (yxConf == null || yxConf.getId() < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        yxConf.setUpdatetime(new Date());
        boolean update = yxConf.update();
        if (update) {
            // 如果 conftype = 5 ,则是会员配置，会员配置需要更新表内容
            if (yxConf.getConftype() == 5) {
                List<YxConf> yxConfs = new ArrayList<>();
                yxConfs.add(yxConf);
                UserMemberService.ME.update(yxConfs);
            }
            clearConfigCache();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "修改单个参数",
                            MgConst.OperLogTypes.update,
                            "修改单个参数" + yxConf.getName());
                    MgConfService.clearCache();
                }
            }).start();
            return Resp.ok();
        }
        return Resp.fail("修改失败");
    }

    /**
     * @param request
     * @param
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/updateAll")
    public Resp updateAll(HttpRequest request) throws Exception {
        ConfigAllSaveVo configAllSaveVo = JSONObject.parseObject(request.getBodyString(), ConfigAllSaveVo.class);
        if (configAllSaveVo == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        List<YxConf> yxConfs = configAllSaveVo.getConfs();
        Ret ret = service.updateAll(yxConfs);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        // 如果 conftype = 5 ,则是会员配置，会员配置需要更新表内容
        if (null != configAllSaveVo.getConfType() && configAllSaveVo.getConfType() == 5) {
            UserMemberService.ME.update(yxConfs);
        }
        clearConfigCache();
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgConfService.clearCache();
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "修改参数配置",
                        MgConst.OperLogTypes.update,
                        "修改参数配置");
                System.out.println("通知清除系统参数ALL");
            }
        }).start();
        return Resp.ok("修改成功");
    }

    /**
     * 获取配置列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath("/queryList")
    public Resp queryList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        if (requestVo == null || requestVo.getType() == null || requestVo.getType() < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        List<YxConf> confs = service.queryByType(requestVo);
        return Resp.ok(confs);
    }

    /**
     * 通过配置名称获取配置
     *
     * @param request
     * @param configName
     * @return
     */
    @RequestPath(value = "/getByName")
    public Resp getByName(HttpRequest request, String configName) {
        if (StrUtil.isEmpty(configName)) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        YxConf string = service.findByName(configName);
        if (string == null) {
            return Resp.fail("参数不存在");
        }
        return Resp.ok(string);
    }

    /**
     * 校验配置
     *
     * @param conf
     * @return
     */
    private Ret checkConf(YxConf conf) {
        if (StrUtil.isBlank(conf.getName())) {
            return RetUtils.failMsg("参数名不可为空");
        }
        if (StrUtil.isBlank(conf.getValue())) {
            return RetUtils.failMsg("参数值不可为空");
        }
        if (StrUtil.isBlank(conf.getTitle())) {
            return RetUtils.failMsg("请填写参数说明");
        }
        if (conf.getConftype() == null) {
            return RetUtils.failMsg("请选择配置类型");
        }
        if (conf.getType() == null) {
            return RetUtils.failMsg("请选择参数展示类型");
        }
        YxConf confByName = service.findByName(conf.getName());
        if (confByName != null) {
            return RetUtils.failMsg("参数名已存在");
        }
        return RetUtils.okOper();
    }

}
