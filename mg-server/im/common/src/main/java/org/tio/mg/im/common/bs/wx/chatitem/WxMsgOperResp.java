/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.common.bs.wx.chatitem;

import java.io.Serializable;

import org.tio.mg.im.common.bs.base.BaseResp;


/**
 * 消息操作--响应-- Server-->Client
 * @author xufei
 * 2020年3月10日 下午3:18:01
 */
public class WxMsgOperResp extends BaseResp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 814549359090799179L;

	@Override
	public void returnData(Object object) {
		setData(object);
	}
}
