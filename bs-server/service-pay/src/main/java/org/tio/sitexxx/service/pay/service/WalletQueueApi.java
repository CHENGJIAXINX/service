/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.pay.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.im.common.Command;
import org.tio.sitexxx.im.common.ImPacket;
import org.tio.sitexxx.im.common.bs.wx.friend.WxFriendChatNtf;
import org.tio.sitexxx.im.common.bs.wx.group.WxGroupChatNtf;
import org.tio.sitexxx.im.server.Ims;
import org.tio.sitexxx.im.server.handler.wx.WxChatApi;
import org.tio.sitexxx.im.server.handler.wx.WxSynApi;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.WxChatGroupItem;
import org.tio.sitexxx.service.model.main.WxChatUserItem;
import org.tio.sitexxx.service.model.main.WxFriendMsg;
import org.tio.sitexxx.service.model.main.WxGroupMsg;
import org.tio.sitexxx.service.model.main.WxUserCoinItem;
import org.tio.sitexxx.service.model.main.WxUserGrabRedItem;
import org.tio.sitexxx.service.model.main.WxUserRechargeItem;
import org.tio.sitexxx.service.model.main.WxUserSendRedItem;
import org.tio.sitexxx.service.model.main.WxUserWithholdItem;
import org.tio.sitexxx.service.pay.impl.pay5u.Pay5UConst;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.RedpacketCallback5UResp;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.chat.ChatIndexService;
import org.tio.sitexxx.service.service.chat.ChatMsgService;
import org.tio.sitexxx.service.service.chat.ChatService;
import org.tio.sitexxx.service.service.chat.FriendService;
import org.tio.sitexxx.service.service.chat.GroupService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.AppCode;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.PayConst;
import org.tio.sitexxx.servicecommon.vo.wx.SynRecordVo;
import org.tio.sitexxx.servicecommon.vo.wx.WxRedVo;
import org.tio.utils.json.Json;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 钱包队列
 * @author xufei
 * 2020年1月17日 下午2:25:27
 */
public class WalletQueueApi{
	
	private static Logger log = LoggerFactory.getLogger(WalletQueueApi.class);

	public static final WalletQueueApi me = new WalletQueueApi();
	
	/**
	 * 钱包业务
	 */
	private static final int walletIndex = 5;
	
	/**
	 * 群发送后处理队列
	 */
	private static ArrayList<LinkedBlockingQueue<Map<String,Object>>> walletQueue = new ArrayList<LinkedBlockingQueue<Map<String,Object>>>();
	
	/**
	 * 队列初始化
	 * @author xufei
	 * 2020年10月12日 下午3:17:04
	 */
	public static void init() {
		walletQueueInit();
	}
	
	/**
	 * 钱包队列
	 * @author xufei
	 * 2020年11月15日 下午5:34:08
	 */
	public static void walletQueueInit() {
		for(int i = 0; i < walletIndex;i++) {
			final int qindex = i;
			walletQueue.add(new LinkedBlockingQueue<Map<String, Object>>());
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					int error = 0;
					while(true) {
						Map<String, Object> map = null;
						try {
							map = walletQueue.get(qindex).take();
							error = 0;
						} catch (InterruptedException e1) {
							error++;
							log.error("队列获取钱包对象失败，队列index:{}，错误次数：{}",qindex,error,e1);
							if(error >= 5) {
								log.error("队列联系获取钱包对象5次失败，退出循环，队列index:{}",qindex);
								break;
							}
							continue;
						}
						try {
							if(map == null) {
								log.error("钱包对象为空，队列index:{}",qindex);
								continue;
							}
							Object key = map.get(PayConst.ApiClassName.API_MAP_KEY);
							if(key == null) {
								log.error("钱包对象操作类型为空,map:{}",Json.toJson(map));
								continue;
							}
							String className = (String) key;
							switch (className) {
								case PayConst.ApiClassName.WALLET_INFO:
//									log.error("钱包查询业务：map:{}",Json.toJson(map));
									break;
								case PayConst.ApiClassName.RECHARGE_CALLBACK:
									rechargeCallback(map);
									break;
								case PayConst.ApiClassName.RECHARGE_QUERY:
									rechargeQuery(map);
									break;
								case PayConst.ApiClassName.WITHHOLD_CALLBACK:
									withholdCallback(map);
									break;
								case PayConst.ApiClassName.WITHHOLD_QUERY:
									withholdQuery(map);
									break;
								case PayConst.ApiClassName.REDPACKET_CALLBACK:
									sendRedpacketCallback(map);
									break;
								case PayConst.ApiClassName.GRAB_REDPACKET:
									grabRedpacket(map);
									break;
								default:
									log.error("无效钱包操作：className:{}",className);
									break;
							}
						} catch (Exception e) {
							log.error("", e);
						}
					}
					
				}
			}).start();
		}
	}
	
	public WalletQueueApi() {
	}
	
	/**
	 * 钱包进队列
	 * @param walletBiz
	 * @param uid
	 * @author xufei
	 * 2020年11月15日 下午5:23:50
	 */
	public static void joinWalletQueue(Map<String, Object> walletBiz,Integer uid) {
		int queueindex = uid % walletIndex;
		try {
			//此处会阻塞队列，如果是短链接谨慎使用
			walletQueue.get(queueindex).put(walletBiz);
		} catch (InterruptedException e) {
			log.error("", e);
		}
	}
	
	/**
	 * 充值回调
	 * @param map
	 * @throws Exception
	 * @author xufei
	 * 2020年11月25日 下午3:55:17
	 */
	public static void rechargeCallback(Map<String, Object> map) throws Exception {
		WxUserRechargeItem item = WxUserRechargeItem.dao.findFirst("select * from wx_user_recharge_item where serialnumber = ?",map.get("serialNumber"));
		if(item == null) {
			log.error("支付队列回调接口中，发现订单不存在：{}",Json.toJson(map));
			return;
		}
		if("again".equals(MapUtil.getStr(map, "again")) &&  MapUtil.getStr(map, "orderStatus").equals(Pay5UConst.RechargeStatus.INIT)) {
			log.error("支付队列查询补偿回调接口中，发现订单还是初始化：{}",Json.toJson(map));
			return;
		}
		WxUserRechargeItem updateItem = new WxUserRechargeItem();
		updateItem.setStatus(MapUtil.getStr(map, "orderStatus"));
		updateItem.setOrdererrormsg(MapUtil.getStr(map, "orderErrorMessage"));
		updateItem.setBizcompletetime(MapUtil.getStr(map, "completeDateTime"));
		updateItem.setId(item.getId());
		updateItem.setQueuetime(new Date());
		updateItem.setQuerysyn(PayConst.QuerySyn.CALLBACK);
		updateItem.setBizcreattime(MapUtil.getStr(map, "createDateTime"));
		if(MapUtil.getStr(map, "orderStatus").equals(Pay5UConst.RechargeStatus.CANCEL)) {
			updateItem.setCoinsyn(PayConst.CoinSyn.SUCCESS);
			updateItem.setQuerysyn(PayConst.QuerySyn.SUCCESS);
			boolean update = updateItem.update();
			if(!update) {
				log.error("本地修改支付订单状态异常,记录：{}，回调：{}",Json.toJson(item),Json.toJson(map));
			} 
			return;
		}
		//TODO:XUFEI-判断成功，进行查询数据同步处理
		WxUserCoinItem coinItem = coinItemAdd(item.getUid(),Const.CoinFlag.INCOME, item.getAmount(), PayConst.WalletMode.RECHARGE,
				item.getSerialnumber(), updateItem.getStatus(), item.getId(), "充值", updateItem.getBizcreattime(),
				updateItem.getBizcompletetime(), updateItem.getOrdererrormsg());
		if(coinItem != null) {
			if(MapUtil.getStr(map, "orderStatus").equals(Pay5UConst.RechargeStatus.PROCESS)) {
				updateItem.setCoinsyn(PayConst.CoinSyn.INIT);
			} else {
				updateItem.setCoinsyn(PayConst.CoinSyn.SUCCESS);
			}
		}
		boolean update = updateItem.update();
		if(!update) {
			log.error("本地修改支付订单状态异常,记录：{}，回调：{}",Json.toJson(item),Json.toJson(map));
		} 
	}
	
	/**
	 * 充值查询
	 * @param map
	 * @throws Exception
	 * @author xufei
	 * 2020年11月25日 下午3:53:03
	 */
	public static void rechargeQuery(Map<String, Object> map) throws Exception {
		WxUserRechargeItem query = WxUserRechargeItem.toBean(map);
		if(query == null) {
			log.error("充值查询队列接口中，发现订单不存在：{}",Json.toJson(map));
			return;
		}
		if(query.getQuerysyn().equals(PayConst.QuerySyn.NO)) {
			log.error("查询再同步得前面执行了，直接返回：{}",Json.toJson(map));
			return;
		}
		WxUserRechargeItem updateItem = new WxUserRechargeItem();
		updateItem.setId(query.getId());
		updateItem.setStatus(query.getStatus());
		updateItem.setOrdererrormsg(query.getOrdererrormsg());
		updateItem.setBizcompletetime(query.getBizcompletetime());
		if(query.getStatus().equals(Pay5UConst.RechargeStatus.CANCEL)) {
			updateItem.setCoinsyn(PayConst.CoinSyn.SUCCESS);
			updateItem.setQuerysyn(PayConst.QuerySyn.SUCCESS);
			updateItem.update();
			return;
		}
		boolean updateOper = false;
		if(Objects.equals(query.getQuerysyn(), PayConst.QuerySyn.CALLBACK)) {
			updateItem.setQuerysyn(PayConst.QuerySyn.SUCCESS);
			updateItem.setBankcardnumber(query.getBankcardnumber());
			updateItem.setBankcode(query.getBankcode());
			updateItem.setBankname(query.getBankname());
			updateItem.setBankicon(query.getBankicon());
			updateItem.setBizcreattime(query.getBizcreattime());
			updateOper = true;
		}
		if(Objects.equals(PayConst.CoinSyn.NO, query.getCoinsyn())) {
			//TODO:XUFEI-判断成功，进行查询数据同步处理
			WxUserCoinItem coinItem = coinItemAdd(query.getUid(),Const.CoinFlag.INCOME, query.getAmount(), PayConst.WalletMode.RECHARGE, query.getSerialnumber(), query.getStatus(), query.getId(), "充值", query.getBizcreattime(), query.getBizcompletetime(),query.getOrdererrormsg());
			if(coinItem != null) {
				updateOper = true;
				if(Objects.equals(query.getStatus(), Pay5UConst.RechargeStatus.PROCESS)) {
					updateItem.setCoinsyn(PayConst.CoinSyn.INIT);
				} else {
					updateItem.setCoinsyn(PayConst.CoinSyn.SUCCESS);
				}
			}
		} else if(Objects.equals(PayConst.CoinSyn.INIT, query.getCoinsyn()) && !Objects.equals(query.getStatus(), Pay5UConst.RechargeStatus.PROCESS)) {
			WxUserCoinItem coinItem = coinItemUpdate(query.getId(), query.getStatus(), query.getBizcompletetime(),query.getOrdererrormsg());
			if(coinItem != null) {
				updateItem.setCoinsyn(PayConst.CoinSyn.SUCCESS);
				updateOper = true;
			}
		}
		if(updateOper) {
			boolean update = updateItem.update();
			if(!update) {
				log.error("本地修改支付订单查询同步状态异常,修改记录：{}，原始记录：{}",Json.toJson(updateItem),Json.toJson(map));
			} 
		} else {
			log.error("本地充值查询无修改");
		}
		
	}
	
	/**
	 * 提现回调
	 * @param map
	 * @throws Exception
	 * @author xufei
	 * 2020年11月25日 下午3:56:00
	 */
	public static void withholdCallback(Map<String, Object> map) throws Exception {
		WxUserWithholdItem item = WxUserWithholdItem.dao.findFirst("select * from wx_user_withhold_item where serialnumber = ?",map.get("serialNumber"));
		if(item == null) {
			log.error("提现队列回调接口中，发现订单不存在：{}",Json.toJson(map));
			return;
		}
		if("again".equals(MapUtil.getStr(map, "again")) &&  MapUtil.getStr(map, "orderStatus").equals(Pay5UConst.RechargeStatus.INIT)) {
			log.error("提现队列查询补偿回调接口中，发现订单还是初始化：{}",Json.toJson(map));
			return;
		}
		WxUserWithholdItem updateItem = new WxUserWithholdItem();
		updateItem.setStatus(MapUtil.getStr(map, "orderStatus"));
		updateItem.setOrdererrormsg(MapUtil.getStr(map, "orderErrorMessage"));
		updateItem.setBizcompletetime(MapUtil.getStr(map, "completeDateTime"));
		updateItem.setId(item.getId());
		updateItem.setQuerysyn(PayConst.QuerySyn.CALLBACK);
		updateItem.setQueuetime(new Date());
		updateItem.setBizcreattime(MapUtil.getStr(map, "createDateTime"));
		if(MapUtil.getStr(map, "orderStatus").equals(Pay5UConst.WithholdStatus.CANCEL)) {
			updateItem.setCoinsyn(PayConst.CoinSyn.SUCCESS);
			updateItem.setQuerysyn(PayConst.QuerySyn.SUCCESS);
			boolean update = updateItem.update();
			if(!update) {
				log.error("本地修改提现订单状态异常,记录：{}，回调：{}",Json.toJson(updateItem),Json.toJson(map));
			} 
			return;
		}
		//TODO:XUFEI-判断成功，进行查询数据同步处理
		WxUserCoinItem coinItem = coinItemAdd(item.getUid(),Const.CoinFlag.PAY, item.getAmount(), PayConst.WalletMode.WIHTHOLD,
				item.getSerialnumber(), updateItem.getStatus(), item.getId(), "提现", updateItem.getBizcreattime(),
				updateItem.getBizcompletetime(), updateItem.getOrdererrormsg());
		if(coinItem != null) {
			if(MapUtil.getStr(map, "orderStatus").equals(Pay5UConst.WithholdStatus.PROCESS)) {
				updateItem.setCoinsyn(PayConst.CoinSyn.INIT);
			} else {
				updateItem.setCoinsyn(PayConst.CoinSyn.SUCCESS);
			}
		}
		boolean update = updateItem.update();
		if(!update) {
			log.error("本地修改提现订单状态异常,记录：{}，回调：{}",Json.toJson(updateItem),Json.toJson(map));
		} 
	}
	
	
	/**
	 * 提现查询
	 * @param map
	 * @throws Exception
	 * @author xufei
	 * 2020年11月25日 下午3:56:06
	 */
	public static void withholdQuery(Map<String, Object> map) throws Exception {
		WxUserWithholdItem query = WxUserWithholdItem.toBean(map);
		if(query == null) {
			log.error("提现查询队列接口中，发现订单不存在：{}",Json.toJson(map));
			return;
		}
		WxUserWithholdItem updateItem = new WxUserWithholdItem();
		if(query.getQuerysyn().equals(PayConst.QuerySyn.NO)) {
			log.error("查询再同步得前面执行了，直接返回：{}",Json.toJson(map));
			//查询简单处理一下银行信息
			updateItem.setId(query.getId());
			updateItem.setBankcardnumber(query.getBankcardnumber());
			updateItem.setBankcode(query.getBankcode());
			updateItem.setBankname(query.getBankname());
			updateItem.setBankicon(query.getBankicon());
			boolean update = updateItem.update();
			if(!update) {
				log.error("本地修改提现订单查询同步状态异常,修改记录：{}，原始记录：{}",Json.toJson(updateItem),Json.toJson(map));
			} 
			return;
		}
		updateItem.setId(query.getId());
		updateItem.setStatus(query.getStatus());
		updateItem.setOrdererrormsg(query.getOrdererrormsg());
		updateItem.setBizcompletetime(query.getBizcompletetime());
		if(query.getStatus().equals(Pay5UConst.WithholdStatus.CANCEL)) {
			updateItem.setCoinsyn(PayConst.CoinSyn.SUCCESS);
			updateItem.setQuerysyn(PayConst.QuerySyn.SUCCESS);
			updateItem.update();
			return;
		}
		boolean updateOper = false;
		if(Objects.equals(query.getQuerysyn(), PayConst.QuerySyn.CALLBACK)) {
			updateItem.setQuerysyn(PayConst.QuerySyn.SUCCESS);
			updateItem.setBankcardnumber(query.getBankcardnumber());
			updateItem.setBankcode(query.getBankcode());
			updateItem.setBankname(query.getBankname());
			updateItem.setBankicon(query.getBankicon());
			updateItem.setBizcreattime(query.getBizcreattime());
			updateOper = true;
		}
		if(Objects.equals(PayConst.CoinSyn.NO, query.getCoinsyn())) {
			//TODO:XUFEI-判断成功，进行查询数据同步处理
			WxUserCoinItem coinItem = coinItemAdd(query.getUid(),Const.CoinFlag.PAY,query.getAmount(), PayConst.WalletMode.WIHTHOLD, query.getSerialnumber(), query.getStatus(), query.getId(), "提现", query.getBizcreattime(), query.getBizcompletetime(),query.getOrdererrormsg());
			if(coinItem != null) {
				updateOper = true;
				if(Objects.equals(query.getStatus(), Pay5UConst.RechargeStatus.PROCESS)) {
					updateItem.setCoinsyn(PayConst.CoinSyn.INIT);
				} else {
					updateItem.setCoinsyn(PayConst.CoinSyn.SUCCESS);
				}
			}
		} else if(Objects.equals(PayConst.CoinSyn.INIT, query.getCoinsyn()) && !Objects.equals(query.getStatus(), Pay5UConst.RechargeStatus.PROCESS)) {
			WxUserCoinItem coinItem = coinItemUpdate(query.getId(), query.getStatus(), query.getBizcompletetime(),query.getOrdererrormsg());
			if(coinItem != null) {
				updateItem.setCoinsyn(PayConst.CoinSyn.SUCCESS);
				updateOper = true;
			}
		}
		if(updateOper) {
			boolean update = updateItem.update();
			if(!update) {
				log.error("本地修改提现订单查询同步状态异常,修改记录：{}，原始记录：{}",Json.toJson(updateItem),Json.toJson(map));
			} 
		} else {
			log.error("本地提现查询无修改");
		}
	}
	
	
	/**
	 * 发送红包回调业务
	 * @param map
	 * @throws Exception
	 * @author xufei
	 * 2020年11月20日 下午5:34:45
	 */
	private static void sendRedpacketCallback(Map<String, Object> map) throws Exception {
		RedpacketCallback5UResp resp = RedpacketCallback5UResp.toBean(map);
		if(resp == null || StrUtil.isBlank(resp.getSerialNumber())) {
			log.error("发红包队列回调接口中，发现响应转化失败,resp:{}",Json.toJson(resp));
			return;
		}
		if("again".equals(MapUtil.getStr(map, "again")) && resp.getOrderStatus().equals(Pay5UConst.RechargeStatus.INIT)) {
			log.error("发红包查询补偿回调接口中，发现订单还是初始化：{}",Json.toJson(map));
			return;
		}
		//查询预下单是否存在
		WxUserSendRedItem redItem = WxUserSendRedItem.dao.findFirst("select * from wx_user_send_red_item where serialnumber = ?",resp.getSerialNumber());
		if(redItem == null) {
			log.error("发红包队列回调接口中，发现订单不存在：{}",Json.toJson(resp));
			return;
		}
		WxUserSendRedItem redItemupdate = new WxUserSendRedItem();
		//本地存储错误标识
		boolean localerror = false;
		Byte chatmode = redItem.getChatmode();
		Long bizid = redItem.getChatbizid();
		Integer uid = redItem.getUid();
		Ret checkRet = checkChat(chatmode, uid, bizid);
		Long chatlinkid  = null;
		String checkMsg = RetUtils.getOkTData(checkRet, "localmsg");
		if(StrUtil.isNotBlank(checkMsg)) {
			redItemupdate.setLocalerrormsg(checkMsg);
			localerror = true;
		} else {
			chatlinkid = RetUtils.getOkTData(checkRet, "chatlinkid");
		}
		User senduser = UserService.ME.getById(redItem.getUid());
		if(!localerror) {
			//判断否激活
			if(chatlinkid == null) {
				Ret ret = actChat(chatmode, uid, bizid, senduser);
				String localMsg = RetUtils.getOkTData(ret, "localmsg");
				if(StrUtil.isNotBlank(localMsg)) {
					redItemupdate.setLocalerrormsg("localMsg");
					localerror = true;
				} else {
					chatlinkid = RetUtils.getOkTData(ret, "chatlinkid");
				}
			}
		}
		boolean sendmsg = false;
		String text = "";
		Byte contenttype = Const.ContentType.REDPACKET;
		Byte sysflag = Const.YesOrNo.NO;
		//状态处理
		Ret statusRet = sendRedpacketStatusDeal(redItem, redItemupdate, resp);
		sendmsg = RetUtils.getOkTData(statusRet,"sendmsg");
		if(sendmsg) {
			text = RetUtils.getOkTData(statusRet,"text");
			contenttype = RetUtils.getOkTData(statusRet,"contenttype");
			sysflag = RetUtils.getOkTData(statusRet,"sysflag");
		}
		redItemupdate.setStatus(resp.getOrderStatus());
		if(sendmsg && !localerror) {
			//消息发送
			localerror  = sendRedpacketNtf(text, contenttype, sysflag, senduser, chatlinkid, redItem, redItemupdate);
		}
		//余额支付进入钱包明细
		if(resp.getPaymentType() != null && resp.getPaymentType().equals(Pay5UConst.PaymentType.BANK_CRAD)) {
			redItemupdate.setCoinsyn(PayConst.CoinSyn.SUCCESS);
		} else {
			if(Objects.equals(redItem.getCoinsyn(), PayConst.CoinSyn.NO) && !resp.getOrderStatus().equals(Pay5UConst.RedPacketStatus.CANCEL)) {
				String coinStatus = Pay5UConst.Status.SUCCESS;
				if(resp.getOrderStatus().equals(Pay5UConst.RedPacketStatus.FAIL)) {
					coinStatus= Pay5UConst.Status.FAIL;
				}
				WxUserCoinItem userCoinItem = coinItemAdd(uid, Const.CoinFlag.PAY, redItem.getAmount(), PayConst.WalletMode.REDPACKET, redItem.getSerialnumber(), coinStatus, redItem.getId(), "发红包", resp.getDebitDateTime(), resp.getCompleteDateTime(), resp.getOrderErrorMessage());
				if(userCoinItem != null) {
					redItemupdate.setCoinsyn(PayConst.CoinSyn.SUCCESS);
				}
			}
		}
		redItemupdate.setId(redItem.getId());
		boolean redItemRet = redItemupdate.update();
		if(!redItemRet) {
			log.error("本地修改红包订单状态异常,记录：{}，回调：{}",Json.toJson(redItem),Json.toJson(resp));
		}
	}
	
	/**
	 * @param map
	 * @throws Exception
	 * @author xufei
	 * 2020年11月22日 下午9:44:18
	 */
	public static void grabRedpacket(Map<String, Object> map) throws Exception {
		WxUserGrabRedItem grabRedItem = WxUserGrabRedItem.toBean(map);
		if(grabRedItem == null) {
			log.error("抢红包队列接口中，发现订单不存在：{}",Json.toJson(map));
			return;
		}
		//本地存储错误标识
		boolean localerror = false;
		Byte chatmode = grabRedItem.getChatmode();
		Long bizid = grabRedItem.getChatbizid();
		Integer uid = grabRedItem.getUid();
		Integer senduid = grabRedItem.getSenduid();
		WxUserGrabRedItem grabRedItemUpdate = new WxUserGrabRedItem();
		Long chatlinkid  = null;
		Long tochatlinkid = null;
		Ret checkRet = checkChat(chatmode, uid, bizid);
		//检查会话是否有效
		String checkMsg = RetUtils.getOkTData(checkRet, "localmsg");
		if(StrUtil.isNotBlank(checkMsg)) {
			grabRedItemUpdate.setLocalerrormsg(checkMsg);
			localerror = true;
		} else {
			chatlinkid = RetUtils.getOkTData(checkRet, "chatlinkid");
			tochatlinkid = RetUtils.getOkTData(checkRet, "tochatlinkid");
		}
		
		User user = UserService.ME.getById(uid);
		User senduser = UserService.ME.getById(senduid);
		if(!localerror) {
			//判断自己否激活
			if(chatlinkid == null) {
				Ret ret = actChat(chatmode, uid, bizid, user);
				String localMsg = RetUtils.getOkTData(ret, "localmsg");
				if(StrUtil.isNotBlank(localMsg)) {
					grabRedItemUpdate.setLocalerrormsg("localMsg");
					localerror = true;
				} else {
					chatlinkid = RetUtils.getOkTData(ret, "chatlinkid");
				}
			}
			//判断发送方是否激活
			if(tochatlinkid == null) {
				long tochatbizid = bizid;
				if(Objects.equals(chatmode, Const.ChatMode.P2P)) {
					tochatbizid = new Long(uid);
				}
				Ret ret = actChat(chatmode, senduid, tochatbizid, senduser);
				String localMsg = RetUtils.getOkTData(ret, "localmsg");
				if(StrUtil.isNotBlank(localMsg)) {
					grabRedItemUpdate.setLocalerrormsg("localMsg");
					localerror = true;
				} else {
					tochatlinkid = RetUtils.getOkTData(ret, "chatlinkid");
				}
			}
		}
		//成功发送推送信息
		if(!localerror && grabRedItem.getStatus().equals(Pay5UConst.Status.SUCCESS)) {
			localerror = grabRedpacketNtf(chatlinkid, tochatlinkid, user, senduser, grabRedItem, grabRedItemUpdate);
		}
		grabRedItemUpdate.setQueuetime(new Date());
		grabRedItemUpdate.setId(grabRedItem.getId());
		//钱包明细处理
		if(Objects.equals(grabRedItem.getCoinsyn(), PayConst.CoinSyn.NO)) {
			WxUserCoinItem userCoinItem = coinItemAdd(uid, Const.CoinFlag.INCOME, grabRedItem.getAmount(), PayConst.WalletMode.REDPACKET, grabRedItem.getSerialnumber(), grabRedItem.getStatus(), grabRedItem.getId(), "收红包", grabRedItem.getBizcompletetime(), grabRedItem.getBizcompletetime(), grabRedItem.getOrdererrormsg());
			if(userCoinItem != null) {
				grabRedItemUpdate.setCoinsyn(PayConst.CoinSyn.SUCCESS);
			}
		} else {
			WxUserCoinItem userCoinItem = coinItemUpdate(grabRedItem.getId(), grabRedItem.getStatus(), grabRedItem.getBizcompletetime(), grabRedItem.getOrdererrormsg());
			if(userCoinItem != null) {
				grabRedItemUpdate.setCoinsyn(PayConst.CoinSyn.SUCCESS);
			}
		}
		boolean redItemRet = grabRedItemUpdate.update();
		if(!redItemRet) {
			log.error("本地修改抢红包订单状态异常,记录：{}，回调：{}",Json.toJson(grabRedItem),Json.toJson(map));
		}
		//TODO:XUFEI-本地钱包逻辑处理
	}
	
	
	/**
	 * @param uid
	 * @param amount
	 * @param mode
	 * @param serialnumber
	 * @param orderstatus
	 * @param bizid
	 * @param bizstr
	 * @param createtime
	 * @param completetime
	 * @author xufei
	 * 2020年11月26日 上午11:28:02
	 */
	public static WxUserCoinItem coinItemAdd(Integer uid,Byte coinflag,String amount,Byte mode,String serialnumber,String orderstatus,Integer bizid,String bizstr,String createtime,String completetime,String error) {
		WxUserCoinItem coinItem = new WxUserCoinItem();
		try {
			coinItem.setUid(uid);
			coinItem.setMode(mode);
			coinItem.setCoinflag(coinflag);
			coinItem.setAmount(Integer.parseInt(amount));
			coinItem.setBizstr(bizstr);
			coinItem.setSerialnumber(serialnumber);
			coinItem.setBizid(bizid);
			if(StrUtil.isNotBlank(createtime)) {
				coinItem.setBizcreattime(createtime);
			}
			if(StrUtil.isNotBlank(completetime)) {
				coinItem.setBizcompletetime(completetime);
			}
			if(Objects.equals(orderstatus, Pay5UConst.RedPacketStatus.SEND)) {
				coinItem.setOrderstatus(Pay5UConst.RedPacketStatus.SUCCESS);
			} else {
				coinItem.setOrderstatus(orderstatus);
			}
			if(Objects.equals(coinItem.getOrderstatus(), Pay5UConst.Status.SUCCESS)) {
				coinItem.setStatus(Const.Status.NORMAL);
			}
			if(StrUtil.isNotBlank(error)) {
				coinItem.setRemark(error);
			}
			coinItem.save();
		} catch (Exception e) {
			log.error("", e);
			log.error("保存钱包明细异常：{}", Json.toJson(coinItem));
			coinItem = null;
		}
		
		return coinItem;
	}
	
	/**
	 * @param uid
	 * @param amount
	 * @param mode
	 * @param serialnumber
	 * @param orderstatus
	 * @param bizid
	 * @param bizstr
	 * @param createtime
	 * @param completetime
	 * @return
	 * @author xufei
	 * 2020年11月26日 下午1:56:37
	 */
	public static WxUserCoinItem coinItemAdd(Integer uid,Byte coinflag,Integer amount,Byte mode,String serialnumber,String orderstatus,Integer bizid,String bizstr,String createtime,String completetime,String error) {
		return coinItemAdd(uid, coinflag,amount + "", mode, serialnumber, orderstatus, bizid, bizstr, createtime, completetime,error);
	}
	
	
	/**
	 * @param id
	 * @param orderstatus
	 * @param completetime
	 * @return
	 * @author xufei
	 * 2020年11月26日 上午11:32:15
	 */
	public static WxUserCoinItem coinItemUpdate(Integer id,String orderstatus,String completetime,String error) {
		WxUserCoinItem coinItem = new WxUserCoinItem();
		try {
			coinItem.setId(id);
			if(StrUtil.isNotBlank(completetime)) {
				coinItem.setBizcompletetime(completetime);
			}
			if(StrUtil.isNotBlank(orderstatus)) {
				coinItem.setOrderstatus(orderstatus);
				if(Objects.equals(orderstatus, Pay5UConst.Status.SUCCESS)) {
					coinItem.setStatus(Const.Status.NORMAL);
				}
			}
			if(StrUtil.isNotBlank(error)) {
				coinItem.setRemark(error);
			}
			coinItem.update();
		} catch (Exception e) {
			log.error("修改钱包明细失败:{}",coinItem);
			log.error("",e);
			coinItem = null;
		}
		
		return coinItem;
	}
	
	
	/**
	 * @param chatlinkid
	 * @param chatmode
	 * @param uid
	 * @param bizid
	 * @param user
	 * @return
	 * @author xufei
	 * 2020年11月27日 上午11:02:03
	 */
	@SuppressWarnings("deprecation")
	private static Ret actChat(Byte chatmode,Integer uid,Long bizid,User user) {
		String localmsg = "";
		Long chatlinkid = null;
		if(Objects.equals(chatmode, Const.ChatMode.P2P)) {
			Ret ret = ChatService.me.actFdChatItems(uid, bizid.intValue());
			if(ret.isFail()) {
				log.error("自己的会话激活失败-私聊，uid:{},touid:{}",uid,bizid.intValue());
				localmsg = "自己的会话激活失败-私聊";
			} else {
				chatlinkid = RetUtils.getOkTData(ret,"chatlinkid");
				if(WxSynApi.isSynVersion()) {
					WxSynApi.synChatSession(uid, RetUtils.getOkTData(ret, "chat"), SynRecordVo.SynType.ADD);
				} else {
					WxChatApi.userActOper(uid,RetUtils.getOkTData(ret, "chat"));
				}
			}
		} else {
			WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(uid, bizid);
			if(groupItem.getChatlinkid() == null) {
				Ret actRet = ChatService.me.actGroupChatItems(bizid,user.getId());
				if(actRet.isFail()) {
					log.error("自己的会话激活失败-群聊，uid:{},touid:{}",uid,bizid);
					localmsg = "自己的会话激活失败-群聊";
				} else {
					if(WxSynApi.isSynVersion()) {
						WxSynApi.synChatSession(uid, RetUtils.getOkTData(actRet, "chat"), SynRecordVo.SynType.ADD);
					} else {
						WxChatApi.userActOper(uid,RetUtils.getOkTData(actRet, "chat"));
					}
				}
				chatlinkid = RetUtils.getOkTData(actRet,"chatlinkid");
			} else {
				chatlinkid = groupItem.getChatlinkid();
			}
		}
		return Ret.ok().set("chatlinkid",chatlinkid).set("localmsg",localmsg);
	}
	
	/**
	 * @param mid
	 * @param chatmode
	 * @param redStatus
	 * @author xufei
	 * 2020年11月27日 上午11:09:04
	 */
	private static void updateRedMsg(Long mid,Byte chatmode,String redStatus) {
		if(Objects.equals(chatmode, Const.ChatMode.P2P)) {
			WxFriendMsg old = WxFriendMsg.dao.findById(mid);
			if(old != null) {
				WxFriendMsg msg = new WxFriendMsg();
				WxRedVo redVo = Json.toBean(old.getText(), WxRedVo.class);
				if(redVo != null) {
					redVo.setStatus(redStatus);
					msg.setId(mid);
					msg.setText(Json.toJson(redVo));
					msg.update();
				}
			}
			
		} else {
			WxGroupMsg old = WxGroupMsg.dao.findById(mid);
			if(old != null) {
				WxGroupMsg msg = new WxGroupMsg();
				WxRedVo redVo = Json.toBean(old.getText(), WxRedVo.class);
				if(redVo != null) {
					redVo.setStatus(redStatus);
					msg.setId(mid);
					msg.setText(Json.toJson(redVo));
					msg.update();
				}
			}
		}
	}
	
	/**
	 * @param chatmode
	 * @param uid
	 * @param bizid
	 * @return
	 * @author xufei
	 * 2020年11月27日 上午11:14:11
	 */
	private static Ret checkChat(Byte chatmode,Integer uid,Long bizid) {
		String localmsg = "";
		WxChatUserItem userItem = ChatIndexService.chatUserIndex(uid, bizid, chatmode);
		//判断是否会话有效
		if(Objects.equals(chatmode, Const.ChatMode.P2P)) {
			if(!ChatService.existTwoFriend(userItem)) {
				log.error("相互不是好友，userindex:{}",userItem);
				localmsg = "相互不是好友";
			}
		} else {
			WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(uid, bizid);
			if(!ChatService.groupExistChat(groupItem)) {
				log.error("不是群成员，userindex:{}",userItem);
				localmsg = "不是群成员";
			}
		}
		return Ret.ok().set("chatlinkid",userItem.getChatlinkid()).set("tochatlinkid",userItem.getTochatlinkid()).set("localmsg",localmsg);
	}
	
	
	/******************************begin-红包私有逻辑******************************************************/
	
	/**
	 * 红包状态处理
	 * @param redItem
	 * @param redItemupdate
	 * @param resp
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月27日 上午11:44:02
	 */
	private static Ret sendRedpacketStatusDeal(WxUserSendRedItem redItem,WxUserSendRedItem redItemupdate,RedpacketCallback5UResp resp) throws Exception {
		boolean sendmsg = false;
		String text = "";
		Byte contenttype = Const.ContentType.REDPACKET;
		Byte sysflag = Const.YesOrNo.NO;
		Long mid = redItem.getMgsid();
		Byte chatmode = redItem.getChatmode();
		boolean coin = false;
		switch (resp.getOrderStatus()) {
		case Pay5UConst.RedPacketStatus.SUCCESS:
			redItemupdate.setBizcompletetime(resp.getCompleteDateTime());
			text = "你的红包已被领完";
			sysflag = Const.YesOrNo.YES;
			contenttype = Const.ContentType.TEXT;
			if(Objects.equals(chatmode, Const.ChatMode.P2P)) {
				sendmsg = false;
			} else {
				sendmsg = true;
			}
			if(mid != null) {
				updateRedMsg(mid, chatmode, Pay5UConst.RedPacketStatus.SUCCESS);
			} 
			redItemupdate.setQuerysyn(PayConst.QuerySyn.SUCCESS);
			break;
		case Pay5UConst.RedPacketStatus.SEND:
			redItemupdate.setDebitdatetime(resp.getDebitDateTime());
			redItemupdate.setPaymenttype(resp.getPaymentType());
			text = redItem.getRemark();
			sendmsg = true;
			redItemupdate.setQuerysyn(PayConst.QuerySyn.CALLBACK);
			break;
		case Pay5UConst.RedPacketStatus.TIMEOUT:
			String refundAmount = resp.getRefundAmount();
			if(StrUtil.isNotBlank(refundAmount)) {
				redItemupdate.setRefundamount(Integer.parseInt(refundAmount));
			}
			String refundCount = resp.getRefundAmount();
			if(StrUtil.isNotBlank(refundAmount)) {
				redItemupdate.setRefundcount(Short.parseShort(refundCount));
			}
			redItemupdate.setBizcompletetime(resp.getCompleteDateTime());
			redItemupdate.setRefundtype(resp.getRefundType());
			text = "你的红包已超时";
			sysflag = Const.YesOrNo.YES;
			contenttype = Const.ContentType.TEXT;
			if(mid != null) {
				updateRedMsg(mid, chatmode, Pay5UConst.RedPacketStatus.TIMEOUT);
			}
			//超时退回
			if(redItemupdate.getRefundamount() != null && redItemupdate.getRefundamount() > 0) {
				WxUserCoinItem userCoinItem = coinItemAdd(redItem.getUid(), Const.CoinFlag.INCOME, redItemupdate.getRefundamount(), PayConst.WalletMode.REDPACKET, redItem.getSerialnumber(), Pay5UConst.RedPacketStatus.SUCCESS, redItem.getId(), "红包退回", resp.getCompleteDateTime(), resp.getCompleteDateTime(), resp.getOrderErrorMessage());
				if(userCoinItem != null) {
					redItemupdate.setQuerysyn(PayConst.QuerySyn.SUCCESS);
				}
			} else {
				redItemupdate.setQuerysyn(PayConst.QuerySyn.SUCCESS);
			}
			break;
		case Pay5UConst.RedPacketStatus.CANCEL:
			coin = true;
			sysflag = Const.YesOrNo.YES;
			contenttype = Const.ContentType.TEXT;
			text = "你的红包已取消";
			redItemupdate.setQuerysyn(PayConst.QuerySyn.SUCCESS);
			redItemupdate.setCoinsyn(PayConst.CoinSyn.SUCCESS);
			break;
		case Pay5UConst.RedPacketStatus.FAIL:
			coin = true;
			sysflag = Const.YesOrNo.YES;
			contenttype = Const.ContentType.TEXT;
			text = "你的红包发送失败";
			redItemupdate.setQuerysyn(PayConst.QuerySyn.SUCCESS);
			break;
		default:
			coin = true;
			log.error("红包未知状态：{}",resp.getOrderStatus());
			sysflag = Const.YesOrNo.YES;
			contenttype = Const.ContentType.TEXT;
			text = "你的红包未知状态";
			redItemupdate.setQuerysyn(PayConst.QuerySyn.SUCCESS);
			break;
		}
		//接受字段处理
		String receivedCount = resp.getReceivedCount();
		if(StrUtil.isNotBlank(receivedCount)) {
			redItemupdate.setReceivedcount(Short.parseShort(receivedCount));
		}
		String receivedAmount = resp.getReceivedAmount();
		if(StrUtil.isNotBlank(receivedAmount)) {
			redItemupdate.setReceivedamount(Integer.parseInt(receivedAmount));
		}
		redItemupdate.setReceivewalletid(resp.getReceiveWalletId());
		redItemupdate.setOrdererrormsg(resp.getOrderErrorMessage());
		return Ret.ok().set("text",text).set("coin",coin).set("sendmsg",sendmsg).set("contenttype",contenttype).set("sysflag",sysflag);
	}
	
	/**
	 * 红包消息发送
	 * @param text
	 * @param contenttype
	 * @param sysflag
	 * @param redItem
	 * @param redItemupdate
	 * @param senduser
	 * @param chatlinkid
	 * @throws Exception
	 * @author xufei
	 * 2020年11月27日 上午11:24:32
	 */
	private static boolean sendRedpacketNtf(String text,Byte contenttype,Byte sysflag,User senduser,Long chatlinkid,WxUserSendRedItem redItem,WxUserSendRedItem redItemupdate) throws Exception {
		if(redItem.getMgsid() != null) {
			log.error("补偿查询红包回调，不需要进行发送消息:{}",redItem);
			return true;
		}
		if(StrUtil.isBlank(text)) {
			text = "没有配置remark";
		}
		WxChatUserItem userItem = ChatIndexService.chatUserIndex(chatlinkid);
		Byte chatmode = redItem.getChatmode();
		Long bizid = redItem.getChatbizid();
		Integer uid = redItem.getUid();
		if(Objects.equals(chatmode, Const.ChatMode.P2P)) {
			if(Objects.equals(sysflag, Const.YesOrNo.YES)) {//系统消息只发给发送人
				WxFriendMsg sendMsg = FriendService.me.addChatMsg(redItem.getDevice(), "", redItem.getIp(), uid, text, uid,null,null,redItem.getAppversion());
				if(sendMsg == null) {
					redItemupdate.setLocalerrormsg("发送私聊消息失败");
					return false;
				}
				WxFriendChatNtf sendNtf = WxFriendChatNtf.from(sendMsg);
				ImPacket sendPacket = new ImPacket(Command.WxFriendChatNtf, Json.toJson(sendNtf));
				sendNtf.setRedflag(Const.YesOrNo.YES);
				sendNtf.setChatlinkid(chatlinkid);
				Ims.sendToUser(uid, sendPacket);
				Ret ret = ChatMsgService.me.afterSendFriendChatMsg(sendMsg,senduser, userItem.getChatlinkmetaid(), 
						null, null, null);
				if(ret.isFail()) {
					redItemupdate.setLocalerrormsg("更改消息会话错误");
					return false;
				}
				clearFriendCache(uid, bizid.intValue(), chatlinkid, null);
			} else {
				WxRedVo redVo = new WxRedVo();
				redVo.setSerialnumber(redItem.getSerialnumber());
				redVo.setText(text);
				redVo.setStatus(redItemupdate.getStatus());
				redVo.setMode(redItem.getMode());
				text = Json.toJson(redVo);
				Ret ret = WxChatApi.sendFdMsgFroSendRed(redItem.getDevice(),redItem.getIp(),text, contenttype, uid, bizid.intValue(), sysflag,redItem.getSerialnumber(),redItem.getAppversion());
				if(ret.isFail()) {
					WxChatApi.sendFriendErrorMsg(uid,uid, bizid.intValue(), chatlinkid, RetUtils.getIntCode(ret), RetUtils.getRetMsg(ret));
					redItemupdate.setLocalerrormsg("发送私聊消息失败");
					return false;
				} else {
					WxFriendMsg msg = RetUtils.getOkTData(ret);
					redItemupdate.setMgsid(msg.getId());
				}
			}
			
		} else {
			if(Objects.equals(sysflag, Const.YesOrNo.YES)) {//系统消息只发给发送人
				WxGroupMsg sendMsg = GroupService.me.addMsg(redItem.getDevice(), "", text, uid, redItem.getIp(), bizid,contenttype , sysflag, uid, null, null,null,"",null,null,redItem.getAppversion());
				if(sendMsg == null) {
					redItemupdate.setLocalerrormsg("红包发送方消息保存失败");
					return false;
				}
				WxGroupChatNtf sendNtf = WxGroupChatNtf.from(sendMsg,null);
				sendNtf.setRedflag(Const.YesOrNo.YES);
				sendNtf.setChatlinkid(-bizid);
				ImPacket sendPacket = new ImPacket(Command.WxGroupChatNtf, Json.toJson(sendNtf));
				Ims.sendToUser(uid, sendPacket);
				ChatMsgService.me.afterSendGroupById(sendMsg, null,userItem.getChatlinkmetaid(),null);
				clearGroupCache(uid, null, bizid);
			} else {
				WxRedVo redVo = new WxRedVo();
				redVo.setSerialnumber(redItem.getSerialnumber());
				redVo.setText(text);
				redVo.setStatus(redItemupdate.getStatus());
				redVo.setMode(redItem.getMode());
				text = Json.toJson(redVo);
				Ret ret = WxChatApi.sendGroupMsgEachForSendRed(redItem.getDevice(),redItem.getIp(),text , contenttype, uid, bizid,null,null,redItem.getSerialnumber(),redItem.getAppversion());
				if(ret.isFail()) {
					WxChatApi.sendFriendErrorMsg(uid,uid, bizid.intValue(), -bizid, AppCode.GroupErrorCode.SYS_ERROR, RetUtils.getRetMsg(ret));
					redItemupdate.setLocalerrormsg("发送群聊消息失败");
					return false;
				} else {
					WxGroupMsg msg = RetUtils.getOkTData(ret);
					redItemupdate.setMgsid(msg.getId());
				}
			}
		}
		return true;
	}
	
	
	/**
	 * 发送红包消息
	 * @param chatlinkid
	 * @param tochatlinkid
	 * @param user
	 * @param senduser
	 * @param grabRedItem
	 * @param grabRedItemUpdate
	 * @throws Exception
	 * @author xufei
	 * 2020年11月27日 下午4:08:30
	 */
	private static boolean grabRedpacketNtf(Long chatlinkid,Long tochatlinkid,User user,User senduser,WxUserGrabRedItem grabRedItem,WxUserGrabRedItem grabRedItemUpdate) throws Exception {
		WxChatUserItem userItem = ChatIndexService.chatUserIndex(chatlinkid);
		WxChatUserItem touserUserItem = ChatIndexService.chatUserIndex(tochatlinkid);
		Byte chatmode = grabRedItem.getChatmode();
		Long bizid = grabRedItem.getChatbizid();
		Integer uid = grabRedItem.getUid();
		Integer senduid = grabRedItem.getSenduid();
		if(Objects.equals(chatmode, Const.ChatMode.P2P)) {
			if(Objects.equals(senduid, uid)) {
				WxFriendMsg grabMsg = FriendService.me.addChatMsg(grabRedItem.getDevice(), "", grabRedItem.getIp(), uid, "你领取了 你 的红包", senduid,null,null,grabRedItem.getAppversion());
				if(grabMsg == null) {
					grabRedItemUpdate.setLocalerrormsg("接受方消息保存失败");
					return false;
				}
				WxFriendChatNtf grabNtf = WxFriendChatNtf.from(grabMsg);
				grabNtf.setRedflag(Const.YesOrNo.YES);
				grabNtf.setChatlinkid(chatlinkid);
				ImPacket grabPacket = new ImPacket(Command.WxFriendChatNtf, Json.toJson(grabNtf));
				Ims.sendToUser(uid, grabPacket); 
				Ret ret = ChatMsgService.me.afterSendFriendChatMsg(grabMsg,user, userItem.getChatlinkmetaid(), 
						null, null, null );
				if(ret.isFail()) {
					grabRedItemUpdate.setLocalerrormsg("更改消息会话错误-抢红包");
					return false;
				}
				clearFriendCache(uid, bizid.intValue(), chatlinkid, null);
			} else {
				WxFriendMsg grabMsg = FriendService.me.addChatMsg(grabRedItem.getDevice(), "", grabRedItem.getIp(), uid, "你领取了 " + senduser.getNick() + " 的红包", senduid,null,null,grabRedItem.getAppversion());
				if(grabMsg == null) {
					grabRedItemUpdate.setLocalerrormsg("接受方消息保存失败");
					return false;
				}
				WxFriendChatNtf grabNtf = WxFriendChatNtf.from(grabMsg);
				grabNtf.setRedflag(Const.YesOrNo.YES);
				grabNtf.setChatlinkid(chatlinkid);
				ImPacket grabPacket = new ImPacket(Command.WxFriendChatNtf, Json.toJson(grabNtf));
				Ims.sendToUser(uid, grabPacket); 
				Ret ret = ChatMsgService.me.afterSendFriendChatMsg(grabMsg,user, userItem.getChatlinkmetaid(), 
						null, null, null );
				if(ret.isFail()) {
					grabRedItemUpdate.setLocalerrormsg("更改消息会话错误-抢红包");
					return false;
				}
				WxFriendMsg sendMsg = FriendService.me.addChatMsg(grabRedItem.getDevice(), "", grabRedItem.getIp(), senduid, user.getNick() + " 领取了你的红包", uid,null,null,grabRedItem.getAppversion());
				if(sendMsg == null) {
					grabRedItemUpdate.setLocalerrormsg("红包发送方消息保存失败");
					return false;
				}
				WxFriendChatNtf sendNtf = WxFriendChatNtf.from(sendMsg);
				sendNtf.setRedflag(Const.YesOrNo.YES);
				sendNtf.setChatlinkid(tochatlinkid);
				ImPacket sendPacket = new ImPacket(Command.WxFriendChatNtf, Json.toJson(sendNtf));
				Ims.sendToUser(senduid, sendPacket);
				Ret toret = ChatMsgService.me.afterSendFriendChatMsg(sendMsg,senduser, touserUserItem.getChatlinkmetaid(), 
						null, null, null);
				if(toret.isFail()) {
					grabRedItemUpdate.setLocalerrormsg("更改消息会话错误-tosend-抢红包");
					return false;
				}
				clearFriendCache(uid, senduid, chatlinkid, tochatlinkid);
			}
		} else {
			Byte contentType = Const.ContentType.TEXT;
			Byte sysflag = Const.YesOrNo.YES;
			if(Objects.equals(senduid, uid)) {
				WxGroupMsg grabMsg = GroupService.me.addMsg(grabRedItem.getDevice(), "", "你领取了 自己 的红包", uid, grabRedItem.getIp(), bizid,contentType , sysflag, uid, null, null,null,"",null,null,grabRedItem.getAppversion());
				if(grabMsg == null) {
					grabRedItemUpdate.setLocalerrormsg("自己抢自己的红包消息保存失败");
					return false;
				}
				WxGroupChatNtf grabNtf = WxGroupChatNtf.from(grabMsg,null);
				grabNtf.setRedflag(Const.YesOrNo.YES);
				grabNtf.setChatlinkid(-bizid);
				ImPacket grabPacket = new ImPacket(Command.WxGroupChatNtf, Json.toJson(grabNtf));
				Ims.sendToUser(uid, grabPacket);
				ChatMsgService.me.afterSendGroupById(grabMsg, null,userItem.getChatlinkmetaid(),null);
				clearGroupCache(uid, null, bizid);
			} else {
				WxGroupMsg grabMsg = GroupService.me.addMsg(grabRedItem.getDevice(), "", "你领取了 " + senduser.getNick() + " 的红包", uid, grabRedItem.getIp(), bizid,contentType , sysflag, uid, null, null,null,"",null,null,grabRedItem.getAppversion());
				if(grabMsg == null) {
					grabRedItemUpdate.setLocalerrormsg("自己抢的红包消息保存失败");
					return false;
				}
				WxGroupChatNtf grabNtf = WxGroupChatNtf.from(grabMsg,null);
				grabNtf.setRedflag(Const.YesOrNo.YES);
				grabNtf.setChatlinkid(-bizid);
				ImPacket grabPacket = new ImPacket(Command.WxGroupChatNtf, Json.toJson(grabNtf));
				Ims.sendToUser(uid, grabPacket);
				ChatMsgService.me.afterSendGroupById(grabMsg, null,userItem.getChatlinkmetaid(),null);
				WxGroupMsg sendMsg = GroupService.me.addMsg(grabRedItem.getDevice(), "", user.getNick() + " 领取了你的红包", senduid, grabRedItem.getIp(), bizid,contentType , sysflag, senduid, null, null,null,"",null,null,grabRedItem.getAppversion());
				if(sendMsg == null) {
					grabRedItemUpdate.setLocalerrormsg("红包发送方消息保存失败");
					return false;
				}
				WxGroupChatNtf sendNtf = WxGroupChatNtf.from(sendMsg,null);
				sendNtf.setRedflag(Const.YesOrNo.YES);
				sendNtf.setChatlinkid(-bizid);
				ImPacket sendPacket = new ImPacket(Command.WxGroupChatNtf, Json.toJson(sendNtf));
				Ims.sendToUser(senduid, sendPacket);
				ChatMsgService.me.afterSendGroupById(sendMsg, null,touserUserItem.getChatlinkmetaid(),null);
				clearGroupCache(uid, senduid, bizid);
			}
			
		}
		return true;
	}
	
	
	/**
	 * @param uid
	 * @param touid
	 * @param chatlinkid
	 * @param tochatlinkid
	 * @author xufei
	 * 2020年12月4日 下午6:03:56
	 */
	private static void clearFriendCache(Integer uid,Integer touid,Long chatlinkid,Long tochatlinkid) {
		ChatIndexService.clearChatUserIndex(uid,new Long(touid), Const.ChatMode.P2P);
		ChatIndexService.removeChatItemsCache(chatlinkid);
		if(tochatlinkid != null) {
			ChatIndexService.clearChatUserIndex(touid,new Long(uid),Const.ChatMode.P2P);
			ChatIndexService.removeChatItemsCache(tochatlinkid);
		}
	}
	
	/**
	 * @param uid
	 * @param touid
	 * @param chatlinkid
	 * @param tochatlinkid
	 * @author xufei
	 * 2020年12月4日 下午6:04:06
	 */
	private static void clearGroupCache(Integer uid,Integer touid,Long groupid) {
		ChatIndexService.removeChatGroupCache(groupid, uid);
		ChatIndexService.removeUserCache(uid, groupid, Const.ChatMode.GROUP);
		if(touid != null) {
			ChatIndexService.removeChatGroupCache(groupid, touid);
			ChatIndexService.removeUserCache(touid, groupid, Const.ChatMode.GROUP);
		}
		ChatIndexService.clearGroupMsgCache(groupid);
	}
	
	/****************************** end -红包私有逻辑******************************************************/
}
