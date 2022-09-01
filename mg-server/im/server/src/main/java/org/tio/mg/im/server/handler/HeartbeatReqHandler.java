/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.server.handler;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.mg.im.common.Command;
import org.tio.mg.im.common.CommandHandler;
import org.tio.mg.im.common.ImPacket;
import org.tio.mg.im.server.utils.ImUtils;
import org.tio.mg.service.model.main.User;
import org.tio.sitexxx.servicecommon.vo.Devicetype;

/**
 * 心跳包处理者
 * @author tanyaowu 
 * 2016年9月13日 上午9:53:30
 */
@CommandHandler(Command.HeartbeatReq)
public class HeartbeatReqHandler implements ImServerHandler {
	private static Logger log = LoggerFactory.getLogger(HeartbeatReqHandler.class);

	public static final HeartbeatReqHandler me = new HeartbeatReqHandler();

	public HeartbeatReqHandler() {
	}

	@Override
	public void handler(ImPacket packet, ChannelContext channelContext, boolean isWebsocket) throws Exception {
		User curr = ImUtils.getUser(channelContext);
		if(curr != null) {
			Devicetype devicetype = ImUtils.getDevicetype(channelContext);
			try {
				if(Objects.equals(devicetype.getValue(), Devicetype.IOS.getValue()) || Objects.equals(devicetype.getValue(), Devicetype.ANDROID.getValue())) {
					devicetype = Devicetype.APP;
				}
			} catch (Exception e) {
				log.error(e.getMessage(),e);
			}
		}
	}

}
