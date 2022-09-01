package org.tio.mg.service.service.yxnxun.other;

public class MgOperVo {

    private Integer uid;
    private String username;
    private String ip;
    private String param;
    private String deviceinfo;

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public void setDeviceinfo(String deviceinfo) {
        this.deviceinfo = deviceinfo;
    }

    public Integer getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getIp() {
        return ip;
    }

    public String getParam() {
        return param;
    }

    public String getDeviceinfo() {
        return deviceinfo;
    }
}
