/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo.wx;

import java.io.Serializable;

/**
 * 群申请vo
 * 
 * @author xufei 2020年2月10日 下午3:12:31
 */
public class WxGroupApplyVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1283024282068675588L;

	/**
	 * 群id
	 */
	private Long groupid;
	
	/**
	 * 申请人
	 */
	private Integer operuid;
	
	/**
	 * 申请文案
	 */
	private String applymsg;
	
	/**
	 * 申请id
	 */
	private Integer id;
	
	/**
	 * 申请状态
	 */
	private Byte status;

	public Long getGroupid() {
		return groupid;
	}

	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

	public Integer getOperuid() {
		return operuid;
	}

	public void setOperuid(Integer operuid) {
		this.operuid = operuid;
	}

	public String getApplymsg() {
		return applymsg;
	}

	public void setApplymsg(String applymsg) {
		this.applymsg = applymsg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}
}
