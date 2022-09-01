/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.timetask;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.service.model.main.WxChatItems;
import org.tio.sitexxx.service.service.chat.ChatIndexService;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.jfinal.P;
import org.tio.utils.json.Json;
import org.tio.utils.quartz.AbstractJobWithLog;

import cn.hutool.core.collection.CollectionUtil;

/**
 * 激活会话处理
 * @author xufei
 * 2020年7月3日 下午2:56:29
 */
public class ChatIndexDealJob extends AbstractJobWithLog {

	private static Logger log = LoggerFactory.getLogger(ChatIndexDealJob.class);

	private static boolean isRunning = false;
	
	@Override
	public void run(JobExecutionContext context) throws Exception {
		boolean allowExecute = P.getBoolean("quartz.open.flag",false);
		if(allowExecute && isStart()) {
			try {
				List<WxChatItems> records = WxChatItems.dao.find(
						"select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag"
						+ " from wx_chat_items outtable "
						+ "where not EXISTS"
						+ "(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) "
						+ "and chatmode = 2");
				String ids = "";
				if(CollectionUtil.isNotEmpty(records)) {
					for(WxChatItems record : records) {
						ids += "," + record.getInt("id");
						log.error("删除异常激活会话,{}",Json.toJson(record));
						ChatIndexService.clearChatGroupIndex(record.getBizid(), record.getUid());
					}
					int count = Db.use(Const.Db.TIO_SITE_MAIN).update("delete from wx_chat_items where id in"
							+ " (" + ids.substring(1) +  ")");
					log.error("删除异常激活会话{}条,真实{}条,ids：{}",records.size(),count,ids.substring(1));
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
		synchronized (ChatIndexDealJob.class) {
			ret = isRunning ? false : (isRunning = true); 
		}
		return ret;
	}
	
	/**
	 * 计划任务结束处理
	 * @author xufei
	 */
	private static void end() {
		synchronized (ChatIndexDealJob.class) {
			isRunning = false;
		}
	}

}
