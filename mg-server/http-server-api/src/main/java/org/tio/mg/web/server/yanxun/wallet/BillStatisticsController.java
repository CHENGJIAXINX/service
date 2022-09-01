package org.tio.mg.web.server.yanxun.wallet;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.service.yxnxun.wallet.RechargeService;
import org.tio.mg.service.service.yxnxun.wallet.RedPacketService;
import org.tio.mg.service.service.yxnxun.wallet.TransAccountService;
import org.tio.mg.service.service.yxnxun.wallet.WithdrawService;
import org.tio.utils.resp.Resp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 账单统计的控制器
 */
@RequestPath("/bill")
public class BillStatisticsController {
    private static final Logger log = LoggerFactory.getLogger(BillStatisticsController.class);

    private RechargeService rechargeService = RechargeService.ME;
    private WithdrawService withdrawService = WithdrawService.ME;
    private RedPacketService redPacketService = RedPacketService.me;
    private TransAccountService transAccountService = TransAccountService.me;

    @RequestPath("/getBillStat")
    public Resp getBill(HttpRequest request) {
        JSONObject jsonObject = JSONObject.parseObject(request.getBodyString());
        String todayTime = DateUtil.format(new Date(), "yyyy-MM-dd");
        String startTime = todayTime;
        String endTime = todayTime;
        if (jsonObject != null) {
            String sTime = (String) jsonObject.get("startTime");
            String eTime = (String) jsonObject.get("endTime");
            if (!StrUtil.isEmpty(sTime) && !StrUtil.isEmpty(eTime)) {
                startTime = sTime;
                endTime = eTime;
            }
        }
        Ret rechargeRet = rechargeService.rechargeStat(startTime, endTime);
        Ret withdrawRet = withdrawService.withdrawStat(startTime, endTime);
        Ret redPacketRet = redPacketService.redPacketStat(startTime, endTime);
        Ret transAccountRet = transAccountService.transAccountStat(startTime, endTime);

        Map<String, Integer> result = new HashMap<>();
        if (rechargeRet != null) {
            result.put("rechargeTotal", rechargeRet.getInt("sum"));
        }
        if (withdrawRet != null) {
            result.put("withdrawTotal", withdrawRet.getInt("sum"));
            result.put("chargeTotal", withdrawRet.getInt("chargeSum"));
        }
        if (redPacketRet != null) {
            result.put("redPacketTotal", redPacketRet.getInt("sum"));
        }
        if (transAccountRet != null) {
            result.put("transAccountTotal", transAccountRet.getInt("sum"));
        }
        return Resp.ok(result);
    }
}
