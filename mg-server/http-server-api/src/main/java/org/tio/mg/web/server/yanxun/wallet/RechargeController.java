package org.tio.mg.web.server.yanxun.wallet;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.model.mg.MgUser;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.service.yxnxun.wallet.RechargeService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RechargeCheckVo;
import org.tio.mg.service.vo.RechargeRequestVo;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.mg.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

@RequestPath(value = "/recharge")
public class RechargeController {

    private static Logger log = LoggerFactory.getLogger(RechargeController.class);

    private static RechargeService service = RechargeService.ME;

    /***
     * 查询充值列表并做分页处理
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath("/list")
    public Resp queryRechargeList(HttpRequest request) throws Exception {
        RechargeRequestVo rechargeRequestVo = JSONObject.parseObject(request.getBodyString(), RechargeRequestVo.class);
        if (rechargeRequestVo == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = service.queryRecharge(rechargeRequestVo);
        if (ret.isFail()) {
            log.error("查询支付列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /***
     * 审核充值
     * @param request
     * @return
     */
    @RequestPath(value = "/check")
    public Resp checkRecharge(HttpRequest request) throws Exception {
        RechargeCheckVo rechargeCheckVo = JSONObject.parseObject(request.getBodyString(), RechargeCheckVo.class);
        if (rechargeCheckVo == null || rechargeCheckVo.getId() == null || rechargeCheckVo.getStatus() == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        // 检查状态是否一致
        Ret statusSame = service.isStatusSame(rechargeCheckVo.getId(), rechargeCheckVo.getStatus());
        if (statusSame.isFail()) {
            log.error(RetUtils.getRetMsg(statusSame));
            return Resp.fail(RetUtils.getRetMsg(statusSame));
        }
        MgUser mgUser = WebUtils.currUser(request);
        Ret ret = service.check(mgUser, rechargeCheckVo);
        if (ret.isFail()) {
            log.error(RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "充值审核",
                        MgConst.OperLogTypes.update,
                        "充值审核结果" + rechargeCheckVo.getStatus());
            }
        }).start();
        return Resp.ok(RetUtils.getRetMsg(ret));
    }


    /**
     * 后台充值接口 不走审核流程
     *
     * @param request
     * @param money
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/backRecharge")
    public Resp recharge(HttpRequest request, Integer money, Integer uid) throws Exception {
        Integer mguid = WebUtils.currUserId(request);
        if (money == null || money == 0) {
            return Resp.fail("充值金额无效");
        }
        if (uid == null) {
            return Resp.fail("用户id为空");
        }
        Ret ret = service.recharge(mguid, money, uid);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "后台充值",
                        MgConst.OperLogTypes.update,
                        "后台充值  金额：" + money + ";uid:" + uid);
            }
        }).start();
        return Resp.ok().msg(RetUtils.getRetMsg(ret));
    }

}
