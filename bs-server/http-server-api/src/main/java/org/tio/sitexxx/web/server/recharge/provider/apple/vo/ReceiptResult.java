/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.web.server.recharge.provider.apple.vo;

/**
 * 
 * @author tanyaowu
 */
public class ReceiptResult {

    private Receipt receipt;
    private int status;
    private String environment;
    public void setReceipt(Receipt receipt) {
         this.receipt = receipt;
     }
     public Receipt getReceipt() {
         return receipt;
     }

    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

    public void setEnvironment(String environment) {
         this.environment = environment;
     }
     public String getEnvironment() {
         return environment;
     }

}