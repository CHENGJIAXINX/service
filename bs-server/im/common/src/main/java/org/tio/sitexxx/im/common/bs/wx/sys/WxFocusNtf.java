/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.sitexxx.im.common.bs.wx.sys;


import java.io.Serializable;
import java.util.Map;

/**
 * 焦点变更通知-- Server-->Client
 * @author xufei
 * 2020年8月25日 下午2:56:14
 */
public class WxFocusNtf implements Serializable {
	private static final long serialVersionUID = -2712989373320633810L;
	
	private Long				t = System.currentTimeMillis();				//消息发送时间
	Map<String, Byte>           focusMap;
	public Long getT() {
		return t;
	}
	public void setT(Long t) {
		this.t = t;
	}
	public Map<String, Byte> getFocusMap() {
		return focusMap;
	}
	public void setFocusMap(Map<String, Byte> focusMap) {
		this.focusMap = focusMap;
	}
}
