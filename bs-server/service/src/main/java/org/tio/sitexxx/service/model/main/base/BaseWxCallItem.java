package org.tio.sitexxx.service.model.main.base;

import org.tio.sitexxx.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseWxCallItem<M extends BaseWxCallItem<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	/**
	 * 1、 音频通话，2、视频通话
	 */
	public void setType(java.lang.Byte type) {
		set("type", type);
	}
	
	/**
	 * 1、 音频通话，2、视频通话
	 */
	public java.lang.Byte getType() {
		return getByte("type");
	}

	/**
	 * 呼叫状态：1、发起呼叫， 2、信令接通，3、流媒体接通，4、通话结束（拒接、占线、挂断都属于通话结束）
	 */
	public void setStatus(java.lang.Byte status) {
		set("status", status);
	}
	
	/**
	 * 呼叫状态：1、发起呼叫， 2、信令接通，3、流媒体接通，4、通话结束（拒接、占线、挂断都属于通话结束）
	 */
	public java.lang.Byte getStatus() {
		return getByte("status");
	}

	/**
	 * 挂断类型 
1、正常挂断
2、拒接挂断
3、对方正在通话
4、TCP断开时，系统自动挂断
5、客户端出现异常，系统自动挂机（譬如获取摄像头失败等），这个请求是客户端发起的挂断请求
6、ICE服务器异常，这个请求是客户端发起的挂断请求
7、系统重启
8、对方不在线
9、等待响应超时
10、发起方取消了通话
99、还没有挂断
	 */
	public void setHanguptype(java.lang.Byte hanguptype) {
		set("hanguptype", hanguptype);
	}
	
	/**
	 * 挂断类型 
1、正常挂断
2、拒接挂断
3、对方正在通话
4、TCP断开时，系统自动挂断
5、客户端出现异常，系统自动挂机（譬如获取摄像头失败等），这个请求是客户端发起的挂断请求
6、ICE服务器异常，这个请求是客户端发起的挂断请求
7、系统重启
8、对方不在线
9、等待响应超时
10、发起方取消了通话
99、还没有挂断
	 */
	public java.lang.Byte getHanguptype() {
		return getByte("hanguptype");
	}

	/**
	 * 挂断一方的uid，如果是系统挂断，则是null
	 */
	public void setHangupuid(java.lang.Integer hangupuid) {
		set("hangupuid", hangupuid);
	}
	
	/**
	 * 挂断一方的uid，如果是系统挂断，则是null
	 */
	public java.lang.Integer getHangupuid() {
		return getInt("hangupuid");
	}

	/**
	 * 呼叫开始时间（一方请求通话请求的时间）
	 */
	public void setCalltime(java.util.Date calltime) {
		set("calltime", calltime);
	}
	
	/**
	 * 呼叫开始时间（一方请求通话请求的时间）
	 */
	public java.util.Date getCalltime() {
		return get("calltime");
	}

	/**
	 * 对方响应时间点
	 */
	public void setResptime(java.util.Date resptime) {
		set("resptime", resptime);
	}
	
	/**
	 * 对方响应时间点
	 */
	public java.util.Date getResptime() {
		return get("resptime");
	}

	/**
	 * 接通时间（对方同意通话时间）
	 */
	public void setConnectedtime(java.util.Date connectedtime) {
		set("connectedtime", connectedtime);
	}
	
	/**
	 * 接通时间（对方同意通话时间）
	 */
	public java.util.Date getConnectedtime() {
		return get("connectedtime");
	}

	/**
	 * 通话结束时间
	 */
	public void setEndtime(java.util.Date endtime) {
		set("endtime", endtime);
	}
	
	/**
	 * 通话结束时间
	 */
	public java.util.Date getEndtime() {
		return get("endtime");
	}

	/**
	 * resptime-calltime
	 */
	public void setRespwait(java.lang.Long respwait) {
		set("respwait", respwait);
	}
	
	/**
	 * resptime-calltime
	 */
	public java.lang.Long getRespwait() {
		return getLong("respwait");
	}

	/**
	 * connectedtime-resptime
	 */
	public void setStreamwait(java.lang.Long streamwait) {
		set("streamwait", streamwait);
	}
	
	/**
	 * connectedtime-resptime
	 */
	public java.lang.Long getStreamwait() {
		return getLong("streamwait");
	}

	/**
	 * 通话时长（endtime-connectedtime)  
	 */
	public void setCallduration(java.lang.Long callduration) {
		set("callduration", callduration);
	}
	
	/**
	 * 通话时长（endtime-connectedtime)  
	 */
	public java.lang.Long getCallduration() {
		return getLong("callduration");
	}

	/**
	 * 通话发起人的userid
	 */
	public void setFromuid(java.lang.Integer fromuid) {
		set("fromuid", fromuid);
	}
	
	/**
	 * 通话发起人的userid
	 */
	public java.lang.Integer getFromuid() {
		return getInt("fromuid");
	}

	/**
	 * 通话发起人的channelcontextid
	 */
	public void setFromcid(java.lang.String fromcid) {
		set("fromcid", fromcid);
	}
	
	/**
	 * 通话发起人的channelcontextid
	 */
	public java.lang.String getFromcid() {
		return getStr("fromcid");
	}

	/**
	 * 发起人的ipid（ipinfo表的id）
	 */
	public void setFromipid(java.lang.Integer fromipid) {
		set("fromipid", fromipid);
	}
	
	/**
	 * 发起人的ipid（ipinfo表的id）
	 */
	public java.lang.Integer getFromipid() {
		return getInt("fromipid");
	}

	/**
	 * 发起通话人员的设备类型（DeviceType），1：PC，2：安卓，3：IOS
	 */
	public void setFromdevice(java.lang.Byte fromdevice) {
		set("fromdevice", fromdevice);
	}
	
	/**
	 * 发起通话人员的设备类型（DeviceType），1：PC，2：安卓，3：IOS
	 */
	public java.lang.Byte getFromdevice() {
		return getByte("fromdevice");
	}

	/**
	 * 通话对方的userid
	 */
	public void setTouid(java.lang.Integer touid) {
		set("touid", touid);
	}
	
	/**
	 * 通话对方的userid
	 */
	public java.lang.Integer getTouid() {
		return getInt("touid");
	}

	/**
	 * 通话对方的channelcontextid
	 */
	public void setTocid(java.lang.String tocid) {
		set("tocid", tocid);
	}
	
	/**
	 * 通话对方的channelcontextid
	 */
	public java.lang.String getTocid() {
		return getStr("tocid");
	}

	/**
	 * 通话对方的ipid（ipinfo表的id）
	 */
	public void setToipid(java.lang.Integer toipid) {
		set("toipid", toipid);
	}
	
	/**
	 * 通话对方的ipid（ipinfo表的id）
	 */
	public java.lang.Integer getToipid() {
		return getInt("toipid");
	}

	/**
	 * 通话对方的设备类型（DeviceType），1：PC，2：安卓，3：IOS
	 */
	public void setTodevice(java.lang.Byte todevice) {
		set("todevice", todevice);
	}
	
	/**
	 * 通话对方的设备类型（DeviceType），1：PC，2：安卓，3：IOS
	 */
	public java.lang.Byte getTodevice() {
		return getByte("todevice");
	}

}
