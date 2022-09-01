package org.tio.mg.web.server.utils;

import org.tio.http.common.HttpRequest;
import org.tio.mg.service.model.mg.MgUser;
import org.tio.mg.service.service.yxnxun.other.MgOperVo;
import org.tio.utils.json.Json;

public class MgOperRequestUtils {

    public static MgOperVo getRequestInfo(HttpRequest request){
        MgOperVo vo = new MgOperVo();
        MgUser mgUser = WebUtils.currUser(request);
        vo.setUid(mgUser.getId());
        vo.setUsername(mgUser.getNick());
        vo.setIp(request.getClientIp());
        vo.setParam(Json.toJson(request.getParam()));
        return vo;
    }


}
