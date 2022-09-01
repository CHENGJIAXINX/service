package org.tio.mg.service.service.yxnxun.wallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.mg.service.model.main.YxAdminRecieverAccount;
import org.tio.mg.service.utils.RetUtils;
import org.tio.utils.hutool.StrUtil;

import java.util.List;

public class AdminRecieverService {

    private static Logger log = LoggerFactory.getLogger(AdminRecieverService.class);

    private static YxAdminRecieverAccount dao = new YxAdminRecieverAccount().dao();

    public static final AdminRecieverService ME = new AdminRecieverService();

    private static final String TABLE_NAME = "yx_user_recharge";

    public Ret findAll() {
        List<YxAdminRecieverAccount> all = dao.findAll();
        return RetUtils.okList(all);
    }

    public Ret findById(Integer id) {
        YxAdminRecieverAccount byId = dao.findById(id);
        if (byId == null) {
            return RetUtils.failMsg("未查询到收款人信息");
        }
        return RetUtils.okData(byId);
    }

    public Ret update(YxAdminRecieverAccount bean) {
        Ret check = check(bean);
        if (check.isFail()) {
            return check;
        }
        boolean update = bean.update();
        if (!update) {
            return RetUtils.failMsg("修改失败");
        }
        return RetUtils.okMsg("修改成功");
    }


    public Ret save(YxAdminRecieverAccount bean) {
        Ret check = check(bean);
        if (check.isFail()) {
            return check;
        }
        boolean save = bean.save();
        if (!save) {
            return RetUtils.failMsg("添加失败");
        }
        return RetUtils.okMsg("添加成功");
    }

    public Ret del(Integer id) {
        if (id == null) {
            return RetUtils.failMsg("id不可为空");
        }
        boolean b = dao.deleteById(id);
        if (!b) {
            return RetUtils.failMsg("删除失败");
        }
        return RetUtils.okMsg("删除成功");
    }


    public Ret check(YxAdminRecieverAccount bean) {
        if (StrUtil.isBlank(bean.getUrl())) {
            return RetUtils.failMsg("请填写二维码地址");
        }
        if (bean.getType() == null) {
            return RetUtils.failMsg("请填写收款方式");
        }
        if (StrUtil.isBlank(bean.getName())) {
            return RetUtils.failMsg("请填写账户名称");
        }
        if (bean.getStatus() == null) {
            return RetUtils.failMsg("请输入合法状态");
        }
        return RetUtils.okOper();
    }
}
