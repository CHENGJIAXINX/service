/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server.handler.wx.group;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.sitexxx.im.common.Command;
import org.tio.sitexxx.im.common.CommandHandler;
import org.tio.sitexxx.im.common.ImPacket;
import org.tio.sitexxx.im.common.bs.wx.group.WxGroupMsgReq;
import org.tio.sitexxx.im.common.bs.wx.group.WxGroupMsgResp;
import org.tio.sitexxx.im.server.Ims;
import org.tio.sitexxx.im.server.handler.AbsImServerHandler;
import org.tio.sitexxx.im.server.handler.wx.WxChatApi;
import org.tio.sitexxx.service.model.main.*;
import org.tio.sitexxx.service.service.chat.*;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.AppCode;
import org.tio.sitexxx.service.vo.SimpleUser;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

/**
 * 群聊的聊天消息请求，WxGroupMsgReq-- Client-->Server
 * 
 * @author xufei
 * 2020年3月10日 下午3:14:44
 */
@CommandHandler(Command.WxGroupMsgReq)
public class WxGroupMsgReqHandler extends AbsImServerHandler {

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(WxGroupMsgReqHandler.class);

	public static final WxGroupMsgReqHandler me = new WxGroupMsgReqHandler();

	public WxGroupMsgReqHandler() {
	}

	@Override
	public void handler(ImPacket packet, ChannelContext channelContext, boolean isWebsocket, User curr, SimpleUser currSimpleUser) throws Exception {
		WxGroupMsgReq msgReq = Json.toBean(packet.getBodyStr(), WxGroupMsgReq.class);
		Long chatlinkid = msgReq.getChatlinkid();
		Long startmid = msgReq.getStartmid();
		Long endmid = msgReq.getEndmid();
		WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(curr.getId(), Math.abs(chatlinkid));
		if(groupItem == null || groupItem.getChatlinkid() == null) {
			WxChatApi.sendFriendErrorMsg(channelContext,curr.getId(),curr.getId(), curr.getId(),chatlinkid, AppCode.GroupErrorCode.SYS_ERROR, "会话为空");
			return;
		}
		chatlinkid = groupItem.getChatlinkid();
		Ret ret = ChatMsgService.me.groupMsgList(chatlinkid, curr.getId(), startmid,endmid);
		if(ret.isFail()) {
			WxChatApi.sendFriendErrorMsg(channelContext,curr.getId(),curr.getId(), curr.getId(), -groupItem.getGroupid(), AppCode.GroupErrorCode.SYS_ERROR, RetUtils.getRetMsg(ret));
			return;
		}
		List<WxGroupMsg> list = RetUtils.getOkTData(ret);
//		if (ConfService.getInt("im.show.friend.remark", 1) == 1){
//			for (WxGroupMsg wxGroupMsg : list){
//				WxChatUserItem fd = ChatIndexService.fdUserIndex(curr.getId(), wxGroupMsg.getUid());
//				if (ChatService.existFriend(fd)){
//					WxFriend friend = FriendService.me.getFriendInfo(fd.getLinkid());
//					if(friend != null && StrUtil.isNotBlank(friend.getRemarkname())) {
//						wxGroupMsg.setFriendRemark(friend.getRemarkname());
//					}
//				}
//			}
//		}

		WxGroupMsgResp msgResp = new WxGroupMsgResp();
		msgResp.setData(list);
		if(list.size() < ConfService.getInt("im.history.chat.count.group", GroupService.GROUP_MSG_LIMIT)) {
			msgResp.setLastPage(true);
		}
		msgResp.setChatlinkid(-groupItem.getGroupid());
		ImPacket imPacket = new ImPacket(Command.WxGroupMsgResp, msgResp);
		Ims.send(channelContext, imPacket); 
	}
}
