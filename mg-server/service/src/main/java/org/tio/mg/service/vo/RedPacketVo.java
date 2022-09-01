package org.tio.mg.service.vo;

import java.io.Serializable;

/**
 * @author :linjian
 * @description :
 * @createTime :2021/9/11
 * @updateTIme :
 */
public class RedPacketVo implements Serializable {

    private static final long serialVersionUID = 6442802700083004389L;

    private Integer pageNum;

    private Integer pageSize;

    private String startTime;

    private String endTime;

    private Integer uid;

    private Integer status;

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
}
