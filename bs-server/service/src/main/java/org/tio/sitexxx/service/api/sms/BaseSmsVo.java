/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.api.sms;

import java.util.Map;

/**
 * 短信请求vo
 * @author xufei
 * 2020年12月18日 下午1:46:28
 */
public class BaseSmsVo {
	
	/**
	 * 短信业务
	 * @author xufei
	 * 2020年12月15日 下午10:16:31
	 */
	public interface BaseSmsBizType {

		/**
		 * 绑定手机
		 */
		byte BIND_PHONE = 1;
		
		/**
		 * 注册验证
		 */
		byte REGISTER = 2;

		/**
		 * 登录验证
		 */
		byte LOGIN = 3;
		
		/**
		 * 修改密码验证
		 */
		byte PWD_UPDATE = 4;
		
		/**
		 * 修改手机验证
		 */
		byte OLD_PHONE_CHECK = 5;
		
		/**
		 * 找回密码
		 */
		byte PWD_BACK = 6;
		
		/**
		 * 绑定新手机
		 */
		byte BIND_NEW_PHONE = 7;
		
		/**
		 * 三方绑定手机
		 */
		byte THIRD_BIND_PHONE = 8;
		
		/**
		 * 手机注册绑定邮箱账号
		 */
		byte PHONE_REG_BIND_EMAIL = 9;
	}
	
	/**
	 * 移动号码
	 */
	private String mobile;
	
	/**
	 * 验证码
	 */
	private String code;
	
	/**
	 * 业务类型
	 */
	private Byte bizType;
	
	/**
	 * 是否新增
	 */
	private boolean codeAdd;
	
	/**
	 * 扩展参数
	 */
	private Map<String, String> extParams;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Byte getBizType() {
		return bizType;
	}

	public void setBizType(Byte bizType) {
		this.bizType = bizType;
	}

	public boolean isCodeAdd() {
		return codeAdd;
	}

	public void setCodeAdd(boolean codeAdd) {
		this.codeAdd = codeAdd;
	}

	public Map<String, String> getExtParams() {
		return extParams;
	}

	public void setExtParams(Map<String, String> extParams) {
		this.extParams = extParams;
	}
	
	/**
	 * 获取code的key值
	 * @return
	 * @author xufei
	 * 2020年12月16日 上午5:20:40
	 */
	public String getCodeCacheKey() {
		return mobile + "_" + bizType;
	}
}
