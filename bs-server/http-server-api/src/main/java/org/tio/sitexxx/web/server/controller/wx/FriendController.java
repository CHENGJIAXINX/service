/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.wx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.im.server.handler.wx.WxChatApi;
import org.tio.sitexxx.im.server.handler.wx.WxSynApi;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.WxChatItems;
import org.tio.sitexxx.service.model.main.WxFriend;
import org.tio.sitexxx.service.service.chat.ChatService;
import org.tio.sitexxx.service.service.chat.FriendService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 好友相关接口
 * @author xufei
 * 2021年1月7日 下午6:26:37
 */
@RequestPath(value = "/friend")
public class FriendController {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(FriendController.class);

	/**
	 * 修改好友备注名-已调整
	 * @param request
	 * @param frienduid
	 * @param remarkname
	 * @return
	 */
	@RequestPath(value = "/modifyRemarkname")
	public Resp modifyRemarkname(HttpRequest request, Integer frienduid, String remarkname) {
		User curr = WebUtils.currUser(request);
		if(StrUtil.isNotBlank(remarkname)) {
//			remarkname = EscapeUtil.escapeHtml4(remarkname);
		} else {
			remarkname = "";
		}
		Ret ret = FriendService.me.updateRemarkName(curr.getId(), frienduid, remarkname);
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		Long fid = RetUtils.getOkTData(ret);
		if(WxSynApi.isSynVersion()) {
			WxSynApi.synFdRemarkName(curr.getId(), fid, remarkname, RetUtils.getOkTData(ret, "chatlinkid"));
		} else {
			WxFriend sendFreind = FriendService.me.getFriendInfo(fid);
			WxChatItems chatItems = ChatService.me.getAllChatItems(RetUtils.getOkTData(ret, "chatlinkid"));
			WxChatApi.autoUseSysChatNtf(curr.getId(), Const.WxSysCode.FRIEND_INFO_UPDATE,"好友信息发生变更", Json.toJson(sendFreind),chatItems);
		}
		return Resp.ok(RetUtils.OPER_RIGHT);
	}
}
