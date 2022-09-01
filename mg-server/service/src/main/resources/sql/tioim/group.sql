-- 群消息统计下的群模型列表
#sql("recordList")
	SELECT
		g.id,
		g.avatar,
		g.`name`,
		guser.id uid,
		#if(email != null && email != "")
			guser.loginname loginname,
		#end
		#if(noemail != null && noemail != "")
			'******' loginname,
		#end
		guser.nick usernick,
		guser.avatar useravatar,
		m.updatetime,
		m.joinnum
	FROM
		wx_group g
	INNER JOIN (
		SELECT
			groupid,
			max(id) maxid,
			count(1)
		FROM
			wx_group_msg
		where 1 = 1
		#if(starttime != null && starttime != "")
			 and createtime >= #para(starttime)
		#end
		#if(endtime != null && endtime != "")
			 and createtime <= #para(endtime)
		#end
		GROUP BY
			groupid
	) AS gstat ON gstat.groupid = g.id
	INNER JOIN wx_group_meta m ON m.groupid = g.id
	INNER JOIN `user` guser ON guser.id = g.uid
	where
			1 = 1
		#if(groupkey != null && groupkey != "")
			 and (g.id = #para(gid)  or g.`name` like #para(groupkey))
		#end
	ORDER BY
		gstat.maxid DESC
#end

-- 群消息统计下的群模型列表-备份
#sql("bakRecordList")
	SELECT
		g.id,
		g.avatar,
		g.`name`,
		guser.id uid,
		#if(email != null && email != "")
			guser.loginname loginname,
		#end
		#if(noemail != null && noemail != "")
			'******' loginname,
		#end
		guser.nick usernick,
		guser.avatar useravatar,
		m.updatetime,
		m.joinnum
	FROM
		wx_group g
	INNER JOIN (
		SELECT
			groupid,
			max(id) maxid,
			count(1)
		FROM
			wx_group_msg_bak
		where 1 = 1
		#if(starttime != null && starttime != "")
			 and createtime >= #para(starttime)
		#end
		#if(endtime != null && endtime != "")
			 and createtime <= #para(endtime)
		#end
		GROUP BY
			groupid
	) AS gstat ON gstat.groupid = g.id
	INNER JOIN wx_group_meta m ON m.groupid = g.id
	INNER JOIN `user` guser ON guser.id = g.uid
	where
			1 = 1
		#if(groupkey != null && groupkey != "")
			 and (g.id = #para(gid)  or g.`name` like #para(groupkey))
		#end
	ORDER BY
		gstat.maxid DESC
#end


-- 群消息统计下的群模型列表-备份
#sql("delBakRecordList")
	SELECT
		g.id,
		g.avatar,
		g.`name`,
		guser.id uid,
		#if(email != null && email != "")
			guser.loginname loginname,
		#end
		#if(noemail != null && noemail != "")
			'******' loginname,
		#end
		guser.nick usernick,
		guser.avatar useravatar,
		m.updatetime,
		m.joinnum
	FROM
		wx_group_bak g
	INNER JOIN (
		SELECT
			groupid,
			max(id) maxid,
			count(1)
		FROM
			wx_group_msg_bak
		where 1 = 1
		#if(starttime != null && starttime != "")
			 and createtime >= #para(starttime)
		#end
		#if(endtime != null && endtime != "")
			 and createtime <= #para(endtime)
		#end
		GROUP BY
			groupid
	) AS gstat ON gstat.groupid = g.id
	INNER JOIN wx_group_meta m ON m.groupid = g.id
	INNER JOIN `user` guser ON guser.id = g.uid
	where
			1 = 1
		#if(groupkey != null && groupkey != "")
			 and (g.id = #para(gid)  or g.`name` like #para(groupkey))
		#end
	ORDER BY
		gstat.maxid DESC
#end


-- 有效群查询
#sql("grouplist")
	SELECT
		g.id,
		g.`name`,
		g.avatar,
		g.intro,
		g.notice,
		g.noticetime,
		g.createtime,
		g.applyflag,
		g.joinmode,
		guser.id uid,
		#if(email != null && email != "")
			guser.loginname loginname,
		#end
		#if(noemail != null && noemail != "")
			'******' loginname,
		#end
		guser.nick usernick,
		guser.avatar useravatar,
		CASE
	WHEN msg.count IS NULL THEN
		0
	ELSE
		msg.count
	END msgcount,
	 manager.mcount,
	 manager.count gusercount
	FROM
		wx_group g
	INNER JOIN `user` guser ON guser.id = g.uid
	LEFT JOIN (
		SELECT
			groupid,
			count(1) count
		FROM
			wx_group_msg
		GROUP BY
			groupid
	) AS msg ON msg.groupid = g.id
	LEFT JOIN (
		SELECT
			groupid,
			sum(grouprole = #(managerrole)) mcount,
			count(1) count
		FROM
			wx_group_user
		GROUP BY
			groupid
	) AS manager ON manager.groupid = g.id
	where
		 	 g.createtime >= #para(starttime)
		 	AND g.createtime <= #para(endtime)
		#if(searchkey != null && searchkey != "")
			 and (guser.loginname like #para(searchkey) or guser.nick like #para(searchkey))
		#end
		#if(groupkey != null && groupkey != "")
			 and (g.id = #para(gid)  or g.`name` like #para(groupkey))
		#end
	ORDER BY
		g.id DESC
#end


-- 无效群查询
#sql("delgrouplist")
	SELECT
		g.id,
		g.`name`,
		g.avatar,
		g.intro,
		g.notice,
		g.noticetime,
		g.createtime,
		g.updatetime,
		g.applyflag,
		g.joinmode,
		guser.id uid,
		#if(email != null && email != "")
			guser.loginname loginname,
		#end
		#if(noemail != null && noemail != "")
			'******' loginname,
		#end
		guser.nick usernick,
		guser.avatar useravatar,
		CASE
			WHEN
				msg.count IS NULL THEN 0
			ELSE
				msg.count
		END msgcount,
		CASE
			WHEN manager.mcount IS NULL THEN
				0
			ELSE
				manager.mcount
		END mcount,

		CASE
			WHEN manager.count IS NULL THEN
				0
			ELSE
				manager.count
		END gusercount,
		CASE
			WHEN bakmsg.count IS NULL THEN
				0
			ELSE
				bakmsg.count
		END bakmsgcount,

		CASE
			WHEN bakmanager.mcount IS NULL THEN
				0
			ELSE
				bakmanager.mcount
		END bakmcount,

		CASE
			WHEN bakmanager.count IS NULL THEN
				0
			ELSE
				bakmanager.count
		END bakgusercount

	FROM
		wx_group_bak g
	INNER JOIN `user` guser ON guser.id = g.uid
	LEFT JOIN (
		SELECT
			groupid,
			count(1) count
		FROM
			wx_group_msg_bak
		GROUP BY
			groupid
	) AS bakmsg ON bakmsg.groupid = g.id
	LEFT JOIN (
			SELECT
				groupid,
				count(1) count
			FROM
				wx_group_msg
			GROUP BY
				groupid
		) AS msg ON msg.groupid = g.id
	LEFT JOIN (
		SELECT
			groupid,
			sum(grouprole = #(managerrole)) mcount,
			count(1) count
		FROM
			wx_group_user_bak
		GROUP BY
			groupid
	) AS bakmanager ON bakmanager.groupid = g.id
	LEFT JOIN (
			SELECT
				groupid,
				sum(grouprole = #(managerrole)) mcount,
				count(1) count
			FROM
				wx_group_user
			GROUP BY
				groupid
		) AS manager ON manager.groupid = g.id
	where
			 g.createtime >= #para(starttime)
		 	AND g.createtime <= #para(endtime)
		#if(searchkey != null && searchkey != "")
			 and (guser.loginname like #para(searchkey) or guser.nick like #para(searchkey))
		#end
		#if(groupkey != null && groupkey != "")
			 and (g.id = #para(gid)  or g.`name` like #para(groupkey))
		#end
	ORDER BY
		g.id DESC
#end
