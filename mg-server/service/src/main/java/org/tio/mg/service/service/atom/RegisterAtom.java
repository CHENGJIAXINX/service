/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.service.atom;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.mg.service.cache.CacheConfig;
import org.tio.mg.service.cache.Caches;
import org.tio.mg.service.model.main.User;
import org.tio.mg.service.model.main.UserThird;
import org.tio.mg.service.service.base.RegisterService;
import org.tio.mg.service.service.base.UserService;
import org.tio.mg.service.service.base.UserThirdService;
import org.tio.utils.BinaryUtils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

public class RegisterAtom extends AbsAtom {

	private static Logger log = LoggerFactory.getLogger(RegisterAtom.class);

	private boolean isThird = false;

	private User user;

	public RegisterAtom(User user) {
		this.user = user;
	}
	private String getInviteCode(){
		int i = (int) (Math.random()*100000);
		if (i < 10000){
			i = 10000+i;
		}
		String inviteCode = String.valueOf(i);
		List<User> users = User.dao.find("select * from user where invitecode = ?", inviteCode);
		if (users.size() == 0){
			return inviteCode;
		}
		return getInviteCode();
	}
	@Override
	public boolean run() throws SQLException {
		user.setInvFlag(false);
		if (RegisterService.me.isLoginnameExists(user.getLoginname())) {
			msg = "该账号已注册，如忘记密码，请找回";
			log.error(msg + ",loginname:{},nick:{},pwd:{}", user.getLoginname(), user.getNick(), user.getPwd());
			return false;
		}
		String nick = user.getNick();
		String initNick = nick;

		while (RegisterService.me.isNickExists(nick)) {
			nick += RandomUtil.randomString(RandomUtil.BASE_CHAR, 2);//.randomAlphanumeric(2);
			msg = "您的昵称【" + initNick + "】已经存在，平台已为您生成新的昵称【" + nick + "】，您登录后可在个人中心进行昵称修改，谢谢！";
		}
		user.setNick(nick);

		//		if (isThird) {
		//			while (RegisterService.me.isNickExists(nick)) {
		//				nick += RandomUtil.randomString(RandomUtil.BASE_CHAR, 2);//.randomAlphanumeric(2);
		//			}
		//			user.setNick(nick);
		//		} else if (RegisterService.me.isNickExists(nick)) {
		//			msg = "昵称已被注册，请换一个昵称";
		//			log.error(msg + ",loginname:{},nick:{},pwd:{}", user.getLoginname(), user.getNick(), user.getPwd());
		//			return false;
		//		}
		
		if (UserService.ME.save(user) == null) {
			msg = "账号注册失败：账号信息有误";
			log.error(msg + ",loginname:{},nick:{},pwd:{}", user.getLoginname(), user.getNick(), user.getPwd());
			return false;
		}

//		String inviteCode = BinaryUtils.encode(user.getId());
		String inviteCode = getInviteCode();
		user.setInvitecode(inviteCode);

		user.update();

		if (user.getUserThird() != null) {
			UserThird userThird = user.getUserThird();
			userThird.setUid(user.getId());
			boolean thirdFlag = UserThirdService.me.save(userThird); //userThird.save();

			if (!thirdFlag) {
				msg = "账号注册失败：三方登录关联信息保存异常";
				log.error(msg + ",openid:{},type:{}", userThird.getOpenid(), userThird.getType());
				return false;
			}
		}

		boolean baseResult = RegisterService.me.initBaseInfo(user);
		if (!baseResult) {
			msg = "账号注册失败：基础数据初始化失败";
			log.error(msg + ",loginname:{},nick:{},pwd:{}", user.getLoginname(), user.getNick(), user.getPwd());
			return false;
		}
		boolean coinResult = RegisterService.me.initCoinInfo(user);
		if (!coinResult) {
			msg = "账号注册失败：财务初始化失败";
			log.error(msg + ",loginname:{},nick:{},pwd:{}", user.getLoginname(), user.getNick(), user.getPwd());
			return false;
		}
		boolean roleResult = RegisterService.me.initRole(user);
		if (!roleResult) {
			msg = "账号注册失败：角色数据初始化失败";
			log.error(msg + ",loginname:{},nick:{},pwd:{}", user.getLoginname(), user.getNick(), user.getPwd());
			return false;
		}
		
		RegisterService.me.initWx(user);

		//清空当前用户数
		Caches.getCache(CacheConfig.USER_COUNT).clear();

		if (StrUtil.isBlank(msg)) {
			msg = "注册成功";
		}
		return true;
	}

	public boolean isThird() {
		return isThird;
	}

	public void setThird(boolean isThird) {
		this.isThird = isThird;
	}
}
