package org.tio.mg.service.vo;

import java.io.Serializable;

/**
 * @author :linjian
 * @description :
 * @createTime :2021/9/11
 * @updateTIme :
 */
public class TransferVo implements Serializable {

    private static final long serialVersionUID = 3353003324629812699L;

    private Integer pageNum;

    private Integer pageSize;

    private Integer uid;

    private Integer status;

    private String startTime;

    private String endTime;

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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}
