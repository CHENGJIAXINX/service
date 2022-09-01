/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.controller.wx;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.Tio;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.UploadFile;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.ActiveRecordException;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.sitexxx.im.common.Command;
import org.tio.sitexxx.im.common.ImPacket;
import org.tio.sitexxx.im.common.bs.wx.friend.WxUserOperNtf;
import org.tio.sitexxx.im.common.bs.wx.group.WxGroupOperNtf;
import org.tio.sitexxx.im.server.Ims;
import org.tio.sitexxx.im.server.TioSiteImServerStarter;
import org.tio.sitexxx.im.server.handler.wx.WxChatApi;
import org.tio.sitexxx.im.server.handler.wx.WxSynApi;
import org.tio.sitexxx.service.cache.CacheConfig;
import org.tio.sitexxx.service.cache.Caches;
import org.tio.sitexxx.service.model.main.*;
import org.tio.sitexxx.service.model.stat.GroupStat;
import org.tio.sitexxx.service.service.ImgService;
import org.tio.sitexxx.service.service.VideoService;
import org.tio.sitexxx.service.service.base.IpInfoService;
import org.tio.sitexxx.service.service.base.UserRoleService;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.base.UserVipLevelService;
import org.tio.sitexxx.service.service.chat.*;
import org.tio.sitexxx.service.service.chat.ChatMsgService.MsgTemplate;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.utils.PeriodUtils;
import org.tio.sitexxx.servicecommon.vo.AppCode;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.Devicetype;
import org.tio.sitexxx.servicecommon.vo.MulLauUtils;
import org.tio.sitexxx.servicecommon.vo.wx.SynRecordVo;
import org.tio.sitexxx.servicecommon.vo.wx.SysMsgVo;
import org.tio.sitexxx.servicecommon.vo.wx.WxForbiddenVo;
import org.tio.sitexxx.web.server.utils.*;
import org.tio.utils.Threads;
import org.tio.utils.cache.CacheUtils;
import org.tio.utils.cache.FirsthandCreater;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

import java.awt.image.BufferedImage;
import java.util.*;

/**
 * 新版聊天短链接入口
 * @author xufei
 * 2020年1月6日 下午7:41:13
 */
@RequestPath(value = "/chat")
public class ChatController {
	
	private static Logger log = LoggerFactory.getLogger(ChatController.class);
	
	private final static FriendService friendService = FriendService.me;
	
	private final static ChatService chatService = ChatService.me;
	
	private final static GroupService groupService = GroupService.me;
	
	/**********************************************begin-query**************************************************/
	
	/**
	 * 会话列表请求-此处未进行缓存处理，尽量不要频繁刷新该请求-已调整
	 * @param request
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年1月21日 下午5:11:45
	 */
	@RequestPath(value = "/list")
	public Resp list(HttpRequest request) throws Exception {
		User curr = WebUtils.currUser(request);
		Byte devicetype = WebUtils.getRequestExt(request).getDeviceType();
		Ret ret = chatService.chatItemList(curr,devicetype);
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkList(ret));
	}
	
	/**
	 * 会话信息-已废弃-转换为长链接-已调整
	 * @param request
	 * @param chatlinkid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月25日 下午4:52:08
	 */
	@Deprecated
	@RequestPath(value = "/chatInfo")
	public Resp chatInfo(HttpRequest request,Long chatlinkid) throws Exception {
		User curr = WebUtils.currUser(request);
		if(chatlinkid == null) {
			return Resp.fail("会话id参数为空");
		}
		if(chatlinkid <= 0) {
			//处理群的chatlinkid
			WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(curr.getId(), -chatlinkid);
			if(groupItem == null || groupItem.getChatlinkid() == null) {
				return Resp.fail("会话id为空");
			}
			chatlinkid = groupItem.getChatlinkid();
		}
		/**
		 * 此处没有缓存,后续根据数据变更频率，可以替换成getBaseInfo
		 */
		WxChatItems chatItems = chatService.getBaseChatItems(chatlinkid);
		if(chatItems == null) {
			return Resp.fail("会话不存在");
		}
		if(!Objects.equals(curr.getId(), chatItems.getUid())) {
			log.error("异常登录请求会话信息：登录uid：{}，请求会话的uid：{}",curr.getId(),chatItems.getUid());
			return Resp.fail(RetUtils.GRANT_ERROR);
		}
		return Resp.ok(chatItems);
	}
	
	/**
	 * 群信息-5分钟缓存-已调整
	 * 
	 * @param request
	 * @param groupid
	 * @param userflag,用户标识-1:获取用户的群用户信息
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年12月22日 下午2:50:32
	 */
	@RequestPath(value = "/group")
	public Resp group(HttpRequest request,Long groupid,Byte userflag) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = groupService.groupInfo(groupid, Objects.equals(userflag, Const.YesOrNo.YES) ? curr.getId() :null);
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(ret);
	}

	@RequestPath(value = "/updateGroupAvatar/{groupId}")
	public Resp updateGroupAvatar(HttpRequest request, String groupId, UploadFile uploadFile){
		if (uploadFile == null) {
			return Resp.fail("上传信息为空");
		}
		User curr = WebUtils.currUser(request);
		if (curr == null) {
			return Resp.fail("您尚未登录或登录超时").code(AppCode.ForbidOper.NOTLOGIN);
		}

		WxGroupUser groupUser = GroupService.me.getGroupUser(curr.getId(), Long.parseLong(groupId));
		if (groupUser.getGrouprole() != 1 && groupUser.getGrouprole() != 3){
			return Resp.fail("权限不足");
		}

		byte[] imageBytes = uploadFile.getData();

		if (UserService.isSuper(curr) || UserRoleService.hasRole(curr, Role.UPLOAD_VIDEO)) {

		} else {
			int maxsize = ConfService.getInt("user.upload.avatar.maxsize", 2048);

			if (imageBytes.length > 1024 * maxsize) {
				return Resp.fail("文件尺寸太大");
			}
		}
		Img img = null;
		try {
			img = ImgUtils.processImg(Const.UPLOAD_DIR.USER_AVATAR, curr.getId(), uploadFile, 1);
		} catch (Exception e) {
			e.printStackTrace();
			return Resp.fail(e.getMessage());
		}

		img.setComefrom(Img.ComeFrom.MODIFY_AVATAR);

		img.setStatus((byte) 1);
		img.setSession(request.getHttpSession().getId());

		boolean f = ImgService.me.save(img);
		if (!f){
			return Resp.fail("保存失败");
		}
		Ret ret = groupService.modifyAvatar(Long.parseLong(groupId), img.getUrl(), false);

		Img finalImg = img;
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					Ret ret = WxChatApi.updateGroupInfoAvatar(request, curr, Long.parseLong(groupId), finalImg.getUrl());
					if(ret.isFail()) {
						log.error(RetUtils.getRetMsg(ret));
					}
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});

		return ret.isOk()?Resp.ok():Resp.fail();
	}
	
	/**
	 * 是否是好友-已调整
	 * @param request
	 * @param touid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月5日 上午10:52:25
	 */
	@RequestPath(value = "/isFriend")
	public Resp isFriend(HttpRequest request,Integer touid) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = friendService.isFriend(curr, touid);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkData(ret));
	}
	
	/**
	 * 好友的申请列表-已调整
	 * @param request
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月4日 下午4:30:55
	 */
	@RequestPath(value = "/applyList")
	public Resp applyList(HttpRequest request) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = FriendApplyService.me.applyList(curr.getId());
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkList(ret));
	}
	
	/**
	 * 用户的被邀请好友的条数-已调整
	 * @param request
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月4日 下午4:37:08
	 */
	@RequestPath(value = "/applyData")
	public Resp applyData(HttpRequest request) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = FriendApplyService.me.applyData(curr.getId());
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkData(ret));
	}
	
	/**
	 * 申请信息-已调整
	 * @param request
	 * @param applyid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月25日 下午9:24:00
	 */
	@RequestPath(value = "/applyInfo")
	public Resp applyInfo(HttpRequest request,Integer applyid) throws Exception {
		Ret ret = FriendApplyService.me.applyInfo(applyid);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		Record record = RetUtils.getOkTData(ret);
		if(record == null) {
			return Resp.fail().msg("申请记录不存在");
		}
		return Resp.ok(record);
	}
	
	/**
	 * 通讯录-无参数缓存-已调整
	 * @param request
	 * @param mode
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月4日 下午2:07:14
	 */
	@RequestPath(value = "/mailList")
	public Resp mailList(HttpRequest request,Byte mode,String searchkey,Integer pageNumber) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = chatService.mailList(curr,mode,searchkey,pageNumber);
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkData(ret));
	}
	
	/**
	 * 获取群可邀请的好友列表-已调整
	 * @param request
	 * @param searchkey
	 * @param groupid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月20日 下午11:33:54
	 */
	@RequestPath(value = "/applyGroupFdList")
	public Resp applyGroupFdList(HttpRequest request,String searchkey,Long groupid) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = friendService.getOutGroupFdList(curr, searchkey, groupid);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkData(ret));
	}
	
	
	/**
	 * @param request
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2021年1月5日 上午10:08:58
	 */
	@RequestPath(value = "/forbidden")
	public Resp forbidden(HttpRequest request,WxForbiddenVo forbiddenVo) throws Exception {
		User curr = WebUtils.currUser(request);
		if(forbiddenVo == null || forbiddenVo.checkIsNull()) {
			return Resp.fail(RetUtils.INVALID_PARAMETER);
		}
		Ret ret = groupService.forbidden(forbiddenVo, curr.getId());
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}

		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					WxChatApi.sendTimeTipMsg(forbiddenVo.getGroupid(), null, curr.getId());
					if(Objects.equals(forbiddenVo.getMode(), WxForbiddenVo.Mode.ALL)) {
						String groupText = MulLauUtils.getMsg("本群已禁言");
						if(Objects.equals(forbiddenVo.getOper(), WxForbiddenVo.Oper.CANCEL)) {
							groupText = MulLauUtils.getMsg("本群已解除禁言");
						}
						WxChatApi.sendGroupMsgEach(request, groupText, Const.ContentType.TEXT, curr.getId(), forbiddenVo.getGroupid(), Const.YesOrNo.YES,null);
					} else {
						User user = UserService.ME.getById(forbiddenVo.getUid());
						SysMsgVo sysMsgVo = new SysMsgVo(curr.getNick(), MsgTemplate.cancelforbidden, user.getNick(),"cancelforbidden");
						if(!Objects.equals(forbiddenVo.getOper(), WxForbiddenVo.Oper.CANCEL)) {
							sysMsgVo = new SysMsgVo(curr.getNick(), MsgTemplate.forbidden, user.getNick(),"forbidden");
						}
						WxChatApi.sendGroupMsgEach(request, sysMsgVo.toText(), Const.ContentType.TEXT, curr.getId(), forbiddenVo.getGroupid(), Const.YesOrNo.YES,sysMsgVo);
					}
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok();
	}

	/**
	 *
	 * @param request
	 * @param groupId
	 * @param flag 2：取消管理员 3：设为管理员
	 * @return
	 */
	@RequestPath(value = "/setGroupManager")
	public Resp groupManager(HttpRequest request, Integer toUid, Integer groupId, Integer flag){
		User curr = WebUtils.currUser(request);
		if (curr == null){
			return Resp.fail("用户未登录或登录超时");
		}
		if (toUid == null || groupId == null || flag == null){
			return Resp.fail("缺少参数");
		}
		if (flag <2 || flag > 3){
			return Resp.fail("参数不合法");
		}
		Ret ret = groupService.groupManager(curr.getId(), toUid, groupId, flag);
		if (ret.isFail()){
			return Resp.fail(RetUtils.getRetMsg(ret));
		}
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					User user = UserService.ME.getById(toUid);
					WxChatApi.sendTimeTipMsg(groupId.longValue(), null, curr.getId());
					SysMsgVo sysMsgVo = new SysMsgVo(curr.getNick(), flag.byteValue() == 3 ? MsgTemplate.setmanager:MsgTemplate.canclemanager, user.getNick(),flag.byteValue() == 3 ? "setManager":"cancleManager");
					WxChatApi.sendGroupMsgEach(request, sysMsgVo.toText(), Const.ContentType.TEXT, curr.getId(), groupId.longValue(), Const.YesOrNo.YES,sysMsgVo, String.valueOf(toUid));
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok(MulLauUtils.getMsg("操作成功"));
	}

	
	/**
	 * 群用户针对当前用户的状态，该接口为了扩展，命名不符合规范
	 * 1、grant：管理员权限：ture:是；
	 * 2、rolegrant:角色管理权限
	 * @param request
	 * @param uid
	 * @param groupid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2021年1月6日 上午11:39:44
	 */
	@RequestPath(value = "/forbiddenFlag")
	public Resp forbiddenFlag(HttpRequest request,Integer uid,Long groupid) throws Exception {
		User curr = WebUtils.currUser(request);
		Map<String, String> flagMap = new HashMap<String, String>();
		flagMap.put("grant", Const.YesOrNo.NO + "");
		flagMap.put("rolegrant", Const.YesOrNo.NO + "");	
		flagMap.put("kickgrant", Const.YesOrNo.NO + "");	
		if(Objects.equals(uid, curr.getId())) {
			return Resp.ok(flagMap);
		}
		WxGroup group = GroupService.me.getByGroupid(groupid);
		if(group == null) {
			return Resp.ok(flagMap);
		}
		WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(curr.getId(), groupid);
		if(!ChatService.groupChatLink(groupItem)) {
			return Resp.ok(flagMap);
		}
		WxGroupUser groupUser = GroupService.me.getGroupUser(groupItem.getGpulinkid());
		if(Objects.equals(groupUser.getGrouprole(), Const.GroupRole.MEMBER)) {
			return Resp.ok(flagMap);
		}
		WxChatGroupItem toGroupItem = ChatIndexService.chatGroupIndex(uid, groupid);
		if(!ChatService.groupChatLink(toGroupItem)) {
			return Resp.ok(flagMap);
		}
		WxGroupUser toGroupUser = GroupService.me.getGroupUser(toGroupItem.getGpulinkid());
		if(Objects.equals(groupUser.getGrouprole(), Const.GroupRole.OWNER)) {
			flagMap.put("grouprole", toGroupUser.getGrouprole() + "");
			flagMap.put("rolegrant", Const.YesOrNo.YES + "");	
		} else {
			if(!Objects.equals(toGroupUser.getGrouprole(), Const.GroupRole.MEMBER)) {
				return Resp.ok(flagMap);
			}
		}
		flagMap.put("grant", Const.YesOrNo.YES + "");
		flagMap.put("flag", toGroupUser.getForbiddenflag() + "");
		flagMap.put("kickgrant", Const.YesOrNo.YES + "");	
		return Resp.ok(flagMap);
	}
	
	
	/**
	 * 群用户列表-已调整
	 * 1、精准查询无缓存
	 * 2、无条件查询存在缓存
	 * @param request
	 * @param groupid
	 * @param pageNumber
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年4月7日 下午3:17:36
	 */
	@RequestPath(value = "/groupUserList")
	public Resp groupUserList(HttpRequest request,Long groupid,Integer pageNumber,String searchkey) throws Exception {
		Ret ret = groupService.groupUserList(groupid, pageNumber,searchkey);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}
	
	/**
	 * 禁言用户列表
	 * @param request
	 * @param groupid
	 * @param pageNumber
	 * @param searchkey
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2021年1月5日 上午11:49:07
	 */
	@RequestPath(value = "/forbiddenUserList")
	public Resp forbiddenUserList(HttpRequest request,Long groupid,Integer pageNumber,String searchkey) throws Exception {
		Ret ret = groupService.forbiddenUserList(groupid, pageNumber,searchkey);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkPage(ret));
	}
	
	/**
	 * at使用的群用户列表-暂时没有算法处理-已调整
	 * @param request
	 * @param groupid
	 * @param searchkey
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年4月7日 下午5:55:13
	 */
	@RequestPath(value = "/atGroupUserList")
	public Resp atGroupUserList(HttpRequest request,Long groupid,String searchkey) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = groupService.atGroupUserList(groupid,searchkey,curr.getId());
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkList(ret));
	}
	
	/**
	 * 私聊的消息-已转长链接处理
	 * 
	 * @param request
	 * @param uid
	 * @param chatlinkid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月1日 下午7:30:38
	 */
	@Deprecated
	@RequestPath(value = "/p2pMsgList")
	public Resp p2pMsgList(HttpRequest request,Integer uid,Long chatlinkid,Long startmid) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = ChatMsgService.me.p2pMsgList(chatlinkid, curr.getId(),startmid,null);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkData(ret));
	}
	
	/**
	 * 群聊消息-已转长链接处理
	 * @param request
	 * @param chatlinkid
	 * @param startmid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月13日 下午9:56:14
	 */
	@Deprecated
	@RequestPath(value = "/groupMsgList")
	public Resp groupMsgList(HttpRequest request,Long chatlinkid,Long startmid) throws Exception {
		User curr = WebUtils.currUser(request);
		//处理群的chatlinkid
		WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(curr.getId(), Math.abs(chatlinkid));
		if(groupItem == null || groupItem.getChatlinkid() == null) {
			return Resp.fail("会话为空");
		}
		chatlinkid = groupItem.getChatlinkid();
		Ret ret = ChatMsgService.me.groupMsgList(chatlinkid, curr.getId(), startmid,null);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkData(ret));
	}
	/************************************************end-query**************************************************/
	
	/**********************************************begin-oper**************************************************/
	
	/**
	 * 进群-异步触发（名片和其它申请的不可异步） - 已调整
	 * @param request
	 * @param uids
	 * @param groupid
	 * @param applyuid 群名片的实际用户
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年12月22日 下午4:10:55
	 */
	@RequestPath(value = "/joinGroup")
	public Resp joinGroup(HttpRequest request,String uids,Long groupid,Integer applyuid) throws Exception {
		User curr = WebUtils.currUser(request);
		WxGroup group = groupService.getByGroupid(groupid);
		WxGroupUser groupUser = groupService.getGroupUser(curr.getId(), groupid);
		if(applyuid != null) {
			Byte devicetype = WebUtils.getRequestExt(request).getDeviceType();
			WxGroupUser applyUser = groupService.getGroupUser(applyuid, groupid);
			if (group.getJoinmode() == 1 && applyUser.getGrouprole() == 2){
				//需要审核
				if (uids.startsWith(",")){
					uids = uids.substring(1);
				}
				String userIdStr = uids.split(",")[0];
				User byId = UserService.ME.getById(userIdStr);
				Ret ret = groupService.joinGroupApply(UserService.ME.getById(applyuid), groupid, uids, byId.getNick()+(uids.split(",").length > 1 ?("等"+uids.split(",").length+"人"):"")+"申请进群");
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				//消息触发
				Threads.getGroupExecutor().execute(new Runnable() {
					@Override
					public void run() {
						try {
							WxGroupApply apply = RetUtils.getOkTData(ret, "apply");
							Integer count = RetUtils.getOkTData(ret);
							WxGroup group = RetUtils.getOkTData(ret, "group");
							Ret ret = WxChatApi.joinGroupApply(request, UserService.ME.getById(applyuid), group, count, apply);
							if(ret.isFail()) {
								log.error(RetUtils.getRetMsg(ret));
							}
						} catch (Exception e) {
							log.error("", e);
						}
					}
				});
				return Resp.ok("已发送申请，等待审核");

			}else {
				Ret ret = groupService.joinGroup(curr, groupid, uids,applyuid);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				Short joinnum = RetUtils.getOkTData(ret, "joinnum");
				Byte nameUpdate = RetUtils.getOkTData(ret, "nameupdate");
				if(joinnum != 0) {
					User msgUser = UserService.ME.getById(applyuid);
					boolean auot = auotUpdateGroupInfo(request,devicetype,groupid, nameUpdate, joinnum, msgUser);
					WxChatApi.joinGroup(request,msgUser,groupid,uids, RetUtils.getOkTData(ret),RetUtils.getOkTData(ret, "rebind"),auot);
				}
			}
		} else {
			if (group.getJoinmode() == 1 && groupUser.getGrouprole() == 2){
				if (uids.startsWith(",")){
					uids = uids.substring(1);
				}
				String userIdStr = uids.split(",")[0];
				User byId = UserService.ME.getById(userIdStr);
				Ret ret = groupService.joinGroupApply(curr, groupid, uids, byId.getNick()+(uids.split(",").length > 1 ?("等"+uids.split(",").length+"人"):"")+"申请进群");
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				//消息触发
				Threads.getGroupExecutor().execute(new Runnable() {
					@Override
					public void run() {
						try {
							WxGroupApply apply = RetUtils.getOkTData(ret, "apply");
							Integer count = RetUtils.getOkTData(ret);
							WxGroup group = RetUtils.getOkTData(ret, "group");
							Ret ret = WxChatApi.joinGroupApply(request, curr, group, count, apply);
							if(ret.isFail()) {
								log.error(RetUtils.getRetMsg(ret));
							}
						} catch (Exception e) {
							log.error("", e);
						}
					}
				});
				return Resp.ok(RetUtils.OPER_RIGHT);
			}

			//异步处理触发
			String finalUids = uids;
			Threads.getGroupExecutor().execute(new Runnable() {
				@Override
				public void run() {
					try {
						if (group == null){
							//群不存在
							return;
						}
						if (group.getJoinmode() == 1 && groupUser.getGrouprole() == 2){
							//邀请需要审核
							Resp resp = joinGroupApply(request, finalUids, groupid, "邀请进群");
							WxChatApi.sendFriendErrorMsg(request,curr.getId(),curr.getId(), curr.getId(), -groupid, AppCode.GroupErrorCode.SYS_ERROR,resp.getMsg());
							return;
						}


						Byte devicetype = WebUtils.getRequestExt(request).getDeviceType();
						Ret ret = groupService.joinGroup(curr, groupid, finalUids,applyuid);
						if(ret.isFail()) {
							WxChatApi.sendFriendErrorMsg(request,curr.getId(),curr.getId(), curr.getId(), -groupid, AppCode.GroupErrorCode.SYS_ERROR, RetUtils.getRetMsg(ret));
							return;
						}
						Short joinnum = RetUtils.getOkTData(ret, "joinnum");
						Byte nameUpdate = RetUtils.getOkTData(ret, "nameupdate");
						if(joinnum != null && joinnum != 0) {
							User msgUser = curr;
							boolean auot = auotUpdateGroupInfo(request,devicetype,groupid, nameUpdate, joinnum, msgUser);
							WxChatApi.joinGroup(request,msgUser,groupid,finalUids, RetUtils.getOkTData(ret),RetUtils.getOkTData(ret, "rebind"),auot);
						}
					} catch (Exception e) {
						log.error("", e);
					}
				}
			});
		}
		return Resp.ok(RetUtils.OPER_RIGHT);
	}

//	@RequestPath(value = "/applyInfo")
//	public Resp applyInfo(HttpRequest request, Integer applyId){
//		User curr = WebUtils.currUser(request);
//		if (curr == null){
//			return Resp.fail("未登录或登录超时");
//		}
//		WxGroupApply apply = WxGroupApply.dao.findById(applyId);
//		List<WxGroupApplyItems> items = WxGroupApplyItems.dao.find("select * from wx_group_apply_items where aid = ?", applyId);
//		Map<String, Object> map = new HashMap<>();
//		map.put("apply", apply);
//		map.put("items", items);
//		return Resp.ok(items);
//	}
	
	
	/**
	 * 邀请用户进群申请
	 * @param request
	 * @param uids
	 * @param groupid
	 * @param applymsg
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2021年1月13日 下午4:07:11
	 */
	@RequestPath(value = "/joinGroupApply")
	public Resp joinGroupApply(HttpRequest request,String uids,Long groupid,String applymsg) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret checkRet = groupService.checkJoinGroup(curr.getId(), groupid,null,null);
		if(checkRet.isOk()) {
			return joinGroup(request, uids, groupid, null);
		}
		Ret ret = groupService.joinGroupApply(curr, groupid, uids, applymsg);
		if(ret.isFail()) {
			return Resp.fail(RetUtils.getRetMsg(ret));
		}
		//消息触发
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					WxGroupApply apply = RetUtils.getOkTData(ret, "apply");
					Integer count = RetUtils.getOkTData(ret);
					WxGroup group = RetUtils.getOkTData(ret, "group");
					Ret ret = WxChatApi.joinGroupApply(request, curr, group, count, apply);
					if(ret.isFail()) {
						log.error(RetUtils.getRetMsg(ret));
					}	
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		
		return Resp.ok(RetUtils.OPER_RIGHT);
	}
	
	/**
	 * 获取群申请信息
	 * @param request
	 * @param aid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2021年1月19日 上午10:07:37
	 */
	@RequestPath(value = "/groupApplyInfo")
	public Resp groupApplyInfo(HttpRequest request,Integer aid) throws Exception {
		Ret ret = groupService.groupApplyInfo(aid);
		if(ret.isFail()) {
			return Resp.fail(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkData(ret));
	}
	
	/**
	 * 处理邀请用户进群申请
	 * @param request
	 * @param aid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2021年1月13日 下午5:42:10
	 */
	@RequestPath(value = "/dealGroupApply")
	public Resp dealGroupApply(HttpRequest request,Integer aid,Long mid) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = groupService.dealGroupApply(curr, aid, mid);
		if(ret.isFail()) {
			return Resp.fail(RetUtils.getRetMsg(ret));
		}
		Byte dealflag = RetUtils.getOkTData(ret);
		if(Objects.equals(dealflag, Const.YesOrNo.NO)) {
			WxGroupApply apply = RetUtils.getOkTData(ret, "apply");
			String uids = RetUtils.getOkTData(ret, "uids");
			return joinGroup(request, uids, apply.getGroupid(), null);
		}
		return Resp.ok(RetUtils.OPER_RIGHT);
	}
	
	/**
	 * 群邀请开关修改-已调整
	 * @param request
	 * @param groupid
	 * @param mode
	 * @return
	 * @author xufei
	 * 2020年3月9日 下午4:32:55
	 */
	@RequestPath(value = "/modifyApply")
	public Resp modifyApply(HttpRequest request, Long groupid, Byte mode) {
		String text = "";
		User curr = WebUtils.currUser(request);
		SysMsgVo sysMsgVo = new SysMsgVo(curr.getNick(),"", "","");
		switch (mode) {
		case Const.YesOrNo.YES:
			text = MsgTemplate.applyopen;
			sysMsgVo.setMsgbody(text);
			sysMsgVo.setMsgkey("applyopen");
			break;
		case Const.YesOrNo.NO:
			text = MsgTemplate.applyclose;
			sysMsgVo.setMsgbody(text);
			sysMsgVo.setMsgkey("applyclose");
			break;
		default:
			return Resp.fail().msg("无效入群方式");
		}
		Ret ret = groupService.modifyApply(curr, groupid, mode);
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		//消息触发
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					WxChatApi.sendTimeTipMsg(groupid, null, curr.getId());
					WxChatApi.sendGroupMsgEach(request, sysMsgVo.toText(), Const.ContentType.TEXT, curr.getId(), groupid,Const.YesOrNo.YES,sysMsgVo);
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok(RetUtils.OPER_RIGHT);
	}
	
	/**
	 * 修改群昵称-已调整
	 * @param request
	 * @param groupid
	 * @param nick
	 * @return
	 * @author xufei
	 * 2020年4月8日 上午11:38:47
	 */
	@RequestPath(value = "/modifyGroupNick")
	public Resp modifyGroupNick(HttpRequest request, Long groupid, String nick) {
		User curr = WebUtils.currUser(request);
		Ret ret = groupService.modifyGroupNick(groupid, nick, curr.getId());
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					WxChatApi.sendTimeTipMsg(groupid, null, curr.getId());
					WxChatApi.synGroupInfo(curr.getId(), groupid, RetUtils.getOkTData(ret));
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok(RetUtils.OPER_RIGHT);
	}

	@RequestPath(value = "/msgContent")
	public Resp msgContent(HttpRequest request, byte chatMode, String msgIds){
		if (StrUtil.isBlank(msgIds)){
			return Resp.fail("消息ID为空");
		}

		return Resp.ok(getMsgListContent(chatMode, msgIds, false));
	}

	private JSONArray getMsgListContent(byte chatMode, String msgIds, boolean simple){
		String key = "msg_query_"+chatMode+msgIds+simple;
		JSONArray result = CacheUtils.get(Caches.getCache(CacheConfig.MSG_QUERY), key, true, new FirsthandCreater<JSONArray>() {
			@Override
			public JSONArray create() {
				JSONArray jsonArray = new JSONArray();
				for (String str : msgIds.split(",")){
					if (Objects.equals(chatMode, Const.ChatMode.P2P)){
						WxFriendMsg byId = WxFriendMsg.dao.findById(Long.parseLong(str));
						if (byId == null){
							continue;
						}
						JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(byId));;
						if (simple){
							jsonObject.remove("c");
							jsonObject.remove("srctext");
							jsonObject.remove("resume");
							jsonObject.remove("session");
						}
						jsonObject = JSONObject.parseObject(JSON.toJSONString(byId));
						User user = UserService.ME.getById(byId.getUid());
						jsonObject.put("avatar", user.getAvatar());
						jsonObject.put("nick", user.getNick());
						jsonArray.add(jsonObject);
					}else {
						WxGroupMsg byId = WxGroupMsg.dao.findById(Long.parseLong(str));
						if (byId == null){
							continue;
						}
						JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(byId));
						if (simple){
							jsonObject.remove("c");
							jsonObject.remove("srctext");
							jsonObject.remove("resume");
							jsonObject.remove("session");
						}
						jsonArray.add(jsonObject);
					}
				}
				return jsonArray;
			}
		});
		return result;
	}

	/**
	 * 转发
	 * @return
	 */
	@RequestPath(value = "/transSend")
	public Resp transSend(HttpRequest request, byte chatMode, String bizid, String msgIds, Long chatlinkid) throws Exception {
		if (StrUtil.isBlank(msgIds)){
			return Resp.fail("消息为空");
		}
		msgIds = msgIds.trim();
		if (msgIds.startsWith(",") || msgIds.endsWith(",")){
			return Resp.fail("消息格式不正确");
		}
		User curr = WebUtils.currUser(request);
		if(chatlinkid <= 0) {
			Ret check = GroupService.checkGroupMsg(-chatlinkid, curr.getId());
			if(check.isFail()) {
				return Resp.fail(RetUtils.getRetMsg(check));
			}
			chatlinkid = RetUtils.getOkTData(check);
		}
		WxChatItems chatItems = chatService.getBaseChatItems(chatlinkid);
		if(chatItems == null) {
			return Resp.fail(RetUtils.INVALID_PARAMETER);
		}
		String title = null;
		JSONObject jsonObject = new JSONObject();
		if(Objects.equals(chatMode, Const.ChatMode.P2P)) {
//			WxChatUserItem touserItem = ChatIndexService.fdUserIndex(chatItems.getBizid().intValue(), chatItems.getUid());
//			if(!ChatService.existTwoFriend(touserItem)) {
//				return Resp.fail("对方不是你的好友");
//			}
			User byId = UserService.ME.getById(bizid);
			if (byId == null){
				return Resp.fail("聊天UID不存在");
			}
			title = byId.getNick()+"与"+curr.getNick()+"的聊天记录";
//			jsonObject.put("toNick", byId.getNick());
//			jsonObject.put("myNick", curr.getNick());
//			jsonObject.put("toUid", byId.getId());
//			jsonObject.put("myUid", curr.getId());
//			jsonObject.put("toAvatar", byId.getAvatar());
//			jsonObject.put("myAvatar", curr.getAvatar());
		}else {
			WxGroup wxGroup = WxGroup.dao.findById(Long.parseLong(bizid));
			if (wxGroup == null){
				return Resp.fail("群不存在");
			}
			title = wxGroup.getName()+"的聊天记录";
		}
		JSONArray msgListContent = getMsgListContent(chatMode, msgIds, true);

		jsonObject.put("fromChatMode", chatMode);
		jsonObject.put("fromBizId", bizid);
		jsonObject.put("msgIds", msgIds);
		jsonObject.put("title", title);
		jsonObject.put("content", msgListContent.size() > 3 ? msgListContent.subList(0, 3): msgListContent);

		String text = jsonObject.toJSONString();
		try {
			if(Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
				WxChatApi.sendTimeTipMsg(null, chatItems.getBizid().intValue(), curr.getId());
				Ret ret = WxChatApi.sendFdMsgEach(request, text, Const.ContentType.TRANS_SEND, chatItems.getUid(), chatItems.getBizid().intValue(),Const.YesOrNo.NO);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			} else {
				WxChatApi.sendTimeTipMsg(chatItems.getBizid(), null, curr.getId());
				Ret ret = WxChatApi.sendGroupMsgEach( request, text, Const.ContentType.TRANS_SEND, chatItems.getUid(), chatItems.getBizid(), Const.YesOrNo.NO,null);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			}
		}catch (ActiveRecordException | MysqlDataTruncation e){
			if (e.getMessage() != null && e.getMessage().contains("Data too long")){
				return Resp.fail("该消息转发次数受限");
			}
			e.printStackTrace();
		}
		return Resp.ok();
	}
	
	/**
	 * TODO-XUFEI-750-主动离开群通知-已调整
	 * 主动离开群
	 * @param request
	 * @param uids
	 * @param groupid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月25日 下午5:49:30
	 */
	@RequestPath(value = "/leaveGroup")
	public Resp leaveGroup(HttpRequest request,Integer uid,Long groupid) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = groupService.leaveGroup(curr, groupid);
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		Byte nameUpdate = RetUtils.getOkTData(ret, "nameupdate");
		Tio.unbindGroup(TioSiteImServerStarter.serverTioConfigWs, curr.getId() + "", groupid + "");
		//自己退群操作
		WxGroupOperNtf leaveNtf = new WxGroupOperNtf();
		leaveNtf.setC("自动退群");
		leaveNtf.setMid(null);
		leaveNtf.setT(System.currentTimeMillis());
		leaveNtf.setUid(curr.getId());
		leaveNtf.setG(groupid);
		leaveNtf.setChatlinkid(-groupid);
		leaveNtf.setOper(Const.WxGroupOper.LEAVE_GROUP);
		ImPacket imPacket = new ImPacket(Command.WxGroupOperNtf, Json.toJson(leaveNtf));
		Ims.sendToUser(curr.getId(), imPacket); 
		//消息触发
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					Byte devicetype = WebUtils.getRequestExt(request).getDeviceType();
					WxChatGroupItem newowner = RetUtils.getOkTData(ret, "owner");
					WxChatGroupItem leave = RetUtils.getOkTData(ret, "leave");
					boolean auto = auotUpdateGroupInfo(request,devicetype,groupid, nameUpdate, (short)-1, curr);
					WxChatApi.leaveGroup(request,curr,leave, newowner,auto);
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok(RetUtils.OPER_RIGHT);
	}
	
	/**
	 * 踢人-已调整
	 * @param request
	 * @param uids
	 * @param groupid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月25日 下午5:57:34
	 */
	@RequestPath(value = "/kickGroup")
	public Resp kickGroup(HttpRequest request,String uids,Long groupid) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = groupService.kickGroup(curr, groupid,uids);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		//踢完人后，删除他所发的所有信息
		String uids2 = uids;
		if (uids.startsWith(",")){
			uids2 = uids.substring(1);
		}else if (uids.endsWith(",")){
			uids2 = uids.substring(0, uids.length() - 1);
		}

		Short joinnum = RetUtils.getOkTData(ret, "joinnum");
		Byte nameUpdate = RetUtils.getOkTData(ret, "nameupdate");
		if(joinnum != 0) {
			//消息触发
			String finalUids = uids2;
			Threads.getGroupExecutor().execute(new Runnable() {
				@Override
				public void run() {
//					List<WxGroupMsg> wxGroupMsgs = WxGroupMsg.dao.find("select * from wx_group_msg where groupid = " + groupid + " and uid in (" + finalUids + ")");
//					if (wxGroupMsgs != null){
////						wxGroupMsgs.forEach(wxGroupMsg -> {
////							wxGroupMsg.delete();
////						});
//						int[] ids = wxGroupMsgs.stream().map(WxGroupMsg::getId).mapToInt(Long::intValue).toArray();
//						System.out.println("要删除的消息ID："+ JSON.toJSONString(ids));
//						WxGroupMsg.dao.deleteByIds(ids);
//					}

					try {
						Byte devicetype = WebUtils.getRequestExt(request).getDeviceType();
						List<WxChatGroupItem> kickGroupItem = RetUtils.getOkTData(ret, "kick");
						String nickStr = RetUtils.getOkTData(ret);
						boolean auot = auotUpdateGroupInfo(request,devicetype,groupid, nameUpdate,joinnum, curr);
						WxChatApi.kickGroup(request,curr,groupid,kickGroupItem,nickStr,auot);
					} catch (Exception e) {
						log.error("", e);
					}
				}
			});
		}
		return Resp.ok(RetUtils.OPER_RIGHT);
	}

	/**
	 * 创建群-已调整
	 * 1、群邀请人数过多只依赖前端控制
	 * 2、群消息不是同步发送的，会出现延迟消息
	 * @param request
	 * @param wxGroup
	 * @param uidList
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月13日 下午5:24:05
	 */
	@RequestPath(value = "/createGroup")
	public Resp createGroup(HttpRequest request, WxGroup wxGroup, String uidList) throws Exception {
		User curr = WebUtils.currUser(request);
		if (Const.MILSERVER){
			System.out.println("vipLevel===>"+curr.getViplevel());
			UserVipLevel userVipLevel = UserVipLevelService.ME.getByLevel(curr.getViplevel());
			if (userVipLevel.getMaxCreateGroup() < 1){
				//临时写法，仅为临时满足需求
				return Resp.fail("建群上限");
			}
		}
		String name = "";
		if(StrUtil.isNotBlank(wxGroup.getName())) {
			name = wxGroup.getName();
			name = name.length() > 30 ? name.substring(0,30) : name;
			wxGroup.setName(name);
			wxGroup.setAutoflag(Const.YesOrNo.NO);
		}
		String[] uidArr = StrUtil.split(uidList, ",");
		Ret imgRet = getGroupImg(uidArr, curr,name);
		Img img = RetUtils.getOkTData(imgRet, "img");
		String nicks = RetUtils.getOkTData(imgRet, "nicks");
		if(StrUtil.isBlank(name)) {
			name = RetUtils.getOkTData(imgRet, "name");
			wxGroup.setName(name);
			wxGroup.setAutoflag(Const.YesOrNo.YES);
		}
		wxGroup.setAvatar(img.getCoverurl());
		Byte devicetype = WebUtils.getRequestExt(request).getDeviceType();
		String sessionid = request.getHttpSession().getId();
		String ip = request.getClientIp();
		short joinnum = uidArr != null ? (short)(uidArr.length + 1) : (short)1;
		wxGroup.setCreatetime(new Date());
		Ret ret = groupService.createGroup(curr, wxGroup,nicks,devicetype,sessionid,ip,joinnum,WebUtils.getRequestExt(request).getAppVersion());
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		//消息触发
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					WxGroupMsg msg = RetUtils.getOkTData(ret,"msg");
					SysMsgVo sysMsgVo = RetUtils.getOkTData(ret, "sysmsgvo");
					//发送自己的群信息
					WxChatApi.creatGroupOwner(request, devicetype, curr, wxGroup, msg,sysMsgVo);
					//其它人的消息触发
					WxChatApi.creatGroup(request,curr, uidList, nicks, wxGroup, msg,sysMsgVo);
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		//统计处理
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					String dayperiod = PeriodUtils.dateToPeriodByType(wxGroup.getCreatetime(), Const.PeriodType.DAY);
					GroupStat groupStat = GroupStat.dao.findFirst("select * from group_stat where dayperiod = ? and type = ?",dayperiod,Const.Status.NORMAL);
					if(groupStat == null) {
						groupStat = new GroupStat();
						groupStat.setAddcount(1);
						groupStat.setDayperiod(dayperiod);
						groupStat.setType(Const.Status.NORMAL);
						groupStat.ignoreSave();
					} else {
						Db.use(Const.Db.TIO_SITE_STAT).update("update group_stat set addcount = addcount + 1 where dayperiod = ? and type = ?",dayperiod,Const.Status.NORMAL);
					}
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok(wxGroup);
	}
	
	/**
	 * 	好友申请-已调整
	 * @param request
	 * @param uid
	 * @param touid
	 * @param greet
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年1月15日 下午5:22:23
	 */
	@RequestPath(value = "/friendApply")
	public Resp friendApply(HttpRequest request,Integer touid,String greet) throws Exception {
		User curr = WebUtils.currUser(request);
		if (Const.MILSERVER){
			UserVipLevel userVipLevel = UserVipLevelService.ME.getByLevel(curr.getViplevel());
			if (userVipLevel.getMaxAddFriend() < 1){
				//临时写法，仅为临时满足需求
				return Resp.fail("好友上限");
			}
		}
		Ret ret = friendService.addApply(curr, touid,greet);
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		WxFriendApplyItems applyItems = RetUtils.getOkTData(ret);
		//发送申请
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					if(WxSynApi.isSynVersion()) {
						WxSynApi.synFriendApply(touid, applyItems, SynRecordVo.SynType.ADD);
					} else {
						WxChatApi.useSysChatNtf(request, touid, Const.WxSysCode.APPLY_REQUEST, curr.getNick()  + " 想要成为你的好友：" + applyItems.getGreet(), applyItems.getId() + "");
					}
					
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok(applyItems);
	}
	
	/**
	 * 	主动加好友-已调整
	 * 不激活聊天列表-也不发送通知
	 * @param request
	 * @param uid
	 * @param touid
	 * @param greet
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年1月15日 下午5:48:55
	 */
	@RequestPath(value = "/addFriend")
	public Resp addFriend(HttpRequest request,Integer touid) throws Exception {
		User curr = WebUtils.currUser(request);
		if (Const.MILSERVER){
			UserVipLevel userVipLevel = UserVipLevelService.ME.getByLevel(curr.getViplevel());
			if (userVipLevel.getMaxAddFriend() < 1){
				//临时写法，仅为临时满足需求
				return Resp.fail("好友上限!");
			}
		}
		Ret ret = friendService.addFriend(curr, touid);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		//消息处理
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					WxFriend friend = RetUtils.getOkTData(ret, "friend");
					WxFriend toFriend = RetUtils.getOkTData(ret,"tofriend");
					WxChatApi.friendChangeAddNtf(request, friend, toFriend);
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok(RetUtils.getOkData(ret));
	}

	public Resp delFriendBothway(HttpRequest request,Integer touid,boolean isManagerDel){
		return null;
	}
	
	/**
	 * 删除好友-已调整
	 * @param request
	 * @param uid
	 * @param touid
	 * @param isManagerDel 1:管理员  2：非管理员
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年1月22日 下午4:23:20
	 */
	@RequestPath(value = "/delFriend")
	public Resp delFriend(HttpRequest request,Integer touid,Integer isManagerDel) throws Exception {
		User curr = WebUtils.currUser(request);
		Integer uid = curr.getId();
		if(Objects.equals(uid, touid)) {
			return Resp.fail("不能删除自己");
		}
		IpInfo ipInfo = IpInfoService.ME.save(request.getClientIp());
		Ret ret = null;
		if(Objects.equals(isManagerDel,1)){
			ret = friendService.delFriendForManager(curr,touid,ipInfo.getId());
		}else {
			ret = friendService.delFriend(curr, touid, ipInfo.getId());
		}

		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		Long chatlinkid = RetUtils.getOkTData(ret,"chatlinkid");
		Long tochatlinkid = RetUtils.getOkTData(ret,"tochatlinkid");
		if(WxSynApi.isSynVersion()) {
			WxSynApi.synFriendDel(uid, touid, chatlinkid, tochatlinkid, RetUtils.getOkTData(ret, "fid"));
		} else {
			if(chatlinkid != null) {
				WxChatApi.userChatOper(request,uid,chatlinkid, Const.WxUserOper.DEL_FRIEND,"删除好友","",null);
			}
			if(tochatlinkid != null) {
				WxChatApi.userChatOper(request,touid,tochatlinkid, Const.WxUserOper.TO_DEL_FRIEND,"被删除好友","",null);
			}
			WxChatApi.friendChangeDelNtf(request, uid,RetUtils.getOkTData(ret, "fid"));
		}
		return Resp.ok(RetUtils.getOkData(ret));
	}
	
	/**
	 * 删除群-已调整
	 * 未进行信息用户处理-TODO:XUFEI
	 * @param request
	 * @param uid
	 * @param groupid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月24日 上午10:28:20
	 */
	@RequestPath(value = "/delGroup")
	public Resp delGroup(HttpRequest request, Integer uid,Long groupid) throws Exception {
		User curr = WebUtils.currUser(request);
		if(!Objects.equals(curr.getId(), uid)) {
			return Resp.fail(RetUtils.LOGIN_ERROR);
		}
		Ret ret = groupService.delGroup(curr, groupid);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		//消息处理
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					WxChatGroupItem groupItem = RetUtils.getOkTData(ret, "groupitem");
					WxGroup group = RetUtils.getOkTData(ret,"group");
					WxGroupUser groupUser = RetUtils.getOkTData(ret,"groupuser");
					WxChatApi.delGroup(request, curr, groupItem, group,groupUser);
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		//统计处理
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					WxGroup group = RetUtils.getOkTData(ret,"group");
					String dayperiod = PeriodUtils.dateToPeriodByType(group.getCreatetime(), Const.PeriodType.DAY);
					GroupStat groupStat = GroupStat.dao.findFirst("select * from group_stat where dayperiod = ? and type = ?",dayperiod,Const.Status.DELETE);
					if(groupStat == null) {
						groupStat = new GroupStat();
						groupStat.setAddcount(1);
						groupStat.setDayperiod(dayperiod);
						groupStat.setType(Const.Status.DELETE);
						groupStat.ignoreSave();
					} else {
						Db.use(Const.Db.TIO_SITE_STAT).update("update group_stat set addcount = addcount + 1 where dayperiod = ? and type = ?",dayperiod,Const.Status.DELETE);
					}
					Db.use(Const.Db.TIO_SITE_STAT).update("update group_stat set addcount = addcount - 1 where dayperiod = ? and type = ?",dayperiod,Const.Status.NORMAL);
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok(RetUtils.okOper());
	}
	
	/**
	 * 转让群-已调整
	 * @param request
	 * @param groupid
	 * @param otherUid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月24日 下午2:33:22
	 */
	@RequestPath(value = "/changeOwner")
	public Resp changeOwner(HttpRequest request, Long groupid,Integer otheruid) throws Exception {
		User curr = WebUtils.currUser(request);
		if(Objects.equals(otheruid, curr.getId())) {
			return Resp.fail().msg("不能对自己操作哦");
		}
		User user = UserService.ME.getById(otheruid);
		if(user == null ) {
			return Resp.fail().msg("无效转让用户");
		}
		Ret ret = groupService.changeOwner(curr.getId(), user.getId(), groupid);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		//消息处理
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					WxChatGroupItem owner = RetUtils.getOkTData(ret, "owner");
					WxChatGroupItem other = RetUtils.getOkTData(ret, "other");
					Byte devicetype = WebUtils.getRequestExt(request).getDeviceType();
					boolean auot = auotUpdateGroupInfo(request,devicetype,groupid, Const.YesOrNo.YES, (short)0, curr);
					WxChatApi.changeOwner(request, curr, owner, other,auot);
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		
		return Resp.ok(RetUtils.okOper());
	}
	
	/**
	 * 操作-已调整
	 * 用户拉黑/删除聊天会话/恢复用户拉黑/清空聊天记录
	 * @param request
	 * @param uid
	 * @param touid
	 * @param oper
	 * @param chatlinkid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年1月19日 下午2:20:38
	 */
	@RequestPath(value = "/oper")
	public Resp oper(HttpRequest request,Integer touid,Byte oper,Long chatlinkid) throws Exception {
		User curr = WebUtils.currUser(request);
		Integer uid = curr.getId();
		//处理群的chatlinkid
		Long group = null;
		Long oldChatLinkid = chatlinkid;
		if(chatlinkid != null && chatlinkid <= 0) {
			group = -chatlinkid;
			WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(curr.getId(), -chatlinkid);
			if(groupItem == null || groupItem.getChatlinkid() == null) {
				return Resp.fail("会话id为空");
			}
			chatlinkid = groupItem.getChatlinkid();
		}
		Ret ret = chatService.chatUserOper(oper,uid, touid, chatlinkid);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		final Long fGroup = group;
		//消息处理
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					WxChatItems chatItems = RetUtils.getOkTData(ret,"chat"); 
					if(Objects.equals(oper, Const.WxUserOper.DEL_ITEM_REACT) || Objects.equals(oper, Const.WxUserOper.HIDE_CHAT)) {
						if(chatItems != null && Objects.equals(chatItems.getChatmode(), Const.ChatMode.GROUP)) {
							Tio.unbindGroup(TioSiteImServerStarter.serverTioConfigWs, uid + "", chatItems.getBizid() + "");
						}
					}
					if(WxSynApi.isSynVersion()) {
						switch (oper) {
						case Const.WxUserOper.BLACK:
							break;
						case Const.WxUserOper.REMOVE_BLACK:
							break;
						case Const.WxUserOper.DEL_ITEM_REACT:
							WxChatItems delChatItems = new WxChatItems();
							delChatItems.setChatlinkid(oldChatLinkid);
							WxSynApi.synChatSession(uid, delChatItems, SynRecordVo.SynType.DEL);
							break;
						case Const.WxUserOper.CLEAR_CHAT_MSG:
							WxSynApi.synMsgClear(uid, oldChatLinkid);
							break;
						case Const.WxUserOper.CHAT_TOP:
							WxChatItems topChatItems = new WxChatItems();
							topChatItems.setChatlinkid(oldChatLinkid);
							topChatItems.setTopflag(Const.YesOrNo.YES);
							topChatItems.setChatuptime(new Date());
							WxSynApi.synChatSession(uid, topChatItems, SynRecordVo.SynType.UPDATE);
							break;
						case Const.WxUserOper.CHAT_CANCEL_TOP:
							WxChatItems cancelTop = new WxChatItems();
							cancelTop.setChatlinkid(oldChatLinkid);
							cancelTop.setTopflag(Const.YesOrNo.NO);
							cancelTop.setChatuptime(new Date());
							WxSynApi.synChatSession(uid, cancelTop, SynRecordVo.SynType.UPDATE);
							break;
						case Const.WxUserOper.HIDE_CHAT:
//							WxChatItems hide = new WxChatItems();
//							hide.setChatlinkid(oldChatLinkid);
//							hide.setViewflag(Const.YesOrNo.NO);
//							hide.setChatuptime(new Date());
//							WxSynApi.synChatSession(uid, hide, SynRecordVo.SynType.UPDATE);
							WxChatItems hidChatItems = new WxChatItems();
							hidChatItems.setChatlinkid(oldChatLinkid);
							WxSynApi.synChatSession(uid, hidChatItems, SynRecordVo.SynType.DEL);
							break;
						}	
					} else {
						String operBizData = "";
						Long chatlinkid = RetUtils.getOkTData(ret, "chatlinkid");
						switch (oper) {
						case Const.WxUserOper.BLACK:
							break;
						case Const.WxUserOper.REMOVE_BLACK:
							if(chatlinkid != null) {
								WxChatItems removeBlack = chatService.getAllChatItems(chatlinkid);
								WxChatApi.userChatOper(request,uid,chatlinkid, oper,"",operBizData,removeBlack);
							}
							break;
						case Const.WxUserOper.CHAT_TOP:
							WxChatItems topChatItems = new WxChatItems();
							topChatItems.setChatlinkid(oldChatLinkid);
							topChatItems.setTopflag(Const.YesOrNo.YES);
							topChatItems.setChatuptime(new Date());
							operBizData = Json.toJson(topChatItems);
							break;
						case Const.WxUserOper.CHAT_CANCEL_TOP:
							WxChatItems cancelTop = new WxChatItems();
							cancelTop.setChatlinkid(oldChatLinkid);
							cancelTop.setTopflag(Const.YesOrNo.NO);
							cancelTop.setChatuptime(new Date());
							operBizData = Json.toJson(cancelTop);
							break;
						}	
						if(Objects.equals(oper, Const.WxUserOper.HIDE_CHAT)) {
							WxChatApi.userChatOper(request,uid,fGroup == null ? RetUtils.getOkTData(ret, "chatlinkid") : -fGroup, Const.WxUserOper.DEL_ITEM_REACT,"",operBizData,null);
						} else {
							WxChatApi.userChatOper(request,uid,fGroup == null ? RetUtils.getOkTData(ret, "chatlinkid") : -fGroup, oper,"",operBizData,null);
						}
					}
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		
		return Resp.ok(RetUtils.getOkData(ret));
	}
	
	/**
	 * 打开聊天界面
	 * 如果是激活操作，发送通知
	 * @param request
	 * @param uid
	 * @param touid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年1月20日 下午4:53:34
	 */
	@RequestPath(value = "/actChat")
	public Resp actChat(HttpRequest request,Integer touid,Long groupid) throws Exception {
		User curr = WebUtils.currUser(request);
		Integer uid = curr.getId();
		Ret ret = null;
		if(groupid == null) {
			if(touid == null) {
				return Resp.fail(RetUtils.INVALID_PARAMETER);
			}
			ret = chatService.actFdChatItems(uid, touid);
		} else {
			ret = chatService.actGroupChatItems(groupid, uid);
		}
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		Byte act = RetUtils.getOkTData(ret, "actflag");
		Ret sendRet = ret;
		if(act != null && Objects.equals(act, Const.YesOrNo.YES)) {//发送激活通知
			//消息处理
			Threads.getGroupExecutor().execute(new Runnable() {
				@Override
				public void run() {
					try {
						WxChatItems chatItems = RetUtils.getOkTData(sendRet,"chat");
						if(WxSynApi.isSynVersion()) {
							WxSynApi.synChatSession(uid, chatItems, SynRecordVo.SynType.ADD);
						} else {
							WxChatApi.userActOper(request,uid,chatItems);
						}
					} catch (Exception e) {
						log.error("", e);
					}
				}
			});
			
		}
		return Resp.ok(ret);
	}
	
	/**
	 * 	处理申请-已调整
	 * @param request
	 * @param applyid
	 * @param remarkname
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年1月15日 下午5:55:41
	 */
	@RequestPath(value = "/dealApply")
	public Resp dealApply(HttpRequest request,Integer applyid,String remarkname) throws Exception {
		User curr = WebUtils.currUser(request);
		WxFriendApplyItems items = FriendApplyService.me.getById(applyid);
		if(items == null) {
			return Resp.fail(RetUtils.NOT_EXIST);
		}
		Ret ret = friendService.dealApply(curr, items, remarkname);
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		//消息处理
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					Integer uid = items.getFromuid();
					Integer touid = items.getTouid();
					String send = RetUtils.retKey(ret, "send");
					if(StrUtil.isNotBlank(send)) {
						String greet = RetUtils.retKey(ret, "greet");
						//操作者的聊天列表
						Long tochatlinkid = RetUtils.retLongKey(ret, "tochatlinkid");
						if(send.equals("double")) {
							boolean applysigle = RetUtils.getOkTData(ret, "applysigle");
							//申请者的聊天列表
							Long chatlinkid = RetUtils.retLongKey(ret, "chatlinkid");
							WxChatApi.addFriendEachOfPassApply(request, uid, touid, chatlinkid, tochatlinkid, greet,applysigle);
						} else {
							WxChatApi.addFriendSigleOfPassApply(request, uid, touid, tochatlinkid, greet);
						}
					}
					WxFriend friend = RetUtils.getOkTData(ret, "friend");
					WxFriend toFriend = RetUtils.getOkTData(ret,"tofriend");
					WxChatApi.friendChangeAddNtf(request, friend, toFriend);
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok(RetUtils.getOkData(ret));
	}
	
	/**
	 * 消息操作-已调整
	 * @param request
	 * @param mid
	 * @param oper
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月11日 下午12:03:26
	 */
	@RequestPath(value = "/msgOper")
	public Resp msgOper(HttpRequest request,Long chatlinkid,String mids,Byte oper) throws Exception {
		if(chatlinkid == null) {
			return Resp.fail("会话id参数为空");
		}
		User curr = WebUtils.currUser(request);
		Byte chatmode = Const.ChatMode.P2P;
		if(chatlinkid <= 0) {
			//处理群的chatlinkid
			WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(curr.getId(), -chatlinkid);
			if(groupItem == null || groupItem.getChatlinkid() == null) {
				return Resp.fail("会话id为空");
			}
			chatlinkid = groupItem.getChatlinkid();
			chatmode = Const.ChatMode.GROUP;
		} 
		Ret ret = ChatMsgService.me.msgOper(curr,chatlinkid, oper, mids,chatmode);
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		Long sendChatLinkid = chatlinkid;
		Byte sendMode = chatmode;
		WxChatItems chatItems = RetUtils.getOkTData(ret, "chatItems");
		//消息处理
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					Object msg = RetUtils.getOkTData(ret, "msg");
					switch (oper) {
					case Const.WxMsgOper.DEL:
						WxChatApi.delMsg(request, curr, sendChatLinkid, sendMode, mids,chatItems);
						break;
					case Const.WxMsgOper.BACK:
						WxChatApi.backMsg(request, curr, sendChatLinkid, sendMode, msg);



						break;
					default:
						break;
					}
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok(RetUtils.OPER_RIGHT);
	}
	
	/**
	 * 消息转发-已调整
	 * @param request
	 * @param mids
	 * @param chatlinkids
	 * @param groupids
	 * @param uids
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年3月12日 下午5:11:26
	 */
	@RequestPath(value = "/msgForward")
	public Resp msgForward(HttpRequest request,Long chatlinkid,String mids,String groupids,String uids) throws Exception {
		if(chatlinkid == null) {
			return Resp.fail("会话id参数为空");
		}
		User curr = WebUtils.currUser(request);
		Byte chatmode = Const.ChatMode.P2P;
		if(chatlinkid <= 0) {
			//处理群的chatlinkid
			WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(curr.getId(), -chatlinkid);
			if(groupItem == null || groupItem.getChatlinkid() == null) {
				return Resp.fail("会话id为空");
			}
			chatlinkid = groupItem.getChatlinkid();
			chatmode = Const.ChatMode.GROUP;
		} 
		Ret ret = WxChatApi.msgForward(request, curr, chatlinkid,chatmode, mids, groupids, uids);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.OPER_RIGHT);
	}
	
	
	/**
	 * 分享名片-已调整
	 * @param request
	 * @param chatlinkid
	 * @param mids
	 * @param groupids
	 * @param uids
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年4月1日 下午2:10:33
	 */
	@RequestPath(value = "/shareCard")
	public Resp shareCard(HttpRequest request,Long cardid,String groupids,String uids,Byte chatmode) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = WxChatApi.sharChard(request, curr, cardid, chatmode, groupids, uids);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.OPER_RIGHT);
	}
	
	/************************************************end-oper**************************************************/
	
	/**********************************************begin-check**************************************************/
	
	/**
	 * 	检查是否可以加好友-已调整
	 * @param request
	 * @param uid
	 * @param touid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年1月15日 下午5:20:11
	 */
	@RequestPath(value = "/checkAddFriend")
	public Resp checkAddFriend(HttpRequest request,Integer touid) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = friendService.checkAddFriend(curr, touid);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getCode(ret));
	}
	
	/**
	 * 检查群名片进去条件-已调整
	 * @param request
	 * @param groupid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年3月11日 上午10:25:12
	 */
	@RequestPath(value = "/checkCardJoinGroup")
	public Resp checkCardJoinGroup(HttpRequest request,Long groupid,Integer applyuid,Date sendtime) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = groupService.checkJoinGroup(applyuid, groupid, curr.getId(),sendtime);
		if(ret.isFail()) {

			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkTData(ret, "joinflag"));
	}
	
	
	/**
	 * check发送名片-已调整
	 * @param request
	 * @param groupid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年3月11日 上午10:25:11
	 */
	@RequestPath(value = "/checkSendCard")
	public Resp checkCard(HttpRequest request,Long groupid) throws Exception {
		User curr = WebUtils.currUser(request);
		Ret ret = groupService.checkSendCard(curr.getId(), groupid);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok();
	}
	
	/**
	 * 检查是否是有效群成员-已调整
	 * @param request
	 * @param groupid
	 * @param uid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年3月31日 下午6:29:22
	 */
	@RequestPath(value = "/checkGroupUser")
	public Resp checkGroupUser(HttpRequest request,Long groupid,Integer uid) throws Exception {
		WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(uid, groupid);
		if(!ChatService.groupChatLink(groupItem)) {
			return Resp.ok(Const.YesOrNo.NO).msg("不是群成员");
		}
		return Resp.ok(Const.YesOrNo.YES);
	}
	
	
	/**
	 * 已读ack
	 * @param request
	 * @return
	 * @author xufei
	 * 2021年1月4日 下午12:23:36
	 */
	@RequestPath(value = "/readAck")
	public Resp readAck(HttpRequest request,Long chatlinkid) throws Exception {
		User curr = WebUtils.currUser(request);
		if(chatlinkid == null) {
			log.error("消息已读ack异常:会话为空");
			return Resp.fail("ack参数异常");
		}
		if(chatlinkid <= 0) {
			return Resp.ok(Const.YesOrNo.YES);
		}
		WxChatUserItem userItem = ChatIndexService.chatUserIndex(chatlinkid);
		if(userItem == null) {
			return Resp.fail("ack索引异常");
		}
		WxReadAck readAck = new WxReadAck();
		readAck.setUid(curr.getId());
		readAck.setTouid(userItem.getBizid().intValue());
		readAck.setChatlinkid(chatlinkid);
		readAck.setType(Const.YesOrNo.YES);
		readAck.setDevicetype(WebUtils.getRequestExt(request).getDeviceType());
		readAck.save();
		return Resp.ok(Const.YesOrNo.YES);
	}
	
	/************************************************end-check**************************************************/
	
	/**********************************************begin-upload-msg**************************************************/
	/**
	 * 发送文件-已调整
	 * @param request
	 * @param uploadFile
	 * @param groupid
	 * @param touid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月5日 下午7:01:16
	 */
	@RequestPath(value = "/file")
	public Resp file(HttpRequest request, UploadFile uploadFile, Long chatlinkid) throws Exception {
		try {
			if(uploadFile == null) {
				return Resp.fail("上传信息为空");
			}
			if(chatlinkid == null) {
				return Resp.fail("会话id参数为空");
			}
			User curr = WebUtils.currUser(request);
			if(chatlinkid <= 0) {
				Ret check = GroupService.checkGroupMsg(-chatlinkid, curr.getId());
				if(check.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(check));
				}
				chatlinkid = RetUtils.getOkTData(check);
			}
			WxChatItems chatItems = chatService.getBaseChatItems(chatlinkid);
			if(chatItems == null) {
				return Resp.fail(RetUtils.INVALID_PARAMETER);
			}
			if(Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
				WxChatUserItem touserItem = ChatIndexService.fdUserIndex(chatItems.getBizid().intValue(), chatItems.getUid());
				if(!ChatService.existTwoFriend(touserItem)) { 
					return Resp.fail("对方不是你的好友");
				}
			}
			String sessionid = request.getHttpSession().getId();
			File dbFile = innerUploadFile(curr, uploadFile, sessionid);
			String text = Json.toJson(dbFile);
			if(Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
				WxChatApi.sendTimeTipMsg(null, chatItems.getBizid().intValue(), curr.getId());
				Ret ret = WxChatApi.sendFdMsgEach(request, text, Const.ContentType.FILE, chatItems.getUid(), chatItems.getBizid().intValue(),Const.YesOrNo.NO);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			} else {
				WxChatApi.sendTimeTipMsg(chatItems.getBizid(), null, curr.getId());
				Ret ret = WxChatApi.sendGroupMsgEach( request, text, Const.ContentType.FILE, chatItems.getUid(), chatItems.getBizid(), Const.YesOrNo.NO,null);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			}
		} catch (Exception e) {
			log.error("", e);
			return Resp.fail(RetUtils.SYS_ERROR);
		}
	}
	@RequestPath(value = "/queryOnline")
	public Resp queryOnlineStatus(HttpRequest request, String uids){
		List<Map<String, Object>> list = new ArrayList<>();
		if (uids == null){
			return Resp.ok(list);
		}
		for (String uid : uids.split(",")){
			if (StrUtil.isBlank(uid)){
				continue;
			}
			if (uid.equals("null")){
				continue;
			}
			Map<String, Object> map = new HashMap<>();
			map.put("uid", uid);
			boolean online = CacheUtils.get(Caches.getCache(CacheConfig.USER_ONLIE), "online_"+uid, true, new FirsthandCreater<Boolean>() {
				@Override
				public Boolean create() throws Exception {
					return !WxChatApi.isOutline(Integer.parseInt(uid));
				}
			});
			map.put("online", online);
			if (!online){
				map.put("lastOnlineTime", Caches.getCache(CacheConfig.USER_ONLINE_TIME).get(uid));
			}
			list.add(map);
		}

//		System.out.println("查询在线结果："+JSONObject.toJSONString(list));
		return Resp.ok(list);
	}

	@RequestPath(value = "/inP2pChatInput")
	public Resp inP2pChatInput(HttpRequest request, Long chatlinkid, Integer toUid){
		User curr = WebUtils.currUser(request);
		if (curr == null){
			return Resp.fail("未登录");
		}
		WxChatUserItem wxChatUserItem = ChatIndexService.chatUserIndex(toUid, curr.getId(), Const.ChatMode.P2P);
		if (wxChatUserItem == null){
			return Resp.fail("未找到相应的会话ID");
		}
		WxUserOperNtf operNtf = new WxUserOperNtf();
		operNtf.setOperbizdata(String.valueOf(curr.getId()));
		operNtf.setChatlinkid(wxChatUserItem.getChatlinkid());
		operNtf.setOper((byte) 55);
		ImPacket imPacket = new ImPacket(Command.WxUserOperNtf, Json.toJson(operNtf));
		Ims.sendToUser(toUid.intValue(), imPacket);
		return Resp.ok();
	}


	/**
	 * 位置信息-已调整
	 * @param request
	 * @param uploadFile
	 * @param groupid
	 * @param touid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月5日 下午7:01:16
	 */
	@RequestPath(value = "/location")
	public Resp location(HttpRequest request, UploadFile uploadFile, Long chatlinkid, String lat, String lng, String address) throws Exception {
		try {
			if(uploadFile == null) {
				return Resp.fail("上传信息为空");
			}
			if(chatlinkid == null) {
				return Resp.fail("会话id参数为空");
			}
			User curr = WebUtils.currUser(request);
			if(chatlinkid <= 0) {
				Ret check = GroupService.checkGroupMsg(-chatlinkid, curr.getId());
				if(check.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(check));
				}
				chatlinkid = RetUtils.getOkTData(check);
			}
			WxChatItems chatItems = chatService.getBaseChatItems(chatlinkid);
			if(chatItems == null) {
				return Resp.fail(RetUtils.INVALID_PARAMETER);
			}
			if(Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
				WxChatUserItem touserItem = ChatIndexService.fdUserIndex(chatItems.getBizid().intValue(), chatItems.getUid());
				if(!ChatService.existTwoFriend(touserItem)) {
					return Resp.fail("对方不是你的好友");
				}
			}
			String sessionid = request.getHttpSession().getId();
//			File dbFile = innerUploadFile(curr, uploadFile, sessionid);
			Resp resp = processUploadedImg(request, uploadFile);
			Img img = (Img) resp.getData();
			String text = Json.toJson(img);
			JSONObject jsonObject = JSONObject.parseObject(text);
			jsonObject.put("lat", lat);
			jsonObject.put("lng", lng);
			jsonObject.put("address", address);
			text = jsonObject.toJSONString();
			if(Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
				WxChatApi.sendTimeTipMsg(null, chatItems.getBizid().intValue(), curr.getId());
				Ret ret = WxChatApi.sendFdMsgEach(request, text, Const.ContentType.LOCATION, chatItems.getUid(), chatItems.getBizid().intValue(),Const.YesOrNo.NO);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			} else {
				WxChatApi.sendTimeTipMsg(chatItems.getBizid(), null, curr.getId());
				Ret ret = WxChatApi.sendGroupMsgEach( request, text, Const.ContentType.LOCATION, chatItems.getUid(), chatItems.getBizid(), Const.YesOrNo.NO,null);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			}
		} catch (Exception e) {
			log.error("", e);
			return Resp.fail(RetUtils.SYS_ERROR);
		}
	}

	/**
	 * 表情-已调整
	 * @param request
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月5日 下午7:01:16
	 */
	@RequestPath(value = "/emotion")
	public Resp location(HttpRequest request, Integer type, String emotion, Long chatlinkid, int width, int height) throws Exception {
		try {
			if(chatlinkid == null) {
				return Resp.fail("会话id参数为空");
			}
			User curr = WebUtils.currUser(request);
			if(chatlinkid <= 0) {
				Ret check = GroupService.checkGroupMsg(-chatlinkid, curr.getId());
				if(check.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(check));
				}
				chatlinkid = RetUtils.getOkTData(check);
			}
			WxChatItems chatItems = chatService.getBaseChatItems(chatlinkid);
			if(chatItems == null) {
				return Resp.fail(RetUtils.INVALID_PARAMETER);
			}
			if(Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
				WxChatUserItem touserItem = ChatIndexService.fdUserIndex(chatItems.getBizid().intValue(), chatItems.getUid());
				if(!ChatService.existTwoFriend(touserItem)) {
					return Resp.fail("对方不是你的好友");
				}
			}
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("type", type);
			jsonObject.put("emotion", emotion);
			jsonObject.put("width", width);
			jsonObject.put("height", height);
			String text = jsonObject.toJSONString();
			if(Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
				WxChatApi.sendTimeTipMsg(null, chatItems.getBizid().intValue(), curr.getId());
				Ret ret = WxChatApi.sendFdMsgEach(request, text, Const.ContentType.FACE_EMOTION, chatItems.getUid(), chatItems.getBizid().intValue(),Const.YesOrNo.NO);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			} else {
				WxChatApi.sendTimeTipMsg(chatItems.getBizid(), null, curr.getId());
				Ret ret = WxChatApi.sendGroupMsgEach( request, text, Const.ContentType.FACE_EMOTION, chatItems.getUid(), chatItems.getBizid(), Const.YesOrNo.NO,null);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			}
		} catch (Exception e) {
			log.error("", e);
			return Resp.fail(RetUtils.SYS_ERROR);
		}
	}


	/**
	 * 发送视频-已调整
	 * @param request
	 * @param uploadFile
	 * @param chatlinkid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月5日 下午7:43:00
	 */
	@RequestPath(value = "/video")
	public Resp video(HttpRequest request, UploadFile uploadFile, Long chatlinkid) throws Exception {
		try {
			if(uploadFile == null) {
				return Resp.fail("上传信息为空");
			}
			if(chatlinkid == null) {
				return Resp.fail("会话id参数为空");
			}
			User curr = WebUtils.currUser(request);
			if(chatlinkid <= 0) {
				Ret check = GroupService.checkGroupMsg(-chatlinkid, curr.getId());
				if(check.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(check));
				}
				chatlinkid = RetUtils.getOkTData(check);
			}
			WxChatItems chatItems = chatService.getBaseChatItems(chatlinkid);
			if(chatItems == null) {
				return Resp.fail(RetUtils.INVALID_PARAMETER);
			}
			if(Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
				WxChatUserItem touserItem = ChatIndexService.fdUserIndex(chatItems.getBizid().intValue(), chatItems.getUid());
				if(!ChatService.existTwoFriend(touserItem)) { 
					return Resp.fail("对方不是你的好友");
				}
			}
			Resp resp = processUploadedVideo(request, uploadFile);
			if (!resp.isOk()) {
				return resp;
			}
			Video video = (Video) resp.getData();
			String text = Json.toJson(video);
			if(Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
				WxChatApi.sendTimeTipMsg(null, chatItems.getBizid().intValue(), curr.getId());
				Ret ret = WxChatApi.sendFdMsgEach(request, text, Const.ContentType.VIDEO, chatItems.getUid(), chatItems.getBizid().intValue(),Const.YesOrNo.NO);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			} else {
				WxChatApi.sendTimeTipMsg(chatItems.getBizid(), null, curr.getId());
				Ret ret = WxChatApi.sendGroupMsgEach(request, text, Const.ContentType.VIDEO, chatItems.getUid(), chatItems.getBizid(),Const.YesOrNo.NO,null);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			}
		} catch (Exception e) {
			log.error("", e);
			return Resp.fail(RetUtils.SYS_ERROR);
		}
	}
	
	/**
	 * 发送图片-已调整
	 * @param request
	 * @param uploadFile
	 * @param groupid
	 * @param touid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月5日 下午7:44:17
	 */
	@RequestPath(value = "/img")
	public Resp img(HttpRequest request, UploadFile uploadFile, Long chatlinkid) throws Exception {
		try {
			if(uploadFile == null) {
				return Resp.fail("上传信息为空");
			}
			if(chatlinkid == null) {
				return Resp.fail("会话id参数为空"); 
			}
			User curr = WebUtils.currUser(request);
			if(chatlinkid <= 0) {
				Ret check = GroupService.checkGroupMsg(-chatlinkid, curr.getId());
				if(check.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(check));
				}
				chatlinkid = RetUtils.getOkTData(check);
			}
			WxChatItems chatItems = chatService.getBaseChatItems(chatlinkid);
			if(chatItems == null) {
				return Resp.fail(RetUtils.INVALID_PARAMETER);
			}
			if(Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
				WxChatUserItem touserItem = ChatIndexService.fdUserIndex(chatItems.getBizid().intValue(), chatItems.getUid());
				if(!ChatService.existTwoFriend(touserItem)) { 
					return Resp.fail("对方不是你的好友");
				}
			}
			Resp resp = processUploadedImg(request, uploadFile);
			if (!resp.isOk()) {
				return resp;
			}
			Img img = (Img) resp.getData();
			String text = Json.toJson(img);

			if(Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
				WxChatApi.sendTimeTipMsg(null, chatItems.getBizid().intValue(), curr.getId());
				Ret ret = WxChatApi.sendFdMsgEach(request, text, Const.ContentType.IMG, chatItems.getUid(), chatItems.getBizid().intValue(),Const.YesOrNo.NO);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			} else {
				WxChatApi.sendTimeTipMsg(chatItems.getBizid(), null, curr.getId());
				Ret ret = WxChatApi.sendGroupMsgEach(request, text, Const.ContentType.IMG, chatItems.getUid(), chatItems.getBizid(),Const.YesOrNo.NO,null);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			}

		} catch (Exception e) {
			log.error("", e);
			return Resp.fail(RetUtils.SYS_ERROR);
		}
	}
	
	/**
	 * 音频上传-已调整
	 * @param request
	 * @param uploadFile
	 * @param chatlinkid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年4月13日 下午2:18:45
	 */
	@RequestPath(value = "/audio")
	public Resp audio(HttpRequest request, UploadFile uploadFile, Long chatlinkid) throws Exception {
		try {
			if(uploadFile == null) {
				return Resp.fail("上传信息为空");
			}
			if(chatlinkid == null) {
				return Resp.fail("会话id参数为空");
			}
			User curr = WebUtils.currUser(request);
			if(chatlinkid <= 0) {
				Ret check = GroupService.checkGroupMsg(-chatlinkid, curr.getId());
				if(check.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(check));
				}
				chatlinkid = RetUtils.getOkTData(check);
			}
			WxChatItems chatItems = chatService.getBaseChatItems(chatlinkid);
			if(chatItems == null) {
				return Resp.fail(RetUtils.INVALID_PARAMETER);
			}
			if(Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
				WxChatUserItem touserItem = ChatIndexService.fdUserIndex(chatItems.getBizid().intValue(), chatItems.getUid());
				if(!ChatService.existTwoFriend(touserItem)) { 
					return Resp.fail("对方不是你的好友");
				}
			}
			Resp resp = processUploadedAudio(request, uploadFile);
			if (!resp.isOk()) {
				return resp;
			}
			Audio audio = (Audio) resp.getData();
			String text = Json.toJson(audio);
			if(Objects.equals(chatItems.getChatmode(), Const.ChatMode.P2P)) {
				WxChatApi.sendTimeTipMsg(null, chatItems.getBizid().intValue(), curr.getId());
				Ret ret = WxChatApi.sendFdMsgEach(request, text, Const.ContentType.AUDIO, chatItems.getUid(), chatItems.getBizid().intValue(),Const.YesOrNo.NO);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			} else {
				WxChatApi.sendTimeTipMsg(chatItems.getBizid(), null, curr.getId());
				Ret ret = WxChatApi.sendGroupMsgEach(request, text, Const.ContentType.AUDIO, chatItems.getUid(), chatItems.getBizid(),Const.YesOrNo.NO,null);
				if(ret.isFail()) {
					return Resp.fail(RetUtils.getRetMsg(ret));
				}
				return Resp.ok(RetUtils.OPER_RIGHT);
			}
		} catch (Exception e) {
			log.error("", e);
			return Resp.fail(RetUtils.SYS_ERROR);
		}
	}

	/**
	 * 上传文件-已调整
	 * 可抽象TODO:XUFEI
	 * @param curr
	 * @param uploadFile
	 * @param sessionid
	 * @return
	 * @author xufei
	 * 2020年2月5日 下午7:25:45
	 */
	public static File innerUploadFile(User curr,UploadFile uploadFile,String sessionid) throws Exception {
		byte[] bs = uploadFile.getData();
		String filename = uploadFile.getName();
		String ext = FileUtil.extName(filename);
		String urlWithoutExt = UploadUtils.newFile(Const.UPLOAD_DIR.WX_FILE, curr.getId(), uploadFile.getName()); //不带后缀的文件路径
		String url = urlWithoutExt + "." + ext;
//		if (StrUtil.isNotBlank(ext)) {
//			url = urlWithoutExt + "." + ext + ".zip";
//		} else {
//			url = urlWithoutExt + ".zip";
//		}
//		byte[] zipbs = ZipUtil.gzip(bs);
		java.io.File file = new java.io.File(Const.RES_ROOT, url);
		FileUtil.writeBytes(bs, file);
		File dbFile = new File();
		dbFile.setExt(ext);
		dbFile.setFilename(uploadFile.getName());
		dbFile.setSession(sessionid);
		dbFile.setSize((long) bs.length);
		dbFile.setUid(curr.getId());
		dbFile.setUrl(url);
		dbFile.save();
		return dbFile;
	}
	
	/**
	 * 用户上传的视频-已调整
	 * 可抽象TODO:XUFEI
	 * @param request
	 * @param uploadFile
	 * @param groupid
	 * @return
	 * @author tanyaowu
	 * @throws Exception 
	 */
	private Resp processUploadedVideo(HttpRequest request, UploadFile uploadFile) throws Exception {
		User curr = WebUtils.currUser(request);
		byte[] bs = uploadFile.getData();
		String filename = uploadFile.getName();
		String extName = FileUtil.extName(filename);
		Resp ret = null;
		if (curr == null) {
			ret = Resp.fail("您尚未登录或登录超时").code(AppCode.ForbidOper.NOTLOGIN);
		}
		Integer uid = null;
		if (curr != null) {
			uid = curr.getId();
		} else {
			uid = 1;
		}

		String videoUrlWithoutExt = UploadUtils.newFile(Const.UPLOAD_DIR.WX_VIDEO, uid, filename);
		String videoUrl = videoUrlWithoutExt + "." + extName;

		String videoFilePath = Const.RES_ROOT + videoUrl;
		FileUtil.writeBytes(bs, videoFilePath);

		String coverExt = "jpg";
		String coverUrl = UploadUtils.newFile(Const.UPLOAD_DIR.WX_VIDEO, uid, FileUtil.mainName(filename)) + "." + coverExt;
		String coverFilePath = Const.RES_ROOT + coverUrl;

		Video video = VideoUtils.processVideo(videoFilePath, coverFilePath, 400, coverExt);
		video.setUrl(videoUrl);
		video.setUid(uid);

		video.setComefrom(Video.ComeFrom.IM_UPLOAD);
		video.setCoverurl(coverUrl);
		video.setStatus((byte) 1);
		video.setTitle(filename);
		video.setFilename(filename);
		video.setSession(request.getHttpSession().getId());
		boolean f = VideoService.me.save(video);
		//不管成功与否都保存视频
		if (ret != null) {
			return ret;
		}
		if (f) {
			return Resp.ok(video);
		} else {
			return Resp.fail().data(video);
		}
	}
	
	/**
	 * 用户上传的音频-已调整
	 * 可抽象TODO:XUFEI
	 * @param request
	 * @param uploadFile
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年4月13日 下午2:20:45
	 */
	@SuppressWarnings("resource")
	private Resp processUploadedAudio(HttpRequest request, UploadFile uploadFile) throws Exception {
		User curr = WebUtils.currUser(request);
		byte[] bs = uploadFile.getData();
		String filename = uploadFile.getName();
		String extName = FileUtil.extName(filename);
		Resp ret = null;
		if (curr == null) {
			ret = Resp.fail("您尚未登录或登录超时").code(AppCode.ForbidOper.NOTLOGIN);
		}
		Integer uid = null;
		if (curr != null) {
			uid = curr.getId();
		} else {
			uid = 1;
		}
		String urlWithoutExt = UploadUtils.newFile(Const.UPLOAD_DIR.WX_VIDEO, uid, filename);
		String url = urlWithoutExt + "." + extName;
		String filePath = Const.RES_ROOT + url;
		FileUtil.writeBytes(bs, filePath);
		FFmpegFrameGrabber ff = new FFmpegFrameGrabber(filePath);
		ff.start();
		long millseconds = ff.getLengthInTime() / (1000);
		double seconds = Math.ceil((new Double(millseconds)) / 1000);
		ff.stop();
		Audio audio = new Audio();
		audio.setSeconds((int) seconds);
		audio.setUid(uid);
		audio.setUrl(url);
		audio.setFilename(filename);
		audio.save();
		if(ret != null) {
			return ret;
		}
		return Resp.ok(audio);
	}
	
	/**
	 * 用户上传的图片-已调整
	 * 可抽象TODO:XUFEI
	 * @param request
	 * @param uploadFile
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月5日 下午7:44:47
	 */
	private Resp processUploadedImg(HttpRequest request, UploadFile uploadFile) throws Exception {
		User curr = WebUtils.currUser(request);
		byte[] imageBytes = uploadFile.getData();
		Resp ret = null;
		if (curr == null) {
			ret = Resp.fail("您尚未登录或登录超时").code(AppCode.ForbidOper.NOTLOGIN);
		}
		Integer uid = null;
		if (curr != null) {
			uid = curr.getId();
		} else {
			uid = 1;
		}
		BufferedImage bi = ImgUtil.toImage(imageBytes);
		float scale = ImgUtils.calcScaleWithWidth(400, bi);
		Img img = ImgUtils.processImg(Const.UPLOAD_DIR.WX_IMG, uid, uploadFile, scale);
		img.setComefrom(Img.ComeFrom.WX_UPLOAD);
		img.setStatus((byte) 1);
		img.setSession(request.getHttpSession().getId());
		boolean f = ImgService.me.save(img);
		if (ret != null) {
			return ret;
		}
		if (f) {
			return Resp.ok(img);
		} else {
			return Resp.fail("服务器异常");
		}
	}

	/************************************************end-upload-msg**************************************************/
	
	/**
	 * 聊天会话焦点聚焦
	 * @param request
	 * @param uid
	 * @param chatlinkid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月1日 下午5:55:51
	 */
	@Deprecated
	@RequestPath(value = "/onFocus")
	public Resp onFocus(HttpRequest request,Long chatlinkid) throws Exception {
		User curr = WebUtils.currUser(request);
		Integer uid = curr.getId();
		if(chatlinkid == null) {
			return Resp.fail("会话id参数为空");
		}
		Byte chatmode = Const.ChatMode.P2P;
		Long groupid = null;
		if(chatlinkid <= 0) {
			chatmode = Const.ChatMode.GROUP;
			groupid = -chatlinkid;
			WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(uid, groupid);
			if(groupItem == null || groupItem.getChatlinkid() == null) {
				return Resp.fail("会话id为空");
			}
			chatlinkid = groupItem.getChatlinkid();
		}
		Byte devicetype = WebUtils.getRequestExt(request).getAppDevice();
		IpInfo ipInfo = IpInfoService.ME.save(request.getClientIp());
		Ret ret = ChatMsgService.me.onFocus(curr, chatlinkid,groupid,chatmode, devicetype,ipInfo.getId());
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		boolean isToRead = RetUtils.getOkTData(ret);
		if(isToRead) {
			final Byte runChatMode = chatmode;
			final Long fGroup = groupid;
			//消息处理
			Threads.getGroupExecutor().execute(new Runnable() {
				@Override
				public void run() {
					try {
						Long tochatlinkid = RetUtils.getOkTData(ret, "tochatlinkid");
						Integer touid = RetUtils.getOkTData(ret, "touid");
						if(Objects.equals(runChatMode, Const.ChatMode.GROUP)) {
							WxChatApi.userChatOper(request,touid,-fGroup, Const.WxUserOper.TO_READ,"好友已读你的消息","",null);
						} else {
							WxChatApi.userChatOper(request,touid,tochatlinkid, Const.WxUserOper.TO_READ,"好友已读你的消息","",null);
						}
					} catch (Exception e) {
						log.error("", e);
					}
				}
			});
		}
		return Resp.ok(RetUtils.OPER_RIGHT);
	}
	
	/**
	 * 跳出会话
	 * @param request
	 * @param uid
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月4日 下午5:14:08
	 */
	@Deprecated
	@RequestPath(value = "/leaveChat")
	public Resp leaveChat(HttpRequest request) throws Exception {
		User curr = WebUtils.currUser(request);
		Byte devicetype = WebUtils.getRequestExt(request).getDeviceType();
		if(Objects.equals(devicetype, Devicetype.IOS.getValue()) || Objects.equals(devicetype, Devicetype.ANDROID.getValue())) {
			devicetype = Devicetype.APP.getValue();
		}
		Ret ret = ChatMsgService.me.leaveChat(curr,devicetype);
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.getOkData(ret));
	}

	@RequestPath(value = "/pushAllNotice")
	public Resp pushAllNotice(HttpRequest request, Integer noticeId) throws Exception {
		if (noticeId == null){
			return Resp.fail("通知ID不能为空");
		}
		String sql = "select * from announcement where id = ?";
		Record record =  Db.use(Const.Db.TIO_SITE_CONF).findFirst(sql, noticeId);
		if (record == null){
			return Resp.fail("查无此通知");
		}

//		String str = ConfService.getString("defaultFriendUid", null);
//		if (NumberUtil.isNumber(str)){
//			return Resp.fail("默认好友不正确");
//		}
//		User defaultFriend = UserService.ME.getById(str);
//		if (defaultFriend == null){
//			return Resp.fail("默认好友不存在");
//		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				List<User> users = User.dao.find("select * from user");
				users.forEach(user -> {
					boolean isOnline = !WxChatApi.isOutline(user.getId());
					if (isOnline){
						//推送通知
						WxUserOperNtf operNtf = new WxUserOperNtf();
						operNtf.setOperbizdata(String.valueOf(noticeId));
//						operNtf.setChatlinkid(wxChatUserItem.getChatlinkid());
						operNtf.setOper((byte) 81);
						ImPacket imPacket = new ImPacket(Command.WxUserOperNtf, Json.toJson(operNtf));
						Ims.sendToUser(user.getId(), imPacket);
						try {
							Thread.sleep(30);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
			}
		}).start();

		return Resp.ok();
	}

	@RequestPath(value = "/getLastAllNotice")
	public Resp getLastAllNotice(){
		String sql = "select * from announcement where status = 2 order by createtime desc limit 1";
		Record record =  Db.use(Const.Db.TIO_SITE_CONF).findFirst(sql);
		if (record == null){
			return Resp.fail();
		}
		return Resp.ok(record.getColumns());
	}
		
	/**
	 * 获取群用户的的头像-已调整
	 * @param uidArr
	 * @param curr
	 * @return
	 * @throws Exception
	 * @author xufei
	 * 2020年2月13日 下午4:06:50
	 */
	private static Ret getGroupImg(String[] uidArr,User curr,String name) throws Exception {
		List<String> avatarList = new ArrayList<>();
		avatarList.add(curr.getAvatar());
		boolean createName = StrUtil.isBlank(name) ? true : false;
		if(createName) {
			name = curr.getNick();
		}
		String nicks = "";
		int c = 0;
		for (String uidStr : uidArr) {
			if (StrUtil.isNotBlank(uidStr)) {
				int uid = Integer.parseInt(uidStr);
				if (Objects.equals(uid, curr.getId())) { //前面已经把当前用户加到了该群，所以此处略过
					continue;
				}
				User user = UserService.ME.getById(uid);
				if (user != null) {
					if(createName) {
						String newName = name + "、" + user.getNick();
						if(newName.length() < 30) {
							name = newName;
						}
					}
					nicks += "、" + user.getNick();
					if (c >= 8) {
						continue;
					}
					avatarList.add(user.getAvatar());
					c++;
				}
			}
		}
		Img img = WxGroupAvatarUtil.generateGroupAvatar(avatarList, curr.getId());
		if(createName) {
			return Ret.ok().set("img",img).set("nicks",nicks.substring(1)).set("name",name);
		} else {
			return Ret.ok().set("img",img).set("nicks",nicks.substring(1));
		}
	}
	
	/**
	 * 自动修改群头像和群名称-已调整
	 * 1、群名称如果指定修改后，该方法无效
	 * 2、群头像生成条件：A、人员减员；B、人员新增时，未满；C、群权限操作
	 * 3、群昵称生成条，排除1后，A、2触发；B、上层逻辑触发
	 * @param request
	 * @param devicetype
	 * @param groupid
	 * @param nameUpdate 名称修改标识：1：修改；2：不修改
	 * @param groupname 1、修改后的群名称
	 * @param joinnum 人数变动数据
	 * @param curr
	 * @throws Exception
	 * @author xufei
	 * 2020年3月13日 下午5:20:25
	 */
	public static boolean auotUpdateGroupInfo(HttpRequest request,Byte devicetype,Long groupid,Byte nameUpdate,Short joinnum,User curr) throws Exception {
		WxGroup group = groupService.getByGroupid(groupid);
		if(group == null) {
			log.error("群自动修改头像，本群已解散：groupid-{}",groupid);
			return false;
		}
		//群名称是否重新生成
		boolean nameInit = false;
		String name = "";
		String oldName = group.getName();
		if(Objects.equals(group.getAutoflag(), Const.YesOrNo.YES) && Objects.equals(nameUpdate, Const.YesOrNo.YES)) { //群名称修改标识
			nameInit = true;
		}
		String avatar = ""; //头像是否生成
		//1、joinnum不为空；2：joinnum > 0时，新增用户判断；3:joinnum < 0时，退出或者被踢
		if (Objects.equals(group.getAvatarautoflag(), Const.YesOrNo.YES) && joinnum != null
				&& (
					(joinnum > 0 && group.getJoinnum() - joinnum < 9) //新增用户判断,新增前是否已满头像
						|| 
					joinnum <= 0 //删除人或者操作，重新更新下头像
					)
				) { // 头像重新生成
			List<String> avatarList = new ArrayList<>();
			Ret ret = groupService.groupUserList(groupid, null,"");
			if(ret.isFail()) {
				
				return false;
			}
			Page<Record> page = RetUtils.getOkTPage(ret);
			if(page == null) {
				log.error("获取用户列表为空");
				return false;
			}
			List<Record> groupUserList = page.getList();
			int avatarCount = 0;
			for(Record record : groupUserList) {
				if(avatarCount > 8) {
					break;
				}
				Integer uid = record.getInt("uid");
				User user = UserService.ME.getById(uid);
				if (user != null) {
					avatarList.add(user.getAvatar());
					avatarCount++;
				}
				if(nameInit) {
					String newName = name + "、" + user.getNick();
					if(newName.length() >= 31) {
						continue;
					}
					name = newName;
				}
			}
			try {
				Img img = WxGroupAvatarUtil.generateGroupAvatar(avatarList, groupUserList.get(0).getInt("uid"));
				avatar = img.getCoverurl();
				if(!avatar.equals(group.getAvatar())) {
					groupService.modifyAvatar(groupid, avatar,true);
				} else {
					avatar = "";
				}
			} catch (Exception e) {
				log.error("", e);
			}
		} else if(nameInit) { //头像不生成，名称需要重新生成
			Ret ret = groupService.groupUserList(groupid, null,"");
			if(ret.isFail()) {
				
				return false;
			}
			Page<Record> page = RetUtils.getOkTPage(ret);
			if(page == null) {
				log.error("获取用户列表为空");
				return false;
			}
			List<Record> groupUserList = page.getList();
			for(Record record : groupUserList) {
				Integer uid = record.getInt("uid");
				User user = UserService.ME.getById(uid);
				String newName = name + "、" + user.getNick();
				if(newName.length() >= 31) {
					continue;
				}
				name = newName;
			}
		}
		if(StrUtil.isNotBlank(name)) {
			name = name.substring(1);
		}
		if(StrUtil.isNotBlank(name) && !oldName.equals(name)) {
			groupService.modifyName(curr.getId(), groupid, name,true);
		} else {
			name = "";
		}
		if(StrUtil.isNotBlank(name) || StrUtil.isNotBlank(avatar)) {
			return true;
		}
		return false;
	}
}
