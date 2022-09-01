package org.tio.mg.service.timetask;

/**
 * Author: zlb
 * Date: 2021/8/19
 * desc:时 - 统计
 */
public class HourLoginAndRegisterStatisticsJob extends BaseLoginAndRegisterStatisticsJob {
    @Override
    public int getStatPeriod() {
        return 2;
    }
}
