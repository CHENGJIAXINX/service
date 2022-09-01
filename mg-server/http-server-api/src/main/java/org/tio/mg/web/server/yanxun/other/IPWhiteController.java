package org.tio.mg.web.server.yanxun.other;

import com.alibaba.fastjson.JSONObject;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.service.conf.IpWhiteListService;
import org.tio.mg.service.service.tioim.TioUserService;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.resp.Resp;

/**
 * 白名单管理控制器
 */
@RequestPath("/ipwhite")
public class IPWhiteController {

    private TioUserService userService = TioUserService.me;

    private IpWhiteListService ipService = IpWhiteListService.me;

    /**
     * 查询用户白名单列表
     *
     * @param request
     * @return
     */
    @RequestPath("/queryList")
    public Resp query(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = userService.queryIpWhite(requestVo);
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 添加白名单
     *
     * @param request
     * @param uid
     * @param ips
     * @return
     */
    @RequestPath("/addIps")
    public Resp addIPWhite(HttpRequest request, Integer uid, String ips) {
        if (uid == null || uid < 0 || StrUtil.isEmpty(ips)) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        String[] split = ips.split(",");
        Ret ret = ipService.saveIps(uid, split);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "添加用户白名单",
                        MgConst.OperLogTypes.add,
                        "添加白名单，ips" + ips);
            }
        }).start();
        return Resp.ok("操作成功");
    }

    /**
     * 删除白名单
     *
     * @param request
     * @param id
     * @return
     */
    @RequestPath("/delIp")
    public Resp delIpWhite(HttpRequest request, Integer id) {
        if (id == null || id < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        if (ipService.delete(id, "") == 0) {
            return Resp.fail(RetUtils.OPER_ERROR);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "删除用户白名单",
                        MgConst.OperLogTypes.del,
                        "删除白名单，id为" + id);
            }
        }).start();
        return Resp.ok(RetUtils.OPER_RIGHT);
    }

}
