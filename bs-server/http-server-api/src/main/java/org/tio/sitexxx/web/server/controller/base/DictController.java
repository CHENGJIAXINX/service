/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.server.annotation.RequestPath;
import org.tio.sitexxx.service.model.conf.Dict;
import org.tio.sitexxx.service.service.conf.DictService;
import org.tio.utils.resp.Resp;

/**
 *
 * 
 */
@RequestPath(value = "/dict")
public class DictController {

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(DictController.class);

	/**
	 * 
	 * 
	 */
	public DictController() {
	}

	/**
	 * 
	 * @param request
	 * @param uid
	 * @return
	 * @throws Exception
	 * 
	 */
	@RequestPath(value = "/child")
	public Resp child(String code) throws Exception {
		List<Dict> child = DictService.getChildDictByParentCode(code);
		return Resp.ok().data(child);
	}

	/**
	 * 用户获取视频信息(观看历史记录)
	 * @param id
	 * @return
	 * @throws Exception
	 * 
	 */
	@RequestPath(value = "/info")
	public Resp videoInfo(String code) throws Exception {
		Dict dict = DictService.getDictByCode(code);
		return Resp.ok().data(dict);
	}
}
