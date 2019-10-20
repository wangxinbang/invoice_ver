package com.bang.invoice_ver.jar.user.dao;

import com.alibaba.fastjson.JSONObject;
import com.bang.invoice_ver.jar.user.bean.InvoiceUserBean;

/**
 * 
 * Description: 用户服务dao
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2017年10月31日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public interface InvoiceUserDao {
    
    /**
     * 
     * Description: 作废信息
     * @param
     * @return Integer
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月31日 下午3:29:44
     */
    public Integer voidInvoiceUser(JSONObject objs);

    /**
     * 
     * Description: 更新信息
     * @param
     * @return Integer
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月31日 下午4:32:14
     */
    public Integer updateInvoiceUser(JSONObject objs);
    
    /**
     * 
     * Description: 插入信息
     * @param
     * @return Integer
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月31日 下午4:32:14
     */
    public Integer insertInvoiceUser(JSONObject objs);
    
    /**
     * 
     * Description: 根据id查询
     * @param
     * @return InvoiceUserBean
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月31日 下午5:57:02
     */
    public InvoiceUserBean getInvoiceUserById(Integer id);

}
