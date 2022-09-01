/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server.ws;

import org.tio.core.ChannelContext;
import org.tio.sitexxx.im.server.TioSiteImGroupListener;

/**
 * @author tanyaowu
 * 2016年5月13日 下午10:38:36
 */
public class ImWsGroupListener extends TioSiteImGroupListener {
	public static final ImWsGroupListener me = new ImWsGroupListener();

	/**
	 *
	 * @author tanyaowu
	 */
	private ImWsGroupListener() {
	}

	/**
	 * @param channelContext
	 * @param group
	 * @throws Exception
	 * @author tanyaowu
	 */
	@Override
	public void onAfterBind(ChannelContext channelContext, String group) throws Exception {
		super.onAfterBind(channelContext, group);
	}

	/**
	 * @param channelContext
	 * @param group
	 * @throws Exception
	 * @author tanyaowu
	 */
	@Override
	public void onAfterUnbind(ChannelContext channelContext, String group) throws Exception {
		super.onAfterUnbind(channelContext, group);
	}
}
