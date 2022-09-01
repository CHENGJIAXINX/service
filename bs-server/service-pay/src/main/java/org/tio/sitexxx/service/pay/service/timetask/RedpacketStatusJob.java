/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.pay.service.timetask;

import cn.hutool.core.util.StrUtil;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.im.common.Command;
import org.tio.sitexxx.im.common.ImPacket;
import org.tio.sitexxx.im.common.bs.wx.friend.WxFriendChatNtf;
import org.tio.sitexxx.im.common.bs.wx.group.WxGroupChatNtf;
import org.tio.sitexxx.im.server.Ims;
import org.tio.sitexxx.service.model.main.*;
import org.tio.sitexxx.service.service.atom.AbsAtom;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.chat.*;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletDetailTypeNum;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.jfinal.P;
import org.tio.utils.json.Json;
import org.tio.utils.quartz.AbstractJobWithLog;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 红包查询记录
 * @author xufei
 * 2020年7月3日 下午2:56:29
 */
public class RedpacketStatusJob extends AbstractJobWithLog {

	private static Logger log = LoggerFactory.getLogger(RedpacketStatusJob.class);

	private static boolean isRunning = false;
	
	private final static long red_packet_timeout = 24 * 60 * 60 *1000;
	
	@Override
	public void run(JobExecutionContext context) throws Exception {
		boolean allowExecute = P.getBoolean("quartz.open.flag",false);
		if(allowExecute && isStart()) {
			try {
				log.info("进入JobExecutionContext定时任务");
				List<YxUserSendRedPacket> yxUserSendRedPackets = YxUserSendRedPacket.dao.find("select * from yx_user_send_red_packet where status = 2");
				for (YxUserSendRedPacket yxUserSendRedPacketTmp : yxUserSendRedPackets){
					YxUserSendRedPacket yxUserSendRedPacket = yxUserSendRedPacketTmp;
					if (new Date().getTime() - yxUserSendRedPacket.getCreatetime().getTime() >= red_packet_timeout){
						//红包过期
						AbsAtom absAtom = new AbsAtom() {
							@Override
							public boolean run() throws SQLException {
								yxUserSendRedPacket.setStatus(4);
								yxUserSendRedPacket.setUpdatetime(new Date());
								if (!yxUserSendRedPacket.update()){
									log.error("处理过期红包失败：更新状态失败");
									return false;
								}
								//退款，把剩下的钱加到余额
								YxUserWallet yxUserWallet = WalletService.ME.queryByUid(yxUserSendRedPacket.getSenduid());
								if (yxUserWallet == null){
									log.error("用户未开户：{}", yxUserSendRedPacket.getSenduid());
									return false;
								}
								Ret ret = WalletService.ME.modifyBalance(WalletDetailTypeNum.RED, 1, yxUserSendRedPacket.getRemainmoney(),
										yxUserWallet.getId(), null, null, "红包退回", yxUserSendRedPacket.getId(), String.valueOf(yxUserSendRedPacket.getId()), false);
								if (ret.isFail()){
									log.error("红包退回失败：{}", RetUtils.getRetMsg(ret));
									return false;
								}
								//发送提醒
								if (yxUserSendRedPacket.getMode().intValue() == 1){
									//单人
									WxFriendMsg sendMsg = FriendService.me.addChatMsg(yxUserSendRedPacket.getDevicetype(), "", yxUserSendRedPacket.getSendip(), yxUserSendRedPacket.getSenduid(), "你的红包已超时，已退回钱包", yxUserSendRedPacket.getSenduid(),null,null,yxUserSendRedPacket.getAppver());
									if (sendMsg == null){
										log.error("发送红包退回私聊消息失败，红包ID：{}", yxUserSendRedPacket.getId());
										return false;
									}
									Ret checkRet = checkChat(Const.ChatMode.P2P, yxUserSendRedPacket.getSenduid(), yxUserSendRedPacket.getSenduid().longValue());
									String checkMsg = RetUtils.getOkTData(checkRet, "localmsg");
									if (StrUtil.isNotBlank(checkMsg)){
										log.error("发送红包退回私聊消息失败：{}，红包ID：{}",checkMsg, yxUserSendRedPacket.getId());
									}
									WxFriendChatNtf sendNtf = WxFriendChatNtf.from(sendMsg);
									ImPacket sendPacket = new ImPacket(Command.WxFriendChatNtf, Json.toJson(sendNtf));
									sendNtf.setRedflag(Const.YesOrNo.YES);
									sendNtf.setChatlinkid(RetUtils.getOkTData(checkRet, "chatlinkid"));
									Ims.sendToUser(yxUserSendRedPacket.getSenduid(), sendPacket);
									WxChatUserItem userItem = ChatIndexService.chatUserIndex(yxUserSendRedPacket.getChatlinkid());
									ret = ChatMsgService.me.afterSendFriendChatMsg(sendMsg, UserService.ME.getById(yxUserSendRedPacket.getSenduid()), userItem.getChatlinkmetaid(),
											null, null, null);
									clearFriendCache(yxUserSendRedPacket.getSenduid(), yxUserSendRedPacket.getSenduid(), yxUserSendRedPacket.getChatlinkid(), null);
								}else {
									//群
									WxGroupMsg sendMsg = GroupService.me.addMsg(yxUserSendRedPacket.getDevicetype(), "",
											"你的红包未在24小时内领取完，已退回钱包", yxUserSendRedPacket.getSenduid(), yxUserSendRedPacket.getSendip(),
											yxUserSendRedPacket.getToid(),Const.ContentType.TEXT ,  Const.YesOrNo.YES, yxUserSendRedPacket.getSenduid(), null, null,null,"",null,null,yxUserSendRedPacket.getAppver());
//									WxGroupMsg sendMsg = GroupService.me.addMsg(yxUserSendRedPacket.getDevicetype(), "", yxUserSendRedPacket.getSendip(), yxUserSendRedPacket.getSenduid(), "", yxUserSendRedPacket.getToid(),Const.ContentType.REDPACKET , Const.YesOrNo.YES,  yxUserSendRedPacket.getSenduid(), null, null,null,"",null,null,yxUserSendRedPacket.getAppver());
									if(sendMsg == null) {
										log.error("发送红包退回私聊消息失败，红包ID：{}", yxUserSendRedPacket.getId());
										return false;
									}
									WxGroupChatNtf sendNtf = WxGroupChatNtf.from(sendMsg,null);
									sendNtf.setRedflag(Const.YesOrNo.YES);
									sendNtf.setChatlinkid(yxUserSendRedPacket.getChatlinkid());
									ImPacket sendPacket = new ImPacket(Command.WxGroupChatNtf, Json.toJson(sendNtf));
									Ims.sendToUser(yxUserSendRedPacket.getSenduid(), sendPacket);
									WxChatUserItem userItem = ChatIndexService.chatUserIndex(yxUserSendRedPacket.getChatlinkid());
									if (userItem != null){
										ChatMsgService.me.afterSendGroupById(sendMsg, null,userItem.getChatlinkmetaid(),null);
									}
									clearGroupCache(yxUserSendRedPacket.getSenduid(), null, yxUserSendRedPacket.getToid());
								}
								return true;
							}
						};
						boolean tx = Db.use(Const.Db.TIO_SITE_MAIN).tx(absAtom);
						log.info("处理过期红包：{},结果：{}",yxUserSendRedPacket.getId(), tx);
					}
				}
			}catch (Exception e){
				e.printStackTrace();
				log.error(e.getMessage(),e);
			}finally {
				end();
			}
		}
	}


	/**
	 * @param uid
	 * @param touid
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
	

	/**
	 * 判断计划任务是否可以开始:true：可以运用；false：不可以
	 * @return
	 * @author xufei
	 */
	private static boolean isStart() {
		boolean ret = false;
		synchronized (RedpacketStatusJob.class) {
			ret = isRunning ? false : (isRunning = true); 
		}
		return ret;
	}
	
	/**
	 * 计划任务结束处理
	 * @author xufei
	 */
	private static void end() {
		synchronized (RedpacketStatusJob.class) {
			isRunning = false;
		}
	}

}
