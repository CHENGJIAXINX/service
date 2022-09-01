# 充值列表
#sql("rechargelist")
SELECT
    recharge.id,
    recharge.uid,
    recharge.unick,
    recharge.paytype,
    recharge.ext1,
    recharge.serial,
    recharge.amount,
    recharge.`status`,
    recharge.createtime
FROM
    `yx_user_recharge` AS recharge
    WHERE
        1 = 1
        #if(starttime != null && starttime != "")
			AND (recharge.createtime >= #para(starttime))
		#end
        #if(endtime != null && endtime != "")
            AND (recharge.createtime <= #para(endtime))
        #end
        #if(status != null && status != "")
            AND (recharge.status = #para(status))
        #end
        #if(uid != null && uid != "")
            AND (recharge.uid = #para(uid))
        #end
        #if(nick != null && nick != "")
            AND (recharge.unick >= #para(nick))
        #end
        #if(orderno != null && orderno != "")
            AND (recharge.serial >= #para(orderno))
        #end
        #if(paytype != null && paytype != "")
            AND (recharge.paytype >= #para(paytype))
        #end
    ORDER BY recharge.id ASC
#end

#sql("getstat")
SELECT
    IFNULL(sum(recharge.amount),0) as sumRecharge
FROM
    yx_user_recharge recharge
WHERE
    recharge.createtime BETWEEN #para(starttime) AND #para(endtime)
#end
