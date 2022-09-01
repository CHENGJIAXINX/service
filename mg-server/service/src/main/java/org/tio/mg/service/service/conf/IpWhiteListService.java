package org.tio.mg.service.service.conf;

import cn.hutool.core.util.StrUtil;
import org.redisson.api.RTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.mg.service.init.RedisInit;
import org.tio.mg.service.model.conf.IpWhiteList;
import org.tio.mg.service.service.atom.AbsAtom;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.topic.TopicVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @author tanyaowu
 */
public class IpWhiteListService {
    private static Logger log = LoggerFactory.getLogger(IpWhiteListService.class);
    public static final IpWhiteListService me = new IpWhiteListService();
    final static IpWhiteList dao = new IpWhiteList().dao();
    /**
     * key: name, value: IpWhiteList
     */
    private static List<IpWhiteList> cacheData = null;

    /**
     * 是否在mg白名单ip中
     * @param ip
     * @return
     */
    public static boolean isWhiteIp(String ip) {
        return true;
    }

    public boolean save(String ip, String remark) {
        IpWhiteList ipWhiteList = new IpWhiteList();
        ipWhiteList.setIp(ip);
        ipWhiteList.setStatus((byte) 1);
        ipWhiteList.setRemark(remark);
        boolean ret = ipWhiteList.save();

        clearCache();
        RTopic topic = RedisInit.get().getTopic(Const.Topic.COMMON_TOPIC);
        TopicVo topicVo = new TopicVo();
        topicVo.setType(TopicVo.Type.CLEAR_IP_WHITE_LIST);
        topic.publishAsync(topicVo);
        return ret;
    }

    /**
     * 删除白名单
     *
     * @param id
     * @param remark
     * @return
     */
    public int delete(Integer id, String remark) {
//		int ret = Db.use(Const.Db.TIO_SITE_CONF).update("update ip_white_list set status = ?, remark = ? where id = ?", 2, remark, id);
        int ret = Db.use(Const.Db.TIO_SITE_CONF).delete("delete from ip_white_list  where id = ?", id);
        clearCache();
        RTopic topic = RedisInit.get().getTopic(Const.Topic.COMMON_TOPIC);
        TopicVo topicVo = new TopicVo();
        topicVo.setType(TopicVo.Type.CLEAR_IP_WHITE_LIST);
        topic.publishAsync(topicVo);
        return ret;
    }

    public static void clearCache() {
        synchronized (IpWhiteListService.class) {
            cacheData = null;
        }
    }

    private static void loadData() throws Exception {
        if (cacheData == null) {
            synchronized (IpWhiteListService.class) {
                if (cacheData == null) {
                    if (cacheData == null) {
                        cacheData = dao.find("select * from ip_white_list where status=1");
                    }
                }
            }
        }
    }

    /**
     * 是否是白名单ip
     *
     * @param ip
     * @return true: 是白名单ip
     */
    public static boolean isWhiteIp(Integer uid, String ip) {
        if (StrUtil.isBlank(ip)) {
            return false;
        }
        if (cacheData == null) {
            try {
                loadData();
            } catch (Exception e) {
                log.error(e.toString(), e);
            }
        }
        for (IpWhiteList ipWhiteList : cacheData) {
            if (ipWhiteList.getUid().intValue() == uid.intValue() && ip.equals(ipWhiteList.getIp())) {
                System.out.println("ipWhiteList.getUid().intValue()==>" + ipWhiteList.getUid().intValue());
                System.out.println("ipWhiteList.getIp()==>" + ipWhiteList.getIp());
                return true;
            }
        }
        return false;
    }

    public Ret saveIps(Integer uid, String[] ips) {
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                int i = 1;
                for (String ip : ips) {

                    boolean whiteIp = isWhiteIp(uid, ip);
                    if (whiteIp) {
                        return failRet("第" + i + "个ip已存在");
                    }
                    IpWhiteList whiteList = new IpWhiteList();
                    whiteList.setUid(uid);
                    whiteList.setIp(ip);
                    whiteList.setRemark("后台白名单放行");
                    boolean save = whiteList.save();
                    if (!save) {
                        return failRet("第" + i + "个ip添加失败");
                    }
                    i++;
                }
                return true;
            }
        };
        boolean tx = Db.use(MgConst.Db.TIO_SITE_CONF).tx(absAtom);
        if (!tx) {
            return RetUtils.failMsg(absAtom.getMsg());
        }
        return RetUtils.okOper();
    }
}
