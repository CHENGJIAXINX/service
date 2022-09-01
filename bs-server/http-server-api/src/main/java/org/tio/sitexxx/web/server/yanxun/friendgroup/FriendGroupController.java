package org.tio.sitexxx.web.server.yanxun.friendgroup;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.plugin.activerecord.Record;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.WxChatUserItem;
import org.tio.sitexxx.service.model.main.WxFriend;
import org.tio.sitexxx.service.model.main.WxFriendGroup;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.chat.ChatIndexService;
import org.tio.sitexxx.service.service.chat.ChatService;
import org.tio.sitexxx.service.service.chat.FriendService;
import org.tio.sitexxx.service.service.yanxun.friendGroup.FriendGroupService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.resp.Resp;

import java.util.*;

/**
* @Description: TODO(好友分组接口)
* @author zhangjianbin
* @date 2021年2月2日
 */

@RequestPath(value="/friendGroup")
public class FriendGroupController {


	private static Logger log = LoggerFactory.getLogger(FriendGroupController.class);

	public static final FriendGroupService groupService = FriendGroupService.me;


	@RequestPath(value = "/test")
	public Resp test(){
		return groupService.delete(5);
	}

	/**
	 * 好友分组列表
	 * @param request
	 * @return
	 */
	@RequestPath(value = "/list")
	public Resp friendGroupList(HttpRequest request) throws Exception {
//		try {
			List<WxFriendGroup> list = groupService.queryGroupList(WebUtils.currUserId(request));
//			List<WxFriendGroup> list = groupService.queryGroupList(10014);
			List<Map<String,Object>> listMap = new ArrayList<>();
			if(list.size()>0){
				for (int j=0; j<list.size();j++) {
					Map<String,Object> itemMap = new HashMap();
					//取出friend数组字符将id逐一切割acc
					WxFriendGroup item =  list.get(j);
					List friendListId = new ArrayList();
					if(!StrUtil.isEmpty(item.getFriendidlist())){
//						String friendIdListStr =item.getFriendidlist().substring(1, item.getFriendidlist().length()-1);
						String[] friendIdLists = item.getFriendidlist().split(",");
						friendListId = Arrays.asList(friendIdLists);
					}

					List friednList = new ArrayList();
					//将数组中的id逐一遍历取出user对象
					for(int i=0;i<friendListId.size();i++){
						Integer userId = Integer.parseInt((String)friendListId.get(i));
						User curr = WebUtils.currUser(request);
						Record record = UserService.ME.info(userId);
						if(curr != null) {
							WxChatUserItem fd = ChatIndexService.fdUserIndex(curr.getId(), userId);
							if(ChatService.existFriend(fd)) {
								WxFriend friend = FriendService.me.getFriendInfo(fd.getLinkid());
								//判断是否为好友
								if(friend != null) {
									Map<String,Object> taskMap = new HashMap();
									taskMap.put("id",friend.getId());
									taskMap.put("nick",record.get("nick"));
									taskMap.put("uid",record.get("id"));
									taskMap.put("chatindex",friend.getChatindex());
									taskMap.put("avatar",record.get("avatar"));
									friednList.add(taskMap);
								}
							}
						}

					}
					itemMap.put("id",item.getId());
					itemMap.put("createtime",item.getCreatetime());
					itemMap.put("friendidlist",friednList);
					itemMap.put("groupname",item.getGroupname());
					itemMap.put("uid",item.getUid());
					listMap.add(itemMap);
				}

			}
			Map<String,Object> map = new HashMap();
			map.put("groupList",listMap);
			return Resp.ok(map);

//		}catch (Exception e){
//			e.printStackTrace();
//			return Resp.fail(RetUtils.SYS_ERROR);
//		}
	}

	/**
	 * 添加分组列表
	 * @param friendGroup
	 * @return
	 */

	@RequestPath(value = "/add")
	public Resp friendGroupAdd(WxFriendGroup friendGroup,HttpRequest request){
		try {
			if(null!=groupService.queryGroupName(WebUtils.currUserId(request),friendGroup.getGroupname())){
				return Resp.fail("分组名称已存在");
			}
			if(friendGroup.getGroupname().isEmpty())
				return Resp.fail("请输入分组名称");
			if(0==friendGroup.getUid())
				friendGroup.setUid(WebUtils.currUserId(request));
			if(groupService.createGroup(friendGroup).isOk()){
				return Resp.ok(RetUtils.OPER_RIGHT);
			}else{
				return Resp.fail(RetUtils.OPER_ERROR);
			}

		}catch (Exception e){
			e.printStackTrace();
			return Resp.fail(RetUtils.SYS_ERROR);
		}
	}

	/**
	 * 更新分组的好友列表
	 * @param groupId
	 * @param userIdListStr
	 * @return
	 */
	@RequestPath(value = "/updateGroupUserList")
	public Resp updateGroupUserList(String groupId,String userIdListStr,HttpRequest request) {
		try{
			if(StringUtils.isEmpty(groupId) || groupId.equals("0"))
				return Resp.fail(RetUtils.INVALID_PARAMETER);
			Resp resp = groupService.updateGroupUserList(WebUtils.currUserId(request),Integer.parseInt(groupId),userIdListStr);
			return resp;
		}catch (Exception e){
			return Resp.fail(RetUtils.SYS_ERROR);
		}
	}

	/**
	 * 更新好友
	 * @param toUserId
	 * @param groupIdStr
	 * @return
	 */
	@RequestPath("/updateFriend")
	public Resp updateFriend(Integer toUserId,String groupIdStr) {
		return null;
	}

	/**
	 * 修改标签名称
	 * @param groupId
	 * @param groupName
	 * @return
	 */
	@RequestPath("/update")
	public Resp friendGroupUpdate( String groupId, String groupName,HttpRequest request) {
		try {
			if(StringUtils.isEmpty(groupId) || groupId.equals("0"))
				return Resp.fail(RetUtils.INVALID_PARAMETER);
			if(StrUtil.isEmpty(groupName))
				return Resp.fail("请输入分组名称");
			if(null!=groupService.queryGroupName(WebUtils.currUserId(request),groupName))
				return Resp.fail(RetUtils.EXIST);
			Resp resp = groupService.updateGroupName(WebUtils.currUserId(request),Integer.parseInt(groupId),groupName);
			return resp;
		}catch(Exception e){
			e.printStackTrace();
			return Resp.fail(RetUtils.SYS_ERROR);
		}
	}

	/**
	 * 删除好友列表
	 * @param groupId
	 * @return
	 */
	@RequestPath("/delete")
	public Resp friendGroupDelete(Integer groupId) {
		try {
			if(groupId==null || groupId==0)
				return Resp.fail(RetUtils.INVALID_PARAMETER);
			Resp resp = groupService.delete(groupId);
			return resp;
		}catch(Exception e){
			e.printStackTrace();
			return Resp.fail(RetUtils.SYS_ERROR);
		}
	}





}
