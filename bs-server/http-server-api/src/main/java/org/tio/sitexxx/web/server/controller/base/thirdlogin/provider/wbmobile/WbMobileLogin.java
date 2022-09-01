/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.controller.base.thirdlogin.provider.wbmobile;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.sitexxx.service.model.main.UserThird;
import org.tio.sitexxx.service.model.main.UserThirdWeibo;
import org.tio.sitexxx.web.server.controller.base.thirdlogin.ThirdLoginUtils;
import org.tio.sitexxx.web.server.controller.base.thirdlogin.provider.Auth2Login;
import org.tio.sitexxx.web.server.init.WebApiInit;
import org.tio.utils.jfinal.P;

import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

/**
 * @author tanyaowu
 *
 */
public class WbMobileLogin extends Auth2Login {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(WbMobileLogin.class);

	public static WbMobileLogin me = new WbMobileLogin();

	/**
	 * 
	 */
	private WbMobileLogin() {
		updateProperties();
	}

	private void updateProperties() {
		WeiboConfig.updateProperties("client_ID", P.get("third.login.weibo.pc.AppID"));
		WeiboConfig.updateProperties("client_SERCRET", P.get("third.login.weibo.pc.AppSecret"));
		WeiboConfig.updateProperties("redirect_URI", ThirdLoginUtils.getCallbackUrl(WebApiInit.httpConfig, UserThird.Type.WB));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	@Override
	public String loginUrl(HttpRequest request, Integer type, String state) throws Exception {
		Oauth oauth = new Oauth();
		String url = oauth.authorize("code", state);
		return url;
	}

	@Override
	public UserThird getUserThird(HttpRequest request, Integer type, String state, String code) throws Exception {
		Oauth oauth = new Oauth();
		AccessToken accessToken = oauth.getAccessTokenByCode(code);
		String uid = accessToken.getUid();

		Users um = new Users();
		try {
			/**http://open.weibo.com/wiki/%E8%8E%B7%E5%8F%96%E7%94%A8%E6%88%B7%E5%9F%BA%E6%9C%AC%E4%BF%A1%E6%81%AF
			 * subscribe	int	用户是否订阅该账号，值为0时，代表此用户没有订阅该账号；
				uid	int64	用户UID
				nicname	string	用户昵称
				sex	string	性别，1：男、2：女、0：未知
				city	string	用户所在城市
				country	string	用户所在国家
				province	int	用户所在省份
				language	string	用户当前的语言版本，zh_CN 简体，zh_TW 繁体，en英语
				headimgurl	string	用户头像地址（中图），50×50像素
				headimgurl_large	string	用户头像地址（大图），180×180像素
				headimgurl_hd	string	用户头像地址（高清），高清头像原图
				subscribe_time	string	订阅时间
				follow	int	该用户是否关注access_token中的uid，1：是，0：否
			 */
			User user = um.showUserById(uid);
			String gender = user.getGender(); // 性别,m--男，f--女,n--未知
			//			Integer sex = "m".equals(gender) ? 1 : ("f".equals(gender) ? 2 : null);
			Integer sex = Objects.equals("m", gender) ? 1 : (Objects.equals("f", gender) ? 2 : null);

			UserThird userThird = new UserThird();
			userThird.setOpenid(user.getIdstr());
			userThird.setAvatar(user.getAvatarLarge());
			userThird.setNick(user.getName());
			userThird.setSex(sex);
			//			if (StrUtil.isNotBlank(user.getCity())) {
			//				userThird.setCity(user.getCity() + "");
			//			}
			//			userThird.setFollowers(user.getFollowersCount());
			//			userThird.setCreatedAt(user.getCreatedAt());

			UserThirdWeibo userThirdWeibo = new UserThirdWeibo();
			userThirdWeibo.setCity(user.getCity() + "");
			userThirdWeibo.setCreatedAt(user.getCreatedAt());
			//			userThirdWeibo.setCountry(user.getco);
			userThirdWeibo.setDescription(user.getDescription());
			userThirdWeibo.setDomain(user.getDomain());
			userThirdWeibo.setFavourites(user.getFavouritesCount());
			userThirdWeibo.setFollowers(user.getFollowersCount());
			userThirdWeibo.setFriends(user.getFriendsCount());
			userThirdWeibo.setVerified(user.isVerified() ? (byte) 1 : (byte) 2);
			userThirdWeibo.setWeihao(user.getWeihao());
			userThird.setSubTable(userThirdWeibo);

			return userThird;
		} catch (WeiboException e) {
			throw e;
		}
	}
}
