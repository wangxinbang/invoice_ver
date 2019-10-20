package com.bang.invoice_ver.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bang.invoice_ver.jar.invoice.service.InvoiceInfoService;

/**
 * 
 * Description: 对外部开放的api接口
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2017年10月31日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
@RestController
@RequestMapping("/apiRest")
public class ApiRestCotroller {
    
    /** 日志  **/
    private static final Logger logger = LoggerFactory.getLogger(ApiRestCotroller.class);
    
    @Autowired
    private InvoiceInfoService invoiceInfoServiceImpl;
    
    /**
     * 
     * Description: 更新数据信息
     * @param
     * @return Object
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月31日 下午2:46:04
     */
    @RequestMapping(value = "/updateInvoiceInfo", method = RequestMethod.POST)
    public Object updateInvoiceInfo(@RequestBody JSONObject objs, HttpServletRequest request, HttpServletResponse response){
        logger.info("ApiRestCotroller->updateInvoiceInfo:" + JSONObject.toJSONString(objs));
        
        return invoiceInfoServiceImpl.updateInvoiceInfo(objs);
    }
    
}
