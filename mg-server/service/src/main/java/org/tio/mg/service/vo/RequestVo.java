package org.tio.mg.service.vo;

import java.io.Serializable;

/**
 * @author :linjian
 * @description : 基础请求对象
 * @createTime :2021/9/11
 * @updateTIme :
 */
public class RequestVo implements Serializable {

    private static final long serialVersionUID = 6813616326919771907L;

    private String searchKey;

    private Integer pageNumber;

    private Integer pageSize;

    private String startTime;

    private String endTime;

    private String name;

    private Integer type;

    private Integer statType;

    private Integer statPeriod;

    private String ip;

    private String groupKey;

    private String period;

    private Integer uid;

    private Integer inviteCode;

    private Integer toUid;

    private Integer roleId;

    private Integer status;

    private String fidKey;

    private Integer contentType;

    private Long groupId;

    private String loginName;

    private String email;

    private String avatar;

    private String nick;

    private String pd5;

    private Long chatLinkId;

    private String order;

    private String province;

    private String city;

    private Integer id;

    private String fuid;

    private Integer gid;

    private String message;

    private String oldPwd;

    private String newPwd;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatType() {
        return statType;
    }

    public void setStatType(Integer statType) {
        this.statType = statType;
    }

    public Integer getStatPeriod() {
        return statPeriod;
    }

    public void setStatPeriod(Integer statPeriod) {
        this.statPeriod = statPeriod;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(Integer inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Integer getToUid() {
        return toUid;
    }

    public void setToUid(Integer toUid) {
        this.toUid = toUid;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFidKey() {
        return fidKey;
    }

    public void setFidKey(String fidKey) {
        this.fidKey = fidKey;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPd5() {
        return pd5;
    }

    public void setPd5(String pd5) {
        this.pd5 = pd5;
    }

    public Long getChatLinkId() {
        return chatLinkId;
    }

    public void setChatLinkId(Long chatLinkId) {
        this.chatLinkId = chatLinkId;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFuid() {
        return fuid;
    }

    public void setFuid(String fuid) {
        this.fuid = fuid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
