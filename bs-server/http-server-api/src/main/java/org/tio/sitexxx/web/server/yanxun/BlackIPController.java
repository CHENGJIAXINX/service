package org.tio.sitexxx.web.server.yanxun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.server.annotation.RequestPath;
import org.tio.sitexxx.service.model.conf.IpBlackList;
import org.tio.sitexxx.service.service.conf.IpBlackListService;
import org.tio.utils.resp.Resp;

import java.util.List;

@RequestPath(value = "/blackIp")
public class BlackIPController {

    private static Logger log = LoggerFactory.getLogger(BlackIPController.class);

    @RequestPath("/getBlackIp")
    public Resp getBlackIp(){
        List<IpBlackList> list = IpBlackListService.me.getAllIp();
        return Resp.ok(list);

    }
}
