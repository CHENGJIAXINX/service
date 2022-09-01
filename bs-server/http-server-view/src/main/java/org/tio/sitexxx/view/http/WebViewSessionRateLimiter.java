/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.view.http;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HeaderName;
import org.tio.http.common.HeaderValue;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.common.session.limiter.SessionRateLimiter;
import org.tio.http.common.session.limiter.SessionRateVo;
import org.tio.sitexxx.service.service.conf.IpWhiteListService;
import org.tio.utils.SystemTimer;
import org.tio.utils.hutool.FileUtil;

public class WebViewSessionRateLimiter implements SessionRateLimiter {
	private static Logger log = LoggerFactory.getLogger(WebViewSessionRateLimiter.class);

	public static final WebViewSessionRateLimiter me = new WebViewSessionRateLimiter();

	private final Map<String, Integer> allowCountMap = new HashMap<>();

	private final Map<String, Integer> extAllowCountMap = new HashMap<>();

	/**
	 * key:   访问路径<br>
	 * value: 相邻两次访问必须间隔的最小时间，单位：毫秒<br>
	 */
	private final Map<String, Integer> map = new HashMap<>();

	/**
	 * js文件，每分钟默认允许访问的次数
	 */
	private final int DEFAULT_JS_ALLOW_COUNT = 50;

	/**
	 * css文件，每分钟默认允许访问的次数
	 */
	private final int DEFAULT_CSS_ALLOW_COUNT = 50;

	/**
	 * other文件，每分钟默认允许访问的次数
	 */
	private final int DEFAULT_OTHER_ALLOW_COUNT = 30;

	/**
	 * html文件，每分钟默认允许访问的次数
	 */
	private final int DEFAULT_HTML_ALLOW_COUNT = 40;

	private HttpResponse response;


	private WebViewSessionRateLimiter() {

		extAllowCountMap.put("html", DEFAULT_HTML_ALLOW_COUNT);
		extAllowCountMap.put("js", DEFAULT_JS_ALLOW_COUNT);
		extAllowCountMap.put("css", DEFAULT_CSS_ALLOW_COUNT);
		//		extAllowCountMap.put("html", DEFAULT_HTML_ALLOW_COUNT);

		response = new HttpResponse();
		try {
			response.addHeader(HeaderName.Content_Type, HeaderValue.Content_Type.TEXT_HTML_HTML);
			response.setBody("操作过快，请稍后再操作".getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			log.error("", e);
		}
		response.addHeader(HeaderName.Content_Type, HeaderValue.Content_Type.TEXT_PLAIN_JSON);
	}

	@Override
	public boolean allow(HttpRequest request, SessionRateVo sessionRateVo) {
		if (IpWhiteListService.isWhiteIp(request.getClientIp())) {
			return true;
		}

		String path = request.getRequestLine().getPath();

		Integer allowCount = allowCountMap.get(path);
		if (allowCount == null) {
			String ext = FileUtil.extName(path);
			allowCount = extAllowCountMap.get(ext);
			if (allowCount == null) {
				allowCount = DEFAULT_OTHER_ALLOW_COUNT;
			}
		}

		if (sessionRateVo.getAccessCount().get() > allowCount) {
			return false;
		}

		Integer iv = map.get(path);
		if (iv != null) {
			if (SystemTimer.currTime - sessionRateVo.getLastAccessTime() < iv) {
				return false;
			}
		}

		return true;
	}

	@Override
	public HttpResponse response(HttpRequest request, SessionRateVo sessionRateVo) {
		return response;
	}

}
