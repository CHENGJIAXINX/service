package org.tio.sitexxx.service.service.yanxun.onekeylogin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.service.model.main.YxOnekeyLoginTmp;

public class OneKeyLoginTempService {

    private static Logger log = LoggerFactory.getLogger(OneKeyLoginTempService.class);

    public static final OneKeyLoginTempService ME = new OneKeyLoginTempService();

    private static  YxOnekeyLoginTmp dao = new YxOnekeyLoginTmp().dao();

    private static final String TABLE_NAME = "yx_onekey_login_tmp";

    public YxOnekeyLoginTmp findByToken(String token) {
        String sql = "select * from "+TABLE_NAME+" where token = ?";
        return dao.findFirst(sql,token);
    }

    public YxOnekeyLoginTmp findById(Integer tokenId) {
        return dao.findById(tokenId);
    }
}
