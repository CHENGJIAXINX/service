/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.mg.service.service.stat;

import java.util.Date;
import java.util.List;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.mg.service.cache.CacheConfig;
import org.tio.mg.service.model.main.IpInfo;
import org.tio.mg.service.model.main.TioThreadLogs;
import org.tio.mg.service.model.main.User;
import org.tio.mg.service.model.stat.AreaStat;
import org.tio.mg.service.model.stat.TioIpPathAccessStat;
import org.tio.mg.service.model.stat.UserRegisterStat;
import org.tio.mg.service.utils.QueryUtils;
import org.tio.sitexxx.servicecommon.utils.PyUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.Threads;

/**
 * @author tanyaowu
 *
 */
public class StatService {

	private static Logger log = LoggerFactory.getLogger(StatService.class);

	public static final StatService me = new StatService();

	final TioIpPathAccessStat dao = new TioIpPathAccessStat().dao();

	private static final int MAX_STAT_DAY = 60;

	/**
	 *  -- 按天统计页面的访问量
		---------------------------
		--     d              path        count
		-- 2018-04-16   /case/index.html	 24
		-- 2018-04-16   /case/index.html	 109
		-- 2018-04-16   /doc/index.html	     18
		-- 2018-04-17   /doc/index.html	     97
		---------------------------
	 * @param days 统计多少天的
	 * @return
	 */
	public List<Record> requestCountByDay(Integer days) {
		if (days == null) {
			days = 7;
		} else {
			if (days > MAX_STAT_DAY) {
				days = MAX_STAT_DAY;
			}
			if (days < 0) {
				days = 7;
			}
		}

		String cacheKey = "stat.requestCountByDay_" + days;
		return QueryUtils.findWithCache(CacheConfig.MG_TIME_TO_LIVE_MINUTE_5, cacheKey, Const.Db.TIO_SITE_STAT, "stat.requestCountByDay", true, days);

	}

	/**
	 *  -- 按天统计不同的ip数
		---------------------------
		--    d         |  count
		-- 2018-04-16	|  35
		-- 2018-04-17	|  222
		---------------------------
	 * @param days
	 * @return
	 */
	public List<Record> ipCountByDay(Integer days) {
		if (days == null) {
			days = 7;
		} else {
			if (days > MAX_STAT_DAY) {
				days = MAX_STAT_DAY;
			}
			if (days < 0) {
				days = 7;
			}
		}

		String cacheKey = "stat.ipCountByDay_" + days;
		return QueryUtils.findWithCache(CacheConfig.MG_TIME_TO_LIVE_MINUTE_5, cacheKey, Const.Db.TIO_SITE_STAT, "stat.ipCountByDay", true, days);

		//		ICache cache = Caches.getCache(CacheConfig.MG_TIME_TO_LIVE_MINUTE_5);
		//		Object obj = cache.get(cacheKey);
		//		if (obj != null) {
		//			return (List<Record>) obj;
		//		}
		//
		//		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_STAT).getSqlPara("stat.ipCountByDay");
		//		sqlPara.addPara(days);
		//		List<Record> list = Db.use(Const.Db.TIO_SITE_STAT).find(sqlPara);
		//
		//		if (list == null) {
		//			list = new ArrayList<>(0);
		//		}
		//
		//		cache.put(cacheKey, (Serializable) list);
		//		return list;
	}

	/**
	 * -- 按省统计点击量
		---------------------------------------------
		--  hitcount | ipcount      |  province
		--  6565     |   545	    |  浙江省
		--  5443     |   434	    |  湖南省
		---------------------------------------------
	 * @param days
	 * @return
	 */
	public List<Record> statIpAndHitsByProvince(Integer days) {
		if (days == null) {
			days = 7;
		} else {
			if (days > MAX_STAT_DAY) {
				days = MAX_STAT_DAY;
			}
			if (days < 0) {
				days = 7;
			}
		}
		String cacheKey = "stat.statIpAndHitsByProvince_" + days;
		return QueryUtils.findWithCache(CacheConfig.MG_TIME_TO_LIVE_MINUTE_5, cacheKey, Const.Db.TIO_SITE_STAT, "stat.statIpAndHitsByProvince", true, days);
	}

	/**
	 *
	 * @param mergeRequest true:合并请求类型，即appType不分组，只按ip分组
	 * @param starttime
	 * @param endtime
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @author tanyaowu
	 */
	public Page<Record> ip(Boolean mergeRequest, String starttime, String endtime, Integer pageNumber, Integer pageSize) {
		Kv kv = Kv.by("starttime", starttime).set("endtime", endtime).set("mergeRequest", mergeRequest);
		Page<Record> page = Db.use(Const.Db.TIO_SITE_STAT).template("stat.ip", kv).paginate(pageNumber, pageSize);
		return page;
	}

	/**
	 * 注册统计
	 * @param user
	 * @return
	 * @author xufei
	 * 2020年7月13日 下午2:10:54
	 */
	public void userRegisterStat(User user) {
		Integer threadid = StatService.me.threadInit(user.getId(), "", Const.ThreadLogType.REGISTER_STAT);
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					Date createtime = user.getCreatetime();
					if (createtime == null) {
						createtime = new Date();
					}
					String period = DateUtil.format(createtime, DatePattern.PURE_DATE_PATTERN);
					IpInfo ipInfo = user.getIpInfo();
					String ip = ipInfo.getIp();
					if (StrUtil.isBlank(ip)) {
						ip = "00000000";
					}
					UserRegisterStat timeStat = UserRegisterStat.dao.findFirst("SELECT * from user_register_stat where type = ? and statbizstr = ?", UserRegisterStat.Type.TIME, period);
					if (timeStat == null) {
						timeStat = new UserRegisterStat();
						timeStat.setStatbizstr(period);
						timeStat.setType(UserRegisterStat.Type.TIME);
						timeStat.ignoreSave();
					}
					UserRegisterStat ipStat = UserRegisterStat.dao.findFirst("SELECT * from user_register_stat where type = ? and statbizstr = ?", UserRegisterStat.Type.IP, ip);
					if (ipStat == null) {
						ipStat = new UserRegisterStat();
						ipStat.setStatbizstr(ip);
						ipStat.setType(UserRegisterStat.Type.IP);
						ipStat.setStatbizid(user.getIpid());
						ipStat.ignoreSave();
					}
					UserRegisterStat ipTimeStat = UserRegisterStat.dao.findFirst("SELECT * from user_register_stat where type = ? and statbizstr = ? and statbizid = ? ", UserRegisterStat.Type.IP_TIME, period, user.getIpid());
					if (ipTimeStat == null) {
						ipTimeStat = new UserRegisterStat();
						ipTimeStat.setStatbizstr(period);
						ipTimeStat.setType(UserRegisterStat.Type.IP_TIME);
						ipTimeStat.setStatbizid(user.getIpid());
						ipTimeStat.ignoreSave();
					}
					Db.use(Const.Db.TIO_SITE_STAT).update("update user_register_stat set regcount = regcount + 1 where (type = ? and statbizstr = ?) or (type = ? and statbizstr = ?) or (type = ? and statbizstr = ? and statbizid = ?) ", UserRegisterStat.Type.TIME, period, UserRegisterStat.Type.IP, ip, UserRegisterStat.Type.IP_TIME, period, user.getIpid());
					String city = ipInfo.getCity();
					String province = ipInfo.getProvince();
					if (StrUtil.isBlank(city) || StrUtil.isBlank(province)) {
						return;
					}
					AreaStat stat = AreaStat.dao.findFirst("select * from area_stat where city = ? and province = ? and type = ?", city, province, Const.AreaStatType.REGISTER);
					if (stat == null) {
						stat = new AreaStat();
						stat.setCity(city);
						stat.setProvince(province);
						stat.setType(Const.AreaStatType.REGISTER);
						stat.setBizcount(1);
						stat.setCharindex(PyUtils.getAllChat(province));
						stat.setCitychatindex(PyUtils.getAllChat(city));
						stat.ignoreSave();//此处存在同步漏洞
					} else {
						Db.use(Const.Db.TIO_SITE_STAT).update("update area_stat set bizcount = bizcount + 1 where city = ? and province = ? and type = ?", city, province, Const.AreaStatType.REGISTER);
					}
					StatService.me.threadDeal(threadid);
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
	}

	/**
	 * 初始化线程执行日志表
	 * @param bizint
	 * @param bizstr
	 * @param type
	 * @return
	 * @author xufei
	 * 2020年7月28日 下午1:54:52
	 */
	public Integer threadInit(Integer bizint,String bizstr,Byte type) {
		if (bizint == null && StrUtil.isBlank(bizstr)) {
			log.error("线程执行统计时，主键信息都为空，type:{}", type);
			return null;
		}
		TioThreadLogs threadLogs = new TioThreadLogs();
		threadLogs.setBizint(bizint);
		threadLogs.setBizstr(bizstr);
		threadLogs.setStatus(Const.YesOrNo.NO);
		threadLogs.setType(type);
		threadLogs.save();
		return threadLogs.getId();
	}
	/**
	 * 线程执行完成
	 * @param id
	 * @author xufei
	 * 2020年7月28日 下午1:56:12
	 */
	public void threadDeal(Integer id) {
		if(id == null) {
			log.error("重要提醒------------------------------>线程执行统计时，日志id为空");
			return;
		}
		TioThreadLogs threadLogs = new TioThreadLogs();
		threadLogs.setId(id);
		threadLogs.setStatus(Const.YesOrNo.YES);
		boolean update = threadLogs.update();
		if(!update) {
			log.error("重要提醒------------------------------>线程执行统计时，修改失败，id:{}",id);
		}
	}

}
