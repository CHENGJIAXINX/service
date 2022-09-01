-- 后台用户列表
-- 用户列表
#sql("mguserlist")
SELECT
    u.*,
    mub.realname,
    mub.sex,
    mub.phone,
    roletable.rolename,
    roletable.rid
FROM
    mg_user u
        INNER JOIN mg_user_base mub ON u.id = mub.uid
        LEFT JOIN (
        SELECT
            mur.uid,
            mr.`name` AS rolename,
            mr.`id` AS rid
        FROM
            mg_user_role mur
                INNER JOIN mg_role mr ON mur.rid = mr.id
    ) AS roletable ON roletable.uid = u.id
    WHERE
        1 = 1
    #if(status != null && status != "")
	    AND u.`status` = #para(status)
    #end
    #if(searchkey != null && searchkey != "")
	    AND concat( u.`id`,u.loginname,u.nick) LIKE #para(searchkey)
	#end
    #if(rid != null && rid != "")
	    AND rid = #para(rid)
    #end
    ORDER BY
	    u.id DESC
#end


-- 用户角色列表
#sql("userRoles")
	SELECT
		u.id ,
	    roletable.rolename,
	    roletable.rid
	FROM
		mg_user u
	LEFT JOIN (
		SELECT
            mur.uid AS uid,
            mr.`name` AS rolename,
            mr.`id` AS rid
		FROM
			mg_user_role mur
		INNER JOIN mg_role mr ON mur.rid = mr.id
		GROUP BY
			mur.uid
	) AS roletable ON roletable.uid = u.id
	where u.id = #para(mguid)
#end
