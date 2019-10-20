package test.bang.invoice_ver;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.bang.invoice_ver.utils.https.HttpClientUtil;

public class TestControllerTest {
    
    @Test
    public void test() throws Exception{
        JSONObject objs = new JSONObject();
        objs.put("q", "q");
        String s = HttpClientUtil.httpPost("http://localhost/invoice_ver/test/testm.do", "111");
        System.out.println(s);
    }
    
    public static void main(String[] args) {
        System.out.println(RandomUtils.nextInt(200));
    }
    
    @Test
    public void testWxJSRestController() throws Exception{
        JSONObject objs = new JSONObject();
        objs.put("url", "http://localhost/invoice_ver/test/testm.do");
        String s = HttpClientUtil.httpPost("http://localhost/invoice_ver/wxJSRest/getJSConfig.do", JSONObject.toJSONString(objs));
        System.out.println(s);
    }
    
    @Test
    public void testCacheRestController() throws Exception{
        JSONObject objs = new JSONObject();
        objs.put("url", "http://localhost/invoice_ver/cacheRest/getAllCache.do");
        String s = HttpClientUtil.httpPost("http://localhost/invoice_ver/cacheRest/getAllCache.do", JSONObject.toJSONString(objs));
        System.out.println(s);
    }

}
