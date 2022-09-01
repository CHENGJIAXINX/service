/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo.wx;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import cn.hutool.core.bean.BeanUtil;

/**
 * 同步记录Vo
 * @author xufei
 * 2020年9月8日 下午5:15:57
 */
public class SynRecordVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 841445948608235787L;

	/**
	 * 记录业务类型
	 */
	private Byte				biztype;	
	
	public static interface BizType {
		
		/**
		 * 聊天会话
		 */
		byte CHAT_SESSION = 1;
		
		/**
		 * 聊天会话的消息
		 */
		byte CHAT_SESSION_MSG = 2;
		
		/**
		 * 好友信息
		 */
		byte FRIEND = 3;
		
		/**
		 * 好友申请
		 */
		byte FRIEND_APPLY = 4;
	}
	
	/**
	 * 记录同步类型：1：新增；2：修改；3：删除;4:所有记录
	 */
	private Byte				syntype;
	
	/**
	 * 同步类型
	 * @author xufei
	 * 2020年9月18日 下午1:44:05
	 */
	public static interface SynType {
		
		/**
		 * 新增
		 */
		byte ADD = 1;
		
		/**
		 * 更新
		 */
		byte UPDATE = 2;
		
		/**
		 * 所有记录修改(状态修改)
		 */
		byte ALL_UPDATE = 3;
		
		/**
		 * 删除
		 */
		byte DEL = 4;
		
		/**
		 * 删除所有
		 */
		byte DEL_ALL = 5;
	}
	
	/**
	 * 同步数据
	 */
	private Map<String, Object> bizdata;

	
	/**
	 * @param biztype
	 * @param syntype
	 * @param bizdata
	 */
	public SynRecordVo(Byte biztype,Byte syntype,Map<String, Object> bizdata) {
		this.bizdata = bizdata;
		this.biztype = biztype;
		this.syntype = syntype;
	}
	
	public SynRecordVo(Object bizdata,Byte biztype,Byte syntype) {
		this.bizdata = BeanUtil.beanToMap(bizdata);
		this.biztype = biztype;
		this.syntype = syntype;
	}
	
	/**
	 * 
	 */
	public SynRecordVo() {
		
	}
	
	public Byte getBiztype() {
		return biztype;
	}

	public void setBiztype(Byte biztype) {
		this.biztype = biztype;
	}

	public Byte getSyntype() {
		return syntype;
	}

	public void setSyntype(Byte syntype) {
		this.syntype = syntype;
	}

	public Map<String, Object> getBizdata() {
		return bizdata;
	}

	public void setBizdata(Map<String, Object> bizdata) {
		this.bizdata = bizdata;
	}
	
	/**
	 * @param key
	 * @param value
	 * @author xufei
	 * 2020年9月15日 下午6:03:38
	 */
	public void put(String key,Object value) {
		if(this.bizdata == null) {
			this.bizdata = new HashMap<String, Object>();
		}
		bizdata.put(key, value);
	}
}
