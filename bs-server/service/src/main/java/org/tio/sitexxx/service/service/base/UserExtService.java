package org.tio.sitexxx.service.service.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.service.cache.CacheConfig;
import org.tio.sitexxx.service.cache.Caches;
import org.tio.sitexxx.service.model.main.UserExt;
import org.tio.utils.cache.CacheUtils;
import org.tio.utils.cache.FirsthandCreater;

import java.util.ArrayList;
import java.util.List;

public class UserExtService {

    public static String EXT_NAME_FIND_UID = "uidFind";

    public static String EXT_NAME_FIND_PHONE = "phoneFind";

    public static String EXT_NAME_FIND_EMAIL = "emailFind";

    public static String EXT_NAME_FIND_LOGINNAME = "loginNameFind";

    public static String EXT_NAME_ADD_GROUP = "groupAdd";

    public static String EXT_NAME_ADD_QRCODE = "qrcodeAdd";

    public static String EXT_NAME_ADD_CARD = "cardAdd";


    private static Logger log = LoggerFactory.getLogger(UserExtService.class);

    public static final UserExtService ME = new UserExtService();

    public List<UserExt> getUserExtListByUid(String uid){
        String key = ""+uid;
        ArrayList<UserExt> userExts = CacheUtils.get(Caches.getCache(CacheConfig.USER_EXT), key, true, new FirsthandCreater<ArrayList<UserExt>>() {
            @Override
            public ArrayList<UserExt> create() throws Exception {
                ArrayList<UserExt> userExts2 = (ArrayList<UserExt>) UserExt.dao.find("select * from user_ext where uid = ?", uid);
                boolean containsUidFind = false;
                boolean containsPhoneFind = false;
                boolean containsEmailFind = false;
                boolean containsLoginNameFind = false;
                boolean containsGroupAdd = false;
                boolean containsQrcodeAdd = false;
                boolean containsCardAdd = false;
                for (UserExt userExt : userExts2){
                    if (userExt.getExtName().equals(EXT_NAME_FIND_UID)){
                        containsUidFind = true;
                        continue;
                    }
                    if (userExt.getExtName().equals(EXT_NAME_FIND_PHONE)){
                        containsPhoneFind = true;
                        continue;
                    }
                    if (userExt.getExtName().equals(EXT_NAME_FIND_EMAIL)){
                        containsEmailFind = true;
                        continue;
                    }
                    if (userExt.getExtName().equals(EXT_NAME_FIND_LOGINNAME)){
                        containsLoginNameFind = true;
                        continue;
                    }
                    if (userExt.getExtName().equals(EXT_NAME_ADD_GROUP)){
                        containsGroupAdd = true;
                        continue;
                    }
                    if (userExt.getExtName().equals(EXT_NAME_ADD_QRCODE)){
                        containsQrcodeAdd = true;
                        continue;
                    }
                    if (userExt.getExtName().equals(EXT_NAME_ADD_CARD)){
                        containsCardAdd = true;
                        continue;
                    }
                }

                if (!containsUidFind){
                    userExts2.add(new UserExt(EXT_NAME_FIND_UID, "1"));
                }
                if (!containsPhoneFind){
                    userExts2.add(new UserExt(EXT_NAME_FIND_PHONE, "1"));
                }
                if (!containsEmailFind){
                    userExts2.add(new UserExt(EXT_NAME_FIND_EMAIL, "1"));
                }
                if (!containsLoginNameFind){
                    userExts2.add(new UserExt(EXT_NAME_FIND_LOGINNAME, "1"));
                }
                if (!containsGroupAdd){
                    userExts2.add(new UserExt(EXT_NAME_ADD_GROUP, "1"));
                }
                if (!containsQrcodeAdd){
                    userExts2.add(new UserExt(EXT_NAME_ADD_QRCODE, "1"));
                }
                if (!containsCardAdd){
                    userExts2.add(new UserExt(EXT_NAME_ADD_CARD, "1"));
                }
                return userExts2;
            }
        });
        return userExts;
    }

    public void notifyClear(String uid){
        Caches.getCache(CacheConfig.USER_EXT).remove(uid);
    }

    public void updateExt(Integer uid, String extName, String extValue){
        List<UserExt> userExtListByUid = getUserExtListByUid(String.valueOf(uid));
        for (UserExt ext : userExtListByUid){
            if (ext.getExtName().equals(extName) && ext.getId() != null){
                ext.setExtValue(extValue);
                ext.update();
                notifyClear(String.valueOf(uid));
                return;
            }
        }
        UserExt userExt = new UserExt();
        userExt.setUid(uid);
        userExt.setExtName(extName);
        userExt.setExtValue(extValue);
        userExt.save();
        notifyClear(String.valueOf(uid));
    }
}
