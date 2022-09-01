/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.pay.service.timetask;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.service.model.main.WxUserSendRedItem;
import org.tio.sitexxx.service.pay.base.BasePayResp;
import org.tio.sitexxx.service.pay.impl.pay5u.Pay5uApi;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.PayConst;
import org.tio.utils.jfinal.P;
import org.tio.utils.quartz.AbstractJobWithLog;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

/**
 * 红包查询记录
 * @author xufei
 * 2020年7月3日 下午2:56:29
 */
public class RedpacketQueryJob extends AbstractJobWithLog {

	private static Logger log = LoggerFactory.getLogger(RedpacketQueryJob.class);

	private static boolean isRunning = false;
	
	private Pay5uApi Pay5uApi = new Pay5uApi();
	
	@Override
	public void run(JobExecutionContext context) throws Exception {
		boolean allowExecute = P.getBoolean("quartz.open.flag",false);
		if(allowExecute && isStart()) {
			try {
				Short paytimeout = ConfService.getShort(Const.ConfMapping.WX_WALLET_REDPACKET_PAY_TIMEOUT, (short) 5);
				String initPayTimeDeal = DateUtil.format(DateUtil.offsetMinute(new DateTime(), - paytimeout - 1),DatePattern.NORM_DATETIME_PATTERN);
				log.info("红包查询未支付定时任务处理开始:{}",initPayTimeDeal);
				List<WxUserSendRedItem> payDeals = WxUserSendRedItem.dao.find("select  * from wx_user_send_red_item where querysyn = ? and bizcreattime <= ?",PayConst.QuerySyn.NO,initPayTimeDeal);
				if(CollectionUtil.isNotEmpty(payDeals)) {
					for(WxUserSendRedItem item : payDeals) {
						BasePayResp basePayResp = Pay5uApi.redpacketAgainCallback(item);
						if(!basePayResp.isOk()) {
							log.error("定时处理红包查询未支付订单异常：{}",basePayResp.getMsg());
						}
					}
				}
				Short timeout = ConfService.getShort(Const.ConfMapping.WX_WALLET_SENDREDPACKET_TIMEOUT, (short) 1440);
				String initTimeDeal = DateUtil.format(DateUtil.offsetMinute(new DateTime(), - timeout - 1),DatePattern.NORM_DATETIME_PATTERN);
				log.info("红包查询超时任务处理开始:{}",initTimeDeal);
				List<WxUserSendRedItem> initDeals = WxUserSendRedItem.dao.find("select  * from wx_user_send_red_item where bizcreattime <= ? and querysyn != ? ",initTimeDeal,PayConst.QuerySyn.SUCCESS);
				if(CollectionUtil.isNotEmpty(initDeals)) {
					for(WxUserSendRedItem item : initDeals) {
						BasePayResp basePayResp = Pay5uApi.redpacketAgainCallback(item);
						if(!basePayResp.isOk()) {
							log.error("红包查询超时订单异常：{}",basePayResp.getMsg());
						}
					}
				}
				log.info("红包查询定时任务处理结束");
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
		synchronized (RedpacketQueryJob.class) {
			ret = isRunning ? false : (isRunning = true); 
		}
		return ret;
	}
	
	/**
	 * 计划任务结束处理
	 * @author xufei
	 */
	private static void end() {
		synchronized (RedpacketQueryJob.class) {
			isRunning = false;
		}
	}

}
