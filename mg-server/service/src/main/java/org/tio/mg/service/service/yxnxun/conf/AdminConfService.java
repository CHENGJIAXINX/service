package org.tio.mg.service.service.yxnxun.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Kv;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.jfinal.plugin.activerecord.SqlPara;
import org.tio.mg.service.model.conf.YxConf;
import org.tio.mg.service.service.atom.AbsAtom;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.utils.hutool.StrUtil;

import java.sql.SQLException;
import java.util.List;

public class AdminConfService {

    private static Logger log = LoggerFactory.getLogger(AdminConfService.class);

    public static final AdminConfService ME = new AdminConfService();

    private static final YxConf dao = new YxConf().dao();

    public boolean add(YxConf yxConf){
        return yxConf.save();
    }

    public boolean del(Integer id) {
        return dao.deleteById(id);
    }

    public YxConf findByName(String name) {
        String sql = "select * from yx_conf where name = ?";
        return dao.findFirst(sql, name);
    }

    public List<YxConf> query() {
        List<YxConf> all = dao.findAll();
        return all;
    }

    /**
     * 通过类型查找配置列表
     *
     * @param requestVo
     * @return
     */
    public List<YxConf> queryByType(RequestVo requestVo) {
        if (StrUtil.isBlank(requestVo.getSearchKey())) {
            String sql = "select * from yx_conf where conftype = ? order by sort desc";
            return dao.find(sql, requestVo.getType());
        }
        Kv params = Kv.by("conftype", requestVo.getType());
        if (StrUtil.isNotBlank(requestVo.getSearchKey())) {
            params.set("searchkey", "%" + requestVo.getSearchKey() + "%");
        }
        SqlPara sqlPara = Db.use(MgConst.Db.TIO_MG).getSqlPara("sys.yxconflist", params);
        return dao.find(sqlPara);
    }

    /**
     * 更新多个配置
     * @param yxConfList
     * @return
     */
    public Ret updateAll(List<YxConf> yxConfList) {
        AbsAtom absAtom = new AbsAtom() {
            @Override
            public boolean run() throws SQLException {
                for (int i = 0; i < yxConfList.size(); i++) {
                    String sql = "update yx_conf c set c.value = ? ,c.remark=?,c.title=?,c.sort=? where c.id = ?";
                    int update = Db.use(MgConst.Db.TIO_SITE_CONF).update(sql, yxConfList.get(i).getValue(), yxConfList.get(i).getRemark(),
                            yxConfList.get(i).getTitle(), yxConfList.get(i).getSort(), yxConfList.get(i).getId());
                    if (update < 0) {
                        return failRet("ID为：" + yxConfList.get(i).getId() + "的数据修改失败");
                    }
                }
                return true;
            }
        };

        boolean tx = Db.use(MgConst.Db.TIO_SITE_CONF).tx(absAtom);
        if (tx) {
            return RetUtils.okOper();
        }
        return RetUtils.failMsg(absAtom.getMsg());
    }
}
