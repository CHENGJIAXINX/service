/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.timetask;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.service.model.main.LoginTaskItems;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.jfinal.P;
import org.tio.utils.quartz.AbstractJobWithLog;

import cn.hutool.core.date.DateTime;

/**
 * 备份消息列表
 * @author xufei
 * 2020年7月3日 下午2:56:29
 */
public class LoginStatJob extends AbstractJobWithLog {

	private static Logger log = LoggerFactory.getLogger(LoginStatJob.class);

	private static boolean isRunning = false;
	
	@Override
	public void run(JobExecutionContext context) throws Exception {
		boolean allowExecute = P.getBoolean("quartz.open.flag",false);
		if(allowExecute && isStart()) {
			try {
				log.info("开始-登录统计定时任务");
				DateTime dateTime = new DateTime();
				LoginTaskItems taskItems = new LoginTaskItems();
				taskItems.setIp(Const.MY_IP_API);
				taskItems.setDealtime(dateTime);
				taskItems.setStatus(Const.Status.DISABLED);
				boolean save = taskItems.save();
				if(!save) {
					log.error("登录统计定时任务-保存任务失败");
					return;
				}
				UserService.ME.loginTimeStat(dateTime);
				UserService.ME.loginIpStat(dateTime);
				LoginTaskItems update = new LoginTaskItems();
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
		synchronized (LoginStatJob.class) {
			ret = isRunning ? false : (isRunning = true); 
		}
		return ret;
	}
	
	/**
	 * 计划任务结束处理
	 * @author xufei
	 */
	private static void end() {
		synchronized (LoginStatJob.class) {
			isRunning = false;
		}
	}

}
