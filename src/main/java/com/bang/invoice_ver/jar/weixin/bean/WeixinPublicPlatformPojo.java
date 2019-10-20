package com.bang.invoice_ver.jar.weixin.bean;

import java.io.Serializable;

/**
 * 
 * Description: 微信公众平台pojo
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2017年9月21日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class WeixinPublicPlatformPojo implements Serializable {

    private static final long serialVersionUID = 4593411058782500023L;

    /** 主键id **/
    private Integer id;
    
    /** appId **/
    private String appId;
    
    /** appSecret **/
    private String appSecret;
    
    /** 公众号名称 **/
    private String appName;
    
    /** 微信类型id **/
    private String wxTypeId;
    
    /** 备注 **/
    private String remark;
    
    /** 微信模板id **/
    private String wxTplId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getWxTypeId() {
        return wxTypeId;
    }

    public void setWxTypeId(String wxTypeId) {
        this.wxTypeId = wxTypeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWxTplId() {
        return wxTplId;
    }

    public void setWxTplId(String wxTplId) {
        this.wxTplId = wxTplId;
    }
    
}
