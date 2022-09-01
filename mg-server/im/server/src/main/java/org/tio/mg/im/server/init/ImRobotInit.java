/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.server.init;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.Node;
import org.tio.core.Tio;
import org.tio.mg.im.common.Command;
import org.tio.mg.im.common.ImPacket;
import org.tio.mg.im.common.ImSessionContext;
import org.tio.mg.im.common.bs.HandshakeReq;
import org.tio.mg.im.common.bs.JoinGroupNtf;
import org.tio.mg.im.server.Ims;
import org.tio.mg.im.server.TioSiteImServerStarter;
import org.tio.mg.im.server.handler.PageOnlineReqHandler;
import org.tio.mg.im.server.utils.ImUtils;
import org.tio.mg.service.model.main.User;
import org.tio.mg.service.service.base.UserService;
import org.tio.mg.service.service.conf.MgConfService;
import org.tio.mg.service.utils.LogUtils;
import org.tio.mg.service.vo.SimpleUser;
import org.tio.server.ServerChannelContext;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.Devicetype;
import org.tio.sitexxx.servicecommon.vo.GroupStat;
import org.tio.sitexxx.servicecommon.vo.MobileInfo;
import org.tio.utils.jfinal.P;

import cn.hutool.core.util.RandomUtil;

/**
 * @author tanyaowu
 *
 */
public class ImRobotInit {
	private static Logger							log						= LoggerFactory.getLogger(ImRobotInit.class);
	static String									group					= "/doc/156";
	static Devicetype								devicetype				= Devicetype.ANDROID;
	private final static int						ROBOT_IP_COUNT_MAX		= 60;
	private final static int						ROBOT_IP_COUNT_INIT		= 50;
	private final static int						ROBOT_IP_COUNT_MIN		= 18;
	public final static List<ServerChannelContext>	ROBOT_CHANNELCONTEXTS	= new ArrayList<>(ROBOT_IP_COUNT_MAX);
	public final static Set<Integer>				ROBOT_UIDS				= new HashSet<>(ROBOT_IP_COUNT_MAX);

	public static void init() {
		boolean loadRobot = P.getInt("im.robot.load", 1) == 1;
		if (!loadRobot) {
			return;
		}

		UserService.ME.initRobot();
		LogUtils.logJvmStartTime("UserService.ME.initRobot()");

		

		Thread addRobotThread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < ROBOT_IP_COUNT_INIT; i++) {
					joinRandomSameUser(true);
				}
//				LogUtils.logJvmStartTime("joinRandomSameUser(true)");
				
				while (true) {
					try {
						int robotIpCount = ROBOT_UIDS.size();

						int realIpCountDouble = TioSiteImServerStarter.serverTioConfigApp.ips.getIpmap().size() * 2;

						int min1 = Math.max(realIpCountDouble, ROBOT_IP_COUNT_MIN);
						if (robotIpCount > min1) {
							int c = RandomUtil.randomInt(1, Math.min(3, robotIpCount - 2));
							for (int i = 0; i < c; i++) {
								leaveOne();
							}
						}

						int max1 = Math.min(realIpCountDouble, ROBOT_IP_COUNT_MAX);
						if (robotIpCount < max1) {
							int c = RandomUtil.randomInt(1, 3);
							for (int i = 0; i < c; i++) {
								joinRandomSameUser(false);
							}
						}
					} catch (Exception e) {
						log.error(e.toString(), e);
					} finally {
						try {
							Thread.sleep(1000 * MgConfService.getInt("im.robot.sleep.time", 30));
						} catch (InterruptedException e) {
							log.error(e.toString(), e);
						}
					}
				}
			}
		});
		addRobotThread.setName("tio-site-add-im-robot");
		addRobotThread.start();
	}

	private static long seq = 1;

	public static void joinRandomSameUser(boolean isInit) {
		User user = UserService.ME.nextRobot();
		if (user == null) {
			return;
		}
		int max = seq++ % 2 == 0 ? 1 : 5;
		int count;
		if (max == 1) {
			count = 1;
		} else {
			count = RandomUtil.randomInt(1, max);
		}

		for (int j = 0; j < count; j++) {
			joinOne(user);
			if (!isInit) {
				try {
					Thread.sleep(RandomUtil.randomLong(300, 3000));
				} catch (InterruptedException e) {
					log.error(e.toString(), e);
				}
			}
		}
	}

	public static void joinOne(User user) {
		if (user == null) {
			return;
		}
		ROBOT_UIDS.add(user.getId());
		String uuid = RandomUtil.randomInt(1, 1000) + TioSiteImServerStarter.serverTioConfigApp.getTioUuid().uuid();
		ServerChannelContext channelContext = new ServerChannelContext(TioSiteImServerStarter.serverTioConfigApp, uuid);
		//		System.out.println("timeCreated: " + channelContext.stat.timeCreated + ", nick: " + user.getNick() + ", id: " + user.getId());

		ImSessionContext imSessionContext = new ImSessionContext();
		channelContext.setAttribute(Const.IM_SESSION_KEY, imSessionContext);

		String ip = org.tio.mg.service.utils.IpUtils.randomIp();
		channelContext.setClientNode(new Node(ip, RandomUtil.randomInt(1030, 65530)));

		//RandomUtil.randomEle(rebotDevicetypeList);

		MobileInfo mobileInfo = new MobileInfo();
		mobileInfo.setAppversion("1.99");
		mobileInfo.setCid("9999");

		if (devicetype == Devicetype.IOS) {
			mobileInfo.setDeviceinfo("iphone8");
		} else {
			mobileInfo.setDeviceinfo("huawei p20");
		}
		mobileInfo.setDevicetype(devicetype.getValue());
		mobileInfo.setImei(RandomUtil.randomString(16));
		mobileInfo.setOperator("电信");
		mobileInfo.setResolution("1200,345");
		mobileInfo.setSize("6.6");
		HandshakeReq handshakeReq = new HandshakeReq();
		handshakeReq.setMobileInfo(mobileInfo);
		imSessionContext.setHandshakeReq(handshakeReq);

		Tio.bindGroup(channelContext, Const.ImGroupType.REAL + group);
		Tio.bindGroup(channelContext, Const.ImGroupType.ALL + devicetype + group);
		Tio.bindGroup(channelContext, Const.ImGroupType.REAL + devicetype + group);
		Tio.bindGroup(channelContext, group);
		Tio.bindGroup(channelContext, Const.ImGroupType.ALL_IN_ONE);

		ImUtils.setHandshakeUser(channelContext, user);

		//发进群组通知
		SimpleUser simpleUser = ImUtils.getHandshakeSimpleUser(channelContext);
		simpleUser.setGroupid(group);
		simpleUser.setMobileInfo(mobileInfo);

		GroupStat groupStat = Ims.createGroupStat(group);
		// 暂时获取在所有页面上的用户
		groupStat = Ims.createGroupStat(Const.ImGroupType.ALL_IN_ONE);

		PageOnlineReqHandler.ME.clearCache(group);//进出群组要清空在线观众列表的数据
		JoinGroupNtf joinGroupNtf = new JoinGroupNtf();
		joinGroupNtf.setG(group);
		joinGroupNtf.setOnline(groupStat.getCalcOnline());
		joinGroupNtf.setU(simpleUser);
		joinGroupNtf.setIpcount(Ims.getIpCount());
		//		afterHandlerOperator(channelContext, g, simpleUser == null ? null : simpleUser.getI());
		//		if (simpleUser != null) {
		//			JoinerVo joinerVo = RoomOperatorMainService.me.getJoinerInfo(simpleUser.getI(), g);
		//			simpleUser.setM(joinerVo.getJoinType());
		//		}
		ImPacket joinGroupNotifyPacket = new ImPacket(Command.JoinGroupNtf, joinGroupNtf);
		Ims.sendToGroup(Const.ImGroupType.ALL_IN_ONE, joinGroupNotifyPacket);

		ROBOT_CHANNELCONTEXTS.add(channelContext);
	}

	public static void leaveOne() {
		if (ROBOT_CHANNELCONTEXTS.size() > 0) {
			int index = 0;
			ServerChannelContext channelContext = ROBOT_CHANNELCONTEXTS.get(index);

			//			SimpleUser simpleUser = ImUtils.getHandshakeSimpleUser(channelContext);
			//			System.out.println(channelContext.getId() + ", " + simpleUser.getI() + ", " + ROBOT_CHANNELCONTEXTS.size());

			Tio.unbindGroup(channelContext);

			ROBOT_CHANNELCONTEXTS.remove(channelContext);

			User user = ImUtils.getHandshakeUser(channelContext);
			if (user != null) {
				ROBOT_UIDS.remove(user.getId());
			}

		}

	}

}
