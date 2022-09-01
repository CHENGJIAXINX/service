/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service;

import java.util.List;

import org.redisson.connection.ClientConnectionsEntry;
import org.redisson.connection.balancer.RandomLoadBalancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyRandomLoadBalancer extends RandomLoadBalancer {
	private static Logger log = LoggerFactory.getLogger(MyRandomLoadBalancer.class);

	/* 
	 * 
	 * @see org.redisson.connection.balancer.RandomLoadBalancer#getEntry(java.util.List)
	 * 
	 */
	@Override
	public ClientConnectionsEntry getEntry(List<ClientConnectionsEntry> clientsCopy) {
		ClientConnectionsEntry test = super.getEntry(clientsCopy);
		log.info(test.getClient().getAddr().getHostString() + ":" + test.getClient().getAddr().getPort());
		return test;
	}

}
