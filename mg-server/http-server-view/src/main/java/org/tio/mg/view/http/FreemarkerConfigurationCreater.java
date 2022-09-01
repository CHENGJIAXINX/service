/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
/**
 * 
 */
package org.tio.mg.view.http;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import org.tio.http.common.HttpConfig;
import org.tio.http.common.view.freemarker.ConfigurationCreater;
import org.tio.utils.freemarker.ShortMessageTemplateExceptionHandler;

import freemarker.template.Configuration;

/**
 * @author tanyaowu
 *
 */
public class FreemarkerConfigurationCreater implements ConfigurationCreater {

	public static final FreemarkerConfigurationCreater me = new FreemarkerConfigurationCreater();

	/**
	 * 
	 */
	private FreemarkerConfigurationCreater() {
	}

	@Override
	public Configuration createConfiguration(HttpConfig httpConfig, String root) throws IOException {
		Configuration cfg = new Configuration(Configuration.getVersion());
		//		cfg.setDirectoryForTemplateLoading(root);

		if (httpConfig.isPageInClasspath()) {
			cfg.setClassForTemplateLoading(this.getClass(), root/**.substring("classpath:".length())*/
			);
		} else {
			cfg.setDirectoryForTemplateLoading(new File(root));
		}

		cfg.setDefaultEncoding(httpConfig.getCharset());
		//		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		if (WebViewInit.devMode == 1) {  //开发模式
			cfg.setLogTemplateExceptions(true);
		} else {
			cfg.setLogTemplateExceptions(false);
		}

		cfg.setWrapUncheckedExceptions(true);
		cfg.setTemplateExceptionHandler(ShortMessageTemplateExceptionHandler.me);
		cfg.setLocale(Locale.SIMPLIFIED_CHINESE);
		cfg.setNumberFormat("#");
//		cfg.setClassicCompatible(true);

		//		cfg.setLocale(Locale.SIMPLIFIED_CHINESE);
		return cfg;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
