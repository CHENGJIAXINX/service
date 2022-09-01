
# //红包列表
#sql("redList")
SELECT
	send.id,
	send.senduid,
	send.sendnick,
	send.money,
	send.`mode`,
	send.num,
	send.remainnum,
	send.remainmoney,
	send.toid,
	send.chatlinkid,
	send.remark,
	send.`status`,
	send.createtime
FROM
	yx_user_send_red_packet send
WHERE 1=1
    #if(uid != null && uid != "")
		AND (send.uid >= #para(uid))
	#end
    #if(status != null && status != "")
        AND (send.status = #para(status))
    #end
    #if(starttime != null && starttime != "")
        AND (send.createtime >= #para(starttime))
    #end
    #if(endtime != null && endtime != "")
        AND (send.createtime <= #para(endtime))
    #end
    ORDER BY send.createtime
#end

# //红包详情
#sql("redDetails")
select
    *
from
    yx_user_reciever_red_packet_item item
where
    item.redid = #para(id)
#end

# //未领取金额统计
#sql("getstat")
   SELECT
        IFNULL(sum(red.remainmoney),0) AS remainmoney
    FROM
        yx_user_send_red_packet red
    WHERE
        red.`status`= 2
        AND
        red.createtime BETWEEN #para(stime) AND #para(etime);
#end
