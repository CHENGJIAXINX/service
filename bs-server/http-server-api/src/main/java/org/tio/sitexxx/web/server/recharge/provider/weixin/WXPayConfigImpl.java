/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.recharge.provider.weixin;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.utils.jfinal.P;

import cn.hutool.core.io.FileUtil;

public class WXPayConfigImpl implements com.github.wxpay.sdk.WXPayConfig {
	private static Logger log = LoggerFactory.getLogger(WXPayConfigImpl.class);

	/**
	 * recharge.wx.appid=wxf76cf20e435b3c78
	#微信支付商户号
	recharge.wx.mch_id=1497294502
	#API密钥
	recharge.wx.key=vSTGii1iTxdh9fJ5G48G49lG5bTEO826
	#Appsecret
	recharge.wx.secret=a2c61341a0d8ac7d3c3e31fd40a1b902
	 */
	private byte[]					certData;
	private static WXPayConfigImpl	INSTANCE;

	private WXPayConfigImpl() {
		try {
			String certPath = FileUtil.getAbsolutePath("classpath:config/weixin/pay/apiclient_cert.p12");
			File file = new File(certPath);
			InputStream certStream = new FileInputStream(file);
			this.certData = new byte[(int) file.length()];
			certStream.read(this.certData);
			certStream.close();
		} catch (Exception e) {
			log.error("", e);
			throw new RuntimeException(e);
		}
	}

	public static WXPayConfigImpl getInstance() {
		if (INSTANCE == null) {
			synchronized (WXPayConfigImpl.class) {
				if (INSTANCE == null) {
					INSTANCE = new WXPayConfigImpl();
				}
			}
		}
		return INSTANCE;
	}

	@Override
	public String getAppID() {
		return P.get("recharge.wx.appid");
	}

	public String getSecret() {
		return P.get("recharge.wx.secret");
	}

	@Override
	public String getMchID() {
		return P.get("recharge.wx.mch_id");
	}

	@Override
	public String getKey() {
		return P.get("recharge.wx.key");
	}

	public InputStream getCertStream() {
		ByteArrayInputStream certBis;
		certBis = new ByteArrayInputStream(this.certData);
		return certBis;
	}

	public int getHttpConnectTimeoutMs() {
		return 5000;
	}

	public int getHttpReadTimeoutMs() {
		return 10000;
	}

	//    public IWXPayDomain getWXPayDomain() {
	//        return WXPayDomainSimpleImpl.instance();
	//    }

	public String getPrimaryDomain() {
		return "api.mch.weixin.qq.com";
	}

	public String getAlternateDomain() {
		return "api2.mch.weixin.qq.com";
	}

	//    @Override
	//    int getReportWorkerNum() {
	//        return 1;
	//    }
	//
	//    @Override
	//    public int getReportBatchSize() {
	//        return 2;
	//    }
}
