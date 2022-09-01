/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.service.model.conf.Dict;
import org.tio.sitexxx.servicecommon.vo.Const;

/**
 * 字典数据加载
 * 
 */
public class DictService {

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(DictService.class);

	public static final DictService me = new DictService();

	final static Dict dictDao = new Dict().dao();

	/**
	 * 子列表缓存前缀
	 */
	private static String CHILD_DICT_PRE = "child_list_";

	/**
	 * 字典缓存
	 * key: parentCode / code, value: List<Dict> / <Dict>
	 */
	private static Map<String, Object> cacheData = new HashMap<>();

	/**
	 * 清空字典缓存
	 * 
	 */
	public static void clearDict() {
		synchronized (Dict.class) {
			cacheData = new HashMap<>();
		}
	}

	/**
	 * 获取父节点下的子节点信息
	 * @param parentCode
	 * @return
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static List<Dict> getChildDictByParentCode(String parentCode) {
		String key = CHILD_DICT_PRE + parentCode;
		Object childDictList = cacheData.get(key);
		if (childDictList == null) {
			synchronized (Dict.class) {
				if (childDictList == null) {
					childDictList = dictDao.find("select id,name,code,pcode from dict where pcode = ? and status = ? order by orderby", parentCode, Const.Status.NORMAL);
					if (childDictList != null) {
						cacheData.put(key, childDictList);
					}
				}
			}
		}
		return childDictList != null ? (List<Dict>) childDictList : null;
	}

	/**
	 * 移除父节点下的列表
	 * @param parentCode
	 * 
	 */
	public static void clearChildDictByParent(String parentCode) {
		synchronized (Dict.class) {
			cacheData.remove(CHILD_DICT_PRE + parentCode);
		}
	}

	/**
	 * 清空节点信息
	 * @param code
	 * @param parentCode
	 * 
	 */
	public static void clearDictByCode(String code, String parentCode) {
		synchronized (Dict.class) {
			cacheData.remove(code);
			cacheData.remove(CHILD_DICT_PRE + parentCode);
		}
	}

	/**
	 * 获取字典信息
	 * @param code
	 * @return
	 * 
	 */
	public static Dict getDictByCode(String code) {
		Object dict = cacheData.get(code);
		if (dict == null) {
			synchronized (Dict.class) {
				if (dict == null) {
					dict = dictDao.findFirst("select id,name,code,pcode,attribute from dict where code = ? and status = ? order by orderby", code, Const.Status.NORMAL);
					if (dict != null) {
						cacheData.put(code, dict);
					}
				}
			}
		}
		return dict != null ? (Dict) dict : null;
	}
}
