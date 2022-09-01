-- 用户列表
#sql("list")
	SELECT
		u.id,
	    u.loginname,
		u.nick,
		u.avatar,
        u.email,
        u.phone,
	    u.invitecode,
	    u.viplevel,
		u.createtime,
		u.`status`,
		ub.sign,
		ub.sex,
		ub.validphone,
		ub.validemail,
		ri.ip,
		ri.province,
		ri.city,
		ll.createtime lastlogintime,
        ui.invite_code,
        IFNULL(wallet.amount, "未开户" ) AS wallet,
        ( SELECT count( ci.id ) FROM wx_call_item ci WHERE u.id = ci.fromuid ) AS callCount,
        IFNULL((
            SELECT
                sum( TIMESTAMPDIFF( SECOND, ci.calltime, ci.endtime ) )
            FROM
                wx_call_item ci
            WHERE
                u.id = ci.fromuid
                ),
            0
        ) AS `second` ,
        ( SELECT ( count( id )) FROM wx_friend WHERE uid = u.id ) AS friendCount,
        ( SELECT ( count( id )) FROM wx_group WHERE uid = u.id ) AS joinGroupCount,
        ( SELECT ( count( id )) FROM user_invite WHERE invite_uid = u.id ) AS inviteCount,
        (SELECT (count( id )) FROM wx_group_user WHERE uid = u.id AND ( grouprole = 2 OR grouprole = 3 )) AS createGroupCount
	FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
		#if(status != null && status != "")
			 AND u.`status` = #para(status)
		#end
		#if(searchkey != null && searchkey != "")
			AND concat(u.loginname,u.nick) LIKE #para(searchkey)
			OR u.phone = #para(searchid)
			OR u.id = #para(searchid)
		#end
	ORDER BY u.createtime DESC
#end


#sql("ipwhite")
    SELECT
        us.id as uid,
        white.id as id,
        us.loginname,
        us.nick,
        us.avatar,
        us.email,
        us.phone,
        white.ip
    FROM tio_site_main.`user`  us
    JOIN tio_site_conf.ip_white_list white on white.uid=us.id
    WHERE 1=1
    #if(uid!=null && uid!="")
        AND us.id=#para(uid)
    #end
    #if(ip!=null && ip!="")
        AND white.ip=#para(ip)
    #end
#end

-- 用户信息
#sql("info")
	SELECT
		u.id,
		#if(email != null && email != "")
			u.phone loginname,
		#end
		#if(noemail != null && noemail != "")
			'******' loginname,
		#end
		u.nick,
		u.avatar,
		#if(email != null && email != "")
			u.email,
			u.phone,
		#end
		#if(noemail != null && noemail != "")
			'******' email,
			'******' phone,
		#end
        u.invitecode,
		u.createtime,
		u.`status`,
		ub.sign,
		ub.sex,
		ub.validphone,
		ub.validemail,
		ri.ip,
		ri.province,
		ri.city,
		ll.createtime lastlogintime,
		friend.count fcount,
		grouptable.count gcount,
		allgroup.count agcount,
		fromcall.count fcallcount,
		fromcall.callduration fduration,
		tocall.callduration toduration,
		tocall.count tcallcount
	FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN (
		SELECT
			uid,
			count(1) count
		FROM
			wx_friend
		WHERE
			 uid = #para(uid) and `status` = 1
	) AS friend ON friend.uid = u.id
	LEFT JOIN (
		SELECT
			uid,
			count(1) count
		FROM
			wx_group
		WHERE
			uid = #para(uid) and `status` = 1
	) AS grouptable ON grouptable.uid = u.id
	LEFT JOIN (
		SELECT
			uid,
			count(1) count
		FROM
			wx_group_user
		WHERE
			uid = #para(uid) and `status` = 1
	) AS allgroup ON allgroup.uid = u.id
	LEFT JOIN (
		SELECT
			fromuid uid,
			count(1) count,
			callduration
		FROM
			wx_call_item
		WHERE
			fromuid = #para(uid) and callduration > 0
	) AS fromcall ON fromcall.uid = u.id
	LEFT JOIN (
		SELECT
			touid uid,
			count(1) count,
			callduration
		FROM
			wx_call_item
		WHERE
			touid = #para(uid) and  callduration > 0
	) AS tocall ON tocall.uid = u.id
	where
		u.id = #para(uid)
#end

-- 统计用户列表
#sql("statlist")
	SELECT
		u.id,
		#if(email != null && email != "")
			u.phone loginname,
		#end
		#if(noemail != null && noemail != "")
			'******' loginname,
		#end
		u.nick,
		u.avatar,
		#if(email != null && email != "")
			u.email,
			u.phone,
		#end
		#if(noemail != null && noemail != "")
			'******' email,
			'******' phone,
		#end
		u.createtime,
		u.`status`,
		ub.sign,
		ub.sex,
		ub.validphone,
		ub.validemail,
		ri.ip,
		ri.province,
		ri.city,
		friend.count fcount,
		allgroup.count agcount,
		ll.createtime lastlogintime
	FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN (
		SELECT
			uid,
			count(1) count
		FROM
			wx_friend
		WHERE
			`status` = 1
		GROUP BY
			uid
	) AS friend ON friend.uid = u.id
	LEFT JOIN (
		SELECT
			uid,
			count(1) count
		FROM
			wx_group_user
		WHERE
			`status` = 1
		GROUP BY
			uid
	) AS allgroup ON allgroup.uid = u.id
	where
		 u.createtime >= #para(starttime)
		 and u.createtime <= #para(endtime)
		#if(ipid != null && ipid != "")
		  	and u.ipid = #para(ipid)
		#end
	order by u.id desc
#end

#sql("usercount")
SELECT
		count(1)
		FROM `user` AS u
		WHERE 1 = 1
		#if(starttime != null && starttime != "")
		  	AND u.createtime >= #para(starttime)
        #end
		#if(endtime != null && endtime != "")
		  	AND u.createtime <= #para(endtime)
        #end
ORDER BY u.createtime DESC
#end
