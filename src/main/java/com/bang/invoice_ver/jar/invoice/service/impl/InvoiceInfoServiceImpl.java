package com.bang.invoice_ver.jar.invoice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bang.invoice_ver.base.CommonReturnInfo;
import com.bang.invoice_ver.base.exception.IVException;
import com.bang.invoice_ver.jar.invoice.biz.InvoiceInfoBiz;
import com.bang.invoice_ver.jar.invoice.service.InvoiceInfoService;

/**
 * 
 * Description: 信息实现类
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2017年10月31日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
@Service
public class InvoiceInfoServiceImpl implements InvoiceInfoService {
    
    /** 日志  **/
    private static Logger logger = LoggerFactory.getLogger(InvoiceInfoServiceImpl.class);

    @Autowired
    private InvoiceInfoBiz invoiceInfoBiz;
    
    @Override
    public Object updateInvoiceInfo(JSONObject objs) throws IVException {
        if(objs == null){
            throw new IVException(CommonReturnInfo.BASE00090005);
        }
        int i = invoiceInfoBiz.voidInvoiceInfo(objs);
        logger.info("更新的数量:" + i);
        if(i < 0){
            throw new IVException(CommonReturnInfo.BASE00030001);
        }
        return invoiceInfoBiz.updateInvoiceInfo(objs);
    }

}
