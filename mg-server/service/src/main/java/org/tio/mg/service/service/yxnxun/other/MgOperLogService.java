package org.tio.mg.service.service.yxnxun.other;

import cn.hutool.core.util.StrUtil;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Page;
import org.tio.mg.service.model.mg.MgOperRecord;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.RequestVo;

public class MgOperLogService {
    private static final MgOperRecord dao = new MgOperRecord().dao();
    public static final MgOperLogService me = new MgOperLogService();

    /**
     * 查询操作日志列表
     *
     * @param requestVo
     * @return
     */
    public Ret query(RequestVo requestVo) {
        if (requestVo.getPageNumber() == null || requestVo.getPageNumber() < 1) {
            requestVo.setPageNumber(1);
        }
        if (requestVo.getPageSize() == null || requestVo.getPageSize() < 1) {
            requestVo.setPageSize(15);
        }
        StringBuffer sql = new StringBuffer();
        sql.append("select * from mg_oper_record where 1 = 1");
        if (requestVo.getUid() != null) {
            sql.append(" and uid=").append(requestVo.getUid());
        }
        if (requestVo.getType() != null) {
            sql.append(" and opertype=").append(requestVo.getType());
        }
        if (!StrUtil.isEmpty(requestVo.getStartTime())) {
            sql.append(" and createtime>=").append(requestVo.getStartTime());
        }
        if (!StrUtil.isEmpty(requestVo.getEndTime())) {
            sql.append(" and createtime<=").append(requestVo.getEndTime());
        }
        Page<MgOperRecord> paginate = dao.paginate(requestVo.getPageNumber(), requestVo.getPageSize(), sql.toString(), " order by createtime desc");
        return RetUtils.okPage(paginate);
    }

    public void add(MgOperVo operVo, String modename, Byte type, String content) {
        MgOperRecord record = new MgOperRecord();
        record.setModename(modename);
        record.setOpertype(type);
        record.setContent(content);
        record.setOperip(operVo.getIp());
        record.setUid(operVo.getUid());
        record.setUsername(operVo.getUsername());
//        record.setDeviceinfo(operVo.getDeviceinfo());
        record.setOperparam(operVo.getParam());
        record.save();
    }
}
