package org.tio.mg.web.server.controller.mg;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.model.mg.MgUser;
import org.tio.mg.service.service.mg.MgUserService;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.mg.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

/**
 * 后台用户管理控制器
 */
@RequestPath(value = "/adminUser")
public class MgUserController {

    private MgUserService userService = MgUserService.ME;

    /**
     * 获取当前用户信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/getUserInfo")
    public Resp getUserInfo(HttpRequest request) throws Exception {
        MgUser user = WebUtils.currUser(request);
        if (user != null) {
            return Resp.ok(user);
        } else {
            return Resp.fail();
        }
    }

    /**
     * 新增后台用户
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/add")
    public Resp add(HttpRequest request) throws Exception {
        MgUser mgUser = JSONObject.parseObject(request.getBodyString(), MgUser.class);
        if (mgUser == null || StrUtil.isEmpty(mgUser.getLoginname()) || StrUtil.isEmpty(mgUser.getPwd())) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = userService.add(mgUser);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "后台用户新增",
                        MgConst.OperLogTypes.add,
                        "后台新增用户为" + mgUser.getLoginname());
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 删除后台用户
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
        Ret ret = userService.del(id);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "后台用户删除",
                        MgConst.OperLogTypes.del,
                        "后台用户删除id为" + id);
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }


    /**
     * 修改后台用户密码
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/updatePwd")
    public Resp updatePwd(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        if (null == requestVo.getId() || requestVo.getId() < 0 || StrUtil.isEmpty(requestVo.getOldPwd()) || StrUtil.isEmpty(requestVo.getNewPwd())) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = userService.updatePwd(requestVo);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "后台用户修改密码",
                        MgConst.OperLogTypes.update,
                        "后台用户修改id为" + requestVo.getId());
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 修改后台用户
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/update")
    public Resp update(HttpRequest request) throws Exception {
        MgUser mgUser = JSONObject.parseObject(request.getBodyString(), MgUser.class);
        if (mgUser == null || mgUser.getId() == null || mgUser.getId() < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = userService.update(mgUser);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "后台用户修改",
                        MgConst.OperLogTypes.update,
                        "后台用户修改id为" + mgUser.getId());
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 重置用户密码
     *
     * @param request
     * @param id
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/resetPwd")
    public Resp resetPwd(HttpRequest request, Integer id) throws Exception {
        if (id == null || id < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = userService.resetPwd(id);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "重置后台登录密码",
                        MgConst.OperLogTypes.rest,
                        "重置后台登录密码id为" + id);
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 获取后台用户列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/list")
    public Resp list(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = userService.userList(requestVo);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

}
