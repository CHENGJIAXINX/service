09-01 21:24:56 
3ms
update chatroom_join_leave set leavetime=DATE_ADD(jointime, INTERVAL 5 second), cost=5000, status = 2 where status = 9 and server = '127.0.0.1'

09-01 21:24:56 
4ms
update chatroom_join_leave set status = 2 where status = 3 and server = '127.0.0.1'

09-01 21:24:56 
2ms
update wx_call_item set status = 4, hanguptype = 7 where status != 4

09-01 21:25:00 
3ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:25:00 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:25:00', 0, 0, 0)

09-01 21:25:05 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:25:05', 0, 0, 0)

09-01 21:25:10 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:25:10', 0, 0, 0)

09-01 21:25:15 
108ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:25:15', 0, 0, 0)

09-01 21:25:20 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:25:20', 0, 0, 0)

09-01 21:25:25 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:25:25', 0, 0, 0)

09-01 21:25:30 
5ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:25:30 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:25:30', 0, 0, 0)

09-01 21:25:35 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:25:35', 0, 0, 0)

09-01 21:25:40 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:25:40', 0, 0, 0)

09-01 21:25:45 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:25:45', 0, 0, 0)

09-01 21:25:50 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:25:50', 0, 0, 0)

09-01 21:25:55 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:25:55', 0, 0, 0)

09-01 21:26:00 
2ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:26:00 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:26:00', 0, 0, 0)

09-01 21:26:05 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:26:05', 0, 0, 0)

09-01 21:26:10 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:26:10', 0, 0, 0)

09-01 21:26:15 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:26:15', 0, 0, 0)

09-01 21:26:20 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:26:20', 0, 0, 0)

09-01 21:26:25 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:26:25', 0, 0, 0)

09-01 21:26:30 
3ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:26:30 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:26:30', 0, 0, 0)

09-01 21:26:35 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:26:35', 0, 0, 0)

09-01 21:26:40 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:26:40', 0, 0, 0)

09-01 21:26:45 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:26:45', 0, 0, 0)

09-01 21:26:50 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:26:50', 0, 0, 0)

09-01 21:26:55 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:26:55', 0, 0, 0)

09-01 21:27:00 
9ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:27:00 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:27:00', 0, 0, 0)

09-01 21:27:05 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:27:05', 0, 0, 0)

09-01 21:27:10 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:27:10', 0, 0, 0)

09-01 21:27:15 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:27:15', 0, 0, 0)

09-01 21:27:20 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:27:20', 0, 0, 0)

09-01 21:27:25 
25ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:27:25', 0, 0, 0)

09-01 21:27:30 
48ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:27:30 
59ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:27:30', 0, 0, 0)

09-01 21:27:30 
16ms
insert into  `tio_slow_request`(`path`, `uid`, `cost`, `session`, `endtime`, `starttime`, `type`, `body`) values('/user/curr', 98708001, 4217, '15161427428658899639962491904', '2022-09-01 21:27:30', '2022-09-01 21:27:26', 1, null)

09-01 21:27:31 
8ms
insert into  `chatroom_join_leave`(`uid`, `server`, `ipid`, `jointime`, `session`, `groupid`, `device`, `status`) values(98708001, '127.0.0.1', 4857, '2022-09-01 21:27:31', '15161427428658899639962491904', '/', 1, 9)

09-01 21:27:31 
16ms
insert into  `login_log`(`ip`, `appversion`, `sessionid`, `type`, `devicetype`, `hourperiod`, `uid`, `ipid`, `imei`, `time`, `deviceinfo`, `dayperiod`, `timeperiod`) values('127.0.0.1', null, '15161427428658899639962491904', 2, 1, '21', 98708001, 4857, '1', '2022-09-01 21:27:31', '自-Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36', '20220901', '21:27')

09-01 21:27:31 
17ms
replace into  `user_last_login_time`(`uid`) values(98708001)

09-01 21:27:31 
14ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 5836, 2, 2)

09-01 21:27:31 
16ms
insert ignore into  `user_ip_login_stat`(`uid`, `totalcount`, `ipid`, `ip`, `dayperiod`) values(98708001, 0, 4857, '127.0.0.1', '20220901')

09-01 21:27:31 
6ms
update user_ip_login_stat set totalcount = totalcount + 1,hour1 = hour1 + 1 where ip = '127.0.0.1' and uid = 98708001 and dayperiod = '20220901'

09-01 21:27:31 
17ms
insert ignore into  `user_ip_login_stat`(`uid`, `totalcount`, `ipid`, `ip`, `usercount`, `remark`, `dayperiod`) values(-1, 1, 4857, '127.0.0.1', 1, '天统计', '20220901')

09-01 21:27:31 
6ms
update user_ip_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = 3544

09-01 21:27:31 
2ms
insert ignore into  `user_time_login_stat`(`uid`, `totalcount`, `usercount`, `dayperiod`) values(98708001, 0, 1, '20220901')

09-01 21:27:31 
2ms
update user_time_login_stat set totalcount = totalcount + 1,hour21 = hour21 + 1 where uid = 98708001 and dayperiod = '20220901'

09-01 21:27:31 
4ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1737 

09-01 21:27:31 
4ms
insert ignore into  `user_time_login_stat`(`uid`, `totalcount`, `usercount`, `remark`, `dayperiod`) values(-1, 1, 1, '天统计', '20220901')

09-01 21:27:31 
92ms
update `tio_thread_logs` set `status` = 1  where `id` = 6401

09-01 21:27:35 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:27:35', 1, 1, 0)

09-01 21:27:36 
6ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3172


09-01 21:27:36 
2ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3172


09-01 21:27:36 
11ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4857,
		readdevice = 1
	WHERE
		twouid = '98708001_98708001'
		and touid = 98708001
		and readflag = 2
		


09-01 21:27:36 
47ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 98708001, null, '', 1, 1, 2, 98708001, 4857, 1, null, '98708001_98708001', 7, '好友已读你的消息', '2022-09-01 21:27:36', 98708001, 1, 2, 1)

09-01 21:27:36 
54ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(98708001, 3172, 98708001, 2, 1)

09-01 21:27:40 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:27:40', 1, 1, 0)

09-01 21:27:45 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:27:45', 1, 1, 0)

09-01 21:27:50 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:27:50', 1, 1, 0)

09-01 21:27:55 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:27:55', 1, 1, 0)

09-01 21:28:00 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:28:00', 1, 1, 0)

09-01 21:28:00 
49ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:28:05 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:28:05', 1, 1, 0)

09-01 21:28:10 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:28:10', 1, 1, 0)

09-01 21:28:15 
30ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:28:15', 1, 1, 0)

09-01 21:28:20 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:28:20', 1, 1, 0)

09-01 21:28:25 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:28:25', 1, 1, 0)

09-01 21:28:30 
44ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:28:30 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:28:30', 1, 1, 0)

09-01 21:28:35 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:28:35', 1, 1, 0)

09-01 21:28:40 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:28:40', 1, 1, 0)

09-01 21:28:45 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:28:45', 1, 1, 0)

09-01 21:28:50 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:28:50', 1, 1, 0)

09-01 21:28:55 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:28:55', 1, 1, 0)

09-01 21:29:00 
39ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:29:00 
40ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:29:00', 1, 1, 0)

09-01 21:29:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:29:05', 1, 1, 0)

09-01 21:29:10 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:29:10', 1, 1, 0)

09-01 21:29:15 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:29:15', 1, 1, 0)

09-01 21:29:20 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:29:20', 1, 1, 0)

09-01 21:29:24 
6ms
insert into  `ip_info`(`area`, `country`, `province`, `city`, `ip`, `time`, `operator`) values('', '', '', '内网IP', '172.20.10.4', '2022-09-01 21:29:24', '内网IP')

09-01 21:29:25 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:29:25', 1, 1, 0)

09-01 21:29:27 
8ms
update chatroom_join_leave set leavetime = '2022-09-01 21:29:27', cost = 116613, status = 1 where id = 22864

09-01 21:29:30 
4ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:29:30 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:29:30', 0, 0, 0)

09-01 21:29:35 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:29:35', 0, 0, 0)

09-01 21:29:40 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:29:40', 0, 0, 0)

09-01 21:29:45 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:29:45', 0, 0, 0)

09-01 21:29:50 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:29:50', 0, 0, 0)

09-01 21:29:55 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:29:55', 0, 0, 0)

09-01 21:30:00 
3ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:30:00 
33ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:30:00', 0, 0, 0)

09-01 21:30:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:30:05', 0, 0, 0)

09-01 21:30:10 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:30:10', 0, 0, 0)

09-01 21:30:15 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:30:15', 0, 0, 0)

09-01 21:30:20 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:30:20', 0, 0, 0)

09-01 21:30:25 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:30:25', 0, 0, 0)

09-01 21:30:30 
3ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:30:30 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:30:30', 0, 0, 0)

09-01 21:30:35 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:30:35', 0, 0, 0)

09-01 21:30:40 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:30:40', 0, 0, 0)

09-01 21:30:45 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:30:45', 0, 0, 0)

09-01 21:30:50 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:30:50', 0, 0, 0)

09-01 21:30:55 
30ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:30:55', 0, 0, 0)

09-01 21:31:00 
4ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:31:00 
39ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:31:00', 0, 0, 0)

09-01 21:31:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:31:05', 0, 0, 0)

09-01 21:31:10 
15ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:31:10', 0, 0, 0)

09-01 21:31:15 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:31:15', 0, 0, 0)

09-01 21:31:20 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:31:20', 0, 0, 0)

09-01 21:31:25 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:31:25', 0, 0, 0)

09-01 21:31:30 
4ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:31:30 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:31:30', 0, 0, 0)

09-01 21:31:35 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:31:35', 0, 0, 0)

09-01 21:31:40 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:31:40', 0, 0, 0)

09-01 21:31:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:31:45', 0, 0, 0)

09-01 21:31:50 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:31:50', 0, 0, 0)

09-01 21:31:55 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:31:55', 0, 0, 0)

09-01 21:32:00 
2ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:32:00 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:32:00', 0, 0, 0)

09-01 21:32:05 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:32:05', 0, 0, 0)

09-01 21:32:10 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:32:10', 0, 0, 0)

09-01 21:32:15 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:32:15', 0, 0, 0)

09-01 21:32:20 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:32:20', 0, 0, 0)

09-01 21:32:25 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:32:25', 0, 0, 0)

09-01 21:32:30 
3ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:32:30 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:32:30', 0, 0, 0)

09-01 21:32:35 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:32:35', 0, 0, 0)

09-01 21:32:40 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:32:40', 0, 0, 0)

09-01 21:32:45 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:32:45', 0, 0, 0)

09-01 21:32:50 
64ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:32:50', 0, 0, 0)

09-01 21:32:55 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:32:55', 0, 0, 0)

09-01 21:33:00 
12ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:33:00 
22ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:33:00', 0, 0, 0)

09-01 21:33:05 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:33:05', 0, 0, 0)

09-01 21:33:10 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:33:10', 0, 0, 0)

09-01 21:33:15 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:33:15', 0, 0, 0)

09-01 21:33:20 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:33:20', 0, 0, 0)

09-01 21:33:25 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:33:25', 0, 0, 0)

09-01 21:33:30 
3ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:33:30 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:33:30', 0, 0, 0)

09-01 21:33:35 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:33:35', 0, 0, 0)

09-01 21:33:40 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:33:40', 0, 0, 0)

09-01 21:33:45 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:33:45', 0, 0, 0)

09-01 21:33:50 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:33:50', 0, 0, 0)

09-01 21:33:55 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:33:55', 0, 0, 0)

09-01 21:34:00 
3ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:34:00 
40ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:34:00', 0, 0, 0)

09-01 21:34:05 
35ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:34:05', 0, 0, 0)

09-01 21:34:10 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:34:10', 0, 0, 0)

09-01 21:34:15 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:34:15', 0, 0, 0)

09-01 21:34:20 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:34:20', 0, 0, 0)

09-01 21:34:25 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:34:25', 0, 0, 0)

09-01 21:34:30 
4ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:34:30 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:34:30', 0, 0, 0)

09-01 21:34:35 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:34:35', 0, 0, 0)

09-01 21:34:40 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:34:40', 0, 0, 0)

09-01 21:34:45 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:34:45', 0, 0, 0)

09-01 21:34:50 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:34:50', 0, 0, 0)

09-01 21:34:55 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:34:55', 0, 0, 0)

09-01 21:35:00 
6ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:35:00 
17ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:35:00', 0, 0, 0)

09-01 21:35:05 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:35:05', 0, 0, 0)

09-01 21:35:10 
59ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:35:10', 0, 0, 0)

09-01 21:35:15 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:35:15', 0, 0, 0)

09-01 21:35:20 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:35:20', 0, 0, 0)

09-01 21:35:25 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:35:25', 0, 0, 0)

09-01 21:35:30 
5ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:35:30 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:35:30', 0, 0, 0)

09-01 21:35:35 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:35:35', 0, 0, 0)

09-01 21:35:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:35:40', 0, 0, 0)

09-01 21:35:45 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:35:45', 0, 0, 0)

09-01 21:35:50 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:35:50', 0, 0, 0)

09-01 21:35:55 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:35:55', 0, 0, 0)

09-01 21:36:00 
4ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:36:00 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:36:00', 0, 0, 0)

09-01 21:36:05 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:36:05', 0, 0, 0)

09-01 21:36:10 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:36:10', 0, 0, 0)

09-01 21:36:15 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:36:15', 0, 0, 0)

09-01 21:36:20 
28ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:36:20', 0, 0, 0)

09-01 21:36:25 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:36:25', 0, 0, 0)

09-01 21:36:30 
4ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:36:30 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:36:30', 0, 0, 0)

09-01 21:36:35 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:36:35', 0, 0, 0)

09-01 21:36:40 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:36:40', 0, 0, 0)

09-01 21:36:45 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:36:45', 0, 0, 0)

09-01 21:36:50 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:36:50', 0, 0, 0)

09-01 21:36:55 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:36:55', 0, 0, 0)

09-01 21:37:00 
3ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:37:00 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:37:00', 0, 0, 0)

09-01 21:37:05 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:37:05', 0, 0, 0)

09-01 21:37:10 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:37:10', 0, 0, 0)

09-01 21:37:15 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:37:15', 0, 0, 0)

09-01 21:37:17 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(3055, 6, '127.0.0.1', 509.1666666666667, '2022-09-01 21:29:24', 6, 120, 0, 473249, 12, 4860, 12, 6, 6, '7分53秒249毫秒', 1.0, 2574, 0, 3055)

09-01 21:37:17 
4ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(19327, 19, '127.0.0.1', 1017.2105263157895, '2022-09-01 21:27:26', 19, 120, 0, 591538, 38, 4857, 12, 19, 19, '9分51秒538毫秒', 1.0, 8783, 0, 19327)

09-01 21:37:18 
6ms
insert into  `ip_info`(`area`, `country`, `province`, `city`, `ip`, `time`, `operator`) values('', '', '', '内网IP', '172.20.10.2', '2022-09-01 21:37:18', '内网IP')

09-01 21:37:18 
6ms
insert into  `ip_info`(`area`, `country`, `province`, `city`, `ip`, `time`, `operator`) values('', '', '', '内网IP', '172.20.10.2', '2022-09-01 21:37:18', '内网IP')

09-01 21:37:18 
9ms
insert into  `imei_stat`(`ipid`, `size`, `ip`, `idfa`, `imei`, `appversion`, `time`, `type`, `deviceinfo`, `resolution`, `url`, `cid`) values(4861, 'x86_64', '172.20.10.2', '00000000-0000-0000-0000-000000000000', '83a522533756442a91e1a2415ced871e', '3.1', '2022-09-01 21:37:18', 3, 'x86_64', '828,1792', '/config/base', '59')

09-01 21:37:18 
5ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(6, '127.0.0.1', '172.20.10.4', 2, '2022-09-01 21:29:24', 300, 473428, 5.0, null, 4860, 8, '7分53秒428毫秒', 0.012673521633701428, 30)

09-01 21:37:18 
7ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(19, '127.0.0.1', '127.0.0.1', 0, '2022-09-01 21:27:30', 300, 587437, 263.4736842105263, null, 4857, 8, '9分47秒437毫秒', 0.032343893898409526, 5006)

09-01 21:37:18 
batch params_list:2, 9ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.4', 2, '2022-09-01 21:29:24', 300, 473443, 'api', 7.5, '/user/curr', 4860, 8, '7分53秒443毫秒', 0.008448746734031341, 30);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:29:24', 300, 473365, 'api', 0.0, '/config/viewmodel', 4860, 8, '7分53秒365毫秒', 0.004225069449579078, 0);


09-01 21:37:18 
batch params_list:11, 32ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '127.0.0.1', 0, '2022-09-01 21:27:31', 300, 586420, 'api', 25.5, '/chat/mailList', 4857, 8, '9分46秒420毫秒', 0.0034105248797789978, 51);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '127.0.0.1', 0, '2022-09-01 21:27:30', 300, 587235, 'api', 57.0, '/chat/list', 4857, 8, '9分47秒235毫秒', 0.0034057915485282723, 114);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '127.0.0.1', 0, '2022-09-01 21:27:31', 300, 587084, 'api', 30.0, '/chat/applyData', 4857, 8, '9分47秒84毫秒', 0.0017033337648445538, 30);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '127.0.0.1', 0, '2022-09-01 21:27:30', 300, 587344, 'api', 0.0, '/im/imserver', 4857, 8, '9分47秒344毫秒', 0.0017025797488354354, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '127.0.0.1', 0, '2022-09-01 21:27:31', 300, 586563, 'api', 77.0, '/chat/getLastAllNotice', 4857, 8, '9分46秒563毫秒', 0.0017048467087081864, 77);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '127.0.0.1', '127.0.0.1', 0, '2022-09-01 21:27:31', 300, 586394, 'api', 66.0, '/config/query', 4857, 8, '9分46秒394毫秒', 0.008526690245807426, 330);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '127.0.0.1', 0, '2022-09-01 21:27:31', 300, 586394, 'api', 26.0, '/friendGroup/list', 4857, 8, '9分46秒394毫秒', 0.0017053380491614852, 26);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '127.0.0.1', 0, '2022-09-01 21:27:30', 300, 587452, 'api', 2108.5, '/user/curr', 4857, 8, '9分47秒452毫秒', 0.003404533476777677, 4217);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '127.0.0.1', 0, '2022-09-01 21:27:32', 300, 585459, 'api', 136.0, '/user/info', 4857, 8, '9分45秒459毫秒', 0.0017080615380410927, 136);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '127.0.0.1', 0, '2022-09-01 21:27:30', 300, 587375, 'api', 12.0, '/config/viewmodel', 4857, 8, '9分47秒375毫秒', 0.003404979782932539, 24);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '127.0.0.1', 0, '2022-09-01 21:27:32', 300, 585349, 'api', 1.0, '/chat/queryOnline', 4857, 8, '9分45秒349毫秒', 0.001708382520513403, 1);


09-01 21:37:18 
6ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.4', '2022-09-01 21:29:24', 300, '15165437320958883038307980288', 473443, 0.0, null, 4860, 8, '7分53秒443毫秒', 0.008448746734031341, 0)

09-01 21:37:18 
8ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(19, '127.0.0.1', '127.0.0.1', '2022-09-01 21:27:30', 300, '15161427428658899639962491904', 587530, 98708001, 263.4736842105263, null, 4857, 8, '9分47秒530毫秒', 0.03233877419025411, 5006)

09-01 21:37:18 
batch params_list:2, 9ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', '2022-09-01 21:29:24', 300, '15165437320958883038307980288', 473443, 'api', 0.0, '/user/curr', 4860, 8, '7分53秒443毫秒', 0.0042243733670156705, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', '2022-09-01 21:29:24', 300, '15165437320958883038307980288', 473458, 'api', 0.0, '/config/viewmodel', 4860, 8, '7分53秒458毫秒', 0.004224239531278381, 0);


09-01 21:37:18 
batch params_list:11, 37ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '127.0.0.1', '2022-09-01 21:27:31', 300, '15161427428658899639962491904', 586513, 'api', 98708001, 25.5, '/chat/mailList', 4857, 8, '9分46秒513毫秒', 0.003409984092424209, 51);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '127.0.0.1', '2022-09-01 21:27:30', 300, '15161427428658899639962491904', 587328, 'api', 98708001, 57.0, '/chat/list', 4857, 8, '9分47秒328毫秒', 0.003405252261087501, 114);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '127.0.0.1', '2022-09-01 21:27:31', 300, '15161427428658899639962491904', 587177, 'api', 98708001, 30.0, '/chat/applyData', 4857, 8, '9分47秒177毫秒', 0.001703063982410755, 30);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '127.0.0.1', '2022-09-01 21:27:30', 300, '15161427428658899639962491904', 587437, 'api', 98708001, 0.0, '/im/imserver', 4857, 8, '9分47秒437毫秒', 0.001702310205179449, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '127.0.0.1', '2022-09-01 21:27:31', 300, '15161427428658899639962491904', 586656, 'api', 98708001, 77.0, '/chat/getLastAllNotice', 4857, 8, '9分46秒656毫秒', 0.001704576446844488, 77);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '127.0.0.1', '127.0.0.1', '2022-09-01 21:27:31', 300, '15161427428658899639962491904', 586487, 'api', 98708001, 66.0, '/config/query', 4857, 8, '9分46秒487毫秒', 0.008525338157538018, 330);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '127.0.0.1', '2022-09-01 21:27:31', 300, '15161427428658899639962491904', 586487, 'api', 98708001, 26.0, '/friendGroup/list', 4857, 8, '9分46秒487毫秒', 0.0017050676315076038, 26);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '127.0.0.1', '2022-09-01 21:27:30', 300, '15161427428658899639962491904', 587545, 'api', 98708001, 2108.5, '/user/curr', 4857, 8, '9分47秒545毫秒', 0.0034039945876486056, 4217);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '127.0.0.1', '2022-09-01 21:27:32', 300, '15161427428658899639962491904', 585552, 'api', 98708001, 136.0, '/user/info', 4857, 8, '9分45秒552毫秒', 0.0017077902560319151, 136);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '127.0.0.1', '2022-09-01 21:27:30', 300, '15161427428658899639962491904', 587468, 'api', 98708001, 12.0, '/config/viewmodel', 4857, 8, '9分47秒468毫秒', 0.003404440752517584, 24);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '127.0.0.1', '2022-09-01 21:27:32', 300, '15161427428658899639962491904', 585442, 'api', 98708001, 1.0, '/chat/queryOnline', 4857, 8, '9分45秒442毫秒', 0.001708111136542988, 1);


09-01 21:37:20 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:37:20', 0, 0, 0)

09-01 21:37:25 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:37:25', 0, 0, 0)

09-01 21:37:30 
8ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:37:30 
15ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:37:30', 0, 0, 0)

09-01 21:37:35 
34ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:37:35', 0, 0, 0)

09-01 21:37:40 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:37:40', 0, 0, 0)

09-01 21:37:45 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:37:45', 0, 0, 0)

09-01 21:37:50 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:37:50', 0, 0, 0)

09-01 21:37:55 
51ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:37:55', 0, 0, 0)

09-01 21:38:00 
5ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:38:00 
60ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:38:00', 0, 0, 0)

09-01 21:38:03 
18ms
insert into  `login_log`(`ip`, `appversion`, `sessionid`, `type`, `devicetype`, `hourperiod`, `uid`, `ipid`, `imei`, `time`, `deviceinfo`, `dayperiod`, `timeperiod`) values('172.20.10.2', '3.1', '15165437323156852135218865152', 1, 3, '21', 98708001, 4861, '83a522533756442a91e1a2415ced871e', '2022-09-01 21:38:03', '主-x86_64', '20220901', '21:38')

09-01 21:38:03 
9ms
replace into  `user_last_login_time`(`uid`) values(98708001)

09-01 21:38:03 
7ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 5837, 2, 2)

09-01 21:38:03 
3ms
insert ignore into  `user_ip_login_stat`(`uid`, `totalcount`, `ipid`, `ip`, `dayperiod`) values(98708001, 0, 4861, '172.20.10.2', '20220901')

09-01 21:38:03 
3ms
update user_ip_login_stat set totalcount = totalcount + 1,hour1 = hour1 + 1 where ip = '172.20.10.2' and uid = 98708001 and dayperiod = '20220901'

09-01 21:38:03 
3ms
insert ignore into  `user_ip_login_stat`(`uid`, `totalcount`, `ipid`, `ip`, `usercount`, `remark`, `dayperiod`) values(-1, 1, 4861, '172.20.10.2', 1, '天统计', '20220901')

09-01 21:38:03 
9ms
insert into  `user_token`(`uid`, `devicetype`, `token`) values(98708001, 5, '15165437323156852135218865152')

09-01 21:38:03 
2ms
insert ignore into  `user_ip_login_stat`(`totalcount`, `uid`, `ipid`, `ip`, `usercount`, `dayperiod`) values(1, -1, 4861, '172.20.10.2', 1, '-1')

09-01 21:38:03 
2ms
update user_time_login_stat set totalcount = totalcount + 1,hour21 = hour21 + 1 where uid = 98708001 and dayperiod = '20220901'

09-01 21:38:03 
5ms
delete from wx_syn_item where uid = 98708001 and devicetype = 5

09-01 21:38:03 
4ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1737 

09-01 21:38:03 
2ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1742

09-01 21:38:03 
5ms
update `tio_thread_logs` set `status` = 1  where `id` = 6402

09-01 21:38:05 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:38:05', 0, 0, 0)

09-01 21:38:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:38:10', 0, 0, 0)

09-01 21:38:12 
9ms
insert into  `login_log`(`hourperiod`, `uid`, `uaid`, `ipid`, `ip`, `time`, `sessionid`, `type`, `deviceinfo`, `devicetype`, `dayperiod`, `timeperiod`) values('21', 98708001, 313, 4860, '172.20.10.4', '2022-09-01 21:38:12', '15165437323250812231226964992', 1, '主-Unknown ??/Chrome 104', 1, '20220901', '21:38')

09-01 21:38:12 
7ms
replace into  `user_last_login_time`(`uid`) values(98708001)

09-01 21:38:12 
8ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 5838, 2, 2)

09-01 21:38:12 
6ms
update `user_token` set `token` = '15165437323250812231226964992'  where `devicetype` = 1 and `uid` = 98708001

09-01 21:38:12 
3ms
insert ignore into  `user_ip_login_stat`(`uid`, `totalcount`, `ipid`, `ip`, `dayperiod`) values(98708001, 0, 4860, '172.20.10.4', '20220901')

09-01 21:38:12 
2ms
update user_ip_login_stat set totalcount = totalcount + 1,hour1 = hour1 + 1 where ip = '172.20.10.4' and uid = 98708001 and dayperiod = '20220901'

09-01 21:38:12 
2ms
insert ignore into  `user_ip_login_stat`(`uid`, `totalcount`, `ipid`, `ip`, `usercount`, `remark`, `dayperiod`) values(-1, 1, 4860, '172.20.10.4', 1, '天统计', '20220901')

09-01 21:38:12 
3ms
insert ignore into  `user_ip_login_stat`(`totalcount`, `uid`, `ipid`, `ip`, `usercount`, `dayperiod`) values(1, -1, 4860, '172.20.10.4', 1, '-1')

09-01 21:38:12 
2ms
update user_time_login_stat set totalcount = totalcount + 1,hour21 = hour21 + 1 where uid = 98708001 and dayperiod = '20220901'

09-01 21:38:12 
2ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1737 

09-01 21:38:12 
3ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1742

09-01 21:38:12 
6ms
update `tio_thread_logs` set `status` = 1  where `id` = 6403

09-01 21:38:12 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1160, 1, '127.0.0.1', 24.680851063829788, '2022-09-01 21:27:30', 47, 120, 1, 641510, 12, 4857, 1, 48, 48, '10分41秒510毫秒', 1.0212765957446808, 1385, 0, 1160)

09-01 21:38:12 
6ms
insert into  `chatroom_join_leave`(`uid`, `server`, `ipid`, `jointime`, `session`, `groupid`, `device`, `status`) values(98708001, '127.0.0.1', 4857, '2022-09-01 21:38:12', '15165437323250812231226964992', '/login', 1, 9)

09-01 21:38:13 
6ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3172


09-01 21:38:13 
3ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3172


09-01 21:38:13 
37ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4857,
		readdevice = 1
	WHERE
		twouid = '98708001_98708001'
		and touid = 98708001
		and readflag = 2
		


09-01 21:38:13 
10ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 98708001, null, '', 1, 1, 2, 98708001, 4857, 1, null, '98708001_98708001', 7, '好友已读你的消息', '2022-09-01 21:38:13', 98708001, 1, 2, 1)

09-01 21:38:13 
12ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(98708001, 3172, 98708001, 2, 1)

09-01 21:38:15 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:38:15', 1, 1, 0)

09-01 21:38:20 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:38:20', 1, 1, 0)

09-01 21:38:25 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:38:25', 1, 1, 0)

09-01 21:38:30 
6ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:38:30 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:38:30', 1, 1, 0)

09-01 21:38:35 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:38:35', 1, 1, 0)

09-01 21:38:40 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:38:40', 1, 1, 0)

09-01 21:38:45 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:38:45', 1, 1, 0)

09-01 21:38:50 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:38:50', 1, 1, 0)

09-01 21:38:55 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:38:55', 1, 1, 0)

09-01 21:39:00 
19ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:39:00', 1, 1, 0)

09-01 21:39:00 
22ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:39:05 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:39:05', 1, 1, 0)

09-01 21:39:10 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:39:10', 1, 1, 0)

09-01 21:39:15 
16ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:39:15', 1, 1, 0)

09-01 21:39:20 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:39:20', 1, 1, 0)

09-01 21:39:25 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:39:25', 1, 1, 0)

09-01 21:39:30 
43ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:39:30 
51ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:39:30', 1, 1, 0)

09-01 21:39:35 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:39:35', 1, 1, 0)

09-01 21:39:40 
40ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:39:40', 1, 1, 0)

09-01 21:39:45 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:39:45', 1, 1, 0)

09-01 21:39:50 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:39:50', 1, 1, 0)

09-01 21:39:55 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:39:55', 1, 1, 0)

09-01 21:40:00 
40ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:40:00', 1, 1, 0)

09-01 21:40:00 
40ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:40:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:40:05', 1, 1, 0)

09-01 21:40:10 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:40:10', 1, 1, 0)

09-01 21:40:13 
5ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1192, 1, '127.0.0.1', 23.84, '2022-09-01 21:38:12', 50, 120, 1, 120722, 12, 4857, 1, 50, 50, '2分722毫秒', 1.0, 1385, 0, 1192)

09-01 21:40:15 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:40:15', 1, 1, 0)

09-01 21:40:20 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:40:20', 1, 1, 0)

09-01 21:40:25 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:40:25', 1, 1, 0)

09-01 21:40:30 
24ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:40:30 
27ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:40:30', 1, 1, 0)

09-01 21:40:35 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:40:35', 1, 1, 0)

09-01 21:40:40 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:40:40', 1, 1, 0)

09-01 21:40:45 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:40:45', 1, 1, 0)

09-01 21:40:50 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:40:50', 1, 1, 0)

09-01 21:40:55 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:40:55', 1, 1, 0)

09-01 21:41:00 
41ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:41:00 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:41:00', 1, 1, 0)

09-01 21:41:05 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:41:05', 1, 1, 0)

09-01 21:41:10 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:41:10', 1, 1, 0)

09-01 21:41:15 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:41:15', 1, 1, 0)

09-01 21:41:20 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:41:20', 1, 1, 0)

09-01 21:41:25 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:41:25', 1, 1, 0)

09-01 21:41:30 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:41:30 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:41:30', 1, 1, 0)

09-01 21:41:35 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:41:35', 1, 1, 0)

09-01 21:41:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:41:40', 1, 1, 0)

09-01 21:41:45 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:41:45', 1, 1, 0)

09-01 21:41:45 
41ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(0, 0, '127.0.0.1', 0.0, '2022-09-01 21:37:46', 0, 120, 0, 238821, 0, 4857, 12, 0, 0, '3分58秒821毫秒', 0.0, 0, 0, 0)

09-01 21:41:45 
4ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(10923, 19, '127.0.0.1', 574.8947368421053, '2022-09-01 21:37:46', 19, 120, 0, 238820, 38, 4860, 12, 19, 19, '3分58秒820毫秒', 1.0, 7434, 0, 10923)

09-01 21:41:45 
4ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(5016, 4, '127.0.0.1', 358.2857142857143, '2022-09-01 21:37:17', 14, 120, 0, 267639, 16, 4861, 12, 8, 8, '4分27秒639毫秒', 0.5714285714285714, 6576, 0, 5016)

09-01 21:41:50 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:41:50', 1, 1, 0)

09-01 21:41:55 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:41:55', 1, 1, 0)

09-01 21:42:00 
41ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:42:00 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:42:00', 1, 1, 0)

09-01 21:42:05 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:42:05', 1, 1, 0)

09-01 21:42:10 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:42:10', 1, 1, 0)

09-01 21:42:15 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:42:15', 1, 1, 0)

09-01 21:42:16 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(539, 0, '127.0.0.1', 11.0, '2022-09-01 21:40:13', 49, 120, 1, 122990, 0, 4857, 1, 49, 49, '2分2秒990毫秒', 1.0, 0, 0, 539)

09-01 21:42:20 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:42:20', 1, 1, 0)

09-01 21:42:25 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:42:25', 1, 1, 0)

09-01 21:42:30 
42ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:42:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:42:30', 1, 1, 0)

09-01 21:42:35 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:42:35', 1, 1, 0)

09-01 21:42:39 
7ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(20, '127.0.0.1', '172.20.10.2', 2, '2022-09-01 21:37:18', 300, 321068, 24.65, null, 4861, 8, '5分21秒68毫秒', 0.06229210011586331, 493)

09-01 21:42:39 
batch params_list:9, 53ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:37:57', 300, 281410, 'api', 53.5, '/login', 4861, 8, '4分41秒410毫秒', 0.00710706797910522, 107);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '127.0.0.1', '172.20.10.2', 2, '2022-09-01 21:37:18', 300, 321068, 'api', 55.2, '/config/base', 4861, 8, '5分21秒68毫秒', 0.015573025028965827, 276);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:41:45', 300, 53573, 'api', 0.0, '/chat/applyData', 4861, 8, '53秒573毫秒', 0.05599835738151681, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:38:04', 300, 275005, 'api', 7.5, '/im/imserver', 4861, 8, '4分35秒5毫秒', 0.007272595043726478, 15);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:41:45', 300, 53526, 'api', 47.0, '/chat/getLastAllNotice', 4861, 8, '53秒526毫秒', 0.018682509434667264, 47);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:38:03', 300, 275317, 'api', 0.0, '/user/curr', 4861, 8, '4分35秒317毫秒', 0.007264353454381677, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:42:07', 300, 31598, 'api', 0.0, '/chat/applyList', 4861, 8, '31秒598毫秒', 0.031647572631179184, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:37:18', 300, 320975, 'api', 24.0, '/sys/version', 4861, 8, '5分20秒975毫秒', 0.006231014876548018, 48);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:41:45', 300, 53449, 'api', 0.0, '/chat/queryOnline', 4861, 8, '53秒449毫秒', 0.037418847873673965, 0);


09-01 21:42:40 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:42:40', 1, 1, 0)

09-01 21:42:45 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:42:45', 1, 1, 0)

09-01 21:42:45 
4ms
insert into  `user`(`nick`, `createtime`, `thirdstatus`, `reghref`, `ipid`, `avatarbig`, `loginname`, `registertype`, `id`, `avatar`, `pwd`, `status`) values('13499999999', '2022-09-01 21:42:45', 1, null, 4857, '/user/base/avatar/2021080826/0953001424186851396296704.png', 'a13499999999', 1, 23026121, '/user/base/avatar/2021080826/0953001424186851396296704.png', 'fb87ee25347829537e0ac3de7105489e', 1)

09-01 21:42:45 
4ms
insert into  `user_base`(`uid`, `email`) values(23026121, 'a13499999999')

09-01 21:42:45 
4ms
insert into  `user_coin`(`uid`) values(23026121)

09-01 21:42:45 
3ms
insert into  `user_role`(`uid`, `rid`, `status`) values(23026121, 2, 1)

09-01 21:42:45 
3ms
insert ignore into  `wx_friend`(`chatindex`, `uid`, `startmsgid`, `frienduid`) values('ZA', 23026121, null, 23026121)

09-01 21:42:45 
6ms
replace into  `wx_friend_meta`(`uid`, `touid`, `fidkey`) values(23026121, 23026121, '23026121_23026121')

09-01 21:42:45 
2ms
insert ignore into  `wx_chat_user_item`(`linkflag`, `uid`, `chatlinkid`, `chatmode`, `linkid`, `tochatlinkmetaid`, `bizid`, `fidkey`, `chatlinkmetaid`, `tochatlinkid`) values(1, 23026121, null, 1, 2250, null, 23026121, '23026121_23026121', null, null)

09-01 21:42:45 
2ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 23026121, 1, 2)

09-01 21:42:45 
6ms
insert ignore into  `user_register_stat`(`statbizstr`, `type`) values('20220901', 1)

09-01 21:42:45 
11ms
insert ignore into  `user_register_stat`(`statbizid`, `statbizstr`, `type`) values(4857, '20220901', 3)

09-01 21:42:45 
16ms
update user_register_stat set regcount = regcount + 1 where (type = 1 and statbizstr = '20220901') or (type = 2 and statbizstr = '127.0.0.1') or (type = 3 and statbizstr = '20220901' and statbizid = 4857) 

09-01 21:42:50 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:42:50', 1, 1, 0)

09-01 21:42:55 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:42:55', 1, 1, 0)

09-01 21:43:00 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:43:00', 1, 1, 0)

09-01 21:43:00 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:43:05 
33ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:43:05', 1, 1, 0)

09-01 21:43:10 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:43:10', 1, 1, 0)

09-01 21:43:15 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:43:15', 1, 1, 0)

09-01 21:43:20 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:43:20', 1, 1, 0)

09-01 21:43:25 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:43:25', 1, 1, 0)

09-01 21:43:30 
52ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:43:30', 1, 1, 0)

09-01 21:43:30 
55ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:43:32 
9ms
insert into  `imei_stat`(`ipid`, `size`, `ip`, `idfa`, `imei`, `appversion`, `time`, `type`, `deviceinfo`, `resolution`, `url`, `cid`) values(4861, 'x86_64', '172.20.10.2', '00000000-0000-0000-0000-000000000000', 'a658aec1bd9a411aba1b78d9af8af44c', '3.1', '2022-09-01 21:43:32', 3, 'x86_64', '1125,2436', '/config/base', '59')

09-01 21:43:32 
7ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(19, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:37:46', 300, 346133, 12.526315789473685, null, 4860, 8, '5分46秒133毫秒', 0.05489219461883149, 238)

09-01 21:43:32 
batch params_list:11, 55ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:38:12', 300, 319933, 'api', 0.0, '/chat/mailList', 4860, 8, '5分19秒933毫秒', 0.006251308867794194, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:38:12', 300, 320474, 'api', 7.5, '/chat/list', 4860, 8, '5分20秒474毫秒', 0.006240755880352228, 15);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:37:46', 300, 346133, 'api', 36.333333333333336, '/login', 4860, 8, '5分46秒133毫秒', 0.008667188624026025, 109);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:38:12', 300, 320412, 'api', 15.0, '/chat/applyData', 4860, 8, '5分20秒412毫秒', 0.0031209817360148807, 15);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:38:12', 300, 320489, 'api', 0.0, '/im/imserver', 4860, 8, '5分20秒489毫秒', 0.0031202318956344835, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:38:12', 300, 319933, 'api', 0.0, '/chat/getLastAllNotice', 4860, 8, '5分19秒933毫秒', 0.003125654433897097, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:38:13', 300, 319898, 'api', 11.0, '/config/query', 4860, 8, '5分19秒898毫秒', 0.015629982056780598, 55);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:38:13', 300, 319898, 'api', 14.0, '/friendGroup/list', 4860, 8, '5分19秒898毫秒', 0.00312599641135612, 14);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:38:12', 300, 320505, 'api', 15.0, '/user/curr', 4860, 8, '5分20秒505毫秒', 0.0031200761298575685, 15);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:38:13', 300, 319593, 'api', 15.0, '/user/info', 4860, 8, '5分19秒593毫秒', 0.0031289796710190776, 15);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:38:13', 300, 319546, 'api', 0.0, '/chat/queryOnline', 4860, 8, '5分19秒546毫秒', 0.003129439892847978, 0);


09-01 21:43:33 
39ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(15, '127.0.0.1', '172.20.10.2', '2022-09-01 21:38:03', 300, '15165437323156852135218865152', 329383, 98708001, 9.4, null, 4861, 8, '5分29秒383毫秒', 0.04553969087657833, 141)

09-01 21:43:33 
5ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(16, '127.0.0.1', '172.20.10.4', '2022-09-01 21:38:12', 300, '15165437323250812231226964992', 320845, 98708001, 8.0625, null, 4860, 8, '5分20秒845毫秒', 0.04986831647680344, 129)

09-01 21:43:33 
5ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.4', '2022-09-01 21:37:46', 300, '15165437320958883038307980288', 346473, 36.333333333333336, null, 4860, 8, '5分46秒473毫秒', 0.008658683360608186, 109)

09-01 21:43:33 
5ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.2', '2022-09-01 21:37:18', 300, '15165437322957834433446897665', 375041, 41.0, null, 4861, 8, '6分15秒41毫秒', 0.007999125428953101, 123)

09-01 21:43:33 
batch params_list:1, 12ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.4', '2022-09-01 21:37:46', 300, '15165437320958883038307980288', 346514, 'api', 36.333333333333336, '/login', 4860, 8, '5分46秒514毫秒', 0.008657658853610533, 109);


09-01 21:43:33 
batch params_list:8, 66ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.2', '2022-09-01 21:38:03', 300, '15165437323156852135218865152', 329362, 'api', 98708001, 15.666666666666666, '/config/base', 4861, 8, '5分29秒362毫秒', 0.00910851889410436, 47);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.2', '2022-09-01 21:41:45', 300, '15165437323156852135218865152', 107680, 'api', 98708001, 0.0, '/chat/applyData', 4861, 8, '1分47秒680毫秒', 0.027860326894502227, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', '2022-09-01 21:38:04', 300, '15165437323156852135218865152', 329112, 'api', 98708001, 7.5, '/im/imserver', 4861, 8, '5分29秒112毫秒', 0.006076958603757992, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:41:45', 300, '15165437323156852135218865152', 107633, 'api', 98708001, 47.0, '/chat/getLastAllNotice', 4861, 8, '1分47秒633毫秒', 0.00929083087900551, 47);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', '2022-09-01 21:38:03', 300, '15165437323156852135218865152', 329424, 'api', 98708001, 0.0, '/user/curr', 4861, 8, '5分29秒424毫秒', 0.0060712030696002724, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:42:07', 300, '15165437323156852135218865152', 85705, 'api', 98708001, 0.0, '/chat/applyList', 4861, 8, '1分25秒705毫秒', 0.011667930692491687, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:41:45', 300, '15165437323156852135218865152', 107432, 'api', 98708001, 32.0, '/sys/version', 4861, 8, '1分47秒432毫秒', 0.009308213567652096, 32);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', '2022-09-01 21:41:45', 300, '15165437323156852135218865152', 107556, 'api', 98708001, 0.0, '/chat/queryOnline', 4861, 8, '1分47秒556毫秒', 0.01859496448361784, 0);


09-01 21:43:33 
batch params_list:2, 14ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', '2022-09-01 21:37:57', 300, '15165437322957834433446897665', 335539, 'api', 53.5, '/login', 4861, 8, '5分35秒539毫秒', 0.005960558981221259, 107);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:37:18', 300, '15165437322957834433446897665', 375104, 'api', 16.0, '/sys/version', 4861, 8, '6分15秒104毫秒', 0.0026659273161576524, 16);


09-01 21:43:33 
batch params_list:10, 74ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', '2022-09-01 21:38:13', 300, '15165437323250812231226964992', 320293, 'api', 98708001, 0.0, '/chat/mailList', 4860, 8, '5分20秒293毫秒', 0.006244282578763819, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', '2022-09-01 21:38:12', 300, '15165437323250812231226964992', 320855, 'api', 98708001, 7.5, '/chat/list', 4860, 8, '5分20秒855毫秒', 0.006233345280578454, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:38:12', 300, '15165437323250812231226964992', 320793, 'api', 98708001, 15.0, '/chat/applyData', 4860, 8, '5分20秒793毫秒', 0.0031172750028834796, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:38:12', 300, '15165437323250812231226964992', 320870, 'api', 98708001, 0.0, '/im/imserver', 4860, 8, '5分20秒870毫秒', 0.0031165269423754165, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:38:12', 300, '15165437323250812231226964992', 320314, 'api', 98708001, 0.0, '/chat/getLastAllNotice', 4860, 8, '5分20秒314毫秒', 0.003121936599711533, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '127.0.0.1', '172.20.10.4', '2022-09-01 21:38:13', 300, '15165437323250812231226964992', 320279, 'api', 98708001, 11.0, '/config/query', 4860, 8, '5分20秒279毫秒', 0.015611388820372238, 55);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:38:13', 300, '15165437323250812231226964992', 320279, 'api', 98708001, 14.0, '/friendGroup/list', 4860, 8, '5分20秒279毫秒', 0.0031222777640744475, 14);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:38:12', 300, '15165437323250812231226964992', 320886, 'api', 98708001, 15.0, '/user/curr', 4860, 8, '5分20秒886毫秒', 0.003116371546281234, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:38:13', 300, '15165437323250812231226964992', 319974, 'api', 98708001, 15.0, '/user/info', 4860, 8, '5分19秒974毫秒', 0.003125253926881559, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:38:13', 300, '15165437323250812231226964992', 319927, 'api', 98708001, 0.0, '/chat/queryOnline', 4860, 8, '5分19秒927毫秒', 0.003125713053290282, 0);


09-01 21:43:35 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:43:35', 1, 1, 0)

09-01 21:43:40 
39ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:43:40', 1, 1, 0)

09-01 21:43:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:43:45', 1, 1, 0)

09-01 21:43:50 
39ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(9330, 9, '127.0.0.1', 358.84615384615387, '2022-09-01 21:41:45', 26, 120, 0, 124382, 30, 4861, 12, 15, 15, '2分4秒382毫秒', 0.5769230769230769, 10211, 0, 9330)

09-01 21:43:50 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:43:50', 1, 1, 0)

09-01 21:43:55 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:43:55', 1, 1, 0)

09-01 21:43:56 
11ms
insert into  `sms_log`(`referer`, `phone`, `smscode`, `ip24count`, `ip`, `tempcode`, `sessionid`, `type`, `phone24count`, `errormsg`, `status`) values(null, '19375836351', '525102', 1, '172.20.10.2', '', '15165437324554856635669169152', '2', 1, '', 1)

09-01 21:44:00 
38ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:44:00 
36ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:44:00', 1, 1, 0)

09-01 21:44:05 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:44:05', 1, 1, 0)

09-01 21:44:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:44:10', 1, 1, 0)

09-01 21:44:15 
26ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:44:15', 1, 1, 0)

09-01 21:44:17 
8ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(539, 0, '127.0.0.1', 11.0, '2022-09-01 21:42:16', 49, 120, 1, 121664, 0, 4857, 1, 49, 49, '2分1秒664毫秒', 1.0, 0, 0, 539)

09-01 21:44:20 
32ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:44:20', 1, 1, 0)

09-01 21:44:25 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:44:25', 1, 1, 0)

09-01 21:44:30 
26ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:44:30', 1, 1, 0)

09-01 21:44:30 
31ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:44:35 
51ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:44:35', 1, 1, 0)

09-01 21:44:37 
8ms
insert into  `auto_avatar`(`chatindex`, `path`, `remark`) values('J', '/user/base/avatar/2022090135/2144361565334814645690368.png', 'J')

09-01 21:44:37 
2ms
insert into  `user`(`createtime`, `reghref`, `loginname`, `phonebindflag`, `avatar`, `nick`, `thirdstatus`, `ipid`, `avatarbig`, `phone`, `registertype`, `id`, `pwd`, `phonepwd`, `status`) values('2022-09-01 21:44:37', null, null, 1, '/user/base/avatar/2022090135/2144361565334814645690368.png', 'Jerrylee', 1, 4861, '/user/base/avatar/2022090135/2144361565334814645690368.png', '19375836351', 3, 48431849, 'aca904fd4a19d36dfdb65665c35608b6', 'aca904fd4a19d36dfdb65665c35608b6', 1)

09-01 21:44:37 
2ms
insert into  `user_base`(`uid`, `email`) values(48431849, null)

09-01 21:44:37 
3ms
insert into  `user_coin`(`uid`) values(48431849)

09-01 21:44:37 
2ms
insert into  `user_role`(`uid`, `rid`, `status`) values(48431849, 2, 1)

09-01 21:44:37 
3ms
insert ignore into  `wx_friend`(`chatindex`, `uid`, `startmsgid`, `frienduid`) values('J', 48431849, null, 48431849)

09-01 21:44:37 
3ms
replace into  `wx_friend_meta`(`uid`, `touid`, `fidkey`) values(48431849, 48431849, '48431849_48431849')

09-01 21:44:37 
1ms
insert ignore into  `wx_chat_user_item`(`linkflag`, `uid`, `chatlinkid`, `chatmode`, `linkid`, `tochatlinkmetaid`, `bizid`, `fidkey`, `chatlinkmetaid`, `tochatlinkid`) values(1, 48431849, null, 1, 2251, null, 48431849, '48431849_48431849', null, null)

09-01 21:44:37 
2ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 48431849, 1, 2)

09-01 21:44:37 
6ms
insert ignore into  `user_register_stat`(`statbizid`, `statbizstr`, `type`) values(4861, '172.20.10.2', 2)

09-01 21:44:37 
8ms
insert ignore into  `user_register_stat`(`statbizid`, `statbizstr`, `type`) values(4861, '20220901', 3)

09-01 21:44:37 
8ms
update user_register_stat set regcount = regcount + 1 where (type = 1 and statbizstr = '20220901') or (type = 2 and statbizstr = '172.20.10.2') or (type = 3 and statbizstr = '20220901' and statbizid = 4861) 

09-01 21:44:40 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:44:40', 1, 1, 0)

09-01 21:44:45 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:44:45', 1, 1, 0)

09-01 21:44:50 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:44:50', 1, 1, 0)

09-01 21:44:55 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:44:55', 1, 1, 0)

09-01 21:45:00 
12ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:45:00 
15ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:45:00', 1, 1, 0)

09-01 21:45:05 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:45:05', 1, 1, 0)

09-01 21:45:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:45:10', 1, 1, 0)

09-01 21:45:15 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:45:15', 1, 1, 0)

09-01 21:45:20 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:45:20', 1, 1, 0)

09-01 21:45:25 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:45:25', 1, 1, 0)

09-01 21:45:27 
43ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1414, 2, '127.0.0.1', 471.3333333333333, '2022-09-01 21:42:39', 3, 120, 0, 168866, 4, 4857, 12, 2, 2, '2分48秒866毫秒', 0.6666666666666666, 910, 0, 1414)

09-01 21:45:30 
14ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:45:30 
17ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:45:30', 1, 1, 0)

09-01 21:45:35 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:45:35', 1, 1, 0)

09-01 21:45:37 
9ms
delete from user_token where uid=98708001 and devicetype=1 and token='15165437323250812231226964992'

09-01 21:45:37 
4ms
update chatroom_join_leave set leavetime = '2022-09-01 21:45:37', cost = 445414, status = 1 where id = 22865

09-01 21:45:40 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:45:40', 0, 0, 0)

09-01 21:45:45 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:45:45', 0, 0, 0)

09-01 21:45:50 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:45:50', 0, 0, 0)

09-01 21:45:50 
9ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(10582, 8, '127.0.0.1', 423.28, '2022-09-01 21:43:49', 25, 120, 0, 120492, 32, 4861, 12, 16, 16, '2分492毫秒', 0.64, 158813, 0, 10582)

09-01 21:45:50 
8ms
insert into  `login_log`(`ip`, `appversion`, `sessionid`, `type`, `devicetype`, `hourperiod`, `uid`, `ipid`, `imei`, `time`, `deviceinfo`, `dayperiod`, `timeperiod`) values('172.20.10.2', '3.1', '15165437325152830433044474880', 1, 3, '21', 48431849, 4861, 'a658aec1bd9a411aba1b78d9af8af44c', '2022-09-01 21:45:50', '主-x86_64', '20220901', '21:45')

09-01 21:45:50 
8ms
replace into  `user_last_login_time`(`uid`) values(48431849)

09-01 21:45:50 
8ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 5839, 2, 2)

09-01 21:45:50 
2ms
insert ignore into  `user_ip_login_stat`(`uid`, `totalcount`, `ipid`, `ip`, `dayperiod`) values(48431849, 0, 4861, '172.20.10.2', '20220901')

09-01 21:45:50 
7ms
insert into  `user_token`(`uid`, `devicetype`, `token`) values(48431849, 5, '15165437325152830433044474880')

09-01 21:45:50 
2ms
update user_ip_login_stat set totalcount = totalcount + 1,hour1 = hour1 + 1 where ip = '172.20.10.2' and uid = 48431849 and dayperiod = '20220901'

09-01 21:45:50 
3ms
delete from wx_syn_item where uid = 48431849 and devicetype = 5

09-01 21:45:50 
2ms
update user_ip_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = 3550

09-01 21:45:50 
3ms
update user_ip_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = 3551

09-01 21:45:50 
2ms
insert ignore into  `user_time_login_stat`(`uid`, `totalcount`, `usercount`, `dayperiod`) values(48431849, 0, 1, '20220901')

09-01 21:45:50 
3ms
update user_time_login_stat set totalcount = totalcount + 1,hour21 = hour21 + 1 where uid = 48431849 and dayperiod = '20220901'

09-01 21:45:50 
2ms
insert ignore into  `user_time_login_stat`(`uid`, `totalcount`, `usercount`, `remark`, `dayperiod`) values(48431849, 1, 1, '用户总统计', '-1')

09-01 21:45:50 
2ms
update user_time_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = 1742

09-01 21:45:50 
7ms
update `tio_thread_logs` set `status` = 1  where `id` = 6406

09-01 21:45:54 
10ms
insert into  `login_log`(`hourperiod`, `uid`, `uaid`, `ipid`, `ip`, `time`, `sessionid`, `type`, `deviceinfo`, `devicetype`, `dayperiod`, `timeperiod`) values('21', 23026121, 313, 4860, '172.20.10.4', '2022-09-01 21:45:54', '15165437325154814931495218176', 1, '主-Unknown ??/Chrome 104', 1, '20220901', '21:45')

09-01 21:45:54 
6ms
replace into  `user_last_login_time`(`uid`) values(23026121)

09-01 21:45:54 
7ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 5840, 2, 2)

09-01 21:45:54 
2ms
insert ignore into  `user_ip_login_stat`(`uid`, `totalcount`, `ipid`, `ip`, `dayperiod`) values(23026121, 0, 4860, '172.20.10.4', '20220901')

09-01 21:45:54 
6ms
insert into  `user_token`(`uid`, `devicetype`, `token`) values(23026121, 1, '15165437325154814931495218176')

09-01 21:45:54 
3ms
update user_ip_login_stat set totalcount = totalcount + 1,hour1 = hour1 + 1 where ip = '172.20.10.4' and uid = 23026121 and dayperiod = '20220901'

09-01 21:45:54 
3ms
update user_ip_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = 3553

09-01 21:45:54 
2ms
update user_ip_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = 3554

09-01 21:45:54 
3ms
insert ignore into  `user_time_login_stat`(`uid`, `totalcount`, `usercount`, `dayperiod`) values(23026121, 0, 1, '20220901')

09-01 21:45:55 
3ms
update user_time_login_stat set totalcount = totalcount + 1,hour21 = hour21 + 1 where uid = 23026121 and dayperiod = '20220901'

09-01 21:45:55 
3ms
insert ignore into  `user_time_login_stat`(`uid`, `totalcount`, `usercount`, `remark`, `dayperiod`) values(23026121, 1, 1, '用户总统计', '-1')

09-01 21:45:55 
2ms
update user_time_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = 1742

09-01 21:45:55 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:45:55', 0, 0, 0)

09-01 21:45:55 
7ms
update `tio_thread_logs` set `status` = 1  where `id` = 6407

09-01 21:45:55 
5ms
insert into  `chatroom_join_leave`(`uid`, `server`, `ipid`, `jointime`, `session`, `groupid`, `device`, `status`) values(23026121, '127.0.0.1', 4857, '2022-09-01 21:45:55', '15165437325154814931495218176', '/login', 1, 9)

09-01 21:46:00 
16ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:46:00', 1, 1, 0)

09-01 21:46:00 
22ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:46:05 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:46:05', 1, 1, 0)

09-01 21:46:10 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:46:10', 1, 1, 0)

09-01 21:46:15 
9ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(18857, 23, '127.0.0.1', 819.8695652173913, '2022-09-01 21:44:03', 23, 120, 0, 131850, 46, 4860, 12, 23, 23, '2分11秒850毫秒', 1.0, 8493, 0, 18857)

09-01 21:46:15 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:46:15', 1, 1, 0)

09-01 21:46:20 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:46:20', 1, 1, 0)

09-01 21:46:20 
8ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1158, 1, '127.0.0.1', 26.318181818181817, '2022-09-01 21:44:17', 44, 120, 1, 122428, 14, 4857, 1, 44, 44, '2分2秒428毫秒', 1.0, 450, 0, 1158)

09-01 21:46:25 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:46:25', 1, 1, 0)

09-01 21:46:30 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:46:30', 1, 1, 0)

09-01 21:46:30 
14ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:46:35 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:46:35', 1, 1, 0)

09-01 21:46:40 
52ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:46:40', 1, 1, 0)

09-01 21:46:45 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:46:45', 1, 1, 0)

09-01 21:46:50 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:46:50', 1, 1, 0)

09-01 21:46:55 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:46:55', 1, 1, 0)

09-01 21:47:00 
17ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:47:00', 1, 1, 0)

09-01 21:47:00 
23ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:47:05 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:47:05', 1, 1, 0)

09-01 21:47:10 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:47:10', 1, 1, 0)

09-01 21:47:15 
14ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:47:15', 1, 1, 0)

09-01 21:47:20 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:47:20', 1, 1, 0)

09-01 21:47:25 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:47:25', 1, 1, 0)

09-01 21:47:30 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:47:30', 1, 1, 0)

09-01 21:47:30 
11ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:47:35 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:47:35', 1, 1, 0)

09-01 21:47:40 
38ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:47:40', 1, 1, 0)

09-01 21:47:45 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:47:45', 1, 1, 0)

09-01 21:47:50 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:47:50', 1, 1, 0)

09-01 21:47:50 
12ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(19300, 16, '127.0.0.1', 386.0, '2022-09-01 21:45:50', 50, 120, 0, 120168, 60, 4861, 12, 30, 30, '2分168毫秒', 0.6, 16316, 0, 19300)

09-01 21:47:50 
6ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(0, 0, '127.0.0.1', 0.0, '2022-09-01 21:45:30', 0, 120, 0, 140563, 0, 4857, 12, 0, 0, '2分20秒563毫秒', 0.0, 0, 0, 0)

09-01 21:47:55 
51ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:47:55', 1, 1, 0)

09-01 21:48:00 
14ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:48:00', 1, 1, 0)

09-01 21:48:00 
22ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:48:05 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:48:05', 1, 1, 0)

09-01 21:48:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:48:10', 1, 1, 0)

09-01 21:48:15 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:48:15', 1, 1, 0)

09-01 21:48:20 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:48:20', 1, 1, 0)

09-01 21:48:21 
10ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(528, 0, '127.0.0.1', 11.0, '2022-09-01 21:46:20', 48, 120, 1, 120888, 0, 4857, 1, 48, 48, '2分888毫秒', 1.0, 0, 0, 528)

09-01 21:48:25 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:48:25', 1, 1, 0)

09-01 21:48:29 
9ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(12953, 16, '127.0.0.1', 809.5625, '2022-09-01 21:46:14', 16, 120, 0, 134977, 32, 4860, 12, 16, 16, '2分14秒977毫秒', 1.0, 5072, 0, 12953)

09-01 21:48:30 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:48:30', 1, 1, 0)

09-01 21:48:30 
14ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:48:35 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:48:35', 1, 1, 0)

09-01 21:48:40 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:48:40', 1, 1, 0)

09-01 21:48:45 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:48:45', 1, 1, 0)

09-01 21:48:45 
43ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '127.0.0.1', 2, '2022-09-01 21:42:39', 300, 366461, 162.0, null, 4857, 8, '6分6秒461毫秒', 0.005457606675744486, 324)

09-01 21:48:45 
48ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(49, '127.0.0.1', '172.20.10.2', 2, '2022-09-01 21:43:32', 300, 312735, 76.53061224489795, null, 4861, 8, '5分12秒735毫秒', 0.15668217500439668, 3750)

09-01 21:48:45 
batch params_list:1, 9ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '127.0.0.1', 2, '2022-09-01 21:42:39', 300, 366492, 'api', 162.0, '/register/submit', 4857, 8, '6分6秒492毫秒', 0.005457145040000873, 324);


09-01 21:48:45 
batch params_list:19, 84ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:43:54', 300, 290991, 'api', 16.0, '/anjiCaptcha/check', 4861, 8, '4分50秒991毫秒', 0.003436532401345746, 16);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:45:47', 300, 177982, 'api', 91.0, '/user/search2', 4861, 8, '2分57秒982毫秒', 0.005618545695632142, 91);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:45:50', 300, 175119, 'api', 107.0, '/login', 4861, 8, '2分55秒119毫秒', 0.0057104026404901816, 107);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:43:56', 300, 288838, 'api', 1025.0, '/sms/send', 4861, 8, '4分48秒838毫秒', 0.003462148332283148, 1025);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(9, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:45:28', 300, 197618, 'api', 3.5555555555555554, '/chat/applyData', 4861, 8, '3分17秒618毫秒', 0.04554241010434272, 32);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:45:29', 300, 195878, 'api', 0.0, '/im/imserver', 4861, 8, '3分15秒878毫秒', 0.020420874217625257, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:45:28', 300, 197602, 'api', 15.666666666666666, '/chat/getLastAllNotice', 4861, 8, '3分17秒602毫秒', 0.015182032570520542, 47);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:44:37', 300, 248594, 'api', 618.0, '/register/submit', 4861, 8, '4分8秒594毫秒', 0.004022623233062745, 618);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:43:50', 300, 295686, 'api', 46.0, '/sms/beforeCheck', 4861, 8, '4分55秒686毫秒', 0.003381966004477723, 46);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:45:28', 300, 197618, 'api', 4.0, '/user/curr', 4861, 8, '3分17秒618毫秒', 0.020241071157485652, 16);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:43:51', 300, 294322, 'api', 1332.0, '/anjiCaptcha/get', 4861, 8, '4分54秒322毫秒', 0.0033976393202003246, 1332);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:47:10', 300, 95391, 'api', 0.0, '/chat/mailList', 4861, 8, '1分35秒391毫秒', 0.010483169271734231, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:46:48', 300, 116890, 'api', 16.0, '/chat/isFriend', 4861, 8, '1分56秒890毫秒', 0.008555051758063136, 16);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(9, '127.0.0.1', '172.20.10.2', 2, '2022-09-01 21:43:32', 300, 312782, 'api', 25.88888888888889, '/config/base', 4861, 8, '5分12秒782毫秒', 0.02877403431143736, 233);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:46:48', 300, 116798, 'api', 61.0, '/chat/checkAddFriend', 4861, 8, '1分56秒798毫秒', 0.00856179044161715, 61);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:46:58', 300, 107606, 'api', 16.0, '/chat/applyList', 4861, 8, '1分47秒606毫秒', 0.009293162091333197, 16);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:43:33', 300, 312442, 'api', 8.0, '/sys/version', 4861, 8, '5分12秒442毫秒', 0.012802376121008058, 32);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:45:28', 300, 197045, 'api', 0.0, '/chat/queryOnline', 4861, 8, '3分17秒45毫秒', 0.020299931487731227, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:46:50', 300, 114859, 'api', 62.0, '/chat/friendApply', 4861, 8, '1分54秒859毫秒', 0.008706326887749328, 62);


09-01 21:48:50 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:48:50', 1, 1, 0)

09-01 21:48:55 
25ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:48:55', 1, 1, 0)

09-01 21:49:00 
15ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:49:00', 1, 1, 0)

09-01 21:49:00 
18ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:49:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:49:05', 1, 1, 0)

09-01 21:49:10 
22ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:49:10', 1, 1, 0)

09-01 21:49:15 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:49:15', 1, 1, 0)

09-01 21:49:20 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:49:20', 1, 1, 0)

09-01 21:49:25 
60ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:49:25', 1, 1, 0)

09-01 21:49:30 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:49:30', 1, 1, 0)

09-01 21:49:30 
7ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:49:35 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:49:35', 1, 1, 0)

09-01 21:49:37 
8ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(42, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:44:03', 300, 334396, 7.809523809523809, null, 4860, 8, '5分34秒396毫秒', 0.12559958851182432, 328)

09-01 21:49:37 
batch params_list:16, 80ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:45:55', 300, 222489, 'api', 8.0, '/chat/list', 4860, 8, '3分42秒489毫秒', 0.008989208455249472, 16);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:45:54', 300, 222551, 'api', 107.0, '/login', 4860, 8, '3分42秒551毫秒', 0.004493352085589371, 107);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:44:15', 300, 322440, 'api', 0.0, '/chat/actChat', 4860, 8, '5分22秒440毫秒', 0.009304056568663937, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:45:37', 300, 239703, 'api', 13.0, '/logout', 4860, 8, '3分59秒703毫秒', 0.004171829305432139, 13);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:45:55', 300, 222444, 'api', 0.0, '/chat/applyData', 4860, 8, '3分42秒444毫秒', 0.004495513477549406, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:45:55', 300, 222505, 'api', 0.0, '/im/imserver', 4860, 8, '3分42秒505毫秒', 0.004494281027392643, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:45:55', 300, 222141, 'api', 20.0, '/chat/getLastAllNotice', 4860, 8, '3分42秒141毫秒', 0.004501645351375928, 20);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:45:55', 300, 222116, 'api', 13.666666666666666, '/friendGroup/list', 4860, 8, '3分42秒116毫秒', 0.013506456086009113, 41);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:45:38', 300, 238782, 'api', 0.0, '/user/curr', 4860, 8, '3分58秒782毫秒', 0.020939601812531933, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:46:17', 300, 200307, 'api', 16.0, '/user/info', 4860, 8, '3分20秒307毫秒', 0.004992336763068689, 16);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(11, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:45:55', 300, 222141, 'api', 6.363636363636363, '/chat/mailList', 4860, 8, '3分42秒141毫秒', 0.0495180988651352, 70);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:44:03', 300, 334396, 'api', 0.0, '/chat/isFriend', 4860, 8, '5分34秒396毫秒', 0.002990466393138674, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:45:55', 300, 222141, 'api', 0.0, '/config/query', 4860, 8, '3分42秒141毫秒', 0.022508226756879638, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:46:33', 300, 184084, 'api', 5.333333333333333, '/user/search', 4860, 8, '3分4秒84毫秒', 0.01629690793333478, 16);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:46:15', 300, 202376, 'api', 14.5, '/chat/applyList', 4860, 8, '3分22秒376毫秒', 0.009882594774083884, 29);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:45:38', 300, 238751, 'api', 0.0, '/config/viewmodel', 4860, 8, '3分58秒751毫秒', 0.004188464132087405, 0);


09-01 21:49:40 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:49:40', 1, 1, 0)

09-01 21:49:45 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:49:45', 1, 1, 0)

09-01 21:49:46 
11ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(9, '127.0.0.1', '172.20.10.4', '2022-09-01 21:44:03', 300, '15165437323250812231226964992', 343770, 98708001, 13.333333333333334, null, 4860, 8, '5分43秒770毫秒', 0.0261802949646566, 120)

09-01 21:49:46 
7ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(7, '127.0.0.1', '172.20.10.2', '2022-09-01 21:43:33', 300, '15165437324554856635669169152', 373647, 451.42857142857144, null, 4861, 8, '6分13秒647毫秒', 0.01873425987630036, 3160)

09-01 21:49:46 
batch params_list:6, 36ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:44:03', 300, '15165437323250812231226964992', 343785, 'api', 98708001, 0.0, '/chat/isFriend', 4860, 8, '5分43秒785毫秒', 0.0029087947408991087, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:45:54', 300, '15165437323250812231226964992', 231940, 'api', 98708001, 107.0, '/login', 4860, 8, '3分51秒940毫秒', 0.0043114598603087, 107);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.4', '2022-09-01 21:44:15', 300, '15165437323250812231226964992', 331829, 'api', 98708001, 0.0, '/chat/actChat', 4860, 8, '5分31秒829毫秒', 0.009040801135524622, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:45:37', 300, '15165437323250812231226964992', 249092, 'api', 98708001, 13.0, '/logout', 4860, 8, '4分9秒92毫秒', 0.0040145809580396, 13);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', '2022-09-01 21:45:38', 300, '15165437323250812231226964992', 248171, 'api', 98708001, 0.0, '/user/curr', 4860, 8, '4分8秒171毫秒', 0.008058959346579577, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:45:38', 300, '15165437323250812231226964992', 248140, 'api', 98708001, 0.0, '/config/viewmodel', 4860, 8, '4分8秒140毫秒', 0.004029983074071089, 0);


09-01 21:49:46 
batch params_list:7, 34ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:43:54', 300, '15165437324554856635669169152', 352226, 'api', 16.0, '/anjiCaptcha/check', 4861, 8, '5分52秒226毫秒', 0.0028390862684753537, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:50', 300, '15165437324554856635669169152', 236354, 'api', 107.0, '/login', 4861, 8, '3分56秒354毫秒', 0.004230941723008707, 107);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:43:56', 300, '15165437324554856635669169152', 350073, 'api', 1025.0, '/sms/send', 4861, 8, '5分50秒73毫秒', 0.002856547063041137, 1025);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:44:37', 300, '15165437324554856635669169152', 309829, 'api', 618.0, '/register/submit', 4861, 8, '5分9秒829毫秒', 0.003227586830154698, 618);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:43:50', 300, '15165437324554856635669169152', 356921, 'api', 46.0, '/sms/beforeCheck', 4861, 8, '5分56秒921毫秒', 0.00280174044116205, 46);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:43:33', 300, '15165437324554856635669169152', 373677, 'api', 16.0, '/sys/version', 4861, 8, '6分13秒677毫秒', 0.0026761079756045998, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:43:51', 300, '15165437324554856635669169152', 355557, 'api', 1332.0, '/anjiCaptcha/get', 4861, 8, '5分55秒557毫秒', 0.0028124885742651672, 1332);


09-01 21:49:50 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:49:50', 1, 1, 0)

09-01 21:49:52 
9ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(0, 0, '127.0.0.1', 0.0, '2022-09-01 21:47:50', 0, 120, 0, 121759, 0, 4857, 12, 0, 0, '2分1秒759毫秒', 0.0, 0, 0, 0)

09-01 21:49:55 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:49:55', 1, 1, 0)

09-01 21:50:00 
12ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:50:00 
19ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:50:00', 1, 1, 0)

09-01 21:50:01 
3ms
insert into  `wx_chat_items`(`linkflag`, `uid`, `chatmode`, `linkid`, `bizid`, `name`, `avatar`, `fidkey`) values(1, 23026121, 1, 2250, 23026121, '13499999999', '/user/base/avatar/2021080826/0953001424186851396296704.png', '23026121_23026121')

09-01 21:50:01 
4ms
insert into  `wx_chat_items_meta`(`chatuptime`, `lastmsgid`, `notreadstartmsgid`, `lastmsguid`, `readflag`, `chatlinkid`, `sysflag`, `msgresume`, `fromnick`, `notreadcount`, `toreadflag`, `sendtime`, `viewflag`) values('2022-09-01 21:50:01', null, null, null, 1, 3173, 2, '', '', 0, null, null, 1)

09-01 21:50:01 
3ms
	update wx_chat_user_item 
	set 
			tochatlinkid = 3173,
			tochatlinkmetaid = 3173,
		-- 以下两个为互斥
			chatlinkid = 3173,
			chatlinkmetaid = 3173
	where uid = 23026121 and chatmode = 1 and bizid = 23026121 


09-01 21:50:01 
8ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('激活聊天会话：3173', null, 23026121, '15165437325154814931495218176', '', 1, 1, 2, 23026121, 4860, 1, null, '23026121_23026121', 4, '激活聊天会话：3173', '2022-09-01 21:50:01', 23026121, 1, 2, 1)

09-01 21:50:02 
2ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3173


09-01 21:50:02 
1ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3173


09-01 21:50:02 
2ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4857,
		readdevice = 1
	WHERE
		twouid = '23026121_23026121'
		and touid = 23026121
		and readflag = 2
		


09-01 21:50:02 
4ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 23026121, null, '', 1, 1, 2, 23026121, 4857, 1, null, '23026121_23026121', 7, '好友已读你的消息', '2022-09-01 21:50:02', 23026121, 1, 2, 1)

09-01 21:50:02 
9ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(23026121, 3173, 23026121, 2, 1)

09-01 21:50:05 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:50:05', 1, 1, 0)

09-01 21:50:10 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:50:10', 1, 1, 0)

09-01 21:50:15 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:50:15', 1, 1, 0)

09-01 21:50:20 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:50:20', 1, 1, 0)

09-01 21:50:21 
40ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(703, 0, '127.0.0.1', 13.784313725490197, '2022-09-01 21:48:21', 51, 120, 1, 120001, 14, 4857, 1, 51, 51, '2分1毫秒', 1.0, 881, 0, 703)

09-01 21:50:25 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:50:25', 1, 1, 0)

09-01 21:50:30 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:50:30', 1, 1, 0)

09-01 21:50:30 
7ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:50:35 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:50:35', 1, 1, 0)

09-01 21:50:40 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:50:40', 1, 1, 0)

09-01 21:50:45 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:50:45', 1, 1, 0)

09-01 21:50:50 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:50:50', 1, 1, 0)

09-01 21:50:50 
40ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(32001, 39, '127.0.0.1', 820.5384615384615, '2022-09-01 21:48:29', 39, 120, 0, 140863, 78, 4860, 12, 39, 39, '2分20秒863毫秒', 1.0, 15009, 0, 32001)

09-01 21:50:50 
10ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1959, 1, '127.0.0.1', 326.5, '2022-09-01 21:48:45', 6, 120, 0, 125211, 6, 4861, 12, 3, 3, '2分5秒211毫秒', 0.5, 583, 0, 1959)

09-01 21:50:50 
7ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(26, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:50', 300, '15165437325152830433044474880', 300306, 48431849, 6.6923076923076925, null, 4861, 8, '5分306毫秒', 0.08657835674278902, 174)

09-01 21:50:50 
9ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(17, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:28', 300, '15165437323156852135218865152', 322898, 98708001, 19.058823529411764, null, 4861, 8, '5分22秒898毫秒', 0.052648204696219864, 324)

09-01 21:50:51 
batch params_list:9, 43ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:47:10', 300, '15165437325152830433044474880', 220671, 'api', 48431849, 0.0, '/chat/mailList', 4861, 8, '3分40秒671毫秒', 0.004531633064607492, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:50', 300, '15165437325152830433044474880', 300227, 'api', 48431849, 15.8, '/config/base', 4861, 8, '5分227毫秒', 0.016654065090748002, 79);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(6, '127.0.0.1', '172.20.10.2', '2022-09-01 21:46:25', 300, '15165437325152830433044474880', 265349, 'api', 48431849, 5.333333333333333, '/chat/applyData', 4861, 8, '4分25秒349毫秒', 0.0226117302119096, 32);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:50', 300, '15165437325152830433044474880', 300087, 'api', 48431849, 0.0, '/im/imserver', 4861, 8, '5分87毫秒', 0.00999710084075618, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', '2022-09-01 21:46:25', 300, '15165437325152830433044474880', 265318, 'api', 48431849, 15.5, '/chat/getLastAllNotice', 4861, 8, '4分25秒318毫秒', 0.0075381240624458196, 31);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:50', 300, '15165437325152830433044474880', 300306, 'api', 48431849, 5.333333333333333, '/user/curr', 4861, 8, '5分306毫秒', 0.009989810393398732, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:46:58', 300, '15165437325152830433044474880', 232886, 'api', 48431849, 16.0, '/chat/applyList', 4861, 8, '3分52秒886毫秒', 0.004293946394373213, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', '2022-09-01 21:46:26', 300, '15165437325152830433044474880', 264714, 'api', 48431849, 0.0, '/sys/version', 4861, 8, '4分24秒714毫秒', 0.0075553238589572145, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.2', '2022-09-01 21:46:25', 300, '15165437325152830433044474880', 265194, 'api', 48431849, 0.0, '/chat/queryOnline', 4861, 8, '4分25秒194毫秒', 0.01131247313287631, 0);


09-01 21:50:51 
batch params_list:11, 49ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', '2022-09-01 21:46:48', 300, '15165437323156852135218865152', 242170, 'api', 98708001, 15.5, '/chat/isFriend', 4861, 8, '4分2秒170毫秒', 0.008258661271007968, 31);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:47', 300, '15165437323156852135218865152', 303262, 'api', 98708001, 91.0, '/user/search2', 4861, 8, '5分3秒262毫秒', 0.003297478747749471, 91);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:28', 300, '15165437323156852135218865152', 322882, 'api', 98708001, 16.0, '/config/base', 4861, 8, '5分22秒882毫秒', 0.006194213365873601, 32);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:28', 300, '15165437323156852135218865152', 322898, 'api', 98708001, 0.0, '/chat/applyData', 4861, 8, '5分22秒898毫秒', 0.009290859652274093, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:29', 300, '15165437323156852135218865152', 321158, 'api', 98708001, 0.0, '/im/imserver', 4861, 8, '5分21秒158毫秒', 0.0031137321816675904, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:28', 300, '15165437323156852135218865152', 322882, 'api', 98708001, 16.0, '/chat/getLastAllNotice', 4861, 8, '5分22秒882毫秒', 0.0030971066829368005, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', '2022-09-01 21:46:48', 300, '15165437323156852135218865152', 242078, 'api', 98708001, 38.0, '/chat/checkAddFriend', 4861, 8, '4分2秒78毫秒', 0.00826179991572964, 76);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:28', 300, '15165437323156852135218865152', 322898, 'api', 98708001, 0.0, '/user/curr', 4861, 8, '5分22秒898毫秒', 0.0030969532174246975, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:28', 300, '15165437323156852135218865152', 321999, 'api', 98708001, 16.0, '/sys/version', 4861, 8, '5分21秒999毫秒', 0.003105599706831388, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:45:28', 300, '15165437323156852135218865152', 322325, 'api', 98708001, 0.0, '/chat/queryOnline', 4861, 8, '5分22秒325毫秒', 0.0031024586985185757, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', '2022-09-01 21:46:50', 300, '15165437323156852135218865152', 240139, 'api', 98708001, 31.0, '/chat/friendApply', 4861, 8, '4分139毫秒', 0.00832850973811001, 62);


09-01 21:50:55 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:50:55', 1, 1, 0)

09-01 21:50:57 
11ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(75, '127.0.0.1', '172.20.10.4', '2022-09-01 21:45:54', 300, '15165437325154814931495218176', 302676, 23026121, 21.36, null, 4860, 8, '5分2秒676毫秒', 0.24778971573563813, 1602)

09-01 21:50:57 
batch params_list:13, 69ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.4', '2022-09-01 21:45:55', 300, '15165437325154814931495218176', 302645, 'api', 23026121, 4.0, '/chat/list', 4860, 8, '5分2秒645毫秒', 0.01321680516777082, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:50:01', 300, '15165437325154814931495218176', 56149, 'api', 23026121, 30.0, '/chat/actChat', 4860, 8, '56秒149毫秒', 0.017809756184437836, 30);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', '2022-09-01 21:45:55', 300, '15165437325154814931495218176', 302600, 'api', 23026121, 7.5, '/chat/applyData', 4860, 8, '5分2秒600毫秒', 0.006609385327164574, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:45:55', 300, '15165437325154814931495218176', 302661, 'api', 23026121, 0.0, '/im/imserver', 4860, 8, '5分2秒661毫秒', 0.003304026617238428, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', '2022-09-01 21:45:55', 300, '15165437325154814931495218176', 302297, 'api', 23026121, 33.0, '/chat/getLastAllNotice', 4860, 8, '5分2秒297毫秒', 0.006616010082799366, 66);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(7, '127.0.0.1', '172.20.10.4', '2022-09-01 21:45:55', 300, '15165437325154814931495218176', 302272, 'api', 23026121, 10.142857142857142, '/friendGroup/list', 4860, 8, '5分2秒272毫秒', 0.02315795045521914, 71);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(7, '127.0.0.1', '172.20.10.4', '2022-09-01 21:45:54', 300, '15165437325154814931495218176', 302691, 'api', 23026121, 0.0, '/user/curr', 4860, 8, '5分2秒691毫秒', 0.023125894063582994, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:46:17', 300, '15165437325154814931495218176', 280463, 'api', 23026121, 16.0, '/user/info', 4860, 8, '4分40秒463毫秒', 0.003565532708414301, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(32, '127.0.0.1', '172.20.10.4', '2022-09-01 21:45:55', 300, '15165437325154814931495218176', 302297, 'api', 23026121, 39.53125, '/chat/mailList', 4860, 8, '5分2秒297毫秒', 0.10585616132478985, 1265);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(10, '127.0.0.1', '172.20.10.4', '2022-09-01 21:45:55', 300, '15165437325154814931495218176', 302297, 'api', 23026121, 6.2, '/config/query', 4860, 8, '5分2秒297毫秒', 0.03308005041399683, 62);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '127.0.0.1', '172.20.10.4', '2022-09-01 21:46:33', 300, '15165437325154814931495218176', 264240, 'api', 23026121, 5.333333333333333, '/user/search', 4860, 8, '4分24秒240毫秒', 0.011353315168029064, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.4', '2022-09-01 21:46:15', 300, '15165437325154814931495218176', 282532, 'api', 23026121, 11.25, '/chat/applyList', 4860, 8, '4分42秒532毫秒', 0.014157688332649045, 45);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:50:01', 300, '15165437325154814931495218176', 55716, 'api', 23026121, 0.0, '/chat/queryOnline', 4860, 8, '55秒716毫秒', 0.01794816569746572, 0);


09-01 21:51:00 
42ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:51:00 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:51:00', 1, 1, 0)

09-01 21:51:05 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:51:05', 1, 1, 0)

09-01 21:51:10 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:51:10', 1, 1, 0)

09-01 21:51:15 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:51:15', 1, 1, 0)

09-01 21:51:20 
40ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:51:20', 1, 1, 0)

09-01 21:51:25 
17ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:51:25', 1, 1, 0)

09-01 21:51:30 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:51:30', 1, 1, 0)

09-01 21:51:30 
50ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:51:35 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:51:35', 1, 1, 0)

09-01 21:51:38 
2ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3173


09-01 21:51:38 
3ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3173


09-01 21:51:38 
2ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4857,
		readdevice = 1
	WHERE
		twouid = '23026121_23026121'
		and touid = 23026121
		and readflag = 2
		


09-01 21:51:38 
5ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 23026121, null, '', 1, 1, 2, 23026121, 4857, 1, null, '23026121_23026121', 7, '好友已读你的消息', '2022-09-01 21:51:38', 23026121, 1, 2, 1)

09-01 21:51:38 
9ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(23026121, 3173, 23026121, 2, 1)

09-01 21:51:40 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:51:40', 1, 1, 0)

09-01 21:51:45 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:51:45', 1, 1, 0)

09-01 21:51:50 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:51:50', 1, 1, 0)

09-01 21:51:55 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:51:55', 1, 1, 0)

09-01 21:51:56 
42ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(0, 0, '127.0.0.1', 0.0, '2022-09-01 21:49:52', 0, 120, 0, 124133, 0, 4857, 12, 0, 0, '2分4秒133毫秒', 0.0, 0, 0, 0)

09-01 21:52:00 
42ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:52:00 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:52:00', 1, 1, 0)

09-01 21:52:05 
16ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:52:05', 1, 1, 0)

09-01 21:52:10 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:52:10', 1, 1, 0)

09-01 21:52:15 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:52:15', 1, 1, 0)

09-01 21:52:20 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:52:20', 1, 1, 0)

09-01 21:52:23 
43ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(714, 0, '127.0.0.1', 14.0, '2022-09-01 21:50:21', 51, 120, 1, 121998, 12, 4857, 1, 52, 52, '2分1秒998毫秒', 1.0196078431372548, 561, 0, 714)

09-01 21:52:25 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:52:25', 1, 1, 0)

09-01 21:52:30 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:52:30', 1, 1, 0)

09-01 21:52:30 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:52:35 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:52:35', 1, 1, 0)

09-01 21:52:40 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:52:40', 1, 1, 0)

09-01 21:52:45 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:52:45', 1, 1, 0)

09-01 21:52:50 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:52:50', 1, 1, 0)

09-01 21:52:51 
41ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(33524, 41, '127.0.0.1', 817.6585365853658, '2022-09-01 21:50:50', 41, 120, 0, 120674, 82, 4860, 12, 41, 41, '2分674毫秒', 1.0, 14866, 0, 33524)

09-01 21:52:55 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:52:55', 1, 1, 0)

09-01 21:53:00 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:53:00', 1, 1, 0)

09-01 21:53:00 
49ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:53:05 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:53:05', 1, 1, 0)

09-01 21:53:10 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:53:10', 1, 1, 0)

09-01 21:53:15 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:53:15', 1, 1, 0)

09-01 21:53:20 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:53:20', 1, 1, 0)

09-01 21:53:25 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:53:25', 1, 1, 0)

09-01 21:53:30 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:53:30', 1, 1, 0)

09-01 21:53:30 
47ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:53:35 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:53:35', 1, 1, 0)

09-01 21:53:40 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:53:40', 1, 1, 0)

09-01 21:53:45 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:53:45', 1, 1, 0)

09-01 21:53:50 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:53:50', 1, 1, 0)

09-01 21:53:55 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:53:55', 1, 1, 0)

09-01 21:54:00 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:54:00', 1, 1, 0)

09-01 21:54:00 
52ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:54:05 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:54:05', 1, 1, 0)

09-01 21:54:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:54:10', 1, 1, 0)

09-01 21:54:13 
9ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(0, 0, '127.0.0.1', 0.0, '2022-09-01 21:51:56', 0, 120, 0, 136356, 0, 4857, 12, 0, 0, '2分16秒356毫秒', 0.0, 0, 0, 0)

09-01 21:54:13 
4ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(3325, 3, '127.0.0.1', 369.44444444444446, '2022-09-01 21:52:00', 9, 120, 0, 132071, 10, 4861, 12, 5, 5, '2分12秒71毫秒', 0.5555555555555556, 1170, 0, 3325)

09-01 21:54:15 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:54:15', 1, 1, 0)

09-01 21:54:20 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:54:20', 1, 1, 0)

09-01 21:54:25 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:54:25', 1, 1, 0)

09-01 21:54:25 
46ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(539, 0, '127.0.0.1', 11.0, '2022-09-01 21:52:23', 49, 120, 1, 122116, 0, 4857, 1, 49, 49, '2分2秒116毫秒', 1.0, 0, 0, 539)

09-01 21:54:30 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:54:30', 1, 1, 0)

09-01 21:54:30 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:54:35 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:54:35', 1, 1, 0)

09-01 21:54:40 
16ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:54:40', 1, 1, 0)

09-01 21:54:45 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:54:45', 1, 1, 0)

09-01 21:54:50 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:54:50', 1, 1, 0)

09-01 21:54:55 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:54:55', 1, 1, 0)

09-01 21:55:00 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:55:00', 1, 1, 0)

09-01 21:55:00 
9ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:55:05 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:55:05', 1, 1, 0)

09-01 21:55:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:55:10', 1, 1, 0)

09-01 21:55:15 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:55:15', 1, 1, 0)

09-01 21:55:20 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:55:20', 1, 1, 0)

09-01 21:55:25 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:55:25', 1, 1, 0)

09-01 21:55:30 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:55:30', 1, 1, 0)

09-01 21:55:30 
43ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:55:35 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:55:35', 1, 1, 0)

09-01 21:55:40 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:55:40', 1, 1, 0)

09-01 21:55:45 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:55:45', 1, 1, 0)

09-01 21:55:47 
6ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(8, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:48:45', 300, 421326, 9.5, null, 4861, 8, '7分1秒326毫秒', 0.018987672253789226, 76)

09-01 21:55:47 
3ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(79, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:49:37', 300, 369448, 22.17721518987342, null, 4860, 8, '6分9秒448毫秒', 0.21383252852904874, 1752)

09-01 21:55:47 
3ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1664, 2, '127.0.0.1', 832.0, '2022-09-01 21:52:58', 2, 120, 0, 168481, 4, 4860, 12, 2, 2, '2分48秒481毫秒', 1.0, 580, 0, 1664)

09-01 21:55:47 
batch params_list:5, 22ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:48:45', 300, 421350, 'api', 15.0, '/chat/isFriend', 4861, 8, '7分1秒350毫秒', 0.004746647680075947, 30);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:52:22', 300, 204045, 'api', 16.0, '/user/search2', 4861, 8, '3分24秒45毫秒', 0.00490087970790757, 16);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:48:45', 300, 421071, 'api', 15.0, '/chat/checkAddFriend', 4861, 8, '7分1秒71毫秒', 0.004749792790289524, 30);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:48:47', 300, 419701, 'api', 0.0, '/chat/friendApply', 4861, 8, '6分59秒701毫秒', 0.0047652971996731, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', 0, '2022-09-01 21:52:00', 300, 226115, 'api', 0.0, '/chat/queryOnline', 4861, 8, '3分46秒115毫秒', 0.0044225283594631045, 0);


09-01 21:55:47 
batch params_list:11, 72ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(35, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:49:37', 300, 369472, 'api', 36.34285714285714, '/chat/mailList', 4860, 8, '6分9秒472毫秒', 0.09472977654598995, 1272);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:50:01', 300, 345418, 'api', 0.0, '/chat/list', 4860, 8, '5分45秒418毫秒', 0.011580172428767464, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:50:01', 300, 345465, 'api', 30.0, '/chat/actChat', 4860, 8, '5分45秒465毫秒', 0.0028946492408782366, 30);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:50:01', 300, 345356, 'api', 7.5, '/chat/applyData', 4860, 8, '5分45秒356毫秒', 0.005791125679009486, 15);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:50:01', 300, 345201, 'api', 46.0, '/chat/getLastAllNotice', 4860, 8, '5分45秒201毫秒', 0.005793725974142601, 92);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(10, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:50:01', 300, 345186, 'api', 19.7, '/config/query', 4860, 8, '5分45秒186毫秒', 0.028969888697687626, 197);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:51:56', 300, 230441, 'api', 6.8, '/user/search', 4860, 8, '3分50秒441毫秒', 0.021697527783684327, 34);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(7, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:49:57', 300, 349430, 'api', 9.0, '/friendGroup/list', 4860, 8, '5分49秒430毫秒', 0.02003262455999771, 63);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(7, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:49:57', 300, 349567, 'api', 0.0, '/user/curr', 4860, 8, '5分49秒567毫秒', 0.020024773505508246, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:49:57', 300, 349430, 'api', 12.25, '/chat/applyList', 4860, 8, '5分49秒430毫秒', 0.011447214034284406, 49);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', 0, '2022-09-01 21:50:01', 300, 345032, 'api', 0.0, '/chat/queryOnline', 4860, 8, '5分45秒32毫秒', 0.00579656379698115, 0);


09-01 21:55:47 
2ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3173


09-01 21:55:47 
2ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3173


09-01 21:55:47 
2ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4857,
		readdevice = 1
	WHERE
		twouid = '23026121_23026121'
		and touid = 23026121
		and readflag = 2
		


09-01 21:55:47 
6ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 23026121, null, '', 1, 1, 2, 23026121, 4857, 1, null, '23026121_23026121', 7, '好友已读你的消息', '2022-09-01 21:55:47', 23026121, 1, 2, 1)

09-01 21:55:47 
9ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(23026121, 3173, 23026121, 2, 1)

09-01 21:55:50 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:55:50', 1, 1, 0)

09-01 21:55:55 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:55:55', 1, 1, 0)

09-01 21:56:00 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:56:00', 1, 1, 0)

09-01 21:56:00 
45ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:56:05 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:56:05', 1, 1, 0)

09-01 21:56:09 
7ms
update chatroom_join_leave set leavetime = '2022-09-01 21:56:08', cost = 613934, status = 1 where id = 22866

09-01 21:56:10 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 0, 0, '2022-09-01 21:56:10', 0, 0, 0)

09-01 21:56:10 
21ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(52, '127.0.0.1', '172.20.10.4', '2022-09-01 21:50:57', 300, '15165437325154814931495218176', 312352, 23026121, 9.711538461538462, null, 4860, 8, '5分12秒352毫秒', 0.1664788443806987, 505)

09-01 21:56:10 
batch params_list:11, 62ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(16, '127.0.0.1', '172.20.10.4', '2022-09-01 21:50:57', 300, '15165437325154814931495218176', 312383, 'api', 23026121, 5.75, '/chat/mailList', 4860, 8, '5分12秒383毫秒', 0.0512191764596665, 92);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.4', '2022-09-01 21:51:38', 300, '15165437325154814931495218176', 271518, 'api', 23026121, 4.0, '/chat/list', 4860, 8, '4分31秒518毫秒', 0.014731988302801287, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.4', '2022-09-01 21:55:46', 300, '15165437325154814931495218176', 23076, 'api', 23026121, 22.0, '/chat/actChat', 4860, 8, '23秒76毫秒', 0.04333506673600278, 22);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', '2022-09-01 21:51:38', 300, '15165437325154814931495218176', 271455, 'api', 23026121, 0.0, '/chat/applyData', 4860, 8, '4分31秒455毫秒', 0.007367703670958354, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', '2022-09-01 21:51:38', 300, '15165437325154814931495218176', 271316, 'api', 23026121, 54.0, '/chat/getLastAllNotice', 4860, 8, '4分31秒316毫秒', 0.00737147827625352, 108);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(10, '127.0.0.1', '172.20.10.4', '2022-09-01 21:51:38', 300, '15165437325154814931495218176', 271316, 'api', 23026121, 16.7, '/config/query', 4860, 8, '4分31秒316毫秒', 0.036857391381267604, 167);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '127.0.0.1', '172.20.10.4', '2022-09-01 21:51:56', 300, '15165437325154814931495218176', 253493, 'api', 23026121, 6.8, '/user/search', 4860, 8, '4分13秒493毫秒', 0.01972441053599113, 34);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.4', '2022-09-01 21:51:37', 300, '15165437325154814931495218176', 272587, 'api', 23026121, 8.25, '/friendGroup/list', 4860, 8, '4分32秒587毫秒', 0.014674214104120885, 33);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.4', '2022-09-01 21:51:37', 300, '15165437325154814931495218176', 272727, 'api', 23026121, 0.0, '/user/curr', 4860, 8, '4分32秒727毫秒', 0.014666681333348, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', '2022-09-01 21:51:37', 300, '15165437325154814931495218176', 272587, 'api', 23026121, 16.5, '/chat/applyList', 4860, 8, '4分32秒587毫秒', 0.007337107052060443, 33);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '127.0.0.1', '172.20.10.4', '2022-09-01 21:51:38', 300, '15165437325154814931495218176', 271224, 'api', 23026121, 0.0, '/chat/queryOnline', 4860, 8, '4分31秒224毫秒', 0.0073739787039495035, 0);


09-01 21:56:10 
7ms
insert into  `chatroom_join_leave`(`uid`, `server`, `ipid`, `jointime`, `session`, `groupid`, `device`, `status`) values(23026121, '127.0.0.1', 4857, '2022-09-01 21:56:10', '15165437325154814931495218176', '/home', 1, 9)

09-01 21:56:10 
2ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3173


09-01 21:56:10 
2ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3173


09-01 21:56:10 
2ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4857,
		readdevice = 1
	WHERE
		twouid = '23026121_23026121'
		and touid = 23026121
		and readflag = 2
		


09-01 21:56:11 
6ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 23026121, null, '', 1, 1, 2, 23026121, 4857, 1, null, '23026121_23026121', 7, '好友已读你的消息', '2022-09-01 21:56:10', 23026121, 1, 2, 1)

09-01 21:56:11 
8ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(23026121, 3173, 23026121, 2, 1)

09-01 21:56:13 
8ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(0, 0, '127.0.0.1', 0.0, '2022-09-01 21:54:12', 0, 120, 0, 120593, 0, 4857, 12, 0, 0, '2分593毫秒', 0.0, 0, 0, 0)

09-01 21:56:15 
19ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:56:15', 1, 1, 0)

09-01 21:56:15 
5ms
insert into  `wx_friend_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `readdevice`, `readipid`, `srctext`, `contenttype`, `readflag`, `uid`, `ipid`, `frommode`, `twouid`, `oper`, `text`, `time`, `readtime`, `sigleuid`, `device`, `msgtype`, `status`) values('1662040575599', null, 23026121, '', '1662040575599', 1, 1, 4857, '1662040575599', 1, 1, 23026121, 4858, null, '23026121_23026121', null, '1662040575599', '2022-09-01 21:56:15', '2022-09-01 21:56:15', -1, 99, 1, 1)

09-01 21:56:15 
3ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5315,
	 	lastmsguid = 23026121,
	 	fromnick = '13499999999',
	 	msgresume = '1662040575599',
	 	msgtype = 1,
	 	sysflag = 1,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 21:56:15'
	WHERE
		id = 3173


09-01 21:56:15 
3ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5315,
	 	lastmsguid = 23026121,
	 	fromnick = '13499999999',
	 	msgresume = '1662040575599',
	 	msgtype = 1,
	 	sysflag = 1,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 21:56:15'
	WHERE
		id = 3173


09-01 21:56:15 
3ms
	update wx_chat_user_item 
	set 
			startmsgid =  5315
	where uid = 23026121 and chatmode = 1 and bizid = 23026121 


09-01 21:56:15 
10ms
update wx_friend_meta set msgcount = msgcount + 1,lastmsgid = 5315 where fidkey = '23026121_23026121'

09-01 21:56:15 
5ms
	update wx_chat_user_item 
	set 
			startmsgid =  5315
	where uid = 23026121 and chatmode = 1 and bizid = 23026121 


09-01 21:56:15 
3ms
insert into  `wx_friend_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `appversion`, `sendbysys`, `readdevice`, `readipid`, `srctext`, `contenttype`, `readflag`, `uid`, `ipid`, `frommode`, `twouid`, `oper`, `text`, `time`, `readtime`, `sigleuid`, `device`, `msgtype`, `status`) values('1111', null, 23026121, '15165437325154814931495218176', '', '0.0.0', 2, 1, 4857, '1111', 1, 1, 23026121, 4857, null, '23026121_23026121', null, '1111', '2022-09-01 21:56:15', '2022-09-01 21:56:15', -1, 1, 1, 1)

09-01 21:56:15 
3ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5316,
	 	lastmsguid = 23026121,
	 	fromnick = '13499999999',
	 	msgresume = '1111',
	 	msgtype = 1,
	 	sysflag = 2,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 21:56:15'
	WHERE
		id = 3173


09-01 21:56:15 
3ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5316,
	 	lastmsguid = 23026121,
	 	fromnick = '13499999999',
	 	msgresume = '1111',
	 	msgtype = 1,
	 	sysflag = 2,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 21:56:15'
	WHERE
		id = 3173


09-01 21:56:15 
7ms
update wx_friend_meta set msgcount = msgcount + 1,lastmsgid = 5316 where fidkey = '23026121_23026121'

09-01 21:56:20 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:56:20', 1, 1, 0)

09-01 21:56:25 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:56:25', 1, 1, 0)

09-01 21:56:25 
19ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1328, 1, '127.0.0.1', 25.53846153846154, '2022-09-01 21:54:25', 52, 120, 1, 120365, 26, 4857, 1, 52, 52, '2分365毫秒', 1.0, 1789, 0, 1328)

09-01 21:56:30 
48ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:56:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:56:30', 1, 1, 0)

09-01 21:56:35 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:56:35', 1, 1, 0)

09-01 21:56:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:56:40', 1, 1, 0)

09-01 21:56:45 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:56:45', 1, 1, 0)

09-01 21:56:50 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:56:50', 1, 1, 0)

09-01 21:56:55 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:56:55', 1, 1, 0)

09-01 21:57:00 
10ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:57:00 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:57:00', 1, 1, 0)

09-01 21:57:05 
29ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:57:05', 1, 1, 0)

09-01 21:57:10 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:57:10', 1, 1, 0)

09-01 21:57:15 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:57:15', 1, 1, 0)

09-01 21:57:20 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:57:20', 1, 1, 0)

09-01 21:57:25 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:57:25', 1, 1, 0)

09-01 21:57:26 
7ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:52:00', 300, '15165437323156852135218865152', 325833, 98708001, 0.0, null, 4861, 8, '5分25秒833毫秒', 0.003069056848139998, 0)

09-01 21:57:26 
3ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '127.0.0.1', '172.20.10.2', '2022-09-01 21:52:22', 300, '15165437325152830433044474880', 303763, 48431849, 11.5, null, 4861, 8, '5分3秒763毫秒', 0.013168160704233234, 46)

09-01 21:57:26 
batch params_list:1, 5ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:52:00', 300, '15165437323156852135218865152', 325879, 'api', 98708001, 0.0, '/chat/queryOnline', 4861, 8, '5分25秒879毫秒', 0.003068623630243127, 0);


09-01 21:57:26 
batch params_list:4, 14ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:52:51', 300, '15165437325152830433044474880', 275279, 'api', 48431849, 15.0, '/chat/isFriend', 4861, 8, '4分35秒279毫秒', 0.0036326781192898843, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:52:22', 300, '15165437325152830433044474880', 303809, 'api', 48431849, 16.0, '/user/search2', 4861, 8, '5分3秒809毫秒', 0.00329154172522868, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:52:51', 300, '15165437325152830433044474880', 275234, 'api', 48431849, 15.0, '/chat/checkAddFriend', 4861, 8, '4分35秒234毫秒', 0.0036332720521447207, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '127.0.0.1', '172.20.10.2', '2022-09-01 21:52:53', 300, '15165437325152830433044474880', 273746, 'api', 48431849, 0.0, '/chat/friendApply', 4861, 8, '4分33秒746毫秒', 0.003653021414011529, 0);


09-01 21:57:30 
5ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:57:30 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:57:30', 1, 1, 0)

09-01 21:57:35 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:57:35', 1, 1, 0)

09-01 21:57:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:57:40', 1, 1, 0)

09-01 21:57:45 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:57:45', 1, 1, 0)

09-01 21:57:50 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:57:50', 1, 1, 0)

09-01 21:57:55 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:57:55', 1, 1, 0)

09-01 21:58:00 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:58:00', 1, 1, 0)

09-01 21:58:00 
45ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:58:05 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:58:05', 1, 1, 0)

09-01 21:58:10 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:58:10', 1, 1, 0)

09-01 21:58:15 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:58:15', 1, 1, 0)

09-01 21:58:20 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:58:20', 1, 1, 0)

09-01 21:58:25 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:58:25', 1, 1, 0)

09-01 21:58:25 
9ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(539, 0, '127.0.0.1', 11.0, '2022-09-01 21:56:25', 49, 120, 1, 119994, 0, 4857, 1, 48, 49, '1分59秒994毫秒', 1.0, 0, 0, 528)

09-01 21:58:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:58:30', 1, 1, 0)

09-01 21:58:30 
52ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:58:35 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:58:35', 1, 1, 0)

09-01 21:58:40 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:58:40', 1, 1, 0)

09-01 21:58:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:58:45', 1, 1, 0)

09-01 21:58:50 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:58:50', 1, 1, 0)

09-01 21:58:55 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:58:55', 1, 1, 0)

09-01 21:59:00 
9ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:59:00 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:59:00', 1, 1, 0)

09-01 21:59:05 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:59:05', 1, 1, 0)

09-01 21:59:10 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:59:10', 1, 1, 0)

09-01 21:59:15 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:59:15', 1, 1, 0)

09-01 21:59:16 
5ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(0, 0, '127.0.0.1', 0.0, '2022-09-01 21:56:13', 0, 120, 0, 182852, 0, 4857, 12, 0, 0, '3分2秒852毫秒', 0.0, 0, 0, 0)

09-01 21:59:16 
4ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25528, 31, '127.0.0.1', 823.483870967742, '2022-09-01 21:55:46', 31, 120, 0, 209409, 62, 4860, 12, 31, 31, '3分29秒409毫秒', 1.0, 12697, 0, 25528)

09-01 21:59:20 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:59:20', 1, 1, 0)

09-01 21:59:25 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:59:25', 1, 1, 0)

09-01 21:59:30 
48ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 21:59:30 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:59:30', 1, 1, 0)

09-01 21:59:35 
28ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:59:35', 1, 1, 0)

09-01 21:59:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:59:40', 1, 1, 0)

09-01 21:59:45 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:59:45', 1, 1, 0)

09-01 21:59:50 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:59:50', 1, 1, 0)

09-01 21:59:55 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 21:59:55', 1, 1, 0)

09-01 22:00:00 
33ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 22:00:00 
35ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:00:00', 1, 1, 0)

09-01 22:00:05 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:00:05', 1, 1, 0)

09-01 22:00:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:00:10', 1, 1, 0)

09-01 22:00:15 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:00:15', 1, 1, 0)

09-01 22:00:20 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:00:20', 1, 1, 0)

09-01 22:00:25 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:00:25', 1, 1, 0)

09-01 22:00:26 
40ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(517, 0, '127.0.0.1', 11.0, '2022-09-01 21:58:25', 47, 120, 1, 120502, 0, 4857, 1, 48, 47, '2分502毫秒', 1.0, 0, 0, 528)

09-01 22:00:30 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:00:30', 1, 1, 0)

09-01 22:00:30 
6ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 22:00:35 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:00:35', 1, 1, 0)

09-01 22:00:40 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:00:40', 1, 1, 0)

09-01 22:00:45 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:00:45', 1, 1, 0)

09-01 22:00:50 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:00:50', 1, 1, 0)

09-01 22:00:55 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:00:55', 1, 1, 0)

09-01 22:01:00 
43ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 22:01:00 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:01:00', 1, 1, 0)

09-01 22:01:05 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:01:05', 1, 1, 0)

09-01 22:01:10 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:01:10', 1, 1, 0)

09-01 22:01:15 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:01:15', 1, 1, 0)

09-01 22:01:20 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:01:20', 1, 1, 0)

09-01 22:01:25 
39ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:01:25', 1, 1, 0)

09-01 22:01:30 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:01:30', 1, 1, 0)

09-01 22:01:30 
45ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 22:01:35 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:01:35', 1, 1, 0)

09-01 22:01:40 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:01:40', 1, 1, 0)

09-01 22:01:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:01:45', 1, 1, 0)

09-01 22:01:50 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:01:50', 1, 1, 0)

09-01 22:01:55 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:01:55', 1, 1, 0)

09-01 22:02:00 
38ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:02:00', 1, 1, 0)

09-01 22:02:00 
41ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '127.0.0.1'

09-01 22:02:05 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:02:05', 1, 1, 0)

09-01 22:02:10 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:02:10', 1, 1, 0)

09-01 22:02:15 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('127.0.0.1', 1, 1, '2022-09-01 22:02:15', 1, 1, 0)

09-01 22:04:53 
2ms
update chatroom_join_leave set leavetime=DATE_ADD(jointime, INTERVAL 5 second), cost=5000, status = 2 where status = 9 and server = '172.20.10.4'

09-01 22:04:53 
2ms
update chatroom_join_leave set status = 2 where status = 3 and server = '172.20.10.4'

09-01 22:04:53 
3ms
update wx_call_item set status = 4, hanguptype = 7 where status != 4

09-01 22:04:55 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 0, 0, '2022-09-01 22:04:55', 0, 0, 0)

09-01 22:04:57 
3ms
insert into  `chatroom_join_leave`(`uid`, `server`, `ipid`, `jointime`, `session`, `groupid`, `device`, `status`) values(23026121, '172.20.10.4', 4860, '2022-09-01 22:04:57', '15165437325154814931495218176', '/home', 1, 9)

09-01 22:04:57 
6ms
insert into  `login_log`(`ip`, `appversion`, `sessionid`, `type`, `devicetype`, `hourperiod`, `uid`, `ipid`, `imei`, `time`, `deviceinfo`, `dayperiod`, `timeperiod`) values('172.20.10.4', null, '15165437325154814931495218176', 2, 1, '22', 23026121, 4860, '1', '2022-09-01 22:04:57', '自-Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36', '20220901', '22:04')

09-01 22:04:57 
7ms
replace into  `user_last_login_time`(`uid`) values(23026121)

09-01 22:04:57 
4ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 5841, 2, 2)

09-01 22:04:57 
3ms
update user_ip_login_stat set totalcount = totalcount + 1,hour1 = hour1 + 1 where ip = '172.20.10.4' and uid = 23026121 and dayperiod = '20220901'

09-01 22:04:57 
2ms
update user_ip_login_stat set totalcount = totalcount + 1 where id = 3553

09-01 22:04:57 
2ms
update user_ip_login_stat set totalcount = totalcount + 1 where id = 3554

09-01 22:04:57 
1ms
update user_time_login_stat set totalcount = totalcount + 1,hour22 = hour22 + 1 where uid = 23026121 and dayperiod = '20220901'

09-01 22:04:57 
1ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1746 

09-01 22:04:57 
2ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1742

09-01 22:04:57 
4ms
update `tio_thread_logs` set `status` = 1  where `id` = 6408

09-01 22:04:59 
1ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3173


09-01 22:04:59 
2ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3173


09-01 22:04:59 
2ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4860,
		readdevice = 1
	WHERE
		twouid = '23026121_23026121'
		and touid = 23026121
		and readflag = 2
		


09-01 22:04:59 
6ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 23026121, null, '', 1, 1, 2, 23026121, 4860, 1, null, '23026121_23026121', 7, '好友已读你的消息', '2022-09-01 22:04:59', 23026121, 1, 2, 1)

09-01 22:04:59 
13ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(23026121, 3173, 23026121, 2, 1)

09-01 22:04:59 
2ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3173


09-01 22:04:59 
2ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3173


09-01 22:04:59 
1ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4860,
		readdevice = 1
	WHERE
		twouid = '23026121_23026121'
		and touid = 23026121
		and readflag = 2
		


09-01 22:04:59 
5ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 23026121, null, '', 1, 1, 2, 23026121, 4860, 1, null, '23026121_23026121', 7, '好友已读你的消息', '2022-09-01 22:04:59', 23026121, 1, 2, 1)

09-01 22:04:59 
7ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(23026121, 3173, 23026121, 2, 1)

09-01 22:05:00 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:05:00', 1, 1, 0)

09-01 22:05:00 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:05:05 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:05:05', 1, 1, 0)

09-01 22:05:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:05:10', 1, 1, 0)

09-01 22:05:15 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:05:15', 1, 1, 0)

09-01 22:05:20 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:05:20', 1, 1, 0)

09-01 22:05:25 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:05:25', 1, 1, 0)

09-01 22:05:30 
41ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:05:30 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:05:30', 1, 1, 0)

09-01 22:05:34 
5ms
update chatroom_join_leave set leavetime = '2022-09-01 22:05:34', cost = 37208, status = 1 where id = 22868

09-01 22:05:35 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 0, 0, '2022-09-01 22:05:35', 0, 0, 0)

09-01 22:05:38 
10ms
insert into  `chatroom_join_leave`(`uid`, `server`, `ipid`, `jointime`, `session`, `groupid`, `device`, `status`) values(23026121, '172.20.10.4', 4860, '2022-09-01 22:05:38', '15165437325154814931495218176', '/home', 1, 9)

09-01 22:05:39 
5ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3173


09-01 22:05:39 
2ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3173


09-01 22:05:39 
3ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4860,
		readdevice = 1
	WHERE
		twouid = '23026121_23026121'
		and touid = 23026121
		and readflag = 2
		


09-01 22:05:39 
6ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 23026121, null, '', 1, 1, 2, 23026121, 4860, 1, null, '23026121_23026121', 7, '好友已读你的消息', '2022-09-01 22:05:39', 23026121, 1, 2, 1)

09-01 22:05:39 
8ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(23026121, 3173, 23026121, 2, 1)

09-01 22:05:40 
14ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:05:40', 1, 1, 0)

09-01 22:05:45 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:05:45', 1, 1, 0)

09-01 22:05:50 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:05:50', 1, 1, 0)

09-01 22:05:53 
6ms
update chatroom_join_leave set leavetime = '2022-09-01 22:05:53', cost = 14458, status = 1 where id = 22869

09-01 22:05:55 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 0, 0, '2022-09-01 22:05:55', 0, 0, 0)

09-01 22:06:00 
5ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:06:00 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 0, 0, '2022-09-01 22:06:00', 0, 0, 0)

09-01 22:06:05 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 0, 0, '2022-09-01 22:06:05', 0, 0, 0)

09-01 22:06:06 
11ms
insert into  `login_log`(`hourperiod`, `uid`, `uaid`, `ipid`, `ip`, `time`, `sessionid`, `type`, `deviceinfo`, `devicetype`, `dayperiod`, `timeperiod`) values('22', 23026121, 313, 4857, '127.0.0.1', '2022-09-01 22:06:06', '15165437420252851535159438336', 1, '主-Unknown ??/Chrome 104', 1, '20220901', '22:06')

09-01 22:06:07 
7ms
replace into  `user_last_login_time`(`uid`) values(23026121)

09-01 22:06:07 
5ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 5842, 2, 2)

09-01 22:06:07 
8ms
update `user_token` set `token` = '15165437420252851535159438336'  where `devicetype` = 1 and `uid` = 23026121

09-01 22:06:07 
4ms
insert ignore into  `user_ip_login_stat`(`uid`, `totalcount`, `ipid`, `ip`, `dayperiod`) values(23026121, 0, 4857, '127.0.0.1', '20220901')

09-01 22:06:07 
3ms
update user_ip_login_stat set totalcount = totalcount + 1,hour1 = hour1 + 1 where ip = '127.0.0.1' and uid = 23026121 and dayperiod = '20220901'

09-01 22:06:07 
9ms
insert into  `chatroom_join_leave`(`uid`, `server`, `ipid`, `jointime`, `session`, `groupid`, `device`, `status`) values(23026121, '172.20.10.4', 4860, '2022-09-01 22:06:07', '15165437420252851535159438336', '/login', 1, 9)

09-01 22:06:07 
3ms
update user_ip_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = 3548

09-01 22:06:07 
3ms
update user_ip_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = 3544

09-01 22:06:07 
3ms
update user_time_login_stat set totalcount = totalcount + 1,hour22 = hour22 + 1 where uid = 23026121 and dayperiod = '20220901'

09-01 22:06:07 
3ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1746 

09-01 22:06:07 
4ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1742

09-01 22:06:07 
9ms
update `tio_thread_logs` set `status` = 1  where `id` = 6409

09-01 22:06:07 
8ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3173


09-01 22:06:07 
3ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3173


09-01 22:06:07 
2ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4860,
		readdevice = 1
	WHERE
		twouid = '23026121_23026121'
		and touid = 23026121
		and readflag = 2
		


09-01 22:06:07 
10ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 23026121, null, '', 1, 1, 2, 23026121, 4860, 1, null, '23026121_23026121', 7, '好友已读你的消息', '2022-09-01 22:06:07', 23026121, 1, 2, 1)

09-01 22:06:08 
9ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(23026121, 3173, 23026121, 2, 1)

09-01 22:06:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:06:10', 1, 1, 0)

09-01 22:06:11 
12ms
insert into  `wx_call_item`(`fromdevice`, `touid`, `fromuid`, `fromipid`, `fromcid`, `type`) values(1, 23026121, 23026121, 4860, '1565340225788583936', 1)

09-01 22:06:12 
14ms
insert into  `wx_call_log`(`callid`, `summary`, `uid`, `data`, `time`) values(469, 'WxCall01Req', 23026121, '{"type":1,"touid":"23026121"}', '2022-09-01 22:06:11')

09-01 22:06:14 
8ms
update `wx_call_item` set `toipid` = 4860 , `resptime` = '2022-09-01 22:06:14' , `tocid` = '1565340225788583936' , `todevice` = 1 , `status` = 2 , `respwait` = 28803465  where `id` = 469

09-01 22:06:14 
10ms
insert into  `wx_call_log`(`callid`, `summary`, `uid`, `data`, `time`) values(469, 'WxCall03ReplyReq', 23026121, '{"id":"469","result":1}', '2022-09-01 22:06:14')

09-01 22:06:15 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:06:15', 1, 1, 0)

09-01 22:06:16 
15ms
insert into  `wx_call_log`(`callid`, `summary`, `uid`, `data`, `time`) values(469, 'WxCall05OfferSdpReq', 23026121, '{"id":"469","sdp":{"type":"offer","sdp":"v=0\r\no=- 6251417674858080060 2 IN IP4 127.0.0.1\r\ns=-\r\nt=0 0\r\na=group:BUNDLE 0\r\na=extmap-allow-mixed\r\na=msid-semantic: WMS bU8gNMK7c8H9TDIMueFMp27ITQeaBzG4t3g7\r\nm=audio 9 UDP/TLS/RTP/SAVPF 111 63 103 104 9 0 8 106 105 13 110 112 113 126\r\nc=IN IP4 0.0.0.0\r\na=rtcp:9 IN IP4 0.0.0.0\r\na=ice-ufrag:WchU\r\na=ice-pwd:XcvpCQyV72EfRBr37MzYwRpl\r\na=ice-options:trickle\r\na=fingerprint:sha-256 B5:B4:01:AE:D5:63:BB:9D:24:2C:23:72:45:27:56:2B:D3:41:2E:7A:98:B7:5B:DA:49:3D:BD:7B:C2:B4:3A:57\r\na=setup:actpass\r\na=mid:0\r\na=extmap:1 urn:ietf:params:rtp-hdrext:ssrc-audio-level\r\na=extmap:2 http://www.webrtc.org/experiments/rtp-hdrext/abs-send-time\r\na=extmap:3 http://www.ietf.org/id/draft-holmer-rmcat-transport-wide-cc-extensions-01\r\na=extmap:4 urn:ietf:params:rtp-hdrext:sdes:mid\r\na=sendrecv\r\na=msid:bU8gNMK7c8H9TDIMueFMp27ITQeaBzG4t3g7 84f63475-5f56-454b-9d3e-805b3f191e10\r\na=rtcp-mux\r\na=rtpmap:111 opus/48000/2\r\na=rtcp-fb:111 transport-cc\r\na=fmtp:111 minptime=10;useinbandfec=1\r\na=rtpmap:63 red/48000/2\r\na=fmtp:63 111/111\r\na=rtpmap:103 ISAC/16000\r\na=rtpmap:104 ISAC/32000\r\na=rtpmap:9 G722/8000\r\na=rtpmap:0 PCMU/8000\r\na=rtpmap:8 PCMA/8000\r\na=rtpmap:106 CN/32000\r\na=rtpmap:105 CN/16000\r\na=rtpmap:13 CN/8000\r\na=rtpmap:110 telephone-event/48000\r\na=rtpmap:112 telephone-event/32000\r\na=rtpmap:113 telephone-event/16000\r\na=rtpmap:126 telephone-event/8000\r\na=ssrc:4144799697 cname:sAB3LFDrKxZa/OEG\r\na=ssrc:4144799697 msid:bU8gNMK7c8H9TDIMueFMp27ITQeaBzG4t3g7 84f63475-5f56-454b-9d3e-805b3f191e10\r\n"}}', '2022-09-01 22:06:16')

09-01 22:06:16 
15ms
update `wx_call_item` set `connectedtime` = '2022-09-01 22:06:16' , `streamwait` = 2648 , `status` = 3  where `id` = 469

09-01 22:06:16 
39ms
insert into  `wx_call_log`(`callid`, `summary`, `uid`, `data`, `time`) values(469, 'WxCall09OfferIceReq', 23026121, '{"id":"469","candidate":{"candidate":"candidate:922505511 1 udp 2113937151 c8b5304c-017f-4e81-bd65-34826724a189.local 60616 typ host generation 0 ufrag WchU network-cost 999","sdpMid":"0","sdpMLineIndex":0}}', '2022-09-01 22:06:16')

09-01 22:06:16 
6ms
insert into  `wx_call_log`(`callid`, `summary`, `uid`, `data`, `time`) values(469, 'WxCall09OfferIceReq', 23026121, '{"id":"469","candidate":{"candidate":"candidate:224882657 1 udp 2113939711 319aa1e9-f8c7-4432-810b-14a10e712d8b.local 60617 typ host generation 0 ufrag WchU network-cost 999","sdpMid":"0","sdpMLineIndex":0}}', '2022-09-01 22:06:16')

09-01 22:06:20 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:06:20', 1, 1, 0)

09-01 22:06:25 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:06:25', 1, 1, 0)

09-01 22:06:25 
7ms
insert into  `wx_call_log`(`callid`, `summary`, `uid`, `data`, `time`) values(469, 'WxCall13EndReq', 23026121, '{"id":"469","type":1,"status":3,"result":null,"calltime":"2022-09-01 14:06:11","resptime":"2022-09-01 22:06:14","connectedtime":"2022-09-01 22:06:17","endtime":null,"waitduration":null,"callduration":"0","hanguptype":1,"hangupuid":null,"fromuid":23026121,"fromcid":"1565340225788583936","fromipid":4860,"fromdevice":1,"touid":23026121,"tocid":"1565340225788583936","toipid":4860,"todevice":1,"errorcode":null,"streamwait":"2648"}', '2022-09-01 22:06:25')

09-01 22:06:25 
8ms
update `wx_call_item` set `hanguptype` = 1 , `endtime` = '2022-09-01 22:06:25' , `callduration` = 8059 , `hangupuid` = 23026121 , `status` = 4  where `id` = 469

09-01 22:06:25 
3ms
insert into  `wx_friend_msg`(`session`, `sendbysys`, `readdevice`, `readipid`, `srctext`, `readflag`, `uid`, `frommode`, `text`, `msgtype`, `resume`, `frommsgid`, `touid`, `operbizdata`, `appversion`, `contenttype`, `ipid`, `twouid`, `oper`, `time`, `readtime`, `sigleuid`, `device`, `status`) values('15165437420252851535159438336', 2, 1, 4860, '{"calltype":11,"devicetype":1,"duration":"8059","hanguptype":1,"hangupuid":23026121}', 1, 23026121, null, '{"calltype":11,"devicetype":1,"duration":"8059","hanguptype":1,"hangupuid":23026121}', 1, '[语音通话]', null, 23026121, '', '0.0.0', 11, 4860, '23026121_23026121', null, '2022-09-01 22:06:25', '2022-09-01 22:06:25', -1, 1, 1)

09-01 22:06:25 
2ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5317,
	 	lastmsguid = 23026121,
	 	fromnick = '13499999999',
	 	msgresume = '[语音通话]',
	 	msgtype = 11,
	 	sysflag = 2,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 22:06:25'
	WHERE
		id = 3173


09-01 22:06:25 
2ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5317,
	 	lastmsguid = 23026121,
	 	fromnick = '13499999999',
	 	msgresume = '[语音通话]',
	 	msgtype = 11,
	 	sysflag = 2,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 22:06:25'
	WHERE
		id = 3173


09-01 22:06:25 
7ms
update wx_friend_meta set msgcount = msgcount + 1,lastmsgid = 5317 where fidkey = '23026121_23026121'

09-01 22:06:27 
11ms
insert into  `wx_call_item`(`fromdevice`, `touid`, `fromuid`, `fromipid`, `fromcid`, `type`) values(1, 23026121, 23026121, 4860, '1565340225788583936', 2)

09-01 22:06:27 
12ms
insert into  `wx_call_log`(`callid`, `summary`, `uid`, `data`, `time`) values(470, 'WxCall01Req', 23026121, '{"type":2,"touid":"23026121"}', '2022-09-01 22:06:27')

09-01 22:06:29 
49ms
update `wx_call_item` set `toipid` = 4860 , `resptime` = '2022-09-01 22:06:29' , `tocid` = '1565340225788583936' , `todevice` = 1 , `status` = 2 , `respwait` = 28802936  where `id` = 470

09-01 22:06:29 
12ms
insert into  `wx_call_log`(`callid`, `summary`, `uid`, `data`, `time`) values(470, 'WxCall03ReplyReq', 23026121, '{"id":"470","result":2}', '2022-09-01 22:06:29')

09-01 22:06:30 
9ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:06:30 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:06:30', 1, 1, 0)

09-01 22:06:30 
14ms
update `wx_call_item` set `hanguptype` = 2 , `endtime` = '2022-09-01 22:06:30' , `hangupuid` = 23026121 , `status` = 4  where `id` = 470

09-01 22:06:30 
4ms
insert into  `wx_friend_msg`(`session`, `sendbysys`, `readdevice`, `readipid`, `srctext`, `readflag`, `uid`, `frommode`, `text`, `msgtype`, `resume`, `frommsgid`, `touid`, `operbizdata`, `appversion`, `contenttype`, `ipid`, `twouid`, `oper`, `time`, `readtime`, `sigleuid`, `device`, `status`) values('15165437420252851535159438336', 2, 1, 4860, '{"calltype":10,"devicetype":1,"duration":"0","hanguptype":2,"hangupuid":23026121}', 1, 23026121, null, '{"calltype":10,"devicetype":1,"duration":"0","hanguptype":2,"hangupuid":23026121}', 1, '[视频通话]', null, 23026121, '', '0.0.0', 10, 4860, '23026121_23026121', null, '2022-09-01 22:06:30', '2022-09-01 22:06:30', -1, 1, 1)

09-01 22:06:30 
4ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5318,
	 	lastmsguid = 23026121,
	 	fromnick = '13499999999',
	 	msgresume = '[视频通话]',
	 	msgtype = 10,
	 	sysflag = 2,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 22:06:30'
	WHERE
		id = 3173


09-01 22:06:30 
3ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5318,
	 	lastmsguid = 23026121,
	 	fromnick = '13499999999',
	 	msgresume = '[视频通话]',
	 	msgtype = 10,
	 	sysflag = 2,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 22:06:30'
	WHERE
		id = 3173


09-01 22:06:30 
8ms
update wx_friend_meta set msgcount = msgcount + 1,lastmsgid = 5318 where fidkey = '23026121_23026121'

09-01 22:06:35 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:06:35', 1, 1, 0)

09-01 22:06:40 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:06:40', 1, 1, 0)

09-01 22:06:45 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:06:45', 1, 1, 0)

09-01 22:06:50 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:06:50', 1, 1, 0)

09-01 22:06:55 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:06:55', 1, 1, 0)

09-01 22:06:59 
40ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(5780, 3, '172.20.10.4', 115.6, '2022-09-01 22:04:57', 50, 120, 1, 122263, 70, 4860, 1, 54, 54, '2分2秒263毫秒', 1.08, 7443, 0, 5780)

09-01 22:07:00 
7ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:07:00 
15ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:07:00', 1, 1, 0)

09-01 22:07:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:07:05', 1, 1, 0)

09-01 22:07:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:07:10', 1, 1, 0)

09-01 22:07:15 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:07:15', 1, 1, 0)

09-01 22:07:20 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:07:20', 1, 1, 0)

09-01 22:07:25 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:07:25', 1, 1, 0)

09-01 22:07:26 
41ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(13885, 17, '172.20.10.4', 816.7647058823529, '2022-09-01 22:04:56', 17, 120, 0, 150688, 34, 4860, 12, 17, 17, '2分30秒688毫秒', 1.0, 6883, 0, 13885)

09-01 22:07:26 
5ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(35349, 28, '172.20.10.4', 1262.4642857142858, '2022-09-01 22:04:56', 28, 120, 0, 150732, 56, 4857, 12, 28, 28, '2分30秒732毫秒', 1.0, 10772, 0, 35349)

09-01 22:07:27 
45ms
insert into  `login_log`(`ip`, `appversion`, `sessionid`, `type`, `devicetype`, `hourperiod`, `uid`, `ipid`, `imei`, `time`, `deviceinfo`, `dayperiod`, `timeperiod`) values('172.20.10.2', '3.1', '15165437325152830433044474880', 2, 3, '22', 48431849, 4861, 'a658aec1bd9a411aba1b78d9af8af44c', '2022-09-01 22:07:27', '自-x86_64', '20220901', '22:07')

09-01 22:07:27 
8ms
replace into  `user_last_login_time`(`uid`) values(48431849)

09-01 22:07:27 
5ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 5843, 2, 2)

09-01 22:07:27 
2ms
update user_ip_login_stat set totalcount = totalcount + 1,hour1 = hour1 + 1 where ip = '172.20.10.2' and uid = 48431849 and dayperiod = '20220901'

09-01 22:07:27 
1ms
update user_ip_login_stat set totalcount = totalcount + 1 where id = 3550

09-01 22:07:27 
2ms
update user_ip_login_stat set totalcount = totalcount + 1 where id = 3551

09-01 22:07:27 
2ms
update user_time_login_stat set totalcount = totalcount + 1,hour22 = hour22 + 1 where uid = 48431849 and dayperiod = '20220901'

09-01 22:07:27 
2ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1744 

09-01 22:07:27 
2ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1742

09-01 22:07:27 
3ms
update `tio_thread_logs` set `status` = 1  where `id` = 6410

09-01 22:07:30 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:07:30', 2, 2, 0)

09-01 22:07:30 
44ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:07:35 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:07:35', 2, 2, 0)

09-01 22:07:40 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:07:40', 2, 2, 0)

09-01 22:07:45 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:07:45', 2, 2, 0)

09-01 22:07:50 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:07:50', 2, 2, 0)

09-01 22:07:55 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:07:55', 2, 2, 0)

09-01 22:08:00 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:08:00', 2, 2, 0)

09-01 22:08:00 
47ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:08:05 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:08:05', 2, 2, 0)

09-01 22:08:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:08:10', 2, 2, 0)

09-01 22:08:15 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:08:15', 2, 2, 0)

09-01 22:08:20 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:08:20', 2, 2, 0)

09-01 22:08:25 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:08:25', 2, 2, 0)

09-01 22:08:30 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:08:30', 2, 2, 0)

09-01 22:08:30 
48ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:08:35 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:08:35', 2, 2, 0)

09-01 22:08:40 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:08:40', 2, 2, 0)

09-01 22:08:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:08:45', 2, 2, 0)

09-01 22:08:50 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:08:50', 2, 2, 0)

09-01 22:08:55 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:08:55', 2, 2, 0)

09-01 22:09:00 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(539, 0, '172.20.10.4', 11.0, '2022-09-01 22:06:59', 49, 120, 1, 119999, 0, 4860, 1, 48, 49, '1分59秒999毫秒', 1.0, 0, 0, 528)

09-01 22:09:00 
7ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:09:00 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:09:00', 2, 2, 0)

09-01 22:09:05 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:09:05', 2, 2, 0)

09-01 22:09:10 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:09:10', 2, 2, 0)

09-01 22:09:15 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:09:15', 2, 2, 0)

09-01 22:09:20 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:09:20', 2, 2, 0)

09-01 22:09:23 
3ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3173


09-01 22:09:23 
2ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3173


09-01 22:09:23 
3ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4860,
		readdevice = 1
	WHERE
		twouid = '23026121_23026121'
		and touid = 23026121
		and readflag = 2
		


09-01 22:09:23 
7ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 23026121, null, '', 1, 1, 2, 23026121, 4860, 1, null, '23026121_23026121', 7, '好友已读你的消息', '2022-09-01 22:09:23', 23026121, 1, 2, 1)

09-01 22:09:23 
9ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(23026121, 3173, 23026121, 2, 1)

09-01 22:09:25 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:09:25', 2, 2, 0)

09-01 22:09:30 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 1, 1, '2022-09-01 22:09:30', 1, 1, 0)

09-01 22:09:30 
48ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:09:30 
41ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(10872, 6, '172.20.10.4', 418.15384615384613, '2022-09-01 22:07:26', 26, 120, 0, 123887, 34, 4861, 12, 17, 17, '2分3秒887毫秒', 0.6538461538461539, 7718, 0, 10872)

09-01 22:09:31 
44ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(394, 1, '172.20.10.4', 98.5, '2022-09-01 22:07:27', 4, 120, 1, 123972, 4, 4861, 2, 4, 4, '2分3秒972毫秒', 1.0, 74, 0, 394)

09-01 22:09:35 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:09:35', 2, 2, 0)

09-01 22:09:40 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:09:40', 2, 2, 0)

09-01 22:09:45 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 2, 2, '2022-09-01 22:09:45', 2, 2, 0)

09-01 22:09:49 
7ms
insert into  `login_log`(`ip`, `appversion`, `sessionid`, `type`, `devicetype`, `hourperiod`, `uid`, `ipid`, `imei`, `time`, `deviceinfo`, `dayperiod`, `timeperiod`) values('172.20.10.2', '3.1', '15165437323156852135218865152', 2, 3, '22', 98708001, 4861, '83a522533756442a91e1a2415ced871e', '2022-09-01 22:09:49', '自-x86_64', '20220901', '22:09')

09-01 22:09:49 
5ms
replace into  `user_last_login_time`(`uid`) values(98708001)

09-01 22:09:49 
5ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 5844, 2, 2)

09-01 22:09:49 
2ms
update user_ip_login_stat set totalcount = totalcount + 1,hour1 = hour1 + 1 where ip = '172.20.10.2' and uid = 98708001 and dayperiod = '20220901'

09-01 22:09:49 
2ms
update user_ip_login_stat set totalcount = totalcount + 1 where id = 3550

09-01 22:09:49 
1ms
update user_ip_login_stat set totalcount = totalcount + 1 where id = 3551

09-01 22:09:49 
2ms
update user_time_login_stat set totalcount = totalcount + 1,hour22 = hour22 + 1 where uid = 98708001 and dayperiod = '20220901'

09-01 22:09:49 
2ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1737 

09-01 22:09:49 
2ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1742

09-01 22:09:49 
4ms
update `tio_thread_logs` set `status` = 1  where `id` = 6411

09-01 22:09:50 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:09:50', 3, 3, 0)

09-01 22:09:53 
2ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3172


09-01 22:09:53 
2ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3172


09-01 22:09:53 
3ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4861,
		readdevice = 5
	WHERE
		twouid = '98708001_98708001'
		and touid = 98708001
		and readflag = 2
		


09-01 22:09:53 
4ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 98708001, null, '', 1, 1, 2, 98708001, 4861, 1, null, '98708001_98708001', 7, '好友已读你的消息', '2022-09-01 22:09:53', 98708001, 5, 2, 1)

09-01 22:09:53 
7ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(98708001, 3172, 98708001, 2, 5)

09-01 22:09:55 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:09:55', 3, 3, 0)

09-01 22:10:00 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:10:00', 3, 3, 0)

09-01 22:10:00 
9ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:10:05 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:10:05', 3, 3, 0)

09-01 22:10:10 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:10:10', 3, 3, 0)

09-01 22:10:15 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:10:15', 3, 3, 0)

09-01 22:10:18 
7ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(17, '172.20.10.4', '172.20.10.4', '2022-09-01 22:04:57', 300, '15165437325154814931495218176', 320553, 23026121, 101.76470588235294, null, 4860, 8, '5分20秒553毫秒', 0.05303335173902599, 1730)

09-01 22:10:18 
batch params_list:10, 53ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.4', '2022-09-01 22:05:39', 300, '15165437325154814931495218176', 279166, 'api', 23026121, 39.5, '/chat/mailList', 4860, 8, '4分39秒166毫秒', 0.0071641962130058814, 79);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.4', '2022-09-01 22:05:38', 300, '15165437325154814931495218176', 279663, 'api', 23026121, 7.0, '/chat/list', 4860, 8, '4分39秒663毫秒', 0.007151464441130933, 14);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.4', '2022-09-01 22:05:38', 300, '15165437325154814931495218176', 279601, 'api', 23026121, 0.0, '/chat/applyData', 4860, 8, '4分39秒601毫秒', 0.0035765251197241786, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.4', '2022-09-01 22:04:57', 300, '15165437325154814931495218176', 320553, 'api', 23026121, 706.5, '/im/imserver', 4860, 8, '5分20秒553毫秒', 0.006239217851650118, 1413);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.4', '2022-09-01 22:05:39', 300, '15165437325154814931495218176', 279166, 'api', 23026121, 0.0, '/chat/getLastAllNotice', 4860, 8, '4分39秒166毫秒', 0.0035820981065029407, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '172.20.10.4', '172.20.10.4', '2022-09-01 22:05:39', 300, '15165437325154814931495218176', 279076, 'api', 23026121, 42.0, '/config/query', 4860, 8, '4分39秒76毫秒', 0.017916266536714014, 210);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.4', '2022-09-01 22:05:39', 300, '15165437325154814931495218176', 279166, 'api', 23026121, 0.0, '/friendGroup/list', 4860, 8, '4分39秒166毫秒', 0.0035820981065029407, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.4', '2022-09-01 22:05:38', 300, '15165437325154814931495218176', 279956, 'api', 23026121, 0.0, '/user/curr', 4860, 8, '4分39秒956毫秒', 0.0035719898841246483, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.4', '2022-09-01 22:05:39', 300, '15165437325154814931495218176', 278846, 'api', 23026121, 14.0, '/user/info', 4860, 8, '4分38秒846毫秒', 0.0035862088751497244, 14);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.4', '2022-09-01 22:05:39', 300, '15165437325154814931495218176', 278799, 'api', 23026121, 0.0, '/chat/queryOnline', 4860, 8, '4分38秒799毫秒', 0.0035868134390725937, 0);


09-01 22:10:18 
5ms
insert into  `chatroom_join_leave`(`uid`, `server`, `ipid`, `jointime`, `session`, `groupid`, `device`, `status`) values(98708001, '172.20.10.4', 4860, '2022-09-01 22:10:18', '15161427428658899639962491904', '/', 1, 9)

09-01 22:10:18 
14ms
insert into  `login_log`(`ip`, `appversion`, `sessionid`, `type`, `devicetype`, `hourperiod`, `uid`, `ipid`, `imei`, `time`, `deviceinfo`, `dayperiod`, `timeperiod`) values('172.20.10.4', null, '15161427428658899639962491904', 2, 1, '22', 98708001, 4860, '1', '2022-09-01 22:10:18', '自-Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36', '20220901', '22:10')

09-01 22:10:18 
13ms
replace into  `user_last_login_time`(`uid`) values(98708001)

09-01 22:10:18 
7ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 5845, 2, 2)

09-01 22:10:18 
3ms
update user_ip_login_stat set totalcount = totalcount + 1,hour1 = hour1 + 1 where ip = '172.20.10.4' and uid = 98708001 and dayperiod = '20220901'

09-01 22:10:18 
2ms
update user_ip_login_stat set totalcount = totalcount + 1 where id = 3553

09-01 22:10:18 
2ms
update user_ip_login_stat set totalcount = totalcount + 1 where id = 3554

09-01 22:10:18 
2ms
update user_time_login_stat set totalcount = totalcount + 1,hour22 = hour22 + 1 where uid = 98708001 and dayperiod = '20220901'

09-01 22:10:18 
3ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1737 

09-01 22:10:18 
3ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1742

09-01 22:10:18 
7ms
update `tio_thread_logs` set `status` = 1  where `id` = 6412

09-01 22:10:18 
33ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(17, '172.20.10.4', '172.20.10.4', 0, '2022-09-01 22:04:57', 300, 321309, 101.76470588235294, null, 4860, 8, '5分21秒309毫秒', 0.05290857087725523, 1730)

09-01 22:10:19 
batch params_list:10, 100ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.4', 0, '2022-09-01 22:05:39', 300, 279954, 'api', 39.5, '/chat/mailList', 4860, 8, '4分39秒954毫秒', 0.007144030805060831, 79);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.4', 0, '2022-09-01 22:05:38', 300, 280451, 'api', 7.0, '/chat/list', 4860, 8, '4分40秒451毫秒', 0.0071313705424477, 14);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.4', 0, '2022-09-01 22:05:38', 300, 280389, 'api', 0.0, '/chat/applyData', 4860, 8, '4分40秒389毫秒', 0.003566473720438391, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.4', 0, '2022-09-01 22:04:57', 300, 321341, 'api', 706.5, '/im/imserver', 4860, 8, '5分21秒341毫秒', 0.006223917894075142, 1413);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.4', 0, '2022-09-01 22:05:39', 300, 279954, 'api', 0.0, '/chat/getLastAllNotice', 4860, 8, '4分39秒954毫秒', 0.0035720154025304157, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '172.20.10.4', '172.20.10.4', 0, '2022-09-01 22:05:39', 300, 279864, 'api', 42.0, '/config/query', 4860, 8, '4分39秒864毫秒', 0.017865820541405827, 210);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.4', 0, '2022-09-01 22:05:39', 300, 279954, 'api', 0.0, '/friendGroup/list', 4860, 8, '4分39秒954毫秒', 0.0035720154025304157, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.4', 0, '2022-09-01 22:05:38', 300, 280744, 'api', 0.0, '/user/curr', 4860, 8, '4分40秒744毫秒', 0.0035619639244293733, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.4', 0, '2022-09-01 22:05:39', 300, 279634, 'api', 14.0, '/user/info', 4860, 8, '4分39秒634毫秒', 0.0035761030489854595, 14);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.4', 0, '2022-09-01 22:05:39', 300, 279587, 'api', 0.0, '/chat/queryOnline', 4860, 8, '4分39秒587毫秒', 0.0035767042101385255, 0);


09-01 22:10:19 
4ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3172


09-01 22:10:19 
2ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3172


09-01 22:10:19 
2ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4860,
		readdevice = 1
	WHERE
		twouid = '98708001_98708001'
		and touid = 98708001
		and readflag = 2
		


09-01 22:10:19 
6ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 98708001, null, '', 1, 1, 2, 98708001, 4860, 1, null, '98708001_98708001', 7, '好友已读你的消息', '2022-09-01 22:10:19', 98708001, 1, 2, 1)

09-01 22:10:19 
8ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(98708001, 3172, 98708001, 2, 1)

09-01 22:10:20 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:10:20', 4, 3, 0)

09-01 22:10:25 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:10:25', 4, 3, 0)

09-01 22:10:25 
5ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3172


09-01 22:10:25 
4ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3172


09-01 22:10:25 
4ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4861,
		readdevice = 5
	WHERE
		twouid = '98708001_98708001'
		and touid = 98708001
		and readflag = 2
		


09-01 22:10:25 
42ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 98708001, null, '', 1, 1, 2, 98708001, 4861, 1, null, '98708001_98708001', 7, '好友已读你的消息', '2022-09-01 22:10:25', 98708001, 5, 2, 1)

09-01 22:10:25 
12ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(98708001, 3172, 98708001, 2, 5)

09-01 22:10:30 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:10:30', 4, 3, 0)

09-01 22:10:30 
49ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:10:34 
4ms
insert into  `wx_friend_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `readdevice`, `readipid`, `srctext`, `contenttype`, `readflag`, `uid`, `ipid`, `frommode`, `twouid`, `oper`, `text`, `time`, `readtime`, `sigleuid`, `device`, `msgtype`, `status`) values('1662041434033', null, 98708001, '', '1662041434033', 1, 5, 4861, '1662041434033', 1, 1, 98708001, 4858, null, '98708001_98708001', null, '1662041434033', '2022-09-01 22:10:34', '2022-09-01 22:10:34', -1, 99, 1, 1)

09-01 22:10:34 
3ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5319,
	 	lastmsguid = 98708001,
	 	fromnick = '12345678',
	 	msgresume = '1662041434033',
	 	msgtype = 1,
	 	sysflag = 1,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 22:10:34'
	WHERE
		id = 3172


09-01 22:10:34 
3ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5319,
	 	lastmsguid = 98708001,
	 	fromnick = '12345678',
	 	msgresume = '1662041434033',
	 	msgtype = 1,
	 	sysflag = 1,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 22:10:34'
	WHERE
		id = 3172


09-01 22:10:34 
11ms
update wx_friend_meta set msgcount = msgcount + 1,lastmsgid = 5319 where fidkey = '98708001_98708001'

09-01 22:10:34 
2ms
insert into  `wx_friend_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `appversion`, `sendbysys`, `readdevice`, `readipid`, `srctext`, `contenttype`, `readflag`, `uid`, `ipid`, `frommode`, `twouid`, `oper`, `text`, `time`, `readtime`, `sigleuid`, `device`, `msgtype`, `status`) values('1234567876543', null, 98708001, '15165437323156852135218865152', '', '3.1', 2, 5, 4861, '1234567876543', 1, 1, 98708001, 4861, null, '98708001_98708001', null, '1234567876543', '2022-09-01 22:10:34', '2022-09-01 22:10:34', -1, 3, 1, 1)

09-01 22:10:34 
3ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5320,
	 	lastmsguid = 98708001,
	 	fromnick = '12345678',
	 	msgresume = '1234567876543',
	 	msgtype = 1,
	 	sysflag = 2,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 22:10:34'
	WHERE
		id = 3172


09-01 22:10:34 
3ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5320,
	 	lastmsguid = 98708001,
	 	fromnick = '12345678',
	 	msgresume = '1234567876543',
	 	msgtype = 1,
	 	sysflag = 2,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 22:10:34'
	WHERE
		id = 3172


09-01 22:10:34 
7ms
update wx_friend_meta set msgcount = msgcount + 1,lastmsgid = 5320 where fidkey = '98708001_98708001'

09-01 22:10:35 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:10:35', 4, 3, 0)

09-01 22:10:40 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:10:40', 4, 3, 0)

09-01 22:10:45 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:10:45', 4, 3, 0)

09-01 22:10:45 
2ms
insert into  `wx_friend_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `appversion`, `sendbysys`, `readdevice`, `readipid`, `srctext`, `contenttype`, `readflag`, `uid`, `ipid`, `frommode`, `twouid`, `oper`, `text`, `time`, `readtime`, `sigleuid`, `device`, `msgtype`, `status`) values('asdasd', null, 98708001, '15161427428658899639962491904', '', '0.0.0', 2, 5, 4861, 'asdasd', 1, 1, 98708001, 4860, null, '98708001_98708001', null, 'asdasd', '2022-09-01 22:10:45', '2022-09-01 22:10:45', -1, 1, 1, 1)

09-01 22:10:45 
2ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5321,
	 	lastmsguid = 98708001,
	 	fromnick = '12345678',
	 	msgresume = 'asdasd',
	 	msgtype = 1,
	 	sysflag = 2,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 22:10:45'
	WHERE
		id = 3172


09-01 22:10:45 
2ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5321,
	 	lastmsguid = 98708001,
	 	fromnick = '12345678',
	 	msgresume = 'asdasd',
	 	msgtype = 1,
	 	sysflag = 2,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 22:10:45'
	WHERE
		id = 3172


09-01 22:10:45 
5ms
update wx_friend_meta set msgcount = msgcount + 1,lastmsgid = 5321 where fidkey = '98708001_98708001'

09-01 22:10:48 
13ms
insert into  `wx_call_item`(`fromdevice`, `touid`, `fromuid`, `fromipid`, `fromcid`, `type`) values(1, 98708001, 98708001, 4860, '1565341279691350016', 1)

09-01 22:10:48 
12ms
insert into  `wx_call_log`(`callid`, `summary`, `uid`, `data`, `time`) values(471, 'WxCall01Req', 98708001, '{"type":1,"touid":"98708001"}', '2022-09-01 22:10:48')

09-01 22:10:50 
51ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:10:50', 4, 3, 0)

09-01 22:10:52 
51ms
update `wx_call_item` set `toipid` = 4860 , `resptime` = '2022-09-01 22:10:52' , `tocid` = '1565341279691350016' , `todevice` = 1 , `status` = 2 , `respwait` = 28804786  where `id` = 471

09-01 22:10:52 
11ms
insert into  `wx_call_log`(`callid`, `summary`, `uid`, `data`, `time`) values(471, 'WxCall03ReplyReq', 98708001, '{"id":"471","result":2}', '2022-09-01 22:10:52')

09-01 22:10:52 
9ms
update `wx_call_item` set `hanguptype` = 2 , `endtime` = '2022-09-01 22:10:52' , `hangupuid` = 98708001 , `status` = 4  where `id` = 471

09-01 22:10:52 
2ms
insert into  `wx_friend_msg`(`session`, `sendbysys`, `readdevice`, `readipid`, `srctext`, `readflag`, `uid`, `frommode`, `text`, `msgtype`, `resume`, `frommsgid`, `touid`, `operbizdata`, `appversion`, `contenttype`, `ipid`, `twouid`, `oper`, `time`, `readtime`, `sigleuid`, `device`, `status`) values('15161427428658899639962491904', 2, 5, 4861, '{"calltype":11,"devicetype":1,"duration":"0","hanguptype":2,"hangupuid":98708001}', 1, 98708001, null, '{"calltype":11,"devicetype":1,"duration":"0","hanguptype":2,"hangupuid":98708001}', 1, '[语音通话]', null, 98708001, '', '0.0.0', 11, 4860, '98708001_98708001', null, '2022-09-01 22:10:52', '2022-09-01 22:10:52', -1, 1, 1)

09-01 22:10:52 
3ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5322,
	 	lastmsguid = 98708001,
	 	fromnick = '12345678',
	 	msgresume = '[语音通话]',
	 	msgtype = 11,
	 	sysflag = 2,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 22:10:52'
	WHERE
		id = 3172


09-01 22:10:52 
4ms
	UPDATE wx_chat_items_meta
	SET 
			readflag = 1,
			notreadcount = 0,
	 		notreadstartmsgid = null,
			toreadflag = 1,
			viewflag = 1,
	 	lastmsgid = 5322,
	 	lastmsguid = 98708001,
	 	fromnick = '12345678',
	 	msgresume = '[语音通话]',
	 	msgtype = 11,
	 	sysflag = 2,
	 	chatuptime = now(),
	 	sendtime = '2022-09-01 22:10:52'
	WHERE
		id = 3172


09-01 22:10:52 
10ms
update wx_friend_meta set msgcount = msgcount + 1,lastmsgid = 5322 where fidkey = '98708001_98708001'

09-01 22:10:55 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:10:55', 4, 3, 0)

09-01 22:11:00 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:11:00', 4, 3, 0)

09-01 22:11:00 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:11:00 
6ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1520, 1, '172.20.10.4', 23.75, '2022-09-01 22:08:59', 64, 120, 2, 120209, 44, 4860, 1, 66, 65, '2分209毫秒', 1.015625, 4739, 0, 1531)

09-01 22:11:05 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:11:05', 4, 3, 0)

09-01 22:11:05 
9ms
delete from wx_jpush_user WHERE uid = 48431849

09-01 22:11:05 
13ms
delete from user_token where uid=48431849 and devicetype=5 and token='15165437325152830433044474880'

09-01 22:11:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:11:10', 3, 2, 0)

09-01 22:11:15 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:11:15', 3, 2, 0)

09-01 22:11:20 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:11:20', 3, 2, 0)

09-01 22:11:25 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:11:25', 3, 2, 0)

09-01 22:11:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:11:30', 3, 2, 0)

09-01 22:11:30 
52ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:11:35 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:11:35', 3, 2, 0)

09-01 22:11:40 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:11:40', 3, 2, 0)

09-01 22:11:45 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:11:45', 3, 2, 0)

09-01 22:11:49 
45ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1084, 2, '172.20.10.4', 72.26666666666667, '2022-09-01 22:09:31', 15, 120, 1, 137822, 46, 4861, 2, 15, 15, '2分17秒822毫秒', 1.0, 4780, 0, 1084)

09-01 22:11:50 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:11:50', 3, 2, 0)

09-01 22:11:55 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:11:55', 3, 2, 0)

09-01 22:12:00 
34ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:12:00', 3, 2, 0)

09-01 22:12:00 
38ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:12:05 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:12:05', 3, 2, 0)

09-01 22:12:10 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:12:10', 3, 2, 0)

09-01 22:12:15 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:12:15', 3, 2, 0)

09-01 22:12:20 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:12:20', 3, 2, 0)

09-01 22:12:25 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:12:25', 3, 2, 0)

09-01 22:12:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:12:30', 3, 2, 0)

09-01 22:12:30 
50ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:12:35 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:12:35', 3, 2, 0)

09-01 22:12:40 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:12:40', 3, 2, 0)

09-01 22:12:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:12:45', 3, 2, 0)

09-01 22:12:50 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:12:50', 3, 2, 0)

09-01 22:12:55 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:12:55', 3, 2, 0)

09-01 22:13:00 
17ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:13:00', 3, 2, 0)

09-01 22:13:00 
24ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:13:00 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1056, 0, '172.20.10.4', 11.0, '2022-09-01 22:11:00', 96, 120, 2, 120012, 0, 4860, 1, 96, 96, '2分12毫秒', 1.0, 0, 0, 1056)

09-01 22:13:00 
9ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(36087, 13, '172.20.10.4', 400.96666666666664, '2022-09-01 22:09:30', 90, 120, 0, 209574, 114, 4861, 12, 57, 57, '3分29秒574毫秒', 0.6333333333333333, 23164, 0, 36087)

09-01 22:13:00 
8ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(39459, 35, '172.20.10.4', 1127.4, '2022-09-01 22:09:22', 35, 120, 0, 217522, 70, 4857, 12, 35, 35, '3分37秒522毫秒', 1.0, 15442, 0, 39459)

09-01 22:13:00 
9ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(74, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:07:26', 300, 333417, 9.432432432432432, null, 4861, 8, '5分33秒417毫秒', 0.22194429198271232, 698)

09-01 22:13:00 
8ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(40, '172.20.10.4', '172.20.10.2', '2022-09-01 22:07:26', 300, '15165437325152830433044474880', 333417, 48431849, 13.925, null, 4861, 8, '5分33秒417毫秒', 0.11996988755822288, 557)

09-01 22:13:00 
10ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(63, '172.20.10.4', '127.0.0.1', 1, '2022-09-01 22:05:55', 300, 425100, 8.396825396825397, null, 4857, 8, '7分5秒100毫秒', 0.14820042342978124, 529)

09-01 22:13:00 
9ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '127.0.0.1', '2022-09-01 22:05:55', 300, '15165437420157861736174161920', 424899, 31.0, null, 4857, 8, '7分4秒899毫秒', 0.0070605014368120425, 93)

09-01 22:13:00 
6ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(39, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:07', 300, '15165437420252851535159438336', 413364, 23026121, 7.923076923076923, null, 4857, 8, '6分53秒364毫秒', 0.09434783870874096, 309)

09-01 22:13:00 
batch params_list:3, 27ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:07', 300, '15165437420157861736174161920', 413411, 'api', 93.0, '/login', 4857, 8, '6分53秒411毫秒', 0.0024189003195367324, 93);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:05:55', 300, '15165437420157861736174161920', 424743, 'api', 0.0, '/user/curr', 4857, 8, '7分4秒743毫秒', 0.00235436487475956, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:05:55', 300, '15165437420157861736174161920', 424930, 'api', 0.0, '/config/viewmodel', 4857, 8, '7分4秒930毫秒', 0.002353328783564352, 0);


09-01 22:13:00 
batch params_list:12, 90ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:07:27', 300, '15165437325152830433044474880', 332686, 'api', 48431849, 0.0, '/chat/mailList', 4861, 8, '5分32秒686毫秒', 0.006011674672213438, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:09:44', 300, '15165437325152830433044474880', 195633, 'api', 48431849, 0.0, '/chat/isFriend', 4861, 8, '3分15秒633毫秒', 0.005111612049091922, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:07:27', 300, '15165437325152830433044474880', 332609, 'api', 48431849, 8.5, '/chat/list', 4861, 8, '5分32秒609毫秒', 0.006013066393272581, 17);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:09:41', 300, '15165437325152830433044474880', 198562, 'api', 48431849, 16.0, '/user/search2', 4861, 8, '3分18秒562毫秒', 0.0050362103524340006, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '172.20.10.4', '172.20.10.2', '2022-09-01 22:07:27', 300, '15165437325152830433044474880', 333416, 'api', 48431849, 21.6, '/config/base', 4861, 8, '5分33秒416毫秒', 0.014996280922331262, 108);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(10, '172.20.10.4', '172.20.10.2', '2022-09-01 22:07:26', 300, '15165437325152830433044474880', 333432, 'api', 48431849, 13.9, '/chat/applyData', 4861, 8, '5分33秒432毫秒', 0.0299911226277022, 139);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:11:05', 300, '15165437325152830433044474880', 114568, 'api', 48431849, 30.0, '/logout', 4861, 8, '1分54秒568毫秒', 0.00872844075134418, 30);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:07:27', 300, '15165437325152830433044474880', 332919, 'api', 48431849, 7.5, '/im/imserver', 4861, 8, '5分32秒919毫秒', 0.006007467281831316, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:07:27', 300, '15165437325152830433044474880', 333416, 'api', 48431849, 46.0, '/chat/getLastAllNotice', 4861, 8, '5分33秒416毫秒', 0.0059985123689325045, 92);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:07:26', 300, '15165437325152830433044474880', 333432, 'api', 48431849, 38.5, '/user/curr', 4861, 8, '5分33秒432毫秒', 0.00599822452554044, 77);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:07:27', 300, '15165437325152830433044474880', 332966, 'api', 48431849, 24.5, '/sys/version', 4861, 8, '5分32秒966毫秒', 0.006006619294462498, 49);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(10, '172.20.10.4', '172.20.10.2', '2022-09-01 22:07:27', 300, '15165437325152830433044474880', 333138, 'api', 48431849, 1.4, '/chat/queryOnline', 4861, 8, '5分33秒138毫秒', 0.030017590307920443, 14);


09-01 22:13:00 
batch params_list:15, 115ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:07:27', 300, 332594, 'api', 10.666666666666666, '/chat/list', 4861, 8, '5分32秒594毫秒', 0.009020006374137838, 32);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:09:41', 300, 198547, 'api', 16.0, '/user/search2', 4861, 8, '3分18秒547毫秒', 0.005036590832397367, 16);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:10:25', 300, 154839, 'api', 17.0, '/chat/actChat', 4861, 8, '2分34秒839毫秒', 0.006458321223981039, 17);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(20, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:07:26', 300, 333417, 'api', 10.05, '/chat/applyData', 4861, 8, '5分33秒417毫秒', 0.05998494377911144, 201);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:11:05', 300, 114553, 'api', 30.0, '/logout', 4861, 8, '1分54秒553毫秒', 0.008729583686154008, 30);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:07:27', 300, 332904, 'api', 5.0, '/im/imserver', 4861, 8, '5分32秒904毫秒', 0.00901160694975128, 15);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:07:27', 300, 333401, 'api', 30.666666666666668, '/chat/getLastAllNotice', 4861, 8, '5分33秒401毫秒', 0.008998173370805726, 92);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:10:29', 300, 151198, 'api', 0.0, '/chat/inP2pChatInput', 4861, 8, '2分31秒198毫秒', 0.006613844098466911, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:07:26', 300, 333417, 'api', 25.666666666666668, '/user/curr', 4861, 8, '5分33秒417毫秒', 0.008997741566866715, 77);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:09:53', 300, 186476, 'api', 5.666666666666667, '/user/info', 4861, 8, '3分6秒476毫秒', 0.016087861172483325, 17);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:07:27', 300, 332671, 'api', 0.0, '/chat/mailList', 4861, 8, '5分32秒671毫秒', 0.009017918604266676, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:09:44', 300, 195618, 'api', 0.0, '/chat/isFriend', 4861, 8, '3分15秒618毫秒', 0.005112004007811142, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(7, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:07:27', 300, 333401, 'api', 17.571428571428573, '/config/base', 4861, 8, '5分33秒401毫秒', 0.020995737865213363, 123);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:07:27', 300, 332951, 'api', 16.333333333333332, '/sys/version', 4861, 8, '5分32秒951毫秒', 0.009010334854077628, 49);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(21, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:07:27', 300, 333123, 'api', 1.380952380952381, '/chat/queryOnline', 4861, 8, '5分33秒123毫秒', 0.06303977809998108, 29);


09-01 22:13:00 
batch params_list:17, 114ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(6, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:06:07', 300, 413333, 'api', 7.833333333333333, '/chat/list', 4857, 8, '6分53秒333毫秒', 0.014516140738823177, 47);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:06:07', 300, 413395, 'api', 93.0, '/login', 4857, 8, '6分53秒395毫秒', 0.002418993940420179, 93);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:09:22', 300, 217555, 'api', 17.0, '/chat/actChat', 4857, 8, '3分37秒555毫秒', 0.0045965388062788725, 17);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:06:07', 300, 413255, 'api', 5.333333333333333, '/chat/applyData', 4857, 8, '6分53秒255毫秒', 0.007259440297153089, 16);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:06:14', 300, 405885, 'api', 0.0, '/im/turnserver', 4857, 8, '6分45秒885毫秒', 0.00246375204799389, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:06:07', 300, 413348, 'api', 0.0, '/im/imserver', 4857, 8, '6分53秒348毫秒', 0.004838537987361739, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:06:07', 300, 412897, 'api', 21.0, '/chat/getLastAllNotice', 4857, 8, '6分52秒897毫秒', 0.0072657345536538175, 63);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:06:07', 300, 412868, 'api', 12.25, '/friendGroup/list', 4857, 8, '6分52秒868毫秒', 0.009687951095222871, 49);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:10:44', 300, 136164, 'api', 0.0, '/chat/inP2pChatInput', 4857, 8, '2分16秒164毫秒', 0.007344085073881497, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(7, '172.20.10.4', '127.0.0.1', 1, '2022-09-01 22:05:55', 300, 425131, 'api', 6.428571428571429, '/user/curr', 4857, 8, '7分5秒131毫秒', 0.016465512983056988, 45);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:06:07', 300, 412609, 'api', 0.0, '/user/info', 4857, 8, '6分52秒609毫秒', 0.00484720401154604, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(9, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:06:07', 300, 412913, 'api', 5.333333333333333, '/chat/mailList', 4857, 8, '6分52秒913毫秒', 0.021796359039313366, 48);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(15, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:06:07', 300, 412884, 'api', 8.933333333333334, '/config/query', 4857, 8, '6分52秒884毫秒', 0.03632981660708577, 134);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:06:48', 300, 372074, 'api', 0.0, '/user/search', 4857, 8, '6分12秒74毫秒', 0.0026876374054623543, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:06:35', 300, 384675, 'api', 0.0, '/chat/applyList', 4857, 8, '6分24秒675毫秒', 0.0025995970624553195, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:05:55', 300, 424930, 'api', 5.666666666666667, '/config/viewmodel', 4857, 8, '7分4秒930毫秒', 0.007059986350693055, 17);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:06:07', 300, 412531, 'api', 0.0, '/chat/queryOnline', 4857, 8, '6分52秒531毫秒', 0.007272180757324904, 0);


09-01 22:13:00 
batch params_list:14, 57ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:07', 300, '15165437420252851535159438336', 413349, 'api', 23026121, 8.0, '/chat/list', 4857, 8, '6分53秒349毫秒', 0.009677052563330261, 32);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:09:22', 300, '15165437420252851535159438336', 217571, 'api', 23026121, 17.0, '/chat/actChat', 4857, 8, '3分37秒571毫秒', 0.004596200780434892, 17);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:07', 300, '15165437420252851535159438336', 413271, 'api', 23026121, 7.5, '/chat/applyData', 4857, 8, '6分53秒271毫秒', 0.004839439496117559, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:14', 300, '15165437420252851535159438336', 405901, 'api', 23026121, 0.0, '/im/turnserver', 4857, 8, '6分45秒901毫秒', 0.002463654930635795, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:07', 300, '15165437420252851535159438336', 413364, 'api', 23026121, 0.0, '/im/imserver', 4857, 8, '6分53秒364毫秒', 0.0024191753515061787, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:07', 300, '15165437420252851535159438336', 412913, 'api', 23026121, 31.5, '/chat/getLastAllNotice', 4857, 8, '6分52秒913毫秒', 0.004843635342069637, 63);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:07', 300, '15165437420252851535159438336', 412884, 'api', 23026121, 11.0, '/friendGroup/list', 4857, 8, '6分52秒884毫秒', 0.007265963321417154, 33);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:07', 300, '15165437420252851535159438336', 413395, 'api', 23026121, 5.0, '/user/curr', 4857, 8, '6分53秒395毫秒', 0.007256981821260537, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:07', 300, '15165437420252851535159438336', 412609, 'api', 23026121, 0.0, '/user/info', 4857, 8, '6分52秒609毫秒', 0.00242360200577302, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(7, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:07', 300, '15165437420252851535159438336', 412913, 'api', 23026121, 4.571428571428571, '/chat/mailList', 4857, 8, '6分52秒913毫秒', 0.01695272369724373, 32);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(10, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:07', 300, '15165437420252851535159438336', 412884, 'api', 23026121, 10.2, '/config/query', 4857, 8, '6分52秒884毫秒', 0.024219877738057175, 102);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:48', 300, '15165437420252851535159438336', 372074, 'api', 23026121, 0.0, '/user/search', 4857, 8, '6分12秒74毫秒', 0.0026876374054623543, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:35', 300, '15165437420252851535159438336', 384675, 'api', 23026121, 0.0, '/chat/applyList', 4857, 8, '6分24秒675毫秒', 0.0025995970624553195, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', '2022-09-01 22:06:07', 300, '15165437420252851535159438336', 412531, 'api', 23026121, 0.0, '/chat/queryOnline', 4857, 8, '6分52秒531毫秒', 0.004848120504883269, 0);


09-01 22:13:05 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:13:05', 3, 2, 0)

09-01 22:13:07 
11ms
insert into  `sms_log`(`referer`, `phone`, `smscode`, `ip24count`, `ip`, `tempcode`, `sessionid`, `type`, `phone24count`, `errormsg`, `status`) values(null, '13723450735', '936080', 2, '172.20.10.2', '', '15165437325152830433044474880', '2', 1, '', 1)

09-01 22:13:10 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:13:10', 3, 2, 0)

09-01 22:13:15 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:13:15', 3, 2, 0)

09-01 22:13:20 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:13:20', 3, 2, 0)

09-01 22:13:25 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:13:25', 3, 2, 0)

09-01 22:13:30 
48ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:13:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:13:30', 3, 2, 0)

09-01 22:13:35 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:13:35', 3, 2, 0)

09-01 22:13:40 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:13:40', 3, 2, 0)

09-01 22:13:45 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:13:45', 3, 2, 0)

09-01 22:13:49 
41ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(15, 0, '172.20.10.4', 5.0, '2022-09-01 22:11:49', 3, 120, 1, 120003, 0, 4861, 2, 2, 3, '2分3毫秒', 1.0, 0, 0, 10)

09-01 22:13:50 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:13:50', 3, 2, 0)

09-01 22:13:55 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:13:55', 3, 2, 0)

09-01 22:14:00 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:14:00', 3, 2, 0)

09-01 22:14:00 
49ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:14:05 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:14:05', 3, 2, 0)

09-01 22:14:06 
49ms
insert into  `sms_log`(`referer`, `phone`, `smscode`, `ip24count`, `ip`, `tempcode`, `sessionid`, `type`, `phone24count`, `errormsg`, `status`) values(null, '13760886509', '714909', 3, '172.20.10.2', '', '15165437325152830433044474880', '2', 1, '', 1)

09-01 22:14:10 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:14:10', 3, 2, 0)

09-01 22:14:15 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:14:15', 3, 2, 0)

09-01 22:14:20 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:14:20', 3, 2, 0)

09-01 22:14:25 
29ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:14:25', 3, 2, 0)

09-01 22:14:30 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:14:30', 3, 2, 0)

09-01 22:14:30 
52ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:14:31 
4ms
insert into  `user`(`createtime`, `reghref`, `loginname`, `phonebindflag`, `avatar`, `nick`, `thirdstatus`, `ipid`, `avatarbig`, `phone`, `registertype`, `id`, `pwd`, `phonepwd`, `status`) values('2022-09-01 22:14:31', null, null, 1, '/user/base/avatar/2022090135/2144361565334814645690368.png', 'Jerrylee', 1, 4861, '/user/base/avatar/2022090135/2144361565334814645690368.png', '13760886509', 3, 16779238, 'aca904fd4a19d36dfdb65665c35608b6', 'aca904fd4a19d36dfdb65665c35608b6', 1)

09-01 22:14:31 
3ms
insert into  `user_base`(`uid`, `email`) values(16779238, null)

09-01 22:14:31 
3ms
insert into  `user_coin`(`uid`) values(16779238)

09-01 22:14:31 
3ms
insert into  `user_role`(`uid`, `rid`, `status`) values(16779238, 2, 1)

09-01 22:14:31 
4ms
insert ignore into  `wx_friend`(`chatindex`, `uid`, `startmsgid`, `frienduid`) values('J', 16779238, null, 16779238)

09-01 22:14:31 
2ms
replace into  `wx_friend_meta`(`uid`, `touid`, `fidkey`) values(16779238, 16779238, '16779238_16779238')

09-01 22:14:31 
2ms
insert ignore into  `wx_chat_user_item`(`linkflag`, `uid`, `chatlinkid`, `chatmode`, `linkid`, `tochatlinkmetaid`, `bizid`, `fidkey`, `chatlinkmetaid`, `tochatlinkid`) values(1, 16779238, null, 1, 2252, null, 16779238, '16779238_16779238', null, null)

09-01 22:14:31 
3ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 16779238, 1, 2)

09-01 22:14:31 
8ms
update user_register_stat set regcount = regcount + 1 where (type = 1 and statbizstr = '20220901') or (type = 2 and statbizstr = '172.20.10.2') or (type = 3 and statbizstr = '20220901' and statbizid = 4861) 

09-01 22:14:35 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:14:35', 3, 2, 0)

09-01 22:14:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:14:40', 3, 2, 0)

09-01 22:14:45 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:14:45', 3, 2, 0)

09-01 22:14:45 
12ms
insert into  `login_log`(`ip`, `appversion`, `sessionid`, `type`, `devicetype`, `hourperiod`, `uid`, `ipid`, `imei`, `time`, `deviceinfo`, `dayperiod`, `timeperiod`) values('172.20.10.2', '3.1', '15165437422450804930493264896', 1, 3, '22', 16779238, 4861, 'a658aec1bd9a411aba1b78d9af8af44c', '2022-09-01 22:14:45', '主-x86_64', '20220901', '22:14')

09-01 22:14:45 
9ms
replace into  `user_last_login_time`(`uid`) values(16779238)

09-01 22:14:45 
7ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 5846, 2, 2)

09-01 22:14:45 
5ms
insert into  `user_token`(`uid`, `devicetype`, `token`) values(16779238, 5, '15165437422450804930493264896')

09-01 22:14:45 
3ms
insert ignore into  `user_ip_login_stat`(`uid`, `totalcount`, `ipid`, `ip`, `dayperiod`) values(16779238, 0, 4861, '172.20.10.2', '20220901')

09-01 22:14:45 
3ms
delete from wx_syn_item where uid = 16779238 and devicetype = 5

09-01 22:14:45 
3ms
update user_ip_login_stat set totalcount = totalcount + 1,hour1 = hour1 + 1 where ip = '172.20.10.2' and uid = 16779238 and dayperiod = '20220901'

09-01 22:14:45 
3ms
update user_ip_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = 3550

09-01 22:14:45 
3ms
update user_ip_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = 3551

09-01 22:14:45 
3ms
insert ignore into  `user_time_login_stat`(`uid`, `totalcount`, `usercount`, `dayperiod`) values(16779238, 0, 1, '20220901')

09-01 22:14:45 
3ms
update user_time_login_stat set totalcount = totalcount + 1,hour22 = hour22 + 1 where uid = 16779238 and dayperiod = '20220901'

09-01 22:14:45 
2ms
insert ignore into  `user_time_login_stat`(`uid`, `totalcount`, `usercount`, `remark`, `dayperiod`) values(16779238, 1, 1, '用户总统计', '-1')

09-01 22:14:45 
3ms
update user_time_login_stat set totalcount = totalcount + 1,usercount = usercount + 1 where id = 1742

09-01 22:14:45 
6ms
update `tio_thread_logs` set `status` = 1  where `id` = 6414

09-01 22:14:50 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:14:50', 4, 3, 0)

09-01 22:14:55 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:14:55', 4, 3, 0)

09-01 22:15:00 
43ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:15:00 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:15:00', 4, 3, 0)

09-01 22:15:01 
43ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1067, 0, '172.20.10.4', 11.0, '2022-09-01 22:13:00', 97, 120, 2, 121234, 0, 4860, 1, 97, 97, '2分1秒234毫秒', 1.0, 0, 0, 1067)

09-01 22:15:02 
43ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(14393, 6, '172.20.10.4', 423.3235294117647, '2022-09-01 22:13:00', 34, 120, 0, 121740, 42, 4861, 12, 21, 21, '2分1秒740毫秒', 0.6176470588235294, 137896, 0, 14393)

09-01 22:15:05 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:15:05', 4, 3, 0)

09-01 22:15:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:15:10', 4, 3, 0)

09-01 22:15:12 
7ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(34, '172.20.10.4', '172.20.10.2', '2022-09-01 22:09:48', 300, '15165437323156852135218865152', 323918, 98708001, 4.147058823529412, null, 4861, 8, '5分23秒918毫秒', 0.10496483677967881, 141)

09-01 22:15:12 
batch params_list:12, 62ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:09:49', 300, '15165437323156852135218865152', 323456, 'api', 98708001, 0.0, '/chat/mailList', 4861, 8, '5分23秒456毫秒', 0.003091610605461021, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:09:49', 300, '15165437323156852135218865152', 323441, 'api', 98708001, 15.0, '/chat/list', 4861, 8, '5分23秒441毫秒', 0.0030917539829520683, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:09:48', 300, '15165437323156852135218865152', 323933, 'api', 98708001, 7.5, '/config/base', 4861, 8, '5分23秒933毫秒', 0.006174116252434918, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:10:25', 300, '15165437323156852135218865152', 287303, 'api', 98708001, 17.0, '/chat/actChat', 4861, 8, '4分47秒303毫秒', 0.0034806458686473863, 17);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(10, '172.20.10.4', '172.20.10.2', '2022-09-01 22:09:48', 300, '15165437323156852135218865152', 323933, 'api', 98708001, 6.2, '/chat/applyData', 4861, 8, '5分23秒933毫秒', 0.030870581262174582, 62);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:09:49', 300, '15165437323156852135218865152', 323627, 'api', 98708001, 0.0, '/im/imserver', 4861, 8, '5分23秒627毫秒', 0.003089977041470582, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:09:48', 300, '15165437323156852135218865152', 323888, 'api', 98708001, 0.0, '/chat/getLastAllNotice', 4861, 8, '5分23秒888毫秒', 0.0030874870325544633, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:10:29', 300, '15165437323156852135218865152', 283662, 'api', 98708001, 0.0, '/chat/inP2pChatInput', 4861, 8, '4分43秒662毫秒', 0.0035253223907326325, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:09:48', 300, '15165437323156852135218865152', 323918, 'api', 98708001, 0.0, '/user/curr', 4861, 8, '5分23秒918毫秒', 0.0030872010817552587, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '172.20.10.2', '2022-09-01 22:09:53', 300, '15165437323156852135218865152', 318940, 'api', 98708001, 5.666666666666667, '/user/info', 4861, 8, '5分18秒940毫秒', 0.009406157898037249, 17);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:09:49', 300, '15165437323156852135218865152', 323627, 'api', 98708001, 0.0, '/sys/version', 4861, 8, '5分23秒627毫秒', 0.003089977041470582, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(11, '172.20.10.4', '172.20.10.2', '2022-09-01 22:09:49', 300, '15165437323156852135218865152', 323658, 'api', 98708001, 1.3636363636363635, '/chat/queryOnline', 4861, 8, '5分23秒658毫秒', 0.033986491914304605, 15);


09-01 22:15:15 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:15:15', 4, 3, 0)

09-01 22:15:20 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:15:20', 4, 3, 0)

09-01 22:15:23 
42ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(20, '172.20.10.4', '127.0.0.1', '2022-09-01 22:10:18', 300, '15161427428658899639962491904', 305271, 98708001, 4.85, null, 4857, 8, '5分5秒271毫秒', 0.065515558307209, 97)

09-01 22:15:23 
batch params_list:12, 66ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', '2022-09-01 22:10:18', 300, '15161427428658899639962491904', 304577, 'api', 98708001, 8.0, '/chat/mailList', 4857, 8, '5分4秒577毫秒', 0.006566484008969817, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', '2022-09-01 22:10:18', 300, '15161427428658899639962491904', 305133, 'api', 98708001, 7.5, '/chat/list', 4857, 8, '5分5秒133毫秒', 0.00655451884915758, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:10:18', 300, '15161427428658899639962491904', 305101, 'api', 98708001, 1.0, '/chat/applyData', 4857, 8, '5分5秒101毫秒', 0.003277603154365276, 1);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:10:18', 300, '15161427428658899639962491904', 305133, 'api', 98708001, 0.0, '/im/imserver', 4857, 8, '5分5秒133毫秒', 0.00327725942457879, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:10:18', 300, '15161427428658899639962491904', 304684, 'api', 98708001, 0.0, '/chat/getLastAllNotice', 4857, 8, '5分4秒684毫秒', 0.0032820889839965343, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '172.20.10.4', '127.0.0.1', '2022-09-01 22:10:18', 300, '15161427428658899639962491904', 304561, 'api', 98708001, 6.4, '/config/query', 4857, 8, '5分4秒561毫秒', 0.016417072441973855, 32);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:10:18', 300, '15161427428658899639962491904', 304561, 'api', 98708001, 16.0, '/friendGroup/list', 4857, 8, '5分4秒561毫秒', 0.0032834144883947714, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:10:44', 300, '15161427428658899639962491904', 279218, 'api', 98708001, 0.0, '/chat/inP2pChatInput', 4857, 8, '4分39秒218毫秒', 0.0035814309965689893, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', '2022-09-01 22:10:18', 300, '15161427428658899639962491904', 305318, 'api', 98708001, 0.0, '/user/curr', 4857, 8, '5分5秒318毫秒', 0.0065505472982267665, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:10:19', 300, '15161427428658899639962491904', 304159, 'api', 98708001, 0.0, '/user/info', 4857, 8, '5分4秒159毫秒', 0.003287754102295181, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', '2022-09-01 22:10:18', 300, '15161427428658899639962491904', 305162, 'api', 98708001, 8.5, '/config/viewmodel', 4857, 8, '5分5秒162毫秒', 0.006553895963455476, 17);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:10:19', 300, '15161427428658899639962491904', 304005, 'api', 98708001, 0.0, '/chat/queryOnline', 4857, 8, '5分4秒5毫秒', 0.003289419581914771, 0);


09-01 22:15:24 
2ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3172


09-01 22:15:24 
2ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3172


09-01 22:15:24 
4ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4860,
		readdevice = 1
	WHERE
		twouid = '98708001_98708001'
		and touid = 98708001
		and readflag = 2
		


09-01 22:15:24 
42ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 98708001, null, '', 1, 1, 2, 98708001, 4860, 1, null, '98708001_98708001', 7, '好友已读你的消息', '2022-09-01 22:15:24', 98708001, 1, 2, 1)

09-01 22:15:24 
8ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(98708001, 3172, 98708001, 2, 1)

09-01 22:15:25 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:15:25', 4, 3, 0)

09-01 22:15:30 
40ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:15:30 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:15:30', 4, 3, 0)

09-01 22:15:35 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:15:35', 4, 3, 0)

09-01 22:15:40 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:15:40', 4, 3, 0)

09-01 22:15:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:15:45', 4, 3, 0)

09-01 22:15:49 
43ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(479, 1, '172.20.10.4', 68.42857142857143, '2022-09-01 22:13:49', 7, 120, 2, 119990, 16, 4861, 2, 8, 7, '1分59秒990毫秒', 1.0, 1206, 0, 484)

09-01 22:15:50 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:15:50', 4, 3, 0)

09-01 22:15:51 
9ms
update chatroom_join_leave set leavetime = '2022-09-01 22:15:51', cost = 333376, status = 1 where id = 22871

09-01 22:15:53 
6ms
insert into  `chatroom_join_leave`(`uid`, `server`, `ipid`, `jointime`, `session`, `groupid`, `device`, `status`) values(98708001, '172.20.10.4', 4860, '2022-09-01 22:15:53', '15161427428658899639962491904', '/home', 1, 9)

09-01 22:15:54 
1ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3172


09-01 22:15:54 
2ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3172


09-01 22:15:54 
3ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4860,
		readdevice = 1
	WHERE
		twouid = '98708001_98708001'
		and touid = 98708001
		and readflag = 2
		


09-01 22:15:54 
5ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 98708001, null, '', 1, 1, 2, 98708001, 4860, 1, null, '98708001_98708001', 7, '好友已读你的消息', '2022-09-01 22:15:54', 98708001, 1, 2, 1)

09-01 22:15:54 
10ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(98708001, 3172, 98708001, 2, 1)

09-01 22:15:55 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:15:55', 4, 3, 0)

09-01 22:16:00 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:16:00', 4, 3, 0)

09-01 22:16:00 
18ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:16:05 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:16:05', 4, 3, 0)

09-01 22:16:10 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:16:10', 4, 3, 0)

09-01 22:16:15 
31ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:16:15', 4, 3, 0)

09-01 22:16:20 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:16:20', 4, 3, 0)

09-01 22:16:25 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:16:25', 4, 3, 0)

09-01 22:16:30 
47ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:16:30 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:16:30', 4, 3, 0)

09-01 22:16:35 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:16:35', 4, 3, 0)

09-01 22:16:40 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:16:40', 4, 3, 0)

09-01 22:16:45 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:16:45', 4, 3, 0)

09-01 22:16:50 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:16:50', 4, 3, 0)

09-01 22:16:55 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:16:55', 4, 3, 0)

09-01 22:17:00 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:17:00', 4, 3, 0)

09-01 22:17:00 
49ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:17:02 
8ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1954, 1, '172.20.10.4', 19.15686274509804, '2022-09-01 22:15:01', 102, 120, 2, 120754, 30, 4860, 1, 102, 102, '2分754毫秒', 1.0, 2934, 0, 1954)

09-01 22:17:05 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:17:05', 4, 3, 0)

09-01 22:17:10 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:17:10', 4, 3, 0)

09-01 22:17:15 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:17:15', 4, 3, 0)

09-01 22:17:20 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:17:20', 4, 3, 0)

09-01 22:17:25 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:17:25', 4, 3, 0)

09-01 22:17:30 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:17:30', 4, 3, 0)

09-01 22:17:30 
7ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:17:35 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:17:35', 4, 3, 0)

09-01 22:17:40 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:17:40', 4, 3, 0)

09-01 22:17:42 
4ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(41812, 41, '172.20.10.4', 1019.8048780487804, '2022-09-01 22:15:23', 41, 120, 0, 139274, 82, 4857, 12, 41, 41, '2分19秒274毫秒', 1.0, 16325, 0, 41812)

09-01 22:17:42 
5ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(15613, 2, '172.20.10.4', 371.73809523809524, '2022-09-01 22:15:02', 42, 120, 0, 160594, 48, 4861, 12, 24, 24, '2分40秒594毫秒', 0.5714285714285714, 5528, 0, 15613)

09-01 22:17:45 
21ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:17:45', 4, 3, 0)

09-01 22:17:48 
11ms
insert into  `yx_user_wallet`(`uid`, `passwd`) values(16779238, 'e10adc3949ba59abbe56e057f20f883e')

09-01 22:17:50 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:17:50', 4, 3, 0)

09-01 22:17:55 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:17:55', 4, 3, 0)

09-01 22:18:00 
73ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:18:00', 4, 3, 0)

09-01 22:18:00 
79ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:18:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:18:05', 4, 3, 0)

09-01 22:18:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:18:10', 4, 3, 0)

09-01 22:18:15 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:18:15', 4, 3, 0)

09-01 22:18:20 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:18:20', 4, 3, 0)

09-01 22:18:25 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:18:25', 4, 3, 0)

09-01 22:18:30 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:18:30', 4, 3, 0)

09-01 22:18:30 
49ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:18:35 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:18:35', 4, 3, 0)

09-01 22:18:40 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:18:40', 4, 3, 0)

09-01 22:18:45 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:18:45', 4, 3, 0)

09-01 22:18:45 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(57, 0, '172.20.10.4', 9.5, '2022-09-01 22:15:49', 6, 120, 2, 176352, 12, 4861, 2, 6, 6, '2分56秒352毫秒', 1.0, 1124, 0, 57)

09-01 22:18:50 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:18:50', 4, 3, 0)

09-01 22:18:55 
26ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:18:55', 4, 3, 0)

09-01 22:19:00 
15ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:19:00 
20ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:19:00', 4, 3, 0)

09-01 22:19:02 
8ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1056, 0, '172.20.10.4', 11.0, '2022-09-01 22:17:02', 96, 120, 2, 120007, 0, 4860, 1, 96, 96, '2分7毫秒', 1.0, 0, 0, 1056)

09-01 22:19:05 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:19:05', 4, 3, 0)

09-01 22:19:10 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:19:10', 4, 3, 0)

09-01 22:19:15 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:19:15', 4, 3, 0)

09-01 22:19:20 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:19:20', 4, 3, 0)

09-01 22:19:23 
34ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(48, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:13:00', 300, 382729, 73.10416666666667, null, 4861, 8, '6分22秒729毫秒', 0.12541511095318097, 3509)

09-01 22:19:23 
batch params_list:23, 76ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:13:05', 300, 377424, 'api', 16.0, '/anjiCaptcha/check', 4861, 8, '6分17秒424毫秒', 0.005299080079698164, 32);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:17:42', 300, 100425, 'api', 0.0, '/wallet/isOpen', 4861, 8, '1分40秒425毫秒', 0.009957679860592481, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:17:48', 300, 94790, 'api', 47.0, '/wallet/open', 4861, 8, '1分34秒790毫秒', 0.010549636037556704, 47);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:14:45', 300, 277309, 'api', 15.0, '/chat/list', 4861, 8, '4分37秒309毫秒', 0.0036060856301093724, 15);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:15:02', 300, 261009, 'api', 10.333333333333334, '/user/search2', 4861, 8, '4分21秒9毫秒', 0.011493856533682746, 31);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:14:45', 300, 277494, 'api', 107.0, '/login', 4861, 8, '4分37秒494毫秒', 0.0036036815210418963, 107);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:13:07', 300, 375390, 'api', 746.0, '/sms/send', 4861, 8, '6分15秒390毫秒', 0.005327792429206958, 1492);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:14:45', 300, 277216, 'api', 0.0, '/chat/applyData', 4861, 8, '4分37秒216毫秒', 0.007214590788410481, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:14:45', 300, 277169, 'api', 0.0, '/chat/getLastAllNotice', 4861, 8, '4分37秒169毫秒', 0.003607907089176639, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:14:31', 300, 291481, 'api', 262.0, '/register/submit', 4861, 8, '4分51秒481毫秒', 0.0034307553494052788, 262);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:16:05', 300, 198121, 'api', 15.0, '/friendGroup/list', 4861, 8, '3分18秒121毫秒', 0.0050474205157454285, 15);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:13:00', 300, 382759, 'api', 0.0, '/sms/beforeCheck', 4861, 8, '6分22秒759毫秒', 0.005225220047079232, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:14:45', 300, 277463, 'api', 0.0, '/user/curr', 4861, 8, '4分37秒463毫秒', 0.007208168296313382, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:15:42', 300, 220432, 'api', 0.0, '/user/info', 4861, 8, '3分40秒432毫秒', 0.004536546417942948, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:17:42', 300, 100425, 'api', 0.0, '/wallet/queryUserWallet', 4861, 8, '1分40秒425毫秒', 0.009957679860592481, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:13:01', 300, 381623, 'api', 629.0, '/anjiCaptcha/get', 4861, 8, '6分21秒623毫秒', 0.005240774271990944, 1258);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:14:45', 300, 277340, 'api', 0.0, '/chat/mailList', 4861, 8, '4分37秒340毫秒', 0.007211365111415591, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:15:03', 300, 260091, 'api', 9.6, '/chat/isFriend', 4861, 8, '4分20秒91毫秒', 0.019224040816483462, 48);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:14:45', 300, 277417, 'api', 7.5, '/config/base', 4861, 8, '4分37秒417毫秒', 0.0072093635213415184, 15);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:15:03', 300, 260029, 'api', 31.0, '/chat/checkAddFriend', 4861, 8, '4分20秒29毫秒', 0.015382899599660037, 124);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:15:51', 300, 211919, 'api', 0.0, '/chat/applyList', 4861, 8, '3分31秒919毫秒', 0.00943756812744492, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:14:46', 300, 277138, 'api', 0.0, '/chat/queryOnline', 4861, 8, '4分37秒138毫秒', 0.018041553305573395, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:15:04', 300, 258627, 'api', 15.75, '/chat/friendApply', 4861, 8, '4分18秒627毫秒', 0.01546628928920801, 63);


09-01 22:19:25 
26ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:19:25', 4, 3, 0)

09-01 22:19:30 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:19:30', 4, 3, 0)

09-01 22:19:30 
45ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:19:35 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:19:35', 4, 3, 0)

09-01 22:19:40 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:19:40', 4, 3, 0)

09-01 22:19:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:19:45', 4, 3, 0)

09-01 22:19:50 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:19:50', 4, 3, 0)

09-01 22:19:55 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:19:55', 4, 3, 0)

09-01 22:20:00 
8ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:20:00 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:20:00', 4, 3, 0)

09-01 22:20:00 
16ms
insert into  `wx_task_items`(`dealtime`, `ip`, `type`, `status`) values('2022-09-01 22:20:00', '172.20.10.4', 1, 2)

09-01 22:20:00 
1ms
delete FROM wx_friend_msg where createtime <= '2022-06-01 22:20:00'

09-01 22:20:00 
4ms
delete FROM wx_group_msg where createtime <= '2022-06-01 22:20:00'

09-01 22:20:00 
1ms
delete from wx_group_msg where groupid not in (select groupid from wx_chat_group_item)

09-01 22:20:00 
29ms
INSERT INTO wx_group_msg_bak SELECT *, now() baktime FROM wx_group_msg WHERE groupid not in (select id from wx_group)  and `status` = 1

09-01 22:20:00 
2ms
update wx_group_msg set `status` = 2 where groupid not in (select id from wx_group)

09-01 22:20:00 
6ms
update `wx_task_items` set `status` = 3  where `id` = 7280

09-01 22:20:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:20:05', 4, 3, 0)

09-01 22:20:10 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:20:10', 4, 3, 0)

09-01 22:20:15 
28ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:20:15', 4, 3, 0)

09-01 22:20:20 
125ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:20:20', 4, 3, 0)

09-01 22:20:25 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:20:25', 4, 3, 0)

09-01 22:20:30 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:20:30', 4, 3, 0)

09-01 22:20:30 
7ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:20:30 
5ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(3917, 4, '172.20.10.4', 326.4166666666667, '2022-09-01 22:17:42', 12, 120, 0, 167869, 12, 4861, 12, 6, 6, '2分47秒869毫秒', 0.5, 1458, 0, 3917)

09-01 22:20:30 
4ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(10, '172.20.10.4', '172.20.10.2', '2022-09-01 22:13:00', 300, '15165437325152830433044474880', 450205, 315.1, null, 4861, 8, '7分30秒205毫秒', 0.02221210337512911, 3151)

09-01 22:20:30 
3ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(15, '172.20.10.4', '172.20.10.2', '2022-09-01 22:15:12', 300, '15165437323156852135218865152', 317740, 98708001, 8.266666666666667, null, 4861, 8, '5分17秒740毫秒', 0.04720840939132624, 124)

09-01 22:20:30 
3ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(41, '172.20.10.4', '127.0.0.1', '2022-09-01 22:15:23', 300, '15161427428658899639962491904', 307151, 98708001, 5.902439024390244, null, 4857, 8, '5分7秒151毫秒', 0.13348483319279442, 242)

09-01 22:20:30 
6ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(26, '172.20.10.4', '172.20.10.2', '2022-09-01 22:14:45', 300, '15165437422450804930493264896', 344909, 16779238, 10.153846153846153, null, 4861, 8, '5分44秒909毫秒', 0.07538220226204594, 264)

09-01 22:20:30 
batch params_list:6, 31ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:13:05', 300, '15165437325152830433044474880', 444901, 'api', 16.0, '/anjiCaptcha/check', 4861, 8, '7分24秒901毫秒', 0.004495382118718546, 32);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:14:45', 300, '15165437325152830433044474880', 344971, 'api', 107.0, '/login', 4861, 8, '5分44秒971毫秒', 0.0028987943914126116, 107);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:13:07', 300, '15165437325152830433044474880', 442867, 'api', 746.0, '/sms/send', 4861, 8, '7分22秒867毫秒', 0.004516028514204039, 1492);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:14:31', 300, '15165437325152830433044474880', 358958, 'api', 262.0, '/register/submit', 4861, 8, '5分58秒958毫秒', 0.0027858412404793875, 262);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:13:00', 300, '15165437325152830433044474880', 450236, 'api', 0.0, '/sms/beforeCheck', 4861, 8, '7分30秒236毫秒', 0.004442114802014944, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:13:01', 300, '15165437325152830433044474880', 449100, 'api', 629.0, '/anjiCaptcha/get', 4861, 8, '7分29秒100毫秒', 0.00445335114673792, 1258);


09-01 22:20:30 
batch params_list:9, 49ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:16:02', 300, '15165437323156852135218865152', 267682, 'api', 98708001, 0.0, '/chat/mailList', 4861, 8, '4分27秒682毫秒', 0.0037357760327552843, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '172.20.10.2', '2022-09-01 22:15:42', 300, '15165437323156852135218865152', 287955, 'api', 98708001, 5.0, '/chat/isFriend', 4861, 8, '4分47秒955毫秒', 0.010418294525186226, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:15:39', 300, '15165437323156852135218865152', 291272, 'api', 98708001, 8.0, '/user/search2', 4861, 8, '4分51秒272毫秒', 0.00686643412343102, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:16:05', 300, '15165437323156852135218865152', 265598, 'api', 98708001, 15.0, '/friendGroup/list', 4861, 8, '4分25秒598毫秒', 0.0037650885925345824, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:15:44', 300, '15165437323156852135218865152', 285713, 'api', 98708001, 31.0, '/chat/checkAddFriend', 4861, 8, '4分45秒713毫秒', 0.00700003150014175, 62);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:15:42', 300, '15165437323156852135218865152', 287909, 'api', 98708001, 0.0, '/user/info', 4861, 8, '4分47秒909毫秒', 0.0034733196947646654, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:15:58', 300, '15165437323156852135218865152', 272319, 'api', 98708001, 0.0, '/chat/applyList', 4861, 8, '4分32秒319毫秒', 0.0036721638960190072, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:15:12', 300, '15165437323156852135218865152', 317771, 'api', 98708001, 0.0, '/chat/queryOnline', 4861, 8, '5分17秒771毫秒', 0.006293840532962417, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:15:46', 300, '15165437323156852135218865152', 283845, 'api', 98708001, 8.0, '/chat/friendApply', 4861, 8, '4分43秒845毫秒', 0.007046099103383889, 16);


09-01 22:20:30 
batch params_list:10, 48ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(11, '172.20.10.4', '127.0.0.1', '2022-09-01 22:15:23', 300, '15161427428658899639962491904', 307027, 'api', 98708001, 3.0, '/chat/mailList', 4857, 8, '5分7秒27毫秒', 0.035827467942558804, 33);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '172.20.10.4', '127.0.0.1', '2022-09-01 22:15:24', 300, '15161427428658899639962491904', 306155, 'api', 98708001, 7.25, '/chat/list', 4857, 8, '5分6秒155毫秒', 0.013065277392170633, 29);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', '2022-09-01 22:15:24', 300, '15161427428658899639962491904', 306109, 'api', 98708001, 0.0, '/chat/applyData', 4857, 8, '5分6秒109毫秒', 0.006533620377055232, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:15:53', 300, '15161427428658899639962491904', 277483, 'api', 98708001, 0.0, '/im/imserver', 4857, 8, '4分37秒483毫秒', 0.0036038243784303906, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', '2022-09-01 22:15:24', 300, '15161427428658899639962491904', 305970, 'api', 98708001, 0.0, '/chat/getLastAllNotice', 4857, 8, '5分5秒970毫秒', 0.006536588554433441, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(10, '172.20.10.4', '127.0.0.1', '2022-09-01 22:15:24', 300, '15161427428658899639962491904', 305909, 'api', 98708001, 14.9, '/config/query', 4857, 8, '5分5秒909毫秒', 0.03268945993743238, 149);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '172.20.10.4', '127.0.0.1', '2022-09-01 22:15:23', 300, '15161427428658899639962491904', 306980, 'api', 98708001, 4.0, '/friendGroup/list', 4857, 8, '5分6秒980毫秒', 0.013030164831585119, 16);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '172.20.10.4', '127.0.0.1', '2022-09-01 22:15:23', 300, '15161427428658899639962491904', 307182, 'api', 98708001, 0.0, '/user/curr', 4857, 8, '5分7秒182毫秒', 0.013021596317492562, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:15:23', 300, '15161427428658899639962491904', 307012, 'api', 98708001, 15.0, '/chat/applyList', 4857, 8, '5分7秒12毫秒', 0.003257201672898779, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', '2022-09-01 22:15:24', 300, '15161427428658899639962491904', 305816, 'api', 98708001, 0.0, '/chat/queryOnline', 4857, 8, '5分5秒816毫秒', 0.006539880189394931, 0);


09-01 22:20:30 
batch params_list:15, 62ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:17:42', 300, '15165437422450804930493264896', 167917, 'api', 16779238, 15.0, '/wallet/isOpen', 4861, 8, '2分47秒917毫秒', 0.011910646331223164, 30);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:17:48', 300, '15165437422450804930493264896', 162282, 'api', 16779238, 47.0, '/wallet/open', 4861, 8, '2分42秒282毫秒', 0.00616211286525924, 47);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:14:45', 300, '15165437422450804930493264896', 344801, 'api', 16779238, 15.0, '/chat/list', 4861, 8, '5分44秒801毫秒', 0.002900223607240118, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:15:02', 300, '15165437422450804930493264896', 328501, 'api', 16779238, 15.0, '/user/search2', 4861, 8, '5分28秒501毫秒', 0.003044130763681085, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:14:45', 300, '15165437422450804930493264896', 344708, 'api', 16779238, 0.0, '/chat/applyData', 4861, 8, '5分44秒708毫秒', 0.005802012137809393, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:14:45', 300, '15165437422450804930493264896', 344661, 'api', 16779238, 0.0, '/chat/getLastAllNotice', 4861, 8, '5分44秒661毫秒', 0.002901401667145398, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:14:45', 300, '15165437422450804930493264896', 344955, 'api', 16779238, 0.0, '/user/curr', 4861, 8, '5分44秒955毫秒', 0.00579785769158296, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:17:42', 300, '15165437422450804930493264896', 167917, 'api', 16779238, 0.0, '/wallet/queryUserWallet', 4861, 8, '2分47秒917毫秒', 0.011910646331223164, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:14:45', 300, '15165437422450804930493264896', 344832, 'api', 16779238, 0.0, '/chat/mailList', 4861, 8, '5分44秒832毫秒', 0.0028999628804751297, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:15:03', 300, '15165437422450804930493264896', 327583, 'api', 16779238, 16.5, '/chat/isFriend', 4861, 8, '5分27秒583毫秒', 0.006105322925792852, 33);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:14:45', 300, '15165437422450804930493264896', 344909, 'api', 16779238, 7.5, '/config/base', 4861, 8, '5分44秒909毫秒', 0.005798630943234302, 15);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:15:03', 300, '15165437422450804930493264896', 327521, 'api', 16779238, 31.0, '/chat/checkAddFriend', 4861, 8, '5分27秒521毫秒', 0.006106478668543391, 62);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:15:51', 300, '15165437422450804930493264896', 279411, 'api', 16779238, 0.0, '/chat/applyList', 4861, 8, '4分39秒411毫秒', 0.0035789571634617105, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '172.20.10.4', '172.20.10.2', '2022-09-01 22:14:46', 300, '15165437422450804930493264896', 344630, 'api', 16779238, 0.0, '/chat/queryOnline', 4861, 8, '5分44秒630毫秒', 0.011606650610799988, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:15:04', 300, '15165437422450804930493264896', 326119, 'api', 16779238, 23.5, '/chat/friendApply', 4861, 8, '5分26秒119毫秒', 0.00613273069033083, 47);


09-01 22:20:35 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:20:35', 4, 3, 0)

09-01 22:20:40 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:20:40', 4, 3, 0)

09-01 22:20:45 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:20:45', 4, 3, 0)

09-01 22:20:45 
42ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 22:18:45', 4, 120, 2, 119997, 0, 4861, 2, 4, 4, '1分59秒997毫秒', 1.0, 0, 0, 20)

09-01 22:20:50 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:20:50', 4, 3, 0)

09-01 22:20:55 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:20:55', 4, 3, 0)

09-01 22:21:00 
102ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:21:00 
133ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:21:00', 4, 3, 0)

09-01 22:21:02 
3ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1056, 0, '172.20.10.4', 11.0, '2022-09-01 22:19:02', 96, 120, 2, 120007, 0, 4860, 1, 96, 96, '2分7毫秒', 1.0, 0, 0, 1056)

09-01 22:21:05 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:21:05', 4, 3, 0)

09-01 22:21:10 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:21:10', 4, 3, 0)

09-01 22:21:15 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:21:15', 4, 3, 0)

09-01 22:21:20 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:21:20', 4, 3, 0)

09-01 22:21:25 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:21:25', 4, 3, 0)

09-01 22:21:30 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:21:30', 4, 3, 0)

09-01 22:21:30 
45ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:21:35 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:21:35', 4, 3, 0)

09-01 22:21:40 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:21:40', 4, 3, 0)

09-01 22:21:45 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:21:45', 4, 3, 0)

09-01 22:21:50 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:21:50', 4, 3, 0)

09-01 22:21:55 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:21:55', 4, 3, 0)

09-01 22:22:00 
40ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:22:00 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:22:00', 4, 3, 0)

09-01 22:22:05 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:22:05', 4, 3, 0)

09-01 22:22:10 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:22:10', 4, 3, 0)

09-01 22:22:15 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:22:15', 4, 3, 0)

09-01 22:22:20 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:22:20', 4, 3, 0)

09-01 22:22:25 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:22:25', 4, 3, 0)

09-01 22:22:30 
45ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:22:30 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:22:30', 4, 3, 0)

09-01 22:22:35 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:22:35', 4, 3, 0)

09-01 22:22:40 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:22:40', 4, 3, 0)

09-01 22:22:45 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:22:45', 4, 3, 0)

09-01 22:22:49 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25, 0, '172.20.10.4', 5.0, '2022-09-01 22:20:45', 5, 120, 2, 123665, 0, 4861, 2, 5, 5, '2分3秒665毫秒', 1.0, 0, 0, 25)

09-01 22:22:50 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:22:50', 4, 3, 0)

09-01 22:22:55 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:22:55', 4, 3, 0)

09-01 22:23:00 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:23:00 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:23:00', 4, 3, 0)

09-01 22:23:03 
8ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1067, 0, '172.20.10.4', 11.0, '2022-09-01 22:21:02', 97, 120, 2, 120989, 0, 4860, 1, 97, 97, '2分989毫秒', 1.0, 0, 0, 1067)

09-01 22:23:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:23:05', 4, 3, 0)

09-01 22:23:10 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:23:10', 4, 3, 0)

09-01 22:23:15 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:23:15', 4, 3, 0)

09-01 22:23:20 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:23:20', 4, 3, 0)

09-01 22:23:25 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:23:25', 4, 3, 0)

09-01 22:23:30 
43ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:23:30 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:23:30', 4, 3, 0)

09-01 22:23:35 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:23:35', 4, 3, 0)

09-01 22:23:40 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:23:40', 4, 3, 0)

09-01 22:23:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:23:45', 4, 3, 0)

09-01 22:23:50 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:23:50', 4, 3, 0)

09-01 22:23:55 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:23:55', 4, 3, 0)

09-01 22:24:00 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:24:00', 4, 3, 0)

09-01 22:24:00 
16ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:24:05 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:24:05', 4, 3, 0)

09-01 22:24:10 
26ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:24:10', 4, 3, 0)

09-01 22:24:15 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:24:15', 4, 3, 0)

09-01 22:24:20 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:24:20', 4, 3, 0)

09-01 22:24:25 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:24:25', 4, 3, 0)

09-01 22:24:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:24:30', 4, 3, 0)

09-01 22:24:30 
53ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:24:35 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:24:35', 4, 3, 0)

09-01 22:24:40 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:24:40', 4, 3, 0)

09-01 22:24:45 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:24:45', 4, 3, 0)

09-01 22:24:50 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:24:50', 4, 3, 0)

09-01 22:24:55 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:24:55', 4, 3, 0)

09-01 22:25:00 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:25:00', 4, 3, 0)

09-01 22:25:00 
8ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:25:03 
5ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1056, 0, '172.20.10.4', 11.0, '2022-09-01 22:23:03', 96, 120, 2, 120000, 0, 4860, 1, 96, 96, '2分', 1.0, 0, 0, 1056)

09-01 22:25:05 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:25:05', 4, 3, 0)

09-01 22:25:10 
26ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:25:10', 4, 3, 0)

09-01 22:25:15 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:25:15', 4, 3, 0)

09-01 22:25:20 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:25:20', 4, 3, 0)

09-01 22:25:25 
40ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:25:25', 4, 3, 0)

09-01 22:25:30 
10ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:25:30 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:25:30', 4, 3, 0)

09-01 22:25:35 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:25:35', 4, 3, 0)

09-01 22:25:40 
26ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:25:40', 4, 3, 0)

09-01 22:25:45 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:25:45', 4, 3, 0)

09-01 22:25:45 
42ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25, 0, '172.20.10.4', 5.0, '2022-09-01 22:22:49', 5, 120, 2, 176327, 0, 4861, 2, 5, 5, '2分56秒327毫秒', 1.0, 0, 0, 25)

09-01 22:25:50 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:25:50', 4, 3, 0)

09-01 22:25:55 
27ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:25:55', 4, 3, 0)

09-01 22:26:00 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:26:00', 4, 3, 0)

09-01 22:26:00 
44ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:26:05 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:26:05', 4, 3, 0)

09-01 22:26:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:26:10', 4, 3, 0)

09-01 22:26:15 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:26:15', 4, 3, 0)

09-01 22:26:20 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:26:20', 4, 3, 0)

09-01 22:26:25 
28ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:26:25', 4, 3, 0)

09-01 22:26:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:26:30', 4, 3, 0)

09-01 22:26:30 
52ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:26:35 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:26:35', 4, 3, 0)

09-01 22:26:40 
27ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:26:40', 4, 3, 0)

09-01 22:26:45 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:26:45', 4, 3, 0)

09-01 22:26:50 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:26:50', 4, 3, 0)

09-01 22:26:55 
25ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:26:55', 4, 3, 0)

09-01 22:27:00 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:27:00', 4, 3, 0)

09-01 22:27:00 
14ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:27:04 
5ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1067, 0, '172.20.10.4', 11.0, '2022-09-01 22:25:03', 97, 120, 2, 120995, 0, 4860, 1, 97, 97, '2分995毫秒', 1.0, 0, 0, 1067)

09-01 22:27:05 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:27:05', 4, 3, 0)

09-01 22:27:10 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:27:10', 4, 3, 0)

09-01 22:27:15 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:27:15', 4, 3, 0)

09-01 22:27:20 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:27:20', 4, 3, 0)

09-01 22:27:25 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:27:25', 4, 3, 0)

09-01 22:27:30 
44ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:27:30 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:27:30', 4, 3, 0)

09-01 22:27:35 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:27:35', 4, 3, 0)

09-01 22:27:40 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:27:40', 4, 3, 0)

09-01 22:27:45 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:27:45', 4, 3, 0)

09-01 22:27:46 
42ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 22:25:45', 4, 120, 2, 120189, 0, 4861, 2, 4, 4, '2分189毫秒', 1.0, 0, 0, 20)

09-01 22:27:50 
40ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:27:50', 4, 3, 0)

09-01 22:27:55 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:27:55', 4, 3, 0)

09-01 22:28:00 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:28:00', 4, 3, 0)

09-01 22:28:00 
10ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:28:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:28:05', 4, 3, 0)

09-01 22:28:10 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:28:10', 4, 3, 0)

09-01 22:28:15 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:28:15', 4, 3, 0)

09-01 22:28:20 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:28:20', 4, 3, 0)

09-01 22:28:25 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:28:25', 4, 3, 0)

09-01 22:28:30 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:28:30', 4, 3, 0)

09-01 22:28:30 
48ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:28:35 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:28:35', 4, 3, 0)

09-01 22:28:40 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:28:40', 4, 3, 0)

09-01 22:28:45 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:28:45', 4, 3, 0)

09-01 22:28:50 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:28:50', 4, 3, 0)

09-01 22:28:55 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:28:55', 4, 3, 0)

09-01 22:29:00 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:29:00', 4, 3, 0)

09-01 22:29:00 
10ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:29:05 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:29:05', 4, 3, 0)

09-01 22:29:05 
6ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1067, 0, '172.20.10.4', 11.0, '2022-09-01 22:27:04', 97, 120, 2, 121001, 0, 4860, 1, 97, 97, '2分1秒1毫秒', 1.0, 0, 0, 1067)

09-01 22:29:10 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:29:10', 4, 3, 0)

09-01 22:29:15 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:29:15', 4, 3, 0)

09-01 22:29:20 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:29:20', 4, 3, 0)

09-01 22:29:25 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:29:25', 4, 3, 0)

09-01 22:29:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:29:30', 4, 3, 0)

09-01 22:29:30 
51ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:29:35 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:29:35', 4, 3, 0)

09-01 22:29:40 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:29:40', 4, 3, 0)

09-01 22:29:45 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:29:45', 4, 3, 0)

09-01 22:29:49 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25, 0, '172.20.10.4', 5.0, '2022-09-01 22:27:46', 5, 120, 2, 123416, 0, 4861, 2, 5, 5, '2分3秒416毫秒', 1.0, 0, 0, 25)

09-01 22:29:50 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:29:50', 4, 3, 0)

09-01 22:29:55 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:29:55', 4, 3, 0)

09-01 22:30:00 
16ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:30:00 
15ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:30:00', 4, 3, 0)

09-01 22:30:05 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:30:05', 4, 3, 0)

09-01 22:30:10 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:30:10', 4, 3, 0)

09-01 22:30:15 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:30:15', 4, 3, 0)

09-01 22:30:20 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:30:20', 4, 3, 0)

09-01 22:30:25 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:30:25', 4, 3, 0)

09-01 22:30:30 
40ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:30:30 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:30:30', 4, 3, 0)

09-01 22:30:35 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:30:35', 4, 3, 0)

09-01 22:30:40 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:30:40', 4, 3, 0)

09-01 22:30:45 
28ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:30:45', 4, 3, 0)

09-01 22:30:50 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:30:50', 4, 3, 0)

09-01 22:30:55 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:30:55', 4, 3, 0)

09-01 22:31:00 
7ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:31:00 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:31:00', 4, 3, 0)

09-01 22:31:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:31:05', 4, 3, 0)

09-01 22:31:07 
5ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1067, 0, '172.20.10.4', 11.0, '2022-09-01 22:29:05', 97, 120, 2, 121994, 0, 4860, 1, 97, 97, '2分1秒994毫秒', 1.0, 0, 0, 1067)

09-01 22:31:10 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:31:10', 4, 3, 0)

09-01 22:31:15 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:31:15', 4, 3, 0)

09-01 22:31:20 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:31:20', 4, 3, 0)

09-01 22:31:25 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:31:25', 4, 3, 0)

09-01 22:31:30 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:31:30', 4, 3, 0)

09-01 22:31:30 
45ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:31:35 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:31:35', 4, 3, 0)

09-01 22:31:40 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:31:40', 4, 3, 0)

09-01 22:31:45 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:31:45', 4, 3, 0)

09-01 22:31:50 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:31:50', 4, 3, 0)

09-01 22:31:55 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:31:55', 4, 3, 0)

09-01 22:32:00 
7ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:32:00 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:32:00', 4, 3, 0)

09-01 22:32:05 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:32:05', 4, 3, 0)

09-01 22:32:10 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:32:10', 4, 3, 0)

09-01 22:32:15 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:32:15', 4, 3, 0)

09-01 22:32:20 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:32:20', 4, 3, 0)

09-01 22:32:25 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:32:25', 4, 3, 0)

09-01 22:32:30 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:32:30', 4, 3, 0)

09-01 22:32:30 
42ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:32:35 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:32:35', 4, 3, 0)

09-01 22:32:40 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:32:40', 4, 3, 0)

09-01 22:32:45 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:32:45', 4, 3, 0)

09-01 22:32:45 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25, 0, '172.20.10.4', 5.0, '2022-09-01 22:29:49', 5, 120, 2, 176412, 0, 4861, 2, 5, 5, '2分56秒412毫秒', 1.0, 0, 0, 25)

09-01 22:32:50 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:32:50', 4, 3, 0)

09-01 22:32:55 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:32:55', 4, 3, 0)

09-01 22:33:00 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:33:00', 4, 3, 0)

09-01 22:33:00 
12ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:33:05 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:33:05', 4, 3, 0)

09-01 22:33:07 
23ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1056, 0, '172.20.10.4', 11.0, '2022-09-01 22:31:07', 96, 120, 2, 120002, 0, 4860, 1, 96, 96, '2分2毫秒', 1.0, 0, 0, 1056)

09-01 22:33:10 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:33:10', 4, 3, 0)

09-01 22:33:15 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:33:15', 4, 3, 0)

09-01 22:33:20 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:33:20', 4, 3, 0)

09-01 22:33:25 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:33:25', 4, 3, 0)

09-01 22:33:30 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:33:30', 4, 3, 0)

09-01 22:33:30 
42ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:33:35 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:33:35', 4, 3, 0)

09-01 22:33:40 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:33:40', 4, 3, 0)

09-01 22:33:45 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:33:45', 4, 3, 0)

09-01 22:33:50 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:33:50', 4, 3, 0)

09-01 22:33:55 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:33:55', 4, 3, 0)

09-01 22:34:00 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:34:00', 4, 3, 0)

09-01 22:34:00 
48ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:34:05 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:34:05', 4, 3, 0)

09-01 22:34:10 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:34:10', 4, 3, 0)

09-01 22:34:15 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:34:15', 4, 3, 0)

09-01 22:34:20 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:34:20', 4, 3, 0)

09-01 22:34:25 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:34:25', 4, 3, 0)

09-01 22:34:30 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:34:30', 4, 3, 0)

09-01 22:34:30 
42ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:34:35 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:34:35', 4, 3, 0)

09-01 22:34:40 
30ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:34:40', 4, 3, 0)

09-01 22:34:45 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:34:45', 4, 3, 0)

09-01 22:34:45 
44ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 22:32:45', 4, 120, 2, 120007, 0, 4861, 2, 4, 4, '2分7毫秒', 1.0, 0, 0, 20)

09-01 22:34:50 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:34:50', 4, 3, 0)

09-01 22:34:55 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:34:55', 4, 3, 0)

09-01 22:35:00 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:35:00', 4, 3, 0)

09-01 22:35:00 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:35:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:35:05', 4, 3, 0)

09-01 22:35:07 
4ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1067, 0, '172.20.10.4', 11.0, '2022-09-01 22:33:07', 97, 120, 2, 119997, 0, 4860, 1, 96, 97, '1分59秒997毫秒', 1.0, 0, 0, 1056)

09-01 22:35:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:35:10', 4, 3, 0)

09-01 22:35:15 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:35:15', 4, 3, 0)

09-01 22:35:20 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:35:20', 4, 3, 0)

09-01 22:35:25 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:35:25', 4, 3, 0)

09-01 22:35:30 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:35:30', 4, 3, 0)

09-01 22:35:30 
44ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:35:35 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:35:35', 4, 3, 0)

09-01 22:35:40 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:35:40', 4, 3, 0)

09-01 22:35:45 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:35:45', 4, 3, 0)

09-01 22:35:50 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:35:50', 4, 3, 0)

09-01 22:35:55 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:35:55', 4, 3, 0)

09-01 22:36:00 
38ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:36:00 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:36:00', 4, 3, 0)

09-01 22:36:05 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:36:05', 4, 3, 0)

09-01 22:36:10 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:36:10', 4, 3, 0)

09-01 22:36:15 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:36:15', 4, 3, 0)

09-01 22:36:20 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:36:20', 4, 3, 0)

09-01 22:36:25 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:36:25', 4, 3, 0)

09-01 22:36:30 
8ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:36:30 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:36:30', 4, 3, 0)

09-01 22:36:35 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:36:35', 4, 3, 0)

09-01 22:36:40 
21ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:36:40', 4, 3, 0)

09-01 22:36:45 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:36:45', 4, 3, 0)

09-01 22:36:45 
6ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 22:34:45', 4, 120, 2, 119996, 0, 4861, 2, 4, 4, '1分59秒996毫秒', 1.0, 0, 0, 20)

09-01 22:36:50 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:36:50', 4, 3, 0)

09-01 22:36:55 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:36:55', 4, 3, 0)

09-01 22:37:00 
35ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:37:00 
36ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:37:00', 4, 3, 0)

09-01 22:37:05 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:37:05', 4, 3, 0)

09-01 22:37:08 
6ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1056, 0, '172.20.10.4', 11.0, '2022-09-01 22:35:07', 96, 120, 2, 120991, 0, 4860, 1, 97, 96, '2分991毫秒', 1.0, 0, 0, 1067)

09-01 22:37:10 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:37:10', 4, 3, 0)

09-01 22:37:15 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:37:15', 4, 3, 0)

09-01 22:37:20 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:37:20', 4, 3, 0)

09-01 22:37:25 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:37:25', 4, 3, 0)

09-01 22:37:30 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:37:30', 4, 3, 0)

09-01 22:37:30 
7ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:37:35 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:37:35', 4, 3, 0)

09-01 22:37:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:37:40', 4, 3, 0)

09-01 22:37:45 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:37:45', 4, 3, 0)

09-01 22:37:50 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:37:50', 4, 3, 0)

09-01 22:37:55 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:37:55', 4, 3, 0)

09-01 22:38:00 
42ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:38:00 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:38:00', 4, 3, 0)

09-01 22:38:05 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:38:05', 4, 3, 0)

09-01 22:38:10 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:38:10', 4, 3, 0)

09-01 22:38:15 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:38:15', 4, 3, 0)

09-01 22:38:20 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:38:20', 4, 3, 0)

09-01 22:38:25 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:38:25', 4, 3, 0)

09-01 22:38:30 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:38:30', 4, 3, 0)

09-01 22:38:30 
50ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:38:35 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:38:35', 4, 3, 0)

09-01 22:38:40 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:38:40', 4, 3, 0)

09-01 22:38:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:38:45', 4, 3, 0)

09-01 22:38:49 
6ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25, 0, '172.20.10.4', 5.0, '2022-09-01 22:36:45', 5, 120, 2, 123505, 0, 4861, 2, 5, 5, '2分3秒505毫秒', 1.0, 0, 0, 25)

09-01 22:38:50 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:38:50', 4, 3, 0)

09-01 22:38:55 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:38:55', 4, 3, 0)

09-01 22:39:00 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:39:00', 4, 3, 0)

09-01 22:39:00 
47ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:39:05 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:39:05', 4, 3, 0)

09-01 22:39:08 
42ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1067, 0, '172.20.10.4', 11.0, '2022-09-01 22:37:08', 97, 120, 2, 120002, 0, 4860, 1, 96, 97, '2分2毫秒', 1.0, 0, 0, 1056)

09-01 22:39:10 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:39:10', 4, 3, 0)

09-01 22:39:15 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:39:15', 4, 3, 0)

09-01 22:39:20 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:39:20', 4, 3, 0)

09-01 22:39:25 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:39:25', 4, 3, 0)

09-01 22:39:30 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:39:30', 4, 3, 0)

09-01 22:39:30 
51ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:39:35 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:39:35', 4, 3, 0)

09-01 22:39:40 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:39:40', 4, 3, 0)

09-01 22:39:45 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:39:45', 4, 3, 0)

09-01 22:39:50 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:39:50', 4, 3, 0)

09-01 22:39:55 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:39:55', 4, 3, 0)

09-01 22:40:00 
17ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:40:00 
28ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 4, 2, '2022-09-01 22:40:00', 4, 3, 0)

09-01 22:40:03 
8ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1282, 1, '172.20.10.4', 320.5, '2022-09-01 22:20:30', 4, 120, 0, 1172544, 4, 4861, 12, 2, 2, '19分32秒544毫秒', 0.5, 380, 0, 1282)

09-01 22:40:03 
15ms
delete from user_token where uid=23026121 and devicetype=1 and token='15165437420252851535159438336'

09-01 22:40:03 
9ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(5, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:19:23', 300, 1240057, 9.0, null, 4861, 8, '20分40秒57毫秒', 0.004032072719237906, 45)

09-01 22:40:03 
6ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(41, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:15:23', 300, 1479732, 5.902439024390244, null, 4857, 8, '24分39秒732毫秒', 0.027707720046603036, 242)

09-01 22:40:03 
7ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:20:30', 300, '15165437323156852135218865152', 1172581, 98708001, 7.5, null, 4861, 8, '19分32秒581毫秒', 0.0017056390987061874, 15)

09-01 22:40:03 
batch params_list:5, 37ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:19:23', 300, 1240027, 'api', 30.0, '/wallet/isOpen', 4861, 8, '20分40秒27毫秒', 8.064340534520619E-4, 30);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:20:30', 300, 1172581, 'api', 0.0, '/chat/isFriend', 4861, 8, '19分32秒581毫秒', 8.528195493530937E-4, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:20:30', 300, 1172535, 'api', 15.0, '/chat/checkAddFriend', 4861, 8, '19分32秒535毫秒', 8.528530065200612E-4, 15);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:19:23', 300, 1240057, 'api', 0.0, '/wallet/queryUserWallet', 4861, 8, '20分40秒57毫秒', 8.064145438475812E-4, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:19:42', 300, 1221075, 'api', 0.0, '/chat/queryOnline', 4861, 8, '20分21秒75毫秒', 8.189505149151363E-4, 0);


09-01 22:40:03 
14ms
update chatroom_join_leave set leavetime = '2022-09-01 22:40:03', cost = 2036157, status = 1 where id = 22870

09-01 22:40:03 
batch params_list:2, 24ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:20:30', 300, '15165437323156852135218865152', 1172597, 'api', 98708001, 0.0, '/chat/isFriend', 4861, 8, '19分32秒597毫秒', 8.528079126929371E-4, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:20:30', 300, '15165437323156852135218865152', 1172551, 'api', 98708001, 15.0, '/chat/checkAddFriend', 4861, 8, '19分32秒551毫秒', 8.528413689468518E-4, 15);


09-01 22:40:03 
batch params_list:10, 88ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(11, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:15:23', 300, 1479593, 'api', 3.0, '/chat/mailList', 4857, 8, '24分39秒593毫秒', 0.007434476913583668, 33);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:15:24', 300, 1478721, 'api', 7.25, '/chat/list', 4857, 8, '24分38秒721毫秒', 0.002705040369346212, 29);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:15:24', 300, 1478675, 'api', 0.0, '/chat/applyData', 4857, 8, '24分38秒675毫秒', 0.0013525622601315366, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:15:53', 300, 1450049, 'api', 0.0, '/im/imserver', 4857, 8, '24分10秒49毫秒', 6.896318676127497E-4, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:15:24', 300, 1478536, 'api', 0.0, '/chat/getLastAllNotice', 4857, 8, '24分38秒536毫秒', 0.0013526894170990764, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(10, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:15:24', 300, 1478475, 'api', 14.9, '/config/query', 4857, 8, '24分38秒475毫秒', 0.006763726136728724, 149);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:15:23', 300, 1479546, 'api', 4.0, '/friendGroup/list', 4857, 8, '24分39秒546毫秒', 0.0027035320294198353, 16);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:15:23', 300, 1479748, 'api', 0.0, '/user/curr', 4857, 8, '24分39秒748毫秒', 0.0027031629709923584, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:15:23', 300, 1479578, 'api', 15.0, '/chat/applyList', 4857, 8, '24分39秒578毫秒', 6.758683895002494E-4, 15);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:15:24', 300, 1478382, 'api', 0.0, '/chat/queryOnline', 4857, 8, '24分38秒382毫秒', 0.0013528303239622778, 0);


09-01 22:40:05 
17ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:40:05', 3, 2, 0)

09-01 22:40:10 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:40:10', 3, 2, 0)

09-01 22:40:15 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:40:15', 3, 2, 0)

09-01 22:40:20 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:40:20', 3, 2, 0)

09-01 22:40:25 
27ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:40:25', 3, 2, 0)

09-01 22:40:30 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:40:30', 3, 2, 0)

09-01 22:40:30 
10ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:40:35 
23ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:40:35', 3, 2, 0)

09-01 22:40:40 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:40:40', 3, 2, 0)

09-01 22:40:45 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:40:45', 3, 2, 0)

09-01 22:40:49 
44ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 22:38:49', 4, 120, 2, 120092, 0, 4861, 2, 4, 4, '2分92毫秒', 1.0, 0, 0, 20)

09-01 22:40:50 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:40:50', 3, 2, 0)

09-01 22:40:55 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:40:55', 3, 2, 0)

09-01 22:41:00 
57ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:41:00', 3, 2, 0)

09-01 22:41:00 
62ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:41:05 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:41:05', 3, 2, 0)

09-01 22:41:09 
44ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(819, 0, '172.20.10.4', 11.375, '2022-09-01 22:39:08', 72, 120, 1, 120992, 4, 4860, 1, 73, 72, '2分992毫秒', 1.0, 84, 0, 830)

09-01 22:41:10 
20ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:41:10', 3, 2, 0)

09-01 22:41:15 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:41:15', 3, 2, 0)

09-01 22:41:20 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:41:20', 3, 2, 0)

09-01 22:41:25 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:41:25', 3, 2, 0)

09-01 22:41:30 
49ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:41:30 
51ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:41:30', 3, 2, 0)

09-01 22:41:35 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:41:35', 3, 2, 0)

09-01 22:41:40 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:41:40', 3, 2, 0)

09-01 22:41:45 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:41:45', 3, 2, 0)

09-01 22:41:50 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:41:50', 3, 2, 0)

09-01 22:41:55 
37ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:41:55', 3, 2, 0)

09-01 22:42:00 
14ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:42:00', 3, 2, 0)

09-01 22:42:00 
15ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:42:05 
39ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:42:05', 3, 2, 0)

09-01 22:42:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:42:10', 3, 2, 0)

09-01 22:42:15 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:42:15', 3, 2, 0)

09-01 22:42:20 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:42:20', 3, 2, 0)

09-01 22:42:25 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:42:25', 3, 2, 0)

09-01 22:42:30 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:42:30 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:42:30', 3, 2, 0)

09-01 22:42:35 
40ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:42:35', 3, 2, 0)

09-01 22:42:40 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:42:40', 3, 2, 0)

09-01 22:42:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:42:45', 3, 2, 0)

09-01 22:42:49 
43ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 22:40:49', 4, 120, 2, 120001, 0, 4861, 2, 4, 4, '2分1毫秒', 1.0, 0, 0, 20)

09-01 22:42:50 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:42:50', 3, 2, 0)

09-01 22:42:55 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:42:55', 3, 2, 0)

09-01 22:43:00 
40ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:43:00 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:43:00', 3, 2, 0)

09-01 22:43:05 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:43:05', 3, 2, 0)

09-01 22:43:09 
32ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(528, 0, '172.20.10.4', 11.0, '2022-09-01 22:41:09', 48, 120, 1, 120003, 0, 4860, 1, 48, 48, '2分3毫秒', 1.0, 0, 0, 528)

09-01 22:43:10 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:43:10', 3, 2, 0)

09-01 22:43:15 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:43:15', 3, 2, 0)

09-01 22:43:20 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:43:20', 3, 2, 0)

09-01 22:43:25 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:43:25', 3, 2, 0)

09-01 22:43:30 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:43:30', 3, 2, 0)

09-01 22:43:30 
11ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:43:35 
40ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:43:35', 3, 2, 0)

09-01 22:43:40 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:43:40', 3, 2, 0)

09-01 22:43:45 
24ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:43:45', 3, 2, 0)

09-01 22:43:50 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:43:50', 3, 2, 0)

09-01 22:43:55 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:43:55', 3, 2, 0)

09-01 22:44:00 
6ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:44:00 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:44:00', 3, 2, 0)

09-01 22:44:05 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:44:05', 3, 2, 0)

09-01 22:44:10 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:44:10', 3, 2, 0)

09-01 22:44:15 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:44:15', 3, 2, 0)

09-01 22:44:20 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:44:20', 3, 2, 0)

09-01 22:44:25 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:44:25', 3, 2, 0)

09-01 22:44:30 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:44:30', 3, 2, 0)

09-01 22:44:30 
49ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:44:35 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:44:35', 3, 2, 0)

09-01 22:44:40 
37ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:44:40', 3, 2, 0)

09-01 22:44:45 
32ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:44:45', 3, 2, 0)

09-01 22:44:50 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:44:50', 3, 2, 0)

09-01 22:44:50 
44ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 22:42:49', 4, 120, 2, 120807, 0, 4861, 2, 4, 4, '2分807毫秒', 1.0, 0, 0, 20)

09-01 22:44:55 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:44:55', 3, 2, 0)

09-01 22:45:00 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:45:00 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:45:00', 3, 2, 0)

09-01 22:45:05 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:45:05', 3, 2, 0)

09-01 22:45:09 
42ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(539, 0, '172.20.10.4', 11.0, '2022-09-01 22:43:09', 49, 120, 1, 119999, 0, 4860, 1, 48, 49, '1分59秒999毫秒', 1.0, 0, 0, 528)

09-01 22:45:10 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:45:10', 3, 2, 0)

09-01 22:45:15 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:45:15', 3, 2, 0)

09-01 22:45:20 
20ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:45:20', 3, 2, 0)

09-01 22:45:25 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:45:25', 3, 2, 0)

09-01 22:45:30 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:45:30', 3, 2, 0)

09-01 22:45:30 
10ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:45:35 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:45:35', 3, 2, 0)

09-01 22:45:40 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:45:40', 3, 2, 0)

09-01 22:45:45 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:45:45', 3, 2, 0)

09-01 22:45:50 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:45:50', 3, 2, 0)

09-01 22:45:55 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:45:55', 3, 2, 0)

09-01 22:46:00 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:46:00', 3, 2, 0)

09-01 22:46:00 
48ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:46:05 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:46:05', 3, 2, 0)

09-01 22:46:10 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:46:10', 3, 2, 0)

09-01 22:46:15 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:46:15', 3, 2, 0)

09-01 22:46:20 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:46:20', 3, 2, 0)

09-01 22:46:25 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:46:25', 3, 2, 0)

09-01 22:46:30 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:46:30', 3, 2, 0)

09-01 22:46:30 
10ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:46:35 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:46:35', 3, 2, 0)

09-01 22:46:40 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:46:40', 3, 2, 0)

09-01 22:46:45 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:46:45', 3, 2, 0)

09-01 22:46:50 
23ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:46:50', 3, 2, 0)

09-01 22:46:55 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:46:55', 3, 2, 0)

09-01 22:47:00 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:47:00', 3, 2, 0)

09-01 22:47:00 
13ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:47:05 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:47:05', 3, 2, 0)

09-01 22:47:09 
6ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(528, 0, '172.20.10.4', 11.0, '2022-09-01 22:45:09', 48, 120, 1, 119995, 0, 4860, 1, 48, 48, '1分59秒995毫秒', 1.0, 0, 0, 528)

09-01 22:47:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:47:10', 3, 2, 0)

09-01 22:47:15 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:47:15', 3, 2, 0)

09-01 22:47:20 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:47:20', 3, 2, 0)

09-01 22:47:25 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:47:25', 3, 2, 0)

09-01 22:47:28 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25, 0, '172.20.10.4', 5.0, '2022-09-01 22:44:50', 5, 120, 2, 157790, 0, 4861, 2, 5, 5, '2分37秒790毫秒', 1.0, 0, 0, 25)

09-01 22:47:28 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(5133, 4, '172.20.10.4', 1283.25, '2022-09-01 22:40:03', 4, 120, 0, 444970, 8, 4857, 12, 4, 4, '7分24秒970毫秒', 1.0, 1369, 0, 5133)

09-01 22:47:28 
6ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '172.20.10.4', '127.0.0.1', '2022-09-01 22:40:03', 300, '15165437420252851535159438336', 444962, 7.5, null, 4857, 8, '7分24秒962毫秒', 0.008989531690346591, 30)

09-01 22:47:28 
5ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(4, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:40:03', 300, 444962, 7.5, null, 4857, 8, '7分24秒962毫秒', 0.008989531690346591, 30)

09-01 22:47:28 
batch params_list:3, 18ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:40:03', 300, '15165437420252851535159438336', 444978, 'api', 30.0, '/logout', 4857, 8, '7分24秒978毫秒', 0.002247302113812368, 30);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', '2022-09-01 22:40:04', 300, '15165437420252851535159438336', 443629, 'api', 0.0, '/user/curr', 4857, 8, '7分23秒629毫秒', 0.004508271551228617, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', '2022-09-01 22:40:04', 300, '15165437420252851535159438336', 443598, 'api', 0.0, '/config/viewmodel', 4857, 8, '7分23秒598毫秒', 0.0022542933015928836, 0);


09-01 22:47:28 
batch params_list:3, 16ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:40:03', 300, 444978, 'api', 30.0, '/logout', 4857, 8, '7分24秒978毫秒', 0.002247302113812368, 30);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:40:04', 300, 443629, 'api', 0.0, '/user/curr', 4857, 8, '7分23秒629毫秒', 0.004508271551228617, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '127.0.0.1', 0, '2022-09-01 22:40:04', 300, 443598, 'api', 0.0, '/config/viewmodel', 4857, 8, '7分23秒598毫秒', 0.0022542933015928836, 0);


09-01 22:47:29 
4ms
	UPDATE wx_chat_items_meta
	SET 
		readflag = 1,
		notreadcount = 0,
	 	notreadstartmsgid = null
	WHERE
		id = 3172


09-01 22:47:29 
4ms
	UPDATE wx_chat_items_meta
	SET 
		toreadflag = 1
	WHERE
		id = 3172


09-01 22:47:29 
4ms
	UPDATE wx_friend_msg
	SET 
		readflag = 1,
		readtime = now(),
		readipid = 4861,
		readdevice = 5
	WHERE
		twouid = '98708001_98708001'
		and touid = 98708001
		and readflag = 2
		


09-01 22:47:29 
8ms
insert into  `wx_friend_oper_msg`(`resume`, `frommsgid`, `touid`, `session`, `operbizdata`, `sendbysys`, `contenttype`, `readflag`, `uid`, `ipid`, `sigleflag`, `frommode`, `twouid`, `oper`, `text`, `time`, `sigleuid`, `device`, `msgtype`, `status`) values('好友已读你的消息', null, 98708001, null, '', 1, 1, 2, 98708001, 4861, 1, null, '98708001_98708001', 7, '好友已读你的消息', '2022-09-01 22:47:29', 98708001, 5, 2, 1)

09-01 22:47:29 
10ms
insert into  `wx_read_ack`(`uid`, `chatlinkid`, `touid`, `type`, `devicetype`) values(98708001, 3172, 98708001, 2, 5)

09-01 22:47:30 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:47:30', 3, 2, 0)

09-01 22:47:30 
12ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:47:35 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:47:35', 3, 2, 0)

09-01 22:47:40 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:47:40', 3, 2, 0)

09-01 22:47:45 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:47:45', 3, 2, 0)

09-01 22:47:50 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:47:50', 3, 2, 0)

09-01 22:47:55 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:47:55', 3, 2, 0)

09-01 22:48:00 
8ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:48:00 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:48:00', 3, 2, 0)

09-01 22:48:05 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:48:05', 3, 2, 0)

09-01 22:48:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:48:10', 3, 2, 0)

09-01 22:48:15 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:48:15', 3, 2, 0)

09-01 22:48:20 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:48:20', 3, 2, 0)

09-01 22:48:25 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:48:25', 3, 2, 0)

09-01 22:48:30 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:48:30', 3, 2, 0)

09-01 22:48:30 
14ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:48:35 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:48:35', 3, 2, 0)

09-01 22:48:40 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:48:40', 3, 2, 0)

09-01 22:48:45 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:48:45', 3, 2, 0)

09-01 22:48:50 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:48:50', 3, 2, 0)

09-01 22:48:55 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:48:55', 3, 2, 0)

09-01 22:49:00 
26ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:49:00', 3, 2, 0)

09-01 22:49:00 
28ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:49:05 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:49:05', 3, 2, 0)

09-01 22:49:09 
39ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(528, 0, '172.20.10.4', 11.0, '2022-09-01 22:47:09', 48, 120, 1, 119997, 4, 4860, 1, 48, 48, '1分59秒997毫秒', 1.0, 193, 0, 528)

09-01 22:49:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:49:10', 3, 2, 0)

09-01 22:49:15 
23ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:49:15', 3, 2, 0)

09-01 22:49:20 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:49:20', 3, 2, 0)

09-01 22:49:25 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:49:25', 3, 2, 0)

09-01 22:49:30 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:49:30', 3, 2, 0)

09-01 22:49:30 
8ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:49:35 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:49:35', 3, 2, 0)

09-01 22:49:40 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:49:40', 3, 2, 0)

09-01 22:49:45 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:49:45', 3, 2, 0)

09-01 22:49:45 
6ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(100, 0, '172.20.10.4', 16.666666666666668, '2022-09-01 22:47:28', 6, 120, 2, 137725, 6, 4861, 2, 6, 6, '2分17秒725毫秒', 1.0, 1004, 0, 100)

09-01 22:49:50 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:49:50', 3, 2, 0)

09-01 22:49:55 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:49:55', 3, 2, 0)

09-01 22:50:00 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:50:00', 3, 2, 0)

09-01 22:50:00 
14ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:50:05 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:50:05', 3, 2, 0)

09-01 22:50:10 
26ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:50:10', 3, 2, 0)

09-01 22:50:15 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:50:15', 3, 2, 0)

09-01 22:50:20 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:50:20', 3, 2, 0)

09-01 22:50:25 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:50:25', 3, 2, 0)

09-01 22:50:30 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:50:30', 3, 2, 0)

09-01 22:50:30 
8ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:50:35 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:50:35', 3, 2, 0)

09-01 22:50:40 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:50:40', 3, 2, 0)

09-01 22:50:45 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:50:45', 3, 2, 0)

09-01 22:50:50 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:50:50', 3, 2, 0)

09-01 22:50:55 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:50:55', 3, 2, 0)

09-01 22:51:00 
16ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:51:00 
16ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:51:00', 3, 2, 0)

09-01 22:51:05 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:51:05', 3, 2, 0)

09-01 22:51:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:51:10', 3, 2, 0)

09-01 22:51:12 
9ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(528, 0, '172.20.10.4', 11.0, '2022-09-01 22:49:09', 48, 120, 1, 122991, 0, 4860, 1, 49, 48, '2分2秒991毫秒', 1.0, 0, 0, 539)

09-01 22:51:15 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:51:15', 3, 2, 0)

09-01 22:51:20 
27ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:51:20', 3, 2, 0)

09-01 22:51:25 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:51:25', 3, 2, 0)

09-01 22:51:30 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:51:30', 3, 2, 0)

09-01 22:51:30 
6ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:51:35 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:51:35', 3, 2, 0)

09-01 22:51:40 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:51:40', 3, 2, 0)

09-01 22:51:45 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:51:45', 3, 2, 0)

09-01 22:51:45 
6ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 22:49:45', 4, 120, 2, 120010, 0, 4861, 2, 4, 4, '2分10毫秒', 1.0, 0, 0, 20)

09-01 22:51:50 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:51:50', 3, 2, 0)

09-01 22:51:55 
40ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:51:55', 3, 2, 0)

09-01 22:52:00 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:52:00', 3, 2, 0)

09-01 22:52:00 
11ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:52:05 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:52:05', 3, 2, 0)

09-01 22:52:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:52:10', 3, 2, 0)

09-01 22:52:15 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:52:15', 3, 2, 0)

09-01 22:52:20 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:52:20', 3, 2, 0)

09-01 22:52:25 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:52:25', 3, 2, 0)

09-01 22:52:30 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:52:30', 3, 2, 0)

09-01 22:52:30 
8ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:52:35 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:52:35', 3, 2, 0)

09-01 22:52:40 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:52:40', 3, 2, 0)

09-01 22:52:45 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:52:45', 3, 2, 0)

09-01 22:52:50 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:52:50', 3, 2, 0)

09-01 22:52:55 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:52:55', 3, 2, 0)

09-01 22:53:00 
10ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:53:00 
15ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:53:00', 3, 2, 0)

09-01 22:53:05 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:53:05', 3, 2, 0)

09-01 22:53:10 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:53:10', 3, 2, 0)

09-01 22:53:12 
5ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(528, 0, '172.20.10.4', 11.0, '2022-09-01 22:51:12', 48, 120, 1, 120004, 0, 4860, 1, 48, 48, '2分4毫秒', 1.0, 0, 0, 528)

09-01 22:53:15 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:53:15', 3, 2, 0)

09-01 22:53:20 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:53:20', 3, 2, 0)

09-01 22:53:25 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:53:25', 3, 2, 0)

09-01 22:53:30 
10ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:53:30 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:53:30', 3, 2, 0)

09-01 22:53:35 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:53:35', 3, 2, 0)

09-01 22:53:40 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:53:40', 3, 2, 0)

09-01 22:53:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:53:45', 3, 2, 0)

09-01 22:53:45 
6ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 22:51:45', 4, 120, 2, 120035, 0, 4861, 2, 4, 4, '2分35毫秒', 1.0, 0, 0, 20)

09-01 22:53:50 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:53:50', 3, 2, 0)

09-01 22:53:55 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:53:55', 3, 2, 0)

09-01 22:54:00 
52ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:54:00', 3, 2, 0)

09-01 22:54:00 
57ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:54:05 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:54:05', 3, 2, 0)

09-01 22:54:10 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:54:10', 3, 2, 0)

09-01 22:54:15 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:54:15', 3, 2, 0)

09-01 22:54:20 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:54:20', 3, 2, 0)

09-01 22:54:25 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:54:25', 3, 2, 0)

09-01 22:54:30 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:54:30', 3, 2, 0)

09-01 22:54:30 
11ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:54:35 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:54:35', 3, 2, 0)

09-01 22:54:40 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:54:40', 3, 2, 0)

09-01 22:54:45 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:54:45', 3, 2, 0)

09-01 22:54:50 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:54:50', 3, 2, 0)

09-01 22:54:55 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:54:55', 3, 2, 0)

09-01 22:55:00 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:55:00', 3, 2, 0)

09-01 22:55:00 
57ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:55:05 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:55:05', 3, 2, 0)

09-01 22:55:10 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:55:10', 3, 2, 0)

09-01 22:55:14 
42ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(539, 0, '172.20.10.4', 11.0, '2022-09-01 22:53:12', 49, 120, 1, 121990, 0, 4860, 1, 49, 49, '2分1秒990毫秒', 1.0, 0, 0, 539)

09-01 22:55:15 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:55:15', 3, 2, 0)

09-01 22:55:20 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:55:20', 3, 2, 0)

09-01 22:55:25 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:55:25', 3, 2, 0)

09-01 22:55:30 
14ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:55:30 
14ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:55:30', 3, 2, 0)

09-01 22:55:35 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:55:35', 3, 2, 0)

09-01 22:55:40 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:55:40', 3, 2, 0)

09-01 22:55:45 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:55:45', 3, 2, 0)

09-01 22:55:49 
40ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25, 0, '172.20.10.4', 5.0, '2022-09-01 22:53:45', 5, 120, 2, 123647, 0, 4861, 2, 5, 5, '2分3秒647毫秒', 1.0, 0, 0, 25)

09-01 22:55:50 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:55:50', 3, 2, 0)

09-01 22:55:55 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:55:55', 3, 2, 0)

09-01 22:56:00 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:56:00', 3, 2, 0)

09-01 22:56:00 
17ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:56:05 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:56:05', 3, 2, 0)

09-01 22:56:10 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:56:10', 3, 2, 0)

09-01 22:56:15 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:56:15', 3, 2, 0)

09-01 22:56:20 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:56:20', 3, 2, 0)

09-01 22:56:25 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:56:25', 3, 2, 0)

09-01 22:56:30 
52ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:56:30 
51ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:56:30', 3, 2, 0)

09-01 22:56:35 
51ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:56:35', 3, 2, 0)

09-01 22:56:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:56:40', 3, 2, 0)

09-01 22:56:45 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:56:45', 3, 2, 0)

09-01 22:56:50 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:56:50', 3, 2, 0)

09-01 22:56:55 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:56:55', 3, 2, 0)

09-01 22:57:00 
16ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:57:00 
20ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:57:00', 3, 2, 0)

09-01 22:57:05 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:57:05', 3, 2, 0)

09-01 22:57:10 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:57:10', 3, 2, 0)

09-01 22:57:14 
8ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(528, 0, '172.20.10.4', 11.0, '2022-09-01 22:55:14', 48, 120, 1, 120005, 0, 4860, 1, 48, 48, '2分5毫秒', 1.0, 0, 0, 528)

09-01 22:57:15 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:57:15', 3, 2, 0)

09-01 22:57:20 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:57:20', 3, 2, 0)

09-01 22:57:25 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:57:25', 3, 2, 0)

09-01 22:57:30 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:57:30', 3, 2, 0)

09-01 22:57:30 
44ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:57:35 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:57:35', 3, 2, 0)

09-01 22:57:40 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:57:40', 3, 2, 0)

09-01 22:57:45 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:57:45', 3, 2, 0)

09-01 22:57:50 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:57:50', 3, 2, 0)

09-01 22:57:55 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:57:55', 3, 2, 0)

09-01 22:58:00 
10ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:58:00 
15ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:58:00', 3, 2, 0)

09-01 22:58:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:58:05', 3, 2, 0)

09-01 22:58:10 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:58:10', 3, 2, 0)

09-01 22:58:15 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:58:15', 3, 2, 0)

09-01 22:58:20 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:58:20', 3, 2, 0)

09-01 22:58:25 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:58:25', 3, 2, 0)

09-01 22:58:30 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:58:30', 3, 2, 0)

09-01 22:58:30 
50ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:58:35 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:58:35', 3, 2, 0)

09-01 22:58:40 
20ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:58:40', 3, 2, 0)

09-01 22:58:45 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:58:45', 3, 2, 0)

09-01 22:58:46 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25, 0, '172.20.10.4', 5.0, '2022-09-01 22:55:49', 5, 120, 2, 176454, 0, 4861, 2, 5, 5, '2分56秒454毫秒', 1.0, 0, 0, 25)

09-01 22:58:50 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:58:50', 3, 2, 0)

09-01 22:58:55 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:58:55', 3, 2, 0)

09-01 22:59:00 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:59:00', 3, 2, 0)

09-01 22:59:00 
16ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:59:05 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:59:05', 3, 2, 0)

09-01 22:59:10 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:59:10', 3, 2, 0)

09-01 22:59:14 
39ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(528, 0, '172.20.10.4', 11.0, '2022-09-01 22:57:14', 48, 120, 1, 120001, 0, 4860, 1, 48, 48, '2分1毫秒', 1.0, 0, 0, 528)

09-01 22:59:15 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:59:15', 3, 2, 0)

09-01 22:59:20 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:59:20', 3, 2, 0)

09-01 22:59:25 
53ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:59:25', 3, 2, 0)

09-01 22:59:30 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:59:30', 3, 2, 0)

09-01 22:59:30 
13ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 22:59:35 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:59:35', 3, 2, 0)

09-01 22:59:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:59:40', 3, 2, 0)

09-01 22:59:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:59:45', 3, 2, 0)

09-01 22:59:50 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:59:50', 3, 2, 0)

09-01 22:59:55 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 22:59:55', 3, 2, 0)

09-01 23:00:00 
35ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:00:00', 3, 2, 0)

09-01 23:00:00 
38ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:00:05 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:00:05', 3, 2, 0)

09-01 23:00:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:00:10', 3, 2, 0)

09-01 23:00:15 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:00:15', 3, 2, 0)

09-01 23:00:20 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:00:20', 3, 2, 0)

09-01 23:00:25 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:00:25', 3, 2, 0)

09-01 23:00:30 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:00:30', 3, 2, 0)

09-01 23:00:30 
12ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:00:35 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:00:35', 3, 2, 0)

09-01 23:00:40 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:00:40', 3, 2, 0)

09-01 23:00:45 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:00:45', 3, 2, 0)

09-01 23:00:49 
10ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25, 0, '172.20.10.4', 5.0, '2022-09-01 22:58:46', 5, 120, 2, 123461, 0, 4861, 2, 5, 5, '2分3秒461毫秒', 1.0, 0, 0, 25)

09-01 23:00:50 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:00:50', 3, 2, 0)

09-01 23:00:55 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:00:55', 3, 2, 0)

09-01 23:01:00 
41ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:01:00 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:01:00', 3, 2, 0)

09-01 23:01:05 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:01:05', 3, 2, 0)

09-01 23:01:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:01:10', 3, 2, 0)

09-01 23:01:14 
43ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(539, 0, '172.20.10.4', 11.0, '2022-09-01 22:59:14', 49, 120, 1, 119995, 0, 4860, 1, 48, 49, '1分59秒995毫秒', 1.0, 0, 0, 528)

09-01 23:01:15 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:01:15', 3, 2, 0)

09-01 23:01:20 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:01:20', 3, 2, 0)

09-01 23:01:25 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:01:25', 3, 2, 0)

09-01 23:01:30 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:01:30', 3, 2, 0)

09-01 23:01:30 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:01:35 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:01:35', 3, 2, 0)

09-01 23:01:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:01:40', 3, 2, 0)

09-01 23:01:45 
29ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:01:45', 3, 2, 0)

09-01 23:01:50 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:01:50', 3, 2, 0)

09-01 23:01:55 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:01:55', 3, 2, 0)

09-01 23:02:00 
37ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:02:00', 3, 2, 0)

09-01 23:02:00 
41ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:02:05 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:02:05', 3, 2, 0)

09-01 23:02:10 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:02:10', 3, 2, 0)

09-01 23:02:15 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:02:15', 3, 2, 0)

09-01 23:02:20 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:02:20', 3, 2, 0)

09-01 23:02:25 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:02:25', 3, 2, 0)

09-01 23:02:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:02:30', 3, 2, 0)

09-01 23:02:30 
50ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:02:35 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:02:35', 3, 2, 0)

09-01 23:02:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:02:40', 3, 2, 0)

09-01 23:02:45 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:02:45', 3, 2, 0)

09-01 23:02:49 
13ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 23:00:49', 4, 120, 2, 120004, 0, 4861, 2, 4, 4, '2分4毫秒', 1.0, 0, 0, 20)

09-01 23:02:50 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:02:50', 3, 2, 0)

09-01 23:02:55 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:02:55', 3, 2, 0)

09-01 23:03:00 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:03:00', 3, 2, 0)

09-01 23:03:00 
50ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:03:05 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:03:05', 3, 2, 0)

09-01 23:03:10 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:03:10', 3, 2, 0)

09-01 23:03:15 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:03:15', 3, 2, 0)

09-01 23:03:17 
42ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(528, 0, '172.20.10.4', 11.0, '2022-09-01 23:01:14', 48, 120, 1, 122982, 0, 4860, 1, 49, 48, '2分2秒982毫秒', 1.0, 0, 0, 539)

09-01 23:03:20 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:03:20', 3, 2, 0)

09-01 23:03:25 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:03:25', 3, 2, 0)

09-01 23:03:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:03:30', 3, 2, 0)

09-01 23:03:30 
50ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:03:35 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:03:35', 3, 2, 0)

09-01 23:03:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:03:40', 3, 2, 0)

09-01 23:03:45 
17ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:03:45', 3, 2, 0)

09-01 23:03:50 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:03:50', 3, 2, 0)

09-01 23:03:55 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:03:55', 3, 2, 0)

09-01 23:04:00 
14ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:04:00', 3, 2, 0)

09-01 23:04:00 
19ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:04:05 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:04:05', 3, 2, 0)

09-01 23:04:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:04:10', 3, 2, 0)

09-01 23:04:15 
14ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:04:15', 3, 2, 0)

09-01 23:04:20 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:04:20', 3, 2, 0)

09-01 23:04:25 
28ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:04:25', 3, 2, 0)

09-01 23:04:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:04:30', 3, 2, 0)

09-01 23:04:30 
49ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:04:35 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:04:35', 3, 2, 0)

09-01 23:04:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:04:40', 3, 2, 0)

09-01 23:04:45 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:04:45', 3, 2, 0)

09-01 23:04:49 
8ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 23:02:49', 4, 120, 2, 120114, 0, 4861, 2, 4, 4, '2分114毫秒', 1.0, 0, 0, 20)

09-01 23:04:50 
51ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:04:50', 3, 2, 0)

09-01 23:04:55 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:04:55', 3, 2, 0)

09-01 23:05:00 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:05:00', 3, 2, 0)

09-01 23:05:00 
47ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:05:05 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:05:05', 3, 2, 0)

09-01 23:05:10 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:05:10', 3, 2, 0)

09-01 23:05:15 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:05:15', 3, 2, 0)

09-01 23:05:17 
40ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(528, 0, '172.20.10.4', 11.0, '2022-09-01 23:03:17', 48, 120, 1, 119999, 0, 4860, 1, 48, 48, '1分59秒999毫秒', 1.0, 0, 0, 528)

09-01 23:05:20 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:05:20', 3, 2, 0)

09-01 23:05:25 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:05:25', 3, 2, 0)

09-01 23:05:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:05:30', 3, 2, 0)

09-01 23:05:30 
52ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:05:35 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:05:35', 3, 2, 0)

09-01 23:05:40 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:05:40', 3, 2, 0)

09-01 23:05:45 
37ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:05:45', 3, 2, 0)

09-01 23:05:50 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:05:50', 3, 2, 0)

09-01 23:05:55 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:05:55', 3, 2, 0)

09-01 23:06:00 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:06:00', 3, 2, 0)

09-01 23:06:00 
50ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:06:05 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:06:05', 3, 2, 0)

09-01 23:06:10 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:06:10', 3, 2, 0)

09-01 23:06:15 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:06:15', 3, 2, 0)

09-01 23:06:20 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:06:20', 3, 2, 0)

09-01 23:06:25 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:06:25', 3, 2, 0)

09-01 23:06:30 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:06:30', 3, 2, 0)

09-01 23:06:30 
52ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:06:35 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:06:35', 3, 2, 0)

09-01 23:06:40 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:06:40', 3, 2, 0)

09-01 23:06:45 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:06:45', 3, 2, 0)

09-01 23:06:50 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:06:50', 3, 2, 0)

09-01 23:06:55 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:06:55', 3, 2, 0)

09-01 23:07:00 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:07:00', 3, 2, 0)

09-01 23:07:00 
44ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:07:05 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:07:05', 3, 2, 0)

09-01 23:07:10 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:07:10', 3, 2, 0)

09-01 23:07:15 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:07:15', 3, 2, 0)

09-01 23:07:17 
5ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(528, 0, '172.20.10.4', 11.0, '2022-09-01 23:05:17', 48, 120, 1, 120007, 0, 4860, 1, 48, 48, '2分7毫秒', 1.0, 0, 0, 528)

09-01 23:07:20 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:07:20', 3, 2, 0)

09-01 23:07:25 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:07:25', 3, 2, 0)

09-01 23:07:30 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:07:30', 3, 2, 0)

09-01 23:07:30 
45ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:07:35 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:07:35', 3, 2, 0)

09-01 23:07:40 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:07:40', 3, 2, 0)

09-01 23:07:45 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:07:45', 3, 2, 0)

09-01 23:07:45 
43ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25, 0, '172.20.10.4', 5.0, '2022-09-01 23:04:49', 5, 120, 2, 176215, 0, 4861, 2, 5, 5, '2分56秒215毫秒', 1.0, 0, 0, 25)

09-01 23:07:50 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:07:50', 3, 2, 0)

09-01 23:07:55 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:07:55', 3, 2, 0)

09-01 23:08:00 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:08:00', 3, 2, 0)

09-01 23:08:00 
45ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:08:05 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:08:05', 3, 2, 0)

09-01 23:08:10 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:08:10', 3, 2, 0)

09-01 23:08:15 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:08:15', 3, 2, 0)

09-01 23:08:20 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:08:20', 3, 2, 0)

09-01 23:08:25 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:08:25', 3, 2, 0)

09-01 23:08:30 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:08:30', 3, 2, 0)

09-01 23:08:30 
47ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:08:35 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:08:35', 3, 2, 0)

09-01 23:08:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:08:40', 3, 2, 0)

09-01 23:08:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:08:45', 3, 2, 0)

09-01 23:08:50 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:08:50', 3, 2, 0)

09-01 23:08:55 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:08:55', 3, 2, 0)

09-01 23:09:00 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:09:00', 3, 2, 0)

09-01 23:09:00 
19ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:09:05 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:09:05', 3, 2, 0)

09-01 23:09:10 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:09:10', 3, 2, 0)

09-01 23:09:15 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:09:15', 3, 2, 0)

09-01 23:09:17 
6ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(539, 0, '172.20.10.4', 11.0, '2022-09-01 23:07:17', 49, 120, 1, 119996, 0, 4860, 1, 48, 49, '1分59秒996毫秒', 1.0, 0, 0, 528)

09-01 23:09:20 
24ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:09:20', 3, 2, 0)

09-01 23:10:17 
52568ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:09:25', 3, 2, 0)

09-01 23:10:17 
125ms
update chatroom_join_leave set leavetime = '2022-09-01 23:10:17', cost = 3264287, status = 1 where id = 22872

09-01 23:10:17 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 23:07:45', 4, 120, 2, 151710, 0, 4861, 2, 4, 4, '2分31秒710毫秒', 1.0, 0, 0, 20)

09-01 23:10:18 
132ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(1892, 2, '172.20.10.4', 473.0, '2022-09-01 22:47:28', 4, 120, 0, 1370273, 6, 4861, 12, 3, 3, '22分50秒273毫秒', 0.75, 872, 0, 1892)

09-01 23:10:18 
88ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:47:28', 300, 1370421, 0.0, null, 4861, 8, '22分50秒421毫秒', 0.002189108310511879, 0)

09-01 23:10:18 
17ms
insert into  `chatroom_join_leave`(`uid`, `server`, `ipid`, `jointime`, `session`, `groupid`, `device`, `status`) values(98708001, '172.20.10.4', 4860, '2022-09-01 23:10:18', '15161427428658899639962491904', '/group', 1, 9)

09-01 23:10:18 
126ms
insert into  `login_log`(`ip`, `appversion`, `sessionid`, `type`, `devicetype`, `hourperiod`, `uid`, `ipid`, `imei`, `time`, `deviceinfo`, `dayperiod`, `timeperiod`) values('172.20.10.4', null, '15161427428658899639962491904', 2, 1, '23', 98708001, 4860, '1', '2022-09-01 23:10:18', '自-Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36', '20220901', '23:10')

09-01 23:10:18 
batch params_list:2, 140ms
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:47:29', 300, 1369362, 'api', 0.0, '/user/info', 4861, 8, '22分49秒362毫秒', 7.30267087884723E-4, 0);
insert into  `tio_ip_path_access_stat`(`requestCount`, `server`, `ip`, `noSessionCount`, `firstAccessTime`, `durationType`, `duration`, `restype`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', 0, '2022-09-01 22:47:28', 300, 1370549, 'api', 0.0, '/chat/queryOnline', 4861, 8, '22分50秒549毫秒', 0.0014592692417418128, 0);


09-01 23:10:18 
46ms
replace into  `user_last_login_time`(`uid`) values(98708001)

09-01 23:10:18 
42ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(3, '172.20.10.4', '172.20.10.2', '2022-09-01 22:47:28', 300, '15165437323156852135218865152', 1370421, 98708001, 0.0, null, 4861, 8, '22分50秒421毫秒', 0.002189108310511879, 0)

09-01 23:10:18 
33ms
insert into  `tio_thread_logs`(`bizstr`, `bizint`, `type`, `status`) values('', 5847, 2, 2)

09-01 23:10:18 
batch params_list:2, 63ms
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(1, '172.20.10.4', '172.20.10.2', '2022-09-01 22:47:29', 300, '15165437323156852135218865152', 1369556, 'api', 98708001, 0.0, '/user/info', 4861, 8, '22分49秒556毫秒', 7.301636442759551E-4, 0);
insert into  `tio_token_path_access_stat`(`requestCount`, `server`, `ip`, `firstAccessTime`, `durationType`, `token`, `duration`, `restype`, `uid`, `timeCostPerRequest`, `path`, `ipid`, `appType`, `formatedDuration`, `requestCountPerSecond`, `timeCost`) values(2, '172.20.10.4', '172.20.10.2', '2022-09-01 22:47:28', 300, '15165437323156852135218865152', 1370743, 'api', 98708001, 0.0, '/chat/queryOnline', 4861, 8, '22分50秒743毫秒', 0.001459062712703986, 0);


09-01 23:10:18 
2ms
update user_ip_login_stat set totalcount = totalcount + 1,hour1 = hour1 + 1 where ip = '172.20.10.4' and uid = 98708001 and dayperiod = '20220901'

09-01 23:10:18 
1ms
update user_ip_login_stat set totalcount = totalcount + 1 where id = 3553

09-01 23:10:18 
2ms
update user_ip_login_stat set totalcount = totalcount + 1 where id = 3554

09-01 23:10:18 
6ms
update user_time_login_stat set totalcount = totalcount + 1,hour23 = hour23 + 1 where uid = 98708001 and dayperiod = '20220901'

09-01 23:10:18 
1ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1737 

09-01 23:10:18 
2ms
update user_time_login_stat set totalcount = totalcount + 1 where id = 1742

09-01 23:10:19 
12ms
update `tio_thread_logs` set `status` = 1  where `id` = 6415

09-01 23:10:20 
5ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:10:20 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:20', 3, 2, 0)

09-01 23:10:20 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:20', 3, 2, 0)

09-01 23:10:20 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:20', 3, 2, 0)

09-01 23:10:20 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:20', 3, 2, 0)

09-01 23:10:20 
1ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:10:20 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:20', 3, 2, 0)

09-01 23:10:20 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:20', 3, 2, 0)

09-01 23:10:20 
4ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:20', 3, 2, 0)

09-01 23:10:20 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:20', 3, 2, 0)

09-01 23:10:21 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:20', 3, 2, 0)

09-01 23:10:21 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:20', 3, 2, 0)

09-01 23:10:21 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:20', 3, 2, 0)

09-01 23:10:25 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:25', 3, 2, 0)

09-01 23:10:30 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:10:30 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:30', 3, 2, 0)

09-01 23:10:35 
52ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:35', 3, 2, 0)

09-01 23:10:40 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:40', 3, 2, 0)

09-01 23:10:45 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:45', 3, 2, 0)

09-01 23:10:50 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:50', 3, 2, 0)

09-01 23:10:55 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:10:55', 3, 2, 0)

09-01 23:11:00 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:11:00', 3, 2, 0)

09-01 23:11:00 
11ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:11:05 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:11:05', 3, 2, 0)

09-01 23:11:10 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:11:10', 3, 2, 0)

09-01 23:11:15 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:11:15', 3, 2, 0)

09-01 23:11:20 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:11:20', 3, 2, 0)

09-01 23:11:25 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:11:25', 3, 2, 0)

09-01 23:11:30 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:11:30', 3, 2, 0)

09-01 23:11:30 
8ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:11:35 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:11:35', 3, 2, 0)

09-01 23:11:40 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:11:40', 3, 2, 0)

09-01 23:11:45 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:11:45', 3, 2, 0)

09-01 23:11:50 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:11:50', 3, 2, 0)

09-01 23:11:55 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:11:55', 3, 2, 0)

09-01 23:12:00 
35ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:12:00', 3, 2, 0)

09-01 23:12:00 
38ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:12:05 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:12:05', 3, 2, 0)

09-01 23:12:05 
4ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(650, 1, '172.20.10.4', 92.85714285714286, '2022-09-01 23:09:17', 7, 120, 1, 167997, 2, 4860, 1, 8, 7, '2分47秒997毫秒', 1.0, 228, 0, 661)

09-01 23:12:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:12:10', 3, 2, 0)

09-01 23:12:15 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:12:15', 3, 2, 0)

09-01 23:12:20 
23ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:12:20', 3, 2, 0)

09-01 23:12:25 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:12:25', 3, 2, 0)

09-01 23:12:30 
44ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:12:30 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:12:30', 3, 2, 0)

09-01 23:12:35 
24ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:12:35', 3, 2, 0)

09-01 23:12:40 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:12:40', 3, 2, 0)

09-01 23:12:45 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:12:45', 3, 2, 0)

09-01 23:12:47 
41ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(30, 0, '172.20.10.4', 5.0, '2022-09-01 23:10:17', 6, 120, 2, 149432, 2, 4861, 2, 6, 6, '2分29秒432毫秒', 1.0, 48, 0, 30)

09-01 23:12:50 
26ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:12:50', 3, 2, 0)

09-01 23:12:55 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:12:55', 3, 2, 0)

09-01 23:13:00 
45ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:13:00 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:13:00', 3, 2, 0)

09-01 23:13:05 
24ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:13:05', 3, 2, 0)

09-01 23:13:10 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:13:10', 3, 2, 0)

09-01 23:13:15 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:13:15', 3, 2, 0)

09-01 23:13:20 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:13:20', 3, 2, 0)

09-01 23:13:25 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:13:25', 3, 2, 0)

09-01 23:13:30 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:13:30 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:13:30', 3, 2, 0)

09-01 23:13:35 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:13:35', 3, 2, 0)

09-01 23:13:40 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:13:40', 3, 2, 0)

09-01 23:13:45 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:13:45', 3, 2, 0)

09-01 23:13:50 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:13:50', 3, 2, 0)

09-01 23:13:55 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:13:55', 3, 2, 0)

09-01 23:14:00 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:14:00', 3, 2, 0)

09-01 23:14:00 
45ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:14:05 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:14:05', 3, 2, 0)

09-01 23:14:05 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(33, 0, '172.20.10.4', 11.0, '2022-09-01 23:12:05', 3, 120, 1, 119993, 0, 4860, 1, 2, 3, '1分59秒993毫秒', 1.0, 0, 0, 22)

09-01 23:14:10 
17ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:14:10', 3, 2, 0)

09-01 23:14:15 
33ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:14:15', 3, 2, 0)

09-01 23:14:20 
5ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:14:20', 3, 2, 0)

09-01 23:14:25 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:14:25', 3, 2, 0)

09-01 23:14:30 
43ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:14:30 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:14:30', 3, 2, 0)

09-01 23:14:35 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:14:35', 3, 2, 0)

09-01 23:14:40 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:14:40', 3, 2, 0)

09-01 23:14:45 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:14:45', 3, 2, 0)

09-01 23:14:49 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25, 0, '172.20.10.4', 5.0, '2022-09-01 23:12:46', 5, 120, 2, 122727, 0, 4861, 2, 5, 5, '2分2秒727毫秒', 1.0, 0, 0, 25)

09-01 23:14:50 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:14:50', 3, 2, 0)

09-01 23:14:55 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:14:55', 3, 2, 0)

09-01 23:15:00 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:15:00', 3, 2, 0)

09-01 23:15:00 
47ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:15:05 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:15:05', 3, 2, 0)

09-01 23:15:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:15:10', 3, 2, 0)

09-01 23:15:15 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:15:15', 3, 2, 0)

09-01 23:15:20 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:15:20', 3, 2, 0)

09-01 23:15:25 
38ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:15:25', 3, 2, 0)

09-01 23:15:30 
42ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:15:30 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:15:30', 3, 2, 0)

09-01 23:15:35 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:15:35', 3, 2, 0)

09-01 23:15:40 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:15:40', 3, 2, 0)

09-01 23:15:45 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:15:45', 3, 2, 0)

09-01 23:15:50 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:15:50', 3, 2, 0)

09-01 23:15:55 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:15:55', 3, 2, 0)

09-01 23:16:00 
38ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:16:00 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:16:00', 3, 2, 0)

09-01 23:16:05 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:16:05', 3, 2, 0)

09-01 23:16:05 
9ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(22, 0, '172.20.10.4', 11.0, '2022-09-01 23:14:05', 2, 120, 1, 119995, 0, 4860, 1, 2, 2, '1分59秒995毫秒', 1.0, 0, 0, 22)

09-01 23:16:10 
26ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:16:10', 3, 2, 0)

09-01 23:16:15 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:16:15', 3, 2, 0)

09-01 23:16:20 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:16:20', 3, 2, 0)

09-01 23:16:25 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:16:25', 3, 2, 0)

09-01 23:16:30 
48ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:16:30 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:16:30', 3, 2, 0)

09-01 23:16:35 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:16:35', 3, 2, 0)

09-01 23:16:40 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:16:40', 3, 2, 0)

09-01 23:16:45 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:16:45', 3, 2, 0)

09-01 23:16:50 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:16:50', 3, 2, 0)

09-01 23:16:55 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:16:55', 3, 2, 0)

09-01 23:17:00 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:17:00', 3, 2, 0)

09-01 23:17:00 
45ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:17:05 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:17:05', 3, 2, 0)

09-01 23:17:10 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:17:10', 3, 2, 0)

09-01 23:17:15 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:17:15', 3, 2, 0)

09-01 23:17:20 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:17:20', 3, 2, 0)

09-01 23:17:25 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:17:25', 3, 2, 0)

09-01 23:17:30 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:17:30', 3, 2, 0)

09-01 23:17:30 
18ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:17:35 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:17:35', 3, 2, 0)

09-01 23:17:40 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:17:40', 3, 2, 0)

09-01 23:17:45 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:17:45', 3, 2, 0)

09-01 23:17:45 
8ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25, 0, '172.20.10.4', 5.0, '2022-09-01 23:14:49', 5, 120, 2, 176164, 0, 4861, 2, 5, 5, '2分56秒164毫秒', 1.0, 0, 0, 25)

09-01 23:17:50 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:17:50', 3, 2, 0)

09-01 23:17:55 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:17:55', 3, 2, 0)

09-01 23:18:00 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:18:00', 3, 2, 0)

09-01 23:18:00 
44ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:18:05 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:18:05', 3, 2, 0)

09-01 23:18:05 
5ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(22, 0, '172.20.10.4', 11.0, '2022-09-01 23:16:05', 2, 120, 1, 119995, 0, 4860, 1, 2, 2, '1分59秒995毫秒', 1.0, 0, 0, 22)

09-01 23:18:10 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:18:10', 3, 2, 0)

09-01 23:18:15 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:18:15', 3, 2, 0)

09-01 23:18:20 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:18:20', 3, 2, 0)

09-01 23:18:25 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:18:25', 3, 2, 0)

09-01 23:18:30 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:18:30 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:18:30', 3, 2, 0)

09-01 23:18:35 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:18:35', 3, 2, 0)

09-01 23:18:40 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:18:40', 3, 2, 0)

09-01 23:18:45 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:18:45', 3, 2, 0)

09-01 23:18:50 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:18:50', 3, 2, 0)

09-01 23:18:55 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:18:55', 3, 2, 0)

09-01 23:19:00 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:19:00', 3, 2, 0)

09-01 23:19:00 
46ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:19:05 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:19:05', 3, 2, 0)

09-01 23:19:10 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:19:10', 3, 2, 0)

09-01 23:19:15 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:19:15', 3, 2, 0)

09-01 23:19:20 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:19:20', 3, 2, 0)

09-01 23:19:25 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:19:25', 3, 2, 0)

09-01 23:19:30 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:19:30', 3, 2, 0)

09-01 23:19:30 
44ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:19:35 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:19:35', 3, 2, 0)

09-01 23:19:40 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:19:40', 3, 2, 0)

09-01 23:19:45 
22ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:19:45', 3, 2, 0)

09-01 23:19:45 
8ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 23:17:45', 4, 120, 2, 120071, 0, 4861, 2, 4, 4, '2分71毫秒', 1.0, 0, 0, 20)

09-01 23:19:50 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:19:50', 3, 2, 0)

09-01 23:19:55 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:19:55', 3, 2, 0)

09-01 23:20:00 
32ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:20:00 
30ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:20:00', 3, 2, 0)

09-01 23:20:00 
40ms
insert into  `wx_task_items`(`dealtime`, `ip`, `type`, `status`) values('2022-09-01 23:20:00', '172.20.10.4', 1, 2)

09-01 23:20:00 
6ms
delete FROM wx_friend_msg where createtime <= '2022-06-01 23:20:00'

09-01 23:20:00 
10ms
delete FROM wx_group_msg where createtime <= '2022-06-01 23:20:00'

09-01 23:20:00 
3ms
delete from wx_group_msg where groupid not in (select groupid from wx_chat_group_item)

09-01 23:20:00 
13ms
INSERT INTO wx_group_msg_bak SELECT *, now() baktime FROM wx_group_msg WHERE groupid not in (select id from wx_group)  and `status` = 1

09-01 23:20:00 
2ms
update wx_group_msg set `status` = 2 where groupid not in (select id from wx_group)

09-01 23:20:00 
17ms
update `wx_task_items` set `status` = 3  where `id` = 7281

09-01 23:20:05 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:20:05', 3, 2, 0)

09-01 23:20:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:20:10', 3, 2, 0)

09-01 23:20:15 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:20:15', 3, 2, 0)

09-01 23:20:20 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:20:20', 3, 2, 0)

09-01 23:20:25 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:20:25', 3, 2, 0)

09-01 23:20:30 
43ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:20:30 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:20:30', 3, 2, 0)

09-01 23:20:35 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:20:35', 3, 2, 0)

09-01 23:20:40 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:20:40', 3, 2, 0)

09-01 23:20:45 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:20:45', 3, 2, 0)

09-01 23:20:50 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:20:50', 3, 2, 0)

09-01 23:20:55 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:20:55', 3, 2, 0)

09-01 23:21:00 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:21:00', 3, 2, 0)

09-01 23:21:00 
47ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:21:05 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:21:05', 3, 2, 0)

09-01 23:21:05 
8ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(22, 0, '172.20.10.4', 11.0, '2022-09-01 23:18:05', 2, 120, 1, 179991, 0, 4860, 1, 3, 2, '2分59秒991毫秒', 1.0, 0, 0, 33)

09-01 23:21:10 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:21:10', 3, 2, 0)

09-01 23:21:15 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:21:15', 3, 2, 0)

09-01 23:21:20 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:21:20', 3, 2, 0)

09-01 23:21:25 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:21:25', 3, 2, 0)

09-01 23:21:30 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:21:30', 3, 2, 0)

09-01 23:21:30 
48ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:21:35 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:21:35', 3, 2, 0)

09-01 23:21:40 
27ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:21:40', 3, 2, 0)

09-01 23:21:45 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:21:45', 3, 2, 0)

09-01 23:21:45 
43ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 23:19:45', 4, 120, 2, 119993, 0, 4861, 2, 4, 4, '1分59秒993毫秒', 1.0, 0, 0, 20)

09-01 23:21:50 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:21:50', 3, 2, 0)

09-01 23:21:55 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:21:55', 3, 2, 0)

09-01 23:22:00 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:22:00', 3, 2, 0)

09-01 23:22:00 
47ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:22:05 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:22:05', 3, 2, 0)

09-01 23:22:10 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:22:10', 3, 2, 0)

09-01 23:22:15 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:22:15', 3, 2, 0)

09-01 23:22:20 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:22:20', 3, 2, 0)

09-01 23:22:25 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:22:25', 3, 2, 0)

09-01 23:22:30 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:22:30', 3, 2, 0)

09-01 23:22:30 
9ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:22:35 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:22:35', 3, 2, 0)

09-01 23:22:40 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:22:40', 3, 2, 0)

09-01 23:22:45 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:22:45', 3, 2, 0)

09-01 23:22:50 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:22:50', 3, 2, 0)

09-01 23:22:55 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:22:55', 3, 2, 0)

09-01 23:23:00 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:23:00', 3, 2, 0)

09-01 23:23:00 
13ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:23:05 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:23:05', 3, 2, 0)

09-01 23:23:05 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(22, 0, '172.20.10.4', 11.0, '2022-09-01 23:21:05', 2, 120, 1, 120002, 0, 4860, 1, 2, 2, '2分2毫秒', 1.0, 0, 0, 22)

09-01 23:23:10 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:23:10', 3, 2, 0)

09-01 23:23:15 
51ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:23:15', 3, 2, 0)

09-01 23:23:20 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:23:20', 3, 2, 0)

09-01 23:23:25 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:23:25', 3, 2, 0)

09-01 23:23:30 
9ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:23:30 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:23:30', 3, 2, 0)

09-01 23:23:35 
13ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:23:35', 3, 2, 0)

09-01 23:23:40 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:23:40', 3, 2, 0)

09-01 23:23:45 
41ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:23:45', 3, 2, 0)

09-01 23:23:49 
42ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(25, 0, '172.20.10.4', 5.0, '2022-09-01 23:21:45', 5, 120, 2, 123489, 0, 4861, 2, 5, 5, '2分3秒489毫秒', 1.0, 0, 0, 25)

09-01 23:23:50 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:23:50', 3, 2, 0)

09-01 23:23:55 
50ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:23:55', 3, 2, 0)

09-01 23:24:00 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:24:00', 3, 2, 0)

09-01 23:24:00 
47ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:24:05 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:24:05', 3, 2, 0)

09-01 23:24:10 
28ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:24:10', 3, 2, 0)

09-01 23:24:15 
10ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:24:15', 3, 2, 0)

09-01 23:24:20 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:24:20', 3, 2, 0)

09-01 23:24:25 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:24:25', 3, 2, 0)

09-01 23:24:30 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:24:30', 3, 2, 0)

09-01 23:24:30 
9ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:24:35 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:24:35', 3, 2, 0)

09-01 23:24:40 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:24:40', 3, 2, 0)

09-01 23:24:45 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:24:45', 3, 2, 0)

09-01 23:24:50 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:24:50', 3, 2, 0)

09-01 23:24:55 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:24:55', 3, 2, 0)

09-01 23:25:00 
41ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:25:00 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:25:00', 3, 2, 0)

09-01 23:25:05 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:25:05', 3, 2, 0)

09-01 23:25:10 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:25:10', 3, 2, 0)

09-01 23:25:15 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:25:15', 3, 2, 0)

09-01 23:25:20 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:25:20', 3, 2, 0)

09-01 23:25:25 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:25:25', 3, 2, 0)

09-01 23:25:30 
8ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:25:30 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:25:30', 3, 2, 0)

09-01 23:25:35 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:25:35', 3, 2, 0)

09-01 23:25:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:25:40', 3, 2, 0)

09-01 23:25:45 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:25:45', 3, 2, 0)

09-01 23:25:49 
10ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 23:23:49', 4, 120, 2, 120043, 0, 4861, 2, 4, 4, '2分43毫秒', 1.0, 0, 0, 20)

09-01 23:25:50 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:25:50', 3, 2, 0)

09-01 23:25:55 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:25:55', 3, 2, 0)

09-01 23:26:00 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:26:00', 3, 2, 0)

09-01 23:26:00 
45ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:26:05 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:26:05', 3, 2, 0)

09-01 23:26:05 
39ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(33, 0, '172.20.10.4', 11.0, '2022-09-01 23:23:05', 3, 120, 1, 179992, 0, 4860, 1, 3, 3, '2分59秒992毫秒', 1.0, 0, 0, 33)

09-01 23:26:10 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:26:10', 3, 2, 0)

09-01 23:26:15 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:26:15', 3, 2, 0)

09-01 23:26:20 
6ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:26:20', 3, 2, 0)

09-01 23:26:25 
12ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:26:25', 3, 2, 0)

09-01 23:26:30 
8ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:26:30 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:26:30', 3, 2, 0)

09-01 23:26:35 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:26:35', 3, 2, 0)

09-01 23:26:40 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:26:40', 3, 2, 0)

09-01 23:26:45 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:26:45', 3, 2, 0)

09-01 23:26:50 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:26:50', 3, 2, 0)

09-01 23:26:55 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:26:55', 3, 2, 0)

09-01 23:27:00 
42ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:27:00 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:27:00', 3, 2, 0)

09-01 23:27:05 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:27:05', 3, 2, 0)

09-01 23:27:10 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:27:10', 3, 2, 0)

09-01 23:27:15 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:27:15', 3, 2, 0)

09-01 23:27:20 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:27:20', 3, 2, 0)

09-01 23:27:25 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:27:25', 3, 2, 0)

09-01 23:27:30 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:27:30', 3, 2, 0)

09-01 23:27:30 
49ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:27:35 
48ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:27:35', 3, 2, 0)

09-01 23:27:40 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:27:40', 3, 2, 0)

09-01 23:27:45 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:27:45', 3, 2, 0)

09-01 23:27:49 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 23:25:49', 4, 120, 2, 120067, 0, 4861, 2, 4, 4, '2分67毫秒', 1.0, 0, 0, 20)

09-01 23:27:50 
47ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:27:50', 3, 2, 0)

09-01 23:27:55 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:27:55', 3, 2, 0)

09-01 23:28:00 
10ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:28:00 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:28:00', 3, 2, 0)

09-01 23:28:05 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:28:05', 3, 2, 0)

09-01 23:28:07 
7ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(77, 0, '172.20.10.4', 11.0, '2022-09-01 23:26:05', 7, 120, 1, 122031, 0, 4860, 1, 7, 7, '2分2秒31毫秒', 1.0, 0, 0, 77)

09-01 23:28:10 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:28:10', 3, 2, 0)

09-01 23:28:15 
22ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:28:15', 3, 2, 0)

09-01 23:28:20 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:28:20', 3, 2, 0)

09-01 23:28:25 
9ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:28:25', 3, 2, 0)

09-01 23:28:30 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:28:30', 3, 2, 0)

09-01 23:28:30 
10ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:28:35 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:28:35', 3, 2, 0)

09-01 23:28:40 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:28:40', 3, 2, 0)

09-01 23:28:45 
43ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:28:45', 3, 2, 0)

09-01 23:28:50 
49ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:28:50', 3, 2, 0)

09-01 23:28:55 
44ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:28:55', 3, 2, 0)

09-01 23:29:00 
9ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:29:00 
11ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:29:00', 3, 2, 0)

09-01 23:29:05 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:29:05', 3, 2, 0)

09-01 23:29:10 
45ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:29:10', 3, 2, 0)

09-01 23:29:15 
8ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:29:15', 3, 2, 0)

09-01 23:29:20 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:29:20', 3, 2, 0)

09-01 23:29:25 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:29:25', 3, 2, 0)

09-01 23:29:30 
44ms
update chatroom_join_leave set leavetime=now(), cost=1000*TIMESTAMPDIFF(SECOND, jointime, now()), status = 3 where status in (3,9) and server = '172.20.10.4'

09-01 23:29:30 
46ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:29:30', 3, 2, 0)

09-01 23:29:35 
18ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:29:35', 3, 2, 0)

09-01 23:29:40 
7ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:29:40', 3, 2, 0)

09-01 23:29:45 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:29:45', 3, 2, 0)

09-01 23:29:49 
5ms
insert into  `tio_ip_stat`(`receivedBytes`, `requestCount`, `server`, `bytesPerTcpReceive`, `start`, `receivedTcps`, `durationType`, `activatedCount`, `duration`, `sentPackets`, `ipid`, `appType`, `handledPackets`, `receivedPackets`, `formatedDuration`, `packetsPerTcpReceive`, `sentBytes`, `decodeErrorCount`, `handledBytes`) values(20, 0, '172.20.10.4', 5.0, '2022-09-01 23:27:49', 4, 120, 2, 120020, 0, 4861, 2, 4, 4, '2分20毫秒', 1.0, 0, 0, 20)

09-01 23:29:50 
42ms
insert into  `stat_online`(`server`, `session`, `ip`, `time`, `page`, `logined`, `group`) values('172.20.10.4', 3, 2, '2022-09-01 23:29:50', 3, 2, 0)

