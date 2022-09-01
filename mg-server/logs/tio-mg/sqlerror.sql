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


java.sql.SQLSyntaxErrorException: In aggregated query without GROUP BY, expression #3 of SELECT list contains nonaggregated column 'tio_site_main.wx_call_item.callduration'; this is incompatible with sql_mode=only_full_group_by
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:953)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeQuery(ClientPreparedStatement.java:1003)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.executeQuery(DruidPooledPreparedStatement.java:227)
	at org.tio.jfinal.plugin.activerecord.sql.proxy.ProxyPreparedStatement.executeQuery(ProxyPreparedStatement.java:316)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:329)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:343)
	at org.tio.jfinal.plugin.activerecord.DbPro.findFirst(DbPro.java:371)
	at org.tio.jfinal.plugin.activerecord.DbPro.findFirst(DbPro.java:1337)
	at org.tio.mg.service.service.tioim.TioUserService.info(TioUserService.java:106)
	at org.tio.mg.web.server.controller.tioim.TioUserController.info(TioUserController.java:84)
	at org.tio.mg.web.server.controller.tioim.TioUserControllerMethodAccess.invoke(Unknown Source)
	at com.esotericsoftware.reflectasm.MethodAccess.invoke(MethodAccess.java:39)
	at org.tio.http.server.handler.DefaultHttpRequestHandler.handler(DefaultHttpRequestHandler.java:637)
	at org.tio.http.server.HttpServerAioHandler.handler(HttpServerAioHandler.java:93)
	at org.tio.core.task.HandlerRunnable.handler(HandlerRunnable.java:94)
	at org.tio.core.task.DecodeRunnable.handler(DecodeRunnable.java:252)
	at org.tio.core.task.DecodeRunnable.decode(DecodeRunnable.java:182)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:85)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:22)
	at sun.nio.ch.Invoker.invokeUnchecked(Invoker.java:126)
	at sun.nio.ch.Invoker$2.run(Invoker.java:218)
	at sun.nio.ch.AsynchronousChannelGroupImpl$1.run(AsynchronousChannelGroupImpl.java:112)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
09-01 22:17:57 
43ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

java.sql.SQLSyntaxErrorException: Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'tio_site_stat.area_stat.province' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:953)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeQuery(ClientPreparedStatement.java:1003)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.executeQuery(DruidPooledPreparedStatement.java:227)
	at org.tio.jfinal.plugin.activerecord.sql.proxy.ProxyPreparedStatement.executeQuery(ProxyPreparedStatement.java:316)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:329)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:343)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:356)
	at org.tio.mg.service.service.tioim.TioStatService.areadict(TioStatService.java:79)
	at org.tio.mg.web.server.controller.tioim.TioStatController.areaList(TioStatController.java:306)
	at org.tio.mg.web.server.controller.tioim.TioStatControllerMethodAccess.invoke(Unknown Source)
	at com.esotericsoftware.reflectasm.MethodAccess.invoke(MethodAccess.java:39)
	at org.tio.http.server.handler.DefaultHttpRequestHandler.handler(DefaultHttpRequestHandler.java:637)
	at org.tio.http.server.HttpServerAioHandler.handler(HttpServerAioHandler.java:93)
	at org.tio.core.task.HandlerRunnable.handler(HandlerRunnable.java:94)
	at org.tio.core.task.DecodeRunnable.handler(DecodeRunnable.java:252)
	at org.tio.core.task.DecodeRunnable.decode(DecodeRunnable.java:182)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:85)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:22)
	at sun.nio.ch.Invoker.invokeUnchecked(Invoker.java:126)
	at sun.nio.ch.Invoker$2.run(Invoker.java:218)
	at sun.nio.ch.AsynchronousChannelGroupImpl$1.run(AsynchronousChannelGroupImpl.java:112)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
09-01 22:18:00 
3ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

java.sql.SQLSyntaxErrorException: Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'tio_site_stat.area_stat.province' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:953)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeQuery(ClientPreparedStatement.java:1003)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.executeQuery(DruidPooledPreparedStatement.java:227)
	at org.tio.jfinal.plugin.activerecord.sql.proxy.ProxyPreparedStatement.executeQuery(ProxyPreparedStatement.java:316)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:329)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:343)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:356)
	at org.tio.mg.service.service.tioim.TioStatService.areadict(TioStatService.java:79)
	at org.tio.mg.web.server.controller.tioim.TioStatController.areaList(TioStatController.java:306)
	at org.tio.mg.web.server.controller.tioim.TioStatControllerMethodAccess.invoke(Unknown Source)
	at com.esotericsoftware.reflectasm.MethodAccess.invoke(MethodAccess.java:39)
	at org.tio.http.server.handler.DefaultHttpRequestHandler.handler(DefaultHttpRequestHandler.java:637)
	at org.tio.http.server.HttpServerAioHandler.handler(HttpServerAioHandler.java:93)
	at org.tio.core.task.HandlerRunnable.handler(HandlerRunnable.java:94)
	at org.tio.core.task.DecodeRunnable.handler(DecodeRunnable.java:252)
	at org.tio.core.task.DecodeRunnable.decode(DecodeRunnable.java:182)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:85)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:22)
	at sun.nio.ch.Invoker.invokeUnchecked(Invoker.java:126)
	at sun.nio.ch.Invoker$2.run(Invoker.java:218)
	at sun.nio.ch.AsynchronousChannelGroupImpl$1.run(AsynchronousChannelGroupImpl.java:112)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
09-01 22:18:23 
4ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

java.sql.SQLSyntaxErrorException: Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'tio_site_stat.area_stat.province' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:953)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeQuery(ClientPreparedStatement.java:1003)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.executeQuery(DruidPooledPreparedStatement.java:227)
	at org.tio.jfinal.plugin.activerecord.sql.proxy.ProxyPreparedStatement.executeQuery(ProxyPreparedStatement.java:316)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:329)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:343)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:356)
	at org.tio.mg.service.service.tioim.TioStatService.areadict(TioStatService.java:79)
	at org.tio.mg.web.server.controller.tioim.TioStatController.areaList(TioStatController.java:306)
	at org.tio.mg.web.server.controller.tioim.TioStatControllerMethodAccess.invoke(Unknown Source)
	at com.esotericsoftware.reflectasm.MethodAccess.invoke(MethodAccess.java:39)
	at org.tio.http.server.handler.DefaultHttpRequestHandler.handler(DefaultHttpRequestHandler.java:637)
	at org.tio.http.server.HttpServerAioHandler.handler(HttpServerAioHandler.java:93)
	at org.tio.core.task.HandlerRunnable.handler(HandlerRunnable.java:94)
	at org.tio.core.task.DecodeRunnable.handler(DecodeRunnable.java:252)
	at org.tio.core.task.DecodeRunnable.decode(DecodeRunnable.java:182)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:85)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:22)
	at sun.nio.ch.Invoker.invokeUnchecked(Invoker.java:126)
	at sun.nio.ch.Invoker$2.run(Invoker.java:218)
	at sun.nio.ch.AsynchronousChannelGroupImpl$1.run(AsynchronousChannelGroupImpl.java:112)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
09-01 22:41:11 
3ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

java.sql.SQLSyntaxErrorException: Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'tio_site_stat.area_stat.province' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:953)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeQuery(ClientPreparedStatement.java:1003)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.executeQuery(DruidPooledPreparedStatement.java:227)
	at org.tio.jfinal.plugin.activerecord.sql.proxy.ProxyPreparedStatement.executeQuery(ProxyPreparedStatement.java:316)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:329)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:343)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:356)
	at org.tio.mg.service.service.tioim.TioStatService.areadict(TioStatService.java:79)
	at org.tio.mg.web.server.controller.tioim.TioStatController.areaList(TioStatController.java:306)
	at org.tio.mg.web.server.controller.tioim.TioStatControllerMethodAccess.invoke(Unknown Source)
	at com.esotericsoftware.reflectasm.MethodAccess.invoke(MethodAccess.java:39)
	at org.tio.http.server.handler.DefaultHttpRequestHandler.handler(DefaultHttpRequestHandler.java:637)
	at org.tio.http.server.HttpServerAioHandler.handler(HttpServerAioHandler.java:93)
	at org.tio.core.task.HandlerRunnable.handler(HandlerRunnable.java:94)
	at org.tio.core.task.DecodeRunnable.handler(DecodeRunnable.java:252)
	at org.tio.core.task.DecodeRunnable.decode(DecodeRunnable.java:182)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:85)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:22)
	at sun.nio.ch.Invoker.invokeUnchecked(Invoker.java:126)
	at sun.nio.ch.Invoker$2.run(Invoker.java:218)
	at sun.nio.ch.AsynchronousChannelGroupImpl$1.run(AsynchronousChannelGroupImpl.java:112)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
09-01 22:41:13 
4ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

java.sql.SQLSyntaxErrorException: Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'tio_site_stat.area_stat.province' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:953)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeQuery(ClientPreparedStatement.java:1003)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.executeQuery(DruidPooledPreparedStatement.java:227)
	at org.tio.jfinal.plugin.activerecord.sql.proxy.ProxyPreparedStatement.executeQuery(ProxyPreparedStatement.java:316)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:329)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:343)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:356)
	at org.tio.mg.service.service.tioim.TioStatService.areadict(TioStatService.java:79)
	at org.tio.mg.web.server.controller.tioim.TioStatController.areaList(TioStatController.java:306)
	at org.tio.mg.web.server.controller.tioim.TioStatControllerMethodAccess.invoke(Unknown Source)
	at com.esotericsoftware.reflectasm.MethodAccess.invoke(MethodAccess.java:39)
	at org.tio.http.server.handler.DefaultHttpRequestHandler.handler(DefaultHttpRequestHandler.java:637)
	at org.tio.http.server.HttpServerAioHandler.handler(HttpServerAioHandler.java:93)
	at org.tio.core.task.HandlerRunnable.handler(HandlerRunnable.java:94)
	at org.tio.core.task.DecodeRunnable.handler(DecodeRunnable.java:252)
	at org.tio.core.task.DecodeRunnable.decode(DecodeRunnable.java:182)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:85)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:22)
	at sun.nio.ch.Invoker.invokeUnchecked(Invoker.java:126)
	at sun.nio.ch.Invoker$2.run(Invoker.java:218)
	at sun.nio.ch.AsynchronousChannelGroupImpl$1.run(AsynchronousChannelGroupImpl.java:112)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
09-01 22:41:19 
3ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

java.sql.SQLSyntaxErrorException: Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'tio_site_stat.area_stat.province' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:953)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeQuery(ClientPreparedStatement.java:1003)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.executeQuery(DruidPooledPreparedStatement.java:227)
	at org.tio.jfinal.plugin.activerecord.sql.proxy.ProxyPreparedStatement.executeQuery(ProxyPreparedStatement.java:316)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:329)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:343)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:356)
	at org.tio.mg.service.service.tioim.TioStatService.areadict(TioStatService.java:79)
	at org.tio.mg.web.server.controller.tioim.TioStatController.areaList(TioStatController.java:306)
	at org.tio.mg.web.server.controller.tioim.TioStatControllerMethodAccess.invoke(Unknown Source)
	at com.esotericsoftware.reflectasm.MethodAccess.invoke(MethodAccess.java:39)
	at org.tio.http.server.handler.DefaultHttpRequestHandler.handler(DefaultHttpRequestHandler.java:637)
	at org.tio.http.server.HttpServerAioHandler.handler(HttpServerAioHandler.java:93)
	at org.tio.core.task.HandlerRunnable.handler(HandlerRunnable.java:94)
	at org.tio.core.task.DecodeRunnable.handler(DecodeRunnable.java:252)
	at org.tio.core.task.DecodeRunnable.decode(DecodeRunnable.java:182)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:85)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:22)
	at sun.nio.ch.Invoker.invokeUnchecked(Invoker.java:126)
	at sun.nio.ch.Invoker$2.run(Invoker.java:218)
	at sun.nio.ch.AsynchronousChannelGroupImpl$1.run(AsynchronousChannelGroupImpl.java:112)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
09-01 22:41:49 
5ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

java.sql.SQLSyntaxErrorException: Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'tio_site_stat.area_stat.province' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:953)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeQuery(ClientPreparedStatement.java:1003)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.executeQuery(DruidPooledPreparedStatement.java:227)
	at org.tio.jfinal.plugin.activerecord.sql.proxy.ProxyPreparedStatement.executeQuery(ProxyPreparedStatement.java:316)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:329)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:343)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:356)
	at org.tio.mg.service.service.tioim.TioStatService.areadict(TioStatService.java:79)
	at org.tio.mg.web.server.controller.tioim.TioStatController.areaList(TioStatController.java:306)
	at org.tio.mg.web.server.controller.tioim.TioStatControllerMethodAccess.invoke(Unknown Source)
	at com.esotericsoftware.reflectasm.MethodAccess.invoke(MethodAccess.java:39)
	at org.tio.http.server.handler.DefaultHttpRequestHandler.handler(DefaultHttpRequestHandler.java:637)
	at org.tio.http.server.HttpServerAioHandler.handler(HttpServerAioHandler.java:93)
	at org.tio.core.task.HandlerRunnable.handler(HandlerRunnable.java:94)
	at org.tio.core.task.DecodeRunnable.handler(DecodeRunnable.java:252)
	at org.tio.core.task.DecodeRunnable.decode(DecodeRunnable.java:182)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:85)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:22)
	at sun.nio.ch.Invoker.invokeUnchecked(Invoker.java:126)
	at sun.nio.ch.Invoker$2.run(Invoker.java:218)
	at sun.nio.ch.AsynchronousChannelGroupImpl$1.run(AsynchronousChannelGroupImpl.java:112)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
09-01 22:41:51 
3ms
SELECT province, GROUP_CONCAT(city ORDER BY citychatindex SEPARATOR ',') citys FROM area_stat where type = 1 GROUP BY charindex

java.sql.SQLSyntaxErrorException: Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'tio_site_stat.area_stat.province' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:120)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:953)
	at com.mysql.cj.jdbc.ClientPreparedStatement.executeQuery(ClientPreparedStatement.java:1003)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.executeQuery(DruidPooledPreparedStatement.java:227)
	at org.tio.jfinal.plugin.activerecord.sql.proxy.ProxyPreparedStatement.executeQuery(ProxyPreparedStatement.java:316)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:329)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:343)
	at org.tio.jfinal.plugin.activerecord.DbPro.find(DbPro.java:356)
	at org.tio.mg.service.service.tioim.TioStatService.areadict(TioStatService.java:79)
	at org.tio.mg.web.server.controller.tioim.TioStatController.areaList(TioStatController.java:306)
	at org.tio.mg.web.server.controller.tioim.TioStatControllerMethodAccess.invoke(Unknown Source)
	at com.esotericsoftware.reflectasm.MethodAccess.invoke(MethodAccess.java:39)
	at org.tio.http.server.handler.DefaultHttpRequestHandler.handler(DefaultHttpRequestHandler.java:637)
	at org.tio.http.server.HttpServerAioHandler.handler(HttpServerAioHandler.java:93)
	at org.tio.core.task.HandlerRunnable.handler(HandlerRunnable.java:94)
	at org.tio.core.task.DecodeRunnable.handler(DecodeRunnable.java:252)
	at org.tio.core.task.DecodeRunnable.decode(DecodeRunnable.java:182)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:85)
	at org.tio.core.ReadCompletionHandler.completed(ReadCompletionHandler.java:22)
	at sun.nio.ch.Invoker.invokeUnchecked(Invoker.java:126)
	at sun.nio.ch.Invoker$2.run(Invoker.java:218)
	at sun.nio.ch.AsynchronousChannelGroupImpl$1.run(AsynchronousChannelGroupImpl.java:112)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
