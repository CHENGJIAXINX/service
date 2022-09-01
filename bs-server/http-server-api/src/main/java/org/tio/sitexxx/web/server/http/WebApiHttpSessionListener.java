/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpConfig;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.session.HttpSession;
import org.tio.http.server.session.HttpSessionListener;
import org.tio.sitexxx.service.vo.SessionExt;
import org.tio.sitexxx.servicecommon.vo.SessionKey;

import cn.hutool.core.util.StrUtil;

/**
 * @author tanyaowu 
 * 2016年9月27日 下午2:04:10
 */
public class WebApiHttpSessionListener implements HttpSessionListener {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(WebApiHttpSessionListener.class);

	public static final WebApiHttpSessionListener ME = new WebApiHttpSessionListener();

	/**
	 * 
	 * @author: tanyaowu
	 */
	private WebApiHttpSessionListener() {
	}

	/** 
	 * @param session
	 * @author: tanyaowu
	 */
	@Override
	public void doAfterCreated(HttpRequest request, HttpSession session, HttpConfig httpConfig) {
		String newSessionId = decorateSessionId(request, session.getId());
		session.setId(newSessionId);
		session.setAttribute(SessionKey.SESSION_EXT, new SessionExt(), httpConfig);
	}

	private static String decorateSessionId(HttpRequest request, String initSessionId) {
		StringBuilder sb = new StringBuilder(initSessionId.length() + 5);
		//		sb.append(request.getClientIp());
		//		sb.append("_");
		sb.append(StrUtil.sub(initSessionId, 0, 2)).append("1");
		sb.append(StrUtil.sub(initSessionId, 2, 4)).append("4");
		sb.append(StrUtil.sub(initSessionId, 4, 5)).append("7");
		sb.append(StrUtil.sub(initSessionId, 5, 6)).append("2");
		sb.append(StrUtil.sub(initSessionId, 6, 8)).append("5");
		sb.append(StrUtil.sub(initSessionId, 8, 9)).append("8");
		sb.append(StrUtil.sub(initSessionId, 9, 12)).append("3");
		sb.append(StrUtil.sub(initSessionId, 9, initSessionId.length()));

		return sb.toString();
	}

	public static boolean isValidSessionId(String s) {
		if (s.length() < 13) {
			return false;
		}
		//		String[] xx = StrUtil.split(s, "_");
		//		if (xx.length != 2) {
		//			return false;
		//		}
		//		s = xx[1];
		int i = 0;
		return s.charAt(2 + i++) == '1' && s.charAt(4 + i++) == '4' && s.charAt(5 + i++) == '7' && s.charAt(6 + i++) == '2' && s.charAt(8 + i++) == '5' && s.charAt(9 + i++) == '8'
		        && s.charAt(12 + i++) == '3';
	}

}
