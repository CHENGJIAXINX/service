/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.pay.service.timetask;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.im.server.handler.wx.WxChatApi;
import org.tio.sitexxx.service.model.main.YxTransAccounts;
import org.tio.sitexxx.service.model.main.YxUserSendRedPacket;
import org.tio.sitexxx.service.model.main.YxUserWallet;
import org.tio.sitexxx.service.service.atom.AbsAtom;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletDetailTypeNum;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.wx.TransAmountVo;
import org.tio.utils.jfinal.P;
import org.tio.utils.json.Json;
import org.tio.utils.quartz.AbstractJobWithLog;
import org.tio.utils.resp.Resp;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * 红包查询记录
 * @author xufei
 * 2020年7月3日 下午2:56:29
 */
public class TransAmountStatusJob extends AbstractJobWithLog {

	private static Logger log = LoggerFactory.getLogger(TransAmountStatusJob.class);

	private static boolean isRunning = false;
	
	private final static long red_packet_timeout = 24 * 60 * 60 *1000;
	
	@Override
	public void run(JobExecutionContext context) throws Exception {
		boolean allowExecute = P.getBoolean("quartz.open.flag",false);
		if(allowExecute && isStart()) {
			try {
				log.info("进入JobExecutionContext 转账状态定时任务");
				List<YxTransAccounts> yxTransAccounts = YxTransAccounts.dao.find("select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)");
				for (YxTransAccounts transAccount : yxTransAccounts){
					String[] txMsg = new String[1];
					AbsAtom absAtom = new AbsAtom() {
						@Override
						public boolean run() throws SQLException {
							YxUserWallet fromWallet = WalletService.ME.queryByUid(transAccount.getFromUid());

							Ret payRet = WalletService.ME.modifyBalance(WalletDetailTypeNum.TRANS, 1, transAccount.getAmount(),
									fromWallet.getId(), null, null, "转账退还", transAccount.getId(), transAccount.getSerial(), false);

							if (payRet.isFail()){
								txMsg[0] = RetUtils.getRetMsg(payRet);
								return false;
							}
							transAccount.setStatus(4);
							transAccount.setBacktime(new Date());
							if (transAccount.update()){
								return true;
							}
							txMsg[0] = "退还失败";
							return false;
						}
					};
					boolean tx = Db.use(Const.Db.TIO_SITE_MAIN).tx(absAtom);
					if (tx){
						TransAmountVo transAmountVo = new TransAmountVo();
						transAmountVo.setSerial(transAccount.getSerial());
						transAmountVo.setAmount(transAccount.getAmount());
						transAmountVo.setStatus(5);
						transAmountVo.setType(2);
						transAmountVo.setId(transAccount.getId());
						transAmountVo.setRemark(transAccount.getRemark());

						String text = Json.toJson(transAmountVo);
						Ret ret = null;
						try {
							ret = WxChatApi.sendFdMsgEach((HttpRequest) null, text, Const.ContentType.TRANS_AMOUNT, transAccount.getToUid(), transAccount.getFromUid(),Const.YesOrNo.NO);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}catch (Exception e){
				e.printStackTrace();
				log.error(e.getMessage(),e);
			}finally {
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
		synchronized (TransAmountStatusJob.class) {
			ret = isRunning ? false : (isRunning = true); 
		}
		return ret;
	}
	
	/**
	 * 计划任务结束处理
	 * @author xufei
	 */
	private static void end() {
		synchronized (TransAmountStatusJob.class) {
			isRunning = false;
		}
	}

}
