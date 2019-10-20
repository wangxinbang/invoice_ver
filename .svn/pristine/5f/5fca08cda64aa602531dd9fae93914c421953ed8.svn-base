package com.bang.invoice_ver.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Description: 测试
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
@RequestMapping("/test")
public class TestController {
    
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    
    @RequestMapping(value = { "/testm.do" }, method = {RequestMethod.GET, RequestMethod.POST })
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException{
        logger.info("testm.do");
        String str = "hello world!";
        response.getWriter().write(str);
    }

}
