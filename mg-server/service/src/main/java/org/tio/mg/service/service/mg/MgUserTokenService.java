package org.tio.mg.service.service.mg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.mg.service.model.mg.MgUserToken;
import org.tio.mg.service.vo.MgConst;

import java.util.List;

/**
 * 后台用户token表
 */
public class MgUserTokenService {
    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(MgUserTokenService.class);
    public static final MgUserTokenService me = new MgUserTokenService();
    public static final MgUserToken dao = new MgUserToken().dao();

    /**
     * 获取后台用户的登录token
     *
     * @param devicetype
     * @param uid
     * @return
     */
    public MgUserToken find(int devicetype, int uid) {
        MgUserToken MgUserToken = dao.findFirst("select * from mg_user_token where devicetype=? and mguid=? limit 1", devicetype, uid);
        return MgUserToken;
    }

    /**
     * 获取后台用户的登录token列表
     *
     * @param uid
     * @return
     */
    public List<MgUserToken> find(int uid) {
        List<MgUserToken> list = dao.find("select * from mg_user_token where mguid=?", uid);
        return list;
    }

    /**
     * 删除已登录的token
     *
     * @param devicetype
     * @param uid
     */
    public int delete(int devicetype, int uid, String token) {
        return Db.use(MgConst.Db.TIO_MG).update("delete from mg_user_token where mguid=? and devicetype=? and token=?", uid, devicetype, token);
    }

    /**
     * 删除用户的所有token
     *
     * @param uid
     * @return
     */
    public int delete(int uid) {
        return Db.use(MgConst.Db.TIO_MG).update("delete from mg_user_token where mguid=?", uid);
    }

    /**
     * 新增token
     *
     * @param MgUserToken
     */
    public void add(MgUserToken MgUserToken) {
        MgUserToken.replaceSave();
    }

    /**
     * 修改token
     *
     * @param MgUserToken
     */
    public void update(MgUserToken MgUserToken) {
        MgUserToken.update();
    }
}
