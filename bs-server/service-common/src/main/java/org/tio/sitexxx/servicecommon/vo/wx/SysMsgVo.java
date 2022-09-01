/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo.wx;

import java.io.Serializable;

/**
 * 系统消息vo
 * 
 * @author xufei 2020年2月10日 下午3:12:31
 */
public class SysMsgVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9054873871350615650L;

	public SysMsgVo(String opernick,String msgbody,String tonicks,String key) {
		this.opernick = opernick;
		this.msgbody = msgbody;
		this.tonicks = tonicks;
		this.msgkey = key;
	}
	
	/**
	 * 操作昵称
	 */
	private String opernick;

	/**
	 * 消息体
	 */
	private String msgbody;
	
	/**
	 * 消息key
	 */
	private String msgkey;
	
	/**
	 * 操作者转义字符
	 */
	public static String OPERESCAPE = "%%%";
	
	/**
	 * 接收者转义字符
	 */
	public static String TOESCAPE = "###";
	
	/**
	 * 接收者的分割符
	 */
	public static char splitchar = '、'; 
	
	/**
	 * 被操作者
	 */
	private String tonicks;
	
	
	
	public String getOpernick() {
		return opernick;
	}



	public void setOpernick(String opernick) {
		this.opernick = opernick;
	}

	public String getMsgbody() {
		return msgbody;
	}

	public void setMsgbody(String msgbody) {
		this.msgbody = msgbody;
	}
	
	public String getTonicks() {
		return tonicks;
	}

	public void setTonicks(String tonicks) {
		this.tonicks = tonicks;
	}
	
	public String toText() {
		return msgbody.replaceAll(TOESCAPE, "\"" + tonicks  + "\"").replaceAll(OPERESCAPE, "\"" + opernick + "\"");
	}
	
	public String getToEscape() {
		return TOESCAPE;
	}
	
	public String getOperEscape() {
		return OPERESCAPE;
	}
	
	public char getSplitchar() {
		return splitchar;
	}
	
	public String getMsgkey() {
		return msgkey;
	}

	public void setMsgkey(String msgkey) {
		this.msgkey = msgkey;
	}



	/**
	 * @param args
	 * @author xufei 2020年2月10日 下午3:12:59
	 */
	public static void main(String[] args) {

	}
}
