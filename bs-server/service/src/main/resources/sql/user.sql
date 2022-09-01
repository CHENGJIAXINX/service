#sql("searchByNick")
	select nick,id,avatar from user 
	where status = 1 and searchflag = 1
		and (nick like #para(nick) or phone = #para(search))
	order by id desc
#end


#sql("updateBase")
	update user_base 
	set
		#if(sex != null && sex != "")
			sex = #para(sex),
		#end
		sign = #para(sign)
	where 
		uid = #para(uid)
#end

#sql("searchUser")
SELECT
    a.nick,
    a.id,
    a.avatar
FROM
    `user` a
        #if(uidFind != null && uidFind == "1")
            LEFT JOIN user_ext b ON a.id = b.uid
            AND b.ext_name = 'uidFind'
       #end
        #if(phoneFind != null && phoneFind == "1")
            LEFT JOIN user_ext c ON a.id = c.uid
            AND c.ext_name = 'phoneFind'
        #end
        #if(emailFind != null && emailFind == "1")
            LEFT JOIN user_ext d ON a.id = d.uid
            AND d.ext_name = 'emailFind'
        #end
        #if(loginNameFind != null && loginNameFind == "1")
            LEFT JOIN user_ext e ON a.id = e.uid
            AND e.ext_name = 'loginNameFind'
        #end
WHERE
    (1 = 0)
   #if(uidFind != null && uidFind == "1")
        or (( b.ext_value IS NULL OR b.ext_value = '1' ) AND a.id = #para(id))
   #end
    #if(phoneFind != null && phoneFind == "1")
        or (( c.ext_value IS NULL OR c.ext_value = '1' ) AND a.phone is not null and a.phone = #para(phone))
   #end
   #if(emailFind != null && emailFind == "1")
        or (( d.ext_value IS NULL OR d.ext_value = '1' ) AND a.emailpwd is not null and a.emailpwd = #para(email))
   #end
   #if(loginNameFind != null && loginNameFind == "1")
        or (( e.ext_value IS NULL OR e.ext_value = '1' ) AND a.loginname is not null and a.loginname = #para(loginname))
    #end
#end

#sql("searchByUid")
	select nick,id,avatar from user where status = 1 and searchflag = 1 and id = #para(uid)
#end

#sql("searchByLoginname")
	select nick,id,avatar from user where status = 1 and searchflag = 1 and loginname = #para(loginname)
#end
----可按id进行查询
#sql("searchByLoginnameOrUid")
	select nick,id,avatar from user where status = 1 and searchflag = 1 and (loginname = #para(loginname) or id = #para(loginname))
#end

-- 查看某人的登录日志
#sql("pageLoginLog")
SELECT u.nick, u.id, u.loginname, ll.time,ll.deviceinfo,ll.devicetype,ii.ip, ii.province, ii.city, ii.operator, ua.agentName, ua.agentVersionMajor, ua.osName, ua.isMobile, ua.deviceClass
FROM `login_log` ll
LEFT JOIN user_agent ua ON ua.id = ll.uaid
LEFT JOIN user u ON u.id = ll.uid
LEFT JOIN ip_info ii ON ii.id = ll.ipid
WHERE u.id = #para(uid)
ORDER BY u.id, ll.time DESC
#end

-- 查看某人的访问日志
#sql("pageAccessLog")
SELECT u.id as uid, u.nick, u.loginname, ii.province, ii.city, ii.operator, ii.ip, cjl.groupid, cjl.jointime, cjl.leavetime, cjl.cost, cjl.`status` FROM `chatroom_join_leave` cjl 
LEFT JOIN user u on u.id = cjl.uid 
LEFT JOIN ip_info ii on ii.id = cjl.ipid 
where u.id = #para(uid)
order by cjl.id desc
#end