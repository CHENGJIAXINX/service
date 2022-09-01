/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.http.cache;

import org.tio.http.common.HttpRequest;
import org.tio.sitexxx.service.model.main.User;

/**
 * @author tanyaowu
 *
 */
public interface HttpCacheMeta {

	/**
	 * 是不是自己的资源，譬如某篇博客
	 * @param request
	 * @param curr
	 * @return 如果返回null，则不用这个作为key，
	 */
	public Boolean isSelf(HttpRequest request, User curr);

	/**
	 * 需要用角色作为key
	 * @param request
	 * @param curr
	 * @return
	 */
	public String roleKey(HttpRequest request, User curr);

}
