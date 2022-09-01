/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.conf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.redisson.api.RTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.service.init.RedisInit;
import org.tio.sitexxx.service.model.conf.IpWhiteList;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.topic.TopicVo;
import org.tio.utils.lock.LockUtils;

import cn.hutool.core.util.StrUtil;

/**
 * 
 * @author tanyaowu
 *
 */
public class IpWhiteListService {
	private static Logger					log			= LoggerFactory.getLogger(IpWhiteListService.class);
	public static final IpWhiteListService	me			= new IpWhiteListService();
	final static IpWhiteList				dao			= new IpWhiteList().dao();
	/**
	 * key: name, value: IpWhiteList
	 */
//	private static Map<String, IpWhiteList>	cacheData	= null;
	private static List<IpWhiteList> cacheData = null;

	public boolean save(String ip, String remark) {
		IpWhiteList ipWhiteList = new IpWhiteList();
		ipWhiteList.setIp(ip);
		ipWhiteList.setStatus((byte) 1);
		ipWhiteList.setRemark(remark);
		boolean ret = ipWhiteList.save();

		clearCache();
		RTopic topic = RedisInit.get().getTopic(Const.Topic.COMMON_TOPIC);
		TopicVo topicVo = new TopicVo();
		topicVo.setType(TopicVo.Type.CLEAR_IP_WHITE_LIST);
		topic.publishAsync(topicVo);
		return ret;
	}

	public boolean canLogin(Integer uid, String ip){
		if (cacheData == null){
			return true;
		}
		boolean canLogin = true;
		for (IpWhiteList ipWhiteList : cacheData){
			if (ipWhiteList.getUid().intValue() == uid.intValue()){
				canLogin = false;
				if (ipWhiteList.getIp().equals(ip)){
					return true;
				}
			}
		}
		return canLogin;
	}

	/**
	 * 删除白名单
	 * @param ip
	 * @param remark
	 * @return
	 */
	public int delete(String ip, String remark) {
		int ret = Db.use(Const.Db.TIO_SITE_CONF).update("update ip_white_list set status = ?, remark = ? where ip = ?", 2, remark, ip);

		clearCache();
		RTopic topic = RedisInit.get().getTopic(Const.Topic.COMMON_TOPIC);
		TopicVo topicVo = new TopicVo();
		topicVo.setType(TopicVo.Type.CLEAR_IP_WHITE_LIST);
		topic.publishAsync(topicVo);
		return ret;
	}

	/**
	 * 
	 */
	public static void clearCache() {
		synchronized (IpWhiteListService.class) {
			cacheData = null;
		}
	}

	private static void loadData() throws Exception {
		if (cacheData == null){
			synchronized (IpWhiteListService.class){
				if (cacheData == null) {
					cacheData = dao.find("select * from ip_white_list where status=1");
				}
			}
		}

	}

	/**
	 * 是否是白名单ip
	 * @param ip
	 * @return true: 是白名单ip
	 */
	public static boolean isWhiteIp(String ip) {
		if (StrUtil.isBlank(ip)) {
			return false;
		}

		if (cacheData == null) {
			try {
				loadData();
			} catch (Exception e) {
				log.error("", e);
			}
		}

//		return cacheData.containsKey(ip);
		return true;
	}
}
