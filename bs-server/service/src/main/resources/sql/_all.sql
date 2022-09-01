







#namespace("stat")
	#include("stat.sql")
#end

#namespace("user")
	#include("user.sql")
#end

#namespace("usercoin")
	#include("usercoin.sql")
#end

#namespace("usercoinitem")
	#include("usercoinitem.sql")
#end

#namespace("userrecharge")
	#include("userrecharge.sql")
#end


### 新版本聊天数据库脚本
#include("chat/all.sql")


### 钱包脚本
#include("wallet/all.sql")
