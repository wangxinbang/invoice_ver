package com.bang.invoice_ver.jar.weixin.service;

import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bang.invoice_ver.base.CommonReturnInfo;
import com.bang.invoice_ver.base.config.BaseConfig;
import com.bang.invoice_ver.base.exception.IVException;
import com.bang.invoice_ver.jar.weixin.bean.TemplateParam;
import com.bang.invoice_ver.jar.weixin.util.WeiXinAccessTokenService;
import com.bang.invoice_ver.jar.weixin.util.WeiXinInterService;
import com.bang.invoice_ver.utils.Attr.WeiXinConstant;
import com.bang.invoice_ver.utils.cache.CacheManagerDao;

/**
 * 
 * Description: 发送微信业务服务
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2017年10月18日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
@Service
public class WeixinBizService {
    
    private static final Logger logger = LoggerFactory.getLogger(WeixinBizService.class);
    
    @Autowired
    private WeiXinAccessTokenService weiXinAccessTokenService;
    
    @Autowired
    private WeiXinInterService weiXinInterService;
    
    @Autowired
    private BaseConfig baseConfig;
    
    @Autowired
    private CacheManagerDao cacheManagerDao;
    
    /**
     * 
     * Description: 字符串格式化
     * @param
     * @return String
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年9月6日 上午10:40:52
     */
    public String format(String input, JSONObject map) {
        for (Entry<String, Object> entry : map.entrySet()) {
            input = input.replace(entry.getKey(), ObjectUtils.toString(entry.getValue()));
        }
        return input;
    }

    /**
     * 
     * Description: 微信模板消息发送
     * 
     * @param
     * @return Map<String,Object>
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年8月28日 下午4:09:45
     */
    public Integer msgSend(String openId, List<TemplateParam> tpList, String wxTplId) {
        logger.info("WeixinSendService-->msgSendWithChannel:" + JSONObject.toJSONString(tpList) + ";openId:" + openId);
        /** 接口票据  **/
        String accessToken = weiXinAccessTokenService.getAccessToken(baseConfig.getWxAppId(), baseConfig.getWxAppSecret());
        String msgSendRet = weiXinInterService.sendWXTplMsg(accessToken, wxTplId, openId, tpList, WeiXinConstant.WX_TPL_COLOR_TPL_DEFAULT);
        String errCode = weiXinInterService.getWxResErrCode(msgSendRet);
        /** 如果成功，修改状态  **/
        if(WeiXinConstant.WX_RES_ERR_CODE_SUCC.equals(errCode)){
        }
        return 1;
    }
    
    /**
     * 
     * Description: 获取js config对象
     * @param
     * @return JSONObject
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月30日 下午5:21:06
     */
    public JSONObject getJsConfig(JSONObject objReq){
        if(objReq == null || objReq.getString(WeiXinConstant.JS_API_TICKET_URL_KEY) == null){
            throw new IVException(CommonReturnInfo.BASE00090004);
        }
        String apiTicketUrl = objReq.getString(WeiXinConstant.JS_API_TICKET_URL_KEY);
        String configJson = cacheManagerDao.getValueByKey(apiTicketUrl);
        if(StringUtils.isNotEmpty(configJson)){
            return JSONObject.parseObject(configJson);
        }
        logger.info("获取js config对象传入地址:" + objReq);
        /** 接口票据  **/
        String accessToken = weiXinAccessTokenService.getAccessToken(baseConfig.getWxAppId(), baseConfig.getWxAppSecret());
        /** js接口票据  **/
        String wxJsApiTicket = weiXinInterService.getWxJsApiTicket(accessToken, baseConfig.getWxAppId());
        /** config对象  **/
        JSONObject objs = weiXinInterService.getWxJsConfig(baseConfig.getWxAppId(), apiTicketUrl, wxJsApiTicket);
        
        cacheManagerDao.setKeyAndValueTimeout(apiTicketUrl, JSONObject.toJSONString(objs));
        return objs;
    }
    
}
