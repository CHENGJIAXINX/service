/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.utils;

import cn.hutool.core.util.NumberUtil;
import org.tio.sitexxx.service.service.base.SensitiveWordsService;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

import cn.hutool.core.util.StrUtil;

/**
 * @author tanyaowu
 */
public class CommonUtils {
	/**
	 *
	 * @param name
	 * @param prefix
	 * @return
	 */
	public static Resp checkGroupName(String name, String prefix) {
		if (StrUtil.isBlank(name)) {
			return Resp.fail(prefix + "不允许为空");
		}
		if (name.length() > 32) {
			return Resp.fail(prefix + "太长了");
		}

//		if (name.contains("@") || name.contains("＠")) {
//			return Resp.fail(prefix + "不能包含 \"@\" 字符");
//		}

//		if (name.contains(" ") || name.contains("　")) {
//			return Resp.fail(prefix + "不能包含空格");
//		}

//		if (StrUtil.containsAny(name, Const.SPECIAL_CHARACTER)) {
//			return Resp.fail(prefix + "不能包含如下特殊字符：" + Json.toJson(Const.SPECIAL_CHARACTER));
//		}

		if (SensitiveWordsService.isMatch(name)) {
			return Resp.fail(prefix + "存在敏感信息，请重新输入");
		}

		return Resp.ok();
	}

	public static boolean isPhone(String str){
		if (str == null || str.length() != 11){
			return false;
		}
		if (!NumberUtil.isNumber(str)){
			return false;
		}
		return true;
	}
}
