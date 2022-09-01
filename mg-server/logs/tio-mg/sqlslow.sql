08-15 21:17:12 
4752096ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

