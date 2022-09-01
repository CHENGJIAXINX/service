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
import org.tio.mg.service.model.mg.MgUser;
import org.tio.mg.service.service.atom.AbsAtom;
import org.tio.mg.service.service.atom.AbsTxAtom;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RechargeCheckVo;
import org.tio.mg.service.vo.RechargeRequestVo;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RechargeService {
    private static Logger log = LoggerFactory.getLogger(RechargeService.class);

    private static YxUserRecharge dao = new YxUserRecharge().dao();

    public static final RechargeService ME = new RechargeService();

    private static final String TABLE_NAME = "yx_user_recharge";

    private static WalletService walletService = WalletService.ME;


    public Ret queryRecharge(RechargeRequestVo rechargeRequestVo) {
        if (rechargeRequestVo.getPageNumber() == null || rechargeRequestVo.getPageNumber() < 1) {
            rechargeRequestVo.setPageNumber(1);
        }
        if (rechargeRequestVo.getPageSize() == null || rechargeRequestVo.getPageSize() < 1) {
            rechargeRequestVo.setPageSize(15);
        }
        Kv params = Kv.create();
        if (StrUtil.isNotBlank(rechargeRequestVo.getStartTime())) {
            params.set("starttime", rechargeRequestVo.getStartTime());
        }
        if (StrUtil.isNotBlank(rechargeRequestVo.getEndTime())) {
            params.set("endtime", rechargeRequestVo.getEndTime());
        }
        if (rechargeRequestVo.getStatus() != null) {
            params.set("status", rechargeRequestVo.getStatus());
        }
        if (rechargeRequestVo.getUid() != null) {
            params.set("uid", rechargeRequestVo.getUid());
        }
        if (StrUtil.isNotBlank(rechargeRequestVo.getNick())) {
            params.set("nick", rechargeRequestVo.getNick());
        }
        if (StrUtil.isNotBlank(rechargeRequestVo.getOrderNo())) {
            params.set("orderno", rechargeRequestVo.getOrderNo());
        }
        if (rechargeRequestVo.getPayType() != null) {
            params.set("paytype", rechargeRequestVo.getPayType());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("mgrecharge.rechargelist", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(rechargeRequestVo.getPageNumber(), rechargeRequestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /***
     * 通过id找到唯一记录
     * @param id
     * @return
     */
    public YxUserRecharge queryById(Integer id) {
        YxUserRecharge yxUserRecharge = dao.findById(id);
        return yxUserRecharge;
    }

    /***
     * 检测这条记录的状态是否和将要更改的一致
     * @param id
     * @param status
     * @return
     */
    public Ret isStatusSame(Integer id, Integer status) {
        if (id == null) {
            return RetUtils.failMsg("id不可为空");
        }
        if (status == null) {
            return RetUtils.failMsg("状态不可为空");
        }
        String sql = "select *  from " + TABLE_NAME + " where id=? and status>1";
//        Record first = Db.use(MgConst.Db.TIO_SITE_MAIN).findFirst(sql, id, status);
        YxUserRecharge first = dao.findFirst(sql, id);
        if (first != null) {
            return RetUtils.failMsg("不可重复审核");
        }
        return RetUtils.okOper();
    }

    /***
     * 审核该充值记录
     * @param mgUser
     * @return
     */
    public Ret check(MgUser mgUser, RechargeCheckVo rechargeCheckVo) throws SQLException {
        AbsAtom result = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                Ret ret = updateStatus(rechargeCheckVo.getId(), rechargeCheckVo.getStatus(), rechargeCheckVo.getNote(), mgUser.getId());
                if (ret.isFail()) {
                    this.msg = RetUtils.getRetMsg(ret);
                    return false;
                }
                YxUserRecharge yxUserRecharge = queryById(rechargeCheckVo.getId());
                if (yxUserRecharge == null) {
                    this.msg = "未找到充值记录";
                    return false;
                }
                Integer rechargeAmount = yxUserRecharge.getAmount();
                Integer amountdis = yxUserRecharge.getAmountdis();//预留
                YxUserWallet userWallet = walletService.queryByUid(rechargeCheckVo.getUid());
                Integer walletId = userWallet.getId();
                String reviewremark = yxUserRecharge.getReviewremark();
                String serial = yxUserRecharge.getSerial();

                Ret ret2 = walletService.modifyBalance(rechargeCheckVo.getStatus(), WalletDetailTypeNum.RECHARGE, 1, rechargeAmount, walletId, reviewremark, rechargeCheckVo.getId(), serial, false);
                if (ret2.isFail()) {
                    this.msg = RetUtils.getRetMsg(ret2);
                    return false;
                }

                this.msg = "充值审核成功";
                return true;
            }
        };
        boolean isRecharge = Db.use(MgConst.Db.TIO_SITE_MAIN).tx(result);
//        boolean ret = result.run();
        if (!isRecharge) {
            return RetUtils.failMsg(result.getMsg());
        }
        return RetUtils.okMsg(result.getMsg());
    }

    /***
     * 修改status
     * @param id
     * @param status
     * @return
     */
    public Ret updateStatus(Integer id, Integer status, String note, Integer mgUid) {
        int update = Db.use(MgConst.Db.TIO_SITE_MAIN).update("update " + TABLE_NAME + " set status = ? , reviewuid = ? , reviewremark = ? , reviewtime = current_timestamp() where id = ?", status, mgUid, note, id);
        if (update > 0) {
            return RetUtils.okMsg("审核成功");
        }
        return RetUtils.failMsg("审核失败");
    }

    /**
     * 充值
     *
     * @param mguid
     * @param money
     * @param uid
     * @return
     */
    public Ret recharge(Integer mguid, Integer money, Integer uid) {
        YxUserWallet userWallet = walletService.queryByUid(uid);
        if (userWallet == null) {
            return RetUtils.failMsg("当前用户未开户，不可充值");
        }
        AbsAtom result = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                Integer walletId = userWallet.getId();
                String serial = new Date().getTime() + "" + RandomUtil.randomInt();
                Ret ret = walletService.modifyBalance(null, WalletDetailTypeNum.BACKRECHARGE, 1, money, walletId, "后台充值-" + mguid, null, serial, false);
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
        return RetUtils.okMsg("充值成功");
    }

    public Ret rechargeStat(String stime, String etime) {
        Kv params = Kv.create().set("starttime", stime).set("endtime", etime);
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("mgrecharge.getstat", params);
        Record record = Db.use(MgConst.Db.TIO_SITE_MAIN).findFirst(sqlPara);
        Ret ret = Ret.create();
        if (record == null) {
            ret.set("sum", 0);
        } else {
            ret.set("sum", record.getInt("sumRecharge"));
        }
        return ret;
    }
}
