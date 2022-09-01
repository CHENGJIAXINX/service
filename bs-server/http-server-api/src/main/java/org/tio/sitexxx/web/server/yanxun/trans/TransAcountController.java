package org.tio.sitexxx.web.server.yanxun.trans;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.im.server.handler.wx.WxChatApi;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.WxChatUserItem;
import org.tio.sitexxx.service.model.main.YxTransAccounts;
import org.tio.sitexxx.service.model.main.YxUserWallet;
import org.tio.sitexxx.service.service.atom.AbsAtom;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.chat.ChatIndexService;
import org.tio.sitexxx.service.service.chat.ChatService;
import org.tio.sitexxx.service.service.yanxun.trans.TransAccountService;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletDetailTypeNum;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.utils.CommonUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.wx.TransAmountVo;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

import java.sql.SQLException;
import java.util.Date;

/**
 * 转账相关
 */
@RequestPath("/trans")
public class TransAcountController {

    private static Logger log = LoggerFactory.getLogger(TransAcountController.class);
    private static UserService userService	= UserService.ME;
    private static TransAccountService transAccountService = TransAccountService.ME;
    private static YxTransAccounts yxTransAccountsDao = new YxTransAccounts().dao();
    /**
     * 给他人转账
     * @param request
     * @return
     */
    @RequestPath("/transAccount")
    public Resp transAccount(HttpRequest request, Integer amount, Integer toUid, String remark){
        User curr = WebUtils.currUser(request);
        YxTransAccounts yxTransAccounts = new YxTransAccounts();
        yxTransAccounts.setAmount(amount);
        yxTransAccounts.setFromNick(curr.getNick());
        yxTransAccounts.setFromUid(curr.getId());
        yxTransAccounts.setToUid(toUid);
        yxTransAccounts.setToNick(userService.getById(toUid).getNick());
        yxTransAccounts.setSerial(CommonUtils.getSerial());
        yxTransAccounts.setStatus(0);
        yxTransAccounts.setRemark(remark);
        if (yxTransAccounts.save()){
            return Resp.ok(yxTransAccounts);
        }
        return Resp.fail();
    }

    /**
     * 提交支付密码
     * @return
     */
    @RequestPath("/payPwd")
    public Resp transAccountPay(HttpRequest request, String serial, String passwd, Long timestamp){
        if (passwd == null){
            return Resp.fail("请输入支付密码");
        }
        User curr = WebUtils.currUser(request);
        Resp resp = transAccountService.payPasswd(curr, passwd, serial, timestamp);
        if (!resp.isOk()){
            return resp;
        }
        YxTransAccounts yxTransAccount = (YxTransAccounts) resp.getData();

        TransAmountVo transAmountVo = new TransAmountVo();
        transAmountVo.setSerial(serial);
        transAmountVo.setAmount(yxTransAccount.getAmount());
        transAmountVo.setStatus(1);
        transAmountVo.setType(1);
        transAmountVo.setId(yxTransAccount.getId());
        transAmountVo.setRemark(yxTransAccount.getRemark());

        String text = Json.toJson(transAmountVo);
        Ret ret = null;
        try {
            ret = WxChatApi.sendFdMsgEach(request, text, Const.ContentType.TRANS_AMOUNT, curr.getId(), yxTransAccount.getToUid(),Const.YesOrNo.NO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ret.isFail()) {
            log.error(RetUtils.getRetMsg(ret));
        }
        return Resp.ok();
    }

    @RequestPath("/detail")
    public Resp detail(HttpRequest request, Integer id){
        User curr = WebUtils.currUser(request);
        YxTransAccounts yxTransAccounts = yxTransAccountsDao.findById(id);
        if (yxTransAccounts == null){
            return Resp.fail("不存在");
        }
        if (curr.getId().intValue() != yxTransAccounts.getFromUid().intValue() && curr.getId().intValue() != yxTransAccounts.getToUid().intValue()){
            return Resp.fail("你无权限查看该红包");
        }
        return Resp.ok(yxTransAccounts);
    }

    /**
     * 退还
     * @return
     */
    @RequestPath("/back")
    public Resp back(HttpRequest request, Integer id, Long chatlinkid){
        User curr = WebUtils.currUser(request);
        if (id == null || chatlinkid == null){
            return Resp.fail("存在为空参数");
        }
        YxTransAccounts yxTransAccounts = yxTransAccountsDao.findById(id);
        if (yxTransAccounts == null){
            return Resp.fail("不存在");
        }
        if (yxTransAccounts.getStatus() == 2){
            return Resp.fail("已领取");
        }
        if (yxTransAccounts.getStatus() == 3){
            return Resp.fail("已过期");
        }
        if (yxTransAccounts.getStatus() == 4){
            return Resp.fail("已退还");
        }
        if (yxTransAccounts.getStatus() != 1){
            return Resp.fail("当前状态不可退还");
        }
        if (curr.getId().intValue() != yxTransAccounts.getToUid().intValue()){
            return Resp.fail("这不是转给你的，不能退还");
        }
        WxChatUserItem userItem = ChatIndexService.chatUserIndex(chatlinkid);
        if(!ChatService.existTwoFriend(userItem)) {
            return Resp.fail("你们不是互相不是好友");
        }
        if (new Date().getTime() - yxTransAccounts.getCreatetime().getTime() >= 24 * 60 * 60 * 1000) {
            //余额要退回
            return Resp.fail("已过期");
        }
        String[] txMsg = new String[1];
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                YxUserWallet fromWallet = WalletService.ME.queryByUid(yxTransAccounts.getFromUid());

                Ret payRet = WalletService.ME.modifyBalance(WalletDetailTypeNum.TRANS, 1, yxTransAccounts.getAmount(),
                        fromWallet.getId(), null, null, "转账退还", yxTransAccounts.getId(), yxTransAccounts.getSerial(), false);

                if (payRet.isFail()){
                    txMsg[0] = RetUtils.getRetMsg(payRet);
                    return false;
                }
                yxTransAccounts.setStatus(5);
                yxTransAccounts.setBacktime(new Date());
                if (yxTransAccounts.update()){
                    return true;
                }
                txMsg[0] = "退还失败";
                return false;
            }
        };
        boolean tx = Db.use(Const.Db.TIO_SITE_MAIN).tx(absAtom);
        if (!tx){
            return Resp.fail(txMsg[0]);
        }
        TransAmountVo transAmountVo = new TransAmountVo();
        transAmountVo.setSerial(yxTransAccounts.getSerial());
        transAmountVo.setAmount(yxTransAccounts.getAmount());
        transAmountVo.setStatus(5);
        transAmountVo.setType(2);
        transAmountVo.setId(yxTransAccounts.getId());
        transAmountVo.setRemark(yxTransAccounts.getRemark());

        String text = Json.toJson(transAmountVo);
        Ret ret = null;
        try {
            ret = WxChatApi.sendFdMsgEach(request, text, Const.ContentType.TRANS_AMOUNT, curr.getId(), yxTransAccounts.getFromUid(),Const.YesOrNo.NO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ret.isFail()) {
            log.error(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(yxTransAccounts);
    }


    /**
     * 收款
     * @return
     */
    @RequestPath("/reciever")
    public Resp reciever(HttpRequest request, Integer id, Long chatlinkid){
        User curr = WebUtils.currUser(request);
        YxTransAccounts yxTransAccounts = yxTransAccountsDao.findById(id);
        if (yxTransAccounts == null){
            return Resp.fail("不存在");
        }
        if (yxTransAccounts.getStatus() == 2){
            return Resp.fail("已领取");
        }
        if (yxTransAccounts.getStatus() == 3){
            return Resp.fail("已过期");
        }
        if (yxTransAccounts.getStatus() == 4){
            return Resp.fail("已退还");
        }
        if (yxTransAccounts.getStatus() != 1){
            return Resp.fail("当前状态不可领取");
        }
        if (curr.getId().intValue() != yxTransAccounts.getToUid().intValue()){
            return Resp.fail("这不是转给你的");
        }
        WxChatUserItem userItem = ChatIndexService.chatUserIndex(chatlinkid);
        if(!ChatService.existTwoFriend(userItem)) {
            return Resp.fail("你们不是互相不是好友");
        }
        if (new Date().getTime() - yxTransAccounts.getCreatetime().getTime() >= 24 * 60 * 60 * 1000) {
            //余额要退回
            return Resp.fail("已过期");
        }
        String[] txMsg = new String[1];
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                YxUserWallet yxUserWallet = WalletService.ME.queryByUid(curr.getId());
                if (yxUserWallet == null){
                    txMsg[0] = "未开户，不能收款";
                    return false;
                }
                Ret payRet = WalletService.ME.modifyBalance(WalletDetailTypeNum.TRANS, 1, yxTransAccounts.getAmount(),
                        yxUserWallet.getId(), null, null, "转账收入", yxTransAccounts.getId(), yxTransAccounts.getSerial(), true);

                if (payRet.isFail()){
                    txMsg[0] = RetUtils.getRetMsg(payRet);
                    return false;
                }
                yxTransAccounts.setStatus(2);
                yxTransAccounts.setRecievertime(new Date());
                if (yxTransAccounts.update()){
                    return true;
                }
                txMsg[0] = "收款失败";
                return false;
            }
        };
        boolean tx = Db.use(Const.Db.TIO_SITE_MAIN).tx(absAtom);
        if (!tx){
            return Resp.fail(txMsg[0]);
        }
        TransAmountVo transAmountVo = new TransAmountVo();
        transAmountVo.setSerial(yxTransAccounts.getSerial());
        transAmountVo.setAmount(yxTransAccounts.getAmount());
        transAmountVo.setStatus(2);
        transAmountVo.setType(2);
        transAmountVo.setId(yxTransAccounts.getId());
        transAmountVo.setRemark(yxTransAccounts.getRemark());

        String text = Json.toJson(transAmountVo);
        Ret ret = null;
        try {
            ret = WxChatApi.sendFdMsgEach(request, text, Const.ContentType.TRANS_AMOUNT, curr.getId(), yxTransAccounts.getFromUid(),Const.YesOrNo.NO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ret.isFail()) {
            log.error(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(yxTransAccounts);
    }

}
