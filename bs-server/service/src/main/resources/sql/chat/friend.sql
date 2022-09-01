--新版好友数据库脚本
-- 查询我的好友
#sql("myFriends")
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = #para(uid)
		AND chatmode = #para(chatmode)
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = #para(userstatus)
	
	#if(nick != null && nick != "")
		WHERE
			wf.remarkname like #para(nick) or u.nick like #para(nick) or wf.frienduid = #para(fuid)
	#end
		ORDER BY
		 wf.chatindex,wf.id
#end


-- 查询群的其他可以邀请成员
#sql("getOutGroupFd")
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = #para(uid)
			AND linkflag = #para(linkflag)
		AND chatmode = #para(chatmode)
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = #para(userstatus)
	where 
		not EXISTS (SELECT
				uid
			FROM
				wx_chat_group_item
			WHERE
				groupid = #para(groupid) and uid = wf.frienduid
				AND linkflag = #para(linkflag)
			)
		#if(nick != null && nick != "")
			and (wf.remarkname like #para(nick) or u.nick like #para(nick))
		#end
		ORDER BY
			 wf.chatindex,wf.id
#end
-----------------------------------------------调整-结束----------------------------------------------------



