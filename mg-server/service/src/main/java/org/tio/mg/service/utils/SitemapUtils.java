/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.mg.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.Threads;
import org.tio.utils.http.HttpUtils;
import org.tio.utils.thread.pool.AbstractSynRunnable;

import okhttp3.Response;

/**
 * @author tanyaowu
 *
 */
public class SitemapUtils {

	private static Logger log = LoggerFactory.getLogger(SitemapUtils.class);

	/**
	 * 
	 */
	public SitemapUtils() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	public static void pushBlog(Long blogid) throws Exception {
		push(blogBodyString(blogid));
	}

	public static void updateBlog(Long blogid) throws Exception {
		update(blogBodyString(blogid));
	}

	public static void deleteBlog(Long blogid) throws Exception {
		delete(blogBodyString(blogid));
	}

	private static String blogBodyString(Long blogid) {
		String bodyString = Const.PRODUCT_SITE + "/" + blogid;
		//		bodyString += "\r\n";
		//		bodyString += Const.PRODUCT_SITE + "/doc/" + blogid;
		return bodyString;
	}

	public static void push(String bodyString) throws Exception {
		notifyBaidu(Const.BaiduZiyuan.PUSH_URL, bodyString);
	}

	public static void update(String bodyString) throws Exception {
		notifyBaidu(Const.BaiduZiyuan.UPDATE_URL, bodyString);
	}

	public static void delete(String bodyString) throws Exception {
		notifyBaidu(Const.BaiduZiyuan.DELETE_URL, bodyString);
	}

	private static void notifyBaidu(String baiduUrl, String bodyString) {
		int x = 6;
		if (x > 1) {//暂时不再往百度上面提交东西
			return;
		}

		if (!Const.PRODUCT_SITE.equals(Const.SITE)) {
			return;
		}
		Threads.getTioExecutor().execute(new AbstractSynRunnable(Threads.getTioExecutor()) {
			@Override
			public boolean isNeededExecute() {
				return false;
			}

			@Override
			public void runTask() {
				try {
					Response response = HttpUtils.post(baiduUrl, null, bodyString);

					if (response != null) {
						log.error("提交到百度统计\r\nurl\r\n{}\r\nbody\r\n{}\r\nresp\r\n{}", baiduUrl, bodyString, response.body().string());
					}

				} catch (Exception e) {
					log.error(e.toString(), e);
				}
			}
		});
	}

}
