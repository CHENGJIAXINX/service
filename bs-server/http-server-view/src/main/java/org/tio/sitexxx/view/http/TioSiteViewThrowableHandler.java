/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.view.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.common.RequestLine;
import org.tio.http.server.intf.ThrowableHandler;
import org.tio.http.server.util.Resps;
import org.tio.sitexxx.service.vo.RequestExt;
import org.tio.sitexxx.web.server.utils.WebUtils;

/**
 * @author tanyaowu
 *
 */
public class TioSiteViewThrowableHandler implements ThrowableHandler {
	private static Logger log = LoggerFactory.getLogger(TioSiteViewThrowableHandler.class);

	public static final TioSiteViewThrowableHandler ME = new TioSiteViewThrowableHandler();

	/**
	 * 
	 */
	private TioSiteViewThrowableHandler() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	@Override
	public HttpResponse handler(HttpRequest request, RequestLine requestLine, Throwable throwable) throws Exception {
		//		if (request.getIsAjax()) {
		log.error(request.toString(), throwable);
		RequestExt requestExt = WebUtils.getRequestExt(request);
		requestExt.setCanCache(false);
		HttpResponse ret = Resps.resp500(request, throwable);//.json(request, Resp.fail());
		return ret;
		//		}
		//		return Resps.html(request, "服务器异常");
	}

}
