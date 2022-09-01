-- 用户列表
#sql("list")
SELECT
       u.id AS uid,
       u.loginname,
       u.nick,
       u.avatar,
       u.email,
       u.phone,
       u.invitecode,
       ub.sex,
       uia.id,
       uia.fuid,
       uia.gid,
       uia.message,
       uia.`status`,
       (SELECT (count(id)) FROM user_invite ui WHERE ui.invite_uid = uia.uid) AS inviteCount
FROM
    user_invite_attr uia
    LEFT JOIN `user` u ON u.id = uia.uid
    LEFT JOIN user_base ub ON ub.uid = uia.uid
WHERE
    1 = 1
#if(status != null && status != "")
    AND uia.`status` = #para(status)
#end
#if(searchkey != null && searchkey != "")
    AND concat(u.loginname, u.nick) LIKE #para(searchkey)
#end
#if(searchid != null && searchid != "")
   OR u.phone = #para(searchid)
   OR u.id = #para(searchid)
#end
ORDER BY uia.create_time DESC
#end
