/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.recharge.provider.apple;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.util.Resps;
import org.tio.sitexxx.service.model.main.RechargeItem;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.service.recharge.RechargeItemService;
import org.tio.sitexxx.servicecommon.utils.LogUtils;
import org.tio.sitexxx.service.vo.RequestExt;
import org.tio.sitexxx.web.server.recharge.IRechargeProvider;
import org.tio.sitexxx.web.server.recharge.provider.apple.vo.ReceiptResult;
import org.tio.sitexxx.web.server.utils.WebUtils;
import org.tio.utils.crypto.Md5;
import org.tio.utils.http.HttpUtils;
import org.tio.utils.jfinal.P;
import org.tio.utils.json.Json;
import org.tio.utils.resp.Resp;

import cn.hutool.core.util.StrUtil;
import okhttp3.Headers;
import okhttp3.Response;

/**
 * 苹果充值
 * @author tanyaowu
 */
public class AppleRechargeProvider implements IRechargeProvider {
	private static Logger log = LogUtils.getCoinLog();

	public static final AppleRechargeProvider me = new AppleRechargeProvider();

	protected AppleRechargeProvider() {
	}

	@Override
	public HttpResponse toThirdRechargePage(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception {
		//本系统订单号
		String tradeno = rechargeItem.getTradeno();
		return Resps.json(request, Resp.ok(tradeno));
	}

	/*
	 * 手机端需要传递
	 * receipt
	 * tradeno
	 * sign: 签名，签名规则见文档
	 */
	@Override
	public boolean isValidCallback(HttpRequest request, int callbackType) throws Exception {
		RequestExt requestExt = WebUtils.getRequestExt(request);
		String appVersion = requestExt.getAppVersion();
		
		String receipt = request.getParam("receipt");
		if (receipt == null) {
			receipt = "";
		}
		String tradeno = getTradeno(request, callbackType);
		String sign = request.getParam("sign");
		

		String str = null;//receipt + tradeno + key;
		String mysign = null;//Md5.getMD5(str);
		
		String key = ConfService.getString("ios.pay.key", "iolkhtgf");
//		if (StrUtil.compareVersion(appVersion, "1.1.9") >= 0) {  //1.1.9（含）及以后新版本
			str = receipt + tradeno + key + appVersion;
			mysign = Md5.getMD5(str);
//		} 
//		else {       //1.1.9版本以前的(1.1.8, 1.1.7等版本)
//			key = "ijkmnbhg";
//			str = receipt + tradeno + key;
//			mysign = Md5.getMD5(str);
//		}

		
		if (Objects.equals(mysign, sign)) {
			return true;
		}
		log.error("苹果充值验证失败, appversion:{}, tradeno:{}", appVersion, tradeno);
		return false;
	}

	@Override
	public String getTradeno(HttpRequest request, int callbackType) {
		String tradeno = request.getParam("tradeno");
		return tradeno;
	}

	
	//如果失败，客户端把这个值传过来
	/**
	 * SKErrorUnknown
		错误代码，表示发生了未知或意外错误。
		
		SKErrorClientInvalid
		错误代码，指示不允许客户端执行尝试的操作。
		
		SKErrorPaymentCancelled
		错误代码，表示用户取消了付款请求。
		
		SKErrorPaymentInvalid
		错误代码，表示App Store无法识别其中一个付款参数。
		
		SKErrorPaymentNotAllowed
		错误代码，表示不允许用户授权付款。
		
		SKErrorStoreProductNotAvailable
		错误代码，表示请求的产品在商店中不可用。
		
		SKErrorCloudServicePermissionDenied
		错误代码，表示用户未允许访问Cloud服务信息。
		
		SKErrorCloudServiceNetworkConnectionFailed
		错误代码，表示设备无法连接到网络。
		
		SKErrorCloudServiceRevoked
		错误代码，指示用户已撤消使用此云服务的权限。
	 */
	//
//	/**
//     *  未知错误
//     */
//    IAP_FILEDCOED_UNKNOWN = 2000,
//    /**
//     *  用户禁止应用内付费购买
//     */
//    IAP_FILEDCOED_NORIGHT = 2001,
//    
//    /**
//     *  商品为空
//     */
//    IAP_FILEDCOED_EMPTYGOODS = 2002,
//    /**
//     *  无法获取产品信息，请重试
//     */
//    IAP_FILEDCOED_CANNOTGETINFORMATION = 2003,
//    /**
//     *  购买失败，请重试
//     */
//    IAP_FILEDCOED_BUYFILED = 2004,
//    /**
//     *  用户取消交易
//     */
//    IAP_FILEDCOED_USERCANCEL = 2005,
//    /**
//     *  付款参数错误
//     */
//    IAP_FILEDCOED_PaymentInvalid = 2006,
//    /**
//     *  不允许客户端执行操作
//     */
//    IAP_FILEDCOED_ClientInvalid = 2007,
//    /**
//     *  不允许用户授权付款
//     */
//    IAP_FILEDCOED_NotAllowed = 2008,
	
	/*
	 * {  
		  "status": 0,  
		  "environment": "Sandbox",  
		  "receipt": {  
		    "receipt_type": "ProductionSandbox",  
		    "adam_id": 0,  
		    "app_item_id": 0,  
		    "bundle_id": "com.platomix.MicroBusinessManage",  
		    "application_version": "2.0.0",  
		    "download_id": 0,  
		    "version_external_identifier": 0,  
		    "receipt_creation_date": "2017-06-06 06:35:27 Etc/GMT",  
		    "receipt_creation_date_ms": "1496730927000",  
		    "receipt_creation_date_pst": "2017-06-05 23:35:27 America/Los_Angeles",  
		    "request_date": "2017-06-06 07:13:26 Etc/GMT",  
		    "request_date_ms": "1496733206549",  
		    "request_date_pst": "2017-06-06 00:13:26 America/Los_Angeles",  
		    "original_purchase_date": "2013-08-01 07:00:00 Etc/GMT",  
		    "original_purchase_date_ms": "1375340400000",  
		    "original_purchase_date_pst": "2013-08-01 00:00:00 America/Los_Angeles",  
		    "original_application_version": "1.0",  
		    "in_app": []  
		 }
		}
	 */
	@Override
	public void fillOnNotify(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception {
		String receipt = request.getParam("receipt");
		if (StrUtil.isBlank(receipt)) {
			String status = request.getParam("status");
			rechargeItem.setRemark("收到回调,但没有receipt值,回调原状态：" +  status);
//			rechargeItem.setStatus(RechargeItem.Status.CANCELED);
//			rechargeItem.setThirdstatus(status);
			return;
		}
		try {
			ReceiptResult result = IosVerify.verifyReceipt(request, receipt, rechargeItem);
			rechargeItem.setReceipt(receipt);
			Integer status = result.getStatus();
			rechargeItem.setThirdstatus(status + "");
			
			if (Objects.equals(status, 0)) {
				RechargeItem rechargeItem_1 = RechargeItemService.me.selectByReceipt(receipt, rechargeItem.getId());
				if (rechargeItem_1 != null /*&& (!Objects.equals(rechargeItem_1.getId(), rechargeItem.getId())) */) {
					log.error("receipt重复,\r\n原RechargeItem\r\n{}\r\n现RechargeItem\r\n{}", Json.toFormatedJson(rechargeItem_1), Json.toFormatedJson(rechargeItem));
					rechargeItem.setStatus(RechargeItem.Status.ATTACK);
				} else {
					rechargeItem.setStatus(RechargeItem.Status.SUCCESS);
				}
			} else {
				rechargeItem.setRemark("收到回调,但status并没有成功：" + status);
//				rechargeItem.setStatus(RechargeItem.Status.CANCELED);
			}
//			rechargeItem.setRemark(StringUtils.left(request.getHeaderString() + request.getBodyString(), 2048));
		} catch (Exception e1) {
			throw e1;
		}
	}

	@Override
	public HttpResponse notifySuccess(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception {
		Resp resp = Resp.ok();
		return Resps.json(request, resp);
	}

	@Override
	public HttpResponse notifyFail(HttpRequest request, RechargeItem rechargeItem, int callbackType) throws Exception {
		Resp resp = Resp.fail();
		return Resps.json(request, resp);
	}


	public static void main(String[] args) throws Exception {
		String receipt = "MIIT4gYJKoZIhvcNAQcCoIIT0zCCE88CAQExCzAJBgUrDgMCGgUAMIIDgwYJKoZIhvcNAQcBoIIDdASCA3AxggNsMAoCARQCAQEEAgwAMAsCAQ4CAQEEAwIBeDALAgEZAgEBBAMCAQMwDQIBCgIBAQQFFgMxNyswDQIBDQIBAQQFAgMBhqAwDgIBAQIBAQQGAgRQsF3ZMA4CAQkCAQEEBgIEUDI1MTAOAgELAgEBBAYCBAcXtpEwDgIBEAIBAQQGAgQxe1B1MBACAQMCAQEECAwGMS4yLjE3MBACAQ8CAQEECAIGVJzNex4bMBACARMCAQEECAwGMS4xLjIwMBQCAQACAQEEDAwKUHJvZHVjdGlvbjAYAgECAgEBBBAMDmNvbS5uYjM1MC5uYnliMBgCAQQCAQIEEOyLnSrJvyHJHsFVirjV7BowHAIBBQIBAQQUIUkX0Cmzp744oATWR68tUktxoSIwHgIBCAIBAQQWFhQyMDE5LTAyLTIxVDExOjU0OjQ2WjAeAgEMAgEBBBYWFDIwMTktMDItMjFUMTE6NTQ6NDZaMB4CARICAQEEFhYUMjAxOC0wOS0xMFQxMjowNjoxNVowPgIBBwIBAQQ2Q7FuIxDp4xjNBAMGvQxTkwfFmq7zXwciYYUxpNrhE%2B2gQXVmjRIawfekTlNr0a6Y/h0z25NGMEsCAQYCAQEEQ11HjqSpjQW2iVdAsWoEkuS9l3kR2KIwJ7PmG/VxFg7vx0CmPUVjogoAPMwc92Vctlsl/99oweNynb8WDDJ96ZgGXKwwggFZAgERAgEBBIIBTzGCAUswCwICBqwCAQEEAhYAMAsCAgatAgEBBAIMADALAgIGsAIBAQQCFgAwCwICBrICAQEEAgwAMAsCAgazAgEBBAIMADALAgIGtAIBAQQCDAAwCwICBrUCAQEEAgwAMAsCAga2AgEBBAIMADAMAgIGpQIBAQQDAgEBMAwCAgarAgEBBAMCAQEwDAICBq8CAQEEAwIBADAMAgIGsQIBAQQDAgEAMA8CAgauAgEBBAYCBFYKuAIwGgICBqcCAQEEEQwPNTMwMDAwNDAxODA4NTEyMBoCAgapAgEBBBEMDzUzMDAwMDQwMTgwODUxMjAeAgIGpgIBAQQVDBNjb20ubmIzNTAubmJ5Yi43NTYwMB8CAgaoAgEBBBYWFDIwMTktMDItMjFUMTE6NTM6MjNaMB8CAgaqAgEBBBYWFDIwMTktMDItMjFUMTE6NTM6MjNaoIIOZTCCBXwwggRkoAMCAQICCA7rV4fnngmNMA0GCSqGSIb3DQEBBQUAMIGWMQswCQYDVQQGEwJVUzETMBEGA1UECgwKQXBwbGUgSW5jLjEsMCoGA1UECwwjQXBwbGUgV29ybGR3aWRlIERldmVsb3BlciBSZWxhdGlvbnMxRDBCBgNVBAMMO0FwcGxlIFdvcmxkd2lkZSBEZXZlbG9wZXIgUmVsYXRpb25zIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MB4XDTE1MTExMzAyMTUwOVoXDTIzMDIwNzIxNDg0N1owgYkxNzA1BgNVBAMMLk1hYyBBcHAgU3RvcmUgYW5kIGlUdW5lcyBTdG9yZSBSZWNlaXB0IFNpZ25pbmcxLDAqBgNVBAsMI0FwcGxlIFdvcmxkd2lkZSBEZXZlbG9wZXIgUmVsYXRpb25zMRMwEQYDVQQKDApBcHBsZSBJbmMuMQswCQYDVQQGEwJVUzCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKXPgf0looFb1oftI9ozHI7iI8ClxCbLPcaf7EoNVYb/pALXl8o5VG19f7JUGJ3ELFJxjmR7gs6JuknWCOW0iHHPP1tGLsbEHbgDqViiBD4heNXbt9COEo2DTFsqaDeTwvK9HsTSoQxKWFKrEuPt3R%2BYFZA1LcLMEsqNSIH3WHhUa%2BiMMTYfSgYMR1TzN5C4spKJfV%2BkhUrhwJzguqS7gpdj9CuTwf0%2Bb8rB9Typj1IawCUKdg7e/pn%2B/8Jr9VterHNRSQhWicxDkMyOgQLQoJe2XLGhaWmHkBBoJiY5uB0Qc7AKXcVz0N92O9gt2Yge4%2BwHz%2BKO0NP6JlWB7%2BIDSSMCAwEAAaOCAdcwggHTMD8GCCsGAQUFBwEBBDMwMTAvBggrBgEFBQcwAYYjaHR0cDovL29jc3AuYXBwbGUuY29tL29jc3AwMy13d2RyMDQwHQYDVR0OBBYEFJGknPzEdrefoIr0TfWPNl3tKwSFMAwGA1UdEwEB/wQCMAAwHwYDVR0jBBgwFoAUiCcXCam2GGCL7Ou69kdZxVJUo7cwggEeBgNVHSAEggEVMIIBETCCAQ0GCiqGSIb3Y2QFBgEwgf4wgcMGCCsGAQUFBwICMIG2DIGzUmVsaWFuY2Ugb24gdGhpcyBjZXJ0aWZpY2F0ZSBieSBhbnkgcGFydHkgYXNzdW1lcyBhY2NlcHRhbmNlIG9mIHRoZSB0aGVuIGFwcGxpY2FibGUgc3RhbmRhcmQgdGVybXMgYW5kIGNvbmRpdGlvbnMgb2YgdXNlLCBjZXJ0aWZpY2F0ZSBwb2xpY3kgYW5kIGNlcnRpZmljYXRpb24gcHJhY3RpY2Ugc3RhdGVtZW50cy4wNgYIKwYBBQUHAgEWKmh0dHA6Ly93d3cuYXBwbGUuY29tL2NlcnRpZmljYXRlYXV0aG9yaXR5LzAOBgNVHQ8BAf8EBAMCB4AwEAYKKoZIhvdjZAYLAQQCBQAwDQYJKoZIhvcNAQEFBQADggEBAA2mG9MuPeNbKwduQpZs0%2BiMQzCCX%2BBc0Y2%2BvQ%2B9GvwlktuMhcOAWd/j4tcuBRSsDdu2uP78NS58y60Xa45/H%2BR3ubFnlbQTXqYZhnb4WiCV52OMD3P86O3GH66Z%2BGVIXKDgKDrAEDctuaAEOR9zucgF/fLefxoqKm4rAfygIFzZ630npjP49ZjgvkTbsUxn/G4KT8niBqjSl/OnjmtRolqEdWXRFgRi48Ff9Qipz2jZkgDJwYyz%2BI0AZLpYYMB8r491ymm5WyrWHWhumEL1TKc3GZvMOxx6GUPzo22/SGAGDDaSK%2BzeGLUR2i0j0I78oGmcFxuegHs5R0UwYS/HE6gwggQiMIIDCqADAgECAggB3rzEOW2gEDANBgkqhkiG9w0BAQUFADBiMQswCQYDVQQGEwJVUzETMBEGA1UEChMKQXBwbGUgSW5jLjEmMCQGA1UECxMdQXBwbGUgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkxFjAUBgNVBAMTDUFwcGxlIFJvb3QgQ0EwHhcNMTMwMjA3MjE0ODQ3WhcNMjMwMjA3MjE0ODQ3WjCBljELMAkGA1UEBhMCVVMxEzARBgNVBAoMCkFwcGxlIEluYy4xLDAqBgNVBAsMI0FwcGxlIFdvcmxkd2lkZSBEZXZlbG9wZXIgUmVsYXRpb25zMUQwQgYDVQQDDDtBcHBsZSBXb3JsZHdpZGUgRGV2ZWxvcGVyIFJlbGF0aW9ucyBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAMo4VKbLVqrIJDlI6Yzu7F%2B4fyaRvDRTes58Y4Bhd2RepQcjtjn%2BUC0VVlhwLX7EbsFKhT4v8N6EGqFXya97GP9q%2BhUSSRUIGayq2yoy7ZZjaFIVPYyK7L9rGJXgA6wBfZcFZ84OhZU3au0Jtq5nzVFkn8Zc0bxXbmc1gHY2pIeBbjiP2CsVTnsl2Fq/ToPBjdKT1RpxtWCcnTNOVfkSWAyGuBYNweV3RY1QSLorLeSUheHoxJ3GaKWwo/xnfnC6AllLd0KRObn1zeFM78A7SIym5SFd/Wpqu6cWNWDS5q3zRinJ6MOL6XnAamFnFbLw/eVovGJfbs%2BZ3e8bY/6SZasCAwEAAaOBpjCBozAdBgNVHQ4EFgQUiCcXCam2GGCL7Ou69kdZxVJUo7cwDwYDVR0TAQH/BAUwAwEB/zAfBgNVHSMEGDAWgBQr0GlHlHYJ/vRrjS5ApvdHTX8IXjAuBgNVHR8EJzAlMCOgIaAfhh1odHRwOi8vY3JsLmFwcGxlLmNvbS9yb290LmNybDAOBgNVHQ8BAf8EBAMCAYYwEAYKKoZIhvdjZAYCAQQCBQAwDQYJKoZIhvcNAQEFBQADggEBAE/P71m%2BLPWybC%2BP7hOHMugFNahui33JaQy52Re8dyzUZ%2BL9mm06WVzfgwG9sq4qYXKxr83DRTCPo4MNzh1HtPGTiqN0m6TDmHKHOz6vRQuSVLkyu5AYU2sKThC22R1QbCGAColOV4xrWzw9pv3e9w0jHQtKJoc/upGSTKQZEhltV/V6WId7aIrkhoxK6%2BJJFKql3VUAqa67SzCu4aCxvCmA5gl35b40ogHKf9ziCuY7uLvsumKV8wVjQYLNDzsdTJWk26v5yZXpT%2BRN5yaZgem8%2BbQp0gF6ZuEujPYhisX4eOGBrr/TkJ2prfOv/TgalmcwHFGlXOxxioK0bA8MFR8wggS7MIIDo6ADAgECAgECMA0GCSqGSIb3DQEBBQUAMGIxCzAJBgNVBAYTAlVTMRMwEQYDVQQKEwpBcHBsZSBJbmMuMSYwJAYDVQQLEx1BcHBsZSBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEWMBQGA1UEAxMNQXBwbGUgUm9vdCBDQTAeFw0wNjA0MjUyMTQwMzZaFw0zNTAyMDkyMTQwMzZaMGIxCzAJBgNVBAYTAlVTMRMwEQYDVQQKEwpBcHBsZSBJbmMuMSYwJAYDVQQLEx1BcHBsZSBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEWMBQGA1UEAxMNQXBwbGUgUm9vdCBDQTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAOSRqQkfkdseR1DrBe1eeYQt6zaiV0xV7IsZid75S2z1B6siMALoGD74UAnTf0GomPnRymacJGsR0KO75Bsqwx%2BVnnoMpEeLW9QWNzPLxA9NzhRp0ckZcvVdDtV/X5vyJQO6VY9NXQ3xZDUjFUsVWR2zlPf2nJ7PULrBWFBnjwi0IPfLrCwgb3C2PwEwjLdDzw%2BdPfMrSSgayP7OtbkO2V4c1ss9tTqt9A8OAJILsSEWLnTVPA3bYharo3GSR1NVwa8vQbP4%2B%2BNwzeajTEV%2BH0xrUJZBicR0YgsQg0GHM4qBsTBY7FoEMoxos48d3mVz/2deZbxJ2HafMxRloXeUyS0CAwEAAaOCAXowggF2MA4GA1UdDwEB/wQEAwIBBjAPBgNVHRMBAf8EBTADAQH/MB0GA1UdDgQWBBQr0GlHlHYJ/vRrjS5ApvdHTX8IXjAfBgNVHSMEGDAWgBQr0GlHlHYJ/vRrjS5ApvdHTX8IXjCCAREGA1UdIASCAQgwggEEMIIBAAYJKoZIhvdjZAUBMIHyMCoGCCsGAQUFBwIBFh5odHRwczovL3d3dy5hcHBsZS5jb20vYXBwbGVjYS8wgcMGCCsGAQUFBwICMIG2GoGzUmVsaWFuY2Ugb24gdGhpcyBjZXJ0aWZpY2F0ZSBieSBhbnkgcGFydHkgYXNzdW1lcyBhY2NlcHRhbmNlIG9mIHRoZSB0aGVuIGFwcGxpY2FibGUgc3RhbmRhcmQgdGVybXMgYW5kIGNvbmRpdGlvbnMgb2YgdXNlLCBjZXJ0aWZpY2F0ZSBwb2xpY3kgYW5kIGNlcnRpZmljYXRpb24gcHJhY3RpY2Ugc3RhdGVtZW50cy4wDQYJKoZIhvcNAQEFBQADggEBAFw2mUwteLftjJvc83eb8nbSdzBPwR%2BFg4UbmT1HN/Kpm0COLNSxkBLYvvRzm%2B7SZA/LeU802KI%2B%2BXj/a8gH7H05g4tTINM4xLG/mk8Ka/8r/FmnBQl8F0BWER5007eLIztHo9VvJOLr0bdw3w9F4SfK8W147ee1Fxeo3H4iNcol1dkP1mvUoiQjEfehrI9zgWDGG1sJL5Ky%2BERI8GA4nhX1PSZnIIozavcNgs/e66Mv%2BVNqW2TAYzN39zoHLFbr2g8hDtq6cxlPtdk2f8GHVdmnmbkyQvvY1XGefqFStxu9k0IkEirHDx22TZxeY8hLgBdQqorV2uT80AkHN7B1dSExggHLMIIBxwIBATCBozCBljELMAkGA1UEBhMCVVMxEzARBgNVBAoMCkFwcGxlIEluYy4xLDAqBgNVBAsMI0FwcGxlIFdvcmxkd2lkZSBEZXZlbG9wZXIgUmVsYXRpb25zMUQwQgYDVQQDDDtBcHBsZSBXb3JsZHdpZGUgRGV2ZWxvcGVyIFJlbGF0aW9ucyBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eQIIDutXh%2BeeCY0wCQYFKw4DAhoFADANBgkqhkiG9w0BAQEFAASCAQBZVNuDS9tjBGr0v1iy37XQPLsNtQpdskkbaJOVm%2BRbS/wrwoowuOseOAChQMi0nO%2BPMz63As3vsqrxJom66970j94QscZZ%2BmtDDxcvKI2jY/VnXasHN3X10vp7NuLw5hH%2B7h8EnpCaasK3yNvOWd7AdwET3MHtJMnrLzRp5SpsYcH41/q%2BaJuWdodzRua0%2BDYXomlOXmfXRz62VspFnSWamb81U%2BG00KPdRTRXK4Paehj9pjiSkvXuZHPZf2zNvMWCvVSl9luyMBhLDoC4mpThiUse4TV7B1hUEcYG604XS90QlLYpCKjktoPerIr0oOHZbuu/YgUa7ZeJhdze1rCP";
		String tradeno = "35925QhTQk190726163702082";

		String key = "iolkhtgf";//P.get("ios.pay.key", "iolkhtgf");
		String appVersion = "1.2.9";

		String url = "https://www.nb350.com/i.html?tio_path=/recharge/nf/33";
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("host", "www.nb350.com");
		headerMap.put("tio-appversion", appVersion);

		receipt = URLDecoder.decode(receipt, "utf-8");
		String str = receipt + tradeno + key + appVersion;
		String mysign = Md5.getMD5(str);

		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("tradeno", tradeno);
		paramMap.put("status", "0");
		paramMap.put("sign", mysign);
		paramMap.put("receipt", receipt);

		//		paramMap.put("tio_path", "/recharge/nf/33");

		Response response = HttpUtils.post(url, headerMap, paramMap);

		String body = response.body().string();
		Headers headers = response.headers();
		String cookie = headers.get("Set-Cookie");
		System.out.println(body);
		System.out.println(cookie);

	}
}
