package org.tio.mg.service.vo;

import java.io.Serializable;

/**
 * @author :linjian
 * @description :
 * @createTime :2021/9/11
 * @updateTIme :
 */
public class RechargeCheckVo implements Serializable {

    private static final long serialVersionUID = 627687673594769893L;

    private Integer id;// 充值/提现记录id

    private Integer uid;// 用户id

    private Integer status;// 审核状态 1待审核 2审核中 3已通过 4拒绝 5提现完成

    private Integer money;// 充值金额

    private String note;// 审核意见

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
