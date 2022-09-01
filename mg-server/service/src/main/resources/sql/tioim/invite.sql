-- 推荐码关联记录列表
#sql("list")
SELECT
    u.id AS uid,
    u.loginname,
    u.nick,
    u.avatar,
    u.email,
    u.phone,
    u.invitecode,
    u.`status`,
    u.createtime,
    ui.id,
    ui.invite_type,
    ui.invite_text,
    ui.invite_channel,
    ui.invite_explain
FROM
    user_invite ui
        LEFT JOIN `user` u ON ui.register_uid = u.id
WHERE
    1 = 1
#if(uid != null && uid != "")
    AND ui.invite_uid = #para(uid)
#end
#if(startTime != null && startTime != "")
    AND u.createtime >= #para(startTime)
#end
#if(endTime != null && endTime != "")
    AND u.createtime <= #para(endTime)
#end
ORDER BY ui.createtime DESC
#end
