/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.controller.base.thirdlogin.provider.qqmobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.sitexxx.service.model.main.UserThird.SubTable;
import org.tio.sitexxx.service.model.main.UserThirdQq;
import org.tio.sitexxx.web.server.controller.base.thirdlogin.provider.MobileLogin;

import cn.hutool.core.util.StrUtil;

/**
 * @author tanyaowu
 *
 */
public class QQMobileLogin extends MobileLogin {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(QQMobileLogin.class);

	public static QQMobileLogin me = new QQMobileLogin();

	/**
	 * 
	 */
	private QQMobileLogin() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	@Override
	public SubTable createSubTable(HttpRequest request, Integer type) {
		String is_yellow_vip = request.getParam("is_yellow_vip");
		String yellow_vip_level = request.getParam("yellow_vip_level");

		UserThirdQq userThirdQq = new UserThirdQq();
		if (StrUtil.isNotBlank(is_yellow_vip)) {
			Byte is_yellow_vip_b = Byte.parseByte(is_yellow_vip);
			userThirdQq.setIsYellowVip(is_yellow_vip_b);

			if (is_yellow_vip_b == 1) {
				userThirdQq.setYellowVipLevel(yellow_vip_level);
			}
		}
		return userThirdQq;
	}

}
