package org.tio.mg.service.service.base;

import cn.hutool.core.util.StrUtil;
import cn.hutool.dfa.WordTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.mg.service.model.conf.SensitiveWordsList;
import org.tio.utils.jfinal.P;

import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词
 *
 * @author tanyaowu
 * 2016年5月29日 下午2:50:41
 */
public class SensitiveWordsService {
    private static final SensitiveWordsList dao = new SensitiveWordsList().dao();


    public static interface SensitiveWordsHandler {
        /**
         * @param initText
         * @param sensitiveWord
         * @return
         * @author tanyaowu
         */
        String replace(String initText, String sensitiveWord);
    }

    private static Logger log = LoggerFactory.getLogger(SensitiveWordsService.class);

    public static final WordTree wordTree = new WordTree();

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
        }
    }

    public static List<SensitiveWordsList> getWords() {
        String sql = "select * from sensitive_words_list where status = 1;";
        return dao.find(sql);
    }

    /**
     * 是否包含敏感词
     *
     * @param text
     * @return true: 表示有敏感词， false：没有敏感词
     * @author: tanyaowu
     */
    public static boolean isMatch(String text) {
        return wordTree.isMatch(text);
    }

    /**
     * 搜索并替换全部敏感词
     *
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
     *
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
     *
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
     *
     * @param initText
     * @return
     * @author: tanyaowu
     */
    public static String findAndReplace(String initText) {
        return findAndReplace(initText, P.get("sensitive.words.replace.text"));
    }

    /**
     * 搜索并替换全部敏感词
     *
     * @param initText
     * @param logstr
     * @return
     * @author: tanyaowu
     */
    public static String findAndReplaceWithLog(String initText, String logstr) {
        return findAndReplaceWithLog(initText, P.get("sensitive.words.replace.text"), logstr);
    }
}
