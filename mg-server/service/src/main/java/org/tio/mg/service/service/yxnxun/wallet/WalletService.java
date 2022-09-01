package org.tio.mg.service.service.yxnxun.wallet;

import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.mg.service.model.main.YxUserWallet;
import org.tio.mg.service.model.main.YxUserWalletItem;
import org.tio.mg.service.service.yxnxun.wallet.utils.DateUtil;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;

import java.util.Date;
import java.util.List;

public class WalletService {

    private static Logger log = LoggerFactory.getLogger(WalletService.class);

    public static final WalletService ME = new WalletService();

    private static final String TABLE_NAME = "yx_user_wallet";

    private static final YxUserWallet dao = new YxUserWallet().dao();

    /***
     * 获取所有钱包用户列表
     * @return
     */
    public Ret queryList(){
        List<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).find("select * from " +TABLE_NAME);
        if(records.isEmpty()){
            return RetUtils.failMsg("钱包用户列表为空");
        }
        return RetUtils.okList(records);

    }

    public Ret modifyBalance(Integer status ,WalletDetailTypeNum mode, Integer coinFlag, Integer money, Integer id, @NotNull String remark, Integer bizId, String bizNumber, boolean checkFreeze){
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
        Integer walletAmount = yxUserWallet.getAmount();
        Integer blockamount = yxUserWallet.getBlockamount();
        boolean isAddItemFlag = false;
        switch (mode){
            case RECHARGE:
                if (status != 4) {
                    walletAmount = walletAmount + money;
                }
                blockamount = blockamount - money;
                break;
            case WITHDRAW:
                if(status == 4){
                    walletAmount = walletAmount + money;
                }
                blockamount = blockamount - money;
                break;
            case BACKRECHARGE:
                walletAmount = walletAmount + money;
                isAddItemFlag = true;
                break;
            case BACKWITHDRAW:
                walletAmount = walletAmount - money;
                isAddItemFlag = true;
                break;
        }
        yxUserWallet.setAmount(walletAmount);
        yxUserWallet.setBlockamount(blockamount);
        Ret ret = updateMoney(yxUserWallet);
        if(ret.isFail()){
            return RetUtils.failMsg(RetUtils.getRetMsg(ret));
        }
        if(isAddItemFlag){
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
        }
        return RetUtils.okMsg("余额修改成功");
    }

    /***
     * 根据uid查找唯一用户
     * @param uid
     * @return
     */
    public YxUserWallet queryByUid(Integer uid){
        YxUserWallet userWallet = dao.findFirst("select * from "+TABLE_NAME+" where uid = ?",uid);
        return userWallet;
    }

    /***
     * 根据时间段查找用户
     * @param sTime
     * @param eTime
     * @return
     */
    public Ret queryListByTime(Date sTime, Date eTime) {
        List<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).find("select * from " +TABLE_NAME+" t where createtime between ? and ?",sTime,eTime);
        if(records.isEmpty()){
            return RetUtils.failMsg("未查询到"+sTime+"--"+eTime+"的用户");
        }
        return RetUtils.okList(records);
    }

    /***
     * 冻结用户 修改status状态
     * @param uid
     * @param status
     * @return
     */
    public Ret updateStatusByUid(Integer uid, Integer status) {
        if(uid==null){
            return RetUtils.failMsg("用户id不可为空");
        }
        if(status==null){
            return RetUtils.failMsg("状态不可为空");
        }
        String sql = "update "+TABLE_NAME+" set status = ? where uid = ?";
        int update = Db.use(MgConst.Db.TIO_SITE_MAIN).update(sql, status, uid);
        if(update>0){
            return RetUtils.okMsg("账户冻结成功");
        }
        return RetUtils.failMsg("账户冻结失败");
    }

    /***
     * 修改余额
     * @param userWallet
     * @return
     */
    public Ret updateMoney(YxUserWallet userWallet) {
        if(userWallet==null){
            return RetUtils.failMsg("钱包未开通");
        }
        boolean update = userWallet.update();
        if(!update){
            return RetUtils.okMsg("余额操作失败");
        }
        return RetUtils.okMsg("余额操作成功");
    }
}
