#sql("gettranslist")
    SELECT
        *
    FROM
        yx_trans_accounts trans
    WHERE 1=1
        #if(uid != null && uid != "")
            AND (trans.uid >= #para(uid))
        #end
        #if(status != null && status != "")
            AND (trans.status = #para(status))
        #end
        #if(starttime != null && starttime != "")
            AND (trans.createtime >= #para(starttime))
        #end
        #if(endtime != null && endtime != "")
            AND (trans.createtime <= #para(endtime))
        #end
    ORDER BY trans.createtime
#end

#sql("getstat")
    SELECT
        IFNULL(sum(trans.amount), 0) AS sumAmount
    FROM
        yx_trans_accounts trans
    WHERE
        trans.`status` = 1
    AND
    trans.createtime BETWEEN #para(stime) AND #para(etime);
#end
