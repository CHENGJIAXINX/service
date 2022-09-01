package org.tio.mg.service.vo;

import java.io.Serializable;

/**
 * @author :linjian
 * @description :
 * @createTime :2021/9/11
 * @updateTIme :
 */
public class RechargeRequestVo implements Serializable {

    private static final long serialVersionUID = -154863278404377299L;

    private Integer pageNum;// 当前页码

    private Integer pageSize;// 页面长度

    private String startTime;// 开始时间

    private String endTime;// 结束时间

    private Integer status;// 审核状态

    private Integer uid;// 用户id

    private String nick;// 名称

    private Integer payType;// 支付方式

    private String orderNo;// 订单号

    public Integer getPageNumber() {
        return pageNum;
    }

    public void setPageNumber(Integer pageNum) {
        this.pageNum = pageNum;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
