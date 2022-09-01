/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.utils;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.utils.SystemTimer;
import org.tio.utils.crypto.Md5;
import org.tio.utils.jfinal.P;
import org.tio.utils.json.Json;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.live.model.v20161101.DescribeLiveStreamOnlineUserNumRequest;
import com.aliyuncs.live.model.v20161101.DescribeLiveStreamOnlineUserNumResponse;
import com.aliyuncs.live.model.v20161101.DescribeLiveStreamRecordIndexFilesRequest;
import com.aliyuncs.live.model.v20161101.DescribeLiveStreamRecordIndexFilesResponse;
import com.aliyuncs.live.model.v20161101.DescribeLiveStreamSnapshotInfoRequest;
import com.aliyuncs.live.model.v20161101.DescribeLiveStreamSnapshotInfoResponse;
import com.aliyuncs.live.model.v20161101.DescribeLiveStreamsFrameRateAndBitRateDataRequest;
import com.aliyuncs.live.model.v20161101.DescribeLiveStreamsFrameRateAndBitRateDataResponse;
import com.aliyuncs.live.model.v20161101.DescribeLiveStreamsOnlineListRequest;
import com.aliyuncs.live.model.v20161101.DescribeLiveStreamsOnlineListResponse;
import com.aliyuncs.live.model.v20161101.ForbidLiveStreamRequest;
import com.aliyuncs.live.model.v20161101.ForbidLiveStreamResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import cn.hutool.core.date.DateUtil;

/**
 * 转码文档：https://help.aliyun.com/document_detail/51229.html?spm=a2c4g.11186623.2.11.6fb34c07o68EJr
 * 转码：直播域名 + AppName + StreamName + _转码模板 ID
 * 	模板\规格	流畅	标清	高清	超清
	原画	      无	 无	无	无
	标准模板	lld	lsd	lhd	lud
	窄带高清™ 模板	ld	sd	hd	ud
 * @author tanyaowu 
 * 2016年9月21日 下午1:38:31
 */
public class AliLiveUtils {
	private static Logger log = LoggerFactory.getLogger(AliLiveUtils.class);

	/**
	 * 
	 * @author: tanyaowu
	 */
	public AliLiveUtils() {
	}

	/**
	 * 创建推流地址的auth_key
	 * @param currtime 当前时间，单位：毫秒
	 * @param timeout 超时时间，单位：秒
	 * @param streamname 随机生成的唯一串
	 * @return
	 * @author: tanyaowu
	 */
	public static String createPublishAuthKey(long currtime, long timeout, String streamname) {
		//		rtmp://video-center.alivecdn.com/nb/\
		return createAuthKey(currtime, timeout, streamname, "");
	}

	/**
	 * 创建rtmp的拉流地址的auth_key值
	 * @param currtime 当前时间，单位：毫秒
	 * @param timeout 超时时间，单位：秒
	 * @param streamname
	 * @return
	 * @author: tanyaowu
	 */
	public static String createPullRtmpAuthKey(long currtime, long timeout, String streamname) {
		//rtmp://live.t-io.org/nb/12?auth_key=1506059050-0-0-dc7b674828231b6db6cfa7283f93c80b
		return createAuthKey(currtime, timeout, streamname, "");
	}

	/**
	 * 创建flv的拉流地址的auth_key值
	 * @param currtime 当前时间，单位：毫秒
	 * @param timeout 超时时间，单位：秒
	 * @param streamname
	 * @return
	 * @author: tanyaowu
	 */
	public static String createPullFlvAuthKey(long currtime, long timeout, String streamname) {
		//http://live.t-io.org/nb/12.flv?auth_key=1506059050-0-0-710925642dde56f01740054181bcac91
		return createAuthKey(currtime, timeout, streamname, ".flv");
	}

	/**
	 * 超清
	 * @param currtime
	 * @param timeout
	 * @param streamname
	 * @return
	 * @author tanyaowu
	 */
	public static String createPullFlvUdAuthKey(long currtime, long timeout, String streamname) {
		//http://live.t-io.org/nb/12.flv?auth_key=1506059050-0-0-710925642dde56f01740054181bcac91
		return createAuthKey(currtime, timeout, streamname, "_lud.flv");
	}

	/**
	 * 高清
	 * @param currtime
	 * @param timeout
	 * @param streamname
	 * @return
	 * @author tanyaowu
	 */
	public static String createPullFlvHdAuthKey(long currtime, long timeout, String streamname) {
		//http://live.t-io.org/nb/12.flv?auth_key=1506059050-0-0-710925642dde56f01740054181bcac91
		return createAuthKey(currtime, timeout, streamname, "_lhd.flv");
	}

	/**
	 * 标清
	 * @param currtime
	 * @param timeout
	 * @param streamname
	 * @return
	 * @author tanyaowu
	 */
	public static String createPullFlvSdAuthKey(long currtime, long timeout, String streamname) {
		//http://live.t-io.org/nb/12.flv?auth_key=1506059050-0-0-710925642dde56f01740054181bcac91
		return createAuthKey(currtime, timeout, streamname, "_lsd.flv");
	}

	/**
	 * 流畅
	 * @param currtime
	 * @param timeout
	 * @param streamname
	 * @return
	 * @author tanyaowu
	 */
	public static String createPullFlvLdAuthKey(long currtime, long timeout, String streamname) {
		//http://live.t-io.org/nb/12.flv?auth_key=1506059050-0-0-710925642dde56f01740054181bcac91
		return createAuthKey(currtime, timeout, streamname, "_lld.flv");
	}

	/**
	 * 创建m3u8的拉流地址的auth_key值
	 * @param currtime 当前时间，单位：毫秒
	 * @param timeout 超时时间，单位：秒
	 * @param streamname
	 * @return
	 * @author: tanyaowu
	 */
	public static String createPullM3u8AuthKey(long currtime, long timeout, String streamname) {
		//http://live.t-io.org/nb/12.m3u8?auth_key=1506059050-0-0-7710084e689d5686041bf7740c05dad3
		return createAuthKey(currtime, timeout, streamname, ".m3u8");
	}

	/**
	 * 创建auth_key值
	 * @param currtime 当前时间，单位：毫秒
	 * @param streamname
	 * @param timeout 超时时间，单位：秒
	 * @param suffix
	 * @return
	 * @author: tanyaowu
	 */
	public static String createAuthKey(long currtime, long timeout, String streamname, String suffix) {
		String appname = Const.AliLive.APPNAME;
		long time = new Date(currtime / 1000 + timeout).getTime();
		String authkey1 = P.get("ali.live.authkey.1", Const.AliLive.AUTHKEY1);
		//		String domainName = P.get("ali.live.domainName", DEFAULT_DOMAINNAME);
		String initStr = "/" + appname + "/" + streamname + suffix + "-" + time + "-0-0-" + authkey1;
		String ret = time + "-0-0-" + Md5.getMD5(initStr);

		return ret;
	}

	/**
	 * @param args
	 * @author: tanyaowu
	 * @throws ClientException 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		org.tio.mg.service.init.PropInit.init();

		init();
		//		getRecordList("");

		//		String endTime = DateUtil.format(new Date(SystemTimer.currTime), format);
		//		System.out.println(endTime);
		//		String streamname = RandomUtil.randomString(12);// RandomStringUtil.randomAlphabetic(12);
		//		long currtime = SystemTimer.currTime;
		//		long timeout = P.getLong("ali.live.timeout", 600L);
		//		String ss = createPublishAuthKey(currtime, timeout, streamname);
		//		System.out.println(ss);
		//
		//		StreamInfo streamInfo = createStream(streamname);
		//		System.out.println(Json.toFormatedJson(streamInfo));

		//		DescribeLiveStreamsOnlineListResponse describeLiveStreamsOnlineListResponse  = getOnlineList();
		//		getOnlineUserNum();
		//		requestInitSample();
		//		invokeSample();

		//		List<LiveStreamSnapshotInfo>  streamInfoList = getSnapshot("31-vchqg7").getLiveStreamSnapshotInfoList();
		//		LiveStreamSnapshotInfo streamObject = streamInfoList.get(0);
		//		URL url = getObjectUrl(streamObject.getOssObject(),streamObject.getOssBucket(),1);
		//	
		//		log.info(Json.toJson(streamInfoList.get(0)));
	}

	private static IAcsClient client;

	public static void init() {
		String regionId = Const.AliLive.REGIONID;
		String accessKey = Const.AliLive.ACCESSKEY;
		String accessSecret = Const.AliLive.ACCESSSECRET;

		IClientProfile profile = DefaultProfile.getProfile(regionId, accessKey, accessSecret);
		//DefaultProfile.addEndpoint("cn-shanghai", "cn-shanghai", "live", "live.aliyuncs.com"); //添加自定义endpoint。
		client = new DefaultAcsClient(profile);
		//System.setProperty("http.proxyHost", "127.0.0.1"); //此设置用于设置代理，可用fiddler拦截查看http请求，便于调试。  
		//System.setProperty("http.proxyPort", "8888");
	}

	//	public static void requestInitSample() {
	//		DescribeLiveSnapshotConfigRequest describeLiveSnapshotConfigRequest = new DescribeLiveSnapshotConfigRequest();
	//		String domainName = P.get("ali.live.domainName", DEFAULT_DOMAINNAME);
	//		describeLiveSnapshotConfigRequest.setDomainName(domainName);
	//		//describeLiveSnapshotConfigRequest.setProtocol(ProtocolType.HTTPS); //指定访问协议
	//		describeLiveSnapshotConfigRequest.setAcceptFormat(FormatType.JSON); //指定api返回格式
	//		//describeLiveSnapshotConfigRequest.setMethod(MethodType.POST); //指定请求方法
	//		//describeLiveSnapshotConfigRequest.setRegionId("cn-shanghai");//指定要访问的Region,仅对当前请求生效，不改变client的默认设置。
	//		try {
	//			HttpResponse httpResponse = client.doAction(describeLiveSnapshotConfigRequest);
	//			System.out.println(httpResponse.getUrl());
	//			System.out.println(new String(httpResponse.getHttpContent()));
	//			//todo something.
	//		} catch (Throwable e) {
	//			log.error(e.toString(), e);
	//		}
	//	}

	/**
	 * 获取正在直播的列表
	 * 
	 * @author tanyaowu
	 */
	public static DescribeLiveStreamsOnlineListResponse getOnlineList() {
		DescribeLiveStreamsOnlineListRequest describeLiveStreamsOnlineListRequest = new DescribeLiveStreamsOnlineListRequest();

		describeLiveStreamsOnlineListRequest.setDomainName(Const.AliLive.DOMAINNAME);
		describeLiveStreamsOnlineListRequest.setAppName(Const.AliLive.APPNAME);
		describeLiveStreamsOnlineListRequest.setProtocol(ProtocolType.HTTPS); //指定访问协议
		describeLiveStreamsOnlineListRequest.setAcceptFormat(FormatType.JSON); //指定api返回格式
		describeLiveStreamsOnlineListRequest.setMethod(MethodType.POST); //指定请求方法
		describeLiveStreamsOnlineListRequest.setRegionId(Const.AliLive.REGIONID);//指定要访问的Region,仅对当前请求生效，不改变client的默认设置。
		try {
			DescribeLiveStreamsOnlineListResponse httpResponse = client.getAcsResponse(describeLiveStreamsOnlineListRequest);
			log.info(Json.toFormatedJson(httpResponse));
			return httpResponse;
		} catch (Throwable e) {
			log.error(e.toString(), e);
			return null;
		}
	}

	/**
	 * 查询录制索引文件
	 * 
	 * @author tanyaowu
	 */
	public static DescribeLiveStreamRecordIndexFilesResponse getRecordList(String streamname, Date startDate, Date endDate) {
		DescribeLiveStreamRecordIndexFilesRequest describeLiveStreamRecordIndexFilesRequest = new DescribeLiveStreamRecordIndexFilesRequest();
		SimpleDateFormat gmtFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		gmtFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		describeLiveStreamRecordIndexFilesRequest.setDomainName(Const.AliLive.DOMAINNAME);
		describeLiveStreamRecordIndexFilesRequest.setAppName(Const.AliLive.APPNAME);
		describeLiveStreamRecordIndexFilesRequest.setProtocol(ProtocolType.HTTPS); //指定访问协议
		describeLiveStreamRecordIndexFilesRequest.setAcceptFormat(FormatType.JSON); //指定api返回格式
		describeLiveStreamRecordIndexFilesRequest.setStreamName(streamname);
		describeLiveStreamRecordIndexFilesRequest.setOrder("asc");
		describeLiveStreamRecordIndexFilesRequest.setMethod(MethodType.POST); //指定请求方法
		describeLiveStreamRecordIndexFilesRequest.setRegionId(Const.AliLive.REGIONID);//指定要访问的Region,仅对当前请求生效，不改变client的默认设置。
		String startTime = gmtFormat.format(startDate);
		String endTime = gmtFormat.format(endDate);
		describeLiveStreamRecordIndexFilesRequest.setStartTime(startTime);
		describeLiveStreamRecordIndexFilesRequest.setEndTime(endTime);
		System.out.println(startTime);
		System.out.println(endTime);
		System.out.println(streamname);
		describeLiveStreamRecordIndexFilesRequest.setPageSize(20);
		try {
			DescribeLiveStreamRecordIndexFilesResponse httpResponse = client.getAcsResponse(describeLiveStreamRecordIndexFilesRequest);
			log.info(Json.toFormatedJson(httpResponse));
			return httpResponse;
		} catch (Throwable e) {
			log.error(e.toString(), e);
			return null;
		}
	}

	/**
	 * 查询在线人数
	 * @return
	 * @author tanyaowu
	 */
	public static DescribeLiveStreamOnlineUserNumResponse getOnlineUserNum(String streamname) {
		DescribeLiveStreamOnlineUserNumRequest describeLiveStreamOnlineUserNumRequest = new DescribeLiveStreamOnlineUserNumRequest();

		String domainName = Const.AliLive.DOMAINNAME;
		describeLiveStreamOnlineUserNumRequest.setDomainName(domainName);
		describeLiveStreamOnlineUserNumRequest.setAppName(Const.AliLive.APPNAME);
		describeLiveStreamOnlineUserNumRequest.setProtocol(ProtocolType.HTTPS); //指定访问协议
		describeLiveStreamOnlineUserNumRequest.setAcceptFormat(FormatType.JSON); //指定api返回格式
		describeLiveStreamOnlineUserNumRequest.setMethod(MethodType.POST); //指定请求方法
		describeLiveStreamOnlineUserNumRequest.setRegionId(Const.AliLive.REGIONID);//指定要访问的Region,仅对当前请求生效，不改变client的默认设置。
		describeLiveStreamOnlineUserNumRequest.setStreamName(streamname);

		try {
			DescribeLiveStreamOnlineUserNumResponse httpResponse = client.getAcsResponse(describeLiveStreamOnlineUserNumRequest);
			log.info(Json.toFormatedJson(httpResponse));
			return httpResponse;
		} catch (Throwable e) {
			log.error(e.toString(), e);
			return null;
		}
	}

	/**
	 * 查询直播流实时帧率和码率
	 * @param streamname
	 * @return
	 */
	public static DescribeLiveStreamsFrameRateAndBitRateDataResponse getFrameRateAndBitRateInfos(String streamname) {
		DescribeLiveStreamsFrameRateAndBitRateDataRequest describeLiveStreamsFrameRateAndBitRateDataRequest = new DescribeLiveStreamsFrameRateAndBitRateDataRequest();

		String domainName = Const.AliLive.DOMAINNAME;
		describeLiveStreamsFrameRateAndBitRateDataRequest.setDomainName(domainName);
		describeLiveStreamsFrameRateAndBitRateDataRequest.setAppName(Const.AliLive.APPNAME);
		describeLiveStreamsFrameRateAndBitRateDataRequest.setProtocol(ProtocolType.HTTPS); //指定访问协议
		describeLiveStreamsFrameRateAndBitRateDataRequest.setAcceptFormat(FormatType.JSON); //指定api返回格式
		describeLiveStreamsFrameRateAndBitRateDataRequest.setMethod(MethodType.POST); //指定请求方法
		describeLiveStreamsFrameRateAndBitRateDataRequest.setRegionId(Const.AliLive.REGIONID);//指定要访问的Region,仅对当前请求生效，不改变client的默认设置。
		describeLiveStreamsFrameRateAndBitRateDataRequest.setStreamName(streamname);

		try {
			DescribeLiveStreamsFrameRateAndBitRateDataResponse httpResponse = client.getAcsResponse(describeLiveStreamsFrameRateAndBitRateDataRequest);
			log.info(Json.toFormatedJson(httpResponse));
			return httpResponse;
		} catch (Throwable e) {
			log.error(e.toString(), e);
			return null;
		}
	}

	/**
	 *  Action	String	是	操作接口名，系统规定参数，取值：DescribeLiveStreamSnapshotInfo
		DomainName	String	是	您的播流域名
		AppName	String	是	直播流所属应用名称
		StreamName	String	是	直播流名称
		StartTime	String	是	开始时间，UTC时间，格式：2015-12-01T17:36:00Z
		EndTime	String	是	结束时间，UTC时间，格式：2015-12-01T17:36:00Z，EndTime和StartTime之间的间隔不能超过1天
		Limit	Integer	否	一次调用获取的数量，范围1~100，默认值：10
	 * 查询五分钟内视频截图
	 * @return
	 * @author tanyaowu
	 */
	public static DescribeLiveStreamSnapshotInfoResponse getSnapshot(String streamname) {
		String format = "yyyy-MM-dd'T'HH:mm:ss'Z'";

		DescribeLiveStreamSnapshotInfoRequest describeLiveStreamSnapshotInfoRequest = new DescribeLiveStreamSnapshotInfoRequest();

		describeLiveStreamSnapshotInfoRequest.setDomainName(Const.AliLive.DOMAINNAME);
		describeLiveStreamSnapshotInfoRequest.setAppName(Const.AliLive.APPNAME);
		describeLiveStreamSnapshotInfoRequest.setStreamName(streamname);

		describeLiveStreamSnapshotInfoRequest.setProtocol(ProtocolType.HTTPS); //指定访问协议
		describeLiveStreamSnapshotInfoRequest.setAcceptFormat(FormatType.JSON); //指定api返回格式
		describeLiveStreamSnapshotInfoRequest.setMethod(MethodType.GET); //指定请求方法
		describeLiveStreamSnapshotInfoRequest.setRegionId(Const.AliLive.REGIONID);//指定要访问的Region,仅对当前请求生效，不改变client的默认设置。

		String startTime = DateUtil.format(new Date(SystemTimer.currTime - 5 * 60 * 1000 - 8 * 3600 * 1000), format);
		String endTime = DateUtil.format(new Date(SystemTimer.currTime - 8 * 3600 * 1000), format);

		describeLiveStreamSnapshotInfoRequest.setStartTime(startTime);
		describeLiveStreamSnapshotInfoRequest.setEndTime(endTime);

		try {
			DescribeLiveStreamSnapshotInfoResponse httpResponse = client.getAcsResponse(describeLiveStreamSnapshotInfoRequest);
			if (log.isInfoEnabled()) {
				log.info("streamname:{}, response:{}", streamname, Json.toFormatedJson(httpResponse));
			}
			return httpResponse;
		} catch (Throwable e) {
			log.error(e.toString(), e);
			return null;
		}
	}

	/**
	 * @param ossObject oss内的文件地址
	 * @param ossBucket Bucketname
	 * 生成图片访问链接
	 * @return  objectUrl
	 * @author tanyaowu
	 */
	public static URL getObjectUrl(String ossObject, String ossBucket, Integer offsetMinute) {
		try {
			//			OSSClient ossClient = new OSSClient(OSS_ENDPOINT, OSS_ACCESS_KEY_ID, OSS_ACCESS_KEY_SECRET);
			CredentialsProvider credsProvider = new DefaultCredentialProvider(Const.AliOss.ACCESS_KEY_ID, Const.AliOss.ACCESS_KEY_SECRET);
			ClientConfiguration config = new ClientBuilderConfiguration();
			OSSClient ossClient = new OSSClient(Const.AliOss.ENDPOINT, credsProvider, config);

			URL objectUrl = ossClient.generatePresignedUrl(ossBucket, ossObject, new Date(SystemTimer.currTime + offsetMinute * 60 * 1000 + 8 * 3600 * 1000));
			ossClient.shutdown();
			log.info(Json.toJson(objectUrl));
			return objectUrl;
		} catch (Throwable e) {
			log.error(e.toString(), e);
			return null;
		}
	}

	/**
	 * 禁止推流
	 * @param streamName
	 * @return requestid
	 * @author tanyaowu
	 */
	public static ForbidLiveStreamResponse forbidLive(String streamName) {

		//		return null;

		ForbidLiveStreamRequest forbidLiveStreamRequest = new ForbidLiveStreamRequest();

		forbidLiveStreamRequest.setDomainName(Const.AliLive.DOMAINNAME);
		forbidLiveStreamRequest.setAppName(Const.AliLive.APPNAME);
		forbidLiveStreamRequest.setProtocol(ProtocolType.HTTPS); //指定访问协议
		forbidLiveStreamRequest.setAcceptFormat(FormatType.JSON); //指定api返回格式
		forbidLiveStreamRequest.setMethod(MethodType.POST); //指定请求方法
		forbidLiveStreamRequest.setRegionId(Const.AliLive.REGIONID);//指定要访问的Region,仅对当前请求生效，不改变client的默认设置。
		forbidLiveStreamRequest.setStreamName(streamName);
		forbidLiveStreamRequest.setLiveStreamType("publisher");
		try {
			ForbidLiveStreamResponse httpResponse = client.getAcsResponse(forbidLiveStreamRequest);
			return httpResponse;
		} catch (Throwable e) {
			log.error(e.toString(), e);
			return null;
		}
	}

	//	public static void invokeSample() {
	//		DescribeLiveSnapshotConfigRequest describeLiveSnapshotConfigRequest = new DescribeLiveSnapshotConfigRequest();
	//		String domainName = P.get("ali.live.domainName", DEFAULT_DOMAINNAME);
	//		describeLiveSnapshotConfigRequest.setDomainName(domainName);
	//		describeLiveSnapshotConfigRequest.setAcceptFormat(FormatType.JSON); //指定api返回格式
	//
	//		try {
	//			HttpResponse httpResponse = client.doAction(describeLiveSnapshotConfigRequest);
	//			System.out.println(httpResponse.getUrl());
	//			System.out.println(new String(httpResponse.getHttpContent()));
	//			//todo something else.
	//		} catch (ServerException e) {
	//			e.printStackTrace();
	//		} catch (ClientException e) {
	//			e.printStackTrace();
	//		}
	//	}
}
