package org.tio.mg.service.service.tioim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.main.WxChatItems;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.sitexxx.servicecommon.vo.Const;

import java.util.Objects;

/**
 * 会话管理服务
 */
public class TioChatService {

    private static Logger log = LoggerFactory.getLogger(TioChatService.class);

    public static final TioChatService me = new TioChatService();

    /**
     * 会话列表
     *
     * @param requestVo
     * @return
     */
    public Ret chatItemList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.by("uid", requestVo.getUid());
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("chat.list", params);
        Page<Record> pages = Db.use(Const.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(pages);
    }

    /**
     * 会话消息
     *
     * @param requestVo
     * @return
     */
    public Ret chatMsgList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        WxChatItems chatItems = WxChatItems.dao.findById(requestVo.getChatLinkId());
        if (chatItems == null) {
            log.error("获取聊天列表：无效会话");
            return RetUtils.noExistParam();
        }
        Kv params = Kv.create();
        String sqlParaName = "";
        if (Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
            sqlParaName = "p2pMsg";
            params.set("key", chatItems.getFidkey());
        } else {
            sqlParaName = "groupMsg";
            params.set("key", chatItems.getBizid());
        }
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("chat." + sqlParaName, params);
        Page<Record> pages = Db.use(Const.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(pages);
    }


    /**
     * 群列表
     * @param requestVo
     * @return
     */
    public Ret groupList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.by("uid", requestVo.getUid());
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("chat.groupList", params);
        Page<Record> pages = Db.use(Const.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(pages);
    }

    /**
     * 群消息列表
     *
     * @param requestVo
     * @return
     */
    public Ret groupMsgList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.by("key", requestVo.getGroupId());
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("chat.groupMsg", params);
        Page<Record> pages = Db.use(Const.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(pages);
    }

    /**
     * @param groupid
     * @return
     * @author xufei
     * 2020年7月29日 下午2:35:57
     */
    public Ret groupInfo(Long groupid) {
        Record group = Db.use(MgConst.Db.TIO_SITE_MAIN).findFirst("select g.*,m.joinnum,u.avatar,u.loginname,u.nick from wx_group g INNER JOIN wx_group_meta m on m.groupid = g.id INNER JOIN `user` u on u.id = g.uid where g.id = ?", groupid);
        return RetUtils.okData(group);
    }

    /**
     * 群用户列表
     * @param requestVo
     * @return
     */
    public Ret groupUserList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.by("groupid", requestVo.getGroupId());
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("chat.groupUserlist", params);
        Page<Record> records = Db.use(Const.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);

    }

    /**
     * 好友列表
     * @param requestVo
     * @return
     */
    public Ret friendList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.by("uid", requestVo.getUid());
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("chat.friendList", params);
        Page<Record> pages = Db.use(Const.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(pages);
    }

    /**
     * 好友申请列表
     * @param requestVo
     * @return
     */
    public Ret applyList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.by("uid", requestVo.getUid());
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("chat.applylist", params);
        Page<Record> pages = Db.use(Const.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(pages);
    }

    /**
     * 好友消息列表
     *
     * @param requestVo
     * @return
     */
    public Ret friendMsgList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        String fidkey = "";
        if (requestVo.getUid() > requestVo.getToUid()) {
            fidkey = requestVo.getUid() + "_" + requestVo.getToUid();
        } else {
            fidkey = requestVo.getToUid() + "_" + requestVo.getUid();
        }
        Kv params = Kv.by("key", fidkey);
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("chat.p2pMsg", params);
        Page<Record> pages = Db.use(Const.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(pages);
    }

    /**
     * 修改索引的起始消息-已调整
     * 单独处理起始消息的方法-用户索引
     *
     * @param uid
     * @param bizid
     * @param mode
     * @param startMsgId
     * @return
     * @author xufei
     * 2020年2月3日 下午12:07:31
     */
    public boolean chatuserStartMsg(Integer uid, Long bizid, Byte mode, Long startMsgId) {
        if (uid == null || bizid == null || mode == null) {
            return false;
        }
        Kv params = Kv.by("uid", uid).set("chatmode", mode).set("bizid", bizid);
        if (startMsgId != null) {
            params.set("startmsgid", startMsgId);
        } else {
            params.set("setnull", Const.YesOrNo.YES);
        }
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("chat.chatuserStartMsg", params);
        int update = Db.use(Const.Db.TIO_SITE_MAIN).update(sqlPara);
        if (update <= 0) {
            return false;
        }
        return true;
    }

}
