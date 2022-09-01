package org.tio.mg.web.server.init;

import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.tio.mg.service.init.RedisInit;
import org.tio.mg.web.server.topic.TopicClearHttpCacheListener;
import org.tio.mg.web.server.topic.TopicPullIpToBlackListener;
import org.tio.sitexxx.servicecommon.vo.ClearHttpCache;
import org.tio.sitexxx.servicecommon.vo.Const.Topic;
import org.tio.sitexxx.servicecommon.vo.topic.PullIpToBlackVo;

/**
 * @author tanyaowu
 *
 */
public class TopicInit {

	/**
	 *
	 */
	public TopicInit() {
	}

	public static void init() {
		RedissonClient redisson = RedisInit.get();
		RTopic topic = redisson.getTopic(Topic.CLEAR_HTTP_CACHE);
		topic.addListener(ClearHttpCache.class, TopicClearHttpCacheListener.me);

		RTopic pullIpToBlackTopic = redisson.getTopic(Topic.PULL_IP_TO_BLACK);
		pullIpToBlackTopic.addListener(PullIpToBlackVo.class, TopicPullIpToBlackListener.me);

	}
}
