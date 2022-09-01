package org.tio.sitexxx.web.server.yanxun.wallet;


import cn.hutool.core.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.YxAdminRecieverAccount;
import org.tio.sitexxx.service.model.main.YxUserRecharge;
import org.tio.sitexxx.service.model.main.YxUserWallet;
import org.tio.sitexxx.service.service.yanxun.utils.DateUtil;
import org.tio.sitexxx.service.service.yanxun.wallet.RechargeService;
import org.tio.sitexxx.service.service.yanxun.wallet.RecieverService;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequestPath(value = "/walletRecharge")
public class WalletRechargeController {

    private static Logger log = LoggerFactory.getLogger(WalletRechargeController.class);

    private static RechargeService service = RechargeService.ME;

    /**
     *
     *
     */
    public WalletRechargeController() {
    }

    /**
     * 充值请求
     * @param  recharge
     * @return boolean
     */
    @RequestPath(value = "/submitRecharge")
    public Resp submitRecharge(HttpRequest request, YxUserRecharge recharge) throws Exception{
        User user = WebUtils.currUser(request);
        if (user == null){
            return Resp.fail("未登录或登录超时");
        }
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(user.getId());
        if(yxUserWallet==null){
            return Resp.fail("用户未开户");
        }
        recharge.setUid(user.getId());
        recharge.setUnick(user.getNick());
        recharge.setSerial(new Date().getTime()+""+RandomUtil.randomInt());
        recharge.setStatus(1);
        Ret ret = service.save(recharge);
        if(ret.isFail()){
            log.error("提交充值请求失败：{}",RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getRetMsg(ret));
    }

    /**
     * 查询充值审核状态
     * @param  rechargeId 充值记录id
     * @return boolean
     */
    @RequestPath(value = "/findStatus")
    public Resp queryRechargeStatus(HttpRequest request,Integer rechargeId) throws Exception{
        Integer uid = WebUtils.currUserId(request);
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(uid);
        if(yxUserWallet==null){
            return Resp.fail("用户未开户");
        }
        YxUserRecharge yxUserRecharge = service.queryById(rechargeId);
        if(yxUserRecharge==null){
            return Resp.fail("充值记录不存在");
        }
        return Resp.ok(yxUserRecharge);
    }

    /**
     * 获取后台收款人
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/getRecieverAccount")
    public Resp findRechargeQRCode(HttpRequest request, Integer type) throws Exception{
        if (type == null){
            return Resp.fail("type为空");
        }
        if (type.intValue() < 1 || type.intValue() > 3){
            return Resp.fail("参数不合法");
        }
        Integer uid = WebUtils.currUserId(request);
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(uid);
        if(yxUserWallet==null){
            return Resp.fail("用户未开户");
        }
        List<YxAdminRecieverAccount> list = RecieverService.ME.findByType(type);
        if (list == null || list.size() == 0){
            return Resp.fail("暂不支付该支付方式，请更换收款方式");
        }
        int i = RandomUtil.randomInt(0, list.size());
        return Resp.ok(list.get(i));
    }
}
