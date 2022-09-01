-- 后台系统脚本
-- 获取角色列表
#sql("rolelist")
SELECT
    mr.*,
    ( SELECT count( 1 ) FROM mg_user_role mur WHERE mur.rid = mr.id ) AS usercount
FROM
    mg_role mr
WHERE
    1 = 1
    #if(status != null && status != "")
        AND `status` = #para(status)
    #end
    ORDER BY sort;
#end

-- 系统参数配置列表
#sql("conflist")
	SELECT
		*
	FROM
		conf
	where
		1 = 1
	#if(type != null && type != "")
		and type = #para(type)
	#end
	#if(searchkey != null && searchkey != "")
		and (name like #para(searchkey) or title like #para(searchkey) )
	#end
	order by name

#end

-- 系统参数配置列表
#sql("yxconflist")
SELECT
    *
FROM
    yx_conf
where
        conftype = #para(conftype)
	#if(searchkey != null && searchkey != "")
		and (name like #para(searchkey) or title like #para(searchkey) )
	#end
order by sort desc
#end
