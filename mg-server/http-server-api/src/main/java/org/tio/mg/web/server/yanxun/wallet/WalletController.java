package org.tio.mg.web.server.yanxun.wallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.model.mg.MgUser;
import org.tio.mg.service.service.yxnxun.wallet.WalletService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

import java.util.Date;

@RequestPath(value = "/wallet")
public class WalletController {

    private static Logger log = LoggerFactory.getLogger(WalletController.class);

    private static WalletService service = WalletService.ME;

    public WalletController() {}

    /***
     * 查询所有钱包用户列表
     * @param
     * @return List<YxUserWallet>
     */
    @RequestPath(value = "/list")
    public Resp queryList(HttpRequest request) throws Exception{
        Ret ret = service.queryList();
        if(ret.isFail()){
            log.error("获取钱包用户列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkList(ret));
    }

    /***
     * 根据创建时间查询钱包用户信息
     * @param sTime 起始时间
     * @param eTime 结束时间
     * @return
     */
    @RequestPath(value = "/listbytime")
    public Resp queryListByTime(HttpRequest request, Date sTime, Date eTime) throws Exception{
        Ret ret = service.queryListByTime(sTime,eTime);
        if(ret.isFail()){
            log.error("获取钱包用户列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkList(ret));
    }

    /***
     * 冻结用户
     * @param request
     * @param uid
     * @param status
     * @param note
     * @return
     */
    @RequestPath(value = "/blockedAccount")
    public Resp blockedAccount(HttpRequest request,Integer uid,Integer status,String note){
        MgUser mgUser = WebUtils.currUser(request);
        if(mgUser==null){
            log.info("尚未登录不可操作");
            return Resp.fail("您尚未登录或登录超时，请重新登录");
        }
        Ret ret = service.updateStatusByUid(uid,status);
        if(ret.isFail()){
            log.error("账户冻结失败：{}",RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getRetMsg(ret));
    }


}
