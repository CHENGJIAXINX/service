/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.wx;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.UploadFile;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.model.main.File;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.service.chat.SysService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.service.vo.RequestExt;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;

/**
 * 系统相关
 * @author xufei
 * 2020年1月6日 下午7:41:13
 */
@RequestPath(value = "/sys")
public class SysController {
	private static Logger log = LoggerFactory.getLogger(SysController.class);
	
	
	/**
	 * 版本更新
	 * @param request
	 * @param version
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年9月18日 上午11:11:58
	 */
	@RequestPath(value = "/version")
	public Resp version(HttpRequest request,String version) throws Exception {
		RequestExt requestExt = WebUtils.getRequestExt(request);
		byte deviceType = requestExt.getDeviceType();
		if(requestExt.isFromAppAndroid()) {
			deviceType = 1;
		} else if(requestExt.isFromAppIos()) {
			deviceType = 2;
		}
		if(StrUtil.isBlank(version)) {
			version = requestExt.getAppVersion();
		}
		Ret ret = SysService.me.checkVersion(deviceType, version);
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkData(ret));
	}
	
	
	/**
	 * 错误日志
	 * @param request
	 * @param uploadFile
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月2日 上午11:33:42
	 */
	@RequestPath(value = "/errlog")
	public Resp updateAvatar(HttpRequest request, UploadFile uploadFile) throws Exception {
		if(uploadFile == null) {
			return Resp.fail("上传信息为空");
		}
		User curr = WebUtils.currUser(request);
		Integer uid = null;
		if (curr != null) {
			uid = curr.getId();
		} else {
			uid = -777;
		}
		String sessionid = request.getHttpSession().getId();
		File dbFile = innerUploadFile(uid, uploadFile, sessionid);
		if(dbFile != null) {
			log.error("app出现了未知异常，已保存记录，上传记录：{}",Json.toJson(dbFile));
		}
		return Resp.ok();
	}
	
	/**
	 * 错误文件上传
	 * @param uid
	 * @param uploadFile
	 * @param sessionid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月2日 上午11:28:34
	 */
	private static File innerUploadFile(Integer uid,UploadFile uploadFile,String sessionid) throws Exception {
		byte[] bs = uploadFile.getData();
		String filename = uploadFile.getName();
		String ext = FileUtil.extName(filename);
		String resRootDir = Const.RES_ROOT;
		String path = "/" + Const.UPLOAD_DIR.APP_LOG_ERR + "/" + DateUtil.format(new Date(), "yyyyMMddHH") + "/" + uid;
		java.io.File dir = new java.io.File(resRootDir, path);
		FileUtil.mkdir(dir);
		String url = path + "/" + filename;
		java.io.File file = new java.io.File(resRootDir, url);
		FileUtil.writeBytes(bs, file);
		File dbFile = new File();
		dbFile.setExt(ext);
		dbFile.setFilename(uploadFile.getName());
		dbFile.setSession(sessionid);
		dbFile.setSize((long) bs.length);
		dbFile.setUid(uid);
		dbFile.setUrl(url);
		dbFile.save();
		return dbFile;
	}
		
}
