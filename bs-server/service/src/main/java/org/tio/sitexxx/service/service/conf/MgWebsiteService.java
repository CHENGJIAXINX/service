package org.tio.sitexxx.service.service.conf;

import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.cache.CacheConfig;
import org.tio.sitexxx.service.cache.Caches;
import org.tio.sitexxx.service.model.conf.EmailServer;
import org.tio.sitexxx.service.model.conf.Website;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.utils.cache.CacheUtils;
import org.tio.utils.cache.FirsthandCreater;
import org.tio.utils.cache.ICache;

import java.util.ArrayList;
import java.util.List;

public class MgWebsiteService {


    public static final MgWebsiteService me = new MgWebsiteService();

    final static Website websitetDao = new Website().dao();

    public Ret add(Website mgWebsite){
        if (mgWebsite.getSitename() == null){
            return RetUtils.failMsg("sitename不能为空");
        }
        if (mgWebsite.getSiteurl() == null){
            return RetUtils.failMsg("siteurl不能为空");
        }
        boolean save = mgWebsite.save();
        if(!save) {
            return RetUtils.failOper();
        }
        return RetUtils.okOper();
    }

    public List<Website> list(){
//        ICache cache = Caches.getCache(CacheConfig.WEBSITE);
//        String key = "website";
//        ArrayList<Website> list = CacheUtils.get(cache, key, true, new FirsthandCreater<ArrayList<Website>>() {
//            @Override
//            public ArrayList<Website> create() {
//                ArrayList<Website> list = (ArrayList<Website>) websitetDao.findAll();
//                return list;
//            }
//        });
//        return list;
        return websitetDao.findAll();
    }

    public Ret del(Integer id){
        boolean b = websitetDao.deleteById(id);
        return b ? RetUtils.okMsg("删除成功") : RetUtils.failMsg("删除失败");
    }
}
