-- 推荐码关联记录列表
#sql("list")
SELECT
       *
FROM
     user_invite
where
      invite_uid = uid
order by id desc
#end
