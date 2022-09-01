/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.mg.service.service.base;

import java.io.Serializable;

/**
 * @author tanyaowu
 *
 */
public class EmailSendService {

	public static final EmailSendService me = new EmailSendService();

	/**
	 * 
	 */
	public EmailSendService() {
	}

	public static class EmailSendVo implements Serializable {
		/**
		 * 
		 */
		private static final long	serialVersionUID	= 361963493750205411L;
		String						emailServer, fromEmail, emailPass, toEmail, title, content;

		public EmailSendVo(String emailServer, String fromEmail, String emailPass, String toEmail, String title, String content) {
			super();
			this.emailServer = emailServer;
			this.fromEmail = fromEmail;
			this.emailPass = emailPass;
			this.toEmail = toEmail;
			this.title = title;
			this.content = content;
		}

	}

}
