/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.im.common;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.intf.Packet;
import org.tio.sitexxx.im.common.bs.base.Base;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.json.Json;
import org.tio.utils.lock.LockUtils;
import org.tio.websocket.common.Opcode;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;

/**
 *
 * @author tanyaowu
 *
 */
public class ImPacket extends Packet {
	private static final long	serialVersionUID	= 4910397844111262804L;
	private static Logger		log					= LoggerFactory.getLogger(ImPacket.class);

	/**
	 * 心跳字节
	 */
	public static final byte HEARTBEAT_BYTE = -128;

	/**
	 * 握手字节
	 */
	public static final byte HANDSHAKE_BYTE = -127;

	/**
	 * 协议版本号
	 */
	public final static byte VERSION = 1;

	public final static byte[] BYTES_X = new byte[2];

	static {
		ByteBuffer byteBuffer = ByteBuffer.allocate(2);
		byteBuffer.putChar('x');
		byteBuffer.flip();
		byteBuffer.get(BYTES_X);

	}

	@Override
	public String toString() {
		return "ImPacket [bodyStr=" + bodyStr + ", command=" + command + "]";
	}

	/**
	 * 消息体最多为多少
	 */
	public static final int MAX_LENGTH_OF_BODY = (int) (1024 * 1024 * 2.1); //只支持多少个字节的数据

	/**
	 * 消息头最少为多少个字节
	 */
	public static final int LEAST_HEADER_LENGTH = 5;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//		"x".getBytes("utf-8");

		String str = String.format("%05d", (byte) 1);
		System.out.println("" + str);
	}

	private byte[] body;

	/**
	 * 根据byte[] body生成的字符串
	 */
	private String bodyStr;

	/**
	 * 
	 */
	private Object bodyObj;

	private Command command = null;

	public ImPacket() {
	}

	public ImPacket(Command command) {
		this();
		this.setCommand(command);
	}

	public ImPacket(Command command, byte[] body) {
		this(command);
		this.body = body;
	}

	public ImPacket(Command command, Object bodyObj) {
		this(command);
		this.bodyObj = bodyObj;
	}

	public ImPacket(Command command, String bodyStr) {
		this(command);
		this.bodyStr = bodyStr;
	}

	/**
	 * @return the body
	 */
	public byte[] getBody() {
		return body;
	}

	/**
	 * @return the bodyStr
	 */
	public String getBodyStr() {
		return bodyStr;
	}

	public Command getCommand() {
		return command;
	}

	/**
	 * 本对象转换成WsResponseExt后的对象
	 */
	private WsResponseExt wsPacket = null;

	public WsResponseExt toWs() {
		if (wsPacket != null) {
			return wsPacket;
		}

		try {
			LockUtils.runWriteOrWaitRead(this.hashCode() + "", this, () -> {
				if (wsPacket != null) {
					return;
				}
				short commandValue = command.getValue();

				String commandStr = String.format("%05d", commandValue);
				String text = commandStr;
				if (StrUtil.isNotBlank(bodyStr)) {
					text += bodyStr;
				} else if (bodyObj != null) {
					text += Json.toJson(bodyObj);
				}

				WsResponseExt wsResponse = new WsResponseExt();
				boolean isZipped = false;
				try {
					byte[] bodyBytes = text.getBytes(Const.CHARSET);
					if (bodyBytes.length > ImConst.SIZE_FOR_COMPRESS) {
						try {
							byte[] gzipedbody = ZipUtil.gzip(bodyBytes);
							if (gzipedbody.length < bodyBytes.length) {
								log.info("{}, 压缩前:{}, 压缩后:{}", command, bodyBytes.length, gzipedbody.length);
								bodyBytes = gzipedbody;
								isZipped = true;

								wsResponse.setBodys(new byte[][] { BYTES_X, bodyBytes });
								wsResponse.setBody(null);
							}
						} catch (Throwable e) {
							log.error(e.getMessage(), e);
						}
					}

					if (!isZipped) {
						wsResponse.setBody(bodyBytes);
					}

				} catch (UnsupportedEncodingException e) {
					log.error("", e);
				}
				//			wsResponse.setWsOpcode(Opcode.TEXT);
				wsResponse.setWsOpcode(Opcode.BINARY);
				wsResponse.setInitPacket(this);

				wsPacket = wsResponse;

			});
		} catch (Exception e) {
			log.error("", e);
		}
		return wsPacket;

	}

	/**
	 * @see org.tio.core.intf.Packet#logstr()
	 *
	 * @return
	 * @author tanyaowu
	 * 2016年2月22日 下午3:15:18
	 *
	 */
	@Override
	public String logstr() {
		if (this.command != null) {
			return "impacket: command【" + this.command.name() + "】";
		}
		return null;

	}

	/**
	 * @param body the body to set
	 */
	public void setBody(byte[] body) {
		this.body = body;
	}

	/**
	 * @param bodyStr the bodyStr to set
	 */
	public void setBodyStr(String bodyStr) {
		this.bodyStr = bodyStr;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	/**
	 * @return the bodyObj
	 */
	public Object getBodyObj() {
		return bodyObj;
	}

	/**
	 * @param bodyObj the bodyObj to set
	 */
	public void setBodyObj(Base bodyObj) {
		this.bodyObj = (Base) bodyObj;
	}
}
