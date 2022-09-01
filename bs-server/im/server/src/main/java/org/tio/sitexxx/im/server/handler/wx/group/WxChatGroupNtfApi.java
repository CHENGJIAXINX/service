/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */package org.tio.sitexxx.im.server.handler.wx.group;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.Tio;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.im.common.Command;
import org.tio.sitexxx.im.common.ImPacket;
import org.tio.sitexxx.im.common.bs.wx.group.WxGroupChatNtf;
import org.tio.sitexxx.im.server.Ims;
import org.tio.sitexxx.im.server.TioSiteImServerStarter;
import org.tio.sitexxx.im.server.handler.wx.WxChatApi;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.WxChatGroupItem;
import org.tio.sitexxx.service.model.main.WxChatItems;
import org.tio.sitexxx.service.model.main.WxGroup;
import org.tio.sitexxx.service.model.main.WxGroupMsg;
import org.tio.sitexxx.service.service.chat.ChatIndexService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.wx.SysMsgVo;
import org.tio.utils.Threads;
import org.tio.utils.json.Json;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 群消息通知api
 * @author xufei
 * 2020年12月22日 下午6:06:01
 */
public class WxChatGroupNtfApi {

	private static Logger log = LoggerFactory.getLogger(WxChatGroupNtfApi.class);
	
	public static final WxChatGroupNtfApi me = new WxChatGroupNtfApi();
	
	/**
	 * @param msg
	 * @param sysMsgVo
	 * @param ats
	 * @param group
	 * @param hideItem
	 * @param chatItemList
	 * @param noActGroupChatsFinal
	 * @param noStartMsgGroupChatsFinal
	 * @param user
	 * @author xufei
	 * 2020年12月22日 下午6:12:35
	 */
	public void sendGroupMsg(WxGroupMsg msg,SysMsgVo sysMsgVo,String ats,WxGroup group,
			List<WxChatItems> chatItemList,
			List<WxChatGroupItem> noActGroupChatsFinal,
			List<WxChatGroupItem> noStartMsgGroupChatsFinal,String operData,
			User user
			) {
		int notActSize = chatItemList != null ? chatItemList.size() : 0;
		long groupid = group.getId();
		WxGroupChatNtf wxGroupChatNtf = WxGroupChatNtf.from(msg,sysMsgVo);
		if(StrUtil.isNotBlank(ats)) {
			if(ats.equals("all")) {
				wxGroupChatNtf.setAt(ats);
			} else {
				wxGroupChatNtf.setAt("," + ats + ",");
			}
		}
		wxGroupChatNtf.setOperbizdata(operData);
		ImPacket imPacket = new ImPacket(Command.WxGroupChatNtf, wxGroupChatNtf);
		Ims.sendToGroup(groupid, imPacket);
		if(notActSize < 1000) {
			if(CollectionUtil.isNotEmpty(chatItemList)) {
				WxGroupChatNtf actNtf = WxGroupChatNtf.from(msg,sysMsgVo);
				actNtf.setActflag(Const.YesOrNo.YES);
				if(StrUtil.isNotBlank(ats)) {
					if(ats.equals("all")) {
						actNtf.setAt(ats);
					} else {
						actNtf.setAt("," + ats + ",");
					}
				}
				actNtf.setActname(group.getName());
				actNtf.setJoinnum(group.getJoinnum());
				actNtf.setActavatar(group.getAvatar());
				for(WxChatItems chatItems : chatItemList) {
					String otheruid = chatItems.getUid() + "";
					actNtf.setGrouprole(chatItems.getBizrole());
					ImPacket otherPacket = new ImPacket(Command.WxGroupChatNtf, Json.toJson(actNtf));
					Ims.sendToUser(chatItems.getUid(), otherPacket); 
					Tio.bindGroup(TioSiteImServerStarter.serverTioConfigWs, otheruid, groupid + "");
				}
			}
		} else {
			//消息处理-超过1000个会话未激活，一般都是脚本执行的，情况很少，不做事务处理，未来如果出现此业务，可以进行逻辑优化
			Threads.getGroupExecutor().execute(new Runnable() {
				@Override
				public void run() {
					try {
						//首次接受或者发送消息处理
						if(CollectionUtil.isNotEmpty(noStartMsgGroupChatsFinal)) {
							ChatIndexService.me.chatGroupStartMsgUpdate(groupid, msg.getId());
							for(WxChatGroupItem groupItem : noStartMsgGroupChatsFinal) {
								ChatIndexService.removeChatGroupCache(groupid, groupItem.getUid());
							}
						}
						//激活消息处理
						Ret ret = WxChatApi.dealGroupAct(noActGroupChatsFinal, group, msg, user);
						if(ret.isFail()) {
							log.error(ret.getStr("msg"));
						}
						List<WxChatItems> chatItemList = RetUtils.getOkTData(ret);
						if(CollectionUtil.isNotEmpty(chatItemList)) {
							WxGroupChatNtf actNtf = WxGroupChatNtf.from(msg,sysMsgVo);
							actNtf.setActflag(Const.YesOrNo.YES);
							actNtf.setActname(group.getName());
							actNtf.setJoinnum(group.getJoinnum());
							if(StrUtil.isNotBlank(ats)) {
								actNtf.setAt("," + ats + ",");
							}
							actNtf.setActavatar(group.getAvatar());
							for(WxChatItems chatItems : chatItemList) {
								String otheruid = chatItems.getUid() + "";
								actNtf.setGrouprole(chatItems.getBizrole());
								ImPacket otherPacket = new ImPacket(Command.WxGroupChatNtf, Json.toJson(actNtf));
								Ims.sendToUser(chatItems.getUid(), otherPacket); 
								Tio.bindGroup(TioSiteImServerStarter.serverTioConfigWs, otheruid, groupid + "");
							}
						}
					} catch (Exception e) {
						log.error("", e);
					}
				}
			});
		}
	}
}
