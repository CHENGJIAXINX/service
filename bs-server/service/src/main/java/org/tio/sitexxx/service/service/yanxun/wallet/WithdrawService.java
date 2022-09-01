package org.tio.sitexxx.service.service.yanxun.wallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.service.model.main.YxUserWallet;
import org.tio.sitexxx.service.model.main.YxUserWithdraw;
import org.tio.sitexxx.service.service.atom.AbsAtom;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.resp.Resp;

import java.sql.SQLException;

public class WithdrawService {

    private static Logger log = LoggerFactory.getLogger(WithdrawService.class);

    private static YxUserWithdraw dao = new YxUserWithdraw().dao();

    public static final WithdrawService ME = new WithdrawService();

    private static final String TABLE_NAME = "yx_user_recharge";

    private static WalletService walletService = WalletService.ME;



    public Ret save(YxUserWithdraw withdraw,String passwd, Long timestamp) {
        YxUserWallet yxUserWallet = walletService.queryByUid(withdraw.getUid());
        if(withdraw.getAmountreal()==null){
            return RetUtils.failMsg("请填写提现金额");
        }
        Integer minAmount = ConfService.getInt(Const.ConfMapping.WX_WALLET_WITHHOLD_MIN_AMOUT, 10000);
        if(withdraw.getAmountreal() < minAmount) {
            return RetUtils.failMsg("单次提现金额不低于" + minAmount /100 + "元");
        }

        Integer maxAmount = ConfService.getInt(Const.ConfMapping.WX_WALLET_WITHHOLD_MAX_AMOUNT, 10000);
        if(withdraw.getAmountreal() > maxAmount) {
            return RetUtils.failMsg("单次提现金额不超过" + minAmount /100 + "元");
        }
        if(yxUserWallet.getAmount()<withdraw.getAmountreal()){
            return RetUtils.failMsg("余额不足");
        }
        if(StrUtil.isBlank(withdraw.getUnick())){
            return RetUtils.failMsg("未添加名称");
        }
        if(withdraw.getWalletid()==null){

            withdraw.setWalletid(yxUserWallet.getId());
        }
        if(withdraw.getAmountacount()==null){
            withdraw.setAmountacount(yxUserWallet.getAmount());
        }
        if(withdraw.getAmountcommission()==null){
            withdraw.setAmountcommission(0);
        }
        if(withdraw.getAmountall()==null){
            withdraw.setAmountall(withdraw.getAmountall());
        }
        if(withdraw.getWithdrawacountid()==null){
            return RetUtils.failMsg("请填写收款方式");
        }
//        if(withdraw.getWithdrawremark()==null){
//            return RetUtils.failMsg("未填写收款人信息");
//        }
        withdraw.setAmountall(withdraw.getAmountreal());

        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                boolean save = withdraw.save();
                if(!save){
                    this.msg = "提现申请失败";
                    return false;
                }
                Integer id = withdraw.getId();
                Integer accountid = withdraw.getWithdrawacountid();
                Integer amountreal = withdraw.getAmountreal();
                Integer walletId = yxUserWallet.getId();
                String reviewremark = withdraw.getReviewremark();
                String serial = withdraw.getSerial();
                Ret ret = walletService.modifyBalance(WalletDetailTypeNum.WITHDRAW,2, amountreal, walletId, passwd,  timestamp, "审核提现", id, serial, true);
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
        return RetUtils.okMsg("提现申请成功");
    }

    private YxUserWithdraw queryBySerial(String serial) {
        String sql = "select * from "+TABLE_NAME+" where serial=?";
        YxUserWithdraw first = dao.findFirst(sql, serial);
        return first;
    }

    public YxUserWithdraw queryById(Integer withdrawId) {
        return dao.findById(withdrawId);
    }
}
