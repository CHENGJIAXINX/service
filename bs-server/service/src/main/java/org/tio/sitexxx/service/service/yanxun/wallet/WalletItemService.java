package org.tio.sitexxx.service.service.yanxun.wallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.sitexxx.service.model.main.YxUserWalletItem;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.hutool.StrUtil;

public class WalletItemService {

    private static final  Logger log = LoggerFactory.getLogger(WalletItemService.class);

    public static final WalletItemService ME = new WalletItemService();

    private static final YxUserWalletItem dao = new YxUserWalletItem().dao();

    private static final String TABLE_NAME = "yx_user_wallet_item";
    public Ret queryWalletLogPage(Integer pageSize, Integer pageNum, String sTime, String eTime, Integer mode, Integer coinFlag, Integer uid) {
        if(pageSize==null)
            pageSize = 10;
        if (pageNum==null)
            pageNum = 1;
        Kv params = Kv.create();
        params.set("uid",uid);
        if (StrUtil.isNotBlank(sTime)) {
            params.set("stime", sTime);
        }
        if (StrUtil.isNotBlank(eTime)) {
            params.set("etime", eTime);
        }
        if (mode!=null && mode!=0) {
            params.set("mode", mode);
        }
        if (coinFlag!=null) {
            params.set("coinflag", coinFlag);
        }
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("walletitem.list", params);
        Page<Record> records = Db.use(Const.Db.TIO_SITE_MAIN).paginate(pageNum, pageSize, sqlPara);
        if (records==null) {
            return RetUtils.failMsg("无明细记录");
        }
        return RetUtils.okPage(records);
    }

//    if(pageNumber == null || pageNumber <= 0) {
//        pageNumber = 1;
//    }
//    Kv params = Kv.by("uid", uid);
//		if(mode != null) {
//        params.set("mode", mode);
//    }
//    SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("wallet.items", params);
//    Page<Record> rechargePage = Db.use(Const.Db.TIO_SITE_MAIN).paginate(pageNumber, 16, sqlPara);
//		return RetUtils.okPage(rechargePage);
}
