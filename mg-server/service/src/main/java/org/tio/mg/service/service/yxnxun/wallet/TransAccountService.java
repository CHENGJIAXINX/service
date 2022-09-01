package org.tio.mg.service.service.yxnxun.wallet;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.main.YxTransAccounts;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.TransferVo;

public class TransAccountService {
    private final static Logger log = LoggerFactory.getLogger(TransAccountService.class);

    private static YxTransAccounts dao = new YxTransAccounts().dao();

    public static TransAccountService me = new TransAccountService();

    /**
     * 查询列表
     * @param transferVo
     * @return
     */
    public Ret queryList(TransferVo transferVo) {
        if (transferVo.getPageNumber() == null || transferVo.getPageNumber() < 1) {
            transferVo.setPageNumber(1);
        }
        if (transferVo.getPageSize() == null || transferVo.getPageSize() < 1) {
            transferVo.setPageSize(15);
        }
        Kv params = Kv.create();
        if (transferVo.getUid() != null) {
            params.set("uid", transferVo.getUid());
        }
        if (transferVo.getStatus() != null) {
            params.set("status", transferVo.getStatus());
        }
        if (!StrUtil.isEmpty(transferVo.getStartTime())) {
            params.set("starttime", transferVo.getStartTime());
        }
        if (!StrUtil.isEmpty(transferVo.getEndTime())) {
            params.set("endtime", transferVo.getEndTime());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("mgtransaccounts.gettranslist", params);
        Page<YxTransAccounts> paginate = dao.paginate(transferVo.getPageNumber(), transferVo.getPageSize(), sqlPara);
        if (paginate.getPageSize() > 0) {
            return RetUtils.okPage(paginate);
        }
        return null;
    }

    public Ret transAccountStat(String stime, String etime) {
        Kv params = Kv.create().set("stime", stime).set("etime", etime);
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("mgtransaccounts.getstat", params);
        Record record = Db.use(MgConst.Db.TIO_SITE_MAIN).findFirst(sqlPara);
        Ret ret = Ret.create();
        if (record == null) {
            ret.set("sum", 0);
        } else {
            ret.set("sum", record.getInt("sumAmount"));
        }
        return ret;
    }
}
