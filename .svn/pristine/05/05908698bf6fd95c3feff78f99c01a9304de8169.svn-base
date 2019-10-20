package com.bang.invoice_ver.utils.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/**
 * 
 * Description: 自定义缓存工具@
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2017年10月30日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
@Component
public class CacheManagerDao {
    
    /** 线程安全的map **/
    private static Map<String, CacheData> CACHE_DATA = new ConcurrentHashMap<String, CacheManagerDao.CacheData>();
    
    /**
     * 
     * Description: 设置数据(时间单位：毫秒)
     * @param
     * @return void
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月30日 下午2:28:47
     */
    public void setKeyAndValueTimeout(String key, String data, long expireTime){
        CacheData cacheData = new CacheData(data, System.currentTimeMillis() + expireTime * 1000);
        CACHE_DATA.put(key, cacheData);
    }
    
    /**
     * 
     * Description: 设置数据(时间单位：毫秒)
     * @param
     * @return void
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月30日 下午2:28:47
     */
    public void setKeyAndValueTimeout(String key, String data){
        CacheData cacheData = new CacheData(data, System.currentTimeMillis() + 60*60*24*365*1000);
        CACHE_DATA.put(key, cacheData);
    }
    
    /**
     * 
     * Description: 获取数据
     * @param
     * @return String
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月30日 下午2:32:01
     */
    public String getValueByKey(String key){
        CacheData cacheData = CACHE_DATA.get(key);
        if(cacheData == null){
            return null;
        } 
        if(cacheData.getExpireTime() <= System.currentTimeMillis()){
            CACHE_DATA.remove(key);
            return null;
        }
        return cacheData.getData();
    }
    
    /**
     * 
     * Description: 移除
     * @param
     * @return void
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月30日 下午2:43:02
     */
    public CacheData removeValueByKey(String key){
        return CACHE_DATA.remove(key);
    }
    
    /**
     * 
     * Description: 清空
     * @param
     * @return void
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月30日 下午2:43:25
     */
    public void clearAll(){
        CACHE_DATA.clear();
    }
    
    /**
     * 
     * Description: 获取所有缓存
     * @param
     * @return Object
     * @throws
     * @Author wangxinbang
     * Create Date: 2017年10月30日 下午6:34:06
     */
    public Object getAllCache(){
        return CACHE_DATA;
    }
    
    /** 缓存数据实体  **/
    private static class CacheData{
        /** 数据内容  **/
        private String data;
        /** 过期时间  **/
        private long expiryTime;
        
        public CacheData(String data, long expiryTime){
            this.data = data;
            this.expiryTime = expiryTime;
        }
        
        public String getData(){
            return this.data;
        }
        
        public long getExpireTime(){
            return this.expiryTime;
        }
        
    }

}
