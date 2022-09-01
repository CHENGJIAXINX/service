#sql("tree")
SELECT
    a.*,
    CASE
        WHEN p.`name` IS NULL THEN
            '-' ELSE p.`name`
        END parentName
FROM
    mg_menu a
        LEFT JOIN mg_menu p ON a.parent_id = p.id
WHERE
    1 = 1
  #if(type != null && type != "")
   and a.type = #para(type)
  #end
  #if(status != null && status != "")
  and a.`status` = #para(status)
  #end
ORDER BY
    a.sort,
    a.parent_id,
    a.type;
#end

#sql("list")
SELECT
    *
FROM
    mg_menu
WHERE
    parent_id = -1
    #if(status != null && status != "")
        AND `status` = #para(status)
    #end
ORDER BY
    sort
#end
