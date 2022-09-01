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
public class UserService {
	private static Logger log = LoggerFactory.getLogger(UserService.class);

	public static final UserService ME = new UserService();

	public static final RoleService roleService = RoleService.me;

	public static final User nullUser = new User();

	//	ICache loginnameAndUserCache;

	//	ICache useridAndUserCache;

	/**
	 *
	 * @author tanyaowu
	 */
	private UserService() {
		//		loginnameAndUserCache = Caches.getCache(CacheConfig.LOGINNAME_USER_1);
		//		useridAndUserCache = Caches.getCache(CacheConfig.USERID_USER_6);
	}

	/**
	 * 查询用户信息，主要用于展示给其它人看，所以有的信息是不允许查询出来的
	 * 会区分超管和非超管
	 * @param currUser
	 * @param uid
	 * @return
	 * @throws Exception
	 * @author tanyaowu
	 */
	public Record info1(User currUser, Integer uid) throws Exception {
		boolean isSuper = UserService.isSuper(currUser);
		ICache cache = Caches.getCache(CacheConfig.USER_INFO_2);

		String key = String.valueOf(isSuper) + uid;
		boolean putTempToCacheIfNull = true;
		Record record = CacheUtils.get(cache, key, putTempToCacheIfNull, () -> {
			User user = UserService.ME.getById(uid);
			if (user == null) {
				return null;
			}
			Record record1 = new Record();
			record1.set("nick", user.getNick());
			record1.set("id", user.getId());
			record1.set("avatar", user.getAvatar());
			record1.set("loginname",user.getLoginname());

			//			Kv params = Kv.by("uid", uid);
			//			SqlPara sqlPara = User.dao.getSqlPara("user.searchByUid", params);
			//			Record record = Db.findFirst(sqlPara);

			perfectUserInfo(isSuper, record1);
			UserBase userBase = UserBaseService.me.getUserBaseByUid(uid);
			if (userBase != null) {
				record1.set("sex", userBase.getSex());
				record1.set("sign", userBase.getSign());
				record1.set("phone",userBase.getPhone());
			}
			return record1;

		});
		return record;
	}

	/**
	 * 获取用户信息，所有人得到的值是一样的，不分超管和普通用户
	 * @param uid
	 * @return
	 * @throws Exception
	 * @author tanyaowu
	 */
	public Record info(Integer uid) throws Exception {
		return info1(null, uid);
	}

	/**
	 * 搜索用户
	 * @param currUser
	 * @param nick
	 * @param uid
	 * @param loginname
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @author tanyaowu
	 * @throws Exception 
	 */
	public Page<Record> search(User currUser, String nick, Integer uid, String loginname, Integer pageNumber, Integer pageSize) throws Exception {
		if (pageNumber == null) {
			pageNumber = 1;
		}
		if (pageSize == null) {
			pageSize = 20;
		}
		Integer pageNumber1 = pageNumber;
		Integer pageSize1 = pageSize;

		boolean isSuper = UserService.isSuper(currUser);
//		if (!isSuper) { //非超管不能用登录名查询
//			loginname = null;
//		}

		ICache cache = Caches.getCache(CacheConfig.SEARCH_USER);

		Page<Record> page = null;
		Kv params = Kv.by("isSuper", isSuper);
		if (uid != null) { // 根据uid查询
			params.set("uid", uid);
			SqlPara sqlPara = User.dao.getSqlPara("user.searchByUid", params);
			page = Db.paginate(pageNumber, pageSize, sqlPara);
			perfectUserInfo(isSuper, page.getList());
		} else if (StrUtil.isNotBlank(loginname)) {
			params.set("loginname", loginname);
			SqlPara sqlPara;
			if (ConfService.getInt("im.queryuser.open.uid", 1) == 1){
				System.out.println("通过UID");
				sqlPara = User.dao.getSqlPara("user.searchByLoginnameOrUid", params);
			}else {
				System.out.println("通过Loginname");
				sqlPara = User.dao.getSqlPara("user.searchByLoginname", params);
			}
			page = Db.paginate(pageNumber, pageSize, sqlPara);
			perfectUserInfo(isSuper, page.getList());
		} else if (StrUtil.isNotBlank(nick)) {
			nick = nick.trim();
			if (!isSuper) {
				if (StrUtil.containsAny(nick, "%")) {
					return null;
				}
				loginname = null; //非超管，不允许使用loginname进行查询
			}

			//多个空格，换成%
			Pattern p = Pattern.compile("\\s+");
			Matcher m = p.matcher(nick);
			String searchNick = m.replaceAll("%");

			String key = isSuper + "_" + pageNumber + "_" + pageSize + "_" + searchNick;
			boolean putTempToCacheIfNull = true;
			page = CacheUtils.get(cache, key, putTempToCacheIfNull, new FirsthandCreater<Page<Record>>() {
				@Override
				public Page<Record> create() throws Exception {
					params.set("nick", "%" + searchNick + "%").set("search", searchNick);
					SqlPara sqlPara = User.dao.getSqlPara("user.searchByNick", params);
					Page<Record> page = Db.paginate(pageNumber1, pageSize1, sqlPara);

					perfectUserInfo(isSuper, page.getList());
					return page;
				}
			});
		} else {
			return null;
		}
		return page;

	}

	/**
	 * 搜索用户
	 * @param currUser
	 * @param nick
	 * @param uid
	 * @param loginname
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @author tanyaowu
	 * @throws Exception
	 */
	public Page<Record> search2(String loginname, Integer pageNumber, Integer pageSize) throws Exception {
		if (pageNumber == null) {
			pageNumber = 1;
		}
		if (pageSize == null) {
			pageSize = 20;
		}
		Integer pageNumber1 = pageNumber;
		Integer pageSize1 = pageSize;


		ICache cache = Caches.getCache(CacheConfig.SEARCH_USER2);

		Page<Record> page = null;
		Kv params = Kv.create();



		if (NumberUtil.isNumber(loginname)){
			params.set("uidFind", "1");
			params.set("id", loginname);
		}
		if (CommonUtils.isPhone(loginname)){
			params.set("phoneFind", "1");
			params.set("phone", loginname);
		}
		if (Validator.isEmail(loginname)){
			params.set("emailFind", "1");
			params.set("email", loginname);
		}
		params.set("loginNameFind", "1");
		params.set("loginname", loginname);

		SqlPara sqlPara = User.dao.getSqlPara("user.searchUser", params);
		String sql = sqlPara.getSql();
//		System.out.println("sql===>"+sql);
		page = Db.paginate(pageNumber, pageSize, sqlPara);
//		perfectUserInfo(isSuper, page.getList());

//		if (uid != null) { // 根据uid查询
//
//		} else if (StrUtil.isNotBlank(loginname)) {
//			params.set("loginname", loginname);
//			SqlPara sqlPara;
//			if (ConfService.getInt("im.queryuser.open.uid", 1) == 1){
//				System.out.println("通过UID");
//				sqlPara = User.dao.getSqlPara("user.searchByLoginnameOrUid", params);
//			}else {
//				System.out.println("通过Loginname");
//				sqlPara = User.dao.getSqlPara("user.searchByLoginname", params);
//			}
//			page = Db.paginate(pageNumber, pageSize, sqlPara);
//			perfectUserInfo(isSuper, page.getList());
//		} else if (StrUtil.isNotBlank(nick)) {
//			nick = nick.trim();
//			if (!isSuper) {
//				if (StrUtil.containsAny(nick, "%")) {
//					return null;
//				}
//				loginname = null; //非超管，不允许使用loginname进行查询
//			}
//
//			//多个空格，换成%
//			Pattern p = Pattern.compile("\\s+");
//			Matcher m = p.matcher(nick);
//			String searchNick = m.replaceAll("%");
//
//			String key = isSuper + "_" + pageNumber + "_" + pageSize + "_" + searchNick;
//			boolean putTempToCacheIfNull = true;
//			page = CacheUtils.get(cache, key, putTempToCacheIfNull, new FirsthandCreater<Page<Record>>() {
//				@Override
//				public Page<Record> create() throws Exception {
//					params.set("nick", "%" + searchNick + "%").set("search", searchNick);
//					SqlPara sqlPara = User.dao.getSqlPara("user.searchByNick", params);
//					Page<Record> page = Db.paginate(pageNumber1, pageSize1, sqlPara);
//
//					perfectUserInfo(isSuper, page.getList());
//					return page;
//				}
//			});
//		} else {
//			return null;
//		}
		return page;

	}

	/**
	 * 完善用户信息
	 * @param isSuper
	 * @param list
	 * @throws Exception
	 * @author tanyaowu
	 */
	public void perfectUserInfo(boolean isSuper, List<Record> list) throws Exception {
		if (list != null) {
			for (Record record : list) {
				perfectUserInfo(isSuper, record);
			}
		}
	}

	/**
	 * 完善用户信息
	 * @param isSuper
	 * @param record
	 * @throws Exception
	 * @author tanyaowu
	 */
	public void perfectUserInfo(boolean isSuper, Record record) throws Exception {
		if (record == null) {
			return;
		}
		Integer uid = record.getInt("id");
		if (uid != null) {
			User user = UserService.ME.getById(uid);
			record.set("roles", user.getRoles());
			if (user.getIpid() != null) {
				IpInfo ipInfo = IpInfoService.ME.getById(user.getIpid());
				if (ipInfo != null) {
					record.set("country", ipInfo.getCountry());
					record.set("province", ipInfo.getProvince());
					record.set("city", ipInfo.getCity());
				}

				UserThirdOsc userThirdOsc = null;
				if ("5".equals(user.getPwd()) && user.getLoginname().startsWith("__osc_")) {
					UserThird userThird = UserThirdService.me.getByUid(uid,UserThird.Type.OSC);
					if (userThird != null) {
						userThirdOsc = UserThirdOscService.me.getByUserThirdId(userThird.getId());
						if (userThirdOsc != null) {
							record.set("osc_url", userThirdOsc.getUrl());
						}
					}
				}

				if (isSuper) {
					if (ipInfo != null) {
						record.set("ip", ipInfo.getIp());
					}
					record.set("createtime", user.getCreatetime());
					record.set("loginname", user.getLoginname());
					if (userThirdOsc != null) {
						record.set("osc_email", userThirdOsc.getEmail());
					}
				}
			}
		}
	}

	/**
	 * 清空用户所有的相关缓存
	 * @param uid 如果为null，则清除所有用户的缓存
	 * 
	 * @date 2016年11月20日 下午1:45:19
	 */
	public void _clearCache(Integer uid) {
		if (uid == null) {
			Caches.getCache(CacheConfig.USERID_USER_6).clear();
			Caches.getCache(CacheConfig.LOGINNAME_USER_1).clear();
			Caches.getCache(CacheConfig.USER_INFO_2).clear();
			Caches.getCache(CacheConfig.USERID_BASE).clear();
		} else {
			User user = UserService.ME.getById(uid);
			String key = uid + "";
			Caches.getCache(CacheConfig.USERID_USER_6).remove(key);
			if (user != null) {
				if(StrUtil.isNotBlank(user.getPhone())) {
					String loginkey = "phone*_" + user.getPhone();
					System.out.println("清除phone缓存："+loginkey);
					Caches.getCache(CacheConfig.LOGINNAME_USER_1).remove(loginkey);
				}
				if(StrUtil.isNotBlank(user.getEmailpwd())) {
					String loginkey = "email*_" + user.getEmailpwd();
					System.out.println("清除email缓存："+loginkey);
					Caches.getCache(CacheConfig.LOGINNAME_USER_1).remove(loginkey);
				}
				Caches.getCache(CacheConfig.LOGINNAME_USER_1).remove(user.getLoginname());
			}
			ICache cache = Caches.getCache(CacheConfig.USER_INFO_2);
			cache.remove(String.valueOf(false) + key);
			cache.remove(String.valueOf(true) + key);
			Caches.getCache(CacheConfig.USERID_BASE).remove(key);
		}
	}

	public void _clearCachePhone(String phone) {
		String loginkey = "phone*_" + phone;
		System.out.println("清除phone缓存："+loginkey);
		Caches.getCache(CacheConfig.LOGINNAME_USER_1).remove(loginkey);
	}

	public void _clearCacheEmail(String email) {
		String loginkey = "email*_" + email;
		System.out.println("清除email缓存："+loginkey);
		Caches.getCache(CacheConfig.LOGINNAME_USER_1).remove(loginkey);
	}

	/**
	 * 发topic通知清除用户缓存
	 * @param uid
	 */
	public void notifyClearCache(Integer uid) {
		System.out.println("清除用户缓存："+uid);
		_clearCache(uid);

		TopicVo topicVo = new TopicVo();
		topicVo.setType(TopicVo.Type.CLEAR_USER);
		topicVo.setValue(uid);
		RTopic topic = RedisInit.get().getTopic(Const.Topic.COMMON_TOPIC);

		//这里设置clientid，避免过滤掉自己
		//有的消息是要过滤自己的，就不能设置此值
		//		topicVo.setClientId("3");
		topic.publish(topicVo);
	}

	/**
	 * 所有用户，包括各种状态，调用后根据业务进行状态处理
	 * @param id
	 * @return
	 * @author tanyaowu
	 */
	public User getById(Integer id) {
		if (id == null) {
			return null;
		}
		String key = id + "";

		User user1 = CacheUtils.get(Caches.getCache(CacheConfig.USERID_USER_6), key, true, new FirsthandCreater<User>() {
			@Override
			public User create() {
				User user = User.dao.findById(id);

				if (user == null) {
					return null;
				}

				if (Const.USE_ANONYMOUS) {
					if (user.getXx() == (byte) 1) {
						user.setAvatar(AVATARS[id % AVATARS.length]);
					}
				}
				roleService.setRoles(user);

				IpInfo ipInfo = IpInfoService.ME.getById(user.getIpid());
				user.setIpInfo(ipInfo);

				UserThird userThird = UserThirdService.me.getByUid(user.getId(),user.getThirdtype());
				user.setUserThird(userThird);

				if (StrUtil.isBlank(user.getAvatar())) {
					user.setAvatar(User.DEFAULT_AVATAR);
				}

				if (StrUtil.isBlank(user.getAvatarbig())) {
					user.setAvatarbig(user.getAvatar());
				}
				UserBase userBase = UserBaseService.me.getUserBaseByUid(user.getId());
				if (userBase != null) {
					user.setSign(userBase.getSign());
					user.setSex(userBase.getSex());
				}
				if(Objects.equals(user.getOpenflag(), Const.YesOrNo.YES) && user.getOpenid() != null ) {
					WxUserWallet wallet = WxUserWallet.dao.findById(user.getOpenid());
					if(wallet != null) {
						user.setWalletid(wallet.getWalletid());
					}
				}
				return user;
			}
		});
		return user1;
	}

	/**
	 * 所有状态下的用户，调用后，根据业务进行处理
	 * @param id
	 * @return
	 * @author: tanyaowu
	 */
	public User getById(String id) {
		if (StrUtil.isBlank(id)) {
			return null;
		}

		return getById(Integer.parseInt(id));
	}

	/**
	 * 保存用户，会连着保存ip等信息
	 * @param user
	 * @return
	 * @author tanyaowu
	 */
	public User save(User user) {
		IpInfo ip = user.getIpInfo();
		ip = IpInfoService.ME.save(ip);

		if (ip != null) {
			user.setIpid(ip.getId());
			System.out.println("user5==============>"+ JSON.toJSON(user));
			boolean ff = user.save();
			if (ff) {
				user.setIpInfo(ip);
				return user;
			}
		}
		return null;
	}

	/**
	 * 保存唯一用户
	 * @param user
	 * @return
	 */
	public User userUnionSave(User user) {
		return null;
	}

	/**
	 * 获取用户数
	 * @return
	 */
	public int getUserCount() {
		ICache cache = Caches.getCache(CacheConfig.USER_COUNT);
		String key = org.tio.sitexxx.service.cache.Caches.SINGLE_KEY;

		Integer count = CacheUtils.get(cache, key, true, new FirsthandCreater<Integer>() {
			@Override
			public Integer create() {
				String sql = "select count(*) from user";
				return Db.use(Const.Db.TIO_SITE_MAIN).queryInt(sql);
			}
		});

		return count;
	}

	/**
	 * 根据loginname获取用户
	 * @param loginname
	 * @param status 如果为null则不限状态
	 * @return
	 * @author tanyaowu
	 */
	public User getByLoginname(String loginname, Byte status) {
		ICache loginnameAndUserCache = Caches.getCache(CacheConfig.LOGINNAME_USER_1);
		User user = (User) loginnameAndUserCache.get(loginname);
		if (user == null) {
			user = User.dao.findFirst("select * from user where loginname = ? and `status` <> ?", loginname, org.tio.sitexxx.service.model.main.User.Status.LOGOUT);
			if (user != null) {
				user = getById(user.getId());
			}
			if (user != null) {
				loginnameAndUserCache.put(loginname, user);
			} else {
				loginnameAndUserCache.putTemporary(loginname, nullUser);
			}
		} else {
			//可能是 nullUser
			if (user.getId() == null) {
				return null;
			}
			if (status == null) {
				return user;
			}
			if (!Objects.equals(status, user.getStatus())) {
				return null;
			}
		}
		return user;
	}
	
	/**
	 * @param email
	 * @param status
	 * @return
	 * @author xufei
	 * 2020年12月16日 下午3:45:47
	 */
	public User getByEmail(String email, Byte status) {
		ICache loginnameAndUserCache = Caches.getCache(CacheConfig.LOGINNAME_USER_1);
		String key = "email*_" + email;
		User user = (User) loginnameAndUserCache.get(key);
		if (user == null) {
			user = User.dao.findFirst("select * from user where emailpwd = ? and `status` <> ?", email, org.tio.sitexxx.service.model.main.User.Status.LOGOUT);
			if (user != null) {
				user = getById(user.getId());
			}
			if (user != null) {
				loginnameAndUserCache.put(key, user);
			} else {
				loginnameAndUserCache.putTemporary(key, nullUser);
			}
		} else {
			//可能是 nullUser
			if (user.getId() == null) {
				return null;
			}
			if (status == null) {
				return user;
			}
			if (!Objects.equals(status, user.getStatus())) {
				return null;
			}
		}
		return user;
	}
	
	/**
	 * @param phone
	 * @param status
	 * @return
	 * @author xufei
	 * 2020年12月16日 下午3:45:44
	 */
	public User getByPhone(String phone, Byte status) {
		System.out.println("phone获取用户："+phone);
		ICache loginnameAndUserCache = Caches.getCache(CacheConfig.LOGINNAME_USER_1);
		String key = "phone*_" + phone;
		User user = (User) loginnameAndUserCache.get(key);
		if (user == null) {
			user = User.dao.findFirst("select * from user where phone = ? and `status` <> ?", phone, org.tio.sitexxx.service.model.main.User.Status.LOGOUT);
			if (user != null) {
				user = getById(user.getId());
			}
			if (user != null) {
				loginnameAndUserCache.put(key, user);
			} else {
				loginnameAndUserCache.putTemporary(key, nullUser);
			}
		} else {
			//可能是 nullUser
			if (user.getId() == null) {
				return null;
			}
			if (status == null) {
				return user;
			}
			if (!Objects.equals(status, user.getStatus())) {
				return null;
			}
		}
		return user;
	}

	/**
	 * 原始登录
	 * 1、loginname不存在
	 * 2、密码不正确
	 * 3、换aes登录吧
	 * @param loginname
	 * @param pd5 md5加密的密码
	 * @param isThirdLogin
	 * @return
	 */
	public Ret login(String loginname, String pd5, boolean isThirdLogin) {
		String code = "code";
		if (StrUtil.isBlank(loginname)/** || ( StrUtil.isBlank(pwd) &&  !isThirdLogin) */
		) {
			return Ret.fail(code, 1);
		}
		User user = getByLoginname(loginname, null);
		if (user == null) {
			log.info("can find user by loginname:【{}】", loginname);
			return Ret.fail(code, 1); //loginname不存在
		}

		if (!isThirdLogin) {
			if (!Objects.equals(pd5, user.getPwd())) {
				log.info("password is invalid, loginname:[{}], md5pwd:[{}], need md5pwd:[{}]", loginname, pd5, user.getPwd());
				return Ret.fail(code, 2); //密码不正确 
			}
		}

		return Ret.ok("user", user);
	}
	
	/**
	 * @param loginname
	 * @param pd5
	 * @param authcode
	 * @param isThirdLogin
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年12月16日 下午3:59:32
	 */
	public Ret login(String loginname, String pd5,String authcode, boolean isThirdLogin) throws Exception {
		String code = "code";
		if (StrUtil.isBlank(loginname)) {
			return Ret.fail(code, 1);
		}
		if (NumberUtil.isNumber(loginname) && loginname.length() != 11){
			//鸽哒号码登录
			User byId = UserService.ME.getById(loginname);
			if (byId == null){
				return Ret.fail(code, 1);
			}
			if (!byId.getPwd().equals(pd5)){
				return Ret.fail(code, 2);
			}
			return Ret.ok("user", byId);
		}
		Integer loginType = null;
		if (Validator.isEmail(loginname)) {
			loginType = Const.RegisterType.EMAIL;
		}
		if (/*Validator.isMobile(loginname)*/CommonUtils.isPhone(loginname)) {
			loginType = Const.RegisterType.PHONE;
		}
		if(loginType == null) {
			return login(loginname, pd5, isThirdLogin);
		}
		User user = null;
		if(Objects.equals(loginType, Const.RegisterType.EMAIL)) {
			user = getByEmail(loginname, null);
			if (user == null) {
				log.warn("can find user by loginname:【{}】", loginname);
				return Ret.fail(code, 1); //loginname不存在
			}
			if (!isThirdLogin) {
				if (!Objects.equals(pd5, user.getPwd())) {
					log.warn("password is invalid, loginname:[{}], md5pwd:[{}], need md5pwd:[{}]", loginname, pd5, user.getPwd());
					return Ret.fail(code, 2); //密码不正确 
				}
			}
		} else {
			user = getByPhone(loginname, null);
			if (user == null) {
				log.warn("can find user by loginname:【{}】", loginname);
				return Ret.fail(code, 1); //loginname不存在
			}
			if(StrUtil.isNotBlank(authcode)) {
				Ret ret = SmsService.me.checkCode(loginname, BaseSmsVo.BaseSmsBizType.LOGIN, authcode, null, true);
				if(ret.isFail()) {
					return ret.set(code, 2);
				}
			} else {
				if (!isThirdLogin) {
					if (!Objects.equals(pd5, user.getPwd())) {
						log.warn("password is invalid, loginname:[{}], md5pwd:[{}], need md5pwd:[{}]", loginname, pd5, user.getPwd());
						return Ret.fail(code, 2); //密码不正确 
					}
				}
			}
		}
		return Ret.ok("user", user);
	}

	/**
	 * 修改用户昵称
	 * @param user
	 * @param newNick
	 * @return
	 * @author tanyaowu
	 */
	public Resp updateNick(User user, String newNick, String avatarPath) {
		if (newNick.equals(user.getNick())) {
			return Resp.fail("原来的昵称就是这个哦！");
		}
		Resp resp = CommonUtils.checkGroupName(newNick, "昵称");
		if (!resp.isOk()) {
			return resp;
		}

		UserlogModifyNick userlogModifyNick = new UserlogModifyNick();
		userlogModifyNick.setNewnick(newNick);
		userlogModifyNick.setOldnick(user.getNick());
		userlogModifyNick.setUid(user.getId());

		if (StrUtil.isNotBlank(newNick)) {
			Integer check = Db.use(Const.Db.TIO_SITE_MAIN).queryInt("select id from user where nick = ? and id != ? and `status` != ? limit 1", newNick, user.getId(),
			        org.tio.sitexxx.service.model.main.User.Status.LOGOUT);
			if (check != null) {
				return Resp.fail("昵称已存在");
			}
			//			user.setSrcnick(newNick);
			String filterContent = newNick;
			filterContent = SensitiveWordsService.findAndReplace(filterContent);
//			filterContent = StringEscapeUtils.escapeHtml4(filterContent);
			user.setNick(filterContent);
		}
		//		String loginname = user.getLoginname();
		int c = -1;
		if (StrUtil.isBlank(avatarPath)) {
			String sql = "update user set nick = ? where id = ?";
			c = Db.update(sql, newNick, user.getId());
		} else {
			String sql = "update user set nick = ?,avatar = ?,avatarbig = ? where id = ?";
			c = Db.update(sql, newNick, avatarPath, avatarPath, user.getId());
		}
		if (c < 1) {
			log.error("修改无变动：" + "用户昵称修改失败");
		}
		notifyClearCache(user.getId());
		userlogModifyNick.save();
//		initSynInfo(user.getId(), Const.UserToImSynType.NICK, newNick, null);
//		if (StrUtil.isNotBlank(avatarPath)) {
//			initSynInfo(user.getId(), Const.UserToImSynType.AVATAR, avatarPath, null);
//		}
		return Resp.ok().msg("用户昵称修改成功");
	}

	/**
	 * 更新头像
	 * @param user
	 * @param newavatar
	 * @param newavatarbig
	 * @return
	 * @author tanyaowu
	 */
	public Resp updateAvatar(User user, String newavatar, String newavatarbig) {
		UserlogModifyAvatar userlogModifyAvatar = new UserlogModifyAvatar();
		userlogModifyAvatar.setNewavatar(newavatar);
		userlogModifyAvatar.setNewavatarbig(newavatarbig);
		userlogModifyAvatar.setOldavatar(user.getAvatar());
		userlogModifyAvatar.setOldavatarbig(user.getAvatarbig());
		userlogModifyAvatar.setUid(user.getId());

		//		String loginname = user.getLoginname();
		String sql = "update user set avatar = ?, avatarbig = ? where id = ?";
		int c = Db.update(sql, newavatar, newavatarbig, user.getId());

		if (c < 1) {
			log.error("修改无变动：" + "用户头像修改失败");
		}
		notifyClearCache(user.getId());

		userlogModifyAvatar.save();
//		initSynInfo(user.getId(), Const.UserToImSynType.AVATAR, newavatar, null);
		return Resp.ok().msg("用户头像修改成功");
	}

	/**
	 * 修改验证方式
	 * @param user
	 * @param fdvalidtype
	 * @return
	 * @author xufei
	 * 2020年3月3日 下午5:24:48
	 */
	public Resp updateFdvalidtype(User user, Byte fdvalidtype) {
		String sql = "update user set fdvalidtype = ? where id = ?";
		int c = Db.update(sql, fdvalidtype, user.getId());

		if (c < 1) {
			log.error("修改无变动：" + "用户验证方式失败");
		}
		notifyClearCache(user.getId());
		return Resp.ok().msg("用户验证方式成功");
	}
	
	/**
	 * @param user
	 * @param emailpwd
	 * @param phonepwd
	 * @return
	 * @author xufei
	 * 2020年12月16日 下午4:50:31
	 */
	public Resp bindPhone(User user,String phone,String phonepwd,String emailpwd) {
		String sql = "update user set phone = ?,phonepwd = ?,emailpwd = ?,pwd = ?,phonebindflag = ? where id = ?";
		int c = Db.update(sql, phone,phonepwd,emailpwd,phonepwd,Const.YesOrNo.YES,user.getId());
		if (c < 1) {
			log.error("修改无变动：" + "用户绑定失败");
		}
		notifyClearCache(user.getId());
		return Resp.ok().msg("用户绑定成功");
	}
	
	/**
	 * 手机注册绑定邮箱
	 * @param user
	 * @param phone
	 * @param phonepwd
	 * @param emailpwd
	 * @return
	 * @author xufei
	 * 2020年12月24日 下午6:18:27
	 */
	public Resp regbindemail(User user,String phone,String phonepwd,String emailpwd) {
		String sql = "update user set phone = ?,phonepwd = ?,phonebindflag = ? where id = ?";
		int c = Db.update(sql, phone,phonepwd,Const.YesOrNo.YES,user.getId());
		if (c < 1) {
			log.error("修改无变动：" + "用户绑定失败");
		}
		notifyClearCache(user.getId());
		return Resp.ok().msg("注册成功");
	}
	
	/**
	 * 三方绑定手机号
	 * @param user
	 * @param phonepwd
	 * @param emailpwd
	 * @return
	 * @author xufei
	 * 2020年12月17日 下午2:45:15
	 */
	public Ret thridBindPhone(User user,User exist,String phone,String typeSplit) {
		if(exist != null ) {
			List<UserThird> userThirds = UserThirdService.me.getBindThirds(user.getId(),typeSplit);
			if(CollectionUtil.isEmpty(userThirds)) {
				return RetUtils.failMsg("三方信息不存在");
			}
			for(UserThird old : userThirds) {
				UserThird updateThrid = new UserThird();
				updateThrid.setUid(exist.getId());
				updateThrid.setId(old.getId());
				boolean update = updateThrid.update();
				if(!update) {
					return RetUtils.failMsg("绑定失败");
				}
				notifyClearCache(old.getId());
			}
//			Db.use(Const.Db.TIO_SITE_MAIN).update("delete from user where id = ?",user.getId());
			notifyClearCache(exist.getId());
			return RetUtils.okOper().set("login", Const.YesOrNo.YES).set("third",userThirds);
		} else {
			String sql = "update user set phone = ?,phonebindflag = ?,thirdstatus = ? where id = ?";
			int c = Db.update(sql, phone,Const.YesOrNo.YES,Const.YesOrNo.YES,user.getId());
			if (c < 1) {
				log.error("修改无变动：" + "三方用户绑定手机失败");
			}
			notifyClearCache(user.getId());
			return RetUtils.okOper().set("login", Const.YesOrNo.NO);
		}
	}
	
	/**
	 * @param user
	 * @param phonepwd
	 * @return
	 * @author xufei
	 * 2020年12月16日 下午6:18:41
	 */
	public Resp bindNewPhone(User user,String phone,String phonepwd,String emailpwd) {
		String sql = "update user set phone = ?,phonepwd = ?,emailpwd = ?,pwd = ? where id = ?";
		int c = Db.update(sql, phone,phonepwd,emailpwd,phonepwd,user.getId());
		if (c < 1) {
			log.error("修改无变动：" + "用户重新绑定失败");
		}
		notifyClearCache(user.getId());
		return Resp.ok().msg("用户重新绑定成功");
	}

	/**
	 * 消息提醒设置
	 * @param user
	 * @param remindflag
	 * @return
	 * @author xufei
	 * 2020年3月3日 下午6:21:30
	 */
	public Resp updateRemind(User user, Byte remindflag) {
		String sql = "update user set msgremindflag = ? where id = ?";
		int c = Db.update(sql, remindflag, user.getId());

		if (c < 1) {
			log.error("修改无变动：" + "用户消息提醒设置失败");
		}
		notifyClearCache(user.getId());
		return Resp.ok().msg("用户消息提醒设置成功");
	}

	/**
	 * 修改电话
	 * @param user
	 * @param searchflag
	 * @return
	 * @author xufei
	 * 2020年3月3日 下午6:24:15
	 */
	public Resp updatePhone(User user, String phone) {
		if (phone == null) {
			phone = "";
		}
		String sql = "update user_base set phone = ? where uid = ?";
		int c = Db.update(sql, phone, user.getId());
		if (c < 1) {
			log.error("修改无变动：" + "用户修改电话失败");
		}
		notifyClearCache(user.getId());
		return Resp.ok().msg("用户修改电话成功");
	}

	/**
	 * 修改签名
	 * @param user
	 * @param sign
	 * @return
	 * @author xufei
	 * 2020年3月3日 下午6:30:39
	 */
	public Resp updateSign(User user, String sign) {
		if (sign == null) {
			sign = "";
		}
		String sql = "update user_base set sign = ? where uid = ?";
		int c = Db.update(sql, sign, user.getId());
		if (c < 1) {
			log.error("修改无变动：" + "用户修改签名失败");
		}
		notifyClearCache(user.getId());
		return Resp.ok().msg("用户修改签名成功");
	}

	/**
	 * 修改用户
	 * @param curr
	 * @param update
	 * @return
	 * @author xufei
	 * 2020年4月23日 上午11:06:07
	 */
	public Resp updateUser(User curr, User update) {
		if (update == null) {
			return Resp.fail().msg(RetUtils.INVALID_PARAMETER);
		}
		if (StrUtil.isNotBlank(update.getNick())) {
			Integer check = Db.use(Const.Db.TIO_SITE_MAIN).queryInt("select id from user where nick = ? and id != ? and `status` != ? limit 1", update.getNick(), curr.getId(),
			        org.tio.sitexxx.service.model.main.User.Status.LOGOUT);
			if (check != null) {
				return Resp.fail("昵称已存在");
			}
			//			user.setSrcnick(newNick);
			String filterContent = update.getNick();
			filterContent = SensitiveWordsService.findAndReplace(filterContent);
//			filterContent = StringEscapeUtils.escapeHtml4(filterContent);
			update.setNick(filterContent);
		}
		AbsTxAtom absTxAtom = new AbsTxAtom() {

			@Override
			public boolean noTxRun() {
				Kv param = Kv.by("uid", curr.getId());
				if (StrUtil.isBlank(update.getSign())) {
					param.set("sign", "");
				} else {
					param.set("sign", update.getSign());
				}
				if (update.getSex() != null) {
					param.set("sex", update.getSex());
				}
				SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("user.updateBase", param);
				Db.use(Const.Db.TIO_SITE_MAIN).update(sqlPara);
				update.setId(curr.getId());
				return update.update();
			}
		};
		boolean atom = Db.use(Const.Db.TIO_SITE_MAIN).tx(absTxAtom);
		if (!atom) {
			return Resp.fail("用户修改失败");
		}
		notifyClearCache(curr.getId());
//		if(StrUtil.isNotBlank(update.getNick()) && !curr.getNick().equals(update.getNick())) {
//			initSynInfo(update.getId(), Const.UserToImSynType.NICK, update.getNick(), null);
//		}
//		if (StrUtil.isNotBlank(update.getAvatar()) && !curr.getAvatar().equals(update.getAvatar())) {
//			initSynInfo(update.getId(), Const.UserToImSynType.AVATAR, update.getAvatar(), null);
//		}
		return Resp.ok().msg("用户修改成功");
	}

	/**
	 * 性别修改
	 * @param user
	 * @param sex
	 * @return
	 * @author xufei
	 * 2020年3月3日 下午6:33:38
	 */
	public Resp updateSex(User user, Byte sex) {
		if (sex == null) {
			sex = Const.UserSex.MALE;
		}
		if (!Objects.equals(user.getSex(), sex)) {
			try {
				if (user.getAvatar().trim().indexOf("/avatar/tio/") == 0) {
					String avatar = AvatarService.nextAvatar(sex + "");
					String sql = "update user set avatar = ?, avatarbig = ? where id = ?";
					Db.update(sql, avatar, avatar, user.getId());
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		String sql = "update user_base set sex = ? where uid = ?";
		int c = Db.update(sql, sex, user.getId());
		if (c < 1) {
			log.error("修改无变动：" + "用户修改性别失败");
		}
		notifyClearCache(user.getId());
		return Resp.ok().msg("用户修改性别成功");
	}

	/**
	 * @param user
	 * @param searchflag
	 * @return
	 * @author xufei
	 * 2020年3月3日 下午6:25:59
	 */
	public Resp updateSearchFlag(User user, Byte searchflag) {
		String sql = "update user set searchflag = ? where id = ?";
		int c = Db.update(sql, searchflag, user.getId());
		if (c < 1) {
			log.error("修改无变动：" + "用户设置别人搜索开关失败");
		}
		notifyClearCache(user.getId());
		return Resp.ok().msg("用户设置别人搜索开关成功");
	}

	/**
	 * 修改密码
	 * @param user
	 * @param initPwd 用户输入的原密码
	 * @param newPwd
	 * @return
	 * @author tanyaowu
	 */
	public Resp updatePwd(User user, String initPwd, String newPwd,String emailpwd) {
		System.out.println(String.format("initPwd:%s, newpwd:%s", initPwd, newPwd));
		if (!Objects.equals(initPwd, user.getPwd())) {
			return Resp.fail("原密码不正确");
		}
//		String md5pwd = getMd5Pwd(user.getPhone(), initPwd);
//		if(StrUtil.isNotBlank(emailpwd)) {
//			md5pwd = getMd5Pwd(user.getPwd(), initPwd);
//
//		} else {
//			if (!Objects.equals(md5pwd, user.getPhonepwd())) {
//				return Resp.fail("原密码不正确");
//			}
//		}
//		String newmd5pwd = newPwd;//getMd5Pwd(loginname, newPwd);
		String sql = "update user set pwd = ? where id = ?";
		int c = Db.update(sql, newPwd, user.getId());
		if( c <= 0) {
			log.error("修改无变动：" + "修改密码");
		}
		notifyClearCache(user.getId());
		return Resp.ok();
	}
	
	/**
	 * @param user
	 * @param phonepwd
	 * @param emailpwd
	 * @return
	 * @author xufei
	 * 2020年12月17日 上午10:31:28
	 */
	public Resp resetPwd(User user, String phonepwd,String emailpwd) {
		String sql = "update user set phonepwd = ?,pwd = ? where id = ?";
		int c = Db.update(sql, phonepwd,phonepwd, user.getId());
		if(c <= 0) {
			log.error("修改无变动：" + "找回密码");
		}
		notifyClearCache(user.getId());
		return Resp.ok();
	}

	public Resp resetPwd2(User user, String pwd) {
		String sql = "update user set pwd = ? where id = ?";
		int c = Db.update(sql, pwd, user.getId());
		if(c <= 0) {
			log.error("修改无变动：" + "找回密码");
		}
		notifyClearCache(user.getId());
		return Resp.ok();
	}

	/**
	 * @param loginname
	 * @param roleid
	 * @return
	 * @author xufei
	 * 2020年12月17日 上午10:50:12
	 */
	public Resp addRoleByLoginname(String loginname, byte roleid) {
		User user = getByLoginname(loginname, org.tio.sitexxx.service.model.main.User.Status.NORMAL);
		if (user == null) {
			return Resp.fail("用户不存在或状态不正常");
		}
		return addRole(user, roleid);
	}

	public Resp addRoleByNick(String nick, byte roleid) {
		User user = getByNick(nick);
		if (user == null) {
			return Resp.fail("昵称不存在");
		}

		if (!Objects.equals(user.getStatus(), org.tio.sitexxx.service.model.main.User.Status.NORMAL)) {
			return Resp.fail("用户状态不对");
		}

		return addRole(user, roleid);
	}

	/**
	 * 给某用户添加角色
	 * @param loginname
	 * @param roleid
	 * @return
	 * @author tanyaowu
	 */
	public Resp addRole(User user, byte roleid) {
		if (user == null) {
			return Resp.fail("用户为空");
		}

		boolean f = Db.use(Const.Db.TIO_SITE_MAIN).tx(new IAtom() {
			@Override
			public boolean run() throws SQLException {
				//先删除
				removeRole(user, roleid, false);

				//再添加
				String sql = "insert into user_role (uid, rid, status) values (?,?,?)";
				Db.use(Const.Db.TIO_SITE_MAIN).update(sql, user.getId(), roleid, 1);

				return true;
			}

		});

		if (f) {
			notifyClearCache(user.getId());
			return Resp.ok();
		} else {
			return Resp.fail("操作失败");
		}
	}

	/**
	 * 删除角色
	 * @param user
	 * @param roleid
	 * @return
	 */
	public Resp removeRole(User user, byte roleid) {
		return removeRole(user, roleid, true);
	}

	public Resp removeRole(User user, byte roleid, boolean clearCache) {
		String sql = "delete from user_role where uid = ? and rid = ?";
		Db.use(Const.Db.TIO_SITE_MAIN).update(sql, user.getId(), roleid);
		if (clearCache) {
			notifyClearCache(user.getId());
		}

		return Resp.ok();
	}

	/**
	 * 获取所有有可能侵权的头像
	 * @return
	 * @author xufei
	 * 2020年1月15日 下午1:48:42
	 */
	public List<Record> getTortAvatarUser() {
		String sql = "select u.id,nick,avatar,b.sex from `user` u INNER JOIN user_base b on u.id = b.uid where avatar not like '/user/avatar/%' and avatar not like 'http%'";
		List<Record> users = Db.use(Const.Db.TIO_SITE_MAIN).find(sql);
		return users;
	}

	/**
	 * 获取md5加密密码
	 * @param loginname 登录名
	 * @param plainpwd 明文密码
	 * @return
	 */
	public static String getMd5Pwd(String loginname, String plainpwd) {
		String pwd = SecureUtil.md5("${" + StrUtil.trim(loginname) + "}" + StrUtil.trim(plainpwd));
		return pwd;
	}

	/**
	 * 修改用户地址
	 * @param uid
	 * @param userAddress
	 * @return
	 * 
	 */
	public Ret updateUserAddress(Integer uid, UserAddress userAddress) {
		if (userAddress == null || uid == null) {
			return Ret.fail().set("msg", "无效参数");
		}
		userAddress.setUid(uid);
		userAddress.update();
		return Ret.ok().set("data", userAddress);
	}

	public static final String[] AVATARS = new String[] { "/img/avatar/1.png", "/img/avatar/10171119181614.jpg", "/img/avatar/1106070_jc1127.png", "/img/avatar/1168934_100.jpeg",
	        "/img/avatar/1485256_wooxz.png", "/img/avatar/2.jpg", "/img/avatar/20171118121406.png", "/img/avatar/20171118122407.jpg", "/img/avatar/20171118124108.jpg",
	        "/img/avatar/20171118124247.png", "/img/avatar/20171118124927.jpg", "/img/avatar/20171118125112.jpg", "/img/avatar/20171118125630.jpg",
	        "/img/avatar/20171118181652.jpg", "/img/avatar/20171119182050.jpg", "/img/avatar/20180416154203.jpg", "/img/avatar/20180416155040.jpg",
	        "/img/avatar/20180429093933.jpg", "/img/avatar/2232696_talent-iofan.png", "/img/avatar/302580_wu1g119.png", "/img/avatar/3196787_100.jpg",
	        "/img/avatar/3440734_100.jpeg", "/img/avatar/3802362_50.jpeg", "/img/avatar/463940_hehui082452239.jpg", "/img/avatar/512121_SJRSB.png", "/img/avatar/556878_100.gif",
	        "/img/avatar/636232_meallon.png", "/img/avatar/87d66e45edd0274fe9c29b8cb54f9258_1.jpg", "/img/avatar/a.jpg", "/img/avatar/beimi.jpeg", "/img/avatar/cc.png",
	        "/img/avatar/eee.png", "/img/avatar/fds.png", "/img/avatar/fdsse.png", "/img/avatar/gopush.jpeg", "/img/avatar/l.png", "/img/avatar/liyus.jpg",
	        "/img/avatar/luxiaolei.jpg", "/img/avatar/orpherus.jpg", "/img/avatar/qbug.png", "/img/avatar/shts.jpg", "/img/avatar/springForAll.png", "/img/avatar/xianxin.jpg",
	        "/img/avatar/zhishu.png" };

	/**
	 * 是否是超管，上帝视角
	 * @param user
	 * @return
	 */
	public static final boolean isSuper(User user) {
		if (user == null) {
			return false;
		}
		return UserRoleService.hasRole(user, Role.ADMIN_SUPER);
	}

	/**
	 * 是否是超管，上帝视角
	 * @param user
	 * @return
	 */
	public static final boolean isSuper(Integer uid) {
		User user = UserService.ME.getById(uid);
		return isSuper(user);
	}

	/**
	 * 根据用户昵称修改用户状态 (status)
	 * @param nick
	 * @param newStatus
	 * @return
	 */
	public int updateUserStatus(String nick, byte newStatus) {
		if (StrUtil.isBlank(nick)) {
			return 0;
		}

		Integer uid = getUidByNick(nick);
		return updateUserStatus(uid, newStatus);
	}

	/**
	 * 根据uid修改用户状态 (status)
	 * @param uid
	 * @param newStatus
	 * @return
	 */
	public int updateUserStatus(Integer uid, byte newStatus) {
		if (uid == null) {
			return 0;
		}
		String sql = "update user set status = ? where id = ?";
		int c = Db.update(sql, newStatus, uid);
		if( c <= 0) {
			log.error("修改无变动：" + "修改用户状态");
		}
		notifyClearCache(uid);
		return c;
	}

	/**
	 * 根据用户昵称拉黑用户
	 * @param nick
	 * @return
	 * @throws SQLException 
	 */
	public int pullBlackUserByNick(String nick) throws SQLException {
		Integer uid = getUidByNick(nick);
		return pullBlackUserByUid(uid);
	}

	/**
	 * 根据uid把用户拉黑
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	public int pullBlackUserByUid(Integer uid) throws SQLException {
		if (uid != null) {
			AbsAtom atom = new AbsAtom() {
				@Override
				public boolean run() throws SQLException {
					updateUserStatus(uid, User.Status.INBLACK);
					return true;
				}
			};

			boolean flag = false;
			try {
				flag = atom.run();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (flag) {
				return 1;
			}
		}
		return 0;
	}

	/**
	 * 根据用户昵称将用户的状态改为正常
	 * @param nick
	 * @return
	 */
	public int normalUserByNick(String nick) {
		Integer uid = getUidByNick(nick);
		return normalUserByUid(uid);
	}

	/**
	 * 根据uid将用户的状态改为正常
	 * @param uid
	 * @return
	 */
	public int normalUserByUid(Integer uid) {
		return updateUserStatus(uid, org.tio.sitexxx.service.model.main.User.Status.NORMAL);
	}

	/**
	 * 根据昵称找到uid
	 * @param nick
	 * @return
	 */
	public Integer getUidByNick(String nick) {
		if (StrUtil.isBlank(nick)) {
			return null;
		}
		ICache cache = Caches.getCache(CacheConfig.TIME_TO_LIVE_SECONDS_5);
		String key = "user_nick_id" + RedisCache.SPLIT_FOR_CACHENAME + nick;
		Integer uid = CacheUtils.get(cache, key, true, new FirsthandCreater<Integer>() {
			@Override
			public Integer create() {
				String sql = "select id from user where nick = ?";
				return Db.use(Const.Db.TIO_SITE_MAIN).queryInt(sql, nick);
			}
		});
		return uid;
	}

	public User getByNick(String nick) {
		Integer uid = getUidByNick(nick);
		if (uid != null) {
			return getById(uid);
		}
		return null;
	}

	/**
	 * 根据ipid获取这个用户可能是谁
	 * @param ipid
	 * @return
	 */
	public Integer getUidByIpid(Integer ipid) {
		if (ipid == null) {
			return null;
		}
		String sql = "SELECT uid FROM `tio_token_path_access_stat` where ipid=? and uid is not null order by firstAccessTime desc LIMIT 0, 1";
		return Db.use(Const.Db.TIO_SITE_STAT).queryInt(sql, ipid);
	}

	/**
	 * 完善一下评论列表/博客列表等中的个人信息
	 * @param record
	 * @param ext
	 * @param uidKey
	 */
	public static void completeUser(Record record, Map<String, Object> ext, String uidKey) {
		Integer uid = record.getInt(uidKey);
		if (uid != null) {
			String uidStr = org.tio.utils.hutool.StrUtil.int2Str(uid);
			if (ext.get(uidStr) != null) {
				return;
			}
			User user = UserService.ME.getById(uid);
			if (user != null) {
				Kv kv = Kv.by("nick", user.getNick()).set("avatar", user.getAvatar()).set("roles", user.getRoles());
				ext.put(uidStr, kv);
			}
		}
	}

	/**
	 * 完善一下评论列表/博客列表等中的个人信息
	 * @param list
	 * @param ext
	 * @param uidKey
	 */
	public static void completeUser(List<Record> list, Map<String, Object> ext, String uidKey) {
		if (list != null) {
			for (Record record : list) {
				UserService.completeUser(record, ext, uidKey);
			}
		}
	}

	/**
	 * 完善一下评论列表/博客列表等中的个人信息
	 * @param page
	 * @param uidKey
	 */
	public static void completeUser(Page<Record> page, String uidKey) {
		List<Record> list = page.getList();
		if (list != null) {
			Map<String, Object> ext = new HashMap<>();
			page.setExt(ext);
			for (Record record : list) {
				UserService.completeUser(record, ext, uidKey);
			}
		}
	}

	/**
	 * 用户是否包含某种角色
	 * @param user
	 * @param code
	 * @return
	 */
	public static boolean hasRole(User user, Byte code) {
		return UserRoleService.hasRole(user, code);
	}

	/**
	 * 根据登录名或昵称获取用户
	 * @param loginname
	 * @param nick
	 * @return
	 */
	public static User getByLoginnameOrNick(String loginname, String nick) {
		User user = null;
		if (StrUtil.isNotBlank(loginname)) {
			user = UserService.ME.getByLoginname(loginname, Const.Status.NORMAL);
		} else {
			user = UserService.ME.getByNick(nick);
		}
		return user;
	}

	/**
	 * 获取两个userid的key
	 * @param uid1
	 * @param uid2
	 * @return
	 */
	public static String twoUid(Integer uid1, Integer uid2) {
		return Math.max(uid1, uid2) + "_" + Math.min(uid1, uid2);
	}

	public static List<Integer> robots = null;

	public void initRobot() {
		if (robots != null) {
			return;
		}

		try {
			LockUtils.runWriteOrWaitRead(UserService.class.getName() + ".initRobot", this, () -> {
				if (robots != null) {
					return;
				}
				int maxId = 23356;
				int count = 2000;
				int start = 0;
				List<Integer> list = Db.use(Const.Db.TIO_SITE_MAIN).query("select id from user where id <= ? limit ?,?", maxId, start, count);
				robots = list;

			});
		} catch (Exception e) {
			log.error("", e);
		}
	}

	/**
	 * 用户信息同步数据
	 * @param uid
	 * @param type
	 * @param bizStr
	 * @author xufei
	 * 2020年3月16日 上午10:28:08
	 */
	public void initSynInfo(Integer uid, Byte type, String bizStr, Long bizbigint) {
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					UserInfoSyn infoSyn = new UserInfoSyn();
					switch (type) {
					case Const.UserToImSynType.NICK:
						infoSyn.setBizstr(bizStr);
						break;
					case Const.UserToImSynType.AVATAR:
						infoSyn.setBizstr(bizStr);
						break;
					case Const.UserToImSynType.GROUP_NICK:
						infoSyn.setBizstr(bizStr);
						infoSyn.setBizbigint(bizbigint);
						break;
					default:
						break;
					}
					infoSyn.setType(type);
					infoSyn.setUid(uid);
					infoSyn.replaceSave();
				} catch (Exception e) {
					log.error(e.toString(), e);
				}
			}
		});
	}

	/**
	 * 用户登录统计-存在内存溢出风险-后续如果登录人数很多，可进行优化
	 * @param date
	 * @author xufei
	 * 2020年7月16日 下午2:56:47
	 */
	public void loginTimeStat(Date date) {
		DateTime dateTime = DateUtil.offsetDay(date, -1);
		String dayPeriod = PeriodUtils.dateToPeriodByType(dateTime, Const.PeriodType.DAY);
		List<Record> records = Db.use(Const.Db.TIO_SITE_MAIN).find("select dayperiod,count(DISTINCT uid) uidcount,count(1) logincount from login_log where dayperiod =?",
		        dayPeriod);
		if (CollectionUtil.isEmpty(records)) {
			return;
		}
		int usercount = records.get(0).getInt("uidcount");
		int totalcount = records.get(0).getInt("logincount");
		if (usercount == 0 || totalcount == 0) {
			return;
		}
		UserTimeLoginStat daystat = new UserTimeLoginStat();
		daystat.setUid(-1);
		daystat.setDayperiod(dayPeriod);
		daystat.setUsercount(usercount);
		daystat.setTotalcount(totalcount);
		daystat.setRemark("天统计");
		daystat.replaceSave();
		List<Record> userLogins = Db.use(Const.Db.TIO_SITE_MAIN).find("select  uid,count(1) logincount from login_log where dayperiod = ? group by uid", dayPeriod);
		if (CollectionUtil.isEmpty(userLogins)) {
			log.error("登录统计异常：用户登录记录不存在");
			return;
		}
		for (Record userLogin : userLogins) {
			Integer uid = userLogin.getInt("uid");
			int count = userLogin.getInt("logincount");
			List<Record> hourLogins = Db.use(Const.Db.TIO_SITE_MAIN)
			        .find("select hourperiod,count(1) hourcount from login_log where dayperiod = ?  and uid = ? group by hourperiod", dayPeriod, uid);
			if (CollectionUtil.isEmpty(hourLogins)) {
				log.error("登录统计异常：用户登录记录不存在-小时");
				continue;
			}
			UserTimeLoginStat userStat = new UserTimeLoginStat();
			userStat.setUid(uid);
			userStat.setDayperiod(dayPeriod);
			userStat.setTotalcount(count);
			for (Record hourLogin : hourLogins) {
				dateToLoginStat(userStat, hourLogin.getStr("hourperiod"), hourLogin.getInt("hourcount"));
			}
			userStat.replaceSave();
			//用户总统计
			UserTimeLoginStat record = UserTimeLoginStat.dao.findFirst("select  * from user_time_login_stat where uid = ? and dayperiod = -1", uid);
			if (record == null) {
				record = new UserTimeLoginStat();
				record.setUid(uid);
				record.setDayperiod("-1");
				record.setUsercount(1);
				record.setTotalcount(count);
				record.setRemark("用户总统计");
				record.replaceSave();
			} else {
				Db.use(Const.Db.TIO_SITE_STAT).update("update user_time_login_stat set totalcount = totalcount + ? where id = ? ", count, record.getId());
			}
		}
	}

	/**
	 * 单词登录时间统计
	 * @param loginLog
	 * @author xufei
	 * 2020年7月30日 下午3:15:46
	 */
	public void singleLoginTimeStat(LoginLog loginLog) {
		String dayPeriod = PeriodUtils.dateToPeriodByType(loginLog.getTime(), Const.PeriodType.DAY);
		//用户天统计
		Integer uid = loginLog.getUid();
		boolean userInit = false;
		UserTimeLoginStat userStat = UserTimeLoginStat.dao.findFirst("select  * from user_time_login_stat where uid = ? and dayperiod = ?", uid, dayPeriod);
		if (userStat == null) {
			userStat = new UserTimeLoginStat();
			userStat.setUid(uid);
			userStat.setDayperiod(dayPeriod);
			userStat.setTotalcount(0);
			userStat.setUsercount(1);
			int save = userStat.ignoreSave();
			if (save <= 0) {
				userInit = true;
			}
		} else {
			userInit = true;
		}
		String hourPeriod = loginLog.getHourperiod();
		Db.use(Const.Db.TIO_SITE_STAT).update("update user_time_login_stat set totalcount = totalcount + 1,hour" + Integer.parseInt(hourPeriod) + " = hour"
		        + Integer.parseInt(hourPeriod) + " + 1 where uid = ? and dayperiod = ?", uid, dayPeriod);
		//用户总统计
		UserTimeLoginStat record = UserTimeLoginStat.dao.findFirst("select  * from user_time_login_stat where uid = ? and dayperiod = -1", uid);
		if (record == null) {
			record = new UserTimeLoginStat();
			record.setUid(uid);
			record.setDayperiod("-1");
			record.setUsercount(1);
			record.setTotalcount(1);
			record.setRemark("用户总统计");
			if (record.ignoreSave() <= 0) {
				Db.use(Const.Db.TIO_SITE_STAT).update("update user_time_login_stat set totalcount = totalcount + 1 where uid = ? and dayperiod = -1", uid);
			}
		} else {
			Db.use(Const.Db.TIO_SITE_STAT).update("update user_time_login_stat set totalcount = totalcount + 1 where id = ? ", record.getId());
		}
		//天总统计
		UserTimeLoginStat daystat = UserTimeLoginStat.dao.findFirst("select  * from user_time_login_stat where uid = -1 and dayperiod = ?", dayPeriod);
		if (daystat == null) {
			daystat = new UserTimeLoginStat();
			daystat.setUid(-1);
			daystat.setDayperiod(dayPeriod);
			daystat.setUsercount(1);
			daystat.setTotalcount(1);
			daystat.setRemark("天统计");
			if (daystat.ignoreSave() <= 0) {
				if (userInit) {
					Db.use(Const.Db.TIO_SITE_STAT).update("update user_time_login_stat set totalcount = totalcount + 1 where uid = -1 and dayperiod = ?", dayPeriod);
				} else {
					Db.use(Const.Db.TIO_SITE_STAT).update("update user_time_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where uid = -1 and dayperiod = ?",
					        dayPeriod);
				}
			}
		} else {
			if (userInit) {
				Db.use(Const.Db.TIO_SITE_STAT).update("update user_time_login_stat set totalcount = totalcount + 1 where id = ?", daystat.getId());
			} else {
				Db.use(Const.Db.TIO_SITE_STAT).update("update user_time_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = ?", daystat.getId());
			}
		}

	}

	/**
	 * @param date
	 * @author xufei
	 * 2020年7月16日 下午3:44:56
	 */
	public void loginIpStat(Date date) {
		DateTime dateTime = DateUtil.offsetDay(date, -1);
		String dayPeriod = PeriodUtils.dateToPeriodByType(dateTime, Const.PeriodType.DAY);
		//总统计数
		List<Record> records = Db.use(Const.Db.TIO_SITE_MAIN)
		        .find("select ip,ipid,count(1) totalcount,count(DISTINCT uid) uidcount from login_log where dayperiod = ? GROUP BY ip,ipid", dayPeriod);
		if (CollectionUtil.isEmpty(records)) {
			return;
		}
		for (Record ipRecord : records) {
			String ip = ipRecord.getStr("ip");
			Integer ipid = ipRecord.getInt("ipid");
			int uidcount = ipRecord.getInt("uidcount");
			int totalcount = ipRecord.getInt("totalcount");
			//ip统计数是否存在
			UserIpLoginStat ipstat = UserIpLoginStat.dao.findFirst("select * from user_ip_login_stat where ip = ? and uid = -1 and dayperiod = '-1'", ip);
			boolean isInit = false;
			if (ipstat == null) {
				isInit = true;
				ipstat = new UserIpLoginStat();
				ipstat.setIp(ip);
				ipstat.setIpid(ipid);
				ipstat.setUsercount(uidcount);
				ipstat.setTotalcount(totalcount);
				ipstat.setDayperiod("-1");
				ipstat.setUid(-1);
				ipstat.replaceSave();
			}
			//ip下的用户列表
			List<Record> useRecords = Db.use(Const.Db.TIO_SITE_MAIN).find("select uid,count(1) logincount from login_log where dayperiod = ? and ip = ? GROUP BY uid", dayPeriod,
			        ip);
			if (CollectionUtil.isEmpty(useRecords)) {
				log.error("登录统计异常：用户登录记录不存在-ip");
				return;
			}
			//莫一天的统计
			UserIpLoginStat daystat = new UserIpLoginStat();
			daystat.setUid(-1);
			daystat.setDayperiod(dayPeriod);
			daystat.setIp(ip);
			daystat.setIpid(ipid);
			daystat.setUsercount(uidcount);
			daystat.setTotalcount(totalcount);
			daystat.setRemark("天统计");
			daystat.replaceSave();
			for (Record userLogin : useRecords) {
				Integer uid = userLogin.getInt("uid");
				int userLoginCount = userLogin.getInt("logincount");
				//一个用户的小时统计
				List<Record> hourLogins = Db.use(Const.Db.TIO_SITE_MAIN)
				        .find("select hourperiod,count(1) hourcount from login_log  where dayperiod = ? and ip = ? and uid = ? group by hourperiod", dayPeriod, ip, uid);
				if (CollectionUtil.isEmpty(hourLogins)) {
					log.error("登录统计异常：用户登录记录不存在-小时-ip");
					continue;
				}
				UserIpLoginStat userStat = new UserIpLoginStat();
				userStat.setUid(uid);
				userStat.setTotalcount(userLoginCount);
				userStat.setDayperiod(dayPeriod);
				userStat.setIp(ip);
				userStat.setIpid(ipid);
				for (Record hourLogin : hourLogins) {
					dateToLoginStat(userStat, hourLogin.getStr("hourperiod"), hourLogin.getInt("hourcount"));
				}
				userStat.replaceSave();
			}
			if (!isInit) {
				//更新总统计
				Record record = Db.use(Const.Db.TIO_SITE_STAT).findFirst("select count(DISTINCT uid) ipuidcount from user_ip_login_stat where ip = ? and uid != -1", ip);
				if (record == null) {
					log.error("登录统计异常：总记录更新异常");
					continue;
				}
				int totaluid = record.getInt("ipuidcount");
				if (totaluid == 0) {
					log.error("登录统计异常：总记录更新异常,统计总数为0");
					continue;
				}
				UserIpLoginStat ipStatUpdate = new UserIpLoginStat();
				ipStatUpdate.setId(ipstat.getId());
				ipStatUpdate.setUsercount(totaluid);
				ipStatUpdate.setTotalcount(ipstat.getTotalcount() + totalcount);
				ipStatUpdate.update();
			}
		}
	}

	/**
	 * 单次登录ip统计
	 * @param loginLog
	 * @author xufei
	 * 2020年7月30日 下午3:45:20
	 */
	public void singleLoginIpStat(LoginLog loginLog) {
		String dayPeriod = PeriodUtils.dateToPeriodByType(loginLog.getTime(), Const.PeriodType.DAY);
		String ip = loginLog.getIp();
		Integer ipid = loginLog.getIpid();
		//用户统计
		Integer uid = loginLog.getUid();
		boolean userInit = false;
		UserIpLoginStat userStat = UserIpLoginStat.dao.findFirst("select * from user_ip_login_stat where ip = ? and uid = ? and dayperiod = ?", ip, uid, dayPeriod);
		if (userStat == null) {
			userStat = new UserIpLoginStat();
			userStat.setUid(uid);
			userStat.setTotalcount(0);
			userStat.setDayperiod(dayPeriod);
			userStat.setIp(ip);
			userStat.setIpid(ipid);
			int save = userStat.ignoreSave();
			if (save <= 0) {
				userInit = true;
			}
		} else {
			userInit = true;
		}
		String hourPeriod = loginLog.getHourperiod();
		hourPeriod = "01";
		Db.use(Const.Db.TIO_SITE_STAT).update("update user_ip_login_stat set totalcount = totalcount + 1,hour" + Integer.parseInt(hourPeriod) + " = hour"
		        + Integer.parseInt(hourPeriod) + " + 1 where ip = ? and uid = ? and dayperiod = ?", ip, uid, dayPeriod);

		//ip天统计
		UserIpLoginStat daystat = UserIpLoginStat.dao.findFirst("select * from user_ip_login_stat where ip = ? and uid = -1 and dayperiod = ?", ip, dayPeriod);
		if (daystat == null) {
			daystat = new UserIpLoginStat();
			daystat.setUid(-1);
			daystat.setDayperiod(dayPeriod);
			daystat.setIp(ip);
			daystat.setIpid(ipid);
			daystat.setUsercount(1);
			daystat.setTotalcount(1);
			daystat.setRemark("天统计");
			if (daystat.ignoreSave() <= 0) {
				if (userInit) {
					Db.use(Const.Db.TIO_SITE_STAT).update("update user_ip_login_stat set totalcount = totalcount + 1 where ip = ? and uid = -1 and dayperiod = ?", ip, dayPeriod);
				} else {
					Db.use(Const.Db.TIO_SITE_STAT).update(
					        "update user_ip_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where ip = ? and uid = -1 and dayperiod = ?", ip, dayPeriod);
				}
			}
		} else {
			if (userInit) {
				Db.use(Const.Db.TIO_SITE_STAT).update("update user_ip_login_stat set totalcount = totalcount + 1 where id = ?", daystat.getId());
			} else {
				Db.use(Const.Db.TIO_SITE_STAT).update("update user_ip_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = ?", daystat.getId());
			}
		}
		//ip总统计
		UserIpLoginStat ipstat = UserIpLoginStat.dao.findFirst("select * from user_ip_login_stat where ip = ? and uid = -1 and dayperiod = '-1'", ip);
		if (ipstat == null) {
			ipstat = new UserIpLoginStat();
			ipstat.setIp(ip);
			ipstat.setIpid(ipid);
			ipstat.setUsercount(1);
			ipstat.setTotalcount(1);
			ipstat.setDayperiod("-1");
			ipstat.setUid(-1);
			if (ipstat.ignoreSave() <= 0) {
				if (userInit) {
					Db.use(Const.Db.TIO_SITE_STAT).update("update user_ip_login_stat set totalcount = totalcount + 1 where ip = ? and uid = -1 and dayperiod = '-1'", ip);
				} else {
					Db.use(Const.Db.TIO_SITE_STAT)
					        .update("update user_ip_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where ip = ? and uid = -1 and dayperiod = '-1'", ip);
				}
			}
		} else {
			if (userInit) {
				Db.use(Const.Db.TIO_SITE_STAT).update("update user_ip_login_stat set totalcount = totalcount + 1 where id = ?", ipstat.getId());
			} else {
				Db.use(Const.Db.TIO_SITE_STAT).update("update user_ip_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = ?", ipstat.getId());
			}
		}
	}

	/**
	 * 单独登录统计处理
	 * @param loginLog
	 * @author xufei
	 * 2020年7月30日 下午3:50:39
	 */
	public void singleLoginInit(LoginLog loginLog) {
		Integer threadid = StatService.me.threadInit(loginLog.getId(), "", Const.ThreadLogType.LOGIN_STAT);
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					AbsTxAtom absTxAtom = new AbsTxAtom() {

						@Override
						public boolean noTxRun() {
							singleLoginIpStat(loginLog);
							singleLoginTimeStat(loginLog);
							return true;
						}
					};
					boolean save = Db.use(Const.Db.TIO_SITE_STAT).tx(absTxAtom);
					if (!save) {
						return;
					}
					StatService.me.threadDeal(threadid);
				} catch (Exception e) {
					log.error(e.toString(), e);
				}
			}
		});
	}

	/**
	 * 
	 * @author xufei
	 * 2020年7月16日 下午6:06:13
	 */
	public void loginInit() {
		Db.use(Const.Db.TIO_SITE_STAT).update("truncate table user_ip_login_stat");
		Db.use(Const.Db.TIO_SITE_STAT).update("truncate table user_time_login_stat");
		Record maxRecord = Db.use(Const.Db.TIO_SITE_MAIN).findFirst("select min(time) mintime from login_log");
		if (maxRecord == null) {
			return;
		}
		Date date = maxRecord.getDate("mintime");
		DateTime begiTime = DateUtil.beginOfDay(date);
		DateTime startime = DateUtil.offsetDay(begiTime, 1);
		DateTime curTime = DateUtil.beginOfDay(new Date());
		int count = 0;
		long start = System.currentTimeMillis();
		log.error("开始登录日志计算：{}", begiTime);
		while (curTime.getTime() >= startime.getTime()) {
			loginTimeStat(startime);
			loginIpStat(startime);
			startime = DateUtil.offsetDay(startime, 1);
			count++;
		}
		long end = System.currentTimeMillis();
		long exe = (end - start) / (60 * 1000);
		log.error("登录日志计算，次数：" + count + ",总时间：" + exe + ",开始日期 (+1)：" + begiTime + ",结束日期：" + startime);
	}

	/**
	 * @param stat
	 * @param field
	 * @param value
	 * @author xufei
	 * 2020年7月16日 下午3:08:11
	 */
	public static void dateToLoginStat(UserTimeLoginStat stat, String field, int value) {
		switch (field) {
		case "00":
			stat.setHour0(value);
			break;

		case "01":
			stat.setHour1(value);
			break;
		case "02":
			stat.setHour2(value);
			break;
		case "03":
			stat.setHour3(value);
			break;
		case "04":
			stat.setHour4(value);
			break;
		case "05":
			stat.setHour5(value);
			break;
		case "06":
			stat.setHour6(value);
			break;
		case "07":
			stat.setHour7(value);
			break;
		case "08":
			stat.setHour8(value);
			break;
		case "09":
			stat.setHour9(value);
			break;
		case "10":
			stat.setHour10(value);
			break;
		case "11":
			stat.setHour11(value);
			break;
		case "12":
			stat.setHour12(value);
			break;
		case "13":
			stat.setHour13(value);
			break;
		case "14":
			stat.setHour14(value);
			break;
		case "15":
			stat.setHour15(value);
			break;
		case "16":
			stat.setHour16(value);
			break;
		case "17":
			stat.setHour17(value);
			break;
		case "18":
			stat.setHour18(value);
			break;
		case "19":
			stat.setHour19(value);
			break;
		case "20":
			stat.setHour20(value);
			break;
		case "21":
			stat.setHour21(value);
			break;
		case "22":
			stat.setHour22(value);
			break;
		case "23":
			stat.setHour23(value);
			break;
		default:
			break;
		}
	}

	/**
	 * @param stat
	 * @param field
	 * @param value
	 * @author xufei
	 * 2020年7月16日 下午4:00:30
	 */
	public static void dateToLoginStat(UserIpLoginStat stat, String field, int value) {
		switch (field) {
		case "00":
			stat.setHour0(value);
			break;

		case "01":
			stat.setHour1(value);
			break;
		case "02":
			stat.setHour2(value);
			break;
		case "03":
			stat.setHour3(value);
			break;
		case "04":
			stat.setHour4(value);
			break;
		case "05":
			stat.setHour5(value);
			break;
		case "06":
			stat.setHour6(value);
			break;
		case "07":
			stat.setHour7(value);
			break;
		case "08":
			stat.setHour8(value);
			break;
		case "09":
			stat.setHour9(value);
			break;
		case "10":
			stat.setHour10(value);
			break;
		case "11":
			stat.setHour11(value);
			break;
		case "12":
			stat.setHour12(value);
			break;
		case "13":
			stat.setHour13(value);
			break;
		case "14":
			stat.setHour14(value);
			break;
		case "15":
			stat.setHour15(value);
			break;
		case "16":
			stat.setHour16(value);
			break;
		case "17":
			stat.setHour17(value);
			break;
		case "18":
			stat.setHour18(value);
			break;
		case "19":
			stat.setHour19(value);
			break;
		case "20":
			stat.setHour20(value);
			break;
		case "21":
			stat.setHour21(value);
			break;
		case "22":
			stat.setHour22(value);
			break;
		case "23":
			stat.setHour23(value);
			break;
		default:
			break;
		}
	}

	/**
	 * 
	 * @return
	 */
	public User nextRobot() {
		if (CollUtil.isNotEmpty(robots)) {
			Integer uid = RandomUtil.randomEle(robots);
			return getById(uid);
		}
		return null;
	}

	/***
	 * 判断该手机号是否注册
	 * @param mobile
	 * @return
	 */
    public boolean isRegister(String mobile) {
		String sql = "select * from user where phone=?";
		User user = User.dao.findFirst(sql, mobile);
		if(user!=null){
			return true;
		}
		return false;
	}
}
