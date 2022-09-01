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
import org.tio.mg.service.model.main.WxGroupMsg;
import org.tio.mg.service.service.atom.AbsAtom;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.jfinal.P;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * im群管理
 *
 * @author xufei
 * 2020年5月16日 下午2:21:06
 */
public class TioGroupService {

    private static Logger log = LoggerFactory.getLogger(TioGroupService.class);

    public static final TioGroupService me = new TioGroupService();

    /**
     * 获取群组数量
     *
     * @param requestVo
     * @return
     */
    public Ret getGroupCount(RequestVo requestVo) {
        String sql = "select count(1) from tio_site_main.wx_group where status = 1";
        if (requestVo != null && StrUtil.isBlank(requestVo.getStartTime()) && StrUtil.isBlank(requestVo.getEndTime())) {
            sql += " and createtime >= '" + requestVo.getStartTime() + "'";
            sql += " and createtime <= '" + requestVo.getEndTime() + "'";
        }
        sql += " order by createtime desc";
        Integer integer = Db.use(Const.Db.TIO_SITE_MAIN).queryInt(sql);
        return RetUtils.okData(integer);
    }

    /**
     * 群查询
     *
     * @param requestVo
     * @return
     */
    public Ret groupList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() <= 0) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.by("managerrole", Const.GroupRole.MANAGER);
        params.set("starttime", requestVo.getStartTime());
        params.set("endtime", requestVo.getEndTime());
        if (StrUtil.isNotBlank(requestVo.getSearchKey())) {
            params.set("searchkey", "%" + requestVo.getSearchKey() + "%");
        }
        if (StrUtil.isNotBlank(requestVo.getGroupKey())) {
            params.set("groupkey", "%" + requestVo.getGroupKey() + "%");
            params.set("gid", requestVo.getGroupKey());
        }
        boolean allowOper = P.getBoolean("oper.open.flag", true);
        if (!allowOper) {
            params.set("noemail", Const.YesOrNo.YES);
        } else {
            params.set("email", Const.YesOrNo.YES);
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("group.grouplist", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /**
     * 删除群列表
     *
     * @param requestVo
     * @return
     */
    public Ret delgroupList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() <= 0) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() <= 0) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.by("managerrole", Const.GroupRole.MANAGER);
        params.set("starttime", requestVo.getStartTime());
        params.set("endtime", requestVo.getEndTime());
        if (StrUtil.isNotBlank(requestVo.getSearchKey())) {
            params.set("searchkey", "%" + requestVo.getSearchKey() + "%");
        }
        if (StrUtil.isNotBlank(requestVo.getGroupKey())) {
            params.set("groupkey", "%" + requestVo.getGroupKey() + "%");
            params.set("gid", requestVo.getGroupKey());
        }
        boolean allowOper = P.getBoolean("oper.open.flag", true);
        if (!allowOper) {
            params.set("noemail", Const.YesOrNo.YES);
        } else {
            params.set("email", Const.YesOrNo.YES);
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("group.delgrouplist", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /**
     * 查询消息模型下的群列表
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
        if (Objects.equals(String.valueOf(requestVo.getType()), String.valueOf(Const.Status.DISABLED))) {
            sqlMode = "bakRecordList";
        } else if (Objects.equals(String.valueOf(requestVo.getType()), String.valueOf(Const.Status.DELETE))) {
            sqlMode = "delBakRecordList";
        }
        Kv params = Kv.create();
        if (StrUtil.isNotBlank(requestVo.getStartTime())) {
            params.set("starttime", requestVo.getStartTime());
        }
        if (StrUtil.isNotBlank(requestVo.getEndTime())) {
            params.set("endtime", requestVo.getEndTime());
        }
        if (StrUtil.isNotBlank(requestVo.getGroupKey())) {
            params.set("groupkey", "%" + requestVo.getGroupKey() + "%");
            params.set("gid", requestVo.getGroupKey());
        }
        boolean allowOper = P.getBoolean("oper.open.flag", true);
        if (!allowOper) {
            params.set("noemail", Const.YesOrNo.YES);
        } else {
            params.set("email", Const.YesOrNo.YES);
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("group." + sqlMode, params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /**
     * 清除全部群聊消息
     *
     * @return
     */
    public Ret cleanAllMsg() {
        String sql = "select * from wx_group_msg group by groupid";
        List<WxGroupMsg> wxGroupMsgs = WxGroupMsg.dao.find(sql);
        List<Long> Ids = new ArrayList<>();
        for (WxGroupMsg groupMsg : wxGroupMsgs) {
            Ids.add(groupMsg.getGroupid());
        }
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                String sql = "delete from wx_group_msg";
                int delete = Db.use(MgConst.Db.TIO_SITE_MAIN).delete(sql);
                if (delete == 0) {
                    return false;
                }
                return true;
            }
        };
        boolean tx = Db.use(MgConst.Db.TIO_SITE_MAIN).tx(absAtom);
        if (!tx) {
            return RetUtils.failMsg("清除失败");
        }

        return RetUtils.okList(Ids);
    }

    /**
     * 清除单个群聊消息
     *
     * @param id
     * @return
     */
    public Ret cleanMsg(Integer id) {
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                String sql = "delete from wx_group_msg where groupid = ?";
                int delete = Db.use(MgConst.Db.TIO_SITE_MAIN).delete(sql, id);
                if (delete == 0) {
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
