/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.pay;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.WxChatGroupItem;
import org.tio.sitexxx.service.model.main.WxChatUserItem;
import org.tio.sitexxx.service.pay.base.BasePayResp;
import org.tio.sitexxx.service.pay.service.PayService;
import org.tio.sitexxx.service.service.chat.ChatIndexService;
import org.tio.sitexxx.service.service.chat.ChatService;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.service.vo.ClientTokenVo;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.service.vo.GrabRedpacketVo;
import org.tio.sitexxx.service.vo.OpenVo;
import org.tio.sitexxx.service.vo.RechargeQueryVo;
import org.tio.sitexxx.service.vo.RechargeVo;
import org.tio.sitexxx.service.vo.SendRedpacketVo;
import org.tio.sitexxx.service.vo.UpdateOpenVo;
import org.tio.sitexxx.service.vo.WalletVo;
import org.tio.sitexxx.service.vo.WithholdQueryVo;
import org.tio.sitexxx.service.vo.WithholdVo;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

import cn.hutool.core.util.StrUtil;

/**
 * 支付
 * 
 */
@RequestPath(value = "/pay")
public class PayController {

	
	private static Logger log = LoggerFactory.getLogger(PayController.class);

	/**
	 * 
	 * 
	 */
	public PayController() {
	}

	/**
	 * 开户
	 * @param mediaCode
	 * @return
	 * @throws Exception
	 * 
	 */
	@RequestPath(value = "/open")
	public Resp open(HttpRequest request, OpenVo open) throws Exception {
		User curr = WebUtils.currUser(request);
		if(Objects.equals(curr.getOpenflag(), Const.YesOrNo.YES)) {
			return Resp.fail("用户已开户");
		}
//		if(!Objects.equals(open.getUid(), curr.getId())) {
//			return Resp.fail("权限不足");
//		}
		String ip = request.getClientIp();
		if(StrUtil.isBlank(open.getIp())) {
			open.setIp(ip);
		}
		open.setUid(curr.getId());
		BasePayResp resp = PayService.me.openUser(open,request);
		if(!resp.isOk()) {
			return Resp.fail("开户失败:" + resp.getMsg());
		}
		return Resp.ok(resp.getResp());
	}
	
	/**
	 * 开户状态
	 * @param request
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月12日 下午3:03:21
	 */
	@RequestPath(value = "/openflag")
	public Resp openflag(HttpRequest request) throws Exception {
		User curr = WebUtils.currUser(request);
		Map<String, Object> ret = new HashMap<String, Object>();
		if(Objects.equals(curr.getOpenflag(),Const.YesOrNo.YES)) {
			ret.put("walletid", curr.getWalletid());
			ret.put("openid", curr.getOpenid());
		} 
		ret.put("uid", curr.getId());
		ret.put("openflag", curr.getOpenflag());
		return Resp.ok(ret);
	}
	
	/**
	 * 修改开户信息
	 * @param request
	 * @param open
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月6日 下午4:30:57
	 */
	@RequestPath(value = "/updateOpenInfo")
	public Resp updateOpenInfo(HttpRequest request, UpdateOpenVo update) throws Exception {
		User curr = WebUtils.currUser(request);
		if(Objects.equals(curr.getOpenflag(), Const.YesOrNo.NO)) {
			return Resp.fail("用户未开户");
		}
		if(update == null) {
			return Resp.fail("参数为空");
		}
//		if(!Objects.equals(update.getUid(), curr.getId()) || !update.getWalletid().equals(curr.getWalletid())) {
//			return Resp.fail("权限不足");
//		}
		if(update.getUid() == null) {
			update.setUid(curr.getId());
		}
		if(update.getWalletid() == null) {
			update.setWalletid(curr.getWalletid());
		}
		BasePayResp resp = PayService.me.updateOpenUser(update,request);
		if(!resp.isOk()) {
			return Resp.fail("修改失败:" + resp.getMsg());
		}
		return Resp.ok(resp.getResp());
	}
	
	/**
	 * 充值接口
	 * @param request
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月6日 下午4:25:37
	 */
	@RequestPath(value = "/recharge")
	public Resp recharge(HttpRequest request,RechargeVo rechargeVo) throws Exception {
		User curr = WebUtils.currUser(request);
		if(Objects.equals(curr.getOpenflag(), Const.YesOrNo.NO)) {
			return Resp.fail("用户未开户");
		}
		if(rechargeVo == null) {
			return Resp.fail("充值参数为空");
		}
		if(StrUtil.isBlank(rechargeVo.getAmount())) {
			return Resp.fail("充值金额为空");
		}
		Double _amount = Double.parseDouble(rechargeVo.getAmount());
		if(_amount <= 0) {
			return Resp.fail("充值金额为负");
		}
		Integer rechargeLimit = ConfService.getInt(Const.ConfMapping.WX_WALLET_RECHARGE_MAX_AMOUNT, 100);
		if(_amount > rechargeLimit) {
			return Resp.fail("充值金额最大为" + new Double(rechargeLimit)/100 + "元");
		}
//		if(!Objects.equals(rechargeVo.getUid(), curr.getId()) || !rechargeVo.getWalletid().equals(curr.getWalletid())) {
//			return Resp.fail("权限不足");
//		}
		if(rechargeVo.getUid() == null) {
			rechargeVo.setUid(curr.getId());
		}
		if(rechargeVo.getWalletid() == null) {
			rechargeVo.setWalletid(curr.getWalletid());
		}
		
		BasePayResp resp = PayService.me.recharge(rechargeVo,request);
		if(!resp.isOk()) {
			return Resp.fail("预支付失败:" + resp.getMsg());
		}
		return Resp.ok(resp.getResp());
	}
	
	/**
	 * 充值查询
	 * @param request
	 * @param queryVo
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月25日 下午2:07:39
	 */
	@RequestPath(value = "/rechargeQuery")
	public Resp rechargeQuery(HttpRequest request,RechargeQueryVo queryVo) throws Exception {
		User curr = WebUtils.currUser(request);
		if(Objects.equals(curr.getOpenflag(), Const.YesOrNo.NO)) {
			return Resp.fail("用户未开户");
		}
		if(queryVo == null || StrUtil.isBlank(queryVo.getSerialnumber())) {
			return Resp.fail("充值参数为空");
		}
		if(queryVo.getUid() == null) {
			queryVo.setUid(curr.getId());
		}
		if(queryVo.getWalletid() == null) {
			queryVo.setWalletid(curr.getWalletid());
		}
		BasePayResp resp = PayService.me.rechargeQuery(queryVo,request);
		if(!resp.isOk()) {
			return Resp.fail("充值查询失败:" + resp.getMsg());
		}
		return Resp.ok(resp.getResp());
	}
	
	/**
	 * 提现记录
	 * @param request
	 * @param pageNumber
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月19日 上午11:20:27
	 */
	@RequestPath(value = "/rechargelist")
	public Resp rechargelist(HttpRequest request,Integer pageNumber) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = PayService.me.rechargelist(curr.getId(),pageNumber);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}
	
	/**
	 * 提现接口
	 * @param request
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月6日 下午4:26:20
	 */
	@RequestPath(value = "/withhold")
	public Resp withhold(HttpRequest request,WithholdVo withholdVo) throws Exception {
		User curr = WebUtils.currUser(request);
		if(Objects.equals(curr.getOpenflag(), Const.YesOrNo.NO)) {
			return Resp.fail("用户未开户");
		}
		if(withholdVo == null) {
			return Resp.fail("充值参数为空");
		}
		if(StrUtil.isBlank(withholdVo.getAmount())) {
			return Resp.fail("充值金额为空");
		}
		Double _amount = Double.parseDouble(withholdVo.getAmount());
		if(_amount <= 0) {
			return Resp.fail("提现金额为负");
		}
		Integer withholdlimit = ConfService.getInt(Const.ConfMapping.WX_WALLET_WITHHOLD_MAX_AMOUNT, 10);
		if(_amount > withholdlimit) {
			return Resp.fail("提现金额最大为" + new Double(withholdlimit)/100 + "元");
		}
		Integer minAmount = ConfService.getInt(Const.ConfMapping.WX_WALLET_WITHHOLD_MIN_AMOUT, 10000);
		if(_amount < minAmount) {
			return Resp.fail("单次提现金额不低于" + minAmount /100 + "元");
		}
//		if(!Objects.equals(withholdVo.getUid(), curr.getId()) || !withholdVo.getWalletid().equals(curr.getWalletid())) {
//			return Resp.fail("权限不足");
//		}
		if(withholdVo.getUid() == null) {
			withholdVo.setUid(curr.getId());
		}
		if(withholdVo.getWalletid() == null) {
			withholdVo.setWalletid(curr.getWalletid());
		}
		BasePayResp resp = PayService.me.withhold(withholdVo,request);
		if(!resp.isOk()) {
			return Resp.fail("预提现失败:" + resp.getMsg());
		}
		return Resp.ok(resp.getResp());
	}
	
	
	/**
	 * @param request
	 * @param queryVo
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月25日 下午2:24:31
	 */
	/**
	 * @param request
	 * @param queryVo
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月25日 下午2:25:07
	 */
	@RequestPath(value = "/withholdQuery")
	public Resp withholdQuery(HttpRequest request,WithholdQueryVo queryVo) throws Exception {
		User curr = WebUtils.currUser(request);
		if(Objects.equals(curr.getOpenflag(), Const.YesOrNo.NO)) {
			return Resp.fail("用户未开户");
		}
		if(queryVo == null || StrUtil.isBlank(queryVo.getSerialnumber())) {
			return Resp.fail("提现参数为空");
		}
		BasePayResp resp = PayService.me.withholdQuery(queryVo,request);
		if(!resp.isOk()) {
			return Resp.fail("提现查询失败:" + resp.getMsg());
		}
		if(queryVo.getUid() == null) {
			queryVo.setUid(curr.getId());
		}
		if(queryVo.getWalletid() == null) {
			queryVo.setWalletid(curr.getWalletid());
		}
		return Resp.ok(resp.getResp());
	}
	
	/**
	 * 提现记录
	 * @param request
	 * @param pageNumber
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月19日 上午11:19:56
	 */
	@RequestPath(value = "/withholdlist")
	public Resp withholdlist(HttpRequest request,Integer pageNumber) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = PayService.me.withholdlist(curr.getId(),pageNumber);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}
	
	/**
	 * 发红包接口
	 * @param request
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月6日 下午4:27:04
	 */
	@RequestPath(value = "/sendRedpacket")
	public Resp sendRedpacket(HttpRequest request,SendRedpacketVo redpacketVo) throws Exception {
		User curr = WebUtils.currUser(request);
		if(Objects.equals(curr.getOpenflag(), Const.YesOrNo.NO)) {
			return Resp.fail("用户未开户");
		}
		if(redpacketVo == null || redpacketVo.getChatlinkid() == null) {
			return Resp.fail("钱包参数为空");
		}
		Double _amount = Double.parseDouble(redpacketVo.getAmount());
		if(_amount <= 0) {
			return Resp.fail("红包金额为负");
		}
		
		Integer sendRedpacketLimit = ConfService.getInt(Const.ConfMapping.WX_WALLET_SENDREDPACKET_MAX_AMOUNT, 10);
		if(_amount > sendRedpacketLimit) {
			return Resp.fail("红包金额最大为" + new Double(sendRedpacketLimit)/100 + "元");
		}
//		if(!Objects.equals(redpacketVo.getUid(), curr.getId()) || !redpacketVo.getWalletid().equals(curr.getWalletid())) {
//			return Resp.fail("权限不足");
//		}
		if(redpacketVo.getUid() == null) {
			redpacketVo.setUid(curr.getId());
		}
		if(redpacketVo.getWalletid() == null) {
			redpacketVo.setWalletid(curr.getWalletid());
		}
		Long chatlinkid = redpacketVo.getChatlinkid();
		Byte chatmode = Const.ChatMode.P2P;
		Long groupid = null;
		if(chatlinkid <= 0) {
			chatmode = Const.ChatMode.GROUP;
			groupid = -chatlinkid;
			WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(curr.getId(), groupid);
			if(!ChatService.groupExistChat(groupItem)) {
				return Resp.fail("不是群成员");
			}
			chatlinkid = groupItem.getChatlinkid();
			redpacketVo.setBizid(groupid);
		} else {
			WxChatUserItem userItem = ChatIndexService.chatUserIndex(chatlinkid);
			if(!ChatService.existTwoFriend(userItem)) {
				return Resp.fail("你们不是互相不是好友");
			}
			redpacketVo.setBizid(userItem.getBizid());
		}
		redpacketVo.setChatmode(chatmode);
		BasePayResp resp = PayService.me.sendRedpacket(redpacketVo,request);
		if(!resp.isOk()) {
			return Resp.fail(resp.getMsg());
		}
		return Resp.ok(resp.getResp());
	}
	
	/**
	 * 发红包列表
	 * @param request
	 * @param pageNumber
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月19日 上午11:37:50
	 */
	@RequestPath(value = "/sendRedpacketlist")
	public Resp sendRedpacketlist(HttpRequest request,Integer pageNumber,String period) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = PayService.me.sendRedpacketlist(curr.getId(),pageNumber,period);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}
	
	/**
	 * @param request
	 * @param period
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月27日 下午4:50:26
	 */
	@RequestPath(value = "/sendredpacketstat")
	public Resp sendRedpacketStat(HttpRequest request,String period) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = PayService.me.sendRedpacketStat(curr.getId(),period);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		Record record = RetUtils.getOkTData(ret);
		if(record != null) {
			record.set("nick", curr.getNick());
			record.set("avatar", curr.getAvatar());
		}
		return Resp.ok(record);
	}

	
	/**
	 * 抢红包
	 * @param request
	 * @param grabRedpacketVo
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月19日 上午10:44:03
	 */
	@RequestPath(value = "/grabRedpacket")
	public Resp grabRedpacket(HttpRequest request,GrabRedpacketVo grabRedpacketVo) throws Exception {
		User curr = WebUtils.currUser(request);
		if(Objects.equals(curr.getOpenflag(), Const.YesOrNo.NO)) {
			return Resp.fail("用户未开户");
		}
		if(grabRedpacketVo == null) {
			return Resp.fail("钱包参数为空");
		}
//		if(!Objects.equals(grabRedpacketVo.getUid(), curr.getId()) || !grabRedpacketVo.getWalletid().equals(curr.getWalletid())) {
//			return Resp.fail("权限不足");
//		}
		if(grabRedpacketVo.getUid() == null) {
			grabRedpacketVo.setUid(curr.getId());
		}
		if(grabRedpacketVo.getWalletid() == null) {
			grabRedpacketVo.setWalletid(curr.getWalletid());
		}
		Long chatlinkid = grabRedpacketVo.getChatlinkid();
		Byte chatmode = Const.ChatMode.P2P;
		Long groupid = null;
		log.error("抢红包的chatlinkid:{}",chatlinkid);
		if(chatlinkid <= 0) {
			chatmode = Const.ChatMode.GROUP;
			groupid = -chatlinkid;
			WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(curr.getId(), groupid);
			if(!ChatService.groupExistChat(groupItem)) {
				return Resp.fail("不是群成员");
			}
			chatlinkid = groupItem.getChatlinkid();
			grabRedpacketVo.setBizid(groupid);
		} else {
			WxChatUserItem userItem = ChatIndexService.chatUserIndex(chatlinkid);
			if(!ChatService.existTwoFriend(userItem)) {
				return Resp.fail("你们不是互相不是好友");
			}
			grabRedpacketVo.setBizid(userItem.getBizid());
		}
		grabRedpacketVo.setChatmode(chatmode);
		BasePayResp resp = PayService.me.grabRedpacket(grabRedpacketVo,request);
		if(!resp.isOk()) {
			return Resp.fail(resp.getMsg());
		}
		return Resp.ok(resp.getResp());
	}
	
	/**
	 * 抢红包列表
	 * @param request
	 * @param pageNumber
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月19日 上午11:38:12
	 */
	@RequestPath(value = "/grabRedpacketlist")
	public Resp grabRedpacketlist(HttpRequest request,Integer pageNumber,String period) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = PayService.me.grabRedpacketlist(curr.getId(),pageNumber,period);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}
	
	/**
	 * @param request
	 * @param period
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月27日 下午4:52:29
	 */
	@RequestPath(value = "/grabredpacketstat")
	public Resp grabRedpacketStat(HttpRequest request,String period) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = PayService.me.grabRedpacketStat(curr.getId(),period);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		Record record = RetUtils.getOkTData(ret);
		if(record != null) {
			record.set("nick", curr.getNick());
			record.set("avatar", curr.getAvatar());
		}
		return Resp.ok(record);
	}
	
	/**
	 * @param request
	 * @param serialNumber
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月22日 下午10:20:30
	 */
	@RequestPath(value = "/redStatus")
	public Resp redStatus(HttpRequest request,String serialnumber) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = PayService.me.redStatus(curr,serialnumber);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkData(ret));
	}
	
	/**
	 * 红包信息
	 * @param request
	 * @param serialNumber
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月22日 下午10:51:00
	 */
	@RequestPath(value = "/redInfo")
	public Resp redInfo(HttpRequest request,String serialnumber) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = PayService.me.redInfo(request,serialnumber,curr);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkData(ret));
	}
	
	
	/**
	 * 获取钱包信息
	 * @param request
	 * @param open
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月6日 下午3:42:15
	 */
	@RequestPath(value = "/getWalletInfo")
	public Resp openInfo(HttpRequest request, WalletVo walletVo) throws Exception {
		User curr = WebUtils.currUser(request);
		if(Objects.equals(curr.getOpenflag(), Const.YesOrNo.NO)) {
			return Resp.fail("用户未开户");
		}
		if(walletVo == null) {
			return Resp.fail("钱包参数为空");
		}
//		if(!Objects.equals(walletVo.getUid(), curr.getId()) || !walletVo.getWalletid().equals(curr.getWalletid())) {
//			return Resp.fail("权限不足");
//		}
		if(walletVo.getUid() == null) {
			walletVo.setUid(curr.getId());
		}
		if(walletVo.getWalletid() == null) {
			walletVo.setWalletid(curr.getWalletid());
		}
		BasePayResp resp = PayService.me.getWalletInfo(walletVo,request);
		if(!resp.isOk()) {
			return Resp.fail(resp.getMsg());
		}
		return Resp.ok(resp.getResp());
	}
	
	
	/**
	 * 获取钱包明细
	 * @param request
	 * @param pageNumber
	 * @param mode
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月26日 上午10:42:13
	 */
	@RequestPath(value = "/getWalletItems")
	public Resp getWalletItems(HttpRequest request,Integer pageNumber, Byte mode) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = PayService.me.getWalletItems(curr.getId(),pageNumber,mode);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}
	
	/**
	 * 获取客户端native的token
	 * @param request
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年11月6日 下午3:42:57
	 */
	@RequestPath(value = "/getClientToken")
	public Resp getClientToken(HttpRequest request,ClientTokenVo tokenVo) throws Exception {
		User curr = WebUtils.currUser(request);
		if(Objects.equals(curr.getOpenflag(), Const.YesOrNo.NO)) {
			return Resp.fail("用户未开户");
		}
		if(tokenVo == null) {
			return Resp.fail("token参数为空");
		}
//		if(!Objects.equals(tokenVo.getUid(), curr.getId()) || !tokenVo.getWalletid().equals(curr.getWalletid())) {
//			return Resp.fail("权限不足");
//		}
		if(tokenVo.getUid() == null) {
			tokenVo.setUid(curr.getId());
		}
		if(tokenVo.getWalletid() == null) {
			tokenVo.setWalletid(curr.getWalletid());
		}
		tokenVo.setUid(curr.getId());
		tokenVo.setWalletid(curr.getWalletid());
		BasePayResp resp = PayService.me.getClientToken(tokenVo,request);
		if(!resp.isOk()) {
			return Resp.fail(resp.getMsg());
		}
		return Resp.ok(resp.getResp());
	}
}
