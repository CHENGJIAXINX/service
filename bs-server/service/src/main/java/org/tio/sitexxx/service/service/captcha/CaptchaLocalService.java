/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.captcha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anji.captcha.service.CaptchaService;

/**
 * 图形本地服务
 * @author xufei
 * 2020年2月13日 下午7:01:05
 */
public class CaptchaLocalService {
	@SuppressWarnings("unused")
	private static Logger				log	= LoggerFactory.getLogger(CaptchaLocalService.class);
	
	public static final CaptchaLocalService	me	= new CaptchaLocalService();
	
	public static final CaptchaService captchaService = CaptchaConfig.captchaService();

}
