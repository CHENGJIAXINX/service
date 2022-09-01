package org.tio.mg.service.service.conf;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.conf.Announcement;
import org.tio.mg.service.service.atom.AbsAtom;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.sitexxx.servicecommon.vo.Const;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author :linjian
 * @description : 通知公告
 * @createTime :2021/9/26
 * @updateTIme :
 */
public class NoticeService {

    public static final NoticeService me = new NoticeService();

    final static Announcement announcementDao = new Announcement().dao();

    /**
     * 停用公告
     *
     * @param id
     * @return
     */
    public Ret stop(Integer id) {
        Announcement announcement = announcementDao.findById(id);
        if (announcement == null) {
            return RetUtils.failMsg(RetUtils.NOT_EXIST);
        }
        // 停用将状态改为已发布
        announcement.setStatus(Const.Status.DELETE);
        // 设置停用时间
        announcement.setStoptime(new Date());
        boolean update = announcement.update();
        if (!update) {
            return RetUtils.failOper();
        }
        return RetUtils.okOper();
    }

    /**
     * 修改发布状态
     *
     * @return
     */
    public Ret updateStatus(Integer id) {
        Announcement announcement = announcementDao.findById(id);
        if (announcement == null) {
            return RetUtils.failMsg(RetUtils.NOT_EXIST);
        }
        // 开启事务
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {

                // 1.查找所有正在显示的状态记录
                List<Announcement> announcements = announcementDao.find("select `id` from announcement where status = 2;");
                for (int i = 0; i < announcements.size(); i++) {
                    Announcement announcement = announcements.get(i);
                    // 2.设置状态为已发布
                    announcement.setStatus(Const.Status.DELETE);
                    boolean update = announcement.update();
                    if (!update) {
                        return failRet("修改已发布状态时失败");
                    }
                }
                // 3.标记状态为显示中
                announcement.setStatus(Const.Status.DISABLED);
                // 设置发布时间
                announcement.setPublishtime(new Date());
                boolean update = announcement.update();
                if (!update) {
                    return failRet("修改正在发布状态时失败");
                }
                return true;
            }
        };
        boolean tx = Db.use(MgConst.Db.TIO_SITE_CONF).tx(absAtom);
        if (!tx) {
            return absAtom.getRetObj();
        }
        return Ret.ok();
    }

    public Announcement getById(Integer id) {
        return announcementDao.findById(id);
    }

    public Ret add(Announcement announcement) {
        // 设置md5验证码
        announcement.setMd5(SecureUtil.md5(new Date().toString()));
        announcement.setCreatetime(new Date());
        announcement.setUpdatetime(new Date());
        // 添加状态为待发布
        announcement.setStatus(Const.Status.NORMAL);
        boolean save = announcement.save();
        if (!save) {
            return RetUtils.failOper();
        }
        return RetUtils.okOper();
    }

    public Ret del(Integer id) {
        boolean del = announcementDao.deleteById(id);
        if (!del) {
            return RetUtils.failOper();
        }
        return RetUtils.okOper();
    }

    public Ret update(Announcement announcement) {
        Announcement updateAnn = announcementDao.findById(announcement.getId());
        if (updateAnn == null) {
            return RetUtils.failMsg("记录不存在");
        }
        // 更新md5值
        announcement.setMd5(SecureUtil.md5(new Date().toString()));
        announcement.setUpdatetime(new Date());
        // 更新保存，将状态设为未发布
        announcement.setStatus(Const.Status.NORMAL);
        if (announcement.update()) {
            return Ret.ok();
        }
        return Ret.fail();
    }

    public Ret list(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        Kv params = Kv.create();
        if (StrUtil.isNotBlank(requestVo.getSearchKey())) {
            params.set("searchkey", "%" + requestVo.getSearchKey() + "%");
        }
        if (requestVo.getStatus() != null) {
            params.set("status", requestVo.getStatus());
        }
        if (StrUtil.isNotBlank(requestVo.getStartTime())) {
            params.set("starttime", requestVo.getStartTime());
        }
        if (StrUtil.isNotBlank(requestVo.getEndTime())) {
            params.set("endtime", requestVo.getEndTime());
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_SITE_CONF).getSqlPara("notice.list", params);
        Page<Record> userPage = Db.use(MgConst.Db.TIO_SITE_CONF).paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sqlPara);
        return RetUtils.okPage(userPage);
    }
}
