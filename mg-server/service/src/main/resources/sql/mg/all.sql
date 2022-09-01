### 后台脚本
### 后台用户脚本
#namespace("mguser")
	#include("mguser.sql")
#end
### 后台系统脚本
#namespace("sys")
	#include("sys.sql")
#end

#namespace("mgloginstat")
	#include("mgloginstat.sql")
#end

#namespace("mgrecharge")
	#include("mgrecharge.sql")
#end

#namespace("mgwithdraw")
	#include("mgwithdraw.sql")
#end

#namespace("mgredpacket")
	#include("mgredpacket.sql")
#end

#namespace("mgwords")
    #include("mgwords.sql")
#end

#namespace("mgtransaccounts")
    #include("mgtransaccounts.sql")
#end

### 菜单
#namespace("mgmenu")
    #include("mgmenu.sql")
#end

