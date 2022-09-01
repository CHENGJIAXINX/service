/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.service.atom;

import java.sql.SQLException;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.mg.service.model.main.RechargeItem;
import org.tio.mg.service.model.main.UserCoinItem;
import org.tio.mg.service.service.UserCoinService;
import org.tio.mg.service.service.conf.MgConfService;
import org.tio.mg.service.service.recharge.RechargeItemService;
import org.tio.sitexxx.servicecommon.vo.Const;

import cn.hutool.core.util.NumberUtil;

/**
 * 充值回调事务代码
 * 
 */
public class RechargeAtom extends AbsAtom {

	private static Logger log = LoggerFactory.getLogger(RechargeAtom.class);

	private RechargeItem rechargeItem;

	public RechargeAtom(RechargeItem rechargeItem) {
		this.rechargeItem = rechargeItem;
	}

	@Override
	public boolean run() throws SQLException {
		Double amount = rechargeItem.getAmount();
		Integer uid = rechargeItem.getUserid();
		Double addCoin = 0d;
		if (Objects.equals(rechargeItem.getPaytype(), RechargeItem.Paytype.APPLE_APP)) {
			addCoin = new Double(NumberUtil.mul(amount.doubleValue(), MgConfService.getFloat(Const.ConfMapping.CNY_TO_COIN_TIME_IOS, 70f).floatValue()));
		} else {
			addCoin = new Double(NumberUtil.mul(amount.doubleValue(), MgConfService.getFloat(Const.ConfMapping.CNY_TO_COIN_TIME_PC, 100f).floatValue()));
		}
		boolean isupdate = UserCoinService.me.addCoin(uid, addCoin);
		if (!isupdate) {
			this.msg = "更新充值清单异常-充值";
			log.error("更新充值清单异常-充值！uid:{},rechargeId:{}", uid, rechargeItem.getId());
			return false;
		}
		RechargeItemService.me.update(rechargeItem);
		UserCoinItem userCoinItem = new UserCoinItem();
		userCoinItem.setCoin(addCoin);
		userCoinItem.setBizid(rechargeItem.getId());
		userCoinItem.setCoinmode(Const.CoinMode.COIN);
		userCoinItem.setUid(uid);
		userCoinItem.setRemark("充值");
		if (Objects.equals(rechargeItem.getPaytype(), RechargeItem.Paytype.APPLE_APP)) {
			userCoinItem.setAddexp(new Double(NumberUtil.mul(amount.doubleValue(), MgConfService.getFloat(Const.ConfMapping.CNY_TO_COIN_EXP_TIME_IOS, 50f).floatValue())));
		} else {
			userCoinItem.setAddexp(new Double(NumberUtil.mul(amount.doubleValue(), MgConfService.getFloat(Const.ConfMapping.CNY_TO_COIN_EXP_TIME_ST, 50f).floatValue())));
		}
		userCoinItem.setCoinflag(Const.CoinFlag.INCOME);
		userCoinItem.setType(Const.StandardMode.RECHARGE);
		boolean isAdd = userCoinItem.save();
		if (!isAdd) {
			this.msg = "新增用户充值记录失败-充值";
			log.error("新增用户充值记录失败-充值！uid:{},rechargeId:{}", uid, rechargeItem.getId());
			return false;
		}

		return isAdd;
	}

}
