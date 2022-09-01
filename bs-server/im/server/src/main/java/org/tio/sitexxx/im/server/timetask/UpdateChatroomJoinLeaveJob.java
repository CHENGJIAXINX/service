/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server.timetask;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.quartz.AbstractJobWithLog;

/**
 *  定时更新chatroom_join_leave的数据
 * @author tanyaowu 
 * 2016年10月8日 下午2:28:11
 */
public class UpdateChatroomJoinLeaveJob extends AbstractJobWithLog {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(UpdateChatroomJoinLeaveJob.class);

	@Override
	public void run(JobExecutionContext context) throws Exception {
		report();
	}

	public static void report() {
		if (!org.tio.sitexxx.servicecommon.vo.Const.IS_START_IM) {
			return;
		}

		String sql = "update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = ?";
		Db.use(Const.Db.TIO_SITE_MAIN).update(sql, Const.MY_IP_API);
	}
}
