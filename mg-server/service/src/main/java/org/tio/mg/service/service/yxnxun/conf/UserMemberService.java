package org.tio.mg.service.service.yxnxun.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.mg.service.model.conf.YxConf;
import org.tio.mg.service.model.main.UserVipLevel;

import java.util.List;

/**
 * @author :linjian
 * @description :
 * @createTime :2021/10/17
 * @updateTIme :
 */
public class UserMemberService {

    private static Logger log = LoggerFactory.getLogger(UserMemberService.class);

    public static final UserMemberService ME = new UserMemberService();

    private static final UserVipLevel dao = new UserVipLevel().dao();


    /**
     * 修改配置表数据 （1：允许  2： 禁止）
     *
     * @param yxConfList 配置集合
     */
    public void update(List<YxConf> yxConfList) {
        for (int i = 0; i < yxConfList.size(); i++) {
            YxConf yxConf = yxConfList.get(i);
            if ("addFriendEnable".equals(yxConf.getName())) {
                // 普通用户
                UserVipLevel user = dao.findFirst("select * from user_vip_level where vip_level = 0");
                if (user != null) {
                    user.setMaxAddFriend("1".equals(yxConf.getValue()) ? 9999 : 0);
                    user.update();
                }
            } else if ("createGroupEnable".equals(yxConf.getName())) {
                // 普通用户
                UserVipLevel user = dao.findFirst("select * from user_vip_level where vip_level = 0");
                if (user != null) {
                    user.setMaxCreateGroup("1".equals(yxConf.getValue()) ? 9999 : 0);
                    user.update();
                }
            } else if ("memberAddFriendEnable".equals(yxConf.getName())) {
                // 会员用户
                UserVipLevel member = dao.findFirst("select * from user_vip_level where vip_level = 1");
                if (member != null) {
                    member.setMaxAddFriend("1".equals(yxConf.getValue()) ? 9999 : 0);
                    member.update();
                }
            } else if ("memberCreateGroupEnable".equals(yxConf.getName())) {
                // 会员用户
                UserVipLevel member = dao.findFirst("select * from user_vip_level where vip_level = 1");
                if (member != null) {
                    member.setMaxCreateGroup("1".equals(yxConf.getValue()) ? 9999 : 0);
                    member.update();
                }
            }
        }
    }
}
