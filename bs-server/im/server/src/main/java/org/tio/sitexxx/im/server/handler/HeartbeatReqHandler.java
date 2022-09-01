/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server.handler;

import java.util.Objects;

import org.redisson.Redisson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.sitexxx.im.common.Command;
import org.tio.sitexxx.im.common.CommandHandler;
import org.tio.sitexxx.im.common.ImPacket;
import org.tio.sitexxx.im.server.handler.wx.WxChatQueueApi;
import org.tio.sitexxx.im.server.utils.ImUtils;
import org.tio.sitexxx.service.cache.CacheConfig;
import org.tio.sitexxx.service.cache.Caches;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.Devicetype;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

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
//		System.out.println("心跳 1=========================>uid:"+curr.getId()+"\tisWebsocket:"+isWebsocket);
		//心跳时间存储起来
		if(curr != null) {
			Caches.getCache(CacheConfig.USER_ONLINE_TIME).put(String.valueOf(curr.getId()), System.currentTimeMillis());
			Devicetype devicetype = ImUtils.getDevicetype(channelContext);
			try {
				if(Objects.equals(devicetype.getValue(), Devicetype.IOS.getValue()) || Objects.equals(devicetype.getValue(), Devicetype.ANDROID.getValue())) {
					devicetype = Devicetype.APP;
				}
				if(Objects.equals(devicetype.getValue(), Devicetype.APP.getValue())) {
					String key = curr.getId() + "_" + devicetype;
					if(Const.IM_HEARTBEAT_TIMEOUT <= 20000) {
						Long refreshtime =  (Long) Caches.getCache(CacheConfig.CHAT_FOCUS_REFRESH_TIME_1).get(key);
						if(refreshtime == null || refreshtime <= 0) {
							refreshtime = DateUtil.offsetMillisecond(new DateTime(), Const.FOCUS_REFRESH_TIMEOUT).getTime();
							Caches.getCache(CacheConfig.CHAT_FOCUS_REFRESH_TIME_1).put(key, refreshtime);
							return;
						}
						if(refreshtime <= new DateTime().getTime()) {
							Caches.getCache(CacheConfig.CHAT_FOCUS_REFRESH_TIME_1).remove(key);
							WxChatQueueApi.refreshFocusQueue(curr, devicetype.getValue(),channelContext.getId());
						} 
					} else {
						WxChatQueueApi.refreshFocusQueue(curr, devicetype.getValue(),channelContext.getId());
					}
				} else {
					//pc现在不走配置，直接写死5秒，后期修改后，可执行最后注释代码
					String key = curr.getId() + "_" + devicetype + "_" + channelContext.getId();
					Long refreshtime =  (Long) Caches.getCache(CacheConfig.CHAT_FOCUS_REFRESH_TIME_1).get(key);
					if(refreshtime == null || refreshtime <= 0) {
						refreshtime = DateUtil.offsetMillisecond(new DateTime(), Const.FOCUS_REFRESH_TIMEOUT).getTime();
						Caches.getCache(CacheConfig.CHAT_FOCUS_REFRESH_TIME_1).put(key, refreshtime);
						return;
					}
					if(refreshtime <= new DateTime().getTime()) {
						Caches.getCache(CacheConfig.CHAT_FOCUS_REFRESH_TIME_1).remove(key);
						WxChatQueueApi.refreshFocusQueue(curr, devicetype.getValue(),channelContext.getId());
					} 
				}
				
				//所有客户端都走配置代码
//				String key = curr.getId() + "_" + devicetype;
//				if(!Objects.equals(devicetype.getValue(), Devicetype.APP.getValue())) {
//					//不是app的话，需要记录通道id
//					key += "_" + channelContext.getId();
//				}
//				if(Const.IM_HEARTBEAT_TIMEOUT <= 20000) {
//					Long refreshtime =  (Long) Caches.getCache(CacheConfig.CHAT_FOCUS_REFRESH_TIME_1).get(key);
//					if(refreshtime == null || refreshtime <= 0) {
//						refreshtime = DateUtil.offsetMillisecond(new DateTime(), Const.FOCUS_REFRESH_TIMEOUT).getTime();
//						Caches.getCache(CacheConfig.CHAT_FOCUS_REFRESH_TIME_1).put(key, refreshtime);
//						return;
//					}
//					if(refreshtime <= new DateTime().getTime()) {
//						Caches.getCache(CacheConfig.CHAT_FOCUS_REFRESH_TIME_1).remove(key);
//						WxChatQueueApi.refreshFocusQueue(curr, devicetype.getValue(),channelContext.getId());
//					} 
//				} else {
//					WxChatQueueApi.refreshFocusQueue(curr, devicetype.getValue(),channelContext.getId());
//				}
			} catch (Exception e) {
				log.error(e.getMessage(),e);
			}
		}
	}

}
