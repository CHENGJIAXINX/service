/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.sitexxx.im.common.bs.wx.webrtc.base;

import java.io.Serializable;

import org.tio.sitexxx.service.model.main.WxCallItem;

/**
 * @author tanyaowu
 */
public class WxCallBase extends WxCallItem implements Serializable {

	private static final long serialVersionUID = 346711195550637522L;

	/**
	 * 透传填充
	 * @param wxCallItem
	 * @author tanyaowu
	 */
	public void fill(WxCallItem wxCallItem) {
		this._setAttrs(wxCallItem);
	}

	//	public static WxCallItem newIns(WxCallBase wxCallBase) {
	//		WxCallItem wxCallItem = new WxCallItem();
	//		wxCallItem._setAttrs(wxCallBase);
	//		return wxCallItem;
	//	}
	

	/**
	 * 
	 * @param wxCallBase
	 * @return
	 * @author tanyaowu
	 */
	public static boolean save(WxCallBase wxCallBase) {
		WxCallItem wxCallItem = new WxCallItem();
		wxCallItem._setAttrs(wxCallBase);
		boolean f = wxCallItem.save();
		if (f) {
			wxCallBase.setId(wxCallItem.getId());
		}
		return f;
	}


}
