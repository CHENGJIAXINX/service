package org.tio.sitexxx.service.service.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.sitexxx.service.model.main.UserInvite;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;

import java.util.Date;
import java.util.List;

/**
 * @author :linjian
 * @description : 用户推荐关系表service
 * @createTime :2021/8/27
 * @updateTIme :
 */
public class TioInviteService {

    private static Logger log = LoggerFactory.getLogger(TioInviteService.class);

    public static final TioInviteService me = new TioInviteService();

    /**
     * 添加记录
     *
     * @param inviteUid
     * @param inviteCode
     * @param registerUid
     * @return
     */
    public Ret add(Integer inviteUid, String inviteCode, Integer registerUid) {
        UserInvite userInvite = new UserInvite();
        userInvite.setInviteUid(inviteUid);
        userInvite.setInviteCode(inviteCode);
        userInvite.setRegisterUid(registerUid);
        userInvite.setInviteType(0);
        userInvite.setCreatetime(new Date());
        boolean result = userInvite.save();
        if (result) {
            return RetUtils.okMsg("保存成功");
        } else {
            return RetUtils.failMsg("保存失败");
        }
    }

    /**
     * 删除记录
     *
     * @param id
     * @return
     */
    public Ret del(Integer id) {
        boolean b = UserInvite.dao.deleteById(id);
        if (b) {
            return RetUtils.okMsg("删除成功");
        } else {
            return RetUtils.failMsg("删除失败");
        }
    }

    /**
     * 通过推荐uid获取记录列表
     *
     * @param uid
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public Ret getPageList(Integer uid, Integer pageNumber, Integer pageSize) {
        if (uid == null || uid <= 0) {
            return RetUtils.failMsg("推荐uid错误");
        }
        if (pageNumber == null || pageNumber <= 0) {
            pageNumber = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 15;
        }
        Kv params = Kv.by("inviteUid", uid);
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("invite.list", params);
        Page<Record> pages = Db.use(Const.Db.TIO_SITE_MAIN).paginate(pageNumber, pageSize, sqlPara);
        return RetUtils.okPage(pages);
    }

    /**
     * 通过推荐uid获取记录列表
     *
     * @param uid
     * @return
     */
    public Ret getListByUid(Integer uid) {
        if (uid == null || uid <= 0) {
            return RetUtils.failMsg("推荐uid错误");
        }
        List<UserInvite> userInvites = UserInvite.dao.find("select * from user_invite where invite_uid = ?", uid);
        return RetUtils.okList(userInvites);
    }
}
