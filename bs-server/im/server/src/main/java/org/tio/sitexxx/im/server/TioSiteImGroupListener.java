/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.intf.GroupListener;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.im.common.ImSessionContext;
import org.tio.sitexxx.im.common.utils.ImUtils;
import org.tio.sitexxx.service.model.main.ChatroomJoinLeave;
import org.tio.sitexxx.servicecommon.vo.Const;

/**
 * @author tanyaowu
 * 2016年5月13日 下午10:38:36
 */
public class TioSiteImGroupListener implements GroupListener {
	private static Logger log = LoggerFactory.getLogger(TioSiteImGroupListener.class);

	public static TioSiteImGroupListener me = new TioSiteImGroupListener();

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @author tanyaowu
	 */
	protected TioSiteImGroupListener() {
	}

	/**
	 * @param channelContext
	 * @param group
	 * @throws Exception
	 * @author tanyaowu
	 */
	@Override
	public void onAfterBind(ChannelContext channelContext, String group) throws Exception {
	}

	/**
	 * @param channelContext
	 * @param group
	 * @throws Exception
	 * @author tanyaowu
	 */
	@Override
	public void onAfterUnbind(ChannelContext channelContext, String group) throws Exception {
		ImSessionContext imSessionContext = ImUtils.getImSessionContext(channelContext);
		if (imSessionContext.isWx()) {
			return;
		}
		boolean con = !group.startsWith(Const.ImGroupType.PREFIX);
		if (con) {
			try {
				ChatroomJoinLeave chatroomJoinLeave = imSessionContext.getChatroomJoinLeave();
				if (chatroomJoinLeave != null) {
					if (!chatroomJoinLeave.isChat()) {
						long cost = System.currentTimeMillis() - chatroomJoinLeave.getJointime().getTime();
						String sql = "update chatroom_join_leave set leavetime = ?, cost = ?, status = 1 where id = ?";
						Db.use(Const.Db.TIO_SITE_MAIN).update(sql, new Date(), cost, chatroomJoinLeave.getId());
					}
				}
			} catch (Exception e) {
				log.error("", e);
			}
		}
	}

}
