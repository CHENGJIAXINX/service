/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.sitexxx.im.common.bs.wx.friend;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.tio.sitexxx.service.model.main.Audio;
import org.tio.sitexxx.service.model.main.File;
import org.tio.sitexxx.service.model.main.Img;
import org.tio.sitexxx.service.model.main.Video;
import org.tio.sitexxx.service.model.main.WxFriendMsg;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.wx.*;
import org.tio.utils.json.Json;

/**
 * 朋友间的聊天通知-- Server-->Client
 * @author tanyaowu 
 * 2016年9月12日 下午3:09:08
 */
public class WxFriendChatNtf implements Serializable {
	private static final long	serialVersionUID	= 4487525418584644680L;
	private Long				mid;										//消息id，全局唯一，一条消息一个id
	private Long				t;											//消息发送时间
	private String				c;											//聊天内容
	private Byte				ct					= null;					//WxFriendMsg.ContentType 1、普通文本消息，2、超链接卡片消息，3、文件，4、音频，5、视频
	private Integer				uid;										//发送方的userid
	private Integer				touid;										//接收方的userid
	private Byte				sendbysys			= 2;					//该消息是否由系统发出，true：为系统发出，null/false：非系统发出
	private Date				readtime;
	private Byte				readflag			= 2;
	private Byte				actflag				= 2;					//该消息是否是激活聊天消息
	private Byte				msgtype				= 1;   					//消息的类型：1：正常消息：2：操作消息
	private String				nick;										//发送方昵称
	private String				avatar;										//发送方头像
	private Long 				chatlinkid;									//聊天列表id
	
	private Video				vc;											//视频内容
	private String				bc;											//博客内容
	private Audio				ac;											//音频内容
	private File				fc;											//文件内容
	private Img 				ic;											//图片内容
	private WxMsgCardVo cardc;										//名片内容
	private WxCallItemVo call;										//音视频通话内容
	private WxRedVo red;								//红包订单号
	private Byte				redflag = Const.YesOrNo.NO;					//红包通知
	private YxLocationMsgVo location;							//位置信息
	private YxFaceEmotionMsgVo faceEmotion;							//表情
	private TransAmountVo transAmountVo;						//转账
	private TransSendVo transSendVo;
	private WxTemplateMsgVo temp;								//模板消息
	
	private String				actname;									//激活时的名称
	private String				actavatar;									//激活时的头像
		
	/**
	 * @param wxFriendMsg
	 * @return
	 * @author xufei
	 * 2020年2月13日 下午9:35:48
	 */
	public static WxFriendChatNtf from(WxFriendMsg wxFriendMsg) {
		WxFriendChatNtf ret = new WxFriendChatNtf();
		ret.setC(wxFriendMsg.getText());
		switch (wxFriendMsg.getContenttype()) {
			case Const.ContentType.TEXT:
				//保存缩略文字
				break;
			case Const.ContentType.AUDIO:
				Audio audio = Json.toBean(wxFriendMsg.getText(), Audio.class);
				//保存音频
				ret.setAc(audio);
				break;
			case Const.ContentType.BLOG:
				//保存微博
				ret.setBc(wxFriendMsg.getText());
				break;
			case Const.ContentType.FILE:
				File file = Json.toBean(wxFriendMsg.getText(), File.class);
				//保存文件
				ret.setFc(file);
				break;
			case Const.ContentType.IMG:
				Img img = Json.toBean(wxFriendMsg.getText(), Img.class);
				//保存图片
				ret.setIc(img);
				break;
			case Const.ContentType.VIDEO:
				Video video = Json.toBean(wxFriendMsg.getText(), Video.class);
				//保存视频
				ret.setVc(video);
				break;
			case Const.ContentType.MSG_CARD:
				WxMsgCardVo cardVo = Json.toBean(wxFriendMsg.getText(), WxMsgCardVo.class);
				//保存名片
				ret.setCardc(cardVo);
				break;
			case Const.ContentType.CALL_AUDIO:
				WxCallItemVo audioCall = Json.toBean(wxFriendMsg.getText(), WxCallItemVo.class);
				ret.setCall(audioCall);
				break;
			case Const.ContentType.CALL_VIDEO:
				WxCallItemVo videoCall = Json.toBean(wxFriendMsg.getText(), WxCallItemVo.class);
				ret.setCall(videoCall);
				break;
			case Const.ContentType.REDPACKET:
				WxRedVo redVo = Json.toBean(wxFriendMsg.getText(), WxRedVo.class);
				ret.setRed(redVo);
				break;
			case Const.ContentType.TEMPLATE:
				WxTemplateMsgVo tempVo = Json.toBean(wxFriendMsg.getText(), WxTemplateMsgVo.class);
				ret.setTemp(tempVo);
				break;
			case Const.ContentType.LOCATION:
				YxLocationMsgVo locationMsgVo = Json.toBean(wxFriendMsg.getText(), YxLocationMsgVo.class);
				ret.setLocation(locationMsgVo);
				break;
			case Const.ContentType.FACE_EMOTION:
				YxFaceEmotionMsgVo faceEmotionMsgVo = Json.toBean(wxFriendMsg.getText(), YxFaceEmotionMsgVo.class);
				ret.setFaceEmotion(faceEmotionMsgVo);
				break;
			case Const.ContentType.TRANS_AMOUNT:
				TransAmountVo transAmountVo = Json.toBean(wxFriendMsg.getText(), TransAmountVo.class);
				ret.setTransAmountVo(transAmountVo);
				break;
			case Const.ContentType.TRANS_SEND:
				TransSendVo transSendVo = Json.toBean(wxFriendMsg.getText(), TransSendVo.class);
				ret.setTransSendVo(transSendVo);
			default:
		}
		ret.setCt(wxFriendMsg.getContenttype());
		ret.setMid(wxFriendMsg.getId());
		ret.setT(wxFriendMsg.getTime().getTime());
		ret.setTouid(wxFriendMsg.getTouid());
		ret.setUid(wxFriendMsg.getUid());
		ret.setReadflag(wxFriendMsg.getReadflag());
		if (Objects.equals(wxFriendMsg.getSendbysys(), Const.Sendbysys.YES)) {
			ret.setSendbysys(wxFriendMsg.getSendbysys());
		}
		ret.setMsgtype(wxFriendMsg.getMsgtype());
		ret.setReadtime(wxFriendMsg.getReadtime());
		return ret;
	}
	
	public WxRedVo getRed() {
		return red;
	}

	public void setRed(WxRedVo red) {
		this.red = red;
	}

	public WxTemplateMsgVo getTemp() {
		return temp;
	}

	public void setTemp(WxTemplateMsgVo temp) {
		this.temp = temp;
	}

	public Byte getRedflag() {
		return redflag;
	}

	public void setRedflag(Byte redflag) {
		this.redflag = redflag;
	}

	public WxCallItemVo getCall() {
		return call;
	}

	public YxLocationMsgVo getLocation() {
		return location;
	}

	public void setLocation(YxLocationMsgVo location) {
		this.location = location;
	}

	public YxFaceEmotionMsgVo getFaceEmotion() {
		return faceEmotion;
	}

	public void setFaceEmotion(YxFaceEmotionMsgVo faceEmotion) {
		this.faceEmotion = faceEmotion;
	}

	public TransAmountVo getTransAmountVo() {
		return transAmountVo;
	}

	public void setTransAmountVo(TransAmountVo transAmountVo) {
		this.transAmountVo = transAmountVo;
	}

	public TransSendVo getTransSendVo() {
		return transSendVo;
	}

	public void setTransSendVo(TransSendVo transSendVo) {
		this.transSendVo = transSendVo;
	}

	public void setCall(WxCallItemVo call) {
		this.call = call;
	}


	public String getBc() {
		return bc;
	}

	public void setBc(String bc) {
		this.bc = bc;
	}

	public Video getVc() {
		return vc;
	}


	public void setVc(Video vc) {
		this.vc = vc;
	}


	public Audio getAc() {
		return ac;
	}


	public void setAc(Audio ac) {
		this.ac = ac;
	}


	public File getFc() {
		return fc;
	}


	public void setFc(File fc) {
		this.fc = fc;
	}


	public Img getIc() {
		return ic;
	}


	public void setIc(Img ic) {
		this.ic = ic;
	}


	public WxMsgCardVo getCardc() {
		return cardc;
	}


	public void setCardc(WxMsgCardVo cardc) {
		this.cardc = cardc;
	}


	public String getActname() {
		return actname;
	}

	public void setActname(String actname) {
		this.actname = actname;
	}

	public String getActavatar() {
		return actavatar;
	}

	public void setActavatar(String actavatar) {
		this.actavatar = actavatar;
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public Long getT() {
		return t;
	}

	public void setT(Long t) {
		this.t = t;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Byte getCt() {
		return ct;
	}

	public void setCt(Byte ct) {
		this.ct = ct;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getTouid() {
		return touid;
	}

	public void setTouid(Integer touid) {
		this.touid = touid;
	}

	/**
	 * @return the readflag
	 */
	public Byte getReadflag() {
		return readflag;
	}

	/**
	 * @param readflag the readflag to set
	 */
	public void setReadflag(Byte readflag) {
		this.readflag = readflag;
	}

	public Byte getSendbysys() {
		return sendbysys;
	}

	public void setSendbysys(Byte sendbysys) {
		this.sendbysys = sendbysys;
	}

	public Date getReadtime() {
		return readtime;
	}

	public void setReadtime(Date readtime) {
		this.readtime = readtime;
	}

	public Byte getActflag() {
		return actflag;
	}

	public void setActflag(Byte actflag) {
		this.actflag = actflag;
	}

	public Byte getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(Byte msgtype) {
		this.msgtype = msgtype;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getAvatar() {
		return avatar;
	}
	public Long getChatlinkid() {
		return chatlinkid;
	}

	public void setChatlinkid(Long chatlinkid) {
		this.chatlinkid = chatlinkid;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
