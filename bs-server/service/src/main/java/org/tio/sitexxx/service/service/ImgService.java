/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.service.model.main.Img;
import org.tio.sitexxx.servicecommon.vo.Const;

/**
 * 
 * @author tanyaowu 
 * 2016年12月6日 下午9:03:32
 */
public class ImgService {

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(ImgService.class);

	public static final ImgService me = new ImgService();

	final Img dao = new Img().dao();

	/**
	 * 保存视频
	 * @param video
	 * @return
	 */
	public boolean save(Img img) {
		return img.save();
	}



	/**
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	public boolean updateStatus(int id, byte status) {
		String sql = "update img set status = ? where id = ?";
		Db.use(Const.Db.TIO_SITE_MAIN).update(sql, status, id);
		return true;
	}

}
