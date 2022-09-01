/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.sitexxx.service.model.main.RechargeItem;
import org.tio.sitexxx.service.model.main.UserCoin;
import org.tio.sitexxx.servicecommon.vo.Const;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

/**
 * 用户财务信息业务类
 * 
 *
 */
public class UserCoinService {

	private static Logger log = LoggerFactory.getLogger(UserCoinService.class);

	public static final UserCoinService me = new UserCoinService();

	final UserCoin userCoinDao = new UserCoin().dao();

	final RechargeItem rechargeItemDao = new RechargeItem().dao();

	/**
	 * 充值
	 * @param uid
	 * @param addCoin
	 * @return
	 * 
	 */
	public boolean addCoin(Integer uid, Double addCoin) {
		Kv params = Kv.by("uid", uid).set("addcoin", addCoin).set("status", Const.Status.NORMAL);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("usercoin.addCoin", params);
		int updateRow = Db.use(Const.Db.TIO_SITE_MAIN).update(sqlPara);
		if (updateRow <= 0) {
			log.error("充值，用户财务表数据异常.更新条数:{}", updateRow);
		}
		return updateRow > 0;
	}

	/**
	 * 添加攻击币值(更新user_coin表的attackcoin字段)
	 * @param uid
	 * @param addCoin
	 * @return
	 * @author tanyaowu
	 */
	public boolean addAttackcoin(Integer uid, Double addCoin) {
		Kv params = Kv.by("uid", uid).set("addcoin", addCoin).set("status", Const.Status.NORMAL);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("usercoin.addAttackCoin", params);
		int updateRow = Db.use(Const.Db.TIO_SITE_MAIN).update(sqlPara);
		if (updateRow <= 0) {
			log.error("攻击充值，用户财务表数据异常.更新条数:{}", updateRow);
		}
		return updateRow > 0;
	}

	/**
	 * 新增T分
	 * @param uid
	 * @param addCoin
	 * @return
	 * 
	 */
	public boolean addFreeCoin(Integer uid, Double addCoin) {
		Kv params = Kv.by("uid", uid).set("addcoin", addCoin).set("status", Const.Status.NORMAL);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("usercoin.freecoin", params);
		int updateRow = Db.use(Const.Db.TIO_SITE_MAIN).update(sqlPara);
		if (updateRow <= 0) {
			log.error("新增T分，用户财务表数据异常.更新条数:{}", updateRow);
		}
		return updateRow > 0;
	}

	/**
	 * 新增钱包
	 * @param uid
	 * @param addCny
	 * @return
	 * 
	 */
	public boolean addCny(Integer uid, Double addCny) {
		Kv params = Kv.by("uid", uid).set("addcny", addCny).set("status", Const.Status.NORMAL);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("usercoin.cny", params);
		int updateRow = Db.use(Const.Db.TIO_SITE_MAIN).update(sqlPara);
		if (updateRow <= 0) {
			log.error("新增T分，用户财务表数据异常.更新条数:{}", updateRow);
		}
		return updateRow > 0;
	}

	/**
	 * 红包提现-未冻结
	 * @param id
	 * @param cny
	 * @return
	 */
	public boolean withdrawCny(Integer id, Double cny) {
		Kv params = Kv.by("id", id).set("cny", cny).set("status", Const.Status.NORMAL);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("usercoin.withdrawCny", params);
		int updateRow = Db.use(Const.Db.TIO_SITE_MAIN).update(sqlPara);
		if (updateRow <= 0) {
			log.error("红包提现，用户财务表数据异常.更新条数:{}", updateRow);
		}
		return updateRow > 0;
	}

	/**
	 * 未冻结处理，需要后续思考下-TO
	 * @param uid
	 * @param cny
	 * @return
	 */
	public boolean refundCny(Integer uid, Double cny) {
		Kv params = Kv.by("uid", uid).set("cny", cny).set("status", Const.Status.NORMAL);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("usercoin.refundCny", params);
		int updateRow = Db.use(Const.Db.TIO_SITE_MAIN).update(sqlPara);
		if (updateRow <= 0) {
			log.error("红包退款，用户财务表数据异常.更新条数:{}", updateRow);
		}
		return updateRow > 0;
	}

	/**
	 * 消费T分
	 * @param uid
	 * @param freecoin
	 * @return
	 * 
	 */
	public boolean costFreeCoin(Integer uid, Double freecoin) {
		Kv params = Kv.by("uid", uid).set("freecoin", freecoin).set("status", Const.Status.NORMAL);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("usercoin.costFreeCoin", params);
		int updateRow = Db.use(Const.Db.TIO_SITE_MAIN).update(sqlPara);
		if (updateRow <= 0) {
			log.error("消费T分，用户财务表数据异常.更新条数:{}", updateRow);
		}
		return updateRow > 0;
	}

	/**
	 * 获取单独usercoin的信息
	 * @param uid
	 * @return
	 * 
	 */
	public UserCoin getUserSimpleCoin(Integer uid) {
		Kv params = Kv.by("uid", uid).set("status", Const.Status.NORMAL);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("usercoin.getUserSimpleCoin", params);
		UserCoin userCoin = userCoinDao.findFirst(sqlPara);
		return userCoin;
	}

	/**
	 * 用户充值记录
	 * @param uid
	 * @param queryParams
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * 
	 */
	public Ret getUserRecharge(Integer uid, Map<String, Object> queryParams, Integer pageNumber, Integer pageSize) {
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
		Kv params = Kv.by("uid", uid).set("status", RechargeItem.Status.SUCCESS).set("rechargetype", Const.StandardMode.RECHARGE);
		if (queryParams.get("begintime") != null) {
			String begintime = queryParams.get("begintime").toString();
			params.set("begintime", DateUtil.parse(begintime.toString()).toSqlDate());
		} else {
			params.set("begintime", DateUtil.offsetDay(new DateTime(), -7).toSqlDate());
		}
		if (queryParams.get("endtime") != null) {
			String endtime = queryParams.get("endtime").toString();
			params.set("endtime", DateUtil.offsetDay(DateUtil.parse(endtime.toString()), 1).toSqlDate());
		} else {
			params.set("endtime", DateUtil.tomorrow().toSqlDate());
		}
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("userrecharge.getUserRecharge", params);
		Page<RechargeItem> userRechargePage = rechargeItemDao.paginate(pageNumber, pageSize, sqlPara);
		return Ret.ok().set("data", userRechargePage);
	}

	public static void main(String[] args) throws Exception {
	}

}
