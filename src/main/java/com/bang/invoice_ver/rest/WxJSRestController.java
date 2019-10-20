package com.bang.invoice_ver.rest;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bang.invoice_ver.base.CommonReturnInfo;
import com.bang.invoice_ver.base.exception.IVException;
import com.bang.invoice_ver.base.service.BaseService;
import com.bang.invoice_ver.jar.weixin.service.WeixinBizService;

/**
 * 
 * Description: 微信js rest服务
 * 
 * @author wangxinbang
 * @version 1.0
 * 
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2016年12月09日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
@RestController
@RequestMapping("/wxJSRest")
public class WxJSRestController extends BaseService {
    
    /** 日志  **/
    protected static final Logger logger = LoggerFactory.getLogger(WxJSRestController.class);
    
    @Autowired
    private WeixinBizService weixinBizService;
    
    /**
     * 
     * Description: 获取js配置信息
     * @param
     * @return Object
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月30日 下午5:19:05
     */
    @ResponseBody
    @RequestMapping(value = "/getJSConfig.do", method = { RequestMethod.POST })
    public Object getJSConfig(@RequestBody JSONObject objs, HttpServletRequest request) {
        try {
            logger.info("获取js配置信息开始->参数:{}", JSONObject.toJSONString(objs));
            Object obj = this.weixinBizService.getJsConfig(objs);
            logger.info("获取js配置信息结束:{}", JSONObject.toJSONString(obj));
            LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
            linkedHashMap.put("result", obj);
            return super.returnSuccessInfo(linkedHashMap);
        } catch (IVException iqbe) {
            logger.error("获取js配置信息错误信息:" + iqbe.getRetInfo().getRetFactInfo(), iqbe);
            return super.returnFailtrueInfo(iqbe);
        } catch (Exception e) {
            logger.error("获取js配置信息错误信息:" + CommonReturnInfo.BASE00000001.getRetFactInfo(), e);
            return super.returnFailtrueInfo(new IVException(CommonReturnInfo.BASE00000001));
        }
    }
    

}
