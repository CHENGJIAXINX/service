package org.tio.mg.web.server.yanxun.other;

import com.alibaba.fastjson.JSONObject;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.RequestVo;
import org.tio.utils.resp.Resp;

/**
 * 操作日志管理控制器
 */
@RequestPath("/operlog")
public class MgOperRecordController {

    /**
     * 操作日志列表
     *
     * @param request
     * @return
     */
    @RequestPath("/query")
    public Resp query(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = MgOperLogService.me.query(requestVo);
        return Resp.ok(RetUtils.getOkPage(ret));
    }
}
