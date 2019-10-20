package com.bang.invoice_ver.jar.weixin.util;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bang.invoice_ver.utils.Attr.WeiXinConstant;
import com.bang.invoice_ver.utils.HttpClientUtil;
import com.bang.invoice_ver.utils.cache.CacheManagerDao;

/**
 * 
 * Description: 微信accessToken服务
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2017年9月21日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
@Service
public class WeiXinAccessTokenService {
    
    private static final Logger logger = LoggerFactory.getLogger(WeiXinAccessTokenService.class);
    
    @Autowired
    private CacheManagerDao cacheManagerDao;
    
    private ConcurrentHashMap<String, String> weiXinAccessTokenReqUrlMap = new ConcurrentHashMap<String, String>();
    
    /**
     * 
     * Description: 调用微信接口获取access_token
     * @param
     * @return String
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年9月21日 上午10:57:49
     */
    public String getAccessTokenFromUrl(String appId, String appSecret, int reqCount){
        if(reqCount >= 6){
            logger.info("请求微信请求接口失败超过6次,终止请求。");
            return null;
        }
        String reqUrl = this.getAccessTokenReqUrl(appId, appSecret);
        logger.info("微信access_token接口请求信息：" + reqUrl);
        String accessTokenRet = null;
        try {
            accessTokenRet = HttpClientUtil.get(reqUrl);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            logger.info("获取access_token失败：" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("获取access_token失败：" + e.getMessage());
        }
        logger.info("微信access_token接口返回信息：" + accessTokenRet);
        if(StringUtils.isEmpty(accessTokenRet)){
            reqCount++;
            return getAccessTokenFromUrl(appId, appSecret, reqCount);
        }
        return getAccessTokenFromRetStr(accessTokenRet);
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
    private String getAccessTokenFromRetStr(String accessTokenRet) {
        JSONObject objs = JSONObject.parseObject(accessTokenRet);
        return objs.getString(WeiXinConstant.WEIXIN_ACCESSTOKEN_KEY);
    }

    /**
     * 
     * Description: 获取access_token请求url
     * @param
     * @return String
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年9月21日 上午11:30:22
     */
    private String getAccessTokenReqUrl(String appId, String appSecret){
        String reqUrl = weiXinAccessTokenReqUrlMap.get(appId + appSecret);
        if(StringUtils.isEmpty(reqUrl)){
            reqUrl = StringUtils.replaceOnce(WeiXinConstant.WEIXIN_ACCESSTOKEN_GET_URL, WeiXinConstant.WEIXIN_APPID_REG, appId);
            reqUrl = StringUtils.replaceOnce(reqUrl, WeiXinConstant.WEIXIN_APPSECRET_REG, appSecret);
            weiXinAccessTokenReqUrlMap.put(appId + appSecret, reqUrl);
        }
        return reqUrl;
    }
    
    /**
     * 
     * Description: 获取access_token
     * @param
     * @return String
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年9月21日 上午11:19:02
     */
    public synchronized String getAccessToken(String appId, String appSecret){
        String accessToken = cacheManagerDao.getValueByKey(WeiXinConstant.WEIXIN_ACCESSTOKEN_REDIS_PRE + appId);
        if(StringUtils.isEmpty(accessToken)){
            accessToken = this.getAccessTokenFromUrl(appId, appSecret, 0);
            cacheManagerDao.setKeyAndValueTimeout(WeiXinConstant.WEIXIN_ACCESSTOKEN_REDIS_PRE + appId, accessToken, Long.parseLong(WeiXinConstant.WEIXIN_ACCESSTOKEN_REDIS_TIMEOUT));
        }
        return accessToken;
    }

}
