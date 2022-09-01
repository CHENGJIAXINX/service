package org.tio.mg.web.server.controller.mg;

import com.alibaba.fastjson.JSONObject;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.mg.service.model.mg.*;
import org.tio.mg.service.service.atom.AbsAtom;
import org.tio.mg.service.service.mg.MgMenuService;
import org.tio.mg.service.service.mg.MgRoleMenuService;
import org.tio.mg.service.service.mg.MgRoleService;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.MgMenuRoleVo;
import org.tio.mg.service.vo.RequestVo;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.mg.web.server.utils.WebUtils;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.resp.Resp;

import java.sql.SQLException;
import java.util.List;

@RequestPath(value = "/mgmenu")
public class MgMenuController {

    private static Logger log = LoggerFactory.getLogger(MgMenuController.class);

    private MgMenuService menuService = MgMenuService.ME;

    private MgRoleService roleService = MgRoleService.ME;

    private MgRoleMenuService roleMenuService = MgRoleMenuService.ME;

    /**
     * 增加菜单/页面
     *
     * @param request {参数放在 body => raw => json中}
     * @return
     */
    @RequestPath(value = "/add")
    public Resp addMenu(@NotNull HttpRequest request) {
        // 将参数转化为对象
        MgMenu mgMenu = JSONObject.parseObject(request.getBodyString(), MgMenu.class);
        // 必要参数检查
        if (mgMenu == null || StrUtil.isEmpty(mgMenu.getPath()) || StrUtil.isEmpty(mgMenu.getName()) || mgMenu.getType() < 0 || StrUtil.isEmpty(mgMenu.getTitle())) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret res = menuService.add(mgMenu);
        if (res.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(res));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "后台菜单新增",
                        MgConst.OperLogTypes.add,
                        "后台新增菜单名称为" + mgMenu.getName());
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(res));
    }

    /**
     * 修改菜单
     *
     * @param request {参数放在 body => raw => json中}
     * @return
     */
    @RequestPath(value = "/update")
    public Resp updateMenu(HttpRequest request) {
        // 将参数转化为对象
        MgMenu mgMenu = JSONObject.parseObject(request.getBodyString(), MgMenu.class);
        // 必要参数检查
        if (mgMenu == null || mgMenu.getId() < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        // 根据角色id去查找对应的菜单列表
        Ret ret = menuService.update(mgMenu);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "后台菜单修改",
                        MgConst.OperLogTypes.update,
                        "后台修改菜单id为" + mgMenu.getId());
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 删除菜单
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/del")
    public Resp delMenu(HttpRequest request, Integer id) {
        // 必要参数检查
        if (id == null || id < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        // 根据角色id去查找对应的菜单列表
        Ret ret = menuService.del(id);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "后台菜单删除",
                        MgConst.OperLogTypes.del,
                        "后台删除菜单id为" + id);
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 获取全部菜单（仅菜单不包含页面）
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/queryMenuList")
    public Resp queryMenuList(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        // 根据角色id去查找对应的菜单列表
        Ret ret = menuService.getMenuList(requestVo);
        if (ret.isFail()) {
            log.error("获取菜单失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkList(ret));
    }

    /**
     * 获取菜单树（菜单页面）
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/queryMenuTree")
    public Resp queryMenuTree(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        // 根据角色id去查找对应的菜单列表
        Ret ret = menuService.queryMenuTree(requestVo);
        if (ret.isFail()) {
            log.error("获取菜单失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkList(ret));
    }

    /**
     * 获取角色菜单列表(roleId为必传值)
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/queryRoleMenuList")
    public Resp queryRoleMenuList(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        if(requestVo == null || requestVo.getRoleId() == null){
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        // 根据角色id去查找对应的菜单列表
        Ret ret = roleMenuService.queryRoleMenuList(requestVo.getRoleId());
        if (ret.isFail()) {
            log.error("获取菜单失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkList(ret));
    }

    /**
     * 获取登录用户角色菜单
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/getRoleMenuList")
    public Resp getRoleMenuList(HttpRequest request) {
        MgUser user = WebUtils.currUser(request);
        if (user == null) {
            return Resp.fail("获取菜单失败:用户不存在");
        }
        // 获取用户角色
        MgUserRole mgUserRole = roleService.getRoleByUid(user.getId());
        if (mgUserRole == null) {
            return Resp.fail("获取菜单失败:用户角色未找到");
        }
        // 根据角色id去查找对应的菜单列表
        Ret ret = roleMenuService.queryRoleMenuList(mgUserRole.getId());
        if (ret.isFail()) {
            log.error("获取菜单失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 保存角色菜单列表
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/saveMenuRoleList")
    public Resp saveMenuRoleList(HttpRequest request) throws Exception {
        MgMenuRoleVo mgMenuRoleVo = JSONObject.parseObject(request.getBodyString(), MgMenuRoleVo.class);
        // 校验参数
        if (mgMenuRoleVo == null || mgMenuRoleVo.getRoleId() < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Integer roleId = mgMenuRoleVo.getRoleId();
        List<Integer> menuIds = mgMenuRoleVo.getMenuIds();
        // 校验角色id
        MgRole mgRole = roleService.getRoleByRoleId(roleId);
        if (mgRole == null) {
            return Resp.fail("保存菜单失败:用户角色未找到");
        }
        // 采用事务的方式两步骤 1.删除此roleId下所有菜单记录 2.添加所有 记录
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                // 删除 roleid下所有记录
                Db.use(MgConst.Db.TIO_MG).update("delete from mg_role_menu where role_id = ?", roleId);
                // 依次添加记录
                for (int i = 0; i < menuIds.size(); i++) {
                    // 获取menuId
                    Integer menuId = menuIds.get(i);
                    MgRoleMenu mgRoleMenu = new MgRoleMenu();
                    // 添加role_id
                    mgRoleMenu.setRoleId(roleId);
                    // 添加menu_id
                    mgRoleMenu.setMenuId(menuId);
                    Ret res = roleMenuService.add(mgRoleMenu);
                    if (res.isFail()) {
                        this.setMsg("添加记录失败");
                        return false;
                    }
                }
                return true;
            }
        };
        boolean tx = Db.use(MgConst.Db.TIO_MG).tx(absAtom);
        if (tx) {
            return Resp.ok(RetUtils.OPER_RIGHT);
        }
        return Resp.fail(absAtom.getMsg());
    }

}
