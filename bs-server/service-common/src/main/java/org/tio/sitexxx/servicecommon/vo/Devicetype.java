/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo;

import java.util.Objects;

/**
 * 设备类型, pc, android, ios
 * @author tanyaowu 
 * 2016年11月1日 下午3:01:43
 */
public enum Devicetype {

	/**
	 * WS
	 */
	PC((byte) 1),

	/**
	 * 安卓
	 */
	ANDROID((byte) 2),

	/**
	 * IOS
	 */
	IOS((byte) 3),
	/**
	 * H5
	 */
	H5((byte) 4),
	
	/**
	 * APP，安卓或IOS都是APP
	 */
	APP((byte) 5),
	
	
	/**
	 * 系统任务自动发送类型
	 */
	SYS_TASK((byte) 99);

	public static Devicetype from(Byte value) {
		Devicetype[] values = Devicetype.values();
		for (Devicetype v : values) {
			if (Objects.equals(v.value, value)) {
				return v;
			}
		}
		return null;
	}

	Byte value;

	private Devicetype(Byte value) {
		this.value = value;
	}

	public Byte getValue() {
		return value;
	}

	public void setValue(Byte value) {
		this.value = value;
	}
}
