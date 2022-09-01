package org.tio.mg.web.server.controller.mg;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.model.mg.MgRole;
import org.tio.mg.service.model.mg.MgUser;
import org.tio.mg.service.service.mg.MgRoleService;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.mg.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

/**
 * 后台用户角色管理控制器
 */
@RequestPath(value = "/adminRole")
public class MgRoleController {

    private Logger log = LoggerFactory.getLogger(MgRoleController.class);

    private MgRoleService roleService = MgRoleService.ME;


    /**
     * 新增角色
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/add")
    public Resp add(HttpRequest request) throws Exception {
        MgRole mgRole = JSONObject.parseObject(request.getBodyString(), MgRole.class);
        if (mgRole == null || StrUtil.isEmpty(mgRole.getName())) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = roleService.add(mgRole);
        if (ret.isFail()) {
            log.error("保存失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "角色新增",
                        MgConst.OperLogTypes.add,
                        "角色新增" + mgRole.getName());
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 删除角色
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
        Ret ret = roleService.del(id);
        if (ret.isFail()) {
            log.error("删除失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "角色删除",
                        MgConst.OperLogTypes.del,
                        "角色删除 rid为" + id);
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 修改角色
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/update")
    public Resp update(HttpRequest request) throws Exception {
        MgRole mgRole = JSONObject.parseObject(request.getBodyString(), MgRole.class);
        if (mgRole == null || mgRole.getId() < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = roleService.update(mgRole);
        if (ret.isFail()) {
            log.error("修改失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "角色修改",
                        MgConst.OperLogTypes.update,
                        "角色修改" + mgRole.getName());
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 获取角色列表
     *
     * @param request
     * @param status  角色的状态
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/list")
    public Resp list(HttpRequest request, Byte status) throws Exception {
        Ret ret = roleService.list(status);
        if (ret.isFail()) {
            log.error("获取角色失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkList(ret));
    }

    /**
     * 获取已经授权的路由列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/getRoutes")
    public Resp getRoutes(HttpRequest request) throws Exception {
        MgUser mgUser = WebUtils.currUser(request);
        if (mgUser == null || mgUser.getId() == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        // 根据角色id去查找对应的菜单列表
        Ret ret = roleService.getRoutes(mgUser.getId());
        if (ret.isFail()) {
            log.error("获取菜单失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkList(ret));
    }

}
