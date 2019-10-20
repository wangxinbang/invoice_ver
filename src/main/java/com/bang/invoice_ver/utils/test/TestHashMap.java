package com.bang.invoice_ver.utils.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Description: 测试HashMap
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月4日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class TestHashMap {

    public static void main(String[] args) {
        Map<String, String> m = new HashMap<String, String>();
        long sta = System.currentTimeMillis();
        for(int i = 20; i > 0; i--){
            long st = System.currentTimeMillis();
            m.put("1111111111111111111111111111" + i, "2222222222222222" + 1);
            long et = System.currentTimeMillis();
            System.out.println("time inter :" + (et-st));
        }
        long eta = System.currentTimeMillis();
        System.out.println("time intera :" + (eta-sta));
    }
    
}
