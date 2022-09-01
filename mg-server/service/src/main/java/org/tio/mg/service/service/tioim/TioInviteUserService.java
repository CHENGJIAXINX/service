package org.tio.mg.service.service.tioim;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.jfinal.template.expr.ast.Const;
import org.tio.mg.service.model.main.User;
import org.tio.mg.service.model.main.UserInviteAttr;
import org.tio.mg.service.service.atom.AbsAtom;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;

import java.sql.SQLException;

/**
 * @author :linjian
 * @description : 邀请用户服务
 * @createTime :2021/10/17
 * @updateTIme :
 */
public class TioInviteUserService {

    private static Logger log = LoggerFactory.getLogger(TioInviteUserService.class);

    public static final TioInviteUserService me = new TioInviteUserService();


    /**
     * 用户列表数据
     *
     * @param requestVo
     * @return
     */
    public Ret list(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.create();
        if (!StrUtil.isEmpty(requestVo.getSearchKey())) {
            params.set("searchkey", "%" + requestVo.getSearchKey() + "%");
            params.set("searchid", requestVo.getSearchKey());
        }
        if (requestVo.getStatus() != null) {
            params.set("status", requestVo.getStatus());
        } else {
            // 默认查询绑定用户
            params.set("status", 1);
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("tioinviteuser.list", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /**
     * 新增用户信息
     *
     * @param requestVo
     * @return
     */
    public Ret add(RequestVo requestVo) {
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                // 验证邀请码是否被设置
                User first = User.dao.findFirst("select * from user where invitecode = ?", requestVo.getInviteCode());
                if (first != null) {
                    this.msg = "邀请码已存在";
                    return false;
                }
                User user = User.dao.findById(requestVo.getUid());
                if (user == null) {
                    this.msg = "用户未找到";
                    return false;
                }
                user.setInvitecode(String.valueOf(requestVo.getInviteCode()));
                boolean update = user.update();
                if (!update) {
                    this.msg = "用户邀请码设置失败";
                    return false;
                }
                UserInviteAttr userInviteAttr = UserInviteAttr.dao.findFirst("select * from user_invite_attr where uid = ?", requestVo.getUid());
                if (userInviteAttr != null) {
                    this.msg = "用户记录已存在";
                    return false;
                }
                UserInviteAttr newUserInviteAttr = new UserInviteAttr();
                newUserInviteAttr.setUid(requestVo.getUid());
                newUserInviteAttr.setInvitecode(String.valueOf(requestVo.getInviteCode()));
                // 设置状态为绑定 1： 绑定  2：解绑
                newUserInviteAttr.setStatus((byte) 1);
                if (requestVo.getFuid() != null) {
                    newUserInviteAttr.setFuid(requestVo.getFuid());
                }
                if (requestVo.getGid() != null) {
                    newUserInviteAttr.setGid(requestVo.getGid());
                }
                if (!StrUtil.isEmpty(requestVo.getMessage())) {
                    newUserInviteAttr.setMessage(requestVo.getMessage());
                }
                boolean save = newUserInviteAttr.save();
                if (!save) {
                    this.msg = "保存邀请用户失败";
                    return false;
                }
                this.msg = "保存成功";
                return true;
            }
        };
        boolean tx = Db.use(MgConst.Db.TIO_SITE_MAIN).tx(absAtom);
        if (!tx) {
            return RetUtils.failMsg(absAtom.getMsg());
        }
        return RetUtils.okMsg(absAtom.getMsg());
    }

    /**
     * 更新用户信息（邀请码不可修改）
     *
     * @param requestVo
     * @return
     */
    public Ret updateInfo(RequestVo requestVo) {
        User user = User.dao.findById(requestVo.getUid());
        if (user == null) {
            return RetUtils.failMsg("用户不存在");
        }
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                UserInviteAttr userInviteAttr = UserInviteAttr.dao.findById(requestVo.getId());
                if (userInviteAttr == null) {
                    this.msg = "推荐用户信息未找到";
                    return false;
                }
                if (requestVo.getFuid() != null) {
                    userInviteAttr.setFuid(requestVo.getFuid());
                }
                if (requestVo.getGid() != null) {
                    userInviteAttr.setGid(requestVo.getGid());
                }
                if (!StrUtil.isEmpty(requestVo.getMessage())) {
                    userInviteAttr.setMessage(requestVo.getMessage());
                }
                boolean update = userInviteAttr.update();
                if (!update) {
                    this.msg = "修改推荐用户信息失败";
                    return false;
                }
                this.msg = "操作成功";
                return true;
            }
        };
        boolean tx = Db.use(MgConst.Db.TIO_SITE_MAIN).tx(absAtom);
        if (!tx) {
            return RetUtils.failMsg(absAtom.getMsg());
        }
        return RetUtils.okMsg(absAtom.getMsg());
    }

    /**
     * 解绑推荐用户
     *
     * @param userInviteAttr
     * @return
     */
    public Ret unbind(UserInviteAttr userInviteAttr) {
        // 设置推荐状态为解绑
        userInviteAttr.setStatus((byte) 2);
        boolean update = userInviteAttr.update();
        if (update) {
            return RetUtils.okOper();
        }
        return RetUtils.failOper();
    }
}
