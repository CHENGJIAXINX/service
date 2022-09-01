-- 聊天服务专用
-- 聊天列表-已调整
#sql("list")
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
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
	LIMIT 0,#para(limit)
#end


-- 基础会话-已调整
#sql("baseInfo")
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = #para(id)
#end

-- 会话详情-已调整
#sql("info")
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		meta.id chatlinkmetaid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 fidkey,
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
		 sendtime,
		 items.createtime,
		 items.updatetime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id = #para(id)
#end


-- 群更新会话显示-已调整
#sql("updateChatGroupview")
	UPDATE wx_chat_items_meta items
	INNER JOIN (
		SELECT
			chatlinkmetaid
		FROM
			wx_chat_group_item
		WHERE
			groupid = #para(groupid)
			and chatlinkid is not null
	) indextable ON items.id = indextable.chatlinkmetaid
	SET items.viewflag = #para(viewflag)
#end

-- 获取会话的隐藏列表-已调整
#sql("getHideGroupItems")
	select * from wx_chat_items_meta items
	INNER JOIN (
		SELECT
			chatlinkmetaid
		FROM
			wx_chat_group_item
		WHERE
			groupid = #para(groupid)
			and chatlinkid is not null
	) indextable ON items.id = indextable.chatlinkmetaid
	where items.viewflag = #para(viewflag)
#end
-----------------------------------------------调整-结束----------------------------------------------------

-- 初始化黑名单信息-已调整
#sql("blackInit")
	INSERT IGNORE INTO wx_user_black_items (
		uid,
		touid
	)
	VALUES
		(
			#para(uid),
			#para(touid)
		);
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

-- 获取黑名单信息-已调整
#sql("blockitems")
	select * from wx_user_black_items where uid = #para(uid) and touid = #para(touid)
#end

-- 群更新人数-已调整
#sql("chatItemUpdateJoinNum")
	INSERT INTO wx_chat_items (
		id,
		uid,
		chatmode,
		bizid,
		linkid,
		bizrole,
		linkflag
	)
	SELECT
		chatlinkid id,
		uid,
		2 chatmode,
		groupid bizid,
		gpulinkid linkid,
		grouprole bizrole,
		linkflag
	FROM
		wx_chat_group_item
	WHERE
		groupid = #para(groupid)
		and linkflag = #para(linkflag)
		and chatlinkid is not null
	ON DUPLICATE KEY 
	UPDATE 
	 	joinnum = joinnum + #para(joinnum)
#end

-- 群更新头像和名称-已调整
#sql("chatItemUpdateInfo")
	INSERT INTO wx_chat_items (
		id,
		uid,
		chatmode,
		bizid,
		linkid,
		bizrole,
		linkflag
	)
	SELECT
		chatlinkid id,
		uid,
		2 chatmode,
		groupid bizid,
		gpulinkid linkid,
		grouprole bizrole,
		linkflag
	FROM
		wx_chat_group_item
	WHERE
		groupid = #para(groupid)
		and linkflag = #para(linkflag)
		and chatlinkid is not null
	ON DUPLICATE KEY
	UPDATE 
		#if(name != null && name != "")
			name = #para(name)
		#end
	 	#if(avatar != null && avatar != "")
			avatar = #para(avatar)
		#end
#end

-- 群更新链接-已调整
#sql("chatItemUpdateActLinK")
	INSERT INTO wx_chat_items (
		id,
		uid,
		chatmode,
		bizid,
		linkid,
		bizrole,
		linkflag
	)
	SELECT
		chatlinkid id,
		uid,
		2 chatmode,
		groupid bizid,
		gpulinkid linkid,
		grouprole bizrole,
		linkflag
	FROM
		wx_chat_group_item
	WHERE
		groupid = #para(groupid)
		and chatlinkid is not null
	ON DUPLICATE KEY
	UPDATE 
	 	linkflag = #para(linkflag)
#end