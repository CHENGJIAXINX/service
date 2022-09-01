/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.pay.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.WxUserGrabRedItem;
import org.tio.sitexxx.service.model.main.WxUserSendRedItem;
import org.tio.sitexxx.service.model.main.WxUserWithholdCount;
import org.tio.sitexxx.service.pay.base.BasePay;
import org.tio.sitexxx.service.pay.base.BasePayReq;
import org.tio.sitexxx.service.pay.base.BasePayResp;
import org.tio.sitexxx.service.pay.impl.pay5u.Pay5UConst;
import org.tio.sitexxx.service.pay.impl.pay5u.Pay5uApi;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.RedpacketQuery5UResp;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.utils.LockUtils.LockPrefix;
import org.tio.sitexxx.servicecommon.utils.PeriodUtils;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.service.vo.ClientTokenVo;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.service.vo.GrabRedpacketVo;
import org.tio.sitexxx.service.vo.OpenVo;
import org.tio.sitexxx.service.vo.RechargeQueryVo;
import org.tio.sitexxx.service.vo.RechargeVo;
import org.tio.sitexxx.service.vo.RedpacketQueryVo;
import org.tio.sitexxx.service.vo.SendRedpacketVo;
import org.tio.sitexxx.service.vo.UpdateOpenVo;
import org.tio.sitexxx.service.vo.WalletVo;
import org.tio.sitexxx.service.vo.WithholdQueryVo;
import org.tio.sitexxx.service.vo.WithholdVo;
import org.tio.utils.json.Json;
import org.tio.utils.lock.LockUtils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 支付服务
 * @author xufei
 * 2020年09月25日 下午5:57:32
 */
public class PayService {
	
	private static Logger				log	= LoggerFactory.getLogger(PayService.class);
	
	public static final PayService	me	= new PayService();
	
	public static BasePay<BasePayReq, BasePayResp> basePay;
	
	public static void initPay() {
		basePay = new Pay5uApi();
	}
	
	/**
	 * 开户
	 * @param openVo
	 * @return
	 * @author xufei
	 * 2020年11月3日 下午5:57:12
	 */
	public BasePayResp openUser(OpenVo openVo,HttpRequest request) {
		if(openVo == null) {
			log.error("开户信息为空");
			return BasePayResp.fail("参数异常");
		}
		log.error("开户信息：{}",Json.toJson(openVo));
		BasePayReq req = new BasePayReq(request);
		req.setParams(openVo.toMap());
		BasePayResp resp = basePay.openUser(req,openVo.getUid());
		return resp;
	}
	
	
	/**
	 * 修改开户信息
	 * @param openVo
	 * @return
	 * @author xufei
	 * 2020年11月12日 下午3:28:16
	 */
	public BasePayResp updateOpenUser(UpdateOpenVo openVo,HttpRequest request) {
		if(openVo == null) {
			log.error("开户信息为空");
			return BasePayResp.fail("参数异常");
		}
		log.error("开户信息：{}",Json.toJson(openVo));
		BasePayReq req = new BasePayReq(request);
		req.setParams(openVo.toMap());
		BasePayResp resp = basePay.updateUser(req,openVo.getUid());
		return resp;
	}
	
	/**
	 * 钱包信息
	 * @param uid
	 * @param walletid
	 * @return
	 * @author xufei
	 * 2020年11月15日 下午5:56:34
	 */
	public BasePayResp getWalletInfo(WalletVo walletVo,HttpRequest request) {
		if(walletVo.getUid() == null || StrUtil.isBlank(walletVo.getWalletid())) {
			log.error("获取钱包信息未空");
			return BasePayResp.fail("参数异常");
		}
		BasePayReq req = new BasePayReq(request);
		req.setParams(walletVo.toMap());
		BasePayResp resp = basePay.getWalletInfo(req,walletVo.getUid());
		return resp;
	}
	
	/**
	 * 发送红包
	 * @param redpacketVo
	 * @return
	 * @author xufei
	 * 2020年11月18日 下午6:06:01
	 */
	public BasePayResp sendRedpacket(SendRedpacketVo redpacketVo,HttpRequest request) {
		if(redpacketVo.getUid() == null || StrUtil.isBlank(redpacketVo.getWalletid())) {
			log.error("发送红包参数为空");
			return BasePayResp.fail("参数异常");
		}
		BasePayReq req = new BasePayReq(request);
		req.setParams(redpacketVo.toMap());
		BasePayResp resp = basePay.sendRedpacket(req,redpacketVo.getUid());
		return resp;
	}
	
	/**
	 * 发送红包记录
	 * @param uid
	 * @param pageNumber
	 * @return
	 * @author xufei
	 * 2020年11月19日 上午11:32:00
	 */
	public Ret sendRedpacketlist(Integer uid,Integer pageNumber,String period) {
		Kv params = Kv.by("uid", uid).set("statuses", 
				"'" + Pay5UConst.RedPacketStatus.SUCCESS + "','" 
				+ Pay5UConst.RedPacketStatus.SEND + "','" 
				+ Pay5UConst.RedPacketStatus.TIMEOUT +  "'" );
		DateTime dateTime = new DateTime();
		if(StrUtil.isNotBlank(period)) {
			dateTime = PeriodUtils.getDateByPeriod(period);
		} 
		String starttime = DateUtil.format(DateUtil.beginOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
		String endtime = DateUtil.format(DateUtil.endOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
		params.set("starttime", starttime).set("endtime", endtime);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("redpacket.sendlist", params);
		Page<Record> redpacketPage = Db.use(Const.Db.TIO_SITE_MAIN).paginate(pageNumber, 16, sqlPara);
		return RetUtils.okPage(redpacketPage);
	}
	
	/**
	 * @param uid
	 * @param period
	 * @return
	 * @author xufei
	 * 2020年11月27日 下午4:50:13
	 */
	public Ret sendRedpacketStat(Integer uid,String period) {
		Kv params = Kv.by("uid", uid).set("statuses", 
				"'" + Pay5UConst.RedPacketStatus.SUCCESS + "','" 
				+ Pay5UConst.RedPacketStatus.SEND + "','" 
				+ Pay5UConst.RedPacketStatus.TIMEOUT +  "'" );
		DateTime dateTime = new DateTime();
		if(StrUtil.isNotBlank(period)) {
			dateTime = PeriodUtils.getDateByPeriod(period);
		} 
		String starttime = DateUtil.format(DateUtil.beginOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
		String endtime = DateUtil.format(DateUtil.endOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
		params.set("starttime", starttime).set("endtime", endtime);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("redpacket.sendstat", params);
		Record redpacketstat = Db.use(Const.Db.TIO_SITE_MAIN).findFirst(sqlPara);
		return RetUtils.okData(redpacketstat);
	}
	
	/**
	 * 抢红包
	 * @param grabRedpacketVo
	 * @return
	 * @author xufei
	 * 2020年11月19日 上午10:45:04
	 */
	public BasePayResp grabRedpacket(GrabRedpacketVo grabRedpacketVo,HttpRequest request) {
		if(grabRedpacketVo.getUid() == null || StrUtil.isBlank(grabRedpacketVo.getWalletid())) {
			log.error("抢红包参数为空");
			return BasePayResp.fail("参数异常");
		}
		BasePayReq req = new BasePayReq(request);
		req.setParams(grabRedpacketVo.toMap());
		BasePayResp resp = basePay.grabRedpacket(req,grabRedpacketVo.getUid());
		return resp;
	}
	
	/**
	 * 抢红包记录
	 * @param uid
	 * @param pageNumber
	 * @return
	 * @author xufei
	 * 2020年11月19日 上午11:33:07
	 */
	public Ret grabRedpacketlist(Integer uid,Integer pageNumber,String period) {
		Kv params = Kv.by("uid", uid).set("status",Pay5UConst.Status.SUCCESS);
		DateTime dateTime = new DateTime();
		if(StrUtil.isNotBlank(period)) {
			dateTime = PeriodUtils.getDateByPeriod(period);
		} 
		String starttime = DateUtil.format(DateUtil.beginOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
		String endtime = DateUtil.format(DateUtil.endOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
		params.set("starttime", starttime).set("endtime", endtime);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("redpacket.grablist", params);
		Page<Record> redpacketPage = Db.use(Const.Db.TIO_SITE_MAIN).paginate(pageNumber, 16, sqlPara);
		return RetUtils.okPage(redpacketPage);
	}
	
	/**
	 * 
	 * @param uid
	 * @param period
	 * @return
	 * @author xufei
	 * 2020年11月27日 下午4:52:51
	 */
	public Ret grabRedpacketStat(Integer uid,String period) {
		Kv params = Kv.by("uid", uid).set("status",Pay5UConst.Status.SUCCESS);
		DateTime dateTime = new DateTime();
		if(StrUtil.isNotBlank(period)) {
			dateTime = PeriodUtils.getDateByPeriod(period);
		} 
		String starttime = DateUtil.format(DateUtil.beginOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
		String endtime = DateUtil.format(DateUtil.endOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
		params.set("starttime", starttime).set("endtime", endtime);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("redpacket.grabstat", params);
		Record redpacketstat = Db.use(Const.Db.TIO_SITE_MAIN).findFirst(sqlPara);
		return RetUtils.okData(redpacketstat);
	}
	
	/**
	 * 红包状态
	 * @param uid
	 * @param serialNumber
	 * @return
	 * @author xufei
	 * 2020年11月22日 下午10:30:43
	 */
	public Ret redStatus(User user,String serialNumber) {
		Map<String, Object> statusRet = new HashMap<String, Object>();
		statusRet.put("openflag", user.getOpenflag());
		if(Objects.equals(user.getOpenflag(), Const.YesOrNo.NO)) {
			return RetUtils.okData(statusRet);
		}
		WxUserSendRedItem redItem = WxUserSendRedItem.dao.findFirst("select * from wx_user_send_red_item where serialnumber = ?",serialNumber);
		if(redItem == null || Objects.equals(redItem.getStatus(), Pay5UConst.RedPacketStatus.CANCEL) || Objects.equals(redItem.getStatus(), Pay5UConst.RedPacketStatus.FAIL)) {
			return RetUtils.failMsg("红包不存在");
		}
		statusRet.put("redstatus", redItem.getStatus());
		WxUserGrabRedItem grabRedItem = WxUserGrabRedItem.dao.findFirst("select * from wx_user_grab_red_item where uid = ? and sendid = ?",user.getId(),redItem.getId());
		if(grabRedItem == null) {
			statusRet.put("grabstatus", Pay5UConst.Status.INIT);
		} else {
			statusRet.put("grabamount",grabRedItem.getAmount());
			statusRet.put("grabstatus", grabRedItem.getStatus());
		}
		return RetUtils.okData(statusRet);
	}
	
	/**
	 * 红包信息
	 * @param serialNumber
	 * @return
	 * @author xufei
	 * 2020年11月22日 下午10:50:11
	 */
	public Ret redInfo(HttpRequest request,String serialNumber,User user) {
		WxUserSendRedItem redItem = WxUserSendRedItem.dao.findFirst("select red.chatmode,red.uid,red.id,red.reqid,red.amount,red.serialnumber,red.remark,red.packetcount,red.bizcompletetime,red.bizcreattime,red.receivedamount,red.receivedcount,u.nick,u.avatar,red.`status`,red.mode from wx_user_send_red_item red inner join `user` u on u.id = red.uid where red.serialnumber = ?",serialNumber);
		if(redItem == null || Objects.equals(redItem.getStatus(), Pay5UConst.RedPacketStatus.CANCEL) || Objects.equals(redItem.getStatus(), Pay5UConst.RedPacketStatus.FAIL)) {
			return RetUtils.failMsg("红包不存在");
		}
		if(Objects.equals(redItem.getStatus(), Pay5UConst.RedPacketStatus.SEND)) {
			BasePayReq req = new BasePayReq(request);
			RedpacketQueryVo queryVo = new RedpacketQueryVo();
			queryVo.setSend(redItem);
			queryVo.setReqid(redItem.getReqid());
			queryVo.setUid(user.getId());
			queryVo.setWalletid(user.getWalletid());
			queryVo.setSerialnumber(serialNumber);
			req.setParams(queryVo.toMap());
			BasePayResp resp = basePay.redpacketQuery(req,queryVo.getUid());
			RedpacketQuery5UResp queryRet = RedpacketQuery5UResp.toBean(resp.getResp());
			if(queryRet != null) {
				redItem.setReceivedamount(strToInteger(queryRet.getReceivedAmount()));
				redItem.setReceivedcount(strToShort(queryRet.getReceivedCount()));
				redItem.setRefundamount(strToInteger(queryRet.getRefundAmount()));
				redItem.setReceivewalletid(queryRet.getReceiveWalletId());
			}
		}
		redItem.setReqid("");
		Map<String, Object> infoRet = new HashMap<String, Object>();
		infoRet.put("info", redItem);
		List<WxUserGrabRedItem> grabRedItem = WxUserGrabRedItem.dao.find("select grab.uid,grab.serialnumber,grab.id,grab.amount,grab.bizcompletetime,grab.walletid,u.nick,u.avatar from wx_user_grab_red_item grab inner join `user` u on u.id = grab.uid  where grab.sendid = ? order by grab.id desc",redItem.getId());
		if(CollectionUtil.isNotEmpty(grabRedItem)) {
			infoRet.put("grablist", grabRedItem);
		} else {
			infoRet.put("grablist", new ArrayList<WxUserGrabRedItem>());
		}
		return RetUtils.okData(infoRet);
	}
	
	
	/**
	 * 客户端token
	 * @param tokenVo
	 * @return
	 * @author xufei
	 * 2020年11月15日 下午6:51:59
	 */
	public BasePayResp getClientToken(ClientTokenVo tokenVo,HttpRequest request) {
		if(tokenVo == null || StrUtil.isBlank(tokenVo.getWalletid()) || StrUtil.isBlank(tokenVo.getBizType())) {
			log.error("获取token参数异常");
			return BasePayResp.fail("参数异常");
		}
		String bizType = tokenVo.getBizType();
		if(!Pay5UConst.ClientBizType.ACCESS_CARDlIST.equals(bizType) && !Pay5UConst.ClientBizType.ACCESS_SAFETY.equals(bizType)) {
			log.error("获取token参数异常:{}",bizType);
			return BasePayResp.fail("无效页面");
		}
		BasePayReq req = new BasePayReq(request);
		req.setParams(tokenVo.toMap());
		BasePayResp resp = basePay.clientToken(req,tokenVo.getUid());
		return resp;
	}
	
	/**
	 * 充值
	 * @param rechargeVo
	 * @return
	 * @author xufei
	 * 2020年11月15日 下午7:57:54
	 */
	public BasePayResp recharge(RechargeVo rechargeVo,HttpRequest request) {
		if(rechargeVo == null || StrUtil.isBlank(rechargeVo.getWalletid()) || rechargeVo.getUid() == null) {
			log.error("充值参数异常");
			return BasePayResp.fail("参数异常");
		}
		BasePayReq req = new BasePayReq(request);
		req.setParams(rechargeVo.toMap());
		BasePayResp resp = basePay.recharge(req, rechargeVo.getUid());
		return resp;
	}
	
	/**
	 * 充值查询
	 * @param rechargeVo
	 * @param request
	 * @return
	 * @author xufei
	 * 2020年11月25日 下午1:59:12
	 */
	public BasePayResp rechargeQuery(RechargeQueryVo rechargeVo,HttpRequest request) {
		if(rechargeVo == null || StrUtil.isBlank(rechargeVo.getSerialnumber())) {
			log.error("充值查询参数异常");
			return BasePayResp.fail("参数异常");
		}
		BasePayReq req = new BasePayReq(request);
		req.setParams(rechargeVo.toMap());
		BasePayResp resp = basePay.rechargeQuery(req, rechargeVo.getUid());
		return resp;
	}
	
	/**
	 * 充值记录
	 * @param uid
	 * @param pageNumber
	 * @return
	 * @author xufei
	 * 2020年11月19日 上午11:17:04
	 */
	public Ret rechargelist(Integer uid,Integer pageNumber) {
		if(pageNumber == null || pageNumber <= 0) {
			pageNumber = 1;
		}
		Kv params = Kv.by("uid", uid).set("status", Pay5UConst.Status.SUCCESS);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("recharge.list", params);
		Page<Record> rechargePage = Db.use(Const.Db.TIO_SITE_MAIN).paginate(pageNumber, 16, sqlPara);
		return RetUtils.okPage(rechargePage);
	}
	
	/**
	 * @param uid
	 * @param pageNumber
	 * @param mode
	 * @return
	 * @author xufei
	 * 2020年11月26日 上午10:43:38
	 */
	public Ret getWalletItems(Integer uid,Integer pageNumber,Byte mode) {
		if(pageNumber == null || pageNumber <= 0) {
			pageNumber = 1;
		}
		Kv params = Kv.by("uid", uid);
		if(mode != null) {
			params.set("mode", mode);
		}
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("wallet.items", params);
		Page<Record> rechargePage = Db.use(Const.Db.TIO_SITE_MAIN).paginate(pageNumber, 16, sqlPara);
		return RetUtils.okPage(rechargePage);
	}
	
	
	/**
	 * 提现
	 * @param withholdVo
	 * @return
	 * @author xufei
	 * 2020年11月16日 下午2:09:17
	 */
	public BasePayResp withhold(WithholdVo withholdVo,HttpRequest request) {
		if(withholdVo == null || StrUtil.isBlank(withholdVo.getWalletid()) || withholdVo.getUid() == null) {
			log.error("提现参数异常");
			return BasePayResp.fail("参数异常");
		}
		BasePayReq req = new BasePayReq(request);
		req.setParams(withholdVo.toMap());
		BasePayResp resp = basePay.withhold(req, withholdVo.getUid());
		return resp;
	}
	
	/**
	 * 提现查询
	 * @param rechargeVo
	 * @param request
	 * @return
	 * @author xufei
	 * 2020年11月25日 下午1:59:12
	 */
	public BasePayResp withholdQuery(WithholdQueryVo withholdQueryVo,HttpRequest request) {
		if(withholdQueryVo == null || StrUtil.isBlank(withholdQueryVo.getSerialnumber())) {
			log.error("充值查询参数异常");
			return BasePayResp.fail("参数异常");
		}
		BasePayReq req = new BasePayReq(request);
		req.setParams(withholdQueryVo.toMap());
		BasePayResp resp = basePay.withholdQuery(req, withholdQueryVo.getUid());
		return resp;
	}
	
	/**
	 * 提现记录
	 * @param uid
	 * @param pageNumber
	 * @return
	 * @author xufei
	 * 2020年11月19日 上午11:16:33
	 */
	public Ret withholdlist(Integer uid,Integer pageNumber) {
		if(pageNumber == null || pageNumber <= 0) {
			pageNumber = 1;
		}
		Kv params = Kv.by("uid", uid).set("status", Pay5UConst.Status.SUCCESS);
		SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("withhold.list", params);
		Page<Record> withholdPage = Db.use(Const.Db.TIO_SITE_MAIN).paginate(pageNumber, 16, sqlPara);
		return RetUtils.okPage(withholdPage);
	}
	
	/**
	 * 充值回调
	 * @param request
	 * @return
	 * @author xufei
	 * 2020年11月15日 下午7:59:04
	 */
	public BasePayResp rechargeCallback(HttpRequest request,Integer uid) {
		BasePayResp resp = basePay.rechargeCallback(request,uid);
		return resp;
	}
	
	/**
	 * 提现回调
	 * @param request
	 * @param uid
	 * @return
	 * @author xufei
	 * 2020年11月16日 下午2:15:22
	 */
	public BasePayResp withholdCallback(HttpRequest request,Integer uid) {
		BasePayResp resp = basePay.withholdCallback(request,uid);
		return resp;
	}
	
	/**
	 * 发送红包回调
	 * @param request
	 * @param uid
	 * @return
	 * @author xufei
	 * 2020年11月18日 下午6:08:40
	 */
	public BasePayResp redpacketCallback(HttpRequest request,Integer uid) {
		BasePayResp resp = basePay.sendRedpacketCallback(request,uid);
		return resp;
	}
	
	/**
	 * 
	 * @param uid
	 * @param period
	 * @return
	 * @author xufei
	 * 2020年11月30日 下午5:35:17
	 */
	public WxUserWithholdCount initWihtCount(Integer uid,String period) {
		if(StrUtil.isBlank(period)) {
			period = PeriodUtils.dateToPeriodByType(new DateTime(), Const.PeriodType.DAY);
		}
		WxUserWithholdCount count = WxUserWithholdCount.dao.findFirst("select * from wx_user_withhold_count where uid = ? and period = ?",uid,period);
		if(count == null) {
			count = new WxUserWithholdCount();
			count.setUid(uid);
			count.setPeriod(period);
			count.setCount((short)0);
			int i = count.ignoreSave();
			if(i <= 0) {
				count = WxUserWithholdCount.dao.findFirst("select * from wx_user_withhold_count where uid = ? and period = ?",uid,period);
				if(count == null) {
					return null;
				}
			}
		}
		return count;
	}
	
	
	/**
	 * 修改提现次数
	 * @param id
	 * @return
	 * @author xufei
	 * 2020年11月30日 下午5:42:02
	 */
	public  boolean updateWithholdCount(Integer id) {
		Integer maxCount = ConfService.getInt(Const.ConfMapping.WX_WALLET_WITHHOLD_MAX_COUNT, 100);
		ReentrantReadWriteLock rwLock = LockUtils.getReentrantReadWriteLock(LockPrefix.CHAT_WALLET_WITHHOLD + "." + id, WxUserWithholdCount.class);
		WriteLock writeLock = rwLock.writeLock();
		writeLock.lock();
		try {
			WxUserWithholdCount count = WxUserWithholdCount.dao.findById(id);
			if(count.getCount() > maxCount) {
				return false;
			}
			Db.use(Const.Db.TIO_SITE_MAIN).update("update wx_user_withhold_count set count = count + 1 where id = ?",id);
			WxUserWithholdCount newCount = WxUserWithholdCount.dao.findById(id);
			if(newCount.getCount() > (maxCount + 1)) {
				return false;
			}
			return true;
		} catch (Exception e) {
			log.error("提现次数修改失败");
		} finally {
			writeLock.unlock();
		}
		return false;
	}
	
	/**
	 * @param str
	 * @return
	 * @author xufei
	 * 2020年12月1日 下午2:13:11
	 */
	private Integer strToInteger(String str) {
		if(StrUtil.isBlank(str)) {
			return 0;
		}
		return Integer.parseInt(str);
	}
	
	
	/**
	 * @param str
	 * @return
	 * @author xufei
	 * 2020年12月1日 下午2:14:10
	 */
	private Short strToShort(String str) {
		if(StrUtil.isBlank(str)) {
			return 0;
		}
		return Short.parseShort(str);
	}
	
}
