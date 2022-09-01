#sql("list")
SELECT
    *
FROM
    announcement AS a
WHERE
        1 = 1
  #if(searchkey != null && searchkey != "")
  AND concat( a.title, a.author) LIKE #para(searchkey)
  #end
  #if(status != null && status != "")
  AND a.`status` = #para(status)
  #end
  #if(starttime != null && starttime != "")
  AND a.createtime >= #para(starttime)
  #end
  #if(endtime != null && endtime != "")
  AND a.createtime < #para(endtime)
  #end
ORDER BY
    a.`id` DESC
#end
