package org.tio.mg.service.service.mg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.mg.MgMenu;
import org.tio.mg.service.model.mg.MgRoleMenu;
import org.tio.mg.service.service.atom.AbsTxAtom;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.sitexxx.servicecommon.vo.Const;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 后台菜单接口
 */
public class MgMenuService {
    private static Logger log = LoggerFactory.getLogger(MgMenuService.class);

    public static final MgMenuService ME = new MgMenuService();

    /**
     * 增加菜单/页面
     *
     * @param mgMenu
     * @return
     */
    public Ret add(MgMenu mgMenu) {
        mgMenu.setCreatetime(new Date());
        mgMenu.setUpdatetime(new Date());
        // 如果是新增菜单 则自动设置parentId 为 -1
        if (mgMenu.getType() == 1) {
            mgMenu.setParentId(-1);
        }
        // 如果是新增页面，则parentId为必填参数
        if (mgMenu.getType() == 2 && (mgMenu.getParentId() == null || mgMenu.getParentId() < 0)) {
            return RetUtils.failMsg(RetUtils.INVALID_PARAMETER);
        }
        boolean save = mgMenu.save();
        if (save) {
            return RetUtils.okMsg(RetUtils.OPER_RIGHT);
        }
        return RetUtils.failMsg(RetUtils.OPER_ERROR);
    }

    /**
     * 修改菜单/页面
     *
     * @param mgMenu
     * @return
     */
    public Ret update(MgMenu mgMenu) {
        MgMenu findMgMenu = MgMenu.dao.findById(mgMenu.getId());
        if (findMgMenu == null) {
            return RetUtils.failMsg(RetUtils.NOT_EXIST);
        }
        // 如果是修改为菜单 则自动设置parentId 为 -1
        if (mgMenu.getType() == 1) {
            mgMenu.setParentId(-1);
        }
        // 如果是修改为页面，则parentId为必填参数
        if (mgMenu.getType() == 2 && (mgMenu.getParentId() == null || mgMenu.getParentId() < 0)) {
            return RetUtils.failMsg(RetUtils.INVALID_PARAMETER);
        }
        mgMenu.setUpdatetime(new Date());
        boolean update = mgMenu.update();
        if (update) {
            return RetUtils.okMsg(RetUtils.OPER_RIGHT);
        }
        return RetUtils.failMsg(RetUtils.OPER_ERROR);
    }

    /**
     * 删除菜单/页面
     *
     * @param id
     * @return
     */
    public Ret del(Integer id) {
        MgMenu findMgMenu = MgMenu.dao.findById(id);
        if (findMgMenu == null) {
            return RetUtils.failMsg(RetUtils.NOT_EXIST);
        }
        // 如果删除的是菜单，则需要删除与之关联的所有页面
        if (findMgMenu.getType() == 1) {
            // 开启事务 依次删除
            AbsTxAtom absTxAtom = new AbsTxAtom() {

                @Override
                public boolean noTxRun() {
                    List<MgMenu> mgMenuList = MgMenu.dao.find("select id from mg_menu where parent_id = ?", findMgMenu.getId());
                    if (mgMenuList.isEmpty()) {
                        return true;
                    }
                    for (MgMenu mgMenu : mgMenuList) {
                        boolean isDelSuccess = MgMenu.dao.deleteById(mgMenu.getId());
                        if (!isDelSuccess) {
                            return false;
                        }
                    }
                    return true;
                }
            };
            boolean atom = Db.use(Const.Db.TIO_MG).tx(absTxAtom);
            if (atom) {
                return RetUtils.okMsg(RetUtils.OPER_RIGHT);
            }
        } else {
            boolean delete = findMgMenu.delete();
            if (delete) {
                return RetUtils.okMsg(RetUtils.OPER_RIGHT);
            }
        }
        return RetUtils.failMsg(RetUtils.OPER_ERROR);
    }

    /**
     * 获取菜单列表不包含页面
     *
     * @param requestVo
     * @return
     */
    public Ret getMenuList(RequestVo requestVo) {
        Kv params = Kv.create();
        if (requestVo != null) {
            if (requestVo.getStatus() != null) {
                params.set("status", requestVo.getStatus());
            }
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_MG).getSqlPara("mgmenu.list", params);
        List<MgMenu> mgMenuList = MgMenu.dao.find(sqlPara);
        return RetUtils.okList(mgMenuList);
    }

    /**
     * 获取树形结构菜单页面列表
     * @param requestVo
     * @return
     */
    public Ret queryMenuTree(RequestVo requestVo) {
        Kv params = Kv.create();
        if (requestVo != null) {
            if (requestVo.getType() != null) {
                params.set("type", requestVo.getType());
            }
            if (requestVo.getStatus() != null) {
                params.set("status", requestVo.getStatus());
            }
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_MG).getSqlPara("mgmenu.tree", params);
        List<MgMenu> mgMenuList = MgMenu.dao.find(sqlPara);
        if (mgMenuList.isEmpty()) {
            return RetUtils.okList(new ArrayList<MgMenu>());
        }
        List<MgMenu> topMenuList = new ArrayList<>();
        List<MgMenu> childMenuList = new ArrayList<>();
        List<MgMenu> resultList = new ArrayList<>();
        // 1. 先取出最顶级的菜单
        for (MgMenu mgMenu : mgMenuList) {
            if (mgMenu.getParentId() == -1) { // 最顶级 菜单
                topMenuList.add(mgMenu);
            } else {
                childMenuList.add(mgMenu);
            }
        }
        // 2. 再取出子页面
        for (MgMenu topMgMenu : topMenuList) {
            for (MgMenu childMgMenu : childMenuList) {
                if (childMgMenu.getParentId() == topMgMenu.getId()) {
                    if(topMgMenu.getChildren() == null){
                        topMgMenu.setChildren(new ArrayList<MgMenu>());
                    }
                    topMgMenu.getChildren().add(childMgMenu);
                }
            }
            resultList.add(topMgMenu);
        }
        return RetUtils.okList(resultList);
    }
}
