package org.tio.mg.web.server.yanxun.wallet;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.service.yxnxun.wallet.TransAccountService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.TransferVo;
import org.tio.utils.resp.Resp;

/**
 * 转账控制器
 */
@RequestPath("/transAccount")
public class TransAccountsController {

    private Logger log = LoggerFactory.getLogger(TransAccountsController.class);

    private TransAccountService service = TransAccountService.me;


    /**
     * 获取转账列表
     *
     * @param request
     * @return
     */
    @RequestPath("/queryList")
    public Resp getTransAccountList(HttpRequest request) {
        TransferVo transferVo = JSONObject.parseObject(request.getBodyString(), TransferVo.class);
        if (transferVo == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = service.queryList(transferVo);
        if (ret == null) {
            return Resp.ok("暂无数据");
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }
}
