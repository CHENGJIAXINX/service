package org.tio.mg.service.timetask;

/**
 * Author: zlb
 * Date: 2021/8/19
 * desc:
 */
public class MiniteLoginAndRegisterStatisticsJob extends BaseLoginAndRegisterStatisticsJob {
    @Override
    public int getStatPeriod() {
        return 1;
    }
}
