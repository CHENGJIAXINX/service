/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server.timetask;

import java.util.Calendar;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.Tio;
import org.tio.sitexxx.im.server.TioSiteImServerStarter;
import org.tio.sitexxx.service.model.main.StatOnline;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.quartz.AbstractJobWithLog;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

/**
 * 统计在线数据任务
 * @author tanyaowu
 */
public class StatOnlineJob extends AbstractJobWithLog {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(StatOnlineJob.class);

	@Override
	public void run(JobExecutionContext context) throws Exception {
		report();
	}

	public static void report() {
		if (!org.tio.sitexxx.servicecommon.vo.Const.IS_START_IM) {
			return;
		}

		DateTime now = DateUtil.date();
		int second = now.second();
		int x = second % 5;
		Calendar calendar = DateUtil.calendar(now);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.SECOND, -x);
		now = DateUtil.date(calendar);

		StatOnline statOnline = new StatOnline();
		statOnline.setTime(now);
		statOnline.setIp(TioSiteImServerStarter.serverTioConfigWs.ips.getIpmap().size());
		statOnline.setPage(Tio.getAll(TioSiteImServerStarter.serverTioConfigWs).size());
		statOnline.setSession(TioSiteImServerStarter.serverTioConfigWs.tokens.getMap().size());
		statOnline.setLogined(TioSiteImServerStarter.serverTioConfigWs.users.getMap().size());
		statOnline.setGroup(TioSiteImServerStarter.serverTioConfigWs.groups.getGroupmap().size());
		statOnline.setServer(Const.MY_IP_API);

		statOnline.save();
	}
}
