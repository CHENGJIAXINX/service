#sql("list")
    SELECT
        t.id,
        t.uid,
        t.amount,
        t.amountall,
        t.bizid,
        t.biznumber,
        t.createtime,
        t.coinflag,
        t.mode,
        t.remark
    FROM
        yx_user_wallet_item t
    WHERE
        t.uid = #para(uid)
        #if(stime != null && stime != "")
           AND(t.createtime >= #para(stime))
        #end
        #if(etime != null && etime != "")
           AND(t.createtime >= #para(etime))
        #end
        #if(mode != null && mode != "")
           AND(t.mode = #para(mode))
        #end
        #if(coinflag != null && coinflag != "")
           AND(t.coinflag = #para(coinflag))
        #end
    order by t.createtime desc
#end