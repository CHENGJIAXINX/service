/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.model.main;

import org.tio.sitexxx.service.model.main.base.BaseWxFriendMsg;
import org.tio.sitexxx.servicecommon.vo.wx.*;
import org.tio.utils.json.Json;

import cn.hutool.core.util.StrUtil;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class WxFriendMsg extends BaseWxFriendMsg<WxFriendMsg> {
	
	public static final Long maxid = 999999999999999999l;
	
	public static final WxFriendMsg dao = new WxFriendMsg().dao();
	
	public void setMid(java.lang.Long mid) {
		put("mid", mid);
	}
	
	public java.lang.Long getMid() {
		if(getLong("mid") == null) {
			return getId();
		}
		return getLong("mid");
	}
	
	public void setC(java.lang.String c) {
		put("c", c);
	}
	
	/**
	 * 聊天内容（原始内容）
	 */
	public java.lang.String getC() {
		if(StrUtil.isBlank(getStr("c"))) {
			return getText();
		}
		return getStr("c");
	}
	
	/**
	 * 聊天时间
	 */
	public void setT(java.util.Date t) {
		put("t", t);
	}
	
	/**
	 * 聊天时间
	 */
	public java.util.Date getT() {
		if(get("t") == null) {
			return getTime();
		}
		return get("t");
	}
	/**
	 * 内容类型，1、普通文本消息，2、超链接卡片消息，3、文件，4、音频，5、视频
	 */
	public void setCt(java.lang.Byte ct) {
		put("ct", ct);
	}
	
	/**
	 * 内容类型，1、普通文本消息，2、超链接卡片消息，3、文件，4、音频，5、视频
	 */
	public java.lang.Byte getCt() {
		if(getByte("ct") == null) {
			return getContenttype();
		}
		return getByte("ct");
	}
	
	/**
	 * 昵称
	 */
	public void setNick(java.lang.String nick) {
		put("nick", nick);
	}
	
	/**
	 * 昵称
	 */
	public java.lang.String getNick() {
		return getStr("nick");
	}

	/**
	 * 头像url
	 */
	public void setAvatar(java.lang.String avatar) {
		put("avatar", avatar);
	}
	
	/**
	 * 头像url
	 */
	public java.lang.String getAvatar() {
		return getStr("avatar");
	}
	
	public WxRedVo getRed() {
		String obj = getStr("red");
		if(StrUtil.isNotBlank(obj)) {
			return Json.toBean(obj, WxRedVo.class);
		}
		return null ;
	}
	
	public void setRed(java.lang.String red) {
		put("red", red);
	}
	
	/**
	 * 红包订单号
	 */
	public java.lang.String getSerialNumber() {
		return getStr("serialNumber");
	}
	
	/**
	 * 消息类型
	 * 1：正常消息：2：操作消息
	 * @author xufei
	 * 2020年1月15日 上午10:37:25
	 */
	public static interface MsgType {
		/**
		 *  正常消息
		 */
		byte NORMAL = 1;

		/**
		 * 操作消息
		 */
		byte oper = 2;
	}

	public YxLocationMsgVo getLocation(){
		String obj = getStr("location");
		if (StrUtil.isNotBlank(obj)){
			return Json.toBean(obj, YxLocationMsgVo.class);
		}
		return null;
	}
	
	public Video getVc() {
		String obj = getStr("vc");
		if(StrUtil.isNotBlank(obj)) {
			return Json.toBean(obj, Video.class);
		}
		return null ;
	}

	public String getBc() {
		return getStr("bc");
	}

	public Audio getAc() {
		String obj = getStr("ac");
		if(StrUtil.isNotBlank(obj)) {
			return Json.toBean(obj, Audio.class);
		}
		return null ;
	}


	public File getFc() {
		String obj = getStr("fc");
		if(StrUtil.isNotBlank(obj)) {
			return Json.toBean(obj, File.class);
		}
		return null ;
	}

	public Img getIc() {
		String obj = getStr("ic");
		if(StrUtil.isNotBlank(obj)) {
			return Json.toBean(obj, Img.class);
		}
		return null ;
	}

	public WxMsgCardVo getCardc() {
		String obj = getStr("cardc");
		if(StrUtil.isNotBlank(obj)) {
			return Json.toBean(obj, WxMsgCardVo.class);
		}
		return null ;
	}
	
	public WxTemplateMsgVo getTemp() {
		String obj = getStr("temp");
		if(StrUtil.isNotBlank(obj)) {
			return Json.toBean(obj, WxTemplateMsgVo.class);
		}
		return null ;
	}
	
	public WxCallItemVo getCall() {
		String obj = getStr("call");
		if(StrUtil.isNotBlank(obj)) {
			return Json.toBean(obj, WxCallItemVo.class);
		}
		return null ;
	}
	
	public void setVc(String vc) {
		put("vc",vc);
	}

	public void setBc(String bc) {
		put("bc",bc);
	}

	public void setAc(String ac) {
		put("ac",ac);
	}


	public void setFc(String fc) {
		put("fc",fc);
	}

	public void setIc(String ic) {
		put("ic",ic);
	}

	public void setLocation(String location){
		put("location", location);
	}

	public void setCardc(String cardc) {
		put("cardc",cardc);
	}
	
	public void setCall(String call) {
		put("call",call);
	}
	
	public void setTemp(String temp) {
		put("temp",temp);
	}

	public void setFaceEmotion(String faceEmotion){
		put("faceEmotion", faceEmotion);
	}


	public YxFaceEmotionMsgVo getFaceEmotion(){
		String obj = getStr("faceEmotion");
		if (StrUtil.isNotBlank(obj)){
			return Json.toBean(obj, YxFaceEmotionMsgVo.class);
		}
		return null;
	}

	public void setTransAmountVo(String transAmountVo){
		put("transAmountVo", transAmountVo);
	}


	public TransAmountVo getTransAmountVo(){
		String obj = getStr("transAmountVo");
		if (StrUtil.isNotBlank(obj)){
			return Json.toBean(obj, TransAmountVo.class);
		}
		return null;
	}

	public void setTransSendVo(String transSendVo){
		put("transSendVo", transSendVo);
	}

	public TransSendVo getTransSendVo(){
		String obj = getStr("transSendVo");
		if (StrUtil.isNotBlank(obj)){
			return Json.toBean(obj, TransSendVo.class);
		}
		return null;
	}
}
