package org.tio.mg.service.service.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.conf.Website;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.utils.hutool.StrUtil;

import java.util.Date;
import java.util.List;

/**
 * 自定义网站服务
 */
public class MgWebsiteService {

    private static Logger log = LoggerFactory.getLogger(MgWebsiteService.class);

    public static final MgWebsiteService me = new MgWebsiteService();

    final static Website websitetDao = new Website().dao();

    public Ret add(Website mgWebsite) {
        if (mgWebsite.getSitename() == null) {
            return RetUtils.failMsg("sitename不能为空");
        }
        if (mgWebsite.getSiteurl() == null) {
            return RetUtils.failMsg("siteurl不能为空");
        }
        boolean save = mgWebsite.save();
        if (!save) {
            return RetUtils.failOper();
        }
        return RetUtils.okOper();
    }

    public Ret update(Website mgWebsite) {
        Website website = websitetDao.findById(mgWebsite.getId());
        if (website == null) {
            return RetUtils.failMsg("记录不存在");
        }
        if (mgWebsite.getSiteicon() != null) {
            website.setSiteicon(mgWebsite.getSiteicon());
        }
        if (mgWebsite.getSitename() != null) {
            website.setSitename(mgWebsite.getSitename());
        }
        if (mgWebsite.getSiteurl() != null) {
            website.setSiteurl(mgWebsite.getSiteurl());
        }
        website.setUpdatetime(new Date());
        if (website.update()) {
            return Ret.ok();
        }
        return Ret.fail();
    }

    /**
     * 列表查询
     *
     * @param requestVo
     * @return
     */
    public Ret queryList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.create();
        if (!StrUtil.isEmpty(requestVo.getSearchKey())) {
            params.set("searchkey", "%" + requestVo.getSearchKey() + "%");
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_CONF).getSqlPara("website.list", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_CONF).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    public List<Website> list() {
        return websitetDao.findAll();
    }

    public Ret del(Integer id) {
        boolean b = websitetDao.deleteById(id);
        return b ? RetUtils.okMsg("删除成功") : RetUtils.failMsg("删除失败");
    }
}
