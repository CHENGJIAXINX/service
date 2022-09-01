/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.service.recharge;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.mg.service.model.main.RechargeItem;
import org.tio.mg.service.service.UserCoinService;
import org.tio.mg.service.service.atom.AbsAtom;
import org.tio.mg.service.service.atom.RechargeAtom;
import org.tio.mg.service.service.conf.MgConfService;
import org.tio.sitexxx.servicecommon.vo.Const;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author tanyaowu 
 * 2016年10月19日 下午4:13:05
 */
public class RechargeItemService {
	private static Logger log = LoggerFactory.getLogger(RechargeItemService.class);

	public static final RechargeItemService	me	= new RechargeItemService();
	public static final RechargeItem		dao	= new RechargeItem().dao();

	/**
	 * 
	 * @author: tanyaowu
	 */
	public RechargeItemService() {
	}

	/**
	 * 
	 * @param roomInst
	 * @return
	 */
	public boolean save(RechargeItem rechargeItem) {
		return rechargeItem.save();
	}

	/**
	 * 
	 * @param rechargeItem
	 * @return
	 */
	public boolean update(RechargeItem rechargeItem) {
		return rechargeItem.update();
	}

	/**
	 * 根据本系统的交易号
	 * @param tradeno
	 * @return
	 */
	public RechargeItem selectByTradeno(String tradeno) {
		if (StrUtil.isBlank(tradeno)) {
			return null;
		}
		return RechargeItem.dao.findFirst("select * from recharge_item where tradeno = ?", tradeno);
	}

	/**
	 * 根据receipt找充值记录
	 * @param receipt
	 * @param id
	 * @return
	 */
	public RechargeItem selectByReceipt(String receipt, Integer id) {
		if (StrUtil.isBlank(receipt)) {
			return null;
		}
		return RechargeItem.dao.findFirst("select * from recharge_item where receipt = ? and id != ?", receipt, id);
	}

	/**
	 * 充值成功，修改用户的相关数据
	 * @param rechargeItem
	 * @throws Exception
	 */
	public void updateUserAndRecharge(RechargeItem rechargeItem) throws Exception {
		if (rechargeItem == null) {
			return;
		}
		Double amount = rechargeItem.getAmount();
		Integer uid = rechargeItem.getUserid();
		if (amount == null || uid == null) {
			return;
		}
		AbsAtom rechare = new RechargeAtom(rechargeItem);
		boolean isRecharge = Db.use(Const.Db.TIO_SITE_MAIN).tx(rechare);
		if (!isRecharge) {
			log.error("充值更新财务失败：uid:{},amount:{},msg:{}", uid, amount, rechare.getMsg());
			throw new RuntimeException(rechare.getMsg());
		}
	}

	/**
	 * 攻击充值修改订单
	 * @param rechargeItem
	 * @throws Exception
	 */
	public void attackRecharge(RechargeItem rechargeItem) throws Exception {
		AbsAtom attackAtom = new AbsAtom() {

			@Override
			public boolean run() throws SQLException {
				boolean update = update(rechargeItem);
				if (!update) {
					log.error("攻击充值-订单数据修改失败，订单id:{}", rechargeItem.getId());
					return false;
				}
				//				Double addCoin = rechargeItem.getAmount() *  ConfService.getInt(Const.ConfMapping.CNY_TO_COIN_TIME_IOS, 70);
				Double addCoin = NumberUtil.mul((double) rechargeItem.getAmount(), (float) MgConfService.getInt(Const.ConfMapping.CNY_TO_COIN_TIME_IOS, 70));

				boolean saveCoin = UserCoinService.me.addAttackcoin(rechargeItem.getUserid(), addCoin);
				if (!saveCoin) {
					log.error("攻击充值-修改财务信息：无数据更新，订单id:{}", rechargeItem.getId());
				}
				return true;
			}
		};
		Db.use(Const.Db.TIO_SITE_MAIN).tx(attackAtom);
	}

	/**
	 * @param args
	 * @author: tanyaowu
	 */
	public static void main(String[] args) {
	}
}
