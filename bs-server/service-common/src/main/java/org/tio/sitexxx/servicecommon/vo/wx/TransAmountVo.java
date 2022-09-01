package org.tio.sitexxx.servicecommon.vo.wx;

public class TransAmountVo {

    private int id;
    /**
     * 订单号
     */
    private String serial;

    /**
     * 备注
     */
    private String remark;
    /**
     *  1-发包 2-收包
     */
    private Integer type;

    private Integer amount;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 状态
     */
    private Integer status;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
