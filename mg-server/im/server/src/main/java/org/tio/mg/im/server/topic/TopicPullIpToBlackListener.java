/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.mg.im.server.topic;

import cn.hutool.core.util.StrUtil;
import org.redisson.api.listener.MessageListener;
import org.tio.core.Tio;
import org.tio.mg.im.server.TioSiteImServerStarter;
import org.tio.sitexxx.servicecommon.vo.topic.PullIpToBlackVo;

import java.util.Objects;

/**
 * @author tanyaowu
 *
 */
public class TopicPullIpToBlackListener implements MessageListener<PullIpToBlackVo> {

    public static final TopicPullIpToBlackListener me = new TopicPullIpToBlackListener();

    @Override
    public void onMessage(CharSequence channel, PullIpToBlackVo pullIpToBlackVo) {
        String ip = pullIpToBlackVo.getIp();
        if (StrUtil.isNotBlank(ip)) {
            if (Objects.equals(pullIpToBlackVo.getType(), PullIpToBlackVo.Type.ADD_BLACK_IP)) {
                Tio.IpBlacklist.add(TioSiteImServerStarter.serverTioConfigApp, ip);
                Tio.IpBlacklist.add(TioSiteImServerStarter.serverTioConfigWs, ip);
            } else {
                Tio.IpBlacklist.remove(TioSiteImServerStarter.serverTioConfigApp, ip);
                Tio.IpBlacklist.remove(TioSiteImServerStarter.serverTioConfigWs, ip);
            }
        }
    }

}
