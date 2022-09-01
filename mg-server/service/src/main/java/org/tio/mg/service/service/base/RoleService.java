package org.tio.mg.service.service.base;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.mg.service.model.main.Role;
import org.tio.mg.service.model.main.User;
import org.tio.sitexxx.servicecommon.vo.Const;

public class RoleService {

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(RoleService.class);

	public static final RoleService me = new RoleService();

	final Role roleDao = new Role().dao();

	/**
	 * 设置用户的角色信息
	 * @param user
	 * @return
	 */
	public List<Byte> setRoles(User user) {
		List<Role> roles = roleDao.find("select * from role r where EXISTS (select rid from user_role rel where uid = ? and r.id = rel.rid and rel.`status` = ?)", user.getId(),
		        Const.Status.NORMAL);
		List<Byte> roleIds = new ArrayList<>();
		for (Role role : roles) {
			roleIds.add(role.getId());

			//判断是不是后台管理角色
			if (role.getId() >= 100 && role.getId() <= 200) {
				user.setMg(true);
			}
		}
		user.setRoles(roleIds);
		return roleIds;
	}
}
