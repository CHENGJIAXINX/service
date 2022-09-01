package org.tio.sitexxx.web.server.yanxun.red;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.sitexxx.service.model.main.*;
import org.tio.sitexxx.service.pay.base.BasePayResp;
import org.tio.sitexxx.service.pay.service.RedPacketService;
import org.tio.sitexxx.service.service.chat.ChatIndexService;
import org.tio.sitexxx.service.service.chat.ChatService;
import org.tio.sitexxx.service.service.chat.GroupService;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.service.vo.GrabRedpacketVo;
import org.tio.sitexxx.service.vo.SendRedpacketVo;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.resp.Resp;

import java.util.Objects;

@RequestPath(value = "/redPacket")
public class RedPacketController {

    private static Logger log = LoggerFactory.getLogger(RedPacketController.class);


    /**
     * 发红包接口
     * @param request
     * @return
     * @throws Exception
     * @author zlb
     * 2020年11月6日 下午4:27:04
     */
    @RequestPath(value = "/sendRedpacket")
    public Resp sendRedpacket(HttpRequest request, SendRedpacketVo redpacketVo) throws Exception {
        User curr = WebUtils.currUser(request);
        //查询是否开通钱包，并且钱包状态正常
        if(redpacketVo == null || redpacketVo.getChatlinkid() == null) {
            return Resp.fail("钱包参数为空");
        }
        if (redpacketVo.getPasswd() == null){
            return Resp.fail("支付密码为空");
        }
        int _amount = Integer.parseInt(redpacketVo.getAmount());
        if(_amount <= 0) {
            return Resp.fail("红包金额为负");
        }
        if (redpacketVo.getPacketType().intValue() == 2){
            if (_amount < redpacketVo.getPacketCount()){
                return Resp.fail("拼手气红包金额太小");
            }
        }
        Integer sendRedpacketLimit = ConfService.getInt(Const.ConfMapping.WX_WALLET_SENDREDPACKET_MAX_AMOUNT, 10) * redpacketVo.getPacketCount();
        if(_amount > sendRedpacketLimit) {
            return Resp.fail("红包金额最大为" + new Double(sendRedpacketLimit)/100 + "元");
        }
        if (curr == null){
            return Resp.fail("用户登录超时");
        }
        redpacketVo.setUid(curr.getId());
        redpacketVo.setNick(curr.getNick());
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(curr.getId());
        if (yxUserWallet == null){
            return Resp.fail("用户未开户");
        }
        redpacketVo.setWalletid(String.valueOf(yxUserWallet.getId()));
        Long chatlinkid = redpacketVo.getChatlinkid();
        Byte chatmode = Const.ChatMode.P2P;
        Long groupid = null;
        if(chatlinkid <= 0) {
            chatmode = Const.ChatMode.GROUP;
            groupid = -chatlinkid;
            WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(curr.getId(), groupid);
            if(!ChatService.groupExistChat(groupItem)) {
                return Resp.fail("不是群成员");
            }
            WxGroupUser groupUser = GroupService.me.getGroupUser(curr.getId(),groupid);
            if(!Objects.equals(groupUser.getForbiddenflag(), Const.YesOrNo.NO)){
                return Resp.fail("您已被禁言，不可发红包");
            }
            WxGroup group = GroupService.me.getByGroupid(groupid);
            if(Objects.equals(groupUser.getGrouprole(),Const.GroupRole.MEMBER)){
                if (!Objects.equals(group.getForbiddenflag(), Const.YesOrNo.NO)){
                    return Resp.fail("本群已禁言");
                }
            }
            chatlinkid = groupItem.getChatlinkid();
            redpacketVo.setBizid(groupid);
        } else {
            WxChatUserItem userItem = ChatIndexService.chatUserIndex(chatlinkid);
            if(!ChatService.existTwoFriend(userItem)) {
                return Resp.fail("你们不是好友");
            }
            redpacketVo.setBizid(userItem.getBizid());
        }
        redpacketVo.setChatmode(chatmode);
        Resp resp = RedPacketService.me.sendRedpacket(redpacketVo,request);
        if(!resp.isOk()) {
            return Resp.fail(resp.getMsg());
        }
        return Resp.ok(resp.getData());
    }


    /**
     * @param request
     * @return
     * @throws Exception
     * @author zlb
     * 2020年11月22日 下午10:20:30
     */
    @RequestPath(value = "/redStatus")
    public Resp redStatus(HttpRequest request,String serialnumber) throws Exception {
        User curr = WebUtils.currUser(request);
        BasePayResp basePayResp = new BasePayResp();
        Ret ret = RedPacketService.me.redStatus(curr,serialnumber);
        if(ret.isFail()) {
            return Resp.fail().msg(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkData(ret));

//        GrabRedpacketVo grabVo = GrabRedpacketVo.toBean(PayQuest.getParams());
//        WxUserSendRedItem item = WxUserSendRedItem.dao.findFirst("select * from wx_user_send_red_item where serialnumber = ?",grabVo.getSerialnumber());
//        BasePayResp basePayResp = new BasePayResp();
//        String checkStr = checkRedpacket(item);
//        if(StrUtil.isNotBlank(checkStr)) {
//            basePayResp.setOk(false);
//            basePayResp.setMsg(checkStr);
//            return basePayResp;
//        }

//        return basePayResp;
    }

    /**
     * 红包信息
     * @param request
     * @return
     * @throws Exception
     * @author xufei
     * 2020年11月22日 下午10:51:00
     */
    @RequestPath(value = "/redInfo")
    public Resp redInfo(HttpRequest request,String serialnumber) throws Exception {
        User curr = WebUtils.currUser(request);
        Ret ret = RedPacketService.me.redInfo(request,serialnumber,curr);
        if(ret.isFail()) {
            return Resp.fail().msg(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 抢红包
     * @param request
     * @param grabRedpacketVo
     * @return
     * @throws Exception
     * @author zlb
     * 2020年11月19日 上午10:44:03
     */
    @RequestPath(value = "/grabRedpacket")
    public Resp grabRedpacket(HttpRequest request, GrabRedpacketVo grabRedpacketVo) throws Exception {
        User curr = WebUtils.currUser(request);
        if (curr == null){
            return Resp.fail("用户登录超时");
        }
        grabRedpacketVo.setUid(curr.getId());
        //判断用户开户
        if(grabRedpacketVo == null) {
            return Resp.fail("钱包参数为空");
        }
        YxUserWallet yxUserWallet = WalletService.ME.queryByUid(grabRedpacketVo.getUid());
        if (yxUserWallet == null){
            return Resp.fail("用户未开户");
        }

        grabRedpacketVo.setWalletid(String.valueOf(yxUserWallet.getId()));
        Long chatlinkid = grabRedpacketVo.getChatlinkid();
        Byte chatmode = Const.ChatMode.P2P;
        Long groupid = null;
        log.error("抢红包的chatlinkid:{}",chatlinkid);
        if(chatlinkid <= 0) {
            chatmode = Const.ChatMode.GROUP;
            groupid = -chatlinkid;
            WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(curr.getId(), groupid);
            if(!ChatService.groupExistChat(groupItem)) {
                return Resp.fail("不是群成员");
            }
            chatlinkid = groupItem.getChatlinkid();
            grabRedpacketVo.setBizid(groupid);
        } else {
            WxChatUserItem userItem = ChatIndexService.chatUserIndex(chatlinkid);
            if(!ChatService.existTwoFriend(userItem)) {
                return Resp.fail("你们不是互相不是好友");
            }
            grabRedpacketVo.setBizid(userItem.getBizid());
        }
        grabRedpacketVo.setChatmode(chatmode);
        Resp resp = RedPacketService.me.grabRedpacket(grabRedpacketVo,request);
        if(!resp.isOk()) {
            return Resp.fail(resp.getMsg());
        }
        return Resp.ok(resp.getData());
    }

    /**
     * 抢红包列表
     * @param request
     * @param pageNumber
     * @return
     * @throws Exception
     * @author xufei
     * 2020年11月19日 上午11:38:12
     */
    @RequestPath(value = "/grabRedpacketlist")
    public Resp grabRedpacketlist(HttpRequest request,Integer pageNumber,String period) throws Exception {
        User curr = WebUtils.currUser(request);
        Ret ret = RedPacketService.me.grabRedpacketlist(curr.getId(),pageNumber,period);
        if(ret.isFail()) {
            return Resp.fail().msg(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }


    /**
     * 发红包列表
     * @param request
     * @param pageNumber
     * @return
     * @throws Exception
     * @author xufei
     * 2020年11月19日 上午11:37:50
     */
    @RequestPath(value = "/sendRedpacketlist")
    public Resp sendRedpacketlist(HttpRequest request,Integer pageNumber,String period) throws Exception {
        User curr = WebUtils.currUser(request);
        Ret ret = RedPacketService.me.sendRedpacketlist(curr.getId(),pageNumber,period);
        if(ret.isFail()) {
            return Resp.fail().msg(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * @param request
     * @param period
     * @return
     * @throws Exception
     * @author xufei
     * 2020年11月27日 下午4:50:26
     */
    @RequestPath(value = "/sendredpacketstat")
    public Resp sendRedpacketStat(HttpRequest request,String period) throws Exception {
        User curr = WebUtils.currUser(request);
        Ret ret = RedPacketService.me.sendRedpacketStat(curr.getId(),period);
        if(ret.isFail()) {
            return Resp.fail().msg(RetUtils.getRetMsg(ret));
        }
        Record record = RetUtils.getOkTData(ret);
        if(record != null) {
            record.set("nick", curr.getNick());
            record.set("avatar", curr.getAvatar());
        }
        return Resp.ok(record);
    }

    /**
     * @param request
     * @param period
     * @return
     * @throws Exception
     * @author xufei
     * 2020年11月27日 下午4:52:29
     */
    @RequestPath(value = "/grabredpacketstat")
    public Resp grabRedpacketStat(HttpRequest request,String period) throws Exception {
        User curr = WebUtils.currUser(request);
        Ret ret = RedPacketService.me.grabRedpacketStat(curr.getId(),period);
        if(ret.isFail()) {
            return Resp.fail().msg(RetUtils.getRetMsg(ret));
        }
        Record record = RetUtils.getOkTData(ret);
        if(record != null) {
            record.set("nick", curr.getNick());
            record.set("avatar", curr.getAvatar());
        }
        return Resp.ok(record);
    }
}
