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
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.service.chat.ChatMsgService.MsgTemplate;
import org.tio.sitexxx.service.service.chat.GroupService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.wx.SysMsgVo;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.Threads;
import org.tio.utils.resp.Resp;

import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 群信息接口
 * @author xufei
 * 2020年11月7日 下午6:26:46
 */
@RequestPath(value = "/group")
public class GroupController {
	private static Logger log = LoggerFactory.getLogger(GroupController.class);

	/**
	 * 修改群简介
	 * @param request
	 * @param groupid
	 * @param intro
	 * @return
	 */
	@RequestPath(value = "/modifyIntro")
	public Resp modifyIntro(HttpRequest request, Long groupid, String intro) {
		User curr = WebUtils.currUser(request);
		Resp resp = GroupService.me.modifyIntro(curr, groupid, intro);
		return resp;
	}

	/**
	 * 修改群名字
	 * @param request
	 * @param groupid
	 * @param name
	 * @return
	 * @author xufei
	 * 2020年11月13日 下午2:23:29
	 */
	@RequestPath(value = "/modifyName")
	public Resp modifyName(HttpRequest request, Long groupid, String name) {
		User curr = WebUtils.currUser(request);
//		name = EscapeUtil.escapeHtml4(name);
		Ret ret = GroupService.me.modifyName(curr.getId(), groupid, name);
		if(ret.isFail()) {
			
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		String sendName = name;
		//消息触发
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					Ret ret = WxChatApi.updateGroupInfo(request, curr, groupid, sendName);
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
	 * 修改群头像
	 * @param request
	 * @param groupid
	 * @param avatar
	 * @return
	 * @author xufei
	 * 2021年1月13日 下午7:08:07
	 */
	@RequestPath(value = "/modifyAvatar")
	public Resp modifyAvatar(HttpRequest request, Long groupid, String avatar) {
		User curr = WebUtils.currUser(request);
		Ret ret = GroupService.me.modifyUploadAvatar(curr.getId(), groupid, avatar);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		String sendAvatar = avatar;
		//消息触发
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					Ret ret = WxChatApi.updateGroupAvatar(request, curr, groupid, sendAvatar);
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
	 * 修改群公告
	 * @param request
	 * @param groupid
	 * @param notice
	 * @return
	 */
	@RequestPath(value = "/modifyNotice")
	public Resp modifyNotice(HttpRequest request, Long groupid, String notice) {
		User curr = WebUtils.currUser(request);
		Resp resp = GroupService.me.modifyNotice(curr, groupid, notice);
		if(StrUtil.isNotBlank(notice)) {
			SysMsgVo sysMsgVo = new SysMsgVo(curr.getNick(),MsgTemplate.updatenotice, notice,"updatenotice");
			//消息触发
			Threads.getGroupExecutor().execute(new Runnable() {
				@Override
				public void run() {
					try {
						Ret ret = WxChatApi.sendGroupMsgEach(request, sysMsgVo.toText(), Const.ContentType.TEXT, curr.getId(), groupid,Const.YesOrNo.YES,sysMsgVo);
						if(ret.isFail()) {
							log.error(RetUtils.getRetMsg(ret));
						}
					} catch (Exception e) {
						log.error("", e);
					}
				}
			});
		}
		return resp;
	}
	
	/**
	 * 群推送提醒开关：freeflag:1:开启免打扰，2：不开启-已调整
	 * @param request
	 * @param groupid
	 * @return
	 * @author xufei
	 * 2020年9月29日 上午11:08:29
	 */
	@RequestPath(value = "/modifyGroupPush")
	public Resp modifyGroupPush(HttpRequest request, Long groupid, Byte freeflag) {
		User curr = WebUtils.currUser(request);
		Ret ret = GroupService.me.modifyGroupPush(groupid, freeflag, curr.getId());
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		return Resp.ok(RetUtils.OPER_RIGHT);
	}
	
	/**
	 * 管理员操作
	 * @param request
	 * @param groupid
	 * @param uid
	 * @param grouprole
	 * @return
	 * @author xufei
	 * 2021年1月13日 下午3:17:35
	 */
	@RequestPath(value = "/manager")
	public Resp manager(HttpRequest request, Long groupid, Integer uid,Byte grouprole) {
		User curr = WebUtils.currUser(request);
		Ret ret = GroupService.me.manager(curr.getId(), uid, groupid, grouprole);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					Ret ret = WxChatApi.manager(request, curr, groupid, uid, grouprole);
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
	 * 好友显示操作
	 * @param request
	 * @param groupid
	 * @param friendflag
	 * @return
	 * @author xufei
	 * 2021年1月13日 下午3:52:10
	 */
	@RequestPath(value = "/modifyFriendFlag")
	public Resp modifyFriendFlag(HttpRequest request, Long groupid,Byte friendflag) {
		User curr = WebUtils.currUser(request);
		Ret ret = GroupService.me.friendFlag(curr.getId(), groupid, friendflag);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		//消息触发
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					SysMsgVo sysMsgVo = new SysMsgVo(curr.getNick(),friendflag==2?MsgTemplate.friendFlagOpen:MsgTemplate.friendFlagClose, "","friendflag");
					WxChatApi.sendGroupMsgEach(request, sysMsgVo.toText(), Const.ContentType.TEXT, curr.getId(), groupid,Const.YesOrNo.YES,sysMsgVo, String.valueOf(friendflag));
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok(RetUtils.OPER_RIGHT);
	}

	/***
	 * 禁止用户主动退群开关
	 * @param request
	 * @param groupid
	 * @param exitflag 1：开启 2：关闭
	 * @return
	 */
	@RequestPath(value = "/modifyExitFlag")
	public Resp modifyExitFlag(HttpRequest request, Long groupid,Byte exitflag) {
		User curr = WebUtils.currUser(request);
		Ret ret = GroupService.me.exitFlag(curr.getId(), groupid, exitflag);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		//消息触发
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					SysMsgVo sysMsgVo = new SysMsgVo(curr.getNick(),exitflag==2?MsgTemplate.exitFlagOpen:MsgTemplate.exitFlagClose, "","exitFlag");
					WxChatApi.sendGroupMsgEach(request, sysMsgVo.toText(), Const.ContentType.TEXT, curr.getId(), groupid,Const.YesOrNo.YES,sysMsgVo, String.valueOf(exitflag));
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok(RetUtils.OPER_RIGHT);
	}
	
	/**
	 * 群审核开关修改-已调整
	 * @param request
	 * @param groupid
	 * @param mode
	 * @return
	 * @author xufei
	 * 2020年3月9日 下午4:37:18
	 */
	@RequestPath(value = "/modifyReview")
	public Resp modifyReview(HttpRequest request, Long groupid, Byte mode) {
		String text = "";
		User curr = WebUtils.currUser(request);
		SysMsgVo sysMsgVo = new SysMsgVo(curr.getNick(),"", "","");
		switch (mode) {
		case Const.GroupJoinMode.REVIEW:
			text = MsgTemplate.reviewopen;
			sysMsgVo.setMsgbody(text);
			sysMsgVo.setMsgkey("reviewopen");
			break;
		case Const.GroupJoinMode.NO_REVIEW:
			text = MsgTemplate.reviewclose;
			sysMsgVo.setMsgbody(text);
			sysMsgVo.setMsgkey("reviewclose");
			break;
		default:
			return Resp.fail().msg("无效入群方式");
		}
		
		Ret ret = GroupService.me.modifyReview(curr, groupid, mode);
		if(ret.isFail()) {
			return Resp.fail().msg(RetUtils.getRetMsg(ret));
		}
		//消息触发
		Threads.getGroupExecutor().execute(new Runnable() {
			@Override
			public void run() {
				try {
					WxChatApi.sendGroupMsgEach(request, sysMsgVo.toText(), Const.ContentType.TEXT, curr.getId(), groupid,Const.YesOrNo.YES,sysMsgVo, String.valueOf(mode));
				} catch (Exception e) {
					log.error("", e);
				}
			}
		});
		return Resp.ok(RetUtils.OPER_RIGHT);
	}
}
