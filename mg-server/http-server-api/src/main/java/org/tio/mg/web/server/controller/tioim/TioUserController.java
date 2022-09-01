package org.tio.mg.web.server.controller.tioim;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.init.RedisInit;
import org.tio.mg.service.model.conf.YxConf;
import org.tio.mg.service.model.main.User;
import org.tio.mg.service.model.main.UserInvite;
import org.tio.mg.service.service.base.UserService;
import org.tio.mg.service.service.tioim.TioInviteService;
import org.tio.mg.service.service.tioim.TioUserService;
import org.tio.mg.service.service.yxnxun.conf.AdminConfService;
import org.tio.mg.service.service.yxnxun.other.ImportUsersService;
import org.tio.mg.service.service.yxnxun.other.MgOperLogService;
import org.tio.mg.service.utils.RetUtils;
import org.tio.mg.service.vo.MgConst;
import org.tio.mg.service.vo.RequestVo;
import org.tio.mg.web.server.utils.HttpRequestUtils;
import org.tio.mg.web.server.utils.MgOperRequestUtils;
import org.tio.mg.web.server.utils.WxGroupAvatarUtil;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.topic.TopicVo;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.resp.Resp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 钛信用户管理
 *
 * @author xufei
 * 2020年5月25日 下午4:45:27
 */
@RequestPath(value = "/tiouser")
public class TioUserController {

    private static Logger log = LoggerFactory.getLogger(TioUserController.class);

    private TioUserService userService = TioUserService.me;

    private TioInviteService inviteService = TioInviteService.me;

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
        Ret ret = userService.list(requestVo);
        if (ret.isFail()) {
            log.error("获取用户列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 获取用户信息
     *
     * @param request
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/info")
    public Resp info(HttpRequest request, Integer uid) throws Exception {
        if (uid == null || uid < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = userService.info(uid);
        if (ret.isFail()) {
            log.error("获取用户信息失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 当日同ip注册列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/statList")
    public Resp statList(HttpRequest request) throws Exception {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        Ret ret = userService.statList(requestVo);
        if (ret.isFail()) {
            log.error("获取用户列表失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        return Resp.ok(RetUtils.getOkPage(ret));
    }

    /**
     * 重置密码
     *
     * @param request
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/resetPwd")
    public Resp resetPwd(HttpRequest request, Integer uid) throws Exception {
        if (uid == null || uid < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = userService.resetPwd(uid);
        if (ret.isFail()) {
            log.error("重置密码失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        // 清除用户缓存
        UserService.ME.notifyClearCache(uid);
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "用户密码重置",
                        MgConst.OperLogTypes.rest,
                        "用户密码重置，id为" + uid);
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 改变用户 禁用/启用 状态
     *
     * @param request
     * @param uid
     * @param status
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/disable")
    public Resp disable(HttpRequest request, Integer uid, Byte status) throws Exception {
        Ret ret = userService.disable(uid, status);
        if (ret.isFail()) {
            log.error("禁用/启用失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        // 清除用户缓存
        UserService.ME.notifyClearCache(uid);
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "用户禁用",
                        MgConst.OperLogTypes.disable,
                        "群聊天记录清除，id为" + uid);
            }
        }).start();
        return Resp.ok(RetUtils.getOkData(ret));
    }

    /**
     * 删除聊天记录（单方）
     *
     * @param request
     * @param uid
     * @return
     */
    @RequestPath(value = "/delMsg")
    public Resp delMsgInfo(HttpRequest request, Integer uid) {
        if (uid == null || uid < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = userService.delMsgByUid(uid);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "删除聊天记录（单方）",
                        MgConst.OperLogTypes.del,
                        "删除聊天记录，id为" + uid);
            }
        }).start();
        return Resp.ok("删除成功");
    }

    /**
     * 重置用户支付密码
     *
     * @param request
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/resetPayPwd")
    public Resp resetPayPwd(HttpRequest request, Integer uid) throws Exception {
        if (uid == null || uid < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = userService.resetPayPwd(uid);
        if (ret.isFail()) {
            log.error("重置密码失败：{}", RetUtils.getRetMsg(ret));
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        // 清除用户缓存
        UserService.ME.notifyClearCache(uid);
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "重置支付密码",
                        MgConst.OperLogTypes.rest,
                        "重置支付密码，id为" + uid);
            }
        }).start();
        return Resp.ok(ret);
    }

    /**
     * 开通/关闭会员
     *
     * @param request
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestPath(value = "/updateVipLevel")
    public Resp updateVipLevel(HttpRequest request, Integer uid, Integer vipLevel) throws Exception {
        if (uid == null || uid < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = userService.updateVipLevel(uid, vipLevel);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        // 清除用户缓存
        UserService.ME.notifyClearCache(uid);
        return Resp.ok(ret);
    }

    /**
     * 新增用户
     *
     * @param request
     * @return
     */
    @RequestPath("/addImUser")
    public Resp addImUser(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        if (requestVo == null || StrUtil.isEmpty(requestVo.getNick()) || StrUtil.isEmpty(requestVo.getPd5())) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        // 读取验证方式配置
        YxConf validateType = AdminConfService.ME.findByName("validateType");
        Map<String, Object> paramsMap = new HashMap<>();
        // 邮箱验证
        if ("2".equals(validateType.getValue())) {
            if (StrUtil.isEmpty(requestVo.getEmail())) {
                return Resp.fail(RetUtils.INVALID_PARAMETER);
            }
            paramsMap.put("email", requestVo.getEmail());
            paramsMap.put("loginname", requestVo.getEmail());
        } else {
            // 短信验证 和 不验证
            if (StrUtil.isEmpty(requestVo.getLoginName())) {
                return Resp.fail(RetUtils.INVALID_PARAMETER);
            }
            if (!StrUtil.isEmpty(requestVo.getLoginName())) {
                paramsMap.put("loginname", requestVo.getLoginName());
            }
        }
        if (requestVo.getUid() != null) {
            // 限制 uid 只能输入 8位 2021/11/03 添加
            if (requestVo.getUid() < 10000000 || requestVo.getUid() > 99999999) {
                return Resp.fail("uid必须为8位数字，且0不能开头");
            }
            paramsMap.put("id", requestVo.getUid());
        }
        if (!StrUtil.isEmpty(requestVo.getPd5())) {
            paramsMap.put("pwd", requestVo.getPd5());
        }
        if (!StrUtil.isEmpty(requestVo.getNick())) {
            paramsMap.put("nick", requestVo.getNick());
        }
        if (!StrUtil.isEmpty(requestVo.getAvatar())) {
            paramsMap.put("avatar", requestVo.getAvatar());
        }
        // 万能验证码
        paramsMap.put("code", "ABCDEF");
        // 同意注册协议
        paramsMap.put("agreement", "on");
        // 请求接口
        String url = "http://127.0.0.1:6060/mytio/register/1.tio_x?" + HttpRequestUtils.getInstance().getUrlParams(paramsMap);
        String resultJson = HttpUtil.post(url, paramsMap);
        if (StrUtil.isEmpty(resultJson)) {
            return Resp.fail();
        }
        Resp resp = JSONObject.parseObject(resultJson, Resp.class);
        if (resp.isOk()) {
            return Resp.ok("操作成功");
        }
        return resp;
    }

    /**
     * 新增用户(停用)
     *
     * @param request
     * @return
     */
    @RequestPath("/addUser")
    public Resp addUser(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        if (requestVo == null || StrUtil.isEmpty(requestVo.getLoginName()) || StrUtil.isEmpty(requestVo.getNick()) || StrUtil.isEmpty(requestVo.getPd5())) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        if (requestVo.getUid() != null) {
            if (requestVo.getUid() < 10000000 || requestVo.getUid() > 99999999) {
                return Resp.fail("UID必须为8位纯数字");
            }
            User first = User.dao.findById(requestVo.getUid());
            if (first != null) {
                return Resp.fail("UID已存在");
            }
        }
        // 生成头像
        String avatarPath = null;
        if (StrUtil.isBlank(requestVo.getAvatar())) {
            try {
                avatarPath = WxGroupAvatarUtil.pressUserAvatar(requestVo.getNick());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            avatarPath = requestVo.getAvatar();
        }
        requestVo.setAvatar(avatarPath);
        requestVo.setIp(request.getClientIp());
        Ret ret = ImportUsersService.ME.addUser(requestVo);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                MgOperLogService.me.add(MgOperRequestUtils.getRequestInfo(request), "用户新增",
                        MgConst.OperLogTypes.add,
                        "新增用户，账号为：" + requestVo.getLoginName());
            }
        }).start();
        return Resp.ok();
    }

    /**
     * 删除用户
     *
     * @param request
     * @param id
     * @return
     */
    @RequestPath("/delUser")
    public Resp delUser(HttpRequest request, Integer id) {
        if (id == null || id < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = userService.delUser(id);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        // 清除用户缓存
        UserService.ME.notifyClearCache(id);
        return Resp.ok(RetUtils.getRetMsg(ret));
    }

    /**
     * 根据uid获取邀请用户列表
     *
     * @param request
     * @return
     */
    @RequestPath("/getInviteListByUid")
    public Resp getInviteListByUid(HttpRequest request) {
        RequestVo requestVo = JSONObject.parseObject(request.getBodyString(), RequestVo.class);
        if (requestVo == null || requestVo.getUid() == null || requestVo.getUid() < 0) {
            return Resp.fail(RetUtils.INVALID_PARAMETER);
        }
        Ret ret = inviteService.getPageList(requestVo);
        if (ret.isOk()) {
            return Resp.ok(RetUtils.getOkPage(ret));
        }
        return Resp.fail("获取失败");
    }
}
