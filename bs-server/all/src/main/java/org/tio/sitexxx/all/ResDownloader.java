/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.all;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.Threads;
import org.tio.utils.http.HttpUtils;
import org.tio.utils.hutool.StrUtil;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import okhttp3.Response;

/**
 * 资源文件下载（从官网下载资源文件）
 * @author tanyaowu
 *
 */
public class ResDownloader {
	private static Logger log = LoggerFactory.getLogger(ResDownloader.class);

	/**
	 * 
	 */
	public ResDownloader() {

	}

	private static String	apiServer	= "https://www.yxtiocloud1.com";
	private static String	resServer	= "https://res.yxtiocloud1.com";

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		if (args != null) {
			if (args.length == 2) {
				apiServer = args[0];
				resServer = args[1];
			}
		}
		org.tio.sitexxx.all.Starter.initBase();

		//		downloadByDb("/upload/img");
		//		downloadByDb("/upload/video");

		downloadByFile("/upload/all");
	}

	/**
	 * 根据数据库里的记录进行资源下载
	 * @param path
	 * @throws Exception
	 */
	@SuppressWarnings({ "unused", "rawtypes" })
	private static void downloadByDb(String path) throws Exception {
		Response response = HttpUtils.get(apiServer + Const.API_CONTEXTPATH + path + Const.API_SUFFIX);
		String str = response.body().string();
		log.error(str);
		List<Map> list = org.tio.utils.json.Json.toList(str, Map.class);
		for (Map map : list) {
			Threads.getGroupExecutor().execute(new Runnable() {
				@SuppressWarnings("unchecked")
				@Override
				public void run() {
					Record record = new Record().setColumns(map);
					try {
						download(resServer, record.getStr("coverurl"), record.getInt("coversize"));
					} catch (Exception e) {
						log.error("", e);
					}
					try {
						download(resServer, record.getStr("url"), Long.parseLong(record.getStr("size")));
					} catch (Exception e) {
						log.error("", e);
					}
				}
			});
		}
	}

	/**
	 * 根据文件扫描进行资源下载
	 * @param path
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	private static void downloadByFile(String path) throws Exception {
		Response response = HttpUtils.get(apiServer + Const.API_CONTEXTPATH + path + Const.API_SUFFIX, null, 50L);
		String str = response.body().string();
//		log.error(str);
		List<Map> list = org.tio.utils.json.Json.toList(str, Map.class);
		for (Map map : list) {
			Threads.getGroupExecutor().execute(new Runnable() {
				@SuppressWarnings("unchecked")
				@Override
				public void run() {
					Record record = new Record().setColumns(map);
					try {
						download(resServer, record.getStr("path"), Long.parseLong(record.getStr("size")));
					} catch (Exception e) {
						log.error("", e);
					}
				}
			});
		}
	}

	/**
	 * 下载成功的数量
	 */
	static AtomicInteger count_ok = new AtomicInteger(1);
	/**
	 * 下载失败的数量
	 */
	static AtomicInteger count_fail = new AtomicInteger(1);

	/**
	 * 已经存在的数量
	 */
	static AtomicInteger count_exist = new AtomicInteger(1);

	private static void download(String server, String path, long size) throws IOException {
		Runnable command = new Runnable() {
			@Override
			public void run() {
				String url = null;
				try {
					url = server + path; //URLEncoder.encode(path, org.tio.sitexxx.service.Const.CHARSET);
					File desFile = new File(Const.RES_ROOT, path);
					if (desFile.exists() && FileUtil.size(desFile) == size) {
//						System.out.println(count_exist.incrementAndGet() + "、已经存在");
						return;
					}
					long size = HttpUtil.downloadFile(url, desFile);

					//					String index = StrUtil.fillAfter(count_ok.incrementAndGet() + ".", ' ', 8);
					String sizeStr = StrUtil.fillAfter("" + size, ' ', 10);
					System.out.println(StrUtil.fillAfter(count_ok.incrementAndGet() + ".", ' ', 8) + sizeStr + desFile.getCanonicalPath());
				} catch (Exception e) {
					//					log.error("", e);
					//					String index = StrUtil.fillAfter(count_fail.incrementAndGet() + ".", ' ', 8);
					String fail = StrUtil.fillAfter("下载失败", ' ', 10) + "\r\n" + e.getMessage();
					System.out.println(StrUtil.fillAfter(count_fail.incrementAndGet() + ".", ' ', 8) + fail + path + "    url:" + url);
				}
			}
		};

		org.tio.utils.Threads.getGroupExecutor().execute(command);

	}

}
