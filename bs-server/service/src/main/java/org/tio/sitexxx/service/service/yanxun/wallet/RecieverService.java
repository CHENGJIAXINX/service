package org.tio.sitexxx.service.service.yanxun.wallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.model.main.YxAdminRecieverAccount;
import org.tio.sitexxx.service.model.main.YxUserRecharge;
import org.tio.sitexxx.service.utils.RetUtils;

import java.util.List;

public class RecieverService {

    private static Logger log = LoggerFactory.getLogger(RecieverService.class);

    private static YxAdminRecieverAccount dao = new YxAdminRecieverAccount().dao();

    public static final RecieverService ME = new RecieverService();

    private static final String TABLE_NAME = "yx_admin_reciever_account";

    public Ret findRecieverById(Integer id){
        YxAdminRecieverAccount reciever = dao.findById(id);
        return RetUtils.okData(reciever);
    }

    public Ret findAllByStatus(){
        String sql = "select * from "+TABLE_NAME+" where status=0";
        List<YxAdminRecieverAccount> list = dao.find(sql);
        return RetUtils.okList(list);
    }

    public List<YxAdminRecieverAccount> findByType(Integer type){
        String sql = "select * from "+TABLE_NAME+" where status = 0 and type="+type;
        List<YxAdminRecieverAccount> list = dao.find(sql);
        return list;
    }
}
