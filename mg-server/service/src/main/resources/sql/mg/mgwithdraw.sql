-- 充值列表
#sql("withdrawlist")
SELECT
    withdraw.id,
    withdraw.uid,
    withdraw.unick,
    withdraw.walletid,
    withdraw.amountacount,
    withdraw.amountcommission,
    withdraw.serial,
    withdraw.`status`,
    withdraw.amountreal,
    withdraw.withdrawremark,
    withdraw.createtime,
    withdraw.ext1,
    withdraw.withdrawacountid as withdrawacountid,
    account.accounttype,
    account.accountname,
    account.accountno
FROM
    `yx_user_withdraw` AS withdraw
LEFT JOIN `yx_user_withdraw_account` AS account ON withdraw.withdrawacountid = account.id
    WHERE
        1 = 1
        #if(starttime != null && starttime != "")
			AND (withdraw.createtime >= #para(starttime))
		#end
        #if(endtime != null && endtime != "")
            AND (withdraw.createtime <= #para(endtime))
        #end
        #if(status != null && status != "")
            AND (withdraw.status = #para(status))
        #end
        #if(uid != null && uid != "")
            AND (withdraw.uid = #para(uid))
        #end
        #if(nick != null && nick != "")
            AND (withdraw.unick >= #para(nick))
        #end
        #if(orderno != null && orderno != "")
            AND (withdraw.serial >= #para(orderno))
        #end
        #if(paytype != null && paytype != "")
            AND (recharge.paytype >= #para(paytype))
        #end
    ORDER BY withdraw.id ASC
#end

#sql("getstat")
SELECT
    IFNULL(sum(withdraw.amountreal),0) as sumWithdraw,
    IFNULL(sum(withdraw.amountcommission),0) as sumCharge
FROM
    yx_user_withdraw withdraw
WHERE
    withdraw.createtime BETWEEN #para(stime) AND #para(etime)
#end
