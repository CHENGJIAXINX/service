package org.tio.mg.service.service.yxnxun.wallet;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.main.YxUserRecharge;
import org.tio.mg.service.model.main.YxUserWallet;
import org.tio.mg.service.model.main.YxUserWithdraw;
import org.tio.mg.service.service.atom.AbsAtom;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.WithdrawRequestVo;

import java.sql.SQLException;
import java.util.Date;

public class WithdrawService {

    private static Logger log = LoggerFactory.getLogger(WithdrawService.class);

    private static YxUserWithdraw dao = new YxUserWithdraw().dao();

    public static final WithdrawService ME = new WithdrawService();

    private static final String TABLE_NAME = "yx_user_withdraw";

    private static WalletService walletService = WalletService.ME;


    public Ret queryWithdraw(WithdrawRequestVo withdrawRequestVo) {
        if (withdrawRequestVo.getPageNumber() == null || withdrawRequestVo.getPageNumber() < 1) {
            withdrawRequestVo.setPageNumber(1);
        }
        if (withdrawRequestVo.getPageSize() == null || withdrawRequestVo.getPageSize() < 1) {
            withdrawRequestVo.setPageSize(15);
        }
        Kv params = Kv.create();
        if (StrUtil.isNotBlank(withdrawRequestVo.getStartTime())) {
            params.set("starttime", withdrawRequestVo.getStartTime());
        }
        if (StrUtil.isNotBlank(withdrawRequestVo.getEndTime())) {
            params.set("endtime", withdrawRequestVo.getEndTime());
        }
        if (withdrawRequestVo.getStatus() != null) {
            params.set("status", withdrawRequestVo.getStatus());
        }
        if (withdrawRequestVo.getUid() != null) {
            params.set("uId", withdrawRequestVo.getUid());
        }
        if (StrUtil.isNotBlank(withdrawRequestVo.getNick())) {
            params.set("nick", withdrawRequestVo.getNick());
        }
        if (StrUtil.isNotBlank(withdrawRequestVo.getOrderNo())) {
            params.set("orderno", withdrawRequestVo.getOrderNo());
        }
        if (withdrawRequestVo.getPayType() != null) {
            params.set("paytype", withdrawRequestVo.getPayType());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("mgwithdraw.withdrawlist", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(withdrawRequestVo.getPageNumber(), withdrawRequestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /***
     * 通过id找到唯一记录
     * @param id
     * @return
     */
    public YxUserWithdraw queryById(Integer id) {
        YxUserWithdraw yxUserWithdraw = dao.findById(id);
        return yxUserWithdraw;
    }

    public Ret isStatusSame(Integer id, Integer status) {
        if (id == null)
            return RetUtils.failMsg("id不可为空");
        if (status == null)
            return RetUtils.failMsg("状态不可为空");
        String sql = "select * from " + TABLE_NAME + " where id=? and status>1";
        YxUserWithdraw first = dao.findFirst(sql, id);
        if (first != null) {
            return RetUtils.failMsg("不可重复审核");
        }
        return RetUtils.okOper();
    }

    public Ret check(Integer mgUid, Integer id, Integer uid, Integer status, String note) {
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                YxUserWithdraw yxUserWithdraw = queryById(id);
                if (yxUserWithdraw == null) {
                    this.msg = "未找到提现记录";
                    return false;
                }
                YxUserWallet userWallet = walletService.queryByUid(uid);
                Ret ret = updateStatus(id, status, note, mgUid);
                if (ret.isFail()) {
                    this.msg = RetUtils.getRetMsg(ret);
                    return false;
                }
                Ret ret2 = walletService.modifyBalance(status, WalletDetailTypeNum.WITHDRAW, 1, yxUserWithdraw.getAmountreal(), userWallet.getId(), note, yxUserWithdraw.getId(), yxUserWithdraw.getSerial(), false);
                if (ret2.isFail()) {
                    this.msg = RetUtils.getRetMsg(ret2);
                    return false;
                }

                this.msg = "提现审核成功";
                return true;
            }
        };
        boolean tx = Db.use(MgConst.Db.TIO_SITE_MAIN).tx(absAtom);
        if (!tx) {
            return RetUtils.failMsg(absAtom.getMsg());
        }
        return RetUtils.okMsg(absAtom.getMsg());
    }

    private Ret updateStatus(Integer id, Integer status, String note, Integer mgUid) {
        int update = Db.use(MgConst.Db.TIO_SITE_MAIN).update("update " + TABLE_NAME + " set status = ? , reviewuid = ? , reviewremark = ? , reviewtime = current_timestamp() where id = ?", status, mgUid, note, id);
        if (update > 0) {
            return RetUtils.okMsg("审核成功");
        }
        return RetUtils.failMsg("审核失败");
    }

    public Ret withdraw(Integer mguid, Integer money, Integer uid) {
        YxUserWallet userWallet = walletService.queryByUid(uid);
        if (userWallet == null) {
            return RetUtils.failMsg("当前用户未开户，不可扣款");
        }
        if (userWallet.getAmount() == 0 || userWallet.getAmount() < money) {
            return RetUtils.failMsg("用户余额不足以扣款");
        }
        AbsAtom result = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                Integer walletId = userWallet.getId();
                String serial = new Date().getTime() + "" + RandomUtil.randomInt();
                Ret ret = walletService.modifyBalance(null, WalletDetailTypeNum.BACKWITHDRAW, 1, money, walletId, "后台扣款-" + mguid, null, serial, false);
                if (ret.isFail()) {
                    this.msg = RetUtils.getRetMsg(ret);
                    return false;
                }
                return true;
            }
        };
        boolean tx = Db.use(MgConst.Db.TIO_SITE_MAIN).tx(result);
        if (!tx) {
            return RetUtils.failMsg(result.getMsg());
        }
        return RetUtils.okMsg("扣款成功");
    }

    public Ret withdrawStat(String stime, String etime) {
        Kv params = Kv.create().set("stime", stime).set("etime", etime);
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("mgwithdraw.getstat", params);
        Record record = Db.use(MgConst.Db.TIO_SITE_MAIN).findFirst(sqlPara);
        Ret ret = Ret.create();
        if (record == null) {
            ret.set("sum", 0);
            ret.set("chargeSum", 0);
        } else {
            ret.set("sum", record.getInt("sumWithdraw"));
            ret.set("chargeSum", record.getInt("sumCharge"));
        }
        return ret;
    }
}
