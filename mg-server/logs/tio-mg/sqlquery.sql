09-01 21:33:23 
3ms
select * from sensitive_words_list where status = 1;

09-01 21:33:23 
6ms
select code,name,pcode from area  where pcode = 'area' and  status = 1

09-01 21:33:23 
7ms
select code,name,pcode from area  where status = 1 and pcode in ( select code from area  where pcode = 'area' and  status = 1)

09-01 21:33:23 
10ms
select code,name,pcode from area  where status = 1 and pcode in ( select code from area  where status = 1 and pcode in ( select code from area  where pcode = 'area' and  status = 1))

09-01 21:33:23 
4ms
select count(*) from avatar

09-01 21:33:23 
2ms
select * from avatar limit 0, 1000

09-01 21:33:23 
4ms
select * from yx_conf

09-01 21:33:23 
6ms
select * from conf_dev

09-01 21:33:23 
2ms
select * from httpcache where status = 1

09-01 21:33:24 
3ms
select * from ip_black_list where status=1

09-01 21:33:49 
2ms
select * from sensitive_words_list where status = 1;

09-01 21:33:49 
4ms
select code,name,pcode from area  where pcode = 'area' and  status = 1

09-01 21:33:49 
5ms
select code,name,pcode from area  where status = 1 and pcode in ( select code from area  where pcode = 'area' and  status = 1)

09-01 21:33:49 
8ms
select code,name,pcode from area  where status = 1 and pcode in ( select code from area  where status = 1 and pcode in ( select code from area  where pcode = 'area' and  status = 1))

09-01 21:33:50 
4ms
select count(*) from avatar

09-01 21:33:50 
2ms
select * from avatar limit 0, 1000

09-01 21:33:50 
4ms
select * from yx_conf

09-01 21:33:50 
2ms
select * from conf_dev

09-01 21:33:50 
2ms
select * from httpcache where status = 1

09-01 21:33:50 
3ms
select * from ip_black_list where status=1

09-01 21:34:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:34:00 
20ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:34:25 
3ms
select * from ip_info where ip='127.0.0.1' and country='' and area='' and province='' and city='内网IP' and operator='内网IP'

09-01 21:34:31 
4ms
select * from user_agent where userAgent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36' limit 1

09-01 21:34:57 
6ms
select * from mg_user where loginname = 'admin'

09-01 21:34:57 
5ms
select * from mg_ip_info where ip='127.0.0.1' and country='' and area='' and province='' and city='内网IP' and operator='内网IP'

09-01 21:34:57 
5ms
select * from mg_user_token where devicetype=1 and mguid=1 limit 1

09-01 21:34:57 
8ms
select * from `mg_user` where `id` = 1

09-01 21:34:57 
3ms
select * from `mg_user` where `id` = 1

09-01 21:34:57 
3ms
select * from `mg_user` where `id` = 1

09-01 21:34:57 
4ms
select * from `mg_user` where `id` = 1

09-01 21:34:57 
6ms
select rid from mg_user_role where uid = 1

09-01 21:34:57 
4ms
select menu_id from mg_role_menu where role_id = 1

09-01 21:34:57 
9ms
select * from mg_menu where id = 1

09-01 21:34:57 
3ms
select * from mg_menu where id = 2

09-01 21:34:57 
3ms
select * from mg_menu where id = 4

09-01 21:34:57 
3ms
select * from mg_menu where id = 5

09-01 21:34:57 
3ms
select * from mg_menu where id = 7

09-01 21:34:57 
2ms
select * from mg_menu where id = 40

09-01 21:34:57 
2ms
select * from mg_menu where id = 3

09-01 21:34:57 
3ms
select * from mg_menu where id = 9

09-01 21:34:57 
3ms
select * from mg_menu where id = 10

09-01 21:34:57 
2ms
select * from mg_menu where id = 41

09-01 21:34:57 
2ms
select * from mg_menu where id = 11

09-01 21:34:57 
1ms
select * from mg_menu where id = 12

09-01 21:34:57 
2ms
select * from mg_menu where id = 13

09-01 21:34:57 
3ms
select * from mg_menu where id = 14

09-01 21:34:57 
3ms
select * from mg_menu where id = 15

09-01 21:34:57 
3ms
select * from mg_menu where id = 16

09-01 21:34:57 
3ms
select * from mg_menu where id = 17

09-01 21:34:57 
3ms
select * from mg_menu where id = 18

09-01 21:34:57 
3ms
select * from mg_menu where id = 19

09-01 21:34:57 
3ms
select * from mg_menu where id = 20

09-01 21:34:57 
2ms
select * from mg_menu where id = 21

09-01 21:34:57 
3ms
select * from mg_menu where id = 22

09-01 21:34:57 
3ms
select * from mg_menu where id = 23

09-01 21:34:57 
3ms
select * from mg_menu where id = 24

09-01 21:34:57 
2ms
select * from mg_menu where id = 25

09-01 21:34:57 
4ms
select * from mg_menu where id = 26

09-01 21:34:57 
4ms
select * from mg_menu where id = 27

09-01 21:34:57 
2ms
select * from mg_menu where id = 38

09-01 21:34:57 
3ms
select * from mg_menu where id = 39

09-01 21:34:57 
2ms
select * from mg_menu where id = 28

09-01 21:34:57 
2ms
select * from mg_menu where id = 29

09-01 21:34:57 
2ms
select * from mg_menu where id = 32

09-01 21:34:57 
3ms
select * from mg_menu where id = 33

09-01 21:34:57 
2ms
select * from mg_menu where id = 34

09-01 21:34:57 
3ms
select * from mg_menu where id = 35

09-01 21:34:57 
3ms
select * from mg_menu where id = 36

09-01 21:34:57 
2ms
select * from mg_menu where id = 37

09-01 21:34:58 
6ms
select * from `mg_user` where `id` = 1

09-01 21:34:58 
7ms
select * from `mg_user` where `id` = 1

09-01 21:34:58 
18ms
select count(1) from tio_site_main.user where 1 = 1 order by createtime desc

09-01 21:34:58 
8ms
select * from `mg_user` where `id` = 1

09-01 21:34:58 
5ms
select * from `mg_user` where `id` = 1

09-01 21:34:58 
5ms
select * from `mg_user` where `id` = 1

09-01 21:34:58 
7ms
select count(1) from tio_site_main.wx_group where status = 1 order by createtime desc

09-01 21:34:58 
6ms
select * from `mg_user` where `id` = 1

09-01 21:34:58 
8ms
select count(1) from tio_site_main.user where 1 = 1 and createtime >= '2022-09-01 00:00:00' and createtime < '2022-09-01 23:59:59' order by createtime desc

09-01 21:34:59 
10ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE 1 = 1 and ll.time >= '2022-09-01 00:00:00' and ll.time < '2022-09-01 23:59:59';

09-01 21:34:59 
38ms
select count(*) from stat_user where stat_type =  1 and stat_period = 3
				 and stat_time >= '20220801' and stat_time <= '20220831'


09-01 21:34:59 
6ms
select count(*) from stat_user where stat_type =  2 and stat_period = 3
				 and stat_time >= '20220801' and stat_time <= '20220831'


09-01 21:35:00 
5ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:35:00 
6ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:35:15 
6ms
select * from `mg_user` where `id` = 1

09-01 21:35:15 
4ms
select * from yx_conf where conftype = 2 order by sort desc

09-01 21:35:26 
5ms
select * from `mg_user` where `id` = 1

09-01 21:35:26 
4ms
select * from yx_conf where conftype = 1 order by sort desc

09-01 21:36:00 
6ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:36:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:37:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:37:00 
1ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:37:33 
4ms
select * from `mg_user` where `id` = 1

09-01 21:37:33 
7ms
select count(*) FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	


09-01 21:37:33 
11ms
	SELECT
		u.id,
	    u.loginname,
		u.nick,
		u.avatar,
        u.email,
        u.phone,
	    u.invitecode,
	    u.viplevel,
		u.createtime,
		u.`status`,
		ub.sign,
		ub.sex,
		ub.validphone,
		ub.validemail,
		ri.ip,
		ri.province,
		ri.city,
		ll.createtime lastlogintime,
        ui.invite_code,
        IFNULL(wallet.amount, "未开户" ) AS wallet,
        ( SELECT count( ci.id ) FROM wx_call_item ci WHERE u.id = ci.fromuid ) AS callCount,
        IFNULL((
            SELECT
                sum( TIMESTAMPDIFF( SECOND, ci.calltime, ci.endtime ) )
            FROM
                wx_call_item ci
            WHERE
                u.id = ci.fromuid
                ),
            0
        ) AS `second` ,
        ( SELECT ( count( id )) FROM wx_friend WHERE uid = u.id ) AS friendCount,
        ( SELECT ( count( id )) FROM wx_group WHERE uid = u.id ) AS joinGroupCount,
        ( SELECT ( count( id )) FROM user_invite WHERE invite_uid = u.id ) AS inviteCount,
        (SELECT (count( id )) FROM wx_group_user WHERE uid = u.id AND ( grouprole = 2 OR grouprole = 3 )) AS createGroupCount
	 FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	ORDER BY u.createtime DESC
 limit 0, 15

09-01 21:38:00 
5ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:38:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:39:00 
7ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:39:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:40:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:40:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:41:00 
6ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:41:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:42:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:42:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:42:16 
4ms
select * from `mg_user` where `id` = 1

09-01 21:42:16 
2ms
select count(*) FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	


09-01 21:42:16 
3ms
	SELECT
		u.id,
	    u.loginname,
		u.nick,
		u.avatar,
        u.email,
        u.phone,
	    u.invitecode,
	    u.viplevel,
		u.createtime,
		u.`status`,
		ub.sign,
		ub.sex,
		ub.validphone,
		ub.validemail,
		ri.ip,
		ri.province,
		ri.city,
		ll.createtime lastlogintime,
        ui.invite_code,
        IFNULL(wallet.amount, "未开户" ) AS wallet,
        ( SELECT count( ci.id ) FROM wx_call_item ci WHERE u.id = ci.fromuid ) AS callCount,
        IFNULL((
            SELECT
                sum( TIMESTAMPDIFF( SECOND, ci.calltime, ci.endtime ) )
            FROM
                wx_call_item ci
            WHERE
                u.id = ci.fromuid
                ),
            0
        ) AS `second` ,
        ( SELECT ( count( id )) FROM wx_friend WHERE uid = u.id ) AS friendCount,
        ( SELECT ( count( id )) FROM wx_group WHERE uid = u.id ) AS joinGroupCount,
        ( SELECT ( count( id )) FROM user_invite WHERE invite_uid = u.id ) AS inviteCount,
        (SELECT (count( id )) FROM wx_group_user WHERE uid = u.id AND ( grouprole = 2 OR grouprole = 3 )) AS createGroupCount
	 FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	ORDER BY u.createtime DESC
 limit 0, 15

09-01 21:42:18 
6ms
select * from yx_conf where name = 'validateType'

09-01 21:42:39 
3ms
select * from `mg_user` where `id` = 1

09-01 21:42:39 
3ms
select * from yx_conf where name = 'validateType'

09-01 21:42:45 
4ms
select * from `mg_user` where `id` = 1

09-01 21:42:45 
4ms
select * from yx_conf where name = 'validateType'

09-01 21:42:45 
4ms
select * from `user` where `id` = 23026121

09-01 21:42:45 
5ms
select * from role r where EXISTS (select rid from user_role rel where uid = 23026121 and r.id = rel.rid and rel.`status` = 1)

09-01 21:42:45 
2ms
select * from ip_info where id=4857

09-01 21:42:45 
4ms
select * from user_third where uid=23026121

09-01 21:42:45 
3ms
select * from user_base where uid = 23026121

09-01 21:42:45 
4ms
select * from `mg_user` where `id` = 1

09-01 21:42:45 
6ms
select count(*) FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	


09-01 21:42:45 
4ms
	SELECT
		u.id,
	    u.loginname,
		u.nick,
		u.avatar,
        u.email,
        u.phone,
	    u.invitecode,
	    u.viplevel,
		u.createtime,
		u.`status`,
		ub.sign,
		ub.sex,
		ub.validphone,
		ub.validemail,
		ri.ip,
		ri.province,
		ri.city,
		ll.createtime lastlogintime,
        ui.invite_code,
        IFNULL(wallet.amount, "未开户" ) AS wallet,
        ( SELECT count( ci.id ) FROM wx_call_item ci WHERE u.id = ci.fromuid ) AS callCount,
        IFNULL((
            SELECT
                sum( TIMESTAMPDIFF( SECOND, ci.calltime, ci.endtime ) )
            FROM
                wx_call_item ci
            WHERE
                u.id = ci.fromuid
                ),
            0
        ) AS `second` ,
        ( SELECT ( count( id )) FROM wx_friend WHERE uid = u.id ) AS friendCount,
        ( SELECT ( count( id )) FROM wx_group WHERE uid = u.id ) AS joinGroupCount,
        ( SELECT ( count( id )) FROM user_invite WHERE invite_uid = u.id ) AS inviteCount,
        (SELECT (count( id )) FROM wx_group_user WHERE uid = u.id AND ( grouprole = 2 OR grouprole = 3 )) AS createGroupCount
	 FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	ORDER BY u.createtime DESC
 limit 0, 15

09-01 21:43:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:43:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:43:00 
4ms
select * from `mg_user` where `id` = 1

09-01 21:43:00 
42ms
	SELECT
		u.id,
			u.phone loginname,
		u.nick,
		u.avatar,
			u.email,
			u.phone,
        u.invitecode,
		u.createtime,
		u.`status`,
		ub.sign,
		ub.sex,
		ub.validphone,
		ub.validemail,
		ri.ip,
		ri.province,
		ri.city,
		ll.createtime lastlogintime,
		friend.count fcount,
		grouptable.count gcount,
		allgroup.count agcount,
		fromcall.count fcallcount,
		fromcall.callduration fduration,
		tocall.callduration toduration,
		tocall.count tcallcount
	FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN (
		SELECT
			uid,
			count(1) count
		FROM
			wx_friend
		WHERE
			 uid = 23026121 and `status` = 1
	) AS friend ON friend.uid = u.id
	LEFT JOIN (
		SELECT
			uid,
			count(1) count
		FROM
			wx_group
		WHERE
			uid = 23026121 and `status` = 1
	) AS grouptable ON grouptable.uid = u.id
	LEFT JOIN (
		SELECT
			uid,
			count(1) count
		FROM
			wx_group_user
		WHERE
			uid = 23026121 and `status` = 1
	) AS allgroup ON allgroup.uid = u.id
	LEFT JOIN (
		SELECT
			fromuid uid,
			count(1) count,
			callduration
		FROM
			wx_call_item
		WHERE
			fromuid = 23026121 and callduration > 0
	) AS fromcall ON fromcall.uid = u.id
	LEFT JOIN (
		SELECT
			touid uid,
			count(1) count,
			callduration
		FROM
			wx_call_item
		WHERE
			touid = 23026121 and  callduration > 0
	) AS tocall ON tocall.uid = u.id
	where
		u.id = 23026121


09-01 21:43:00 
4ms
select * from `mg_user` where `id` = 1

09-01 21:44:00 
25ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:44:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:44:37 
3ms
select * from `user` where `id` = 48431849

09-01 21:44:37 
3ms
select * from role r where EXISTS (select rid from user_role rel where uid = 48431849 and r.id = rel.rid and rel.`status` = 1)

09-01 21:44:37 
2ms
select * from ip_info where id=4861

09-01 21:44:37 
2ms
select * from user_third where uid=48431849

09-01 21:44:37 
3ms
select * from user_base where uid = 48431849

09-01 21:45:00 
5ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:45:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:46:00 
7ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:46:00 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:46:54 
5ms
select * from `mg_user` where `id` = 1

09-01 21:46:54 
4ms
select * from yx_conf where conftype = 3 order by sort desc

09-01 21:46:56 
2ms
select * from `mg_user` where `id` = 1

09-01 21:46:56 
2ms
select * from yx_conf where conftype = 4 order by sort desc

09-01 21:47:00 
7ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:47:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:47:03 
3ms
select * from `mg_user` where `id` = 1

09-01 21:47:03 
5ms
select count(*) FROM
		wx_group g
	INNER JOIN (
		SELECT
			groupid,
			max(id) maxid,
			count(1)
		FROM
			wx_group_msg
		where 1 = 1
		GROUP BY
			groupid
	) AS gstat ON gstat.groupid = g.id
	INNER JOIN wx_group_meta m ON m.groupid = g.id
	INNER JOIN `user` guser ON guser.id = g.uid
	where
			1 = 1
	


09-01 21:47:19 
3ms
select * from `mg_user` where `id` = 1

09-01 21:47:19 
3ms
select count(*) FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	


09-01 21:47:19 
30ms
	SELECT
		u.id,
	    u.loginname,
		u.nick,
		u.avatar,
        u.email,
        u.phone,
	    u.invitecode,
	    u.viplevel,
		u.createtime,
		u.`status`,
		ub.sign,
		ub.sex,
		ub.validphone,
		ub.validemail,
		ri.ip,
		ri.province,
		ri.city,
		ll.createtime lastlogintime,
        ui.invite_code,
        IFNULL(wallet.amount, "未开户" ) AS wallet,
        ( SELECT count( ci.id ) FROM wx_call_item ci WHERE u.id = ci.fromuid ) AS callCount,
        IFNULL((
            SELECT
                sum( TIMESTAMPDIFF( SECOND, ci.calltime, ci.endtime ) )
            FROM
                wx_call_item ci
            WHERE
                u.id = ci.fromuid
                ),
            0
        ) AS `second` ,
        ( SELECT ( count( id )) FROM wx_friend WHERE uid = u.id ) AS friendCount,
        ( SELECT ( count( id )) FROM wx_group WHERE uid = u.id ) AS joinGroupCount,
        ( SELECT ( count( id )) FROM user_invite WHERE invite_uid = u.id ) AS inviteCount,
        (SELECT (count( id )) FROM wx_group_user WHERE uid = u.id AND ( grouprole = 2 OR grouprole = 3 )) AS createGroupCount
	 FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	ORDER BY u.createtime DESC
 limit 0, 15

09-01 21:47:26 
32ms
select * from yx_conf where name = 'inviteEnable'

09-01 21:47:26 
3ms
select * from `mg_user` where `id` = 1

09-01 21:47:26 
4ms
select count(*) FROM
    user_invite_attr uia
    LEFT JOIN `user` u ON u.id = uia.uid
    LEFT JOIN user_base ub ON ub.uid = uia.uid
WHERE
    1 = 1
    AND uia.`status` = 1



09-01 21:47:39 
3ms
select * from `mg_user` where `id` = 1

09-01 21:47:39 
6ms
select count(*) FROM
    wx_friend_meta m
        INNER JOIN (
        SELECT
            twouid,
            max( id ) maxid
        FROM
            wx_friend_msg
        WHERE
                1 = 1
        GROUP BY
            twouid
    ) AS fdstat ON fdstat.twouid = m.fidkey
        INNER JOIN `user` u ON u.id = m.uid
        INNER JOIN `user` tu ON tu.id = m.touid
WHERE
        1 = 1



09-01 21:47:39 
4ms
SELECT
    m.*,
    u.nick,
    u.avatar,
    tu.nick tonick,
    tu.avatar toavatar
 FROM
    wx_friend_meta m
        INNER JOIN (
        SELECT
            twouid,
            max( id ) maxid
        FROM
            wx_friend_msg
        WHERE
                1 = 1
        GROUP BY
            twouid
    ) AS fdstat ON fdstat.twouid = m.fidkey
        INNER JOIN `user` u ON u.id = m.uid
        INNER JOIN `user` tu ON tu.id = m.touid
WHERE
        1 = 1
ORDER BY
    fdstat.maxid DESC
 limit 0, 30

09-01 21:47:41 
3ms
select * from `mg_user` where `id` = 1

09-01 21:47:41 
9ms
select count(*) FROM
		group_stat
	WHERE
			type = 1
	


09-01 21:48:00 
7ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:48:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:48:11 
4ms
select * from `mg_user` where `id` = 1

09-01 21:48:11 
3ms
select count(*) FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	


09-01 21:48:11 
5ms
	SELECT
		u.id,
	    u.loginname,
		u.nick,
		u.avatar,
        u.email,
        u.phone,
	    u.invitecode,
	    u.viplevel,
		u.createtime,
		u.`status`,
		ub.sign,
		ub.sex,
		ub.validphone,
		ub.validemail,
		ri.ip,
		ri.province,
		ri.city,
		ll.createtime lastlogintime,
        ui.invite_code,
        IFNULL(wallet.amount, "未开户" ) AS wallet,
        ( SELECT count( ci.id ) FROM wx_call_item ci WHERE u.id = ci.fromuid ) AS callCount,
        IFNULL((
            SELECT
                sum( TIMESTAMPDIFF( SECOND, ci.calltime, ci.endtime ) )
            FROM
                wx_call_item ci
            WHERE
                u.id = ci.fromuid
                ),
            0
        ) AS `second` ,
        ( SELECT ( count( id )) FROM wx_friend WHERE uid = u.id ) AS friendCount,
        ( SELECT ( count( id )) FROM wx_group WHERE uid = u.id ) AS joinGroupCount,
        ( SELECT ( count( id )) FROM user_invite WHERE invite_uid = u.id ) AS inviteCount,
        (SELECT (count( id )) FROM wx_group_user WHERE uid = u.id AND ( grouprole = 2 OR grouprole = 3 )) AS createGroupCount
	 FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	ORDER BY u.createtime DESC
 limit 0, 15

09-01 21:48:14 
7ms
select * from yx_conf where name = 'validateType'

09-01 21:49:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:49:00 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:50:00 
6ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:50:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:50:26 
5ms
select * from `mg_user` where `id` = 1

09-01 21:50:26 
5ms
select count(*) FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	


09-01 21:50:26 
5ms
	SELECT
		u.id,
	    u.loginname,
		u.nick,
		u.avatar,
        u.email,
        u.phone,
	    u.invitecode,
	    u.viplevel,
		u.createtime,
		u.`status`,
		ub.sign,
		ub.sex,
		ub.validphone,
		ub.validemail,
		ri.ip,
		ri.province,
		ri.city,
		ll.createtime lastlogintime,
        ui.invite_code,
        IFNULL(wallet.amount, "未开户" ) AS wallet,
        ( SELECT count( ci.id ) FROM wx_call_item ci WHERE u.id = ci.fromuid ) AS callCount,
        IFNULL((
            SELECT
                sum( TIMESTAMPDIFF( SECOND, ci.calltime, ci.endtime ) )
            FROM
                wx_call_item ci
            WHERE
                u.id = ci.fromuid
                ),
            0
        ) AS `second` ,
        ( SELECT ( count( id )) FROM wx_friend WHERE uid = u.id ) AS friendCount,
        ( SELECT ( count( id )) FROM wx_group WHERE uid = u.id ) AS joinGroupCount,
        ( SELECT ( count( id )) FROM user_invite WHERE invite_uid = u.id ) AS inviteCount,
        (SELECT (count( id )) FROM wx_group_user WHERE uid = u.id AND ( grouprole = 2 OR grouprole = 3 )) AS createGroupCount
	 FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	ORDER BY u.createtime DESC
 limit 0, 15

09-01 21:50:32 
5ms
select * from yx_conf where name = 'validateType'

09-01 21:50:41 
3ms
select * from `mg_user` where `id` = 1

09-01 21:50:41 
3ms
select * from `mg_user` where `id` = 1

09-01 21:50:41 
3ms
select * from `mg_user` where `id` = 1

09-01 21:50:41 
2ms
select * from `mg_user` where `id` = 1

09-01 21:50:41 
3ms
select rid from mg_user_role where uid = 1

09-01 21:50:41 
3ms
select menu_id from mg_role_menu where role_id = 1

09-01 21:50:41 
3ms
select * from mg_menu where id = 1

09-01 21:50:41 
2ms
select * from mg_menu where id = 2

09-01 21:50:41 
3ms
select * from mg_menu where id = 4

09-01 21:50:41 
2ms
select * from mg_menu where id = 5

09-01 21:50:41 
2ms
select * from mg_menu where id = 7

09-01 21:50:41 
3ms
select * from mg_menu where id = 40

09-01 21:50:41 
3ms
select * from mg_menu where id = 3

09-01 21:50:41 
3ms
select * from mg_menu where id = 9

09-01 21:50:41 
3ms
select * from mg_menu where id = 10

09-01 21:50:41 
3ms
select * from mg_menu where id = 41

09-01 21:50:41 
3ms
select * from mg_menu where id = 11

09-01 21:50:41 
3ms
select * from mg_menu where id = 12

09-01 21:50:41 
6ms
select * from mg_menu where id = 13

09-01 21:50:41 
2ms
select * from mg_menu where id = 14

09-01 21:50:41 
2ms
select * from mg_menu where id = 15

09-01 21:50:41 
2ms
select * from mg_menu where id = 16

09-01 21:50:41 
3ms
select * from mg_menu where id = 17

09-01 21:50:41 
3ms
select * from mg_menu where id = 18

09-01 21:50:41 
2ms
select * from mg_menu where id = 19

09-01 21:50:41 
2ms
select * from mg_menu where id = 20

09-01 21:50:41 
2ms
select * from mg_menu where id = 21

09-01 21:50:41 
4ms
select * from mg_menu where id = 22

09-01 21:50:41 
3ms
select * from mg_menu where id = 23

09-01 21:50:41 
3ms
select * from mg_menu where id = 24

09-01 21:50:41 
3ms
select * from mg_menu where id = 25

09-01 21:50:41 
3ms
select * from mg_menu where id = 26

09-01 21:50:41 
5ms
select * from mg_menu where id = 27

09-01 21:50:41 
4ms
select * from mg_menu where id = 38

09-01 21:50:41 
3ms
select * from mg_menu where id = 39

09-01 21:50:41 
2ms
select * from mg_menu where id = 28

09-01 21:50:41 
4ms
select * from mg_menu where id = 29

09-01 21:50:41 
2ms
select * from mg_menu where id = 32

09-01 21:50:41 
2ms
select * from mg_menu where id = 33

09-01 21:50:41 
2ms
select * from mg_menu where id = 34

09-01 21:50:41 
2ms
select * from mg_menu where id = 35

09-01 21:50:41 
3ms
select * from mg_menu where id = 36

09-01 21:50:41 
3ms
select * from mg_menu where id = 37

09-01 21:50:41 
4ms
select * from `mg_user` where `id` = 1

09-01 21:50:41 
3ms
select count(*) FROM
		group_stat
	WHERE
			type = 1
	


09-01 21:51:00 
6ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:51:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:52:00 
6ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:52:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:52:28 
5ms
select * from `mg_user` where `id` = 1

09-01 21:52:28 
5ms
select count(*) FROM
		login_log ll
	INNER JOIN `user` u ON u.id = ll.uid
	LEFT JOIN ip_info i ON i.id = ll.ipid
	where
		1 = 1
	


09-01 21:52:28 
5ms
	SELECT
		ll.id,
		u.nick,
			u.loginname, 
		u.avatar,
		ll.uid,
		ll.ip,
		i.province,
		i.city,
		ll.devicetype,
		ll.deviceinfo,
		ll.time
	 FROM
		login_log ll
	INNER JOIN `user` u ON u.id = ll.uid
	LEFT JOIN ip_info i ON i.id = ll.ipid
	where
		1 = 1
	order by ll.id desc
 limit 0, 15

09-01 21:52:31 
3ms
select * from `mg_user` where `id` = 1

09-01 21:52:31 
4ms
select count(*) FROM
		login_log ll
	INNER JOIN `user` u ON u.id = ll.uid
	LEFT JOIN ip_info i ON i.id = ll.ipid
	where
		1 = 1
	


09-01 21:52:31 
2ms
	SELECT
		ll.id,
		u.nick,
			u.loginname, 
		u.avatar,
		ll.uid,
		ll.ip,
		i.province,
		i.city,
		ll.devicetype,
		ll.deviceinfo,
		ll.time
	 FROM
		login_log ll
	INNER JOIN `user` u ON u.id = ll.uid
	LEFT JOIN ip_info i ON i.id = ll.ipid
	where
		1 = 1
	order by ll.id desc
 limit 0, 15

09-01 21:53:00 
5ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:53:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:54:00 
6ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:54:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:55:00 
2ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:55:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:56:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:56:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:57:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:57:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:58:00 
2ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:58:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 21:59:00 
2ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 21:59:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:00:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:00:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:01:00 
1ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:01:00 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:01:15 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 HOUR) and createtime < now()

09-01 22:01:15 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 HOUR) AND ll.time < now();

09-01 22:02:00 
31ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:02:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:03:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:03:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:04:42 
4ms
select * from sensitive_words_list where status = 1;

09-01 22:04:42 
9ms
select code,name,pcode from area  where pcode = 'area' and  status = 1

09-01 22:04:42 
8ms
select code,name,pcode from area  where status = 1 and pcode in ( select code from area  where pcode = 'area' and  status = 1)

09-01 22:04:42 
9ms
select code,name,pcode from area  where status = 1 and pcode in ( select code from area  where status = 1 and pcode in ( select code from area  where pcode = 'area' and  status = 1))

09-01 22:04:42 
8ms
select count(*) from avatar

09-01 22:04:42 
2ms
select * from avatar limit 0, 1000

09-01 22:04:43 
4ms
select * from yx_conf

09-01 22:04:43 
2ms
select * from conf_dev

09-01 22:04:43 
2ms
select * from httpcache where status = 1

09-01 22:04:43 
2ms
select * from ip_black_list where status=1

09-01 22:05:00 
2ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:05:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:06:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:06:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:07:00 
5ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:07:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:08:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:08:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:09:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:09:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:09:32 
4ms
select * from user_agent where userAgent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36' limit 1

09-01 22:10:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:10:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:11:00 
8ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:11:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:12:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:12:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:13:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:13:00 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:14:00 
5ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:14:00 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:14:31 
3ms
select * from `user` where `id` = 16779238

09-01 22:14:31 
3ms
select * from role r where EXISTS (select rid from user_role rel where uid = 16779238 and r.id = rel.rid and rel.`status` = 1)

09-01 22:14:31 
3ms
select * from user_third where uid=16779238

09-01 22:14:31 
3ms
select * from user_base where uid = 16779238

09-01 22:15:00 
2ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:15:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:16:00 
6ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:16:00 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:17:00 
5ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:17:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:17:45 
5ms
select * from `mg_user` where `id` = 1

09-01 22:17:45 
3ms
select * from `mg_user` where `id` = 1

09-01 22:17:45 
4ms
select * from `mg_user` where `id` = 1

09-01 22:17:45 
3ms
select * from `mg_user` where `id` = 1

09-01 22:17:45 
4ms
select rid from mg_user_role where uid = 1

09-01 22:17:45 
6ms
select menu_id from mg_role_menu where role_id = 1

09-01 22:17:45 
3ms
select * from mg_menu where id = 1

09-01 22:17:45 
2ms
select * from mg_menu where id = 2

09-01 22:17:45 
2ms
select * from mg_menu where id = 4

09-01 22:17:45 
4ms
select * from mg_menu where id = 5

09-01 22:17:45 
2ms
select * from mg_menu where id = 7

09-01 22:17:45 
2ms
select * from mg_menu where id = 40

09-01 22:17:45 
2ms
select * from mg_menu where id = 3

09-01 22:17:45 
1ms
select * from mg_menu where id = 9

09-01 22:17:45 
2ms
select * from mg_menu where id = 10

09-01 22:17:45 
2ms
select * from mg_menu where id = 41

09-01 22:17:45 
2ms
select * from mg_menu where id = 11

09-01 22:17:45 
2ms
select * from mg_menu where id = 12

09-01 22:17:45 
2ms
select * from mg_menu where id = 13

09-01 22:17:45 
2ms
select * from mg_menu where id = 14

09-01 22:17:45 
3ms
select * from mg_menu where id = 15

09-01 22:17:45 
2ms
select * from mg_menu where id = 16

09-01 22:17:45 
3ms
select * from mg_menu where id = 17

09-01 22:17:45 
2ms
select * from mg_menu where id = 18

09-01 22:17:45 
2ms
select * from mg_menu where id = 19

09-01 22:17:45 
2ms
select * from mg_menu where id = 20

09-01 22:17:45 
2ms
select * from mg_menu where id = 21

09-01 22:17:45 
3ms
select * from mg_menu where id = 22

09-01 22:17:45 
3ms
select * from mg_menu where id = 23

09-01 22:17:45 
3ms
select * from mg_menu where id = 24

09-01 22:17:45 
2ms
select * from mg_menu where id = 25

09-01 22:17:45 
3ms
select * from mg_menu where id = 26

09-01 22:17:45 
3ms
select * from mg_menu where id = 27

09-01 22:17:45 
3ms
select * from mg_menu where id = 38

09-01 22:17:45 
2ms
select * from mg_menu where id = 39

09-01 22:17:45 
2ms
select * from mg_menu where id = 28

09-01 22:17:46 
3ms
select * from mg_menu where id = 29

09-01 22:17:46 
2ms
select * from mg_menu where id = 32

09-01 22:17:46 
2ms
select * from mg_menu where id = 33

09-01 22:17:46 
2ms
select * from mg_menu where id = 34

09-01 22:17:46 
2ms
select * from mg_menu where id = 35

09-01 22:17:46 
2ms
select * from mg_menu where id = 36

09-01 22:17:46 
2ms
select * from mg_menu where id = 37

09-01 22:17:46 
7ms
select * from `mg_user` where `id` = 1

09-01 22:17:46 
6ms
select * from `mg_user` where `id` = 1

09-01 22:17:46 
6ms
select * from `mg_user` where `id` = 1

09-01 22:17:46 
14ms
select count(1) from tio_site_main.user where 1 = 1 order by createtime desc

09-01 22:17:46 
6ms
select * from `mg_user` where `id` = 1

09-01 22:17:46 
9ms
select count(1) from tio_site_main.wx_group where status = 1 order by createtime desc

09-01 22:17:46 
8ms
select * from `mg_user` where `id` = 1

09-01 22:17:46 
8ms
select * from `mg_user` where `id` = 1

09-01 22:17:46 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE 1 = 1 and ll.time >= '2022-09-01 00:00:00' and ll.time < '2022-09-01 23:59:59';

09-01 22:17:46 
4ms
select count(1) from tio_site_main.user where 1 = 1 and createtime >= '2022-09-01 00:00:00' and createtime < '2022-09-01 23:59:59' order by createtime desc

09-01 22:17:46 
11ms
select count(*) from stat_user where stat_type =  1 and stat_period = 3
				 and stat_time >= '20220801' and stat_time <= '20220831'


09-01 22:17:46 
11ms
select count(*) from stat_user where stat_type =  2 and stat_period = 3
				 and stat_time >= '20220801' and stat_time <= '20220831'


09-01 22:17:52 
21ms
select * from `mg_user` where `id` = 1

09-01 22:17:52 
3ms
select count(*) FROM
		login_log ll
	INNER JOIN `user` u ON u.id = ll.uid
	LEFT JOIN ip_info i ON i.id = ll.ipid
	where
		1 = 1
	


09-01 22:17:52 
4ms
	SELECT
		ll.id,
		u.nick,
			u.loginname, 
		u.avatar,
		ll.uid,
		ll.ip,
		i.province,
		i.city,
		ll.devicetype,
		ll.deviceinfo,
		ll.time
	 FROM
		login_log ll
	INNER JOIN `user` u ON u.id = ll.uid
	LEFT JOIN ip_info i ON i.id = ll.ipid
	where
		1 = 1
	order by ll.id desc
 limit 0, 15

09-01 22:17:55 
4ms
select * from `mg_user` where `id` = 1

09-01 22:17:55 
5ms
select count(*) FROM
		group_stat
	WHERE
			type = 1
	


09-01 22:17:57 
3ms
select * from `mg_user` where `id` = 1

09-01 22:17:57 
3ms
select * from `mg_user` where `id` = 1

09-01 22:17:57 
4ms
select count(*) FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	


09-01 22:17:57 
4ms
	SELECT
		urs.*
	 FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	order by 
		 	urs.statbizstr desc
 limit 0, 15

09-01 22:17:57 
43ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

09-01 22:17:57 
4ms
select * from `mg_user` where `id` = 1

09-01 22:18:00 
7ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:18:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:18:00 
15ms
select * from `mg_user` where `id` = 1

09-01 22:18:00 
20ms
select * from `mg_user` where `id` = 1

09-01 22:18:00 
3ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

09-01 22:18:00 
2ms
select count(*) FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	


09-01 22:18:00 
5ms
select * from `mg_user` where `id` = 1

09-01 22:18:00 
6ms
	SELECT
		urs.*
	 FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	order by 
		 	urs.statbizstr desc
 limit 0, 15

09-01 22:18:00 
4ms
select * from `mg_user` where `id` = 1

09-01 22:18:00 
40ms
select count(*) FROM
    wx_friend_meta m
        INNER JOIN (
        SELECT
            twouid,
            max( id ) maxid
        FROM
            wx_friend_msg
        WHERE
                1 = 1
        GROUP BY
            twouid
    ) AS fdstat ON fdstat.twouid = m.fidkey
        INNER JOIN `user` u ON u.id = m.uid
        INNER JOIN `user` tu ON tu.id = m.touid
WHERE
        1 = 1



09-01 22:18:00 
5ms
SELECT
    m.*,
    u.nick,
    u.avatar,
    tu.nick tonick,
    tu.avatar toavatar
 FROM
    wx_friend_meta m
        INNER JOIN (
        SELECT
            twouid,
            max( id ) maxid
        FROM
            wx_friend_msg
        WHERE
                1 = 1
        GROUP BY
            twouid
    ) AS fdstat ON fdstat.twouid = m.fidkey
        INNER JOIN `user` u ON u.id = m.uid
        INNER JOIN `user` tu ON tu.id = m.touid
WHERE
        1 = 1
ORDER BY
    fdstat.maxid DESC
 limit 0, 30

09-01 22:18:02 
4ms
select * from `mg_user` where `id` = 1

09-01 22:18:02 
5ms
select count(*) FROM
		wx_group g
	INNER JOIN (
		SELECT
			groupid,
			max(id) maxid,
			count(1)
		FROM
			wx_group_msg
		where 1 = 1
		GROUP BY
			groupid
	) AS gstat ON gstat.groupid = g.id
	INNER JOIN wx_group_meta m ON m.groupid = g.id
	INNER JOIN `user` guser ON guser.id = g.uid
	where
			1 = 1
	


09-01 22:18:11 
4ms
select * from `mg_user` where `id` = 1

09-01 22:18:11 
6ms
select count(*) FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	


09-01 22:18:11 
11ms
	SELECT
		u.id,
	    u.loginname,
		u.nick,
		u.avatar,
        u.email,
        u.phone,
	    u.invitecode,
	    u.viplevel,
		u.createtime,
		u.`status`,
		ub.sign,
		ub.sex,
		ub.validphone,
		ub.validemail,
		ri.ip,
		ri.province,
		ri.city,
		ll.createtime lastlogintime,
        ui.invite_code,
        IFNULL(wallet.amount, "未开户" ) AS wallet,
        ( SELECT count( ci.id ) FROM wx_call_item ci WHERE u.id = ci.fromuid ) AS callCount,
        IFNULL((
            SELECT
                sum( TIMESTAMPDIFF( SECOND, ci.calltime, ci.endtime ) )
            FROM
                wx_call_item ci
            WHERE
                u.id = ci.fromuid
                ),
            0
        ) AS `second` ,
        ( SELECT ( count( id )) FROM wx_friend WHERE uid = u.id ) AS friendCount,
        ( SELECT ( count( id )) FROM wx_group WHERE uid = u.id ) AS joinGroupCount,
        ( SELECT ( count( id )) FROM user_invite WHERE invite_uid = u.id ) AS inviteCount,
        (SELECT (count( id )) FROM wx_group_user WHERE uid = u.id AND ( grouprole = 2 OR grouprole = 3 )) AS createGroupCount
	 FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	ORDER BY u.createtime DESC
 limit 0, 15

09-01 22:18:17 
5ms
select * from yx_conf where name = 'validateType'

09-01 22:18:23 
3ms
select * from `mg_user` where `id` = 1

09-01 22:18:23 
3ms
select * from `mg_user` where `id` = 1

09-01 22:18:23 
4ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

09-01 22:18:23 
6ms
select count(*) FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	


09-01 22:18:23 
3ms
select * from `mg_user` where `id` = 1

09-01 22:18:23 
3ms
	SELECT
		urs.*
	 FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	order by 
		 	urs.statbizstr desc
 limit 0, 15

09-01 22:18:24 
3ms
select * from `mg_user` where `id` = 1

09-01 22:18:24 
5ms
select count(*) FROM
    user_invite_attr uia
    LEFT JOIN `user` u ON u.id = uia.uid
    LEFT JOIN user_base ub ON ub.uid = uia.uid
WHERE
    1 = 1
    AND uia.`status` = 1



09-01 22:18:24 
5ms
select * from yx_conf where name = 'inviteEnable'

09-01 22:18:27 
4ms
select * from `mg_user` where `id` = 1

09-01 22:18:27 
5ms
select count(*) FROM tio_site_main.`user`  us
    JOIN tio_site_conf.ip_white_list white on white.uid=us.id
    WHERE 1=1


09-01 22:18:29 
3ms
select * from `mg_user` where `id` = 1

09-01 22:18:29 
3ms
select * from yx_conf where conftype = 2 order by sort desc

09-01 22:18:30 
4ms
select * from `mg_user` where `id` = 1

09-01 22:18:30 
5ms
select * from yx_conf where conftype = 1 order by sort desc

09-01 22:19:00 
12ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:19:00 
6ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:19:04 
5ms
select * from `mg_user` where `id` = 1

09-01 22:19:04 
4ms
select * from yx_conf where conftype = 4 order by sort desc

09-01 22:19:04 
4ms
select * from `mg_user` where `id` = 1

09-01 22:19:04 
4ms
select * from yx_conf where conftype = 3 order by sort desc

09-01 22:20:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:20:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:21:00 
38ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:21:00 
30ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:22:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:22:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:23:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:23:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:24:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:24:00 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:25:00 
2ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:25:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:26:00 
2ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:26:00 
1ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:27:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:27:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:28:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:28:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:29:00 
2ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:29:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:30:00 
9ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:30:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:31:00 
2ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:31:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:32:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:32:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:33:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:33:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:34:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:34:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:35:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:35:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:36:00 
34ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:36:00 
1ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:37:00 
29ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:37:00 
1ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:38:00 
5ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:38:00 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:39:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:39:00 
1ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:40:00 
12ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:40:00 
5ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:40:54 
5ms
select * from `mg_user` where `id` = 1

09-01 22:40:54 
9ms
SELECT
    IFNULL(sum(recharge.amount),0) as sumRecharge
FROM
    yx_user_recharge recharge
WHERE
    recharge.createtime BETWEEN '2022-09-01' AND '2022-09-01'


09-01 22:40:54 
5ms
SELECT
    IFNULL(sum(withdraw.amountreal),0) as sumWithdraw,
    IFNULL(sum(withdraw.amountcommission),0) as sumCharge
FROM
    yx_user_withdraw withdraw
WHERE
    withdraw.createtime BETWEEN '2022-09-01' AND '2022-09-01'


09-01 22:40:54 
5ms
   SELECT
        IFNULL(sum(red.remainmoney),0) AS remainmoney
    FROM
        yx_user_send_red_packet red
    WHERE
        red.`status`= 2
        AND
        red.createtime BETWEEN '2022-09-01' AND '2022-09-01';


09-01 22:40:54 
4ms
    SELECT
        IFNULL(sum(trans.amount), 0) AS sumAmount
    FROM
        yx_trans_accounts trans
    WHERE
        trans.`status` = 1
    AND
    trans.createtime BETWEEN '2022-09-01' AND '2022-09-01';


09-01 22:40:58 
4ms
select * from `mg_user` where `id` = 1

09-01 22:40:58 
6ms
select count(*) from website as w
where
    1 = 1



09-01 22:40:58 
2ms
select *
 from website as w
where
    1 = 1
order by w.id
 limit 0, 15

09-01 22:41:00 
30ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:41:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:41:02 
3ms
select * from `mg_user` where `id` = 1

09-01 22:41:02 
4ms
select count(*) FROM
		(
			SELECT
				id,
				uid,
				touid,
				text c,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
                sendbysys = 2
                AND twouid = '98708001_98708001'
			
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	


09-01 22:41:02 
12ms
	SELECT
		msg.*,
	    u.nick,
		u.avatar
	 FROM
		(
			SELECT
				id,
				uid,
				touid,
				text c,
				time t,
				sendbysys,
				msgtype,
				contenttype ct
			FROM
				wx_friend_msg
			WHERE
                sendbysys = 2
                AND twouid = '98708001_98708001'
			ORDER BY
				id DESC
		) AS msg
	INNER JOIN `user` u ON msg.uid = u.id
	ORDER BY
		msg.id DESC
 limit 0, 15

09-01 22:41:10 
3ms
select * from `mg_user` where `id` = 1

09-01 22:41:10 
5ms
select count(*) from user_time_login_stat 
	where
		uid = -1
	


09-01 22:41:10 
4ms
	select *  from user_time_login_stat 
	where
		uid = -1
	order by dayperiod desc
 limit 0, 15

09-01 22:41:11 
5ms
select * from `mg_user` where `id` = 1

09-01 22:41:11 
3ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

09-01 22:41:11 
2ms
select * from `mg_user` where `id` = 1

09-01 22:41:11 
5ms
select * from `mg_user` where `id` = 1

09-01 22:41:11 
6ms
select count(*) FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	


09-01 22:41:11 
3ms
	SELECT
		urs.*
	 FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	order by 
		 	urs.statbizstr desc
 limit 0, 15

09-01 22:41:13 
5ms
select * from `mg_user` where `id` = 1

09-01 22:41:13 
6ms
select * from `mg_user` where `id` = 1

09-01 22:41:13 
4ms
select count(*) FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	


09-01 22:41:13 
4ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

09-01 22:41:13 
3ms
	SELECT
		urs.*
	 FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	order by 
		 	urs.statbizstr desc
 limit 0, 15

09-01 22:41:13 
4ms
select * from `mg_user` where `id` = 1

09-01 22:41:14 
3ms
select * from `mg_user` where `id` = 1

09-01 22:41:14 
4ms
select count(*) FROM
		login_log ll
	INNER JOIN `user` u ON u.id = ll.uid
	LEFT JOIN ip_info i ON i.id = ll.ipid
	where
		1 = 1
	


09-01 22:41:14 
3ms
	SELECT
		ll.id,
		u.nick,
			u.loginname, 
		u.avatar,
		ll.uid,
		ll.ip,
		i.province,
		i.city,
		ll.devicetype,
		ll.deviceinfo,
		ll.time
	 FROM
		login_log ll
	INNER JOIN `user` u ON u.id = ll.uid
	LEFT JOIN ip_info i ON i.id = ll.ipid
	where
		1 = 1
	order by ll.id desc
 limit 0, 15

09-01 22:41:19 
3ms
select * from `mg_user` where `id` = 1

09-01 22:41:19 
4ms
select * from `mg_user` where `id` = 1

09-01 22:41:19 
3ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

09-01 22:41:19 
3ms
select * from `mg_user` where `id` = 1

09-01 22:41:19 
9ms
select count(*) FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	


09-01 22:41:19 
4ms
	SELECT
		urs.*
	 FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	order by 
		 	urs.statbizstr desc
 limit 0, 15

09-01 22:41:49 
4ms
select * from `mg_user` where `id` = 1

09-01 22:41:49 
5ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

09-01 22:41:49 
5ms
select * from `mg_user` where `id` = 1

09-01 22:41:49 
4ms
select * from `mg_user` where `id` = 1

09-01 22:41:49 
6ms
select count(*) FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	


09-01 22:41:49 
7ms
	SELECT
		urs.*
	 FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	order by 
		 	urs.statbizstr desc
 limit 0, 15

09-01 22:41:50 
19ms
select * from `mg_user` where `id` = 1

09-01 22:41:50 
7ms
select count(*) FROM
    user_invite_attr uia
    LEFT JOIN `user` u ON u.id = uia.uid
    LEFT JOIN user_base ub ON ub.uid = uia.uid
WHERE
    1 = 1
    AND uia.`status` = 1



09-01 22:41:50 
5ms
select * from yx_conf where name = 'inviteEnable'

09-01 22:41:50 
3ms
select * from `mg_user` where `id` = 1

09-01 22:41:50 
42ms
select count(*) FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	


09-01 22:41:50 
9ms
	SELECT
		u.id,
	    u.loginname,
		u.nick,
		u.avatar,
        u.email,
        u.phone,
	    u.invitecode,
	    u.viplevel,
		u.createtime,
		u.`status`,
		ub.sign,
		ub.sex,
		ub.validphone,
		ub.validemail,
		ri.ip,
		ri.province,
		ri.city,
		ll.createtime lastlogintime,
        ui.invite_code,
        IFNULL(wallet.amount, "未开户" ) AS wallet,
        ( SELECT count( ci.id ) FROM wx_call_item ci WHERE u.id = ci.fromuid ) AS callCount,
        IFNULL((
            SELECT
                sum( TIMESTAMPDIFF( SECOND, ci.calltime, ci.endtime ) )
            FROM
                wx_call_item ci
            WHERE
                u.id = ci.fromuid
                ),
            0
        ) AS `second` ,
        ( SELECT ( count( id )) FROM wx_friend WHERE uid = u.id ) AS friendCount,
        ( SELECT ( count( id )) FROM wx_group WHERE uid = u.id ) AS joinGroupCount,
        ( SELECT ( count( id )) FROM user_invite WHERE invite_uid = u.id ) AS inviteCount,
        (SELECT (count( id )) FROM wx_group_user WHERE uid = u.id AND ( grouprole = 2 OR grouprole = 3 )) AS createGroupCount
	 FROM
		`user` u
	INNER JOIN user_base ub ON u.id = ub.uid
	LEFT JOIN ip_info ri ON ri.id = u.ipid
	LEFT JOIN user_last_login_time ll ON ll.uid = u.id
	LEFT JOIN yx_user_wallet wallet ON u.id = wallet.uid
    LEFT JOIN user_invite ui ON u.id = ui.register_uid
	WHERE
	    1 = 1
	ORDER BY u.createtime DESC
 limit 0, 15

09-01 22:41:51 
4ms
select * from `mg_user` where `id` = 1

09-01 22:41:51 
2ms
select * from `mg_user` where `id` = 1

09-01 22:41:51 
3ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

09-01 22:41:51 
6ms
select count(*) FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	


09-01 22:41:51 
3ms
select * from `mg_user` where `id` = 1

09-01 22:41:51 
4ms
	SELECT
		urs.*
	 FROM
		user_register_stat urs
	WHERE
			urs.type = 1
	order by 
		 	urs.statbizstr desc
 limit 0, 15

09-01 22:41:52 
5ms
select * from `mg_user` where `id` = 1

09-01 22:41:52 
5ms
select * from yx_conf where conftype = 5 order by sort desc

09-01 22:42:00 
7ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:42:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:43:00 
2ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:43:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:44:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:44:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:45:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:45:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:46:00 
2ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:46:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:47:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:47:00 
6ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:48:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:48:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:49:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:49:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:50:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:50:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:51:00 
2ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:51:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:52:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:52:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:53:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:53:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:54:00 
5ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:54:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:55:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:55:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:56:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:56:00 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:57:00 
7ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:57:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:58:00 
7ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:58:00 
5ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 22:59:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 22:59:00 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:00:00 
5ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:00:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:01:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:01:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:01:15 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 HOUR) and createtime < now()

09-01 23:01:15 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 HOUR) AND ll.time < now();

09-01 23:02:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:02:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:03:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:03:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:04:00 
5ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:04:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:05:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:05:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:06:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:06:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:07:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:07:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:08:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:08:00 
1ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:09:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:09:00 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:10:19 
23ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:10:19 
15ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:11:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:11:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:12:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:12:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:13:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:13:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:14:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:14:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:15:00 
2ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:15:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:16:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:16:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:17:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:17:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:18:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:18:00 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:19:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:19:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:20:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:20:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:21:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:21:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:22:00 
5ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:22:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:23:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:23:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:24:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:24:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:25:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:25:00 
4ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:26:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:26:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:27:00 
4ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:27:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:28:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:28:00 
3ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

09-01 23:29:00 
3ms
select count(1) from user where createtime >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) and createtime < now()

09-01 23:29:00 
2ms
SELECT count(1) FROM tio_site_main.login_log ll INNER JOIN tio_site_main.ip_info ri ON ri.id = ll.ipid WHERE ll.time >= DATE_SUB(NOW(),INTERVAL 1 MINUTE) AND ll.time < now();

