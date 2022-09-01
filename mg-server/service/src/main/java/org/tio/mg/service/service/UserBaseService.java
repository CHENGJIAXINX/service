package org.tio.mg.service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.mg.service.cache.CacheConfig;
import org.tio.mg.service.cache.Caches;
import org.tio.mg.service.model.main.UserBase;
import org.tio.utils.cache.CacheUtils;
import org.tio.utils.cache.FirsthandCreater;
import org.tio.utils.cache.ICache;
import org.tio.utils.resp.Resp;

/**
 * 用户基础信息业务类
 */
public class UserBaseService {

    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(UserBaseService.class);

    public static final UserBaseService me = new UserBaseService();

    final UserBase userBaseDao = new UserBase().dao();

    /**
     * 用户基础信息-缓存
     *
     * @param uid
     * @return
     */
    public UserBase getUserBaseByUid(Integer uid) {
        ICache userbaseCache = Caches.getCache(CacheConfig.USERID_BASE);
        String key = uid + "";
        UserBase userBase1 = CacheUtils.get(userbaseCache, key, new FirsthandCreater<UserBase>() {
            @Override
            public UserBase create() {
                return userBaseDao.findFirst("select * from user_base where uid = ?", uid);
            }
        });
        return userBase1;
    }

    /**
     * 修改用户基础数据-清空缓存
     *
     * @param userBase
     * @return
     */
    public Resp updateBase(UserBase userBase) {
        boolean isUpdate = userBase.update();
        if (!isUpdate) {
            return Resp.fail("用户基础信息修改失败");
        }
        Caches.getCache(CacheConfig.USERID_BASE).remove(userBase.getUid() + "");
        return Resp.ok("用户修改成功.");
    }
}
