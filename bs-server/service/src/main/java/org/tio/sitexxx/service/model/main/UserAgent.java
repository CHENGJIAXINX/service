/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.model.main;

import java.util.Objects;

import org.tio.sitexxx.service.model.main.base.BaseUserAgent;
import org.tio.utils.UAUtils;

import nl.basjes.parse.useragent.AgentField;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class UserAgent extends BaseUserAgent<UserAgent> {
	public static final UserAgent dao = new UserAgent().dao();

	private boolean isSyntaxError = false;

	public static UserAgent from(String userAgentStr) {
		nl.basjes.parse.useragent.UserAgent _userAgent = UAUtils.parse(userAgentStr);

		UserAgent userAgent = new UserAgent();

		AgentField syntaxErrorAgentField = _userAgent.get(nl.basjes.parse.useragent.UserAgent.SYNTAX_ERROR);
		if (syntaxErrorAgentField != null) {
			String syntaxError = syntaxErrorAgentField.getValue();
			userAgent.setSyntaxError("true".equalsIgnoreCase(syntaxError));
		}

		userAgent.setUserAgent(userAgentStr);
		userAgent.setAgentName(_userAgent.get(nl.basjes.parse.useragent.UserAgent.AGENT_NAME).getValue());
		userAgent.setAgentVersionMajor(_userAgent.get(nl.basjes.parse.useragent.UserAgent.AGENT_VERSION_MAJOR).getValue());
		userAgent.setOsName(_userAgent.get(nl.basjes.parse.useragent.UserAgent.OPERATING_SYSTEM_NAME).getValue());
		userAgent.setOsVersion(_userAgent.get(nl.basjes.parse.useragent.UserAgent.OPERATING_SYSTEM_VERSION).getValue());
		userAgent.setDeviceClass(_userAgent.get(nl.basjes.parse.useragent.UserAgent.DEVICE_CLASS).getValue());
		userAgent.setIsMobile(UAUtils.isMobile(_userAgent) ? (byte) 1 : (byte) 2);

		return userAgent;
	}

	/**
	 * 是否是移动端的浏览器
	 * @param userAgent
	 * @return
	 * @author tanyaowu
	 */
	public static final boolean isMobile(UserAgent userAgent) {
		return Objects.equals(userAgent.getIsMobile(), (byte) 1);
	}

	public boolean isSyntaxError() {
		return isSyntaxError;
	}

	public void setSyntaxError(boolean isSyntaxError) {
		this.isSyntaxError = isSyntaxError;
	}
}
