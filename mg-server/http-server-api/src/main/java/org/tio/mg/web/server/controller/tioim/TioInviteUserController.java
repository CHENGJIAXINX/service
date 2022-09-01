package org.tio.mg.web.server.controller.tioim;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.model.main.UserInviteAttr;
import org.tio.mg.service.service.base.UserService;
import org.tio.mg.service.service.tioim.TioInviteUserService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.RequestVo;
import org.tio.utils.resp.Resp;


@RequestPath(value = "/tioinviteuser")
public class TioInviteUserController {

    private static Logger log = LoggerFactory.getLogger(TioInviteUserController.class);

    private TioInviteUserService inviteUserService = TioInviteUserService.me;

    /**
     * 获取用户列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/list")
    public Resp list(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = inviteUserService.list(requestVo);
        if (ret.isFail()) {
            log.error("获取用户列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 新增推荐人
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/add")
    public Resp add(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        if (null == requestVo.getUid() || requestVo.getUid() < 0 || null == requestVo.getInviteCode()) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = inviteUserService.add(requestVo);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        // 清除用户缓存
        UserService.ME.notifyClearCache(requestVo.getUid());
        return Resp.ok(ret);
    }

    /**
     * 更新信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/update")
    public Resp update(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        if (null == requestVo.getUid() || requestVo.getUid() < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = inviteUserService.updateInfo(requestVo);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        // 清除用户缓存
        UserService.ME.notifyClearCache(requestVo.getUid());
        return Resp.ok(ret);
    }

    /**
     * 解绑推荐用户
     *
     * @param request
     * @param id
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/unbind")
    public Resp unbind(HttpRequest request, Integer id) throws Exception {
        if (null == id || id < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        UserInviteAttr userInviteAttr = UserInviteAttr.dao.findById(id);
        if (userInviteAttr == null) {
            return Resp.fail("推荐用户信息未找到");
        }
        Ret ret = inviteUserService.unbind(userInviteAttr);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        // 清除用户缓存
        UserService.ME.notifyClearCache(userInviteAttr.getUid());
        return Resp.ok(ret);
    }
}
