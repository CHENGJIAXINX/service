package org.tio.mg.service.service.yxnxun.word;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.conf.SensitiveWordsList;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;

public class WordService {
    private static Logger log = LoggerFactory.getLogger(WordService.class);

    private static final String TABLE_NAME = "sensitive_words_list";

    public static final WordService ME = new WordService();

    private static final SensitiveWordsList dao = new SensitiveWordsList().dao();

    public Ret add(SensitiveWordsList sensitiveWordsList) {
        if (sensitiveWordsList == null) {
            return RetUtils.invalidParam();
        }
        boolean save = sensitiveWordsList.save();
        if (save) {
            return Ret.ok();
        }
        return Ret.fail();
    }

    public Ret del(Integer id) {
        boolean b = dao.deleteById(id);
        if (b) {
            return Ret.ok();
        }
        return Ret.fail();
    }

    public Ret update(SensitiveWordsList sensitiveWordsList){
        boolean b = sensitiveWordsList.update();
        if (b) {
            return Ret.ok();
        }
        return Ret.fail();
    }

    /**
     * 敏感词查询
     *
     * @param requestVo
     * @return
     */
    public Ret query(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv kv = Kv.create();
        if (requestVo.getStatus() != null) {
            kv.put("status", requestVo.getStatus());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_CONF).getSqlPara("mgwords.word", kv);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_CONF).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }
}
