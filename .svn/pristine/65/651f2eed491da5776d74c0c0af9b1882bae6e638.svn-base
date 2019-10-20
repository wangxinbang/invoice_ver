package com.bang.invoice_ver.jar.weixin.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bang.invoice_ver.jar.weixin.bean.Template;
import com.bang.invoice_ver.jar.weixin.bean.TemplateParam;
import com.bang.invoice_ver.utils.Attr.WeiXinConstant;
import com.bang.invoice_ver.utils.HttpClientUtil;
import com.bang.invoice_ver.utils.cache.CacheManagerDao;

/**
 * 
 * Description: 微信接口服务
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2017年10月20日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
@Service
public class WeiXinInterService {

    private static final Logger logger = LoggerFactory.getLogger(WeiXinInterService.class);
    
    @Autowired
    private CacheManagerDao cacheManagerDao;
    
    /**
     * 
     * Description: 发送微信模板消息
     * @param
     * @return String
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月20日 上午11:36:59
     */
    public String sendWXTplMsg(String accessToken, String WxTplId, String openId, List<TemplateParam> paras, String color){
        /** 参数替换  **/
        String reqUrl = StringUtils.replaceOnce(WeiXinConstant.WEIXIN_TPL_MSG_SEND_URL, WeiXinConstant.WEIXIN_ACCESS_TOKEN_REG, accessToken);
        
        /** 模板封装  **/
        Template tem=new Template();
        tem.setTemplateId(WxTplId);
        tem.setTopColor(color);
        tem.setToUser(openId);
        tem.setTemplateParamList(paras);
        
        logger.info("微信模板消息发送接口请求信息：" + tem.toJSON());
        String msgSendRet = HttpPostUtil.doHttpPostJson(reqUrl, tem.toJSON());
        logger.info("微信模板消息发送接口返回信息：" + msgSendRet);
        
        return msgSendRet;
    }
    
    /**
     * 
     * Description: 获取微信返回信息的errCode
     * @param
     * @return String
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月20日 下午1:56:54
     */
    public String getWxResErrCode(String resStr){
        if(StringUtils.isEmpty(resStr)){
            return WeiXinConstant.WX_RES_ERR_CODE_UNSUCC;
        }
        JSONObject resObjs = JSONObject.parseObject(resStr);
        return resObjs.getString(WeiXinConstant.WX_RES_ERR_KEY);
    }
    
    /**
     * 
     * Description: 获取模板参数列表
     * @param
     * @return List<TemplateParam>
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月20日 上午11:49:08
     */
    public List<TemplateParam> getTplParamList(JSONObject objs){
        List<TemplateParam> tplParamList = new ArrayList<TemplateParam>();
        for (Entry<String, Object> entry : objs.entrySet()) {
            TemplateParam tplParam = new TemplateParam(entry.getKey(), ObjectUtils.toString(entry.getValue()), WeiXinConstant.WX_TPL_COLOR_TPL_DEFAULT);
            tplParamList.add(tplParam);
        }
        return tplParamList;
    }
    
    /**
     * 
     * Description: 获取api_ticket请求地址
     * @param
     * @return String
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月30日 下午4:30:24
     */
    private String getJsApiTicketReqUrl(String accessToken){
        return StringUtils.replaceOnce(WeiXinConstant.WEIXIN_API_TICKET_URL, WeiXinConstant.WEIXIN_ACCESS_TOKEN_REG, accessToken);
    }
    
    /**
     * 
     * Description: 获取微信js配置
     * @param
     * @return JSONObject
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月30日 下午5:03:45
     */
    public JSONObject getWxJsConfig(String appId, String url, String jsApiTicket){
        String nonceStr = create_nonce_str();
        String timestamp = create_timestamp();
        String signStr = new StringBuffer("jsapi_ticket=").append(jsApiTicket).append("&noncestr=").append(nonceStr)
                .append("&timestamp=").append(timestamp).append("&url=").append(url).toString();
        String signature = DigestUtils.sha1Hex(signStr);
        JSONObject objs = new JSONObject();
        objs.put(WeiXinConstant.JS_API_TICKET_URL_KEY, url);
        objs.put(WeiXinConstant.JS_JSAPI_TICKET_KEY, jsApiTicket);
        objs.put(WeiXinConstant.JS_API_TICKET_NONCE_STR_KEY, nonceStr);
        objs.put(WeiXinConstant.JS_API_TICKET_TIMESTAMP_KEY, timestamp);
        objs.put(WeiXinConstant.JS_API_TICKET_SIGNATURE_KEY, signature);
        objs.put(WeiXinConstant.APP_ID_KEY, appId);
        return objs;
    }
    
    /**
     * 
     * Description: 获取js票据
     * @param
     * @return String
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月30日 下午4:30:52
     */
    public synchronized String getWxJsApiTicket(String accessToken, String appId){
        String apiTicket = cacheManagerDao.getValueByKey(WeiXinConstant.WEIXINJS_API_TICKET_REDIS_PRE + appId);
        if(StringUtils.isEmpty(apiTicket)){
            apiTicket = this.getJsApiTicketFromUrl(accessToken, 0);
            cacheManagerDao.setKeyAndValueTimeout(WeiXinConstant.WEIXINJS_API_TICKET_REDIS_PRE + appId, apiTicket, Long.parseLong(WeiXinConstant.WEIXIN_API_TICKET_REDIS_TIMEOUT));
        }
        return apiTicket;
    }

    /**
     * 
     * Description: 调用微信接口获取apiTicket
     * @param
     * @return String
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年9月21日 上午10:57:49
     */
    private String getJsApiTicketFromUrl(String accessToken, int reqCount){
        if(reqCount >= 6){
            logger.info("请求微信请求接口失败超过6次,终止请求。");
            return null;
        }
        String reqUrl = this.getJsApiTicketReqUrl(accessToken);
        logger.info("微信apiTicket接口请求信息：" + reqUrl);
        String apiTicketRet = null;
        try {
            apiTicketRet = HttpClientUtil.get(reqUrl);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            logger.info("获取apiTicket失败：" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("获取access_token失败：" + e.getMessage());
        }
        logger.info("微信access_token接口返回信息：" + apiTicketRet);
        if(StringUtils.isEmpty(apiTicketRet)){
            reqCount++;
            return getJsApiTicketFromUrl(accessToken, reqCount);
        }
        return getJsApiTicketFromRetStr(apiTicketRet);
    }
    

    /**
     * 
     * Description: 从返回信息中获取到access_token
     * @param
     * @return String
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年9月21日 上午11:54:33
     */
    private String getJsApiTicketFromRetStr(String apiTicketRet) {
        JSONObject objs = JSONObject.parseObject(apiTicketRet);
        return objs.getString(WeiXinConstant.JS_API_TICKET_RET_KEY);
    }

    /** 获取随机串  **/
    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }
    
    /** 获取时间戳  **/
    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
    
}
