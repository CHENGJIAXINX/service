/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.mg.view.http.pathmodel;

import java.util.Map;

import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.mg.view.annotaion.ModelGeneratorPath;
import org.tio.mg.web.server.utils.SessionCacheUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.SessionKey;

import cn.hutool.core.util.StrUtil;

/**
 * 微信PC端充值
 * @author tanyaowu
 */
@ModelGeneratorPath({ Const.Path.WECHAT_PAY })
public class WechatPayPathModelGenerator implements PathModelGenerator {

	/**
	 * 
	 */
	public WechatPayPathModelGenerator() {
	}

	@Override
	public HttpResponse generate(HttpRequest request, String path, Map<Object, Object> baseModel) {
		String qrBase64 = (String) SessionCacheUtils.get(request, SessionKey.WX_PAY_QR_BASE64);
		Object amount = SessionCacheUtils.get(request, SessionKey.WX_PAY_AMOUNT);
		String subject = (String) SessionCacheUtils.get(request, SessionKey.WX_PAY_SUBJECT);
		String tradeno = (String) SessionCacheUtils.get(request, SessionKey.WX_PAY_TRADENO);

		if (amount == null || StrUtil.isBlank(qrBase64) || StrUtil.isBlank(subject)) {
			baseModel.put(SessionKey.WX_PAY_AMOUNT, -1); //交易金额，单位：元
		} else {
			baseModel.put(SessionKey.WX_PAY_QR_BASE64, qrBase64);
			baseModel.put(SessionKey.WX_PAY_AMOUNT, amount); //交易金额，单位：元
			baseModel.put(SessionKey.WX_PAY_SUBJECT, subject); //商品名字，形如：“1000T币”
			baseModel.put(SessionKey.WX_PAY_TRADENO, tradeno);
		}

		return null;
	}

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

}
