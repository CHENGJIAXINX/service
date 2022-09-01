/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.service.tioim;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.main.*;
import org.tio.mg.service.service.atom.AbsAtom;
import org.tio.mg.service.service.yxnxun.wallet.WalletService;
import org.tio.mg.service.utils.CommonUtils;
import org.tio.mg.service.utils.PeriodUtils;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.utils.UuidUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.jfinal.P;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * im用户管理
 *
 * @author xufei
 * 2020年5月16日 下午2:21:06
 */
public class TioUserService {

    private static Logger log = LoggerFactory.getLogger(TioUserService.class);

    public static final TioUserService me = new TioUserService();

    /**
     * 获取用户总数
     *
     * @param requestVo
     * @return
     */
    public Ret getUserCount(RequestVo requestVo) {
        String sql = "select count(1) from tio_site_main.user where 1 = 1";
        if (requestVo != null && StrUtil.isNotBlank(requestVo.getStartTime()) && StrUtil.isNotBlank(requestVo.getEndTime())) {
            sql += " and createtime >= '" + requestVo.getStartTime() + "'";
            sql += " and createtime < '" + requestVo.getEndTime() + "'";
        }
        sql += " order by createtime desc";
        Integer integer = Db.use(MgConst.Db.TIO_SITE_MAIN).queryInt(sql);
        return RetUtils.okData(integer);
    }

    /**
     * 用户列表数据
     *
     * @param requestVo
     * @return
     */
    public Ret list(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.create();
        if (!StrUtil.isEmpty(requestVo.getSearchKey())) {
            params.set("searchkey", "%" + requestVo.getSearchKey() + "%");
            params.set("searchid", requestVo.getSearchKey());
        }
        if (requestVo.getStatus() != null) {
            params.set("status", requestVo.getStatus());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("tiouser.list", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /**
     * @param uid
     * @return
     * @author xufei
     * 2020年7月29日 下午2:30:18
     */
    public Ret info(Integer uid) {
        Kv params = Kv.by("uid", uid);
        boolean allowOper = P.getBoolean("oper.open.flag", true);
        if (!allowOper) {
            params.set("noemail", Const.YesOrNo.YES);
        } else {
            params.set("email", Const.YesOrNo.YES);
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("tiouser.info", params);
        Record record = Db.use(MgConst.Db.TIO_SITE_MAIN).findFirst(sqlPara);
        return RetUtils.okData(record);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public Ret delUser(Integer id) {
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                // 1.删除用户表
                User user = User.dao.findById(id);
                if (user != null && !user.delete()) {
                    return false;
                }
                // 2.删除 user_base表
                UserBase userBase = UserBase.dao.findFirst("select * from user_base where uid = ?", user.getId());
                if (userBase != null && !userBase.delete()) {
                    return false;
                }
                // 3.删除ip_info表 ip_info
                IpInfo ipInfo = IpInfo.dao.findFirst("select * from ip_info where id = ?", user.getIpid());
                if (ipInfo != null && !ipInfo.delete()) {
                    return false;
                }
                // 4.删除 user_invite表
                UserInvite userInvite = UserInvite.dao.findFirst("select * from user_invite where invite_uid = ?", user.getId());
                if (userInvite != null && !userInvite.delete()) {
                    return false;
                }
                return true;
            }
        };
        boolean tx = Db.use(Const.Db.TIO_SITE_MAIN).tx(absAtom);
        if (!tx) {
            return RetUtils.failMsg(RetUtils.OPER_ERROR);
        }
        return RetUtils.okMsg(RetUtils.OPER_RIGHT);
    }

    /**
     * @param requestVo
     * @return
     */
    public Ret statList(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.create();
        DateTime dateTime = PeriodUtils.getDateByPeriod(requestVo.getSearchKey());
        params.set("starttime", DateUtil.beginOfDay(dateTime));
        params.set("endtime", DateUtil.endOfDay(dateTime));
        if (requestVo.getId() != null) {
            params.set("ipid", requestVo.getId());
        }
        boolean allowOper = P.getBoolean("oper.open.flag", true);
        if (!allowOper) {
            params.set("noemail", Const.YesOrNo.YES);
        } else {
            params.set("email", Const.YesOrNo.YES);
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("tiouser.statlist", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /**
     * @param uid
     * @return
     * @author xufei
     * 2020年6月28日 下午2:34:17
     */
    public Ret resetPwd(Integer uid) {
        if (uid == null) {
            log.error("用户id为空");
            return RetUtils.invalidParam();
        }
        User update = User.dao.findById(uid);
        if (update == null) {
            return RetUtils.failMsg("用户不存在");
        }
        String resetPwd = CommonUtils.getMd5Pwd( MgConst.MG_USER_DEFAULT_PWD);
//        String resetPwd = CommonUtils.getMd5Pwd(update.getLoginname(), MgConst.MG_USER_DEFAULT_PWD);
        update.setPwd(resetPwd);
        update.setPhonepwd(resetPwd);
        update.setUpdatetime(new Date());
        boolean b = update.update();
        if (!b) {
            return RetUtils.failOper();
        }
        return RetUtils.okOper();
    }

    /**
     * 禁用/启用
     *
     * @param uid
     * @param status
     * @return
     * @author xufei
     * 2020年6月28日 下午2:36:46
     */
    public Ret disable(Integer uid, Byte status) {
        if (uid == null) {
            return RetUtils.invalidParam();
        }
        User user = User.dao.findById(uid);
        if (user == null) {
            return RetUtils.failMsg("用户不存在");
        }
        if (Objects.equals(user.getStatus(), status)) {
            return RetUtils.okOper();
        }
        User update = new User();
        update.setId(user.getId());
        update.setStatus(status);
        boolean ret = update.update();
        if (!ret) {
            return RetUtils.failOper();
        }
        return RetUtils.okOper();
    }

    public Ret delMsgByUid(Integer uid) {
        String sql = "select * from wx_chat_items where uid = ? ";
        List<WxChatItems> wxChatItems = WxChatItems.dao.find(sql, uid);
        if (wxChatItems == null) {
            return RetUtils.failMsg("记录不存在");
        }
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                for (WxChatItems chatItems : wxChatItems) {
                    boolean clearMsg = clearChatItemMsg(chatItems.getId());
                    if (!clearMsg) {
                        return failRet("清空消息异常");
                    }
                    boolean startTx = TioChatService.me.chatuserStartMsg(chatItems.getUid(), chatItems.getBizid(), chatItems.getChatmode(), null);
                    if (!startTx) {
                        return failRet("修改起始消息异常");
                    }
                }

                return false;
            }
        };

        boolean tx = Db.use(Const.Db.TIO_SITE_MAIN).tx(absAtom);
        if (!tx) {
            return absAtom.getRetObj();
        }

        return RetUtils.okOper();
    }

    /**
     * 清空聊天会话-已调整
     * alter:去除本方法的锁，请上层加锁
     *
     * @param chatlinkmetaid
     * @return
     * @author xufei
     * 2020年2月3日 下午12:41:13
     */
    public boolean clearChatItemMsg(Long chatlinkmetaid) {
        if (chatlinkmetaid == null) {
            return false;
        }
        Kv params = Kv.by("id", chatlinkmetaid);
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("chat.clearChatItemMsg", params);
        int update = Db.use(Const.Db.TIO_SITE_MAIN).update(sqlPara);
        if (update <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 重置支付密码
     *
     * @param uid
     * @return
     */
    public Ret resetPayPwd(Integer uid) {
        if (uid == null) {
            return RetUtils.failMsg("用户id不可为空");
        }
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(uid);
        if (yxUserWallet == null) {
            return RetUtils.failMsg("用户未开户");
        }
        yxUserWallet.setPasswd(getMd5PayPwd());
        if (!yxUserWallet.update()) {
            return RetUtils.failMsg("重置失败");
        }
        return RetUtils.okMsg("重置成功，重置密码为：" + MgConst.MG_USER_DEFAULT_PWD);
    }

    private String getMd5PayPwd() {
        return SecureUtil.md5(MgConst.MG_USER_DEFAULT_PWD);
    }

    /**
     * 开通/关闭会员
     *
     * @param uid
     * @param vipLevel
     * @return
     */
    public Ret updateVipLevel(Integer uid, Integer vipLevel) {
        User user = User.dao.findById(uid);
        if (user != null) {
            user.setViplevel(vipLevel);
            boolean update = user.update();
            if (update) {
                return RetUtils.okOper();
            }
        }
        return RetUtils.failOper();
    }

    /**
     * 查询用户ip白名单
     *
     * @param requestVo
     * @return
     */
    public Ret queryIpWhite(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv param = Kv.create();
        if (requestVo.getUid() != null) {
            param.set("uid", requestVo.getUid());
        }
        if (!StrUtil.isEmpty(requestVo.getIp())) {
            param.set("ip", requestVo.getIp());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_MAIN).getSqlPara("tiouser.ipwhite", param);
        Page<Record> paginate = Db.use(MgConst.Db.TIO_SITE_MAIN).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(paginate);
    }

    /**
     * 推荐码注册用户
     *
     * @param clientIp
     * @param loginname
     * @param nick
     * @param password
     * @return
     */
    public Ret register(String clientIp, String loginname, String nick, String password) {
        // 先判断是否注册过
        User daoFirst = User.dao.findFirst("select * from user where loginname=?", loginname);
        if (daoFirst != null) {
            return RetUtils.failMsg("登录名已存在");
        }
        User user = new User();
        user.setLoginname(loginname);
        user.setPwd(CommonUtils.getMd5Pwd(password));
        user.setNick(nick);
        user.setAgreement("on");
        String itemAvatar = "";
        user.setAvatar(itemAvatar);
        IpInfo ipInfo = new IpInfo();
        ipInfo.setIp(clientIp);
        ipInfo.setTime(org.tio.mg.service.service.yxnxun.wallet.utils.DateUtil.format(org.tio.mg.service.service.yxnxun.wallet.utils.DateUtil.getCurrDate()));
        boolean ipSave = ipInfo.save();
        if (!ipSave) {
            return RetUtils.failMsg("ip保存失敗");
        }
        IpInfo ipIn = IpInfo.dao.findFirst("select * from ip_info where ip = ?", clientIp);
        user.setIpid(ipIn.getId());
        user.setIpInfo(ipIn);
        // 生成推荐码
        user.setInvitecode(UuidUtils.generateShortUuid());
        boolean save = user.save();
        if (save) {
            User first = User.dao.findFirst("select * from user where loginname=?", loginname);
            return RetUtils.okData(first);
        } else {
            return RetUtils.failMsg("添加失败");
        }
    }


}
