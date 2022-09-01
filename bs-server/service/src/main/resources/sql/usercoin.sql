#sql("addCoin")
	UPDATE user_coin
		SET coin = coin + #para(addcoin) ,
		 totalcoin = totalcoin + #para(addcoin) 
		WHERE
			uid = #para(uid) and `status` = #para(status)
#end

-- 新增攻击T币
#sql("addAttackCoin")
	UPDATE user_coin
		SET attackcoin = attackcoin + #para(addcoin)
		WHERE
			uid = #para(uid) and `status` = #para(status)
#end

-- 新增T分
#sql("freecoin")
	UPDATE user_coin
		SET freecoin = freecoin + #para(addcoin) ,
		 totalfreecoin = totalfreecoin + #para(addcoin) 
		WHERE
			uid = #para(uid) and `status` = #para(status)
#end

-- 消费T分
#sql("costFreeCoin")
	UPDATE user_coin
		SET freecoin = freecoin - #para(freecoin) ,
		 costfreecoin = costfreecoin + #para(freecoin) 
		WHERE
			uid = #para(uid) and `status` = #para(status) and freecoin >= #para(freecoin)
#end

-- 消费T币
#sql("costCoin")
	UPDATE user_coin
		SET coin = coin - #para(coin) ,
		 costcoin = costcoin + #para(coin) 
		WHERE
			uid = #para(uid) and `status` = #para(status) and coin >= #para(coin)
#end


-- 根据uid获取用户财务信息
#sql("getUserSimpleCoin")
	select id,coin,freecoin,cny,uid from  user_coin
		WHERE
			uid = #para(uid) and `status` = #para(status)
#end
