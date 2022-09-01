/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.service.service.base;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.service.model.main.Role;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.servicecommon.vo.Const;

public class RoleService {

	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(RoleService.class);

	public static final RoleService me = new RoleService();

	final Role roleDao = new Role().dao();

	/**
	 * 设置用户的角色信息
	 * @param userid
	 * @return
	 * 
	 */
	public List<Byte> setRoles(User user) {
		List<Role> roles = roleDao.find("select * from role r where EXISTS (select rid from user_role rel where uid = ? and r.id = rel.rid and rel.`status` = ?)", user.getId(),
		        Const.Status.NORMAL);
		List<Byte> roleIds = new ArrayList<>();
		for (Role role : roles) {
			roleIds.add(role.getId());

			//判断是不是后台管理角色
			if (role.getId() >= 100) {
				user.setMg(true);
			}
		}
		user.setRoles(roleIds);
		return roleIds;
	}

	public static void main(String[] args) throws Exception {
	}
}
