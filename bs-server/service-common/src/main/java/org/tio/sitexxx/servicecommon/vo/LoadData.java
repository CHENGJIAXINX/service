/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 负载数据
 * @author tanyaowu 
 * 2016年10月8日 下午4:39:03
 */
public class LoadData implements java.io.Serializable {
	private static final long	serialVersionUID	= 6605697801713948836L;
	@SuppressWarnings("unused")
	private static Logger		log					= LoggerFactory.getLogger(LoadData.class);

	/**
	 * 
	 * @author: tanyaowu
	 */
	public LoadData() {
	}

	private int	pcCount;
	private int	appCount;
	//	private int iosCount;

	public int getPcCount() {
		return pcCount;
	}

	public void setPcCount(int pcCount) {
		this.pcCount = pcCount;
	}

	public int getAppCount() {
		return appCount;
	}

	public void setAppCount(int appCount) {
		this.appCount = appCount;
	}

	//	public int getIosCount() {
	//		return iosCount;
	//	}
	//
	//	public void setIosCount(int iosCount) {
	//		this.iosCount = iosCount;
	//	}

	//	/**
	//	 * @param args
	//	 * @author: tanyaowu
	//	 */
	//	public static void main(String[] args) {
	//
	//	}

}
