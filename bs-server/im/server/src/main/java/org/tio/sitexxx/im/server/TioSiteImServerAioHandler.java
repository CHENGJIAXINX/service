/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.server;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.TioConfig;
import org.tio.core.exception.TioDecodeException;
import org.tio.core.intf.Packet;
import org.tio.core.utils.ByteBufferUtils;
import org.tio.server.intf.ServerAioHandler;
import org.tio.sitexxx.im.common.Command;
import org.tio.sitexxx.im.common.ImConst;
import org.tio.sitexxx.im.common.ImPacket;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.json.Json;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;

/**
 *
 * @author tanyaowu
 *
 */
public class TioSiteImServerAioHandler implements ServerAioHandler {
	private static Logger log = LoggerFactory.getLogger(TioSiteImServerAioHandler.class);

	private PacketDispatcher packetDispatcher;

	/**
	 * 
	 * @param packetDispatcher
	 */
	public TioSiteImServerAioHandler(PacketDispatcher packetDispatcher) {
		this.setPacketDispatcher(packetDispatcher);
	}

	@Override
	public ImPacket decode(ByteBuffer buffer, int limit, int position, int readableLength, ChannelContext channelContext) throws TioDecodeException {
		int headerLength = ImPacket.LEAST_HEADER_LENGTH;
		if (readableLength < headerLength) {
			return null;
		}

		int bodyLength = ByteBufferUtils.readShort(buffer);
		if (bodyLength > ImPacket.MAX_LENGTH_OF_BODY || bodyLength < 0) {
			throw new TioDecodeException("bodyLength [" + bodyLength + "] is not right, remote:" + channelContext.getClientNode());
		}
		int neededLength = headerLength + bodyLength;
		if (readableLength < neededLength) // 不够消息体长度(剩下的buffe组不了消息体)
		{
			channelContext.setPacketNeededLength(neededLength);
			return null;
		}

		short commandValue = ByteBufferUtils.readShort(buffer);
		Command command = Command.from(commandValue);
		if (command == null) {
			throw new TioDecodeException("消息命令码【" + commandValue + "】不正确");
		}

		byte gzip = ByteBufferUtils.read(buffer);
		ImPacket imPacket = new ImPacket();
		imPacket.setCommand(command);

		if (bodyLength > 0) {
			byte[] dst = new byte[bodyLength];
			buffer.get(dst);
			boolean isGzipped = gzip == (byte) 1;
			if (isGzipped) {
				try {
					byte[] unGzippedBytes = ZipUtil.unGzip(dst);
					imPacket.setBody(unGzippedBytes);
				} catch (Throwable e) {
					log.error("{}, 解压失败, bodyLength:{}, buffer:{}", channelContext, bodyLength, buffer);
					throw new TioDecodeException(e);
				}
			} else {
				imPacket.setBody(dst);
			}

			try {
				imPacket.setBodyStr(new String(imPacket.getBody(), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				log.error("", e);
			}
		}
		return imPacket;
	}

	@Override
	public ByteBuffer encode(Packet packet, TioConfig tioConfig, ChannelContext channelContext) {
		ImPacket imPacket = (ImPacket) packet;

		byte[] body = imPacket.getBody();
		if (body == null) {
			String bodyStr = imPacket.getBodyStr();
			if (StrUtil.isBlank(bodyStr)) {
				Object bodyObj = imPacket.getBodyObj();
				if (bodyObj != null) {
					bodyStr = Json.toJson(bodyObj);
				}
			}

			if (StrUtil.isNotBlank(bodyStr)) {
				try {
					body = bodyStr.getBytes(Const.CHARSET);
				} catch (UnsupportedEncodingException e) {
					log.error("", e);
				}
			}
		}

		int bodyLen = 0;
		boolean isCompress = false;
		if (body != null) {
			bodyLen = body.length;
			if (bodyLen > ImConst.SIZE_FOR_COMPRESS) {
				try {
					byte[] gzipedbody = ZipUtil.gzip(body);
					if (gzipedbody.length < body.length) {
						log.info("压缩前:{}, 压缩后:{}", body.length, gzipedbody.length);
						body = gzipedbody;
						bodyLen = gzipedbody.length;
						isCompress = true;
					}
				} catch (Throwable e) {
					log.error(e.getMessage(), e);
				}
			}
		}

		int allLen = ImPacket.LEAST_HEADER_LENGTH + bodyLen;

		ByteBuffer buffer = ByteBuffer.allocate(allLen);
		buffer.order(tioConfig.getByteOrder());

		buffer.putShort((short) bodyLen);
		buffer.putShort(imPacket.getCommand().getValue());
		if (isCompress) {
			buffer.put((byte) 1);
		} else {
			buffer.put((byte) 0);
		}

		if (body != null) {
			buffer.put(body);
		}
		return buffer;
	}

	@Override
	public void handler(Packet packet, ChannelContext channelContext) throws Exception {
		ImPacket imPacket = (ImPacket) packet;
		packetDispatcher.dispatch(imPacket, channelContext, false);
	}

	/**
	 * @return the packetDispatcher
	 */
	public PacketDispatcher getPacketDispatcher() {
		return packetDispatcher;
	}

	/**
	 * @param packetDispatcher the packetDispatcher to set
	 */
	public void setPacketDispatcher(PacketDispatcher packetDispatcher) {
		this.packetDispatcher = packetDispatcher;
	}

}
