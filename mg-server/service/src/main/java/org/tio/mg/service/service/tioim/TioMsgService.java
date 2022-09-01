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
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.sitexxx.servicecommon.vo.Const;

import java.util.Objects;

/**
 * im消息管理
 */
public class TioMsgService {

    private Logger log = LoggerFactory.getLogger(TioMsgService.class);

    public static final TioMsgService me = new TioMsgService();

    /**
     * 近期私聊消息列表
     *
     * @param requestVo
     * @return
     */
    public Ret p2pList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        String sqlMode = "modeP2PMsgList";
        if (!Objects.equals(String.valueOf(requestVo.getType()), String.valueOf(Const.Status.NORMAL))) {
            sqlMode = "bakModeP2PMsgList";
        }
        Kv params = Kv.by("fidkey", requestVo.getFidKey());
        if (requestVo.getContentType() != null) {
            params.set("contenttype", "(" + requestVo.getContentType() + ")");
        }
        if (StrUtil.isNotBlank(requestVo.getStartTime())) {
            params.set("starttime", requestVo.getStartTime());
        }
        if (StrUtil.isNotBlank(requestVo.getEndTime())) {
            params.set("endtime", requestVo.getEndTime());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("wxmsg." + sqlMode, params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /**
     * 群聊模型聊天列表
     *
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
        String sqlMode = "groupModeMsgList";
        if (!Objects.equals(String.valueOf(requestVo.getType()), String.valueOf(Const.Status.NORMAL))) {
            sqlMode = "bakGroupModeMsgList";
        }
        Kv params = Kv.by("groupid", requestVo.getGroupId());
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("wxmsg." + sqlMode, params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

}
