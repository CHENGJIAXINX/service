package org.tio.sitexxx.service.utils;

import org.tio.http.common.HttpRequest;
import org.tio.sitexxx.service.pay.base.BasePayReq;
import org.tio.sitexxx.servicecommon.vo.Devicetype;
import org.tio.sitexxx.service.vo.RequestExt;
import org.tio.sitexxx.servicecommon.vo.RequestKey;

public class CommonUtilss {
    /**
     * @param PayQuest
     * @return
     * @author xufei
     * 2020年11月22日 下午9:19:59
     */
    public static RequestExt getReqExt(BasePayReq PayQuest) {
        HttpRequest request = PayQuest.getRequest();
        return  getReqExt(request);
    }

    /**
     * @param request
     * @return
     * @author xufei
     * 2020年11月22日 下午9:19:59
     */
    public static RequestExt getReqExt(HttpRequest request) {
        if(request == null) {
            return null;
        }
        return (RequestExt)request.getAttribute(RequestKey.REQUEST_EXT);
    }

    /**
     * 设备
     * @param ext
     * @return
     * @author xufei
     * 2020年11月22日 下午9:19:56
     */
    public static Byte getDeviceType(RequestExt ext) {
        if(ext == null) {
            return Devicetype.SYS_TASK.getValue();
        }
        return ext.getDeviceType();
    }

    /**
     * 客户端ip
     * @return
     * @author xufei
     * 2020年11月22日 下午9:22:42
     */
    public static String getIp(HttpRequest request) {
        if(request == null) {
            return "0.0.0.0";
        }
        return request.getClientIp();
    }


    /**
     * app版本号
     * @param ext
     * @return
     * @author xufei
     * 2020年11月22日 下午9:23:47
     */
    public static String getAppVersion(RequestExt ext) {
        if(ext == null) {
            return "0.0.0";
        }
        return ext.getAppVersion();
    }
}
