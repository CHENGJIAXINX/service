package org.tio.mg.web.server.yanxun.wallet;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.model.main.YxUserWithdraw;
import org.tio.mg.service.model.mg.MgUser;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.service.yxnxun.wallet.WithdrawService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RechargeCheckVo;
import org.tio.mg.service.vo.WithdrawRequestVo;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.mg.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

/**
 * 提现控制器
 */
@RequestPath(value = "/withdraw")
public class WithdrawController {

    private static Logger log = LoggerFactory.getLogger(WithdrawController.class);

    private static WithdrawService service = WithdrawService.ME;

    /***
     * 查询提现列表
     * @param request
     * @return
     */
    @RequestPath("/list")
    public Resp queryWithdrawList(HttpRequest request) {
        WithdrawRequestVo withdrawRequestVo = JSONObject.parseObject(request.getBodyString(), WithdrawRequestVo.class);
        if (withdrawRequestVo == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = service.queryWithdraw(withdrawRequestVo);
        if (ret.isFail()) {
            log.error("查询提现列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /***
     * 提现审核
     * //    提现状态：1待审核 2审核中 3已通过 4拒绝5提现完成
     * @param request
     * @return
     */
    @RequestPath(value = "/updateCheckStatus")
    public Resp checkWithdraw(HttpRequest request) {
        RechargeCheckVo rechargeCheckVo = JSONObject.parseObject(request.getBodyString(), RechargeCheckVo.class);
        Ret statusSame = service.isStatusSame(rechargeCheckVo.getId(), rechargeCheckVo.getStatus());
        if (statusSame.isFail()) {
            log.error(RetUtils.getRetMsg(statusSame));
            return Resp.fail(RetUtils.getRetMsg(statusSame));
        }
        Integer mgUid = WebUtils.currUserId(request);
        Ret ret = service.check(mgUid, rechargeCheckVo.getId(), rechargeCheckVo.getUid(), rechargeCheckVo.getStatus(), rechargeCheckVo.getNote());
        if (ret.isFail()) {
            log.error(RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "提现审核",
                        MgConst.OperLogTypes.update,
                        "提现审核结果：" + rechargeCheckVo.getStatus() + ",备注：" + rechargeCheckVo.getNote());
            }
        }).start();
        return Resp.ok().msg(RetUtils.getRetMsg(ret));
    }

    /**
     * 后台提现 不走审核
     *
     * @param request
     * @param money
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/backWithdraw")
    public Resp withdraw(HttpRequest request, Integer money, Integer uid) throws Exception {
        Integer mguid = WebUtils.currUserId(request);
        if (money == null || money == 0) {
            return Resp.fail("扣款金额无效");
        }
        if (uid == null) {
            return Resp.fail("用户id为空");
        }
        Ret ret = service.withdraw(mguid, money, uid);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "后台扣款",
                        MgConst.OperLogTypes.update,
                        "后台扣款，金额:" + money + ";uid:" + uid);
            }
        }).start();
        return Resp.ok().msg(RetUtils.getRetMsg(ret));
    }
}
