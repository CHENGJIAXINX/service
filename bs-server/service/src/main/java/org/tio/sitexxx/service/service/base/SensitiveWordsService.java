/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.base;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.service.model.conf.SensitiveWordsList;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.utils.jfinal.P;

import cn.hutool.core.util.StrUtil;
import cn.hutool.dfa.WordTree;

/**
 * 敏感词
 * @author tanyaowu
 * 2016年5月29日 下午2:50:41
 */
public class SensitiveWordsService {
	public static interface SensitiveWordsHandler {
		/**
		 *
		 * @param initText
		 * @param sensitiveWord
		 * @return
		 * @author tanyaowu
		 */
		String replace(String initText, String sensitiveWord);
	}

	private static Logger log = LoggerFactory.getLogger(SensitiveWordsService.class);

	public static final WordTree wordTree = new WordTree();

	private static final SensitiveWordsList dao = new SensitiveWordsList().dao();

	private static final String TABLE_NAME = "sensitive_words_list";


//	public static void init() {
//		wordTree.clear();
//		String rootDirStr = FileUtil.getAbsolutePath("classpath:config/sensitive/");
//		File rootDir = new File(rootDirStr);
//		if (!rootDir.exists()) {
//			log.warn("文件[{}]不存在", rootDir.getAbsolutePath());
//			return;
//		}
//
//		File[] files = rootDir.listFiles();
//		int count = 0;
//		if (files != null) {
//			StringBuilder sb = new StringBuilder(256);
//			for (File file : files) {
//				sb.append(file.getAbsolutePath()).append(System.lineSeparator());
//				List<String> lines = FileUtil.readLines(file, "utf-8");
//				for (String line : lines) {
//					wordTree.addWord(line);
//					count++;
//				}
//			}
//			log.warn("敏感词库文件:{}", sb);
//		}
//		log.info("词库中一共有{}个敏感词", count);
//	}

	public static void init() {
		wordTree.clear();
		List<SensitiveWordsList> words = getWords();
		int count = 0;
		if (words != null) {
			List<String> word = new ArrayList();
			for (SensitiveWordsList item : words) {
				wordTree.addWord(item.getWord());
				word.add(item.getWord());
				count++;
			}
			log.warn("敏感词库文件:{}", word);
		}
		log.warn("词库中一共有{}个敏感词", count);
	}

	public static List<SensitiveWordsList> getWords(){
		String sql = "select * from "+TABLE_NAME+" where status = 1;";
		return dao.find(sql);
	}

	/**
	 * 是否包含敏感词
	 * @param text
	 * @return true: 表示有敏感词， false：没有敏感词
	 * @author: tanyaowu
	 */
	public static boolean isMatch(String text) {
		return wordTree.isMatch(text);
	}

	/**
	 * 搜索并替换全部敏感词
	 * @param initText
	 * @param sensitiveWordsHandler
	 * @param logstr
	 * @return
	 * @author: tanyaowu
	 */
	public static String findAndReplace(String initText, SensitiveWordsHandler sensitiveWordsHandler, Object logstr) {
		List<String> list = wordTree.matchAll(initText);
		if (list != null && list.size() > 0) {
			String ret = initText;
			for (String word : list) {
				ret = sensitiveWordsHandler.replace(ret, word);//StrUtil.replaceAll(ret, word, replaceText);
			}
			if (logstr != null) {
				log.error("{}, 找到敏感词，原文:【{}】，替换后的:【{}】", logstr, initText, ret);
			} else {
				log.error("找到敏感词，原文:【{}】，替换后的:【{}】", initText, ret);
			}
			return ret;
		}
		return initText;
	}

	/**
	 * 搜索并替换全部敏感词
	 * @param initText
	 * @param replaceText
	 * @return
	 * @author: tanyaowu
	 */
	public static String findAndReplace(String initText, String replaceText) {
		return findAndReplaceWithLog(initText, replaceText, null);
	}

	/**
	 * 用replaceText替换initText中的敏感词
	 * @param initText
	 * @param replaceText
	 * @param logstr
	 * @return
	 * @author tanyaowu
	 */
	public static String findAndReplaceWithLog(String initText, String replaceText, Object logstr) {
		List<String> list = wordTree.matchAll(initText);
		if (list != null && list.size() > 0) {
			String ret = initText;
			for (String word : list) {
				String xx = StrUtil.repeat(replaceText, word.length());
				ret = StrUtil.replace(ret, word, xx);
			}
			if (logstr != null) {
				log.warn("{}, 找到敏感词，原文:【{}】，替换后的:【{}】", logstr, initText, ret);
			} else {
				log.warn("找到敏感词，原文:【{}】，替换后的:【{}】", initText, ret);
			}
			return ret;
		}
		return initText;
	}

	/**
	 * 搜索并替换全部敏感词
	 * @param initText
	 * @return
	 * @author: tanyaowu
	 */
	public static String findAndReplace(String initText) {
		return findAndReplace(initText, ConfService.getString("sensitive.words.replace.text","*"));
	}

	/**
	 * 搜索并替换全部敏感词
	 * @param initText
	 * @param logstr
	 * @return
	 * @author: tanyaowu
	 */
	public static String findAndReplaceWithLog(String initText, String logstr) {
		return findAndReplaceWithLog(initText,ConfService.getString("sensitive.words.replace.text","*"), logstr);
	}

	/**
	 *
	 * @author tanyaowu
	 */
	private SensitiveWordsService() {
	}
}
