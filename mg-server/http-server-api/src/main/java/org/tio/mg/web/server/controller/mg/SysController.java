package org.tio.mg.web.server.controller.mg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.mg.service.service.conf.MgConfService;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.resp.Resp;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统管理控制器
 */
@RequestPath(value = "/sys")
public class SysController {

    private static Logger log = LoggerFactory.getLogger(SysController.class);

    /**
     * 页面系统参数
     *
     * @param request
     * @return
     */
    @RequestPath(value = "/params")
    public Resp operdisable(HttpRequest request) {
        Map<String, Object> param = new HashMap<>();
        param.put("res.server", Const.RES_SERVER);
        param.put("site", Const.SITE);
        param.put(Const.ModelKey.GOOGLE_AUTH, MgConfService.getString("isOpen.admin.googleCheck", "2"));
        param.put("bsResUrl", MgConfService.getString("bsResUrl", Const.RES_SERVER));
        String sitename = MgConfService.getString("sitename", "鸽哒");
        param.put("sitename", sitename);
        param.put("tioim_title", MgConfService.getString("tioim.title", "鸽哒IM"));
        param.put("admin_title", sitename + "后台管理系统");
        param.put("resetpwd", "888888");
        return Resp.ok(param);
    }
}
