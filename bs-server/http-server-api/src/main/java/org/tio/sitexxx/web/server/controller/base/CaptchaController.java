/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.base;

import java.io.ByteArrayOutputStream;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.common.session.HttpSession;
import org.tio.http.server.annotation.RequestPath;
import org.tio.http.server.util.Resps;
import org.tio.sitexxx.service.cache.CacheConfig;
import org.tio.sitexxx.service.cache.Caches;
import org.tio.sitexxx.service.vo.RequestExt;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.cache.ICache;
import org.tio.utils.resp.Resp;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.util.StrUtil;

/**
 * 图片验证码
 * @author tanyaowu
 * 2016年6月29日 下午7:53:59
 */
@RequestPath(value = "/captcha")
public class CaptchaController {
	private static Logger log = LoggerFactory.getLogger(CaptchaController.class);

	/**
	 *
	 * @param captcha
	 * @param session
	 * @return true: 验证通过
	 * @author tanyaowu
	 */
	public static Resp check(String captcha, HttpRequest request, boolean remove) {
		HttpSession session = request.getHttpSession();
		RequestExt ext = WebUtils.getRequestExt(request);
		//是否是从pc端过来的请求
		boolean isNeed = ext.isFromBrowserPc();
		if (!isNeed) {
			return Resp.ok();
		}
		ICache cache = Caches.getCache(CacheConfig.CAPTCHA);
		String code = (String) Caches.getCache(CacheConfig.CAPTCHA).get(session.getId());
		if (remove) {
			cache.remove(session.getId());
		}
		if (StrUtil.isNotBlank(captcha) && Objects.equals(captcha.toLowerCase(), code)) {
			return Resp.ok();
		} else {
			if (StrUtil.isNotBlank(code)) {
				return Resp.fail().msg("校验码失效");
			} else {
				return Resp.fail().msg("输入的校验码不正确");
			}
		}
	}

	/**
	 *
	 * @author tanyaowu
	 */
	public CaptchaController() {
	}

	@RequestPath(value = "")
	public HttpResponse index(HttpRequest request) throws Exception {
		HttpResponse ret = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			
			int width = 116;
			int height = 36;
			int length = 4;

			//定义图形验证码的长、宽、验证码字符数、干扰元素个数
			CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(width, height, length, 3);
			byteArrayOutputStream = new ByteArrayOutputStream();
			captcha.write(byteArrayOutputStream);
			byte[] bs = byteArrayOutputStream.toByteArray();
			String code = captcha.getCode();
			code = code.toLowerCase();
			Caches.getCache(CacheConfig.CAPTCHA).put(request.getHttpSession().getId(), code);
			
			ret = Resps.bytes(request, bs, "png");
		} catch (Throwable e) {
			log.error("", e);
		} finally {
			if (byteArrayOutputStream != null) {
				byteArrayOutputStream.close();
			}
		}

		return ret;
	}

	@RequestPath(value = "/validate")
	public HttpResponse validate(String captcha, HttpRequest request) throws Exception {
		Resp resp = check(captcha, request, false);
		HttpResponse response = Resps.json(request, resp);
		return response;
	}

}
