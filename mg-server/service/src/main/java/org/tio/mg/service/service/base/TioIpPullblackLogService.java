package org.tio.mg.service.service.base;

import org.redisson.api.RTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.mg.service.init.RedisInit;
import org.tio.mg.service.model.stat.TioIpPullblackLog;
import org.tio.mg.service.service.conf.IpBlackListService;
import org.tio.mg.service.service.conf.IpWhiteListService;
import org.tio.sitexxx.servicecommon.vo.Const.Topic;
import org.tio.sitexxx.servicecommon.vo.topic.PullIpToBlackVo;

/**
 * @author tanyaowu
 * 2016年10月30日 下午5:00:28
 */
public class TioIpPullblackLogService {

    private static Logger log = LoggerFactory.getLogger(TioIpPullblackLogService.class);

    public static final TioIpPullblackLogService ME = new TioIpPullblackLogService();

    public static void main(String[] args) {

    }

    /**
     * @param tioIpPullblackLog
     * @return
     * @author tanyaowu
     */
    private boolean save(TioIpPullblackLog tioIpPullblackLog) {
        if (tioIpPullblackLog != null) {
            boolean ret = tioIpPullblackLog.save();
            return ret;
        }
        return false;
    }

    /**
     * 把ip拉黑
     *
     * @param tioIpPullblackLog
     */
    public void addToBlack(TioIpPullblackLog tioIpPullblackLog) {
        String ip = tioIpPullblackLog.getIp();
        int serverport = tioIpPullblackLog.getServerport();
        String remark = tioIpPullblackLog.getRemark();

        boolean isWhiteIp = IpWhiteListService.isWhiteIp(ip);
        if (isWhiteIp) {
            log.warn("ip:[{}]是白名单，不允许拉黑。本次拉黑serverport:{}, 原因:{}", ip, serverport, remark);
            return;
        }
        log.warn("ip:{}将被拉黑", ip);
        PullIpToBlackVo pullIpToBlackVo = new PullIpToBlackVo();
        pullIpToBlackVo.setIp(ip);
        pullIpToBlackVo.setRemark(remark);
        RTopic pullIpToBlackTopic = RedisInit.get().getTopic(Topic.PULL_IP_TO_BLACK);
        pullIpToBlackTopic.publish(pullIpToBlackVo);
        TioIpPullblackLogService.ME.save(tioIpPullblackLog);
    }

    public void deleteFromBlack(String ip, int serverport, String remark) {
        log.warn("ip:{}从黑名单中删除", ip);

        PullIpToBlackVo pullIpToBlackVo = new PullIpToBlackVo();
        pullIpToBlackVo.setIp(ip);
        pullIpToBlackVo.setRemark(remark);
        pullIpToBlackVo.setType(PullIpToBlackVo.Type.DELETE_IP_FROM_BLACK);
        RTopic pullIpToBlackTopic = RedisInit.get().getTopic(Topic.PULL_IP_TO_BLACK);
        pullIpToBlackTopic.publish(pullIpToBlackVo);
        IpBlackListService.me.delete(ip, remark);
    }

}
