/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.utils;

import java.io.File;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.web.server.init.WebApiInit;
import org.tio.utils.hutool.DatePattern;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;

/**
 * @author tanyaowu 
 * 2016年11月29日 下午9:25:00
 */
public class UploadUtils {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(UploadUtils.class);

	/**
	 * 根据用户id获取其im-data路径(位于上传资源服务器)
	 * @param uid
	 * @return
	 */
	public static String dataRootPath(String subDir, int uid) {
		long uid1 = uid + 74541287548L;
		long base = 107;
		long dir1 = uid1 % base;
		long dir2 = uid1 % (base * base);
		long dir3 = uid1 % (base * base * base);
		long dir4 = uid1 % (base * base * base * base);

		//		String path = "/im-upload-data/" + dir1 + "/" + dir2 + "/" + dir3 + "/" + dir4 + "/" + uid1;
		String path = "/" + subDir + "/" + dir1 + "/" + dir2 + "/" + dir3 + "/" + dir4 + "/" + uid1;
		return path;
	}

	/**
	 * 新上传的文件，不含后缀。形如："/im/upload/img/1/1/1/2/44/20/121212"
	 * @param subDir
	 * @param uid
	 * @param filename
	 * @return
	 */
	public static String newFile(String subDir, int uid, String filename) {
		String path = dataRootPath(subDir, uid);
		Date date = new Date();
		path = path + "/" + RandomUtil.randomInt(1, 120);

		String resRootDir = Const.RES_ROOT;
		File dir = new File(resRootDir, path);
		FileUtil.mkdir(dir);

		String fileName = DateUtil.format(date, "HHmmss");
		if (filename != null) {
//			fileName += "/" + FileUtil.mainName(filename);
			fileName += "/" + WebApiInit.sessionIdGenerator.nextId();
			
		}
		return path + "/" + fileName;
	}

	/**
	 *  按时间产生路径
	 * @param subDir
	 * @param filename
	 * @return
	 * @author xufei
	 * 2020年1月14日 下午4:12:11
	 */
	public static String dateFile(String subDir) {
		String path = "/" + subDir + "/";
		Date date = new Date();
		path += DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN);
		path = path + RandomUtil.randomInt(1, 120);
		String resRootDir = Const.RES_ROOT;
		File dir = new File(resRootDir, path);
		FileUtil.mkdir(dir);
		return path + "/" + DateUtil.format(date, "HHmmss") + WebApiInit.sessionIdGenerator.nextId();
	}
	
	/**
	 * 
	 * @author tanyaowu
	 */
	public UploadUtils() {
	}

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}
}
