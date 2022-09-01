/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.timetask;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.mg.service.tool.MysqlTool;
import org.tio.utils.date.DateFmt;
import org.tio.utils.jfinal.P;
import org.tio.utils.quartz.AbstractJobWithLog;

import com.alibaba.druid.filter.config.ConfigTools;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;

/**
 * 
 * @author xufei
 * 2020年10月16日 下午4:21:25
 */
public class MySqlBackupJob extends AbstractJobWithLog {
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(MySqlBackupJob.class);

	public static MySqlBackupJob	me			= new MySqlBackupJob();
	public static String			lastZipPath	= null;
	private static final String		PATTERN		= "yyyy-MM-dd_HH_mm_ss";

	@Override
	public void run(JobExecutionContext context) throws Exception {
		String time = DateFmt.of(PATTERN).format(LocalDateTime.now());
		String rootdir = P.get("mysql.backup.backend.dir", "d:/mysqlbackup/backend");
		File root = new File(rootdir);
		String dir = rootdir + "/" + time;
		FileUtil.mkdir(dir);
		
		String jdbcUrl = P.get("tio_mg.jdbc.url");
		JdbcUrlSplitter jdbcUrlSplitter = new JdbcUrlSplitter(jdbcUrl);

		final String username = P.get("tio_mg.jdbc.username");
		String password = null;
		try {
			password = ConfigTools.decrypt(P.get("tio_mg.jdbc.password"));
		} catch (Throwable e) {
			password = P.get("tio_mg.jdbc.password");
		}
		String host = jdbcUrlSplitter.host;
		String port = jdbcUrlSplitter.port;

		String filePath = dir + "/tio_mg.sql";

		@SuppressWarnings("unused")
		File backFile = MysqlTool.backup(host, Integer.parseInt(port), "tio_mg", username, password, filePath);
		//			files[i++] = file;

		String zipPath = rootdir + "/" + time + ".zip";
		ZipUtil.zip(dir, zipPath);
		lastZipPath = zipPath;

		FileUtil.del(dir);

		File[] files = root.listFiles();
		if (files != null && files.length > 0) {
			Date nowDate = new Date();
			for (File file : files) {
				Path path = Paths.get(file.toURI());
				BasicFileAttributeView basicview = Files.getFileAttributeView(path, BasicFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);

				BasicFileAttributes attr = basicview.readAttributes();
				Date createTimeDate = new Date(attr.creationTime().toMillis());

				long days = DateUtil.between(nowDate, createTimeDate, DateUnit.DAY);
				if (days > 30) {
					FileUtil.del(file);
				}
			}
		}
	}

	public static class JdbcUrlSplitter {
		public String driverName, host, port, database, params;

		public JdbcUrlSplitter(String jdbcUrl) {
			int pos, pos1, pos2;
			String connUri;

			if (jdbcUrl == null || !jdbcUrl.startsWith("jdbc:") || (pos1 = jdbcUrl.indexOf(':', 5)) == -1)
				throw new IllegalArgumentException("Invalid JDBC url.");

			driverName = jdbcUrl.substring(5, pos1);
			if ((pos2 = jdbcUrl.indexOf(';', pos1)) == -1) {
				connUri = jdbcUrl.substring(pos1 + 1);
			} else {
				connUri = jdbcUrl.substring(pos1 + 1, pos2);
				params = jdbcUrl.substring(pos2 + 1);
			}

			if (connUri.startsWith("//")) {
				if ((pos = connUri.indexOf('/', 2)) != -1) {
					host = connUri.substring(2, pos);
					database = connUri.substring(pos + 1);

					if ((pos = host.indexOf(':')) != -1) {
						port = host.substring(pos + 1);
						host = host.substring(0, pos);
					}
				}
			} else {
				database = connUri;
			}
		}
	}

	public static class JdbcUrlUtil {
		public static String findDataBaseNameByUrl(String jdbcUrl) {
			String database = null;
			int pos, pos1;
			String connUri;

			if (StringUtils.isBlank(jdbcUrl)) {
				throw new IllegalArgumentException("Invalid JDBC url.");
			}

			jdbcUrl = jdbcUrl.toLowerCase();

			if (jdbcUrl.startsWith("jdbc:impala")) {
				jdbcUrl = jdbcUrl.replace(":impala", "");
			}

			if (!jdbcUrl.startsWith("jdbc:") || (pos1 = jdbcUrl.indexOf(':', 5)) == -1) {
				throw new IllegalArgumentException("Invalid JDBC url.");
			}

			connUri = jdbcUrl.substring(pos1 + 1);

			if (connUri.startsWith("//")) {
				if ((pos = connUri.indexOf('/', 2)) != -1) {
					database = connUri.substring(pos + 1);
				}
			} else {
				database = connUri;
			}

			if (database.contains("?")) {
				database = database.substring(0, database.indexOf("?"));
			}

			if (database.contains(";")) {
				database = database.substring(0, database.indexOf(";"));
			}

			if (StringUtils.isBlank(database)) {
				throw new IllegalArgumentException("Invalid JDBC url.");
			}
			return database;
		}
	}
}
