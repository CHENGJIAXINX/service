-- 同步服务专用
-- 聊天列表
#sql("synchatlist")
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
  	 and (meta.updatetime >= #para(syntime) or items.updatetime >= #para(syntime))
#end

-- 删除会话列表
#sql("syndelchatlist")
	SELECT
		IF (chatmode = 2 ,- bizid, chatlinkid) chatlinkid,uid
	FROM
		wx_chat_del_item
	WHERE
		uid = #para(uid)
	AND updatetime >= #para(syntime)
#end