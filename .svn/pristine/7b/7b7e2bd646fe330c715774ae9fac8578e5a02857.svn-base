package com.bang.invoice_ver.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.bang.invoice_ver.utils.cache.CacheManagerDao;

/**
 * 
 * Description: 缓存(供生产排查和解决问题使用)
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2017年10月30日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
@RestController
@RequestMapping("/cacheRest")
public class CacheRestController {

    @Autowired
    private CacheManagerDao cacheManagerDao;
    
    /**
     * 
     * Description: 获取所有缓存
     * @param
     * @return Object
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月30日 下午6:37:02
     */
    @ResponseBody
    @RequestMapping(value = "/getAllCache.do", method = RequestMethod.POST)
    public Object getAllCache(){
        return cacheManagerDao.getAllCache();
    }
    
    /**
     * 
     * Description: 获取所有缓存
     * @param
     * @return Object
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月30日 下午6:37:02
     */
    @ResponseBody
    @RequestMapping(value = "/removeCache.do", method = RequestMethod.POST)
    public Object removeCache(@RequestBody JSONObject objs){
        return cacheManagerDao.removeValueByKey(objs.getString("887f2f0d3db09ced4dadec55810e1028"));
    }
    
}
