package com.bang.invoice_ver.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bang.invoice_ver.utils.AnswerEnum;

/**
 * 
 * Description: 答案之书
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2017年10月28日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
@RestController
@RequestMapping("/answer")
public class AnswerController {
    
    private static final Logger logger = LoggerFactory.getLogger(AnswerController.class);
    
    /**
     * 
     * Description: 获取答案
     * @param
     * @return void
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年12月10日 下午3:57:26
     */
    @ResponseBody
    @RequestMapping(value = { "/getAnswer.do" }, method = {RequestMethod.GET, RequestMethod.POST })
    public Object test(HttpServletRequest request, HttpServletResponse response) throws IOException{
        logger.info("入参信息：uri:"+ request.getRequestURI() + ",host:" + request.getRemoteHost());
        Integer i = RandomUtils.nextInt(AnswerEnum.getAnswerMap().size());
        AnswerEnum answerEnum = AnswerEnum.getAnswerMap().get(i);
        Map<String, String> map = new HashMap<String, String>();
        map.put("key", answerEnum.getAnswer());
        return map;
    }

}
