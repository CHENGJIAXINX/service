/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.chat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import cn.jpush.api.push.PushResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.servicecommon.vo.Const;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosAlert;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import org.tio.utils.json.Json;

/**
 * 推送服务
 * @author xufei
 * 2020年09月25日 下午5:57:32
 */
public class JPushService {
	@SuppressWarnings("unused")
	private static Logger				log	= LoggerFactory.getLogger(JPushService.class);
	public static final JPushService	me	= new JPushService();
	
	private static JPushClient jpushClient = new JPushClient(ConfService.getString(Const.JPushConfig.MASTERSECRET,"e43628eab44fe53688d7b51f"), ConfService.getString(Const.JPushConfig.APPKEY,"f76e1608f92c1c3410b79e2e"), null, ClientConfig.getInstance());
	private static boolean jpushEnv = ConfService.getString("jpushEnv", "1").equals("2");
	/**
	 * 别名发送方式初始化-参数
	 * @param uid
	 * @param fromnick
	 * @param msg
	 * @param chatName
	 * @return
	 * @author xufei
	 * 2020年9月24日 上午10:53:28
	 */
	public static PushPayload initPushAlias(Integer uid,String fromnick,String msg,String chatName,Byte chatmode) {
		Map<String, String> extras = new HashMap<String, String>();
		extras.put("chatName", chatName);
		extras.put("nick",fromnick);
		extras.put("text",msg);
		extras.put("chatlinkid","");
		if(Objects.equals(chatmode, Const.ChatMode.GROUP)) {
			msg = fromnick + "：" + msg;
		}
		return initPushAlias(uid, msg, extras,chatName);
	}
	
	/**
	 * 别名发送方式初始化-参数-群组
	 * @param uid
	 * @param fromnick
	 * @param msg
	 * @param chatName
	 * @return
	 * @author xufei
	 * 2020年9月24日 上午11:19:41
	 */
	public static PushPayload initPushAlias(List<String> uid,String fromnick,String msg,String chatName,Byte chatmode) {
		Map<String, String> extras = new HashMap<String, String>();
		extras.put("chatName", chatName);
		extras.put("nick",fromnick);
		extras.put("text",msg);
		extras.put("chatlinkid","");
		if(Objects.equals(chatmode, Const.ChatMode.GROUP)) {
			msg = fromnick + "：" + msg;
		}
		return initPushAlias(uid, msg, extras,chatName);
	}

	/**
	 * 别名发送方式初始化-参数
	 * @param uid
	 * @param fromnick
	 * @param msg
	 * @param chatName
	 * @param chatlinkid
	 * @return
	 * @author xufei
	 * 2020年9月24日 上午10:53:02
	 */
	public static PushPayload initPushAlias(Integer uid,String fromnick,String msg,String chatName,Long chatlinkid,Byte chatmode) {
		Map<String, String> extras = new HashMap<String, String>();
		extras.put("chatName", chatName);
		extras.put("nick",fromnick);
		extras.put("text",msg);
		extras.put("chatlinkid",chatlinkid + "");
		if(Objects.equals(chatmode, Const.ChatMode.GROUP)) {
			msg = fromnick + "：" + msg;
		}
		return initPushAlias(uid, msg, extras,chatName);
	}
	
	/**
	 * 别名发送方式初始化-单条
	 * @param uid
	 * @param chatName
	 * @param msg
	 * @return
	 * @author xufei
	 * 2020年9月24日 上午10:29:53
	 */
	public static PushPayload initPushAlias(Integer uid,String msg,Map<String, String> extras,String title) {
		Notification notification = Notification.newBuilder()
                .addPlatformNotification(AndroidNotification.newBuilder()
                        .setAlert(msg)
                        .setTitle(title)
                        .addExtras(extras)
                        .build())
                .addPlatformNotification(IosNotification.newBuilder()
                		.setAlert(IosAlert.newBuilder().setTitleAndBody(title, "", msg).build())
                        .addExtras(extras)
                        .build())
                    .build();
		PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all())
				.setAudience(Audience.alias(uid + ""))
				.setNotification(notification)
				.setOptions(Options.newBuilder().setApnsProduction(jpushEnv).build())
				.build();
		return payload;
	}
	
	/**
	 * 别名发送方式初始化-群组
	 * @param uid
	 * @param msg
	 * @param extras
	 * @return
	 * @author xufei
	 * 2020年9月24日 上午11:19:15
	 */
	public static PushPayload initPushAlias(List<String> uid,String msg,Map<String, String> extras,String title) {
		Notification notification = Notification.newBuilder()
                .addPlatformNotification(AndroidNotification.newBuilder()
                        .setAlert(msg)
                        .setTitle(title)
                        .addExtras(extras)
                        .build())
                .addPlatformNotification(IosNotification.newBuilder()
                		.setAlert(IosAlert.newBuilder().setTitleAndBody(title, "", msg).build())
                        .addExtras(extras)
                        .build())
                    .build();
		PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all())
				.setAudience(Audience.alias(uid))
				.setNotification(notification)
				.setOptions(Options.newBuilder().setApnsProduction(jpushEnv).build())
				.build();
		return payload;
	}
	
	
	/**
	 * 注册id方式初始化-参数
	 * @param uid
	 * @param fromnick
	 * @param msg
	 * @param chatName
	 * @return
	 * @author xufei
	 * 2020年9月24日 上午10:53:28
	 */
	public static PushPayload initPushReg(String regid,String fromnick,String msg,String chatName,Byte chatmode) {
		Map<String, String> extras = new HashMap<String, String>();
		extras.put("chatName", chatName);
		extras.put("nick",fromnick);
		extras.put("text",msg);
		extras.put("chatlinkid","");
		if(Objects.equals(chatmode, Const.ChatMode.GROUP)) {
			msg = fromnick + "：" + msg;
		}
		return initPushReg(regid, msg, extras,chatName);
	}
	
	/**
	 *  注册id方式初始化-参数-群组
	 * @param uid
	 * @param fromnick
	 * @param msg
	 * @param chatName
	 * @return
	 * @author xufei
	 * 2020年9月24日 上午11:19:41
	 */
	public static PushPayload initPushReg(List<String> regids,String fromnick,String msg,String chatName,Byte chatmode) {
		Map<String, String> extras = new HashMap<String, String>();
		extras.put("chatName", chatName);
		extras.put("nick",fromnick);
		extras.put("text",msg);
		extras.put("chatlinkid","");
		if(Objects.equals(chatmode, Const.ChatMode.GROUP)) {
			msg = fromnick + "：" + msg;
		}
		return initPushReg(regids, msg, extras,chatName);
	}
	
	
	/**
	 * 注册id方式初始化-参数
	 * @param regid
	 * @param fromnick
	 * @param msg
	 * @param chatName
	 * @param chatlinkid
	 * @return
	 * @author xufei
	 * 2020年9月24日 下午6:30:16
	 */
	public static PushPayload initPushReg(String regid,String fromnick,String msg,String chatName,Long chatlinkid,Byte chatmode) {
//		System.out.println("appKey:"+ConfService.getString(Const.JPushConfig.APPKEY,"f76e1608f92c1c3410b79e2e"));
//		System.out.println("secret:"+ConfService.getString(Const.JPushConfig.MASTERSECRET,"e43628eab44fe53688d7b51f"));

		Map<String, String> extras = new HashMap<String, String>();
		extras.put("chatName", chatName);
		extras.put("nick",fromnick);
		extras.put("text",msg);
		extras.put("chatlinkid",chatlinkid + "");

//		String mMsg = String.format("uid:%s,msg:%s,extras:%s,title:%s", regid, msg, extras.toString(), chatName);
//		System.out.println("msg==>"+mMsg);

		if(Objects.equals(chatmode, Const.ChatMode.GROUP)) {
			msg = fromnick + "：" + msg;
		}
		return initPushReg(regid, msg, extras,chatName);
	}
	
	/**
	 * 注册id方式初始化-单条记录
	 * @param regid
	 * @param msg
	 * @param extras
	 * @return
	 * @author xufei
	 * 2020年9月24日 下午6:29:33
	 */
	public static PushPayload initPushReg(String regid,String msg,Map<String, String> extras,String title) {
		Notification notification = Notification.newBuilder()
                .addPlatformNotification(AndroidNotification.newBuilder()
                        .setAlert(msg)
                        .setTitle(title)
                        .addExtras(extras)
                        .build())
                .addPlatformNotification(IosNotification.newBuilder()
                		.setAlert(IosAlert.newBuilder().setTitleAndBody(title, "", msg).build())
                        .addExtras(extras)
                        .build())
                    .build();
		PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all())
				.setAudience(Audience.registrationId(regid))
				.setNotification(notification)
				.setOptions(Options.newBuilder().setApnsProduction(jpushEnv).build())
				.build();
		return payload;
	}
	
	/**
	 * 注册id方式初始化-列表
	 * @param regids
	 * @param msg
	 * @param extras
	 * @return
	 * @author xufei
	 * 2020年9月24日 下午6:28:00
	 */
	public static PushPayload initPushReg(List<String> regids,String msg,Map<String, String> extras,String title) {
		Notification notification = Notification.newBuilder()
                .addPlatformNotification(AndroidNotification.newBuilder()
                        .setAlert(msg)
                        .setTitle(title)
                        .addExtras(extras)
                        .build())
                .addPlatformNotification(IosNotification.newBuilder()
                		.setAlert(IosAlert.newBuilder().setTitleAndBody(title, "", msg).build())
                        .addExtras(extras)
                        .build())
                    .build();
		PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all())
				.setAudience(Audience.registrationId(regids))
				.setNotification(notification)
				.setOptions(Options.newBuilder().setApnsProduction(jpushEnv).build())
				.build();
		return payload;
	}
	
	/**
	 * @param payload
	 * @author xufei
	 * 2020年9月24日 上午10:45:39
	 */
	public static void send(PushPayload payload,Byte chatmode) {
		try {
		    PushResult result = jpushClient.sendPush(payload);
//			jpushClient.sendPush(payload);
		    log.error("推送信息：payload:{},result:{},chatmode:{}", Json.toJson(payload),Json.toJson(result),chatmode);
		    Thread.sleep(5000);
		    // 请求结束后，调用 NettyHttpClient 中的 close 方法，否则进程不会退出。
		    jpushClient.close();
		} catch(Exception e) {
		    e.printStackTrace();
		}
	}

//	System.out.println("appKey:"+ConfService.getString(Const.JPushConfig.APPKEY,"f76e1608f92c1c3410b79e2e"));
//		System.out.println("secret:"+ConfService.getString(Const.JPushConfig.MASTERSECRET,"e43628eab44fe53688d7b51f"));
//	String mMsg = String.format("uid:%s,msg:%s,extras:%s,title:%s", uid, msg, extras.toString(), title);
//		System.out.println("msg==>"+mMsg);
}
