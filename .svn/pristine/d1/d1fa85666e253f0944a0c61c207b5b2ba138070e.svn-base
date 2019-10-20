package com.bang.invoice_ver.jar.weixin.util;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 微信发送 模板消息util
 *
 * @author lifq 
 * @date 2015-3-18 下午05:43:40
 */
public class TemplateMessageUtil {
    //下发薪资单 模板消息
    public static final String SEND_PERIOD_TEMPLATE =   
       "{\n"+
           "\"touser\":\"@WXID@\",\n"+
           "\"template_id\":\"@TEMPLATE_ID@\",\n"+
           "\"url\":\"@URL@\",\n"+
           "\"topcolor\":\"#FF0000\",\n"+
           "\"data\":{\n"+
                  " \"content\":{\n"+
                       "\"value\":\"@CONTENT@\",\n"+
                       "\"color\":\"#173177\"\n"+
                   "}\n"+
           "}\n"+
           "}";
        
    /**
     * 发送模板消息
     *
     * @return boolean
     * @author lifq
     * @date 2015-2-11 下午03:25:07
     */
    public static String sendTemplateMsg (String url, Map<String,String> paraMap){
        String data = TemplateMessageUtil.SEND_PERIOD_TEMPLATE;
        //替换变量
        for (Entry<String, String> entry: paraMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            data = StringUtils.replaceOnce(data, key, value);
        }
        String res = HttpPostUtil.doHttpPostJson(url, data);
        JSONObject demoJson = JSONObject.parseObject(res);
        String errcode = demoJson.getString("errcode");
        return errcode;
    }
}