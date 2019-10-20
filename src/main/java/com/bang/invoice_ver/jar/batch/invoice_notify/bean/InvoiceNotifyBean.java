package com.bang.invoice_ver.jar.batch.invoice_notify.bean;

import java.io.Serializable;

/**
 * 
 * Description: 通知bean
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2017年10月31日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class InvoiceNotifyBean implements Serializable {
    
    private static final long serialVersionUID = -4387942188899694298L;

    private Integer id;
    
    private String openId;
    
    private String userPhone;
    
    private String invoiceCode;
    
    private String content;
    
    private Integer status;
    
    private Integer notifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(Integer notifyTime) {
        this.notifyTime = notifyTime;
    }
    
}
