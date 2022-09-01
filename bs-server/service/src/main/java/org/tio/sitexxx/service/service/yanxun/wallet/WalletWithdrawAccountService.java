package org.tio.sitexxx.service.service.yanxun.wallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.model.main.YxUserWithdrawAccount;
import org.tio.sitexxx.service.utils.RetUtils;

import java.util.List;

public class WalletWithdrawAccountService {
    private static Logger log = LoggerFactory.getLogger(WalletWithdrawAccountService.class);

    public static final WalletWithdrawAccountService ME = new WalletWithdrawAccountService();

    private static final YxUserWithdrawAccount dao = new YxUserWithdrawAccount().dao();

    private static final String TABLE_NAME = "yx_user_withdraw_account";

    public Ret queryByUid(Integer uid) {
        String sql = "select * from "+TABLE_NAME+" where uid = ?";
        List<YxUserWithdrawAccount> yxUserWithdrawAccounts = dao.find(sql, uid);
        return RetUtils.okList(yxUserWithdrawAccounts);
    }

    public boolean update(YxUserWithdrawAccount account) {
        boolean update = account.update();
        return update;
    }

    public YxUserWithdrawAccount queryById(Integer id) {
        YxUserWithdrawAccount account = dao.findById(id);
        return account;
    }

    public boolean delById(Integer id) {
        boolean del = dao.deleteById(id);
        return del;
    }

    public boolean isMaxNum(Integer uid) {
        Ret ret = queryByUid(uid);
        List<YxUserWithdrawAccount> yxUserWithdrawAccounts = (List<YxUserWithdrawAccount>)RetUtils.getOkList(ret);
        if(yxUserWithdrawAccounts.size()>=20){
            return true;
        }
        return false;
    }
}
