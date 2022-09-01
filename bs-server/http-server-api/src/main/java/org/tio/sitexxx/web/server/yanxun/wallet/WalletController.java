package org.tio.sitexxx.web.server.yanxun.wallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.YxUserWallet;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletService;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

@RequestPath(value = "/wallet")
public class WalletController {

    private static Logger log = LoggerFactory.getLogger(WalletController.class);

    /**
     *
     *
     */
    public WalletController() {
    }

    /**
     * 查询钱包信息
     * @param
     * @return YxUserWallet
     */
    @RequestPath(value = "/queryUserWallet")
    public Resp queryUserWalletInfo(HttpRequest request) throws Exception{
        Integer uid = WebUtils.currUserId(request);
        if (uid == null){
            return Resp.fail("用户未登录或登录超时");
        }
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(uid);
        if (yxUserWallet == null){
            return Resp.fail("未开户").code(-1);
        }
        if (yxUserWallet.getStatus().intValue() == 1){
            return Resp.fail("账户冻结，请联系管理员");
        }
        yxUserWallet.setPasswd("");
        return Resp.ok().data(yxUserWallet);
    }

    /**
     * 开户
     * @param userWallet
     * @return boolean
     */
    @RequestPath(value = "/open")
    public Resp open(HttpRequest request, YxUserWallet userWallet) throws Exception{
        Integer uid = WebUtils.currUserId(request);
        if (uid == null){
            return Resp.fail("用户未登录或登录超时");
        }
        if (userWallet.getPasswd() == null){
            return Resp.fail("密码为空");
        }
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(uid);
        if (yxUserWallet != null){
            return Resp.fail("用户已开户");
        }
        YxUserWallet open = WalletService.ME.open(uid, userWallet.getPasswd());
        if (open == null){
            return Resp.fail("开户失败");
        }
        open.setPasswd("");
        return Resp.ok(open);
    }

    @RequestPath(value = "/isOpen")
    public Resp isOpen(HttpRequest request)throws Exception{
        Integer uid = WebUtils.currUserId(request);
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(uid);
        boolean flag = true;
        if(yxUserWallet==null){
            flag = false;
        }
        return Resp.ok(flag);
    }

    /**
     * 修改余额
     * @param userWallet
     * @param type 1:充值 2:提现 3:红包
     * @return boolean
     */
    @RequestPath(value = "/updateBlockamount")
    public Resp updateBlockamount(HttpRequest request, YxUserWallet userWallet,Integer type) throws Exception{

        return Resp.ok();
    }

    /***
     * 修改支付密码
     * @param request
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestPath(value = "/updatePayPassword")
    public Resp updatePayPassword(HttpRequest request,String oldPassword,long oldpwdTimestamp, String newPassword){
        User user = WebUtils.currUser(request);
        if (user == null){
            return Resp.fail("用户未登录或登录超时");
        }
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(user.getId());
        if (yxUserWallet == null){
            return Resp.fail("用户未开户");
        }
        boolean b = WalletService.ME.checkPayPwd(oldPassword, oldpwdTimestamp, yxUserWallet.getPasswd());
        if (!b){
            return Resp.fail("原密码错误");
        }
        yxUserWallet.setPasswd(newPassword);
        if (!yxUserWallet.update()){
            return Resp.fail("修改失败");
        }
        return Resp.ok();
    }

    /**
     * 验证支付密码
     * @param request
     * @param passwd
     * @param timestamp
     * @return
     */
    @RequestPath(value = "/checkPayPwd")
    public Resp checkPayPwd(HttpRequest request, String passwd, long timestamp){
        User user = WebUtils.currUser(request);
        if (user == null){
            return Resp.fail("用户未登录或登录超时");
        }
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(user.getId());
        if (yxUserWallet == null){
            return Resp.fail("用户未开户");
        }
        boolean b = WalletService.ME.checkPayPwd(passwd, timestamp, yxUserWallet.getPasswd());
        if (!b){
            return Resp.fail("密码错误");
        }
        return Resp.ok();
    }
}
