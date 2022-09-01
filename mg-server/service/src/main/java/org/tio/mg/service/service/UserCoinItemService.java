/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.main.UserCoinItem;
import org.tio.sitexxx.servicecommon.vo.Const;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 用户财务明细服务表
 * 
 *
 */
public class UserCoinItemService {

	private static Logger log = LoggerFactory.getLogger(UserCoinItemService.class);

	public static final UserCoinItemService me = new UserCoinItemService();

	final UserCoinItem userCoinItemDao = new UserCoinItem().dao();

	/**
	 * 消费记录
	 * @param uid
	 * @param coinmode
	 * @param month
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * 
	 */
	public Ret getUserCoinItem(Integer uid, Byte coinmode, String month, Integer pageNumber, Integer pageSize) {
		if (uid == null) {
			log.error("uid is null");
			return Ret.fail("msg", "用户id为空");
		}
		if (pageNumber == null || pageNumber <= 0) {
			pageNumber = 1;
		}
		if (pageSize == null || pageSize <= 0) {
			pageSize = 10;
		}
		Kv params = Kv.by("uid", uid).set("coinmode", coinmode);
		DateTime queryMonth = null;
		if (StrUtil.isBlank(month)) {
			queryMonth = new DateTime();
		} else {
			queryMonth = DateUtil.parse(month, "yyyy-MM");
		}
		DateTime beginTime = DateUtil.beginOfMonth(queryMonth);
		DateTime endTime = DateUtil.endOfMonth(queryMonth);
		params.set("begintime", beginTime.toTimestamp()).set("endtime", endTime.toTimestamp());
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("usercoinitem.getUserCoinItem", params);
		Page<UserCoinItem> userCosts = userCoinItemDao.paginate(pageNumber, pageSize, sqlPara);
		Ret ret = Ret.ok().set("data", userCosts);
		return ret;
	}

	public static void main(String[] args) throws Exception {
	}

}
