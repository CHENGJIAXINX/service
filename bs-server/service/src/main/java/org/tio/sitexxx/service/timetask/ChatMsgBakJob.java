/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.timetask;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.service.model.main.WxTaskItems;
import org.tio.sitexxx.service.service.chat.ChatMsgService;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.jfinal.P;
import org.tio.utils.quartz.AbstractJobWithLog;

import cn.hutool.core.date.DateTime;

/**
 * 备份消息列表
 * @author xufei
 * 2020年7月3日 下午2:56:29
 */
public class ChatMsgBakJob extends AbstractJobWithLog {

	private static Logger log = LoggerFactory.getLogger(ChatMsgBakJob.class);

	private static boolean isRunning = false;
	
	@Override
	public void run(JobExecutionContext context) throws Exception {
		boolean allowExecute = P.getBoolean("quartz.open.flag",false);
		if(allowExecute && isStart()) {
			try {
				log.info("开始-备份超时限的消息");
				DateTime dateTime = new DateTime();
				WxTaskItems taskItems = new WxTaskItems();
				taskItems.setIp(Const.MY_IP_API);
				taskItems.setDealtime(dateTime);
				taskItems.setStatus(Const.Status.DISABLED);
				taskItems.setType(Const.WxTaskType.BAK_MSG);
				boolean save = taskItems.save();
				if(!save) {
					log.error("定时任务备份消息-保存任务失败");
					return;
				}
				int fdMsg = ChatMsgService.me.bakFriendMsg(dateTime);
				log.info("备份好友消息{}条，dealtime:{}",fdMsg,dateTime);
				int groupMsg = ChatMsgService.me.bakGroupMsg(dateTime);
				log.info("备份群消息{}条，dealtime:{}",groupMsg,dateTime);
				int noChatGroupMsg = ChatMsgService.me.delGroupInvalidMsg();
				log.info("删除无效群消息{}条，dealtime:{}",noChatGroupMsg,dateTime);
				int invalidBakCount = ChatMsgService.me.bakGroupInvalidMsg();
				log.info("备份无效群有效消息{}条，dealtime:{}",invalidBakCount,dateTime);
				int invalidUpadteCount =  ChatMsgService.me.updateGroupInvalidMsg();
				log.info("修改无效群有效消息状态{}条，dealtime:{}",invalidUpadteCount,dateTime);
				log.info("结束备份超时限的消息");
				WxTaskItems update = new WxTaskItems();
				update.setId(taskItems.getId());
				update.setStatus(Const.Status.DELETE);
				update.update();
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
		synchronized (ChatMsgBakJob.class) {
			ret = isRunning ? false : (isRunning = true); 
		}
		return ret;
	}
	
	/**
	 * 计划任务结束处理
	 * @author xufei
	 */
	private static void end() {
		synchronized (ChatMsgBakJob.class) {
			isRunning = false;
		}
	}

}
