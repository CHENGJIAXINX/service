/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.service.tioim;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.stat.UserRegisterStat;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.jfinal.P;

import java.util.List;
import java.util.Objects;

/**
 * 统计管理
 *
 * @author xufei
 * 2020年5月16日 下午2:21:06
 */
public class TioStatService {

    private static Logger log = LoggerFactory.getLogger(TioStatService.class);

    public static final TioStatService me = new TioStatService();

    /**
     * 用户统计数据
     * TODO:XUFEI-未添加在线时长
     *
     * @param pageNumber
     * @param pageSize
     * @param searchkey
     * @return
     * @author xufei
     * 2020年6月28日 下午3:33:25
     */
    public Ret userStatList(Integer pageNumber, Integer pageSize, String searchkey) {
        if (pageNumber == null || pageNumber <= 0) {
            pageNumber = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 16;
        }
        Kv params = Kv.create();
        if (StrUtil.isNotBlank(searchkey)) {
            params.set("searchkey", "%" + searchkey + "%");
        }
        boolean allowOper = P.getBoolean("oper.open.flag", true);
        if (!allowOper) {
            params.set("noemail", Const.YesOrNo.YES);
        } else {
            params.set("email", Const.YesOrNo.YES);
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_STAT).getSqlPara("stat.userstatlist", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_STAT).paginate(pageNumber, pageSize, sqlPara);
        return RetUtils.okPage(records);
    }

    /**
     * 区域字典列表
     *
     * @return
     * @author xufei
     * 2020年7月23日 下午3:44:04
     */
    public Ret areadict() {
        List<Record> records = Db.use(MgConst.Db.TIO_SITE_STAT).find("SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex");
        return RetUtils.okList(records);
    }

    /**
     * 用户总登录次数
     *
     * @param uid
     * @return
     * @author xufei
     * 2020年7月23日 下午4:20:28
     */
    public Ret userLoginCount(Integer uid) {
        Integer count = Db.use(MgConst.Db.TIO_SITE_STAT).queryInt("select totalcount from user_time_login_stat where uid = ? and dayperiod = '-1'", uid);
        if (count == null || count < 0) {
            count = 0;
        }
        return RetUtils.okData(count);
    }

    /**
     * ip小的注册人数
     *
     * @param ip
     * @return
     * @author xufei
     * 2020年7月23日 下午4:39:39
     */
    public Ret ipRegisterCount(String ip) {
        Integer count = Db.use(MgConst.Db.TIO_SITE_STAT).queryInt("select regcount from user_register_stat where type = 2 and statbizstr = ?", ip);
        if (count == null || count < 0) {
            count = 0;
        }
        return RetUtils.okData(count);
    }

    /**
     * 区域注册人数
     *
     * @param province
     * @param city
     * @return
     * @author xufei
     * 2020年7月23日 下午4:40:55
     */
    public Ret areaRegisterCount(String province, String city) {
        Integer count = Db.use(MgConst.Db.TIO_SITE_STAT).queryInt("select bizcount from area_stat where province = ? and city = ?", province, city);
        if (count == null || count < 0) {
            count = 0;
        }
        return RetUtils.okData(count);
    }

    /**
     * 时间注册人数
     *
     * @param period
     * @return
     * @author xufei
     * 2020年7月23日 下午4:45:52
     */
    public Ret timeRegisterCount(String period) {
        Integer count = Db.use(MgConst.Db.TIO_SITE_STAT).queryInt("select regcount from user_register_stat where type = 1 and statbizstr = ?", period);
        if (count == null || count < 0) {
            count = 0;
        }
        return RetUtils.okData(count);
    }

    /**
     * 注册统计
     *
     * @param requestVo
     * @return
     */
    public Ret userRegisterStat(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.by("type", requestVo.getType());
        if (Objects.equals(String.valueOf(requestVo.getType()),String.valueOf( UserRegisterStat.Type.TIME))) {
            params.set("time", Const.YesOrNo.YES);
        } else {
            params.set("ip", Const.YesOrNo.YES);
            if (StrUtil.isBlank(requestVo.getOrder())) {
                requestVo.setOrder("regcount");
            }
            params.set("order", requestVo.getOrder());
            if (StrUtil.isNotBlank(requestVo.getProvince())) {
                params.set("province", requestVo.getProvince());
            }
            if (StrUtil.isNotBlank(requestVo.getCity())) {
                params.set("city", requestVo.getCity());
            }
        }
        if (StrUtil.isNotBlank(requestVo.getStartTime())) {
            params.set("starttime", requestVo.getStartTime());
        }
        if (StrUtil.isNotBlank(requestVo.getEndTime())) {
            params.set("endtime", requestVo.getEndTime());
        }
        if (StrUtil.isNotBlank(requestVo.getIp())) {
            params.set("searchip", requestVo.getIp());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_STAT).getSqlPara("stat.userRegistList", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_STAT).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }


    /**
     * 获取群组状态
     *
     * @param requestVo
     * @return
     */
    public Ret groupStat(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.by("type", requestVo.getType());
        if (StrUtil.isNotBlank(requestVo.getStartTime())) {
            params.set("starttime", requestVo.getStartTime());
        }
        if (StrUtil.isNotBlank(requestVo.getEndTime())) {
            params.set("endtime", requestVo.getEndTime());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_STAT).getSqlPara("stat.groupstat", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_STAT).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

    /**
     * 获取用户注册下的ip周期统计
     * @param requestVo
     * @return
     */
    public Ret userIpTimeRegisterStat(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        if (StrUtil.isBlank(requestVo.getOrder())) {
            requestVo.setOrder("statbizstr");
        }
        Kv params = Kv.by("ipid", requestVo.getId()).set("type", UserRegisterStat.Type.IP_TIME);
        if (StrUtil.isNotBlank(requestVo.getOrder())) {
            params.set("order", requestVo.getOrder());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_STAT).getSqlPara("stat.userIpTimeRegisterStat", params);
        Page<Record> records = Db.use(MgConst.Db.TIO_SITE_STAT).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(records);
    }

}
