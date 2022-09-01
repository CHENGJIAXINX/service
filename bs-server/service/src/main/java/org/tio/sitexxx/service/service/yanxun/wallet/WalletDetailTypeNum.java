package org.tio.sitexxx.service.service.yanxun.wallet;

public enum  WalletDetailTypeNum {
    RECHARGE(1) ,WITHDRAW(2), RED(3),OTHER(4),TRANS(5);

    private Integer mode;

    WalletDetailTypeNum(Integer type) {
        this.mode = type;
    }

    public Integer getMode() {
        return mode;
    }
}
