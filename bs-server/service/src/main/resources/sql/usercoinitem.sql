

-- 资产明细
#sql("getUserCoinItem")
	SELECT
		*
	FROM
		user_coin_item
	WHERE
		uid = #para(uid) and coinmode = #para(coinmode) 
		#if(begintime != null && begintime != "")
			AND createtime >= #para(begintime)
		#end
		#if(endtime != null && endtime != "")
			AND createtime <= #para(endtime)
		#end
	order by id desc
#end
