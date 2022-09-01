package org.tio.sitexxx.service.service.yanxun.friendGroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.kit.Ret;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.service.model.main.WxFriendGroup;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.resp.Resp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FriendGroupService {

    private static Logger log = LoggerFactory.getLogger(FriendGroupService.class);

    public static final FriendGroupService me = new FriendGroupService();

    private static final WxFriendGroup dao = new WxFriendGroup().dao();

    private static final String TABLE_NAME = "wx_friend_group";


    public List<WxFriendGroup> queryGroupList(Integer userId) {

        return dao.find("select * from " + TABLE_NAME + " t where t.uid = ?",userId);
    }

    /**
     * @param  userId
     * @param  groupName
     * @return WxFriendGroup
     * 查询用户是否存在标签
     */

    public WxFriendGroup queryGroupName(Integer userId,String groupName){
        String sql = "select * from "+TABLE_NAME+" t where t.uid = ? and t.groupname = ?";
        return dao.findFirst(sql,userId,groupName);
    }

    public Ret createGroup(WxFriendGroup friendGroup) throws ParseException {

//        Record record = new Record().set("id",friendGroup.getId()).set("groupname",friendGroup.getGroupname()).
//                set("uid",friendGroup.getUid()).set("createtime",friendGroup.getCreatetime()).set("friendlist",friendGroup.getFriendidlist());
//        Db.use(Const.Db.TIO_SITE_MAIN).save(TABLE_NAME,record);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        friendGroup.setCreatetime(sdf.parse(sdf.format(date)));

        boolean save = friendGroup.save();
        if(save){
            return RetUtils.okOper();
        }
        return RetUtils.failOper();
    }

    public Resp updateGroupUserList(Integer uid, int groupId, String userIdListStr) {
        String sql = "update "+TABLE_NAME+" t set t.friendidlist = ? where id = ?";
        int update = Db.use(Const.Db.TIO_SITE_MAIN).update(sql,userIdListStr,groupId);
        if(update>0) {
            return Resp.ok(RetUtils.OPER_RIGHT);
        }
        return  Resp.fail(RetUtils.OPER_ERROR);
    }

    public Resp updateGroupName(Integer uid, int groupId, String groupName) {
        String sql = "update "+TABLE_NAME+" t set t.groupname = ? where t.uid = ? and t.id = ?";
        int update = Db.use(Const.Db.TIO_SITE_MAIN).update(sql,groupName,uid,groupId);
        if(update>0) {
            return Resp.ok(RetUtils.OPER_RIGHT);
        }
        return  Resp.fail(RetUtils.OPER_ERROR);
    }

    public Resp delete(int id) {
        String sql = "delete from "+TABLE_NAME+" where id = ?";
        int delete = Db.use(Const.Db.TIO_SITE_MAIN).delete(sql,id);
        if(delete>0) {
            return Resp.ok(RetUtils.OPER_RIGHT);
        }
        return  Resp.fail(RetUtils.OPER_ERROR);
    }
}
