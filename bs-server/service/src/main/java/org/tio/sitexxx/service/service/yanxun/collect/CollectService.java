package org.tio.sitexxx.service.service.yanxun.collect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.service.model.main.YxCollect;

import java.util.List;

public class CollectService {

    private static Logger log = LoggerFactory.getLogger(CollectService.class);

    public static final CollectService me = new CollectService();

    private static final YxCollect dao = new YxCollect().dao();

    private static final String TABLE_NAME = "yx_collect";

    public List<YxCollect> queryList(int type, int userId){
        return dao.find("select * from " + TABLE_NAME + " t where t.user_id = ? and t.collect_type = ?",userId,type);
    }

    public void deleteCollect(int id){
        dao.deleteById(id);
    }
}
