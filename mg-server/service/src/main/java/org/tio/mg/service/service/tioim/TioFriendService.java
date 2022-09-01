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
import org.tio.mg.service.model.main.WxFriendMeta;
import org.tio.mg.service.service.atom.AbsAtom;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.sitexxx.servicecommon.vo.Const;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * im好友管理
 */
public class TioFriendService {

    private Logger log = LoggerFactory.getLogger(TioFriendService.class);

    public static final TioFriendService me = new TioFriendService();

    /**
     * 查询消息模型下的好友列表
     *
     * @param requestVo
     * @return
     */
    public Ret recordList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        String sqlMode = "recordList";
        if (!Objects.equals(String.valueOf(requestVo.getType()),String.valueOf(Const.Status.NORMAL))) {
            sqlMode = "bakRecordList";
        }
        Kv params = Kv.create();
        if (StrUtil.isNotBlank(requestVo.getStartTime())) {
            params.set("starttime", requestVo.getStartTime());
        }
        if (StrUtil.isNotBlank(requestVo.getEndTime())) {
            params.set("endtime", requestVo.getEndTime());
        }
        if (StrUtil.isNotBlank(requestVo.getSearchKey())) {
            params.set("searchkey", "%" + requestVo.getSearchKey() + "%");
            params.set("searchid", requestVo.getSearchKey());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("friend." + sqlMode, params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    public Ret cleanAllMsg() {
        List<WxFriendMeta> all = WxFriendMeta.dao.findAll();
        List metaIds = new ArrayList();
        for (WxFriendMeta item : all) {
            metaIds.add(item.getId());
        }
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                String sql = "delete from wx_friend_msg";
                int delete = Db.use(MgConst.Db.TIO_SITE_MAIN).delete(sql);
                if (delete == 0) {
                    return false;
                }
                String updatesql = "update wx_friend_meta set lastmsgid = null";
                int update = Db.use(MgConst.Db.TIO_SITE_MAIN).update(updatesql);
                if (update == 0) {
                    return false;
                }
                return true;
            }
        };
        boolean tx = Db.use(MgConst.Db.TIO_SITE_MAIN).tx(absAtom);
        if (!tx) {
            return RetUtils.failMsg("清除失败");
        }
        return RetUtils.okList(metaIds);
    }

    public Ret cleanMsg(Integer id) {
        WxFriendMeta meta = WxFriendMeta.dao.findById(id);
        if (meta == null) {
            return RetUtils.failMsg("会话不存在");
        }
        String fidkey = meta.getFidkey();
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                String sql = "delete from wx_friend_msg where twouid = ?";
                int delete = Db.use(MgConst.Db.TIO_SITE_MAIN).delete(sql, fidkey);
                if (delete == 0) {
                    return false;
                }
                meta.setLastmsgid(null);
                boolean update = meta.update();
                if (!update) {
                    return false;
                }
                return true;
            }
        };
        boolean tx = Db.use(MgConst.Db.TIO_SITE_MAIN).tx(absAtom);
        if (!tx) {
            return RetUtils.failMsg("清除失败");
        }
        List<Integer> list = new ArrayList<>();
        list.add(id);
        return RetUtils.okList(list);
    }
}
