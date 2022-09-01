/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.sitexxx.web.server.http.stat;

import java.util.HashSet;
import java.util.Set;

import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.stat.StatPathFilter;

import cn.hutool.core.io.FileUtil;

/**
 * @author tanyaowu
 *
 */
public class TioSiteStatPathFilter implements StatPathFilter {

	public static final TioSiteStatPathFilter me = new TioSiteStatPathFilter();

	/**
	 * 
	 */
	private TioSiteStatPathFilter() {

	}

	private static Set<String> skipExtSet = new HashSet<>();

	static {
		skipExtSet.add("css");
		skipExtSet.add("js");
		skipExtSet.add("ico");
		skipExtSet.add("png");
		skipExtSet.add("jpg");
		skipExtSet.add("swf");
		skipExtSet.add("xml");
		skipExtSet.add("gif");
		skipExtSet.add("jpeg");
		skipExtSet.add("woff");
		skipExtSet.add("map");
		skipExtSet.add("txt");
	}

	@Override
	public boolean filter(String path, HttpRequest request, HttpResponse response) {
		String ext = FileUtil.extName(path);
		if (skipExtSet.contains(ext)) {
			return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
