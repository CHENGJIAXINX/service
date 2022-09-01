/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.controller.base.thirdlogin;

import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.sitexxx.service.model.main.UserThird;

/**
 * @author tanyaowu
 *
 */
public interface IThirdLogin {

	/**
	 * 跳转到第三方登录
	 * @param request
	 * @param type 登录类型
	 * @return
	 * @throws Exception
	 */
	public HttpResponse toLoginPage(HttpRequest request, Integer type) throws Exception;

	/**
	 * 回调
	 * @param request
	 * @param type 登录类型
	 * @return UserThird
	 */
	public UserThird callback(HttpRequest request, Integer type) throws Exception;

	/**
	 * 
	 * @param request
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public boolean isAjax(HttpRequest request, Integer type) throws Exception;
}
