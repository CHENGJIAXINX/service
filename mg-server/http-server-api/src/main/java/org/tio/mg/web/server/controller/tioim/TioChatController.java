package org.tio.mg.web.server.controller.tioim;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.service.tioim.TioChatService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.RequestVo;
import org.tio.utils.resp.Resp;

/**
 * 会话管理控制器
 */
@RequestPath(value = "/wxchat")
public class TioChatController {

	private static Logger log = LoggerFactory.getLogger(TioChatController.class);

	private TioChatService chatService = TioChatService.me;

	/**
	 * 会话列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "/chatList")
	public Resp chatList(HttpRequest request) throws Exception {
		RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
		if(requestVo == null || requestVo.getUid() == null || requestVo.getUid() < 0){
			return Resp.fail(RetUtils.INVALID_PARAMETER);
		}
		Ret ret = chatService.chatItemList(requestVo);
		if(ret.isFail()) {
			log.error("获取会话列表失败：{}",RetUtils.getRetMsg(ret));
			return Resp.fail(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}

	/**
	 * 会话消息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "/chatMsgList")
	public Resp chatMsgList(HttpRequest request) throws Exception {
		RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
		if(requestVo == null || requestVo.getChatLinkId() == null ){
			return Resp.fail(RetUtils.INVALID_PARAMETER);
		}
		Ret ret = chatService.chatMsgList(requestVo);
		if(ret.isFail()) {
			log.error("获取会话消息失败：{}",RetUtils.getRetMsg(ret));
			return Resp.fail(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}

	/**
	 * 群列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "/groupList")
	public Resp groupList(HttpRequest request) throws Exception {
		RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
		if(requestVo == null || requestVo.getUid() == null || requestVo.getUid() < 0){
			return Resp.fail(RetUtils.INVALID_PARAMETER);
		}
		Ret ret = chatService.groupList(requestVo);
		if(ret.isFail()) {
			log.error("获取群列表失败：{}",RetUtils.getRetMsg(ret));
			return Resp.fail(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}

	/**
	 * 获取好友列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "/friendList")
	public Resp friendList(HttpRequest request) throws Exception {
		RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
		if(requestVo == null || requestVo.getUid() == null || requestVo.getUid() < 0){
			return Resp.fail(RetUtils.INVALID_PARAMETER);
		}
		Ret ret = chatService.friendList(requestVo);
		if(ret.isFail()) {
			log.error("获取好友列表失败：{}",RetUtils.getRetMsg(ret));
			return Resp.fail(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}

	/**
	 * 好友申请列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "/friendApplyList")
	public Resp friendApplyList(HttpRequest request) throws Exception {
		RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
		if(requestVo == null || requestVo.getUid() == null || requestVo.getUid() < 0){
			return Resp.fail(RetUtils.INVALID_PARAMETER);
		}
		Ret ret = chatService.applyList(requestVo);
		if(ret.isFail()) {
			log.error("获取好友列表失败：{}",RetUtils.getRetMsg(ret));
			return Resp.fail(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}

	/**
	 * 好友消息列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "/friendMsgList")
	public Resp friendMsgList(HttpRequest request) throws Exception {
		RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
		if(requestVo == null || requestVo.getUid() == null || requestVo.getToUid() == null){
			return Resp.fail(RetUtils.INVALID_PARAMETER);
		}
		Ret ret = chatService.friendMsgList(requestVo);
		if(ret.isFail()) {
			log.error("获取好友消息列表失败：{}",RetUtils.getRetMsg(ret));
			return Resp.fail(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}


	/**
	 * 群消息列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "/groupMsgList")
	public Resp groupMsgList(HttpRequest request) throws Exception {
		RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
		if(requestVo == null || requestVo.getGroupId() == null){
			return Resp.fail(RetUtils.INVALID_PARAMETER);
		}
		Ret ret = chatService.groupMsgList(requestVo);
		if(ret.isFail()) {
			log.error("获取群消息列表失败：{}",RetUtils.getRetMsg(ret));
			return Resp.fail(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}

	/**
	 * 群信息
	 * @param request
	 * @param groupId
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "/groupInfo")
	public Resp groupInfo(HttpRequest request,Long groupId) throws Exception {
		if(groupId == null){
			return Resp.fail(RetUtils.INVALID_PARAMETER);
		}
		Ret ret = chatService.groupInfo(groupId);
		if(ret.isFail()) {
			log.error("获取群信息失败：{}",RetUtils.getRetMsg(ret));
			return Resp.fail(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkData(ret));
	}

	/**
	 * 群用户列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "/groupUserList")
	public Resp groupUserList(HttpRequest request) throws Exception {
		RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
		if(requestVo == null || requestVo.getGroupId() == null){
			return Resp.fail(RetUtils.INVALID_PARAMETER);
		}
		Ret ret = chatService.groupUserList(requestVo);
		if(ret.isFail()) {
			log.error("获取群用户列表失败：{}",RetUtils.getRetMsg(ret));
			return Resp.fail(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}

}
