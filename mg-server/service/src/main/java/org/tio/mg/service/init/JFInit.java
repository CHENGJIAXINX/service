package org.tio.mg.service.init;

import com.alibaba.druid.filter.config.ConfigTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.jfinal.plugin.activerecord.ActiveRecordPlugin;
import org.tio.jfinal.plugin.druid.DruidPlugin;
import org.tio.jfinal.template.Engine;
import org.tio.jfinal.template.source.ClassPathSourceFactory;
import org.tio.mg.service.jf.TioMysqlDialect;
import org.tio.utils.jfinal.P;

import java.sql.Connection;

public class JFInit {
    private static Logger log = LoggerFactory.getLogger(JFInit.class);
    public static DruidPlugin[] plugins;
    /**
     * 有几个数据库
     */
    public static int dbCount;
    /**
     * 数据库名字
     */
    public static String[] dbNames;

    /**
     * Jfinal初始化加载
     */
    public static void init() {
        PropInit.init();

        dbNames = P.get("db.jdbc.multi.name").split(",");
        dbCount = dbNames.length;
        plugins = new DruidPlugin[dbCount];
        for (int i = 0; i < dbCount; i++) {//多数据源加载
            String dbName = dbNames[i];
            final String jdbcUrl = P.get(dbName + ".jdbc.url");
            final String jdbcUsername = P.get(dbName + ".jdbc.username");
            String jdbcPwd = null;
            try {
                jdbcPwd = ConfigTools.decrypt(P.get(dbName + ".jdbc.password"));
            } catch (Throwable e) {
                jdbcPwd = P.get(dbName + ".jdbc.password");
            }
            final Integer jdbcPoolInitSize = P.getInt("db.jdbc.pool.initialSize");
            final Integer jdbcPoolMinIdle = P.getInt("db.jdbc.pool.minIdle");
            final Integer jdbcPoolMaxActive = P.getInt("db.jdbc.pool.maxActive");
            DruidPlugin druidPlugin = new DruidPlugin(jdbcUrl, jdbcUsername, jdbcPwd);
            //		plugins.setConnectionProperties(P.get("connectionProperties"));
            druidPlugin.set(jdbcPoolInitSize, jdbcPoolMinIdle, jdbcPoolMaxActive);
            druidPlugin.setFilters(P.get("db.jdbc.filters", "stat,wall"));
            druidPlugin.setValidationQuery(P.get("db.jdbc.validationQuery"));
            druidPlugin.setDriverClass(P.get("db.jdbc.driverClassName"));
            druidPlugin.setConnectionInitSql("set names utf8mb4");

            druidPlugin.start();
            plugins[i] = druidPlugin;

            ActiveRecordPlugin arp = new ActiveRecordPlugin(dbName, druidPlugin);
            arp.setDialect(new TioMysqlDialect());
            arp.setTransactionLevel(Connection.TRANSACTION_READ_COMMITTED);
            arp.getConfig().getDialect().setKeepByteAndShort(true);
            try {
                String[] xx = dbName.split("_");//[2];
                Class.forName("org.tio.mg.service.model." + xx[xx.length - 1] + "._MappingKit").getMethod("mapping", ActiveRecordPlugin.class).invoke(null, arp);
            } catch (Exception e) {
                log.error("加载数据库映射关系错误");
            }
            arp.setShowSql(true);

            Engine engine = arp.getSqlKit().getEngine();
            engine.setBaseTemplatePath(null);
            engine.setSourceFactory(new ClassPathSourceFactory());
            arp.addSqlTemplate("sql/_all.sql");
            arp.start();
        }
    }
}
