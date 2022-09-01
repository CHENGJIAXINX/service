package org.tio.mg.service.service.yxnxun.wallet;

public enum WalletDetailTypeNum {
    RECHARGE(1) ,WITHDRAW(2), RED(3),OTHER(4),BACKRECHARGE(5),BACKWITHDRAW(6);

    private Integer mode;

    WalletDetailTypeNum(Integer type) {
        this.mode = type;
    }

    public Integer getMode() {
        return mode;
    }
}
