09-01 23:10:17 
52376ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:17 
52568ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:09:25', 3, 2, 0)

