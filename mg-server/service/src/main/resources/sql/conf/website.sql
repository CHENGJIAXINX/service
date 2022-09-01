#sql("list")
select *
from website as w
where
    1 = 1
    #if(searchkey != null && searchkey != "")
       and concat (w.sitename,w.siteurl) like #para(searchkey)))
    #end
order by w.id
#end
