/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server.timetask;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.im.server.handler.wx.call.WxCallUtils;
import org.tio.sitexxx.service.model.main.WxCallItem;
import org.tio.utils.quartz.AbstractJobWithLog;

/**
 * 音视频通话，响应超时检查任务
 * @author tanyaowu
 */
public class WxCallRespTimeoutJob extends AbstractJobWithLog {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(WxCallRespTimeoutJob.class);

	@Override
	public void run(JobExecutionContext context) throws Exception {
		check();
	}

	private static final String sql = "select * from wx_call_item where status = ? and calltime < date_sub(now(), interval 40 second)";

	public static void check() {
		List<WxCallItem> list = WxCallItem.dao.find(sql, WxCallItem.Status.BEGIN_CALLING);
		if (list != null) {
			for (WxCallItem wxCallItem : list) {
				WxCallUtils.endCall(null, wxCallItem.getId(), null, WxCallItem.Hanguptype.RESP_TIMEOUT);
			}
		}
	}
}
