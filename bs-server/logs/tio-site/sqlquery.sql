09-01 21:24:55 
4ms
select * from sensitive_words_list where status = 1;

09-01 21:24:56 
6ms
select code,name,pcode from area  where pcode = 'area' and  status = 1

09-01 21:24:56 
8ms
select code,name,pcode from area  where status = 1 and pcode in ( select code from area  where pcode = 'area' and  status = 1)

09-01 21:24:56 
8ms
select code,name,pcode from area  where status = 1 and pcode in ( select code from area  where status = 1 and pcode in ( select code from area  where pcode = 'area' and  status = 1))

09-01 21:24:56 
4ms
select count(*) from avatar

09-01 21:24:56 
2ms
select * from avatar limit 0, 1000

09-01 21:24:57 
5ms
select * from yx_conf

09-01 21:24:57 
2ms
select * from conf_dev

09-01 21:25:00 
2ms
select * from httpcache where status = 1

09-01 21:25:00 
3ms
select * from ip_black_list where status=1

09-01 21:25:00 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:25:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:25:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:25:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:25:15 
29ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:25:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:25:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:25:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:25:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:25:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:25:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:25:41 
5ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:19:41'

09-01 21:25:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 21:25:41 
3ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 21:25:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:25:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:25:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:25:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:26:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:26:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:26:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:26:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:26:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:26:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:26:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:26:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:26:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:26:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:26:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:26:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 21:26:41 
2ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:20:41'

09-01 21:26:41 
3ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 21:26:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:26:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:26:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:26:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:27:00 
8ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:27:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:27:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:27:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:27:12 
9ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 21:27:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:27:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:27:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:27:26 
28ms
select * from ip_info where ip='127.0.0.1' and country='' and area='' and province='' and city='内网IP' and operator='内网IP'

09-01 21:27:30 
45ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:27:30 
11ms
select * from user_agent where userAgent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36' limit 1

09-01 21:27:30 
12ms
select * from ip_white_list where status=1

09-01 21:27:30 
9ms
select * from `user` where `id` = 98708001

09-01 21:27:30 
16ms
select * from role r where EXISTS (select rid from user_role rel where uid = 98708001 and r.id = rel.rid and rel.`status` = 1)

09-01 21:27:30 
6ms
select * from ip_info where id=4857

09-01 21:27:30 
5ms
select * from user_third where uid=98708001 and type = 5

09-01 21:27:30 
5ms
select * from user_base where uid = 98708001

09-01 21:27:30 
5ms
select * from user_ext where uid = '98708001'

09-01 21:27:30 
47ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 98708001
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:27:31 
11ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 21:27:31 
9ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 98708001
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id


09-01 21:27:31 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 21:27:31 
45ms
select * from user_ip_login_stat where ip = '127.0.0.1' and uid = 98708001 and dayperiod = '20220901'

09-01 21:27:31 
6ms
select * from user_ip_login_stat where ip = '127.0.0.1' and uid = -1 and dayperiod = '20220901'

09-01 21:27:31 
4ms
select * from user_ip_login_stat where ip = '127.0.0.1' and uid = -1 and dayperiod = '-1'

09-01 21:27:31 
6ms
select  * from user_time_login_stat where uid = 98708001 and dayperiod = '20220901'

09-01 21:27:31 
9ms
select  * from user_time_login_stat where uid = 98708001 and dayperiod = -1

09-01 21:27:31 
4ms
select  * from user_time_login_stat where uid = -1 and dayperiod = '20220901'

09-01 21:27:31 
79ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 21:27:31 
12ms
select * from yx_conf where name = 'app.video.is.open.flag'

09-01 21:27:31 
6ms
select * from yx_conf where name = 'displayInputStatus'

09-01 21:27:31 
23ms
select * from wx_friend_group t where t.uid = 98708001

09-01 21:27:31 
25ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:27:31 
51ms
	SELECT
		wg.id groupid,
		wg.`name`,
		wg.avatar,
		wg.uid,
		gu.grouprole,
		wgm.joinnum
	FROM
		wx_group wg
	INNER JOIN (
		SELECT
			bizid,linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 98708001
		AND chatmode = 2
		AND linkflag = 1
	) AS groupindex ON groupindex.bizid = wg.id
	INNER JOIN wx_group_meta wgm ON wg.id = wgm.groupid
	INNER JOIN wx_group_user gu on gu.id = groupindex.linkid
	order by wg.id desc


09-01 21:27:31 
15ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 98708001
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:27:32 
55ms
select * from login_log where uid = 98708001 order by id desc limit 1

09-01 21:27:32 
217ms
select * from yx_conf where name = 'onlineStatus'

09-01 21:27:32 
58ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 98708001


09-01 21:27:32 
5ms
select * from `wx_friend` where `id` = 2249

09-01 21:27:32 
11ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:27:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:27:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:27:36 
3ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3172


09-01 21:27:36 
35ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '98708001_98708001'
					AND id >= 5302
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 21:27:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:27:41 
11ms
select * from yx_user_send_red_packet where status = 2

09-01 21:27:41 
10ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:21:41'

09-01 21:27:41 
3ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 21:26:41' and querysyn != 3 

09-01 21:27:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:27:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:27:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:27:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:28:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:28:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:28:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:28:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:28:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:28:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:28:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:28:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:28:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:28:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:28:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:28:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 21:28:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:28:50 
37ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:28:50 
37ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:28:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:29:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:29:04 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:29:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:29:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:29:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:29:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:29:24 
2ms
select * from ip_info where ip='172.20.10.4' and country='' and area='' and province='' and city='内网IP' and operator='内网IP'

09-01 21:29:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:29:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:29:34 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:29:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:29:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:29:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 21:29:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:29:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:29:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:29:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:30:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:30:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:30:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:30:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:30:12 
4ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 21:30:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:30:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:30:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:30:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:30:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:30:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:30:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:30:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 21:30:41 
2ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:24:41'

09-01 21:30:41 
3ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 21:30:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:30:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:30:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:30:55 
7ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:31:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:31:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:31:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:31:10 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:31:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:31:20 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:31:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:31:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:31:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:31:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:31:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:31:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 21:31:41 
39ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:25:41'

09-01 21:31:41 
2ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 21:31:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:31:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:31:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:31:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:32:00 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:32:04 
6ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:32:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:32:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:32:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:32:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:32:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:32:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:32:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:32:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:32:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:32:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 21:32:41 
3ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:26:41'

09-01 21:32:41 
1ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 21:31:41' and querysyn != 3 

09-01 21:32:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:32:50 
65ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:32:50 
63ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:32:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:33:00 
10ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:33:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:33:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:33:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:33:12 
6ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 21:33:15 
41ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:33:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:33:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:33:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:33:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:33:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:33:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:33:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 21:33:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:33:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:33:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:33:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:34:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:34:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:34:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:34:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:34:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:34:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:34:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:34:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:34:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:34:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:34:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:34:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 21:34:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:34:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:34:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:34:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:35:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:35:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:35:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:35:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:35:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:35:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:35:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:35:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:35:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:35:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:35:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:35:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 21:35:41 
4ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:29:41'

09-01 21:35:41 
4ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 21:35:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:35:50 
8ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:35:50 
7ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:35:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:36:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:36:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:36:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:36:10 
37ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:36:12 
4ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 21:36:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:36:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:36:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:36:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:36:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:36:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:36:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:36:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 21:36:41 
12ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:30:41'

09-01 21:36:41 
2ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 21:36:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:36:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:36:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:36:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:37:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:37:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:37:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:37:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:37:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:37:18 
3ms
select * from ip_info where ip='172.20.10.2' and country='' and area='' and province='' and city='内网IP' and operator='内网IP'

09-01 21:37:18 
4ms
select * from imei_stat where imei='83a522533756442a91e1a2415ced871e'

09-01 21:37:18 
2ms
select * from imei_stat where imei='83a522533756442a91e1a2415ced871e'

09-01 21:37:18 
2ms
select * from imei_stat where imei='83a522533756442a91e1a2415ced871e'

09-01 21:37:18 
5ms
select * from `website`

09-01 21:37:18 
1ms
select * from `website`

09-01 21:37:18 
4ms
select * from wx_app where type = 2 and `status` = 1

09-01 21:37:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:37:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:37:30 
7ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:37:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:37:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:37:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:37:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 21:37:41 
6ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:31:41'

09-01 21:37:41 
3ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 21:36:41' and querysyn != 3 

09-01 21:37:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:37:46 
3ms
select * from user where phone = '13488888888' and `status` <> 6

09-01 21:37:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:37:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:37:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:38:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:38:03 
2ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = 98708001 and dayperiod = '20220901'

09-01 21:38:03 
3ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = -1 and dayperiod = '20220901'

09-01 21:38:03 
4ms
select * from user_token where devicetype=5 and uid=98708001 limit 1

09-01 21:38:03 
3ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = -1 and dayperiod = '-1'

09-01 21:38:03 
3ms
select  * from user_time_login_stat where uid = 98708001 and dayperiod = '20220901'

09-01 21:38:03 
3ms
select  * from user_time_login_stat where uid = 98708001 and dayperiod = -1

09-01 21:38:03 
3ms
select  * from user_time_login_stat where uid = -1 and dayperiod = '20220901'

09-01 21:38:03 
5ms
select * from `website`

09-01 21:38:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:38:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:38:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:38:12 
2ms
select * from user_token where devicetype=1 and uid=98708001 limit 1

09-01 21:38:12 
3ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = 98708001 and dayperiod = '20220901'

09-01 21:38:12 
2ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = -1 and dayperiod = '20220901'

09-01 21:38:12 
3ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = -1 and dayperiod = '-1'

09-01 21:38:12 
2ms
select  * from user_time_login_stat where uid = 98708001 and dayperiod = '20220901'

09-01 21:38:12 
2ms
select  * from user_time_login_stat where uid = 98708001 and dayperiod = -1

09-01 21:38:12 
2ms
select  * from user_time_login_stat where uid = -1 and dayperiod = '20220901'

09-01 21:38:12 
5ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 98708001
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:38:12 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 21:38:12 
5ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 21:38:12 
4ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 21:38:13 
8ms
select * from yx_conf where name = 'app.video.is.open.flag'

09-01 21:38:13 
12ms
select * from wx_friend_group t where t.uid = 98708001

09-01 21:38:13 
14ms
select * from yx_conf where name = 'displayInputStatus'

09-01 21:38:13 
8ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:38:13 
4ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 98708001
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:38:13 
5ms
select * from yx_conf where name = 'onlineStatus'

09-01 21:38:13 
3ms
select * from login_log where uid = 98708001 order by id desc limit 1

09-01 21:38:13 
5ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:38:13 
3ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3172


09-01 21:38:13 
10ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '98708001_98708001'
					AND id >= 5302
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 21:38:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:38:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:38:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:38:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:38:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:38:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:38:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:38:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 21:38:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:38:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:38:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:38:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:39:00 
9ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:39:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:39:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:39:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:39:12 
6ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 21:39:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:39:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:39:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:39:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:39:34 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:39:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:39:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:39:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 21:39:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:39:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:39:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:39:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:40:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:40:04 
37ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:40:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:40:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:40:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:40:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:40:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:40:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:40:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:40:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:40:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:40:41 
3ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:34:41'

09-01 21:40:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 21:40:41 
2ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 21:40:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:40:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:40:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:40:55 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:41:00 
7ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:41:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:41:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:41:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:41:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:41:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:41:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:41:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:41:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:41:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:41:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:41:41 
3ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:35:41'

09-01 21:41:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 21:41:41 
2ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 21:41:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:41:45 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 21:41:45 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 21:41:45 
4ms
select * from `website`

09-01 21:41:45 
3ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 21:41:45 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 21:41:45 
3ms
select * from `website`

09-01 21:41:45 
38ms
select * from wx_app where type = 2 and `status` = 1

09-01 21:41:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:41:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:41:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:42:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:42:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:42:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:42:07 
3ms
	SELECT
		ai.id,
		fromuid uid,
		greet,
		ai.`status`,
		replytime,
		autoflag,
		nick,
		avatar
	FROM
		wx_friend_apply_items ai
	INNER JOIN `user` u ON u.id = ai.fromuid
	WHERE
		ai.touid = 98708001
	ORDER BY
		ai.id DESC


09-01 21:42:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:42:12 
3ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 21:42:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:42:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:42:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:42:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:42:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:42:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:42:39 
2ms
select * from user_agent where userAgent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36 Hutool' limit 1

09-01 21:42:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:42:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 21:42:41 
4ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:36:41'

09-01 21:42:41 
5ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 21:41:41' and querysyn != 3 

09-01 21:42:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:42:45 
4ms
select * from user where loginname = 'a13499999999' and `status` <> 6

09-01 21:42:45 
2ms
select * from `user` where `id` = 23026121

09-01 21:42:45 
4ms
select id,r,g,b from auto_avatar_plate

09-01 21:42:45 
3ms
select path from auto_avatar where chatindex = '1' limit 0,1

09-01 21:42:45 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 23026121 and chatmode = 1 and bizid = 23026121


09-01 21:42:45 
3ms
select * from `user` where `id` = 23026121

09-01 21:42:45 
2ms
select * from role r where EXISTS (select rid from user_role rel where uid = 23026121 and r.id = rel.rid and rel.`status` = 1)

09-01 21:42:45 
3ms
select * from user_third where uid=23026121 and type = 5

09-01 21:42:45 
2ms
select * from user_base where uid = 23026121

09-01 21:42:45 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 23026121 and chatmode = 1 and bizid = 23026121


09-01 21:42:45 
6ms
SELECT * from user_register_stat where type = 1 and statbizstr = '20220901'

09-01 21:42:45 
2ms
SELECT * from user_register_stat where type = 2 and statbizstr = '127.0.0.1'

09-01 21:42:45 
3ms
SELECT * from user_register_stat where type = 3 and statbizstr = '20220901' and statbizid = 4857 

09-01 21:42:45 
4ms
select * from `user` where `id` = 88888888

09-01 21:42:45 
8ms
	SELECT
		g.*, 
		m.id metaid,
		m.joinnum,
		m.allactflag,
		m.forbiddenflag,
		m.allstartflag
	FROM
		wx_group g
	INNER JOIN wx_group_meta m ON m.groupid = g.id
	WHERE
		g.id = 235


09-01 21:42:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:42:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:42:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:43:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:43:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:43:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:43:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:43:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:43:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:43:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:43:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:43:32 
3ms
select * from imei_stat where imei='a658aec1bd9a411aba1b78d9af8af44c'

09-01 21:43:32 
3ms
select * from imei_stat where imei='a658aec1bd9a411aba1b78d9af8af44c'

09-01 21:43:32 
2ms
select * from imei_stat where imei='a658aec1bd9a411aba1b78d9af8af44c'

09-01 21:43:32 
3ms
select * from `website`

09-01 21:43:32 
3ms
select * from `website`

09-01 21:43:33 
4ms
select * from wx_app where type = 2 and `status` = 1

09-01 21:43:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:43:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:43:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:43:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 21:43:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:43:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:43:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:43:50 
1ms
select * from user where phone = '19375836351' and `status` <> 6

09-01 21:43:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:44:00 
22ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:44:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:44:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:44:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:44:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:44:15 
4ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3172


09-01 21:44:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:44:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:44:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:44:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:44:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:44:36 
5ms
select * from `user` where `id` = 48431849

09-01 21:44:36 
3ms
select * from user where phone = '19375836351' and `status` <> 6

09-01 21:44:36 
4ms
select path from auto_avatar where chatindex = 'J' limit 0,1

09-01 21:44:37 
2ms
select * from user where loginname = '19375836351' and `status` <> 6

09-01 21:44:37 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 48431849 and chatmode = 1 and bizid = 48431849


09-01 21:44:37 
2ms
select * from `user` where `id` = 48431849

09-01 21:44:37 
7ms
select * from role r where EXISTS (select rid from user_role rel where uid = 48431849 and r.id = rel.rid and rel.`status` = 1)

09-01 21:44:37 
2ms
select * from ip_info where id=4861

09-01 21:44:37 
3ms
select * from user_third where uid=48431849 and type = 5

09-01 21:44:37 
2ms
select * from user_base where uid = 48431849

09-01 21:44:37 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 48431849 and chatmode = 1 and bizid = 48431849


09-01 21:44:37 
3ms
SELECT * from user_register_stat where type = 1 and statbizstr = '20220901'

09-01 21:44:37 
3ms
SELECT * from user_register_stat where type = 2 and statbizstr = '172.20.10.2'

09-01 21:44:37 
3ms
SELECT * from user_register_stat where type = 3 and statbizstr = '20220901' and statbizid = 4861 

09-01 21:44:37 
3ms
select * from `user` where `id` = 88888888

09-01 21:44:37 
2ms
	SELECT
		g.*, 
		m.id metaid,
		m.joinnum,
		m.allactflag,
		m.forbiddenflag,
		m.allstartflag
	FROM
		wx_group g
	INNER JOIN wx_group_meta m ON m.groupid = g.id
	WHERE
		g.id = 235


09-01 21:44:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:44:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 21:44:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:44:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:44:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:44:55 
8ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:45:00 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:45:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:45:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:45:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:45:12 
3ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 21:45:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:45:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:45:24 
5ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3172


09-01 21:45:24 
4ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '98708001_98708001'
					AND id >= 5302
					AND id < 5302
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 21:45:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:45:28 
5ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 21:45:28 
5ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 21:45:28 
5ms
select * from `website`

09-01 21:45:28 
6ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 21:45:28 
3ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 21:45:28 
7ms
select * from `website`

09-01 21:45:28 
3ms
select * from wx_app where type = 2 and `status` = 1

09-01 21:45:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:45:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:45:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:45:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:45:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 21:45:41 
4ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:39:41'

09-01 21:45:41 
3ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 21:45:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:45:47 
6ms
select count(*) FROM
    `user` a
            LEFT JOIN user_ext b ON a.id = b.uid
            AND b.ext_name = 'uidFind'
            LEFT JOIN user_ext e ON a.id = e.uid
            AND e.ext_name = 'loginNameFind'
WHERE
    (1 = 0)
        or (( b.ext_value IS NULL OR b.ext_value = '1' ) AND a.id = '48431849')
        or (( e.ext_value IS NULL OR e.ext_value = '1' ) AND a.loginname is not null and a.loginname = '48431849')


09-01 21:45:47 
6ms
SELECT
    a.nick,
    a.id,
    a.avatar
 FROM
    `user` a
            LEFT JOIN user_ext b ON a.id = b.uid
            AND b.ext_name = 'uidFind'
            LEFT JOIN user_ext e ON a.id = e.uid
            AND e.ext_name = 'loginNameFind'
WHERE
    (1 = 0)
        or (( b.ext_value IS NULL OR b.ext_value = '1' ) AND a.id = '48431849')
        or (( e.ext_value IS NULL OR e.ext_value = '1' ) AND a.loginname is not null and a.loginname = '48431849')
 limit 0, 20

09-01 21:45:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:45:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:45:50 
5ms
select * from user where phone = '19375836351' and `status` <> 6

09-01 21:45:50 
4ms
select * from `user` where `id` = 48431849

09-01 21:45:50 
4ms
select * from role r where EXISTS (select rid from user_role rel where uid = 48431849 and r.id = rel.rid and rel.`status` = 1)

09-01 21:45:50 
4ms
select * from user_third where uid=48431849 and type = 5

09-01 21:45:50 
4ms
select * from user_base where uid = 48431849

09-01 21:45:50 
4ms
select * from user_token where devicetype=5 and uid=48431849 limit 1

09-01 21:45:50 
2ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = 48431849 and dayperiod = '20220901'

09-01 21:45:50 
2ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = -1 and dayperiod = '20220901'

09-01 21:45:50 
2ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = -1 and dayperiod = '-1'

09-01 21:45:50 
3ms
select  * from user_time_login_stat where uid = 48431849 and dayperiod = '20220901'

09-01 21:45:50 
2ms
select  * from user_time_login_stat where uid = 48431849 and dayperiod = -1

09-01 21:45:50 
2ms
select  * from user_time_login_stat where uid = -1 and dayperiod = '20220901'

09-01 21:45:50 
2ms
select * from user_ext where uid = '48431849'

09-01 21:45:50 
4ms
select * from `website`

09-01 21:45:54 
5ms
select * from user where phone = '13499999999' and `status` <> 6

09-01 21:45:54 
4ms
select * from `user` where `id` = 23026121

09-01 21:45:54 
5ms
select * from role r where EXISTS (select rid from user_role rel where uid = 23026121 and r.id = rel.rid and rel.`status` = 1)

09-01 21:45:54 
4ms
select * from user_third where uid=23026121 and type = 5

09-01 21:45:54 
2ms
select * from user_base where uid = 23026121

09-01 21:45:54 
2ms
select * from user_token where devicetype=1 and uid=23026121 limit 1

09-01 21:45:54 
2ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = 23026121 and dayperiod = '20220901'

09-01 21:45:54 
3ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = -1 and dayperiod = '20220901'

09-01 21:45:54 
3ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = -1 and dayperiod = '-1'

09-01 21:45:54 
3ms
select  * from user_time_login_stat where uid = 23026121 and dayperiod = '20220901'

09-01 21:45:55 
3ms
select  * from user_time_login_stat where uid = 23026121 and dayperiod = -1

09-01 21:45:55 
2ms
select * from user_ext where uid = '23026121'

09-01 21:45:55 
2ms
select  * from user_time_login_stat where uid = -1 and dayperiod = '20220901'

09-01 21:45:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:45:55 
4ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:45:55 
5ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id


09-01 21:45:55 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 23026121
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 21:45:55 
3ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 23026121 and `status` = 2

09-01 21:45:55 
33ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 21:45:55 
5ms
select * from yx_conf where name = 'app.video.is.open.flag'

09-01 21:45:55 
4ms
select * from yx_conf where name = 'displayInputStatus'

09-01 21:45:55 
10ms
	SELECT
		wg.id groupid,
		wg.`name`,
		wg.avatar,
		wg.uid,
		gu.grouprole,
		wgm.joinnum
	FROM
		wx_group wg
	INNER JOIN (
		SELECT
			bizid,linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 2
		AND linkflag = 1
	) AS groupindex ON groupindex.bizid = wg.id
	INNER JOIN wx_group_meta wgm ON wg.id = wgm.groupid
	INNER JOIN wx_group_user gu on gu.id = groupindex.linkid
	order by wg.id desc


09-01 21:45:55 
10ms
select * from wx_friend_group t where t.uid = 23026121

09-01 21:45:55 
4ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:45:55 
6ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:45:55 
5ms
select * from yx_conf where name = 'onlineStatus'

09-01 21:45:55 
3ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:46:00 
9ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:46:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:46:05 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:46:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:46:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:46:15 
4ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		


09-01 21:46:15 
8ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:46:15 
4ms
	SELECT
		ai.id,
		fromuid uid,
		greet,
		ai.`status`,
		replytime,
		autoflag,
		nick,
		avatar
	FROM
		wx_friend_apply_items ai
	INNER JOIN `user` u ON u.id = ai.fromuid
	WHERE
		ai.touid = 23026121
	ORDER BY
		ai.id DESC


09-01 21:46:15 
6ms
select * from wx_friend_group t where t.uid = 23026121

09-01 21:46:17 
5ms
select * from login_log where uid = 23026121 order by id desc limit 1

09-01 21:46:17 
3ms
select * from `wx_friend` where `id` = 2250

09-01 21:46:18 
4ms
	SELECT
		ai.id,
		fromuid uid,
		greet,
		ai.`status`,
		replytime,
		autoflag,
		nick,
		avatar
	FROM
		wx_friend_apply_items ai
	INNER JOIN `user` u ON u.id = ai.fromuid
	WHERE
		ai.touid = 23026121
	ORDER BY
		ai.id DESC


09-01 21:46:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:46:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:46:25 
6ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 21:46:25 
37ms
select * from `website`

09-01 21:46:25 
37ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 21:46:25 
3ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 21:46:25 
3ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 21:46:25 
4ms
select * from `website`

09-01 21:46:26 
4ms
select * from wx_app where type = 2 and `status` = 1

09-01 21:46:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:46:33 
4ms
select count(*) from user where status = 1 and searchflag = 1 and (loginname = '13488888888' or id = '13488888888')


09-01 21:46:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:46:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:46:37 
3ms
select count(*) from user where status = 1 and searchflag = 1 and (loginname = '13488888888' or id = '13488888888')


09-01 21:46:39 
5ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 21:46:39 
3ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 21:46:39 
3ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 21:46:39 
3ms
select * from `website`

09-01 21:46:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:46:40 
4ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 21:46:40 
4ms
select * from `website`

09-01 21:46:40 
4ms
select * from wx_app where type = 2 and `status` = 1

09-01 21:46:41 
4ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:40:41'

09-01 21:46:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 21:46:41 
4ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 21:46:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:46:48 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 48431849


09-01 21:46:48 
4ms
	select * from wx_user_black_items where uid = 48431849 and touid = 98708001


09-01 21:46:48 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 48431849


09-01 21:46:48 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 48431849 and chatmode = 1 and bizid = 98708001


09-01 21:46:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:46:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:46:50 
7ms
select * from user_vip_level where vip_level = 0

09-01 21:46:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:46:58 
6ms
	SELECT
		ai.id,
		fromuid uid,
		greet,
		ai.`status`,
		replytime,
		autoflag,
		nick,
		avatar
	FROM
		wx_friend_apply_items ai
	INNER JOIN `user` u ON u.id = ai.fromuid
	WHERE
		ai.touid = 48431849
	ORDER BY
		ai.id DESC


09-01 21:47:00 
8ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:47:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:47:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:47:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:47:10 
3ms
	SELECT
		wg.id groupid,
		wg.`name`,
		wg.avatar,
		wg.uid,
		gu.grouprole,
		wgm.joinnum
	FROM
		wx_group wg
	INNER JOIN (
		SELECT
			bizid,linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 48431849
		AND chatmode = 2
		AND linkflag = 1
	) AS groupindex ON groupindex.bizid = wg.id
	INNER JOIN wx_group_meta wgm ON wg.id = wgm.groupid
	INNER JOIN wx_group_user gu on gu.id = groupindex.linkid
	order by wg.id desc


09-01 21:47:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:47:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:47:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:47:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:47:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:47:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:47:40 
31ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:47:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 21:47:41 
5ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:41:41'

09-01 21:47:41 
4ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 21:46:41' and querysyn != 3 

09-01 21:47:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:47:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:47:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:47:50 
5ms
select * from wx_friend_group t where t.uid = 23026121

09-01 21:47:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:48:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:48:03 
5ms
select count(*) from user where status = 1 and searchflag = 1 and (loginname = '13488888888' or id = '13488888888')


09-01 21:48:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:48:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:48:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:48:12 
3ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 21:48:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:48:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:48:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:48:29 
3ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		


09-01 21:48:29 
5ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:48:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:48:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:48:34 
4ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%13%' or u.nick like '%13%' or wf.frienduid = '13'
		


09-01 21:48:34 
3ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%13%' or u.nick like '%13%' or wf.frienduid = '13'
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:48:34 
4ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%134%' or u.nick like '%134%' or wf.frienduid = '134'
		


09-01 21:48:34 
4ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%134%' or u.nick like '%134%' or wf.frienduid = '134'
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:48:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:48:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:48:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 21:48:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:48:45 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 48431849


09-01 21:48:45 
3ms
	select * from wx_user_black_items where uid = 48431849 and touid = 98708001


09-01 21:48:45 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 48431849


09-01 21:48:45 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 48431849 and chatmode = 1 and bizid = 98708001


09-01 21:48:47 
4ms
select * from user_vip_level where vip_level = 0

09-01 21:48:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:48:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:48:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:49:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:49:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:49:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:49:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:49:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:49:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:49:25 
23ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:49:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:49:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:49:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:49:37 
4ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		


09-01 21:49:37 
4ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:49:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:49:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 21:49:42 
3ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%13%' or u.nick like '%13%' or wf.frienduid = '13'
		


09-01 21:49:42 
4ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%13%' or u.nick like '%13%' or wf.frienduid = '13'
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:49:43 
4ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%134%' or u.nick like '%134%' or wf.frienduid = '134'
		


09-01 21:49:43 
3ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%134%' or u.nick like '%134%' or wf.frienduid = '134'
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:49:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:49:45 
4ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%134888%' or u.nick like '%134888%' or wf.frienduid = '134888'
		


09-01 21:49:46 
4ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%13488888%' or u.nick like '%13488888%' or wf.frienduid = '13488888'
		


09-01 21:49:46 
4ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%13488888888%' or u.nick like '%13488888888%' or wf.frienduid = '13488888888'
		


09-01 21:49:46 
5ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%1348888888%' or u.nick like '%1348888888%' or wf.frienduid = '1348888888'
		


09-01 21:49:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:49:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:49:52 
4ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%1349999999%' or u.nick like '%1349999999%' or wf.frienduid = '1349999999'
		


09-01 21:49:52 
4ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%1349999999%' or u.nick like '%1349999999%' or wf.frienduid = '1349999999'
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:49:52 
2ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%13499999999%' or u.nick like '%13499999999%' or wf.frienduid = '13499999999'
		


09-01 21:49:52 
2ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%13499999999%' or u.nick like '%13499999999%' or wf.frienduid = '13499999999'
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:49:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:49:57 
2ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		


09-01 21:49:57 
3ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:49:57 
4ms
select * from wx_friend_group t where t.uid = 23026121

09-01 21:49:57 
4ms
	SELECT
		ai.id,
		fromuid uid,
		greet,
		ai.`status`,
		replytime,
		autoflag,
		nick,
		avatar
	FROM
		wx_friend_apply_items ai
	INNER JOIN `user` u ON u.id = ai.fromuid
	WHERE
		ai.touid = 23026121
	ORDER BY
		ai.id DESC


09-01 21:50:00 
7ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:50:01 
3ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3173


09-01 21:50:01 
3ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:50:01 
4ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 23026121 and `status` = 2

09-01 21:50:01 
4ms
select * from wx_friend_group t where t.uid = 23026121

09-01 21:50:01 
5ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 21:50:01 
5ms
select * from yx_conf where name = 'app.video.is.open.flag'

09-01 21:50:01 
5ms
select * from yx_conf where name = 'displayInputStatus'

09-01 21:50:01 
10ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:50:01 
12ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:50:01 
12ms
select * from yx_conf where name = 'onlineStatus'

09-01 21:50:01 
6ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:50:01 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 23026121 and chatmode = 1 and bizid = 23026121


09-01 21:50:02 
3ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '23026121_23026121'
					AND id >= 999999999999999999
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 21:50:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:50:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:50:07 
4ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		


09-01 21:50:07 
2ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:50:07 
4ms
	SELECT
		ai.id,
		fromuid uid,
		greet,
		ai.`status`,
		replytime,
		autoflag,
		nick,
		avatar
	FROM
		wx_friend_apply_items ai
	INNER JOIN `user` u ON u.id = ai.fromuid
	WHERE
		ai.touid = 23026121
	ORDER BY
		ai.id DESC


09-01 21:50:07 
3ms
select * from wx_friend_group t where t.uid = 23026121

09-01 21:50:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:50:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:50:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:50:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:50:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:50:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:50:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:50:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:50:41 
2ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:44:41'

09-01 21:50:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 21:50:41 
3ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 21:50:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:50:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:50:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:50:50 
4ms
select * from wx_friend_group t where t.uid = 23026121

09-01 21:50:53 
6ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		


09-01 21:50:53 
4ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:50:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:50:57 
5ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%13%' or u.nick like '%13%' or wf.frienduid = '13'
		


09-01 21:50:57 
3ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%13%' or u.nick like '%13%' or wf.frienduid = '13'
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:50:58 
2ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%134%' or u.nick like '%134%' or wf.frienduid = '134'
		


09-01 21:50:58 
1ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%134%' or u.nick like '%134%' or wf.frienduid = '134'
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:50:59 
5ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%134888%' or u.nick like '%134888%' or wf.frienduid = '134888'
		


09-01 21:51:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:51:00 
4ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%13488888%' or u.nick like '%13488888%' or wf.frienduid = '13488888'
		


09-01 21:51:00 
4ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%1348888888%' or u.nick like '%1348888888%' or wf.frienduid = '1348888888'
		


09-01 21:51:01 
6ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		WHERE
			wf.remarkname like '%13488888888%' or u.nick like '%13488888888%' or wf.frienduid = '13488888888'
		


09-01 21:51:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:51:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:51:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:51:12 
4ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 21:51:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:51:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:51:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:51:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:51:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:51:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:51:37 
4ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		


09-01 21:51:37 
3ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:51:37 
3ms
	SELECT
		ai.id,
		fromuid uid,
		greet,
		ai.`status`,
		replytime,
		autoflag,
		nick,
		avatar
	FROM
		wx_friend_apply_items ai
	INNER JOIN `user` u ON u.id = ai.fromuid
	WHERE
		ai.touid = 23026121
	ORDER BY
		ai.id DESC


09-01 21:51:37 
4ms
select * from wx_friend_group t where t.uid = 23026121

09-01 21:51:38 
6ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:51:38 
3ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 23026121 and `status` = 2

09-01 21:51:38 
2ms
select * from wx_friend_group t where t.uid = 23026121

09-01 21:51:38 
2ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:51:38 
7ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 21:51:38 
12ms
select * from yx_conf where name = 'app.video.is.open.flag'

09-01 21:51:38 
9ms
select * from yx_conf where name = 'displayInputStatus'

09-01 21:51:38 
3ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:51:38 
5ms
select * from yx_conf where name = 'onlineStatus'

09-01 21:51:38 
7ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:51:38 
3ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3173


09-01 21:51:38 
6ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '23026121_23026121'
					AND id >= 999999999999999999
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 21:51:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:51:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 21:51:41 
4ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:45:41'

09-01 21:51:41 
3ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 21:51:42 
3ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		


09-01 21:51:42 
8ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 21:51:42 
34ms
	SELECT
		ai.id,
		fromuid uid,
		greet,
		ai.`status`,
		replytime,
		autoflag,
		nick,
		avatar
	FROM
		wx_friend_apply_items ai
	INNER JOIN `user` u ON u.id = ai.fromuid
	WHERE
		ai.touid = 23026121
	ORDER BY
		ai.id DESC


09-01 21:51:42 
33ms
select * from wx_friend_group t where t.uid = 23026121

09-01 21:51:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:51:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:51:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:51:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:51:56 
3ms
select count(*) from user where status = 1 and searchflag = 1 and (loginname = '13488888888' or id = '13488888888')


09-01 21:51:57 
4ms
select count(*) from user where status = 1 and searchflag = 1 and (loginname = '13488888888' or id = '13488888888')


09-01 21:52:00 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:52:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:52:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:52:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:52:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:52:17 
3ms
select count(*) from user where status = 1 and searchflag = 1 and (loginname = '13499999999' or id = '13499999999')


09-01 21:52:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:52:22 
7ms
select count(*) FROM
    `user` a
            LEFT JOIN user_ext b ON a.id = b.uid
            AND b.ext_name = 'uidFind'
            LEFT JOIN user_ext c ON a.id = c.uid
            AND c.ext_name = 'phoneFind'
            LEFT JOIN user_ext e ON a.id = e.uid
            AND e.ext_name = 'loginNameFind'
WHERE
    (1 = 0)
        or (( b.ext_value IS NULL OR b.ext_value = '1' ) AND a.id = '13499999999')
        or (( c.ext_value IS NULL OR c.ext_value = '1' ) AND a.phone is not null and a.phone = '13499999999')
        or (( e.ext_value IS NULL OR e.ext_value = '1' ) AND a.loginname is not null and a.loginname = '13499999999')


09-01 21:52:22 
5ms
SELECT
    a.nick,
    a.id,
    a.avatar
 FROM
    `user` a
            LEFT JOIN user_ext b ON a.id = b.uid
            AND b.ext_name = 'uidFind'
            LEFT JOIN user_ext c ON a.id = c.uid
            AND c.ext_name = 'phoneFind'
            LEFT JOIN user_ext e ON a.id = e.uid
            AND e.ext_name = 'loginNameFind'
WHERE
    (1 = 0)
        or (( b.ext_value IS NULL OR b.ext_value = '1' ) AND a.id = '13499999999')
        or (( c.ext_value IS NULL OR c.ext_value = '1' ) AND a.phone is not null and a.phone = '13499999999')
        or (( e.ext_value IS NULL OR e.ext_value = '1' ) AND a.loginname is not null and a.loginname = '13499999999')
 limit 0, 20

09-01 21:52:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:52:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:52:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:52:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:52:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:52:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 21:52:41 
3ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:46:41'

09-01 21:52:41 
3ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 21:51:41' and querysyn != 3 

09-01 21:52:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:52:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:52:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:52:51 
5ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 48431849 and chatmode = 1 and bizid = 23026121


09-01 21:52:51 
2ms
	select * from wx_user_black_items where uid = 23026121 and touid = 48431849


09-01 21:52:51 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 48431849 and chatmode = 1 and bizid = 23026121


09-01 21:52:51 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 23026121 and chatmode = 1 and bizid = 48431849


09-01 21:52:53 
4ms
select * from user_vip_level where vip_level = 0

09-01 21:52:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:52:58 
5ms
select count(*) from user where status = 1 and searchflag = 1 and (loginname = '19375836351' or id = '19375836351')


09-01 21:53:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:53:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:53:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:53:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:53:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:53:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:53:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:53:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:53:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:53:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:53:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:53:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 21:53:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:53:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:53:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:53:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:54:00 
7ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:54:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:54:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:54:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:54:12 
5ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 21:54:12 
6ms
select count(*) from user where status = 1 and searchflag = 1 and (loginname = '19375836351' or id = '19375836351')


09-01 21:54:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:54:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:54:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:54:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:54:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:54:35 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:54:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:54:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 21:54:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:54:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:54:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:54:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:55:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:55:04 
1ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:55:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:55:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:55:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:55:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:55:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:55:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:55:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:55:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:55:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:55:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 21:55:41 
2ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:49:41'

09-01 21:55:41 
2ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 21:55:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:55:46 
4ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3173


09-01 21:55:47 
2ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:55:47 
4ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 23026121 and `status` = 2

09-01 21:55:47 
4ms
select * from wx_friend_group t where t.uid = 23026121

09-01 21:55:47 
17ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 21:55:47 
5ms
select * from yx_conf where name = 'app.video.is.open.flag'

09-01 21:55:47 
3ms
select * from yx_conf where name = 'displayInputStatus'

09-01 21:55:47 
5ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:55:47 
6ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:55:47 
4ms
select * from yx_conf where name = 'onlineStatus'

09-01 21:55:47 
4ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:55:47 
3ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '23026121_23026121'
					AND id >= 999999999999999999
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 21:55:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:55:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:55:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:56:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:56:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:56:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:56:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:56:10 
12ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:56:10 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 23026121
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 21:56:10 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 23026121 and `status` = 2

09-01 21:56:10 
9ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 21:56:10 
4ms
select * from yx_conf where name = 'displayInputStatus'

09-01 21:56:10 
6ms
select * from yx_conf where name = 'app.video.is.open.flag'

09-01 21:56:10 
6ms
select * from wx_friend_group t where t.uid = 23026121

09-01 21:56:10 
3ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:56:10 
3ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 21:56:10 
2ms
select * from yx_conf where name = 'onlineStatus'

09-01 21:56:10 
3ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 21:56:10 
3ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3173


09-01 21:56:10 
3ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '23026121_23026121'
					AND id >= 999999999999999999
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 21:56:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:56:15 
4ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3173


09-01 21:56:15 
4ms
	select * from wx_user_black_items where uid = 23026121 and touid = 23026121


09-01 21:56:15 
3ms
	select * from wx_user_black_items where uid = 23026121 and touid = 23026121


09-01 21:56:15 
4ms
select * from ip_info where ip='0.0.0.0' and country='' and area='' and province='' and city='内网IP' and operator='内网IP'

09-01 21:56:15 
3ms
	select * from wx_user_black_items where uid = 23026121 and touid = 23026121


09-01 21:56:15 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 23026121 and chatmode = 1 and bizid = 23026121


09-01 21:56:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:56:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:56:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:56:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:56:35 
37ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:56:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:56:41 
4ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:50:41'

09-01 21:56:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 21:56:41 
4ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 21:56:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:56:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:56:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:56:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:57:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:57:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:57:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:57:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:57:12 
3ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 21:57:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:57:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:57:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:57:26 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 21:57:26 
4ms
select * from `website`

09-01 21:57:26 
2ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 21:57:26 
1ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 21:57:27 
3ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 21:57:27 
5ms
select * from `website`

09-01 21:57:27 
2ms
select * from wx_app where type = 2 and `status` = 1

09-01 21:57:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:57:34 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:57:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:57:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:57:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 21:57:41 
5ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:51:41'

09-01 21:57:41 
3ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 21:56:41' and querysyn != 3 

09-01 21:57:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:57:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:57:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:57:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:58:00 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:58:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:58:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:58:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:58:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:58:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:58:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:58:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:58:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:58:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:58:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:58:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 21:58:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:58:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:58:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:58:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:59:00 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:59:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:59:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:59:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:59:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:59:16 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 21:59:16 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 21:59:16 
2ms
select * from `website`

09-01 21:59:16 
1ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 21:59:16 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 21:59:16 
3ms
select * from `website`

09-01 21:59:16 
2ms
select * from wx_app where type = 2 and `status` = 1

09-01 21:59:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:59:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:59:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:59:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 21:59:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:59:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:59:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 21:59:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:59:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 21:59:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 21:59:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:00:00 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:00:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:00:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:00:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:00:12 
3ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:00:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:00:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:00:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:00:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:00:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:00:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:00:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:00:41 
3ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:54:41'

09-01 22:00:41 
2ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 22:00:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:00:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:00:50 
1ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:00:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:01:00 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:01:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:01:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:01:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:01:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:01:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:01:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:01:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:01:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:01:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:01:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:01:41 
2ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:55:41'

09-01 22:01:41 
1ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 22:01:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:01:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:01:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:01:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:02:00 
32ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:02:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:02:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:02:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:02:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:04:53 
3ms
select * from sensitive_words_list where status = 1;

09-01 22:04:53 
2ms
select code,name,pcode from area  where pcode = 'area' and  status = 1

09-01 22:04:53 
4ms
select code,name,pcode from area  where status = 1 and pcode in ( select code from area  where pcode = 'area' and  status = 1)

09-01 22:04:53 
7ms
select code,name,pcode from area  where status = 1 and pcode in ( select code from area  where status = 1 and pcode in ( select code from area  where pcode = 'area' and  status = 1))

09-01 22:04:53 
6ms
select count(*) from avatar

09-01 22:04:53 
2ms
select * from avatar limit 0, 1000

09-01 22:04:54 
3ms
select * from yx_conf

09-01 22:04:54 
2ms
select * from conf_dev

09-01 22:04:54 
2ms
select * from httpcache where status = 1

09-01 22:04:54 
3ms
select * from ip_black_list where status=1

09-01 22:04:55 
17ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:04:56 
3ms
select * from ip_info where ip='172.20.10.4' and country='' and area='' and province='' and city='内网IP' and operator='内网IP'

09-01 22:04:57 
3ms
select * from user_agent where userAgent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36' limit 1

09-01 22:04:57 
2ms
select * from ip_white_list where status=1

09-01 22:04:57 
2ms
select * from `user` where `id` = 23026121

09-01 22:04:57 
3ms
select * from role r where EXISTS (select rid from user_role rel where uid = 23026121 and r.id = rel.rid and rel.`status` = 1)

09-01 22:04:57 
2ms
select * from user_third where uid=23026121 and type = 5

09-01 22:04:57 
2ms
select * from user_base where uid = 23026121

09-01 22:04:57 
2ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id


09-01 22:04:57 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 23026121
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 22:04:57 
4ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = 23026121 and dayperiod = '20220901'

09-01 22:04:57 
2ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = -1 and dayperiod = '20220901'

09-01 22:04:57 
2ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = -1 and dayperiod = '-1'

09-01 22:04:57 
2ms
select  * from user_time_login_stat where uid = 23026121 and dayperiod = '20220901'

09-01 22:04:57 
2ms
select  * from user_time_login_stat where uid = 23026121 and dayperiod = -1

09-01 22:04:57 
1ms
select  * from user_time_login_stat where uid = -1 and dayperiod = '20220901'

09-01 22:04:59 
3ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3173


09-01 22:04:59 
1ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 23026121 and chatmode = 1 and bizid = 23026121


09-01 22:04:59 
2ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3173


09-01 22:04:59 
6ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '23026121_23026121'
					AND id >= 5315
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 22:05:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:05:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:05:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:05:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:05:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:05:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:05:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:05:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:05:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:05:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:05:38 
3ms
select * from user_ext where uid = '23026121'

09-01 22:05:38 
6ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:05:38 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 23026121
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 22:05:38 
3ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 23026121 and `status` = 2

09-01 22:05:39 
6ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 22:05:39 
4ms
select * from wx_friend_group t where t.uid = 23026121

09-01 22:05:39 
71ms
select * from yx_conf where name = 'app.video.is.open.flag'

09-01 22:05:39 
71ms
	SELECT
		wg.id groupid,
		wg.`name`,
		wg.avatar,
		wg.uid,
		gu.grouprole,
		wgm.joinnum
	FROM
		wx_group wg
	INNER JOIN (
		SELECT
			bizid,linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 2
		AND linkflag = 1
	) AS groupindex ON groupindex.bizid = wg.id
	INNER JOIN wx_group_meta wgm ON wg.id = wgm.groupid
	INNER JOIN wx_group_user gu on gu.id = groupindex.linkid
	order by wg.id desc


09-01 22:05:39 
7ms
select * from yx_conf where name = 'displayInputStatus'

09-01 22:05:39 
12ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 22:05:39 
12ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:05:39 
5ms
select * from yx_conf where name = 'onlineStatus'

09-01 22:05:39 
5ms
select * from login_log where uid = 23026121 order by id desc limit 1

09-01 22:05:39 
3ms
select * from `wx_friend` where `id` = 2250

09-01 22:05:39 
3ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 22:05:39 
3ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3173


09-01 22:05:39 
5ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '23026121_23026121'
					AND id >= 5315
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 22:05:40 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:05:41 
5ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 21:59:41'

09-01 22:05:41 
4ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 22:05:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:05:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:05:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:05:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:05:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:05:55 
4ms
select * from ip_info where ip='127.0.0.1' and country='' and area='' and province='' and city='内网IP' and operator='内网IP'

09-01 22:06:00 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:06:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:06:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:06:06 
4ms
select * from user where phone = '13499999999' and `status` <> 6

09-01 22:06:07 
2ms
select * from user_token where devicetype=1 and uid=23026121 limit 1

09-01 22:06:07 
5ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:06:07 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 23026121
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 22:06:07 
3ms
select * from user_ip_login_stat where ip = '127.0.0.1' and uid = 23026121 and dayperiod = '20220901'

09-01 22:06:07 
3ms
select * from user_ip_login_stat where ip = '127.0.0.1' and uid = -1 and dayperiod = '20220901'

09-01 22:06:07 
3ms
select * from user_ip_login_stat where ip = '127.0.0.1' and uid = -1 and dayperiod = '-1'

09-01 22:06:07 
3ms
select  * from user_time_login_stat where uid = 23026121 and dayperiod = '20220901'

09-01 22:06:07 
4ms
select  * from user_time_login_stat where uid = 23026121 and dayperiod = -1

09-01 22:06:07 
7ms
select  * from user_time_login_stat where uid = -1 and dayperiod = '20220901'

09-01 22:06:07 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 23026121 and `status` = 2

09-01 22:06:07 
5ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 22:06:07 
3ms
select * from wx_friend_group t where t.uid = 23026121

09-01 22:06:07 
2ms
select * from yx_conf where name = 'displayInputStatus'

09-01 22:06:07 
3ms
select * from yx_conf where name = 'app.video.is.open.flag'

09-01 22:06:07 
10ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 22:06:07 
10ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:06:07 
11ms
select * from yx_conf where name = 'onlineStatus'

09-01 22:06:07 
3ms
select * from login_log where uid = 23026121 order by id desc limit 1

09-01 22:06:07 
6ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 22:06:07 
4ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3173


09-01 22:06:07 
4ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '23026121_23026121'
					AND id >= 5315
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 22:06:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:06:12 
3ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:06:14 
3ms
select * from `wx_call_item` where `id` = 469

09-01 22:06:15 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:06:16 
6ms
select * from `wx_call_item` where `id` = 469

09-01 22:06:16 
4ms
select * from `wx_call_item` where `id` = 469

09-01 22:06:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:06:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:06:25 
2ms
	select * from wx_user_black_items where uid = 23026121 and touid = 23026121


09-01 22:06:29 
4ms
select * from `wx_call_item` where `id` = 470

09-01 22:06:30 
5ms
select * from `wx_call_item` where `id` = 470

09-01 22:06:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:06:30 
3ms
	select * from wx_user_black_items where uid = 23026121 and touid = 23026121


09-01 22:06:34 
41ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:06:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:06:35 
6ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		


09-01 22:06:35 
6ms
	SELECT
		ai.id,
		fromuid uid,
		greet,
		ai.`status`,
		replytime,
		autoflag,
		nick,
		avatar
	FROM
		wx_friend_apply_items ai
	INNER JOIN `user` u ON u.id = ai.fromuid
	WHERE
		ai.touid = 23026121
	ORDER BY
		ai.id DESC


09-01 22:06:35 
3ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 22:06:35 
6ms
select * from wx_friend_group t where t.uid = 23026121

09-01 22:06:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:06:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 22:06:41 
5ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:00:41'

09-01 22:06:41 
4ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 22:06:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:06:48 
4ms
select count(*) from user where status = 1 and searchflag = 1 and (loginname = '13488888888' or id = '13488888888')


09-01 22:06:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:06:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:06:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:07:00 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:07:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:07:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:07:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:07:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:07:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:07:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:07:26 
2ms
select * from ip_info where ip='172.20.10.2' and country='' and area='' and province='' and city='内网IP' and operator='内网IP'

09-01 22:07:26 
2ms
select * from `user` where `id` = 48431849

09-01 22:07:26 
3ms
select * from role r where EXISTS (select rid from user_role rel where uid = 48431849 and r.id = rel.rid and rel.`status` = 1)

09-01 22:07:26 
1ms
select * from user_third where uid=48431849 and type = 5

09-01 22:07:26 
1ms
select * from user_base where uid = 48431849

09-01 22:07:26 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 22:07:26 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 22:07:26 
1ms
select * from user_ext where uid = '48431849'

09-01 22:07:27 
2ms
select * from `website`

09-01 22:07:27 
2ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 22:07:27 
3ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 22:07:27 
3ms
select * from `website`

09-01 22:07:27 
4ms
select * from wx_app where type = 2 and `status` = 1

09-01 22:07:27 
2ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 48431849
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id


09-01 22:07:27 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 48431849
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 22:07:27 
2ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = 48431849 and dayperiod = '20220901'

09-01 22:07:27 
1ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = -1 and dayperiod = '20220901'

09-01 22:07:27 
2ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = -1 and dayperiod = '-1'

09-01 22:07:27 
1ms
select  * from user_time_login_stat where uid = 48431849 and dayperiod = '20220901'

09-01 22:07:27 
2ms
select  * from user_time_login_stat where uid = 48431849 and dayperiod = -1

09-01 22:07:27 
2ms
select  * from user_time_login_stat where uid = -1 and dayperiod = '20220901'

09-01 22:07:27 
4ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 48431849
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:07:27 
4ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 22:07:27 
3ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 22:07:28 
3ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 22:07:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:07:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:07:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:07:40 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:07:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:07:41 
4ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:01:41'

09-01 22:07:41 
2ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 22:06:41' and querysyn != 3 

09-01 22:07:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:07:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:07:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:07:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:08:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:08:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:08:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:08:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:08:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:08:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:08:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:08:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:08:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:08:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:08:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:08:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 22:08:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:08:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:08:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:08:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:09:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:09:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:09:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:09:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:09:12 
4ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:09:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:09:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:09:22 
6ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3173


09-01 22:09:22 
4ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:09:23 
4ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 23026121 and `status` = 2

09-01 22:09:23 
6ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 22:09:23 
5ms
select * from wx_friend_group t where t.uid = 23026121

09-01 22:09:23 
4ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 22:09:23 
4ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 23026121
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:09:23 
4ms
select * from yx_conf where name = 'displayInputStatus'

09-01 22:09:23 
4ms
select * from yx_conf where name = 'app.video.is.open.flag'

09-01 22:09:23 
6ms
select * from yx_conf where name = 'onlineStatus'

09-01 22:09:23 
5ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 22:09:23 
5ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '23026121_23026121'
					AND id >= 5315
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 22:09:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:09:25 
3ms
select * from wx_syn_item where uid = 48431849 and devicetype = 5 and syntype = 2

09-01 22:09:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:09:30 
4ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 22:09:30 
5ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 22:09:30 
5ms
select * from `website`

09-01 22:09:31 
4ms
select * from `website`

09-01 22:09:31 
47ms
select * from wx_app where type = 2 and `status` = 1

09-01 22:09:31 
4ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 22:09:31 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 48431849
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 22:09:31 
5ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 48431849
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:09:31 
4ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 22:09:31 
8ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 48431849 and `status` = 2

09-01 22:09:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:09:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:09:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:09:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 22:09:41 
5ms
select count(*) FROM
    `user` a
            LEFT JOIN user_ext b ON a.id = b.uid
            AND b.ext_name = 'uidFind'
            LEFT JOIN user_ext c ON a.id = c.uid
            AND c.ext_name = 'phoneFind'
            LEFT JOIN user_ext e ON a.id = e.uid
            AND e.ext_name = 'loginNameFind'
WHERE
    (1 = 0)
        or (( b.ext_value IS NULL OR b.ext_value = '1' ) AND a.id = '19375836351')
        or (( c.ext_value IS NULL OR c.ext_value = '1' ) AND a.phone is not null and a.phone = '19375836351')
        or (( e.ext_value IS NULL OR e.ext_value = '1' ) AND a.loginname is not null and a.loginname = '19375836351')


09-01 22:09:41 
2ms
SELECT
    a.nick,
    a.id,
    a.avatar
 FROM
    `user` a
            LEFT JOIN user_ext b ON a.id = b.uid
            AND b.ext_name = 'uidFind'
            LEFT JOIN user_ext c ON a.id = c.uid
            AND c.ext_name = 'phoneFind'
            LEFT JOIN user_ext e ON a.id = e.uid
            AND e.ext_name = 'loginNameFind'
WHERE
    (1 = 0)
        or (( b.ext_value IS NULL OR b.ext_value = '1' ) AND a.id = '19375836351')
        or (( c.ext_value IS NULL OR c.ext_value = '1' ) AND a.phone is not null and a.phone = '19375836351')
        or (( e.ext_value IS NULL OR e.ext_value = '1' ) AND a.loginname is not null and a.loginname = '19375836351')
 limit 0, 20

09-01 22:09:44 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 48431849 and chatmode = 1 and bizid = 48431849


09-01 22:09:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:09:48 
3ms
select * from `user` where `id` = 98708001

09-01 22:09:48 
2ms
select * from role r where EXISTS (select rid from user_role rel where uid = 98708001 and r.id = rel.rid and rel.`status` = 1)

09-01 22:09:48 
2ms
select * from user_third where uid=98708001 and type = 5

09-01 22:09:48 
2ms
select * from user_base where uid = 98708001

09-01 22:09:48 
2ms
select * from `website`

09-01 22:09:48 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 22:09:48 
3ms
select * from user_ext where uid = '98708001'

09-01 22:09:48 
2ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 22:09:48 
1ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 22:09:49 
3ms
select * from `website`

09-01 22:09:49 
3ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 22:09:49 
2ms
select * from wx_app where type = 2 and `status` = 1

09-01 22:09:49 
4ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 98708001
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id


09-01 22:09:49 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 22:09:49 
3ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = 98708001 and dayperiod = '20220901'

09-01 22:09:49 
1ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = -1 and dayperiod = '20220901'

09-01 22:09:49 
1ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = -1 and dayperiod = '-1'

09-01 22:09:49 
1ms
select  * from user_time_login_stat where uid = 98708001 and dayperiod = '20220901'

09-01 22:09:49 
1ms
select  * from user_time_login_stat where uid = 98708001 and dayperiod = -1

09-01 22:09:49 
2ms
select  * from user_time_login_stat where uid = -1 and dayperiod = '20220901'

09-01 22:09:49 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 22:09:49 
2ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 98708001
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:09:49 
1ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 22:09:49 
2ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3172


09-01 22:09:49 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 98708001


09-01 22:09:49 
2ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '98708001_98708001'
					AND id >= 5302
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 22:09:49 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 22:09:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:09:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:09:53 
2ms
select * from login_log where uid = 98708001 order by id desc limit 1

09-01 22:09:53 
2ms
select * from `wx_friend` where `id` = 2249

09-01 22:09:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:10:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:10:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:10:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:10:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:10:12 
3ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3172


09-01 22:10:12 
2ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '98708001_98708001'
					AND id >= 5302
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 22:10:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:10:18 
4ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 98708001
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:10:18 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 22:10:18 
6ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 22:10:18 
4ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = 98708001 and dayperiod = '20220901'

09-01 22:10:18 
2ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = -1 and dayperiod = '20220901'

09-01 22:10:18 
2ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = -1 and dayperiod = '-1'

09-01 22:10:18 
4ms
select  * from user_time_login_stat where uid = 98708001 and dayperiod = '20220901'

09-01 22:10:18 
3ms
select  * from user_time_login_stat where uid = 98708001 and dayperiod = -1

09-01 22:10:18 
3ms
select  * from user_time_login_stat where uid = -1 and dayperiod = '20220901'

09-01 22:10:18 
5ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 22:10:18 
4ms
	SELECT
		wg.id groupid,
		wg.`name`,
		wg.avatar,
		wg.uid,
		gu.grouprole,
		wgm.joinnum
	FROM
		wx_group wg
	INNER JOIN (
		SELECT
			bizid,linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 98708001
		AND chatmode = 2
		AND linkflag = 1
	) AS groupindex ON groupindex.bizid = wg.id
	INNER JOIN wx_group_meta wgm ON wg.id = wgm.groupid
	INNER JOIN wx_group_user gu on gu.id = groupindex.linkid
	order by wg.id desc


09-01 22:10:18 
4ms
select * from wx_friend_group t where t.uid = 98708001

09-01 22:10:18 
4ms
select * from yx_conf where name = 'app.video.is.open.flag'

09-01 22:10:18 
3ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 22:10:18 
3ms
select * from yx_conf where name = 'displayInputStatus'

09-01 22:10:18 
8ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 98708001
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:10:19 
5ms
select * from yx_conf where name = 'onlineStatus'

09-01 22:10:19 
4ms
select * from login_log where uid = 98708001 order by id desc limit 1

09-01 22:10:19 
3ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 22:10:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:10:24 
5ms
select * from login_log where uid = 98708001 order by id desc limit 1

09-01 22:10:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:10:25 
4ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3172


09-01 22:10:25 
5ms
select * from login_log where uid = 98708001 order by id desc limit 1

09-01 22:10:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:10:34 
4ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3172


09-01 22:10:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:10:34 
4ms
	select * from wx_user_black_items where uid = 98708001 and touid = 98708001


09-01 22:10:34 
3ms
	select * from wx_user_black_items where uid = 98708001 and touid = 98708001


09-01 22:10:34 
4ms
select * from ip_info where ip='0.0.0.0' and country='' and area='' and province='' and city='内网IP' and operator='内网IP'

09-01 22:10:34 
1ms
	select * from wx_user_black_items where uid = 98708001 and touid = 98708001


09-01 22:10:34 
4ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 22:10:34 
6ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 22:10:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:10:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:10:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 22:10:41 
5ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:04:41'

09-01 22:10:41 
3ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 22:10:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:10:45 
2ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3172


09-01 22:10:45 
2ms
	select * from wx_user_black_items where uid = 98708001 and touid = 98708001


09-01 22:10:45 
2ms
	select * from wx_user_black_items where uid = 98708001 and touid = 98708001


09-01 22:10:45 
5ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 22:10:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:10:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:10:52 
4ms
select * from `wx_call_item` where `id` = 471

09-01 22:10:52 
4ms
select * from `wx_call_item` where `id` = 471

09-01 22:10:52 
2ms
	select * from wx_user_black_items where uid = 98708001 and touid = 98708001


09-01 22:10:53 
6ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 22:10:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:11:00 
8ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:11:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:11:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:11:05 
3ms
select * from `website`

09-01 22:11:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:11:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:11:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:11:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:11:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:11:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:11:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:11:40 
7ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:11:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:11:41 
5ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:05:41'

09-01 22:11:41 
3ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 22:11:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:11:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:11:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:11:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:12:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:12:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:12:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:12:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:12:12 
4ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:12:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:12:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:12:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:12:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:12:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:12:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:12:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:12:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:12:41 
5ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:06:41'

09-01 22:12:41 
3ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 22:11:41' and querysyn != 3 

09-01 22:12:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:12:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:12:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:12:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:13:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:13:00 
4ms
select * from user where phone = '13723450735' and `status` <> 6

09-01 22:13:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:13:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:13:10 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:13:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:13:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:13:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:13:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:13:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:13:35 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:13:40 
39ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:13:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:13:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:13:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:13:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:13:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:13:59 
5ms
select * from user where phone = '13760886509' and `status` <> 6

09-01 22:14:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:14:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:14:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:14:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:14:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:14:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:14:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:14:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:14:31 
4ms
select * from `user` where `id` = 16779238

09-01 22:14:31 
3ms
select * from user where phone = '13760886509' and `status` <> 6

09-01 22:14:31 
4ms
select id,r,g,b from auto_avatar_plate

09-01 22:14:31 
3ms
select path from auto_avatar where chatindex = 'J' limit 0,1

09-01 22:14:31 
2ms
select * from user where loginname = '13760886509' and `status` <> 6

09-01 22:14:31 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 16779238 and chatmode = 1 and bizid = 16779238


09-01 22:14:31 
3ms
select * from `user` where `id` = 16779238

09-01 22:14:31 
3ms
select * from role r where EXISTS (select rid from user_role rel where uid = 16779238 and r.id = rel.rid and rel.`status` = 1)

09-01 22:14:31 
3ms
select * from user_third where uid=16779238 and type = 5

09-01 22:14:31 
3ms
select * from user_base where uid = 16779238

09-01 22:14:31 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 16779238 and chatmode = 1 and bizid = 16779238


09-01 22:14:31 
3ms
SELECT * from user_register_stat where type = 1 and statbizstr = '20220901'

09-01 22:14:31 
2ms
SELECT * from user_register_stat where type = 2 and statbizstr = '172.20.10.2'

09-01 22:14:31 
2ms
SELECT * from user_register_stat where type = 3 and statbizstr = '20220901' and statbizid = 4861 

09-01 22:14:31 
5ms
select * from `user` where `id` = 88888888

09-01 22:14:31 
3ms
	SELECT
		g.*, 
		m.id metaid,
		m.joinnum,
		m.allactflag,
		m.forbiddenflag,
		m.allstartflag
	FROM
		wx_group g
	INNER JOIN wx_group_meta m ON m.groupid = g.id
	WHERE
		g.id = 235


09-01 22:14:34 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:14:35 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:14:40 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:14:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 22:14:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:14:45 
4ms
select * from user where phone = '13760886509' and `status` <> 6

09-01 22:14:45 
3ms
select * from `user` where `id` = 16779238

09-01 22:14:45 
3ms
select * from role r where EXISTS (select rid from user_role rel where uid = 16779238 and r.id = rel.rid and rel.`status` = 1)

09-01 22:14:45 
4ms
select * from user_third where uid=16779238 and type = 5

09-01 22:14:45 
3ms
select * from user_base where uid = 16779238

09-01 22:14:45 
2ms
select * from user_token where devicetype=5 and uid=16779238 limit 1

09-01 22:14:45 
4ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = 16779238 and dayperiod = '20220901'

09-01 22:14:45 
3ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = -1 and dayperiod = '20220901'

09-01 22:14:45 
4ms
select * from user_ip_login_stat where ip = '172.20.10.2' and uid = -1 and dayperiod = '-1'

09-01 22:14:45 
5ms
select  * from user_time_login_stat where uid = 16779238 and dayperiod = '20220901'

09-01 22:14:45 
3ms
select  * from user_time_login_stat where uid = 16779238 and dayperiod = -1

09-01 22:14:45 
3ms
select * from user_ext where uid = '16779238'

09-01 22:14:45 
3ms
select  * from user_time_login_stat where uid = -1 and dayperiod = '20220901'

09-01 22:14:45 
2ms
select * from `website`

09-01 22:14:45 
3ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 16779238
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id


09-01 22:14:45 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 16779238
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 22:14:45 
6ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 16779238
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:14:45 
5ms
select * from `website`

09-01 22:14:45 
3ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 16779238 and `status` = 2

09-01 22:14:45 
4ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 22:14:46 
5ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 16779238 and `status` = 2

09-01 22:14:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:14:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:14:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:15:00 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:15:02 
7ms
select count(*) FROM
    `user` a
            LEFT JOIN user_ext b ON a.id = b.uid
            AND b.ext_name = 'uidFind'
            LEFT JOIN user_ext c ON a.id = c.uid
            AND c.ext_name = 'phoneFind'
            LEFT JOIN user_ext e ON a.id = e.uid
            AND e.ext_name = 'loginNameFind'
WHERE
    (1 = 0)
        or (( b.ext_value IS NULL OR b.ext_value = '1' ) AND a.id = '19375836351')
        or (( c.ext_value IS NULL OR c.ext_value = '1' ) AND a.phone is not null and a.phone = '19375836351')
        or (( e.ext_value IS NULL OR e.ext_value = '1' ) AND a.loginname is not null and a.loginname = '19375836351')


09-01 22:15:02 
4ms
SELECT
    a.nick,
    a.id,
    a.avatar
 FROM
    `user` a
            LEFT JOIN user_ext b ON a.id = b.uid
            AND b.ext_name = 'uidFind'
            LEFT JOIN user_ext c ON a.id = c.uid
            AND c.ext_name = 'phoneFind'
            LEFT JOIN user_ext e ON a.id = e.uid
            AND e.ext_name = 'loginNameFind'
WHERE
    (1 = 0)
        or (( b.ext_value IS NULL OR b.ext_value = '1' ) AND a.id = '19375836351')
        or (( c.ext_value IS NULL OR c.ext_value = '1' ) AND a.phone is not null and a.phone = '19375836351')
        or (( e.ext_value IS NULL OR e.ext_value = '1' ) AND a.loginname is not null and a.loginname = '19375836351')
 limit 0, 20

09-01 22:15:03 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 16779238 and chatmode = 1 and bizid = 48431849


09-01 22:15:03 
3ms
	select * from wx_user_black_items where uid = 48431849 and touid = 16779238


09-01 22:15:03 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 16779238 and chatmode = 1 and bizid = 48431849


09-01 22:15:03 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 48431849 and chatmode = 1 and bizid = 16779238


09-01 22:15:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:15:04 
6ms
select * from user_vip_level where vip_level = 0

09-01 22:15:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:15:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:15:12 
4ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:15:12 
3ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3172


09-01 22:15:12 
5ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '98708001_98708001'
					AND id >= 5302
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 22:15:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:15:15 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 16779238 and chatmode = 1 and bizid = 48431849


09-01 22:15:15 
4ms
	select * from wx_user_black_items where uid = 48431849 and touid = 16779238


09-01 22:15:15 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 16779238 and chatmode = 1 and bizid = 48431849


09-01 22:15:15 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 48431849 and chatmode = 1 and bizid = 16779238


09-01 22:15:16 
4ms
select * from user_vip_level where vip_level = 0

09-01 22:15:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:15:23 
3ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 98708001
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		


09-01 22:15:23 
3ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 98708001
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 22:15:23 
3ms
	SELECT
		ai.id,
		fromuid uid,
		greet,
		ai.`status`,
		replytime,
		autoflag,
		nick,
		avatar
	FROM
		wx_friend_apply_items ai
	INNER JOIN `user` u ON u.id = ai.fromuid
	WHERE
		ai.touid = 98708001
	ORDER BY
		ai.id DESC


09-01 22:15:23 
2ms
select * from wx_friend_group t where t.uid = 98708001

09-01 22:15:24 
5ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 98708001
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:15:24 
4ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 22:15:24 
4ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 22:15:24 
3ms
select * from wx_friend_group t where t.uid = 98708001

09-01 22:15:24 
4ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 98708001
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:15:24 
5ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 22:15:24 
6ms
select * from yx_conf where name = 'displayInputStatus'

09-01 22:15:24 
6ms
select * from yx_conf where name = 'app.video.is.open.flag'

09-01 22:15:24 
5ms
select * from yx_conf where name = 'onlineStatus'

09-01 22:15:24 
4ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 22:15:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:15:30 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:15:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:15:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:15:39 
5ms
select count(*) FROM
    `user` a
            LEFT JOIN user_ext b ON a.id = b.uid
            AND b.ext_name = 'uidFind'
            LEFT JOIN user_ext c ON a.id = c.uid
            AND c.ext_name = 'phoneFind'
            LEFT JOIN user_ext e ON a.id = e.uid
            AND e.ext_name = 'loginNameFind'
WHERE
    (1 = 0)
        or (( b.ext_value IS NULL OR b.ext_value = '1' ) AND a.id = '13760886509')
        or (( c.ext_value IS NULL OR c.ext_value = '1' ) AND a.phone is not null and a.phone = '13760886509')
        or (( e.ext_value IS NULL OR e.ext_value = '1' ) AND a.loginname is not null and a.loginname = '13760886509')


09-01 22:15:39 
3ms
SELECT
    a.nick,
    a.id,
    a.avatar
 FROM
    `user` a
            LEFT JOIN user_ext b ON a.id = b.uid
            AND b.ext_name = 'uidFind'
            LEFT JOIN user_ext c ON a.id = c.uid
            AND c.ext_name = 'phoneFind'
            LEFT JOIN user_ext e ON a.id = e.uid
            AND e.ext_name = 'loginNameFind'
WHERE
    (1 = 0)
        or (( b.ext_value IS NULL OR b.ext_value = '1' ) AND a.id = '13760886509')
        or (( c.ext_value IS NULL OR c.ext_value = '1' ) AND a.phone is not null and a.phone = '13760886509')
        or (( e.ext_value IS NULL OR e.ext_value = '1' ) AND a.loginname is not null and a.loginname = '13760886509')
 limit 0, 20

09-01 22:15:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:15:41 
4ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:09:41'

09-01 22:15:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:15:41 
3ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 22:15:42 
5ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 16779238


09-01 22:15:42 
4ms
select * from login_log where uid = 16779238 order by id desc limit 1

09-01 22:15:42 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 16779238


09-01 22:15:44 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 16779238


09-01 22:15:44 
3ms
	select * from wx_user_black_items where uid = 16779238 and touid = 98708001


09-01 22:15:44 
4ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 16779238


09-01 22:15:44 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 16779238 and chatmode = 1 and bizid = 98708001


09-01 22:15:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:15:46 
4ms
select * from user_vip_level where vip_level = 0

09-01 22:15:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:15:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:15:51 
5ms
	SELECT
		ai.id,
		fromuid uid,
		greet,
		ai.`status`,
		replytime,
		autoflag,
		nick,
		avatar
	FROM
		wx_friend_apply_items ai
	INNER JOIN `user` u ON u.id = ai.fromuid
	WHERE
		ai.touid = 16779238
	ORDER BY
		ai.id DESC


09-01 22:15:53 
3ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 98708001
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:15:53 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 22:15:53 
2ms
SELECT count(1) num FROM wx_friend_apply_items where touid = 98708001 and `status` = 2

09-01 22:15:53 
3ms
select * from announcement where status = 2 order by createtime desc limit 1

09-01 22:15:53 
4ms
select * from wx_friend_group t where t.uid = 98708001

09-01 22:15:53 
2ms
select * from yx_conf where name = 'app.video.is.open.flag'

09-01 22:15:53 
32ms
select * from yx_conf where name = 'displayInputStatus'

09-01 22:15:53 
19ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 22:15:53 
19ms
	SELECT
		IF (chatmode = 2 ,- bizid, items.id) id,
		IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
		 uid,
		 chatmode,
		 bizid,
		 linkid,
		 bizrole,
		 avatar,
		 linkflag,
		 `name`,
		 joinnum,
		 toreadflag,
		 readflag,
		 viewflag,
		 notreadcount,
		 notreadstartmsgid,
		 atreadflag,
		 atnotreadcount,
		 atnotreadstartmsgid,
		 sysmsgkey,
		 opernick,
		 tonicks,
		 topflag,
		 lastmsgid,
		 lastmsguid,
		 fromnick,
		 msgresume,
		 msgtype,
		 sysflag,
		 chatuptime,
		 sendtime
	FROM
		wx_chat_items items
		INNER JOIN wx_chat_items_meta meta on items.id = meta.chatlinkid
	WHERE
		items.id IN (
			SELECT
				chatlinkid
			FROM
				wx_chat_user_item
			WHERE
				uid = 98708001
		)
	ORDER BY
		topflag,
		chatuptime desc
	LIMIT 0,300


09-01 22:15:53 
2ms
select * from yx_conf where name = 'onlineStatus'

09-01 22:15:54 
3ms
select * from yx_conf where name = 'msg.read.focus.flag'

09-01 22:15:54 
3ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3172


09-01 22:15:54 
3ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '98708001_98708001'
					AND id >= 5302
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 22:15:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:15:55 
4ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3172


09-01 22:15:55 
3ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '98708001_98708001'
					AND id >= 5302
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 22:15:58 
4ms
	SELECT
		ai.id,
		fromuid uid,
		greet,
		ai.`status`,
		replytime,
		autoflag,
		nick,
		avatar
	FROM
		wx_friend_apply_items ai
	INNER JOIN `user` u ON u.id = ai.fromuid
	WHERE
		ai.touid = 98708001
	ORDER BY
		ai.id DESC


09-01 22:16:00 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:16:04 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:16:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:16:05 
4ms
select * from wx_friend_group t where t.uid = 98708001

09-01 22:16:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:16:14 
5ms
select count(*) FROM
    `user` a
            LEFT JOIN user_ext b ON a.id = b.uid
            AND b.ext_name = 'uidFind'
            LEFT JOIN user_ext c ON a.id = c.uid
            AND c.ext_name = 'phoneFind'
            LEFT JOIN user_ext e ON a.id = e.uid
            AND e.ext_name = 'loginNameFind'
WHERE
    (1 = 0)
        or (( b.ext_value IS NULL OR b.ext_value = '1' ) AND a.id = '13760886509')
        or (( c.ext_value IS NULL OR c.ext_value = '1' ) AND a.phone is not null and a.phone = '13760886509')
        or (( e.ext_value IS NULL OR e.ext_value = '1' ) AND a.loginname is not null and a.loginname = '13760886509')


09-01 22:16:14 
3ms
SELECT
    a.nick,
    a.id,
    a.avatar
 FROM
    `user` a
            LEFT JOIN user_ext b ON a.id = b.uid
            AND b.ext_name = 'uidFind'
            LEFT JOIN user_ext c ON a.id = c.uid
            AND c.ext_name = 'phoneFind'
            LEFT JOIN user_ext e ON a.id = e.uid
            AND e.ext_name = 'loginNameFind'
WHERE
    (1 = 0)
        or (( b.ext_value IS NULL OR b.ext_value = '1' ) AND a.id = '13760886509')
        or (( c.ext_value IS NULL OR c.ext_value = '1' ) AND a.phone is not null and a.phone = '13760886509')
        or (( e.ext_value IS NULL OR e.ext_value = '1' ) AND a.loginname is not null and a.loginname = '13760886509')
 limit 0, 20

09-01 22:16:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:16:20 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:16:22 
5ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 16779238


09-01 22:16:22 
3ms
	select * from wx_user_black_items where uid = 16779238 and touid = 98708001


09-01 22:16:22 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 16779238


09-01 22:16:22 
3ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 16779238 and chatmode = 1 and bizid = 98708001


09-01 22:16:24 
5ms
select * from user_vip_level where vip_level = 0

09-01 22:16:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:16:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:16:31 
3ms
select * from wx_friend_group t where t.uid = 98708001

09-01 22:16:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:16:34 
5ms
select count(*) FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 98708001
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		


09-01 22:16:34 
6ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	 FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 98708001
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id
 limit 0, 16

09-01 22:16:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:16:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:16:41 
4ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:10:41'

09-01 22:16:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:16:41 
3ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 22:16:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:16:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:16:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:16:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:17:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:17:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:17:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:17:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:17:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:17:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:17:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:17:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:17:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:17:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:17:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:17:41 
2ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:11:41'

09-01 22:17:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 22:17:41 
3ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 22:16:41' and querysyn != 3 

09-01 22:17:42 
2ms
select * from yx_user_wallet where uid = 16779238

09-01 22:17:42 
2ms
select * from yx_user_wallet where uid = 16779238

09-01 22:17:45 
12ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:17:48 
2ms
select * from yx_user_wallet where uid = 16779238

09-01 22:17:48 
3ms
select * from yx_user_wallet where uid = 16779238

09-01 22:17:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:17:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:17:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:18:00 
8ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:18:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:18:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:18:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:18:12 
6ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:18:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:18:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:18:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:18:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:18:34 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:18:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:18:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:18:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 22:18:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:18:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:18:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:18:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:19:00 
12ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:19:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:19:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:19:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:19:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:19:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:19:23 
2ms
select * from yx_user_wallet where uid = 16779238

09-01 22:19:23 
39ms
select * from yx_user_wallet where uid = 16779238

09-01 22:19:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:19:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:19:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:19:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:19:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:19:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 22:19:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:19:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:19:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:19:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:20:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:20:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:20:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:20:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:20:15 
15ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:20:20 
112ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:20:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:20:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:20:30 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 16779238


09-01 22:20:30 
2ms
	select * from wx_user_black_items where uid = 16779238 and touid = 98708001


09-01 22:20:30 
1ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001 and chatmode = 1 and bizid = 16779238


09-01 22:20:30 
2ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 16779238 and chatmode = 1 and bizid = 98708001


09-01 22:20:34 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:20:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:20:40 
27ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:20:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 22:20:41 
2ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:14:41'

09-01 22:20:41 
2ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 22:20:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:20:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:20:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:20:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:21:00 
38ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:21:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:21:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:21:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:21:12 
5ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:21:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:21:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:21:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:21:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:21:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:21:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:21:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:21:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:21:41 
4ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:15:41'

09-01 22:21:41 
3ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 22:21:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:21:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:21:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:21:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:22:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:22:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:22:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:22:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:22:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:22:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:22:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:22:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:22:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:22:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:22:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:22:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 22:22:41 
5ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:16:41'

09-01 22:22:41 
2ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 22:21:41' and querysyn != 3 

09-01 22:22:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:22:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:22:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:22:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:23:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:23:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:23:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:23:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:23:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:23:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:23:25 
0ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:23:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:23:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:23:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:23:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:23:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:23:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:23:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:23:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:23:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:24:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:24:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:24:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:24:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:24:12 
5ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:24:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:24:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:24:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:24:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:24:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:24:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:24:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:24:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 22:24:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:24:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:24:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:24:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:25:00 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:25:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:25:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:25:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:25:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:25:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:25:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:25:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:25:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:25:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:25:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:25:41 
35ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:19:41'

09-01 22:25:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 22:25:41 
2ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 22:25:45 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:25:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:25:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:25:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:26:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:26:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:26:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:26:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:26:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:26:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:26:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:26:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:26:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:26:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:26:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:26:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:26:41 
4ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:20:41'

09-01 22:26:41 
4ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 22:26:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:26:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:26:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:26:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:27:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:27:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:27:05 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:27:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:27:12 
2ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:27:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:27:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:27:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:27:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:27:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:27:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:27:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:27:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:27:41 
4ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:21:41'

09-01 22:27:41 
3ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 22:26:41' and querysyn != 3 

09-01 22:27:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:27:50 
37ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:27:50 
37ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:27:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:28:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:28:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:28:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:28:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:28:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:28:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:28:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:28:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:28:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:28:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:28:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:28:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 22:28:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:28:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:28:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:28:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:29:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:29:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:29:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:29:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:29:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:29:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:29:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:29:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:29:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:29:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:29:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:29:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:29:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:29:50 
38ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:29:50 
39ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:29:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:30:00 
9ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:30:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:30:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:30:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:30:12 
5ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:30:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:30:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:30:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:30:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:30:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:30:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:30:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:30:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:30:41 
5ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:24:41'

09-01 22:30:41 
3ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 22:30:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:30:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:30:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:30:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:31:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:31:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:31:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:31:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:31:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:31:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:31:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:31:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:31:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:31:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:31:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:31:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 22:31:41 
2ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:25:41'

09-01 22:31:41 
1ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 22:31:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:31:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:31:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:31:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:32:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:32:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:32:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:32:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:32:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:32:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:32:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:32:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:32:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:32:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:32:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:32:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 22:32:41 
2ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:26:41'

09-01 22:32:41 
2ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 22:31:41' and querysyn != 3 

09-01 22:32:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:32:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:32:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:32:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:33:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:33:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:33:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:33:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:33:12 
4ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:33:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:33:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:33:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:33:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:33:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:33:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:33:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:33:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 22:33:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:33:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:33:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:33:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:34:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:34:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:34:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:34:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:34:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:34:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:34:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:34:30 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:34:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:34:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:34:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:34:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 22:34:45 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:34:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:34:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:34:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:35:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:35:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:35:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:35:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:35:15 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:35:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:35:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:35:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:35:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:35:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:35:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:35:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 22:35:41 
1ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:29:41'

09-01 22:35:41 
2ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 22:35:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:35:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:35:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:35:55 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:36:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:36:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:36:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:36:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:36:12 
3ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:36:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:36:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:36:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:36:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:36:34 
1ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:36:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:36:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:36:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 22:36:41 
2ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:30:41'

09-01 22:36:41 
2ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 22:36:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:36:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:36:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:36:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:37:00 
29ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:37:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:37:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:37:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:37:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:37:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:37:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:37:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:37:34 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:37:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:37:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:37:41 
3ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:31:41'

09-01 22:37:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 22:37:41 
3ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 22:36:41' and querysyn != 3 

09-01 22:37:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:37:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:37:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:37:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:38:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:38:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:38:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:38:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:38:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:38:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:38:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:38:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:38:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:38:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:38:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:38:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 22:38:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:38:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:38:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:38:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:39:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:39:04 
37ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:39:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:39:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:39:12 
3ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:39:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:39:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:39:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:39:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:39:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:39:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:39:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:39:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:39:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:39:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:39:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:39:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:40:00 
12ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:40:03 
7ms
	SELECT
		wf.id,
		wf.remarkname,
		u.nick,
		u.avatar,
		wf.chatindex,
		u.id uid
	FROM
		wx_friend wf
	INNER JOIN (
		SELECT
			linkid
		FROM
			wx_chat_user_item
		WHERE
			uid = 23026121
		AND chatmode = 1
	) AS userindex ON userindex.linkid = wf.id
	INNER JOIN `user` u ON u.id = wf.frienduid and u.status = 1
	
		ORDER BY
		 wf.chatindex,wf.id


09-01 22:40:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:40:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:40:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:40:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:40:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:40:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:40:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:40:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:40:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:40:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:40:41 
4ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:34:41'

09-01 22:40:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 22:40:41 
3ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 22:40:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:40:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:40:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:40:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:41:00 
31ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:41:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:41:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:41:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:41:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:41:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:41:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:41:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:41:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:41:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:41:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:41:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:41:41 
5ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:35:41'

09-01 22:41:41 
3ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 22:41:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:41:50 
41ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:41:50 
41ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:41:55 
29ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:42:00 
8ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:42:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:42:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:42:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:42:12 
3ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:42:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:42:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:42:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:42:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:42:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:42:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:42:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:42:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 22:42:41 
3ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:36:41'

09-01 22:42:41 
2ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 22:41:41' and querysyn != 3 

09-01 22:42:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:42:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:42:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:42:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:43:00 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:43:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:43:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:43:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:43:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:43:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:43:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:43:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:43:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:43:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:43:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:43:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:43:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:43:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:43:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:43:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:44:00 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:44:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:44:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:44:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:44:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:44:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:44:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:44:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:44:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:44:35 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:44:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:44:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:44:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:44:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:44:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:44:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:45:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:45:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:45:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:45:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:45:12 
3ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:45:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:45:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:45:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:45:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:45:34 
13ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:45:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:45:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:45:41 
2ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:39:41'

09-01 22:45:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 22:45:41 
2ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 22:45:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:45:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:45:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:45:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:46:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:46:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:46:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:46:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:46:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:46:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:46:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:46:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:46:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:46:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:46:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:46:41 
4ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:40:41'

09-01 22:46:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:46:41 
2ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 22:46:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:46:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:46:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:46:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:47:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:47:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:47:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:47:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:47:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:47:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:47:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:47:28 
4ms
	SELECT
	IF (chatmode = 2 ,- bizid, items.id) chatlinkid,
	 items.*
	FROM
		wx_chat_items items
	WHERE
		items.id = 3172


09-01 22:47:28 
8ms
	SELECT
		msg.*, u.nick,
		u.avatar
	FROM
		(
			SELECT
				id mid,
				uid,
				touid,
				sigleuid,
				sigleflag,
				text c,
				IF(contenttype = 4,text,'') ac,
				IF(contenttype = 2,text,'') bc,
				IF(contenttype = 3,text,'') fc,
				IF(contenttype = 6,text,'') ic,
				IF(contenttype = 14, text, '') location,
				IF(contenttype = 15,text,'') faceEmotion,
				IF(contenttype = 16,text,'') transAmountVo,
				IF(contenttype = 17,text,'') transSendVo,
				IF(contenttype = 5,text,'') vc,
				IF(contenttype = 9,text,'') cardc,
				IF(contenttype = 10 or contenttype = 11,text,'') `call`,
				IF(contenttype = 12,text,'') red,

				IF(contenttype = 88,text,'') temp,
				readflag,
				readtime,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
				twouid = '98708001_98708001'
					AND id >= 5302
				AND `status` = 1
				AND contenttype != 7
			ORDER BY
				id DESC
			LIMIT 0,
			100
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		mid DESC


09-01 22:47:29 
3ms
select * from login_log where uid = 98708001 order by id desc limit 1

09-01 22:47:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:47:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:47:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:47:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:47:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 22:47:41 
4ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:41:41'

09-01 22:47:41 
4ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 22:46:41' and querysyn != 3 

09-01 22:47:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:47:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:47:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:47:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:48:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:48:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:48:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:48:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:48:12 
6ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:48:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:48:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:48:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:48:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:48:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:48:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:48:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:48:41 
1ms
select * from yx_user_send_red_packet where status = 2

09-01 22:48:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:48:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:48:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:48:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:49:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:49:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:49:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:49:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:49:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:49:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:49:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:49:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:49:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:49:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:49:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:49:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 22:49:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:49:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:49:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:49:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:50:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:50:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:50:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:50:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:50:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:50:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:50:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:50:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:50:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:50:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:50:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:50:41 
2ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:44:41'

09-01 22:50:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 22:50:41 
2ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 22:50:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:50:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:50:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:50:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:51:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:51:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:51:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:51:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:51:12 
2ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:51:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:51:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:51:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:51:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:51:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:51:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:51:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:51:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 22:51:41 
3ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:45:41'

09-01 22:51:41 
2ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 22:51:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:51:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:51:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:51:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:52:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:52:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:52:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:52:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:52:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:52:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:52:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:52:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:52:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:52:35 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:52:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:52:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 22:52:41 
3ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:46:41'

09-01 22:52:41 
2ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 22:51:41' and querysyn != 3 

09-01 22:52:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:52:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:52:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:52:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:53:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:53:04 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:53:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:53:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:53:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:53:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:53:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:53:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:53:34 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:53:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:53:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:53:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 22:53:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:53:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:53:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:53:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:54:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:54:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:54:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:54:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:54:12 
3ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:54:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:54:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:54:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:54:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:54:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:54:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:54:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:54:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:54:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:54:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:54:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:54:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:55:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:55:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:55:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:55:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:55:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:55:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:55:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:55:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:55:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:55:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:55:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:55:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 22:55:41 
2ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:49:41'

09-01 22:55:41 
1ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 22:55:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:55:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:55:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:55:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:56:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:56:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:56:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:56:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:56:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:56:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:56:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:56:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:56:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:56:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:56:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:56:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 22:56:41 
3ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:50:41'

09-01 22:56:41 
3ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 22:56:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:56:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:56:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:56:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:57:00 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:57:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:57:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:57:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:57:12 
4ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 22:57:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:57:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:57:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:57:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:57:34 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:57:35 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:57:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:57:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:57:41 
5ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:51:41'

09-01 22:57:41 
4ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 22:56:41' and querysyn != 3 

09-01 22:57:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:57:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:57:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:57:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:58:00 
7ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:58:04 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:58:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:58:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:58:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:58:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:58:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:58:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:58:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:58:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:58:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:58:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:58:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:58:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:58:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:58:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:59:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:59:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:59:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:59:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:59:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:59:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:59:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:59:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:59:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 22:59:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:59:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:59:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 22:59:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:59:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 22:59:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 22:59:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:00:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:00:04 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:00:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:00:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:00:12 
5ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 23:00:15 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:00:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:00:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:00:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:00:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:00:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:00:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:00:41 
4ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:54:41'

09-01 23:00:41 
3ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 23:00:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:00:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:00:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:00:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:01:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:01:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:01:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:01:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:01:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:01:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:01:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:01:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:01:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:01:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:01:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:01:41 
5ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:55:41'

09-01 23:01:41 
3ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 23:01:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:01:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:01:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:01:55 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:02:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:02:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:02:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:02:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:02:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:02:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:02:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:02:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:02:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:02:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:02:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:02:41 
5ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:56:41'

09-01 23:02:41 
2ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 23:01:41' and querysyn != 3 

09-01 23:02:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:02:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:02:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:02:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:03:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:03:04 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:03:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:03:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:03:12 
4ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 23:03:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:03:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:03:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:03:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:03:34 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:03:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:03:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:03:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 23:03:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:03:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:03:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:03:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:04:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:04:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:04:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:04:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:04:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:04:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:04:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:04:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:04:34 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:04:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:04:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:04:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 23:04:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:04:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:04:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:04:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:05:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:05:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:05:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:05:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:05:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:05:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:05:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:05:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:05:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:05:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:05:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:05:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 23:05:41 
3ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 22:59:41'

09-01 23:05:41 
2ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 23:05:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:05:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:05:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:05:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:06:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:06:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:06:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:06:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:06:12 
5ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 23:06:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:06:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:06:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:06:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:06:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:06:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:06:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:06:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 23:06:41 
4ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:00:41'

09-01 23:06:41 
4ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 23:06:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:06:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:06:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:06:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:07:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:07:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:07:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:07:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:07:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:07:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:07:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:07:30 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:07:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:07:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:07:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:07:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 23:07:41 
5ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:01:41'

09-01 23:07:41 
3ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 23:06:41' and querysyn != 3 

09-01 23:07:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:07:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:07:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:07:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:08:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:08:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:08:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:08:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:08:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:08:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:08:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:08:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:08:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:08:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:08:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:08:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 23:08:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:08:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:08:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:08:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:09:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:09:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:09:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:09:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:09:12 
2ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 23:09:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:09:20 
7ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:17 
52376ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:18 
58ms
	SELECT
		*
	FROM
		wx_chat_user_item
	WHERE
		uid = 98708001
			AND chatmode = 2
		AND linkflag = 1
		AND chatlinkid is not null


09-01 23:10:18 
10ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = 98708001 and dayperiod = '20220901'

09-01 23:10:18 
2ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = -1 and dayperiod = '20220901'

09-01 23:10:18 
2ms
select * from user_ip_login_stat where ip = '172.20.10.4' and uid = -1 and dayperiod = '-1'

09-01 23:10:18 
3ms
select  * from user_time_login_stat where uid = 98708001 and dayperiod = '20220901'

09-01 23:10:18 
2ms
select  * from user_time_login_stat where uid = 98708001 and dayperiod = -1

09-01 23:10:18 
1ms
select  * from user_time_login_stat where uid = -1 and dayperiod = '20220901'

09-01 23:10:20 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:20 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:10:20 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:20 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:20 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 23:10:20 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:20 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:10:20 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:20 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:20 
1ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:10:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:20 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:20 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:20 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:10:35 
50ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 23:10:41 
4ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:04:41'

09-01 23:10:41 
2ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 23:10:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:10:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:10:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:11:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:11:04 
1ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:11:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:11:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:11:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:11:20 
1ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:11:25 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:11:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:11:34 
39ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:11:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:11:40 
39ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:11:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 23:11:41 
37ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:05:41'

09-01 23:11:41 
4ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 23:11:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:11:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:11:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:11:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:12:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:12:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:12:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:12:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:12:12 
5ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 23:12:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:12:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:12:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:12:30 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:12:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:12:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:12:40 
39ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:12:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 23:12:41 
5ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:06:41'

09-01 23:12:41 
3ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 23:11:41' and querysyn != 3 

09-01 23:12:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:12:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:12:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:12:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:13:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:13:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:13:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:13:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:13:15 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:13:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:13:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:13:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:13:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:13:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:13:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:13:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 23:13:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:13:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:13:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:13:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:14:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:14:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:14:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:14:10 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:14:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:14:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:14:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:14:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:14:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:14:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:14:40 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:14:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 23:14:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:14:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:14:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:14:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:15:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:15:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:15:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:15:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:15:12 
4ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 23:15:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:15:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:15:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:15:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:15:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:15:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:15:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:15:41 
35ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:09:41'

09-01 23:15:41 
3ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 23:15:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 23:15:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:15:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:15:50 
5ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:15:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:16:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:16:04 
7ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:16:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:16:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:16:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:16:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:16:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:16:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:16:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:16:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:16:40 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:16:41 
2ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:10:41'

09-01 23:16:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 23:16:41 
3ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 23:16:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:16:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:16:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:16:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:17:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:17:04 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:17:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:17:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:17:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:17:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:17:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:17:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:17:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:17:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:17:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:17:41 
4ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:11:41'

09-01 23:17:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 23:17:41 
3ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 23:16:41' and querysyn != 3 

09-01 23:17:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:17:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:17:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:17:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:18:00 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:18:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:18:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:18:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:18:12 
4ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 23:18:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:18:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:18:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:18:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:18:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:18:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:18:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:18:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 23:18:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:18:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:18:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:18:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:19:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:19:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:19:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:19:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:19:15 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:19:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:19:25 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:19:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:19:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:19:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:19:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:19:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 23:19:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:19:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:19:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:19:55 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:20:00 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:20:04 
6ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:20:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:20:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:20:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:20:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:20:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:20:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:20:34 
9ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:20:35 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:20:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:20:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 23:20:41 
10ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:14:41'

09-01 23:20:41 
3ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 23:20:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:20:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:20:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:20:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:21:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:21:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:21:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:21:10 
37ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:21:12 
10ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 23:21:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:21:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:21:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:21:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:21:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:21:35 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:21:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:21:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 23:21:41 
3ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:15:41'

09-01 23:21:41 
3ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 23:21:45 
39ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:21:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:21:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:21:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:22:00 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:22:04 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:22:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:22:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:22:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:22:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:22:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:22:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:22:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:22:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:22:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:22:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 23:22:41 
5ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:16:41'

09-01 23:22:41 
3ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 23:21:41' and querysyn != 3 

09-01 23:22:45 
41ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:22:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:22:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:22:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:23:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:23:04 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:23:05 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:23:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:23:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:23:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:23:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:23:30 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:23:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:23:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:23:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:23:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 23:23:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:23:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:23:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:23:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:24:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:24:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:24:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:24:10 
22ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:24:12 
4ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 23:24:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:24:20 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:24:25 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:24:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:24:34 
3ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:24:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:24:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:24:41 
2ms
select * from yx_user_send_red_packet where status = 2

09-01 23:24:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:24:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:24:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:24:55 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:25:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:25:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:25:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:25:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:25:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:25:20 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:25:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:25:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:25:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:25:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:25:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:25:41 
5ms
select  * from wx_user_recharge_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:19:41'

09-01 23:25:41 
5ms
select * from yx_user_send_red_packet where status = 2

09-01 23:25:41 
4ms
select  * from wx_user_recharge_item where coinsyn != 3 or querysyn = 1

09-01 23:25:45 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:25:50 
3ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:25:50 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:25:55 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:26:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:26:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:26:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:26:10 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:26:15 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:26:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:26:25 
8ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:26:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:26:34 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:26:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:26:40 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:26:41 
4ms
select * from yx_user_send_red_packet where status = 2

09-01 23:26:41 
4ms
select  * from wx_user_withhold_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:20:41'

09-01 23:26:41 
3ms
select  * from wx_user_withhold_item where coinsyn != 3 or querysyn = 1

09-01 23:26:45 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:26:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:26:50 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:26:55 
40ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:27:00 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:27:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:27:05 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:27:10 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:27:12 
5ms
select id,uid,chatmode,bizid,linkid,fidkey,bizrole,linkflag from wx_chat_items outtable where not EXISTS(select * from wx_chat_group_item WHERE outtable.id = chatlinkid) and chatmode = 2

09-01 23:27:15 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:27:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:27:25 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:27:30 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:27:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:27:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:27:40 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:27:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 23:27:41 
3ms
select  * from wx_user_send_red_item where querysyn = 2 and bizcreattime <= '2022-09-01 23:21:41'

09-01 23:27:41 
3ms
select  * from wx_user_send_red_item where bizcreattime <= '2022-08-31 23:26:41' and querysyn != 3 

09-01 23:27:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:27:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:27:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:27:55 
37ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:28:00 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:28:04 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:28:05 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:28:10 
6ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:28:15 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:28:20 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:28:25 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:28:30 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:28:34 
4ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:28:35 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:28:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:28:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 23:28:45 
3ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:28:50 
4ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

09-01 23:28:50 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:28:55 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:29:00 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:29:04 
5ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:29:05 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:29:10 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:29:15 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:29:20 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:29:25 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:29:30 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:29:34 
2ms
select * from wx_group_user where forbiddenflag = 1 and cancelforbiddentime < now()

09-01 23:29:35 
5ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:29:40 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:29:41 
3ms
select * from yx_user_send_red_packet where status = 2

09-01 23:29:45 
4ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:29:50 
2ms
select * from wx_call_item where status = 1 and calltime < date_sub(now(), interval 40 second)

09-01 23:29:50 
2ms
select * from yx_trans_accounts where status = 1 and createtime < date_sub(now(), interval 1 day)

