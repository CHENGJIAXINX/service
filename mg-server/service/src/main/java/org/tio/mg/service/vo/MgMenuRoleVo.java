package org.tio.mg.service.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author :linjian
 * @description : 保存菜单的请求对象
 * @createTime :2021/9/10
 * @updateTIme :
 */
public class MgMenuRoleVo implements Serializable {

    private static final long serialVersionUID = 5001160676053642557L;

    private Integer roleId;

    private List<Integer> menuIds;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }
}
