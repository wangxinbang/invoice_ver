package com.bang.invoice_ver.jar.invoice.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.bang.invoice_ver.base.biz.BaseBiz;
import com.bang.invoice_ver.jar.invoice.dao.InvoiceInfoDao;

/**
 * 
 * Description: biz服务
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2017年10月31日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
@Component
public class InvoiceInfoBiz extends BaseBiz {
    
    @Autowired
    private InvoiceInfoDao invoiceInfoDao;
    
    /**
     * 
     * Description: 作废信息
     * @param
     * @return Integer
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月31日 下午3:28:07
     */
    public Integer voidInvoiceInfo(JSONObject objs){
        super.setDb(0, super.MASTER);
        return invoiceInfoDao.voidInvoiceInfo(objs);
    }
    
    /**
     * 
     * Description: 更新信息
     * @param
     * @return Integer
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月31日 下午3:28:07
     */
    public Integer updateInvoiceInfo(JSONObject objs){
        super.setDb(0, super.MASTER);
        return invoiceInfoDao.updateInvoiceInfo(objs);
    }

}
