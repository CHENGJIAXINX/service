/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.UploadFile;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.web.server.controller.wx.ChatController;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.jfinal.P;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import org.tio.utils.resp.Resp;

/**
 * @author tanyaowu
 * 2016年6月29日 下午7:53:59
 */
@RequestPath(value = "/upload")
public class UploadController {
	private static Logger log = LoggerFactory.getLogger(UploadController.class);

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

	/**
	 * 发送文件-已调整
	 * @param request
	 * @param uploadFile
	 * @param groupid
	 * @param touid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月5日 下午7:01:16
	 */
	@RequestPath(value = "/file")
	public Resp file(HttpRequest request, UploadFile uploadFile) throws Exception {
		try {
			if(uploadFile == null) {
				return Resp.fail("上传信息为空");
			}
			User curr = WebUtils.currUser(request);
			if (curr == null){
				return Resp.fail("未登录或登录超时");
			}
			String sessionid = request.getHttpSession().getId();
			org.tio.sitexxx.service.model.main.File dbFile = ChatController.innerUploadFile(curr, uploadFile, sessionid);
//			String text = Json.toJson(dbFile);
			return Resp.ok(dbFile);
		} catch (Exception e) {
			log.error("", e);
			return Resp.fail(RetUtils.SYS_ERROR);
		}
	}

	/**
	 *
	 * @author tanyaowu
	 */
	public UploadController() {
	}

	@RequestPath(value = "/img")
	public List<Record> img(HttpRequest request) throws Exception {
		String sql = "select * from img where updatetime > ?";
		return xx(request, sql);
	}

	@RequestPath(value = "/video")
	public List<Record> video(HttpRequest request) throws Exception {
		String sql = "select * from video where updatetime > ?";
		return xx(request, sql);
	}

	@RequestPath(value = "/all")
	public List<Map<String, Object>> all(HttpRequest request) throws Exception {
		String rootPath = P.get("res.root");
		List<File> list = FileUtil.loopFiles(rootPath, new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				try {
					String path = pathname.getCanonicalPath().substring(rootPath.length());
					path = StrUtil.replace(path, "\\", "/");
					///avatar/
//					if (path.startsWith("/avatar/")) {
//						return false;
//					}
					return true;
				} catch (IOException e) {
					log.error("", e);
					return true;
				}
			}});

		List<Map<String, Object>> listMap = new ArrayList<>(list.size());
		for (File file : list) {
			try {
				Map<String, Object> map = new HashMap<>();
				listMap.add(map);

				String path = file.getCanonicalPath().substring(rootPath.length());
				path = StrUtil.replace(path, "\\", "/");
				map.put("size", FileUtil.size(file));
				map.put("path", path);
			} catch (Exception e) {
				log.error("", e);
			}
		}

		return listMap;
	}

	public List<Record> xx(HttpRequest request, String sql) throws Exception {
		long iv = 3600L * 24L * 1000L * 30L; //只取最近30天的
		Date date = new Date(System.currentTimeMillis() - iv);

		List<Record> list = Db.use(Const.Db.TIO_SITE_MAIN).find(sql, date);
		return list;
	}
}
