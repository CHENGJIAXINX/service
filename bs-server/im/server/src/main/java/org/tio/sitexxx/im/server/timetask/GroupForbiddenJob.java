/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server.timetask;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.im.server.handler.wx.WxChatApi;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.WxGroupUser;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.chat.ChatIndexService;
import org.tio.sitexxx.service.service.chat.ChatMsgService.MsgTemplate;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.wx.SysMsgVo;
import org.tio.utils.jfinal.P;
import org.tio.utils.quartz.AbstractJobWithLog;

import cn.hutool.core.collection.CollectionUtil;

/**
 * 群聊禁言定时任务处理
 * @author xufei
 * 2020年7月3日 下午2:56:29
 */
public class GroupForbiddenJob extends AbstractJobWithLog {

	private static Logger log = LoggerFactory.getLogger(GroupForbiddenJob.class);

	private static boolean isRunning = false;
	
	@Override
	public void run(JobExecutionContext context) throws Exception {
		boolean allowExecute = P.getBoolean("quartz.open.flag",false);
		if(allowExecute && isStart()) {
			try {
				List<WxGroupUser> groupUsers = WxGroupUser.dao.find("select * from wx_group_user where forbiddenflag = ? and cancelforbiddentime < now()",WxGroupUser.Forbiddenflag.DURATION);
				if(CollectionUtil.isNotEmpty(groupUsers)) {
					for(WxGroupUser groupUser : groupUsers) {
						User user = UserService.ME.getById(groupUser.getUid());
						if(user == null) {
							continue;
						}
						try {
							WxGroupUser updateGroupUser = new WxGroupUser();
							updateGroupUser.setId(groupUser.getId());
							updateGroupUser.setForbiddenflag(WxGroupUser.Forbiddenflag.NO);
							updateGroupUser.setForbiddenduration(0);
							updateGroupUser.setCancelforbiddentime(null);
							boolean update = updateGroupUser.update();
							if(!update) {
								log.error("自动解除禁言异常");
								continue;
							}
							ChatIndexService.clearGroupUserCache(groupUser.getId());
							ChatIndexService.clearGroupUserListCache(groupUser.getGroupid());
							SysMsgVo sysMsgVo = new SysMsgVo(user.getNick(), MsgTemplate.cancelforbidden, user.getNick(),"cancelforbidden");
							WxChatApi.sendGroupMsgEach( null,sysMsgVo.toText(), Const.ContentType.TEXT, user.getId(), groupUser.getGroupid(), Const.YesOrNo.YES,sysMsgVo);
						} catch (Exception e) {
							log.error(e.getMessage(),e);
						}
					}
				}
			} catch (Exception e) {
				log.error(e.getMessage(),e);
			} finally {
				end();
			}
		}
		
	}
	

	/**
	 * 判断计划任务是否可以开始:true：可以运用；false：不可以
	 * @return
	 * @author xufei
	 */
	private static boolean isStart() {
		boolean ret = false;
		synchronized (GroupForbiddenJob.class) {
			ret = isRunning ? false : (isRunning = true); 
		}
		return ret;
	}
	
	/**
	 * 计划任务结束处理
	 * @author xufei
	 */
	private static void end() {
		synchronized (GroupForbiddenJob.class) {
			isRunning = false;
		}
	}

}
