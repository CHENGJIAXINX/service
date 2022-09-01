package org.tio.mg.service.vo;

import java.io.Serializable;

/**
 * @author :linjian
 * @description :
 * @createTime :2021/9/12
 * @updateTIme :
 */
public class MgLoginVo implements Serializable {
    private static final long serialVersionUID = -509408179630477422L;

    private String loginName;// 登录名

    private String pd5;// md5加密后的密码

    private String authCode;// 图形验证码

    private Long googleCode;// 谷歌令牌

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPd5() {
        return pd5;
    }

    public void setPd5(String pd5) {
        this.pd5 = pd5;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Long getGoogleCode() {
        return googleCode;
    }

    public void setGoogleCode(Long googleCode) {
        this.googleCode = googleCode;
    }
}
