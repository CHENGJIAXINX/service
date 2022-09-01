/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.atom;

import java.sql.SQLException;

/**
 * 提供非事务提交，使用场景:
 * 	1、上层已开启事务
 * 	2、其他业务开启事务
 * @author xufei
 * 2020年1月6日 下午2:57:41
 */
public abstract class AbsTxAtom extends AbsAtom {

	@Override
	public boolean run() throws SQLException {
		return noTxRun();
	}

	/**
	 * 不开启事务执行
	 * @return
	 * @throws SQLException
	 * @author xufei
	 * 2020年1月6日 下午2:57:11
	 */
	abstract public boolean noTxRun();
	
}
