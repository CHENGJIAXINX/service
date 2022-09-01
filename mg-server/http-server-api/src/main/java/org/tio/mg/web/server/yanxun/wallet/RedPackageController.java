package org.tio.mg.web.server.yanxun.wallet;

import com.alibaba.fastjson.JSONObject;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.service.yxnxun.wallet.RedPacketService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.DeleteIdVo;
import org.tio.mg.service.vo.RedPacketVo;
import org.tio.utils.resp.Resp;

/**
 * 红包控制器
 */
@RequestPath(value = "/redPackage")
public class RedPackageController {

    private RedPacketService redPacketService = RedPacketService.me;

    @RequestPath("/queryList")
    public Resp query(HttpRequest request) {
        RedPacketVo redPacketVo = JSONObject.parseObject(request.getBodyString(), RedPacketVo.class);
        if (redPacketVo == null) {
            return Resp.ok(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = redPacketService.findList(redPacketVo);
        if (ret == null) {
            return Resp.ok("暂无数据");
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }


    @RequestPath("/detail")
    public Resp detail(HttpRequest request) {
        DeleteIdVo deleteIdVo = JSONObject.parseObject(request.getBodyString(), DeleteIdVo.class);
        if (deleteIdVo == null || deleteIdVo.getId() < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = redPacketService.findDetailsById(deleteIdVo.getId());
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkList(ret));
    }
}
