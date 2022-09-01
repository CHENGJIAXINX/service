/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.init;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.server.mvc.Routes;
import org.tio.sitexxx.service.model.conf.Httpcache;
import org.tio.sitexxx.service.service.conf.HttpcacheService;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;

/**
 * @author tanyaowu
 *
 */
public class HttpcacheInit {
	private static Logger log = LoggerFactory.getLogger(HttpcacheInit.class);

	/**
	 * 
	 */
	public HttpcacheInit() {
	}

	/**
	 * 
	 */
	public static void init(Routes routes) {
		List<Httpcache> list = HttpcacheService.getAll();
		if (CollectionUtil.isNotEmpty(list)) {
			StringBuilder sb = new StringBuilder(50);
			for (Httpcache httpcache : list) {
				String path = httpcache.getPath();
				if (!routes.PATH_METHOD_MAP.containsKey(path)) {
					sb.append(path).append(System.lineSeparator());
				}
			}

			if (sb.length() > 0) {
				log.error("有些路径在httpcache表中配置了，但是是无效路径\r\n{}", sb.toString());
				try {
					FileUtil.writeUtf8String("有些路径在httpcache表中配置了，但是是无效路径\r\n" + sb.toString(), "/tio_error_httpcache_path.txt");//.writeString("/tio_error_httpcache_path.txt", "有些路径在httpcache表中配置了，但是是无效路径\r\n" + sb.toString());
				} catch (Exception e) {
					log.error("", e);
				}
			}
		}
	}

}
