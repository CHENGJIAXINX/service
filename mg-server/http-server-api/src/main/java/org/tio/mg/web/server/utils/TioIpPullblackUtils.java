/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.mg.web.server.utils;

import org.tio.http.common.HttpConst;
import org.tio.http.common.HttpRequest;
import org.tio.mg.service.model.stat.TioIpPullblackLog;
import org.tio.mg.service.service.base.IpInfoService;
import org.tio.mg.service.service.base.TioIpPullblackLogService;
import org.tio.mg.service.service.conf.IpBlackListService;
import org.tio.sitexxx.servicecommon.vo.Const;

import java.util.Date;

/**
 * @author tanyaowu
 *
 */
public class TioIpPullblackUtils {

    public static void main(String[] args) {

    }

    public static void addToBlack(HttpRequest request, String ip, String remark, byte type) {
        Integer currId = WebUtils.currUserId(request);

        TioIpPullblackLog tioIpPullblackLog = new TioIpPullblackLog();
        tioIpPullblackLog.setIp(ip);
        tioIpPullblackLog.setIpid(IpInfoService.ME.save(request.getClientIp()).getId());
        tioIpPullblackLog.setRemark(remark);
        tioIpPullblackLog.setServer(Const.MY_IP_API);
        tioIpPullblackLog.setServerport(request.getChannelContext().getServerNode().getPort());
        tioIpPullblackLog.setTime(new Date());
        tioIpPullblackLog.setType(type);

        tioIpPullblackLog.setSessionid(request.getHttpSession().getId());
        tioIpPullblackLog.setCookie(request.getHeader(HttpConst.RequestHeaderKey.Cookie));
        tioIpPullblackLog.setInitpath(request.requestLine.getInitPath());
        tioIpPullblackLog.setPath(request.requestLine.getPath());
        tioIpPullblackLog.setRequestline(request.requestLine.toString());
        tioIpPullblackLog.setUid(currId);

        TioIpPullblackLogService.ME.addToBlack(tioIpPullblackLog);

        IpBlackListService.me.save(ip, remark);
    }
}
