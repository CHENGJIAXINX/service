/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.main.User;
import org.tio.mg.service.model.main.Video;
import org.tio.mg.service.service.base.UserService;
import org.tio.sitexxx.servicecommon.vo.Const;

/**
 * 
 * @author tanyaowu 
 * 2016年12月6日 下午9:03:27
 */
public class VideoService {

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(VideoService.class);

	public static final VideoService me = new VideoService();

	final Video dao = new Video().dao();

	/**
	 * 保存视频
	 * @param video
	 * @return
	 */
	public boolean save(Video video) {
		return video.save();
	}
	
	
	public Page<Record> page(User curr, int pageNumber, int pageSize, Integer start, Byte status) {
		if (start == null) {
			start = Integer.MAX_VALUE;
		}
		Kv kv = Kv.by("start", start);
		if (UserService.isSuper(curr)) {
			if (status != null && !Objects.equals((byte)9, status)) {    // 9表示查看所有(不包括隐藏的)
				kv.set("status", status);
			}
		} else {
			kv.set("status", 2);
		}
		SqlPara sqlPara = dao.getSqlPara("video.page", kv);
		Page<Record> ret = Db.paginate(pageNumber, pageSize, sqlPara);
		UserService.completeUser(ret, "uid");
		return ret;
	}
	
	public boolean updateStatus(int id, byte status) {
		String sql = "update video set status = ? where id = ?";
		Db.use(Const.Db.TIO_SITE_MAIN).update(sql, status, id);
		return true;
	}
	
	/**
	 * 重置视频title
	 * @param id
	 * @param title
	 * @return
	 * @author xufei
	 */
	public boolean reTitle(int id, String  title) {
		String sql = "update video set title = ? where id = ?";
		Db.use(Const.Db.TIO_SITE_MAIN).update(sql, title, id);
		return true;
	}

}
