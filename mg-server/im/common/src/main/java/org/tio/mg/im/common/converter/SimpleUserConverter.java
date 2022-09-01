/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.mg.im.common.converter;

import org.tio.core.ChannelContext;
import org.tio.mg.im.common.utils.ImUtils;
import org.tio.mg.service.vo.SimpleUser;
import org.tio.utils.convert.Converter;

/**
 * @author tanyaowu
 *
 */
public class SimpleUserConverter implements Converter<SimpleUser> {

	public static final SimpleUserConverter me = new SimpleUserConverter();

	public static final SimpleUserConverter supper = new SimpleUserConverter(true);

	@SuppressWarnings("unused")
	private boolean isSuper = false;

	/**
	 * 
	 */
	private SimpleUserConverter() {

	}

	private SimpleUserConverter(boolean isSuper) {
		this.isSuper = isSuper;
	}


	@Override
	public SimpleUser convert(Object value) {
		ChannelContext channelContext = (ChannelContext) value;
		SimpleUser handshakeSimpleUser = ImUtils.getHandshakeSimpleUser(channelContext);
		//		User user = ImUtils.getUser(channelContext);
		//		if (user == null && handshakeSimpleUser.getI() != null) {
		//			if (!channelContext.isVirtual) {
		//				handshakeSimpleUser.setIsLogout(true);
		//			}
		//		}
		//		simpleUser.setCid(channelContext.getId());

		// 检查可能的用户
		//		if (handshakeSimpleUser.getI() == null && isSuper) {
		//			ImSessionContext imSessionContext = ImUtils.getImSessionContext(channelContext);
		//			SimpleUser lastSimpleUser = imSessionContext.getLastLoginSimpleUser();
		//			if (lastSimpleUser != null) {
		////				lastSimpleUser.setGroupid(handshakeSimpleUser.getGroupid());
		//				handshakeSimpleUser = lastSimpleUser;
		//			}
		//		}

		return handshakeSimpleUser;
	}

}
