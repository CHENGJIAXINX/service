/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.service.base;

import java.net.URLEncoder;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.StrKit;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.mg.service.cache.CacheConfig;
import org.tio.mg.service.cache.Caches;
import org.tio.mg.service.model.main.EmailSendLog;
import org.tio.mg.service.model.main.Role;
import org.tio.mg.service.model.main.User;
import org.tio.mg.service.model.main.UserBase;
import org.tio.mg.service.model.main.UserCoin;
import org.tio.mg.service.model.main.UserRole;
import org.tio.mg.service.service.atom.RegisterAtom;
import org.tio.mg.service.service.conf.AvatarService;
import org.tio.mg.service.service.conf.MgConfService;
import org.tio.mg.service.utils.CommonUtils;
import org.tio.mg.service.utils.EmailKit;
import org.tio.mg.service.vo.RequestExt;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.cache.ICache;
import org.tio.utils.resp.Resp;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;

/**
 * @author tanyaowu
 * 2016年8月10日 上午11:09:59
 */
public class RegisterService {
	private static Logger log = LoggerFactory.getLogger(RegisterService.class);

	public static final RegisterService me = new RegisterService();

	public static final UserService userService = UserService.ME;

	final User userDao = new User().dao();

	/**
	 * 存邮箱激活码
	 */
	public ICache emailAuthCodeCache = null;

	/**
	 *
	 * @author tanyaowu
	 */
	private RegisterService() {
		emailAuthCodeCache = Caches.getCache(CacheConfig.EMAIL_AUTHCODE);
	}

	/**
	 * 昵称是否已被注册
	 */
	public boolean isNickExists(String nick) {
		nick = nick.toLowerCase().trim();
		return Db.use(Const.Db.TIO_SITE_MAIN).queryInt("select id from user where nick = ? limit 1", nick) != null;
	}

	/**
	 *
	 * @param user
	 * @param needCheck
	 * @return
	 * @throws Exception
	 */
	public Resp innerEmailRegister(User user, boolean needCheck) throws Exception {
		Resp resp = null;
		if (needCheck) {
			user.setAgreement("true");
			resp = regCheckAndSet(user, 1);
		} else {
			resp = Resp.ok();
		}

		if (resp.isOk()) {
			RegisterAtom registerUserAtom = new RegisterAtom(user);
			boolean relsut = Db.tx(registerUserAtom);
			if (relsut) {
				userService.notifyClearCache(user.getId());
				return Resp.ok(registerUserAtom.getMsg()).data(Kv.by("loginname", user.getLoginname()).set("id", user.getId()).set("user", user));
			} else {
				return Resp.fail(registerUserAtom.getMsg());
				//				User user1 = userService.getByLoginname(user.getLoginname(), null);
				//				if (user1 != null) {
				//					return Resp.fail("该帐号已经被激活过了，请直接登录");
				//				} else {
				//					return Resp.fail("帐号激活失败");
				//				}
			}
		} else {
			return resp;
		}
	}

	/**
	 * 激活账号，返回 false 表示激活码已过期或者不存在
	 * 激活账号不要去自动登录，激活邮件如果发错到了别人的邮箱，会有别人冒用的可能
	 * 并且登录功能还有额外有选择过期时间的功能
	 * @throws Exception
	 */
	public Resp activate(String authCode) throws Exception {
		User user = (User) emailAuthCodeCache.get(authCode);
		if (user != null) {
			emailAuthCodeCache.remove(authCode);
			return innerEmailRegister(user, false);
		} else {
			return Resp.fail("激活码不存在或已经失效或已经激活过了");
		}
	}

	/**
	 * 用户名是否已被注册
	 */
	public boolean isLoginnameExists(String loginname) {
		loginname = loginname.trim();
		User user = userService.getByLoginname(loginname, null);
		return user != null;
	}

	/**
	 * 找回密码
	 * @param loginname
	 * @param clientIp
	 * @param sessionid
	 * @param requestExt
	 * @return
	 * @throws Exception
	 * @author tanyaowu
	 */
	public Resp retrievePwd(String loginname, String clientIp, String sessionid, RequestExt requestExt) throws Exception {
		User user = UserService.ME.getByLoginname(loginname, Const.Status.NORMAL);
		if (user == null) {
			return Resp.fail("帐号不存在");
		}

		String authCode = StrKit.getRandomUUID();
		emailAuthCodeCache.put(authCode, loginname);

		String title = "t-io官网密码找回";

		String url = Const.SITE + "/user/forget/setNewPwd.html?authCode=" + URLEncoder.encode(authCode, "utf-8") + "&loginname=" + URLEncoder.encode(loginname, "utf-8");
		String content = "点击设置新密码：<a href='" + url + "'>" + url + "</a>";
		boolean f = sendAuthEmail((byte) 2, title, content, authCode, loginname, clientIp, sessionid, requestExt);

		if (f) {
			return Resp.ok().msg("重置密码链接已经发到邮箱" + loginname + "，有效时间为" + (emailAuthCodeCache.getTimeToLiveSeconds() / 60) + "分钟（邮件可能在您的垃圾邮箱）");
		} else {
			emailAuthCodeCache.remove(authCode);
			return Resp.fail("邮件发送不成功");
		}
	}

	/**
	 * @param authCode
	 * @param newpwd
	 * @return
	 */
	public Resp setNewPwd(String authCode, String newpwd) {
		String loginname = (String) emailAuthCodeCache.get(authCode);
		if (StrUtil.isBlank(loginname)) {
			return Resp.fail("修改密码的授权码不存在或已经失效");
		}
		emailAuthCodeCache.remove(authCode);
		String encodedPwd = newpwd;//UserService.getMd5Pwd(loginname, newpwd);

		String sql = "update user set pwd=? where loginname = ?";
		int r = Db.use(Const.Db.TIO_SITE_MAIN).update(sql, encodedPwd, loginname);
		if (r == 1) {
			User user = UserService.ME.getByLoginname(loginname, Const.Status.NORMAL);
			if (user != null) {
				UserService.ME.notifyClearCache(user.getId());
				Kv kv = Kv.by("loginname", loginname).set("pwd", newpwd);
				return Resp.ok(kv);
			} else {
				return Resp.fail("密码修改失败（找不到用户）");
			}

		} else {
			return Resp.fail("密码修改失败");
		}
	}

	/**
	 *
	 * @param user
	 * @param clientIp
	 * @param sessionid
	 * @return
	 * @throws Exception
	 */
	public Resp emailRegister(User user, String clientIp, String sessionid, RequestExt requestExt) throws Exception {

		Resp resp = regCheckAndSet(user, 1);
		if (resp.isOk()) {
			String authCode = StrKit.getRandomUUID();
			emailAuthCodeCache.put(authCode, user);

			String title = "t-io社区用户[" + user.getNick() + "]激活邮件";

			String url = Const.SITE + "/email/index.html?authCode=" + URLEncoder.encode(authCode, "utf-8");
			String content = "<div>亲爱的" + user.getNick() + "，欢迎成为t-io家庭第<span style='color:#FF5722;font-weight: bold; padding: 2px 5px;'>" + (UserService.ME.getUserCount() + 1)
			        + "</span>位成员：";
			//					content += "<div>友情提醒：现在激活，您大约是t-io社区第<span style='color:#FF5722;font-weight: bold; padding: 2px 5px;'>" + (UserService.ME.getUserCount() + 1) + "</span>位用户</div>";

			content += "<span style='color:#FF5722; font-weight: bold; font-size:16px;'><a style='text-decoration:none' href='" + url + "' target='_blank'>点击激活</a></span></div>";

			boolean f = sendAuthEmail((byte) 1, title, content, authCode, user.getLoginname(), clientIp, sessionid, requestExt);

			if (f) {
				return Resp.ok().msg("注册申请成功，激活链接已发送到您的注册邮箱" + user.getLoginname() + "，有效时间为" + (emailAuthCodeCache.getTimeToLiveSeconds() / 60) + "分钟（邮件可能在您的垃圾邮箱）");
			} else {
				emailAuthCodeCache.remove(authCode);
				return Resp.fail("激活邮件发送不成功，注册失败");
			}
		} else {
			return resp;
		}

		//////////////////////////
		//		String authCode = StrKit.getRandomUUID();
		//		emailAuthCodeCache.put(authCode, user);
		//
		//		if (sendRegActivateAuthEmail(authCode, user.getLoginname())) {
		//			return Resp.ok().msg("注册申请成功，激活链接已发送到您的注册邮箱，请查收并尽快去邮箱激活");
		//		} else {
		//			emailAuthCodeCache.remove(authCode);
		//			return Resp.fail("注册成功，但是激活邮件发送失败，可能是邮件服务器出现故障，抱歉！");
		//		}
	}

	/**
	 * 注册前字段检查和字段值设置
	 * @param user
	 * @param regType 注册类型：1、邮箱，2、短信
	 * @return
	 * @throws Exception
	 */
	public Resp regCheckAndSet(User user, int regType) throws Exception {
		String loginname = StrUtil.trim(user.getLoginname());
		String pwd = StrUtil.trim(user.getPwd());
		//		String pwd2 = StrUtil.trim(user.getPwd2());
		String nick = StrUtil.trim(user.getNick());

		if (StrKit.isBlank(user.getAgreement())) {
			return Resp.fail("您必须 [同意用户服务条款] 才能注册");
		}

		if (StrKit.isBlank(pwd)) {
			return Resp.fail("密码不能为空");
		}

		//		if (!Objects.equals(pwd, pwd2)) {
		//			return Resp.fail("两次密码不一致");
		//		}

		Resp resp = CommonUtils.checkGroupName(nick, "昵称");
		if (!resp.isOk()) {
			return resp;
		}

		if (regType == 1) {
			if (loginname.length() > 48) {
				return Resp.fail("邮箱过长");
			}
			if (!Validator.isEmail(loginname)) {
				return Resp.fail("不是合法的邮箱");
			}
		} else {
			if (!Validator.isMobile(loginname)) {
				return Resp.fail("不是合法的手机号码");
			}
		}

		if (StrKit.isBlank(nick)) {
			return Resp.fail("昵称不能为空");
		}

		if (isNickExists(nick)) {
			return Resp.fail("昵称已被注册，请换一个昵称");
		}

		if (isLoginnameExists(loginname)) {
			return Resp.fail("该账号已注册，如忘记密码，请找回");
		}

		user.setLoginname(loginname);
		user.setNick(nick);

		//		pwd = UserService.getMd5Pwd(user.getLoginname(), pwd);
		//		user.setPwd(pwd);
		user.setStatus(org.tio.mg.service.model.main.User.Status.NORMAL);
		user.setCreatetime(new Date());
		user.setThirdstatus(Const.UserThirdStatus.NORMAL);
		if (StrUtil.isBlank(user.getAvatar())) {
			String avatar = AvatarService.nextAvatar();
			user.setAvatar(avatar);
			user.setAvatarbig(avatar);
		}
		return Resp.ok();
	}

	/**
	 * 初始化角色信息
	 * @param user
	 * @return
	 *
	 */
	public boolean initRole(User user) {
		UserRole userRoleRel = new UserRole();
		userRoleRel.setUid(user.getId());
		userRoleRel.setRid(Role.NORMAL);
		userRoleRel.setStatus(Const.Status.NORMAL);
		boolean roleResult = userRoleRel.save();

		//		//如果是华为公司邮箱注册的，自动开通文档阅读权限
		//		if (user.getLoginname().endsWith("@huawei.com")) {
		//			userRoleRel.setRid(Role.ALLOW_READ_DOC);
		//			userRoleRel.setId(null);
		//			userRoleRel.save();
		//		}

		return roleResult;
	}

	/**
	 * 初始化财务信息
	 * @param user
	 * @return
	 *
	 */
	public boolean initCoinInfo(User user) {
		UserCoin coinInfo = new UserCoin();
		coinInfo.setUid(user.getId());
		boolean coinResult = coinInfo.save();
		return coinResult;
	}

	/**
	 * 初始化基础信息
	 * @param user
	 * @return
	 *
	 */
	public boolean initBaseInfo(User user) {
		UserBase baseInfo = new UserBase();
		baseInfo.setUid(user.getId());
		if (user.getUserThird() != null) {
			baseInfo.setPhone("");
		} else {
			baseInfo.setEmail(user.getLoginname());
		}
		boolean baseResult = baseInfo.save();
		return baseResult;
	}

	/**
	 * 通过邮箱发送授权码
	 * @param type 1:注册， 2：密码找回
	 * @param title
	 * @param content
	 * @param authCode
	 * @param email
	 * @param clientIp
	 * @param sessionid
	 * @param requestExt
	 * @return
	 * @throws Exception
	 * @author tanyaowu
	 */
	public boolean sendAuthEmail(byte type, String title, String content, String authCode, String email, String clientIp, String sessionid, RequestExt requestExt)
	        throws Exception {
		synchronized (RegisterService.class) {
			ICache cache = Caches.getCache(CacheConfig.EMAIL_SENT_COUNT_PERIP_PERDAY);
			Integer count = cache.get(clientIp, Integer.class);
			if (count != null) {
				if (count >= MgConfService.getInt("email.reg.maxcount.perip.perday", 10)) {
					log.warn("该IP[{}]邮件发送次数已经达到上限", clientIp);
					return false;
				}
			}

			ICache cache2 = Caches.getCache(CacheConfig.EMAIL_SENT_COUNT_PERDAY);
			Integer count2 = cache2.get("x", Integer.class);
			if (count2 != null) {
				if (count2 >= MgConfService.getInt("email.reg.maxcount.perday", 100)) {
					log.warn("邮件发送次数已经达到上限{}", count2);
					return false;
				}
			}

			EmailSendLog emailSendLog = new EmailSendLog();
			emailSendLog.setAuthcode(authCode);
			emailSendLog.setEmailto(email);
			emailSendLog.setIp(clientIp);
			emailSendLog.setIpid(requestExt.getIpInfo().getId());
			emailSendLog.setSession(sessionid);
			if (requestExt.getUserAgent() != null) {
				emailSendLog.setUaid(requestExt.getUserAgent().getId());
			}
			emailSendLog.setCreatetime(new Date());

			try {
//				EmailServer emailServer = EmailServerService.me.next();
//				String server = emailServer.getServer();
//				String fromEmail = emailServer.getEmail();
//				String emailPass = EmailKit.getEmailUserPwd(emailServer.getPwd());
//				String toEmail = email;
//
//				emailSendLog.setContent(content);
//				emailSendLog.setTitle(title);
//				emailSendLog.setType(type);
//				emailSendLog.setEmailfrom(emailServer.getEmail());
//				emailSendLog.setEmailpwd(emailServer.getPwd());
//				emailSendLog.setEmailserver(emailServer.getServer());
//
//				EmailKit.sendEmail(server, fromEmail, emailPass, toEmail, title, content);
//				emailSendLog.setStatus((byte) 1);
			} catch (Throwable e) {
				//					return false;
				log.error("发送邮件失败", e);
				emailSendLog.setStatus((byte) 2);
				return false;
			} finally {
				try {
					emailSendLog.save();
				} catch (Exception e) {
					log.error(e.toString(), e);
				}

				count = cache.get(clientIp, Integer.class);
				if (count == null) {
					count = 1;
				} else {
					if (count < MgConfService.getInt("email.reg.maxcount.perip.perday", 10)) {
						count++;
					}
				}
				cache.put(clientIp, count);

				count2 = cache2.get("x", Integer.class);
				if (count2 == null) {
					count2 = 1;
				} else {
					if (count2 < MgConfService.getInt("email.reg.maxcount.perday", 100)) {
						count2++;
					}
				}
				cache2.put("x", count2);
			}

			return true;
		}

	}

	/**
	 * 初始化谭信好友和谭信群，让用户一进来就有好友
	 * @param user
	 */
	public boolean initWx(User user) {

		return true;

	}

}
