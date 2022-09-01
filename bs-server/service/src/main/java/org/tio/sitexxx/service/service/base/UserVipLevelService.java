/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.base;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import org.redisson.api.RTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.*;
import org.tio.sitexxx.service.api.sms.BaseSmsVo;
import org.tio.sitexxx.service.cache.CacheConfig;
import org.tio.sitexxx.service.cache.Caches;
import org.tio.sitexxx.service.init.RedisInit;
import org.tio.sitexxx.service.model.main.*;
import org.tio.sitexxx.service.model.stat.UserIpLoginStat;
import org.tio.sitexxx.service.model.stat.UserTimeLoginStat;
import org.tio.sitexxx.service.service.UserBaseService;
import org.tio.sitexxx.service.service.atom.AbsAtom;
import org.tio.sitexxx.service.service.atom.AbsTxAtom;
import org.tio.sitexxx.service.service.base.sms.SmsService;
import org.tio.sitexxx.service.service.conf.AvatarService;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.service.stat.StatService;
import org.tio.sitexxx.service.utils.CommonUtils;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.utils.PeriodUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.topic.TopicVo;
import org.tio.utils.Threads;
import org.tio.utils.cache.CacheUtils;
import org.tio.utils.cache.FirsthandCreater;
import org.tio.utils.cache.ICache;
import org.tio.utils.cache.redis.RedisCache;
import org.tio.utils.hutool.CollUtil;
import org.tio.utils.lock.LockUtils;
import org.tio.utils.resp.Resp;

import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tanyaowu
 * 2016年8月10日 上午11:09:59
 */
public class UserVipLevelService {
	private static Logger log = LoggerFactory.getLogger(UserVipLevelService.class);

	public static final UserVipLevelService ME = new UserVipLevelService();


	/**
	 *
	 * @author tanyaowu
	 */
	private UserVipLevelService() {
	}

	public UserVipLevel getByLevel(Integer level){
		return UserVipLevel.dao.findFirst("select * from user_vip_level where vip_level = ?", level);
	}
}
