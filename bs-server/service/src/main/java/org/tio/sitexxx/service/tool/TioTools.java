/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * grantinfo
 */
package org.tio.sitexxx.service.tool;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

public class TioTools {

	public static void main(String[] args) throws Exception {
		//		changeSiteStyle();//切换网站风格
		//		newProject(); //新工程
		//		rename();
		tio(); //tio升级
		//		deleteMianZhe();  //删除免责声明
		//		addMianZhe();  //添加免责声明
		//						tioSiteReplace();   //tio官网字符串替换

		//						qijian();  

		//

		//						addBlankFile("F:\\svn_lulili\\my-project");
		//		deleteFiles(new String[] { "D:\\work\\t-io" }, new String[] { ".externalToolBuilders", ".settings", ".classpath", ".project" });

		//		replaceFiles(new File("C:\\Users\\tanyw\\Desktop\\nb830.dic"), new String[] { "D:\\work\\tio-im", "F:\\gitee\\java", "D:\\work\\tio-im(改名前)" });
		//		replaceFiles(new File("F:\\work\\ip2region\\data\\ip2region.db"), new String[] { "D:\\work\\tio-im", "F:\\gitee\\java" });

		//		AtomicInteger count = new AtomicInteger();
		//		findFile("D:\\work", "g-m-db", count);
		//		System.out.println("共找到" + count + "个文件及目录");

		//		printFiles();
	}

	private static Logger		log			= LoggerFactory.getLogger(TioTools.class);
	private static Set<String>	acceptedExt	= new HashSet<>();
	static {
		acceptedExt.add("js");
		acceptedExt.add("jsp");
		acceptedExt.add("xml");
		acceptedExt.add("bat");
		acceptedExt.add("sh");
		acceptedExt.add("java");
		acceptedExt.add("properties");
//		acceptedExt.add("sql");
		acceptedExt.add("txt");
//		acceptedExt.add("log");
		acceptedExt.add("css");
		acceptedExt.add("md");
		acceptedExt.add("form");
		acceptedExt.add("dic");
		acceptedExt.add("conf");
		acceptedExt.add("html");
	}

	/**
	 * 
	 * @author: tanyaowu
	 * @创建时间:　2016年6月29日 下午2:47:09
	 */
	public TioTools() {
	}

	//	@SuppressWarnings("rawtypes")
	//	private static SynThreadPoolExecutor threadExecutor = new SynThreadPoolExecutor(40, 120, "quickstart-thread-pool");

	private static int modifiedCount = 0;

	//	private static int renameCount = 0;

	public static void printFiles() {
		//F:\work\tio-site\src\frontend\web-all\starter\src\main\resources\config\page\img\avatar

		File f = new File("F:\\work\\tio-site\\src\\frontend\\web-all\\starter\\src\\main\\resources\\config\\page\\img\\avatar");
		File[] list = f.listFiles();
		String str = "{";
		if (!ArrayUtil.isEmpty(list)) {
			for (File file : list) {
				str += "\"/img/avatar/" + file.getName() + "\",";
			}
		}
		str += "}";
		System.out.println(str);
	}

	/**
	 * 
	 * @param rootDirStr
	 * @param old2newFilename 可以为空或null
	 * @throws IOException
	 */
	public static void rename(String rootDirStr, Map<String, String> old2newFilename) throws IOException {
		//		System.out.println("renameCount:" + renameCount++ + ", " + rootDirStr);
		if (old2newFilename == null || old2newFilename.size() == 0) {
			return;
		}

		File rootDir = new File(rootDirStr);
		File[] files = rootDir.listFiles();

		if (!ArrayUtil.isEmpty(files)) {
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				//			String absolutePath = file.getAbsolutePath();
				String filename = file.getName();
				Set<Entry<String, String>> old2newFilenameSet = old2newFilename.entrySet();
				for (Entry<String, String> entry : old2newFilenameSet) {
					String oldfilenamefragment = entry.getKey();
					String newfilenamefragment = entry.getValue();
					if (filename.contains(oldfilenamefragment)) {
						String newfilename = filename.replaceAll(oldfilenamefragment, newfilenamefragment);
						File newFile = new File(file.getParentFile(), newfilename);
						boolean f = file.renameTo(newFile);
						file = newFile;
						if (f) {
							System.out.println("改名成功，原名:" + filename + ", 新名：" + newfilename + ", " + file.getAbsolutePath());
						} else {
							System.out.println("改名失败，原名:" + filename + ", 新名：" + newfilename + ", " + file.getAbsolutePath());
						}
					}
				}
			}
		}
		

		rootDir = new File(rootDirStr);
		files = rootDir.listFiles(new MyFileFilter());

		if (!ArrayUtil.isEmpty(files)) {
			for (int i = 0; i < files.length; i++) {
				File file = files[i];

				if (file.isDirectory()) {
					rename(file.getAbsolutePath(), old2newFilename);
				}
			}
		}


	}

	
	private static Set<String> filterFile = new HashSet<>();
	static {
		filterFile.add("TioTools.java");
		filterFile.add("left-tree.html");
		filterFile.add("left.js");
	}
	
	/**
	 * 
	 * @param rootDirStr
	 * @param old2newStr
	 * @throws IOException
	 */
	public static void replaceStr(String rootDirStr, Map<String, String> old2newStr) throws Exception {
		if (old2newStr == null) {
			return;
		}

		File rootDir = new File(rootDirStr);
		File[] files = rootDir.listFiles(new MyFileFilter());

		if (files == null) {
			return;
		}

		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			String absolutePath = file.getAbsolutePath();
			//			String filename = file.getName();
			//			Set<Entry<String, String>> old2newFilenameSet = old2newFilename.entrySet();

			//			String extension = FilenameUtils.getExtension(file.getName());
			//svn-base
			if (file.isFile() && !filterFile.contains(file.getName())) {
				String filecontent = FileUtil.readUtf8String(file);
				boolean needRewrite = false;

				Set<Entry<String, String>> old2newStrSet = old2newStr.entrySet();
				for (Entry<String, String> entry1 : old2newStrSet) {
					String oldstrfragment = entry1.getKey();
					String newstrfragment = entry1.getValue();
					if (filecontent.contains(oldstrfragment)) {
						filecontent = filecontent.replaceAll(oldstrfragment, newstrfragment);
						needRewrite = true;
					}
				}

				if (needRewrite) {
					FileUtil.writeString(filecontent, file.getCanonicalPath(), "utf-8");//.writeStringToFile(file, filecontent, "utf-8");
					System.out.println(++modifiedCount + "、" + file.getAbsolutePath());
				}

			} else if (file.isDirectory()) {
				replaceStr(absolutePath, old2newStr);
			}
		}
	}

	/**
	 * tio版本升级
	 * 
	 * @author tanyaowu
	 */
	public static void tio() {
		String[] rootDirStrs = new String[] { "F:\\work\\sharebike", "D:\\work\\tio-websocket-showcase", "F:\\work\\tio-core-showcase", "F:\\work\\tio-jbolt",
		        "F:\\work\\tio-chat-base", "D:\\work\\t-io", "F:\\work\\tio-site", "F:\\work\\tio-site-qijian", "F:\\work\\tio-site-baijin", "D:\\work\\tio-core-showcase",
		        "D:\\work\\sharebike", "G:\\work\\tio-showcase-websocket", "G:\\work\\tio-showcase-udp", "G:\\work\\tio-showcase-http-server" };
		//		String[] rootDirStrs = new String[] { "F:\\work\\tio-img\\_webrtc", "F:\\work\\tio-jbolt", "F:\\work\\tio-site-page", "F:\\work\\tio-site", "F:\\work\\tio-site-baijin",
		//		        "F:\\work\\tio-chat-base", "F:\\work\\tio-site-qijian" };

		String newversion = "3.6.0.v20200315-RELEASE";
		String oldversion = "3.5.9.v20200214-RELEASE";
		Map<String, String> old2newStr = new HashMap<>();

		old2newStr.put(oldversion, newversion);

		//		old2newStr.put("tio-core-showcase", "tio-study");
		//		old2newStr.put("tio-showcase", "tio-study");
		//		
		//		old2newStr.put("org.tio.examples", "org.tio.study");

		for (String rootDirStr : rootDirStrs) {
			//			old2newFilename.putAll(old2newStr);

			try {
				//如果需要修改文件名字，就在这里调一下rename
				//				rename(rootDirStr, old2newStr);

				//替换文字
				replaceStr(rootDirStr, old2newStr);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	public final static String	mianZheFileOld			= "F:\\work\\tio-site\\some\\doc\\服务条款和免责声明.txt";
	public final static String	mianZheFileNew			= "F:\\work\\tio-site\\some\\doc\\服务条款和免责声明-new.txt";
	public final static String	mianZhe_apacheFile		= "D:\\work\\t-io\\docs\\license_header.txt";
	public final static String	mianZhe_tiostudyFile	= "F:\\work\\tio-site\\some\\doc\\服务条款和免责声明-脚手架.txt";

	/**
	 * 删除免责声明
	 */
	public static void deleteMianZhe() {
		String[] rootDirStrs = new String[] { "D:\\work\\tio-core-showcase" };
		String content = cn.hutool.core.io.FileUtil.readUtf8String(new File(mianZhe_tiostudyFile));
		for (String rootDirStr : rootDirStrs) {
			try {
				deleteMianZhe(rootDirStr, content);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}

		rootDirStrs = new String[] { "F:\\work\\tio-site", "F:\\work\\tio-site-qijian", "F:\\work\\tio-site-baijin", "D:\\work\\tio-study", "D:\\work\\sharebike" };
		content = cn.hutool.core.io.FileUtil.readUtf8String(new File(mianZheFileOld));
		for (String rootDirStr : rootDirStrs) {
			try {
				deleteMianZhe(rootDirStr, content);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}

		rootDirStrs = new String[] { "D:\\work\\t-io", "G:\\work\\tio-showcase-websocket", "G:\\work\\tio-showcase-http-server" };
		content = cn.hutool.core.io.FileUtil.readUtf8String(new File(mianZhe_apacheFile));
		for (String rootDirStr : rootDirStrs) {
			try {
				deleteMianZhe(rootDirStr, content);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}

		//		rootDirStrs = new String[] {"F:\\work\\tio-site-qijian", "F:\\work\\tio-site-baijin"};
		//		content = cn.hutool.core.io.FileUtil.readUtf8String(new File(mianZheFileOld));
		//		for (String rootDirStr : rootDirStrs) {
		//			try {
		//				deleteMianZhe(rootDirStr, content);
		//			} catch (Exception e) {
		//				log.error(e.getMessage(), e);
		//			}
		//		}

	}

	/** , "D:\\work\\tio-core-showcase"
	 * 添加免责声明
	 */
	public static void addMianZhe() {
		String[] rootDirStrs = new String[] { "F:\\work\\tio-site", "F:\\work\\tio-site-qijian", "F:\\work\\tio-site-baijin", "D:\\work\\sharebike" };
		String content = cn.hutool.core.io.FileUtil.readUtf8String(new File(mianZheFileNew));
		for (String rootDirStr : rootDirStrs) {
			try {
				addMianZhe(rootDirStr, content);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}

		rootDirStrs = new String[] { "D:\\work\\tio-core-showcase" };
		content = cn.hutool.core.io.FileUtil.readUtf8String(new File(mianZhe_tiostudyFile));
		for (String rootDirStr : rootDirStrs) {
			try {
				addMianZhe(rootDirStr, content);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}

		rootDirStrs = new String[] { "D:\\work\\t-io", "G:\\work\\tio-showcase-websocket", "G:\\work\\tio-showcase-http-server" };
		content = cn.hutool.core.io.FileUtil.readUtf8String(new File(mianZhe_apacheFile));
		for (String rootDirStr : rootDirStrs) {
			try {
				addMianZhe(rootDirStr, content);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}

		//		rootDirStrs = new String[] {"F:\\work\\tio-site-qijian", "F:\\work\\tio-site-baijin"};
		//		content = cn.hutool.core.io.FileUtil.readUtf8String(new File(mianZheFileOld));
		//		for (String rootDirStr : rootDirStrs) {
		//			try {
		//				addMianZhe(rootDirStr, content);
		//			} catch (Exception e) {
		//				log.error(e.getMessage(), e);
		//			}
		//		}
	}

	public static String[] TIO_SITE_DIRS = new String[] { "F:\\work\\tio-site", "F:\\work\\tio-site-qijian", "F:\\work\\tio-site-baijin" };

	/**
	 * 给代码生成器生成的代码添加服务条款和免责声明
	 */
	public static void addMianZhe4DbModel() {
		//		谭总的代码付款条款目录
		//		String[] rootDirStrs = new String[] {"F:\\work\\tio-site"};
		//		徐飞的代码条款目录
		String[] rootDirStrs = new String[] { "D:\\tio\\tio-site\\src\\frontend" };
		//tan_flag.txt
		File test = new File("F:/tan_flag.txt");
		if (test.exists()) {
			rootDirStrs = new String[] { "F:\\work\\tio-site" };
		}
		String oldcontent = cn.hutool.core.io.FileUtil.readUtf8String(new File(mianZheFileOld));
		String newcontent = cn.hutool.core.io.FileUtil.readUtf8String(new File(mianZheFileNew));

		for (String rootDirStr : rootDirStrs) {
			try {
				deleteMianZhe(rootDirStr, oldcontent);
				addMianZhe(rootDirStr, newcontent);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}

	}

	public static void addMianZhe(String rootDirStr, String content) throws Exception {
		if (cn.hutool.core.util.StrUtil.isBlank(content)) {
			return;
		}

		File rootDir = new File(rootDirStr);
		File[] files = rootDir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				String ext = cn.hutool.core.io.FileUtil.extName(pathname);
				if ("java".equalsIgnoreCase(ext)) {
					return true;
				}
				if (pathname.isDirectory()) {
					return true;
				}
				return false;
			}
		});

		if (files == null) {
			return;
		}

		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			String absolutePath = file.getAbsolutePath();
			//			String filename = file.getName();
			//			Set<Entry<String, String>> old2newFilenameSet = old2newFilename.entrySet();

			//			String extension = FilenameUtils.getExtension(file.getName());
			//svn-base
			if (file.isFile()) {
				String filecontent = FileUtil.readUtf8String(file);

				if (cn.hutool.core.util.StrUtil.isNotBlank(filecontent) && !filecontent.startsWith(content)) {
					FileUtil.writeUtf8String(content + filecontent, file);
					System.out.println(++modifiedCount + "、" + file.getAbsolutePath());
				}
			} else if (file.isDirectory()) {
				addMianZhe(absolutePath, content);
			}
		}
	}

	public static void deleteMianZhe(String rootDirStr, String content) throws Exception {
		if (cn.hutool.core.util.StrUtil.isBlank(content)) {
			return;
		}

		File rootDir = new File(rootDirStr);
		File[] files = rootDir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				String ext = cn.hutool.core.io.FileUtil.extName(pathname);
				if ("java".equalsIgnoreCase(ext)) {
					return true;
				}
				if (pathname.isDirectory()) {
					return true;
				}
				return false;
			}
		});

		if (files == null) {
			return;
		}

		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			String absolutePath = file.getAbsolutePath();
			if (file.isFile()) {
				String filecontent = FileUtil.readUtf8String(file);
				filecontent = StrUtil.replace(filecontent, content, "");
				FileUtil.writeUtf8String(filecontent, file);
			} else if (file.isDirectory()) {
				deleteMianZhe(absolutePath, content);
			}
		}
	}

	/**
	 * 官网内容替换
	 */
	public static void tioSiteReplace() {
		String[] rootDirStrs = new String[] { "F:\\work\\tio-site-qijian", "F:\\work\\tio-site" };

		Map<String, String> old2newStr = new HashMap<>();
		old2newStr.put("P2P_NOT_READ_COUNT", "P2P_RECENT_CHAT_LIST");
		old2newStr.put("P2PNotReadCount", "P2PRecentChatList");

		for (String rootDirStr : rootDirStrs) {
			Map<String, String> old2newFilename = new HashMap<>();
			old2newFilename.putAll(old2newStr);

			try {
				//如果需要修改文件名字，就在这里调一下rename
				rename(rootDirStr, old2newFilename);

				//替换文字
				replaceStr(rootDirStr, old2newStr);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	public static void newProject() {
		String[] rootDirStrs = new String[] { "F:\\work\\tio-site\\src\\frontend-new" };

		for (String rootDirStr : rootDirStrs) {
			Map<String, String> old2newStr = new HashMap<>();
			Map<String, String> old2newFilename = new HashMap<>();

			String oldName = "live";
			String newName = "site";

			//			String oldName = "im";
			//			String newName = "live";

			String splitStr = "-";
			//中划线
			splitStr = "-";
			old2newStr.put("tio" + splitStr + oldName, "tio" + splitStr + newName);
			old2newStr.put("tio" + splitStr + StrUtil.upperFirst(oldName), "tio" + splitStr + StrUtil.upperFirst(newName));

			old2newStr.put("Tio" + splitStr + oldName, "Tio" + splitStr + newName);
			old2newStr.put("Tio" + splitStr + StrUtil.upperFirst(oldName), "Tio" + splitStr + StrUtil.upperFirst(newName));

			old2newStr.put("TIO" + splitStr + oldName.toUpperCase(), "TIO" + splitStr + newName.toUpperCase());

			//下划线
			splitStr = "_";
			old2newStr.put("tio" + splitStr + oldName, "tio" + splitStr + newName);
			old2newStr.put("tio" + splitStr + StrUtil.upperFirst(oldName), "tio" + splitStr + StrUtil.upperFirst(newName));

			old2newStr.put("Tio" + splitStr + oldName, "Tio" + splitStr + newName);
			old2newStr.put("Tio" + splitStr + StrUtil.upperFirst(oldName), "Tio" + splitStr + StrUtil.upperFirst(newName));

			old2newStr.put("TIO" + splitStr + oldName.toUpperCase(), "TIO" + splitStr + newName.toUpperCase());

			//一个空格
			splitStr = " ";
			old2newStr.put("tio" + splitStr + oldName, "tio" + splitStr + newName);
			old2newStr.put("tio" + splitStr + StrUtil.upperFirst(oldName), "tio" + splitStr + StrUtil.upperFirst(newName));

			old2newStr.put("Tio" + splitStr + oldName, "Tio" + splitStr + newName);
			old2newStr.put("Tio" + splitStr + StrUtil.upperFirst(oldName), "Tio" + splitStr + StrUtil.upperFirst(newName));

			old2newStr.put("TIO" + splitStr + oldName.toUpperCase(), "TIO" + splitStr + newName.toUpperCase());

			//空串
			splitStr = "";
			old2newStr.put("tio" + splitStr + oldName, "tio" + splitStr + newName);
			old2newStr.put("tio" + splitStr + StrUtil.upperFirst(oldName), "tio" + splitStr + StrUtil.upperFirst(newName));

			old2newStr.put("Tio" + splitStr + oldName, "Tio" + splitStr + newName);
			old2newStr.put("Tio" + splitStr + StrUtil.upperFirst(oldName), "Tio" + splitStr + StrUtil.upperFirst(newName));

			//特殊处理
			old2newStr.put("TIO_LIVEEI", "TIO_IMEI");
			old2newStr.put("tio_liveei", "tio_imei");
			old2newStr.put("TIO-LIVEEI", "TIO-IMEI");
			old2newStr.put("tio-liveei", "tio-imei");

			old2newFilename.putAll(old2newStr);

			try {
				//如果需要修改文件名字，就在这里调一下rename
				rename(rootDirStr, old2newFilename);

				//替换文字
				replaceStr(rootDirStr, old2newStr);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * 简单的替换
	 */
	public static void onlyReplace() {
		String[] rootDirStrs = new String[] { "F:\\work\\tio-site\\src\\frontend\\all\\starter\\src\\main\\resources\\config\\page\\doc" };

		for (String rootDirStr : rootDirStrs) {
			Map<String, String> old2newStr = new HashMap<>();
			Map<String, String> old2newFilename = new HashMap<>();

			old2newStr.put("/doc/", "/doc/tio/");

			old2newStr.put("/doc/", "/doc/tio/");

			old2newFilename.putAll(old2newStr);

			try {
				//如果需要修改文件名字，就在这里调一下rename
				rename(rootDirStr, old2newFilename);

				//替换文字
				replaceStr(rootDirStr, old2newStr);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	public static void tioSiteCode(String dir, String mykey) {
		String[] rootDirStrs = new String[] { dir };
		String flag = mykey;

		for (String rootDirStr : rootDirStrs) {
			Map<String, String> old2newStr = new HashMap<>();
			Map<String, String> old2newFilename = new HashMap<>();

			old2newStr.put("tio_qijian_session", "tio_" + flag + "_session");

			String key = "UijSoEpB";
			old2newStr.put(key, key.substring(0, key.length() - flag.length()) + flag);

			key = "PkjSmTnb";
			old2newStr.put(key, key.substring(0, key.length() - flag.length()) + flag);

			key = "uPezilSoTLyzkMop";
			old2newStr.put(key, key.substring(0, key.length() - flag.length()) + flag);

			key = "xOezYlYsPebzEolO";
			old2newStr.put(key, key.substring(0, key.length() - flag.length()) + flag);

			key = "iOezXlTsOebzEolU";
			old2newStr.put(key, key.substring(0, key.length() - flag.length()) + flag);

			old2newFilename.putAll(old2newStr);

			try {
				//如果需要修改文件名字，就在这里调一下rename
				rename(rootDirStr, old2newFilename);

				//替换文字
				replaceStr(rootDirStr, old2newStr);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * 切换网站风格
	 * 
	 * @author tanyaowu
	 */
	public static void changeSiteStyle() {
		String[] rootDirStrs = new String[] { "F:\\work\\tio-site\\src\\frontend\\web-all\\starter\\src\\main\\resources\\config\\page" };

		for (String rootDirStr : rootDirStrs) {
			Map<String, String> old2newStr = new HashMap<>();
			Map<String, String> old2newFilename = new HashMap<>();
			old2newStr.put("#00CC00", "#0000CC");
			old2newStr.put("#0376e0", "#03e076");

			old2newStr.put("#0099FF", "#00FF99");
			old2newStr.put("#0c7ac9", "#0cc97a");
			old2newStr.put("#00ff80", "#0080ff");
			old2newStr.put("#e7f5ff", "#e7fff5");
			old2newStr.put("#379ef8", "#37f89e");
			old2newStr.put("#9accf9", "#9af9cc");
			old2newStr.put("#6f6", "#66f");
			old2newStr.put("#108ee9", "#10e98e");
			old2newStr.put("#1E9FFF", "#1EFF9F");

			//
			old2newStr.put("#00FF99", "#03e076");

			old2newFilename.putAll(old2newStr);

			try {

				//替换文字
				replaceStr(rootDirStr, old2newStr);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	public static void rename() {
		String[] rootDirStrs = new String[] { "D:\\work\\tio-im", "F:\\gitee\\java", "D:\\work\\tio-im(改名前)" };

		for (String rootDirStr : rootDirStrs) {
			Map<String, String> old2newFilename = new HashMap<>();
			old2newFilename.put("nb830.dic", "nb919.dic");

			try {
				rename(rootDirStr, old2newFilename);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * 用newFile替换文件名相同的文件
	 * @param newFile 新的文件
	 * @param rootDirStrs 要搜索的目录
	 * @throws Exception
	 * @author tanyaowu
	 */
	public static void replaceFiles(File newFile, String[] rootDirStrs) throws Exception {
		byte[] newBytes = FileUtil.readBytes(newFile);
		for (String rootDirStr : rootDirStrs) {
			try {
				replaceFile(newFile, newBytes, rootDirStr);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	/**
	 * 用newFile替换文件名相同的文件
	 * @param newFile
	 * @param newBytes
	 * @param rootDirStr
	 * @throws Exception
	 * @author tanyaowu
	 */
	private static void replaceFile(File newFile, byte[] newBytes, String rootDirStr) throws Exception {
		File rootDir = new File(rootDirStr);
		File[] files = rootDir.listFiles();

		if (files.length == 0) {

		} else {
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				String absolutePath = file.getAbsolutePath();

				if (file.isDirectory()) {
					replaceFile(newFile, newBytes, absolutePath);
				} else {
					if (file.getName().equals(newFile.getName())) {
						FileUtil.writeBytes(newBytes, file);
						System.out.println(file.getCanonicalPath());
					}
				}
			}
		}
	}

	/**
	 * 给空目录添加一个空白文件
	 * @param rootDirStr
	 */
	public static void addBlankFile(String rootDirStr) {
		File rootDir = new File(rootDirStr);
		File[] files = rootDir.listFiles();

		if (files.length == 0) {
			File blankFile = new File(rootDir, "svn.txt");
			log.warn(blankFile.getAbsolutePath());
			try {
				blankFile.createNewFile();
			} catch (IOException e) {
				log.error("", e);
			}
		} else {
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				String absolutePath = file.getAbsolutePath();

				if (file.isDirectory()) {
					addBlankFile(absolutePath);
				}
			}
		}
	}

	/**
	 * 
	 * @param rootDirStr
	 * @param searchStr
	 * @param count
	 * @author tanyaowu
	 */
	public static void findFile(String rootDirStr, String searchStr, AtomicInteger count) {
		File rootDir = new File(rootDirStr);
		File[] files = rootDir.listFiles();

		if (files.length == 0) {

		} else {
			for (int i = 0; i < files.length; i++) {
				try {
					File file = files[i];
					String absolutePath = file.getAbsolutePath();

					if (StrUtil.containsAny(file.getName(), searchStr)) {
						if (file.isDirectory()) {
							log.warn("\r\n[dir ]" + file.getAbsolutePath());
						} else {
							log.warn("\r\n[file]" + file.getAbsolutePath());
						}
						count.incrementAndGet();
					}
					if (file.isDirectory()) {
						findFile(absolutePath, searchStr, count);
					}
				} catch (Exception e) {
					log.error("", e);
				}
			}
		}
	}

	/**
	 * 删除文件名与filenames中相同的
	 * @param rootDirStrs
	 * @param filenames
	 * @author tanyaowu
	 */
	public static void deleteFiles(String[] rootDirStrs, String[] filenames) {
		for (String rootDirStr : rootDirStrs) {
			try {
				deleteFile(rootDirStr, filenames);
			} catch (Exception e) {
				log.error("", e);
			}
		}
	}

	/**
	 * 删除文件名与filenames中相同的
	 * @param rootDirStr
	 * @author tanyaowu
	 */
	@SuppressWarnings("unused")
	public static void deleteFile(String rootDirStr, String[] filenames) {
		File rootDir = new File(rootDirStr);
		File[] files = rootDir.listFiles();

		if (files.length == 0) {

		} else {
			lab1: for (int i = 0; i < files.length; i++) {
				try {
					File file = files[i];
					String absolutePath = file.getAbsolutePath();

					lab2: for (int j = 0; j < filenames.length; j++) {
						if (file.getName().equals(filenames[j])) {
							FileUtil.del(file);
							log.warn(file.getAbsolutePath());
							continue lab1;
						}
					}

					if (file.isDirectory()) {
						deleteFile(absolutePath, filenames);
					}
				} catch (Exception e) {
					log.error("", e);
				}
			}
		}
	}

	static class MyFileFilter implements FileFilter {

		@Override
		public boolean accept(File file) {
			//			return true;

			String absolutePath = file.getAbsolutePath();
			String filename = file.getName();
			String extension = FileUtil.extName(filename);//.getExtension(filename);
			if (file.isDirectory()) {
				if (absolutePath.contains("\\webapp\\js") || absolutePath.contains("-app\\nginx\\cache") || absolutePath.contains("nginx\\html\\js") || filename.equals("target")) {
					return false;
				}

				if ("svn-base".equalsIgnoreCase(extension)) {
					return false;
				}

				return true;
			}

			String ext = FileUtil.extName(file);
			if (acceptedExt.contains(ext)) {
				return true;
			}

			return false;
		}

	}
}
