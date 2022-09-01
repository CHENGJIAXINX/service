/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.all.test;

import org.tio.sitexxx.all.Starter;
import org.tio.sitexxx.service.service.base.SensitiveWordsService;

/**
 * @author tanyaowu
 *
 */
public class SensitiveWordsServiceTest {

	/**
	 * 
	 */
	public SensitiveWordsServiceTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		Starter.initBase();

		String x = "tionet";
		String xx = SensitiveWordsService.findAndReplace(x);
		System.out.println(xx);

	}

}
