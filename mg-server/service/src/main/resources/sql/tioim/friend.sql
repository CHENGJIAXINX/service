-- 统计下的好友列表
#sql("recordList")
SELECT
    m.*,
    u.nick,
    u.avatar,
    tu.nick tonick,
    tu.avatar toavatar
FROM
    wx_friend_meta m
        INNER JOIN (
        SELECT
            twouid,
            max( id ) maxid
        FROM
            wx_friend_msg
        WHERE
                1 = 1
          #if(starttime != null && starttime != "")
            AND createtime >= #para(starttime)
          #end
          #if(endtime != null && endtime != "")
            AND createtime <= #para(endtime)
          #end
        GROUP BY
            twouid
    ) AS fdstat ON fdstat.twouid = m.fidkey
        INNER JOIN `user` u ON u.id = m.uid
        INNER JOIN `user` tu ON tu.id = m.touid
WHERE
        1 = 1
        #if(searchkey != null && searchkey != "")
            AND concat( tu.nick, u.nick ) LIKE #para(searchkey)
            OR concat( m.uid, m.touid ) LIKE #para(searchid)
        #end
ORDER BY
    fdstat.maxid DESC
#end

-- 统计下的备份好友列表
#sql("bakRecordList")
	SELECT
		m.*, u.nick,
		u.avatar,
		tu.nick tonick,
		tu.avatar toavatar
	FROM
		wx_friend_meta m
	INNER JOIN (
		SELECT
			twouid,
			max(id) maxid
		FROM
			wx_friend_msg_bak
		WHERE
				1 = 1
			#if(starttime != null && starttime != "")
				AND createtime >= #para(starttime)
			#end
			#if(endtime != null && endtime != "")
				AND createtime <= #para(endtime)
			#end
		GROUP BY
			twouid
	) AS fdstat ON fdstat.twouid = m.fidkey
	INNER JOIN `user` u ON u.id = m.uid
	INNER JOIN `user` tu ON tu.id = m.touid
	WHERE
		1 = 1
		#if(searchkey != null && searchkey != "")
			 and (tu.nick like #para(searchkey) or u.nick like #para(searchkey) or m.uid = #para(searchid) or m.touid= #para(searchid))
		#end
	ORDER BY
		fdstat.maxid DESC
#end
