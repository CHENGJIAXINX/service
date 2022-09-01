package org.tio.mg.service.service.yxnxun.wallet;

import cn.hutool.core.collection.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.main.YxUserRecieverRedPacketItem;
import org.tio.mg.service.model.main.YxUserSendRedPacket;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RedPacketVo;

import java.util.List;

public class RedPacketService {
    Logger log = LoggerFactory.getLogger(RedPacketService.class);

    public static final RedPacketService me = new RedPacketService();

    private YxUserSendRedPacket redPacketDao = new YxUserSendRedPacket().dao();

    private YxUserRecieverRedPacketItem itemDao = new YxUserRecieverRedPacketItem().dao();


    public Ret findList(RedPacketVo redPacketVo) {
        if (redPacketVo.getPageNumber() == null || redPacketVo.getPageNumber() < 1) {
            redPacketVo.setPageNumber(1);
        }
        if (redPacketVo.getPageSize() == null || redPacketVo.getPageSize() < 1) {
            redPacketVo.setPageSize(15);
        }
        Kv param = Kv.create();
        if (redPacketVo.getUid() != null) {
            param.set("uid", redPacketVo.getUid());
        }
        if (redPacketVo.getStatus() != null) {
            param.set("status", redPacketVo.getStatus());
        }
        if (redPacketVo.getStartTime() != null) {
            param.set("starttime", redPacketVo.getStartTime());
        }
        if (redPacketVo.getEndTime() != null) {
            param.set("endtime", redPacketVo.getEndTime());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("mgredpacket.redList", param);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(redPacketVo.getPageNumber(), redPacketVo.getPageSize(), sqlPara);
        if (records.getPageSize() == 0) {
            return null;
        }
        return RetUtils.okPage(records);
    }

    public Ret findDetailsById(Integer id) {
        Kv param = Kv.by("id", id);
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("mgredpacket.redDetails", param);
        List<YxUserRecieverRedPacketItem> list = itemDao.find(sqlPara);
        if (!CollectionUtil.isEmpty(list)) {
            return RetUtils.okList(list);
        }
        return null;
    }

    public Ret redPacketStat(String stime, String etime) {
        Kv params = Kv.create().set("stime", stime).set("etime", etime);
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("mgredpacket.getstat", params);
        Record record = Db.use(MgConst.Db.TIO_SITE_MAIN).findFirst(sqlPara);
        Ret ret = Ret.create();
        if (record == null) {
            ret.set("sum", 0);
        } else {
            ret.set("sum", record.getInt("remainmoney"));
        }
        return ret;
    }
}
