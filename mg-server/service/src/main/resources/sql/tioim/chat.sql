-- app列表
#sql("list")
	SELECT
		items.id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = #para(uid)
		)
	ORDER BY
		topflag,
		chatuptime desc
#end


#sql("p2pMsg")
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = #para(key)
				AND contenttype != 7
			ORDER BY
				id DESC
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC
#end

-- 清空会话的消息记录-已调整
#sql("clearChatItemMsg")
	update wx_chat_items_meta
	set
		lastmsgid = null,
		lastmsguid = null,
		msgresume = null,
		sendtime = null,
		msgcount = 0,
		sysmsgkey = '',
		chatuptime = now(),
		fromnick = null
	where id = #para(id)
#end

-- 修改索引的起始消息-已调整
#sql("chatuserStartMsg")
	update wx_chat_user_item
	set
		#if(startmsgid != null && startmsgid != "")
			startmsgid =  #para(startmsgid)
		#end
		#if(setnull != null && setnull != "")
			startmsgid = null
		#end
	where uid = #para(uid) and chatmode = #para(chatmode) and bizid = #para(bizid)
#end

-- 群消息
#sql("groupMsg")
	SELECT
		wgm.text as c,
		wgm.contenttype as ct,
		wgm.id as mid,
		wgm.time as t,
		wgm.uid as f,
		wgm.groupid as g,
		wgm.sendbysys,
		wgm.device as d,
		wgm.sysmsgkey,
		wgm.opernick,
		wgm.tonicks,
		sigleuid,
		sigleflag,
		nick,
		avatar,
		whereflag,
		whereuid
	FROM
		wx_group_msg wgm
	WHERE
		groupid = #para(key)
	ORDER BY
		id DESC
#end

-- 好友列表
#sql("friendList")
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
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
		ORDER BY
		 wf.chatindex,wf.id
#end


-- 群列表
#sql("groupList")
	SELECT
		wg.id groupid,
		wg.`name`,
		wg.avatar,
		wg.uid,
		wgm.joinnum
	FROM
		wx_group wg
	INNER JOIN (
		SELECT
			bizid
		FROM
			wx_chat_user_item
		WHERE
			uid = #para(uid)
		AND chatmode = 2
		AND linkflag = 1
	) AS groupindex ON groupindex.bizid = wg.id
	INNER JOIN wx_group_meta wgm ON wg.id = wgm.groupid
	order by wg.id desc
#end

-- 群用户列表
#sql("groupUserlist")
	SELECT
		wgu.id,
		wgu.uid,
		wgu.groupid,
		wgu.grouprole,
		wgu.srcnick,
		wgu.groupnick nick,
		wgu.groupavator avatar
	FROM
		wx_group_user wgu
	INNER JOIN (
		SELECT
			gpulinkid
		FROM
			wx_chat_group_item
		WHERE
			groupid = #para(groupid)
	) AS groupindex ON groupindex.gpulinkid = wgu.id
	ORDER BY
		wgu.grouprole,
		wgu.id
#end

#sql("applylist")
	SELECT
		ai.id,
		fromuid uid,
		greet,
		ai.`status`,
		replytime,
		autoflag,
		nick,
		avatar
	FROM
		wx_friend_apply_items ai
	INNER JOIN `user` u ON u.id = ai.fromuid
	WHERE
		ai.touid = #para(uid)
	ORDER BY
		ai.id DESC
#end