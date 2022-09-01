package org.tio.mg.service.timetask;

import cn.hutool.core.date.DateUtil;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.mg.service.vo.MgConst;
import org.tio.utils.jfinal.P;
import org.tio.utils.quartz.AbstractJobWithLog;

import java.util.Date;

/**
 * Author: zlb
 * Date: 2021/8/19
 * desc: 登录注册首页统计
 */
public abstract class BaseLoginAndRegisterStatisticsJob extends AbstractJobWithLog {

    private static Logger log = LoggerFactory.getLogger(BaseLoginAndRegisterStatisticsJob.class);

    private static boolean isRunning = false;

    /**
     * 判断计划任务是否可以开始
     * {true：可以运用；false：不可以}
     *
     * @return
     */
    private static boolean isTaskStartEnable() {
        boolean ret;
        synchronized (BaseLoginAndRegisterStatisticsJob.class) {
            ret = !isRunning && (isRunning = true);
        }
        return ret;
    }

    /**
     * 任务结束调用
     */
    private static void taskEnded() {
        synchronized (BaseLoginAndRegisterStatisticsJob.class) {
            isRunning = false;
        }
    }

    @Override
    public void run(JobExecutionContext jobExecutionContext) throws Exception {
        boolean allowExecute = P.getBoolean("quartz.open.flag", false);
        if (allowExecute && isTaskStartEnable()) {
            try {
                log.info("开始执行登录、注册统计任务");
                startStatisticsTask();
            } catch (Exception e) {
                log.error("登录、注册统计任务异常：" + e.getMessage(), e);
            } finally {
                taskEnded();
            }
        }
    }

    /**
     * 开始执行统计任务
     */
    private void startStatisticsTask() {
        registerStatistics();
        loginStatistics();
    }

    /**
     * 注册统计
     */
    private void registerStatistics() {
        //HOUR/DAY/WEEK/MONTH
        int statPeriod = getStatPeriod();
        String statTime;
        String intervalName;
        if (statPeriod == 1) {
            statTime = DateUtil.format(new Date(), "yyyyMMddHHmm");
            intervalName = "MINUTE";
        } else if (statPeriod == 2) {
            statTime = DateUtil.format(new Date(), "yyyyMMddHH");
            intervalName = "HOUR";
        } else if (statPeriod == 3) {
            statTime = DateUtil.format(new Date(), "yyyyMMdd");
            intervalName = "DAY";
        } else if (statPeriod == 4) {
            statTime = DateUtil.format(new Date(), "yyyyMM");
            intervalName = "MONTH";
        } else {
            log.error("不正确的statPeriod==>" + statPeriod);
            return;
        }

        String sql = "select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 " + intervalName + ") and createtime < now()";
        Integer integer = Db.use(MgConst.Db.TIO_SITE_MAIN).queryInt(sql);
        Record record = new Record();
        record.set("stat_type", 1);
        record.set("stat_period", statPeriod);
        record.set("stat_time", statTime);
        record.set("stat_count", integer);
        Db.use(MgConst.Db.TIO_SITE_STAT).save("stat_user", record);
    }

    /**
     * 登录统计
     */
    private void loginStatistics() {
        int statPeriod = getStatPeriod();
        String statTime;
        String intervalName;
        if (statPeriod == 1) {
            statTime = DateUtil.format(new Date(), "yyyyMMddHHmm");
            intervalName = "MINUTE";
        } else if (statPeriod == 2) {
            statTime = DateUtil.format(new Date(), "yyyyMMddHH");
            intervalName = "HOUR";
        } else if (statPeriod == 3) {
            statTime = DateUtil.format(new Date(), "yyyyMMdd");
            intervalName = "DAY";
        } else if (statPeriod == 4) {
            statTime = DateUtil.format(new Date(), "yyyyMM");
            intervalName = "MONTH";
        } else {
            log.error("不正确的statPeriod==>" + statPeriod);
            return;
        }

        String sql = "SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 " + intervalName + ") AND ll.time < now();";
        Integer integer = Db.use(MgConst.Db.TIO_SITE_MAIN).queryInt(sql);
        Record record = new Record();
        record.set("stat_type", 2);
        record.set("stat_period", statPeriod);
        record.set("stat_time", statTime);
        record.set("stat_count", integer);
        Db.use(MgConst.Db.TIO_SITE_STAT).save("stat_user", record);
    }

    public abstract int getStatPeriod();
}
