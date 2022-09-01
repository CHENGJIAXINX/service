package org.tio.sitexxx.web.server.yanxun.wallet;

import cn.hutool.core.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.model.main.*;
import org.tio.sitexxx.service.service.yanxun.wallet.RecieverService;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletService;
import org.tio.sitexxx.service.service.yanxun.wallet.WithdrawService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequestPath(value = "/walletWithdraw")
public class WalletWithdrawController {

    private static Logger log = LoggerFactory.getLogger(WalletWithdrawController.class);

    private static WithdrawService service = WithdrawService.ME;

    /**
     *
     *
     */
    public WalletWithdrawController() {
    }

    /**
     * 提现请求
     * @param  withdraw
     * @return boolean
     */
    @RequestPath(value = "/submitWithdraw")
    public Resp submitWithdraw(HttpRequest request, YxUserWithdraw withdraw,String passwd, Long timestamp) throws Exception{
        User curr = WebUtils.currUser(request);
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(curr.getId());
        if(yxUserWallet==null){
            return Resp.fail("用户未开户");
        }
        withdraw.setUid(curr.getId());
        withdraw.setUnick(curr.getNick());
        withdraw.setSerial(new Date().getTime()+""+RandomUtil.randomInt());
        withdraw.setStatus(1);
        Ret ret = service.save(withdraw,passwd, timestamp);
        if(ret.isFail()){
            log.error("提现申请失败：{}",RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getRetMsg(ret));
    }

    /**
     * 查询提现审核状态
     * @param  withdrawId 提现记录id
     * @return boolean
     */
    @RequestPath(value = "/findStatus")
    public Resp queryWithdrawStatus(HttpRequest request,Integer withdrawId) throws Exception{
        Integer uid = WebUtils.currUserId(request);
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(uid);
        if(yxUserWallet==null){
            return Resp.fail("用户未开户");
        }
        YxUserWithdraw yxUserWithdraw = service.queryById(withdrawId);
        if(yxUserWithdraw==null){
            return Resp.fail("提现记录不存在");
        }
        return Resp.ok(yxUserWithdraw);
    }
}
