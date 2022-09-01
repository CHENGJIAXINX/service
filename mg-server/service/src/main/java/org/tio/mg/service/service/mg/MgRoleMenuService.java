package org.tio.mg.service.service.mg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.model.mg.MgRoleMenu;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.RequestVo;

import java.util.Date;
import java.util.List;

/**
 * 后台角色菜单
 */
public class MgRoleMenuService {
    private static Logger log = LoggerFactory.getLogger(MgRoleMenuService.class);

    public static final MgRoleMenuService ME = new MgRoleMenuService();

    /**
     * 添加角色菜单
     *
     * @param mgRoleMenu
     * @return
     */
    public Ret add(MgRoleMenu mgRoleMenu) {
        mgRoleMenu.setCreatetime(new Date());
        boolean save = mgRoleMenu.save();
        if (save) {
            return RetUtils.okMsg(RetUtils.OPER_RIGHT);
        }
        return RetUtils.failMsg(RetUtils.OPER_ERROR);
    }

    /**
     * 删除角色菜单
     *
     * @param id
     * @return
     */
    public Ret del(Integer id) {
        MgRoleMenu findMgRoleMenu = MgRoleMenu.dao.findById(id);
        if (findMgRoleMenu == null) {
            return RetUtils.failMsg(RetUtils.NOT_EXIST);
        }
        return RetUtils.okMsg(RetUtils.OPER_RIGHT);
    }

    /**
     * 根据角色id获取角色菜单
     * @param roleId
     * @return
     */
    public Ret queryRoleMenuList(Integer roleId) {
        // 查出给角色授权的菜单id
        List<MgRoleMenu> mgRoleMenuList = MgRoleMenu.dao.find("select * from mg_role_menu where role_id = ?", roleId);
        return RetUtils.okList(mgRoleMenuList);
    }

}
