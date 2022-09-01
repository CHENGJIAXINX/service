/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.topic;

import java.util.Map;
import java.util.Objects;

import com.alibaba.fastjson.JSON;
import org.redisson.api.listener.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.init.PropInit;
import org.tio.sitexxx.service.service.base.SensitiveWordsService;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.chat.ChatMsgService;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.service.conf.DictService;
import org.tio.sitexxx.service.service.conf.IpWhiteListService;
import org.tio.sitexxx.servicecommon.vo.topic.TopicVo;
import org.tio.utils.jfinal.P;

import cn.hutool.core.util.StrUtil;
import org.tio.utils.json.Json;

/**
 * @author tanyaowu 
 * 2016年11月8日 下午4:05:52
 */
public class TopicCommonListener implements MessageListener<TopicVo> {
	private static Logger log = LoggerFactory.getLogger(TopicCommonListener.class);

	public static TopicCommonListener ME = new TopicCommonListener();

	/**
	 * 
	 * @author tanyaowu
	 */
	private TopicCommonListener() {
	}

	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {

	}

	@Override
	public void onMessage(CharSequence channel, TopicVo msg) {
		System.out.println("redis推送："+ JSON.toJSONString(msg));
		String clientid = msg.getClientId();
		if (StrUtil.isBlank(clientid)) {
			log.error("clientid is null");
			return;
		}
		if (Objects.equals(TopicVo.CLIENTID, clientid)) {
			log.info("自己发布的消息,{}", clientid);
			return;
		}
		Byte type = msg.getType();
		if (Objects.equals(type, TopicVo.Type.CLEAR_DICT)) {
			//清空字典信息
			DictService.clearDict();
		} else if (Objects.equals(type, TopicVo.Type.CLEAR_CONF)) {
			//清空系统参数
			ConfService.clearCache();
		} else if (Objects.equals(type, TopicVo.Type.CLEAR_USER)) {
			//清空用户缓存，后台修改用户相关信息
			Integer uid = (Integer) msg.getValue();
			System.out.println("清除用户信息："+uid);
			UserService.ME._clearCache(uid);
		} else if (Objects.equals(type, TopicVo.Type.CLEAR_ALL_USER)) {
			UserService.ME.notifyClearCache(null);
		} else if (Objects.equals(type, TopicVo.Type.CLEAR_ALL_CONF)) {
			ConfService.clearCache();
			P.clear();
			PropInit.forceInit();
		} else if (Objects.equals(type, TopicVo.Type.CLEAR_IP_WHITE_LIST)) {
			//ip白名单缓存清空
			IpWhiteListService.clearCache();
		}else if(Objects.equals(type, TopicVo.Type.CLEAR_WORD)){
			SensitiveWordsService.init();
		}
	}
}
