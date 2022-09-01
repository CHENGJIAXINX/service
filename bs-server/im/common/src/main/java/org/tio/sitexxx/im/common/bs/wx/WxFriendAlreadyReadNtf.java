/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 *
 */
package org.tio.sitexxx.im.common.bs.wx;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * @author tanyaowu 
 * 2016年9月12日 下午3:09:08
 */
public class WxFriendAlreadyReadNtf implements Serializable {

	private static final long serialVersionUID = -5146467582178818159L;

	/**
	 * @param uid
	 * @author tanyaowu
	 */
	public WxFriendAlreadyReadNtf(Integer uid, Date readtime) {
		super();
		this.setUid(uid);
		this.readtime = readtime;
	}

	/**
	 * 聊天对方的userid
	 */
	private Integer	uid;
	/**
	 * 阅读时间
	 */
	private Date	readtime;

	public Date getReadtime() {
		return readtime;
	}

	public void setReadtime(Date readtime) {
		this.readtime = readtime;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}
