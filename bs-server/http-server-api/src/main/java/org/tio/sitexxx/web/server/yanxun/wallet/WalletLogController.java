package org.tio.sitexxx.web.server.yanxun.wallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.sitexxx.service.model.main.YxUserRecharge;
import org.tio.sitexxx.service.model.main.YxUserWallet;
import org.tio.sitexxx.service.model.main.YxUserWalletItem;
import org.tio.sitexxx.service.model.main.YxUserWithdraw;
import org.tio.sitexxx.service.service.yanxun.wallet.RechargeService;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletItemService;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletService;
import org.tio.sitexxx.service.service.yanxun.wallet.WithdrawService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

import java.util.HashMap;
import java.util.List;

@RequestPath(value = "/walletLog")
public class WalletLogController {

    private static Logger log = LoggerFactory.getLogger(WalletLogController.class);

    private static WalletItemService service = WalletItemService.ME;

    /**
     *
     *
     */
    public WalletLogController() {
    }

    /***
     * 查询钱包明细（分页）
     * @param request
     * @param pageSize
     * @param pageNum
     * @param sTime
     * @param eTime
     * @param mode
     * @param coinFlag
     * @return page
     * @throws Exception
     */
    @RequestPath(value = "/walletDetail")
    public Resp queryWalletDetail(HttpRequest request,Integer pageSize,Integer pageNum,String sTime,String eTime,Integer mode,Integer coinFlag)throws Exception{
        Integer uid = WebUtils.currUserId(request);
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(uid);
        if(yxUserWallet==null){
            return Resp.fail("用户未开户");
        }
        Ret ret = service.queryWalletLogPage(pageSize,pageNum,sTime,eTime,mode,coinFlag,uid);
        if(ret.isFail()){
            log.error("钱包明细获取失败：{}",RetUtils.getCode(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        Page<Record> records = (Page<Record>)RetUtils.getOkPage(ret);
        List<Record> list = records.getList();
        for(int i=0;i<list.size();i++){
            Integer anInt = list.get(i).getInt("bizid");
            Integer tableMode = list.get(i).getInt("mode");
            Record record = list.get(i);
            if(tableMode==1){
                YxUserRecharge yxUserRecharge = RechargeService.ME.queryById(anInt);
                list.set(i,record.set("status",yxUserRecharge.getStatus()));
                list.set(i,record.set("data", yxUserRecharge));
            }else if(tableMode==2){
                YxUserWithdraw yxUserWithdraw = WithdrawService.ME.queryById(anInt);
                list.set(i,record.set("status",yxUserWithdraw.getStatus()));
                list.set(i,record.set("data", yxUserWithdraw));
            }else {
                list.set(i,record.set("data", new HashMap<>()));
            }
            records.setList(list);
        }
        return Resp.ok(records);
    }


}
