package org.tio.sitexxx.service.service.yanxun.wallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.service.model.main.YxUserRecharge;
import org.tio.sitexxx.service.model.main.YxUserWallet;
import org.tio.sitexxx.service.service.atom.AbsAtom;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.hutool.StrUtil;

import java.sql.SQLException;
import java.util.Date;


public class RechargeService {
    private static Logger log = LoggerFactory.getLogger(RechargeService.class);

    private static YxUserRecharge dao = new YxUserRecharge().dao();

    public static final RechargeService ME = new RechargeService();

    private static final String TABLE_NAME = "yx_user_recharge";

    private static WalletService walletService = WalletService.ME;

    
    /***
     * 通过id找到唯一记录
     * @param id
     * @return
     */
    public YxUserRecharge queryById(Integer id){
        YxUserRecharge yxUserRecharge = dao.findById(id);
        return yxUserRecharge;
    }


    public Ret save(YxUserRecharge recharge) {
        YxUserWallet yxUserWallet = walletService.queryByUid(recharge.getUid());
        if(StrUtil.isBlank(recharge.getUnick())){
            return RetUtils.failMsg("未添加名称");
        }
        if(recharge.getWalletid()==null){
            recharge.setWalletid(yxUserWallet.getId());
        }
        if(recharge.getAmount()==null){
            return RetUtils.failMsg("请填写充值金额");
        }
        Integer maxAmount = ConfService.getInt(Const.ConfMapping.WX_WALLET_RECHARGE_MAX_AMOUNT, 10000);
        System.out.println("当前充值金额："+recharge);
        if(recharge.getAmount() > maxAmount) {
            return RetUtils.failMsg("单次充值金额不超过" + maxAmount /100 + "元");
        }
//        if(!passwd.equals(yxUserWallet.getPasswd())){
//            return RetUtils.failMsg("支付密码错误");
//        }
        if(recharge.getAmountpay()==null){
            recharge.setAmountpay(recharge.getAmount());
        }
        if(recharge.getPaytype()==null){
            return RetUtils.failMsg("请填写充值方式");
        }
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                boolean save = recharge.save();
                if(!save){
                    this.msg = "充值申请失败";
                    return false;
                }
                Integer id = recharge.getId();
                String serial = recharge.getSerial();
                Integer rechargeAmount = recharge.getAmount();
                Integer paytype = recharge.getPaytype();
                String reviewremark = recharge.getReviewremark();
                Integer walletId = yxUserWallet.getId();
                long time = new Date().getTime();
                Ret ret = walletService.modifyBalance(WalletDetailTypeNum.RECHARGE, 1, rechargeAmount, walletId, null,time, "审核充值", id, serial, true);
                if(ret.isFail()){
                    this.msg = RetUtils.getRetMsg(ret);
                    return false;
                }
                return true;
            }
        };
        boolean tx = Db.use(Const.Db.TIO_SITE_MAIN).tx(absAtom);
        if(!tx){
            return RetUtils.failMsg(absAtom.getMsg());
        }
//        boolean save = recharge.save();
//        if (!save){
//            return RetUtils.failMsg("充值申请失败");
//        }
        return RetUtils.okMsg("充值申请成功");
    }
}
