package org.tio.mg.service.service.mg;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.mg.MguserLoginStat;
import org.tio.mg.service.utils.PeriodUtils;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.sitexxx.servicecommon.vo.Const;

import java.util.Date;
import java.util.List;

/**
 * 后台登录用户接口
 *
 * @author xufei
 * 2020年5月25日 下午4:46:25
 */
public class MgLoginStatService {
    private static Logger log = LoggerFactory.getLogger(MgLoginStatService.class);

    public static final MgLoginStatService ME = new MgLoginStatService();

    /**
     * 用户登录统计-存在内存溢出风险-后续如果登录人数很多，可进行优化
     *
     * @param date
     * @author xufei
     * 2020年7月16日 下午2:56:47
     */
    public void loginTimeStat(Date date) {
        DateTime dateTime = DateUtil.offsetDay(date, -1);
        String dayPeriod = PeriodUtils.dateToPeriodByType(dateTime, Const.PeriodType.DAY);
        List<Record> records = Db.use(MgConst.Db.TIO_MG).find("select dayperiod,count(DISTINCT mguid) uidcount,count(1) logincount from mg_user_login_log where dayperiod =?", dayPeriod);
        if (CollectionUtil.isEmpty(records)) {
            return;
        }
        int usercount = records.get(0).getInt("uidcount");
        int totalcount = records.get(0).getInt("logincount");
        if (usercount == 0 || totalcount == 0) {
            return;
        }
        //周期天统计
        MguserLoginStat daystat = new MguserLoginStat();
        daystat.setMguid(-1);
        daystat.setDayperiod(dayPeriod);
        daystat.setUsercount(usercount);
        daystat.setTotalcount(totalcount);
        daystat.setRemark("天统计");
        daystat.replaceSave();
        List<Record> userLogins = Db.use(MgConst.Db.TIO_MG).find("select  mguid,count(1) logincount from mg_user_login_log where dayperiod = ? group by mguid", dayPeriod);
        if (CollectionUtil.isEmpty(userLogins)) {
            log.error("登录统计异常：用户登录记录不存在");
            return;
        }
        for (Record userLogin : userLogins) {
            Integer uid = userLogin.getInt("mguid");
            int count = userLogin.getInt("logincount");
            List<Record> hourLogins = Db.use(MgConst.Db.TIO_MG).find("select hourperiod,count(1) hourcount from mg_user_login_log where dayperiod = ?  and mguid = ? group by hourperiod", dayPeriod, uid);
            if (CollectionUtil.isEmpty(hourLogins)) {
                log.error("登录统计异常：用户登录记录不存在-小时");
                continue;
            }
            //用户天周期统计
            MguserLoginStat userStat = new MguserLoginStat();
            userStat.setMguid(uid);
            userStat.setDayperiod(dayPeriod);
            userStat.setTotalcount(count);
            for (Record hourLogin : hourLogins) {
                dateToLoginStat(userStat, hourLogin.getStr("hourperiod"), hourLogin.getInt("hourcount"));
            }
            userStat.replaceSave();
            //用户总统计
            MguserLoginStat record = MguserLoginStat.dao.findFirst("select  * from mguser_login_stat where mguid = ? and dayperiod = -1", uid);
            if (record == null) {
                record = new MguserLoginStat();
                record.setMguid(uid);
                record.setDayperiod("-1");
                record.setUsercount(1);
                record.setTotalcount(count);
                record.setRemark("用户总统计");
                record.replaceSave();
            } else {
                Db.use(MgConst.Db.TIO_MG).update("update mguser_login_stat set totalcount = totalcount + ? where id = ? ", count, record.getId());
            }
        }
    }


    /**
     * 时间统计列表
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
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_MG).getSqlPara("mgloginstat.statTimeList", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_MG).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /**
     * 时间下的用户列表
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
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_MG).getSqlPara("mgloginstat.statTimeUserList", params);
        Page<Record> list = Db.use(MgConst.Db.TIO_MG).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(list);
    }


    /**
     * 周期下的用户日志列表
     *
     * @param requestVo
     * @return
     */
    public Ret statLoginList(RequestVo requestVo) {
        if (StrUtil.isBlank(requestVo.getPeriod()) || requestVo.getUid() == null) {
            return RetUtils.invalidParam();
        }
        Kv params = Kv.by("dayperiod", requestVo.getPeriod()).set("mguid", requestVo.getUid());
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_MG).getSqlPara("mgloginstat.statLoginList", params);
        List<Record> list = Db.use(MgConst.Db.TIO_MG).find(sqlPara);
        return RetUtils.okList(list);
    }

    /**
     * 用户状态统计列表
     *
     * @param requestVo
     * @return
     */
    public Ret statUserList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.create();
        if (StrUtil.isNotBlank(requestVo.getSearchKey())) {
            params.set("searchkey", "%" + requestVo.getSearchKey() + "%");
            params.set("searchid", requestVo.getSearchKey());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_MG).getSqlPara("mgloginstat.statUserList", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_MG).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /**
     * 用户统计下的用户列表
     *
     * @param requestVo
     * @return
     */
    public Ret statUserDayList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.by("mguid", requestVo.getUid());
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_MG).getSqlPara("mgloginstat.statUserDayList", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_MG).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /**
     * 后台登录日志列表
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
        if (requestVo.getRoleId() != null) {
            params.set("rid", requestVo.getRoleId());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_MG).getSqlPara("mgloginstat.loginlist", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_MG).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }


    /**
     * @param stat
     * @param field
     * @param value
     * @author xufei
     * 2020年7月17日 下午5:39:51
     */
    public static void dateToLoginStat(MguserLoginStat stat, String field, int value) {
        switch (field) {
            case "00":
                stat.setHour0(value);
                break;

            case "01":
                stat.setHour1(value);
                break;
            case "02":
                stat.setHour2(value);
                break;
            case "03":
                stat.setHour3(value);
                break;
            case "04":
                stat.setHour4(value);
                break;
            case "05":
                stat.setHour5(value);
                break;
            case "06":
                stat.setHour6(value);
                break;
            case "07":
                stat.setHour7(value);
                break;
            case "08":
                stat.setHour8(value);
                break;
            case "09":
                stat.setHour9(value);
                break;
            case "10":
                stat.setHour10(value);
                break;
            case "11":
                stat.setHour11(value);
                break;
            case "12":
                stat.setHour12(value);
                break;
            case "13":
                stat.setHour13(value);
                break;
            case "14":
                stat.setHour14(value);
                break;
            case "15":
                stat.setHour15(value);
                break;
            case "16":
                stat.setHour16(value);
                break;
            case "17":
                stat.setHour17(value);
                break;
            case "18":
                stat.setHour18(value);
                break;
            case "19":
                stat.setHour19(value);
                break;
            case "20":
                stat.setHour20(value);
                break;
            case "21":
                stat.setHour21(value);
                break;
            case "22":
                stat.setHour22(value);
                break;
            case "23":
                stat.setHour23(value);
                break;
            default:
                break;
        }
    }
}
