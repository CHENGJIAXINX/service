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
import org.tio.utils.jfinal.P;

import java.util.List;

/**
 * IM登录日志管理服务
 */
public class TioLoginService {

    private static Logger log = LoggerFactory.getLogger(TioLoginService.class);

    public static final TioLoginService me = new TioLoginService();

    /**
     * 获取用户登录统计
     *
     * @param requestVo
     * @return
     */
    public Ret getLoginCount(RequestVo requestVo) {
        String sql = "SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE 1 = 1";
        if (StrUtil.isNotEmpty(requestVo.getStartTime()) && StrUtil.isNotEmpty(requestVo.getEndTime())) {
            sql += " and ll.time >= '" + requestVo.getStartTime() + "'";
            sql += " and ll.time < '" + requestVo.getEndTime() + "';";
        }
        int groupCount = Db.use(Const.Db.TIO_SITE_MAIN).queryInt(sql);
        return RetUtils.okData(groupCount);
    }

    /**
     * 登录日志
     *
     * @param requestVo
     * @return
     */
    public Ret loginList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.create();
        if (StrUtil.isNotBlank(requestVo.getStartTime())) {
            params.set("starttime", requestVo.getStartTime());
        }
        if (StrUtil.isNotBlank(requestVo.getEndTime())) {
            params.set("endtime", requestVo.getEndTime());
        }
        if (StrUtil.isNotBlank(requestVo.getIp())) {
            params.set("searchip", requestVo.getIp());
        }
        if (StrUtil.isNotBlank(requestVo.getSearchKey())) {
            params.set("searchkey", "%" + requestVo.getSearchKey() + "%");
            params.set("searchid", requestVo.getSearchKey());
        }
        boolean allowOper = P.getBoolean("oper.open.flag", true);
        if (!allowOper) {
            params.set("noemail", Const.YesOrNo.YES);
        } else {
            params.set("email", Const.YesOrNo.YES);
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("tiologin.list", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }


    /**
     * 统计日志--天
     *
     * @param requestVo
     * @return
     */
    public Ret statTimeList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.create();
        if (StrUtil.isNotBlank(requestVo.getStartTime())) {
            params.set("starttime", requestVo.getStartTime());
        }
        if (StrUtil.isNotBlank(requestVo.getEndTime())) {
            params.set("endtime", requestVo.getEndTime());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_STAT).getSqlPara("tiologin.statTimeList", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_STAT).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }


    /**
     * 统计日志--天--用户
     *
     * @param requestVo
     * @return
     */
    public Ret statTimeUserList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        if (StrUtil.isBlank(requestVo.getPeriod())) {
            return RetUtils.invalidParam();
        }
        Kv params = Kv.by("dayperiod", requestVo.getPeriod());
        boolean allowOper = P.getBoolean("oper.open.flag", true);
        if (!allowOper) {
            params.set("noemail", Const.YesOrNo.YES);
        } else {
            params.set("email", Const.YesOrNo.YES);
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_STAT).getSqlPara("tiologin.statTimeUserList", params);
        Page<Record> list = Db.use(MgConst.Db.TIO_SITE_STAT).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(list);
    }

    /**
     * 统计日志--天--日志
     *
     * @param period
     * @param uid
     * @return
     * @author xufei
     * 2020年7月16日 下午3:26:34
     */
    public Ret statTimeLoginList(String period, Integer uid) {
        if (StrUtil.isBlank(period) || uid == null) {
            return RetUtils.invalidParam();
        }
        Kv params = Kv.by("dayperiod", period).set("uid", uid);
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("tiologin.statTimeLoginList", params);
        List<Record> list = Db.use(MgConst.Db.TIO_SITE_MAIN).find(sqlPara);
        return RetUtils.okList(list);
    }


    /**
     * 统计日志--Ip
     *
     * @param requestVo
     * @return
     */
    public Ret statIpList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.create();
        if (StrUtil.isNotBlank(requestVo.getIp())) {
            params.set("ip", requestVo.getIp());
        }
        if (StrUtil.isBlank(requestVo.getOrder())) {
            params.set("order", "usercount");
        } else {
            params.set("order", requestVo.getOrder());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_STAT).getSqlPara("tiologin.statIpList", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_STAT).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /**
     * 统计日志--Ip--天
     *
     * @param requestVo
     * @return
     */
    public Ret statIpDayList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.by("ip", requestVo.getIp());
        if (StrUtil.isBlank(requestVo.getOrder())) {
            params.set("order", "usercount");
        } else {
            params.set("order", requestVo.getOrder());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_STAT).getSqlPara("tiologin.statIpDayList", params);
        Page<Record> list = Db.use(MgConst.Db.TIO_SITE_STAT).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(list);
    }


    /**
     * 统计日志--Ip--用户
     * @param requestVo
     * @return
     */
    public Ret statIpUserList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.by("dayperiod", requestVo.getPeriod()).set("ip", requestVo.getIp());
        boolean allowOper = P.getBoolean("oper.open.flag", true);
        if (!allowOper) {
            params.set("noemail", Const.YesOrNo.YES);
        } else {
            params.set("email", Const.YesOrNo.YES);
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_STAT).getSqlPara("tiologin.statIpUserList", params);
        Page<Record> list = Db.use(MgConst.Db.TIO_SITE_STAT).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(list);
    }

    /**
     * 统计日志--Ip--用户--日志
     *
     * @param period
     * @param uid
     * @return
     * @author xufei
     * 2020年7月16日 下午3:26:34
     */
    public Ret statIpLoginList(String period, Integer uid, String ip) {
        if (StrUtil.isBlank(period) || uid == null) {
            return RetUtils.invalidParam();
        }
        Kv params = Kv.by("dayperiod", period).set("uid", uid).set("ip", ip);
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("tiologin.statIpLoginList", params);
        List<Record> list = Db.use(MgConst.Db.TIO_SITE_MAIN).find(sqlPara);
        return RetUtils.okList(list);
    }

}
