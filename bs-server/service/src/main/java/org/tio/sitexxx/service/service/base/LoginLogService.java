/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.base;

import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.sitexxx.service.model.main.LoginLog;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.UserLastLoginTime;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.cache.CacheUtils;
import org.tio.utils.cache.FirsthandCreater;
import org.tio.utils.hutool.StrUtil;

/**
 * @author tanyaowu
 * 2016年9月15日 下午1:42:50
 */
public class LoginLogService {
    public static final LoginLogService me = new LoginLogService();
    public static final LoginLog dao = new LoginLog().dao();

    /**
     * @author: tanyaowu
     */
    public LoginLogService() {
    }

    /**
     * 通过uid 获取最近一条登录日志
     *
     * @param uid
     * @return
     */
    public LoginLog findByUid(Integer uid) {
        if (null == uid || uid < 0) {
            return null;
        }
        return dao.findFirst("select * from login_log where uid = ? order by time desc", uid);
    }

    public void add(LoginLog loginLog) {
        loginLog.save();
        //更新最近登录记录
        UserLastLoginTime lastLoginTime = new UserLastLoginTime();
        lastLoginTime.setUid(loginLog.getUid());
        lastLoginTime.replaceSave();
        UserService.ME.singleLoginInit(loginLog);
    }

    /**
     * 根据 sessionid获取最近一次登录日志信息
     *
     * @param sessionid
     * @return
     * @author tanyaowu
     */
    public LoginLog selectLastLoginLog(String sessionid) {
        if (StrUtil.isBlank(sessionid)) {
            return null;
        }

        String cacheKey = "login_log.sessionid." + sessionid;
        return CacheUtils.get(Const.CacheTime.SECOND_60, null, cacheKey, true, new FirsthandCreater<LoginLog>() {
            @Override
            public LoginLog create() {
                String sql = "SELECT * FROM `login_log` where sessionid = ? order by time desc LIMIT 0, 1";
                LoginLog ret = dao.findFirst(sql, sessionid);
                return ret;
            }
        });
    }

    /**
     * 根据 sessionid获取最近一次登录的用户
     *
     * @param sessionid
     * @return
     * @author tanyaowu
     */
    public User selectLastLoginUser(String sessionid) {
        LoginLog loginLog = selectLastLoginLog(sessionid);
        if (loginLog == null) {
            return null;
        }

        User user = UserService.ME.getById(loginLog.getUid());
        return user;
    }

    /**
     * 分页查询某用户的登录日志
     *
     * @param curr
     * @param uid        查询谁的登录日志
     * @param pageNumber
     * @return
     * @author tanyaowu
     */
    public Page<Record> page(User curr, Integer uid, Integer pageNumber) {
        boolean isSuper = UserService.isSuper(curr);
        if (!isSuper) { //非超管不能查别人的登录日志
            uid = curr.getId();
        }
        Integer pageSize = 10;
        Kv params = Kv.by("uid", uid);
        SqlPara sqlPara = User.dao.getSqlPara("user.pageLoginLog", params);
        Page<Record> page = Db.paginate(pageNumber, pageSize, sqlPara);
        return page;
    }

}
