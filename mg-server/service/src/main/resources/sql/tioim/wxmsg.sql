-- 近期私聊模型消息列表
#sql("modeP2PMsgList")
	SELECT
		msg.*,
	    u.nick,
		u.avatar
	FROM
		(
			SELECT
				id,
				uid,
				touid,
				text c,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
                sendbysys = 2
                AND twouid = #para(fidkey)
				#if(contenttype != null && contenttype != "")
                    AND contenttype in #(contenttype)
				#end
				#if(starttime != null && starttime != "")
					AND createtime >= #para(starttime)
				#end
				#if(endtime != null && endtime != "")
					AND createtime <= #para(endtime)
				#end
			ORDER BY
				id DESC
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		msg.id DESC
#end


-- 近期私聊模型消息列表
#sql("bakModeP2PMsgList")
	SELECT
		msg.*,
	    u.nick,
		u.avatar
	FROM
		(
			SELECT
				id,
				uid,
				touid,
				text c,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg_bak
			WHERE
				twouid = #para(fidkey)
                AND sendbysys = 2
				#if(contenttype != null && contenttype != "")
					AND contenttype in #(contenttype)
				#end
				#if(starttime != null && starttime != "")
					AND createtime >= #para(starttime)
				#end
				#if(endtime != null && endtime != "")
					AND createtime <= #para(endtime)
				#end
			ORDER BY
				id DESC
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		msg.id DESC
#end

-- 群聊天模型下的消息列表
#sql("groupModeMsgList")
	SELECT
		u.avatar,
		u.nick,
		m.uid,
		m.createtime,
		m.id,
		m.text,
		m.contenttype,
		m.sendbysys
	FROM
		wx_group_msg m
	INNER JOIN `user` u ON u.id = m.uid
	WHERE
		m.groupid = #para(groupid)
		AND m.sendbysys = 2
	ORDER BY
		m.id DESC
#end

-- 群聊天模型下的历史消息列表
#sql("bakGroupModeMsgList")
	SELECT
		u.avatar,
		u.nick,
		m.uid,
		m.createtime,
		m.id,
		m.text,
		m.contenttype,
		m.sendbysys
	FROM
		wx_group_msg_bak m
	INNER JOIN `user` u ON u.id = m.uid
	WHERE
		m.groupid = #para(groupid)
		AND m.sendbysys = 2
	ORDER BY
		m.id DESC
#end
