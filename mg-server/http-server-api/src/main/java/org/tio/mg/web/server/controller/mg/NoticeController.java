package org.tio.mg.web.server.controller.mg;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.model.conf.Announcement;
import org.tio.mg.service.model.mg.MgUser;
import org.tio.mg.service.service.conf.NoticeService;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.mg.web.server.utils.HttpRequestUtils;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.mg.web.server.utils.WebUtils;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.resp.Resp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :linjian
 * @description : 通知公告管理控制器
 * @createTime :2021/9/26
 * @updateTIme :
 */
@RequestPath(value = "/notice")
public class NoticeController {

    private NoticeService noticeService = NoticeService.me;

    /**
     * 获取通知公告列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/list")
    public Resp getList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = noticeService.list(requestVo);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 添加通知公告
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/add")
    public Resp addNotice(HttpRequest request) throws Exception {
        Announcement announcement = JSONObject.parseObject(request.getBodyString(), Announcement.class);
        if (announcement == null || StrUtil.isEmpty(announcement.getContent())) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        // 添加uid
        MgUser user = WebUtils.currUser(request);
        if (user == null) {
            return Resp.fail(RetUtils.OPER_ERROR);
        }
        announcement.setAuthor(user.getLoginname());
        announcement.setOperatorId(user.getId());
        Ret ret = noticeService.add(announcement);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "后台用户新增",
                        MgConst.OperLogTypes.add,
                        "后台用户新增通知公告");
            }
        }).start();
        return Resp.ok(RetUtils.OPER_RIGHT);
    }

    /**
     * 修改通知公告
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/update")
    public Resp updateNotice(HttpRequest request) throws Exception {
        Announcement announcement = JSONObject.parseObject(request.getBodyString(), Announcement.class);
        if (announcement == null || announcement.getId() == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        // 添加uid
        MgUser user = WebUtils.currUser(request);
        if (user == null) {
            return Resp.fail(RetUtils.OPER_ERROR);
        }
        announcement.setOperatorId(user.getId());
        Ret ret = noticeService.update(announcement);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "后台用户修改",
                        MgConst.OperLogTypes.update,
                        "后台用户修改通知公告id：" + announcement.getId());
            }
        }).start();
        return Resp.ok(RetUtils.OPER_RIGHT);
    }

    /**
     * 删除通知公告
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/del")
    public Resp delNotice(HttpRequest request, Integer id) throws Exception {
        if (id == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = noticeService.del(id);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "后台用户删除",
                        MgConst.OperLogTypes.del,
                        "后台用户删除通知公告id：" + id);
            }
        }).start();
        return Resp.ok(RetUtils.OPER_RIGHT);
    }

    /**
     * 发布通知公告
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/publish")
    public Resp publishNotice(HttpRequest request, Integer id) throws Exception {
        if (id == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        // 开启事务修改
        Ret ret = noticeService.updateStatus(id);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        // 调用 bs 发布接口
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("noticeId", id);
        String url = "http://127.0.0.1:6060/mytio/chat/pushAllNotice.tio_x?" + HttpRequestUtils.getInstance().getUrlParams(paramsMap);
        String resultJson = HttpUtil.post(url, paramsMap);
        System.out.println("返回结果：" + resultJson);
        if (StrUtil.isEmpty(resultJson)) {
            return Resp.fail(RetUtils.OPER_ERROR);
        }
        Resp resp = JSONObject.parseObject(resultJson, Resp.class);
        if (resp.isOk()) {
            return Resp.ok(RetUtils.OPER_RIGHT);
        }
        return resp;
    }

    /**
     * 停用通知公告
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/stop")
    public Resp stopNotice(HttpRequest request, Integer id) throws Exception {
        if (id == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = noticeService.stop(id);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.OPER_RIGHT);
    }
}
