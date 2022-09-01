package org.tio.sitexxx.service.service.yanxun.trans;

import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.YxTransAccounts;
import org.tio.sitexxx.service.model.main.YxUserWallet;
import org.tio.sitexxx.service.service.atom.AbsAtom;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletDetailTypeNum;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.wx.TransAmountVo;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

import java.sql.SQLException;

public class TransAccountService {

    public static final TransAccountService ME = new TransAccountService();
    private static YxTransAccounts dao = new YxTransAccounts().dao();

    public Resp payPasswd(User user, String passwd, String serial, Long timestamp){
        if (user == null){
            return Resp.fail("未登录用户");
        }
        YxTransAccounts yxTransAccount = dao.findFirst("select * from yx_trans_accounts where serial = ?", serial);
        if (yxTransAccount == null){
            return Resp.fail("订单不存在");
        }
        if (yxTransAccount.getFromUid().intValue() != user.getId().intValue()){
            return Resp.fail("Serial不对应");
        }
        if (yxTransAccount.getStatus() != 0){
            return Resp.fail("不正确的状态，不能支付");
        }
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(user.getId());
        if (yxUserWallet == null){
            return Resp.fail("未开户");
        }
        String[] txMsg = new String[1];
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                Ret payRet = WalletService.ME.modifyBalance(WalletDetailTypeNum.TRANS, 2, yxTransAccount.getAmount(),
                        yxUserWallet.getId(), passwd, timestamp, "转账支出", yxTransAccount.getId(), yxTransAccount.getSerial(), true);

                if (payRet.isFail()){
                    txMsg[0] = RetUtils.getRetMsg(payRet);
                    return false;
                }
                yxTransAccount.setStatus(1);
                if (yxTransAccount.update()){
                    return true;
                }
                txMsg[0] = "转账失败";
                return false;
            }
        };
        boolean tx = Db.use(Const.Db.TIO_SITE_MAIN).tx(absAtom);
        if (!tx){
            return Resp.fail(txMsg[0]);
        }
        return Resp.ok(yxTransAccount);
    }
}
