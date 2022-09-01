-- 获取充值记录
#sql("getUserRecharge")
	SELECT
		item.userid,item.id,rec.createtime,rec.coin addcoin,item.tradeno,item.amount
	FROM
		recharge_item item
		LEFT JOIN user_coin_item rec ON rec.bizid = item.id and rec.type = #para(rechargetype) 
	WHERE
		item.`status` = #para(status) 
		AND rec.uid = #para(uid)
		#if(begintime != null && begintime != "")
			AND rec.createtime >= #para(begintime)
		#end
		#if(endtime != null && endtime != "")
			AND rec.createtime < #para(endtime)
		#end
#end



