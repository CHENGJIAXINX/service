/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.chat;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.model.main.WxApp;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;

import cn.hutool.core.util.StrUtil;

/**
 * 系统服务
 * @author xufei
 * 2020年8月25日 下午5:57:32
 */
public class SysService {
	private static Logger				log	= LoggerFactory.getLogger(SysService.class);
	public static final SysService	me	= new SysService();
	
	/**
	 * 版本信息
	 * @param deviceType
	 * @param version
	 * @return
	 * @author xufei
	 * 2020年9月18日 下午1:35:03
	 */
	public Ret checkVersion(Byte deviceType,String version) {
		if(StrUtil.isBlank(version)) {
			log.error("版本公司异常:版本号为空,设备类型-{}",deviceType);
			return RetUtils.failMsg("版本号为空");
		}
		WxApp sysVersion = WxApp.dao.findFirst(
				"select * from wx_app where type = ? and `status` = ?", deviceType,
				Const.Status.NORMAL);
		Map<String,Object> reslut = new HashMap<>();
		if(sysVersion == null || sysVersion.getVersion().equals(version) || StrUtil.compare(version, sysVersion.getVersion(), false) > 0) {
			reslut.put("updateflag", Const.YesOrNo.NO);
			reslut.put("url","");
			reslut.put("version", version);
			return RetUtils.okData(reslut);
		} else {
			reslut.put("url",sysVersion.getFileurl());
			reslut.put("updateflag", Const.YesOrNo.YES);
			if(Objects.equals(sysVersion.getUpdatemode(), Const.YesOrNo.NO)) {//不是正常更新
				reslut.put("forceflag", Const.YesOrNo.YES);
				reslut.put("version", sysVersion.getVersion());
				reslut.put("content", sysVersion.getName());
				return RetUtils.okData(reslut);
			} else {
				reslut.put("forceflag", Const.YesOrNo.NO);
				reslut.put("version", sysVersion.getVersion());
				reslut.put("content", sysVersion.getName());
				return RetUtils.okData(reslut);
			}
		}
	}
}
