package org.tio.sitexxx.service.pay.service;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.sitexxx.im.common.Command;
import org.tio.sitexxx.im.common.ImPacket;
import org.tio.sitexxx.im.common.bs.wx.friend.WxFriendChatNtf;
import org.tio.sitexxx.im.common.bs.wx.group.WxGroupChatNtf;
import org.tio.sitexxx.im.server.Ims;
import org.tio.sitexxx.im.server.handler.wx.WxChatApi;
import org.tio.sitexxx.im.server.handler.wx.WxSynApi;
import org.tio.sitexxx.service.model.main.*;
import org.tio.sitexxx.service.pay.base.BasePayReq;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.GrabRedpacket5UResp;
import org.tio.sitexxx.service.service.atom.AbsAtom;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.chat.*;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletDetailTypeNum;
import org.tio.sitexxx.service.service.yanxun.wallet.WalletService;
import org.tio.sitexxx.servicecommon.utils.PeriodUtils;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.service.vo.*;
import org.tio.sitexxx.servicecommon.vo.AppCode;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.Devicetype;
import org.tio.sitexxx.servicecommon.vo.RequestKey;
import org.tio.sitexxx.servicecommon.vo.wx.SynRecordVo;
import org.tio.sitexxx.servicecommon.vo.wx.WxRedVo;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

import java.sql.SQLException;
import java.util.*;

public class RedPacketService {
    private static Logger log	= LoggerFactory.getLogger(RedPacketService.class);

    public static final RedPacketService me	= new RedPacketService();

    final static YxUserSendRedPacket packetDao = new YxUserSendRedPacket().dao();

    final static YxUserRecieverRedPacketItem recieverRedPacketItemDao = new YxUserRecieverRedPacketItem().dao();

    /**
     * 发送红包
     * @param redpacketVo
     * @return
     * @author zlb
     * 2020年11月18日 下午6:06:01
     */
    public Resp sendRedpacket(SendRedpacketVo redpacketVo, HttpRequest request) throws Exception {
        if(redpacketVo.getUid() == null || StrUtil.isBlank(redpacketVo.getWalletid())) {
            log.error("发送红包参数为空");
            return Resp.fail("参数异常");
        }
        final int[] redId = {0};
        final String[] txMsg = {""};
        RequestExt reqExt = getReqExt(request);
        AbsAtom absAtom = new AbsAtom(){

            @Override
            public boolean run() throws SQLException {
                //事务处理：
                // 1、扣减钱包余额
                // 2、增加一条钱包明细记录
                // 3、增加一条红包记录
                YxUserSendRedPacket redPacket = new YxUserSendRedPacket();
                redPacket.setSenduid(redpacketVo.getUid());
                int countMoney = 0;
                if (redpacketVo.getPacketType().intValue() == 1){
                    //普通红包
                    countMoney = redpacketVo.getPacketCount().intValue() * Integer.parseInt(redpacketVo.getSingleAmount());
                    if (redpacketVo.getChatlinkid() <= 0){
                        redPacket.setMode(21);
                    }else {
                        redPacket.setMode(1);
                    }
                }else {
                    //拼手气红包
                    redPacket.setMode(22);
                    countMoney = Integer.parseInt(redpacketVo.getAmount());
                }
                redPacket.setMoney(countMoney);
                redPacket.setNum(redpacketVo.getPacketCount().intValue());
                redPacket.setChatlinkid(redpacketVo.getChatlinkid());
                redPacket.setRemainmoney(countMoney);
                redPacket.setRemainnum(redpacketVo.getPacketCount().intValue());
                redPacket.setSendip(getIp(request));
                redPacket.setDevicetype(getDeviceType(reqExt));
                redPacket.setAppver(getAppVersion(reqExt));
                redPacket.setSendnick(redpacketVo.getNick());
                redPacket.setStatus(2);
                redPacket.setToid(redpacketVo.getBizid());
                redPacket.setRemark(redpacketVo.getRemark());
                redPacket.setSendnick(String.valueOf(redpacketVo.getUid()));
                boolean save = redPacket.save();
                if (!save){
                    txMsg[0] = "红包发送失败";
                    return false;
                }
                redId[0] = redPacket.getId();
                Ret payRet = WalletService.ME.modifyBalance(WalletDetailTypeNum.RED, 2, Integer.parseInt(redpacketVo.getAmount()),
                        Integer.parseInt(redpacketVo.getWalletid()), redpacketVo.getPasswd(), redpacketVo.getTimestamp(), "红包支出", redPacket.getId(), String.valueOf(redPacket.getId()), true);
                if (payRet.isFail()){
                    txMsg[0] = RetUtils.getRetMsg(payRet);
                    return false;
                }
                return true;
            }
        };

        boolean tx = Db.use(Const.Db.TIO_SITE_MAIN).tx(absAtom);
        //发送红包消息
        if (!tx){
            return Resp.fail(txMsg[0]);
        }
        WxChatUserItem userItem = ChatIndexService.chatUserIndex(redpacketVo.getChatlinkid());
        Byte chatmode = redpacketVo.getChatmode();
        Long bizid = redpacketVo.getBizid();
        Integer uid = redpacketVo.getUid();
        if(Objects.equals(chatmode, Const.ChatMode.P2P)) {
            {
                WxRedVo redVo = new WxRedVo();
                redVo.setSerialnumber(/*redItem.getSerialnumber()*/String.valueOf(redId[0]));
                redVo.setText(redpacketVo.getRemark());
                redVo.setStatus("SEND");
                redVo.setMode(redpacketVo.getPacketType());
                String text = Json.toJson(redVo);
                Ret ret = WxChatApi.sendFdMsgFroSendRed(getDeviceType(reqExt),getIp(request),text, Const.ContentType.REDPACKET, uid, bizid.intValue(), (byte) 0,String.valueOf(redId[0]),getAppVersion(reqExt));
                if(ret.isFail()) {
                    WxChatApi.sendFriendErrorMsg(uid,uid, bizid.intValue(), redpacketVo.getChatlinkid(), RetUtils.getIntCode(ret), RetUtils.getRetMsg(ret));
                } else {
                    WxFriendMsg msg = RetUtils.getOkTData(ret);
                }
            }

        } else {
            {
                WxRedVo redVo = new WxRedVo();
                redVo.setSerialnumber(String.valueOf(redId[0]));
                redVo.setText(redpacketVo.getRemark());
                redVo.setStatus("SEND");
                redVo.setMode(redpacketVo.getPacketType());
                String text = Json.toJson(redVo);
//                RequestExt reqExt = /*CommonUtils.*/getReqExt(request);
                Ret ret = WxChatApi.sendGroupMsgEachForSendRed(/*CommonUtils.*/getDeviceType(reqExt),/*CommonUtils.*/getIp(request),text , Const.ContentType.REDPACKET, uid, bizid,null,null,String.valueOf(redId[0]),/*CommonUtils.*/getAppVersion(reqExt));
                if(ret.isFail()) {
                    WxChatApi.sendFriendErrorMsg(uid,uid, bizid.intValue(), -bizid, AppCode.GroupErrorCode.SYS_ERROR, RetUtils.getRetMsg(ret));
//                    redItemupdate.setLocalerrormsg("发送群聊消息失败");
//                    return false;
                } else {
                    WxGroupMsg msg = RetUtils.getOkTData(ret);
//                    redItemupdate.setMgsid(msg.getId());
                }
            }
        }
        return Resp.ok();
    }


    /**
     * 红包状态
     * @param serialNumber
     * @return
     * @author zlb
     * 2020年11月22日 下午10:30:43
     */
    public Ret redStatus(User user, String serialNumber) {
        Map<String, Object> statusRet = new HashMap<String, Object>();
        statusRet.put("openflag", /*user.getOpenflag()*/1);
        YxUserSendRedPacket packet = packetDao.findById(Integer.parseInt(serialNumber));
        if (packet == null){
            return RetUtils.failMsg("红包不存在");
        }
//        if (packet.getStatus().intValue() == 3){
//            return RetUtils.failMsg("红包已抢完");
//        }
//        if (packet.getStatus().intValue() == 4){
//            return RetUtils.failMsg("红包已过期");
//        }
//        if (packet.getStatus().intValue() != 2){
//            return RetUtils.failMsg("红包不可用");
//        }
        if (packet.getStatus().intValue() == 2){
            statusRet.put("redstatus", "SEND");
        }else if (packet.getStatus().intValue() == 3){
            statusRet.put("redstatus", "SUCCESS");
        }else if (packet.getStatus().intValue() == 4){
            statusRet.put("redstatus", "TIMEOUT");
        }else {
            return RetUtils.failMsg("红包状态异常");
        }

        YxUserRecieverRedPacketItem item = recieverRedPacketItemDao.findFirst("select * from yx_user_reciever_red_packet_item where redid = ? and uid = ?", packet.getId(), user.getId());
        if (item == null){
            //可抢
            statusRet.put("grabstatus", "INIT");
        }else {
            //已抢
            statusRet.put("grabstatus", "SUCCESS");
            statusRet.put("grabamount", item.getMoney());
        }

        /*if(Objects.equals(user.getOpenflag(), Const.YesOrNo.NO)) {
            return RetUtils.okData(statusRet);
        }*/
//        WxUserSendRedItem redItem = WxUserSendRedItem.dao.findFirst("select * from wx_user_send_red_item where serialnumber = ?",serialNumber);
//        if(redItem == null || Objects.equals(redItem.getStatus(), Pay5UConst.RedPacketStatus.CANCEL) || Objects.equals(redItem.getStatus(), Pay5UConst.RedPacketStatus.FAIL)) {
//            return RetUtils.failMsg("红包不存在");
//        }
//        statusRet.put("redstatus", redItem.getStatus());
//        WxUserGrabRedItem grabRedItem = WxUserGrabRedItem.dao.findFirst("select * from wx_user_grab_red_item where uid = ? and sendid = ?",user.getId(),redItem.getId());
//        if(grabRedItem == null) {
//            statusRet.put("grabstatus", Pay5UConst.Status.INIT);
//        } else {
//            statusRet.put("grabamount",grabRedItem.getAmount());
//            statusRet.put("grabstatus", grabRedItem.getStatus());
//        }
        return RetUtils.okData(statusRet);
    }


    /**
     * 红包信息
     * @param serialNumber
     * @return
     * @author xufei
     * 2020年11月22日 下午10:50:11
     */
    public Ret redInfo(HttpRequest request,String serialNumber,User user) {
//        WxUserSendRedItem redItem = WxUserSendRedItem.dao.findFirst("select red.chatmode,red.uid,red.id,red.reqid,red.amount,red.serialnumber,red.remark,red.packetcount,red.bizcompletetime,red.bizcreattime,red.receivedamount,red.receivedcount,u.nick,u.avatar,red.`status`,red.mode from wx_user_send_red_item red inner join `user` u on u.id = red.uid where red.serialnumber = ?",serialNumber);
        YxUserSendRedPacket sendRedPacket = packetDao.findById(Integer.parseInt(serialNumber));
        if(sendRedPacket == null) {
            return RetUtils.failMsg("红包不存在");
        }
        User sendUser = User.dao.findById(sendRedPacket.getSenduid());
        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("amount", sendRedPacket.getMoney());
        infoMap.put("avatar", sendUser.getAvatar());
        infoMap.put("bizcompletetime", sendRedPacket.getUpdatetime());
        infoMap.put("bizcreattime", sendRedPacket.getCreatetime());
        infoMap.put("id", sendRedPacket.getId());
        infoMap.put("mode", sendRedPacket.getMode() == 22 ? 2 : 1);
        infoMap.put("chatmode", sendRedPacket.getMode() == 1 ? 1 : 2);
        infoMap.put("nick", sendUser.getNick());
        infoMap.put("packetcount", sendRedPacket.getNum());
        infoMap.put("receivedamount", sendRedPacket.getMoney() - sendRedPacket.getRemainmoney());
        infoMap.put("receivedcount", sendRedPacket.getNum() - sendRedPacket.getRemainnum());
        infoMap.put("remark", sendRedPacket.getRemark());
        infoMap.put("serialnumber", sendRedPacket.getId());

        if (sendRedPacket.getStatus() == 2){
            infoMap.put("status", "SEND");
        }else if (sendRedPacket.getStatus() == 3){
            infoMap.put("status", "SUCCESS");
        }else if (sendRedPacket.getStatus() == 4){
            infoMap.put("status", "TIMEOUT");
        }else {
            return RetUtils.failMsg("红包不存在");
        }
        infoMap.put("uid", sendRedPacket.getId());
        Map<String, Object> infoRet = new HashMap<String, Object>();
        infoRet.put("info", infoMap);

        List<YxUserRecieverRedPacketItem> yxUserRecieverRedPacketItems = recieverRedPacketItemDao.find("select * from yx_user_reciever_red_packet_item where redid = ? order by createtime", sendRedPacket.getId());
        List<Map> mapList = new ArrayList<>();
        for (YxUserRecieverRedPacketItem item : yxUserRecieverRedPacketItems){
            User byId = User.dao.findById(item.getUid());
            Map<String, Object> map = new HashMap<>();
            map.put("amount", item.getMoney());
            map.put("avatar", byId.getAvatar());
            map.put("bizcompletetime", item.getCreatetime());
            map.put("id", item.getId());
            map.put("uid", byId.getId());
            map.put("nick", byId.getNick());
            map.put("serialnumber", item.getRedid());
            mapList.add(map);
        }
        infoRet.put("grablist", mapList);
        return RetUtils.okData(infoRet);
    }

    /**
     * 抢红包
     * @param grabRedpacketVo
     * @return
     * @author xufei
     * 2020年11月19日 上午10:45:04
     */
    public Resp grabRedpacket(GrabRedpacketVo grabRedpacketVo, HttpRequest request) throws Exception {
        if(grabRedpacketVo.getUid() == null/* || StrUtil.isBlank(grabRedpacketVo.getWalletid())*/) {
            log.error("抢红包参数为空");
            return Resp.fail("参数异常");
        }
        YxUserSendRedPacket sendRedPacket = packetDao.findById(Integer.parseInt(grabRedpacketVo.getSerialnumber()));
        if (sendRedPacket == null){
            return Resp.fail("红包不存在");
        }
        if (sendRedPacket.getStatus().intValue() == 3){
            return Resp.fail("红包已抢完");
        }
        if (sendRedPacket.getStatus().intValue() == 4){
            return Resp.fail("红包已过期");
        }
        if (sendRedPacket.getStatus().intValue() != 2){
            return Resp.fail("红包状态异常");
        }
        AbsAtom absAtom;
        GrabRedpacket5UResp grabRedpacket5UResp;
        synchronized ((Integer)(sendRedPacket.getId()%100)){

            if (new Date().getTime() - sendRedPacket.getCreatetime().getTime() >= 24 * 60 * 60 * 1000) {
                //余额要退回
                return Resp.fail("红包已过期");
            }
            if (sendRedPacket.getRemainnum() <= 0){
                sendRedPacket.setStatus(3);
                sendRedPacket.update();
                return Resp.fail("红包已抢完");
            }
            List<YxUserRecieverRedPacketItem> yxUserRecieverRedPacketItems = recieverRedPacketItemDao.find("select * from yx_user_reciever_red_packet_item where redid = ? and uid = ? and type = 1", sendRedPacket.getId(), grabRedpacketVo.getUid());
            if (yxUserRecieverRedPacketItems != null && yxUserRecieverRedPacketItems.size() > 0){
                return Resp.fail("你已抢过了");
            }

            grabRedpacket5UResp = new GrabRedpacket5UResp();
            absAtom = new AbsAtom() {
                @Override
                public boolean run() throws SQLException {
                    int remainMoney = sendRedPacket.getRemainmoney();
                    int remainNum = sendRedPacket.getRemainnum();
                    int grabMoney = 0;
                    if (sendRedPacket.getMode().intValue() == 1){
                        grabMoney = remainMoney;
                    }else if (sendRedPacket.getMode().intValue() == 21){
                        grabMoney = remainMoney/remainNum;
                    }else if (sendRedPacket.getMode().intValue() == 22){
                        //拼手气红包算法
                        if (remainNum == 1){
                            grabMoney = remainMoney;
                        }else {
                            Random r = new Random();
                            //规定最少抢到的红包有0.01元，最多为剩余的红包钱的平均值*2
                            //先每人留一分钱底钱
                            int t = (remainMoney-remainNum) / remainNum * 2;
                            int i;
                            if (t <= 0){
                                i = 0;
                            }else {
                                i = r.nextInt(t);
                            }
                            i = i + 1;
                            if (i < 1){
                                i = 1;
                            }
                            grabMoney = i;
                        }
                    }else {
                        this.msg = "红包参数错误";
                        return false;
                    }
                    //抢到红包
                    //扣减余额、扣减红包个数
                    sendRedPacket.setRemainnum(sendRedPacket.getRemainnum() - 1);
                    sendRedPacket.setRemainmoney(sendRedPacket.getRemainmoney() - grabMoney);
                    if (sendRedPacket.getRemainmoney() <= 0){
                        sendRedPacket.setStatus(3);
                    }
                    sendRedPacket.setUpdatetime(new Date());
                    if (!sendRedPacket.update()){
                        this.msg = "红包扣减余额失败";
                        return false;
                    }
                    //增加一条抢到的红包记录
                    YxUserRecieverRedPacketItem recieverRedPacketItem = new YxUserRecieverRedPacketItem();
                    recieverRedPacketItem.setMoney(grabMoney);
                    recieverRedPacketItem.setRedid(sendRedPacket.getId());
                    recieverRedPacketItem.setRemark(sendRedPacket.getRemark());
                    recieverRedPacketItem.setType(1);
                    recieverRedPacketItem.setUid(grabRedpacketVo.getUid());
                    if (!recieverRedPacketItem.save()){
                        this.msg = "红包保存失败";
                        return false;
                    }
                    //增加一条钱包明细记录
                    Ret ret = WalletService.ME.modifyBalance(WalletDetailTypeNum.RED, 1, grabMoney, Integer.parseInt(grabRedpacketVo.getWalletid()), null, null,"抢到红包", sendRedPacket.getId(), String.valueOf(sendRedPacket.getId()), true);
                    if (ret.isFail()){
                        this.msg = "余额存入失败";
                        return false;
                    }
                    //组装返回参数
                    grabRedpacket5UResp.setAmount(String.valueOf(grabMoney));
                    grabRedpacket5UResp.setSerialNumber(grabRedpacketVo.getSerialnumber());
                    return true;
                }
            };
        }
        boolean ret = Db.use(Const.Db.TIO_SITE_MAIN).tx(absAtom);
        if (ret){
            sendRedPacketGrabMsg(sendRedPacket, grabRedpacketVo, request);
            return Resp.ok(grabRedpacket5UResp);
        }
        return Resp.fail(absAtom.getMsg());
    }

    private void sendRedPacketGrabMsg(YxUserSendRedPacket sendRedPacket, GrabRedpacketVo grabRedpacketVo, HttpRequest httpRequest) throws Exception {
        //本地存储错误标识
        boolean localerror = false;
        Long chatlinkid  = null;
        Long tochatlinkid = null;
        Ret checkRet = checkChat(grabRedpacketVo.getChatmode(), grabRedpacketVo.getUid(), grabRedpacketVo.getBizid());
        //检查会话是否有效
        String checkMsg = RetUtils.getOkTData(checkRet, "localmsg");
        if(StrUtil.isNotBlank(checkMsg)) {
//            grabRedItemUpdate.setLocalerrormsg(checkMsg);
            localerror = true;
        } else {
            chatlinkid = RetUtils.getOkTData(checkRet, "chatlinkid");
            tochatlinkid = RetUtils.getOkTData(checkRet, "tochatlinkid");
        }

        User user = UserService.ME.getById(grabRedpacketVo.getUid());
        User senduser = UserService.ME.getById(sendRedPacket.getSenduid());
        if(!localerror) {
            //判断自己否激活
            if(chatlinkid == null) {
                Ret ret = actChat(grabRedpacketVo.getChatmode(), grabRedpacketVo.getUid(), grabRedpacketVo.getBizid(), user);
                String localMsg = RetUtils.getOkTData(ret, "localmsg");
                if(StrUtil.isNotBlank(localMsg)) {
//                    grabRedItemUpdate.setLocalerrormsg("localMsg");
                    localerror = true;
                } else {
                    chatlinkid = RetUtils.getOkTData(ret, "chatlinkid");
                }
            }
            //判断发送方是否激活
            if(tochatlinkid == null) {
                long tochatbizid = grabRedpacketVo.getBizid();
                if(Objects.equals(grabRedpacketVo.getChatmode(), Const.ChatMode.P2P)) {
                    tochatbizid = new Long(grabRedpacketVo.getUid());
                }
                Ret ret = actChat(grabRedpacketVo.getChatmode(), sendRedPacket.getSenduid(), tochatbizid, senduser);
                String localMsg = RetUtils.getOkTData(ret, "localmsg");
                if(StrUtil.isNotBlank(localMsg)) {
//                    grabRedItemUpdate.setLocalerrormsg("localMsg");
                    localerror = true;
                } else {
                    tochatlinkid = RetUtils.getOkTData(ret, "chatlinkid");
                }
            }
        }
        //成功发送推送信息
        if(!localerror) {
            //Byte chatMode, Long chatBizid, Integer uid, Integer senduid, Byte devicetype, String ip, String appver
            RequestExt reqExt = getReqExt(httpRequest);
            localerror = grabRedpacketNtf(chatlinkid, tochatlinkid, user, senduser, grabRedpacketVo.getChatmode(),grabRedpacketVo.getBizid(),grabRedpacketVo.getUid()
                    , sendRedPacket.getSenduid(), getDeviceType(reqExt), getIp(httpRequest), getAppVersion(reqExt));
        }
    }

    /**
     * @param chatmode
     * @param uid
     * @param bizid
     * @param user
     * @return
     * @author xufei
     * 2020年11月27日 上午11:02:03
     */
    @SuppressWarnings("deprecation")
    private static Ret actChat(Byte chatmode,Integer uid,Long bizid,User user) {
        String localmsg = "";
        Long chatlinkid = null;
        if(Objects.equals(chatmode, Const.ChatMode.P2P)) {
            Ret ret = ChatService.me.actFdChatItems(uid, bizid.intValue());
            if(ret.isFail()) {
                log.error("自己的会话激活失败-私聊，uid:{},touid:{}",uid,bizid.intValue());
                localmsg = "自己的会话激活失败-私聊";
            } else {
                chatlinkid = RetUtils.getOkTData(ret,"chatlinkid");
                if(WxSynApi.isSynVersion()) {
                    WxSynApi.synChatSession(uid, RetUtils.getOkTData(ret, "chat"), SynRecordVo.SynType.ADD);
                } else {
                    WxChatApi.userActOper(uid,RetUtils.getOkTData(ret, "chat"));
                }
            }
        } else {
            WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(uid, bizid);
            if(groupItem.getChatlinkid() == null) {
                Ret actRet = ChatService.me.actGroupChatItems(bizid,user.getId());
                if(actRet.isFail()) {
                    log.error("自己的会话激活失败-群聊，uid:{},touid:{}",uid,bizid);
                    localmsg = "自己的会话激活失败-群聊";
                } else {
                    if(WxSynApi.isSynVersion()) {
                        WxSynApi.synChatSession(uid, RetUtils.getOkTData(actRet, "chat"), SynRecordVo.SynType.ADD);
                    } else {
                        WxChatApi.userActOper(uid,RetUtils.getOkTData(actRet, "chat"));
                    }
                }
                chatlinkid = RetUtils.getOkTData(actRet,"chatlinkid");
            } else {
                chatlinkid = groupItem.getChatlinkid();
            }
        }
        return Ret.ok().set("chatlinkid",chatlinkid).set("localmsg",localmsg);
    }

    /**
     * @param chatmode
     * @param uid
     * @param bizid
     * @return
     * @author xufei
     * 2020年11月27日 上午11:14:11
     */
    private static Ret checkChat(Byte chatmode,Integer uid,Long bizid) {
        String localmsg = "";
        WxChatUserItem userItem = ChatIndexService.chatUserIndex(uid, bizid, chatmode);
        //判断是否会话有效
        if(Objects.equals(chatmode, Const.ChatMode.P2P)) {
            if(!ChatService.existTwoFriend(userItem)) {
                log.error("相互不是好友，userindex:{}",userItem);
                localmsg = "相互不是好友";
            }
        } else {
            WxChatGroupItem groupItem = ChatIndexService.chatGroupIndex(uid, bizid);
            if(!ChatService.groupExistChat(groupItem)) {
                log.error("不是群成员，userindex:{}",userItem);
                localmsg = "不是群成员";
            }
        }
        return Ret.ok().set("chatlinkid",userItem.getChatlinkid()).set("tochatlinkid",userItem.getTochatlinkid()).set("localmsg",localmsg);
    }

    /**
     * 发送红包消息
     * @param chatlinkid
     * @param tochatlinkid
     * @param user
     * @param senduser
     * @throws Exception
     * @author xufei
     * 2020年11月27日 下午4:08:30
     */
    private static boolean grabRedpacketNtf(Long chatlinkid,Long tochatlinkid,User user,User senduser,Byte chatMode, Long chatBizid, Integer uid, Integer senduid, Byte devicetype, String ip, String appver) throws Exception {
        WxChatUserItem userItem = ChatIndexService.chatUserIndex(chatlinkid);
        WxChatUserItem touserUserItem = ChatIndexService.chatUserIndex(tochatlinkid);
        Byte chatmode = chatMode;
        Long bizid = chatBizid;
        if(Objects.equals(chatmode, Const.ChatMode.P2P)) {
            if(Objects.equals(senduid, uid)) {
                WxFriendMsg grabMsg = FriendService.me.addChatMsg(devicetype, "", ip, uid, "你领取了 你 的红包", senduid,null,null,appver);
                if(grabMsg == null) {
//                    grabRedItemUpdate.setLocalerrormsg("接受方消息保存失败");
                    return false;
                }
                WxFriendChatNtf grabNtf = WxFriendChatNtf.from(grabMsg);
                grabNtf.setRedflag(Const.YesOrNo.YES);
                grabNtf.setChatlinkid(chatlinkid);
                ImPacket grabPacket = new ImPacket(Command.WxFriendChatNtf, Json.toJson(grabNtf));
                Ims.sendToUser(uid, grabPacket);
                Ret ret = ChatMsgService.me.afterSendFriendChatMsg(grabMsg,user, userItem.getChatlinkmetaid(),
                        null, null, null );
                if(ret.isFail()) {
//                    grabRedItemUpdate.setLocalerrormsg("更改消息会话错误-抢红包");
                    return false;
                }
                clearFriendCache(uid, bizid.intValue(), chatlinkid, null);
            } else {
                WxFriendMsg grabMsg = FriendService.me.addChatMsg(devicetype, "", ip, uid, "你领取了 " + senduser.getNick() + " 的红包", senduid,null,null,appver);
                if(grabMsg == null) {
//                    grabRedItemUpdate.setLocalerrormsg("接受方消息保存失败");
                    return false;
                }
                WxFriendChatNtf grabNtf = WxFriendChatNtf.from(grabMsg);
                grabNtf.setRedflag(Const.YesOrNo.YES);
                grabNtf.setChatlinkid(chatlinkid);
                ImPacket grabPacket = new ImPacket(Command.WxFriendChatNtf, Json.toJson(grabNtf));
                Ims.sendToUser(uid, grabPacket);
                Ret ret = ChatMsgService.me.afterSendFriendChatMsg(grabMsg,user, userItem.getChatlinkmetaid(),
                        null, null, null );
                if(ret.isFail()) {
//                    grabRedItemUpdate.setLocalerrormsg("更改消息会话错误-抢红包");
                    return false;
                }
                WxFriendMsg sendMsg = FriendService.me.addChatMsg(devicetype, "",ip, senduid, user.getNick() + " 领取了你的红包", uid,null,null,appver);
                if(sendMsg == null) {
//                    grabRedItemUpdate.setLocalerrormsg("红包发送方消息保存失败");
                    return false;
                }
                WxFriendChatNtf sendNtf = WxFriendChatNtf.from(sendMsg);
                sendNtf.setRedflag(Const.YesOrNo.YES);
                sendNtf.setChatlinkid(tochatlinkid);
                ImPacket sendPacket = new ImPacket(Command.WxFriendChatNtf, Json.toJson(sendNtf));
                Ims.sendToUser(senduid, sendPacket);
                Ret toret = ChatMsgService.me.afterSendFriendChatMsg(sendMsg,senduser, touserUserItem.getChatlinkmetaid(),
                        null, null, null);
                if(toret.isFail()) {
//                    grabRedItemUpdate.setLocalerrormsg("更改消息会话错误-tosend-抢红包");
                    return false;
                }
                clearFriendCache(uid, senduid, chatlinkid, tochatlinkid);
            }
        } else {
            Byte contentType = Const.ContentType.TEXT;
            Byte sysflag = Const.YesOrNo.YES;
            if(Objects.equals(senduid, uid)) {
                WxGroupMsg grabMsg = GroupService.me.addMsg(devicetype, "", "你领取了 自己 的红包", uid, ip, bizid,contentType , sysflag, uid, null, null,null,"",null,null,appver);
                if(grabMsg == null) {
//                    grabRedItemUpdate.setLocalerrormsg("自己抢自己的红包消息保存失败");
                    return false;
                }
                WxGroupChatNtf grabNtf = WxGroupChatNtf.from(grabMsg,null);
                grabNtf.setRedflag(Const.YesOrNo.YES);
                grabNtf.setChatlinkid(-bizid);
                ImPacket grabPacket = new ImPacket(Command.WxGroupChatNtf, Json.toJson(grabNtf));
                Ims.sendToUser(uid, grabPacket);
                ChatMsgService.me.afterSendGroupById(grabMsg, null,userItem.getChatlinkmetaid(),null);
                clearGroupCache(uid, null, bizid);
            } else {
                WxGroupMsg grabMsg = GroupService.me.addMsg(devicetype, "", "你领取了 " + senduser.getNick() + " 的红包", uid, ip, bizid,contentType , sysflag, uid, null, null,null,"",null,null,appver);
                if(grabMsg == null) {
//                    grabRedItemUpdate.setLocalerrormsg("自己抢的红包消息保存失败");
                    return false;
                }
                WxGroupChatNtf grabNtf = WxGroupChatNtf.from(grabMsg,null);
                grabNtf.setRedflag(Const.YesOrNo.YES);
                grabNtf.setChatlinkid(-bizid);
                ImPacket grabPacket = new ImPacket(Command.WxGroupChatNtf, Json.toJson(grabNtf));
                Ims.sendToUser(uid, grabPacket);
                ChatMsgService.me.afterSendGroupById(grabMsg, null,userItem.getChatlinkmetaid(),null);
                WxGroupMsg sendMsg = GroupService.me.addMsg(devicetype, "", user.getNick() + " 领取了你的红包", senduid, ip, bizid,contentType , sysflag, senduid, null, null,null,"",null,null,appver);
                if(sendMsg == null) {
//                    grabRedItemUpdate.setLocalerrormsg("红包发送方消息保存失败");
                    return false;
                }
                WxGroupChatNtf sendNtf = WxGroupChatNtf.from(sendMsg,null);
                sendNtf.setRedflag(Const.YesOrNo.YES);
                sendNtf.setChatlinkid(-bizid);
                ImPacket sendPacket = new ImPacket(Command.WxGroupChatNtf, Json.toJson(sendNtf));
                Ims.sendToUser(senduid, sendPacket);
                ChatMsgService.me.afterSendGroupById(sendMsg, null,touserUserItem.getChatlinkmetaid(),null);
                clearGroupCache(uid, senduid, bizid);
            }

        }
        return true;
    }

    /**
     * @param uid
     * @param touid
     * @param chatlinkid
     * @param tochatlinkid
     * @author xufei
     * 2020年12月4日 下午6:03:56
     */
    private static void clearFriendCache(Integer uid,Integer touid,Long chatlinkid,Long tochatlinkid) {
        ChatIndexService.clearChatUserIndex(uid,new Long(touid), Const.ChatMode.P2P);
        ChatIndexService.removeChatItemsCache(chatlinkid);
        if(tochatlinkid != null) {
            ChatIndexService.clearChatUserIndex(touid,new Long(uid),Const.ChatMode.P2P);
            ChatIndexService.removeChatItemsCache(tochatlinkid);
        }
    }

    /**
     * @param uid
     * @param touid
     * @author xufei
     * 2020年12月4日 下午6:04:06
     */
    private static void clearGroupCache(Integer uid,Integer touid,Long groupid) {
        ChatIndexService.removeChatGroupCache(groupid, uid);
        ChatIndexService.removeUserCache(uid, groupid, Const.ChatMode.GROUP);
        if(touid != null) {
            ChatIndexService.removeChatGroupCache(groupid, touid);
            ChatIndexService.removeUserCache(touid, groupid, Const.ChatMode.GROUP);
        }
        ChatIndexService.clearGroupMsgCache(groupid);
    }

    /**
     * @param request
     * @return
     * @author xufei
     * 2020年11月22日 下午9:19:59
     */
    public static RequestExt getReqExt(HttpRequest request) {
        if(request == null) {
            return null;
        }
        return (RequestExt)request.getAttribute(RequestKey.REQUEST_EXT);
    }

    /**
     * @param PayQuest
     * @return
     * @author xufei
     * 2020年11月22日 下午9:19:59
     */
    public static RequestExt getReqExt(BasePayReq PayQuest) {
        HttpRequest request = PayQuest.getRequest();
        return  getReqExt(request);
    }


    /**
     * 设备
     * @param ext
     * @return
     * @author xufei
     * 2020年11月22日 下午9:19:56
     */
    public static Byte getDeviceType(RequestExt ext) {
        if(ext == null) {
            return Devicetype.SYS_TASK.getValue();
        }
        return ext.getDeviceType();
    }

    /**
     * 客户端ip
     * @return
     * @author xufei
     * 2020年11月22日 下午9:22:42
     */
    public static String getIp(HttpRequest request) {
        if(request == null) {
            return "0.0.0.0";
        }
        return request.getClientIp();
    }


    /**
     * app版本号
     * @param ext
     * @return
     * @author xufei
     * 2020年11月22日 下午9:23:47
     */
    public static String getAppVersion(RequestExt ext) {
        if(ext == null) {
            return "0.0.0";
        }
        return ext.getAppVersion();
    }

    /**
     * 抢红包记录
     * @param uid
     * @param pageNumber
     * @return
     * @author xufei
     * 2020年11月19日 上午11:33:07
     */
    public Ret grabRedpacketlist(Integer uid,Integer pageNumber,String period) {
        Kv params = Kv.by("uid", uid).set("type", 1);
        DateTime dateTime = new DateTime();
        if(StrUtil.isNotBlank(period)) {
            dateTime = PeriodUtils.getDateByPeriod(period);
        }
        String starttime = DateUtil.format(DateUtil.beginOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
        String endtime = DateUtil.format(DateUtil.endOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
        params.set("starttime", starttime).set("endtime", endtime);
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("redpacket.grablistnew", params);
        Page<Record> redpacketPage = Db.use(Const.Db.TIO_SITE_MAIN).paginate(pageNumber, 16, sqlPara);
        return RetUtils.okPage(redpacketPage);
    }

    /**
     *
     * @param uid
     * @param period
     * @return
     * @author xufei
     * 2020年11月27日 下午4:52:51
     */
    public Ret grabRedpacketStat(Integer uid,String period) {
        Kv params = Kv.by("uid", uid).set("type",1);
        DateTime dateTime = new DateTime();
        if(StrUtil.isNotBlank(period)) {
            dateTime = PeriodUtils.getDateByPeriod(period);
        }
        String starttime = DateUtil.format(DateUtil.beginOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
        String endtime = DateUtil.format(DateUtil.endOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
        params.set("starttime", starttime).set("endtime", endtime);
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("redpacket.grabstatnew", params);
        Record redpacketstat = Db.use(Const.Db.TIO_SITE_MAIN).findFirst(sqlPara);
        return RetUtils.okData(redpacketstat);
    }

    /**
     * 发送红包记录
     * @param uid
     * @param pageNumber
     * @return
     * @author xufei
     * 2020年11月19日 上午11:32:00
     */
    public Ret sendRedpacketlist(Integer uid,Integer pageNumber,String period) {
        Kv params = Kv.by("uid", uid).set("statuses",
                "'" + 2 + "','"
                        + 3 + "','"
                        + 4 +  "'" );
        DateTime dateTime = new DateTime();
        if(StrUtil.isNotBlank(period)) {
            dateTime = PeriodUtils.getDateByPeriod(period);
        }
        String starttime = DateUtil.format(DateUtil.beginOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
        String endtime = DateUtil.format(DateUtil.endOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
        params.set("starttime", starttime).set("endtime", endtime);
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("redpacket.sendlistnew", params);
        Page<Record> redpacketPage = Db.use(Const.Db.TIO_SITE_MAIN).paginate(pageNumber, 16, sqlPara);
        return RetUtils.okPage(redpacketPage);
    }

    /**
     * @param uid
     * @param period
     * @return
     * @author xufei
     * 2020年11月27日 下午4:50:13
     */
    public Ret sendRedpacketStat(Integer uid,String period) {
        Kv params = Kv.by("uid", uid).set("statuses",
                "'" + 2 + "','"
                        + 3 + "','"
                        + 4 +  "'" );
        DateTime dateTime = new DateTime();
        if(StrUtil.isNotBlank(period)) {
            dateTime = PeriodUtils.getDateByPeriod(period);
        }
        String starttime = DateUtil.format(DateUtil.beginOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
        String endtime = DateUtil.format(DateUtil.endOfYear(dateTime), DatePattern.NORM_DATETIME_PATTERN);
        params.set("starttime", starttime).set("endtime", endtime);
        SqlPara sqlPara = Db.use(Const.Db.TIO_SITE_MAIN).getSqlPara("redpacket.sendstatnew", params);
        Record redpacketstat = Db.use(Const.Db.TIO_SITE_MAIN).findFirst(sqlPara);
        return RetUtils.okData(redpacketstat);
    }
}
