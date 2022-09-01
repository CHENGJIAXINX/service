package org.tio.sitexxx.web.server.yanxun.youmeng;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.http.server.annotation.RequestPath;
import org.tio.jfinal.kit.Ret;
import org.tio.sitexxx.service.api.sms.BaseSmsVo;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.YxOnekeyLoginTmp;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.base.sms.SmsService;
import org.tio.sitexxx.service.service.yanxun.onekeylogin.OneKeyLoginTempService;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.web.server.controller.base.LoginController;
import org.tio.sitexxx.web.server.controller.base.RegisterController;
import org.tio.sitexxx.web.server.utils.MD5Utils;
import org.tio.sitexxx.web.server.yanxun.youmeng.http.Client;
import org.tio.sitexxx.web.server.yanxun.youmeng.http.Request;
import org.tio.sitexxx.web.server.yanxun.youmeng.http.Response;
import org.tio.sitexxx.web.server.yanxun.youmeng.http.constant.Constants;
import org.tio.sitexxx.web.server.yanxun.youmeng.http.constant.ContentType;
import org.tio.sitexxx.web.server.yanxun.youmeng.http.constant.HttpHeader;
import org.tio.sitexxx.web.server.yanxun.youmeng.http.constant.HttpSchema;
import org.tio.sitexxx.web.server.yanxun.youmeng.http.enums.Method;
import org.tio.sitexxx.web.server.yanxun.youmeng.http.util.MessageDigestUtil;
import org.tio.utils.hutool.StrUtil;
import org.tio.utils.resp.Resp;

import java.util.*;

@RequestPath(value = "/oauth")
public class OauthController {

    private static Logger log = LoggerFactory.getLogger(OauthController.class);


    private static OneKeyLoginTempService oneKeyLoginTemp = OneKeyLoginTempService.ME;


    private final static List<String> CUSTOM_HEADERS_TO_SIGN_PREFIX = new ArrayList<String>();

    private final static UserService userService = UserService.ME;

    /**
     *
     *
     */
    public OauthController() {
    }

    @RequestPath(value = "/login")
    public Object oauth(HttpRequest request,String token,String appKey) throws Exception{
        if(StrUtil.isBlank(token)){
            log.error("token令牌无效");
            return Resp.fail("令牌不合法");
        }
        if(StrUtil.isBlank(appKey)){
            log.error("appKey未空");
            return Resp.fail("参数错误：未传appKey");
        }
        YxOnekeyLoginTmp temp = new YxOnekeyLoginTmp();
        YxOnekeyLoginTmp loginTmp = oneKeyLoginTemp.findByToken(token);
        String mobile = null;
        if(loginTmp==null){
            JSONObject body = new JSONObject();
            body.put("token",token);
            //发送http请求 获取手机号
            Response response = postString(Const.OneKeyLoginConf.PATH, appKey, body.toString(), "");;
            JSONObject jsonObject = JSON.parseObject(response.getBody());

            boolean success = (boolean)jsonObject.get("success");
            if(!success){
                log.error("获取手机号失败：{}",jsonObject.get("message").toString());
                return Resp.fail(jsonObject.get("message").toString());
            }
            mobile= JSON.parseObject(jsonObject.get("data").toString()).get("mobile").toString();

            temp.setMobile(mobile);
            temp.setToken(token);
            if(!temp.save()){
                log.error("临时token保存失败");
                return Resp.fail("token保存失败");
            }
        }else{
            mobile = loginTmp.getMobile();
        }

        Resp resp = null;
        User user = userService.getByPhone(mobile, null);
        if(user!=null){
//            Map<String,Object> map = new HashMap<String,Object>();
//            map.put("loginname",mobile);
//            map.put("pd5",user.getPhonepwd());
//            map.put("authcode",null);
            HttpResponse login = new LoginController().login(mobile, user.getPhonepwd(), null, request);
            return login;
        }else{
            Map<String,Object> map = new HashMap();
            map.put("mobile",mobile);
            map.put("tempId",temp.getId());
            resp = Resp.ok(map);
        }
        return resp;
    }

    @RequestPath(value = "/register")
    public Object register(HttpRequest request,Integer tokenId,String token,String name,String agreement) throws Exception{
        if(StrUtil.isBlank(name)){
            return Resp.fail("未填写名称");
        }
        if(StrUtil.isBlank(token)){
            return Resp.fail("token为空");
        }
        YxOnekeyLoginTmp loginTmp = oneKeyLoginTemp.findById(tokenId);
        if(loginTmp==null||!loginTmp.getToken().equals(token)){
            return Resp.fail("token校验不通过");
        }
        String mobile = loginTmp.getMobile();
        User user = new User();
        user.setNick(name);
        user.setLoginname(mobile);
        user.setPhone(mobile);
        user.setPwd(getPwd5());
        user.setPhonepwd(getPwd5());
        user.setAgreement(agreement);
        Resp register = new RegisterController().register(user, (byte) 2, request);
        if(register.isOk()){
            HttpResponse login = new LoginController().login(mobile, user.getPhonepwd(), null, request);
            return login;
        }
        return register;
    }

    @RequestPath(value = "/codeRegister")
    public Object register(HttpRequest request,String phone,String code,String nick,String agreement) throws Exception{
        if(StrUtil.isBlank(phone)){
            return Resp.fail("未填写phone");
        }
        if(StrUtil.isBlank(code)){
            return Resp.fail("code为空");
        }
        System.out.println(String.format("====>phone=%s, code=%s", phone, code));
        Ret ret = SmsService.me.checkCode(phone, BaseSmsVo.BaseSmsBizType.REGISTER, code, null, false);
        if (ret.isFail()) {
            return Resp.fail(RetUtils.getRetMsg(ret));
        }
        User user = new User();
        user.setNick(nick);
        user.setLoginname(phone);
        user.setPhone(phone);
        user.setPwd(getPwd5());
        user.setPhonepwd(getPwd5());
        user.setCode(code);
        user.setAgreement(agreement);
        Resp register = new RegisterController().register(user, (byte) 2, request);
        if(register.isOk()){
            HttpResponse login = new LoginController().login(phone, user.getPhonepwd(), null, request);
            return login;
        }
        return register;
    }

    private String getPwd5(){
        UUID uuid = UUID.randomUUID();
        String md5 = MD5Utils.getMd5(uuid.toString());
        return md5;
    }

    private Response postString(String path,String appKey,String body,String verifyId) throws Exception{
        HashMap<String,String> headers = new HashMap();
        headers.put(HttpHeader.HTTP_HEADER_ACCEPT,"application/json");
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_MD5, MessageDigestUtil.base64AndMD5(body));
        headers.put(HttpHeader.HTTP_HEADER_CONTENT_TYPE, ContentType.CONTENT_TYPE_TEXT);
        headers.put("X-Ca-Version", "1");
        headers.put("X-Ca-Stage", "RELEASE");
        headers.put("X-Ca-Key",Const.OneKeyLoginConf.APP_KEY);
//        headers.put("X-Ca-Timestamp",new Date().getTime()+"");
        headers.put("X-Ca-Nonce", UUID.randomUUID().toString());
        CUSTOM_HEADERS_TO_SIGN_PREFIX.clear();
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("X-Ca-Version");
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("X-Ca-Stage");
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("X-Ca-Nonce");
        CUSTOM_HEADERS_TO_SIGN_PREFIX.add("X-Ca-Key");
        Request request = new Request(Method.POST_STRING, HttpSchema.HTTP + Const.OneKeyLoginConf.HOST, path, Const.OneKeyLoginConf.APP_KEY, Const.OneKeyLoginConf.APP_SECRET, Constants.DEFAULT_TIMEOUT);
        request.setHeaders(headers);
        request.setSignHeaderPrefixList(CUSTOM_HEADERS_TO_SIGN_PREFIX);
        //请求的query
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("appkey", appKey);
        querys.put("verifyId", verifyId);
        request.setQuerys(querys);

        request.setStringBody(body);

        //调用服务端
        Response response = Client.execute(request);
        return response;
    }
}
