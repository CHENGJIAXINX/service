/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.servicecommon.vo;

import java.util.Objects;

import org.tio.utils.jfinal.P;
import org.tio.utils.time.Time;

import cn.hutool.core.util.StrUtil;

/**
 * @author tanyaowu 
 * 2016年9月19日 下午5:04:12
 */
public class Const {

	/**
	 * 特殊字符
	 */
	public static final char[]	SPECIAL_CHARACTER		= new char[] { '<', '>', '\"', '\'', '\\', '/', '~', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '[',
	        ']', '{', '}', '＠', '￥', ' ', '	' };
	/**
	 * 握手签名时的key
	 */
	public static final String	HANDSHAKE_KEY			= P.get("app.handshake.key","ufDoiDnj");
	public static final String	CHARSET					= "utf-8";
	/**
	 * 在ChannelContext存放ImSessionContext对象的key
	 */
	public static final String	IM_SESSION_KEY			= "im_session_key";
	/**
	 * IM心跳超时时间，单位：毫秒
	 */
	public static final long	IM_HEARTBEAT_TIMEOUT	= P.getLong("im.heartbeat.timeout", 120 * 1000L);
	
	
	/**
	 * 焦点刷新时间-毫秒
	 */
	public static final int  	FOCUS_REFRESH_TIMEOUT	= P.getInt("focus.refresh.timeout", 20000);
	
	/**
	 * 用来做测试的groupid，随时会变和被取消
	 */
	public static final String	TEST_GROUPID			= "45";
	/**
	 * 上传资源服务器存放上传文件的根目录
	 */
	public static final String	RES_ROOT				= P.get("res.root");
	/**
	 * 服务器的IP地址或域名
	 */
	public static final String	MY_IP_API					= P.get("my.ip.api");
	public static final String	MY_IP_APP					= P.get("my.ip.app");
	public static final String	MY_IP_WEB					= P.get("my.ip.web");

	public static final int UID_LEN = P.getInt("uid.len", 8);

	/**
	 * 是否使用tio集群
	 * true : 使用集群
	 * false : 不使用
	 */
	public static final boolean	USE_TIO_CLU				= P.getBoolean("use.tio.clu", false);

	/**
	 * 新版同步标识
	 */
	public static final boolean SYN_NEW_VERSION = P.getBoolean("syn.newversion.flag", false);

	//
	public static final boolean MILSERVER = P.getBoolean("milserver", true);

	public static final String CURR_LAU = P.get("curr_lau", "cn");


	/**
	 * 敏感词过滤开关
	 */
//	public static final boolean SENSITIVE_FLAG = P.getBoolean("sensitive.flag", false);
	public static final String SENSITIVE_FLAG = "sensitive.flag";

	/**
	 * 焦点高性能开关
	 */
//	public static final boolean MSG_READ_FOCUS_FLAG = P.getBoolean("msg.read.focus.flag", false);
	public static final String MSG_READ_FOCUS_FLAG = "msg.read.focus.flag";


	/**
	 * 上传资源服务器
	 */
	public static final String RES_SERVER = P.get("res.server");

	/**
	  *   阿里惠普TTF字体路径
	 */
	public static final String MEDIUM_FONT_TTF_FILE = P.get("medium.font.ttf.file");

	/**
	 * 用户头像自动生成背景图片路径
	 */
	public static final String USER_AVATAR_BASE_BACKGROUND_IMG = P.get("user.avatar.base.background.img");

	/**
	 * 用户生成头像字体字号
	 */
	public static final int USER_AVATAR_MEDIUM_FONT_SIZE = P.getInt("user.avatar.medium.font.size", 80);

	/**
	 * 是否用匿名系统
	 */
	public static final boolean USE_ANONYMOUS = Objects.equals(P.getInt("use.anonymous", 2), 1);

	/**
	 * 是否开启自动生成头像：默认不开启
	 */
	public static final boolean USE_AUTO_AVATAR = Objects.equals(P.getInt("use.auto.avatar", 2), 1);
//	public static final String USE_AUTO_AVATAR = "use.auto.avatar";

	/**
	 * 是否启动im服务器
	 */
	public static final boolean	IS_START_IM					= P.getInt("start.im", 2) == 1;

	/**
	 * 是否于后台redis建立通知
	 */
	public static final boolean IS_REDIS_LINK_MG = P.getInt("redis.link.mg", 2) == 1;

	/**
	 * 是否启动了view服务器
	 */
	public static final boolean	IS_START_VIEW			= P.getInt("start.view", 1) == 1;
	
	/**
	 * 是否开启钱包功能
	 */
	public static final boolean	IS_OPEN_WALLET			= P.getBoolean("wallet.open.flag", false);
	
	/**
	 * 钱包商户号
	 */
	public static final String	WALLET_MERCHANTID				= P.get("wallet.merchantid","894420924");
	
	/**
	 * 分页查询时，第几页的参数名，统一用这个名字
	 */
	public static final String	PARAM_NAME_PAGENUMBER	= "pageNumber";
	/**
	 * 分页查询时，每页几条数据，统一用这个名字
	 */
	public static final String	PARAM_NAME_PAGESIZE		= "pageSize";

	/**
	 * 是否im和wx互通
	 */
	public static final boolean IM_CONNECT_WX = P.getInt("im.connect.wx", 1) == 1;

	/**
	 * 通道默认uid
	 */
	public static final Integer MSG_DEFAULT_UID = -1;

	/**
	 * im是否进行ssl认证
	 */
	public static final boolean IM_SSL_FLAG = StrUtil.isNotBlank(P.get("ssl.keystore.web"));

    public static interface BsToken{
    	public static  final  String TOKEN = "TioYanXunKeymqpad";
	};

    /**
	 * tio监控数据统计时段
	 * @author tanyaowu 
	 * 2016年10月30日 下午1:34:46
	 */
	public static interface IpStatDuration {
		public static final Long DURATION_1 = Time.MINUTE_1 * 2;
		//		public static final Long DURATION_2 = Time.MINUTE_1 * 10;
		//		public static final Long DURATION_3 = Time.HOUR_1 * 1;

		public static final Long[] IPSTAT_DURATIONS = new Long[] { DURATION_1/**, DURATION_2, DURATION_3 */
		};
	}


	/**
	 * im 群组的子群
	 * @author tanyaowu
	 *
	 */
	public static interface ImGroupType {

		String PREFIX = "_$x-_";

		/**
		 * 所有用户都加入这个组
		 */
		String ALL_IN_ONE = PREFIX + "_allinone";

		/**
		 * 真实用户
		 */
		String REAL = PREFIX + "_real_";

		/**
		 * 所有用户
		 */
		String ALL = PREFIX + "_";

		/**
		 * 绑定省
		 */
		String PROVINCE = PREFIX + "PROVINCE_";

		/**
		 * 绑定市
		 */
		String CITY = PREFIX + "CITY_";

		/**
		 * 运营商
		 */
		String OPERATOR = PREFIX + "OPERATOR_";
	}

	public static interface Protocol {
		String	IM_WS	= "ws";
		String	IM_APP	= "app";
	}

	/**
	 * ip访问路径统计
	 * @author tanyaowu 
	 * 2016年10月30日 下午1:34:29
	 */
	public static interface IpPathAccessStatDuration {
		//		public static final long DURATION_1 = Time.SECOND_1 * 10;
		public static final long DURATION_2 = Time.MINUTE_1 * 5;
		//		public static final long DURATION_3 = Time.HOUR_1 * 1;

		//		public static final Long[] IP_PATH_ACCESS_STAT_DURATIONS = new Long[] { DURATION_1 };
		public static final Long[] IP_PATH_ACCESS_STAT_DURATIONS = new Long[] { DURATION_2 };

	}

	public static interface TokenPathAccessStatDuration {
		//		public static final long DURATION_1 = Time.SECOND_1 * 10;
		public static final long DURATION_2 = Time.MINUTE_1 * 5;
		//		public static final long DURATION_3 = Time.HOUR_1 * 1;

		//		public static final Long[] IP_PATH_ACCESS_STAT_DURATIONS = new Long[] { DURATION_1 };
		public static final Long[] TOKEN_PATH_ACCESS_STAT_DURATIONS = new Long[] { DURATION_2 };

	}

	public static interface ImPort {
		/**
		 * pc端的端口(websocket的端口)
		 */
		public Integer	WS	= P.getInt("im.port.ws");
		/**
		 * app端的端口(安卓和ios的端口一样)
		 */
		public Integer	APP	= P.getInt("im.port.app");
	}

	/**
	 * 网站地址
	 */
	public static String SITE = P.get("site");

	/**
	 * 极光推送参数
	 * 
	 * @author xufei
	 * 2020年9月24日 上午10:23:14
	 */
	public static interface JPushConfig {

		/**
		 * 开启开关
		 */
//		boolean	OPENFLAG	= P.getBoolean("Jpush.open.flag", false);
		String	OPENFLAG	= "Jpush.open.flag";

		/**
		 * 
		 */
//		String	APPKEY		= P.get("JAppKey", "e09e4e97149a462165c976b7");
		String	APPKEY		= "JAppKey";

		/**
		 * 
		 */
//		String MASTERSECRET = P.get("JMasterSecret", "61068e3d5ca47b2288b8ab5e");
		String MASTERSECRET ="JMasterSecret";

	}

	/**
	 * 生产环境的网站地址
	 */
	public static String PRODUCT_SITE = P.get("product.site", "https://www.t-io.org");

	public static String API_CONTEXTPATH = P.get("http.api.contextpath", "/mytio");

	public static String API_SUFFIX = P.get("http.api.suffix", ".tio_x");

	public static interface Path {
		/**
		 * 登录页
		 */
		String LOGIN = "/login/index.html";

		/**
		 * 微信支付的path
		 */
		String WECHAT_PAY = "/recharge/wechatPay.html";


	}

	/**
	 * 百度资源
	 * @author tanyaowu
	 *
	 */
	public static interface BaiduZiyuan {
		/**
		 * 百度链接推送地址
		 */
		String PUSH_URL = "http://data.zz.baidu.com/urls?site=https://www.t-io.org&token=AYbJAHBEcjRSomPf";

		/**
		 * 百度链接更新地址
		 */
		String UPDATE_URL = "http://data.zz.baidu.com/update?site=https://www.t-io.org&token=AYbJAHBEcjRSomPf";

		/**
		 * 百度链接删除地址
		 */
		String DELETE_URL = "http://data.zz.baidu.com/del?site=https://www.t-io.org&token=AYbJAHBEcjRSomPf";

	}

	/**
	 * view层，公共model的key
	 * @author tanyaowu
	 */
	public static interface ModelKey {
		String	TITLE						= "title";
		String	KEYWORDS					= "keywords";
		String	DESCRIPTION					= "description";
		String	RES_SERVER					= "res_server";
		String	JS_VERSION					= "js_version";
		String	API_CONTEXTPATH				= "api_ctx";				//  "/api"
		String	API_SUFFIX					= "api_suf";				//  ".php"
		String	HTTP_SESSION_COOKIE_NAME	= "session_cookie_name";	// "TIO_SESSION"
		String	SITE_NAME					= "sitename";
		String	GOOGLE_AUTH					= "google_auth";
	}

	public static interface AliOss {
		/**
		 * 
		 */
		public static final String	ENDPOINT			= P.get("ali.oss.endpoint");
		/**
		 *accessKeyId  
		 */
		public static final String	ACCESS_KEY_ID		= P.get("ali.oss.AccessKeyID");
		/**
		 *accessKeySecret     
		 */
		public static final String	ACCESS_KEY_SECRET	= P.get("ali.oss.AccessKeySecret");

	}

	/**
	 * 阿里直播
	 * @author tanyaowu
	 *
	 */
	public static interface AliLive {
		/**
		 * url
		 */
		public static final String	URL				= P.get("ali.live.url");
		/**
		 * regionid
		 */
		public static final String	REGIONID		= P.get("ali.live.regionId");
		/**
		 * accesskey
		 */
		public static final String	ACCESSKEY		= P.get("ali.live.accessKey");
		/**
		 * accesssecret
		 */
		public static final String	ACCESSSECRET	= P.get("ali.live.accessSecret");
		/**
		 * domainname
		 */
		public static final String	DOMAINNAME		= P.get("ali.live.domainName");
		/**
		 * appname
		 */
		public static final String	APPNAME			= P.get("ali.live.appName");

		/**
		 * 
		 */
		public static final String AUTHKEY1 = P.get("ali.live.authkey.1");
	}

	/**
	 * 系统参数配置key值
	 * 
	 */
	public static interface ConfMapping {
		/**
		 * 人民币转换T币倍数.pc
		 */
		public String CNY_TO_COIN_TIME_PC = "cny.to.coin.time.pc";

		/**
		 * 人民币转换T币倍数.ios
		 */
		public String CNY_TO_COIN_TIME_IOS = "cny.to.coin.time.ios";

		/**
		 * 人民币充值经验倍数.标准
		 */
		public String CNY_TO_COIN_EXP_TIME_ST = "cny.to.coin.exp.time.st";

		/**
		 * 人民币充值经验倍数.ios
		 */
		public String CNY_TO_COIN_EXP_TIME_IOS = "cny.to.coin.exp.time.ios";

		/**
		 * 好友会话缩略最长字符 
		 */
		public String WX_FRIEND_MSG_RESUME_MAXSIZE = "wx.friend.msg.resume.maxsize";

		/**
		 * 好友历史消息分页条数
		 */
		public String WX_FRIEND_MSG_LIMIT = "wx.friend.msg.limit";

		/**
		 * 默认查询群聊的的历史记录条数
		 */
		public static final String WX_GROUP_MSG_LIMIT = "wx.group.msg.limit";

		/**
		 * 缩略消息默认长度
		 */
		static final String WX_GROUP_MSG_RESUME_MAXSIZE = "wx.group.msg.resume.maxsize";

		/**
		 * 群用户默认显示多少
		 */
		static final String WX_GROUP_USER_VIEW_DEFAULT = "wx.group.user.view.limit";

		/**
		 * 撤回的最大时间
		 */
		static final String WX_MSG_BACK_MAX_TIME = "wx.msg.back.max.time";

		/**
		 * 提现的最大金额
		 */
		static final String WX_WALLET_WITHHOLD_MAX_AMOUNT = "wx.wallet.withhold.max.amount";
		
		/**
		 * 提现的最大次数
		 */
		static final String WX_WALLET_WITHHOLD_MAX_COUNT = "wx.wallet.withhold.max.count";
		
		/**
		 * 提现的最小金额
		 */
		static final String WX_WALLET_WITHHOLD_MIN_AMOUT = "wx.wallet.withhold.min.amount";
		
		/**
		 * 提现的手续费
		 */
		static final String WX_WALLET_WITHHOLD_COMMISSION = "wx.wallet.withhold.commission";
		
		/**
		 * 提现的手续费常量
		 */
		static final String WX_WALLET_WITHHOLD_COMMISSION_CONST = "wx.wallet.withhold.commission.const";
		
		/**
		 * 提现超时时间
		 */
		static final String WX_WALLET_WITHHOLD_TIMEOUT = "wx.wallet.withhold.timeout";
		
		/**
		 * 充值的最大金额
		 */
		static final String WX_WALLET_RECHARGE_MAX_AMOUNT = "wx.wallet.recharge.max.amount";
		
		/**
		 * 充值超时时间
		 */
		static final String WX_WALLET_RECHARGE_TIMEOUT = "wx.wallet.recharge.timeout";
		
		/**
		 * 发送红包的最大金额
		 */
		static final String WX_WALLET_SENDREDPACKET_MAX_AMOUNT = "wx.wallet.sendredpacket.max.amount";
		
		/**
		 * 发红包超时时间
		 */
		static final String WX_WALLET_SENDREDPACKET_TIMEOUT = "wx.wallet.sendredpacket.timeout";
		
		/**
		 * 发红包支付超时时间
		 */
		static final String WX_WALLET_REDPACKET_PAY_TIMEOUT = "wx.wallet.redpacket.pay.timeout";
		
		/**
		 * 群发限速开关
		 */
		static final String WX_GROUP_MSG_SEND_LIMIT_OPEN = "wx.group.msg.send.limit.open";
	}

	/**
	 * 数据库名字常量
	 * @author tanyaowu 
	 * 2016年10月20日 下午4:04:51
	 */
	public static interface Db {
		/**
		 * tio_site_main数据库
		 */
		String	TIO_SITE_MAIN	= "tio_site_main";
		/**
		 * tio_site_stat数据库
		 */
		String	TIO_SITE_STAT	= "tio_site_stat";
		/**
		 * tio_site_conf数据库
		 */
		String	TIO_SITE_CONF	= "tio_site_conf";
		/**
		 * tio_mg数据库
		 */
		String	TIO_MG			= "tio_mg";
	}

	/**
	 * 历史表
	 * @author tanyw
	 *
	 */
	public static interface HistoryTable {
		/**
		 * 历史表后缀
		 */
		public static final String HISTORY_TABLE_SUFFIX = "_x_his";
	}

	/**
	 * 上传目录
	 * @author tanyaowu 
	 * 2016年12月22日 下午5:03:14
	 */
	public static interface UPLOAD_DIR {

		/**
		 * im上传视频的目录
		 */
		public static final String	IM_VIDEO		= "im/upload/video";
		/**
		 * im上传图片的目录
		 */
		public static final String	IM_IMG			= "im/upload/img";
		/**
		 * 群组头像上传
		 */
		public static final String	IM_GROUP_AVATAR	= "im/group/avatar";

		/**
		 * wx上传视频的目录
		 */
		public static final String WX_AUDIO = "wx/upload/audio";

		/**
		 * wx上传视频的目录
		 */
		public static final String WX_VIDEO = "wx/upload/video";

		/**
		 * wx上传图片的目录
		 */
		public static final String WX_IMG = "wx/upload/img";

		/**
		 * wx上传文件的目录
		 */
		public static final String WX_FILE = "wx/upload/file";

		/**
		 * wx群组头像上传
		 */
		public static final String WX_GROUP_AVATAR = "wx/group/avatar";

		/**
		 * blog上传图片的目录
		 */
		public static final String BLOG_IMG = "blog/upload/img";

		/**
		 * 用户上传头像的目录
		 */
		public static final String USER_AVATAR = "user/avatar";

		/**
		 *  自动生成头像的目录
		 */
		public static final String USER_BASE_AVATAR = "user/base/avatar";

		/**
		 * 案例上传
		 */
		public static final String CASE_IMG = "case/img";

		/**
		 * 招聘简历
		 */
		public static final String RECRUIT_RESUME = "tio/resume";

		/**
		 * 发票
		 */
		public static final String INVOICE = "tio/invoice";
		
		/**
		 * app错误日志
		 */
		public static final String APP_LOG_ERR = "app/log/err";

	}

	public static interface ZkNode {
		/**
		 * 根节点
		 */
		String ROOT = "/tio-site";

		/**
		 * IM服务器
		 * 该节点下的数据形如:<br>
		 * |--192.168.0.1<br>
		 * |--192.168.0.2<br>
		 * |--192.168.0.3<br>
		 */
		String IM_SERVERS = ROOT + "/im-server";

	}

	/**
	 * topic常量，前后台要一致
	 * @author tanyaowu 
	 * 2016年11月8日 下午4:16:25
	 */
	public static interface Topic {
		/**
		 * 通用topic
		 */
		String	COMMON_TOPIC		= "COMMON_TOPIC";
		/**
		 * 清除http cache
		 */
		String	CLEAR_HTTP_CACHE	= "CLEAR_HTTP_CACHE";
		/**
		 * 把ip拉黑
		 */
		String	PULL_IP_TO_BLACK	= "PULL_IP_TO_BLACK";
		/**
		 * web通知im系统发消息
		 */
		String	WEB_NTY_IM			= "WEB_NTY_IM";
		/**
		 * 清空html-view的缓存
		 */
		String	CLEAN_VIEW_CACHE	= "CLEAN_VIEW_CACHE";

		/**
		 * 后台通知系统发消息
		 */
		String MG_NTY_IM = "MG_NTY_IM";
	}


	/**
	 * 通用yes/no
	 */
	public static interface YesOrNo {
		/**
		 * 是
		 */
		byte YES = 1;

		/**
		 * 否
		 */
		byte NO = 2;
	}
	
	/**
	 * 群进入类型
	 * @author xufei
	 * 2021年1月13日 下午3:57:54
	 */
	public static interface GroupJoinMode {
		/**
		 * 是
		 */
		byte REVIEW = 1;

		/**
		 * 否
		 */
		byte NO_REVIEW = 2;
	}

	/**
	 * 申请状态
	 * @author xufei
	 * 2020年1月9日 下午2:50:54
	 */
	public static interface ApplyStatus {
		/**
		 *  通过
		 */
		byte PASS = 1;

		/**
		 * 申请中
		 */
		byte APPLY = 2;
		
		/**
		 * 无效：过期/拒绝
		 */
		byte INVALID = 3;
	}
	
	/**
	 * 消息是否是系统发出
	 * @author tanyaowu
	 */
	public static interface Sendbysys {
		/**
		 * 是
		 */
		byte YES = 1;

		/**
		 * 否
		 */
		byte NO = 2;
	}

	/**
	 * 标准状态常量
	 * 
	 */
	public static interface Status {
		/**
		 * 正常
		 */
		byte	NORMAL		= 1;
		/**
		 * 禁用/处理中
		 */
		byte	DISABLED	= 2;

		/**
		 * 删除
		 */
		byte DELETE = 3;
	}

	/**
	 * 标准处理状态
	 * 
	 * @date 2016年5月24日 下午4:13:26
	 */
	public static interface DealStatus {
		/**
		 * 正常
		 */
		byte NORMAL = 1;

		/**
		 * 处理中
		 */
		byte DEALING = 88;

		/**
		 * 完成
		 */
		byte FINISH = 3;
	}

	/**
	 * 
	 * @author: tanyaowu
	 */
	private Const() {
	}

	public static interface AccessToken {
		/**
		 * 存令牌(access_token)的cookie name
		 */
		public static final String COOKIENAME_FOR_ACCESSTOKEN = "tio_access_token";
	}

	/**
	 * 区域显示状态
	 * 
	 */
	public static interface AreaViewStatus {
		/**
		 * 显示
		 */
		byte VIEW = 1;

		/**
		 * 隐藏
		 */
		byte HIDDEN = 2;
	}

	/**
	 * 三方登录状态
	 * 
	 */
	public static interface UserThirdStatus {
		/**
		 * 正式
		 */
		byte NORMAL = 1;

		/**
		 * 初始化登录
		 */
		byte INIT = 2;
	}
	
	/**
	 * 性别
	 * @author xufei
	 * 2020年3月3日 下午6:32:53
	 */
	public static interface UserSex {
		/**
		 * 男
		 */
		byte MALE = 1;

		/**
		 * 女
		 */
		byte FEMALE = 2;

		/**
		 * 保密
		 */
		byte SECRET = 3;
	}

	/**
	 * 币种模式
	 * 
	 */
	public static interface CoinMode {
		/**
		 * T币
		 */
		byte COIN = 1;

		/**
		 * 人民币
		 */
		byte CNY = 3;

	}

	/**
	 * 财务收支状态
	 * 
	 */
	public static interface CoinFlag {
		/**
		 * 收入
		 */
		byte INCOME = 1;

		/**
		 * 支出
		 */
		byte PAY = 2;
	}

	/**
	 * 业务标准来源模型 
	 * 
	 */
	public static interface StandardMode {
		/**
		 * 充值
		 */
		byte RECHARGE = 1;
	}

	/**
	 * 该类定义的，单位都是秒
	 * @author tanyaowu
	 */
	public static class CacheTime {
		/**
		 * 60秒
		 */
		public static final long SECOND_60 = 60;
	}

	public static interface UrlParamName {
		/**
		 * 登录后重定向的地址
		 */
		String REDIRECT_URI_AFTER_LOGIN = "redirect_uri_after_login";
	}

	/**
	 * 一些固定的聊天群组
	 * @author tanyaowu
	 *
	 */
	public static interface GroupId {

		/**
		 * 全站聊天的groupid
		 */
		String ALL = "-1";
	}

	/**
	 * 一些内置的ChannelContextId
	 * @author tanyaowu
	 *
	 */
	public static interface ChannelContextId {

		/**
		 * 系统内置的ChannelContextId
		 */
		String SYSTEM = "1";
	}

	/**
	 * 群加人方式
	 * 
	 */
	//	public static interface GroupJoinMode {
	//		/**
	//		 *  群主邀请
	//		 */
	//		byte OWENSER_INVITE = 1;
	//
	//		/**
	//		 * 群主审核
	//		 */
	//		byte OWENSER_ADD = 2;
	//		
	//		/**
	//		 * 直接入群
	//		 */
	//		byte ALL_ADD = 3;
	//	}

	/**
	 * 聊天模型
	 * @author xufei
	 */
	public static interface ChatMode {
		/**
		 *  私聊
		 */
		byte P2P = 1;

		/**
		 * 群聊
		 */
		byte GROUP = 2;
	}

	/**
	 * 群角色
	 * @author xufei
	 * 2020年2月13日 下午4:34:29
	 */
	public static interface GroupRole {
		/**
		 * 群主
		 */
		byte OWNER = 1;

		/**
		 * 成员
		 */
		byte MEMBER = 2;

		/**
		 * 群管理员
		 */
		byte MANAGER = 3;
	}

	/**
	 * Im的人员操作码
	 * @author xufei
	 * 2020年1月17日 下午2:20:08
	 */
	public static interface WxUserOper {
		/**
		 * 删除聊天会话
		 */
		byte DEL_ITEM_REACT = 1;

		/**
		 * 拉黑消息
		 */
		byte BLACK = 2;

		/**
		 * 拉黑恢复消息
		 */
		byte REMOVE_BLACK = 3;

		/**
		 * 激活操作
		 */
		byte ACT = 4;

		/**
		 * 删除好友通知
		 */
		byte DEL_FRIEND = 5;

		/**
		 * 被删除好友通知
		 */
		byte TO_DEL_FRIEND = 6;

		/**
		 * 对方已读
		 */
		byte TO_READ = 7;

		/**
		 * 清空聊天记录
		 */
		byte CLEAR_CHAT_MSG = 8;

		/**
		 * 撤回消息
		 */
		byte BACK_MSG = 9;

		/**
		 * 删除消息
		 */
		byte DEL_MSG = 10;

		/**
		 * 隐藏会话(删除会话)：影响激活/已退群业务
		 */
		byte HIDE_CHAT = 11;

		/**
		 * 置顶操作
		 */
		byte CHAT_TOP = 21;

		/**
		 * 取消置顶操作
		 */
		byte CHAT_CANCEL_TOP = 22;

		/**
		 * 举报
		 */
		byte CHAT_REPORT = 99;
	}

	/**
	 * 同步类型
	 * @author xufei
	 * 2020年8月27日 下午2:37:17
	 */
	public static interface WxSynType {
		/**
		 * 会话同步
		 */
		byte CHAT = 1;

		/**
		 * 链接建立
		 */
		byte LINK_CREATE = 2;

		/**
		 * 客户端同步
		 */
		byte CLIENT_SYN = 3;

	}

	/**
	 * 文件icon类型
	 * @author xufei
	 * 2020年8月26日 下午4:12:08
	 */
	public static interface FileIconType {
		/**
		 * pdf
		 */
		byte PDF = 1;

		/**
		 * txt
		 */
		byte TXT = 2;

		/**
		 * doc
		 */
		byte DOC = 3;

		/**
		 * xls
		 */
		byte XLS = 4;

		/**
		 * ppt
		 */
		byte PPT = 5;

		/**
		 * apk
		 */
		byte APK = 6;

		/**
		 * 图片
		 */
		byte IMG = 7;

		/**
		 * 压缩包
		 */
		byte ZIP = 8;

		/**
		 * 视频
		 */
		byte VIDEO = 9;

		/**
		 * 音频
		 */
		byte AUDIO = 10;

		/**
		 * 其它
		 */
		byte OTHER = 11;

	}

	/**
	 * 聊天系统code
	 * @author xufei
	 * 2020年2月25日 下午9:55:52
	 */
	public static interface WxSysCode {
		/**
		 * 申请好友请求
		 */
		byte APPLY_REQUEST = 30;

		/**
		 * 好友发生变更-新增
		 */
		byte FRIEND_CHANGE_ADD = 31;

		/**
		 * 好友发生变更-减员
		 */
		byte FRIEND_CHANGE_DEL = 32;

		/**
		 * 好友发生变更-信息修改
		 */
		byte FRIEND_INFO_UPDATE = 33;

		/**
		 * 错误码
		 */
		byte ERROR_CODE = -100;
	}

	/**
	 * 群操作通知
	 * @author xufei
	 * 2020年2月24日 下午1:04:59
	 */
	public static interface WxGroupOper {
		/**
		 * 删除群
		 */
		byte DEL_GROUP = 1;

		/**
		 * 转让群-转让
		 */
		byte CHANGE_OUT_GROUP = 2;

		/**
		 * 接受群-转让
		 */
		byte CHANGE_IN_GROUP = 3;

		/**
		 * 群加入
		 */
		byte UPDATE_JOINNUM = 4;

		/**
		 * 退群
		 */
		byte LEAVE_GROUP = 5;

		/**
		 * 被踢出群
		 */
		byte KICK_GROUP = 6;

		/**
		 * 重新加入群
		 */
		byte RE_JOIN_GROUP = 7;

		/**
		 * 撤回消息
		 */
		byte BACK_MSG = 9;

		/**
		 * 删除消息
		 */
		byte DEL_MSG = 10;
		
		
		/**
		 * 更新群角色
		 */
		byte UPDATE_GROUP_ROLE = 11;

		/**
		 * 修改群头像
		 */
		byte UPDATE_GROUP_AVATAR = 20;
		
		/**
		 * 修改群名称
		 */
		byte UPDATE_GROUP_NAME = 21;

		/**
		 * 自动修改群信息
		 */
		byte AUTO_UPDATE_INFO = 22;

		/**
		 * 修改群通知-未发送同步
		 */
		byte UPDATE_GROUP_NOTICE = 23;

		byte KICK_GROUP_NOTICE = 24;
	}

	/**
	 * Im的消息操作码
	 * @author xufei
	 * 2020年1月17日 下午2:20:08
	 */
	public static interface WxMsgOper {
		/**
		 * 删除消息
		 */
		byte DEL = 1;

		/**
		 * 撤回消息
		 */
		byte BACK = 9;

		/**
		 * 举报
		 */
		byte REPORT = 99;
	}

	/**
	 * 
	 * 用户同步类型
	 * @author xufei
	 * 2020年3月16日 上午10:25:43
	 */
	public static interface UserToImSynType {
		/**
		 * 昵称
		 */
		byte NICK = 1;

		/**
		 * 头像
		 */
		byte AVATAR = 2;

		/**
		 * 群昵称
		 */
		byte GROUP_NICK = 3;

		/**
		 * 用户所有
		 */
		byte USER_ALL = 99;
	}

	/**
	 * 会话操作码
	 * @author xufei
	 * 2020年3月5日 下午9:36:45
	 */
	public static interface SessionOper {
		/**
		 * 进入
		 */
		byte JOIN = 1;

		/**
		 * 离开
		 */
		byte LEAVE = 2;
	}

	/**
	 * 好友验证方式
	 * @author xufei
	 * 2020年1月8日 下午4:35:49
	 */
	public static interface FdValidType {
		/**
		 *  验证
		 */
		byte VALID = 1;

		/**
		 * 不验证
		 */
		byte NO_VALID = 2;
	}

	/**
	 * 周期
	 * @author xufei
	 */
	public static interface PeriodType {

		/**
		 * 天
		 */
		byte DAY = 1;

		/**
		 * 周
		 */
		byte WEEK = 2;

		/**
		 * 月
		 */
		byte MONTH = 3;

		/**
		 * 年
		 */
		byte YEAR = 4;

		/**
		 * 季
		 */
		byte QUARTER = 5;

		/**
		 * 小时
		 */
		byte HOUR = 6;

		/**
		 * 时分
		 */
		byte TIME = 7;

		/**
		 * 所有
		 */
		byte TOTAL = 9;

		/**
		 * 所有标识
		 */
		String TOTAL_PERIOD = "total";

		/**
		 * 默认周期字段
		 */
		String DEFAULT_PERIOD = "period";
	}

	/**
	 * 内容类型 
	 * 内容类型，1、普通文本消息，2、博客，3、文件，4、音频，5、视频，6：图片
	 * @author tanyaowu
	 *
	 */
	public static interface ContentType {
		/**
		 * 
		 */
		byte TEXT = 1;

		/**
		 * 博客
		 */
		byte BLOG = 2;

		/**
		 * 文件
		 */
		byte FILE = 3;

		/**
		 * 音频
		 */
		byte AUDIO = 4;

		/**
		 * 视频
		 */
		byte VIDEO = 5;

		/**
		 * 图片
		 */
		byte IMG = 6;

		byte RUN_JS = 7;

		/**
		 * 邀请用户入群
		 */
		byte INVITE_INTO_GROUP = 8;

		/**
		 * 名片
		 */
		byte MSG_CARD = 9;

		/**
		 * 视频通话
		 */
		byte CALL_VIDEO = 10;

		/**
		 * 语音通话
		 */
		byte CALL_AUDIO = 11;
		
		/**
		 * 发红包
		 */
		byte REDPACKET = 12;
		
		/**
		 * 群申请
		 */
		byte GROUP_APPLY = 13;

		/**
		 * 位置信息
		 */
		byte LOCATION = 14;

		/**
		 * 表情
		 */
		byte FACE_EMOTION = 15;

		/**
		 * 转账
		 */
		byte TRANS_AMOUNT = 16;

		byte TRANS_SEND = 17;
		
		/**
		 * 模板消息
		 */
		byte TEMPLATE  = 88;
	}

	/**
	 * 钛信定时任务类型
	 * @author xufei
	 * 2020年7月3日 下午3:58:26
	 */
	public static interface WxTaskType {
		/**
		 * 备份消息
		 */
		byte BAK_MSG = 1;

	}

	/**
	 * 消息名片类型-来自聊天模型
	 * @author xufei
	 * 2020年3月9日 下午2:32:09
	 */
	public static interface MsgCardType {
		/**
		 * 好友
		 */
		byte FRIEND = Const.ChatMode.P2P;

		/**
		 * 群
		 */
		byte GROUP = Const.ChatMode.GROUP;

	}

	/**
	 * 暂时移过来，未来可能不用了
	 * @author xufei
	 * 2020年2月13日 下午11:23:19
	 */
	public static interface BackStatus {
		/**
		 * 正常
		 */
		byte OK = 1;

		/**
		 * 被自己撤回
		 */
		byte WITHDRAW_BY_SELF = 2;

		/**
		 * 被管理员撤回
		 */
		byte WITHDRAW_BY_MANAGER = 3;
	}

	/**
	 * 区域统计类型
	 * @author xufei
	 * 2020年7月23日 下午2:45:15
	 */
	public static interface AreaStatType {
		/**
		 * 注册
		 */
		byte REGISTER = 1;
	}

	/**
	 * 现存执行日志类型
	 * @author xufei
	 * 2020年7月28日 下午1:58:20
	 */
	public static interface ThreadLogType {
		/**
		 * 注册统计
		 */
		byte	REGISTER_STAT	= 1;
		/**
		 * 登录日志统计
		 */
		byte	LOGIN_STAT		= 2;
	}

	public static interface Http {
		String SESSION_COOKIE_NAME = P.get("http.session.cookie.name", "tio_session");
	}
	
	/**
	 * 注册类型
	 * @author xufei
	 * 2020年12月16日 下午3:18:43
	 */
	public static interface RegisterType {
		/**
		 * 邮箱
		 */
		int EMAIL = 1;

		/**
		 * 电话
		 */
		int PHONE = 2;
	}

	public static interface OneKeyLoginConf{
		/***
		 * 获取手机号api接口
		 */
		String PATH = "/api/v1/mobile/info";
		/**
		 *
		 */
		String APP_KEY = "203929888";


		String APP_SECRET = "roJiyYhznouLsJkS6kaeTgtnmH9XVF10";

		/**
		 * 地址
		 */
		String HOST = "verify5.market.alicloudapi.com";
	}

}
