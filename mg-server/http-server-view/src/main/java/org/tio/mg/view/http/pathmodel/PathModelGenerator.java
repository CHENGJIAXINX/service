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

/**
 * @author tanyaowu
 *
 */
public interface PathModelGenerator {

	/**
	 * 生成model，如果返回值不为null，则直接将返回值作为响应发给前端
	 * @param request
	 * @param path
	 * @param baseModel
	 * @return
	 * @throws Exception 
	 */
	public HttpResponse generate(HttpRequest request, String path, Map<Object, Object> baseModel) throws Exception;
}
