/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.base;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.sitexxx.service.vo.RequestExt;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.jfinal.P;
import org.tio.utils.resp.Resp;

/**
 * 单独提供给app的接口
 * @author tanyaowu
 */
@RequestPath(value = "/app")
public class AppController {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(AppController.class);

	/**
	 *
	 * @author tanyaowu
	 */
	public AppController() {
	}

	@SuppressWarnings("unused")
	@RequestPath(value = "/conf")
	public Resp conf(HttpRequest request) throws Exception {
		RequestExt requestExt = WebUtils.getRequestExt(request);

		Map<String, Object> map = new HashMap<>();
		map.put("res_server", P.get("res.server"));
		return Resp.ok(map);
	}

}
