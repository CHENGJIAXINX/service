/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server.handler;

import org.tio.core.ChannelContext;
import org.tio.sitexxx.im.common.ImPacket;

/**
 * 
 * @author tanyaowu 
 * 2016年9月7日 下午4:34:51
 */
public interface ImServerHandler {
	/**
	 * 
	 * @param packet
	 * @param channelContext
	 * @param isWebsocket
	 * @return
	 * @throws Exception
	 * @author: tanyaowu
	 */
	public void handler(ImPacket packet, ChannelContext channelContext, boolean isWebsocket) throws Exception;

}
