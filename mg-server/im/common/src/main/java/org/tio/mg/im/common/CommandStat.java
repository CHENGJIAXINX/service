/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.im.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.utils.lock.LockUtils;
import org.tio.utils.lock.ReadWriteLockHandler;

/**
 *
 * @author tanyaowu
 *
 */
public class CommandStat {
	private static Logger							log					= LoggerFactory.getLogger(CommandStat.class);
	public final static Map<Command, CommandStat>	COMMAND_STAT_MAP	= new HashMap<>();

	public static CommandStat getCommandStat(Command command) {
		if (command == null) {
			return null;
		}
		CommandStat ret = COMMAND_STAT_MAP.get(command);
		if (ret != null) {
			return ret;
		}

		try {
			LockUtils.runWriteOrWaitRead(CommandStat.class.getName(), CommandStat.class, new ReadWriteLockHandler() {
				@Override
				public void write() throws Exception {
					CommandStat ret = COMMAND_STAT_MAP.get(command);
					if (ret == null) {
						ret = new CommandStat();
						COMMAND_STAT_MAP.put(command, ret);
					}
				}
			});
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
		ret = COMMAND_STAT_MAP.get(command);

		//		synchronized (COMMAND_STAT_MAP) {
		//			ret = COMMAND_STAT_MAP.get(command);
		//			if (ret != null) {
		//				return ret;
		//			}
		//			ret = new CommandStat();
		//			COMMAND_STAT_MAP.put(command, ret);
		//		}
		return ret;
	}

	/**
	 * @param args
	 *
	 * @author tanyaowu
	 * 2016年12月6日 下午5:32:31
	 *
	 */
	public static void main(String[] args) {
	}

	public final AtomicLong received = new AtomicLong();

	public final AtomicLong handled = new AtomicLong();

	public final AtomicLong sent = new AtomicLong();

	/**
	 *
	 *
	 * @author tanyaowu
	 * 2016年12月6日 下午5:32:31
	 *
	 */
	public CommandStat() {
	}

	/**
	 * @return the handledCount
	 */
	public AtomicLong getHandled() {
		return handled;
	}

	/**
	 * @return the receivedCount
	 */
	public AtomicLong getReceived() {
		return received;
	}

	/**
	 * @return the sentCount
	 */
	public AtomicLong getSent() {
		return sent;
	}

}
