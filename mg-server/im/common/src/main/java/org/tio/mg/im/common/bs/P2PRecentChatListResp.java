/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.common.bs;

import java.io.Serializable;
import java.util.List;

import org.tio.jfinal.plugin.activerecord.Record;


/**
 * 查询未读私聊消息数响应
 * @author tanyaowu 
 * 2016年9月8日 下午2:10:00
 */
public class P2PRecentChatListResp implements Serializable {
	private static final long serialVersionUID = 7799598518276654167L;
	
	private List<Record> list;

	public List<Record> getList() {
		return list;
	}

	public void setList(List<Record> list) {
		this.list = list;
	}
}
