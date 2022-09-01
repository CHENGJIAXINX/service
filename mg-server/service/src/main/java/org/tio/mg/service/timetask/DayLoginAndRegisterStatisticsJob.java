package org.tio.mg.service.timetask;

/**
 * Author: zlb
 * Date: 2021/8/19
 * desc:天统计
 */
public class DayLoginAndRegisterStatisticsJob extends BaseLoginAndRegisterStatisticsJob {
    @Override
    public int getStatPeriod() {
        return 3;
    }
}
