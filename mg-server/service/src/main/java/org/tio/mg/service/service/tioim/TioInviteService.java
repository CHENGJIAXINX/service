package org.tio.mg.service.service.tioim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.main.UserInvite;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.RequestVo;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.hutool.StrUtil;

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
     * @param uid
     * @param inviteCode
     * @param registerUid
     * @return
     */
    public Ret add(Integer uid, String inviteCode, Integer registerUid) {
        UserInvite userInvite = new UserInvite();
        userInvite.setInviteUid(uid);
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
     * @param requestVo
     * @return
     */
    public Ret getPageList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv param = Kv.create();
        param.set("uid", requestVo.getUid());
        if (!StrUtil.isEmpty(requestVo.getStartTime())) {
            param.set("startTime", requestVo.getStartTime());
        }
        if (!StrUtil.isEmpty(requestVo.getEndTime())) {
            param.set("endTime", requestVo.getEndTime());
        }
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("invite.list", param);
        Page<Record> pages = Db.use(Const.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
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
