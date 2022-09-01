-- app列表
#sql("list")
	SELECT
		*
	FROM
		wx_app
	where
	 	1 = 1
	#if(version != null && version != "")
		and version like #para(version) 
	#end
	#if(updatemode != null && updatemode != "")
		and updatemode = #para(updatemode) 
	#end
	#if(type != null && type != "")
		and type = #para(type) 
	#end
	#if(status != null && status != "")
		and status = #para(status) 
	#end
	order by id desc
#end