package org.tio.sitexxx.service.service.yanxun.wallet;

import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.model.main.YxUserWallet;
import org.tio.sitexxx.service.model.main.YxUserWalletItem;
import org.tio.sitexxx.service.utils.MD5Utils;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;

public class WalletService {

    private static Logger log = LoggerFactory.getLogger(WalletService.class);

    public static final WalletService ME = new WalletService();

    private static final String TABLE_NAME = "yx_user_wallet";

    private static final YxUserWallet dao = new YxUserWallet().dao();

    /***
     * {！！！！该处不可使用事务，需要外层使用事务}
     * 修改钱包金额增加余额明细
     * @param mode 支出收入方式 类型：3：提现 11：微信扫码充值 ，12微信sdk 13微信提现 21：支付宝扫码充值，22支付宝sdk,23支付宝提现；31：发红包，32：抢红包 33：红包退回；4：消费；5：退款 6：转账 7:银行卡提现
     * @param coinFlag 支出或收入 收支：1 支出：2
     * @param money 操作的钱
     * @param id 钱包id
     * @param passwd 钱包支付密码
     * @param timestamp 传支付密码时，必须要传时间戳
     * @param remark 备注
     * @param bizId 业务编号
     * @param bizNumber 业务流水号
     * @param checkFreeze 是否要验证冻结状态
     * @return
     */
    public Ret modifyBalance(WalletDetailTypeNum mode, Integer coinFlag, Integer money, Integer id, String passwd, Long timestamp, @NotNull String remark, Integer bizId, String bizNumber, boolean checkFreeze){
        if (remark == null || remark.equals("")){
            return RetUtils.failMsg("remark不能为空");
        }

        YxUserWallet yxUserWallet = dao.findById(id);
        if(yxUserWallet==null) {
            return RetUtils.failMsg("用户未开户");
        }
        if (checkFreeze && yxUserWallet.getStatus().intValue() == 1){
            return RetUtils.failMsg("账户冻结");
        }
        if (passwd != null){
            if (timestamp == null){
                return RetUtils.failMsg("缺少时间戳");
            }
            if (!checkPayPwd(passwd, timestamp, yxUserWallet.getPasswd())){
                return RetUtils.failMsg("支付密码错误");
            }
        }
        Integer walletAmount = yxUserWallet.getAmount();
        Integer blockamount = yxUserWallet.getBlockamount();
        if(mode == WalletDetailTypeNum.RECHARGE || mode == WalletDetailTypeNum.WITHDRAW){
            if(mode == WalletDetailTypeNum.WITHDRAW ){
                walletAmount = walletAmount-money;
                if (walletAmount < 0){
                    return RetUtils.failMsg("余额不足");
                }
            }
            blockamount = blockamount + money;
        }else{
            if (coinFlag==1){
                walletAmount = walletAmount+money;
            }else {
                walletAmount = walletAmount-money;
                if (walletAmount < 0){
                    return RetUtils.failMsg("余额不足");
                }
            }
        }

        yxUserWallet.setAmount(walletAmount);
        yxUserWallet.setBlockamount(blockamount);
        Ret ret = updateMoney(yxUserWallet);
        if(ret.isFail()){
            return RetUtils.failMsg(RetUtils.getRetMsg(ret));
        }
        YxUserWalletItem item = new YxUserWalletItem();
        item.setUid(yxUserWallet.getUid());
        item.setAmount(money);
        item.setAmountall(walletAmount);
        item.setCoinflag(coinFlag);
        item.setMode(mode.getMode());
        item.setBizid(bizId);
        item.setBiznumber(bizNumber);
        item.setRemark(remark);
        item.setWalletid(yxUserWallet.getId());
        boolean save = item.save();
        if(!save){
            return RetUtils.failMsg("余额明细保存失败");
        }
        return RetUtils.okMsg("余额修改成功");
    }

    /***
     *
     * @param bean
     * @return
     */
    public Ret updateMoney(YxUserWallet bean){
        boolean update = bean.update();
        if(!update){
            return RetUtils.failMsg("余额操作失败");
        }
        return RetUtils.okOper();
    }

    /***
     * 根据uid查找唯一用户
     * @param uid
     * @return
     */
    public YxUserWallet queryByUid(Integer uid){
        YxUserWallet userWallet = dao.findFirst("select * from yx_user_wallet where uid = ?", uid);
        return userWallet;
    }

    /**
     * 验证密码是否正确
     * @param pwd 第一次md5后的密码
     * @param timestamp 传上来的时间戳
     */
    public boolean checkPayPwd(String pwd, Long timestamp, String dbPwd){
        return pwd.equals(getMd5Pwd(timestamp, dbPwd));
    }

    public String getMd5Pwd(Long timestamp, String dbPwd){
        return MD5Utils.getMd5(dbPwd + timestamp + Const.HANDSHAKE_KEY);
    }


    public YxUserWallet open(Integer uid, String pwd){
        YxUserWallet userWallet = new YxUserWallet();
        userWallet.setUid(uid);
        userWallet.setPasswd(pwd);
        if (userWallet.save()){
            return queryByUid(uid);
        }
        return null;
    }
}
