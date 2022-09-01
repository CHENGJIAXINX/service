/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */package org.tio.sitexxx.service.pay.base;

import java.util.Map;

import org.tio.http.common.HttpRequest;

/**
 * 支付接口
 * @param <PayQuest>
 * @param <Resp>
 * @author xufei
 * 2020年10月27日 上午11:20:10
 * @param <req>
 * @param <Resp>
 */
public interface BasePay<Req extends BasePayReq, Resp extends BasePayResp> {

	/**
	 * @return
	 * @author xufei
	 * 2020年11月3日 下午5:02:35
	 */
	Map<String, Object> getConfParam();
	
	/**
	 * 
	 * 开户
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年10月27日 上午11:22:44
	 */
	Resp openUser(Req PayQuest,Integer uid);
	
	
	/**
	 * 修改开户信息
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年11月12日 下午3:05:22
	 */
	Resp updateUser(Req PayQuest,Integer uid);
	
	/**
	 * 实名认证
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年10月27日 上午11:23:55
	 */
	Resp authRealname(Req PayQuest,Integer uid);
	
	/**
	 * 绑定银行卡
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年10月27日 上午11:26:10
	 */
	Resp bindBankCard(Req PayQuest,Integer uid);
	
	
	/**
	 * 解绑银行卡
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年10月27日 上午11:27:00
	 */
	Resp removeBankCard(Req PayQuest,Integer uid);
	
	
	/**
	 * 获取银行卡列表
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年10月27日 上午11:27:18
	 */
	Resp getBankCards(Req PayQuest,Integer uid);
	
	
	/**
	 * 用户余额
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年10月27日 上午11:15:19
	 */
	Resp getWalletInfo(Req PayQuest,Integer uid);
	
	/**
	 * 钱包明细
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年10月27日 上午11:17:38
	 */
	Resp getCoinItems(Req PayQuest,Integer uid);
	
	/**
	 * 明细信息
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年10月27日 上午11:28:51
	 */
	Resp getCoinItemInfo(Req PayQuest,Integer uid);
	
	/**
	 * 充值
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年10月27日 上午11:17:18
	 */
	Resp recharge(Req PayQuest,Integer uid);
	
	
	/**
	 * 
	 * @param PayQuest
	 * @param uid
	 * @return
	 * @author xufei
	 * 2020年11月15日 下午7:37:00
	 */
	Resp rechargeCallback(HttpRequest request,Integer uid);
	
	
	/**
	 * 充值查询
	 * @param request
	 * @param uid
	 * @return
	 * @author xufei
	 * 2020年11月25日 上午10:42:04
	 */
	Resp rechargeQuery(Req PayQuest,Integer uid);
	
	
	/**
	 * 消费
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年10月27日 上午11:17:38
	 */
	Resp cost(Req PayQuest,Integer uid);
	
	/**
	 * 退款
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年10月27日 上午11:17:38
	 */
	Resp back(Req PayQuest,Integer uid);
	
	/**
	 * 发红包
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年10月27日 上午11:17:38
	 */
	Resp sendRedpacket(Req PayQuest,Integer uid);
	
	/**
	 * @param request
	 * @param uid
	 * @return
	 * @author xufei
	 * 2020年11月18日 下午6:08:30
	 */
	Resp sendRedpacketCallback(HttpRequest request,Integer uid);
	
	/**
	 * 红包查询
	 * @param PayQuest
	 * @param uid
	 * @return
	 * @author xufei
	 * 2020年12月1日 下午1:47:29
	 */
	Resp redpacketQuery(Req PayQuest,Integer uid);
	
	
	/**
	 * 抢红包
	 * @param PayQuest
	 * @param uid
	 * @return
	 * @author xufei
	 * 2020年11月19日 上午10:08:07
	 */
	Resp grabRedpacket(Req PayQuest,Integer uid);
	
	/**
	 * 提现
	 * @param PayQuest
	 * @param uid
	 * @return
	 * @author xufei
	 * 2020年11月16日 下午2:10:00
	 */
	Resp withhold(Req PayQuest,Integer uid);
	
	
	/**
	 * 提现回调
	 * @param request
	 * @param uid
	 * @return
	 * @author xufei
	 * 2020年11月16日 下午2:11:15
	 */
	Resp withholdCallback(HttpRequest request,Integer uid);
	
	/**
	 * 提现查询
	 * @param PayQuest
	 * @param uid
	 * @return
	 * @author xufei
	 * 2020年11月25日 下午2:28:45
	 */
	Resp withholdQuery(Req PayQuest,Integer uid);
	
	/**
	 * 客户端token
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年10月27日 上午11:17:38
	 */
	Resp clientToken(Req PayQuest,Integer uid);
	
	
	/**
	 * 手续费
	 * @param amount
	 * @return
	 * @author xufei
	 * 2020年11月16日 下午2:06:05
	 */
	int commission(int amount);
}
