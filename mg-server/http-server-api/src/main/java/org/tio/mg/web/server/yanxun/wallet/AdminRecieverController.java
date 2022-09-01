package org.tio.mg.web.server.yanxun.wallet;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.model.main.YxAdminRecieverAccount;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.service.yxnxun.wallet.AdminRecieverService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.utils.resp.Resp;

/**
 * 收款人控制器
 */
@RequestPath(value = "/reciever")
public class AdminRecieverController {

    private static Logger log = LoggerFactory.getLogger(AdminRecieverController.class);

    private static AdminRecieverService service = AdminRecieverService.ME;

    /***
     * 查找所有收款账户
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/list")
    public Resp findAll(HttpRequest request) throws Exception {
        Ret ret = service.findAll();
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkList(ret));
    }

    /***
     * 收款账户详情
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/findByid")
    public Resp findById(HttpRequest request) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(request.getBodyString());
        Integer id = -1;
        if (jsonObject != null) {
            id = (Integer) jsonObject.get("id");
        }
        if (id == null || id < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = service.findById(id);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /***
     * 新增收款账户
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/save")
    public Resp save(HttpRequest request) throws Exception {
        YxAdminRecieverAccount yxAdminRecieverAccount = JSONObject.parseObject(request.getBodyString(), YxAdminRecieverAccount.class);
        // 校验参数
        if (yxAdminRecieverAccount == null) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = service.save(yxAdminRecieverAccount);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "新增收款人",
                        MgConst.OperLogTypes.add,
                        "新增收款人" + yxAdminRecieverAccount.getName());
            }
        }).start();
        return Resp.ok(RetUtils.getRetMsg(ret));
    }

    /***
     * 修改收款账户
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath("/update")
    public Resp update(HttpRequest request) throws Exception {
        YxAdminRecieverAccount yxAdminRecieverAccount = JSONObject.parseObject(request.getBodyString(), YxAdminRecieverAccount.class);
        // 校验参数
        if (yxAdminRecieverAccount == null || yxAdminRecieverAccount.getId() < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = service.update(yxAdminRecieverAccount);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "修改收款账户",
                        MgConst.OperLogTypes.update,
                        "修改收款账户" + yxAdminRecieverAccount.getName());
            }
        }).start();
        return Resp.ok(RetUtils.getRetMsg(ret));
    }

    /***
     * 删除收款账户
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/del")
    public Resp del(HttpRequest request) throws Exception {
        YxAdminRecieverAccount yxAdminRecieverAccount = JSONObject.parseObject(request.getBodyString(), YxAdminRecieverAccount.class);
        // 校验参数
        if (yxAdminRecieverAccount == null || yxAdminRecieverAccount.getId() < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Integer id = yxAdminRecieverAccount.getId();
        Ret ret = service.del(id);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "删除收款人",
                        MgConst.OperLogTypes.del,
                        "删除收款人" + id);
            }
        }).start();
        return Resp.ok(RetUtils.getRetMsg(ret));
    }

}
