package org.tio.sitexxx.web.server.yanxun.wallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.model.main.YxUserWallet;
import org.tio.sitexxx.service.model.main.YxUserWithdrawAccount;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletService;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletWithdrawAccountService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

import java.util.HashMap;
import java.util.Map;

@RequestPath(value = "/withdrawAccount")
public class WalletWithdrawAccountController {
    private static Logger log = LoggerFactory.getLogger(WalletWithdrawAccountController.class);

    private WalletWithdrawAccountService service = WalletWithdrawAccountService.ME;

    private WalletService walletService = WalletService.ME;


    /***
     * 查询收款人设置
     * @param request
     * @return
     */
    @RequestPath(value = "/findAll")
    public Resp queryAll(HttpRequest request) throws Exception{
        Integer uid = WebUtils.currUserId(request);
        YxUserWallet yxUserWallet = walletService.queryByUid(uid);
        if(yxUserWallet==null){
            return Resp.fail("用户未开户");
        }
        Ret ret = service.queryByUid(uid);
        if(RetUtils.getOkTList(ret)==null){
            return Resp.fail("未设置收款人");
        }
        Map<String,Object> map = new HashMap();
        map.put("data",RetUtils.getOkTList(ret));
        return Resp.ok(map);
    }

    /***
     * 查询收款人详情
     * @param request
     * @param id
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/findById")
    public Resp queryById(HttpRequest request,Integer id) throws Exception{
        Integer uid = WebUtils.currUserId(request);
        YxUserWallet yxUserWallet = walletService.queryByUid(uid);
        if(yxUserWallet==null){
            return Resp.fail("用户未开户");
        }
        if(id==null){
            return Resp.fail("参数错误");
        }
        YxUserWithdrawAccount account = service.queryById(id);
        if(account==null){
            return Resp.fail("未设置收款人");
        }
        return Resp.ok(account);
    }

    /***
     * 修改收款人信息
     * @param request
     * @param account
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/update")
    public Resp update(HttpRequest request,YxUserWithdrawAccount account) throws Exception{
        Integer uid = WebUtils.currUserId(request);
        YxUserWallet yxUserWallet = walletService.queryByUid(uid);
        if (yxUserWallet==null)
            return Resp.fail("用户未开户");
        Resp check = check(account,true);
        if(!check.isOk()){
            return Resp.fail(check.getMsg());
        }
        account.setUid(uid);
        boolean flag = account.update();
        if(!flag){
            return Resp.fail("修改失败");
        }
        return Resp.ok("修改成功").msg("修改成功");
    }

    /***
     * 新增收款人
     * @param request
     * @param account
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/save")
    public Resp save(HttpRequest request,YxUserWithdrawAccount account) throws Exception{
        Integer uid = WebUtils.currUserId(request);
        YxUserWallet yxUserWallet = walletService.queryByUid(uid);
        if (yxUserWallet==null)
            return Resp.fail("用户未开户");
        boolean isMaxNum = service.isMaxNum(uid);
        if(isMaxNum){
            return Resp.fail("收款人账户过多");
        }
        Resp check = check(account,false);
        if(!check.isOk()){
            return Resp.fail(check.getMsg());
        }
        account.setUid(uid);
        boolean save = account.save();
        if(!save){
            return Resp.fail("添加失败");
        }
        return Resp.ok("添加成功").msg("添加成功");
    }

    /***
     * 删除收款人
     * @param request
     * @param id
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/del")
    public Resp del(HttpRequest request,Integer id) throws Exception{
        Integer uid = WebUtils.currUserId(request);
        YxUserWallet yxUserWallet = walletService.queryByUid(uid);
        if (yxUserWallet==null)
            return Resp.fail("用户未开户");
        boolean flag = service.delById(id);
        if(!flag){
            return Resp.fail("删除失败");
        }
        return Resp.ok("删除成功").msg("删除成功");
    }

    public Resp check(YxUserWithdrawAccount account,boolean needId){
        if (account==null)
            return Resp.fail("参数有误");
        if (needId && account.getId()==null)
            return Resp.fail("Id不能为空");
        if (account.getAccounttype()==null)
            return Resp.fail("账户类型未填写");
        if (account.getAccountname()==null)
            return Resp.fail("账户名称未填写");
        return Resp.ok();
    }

}
