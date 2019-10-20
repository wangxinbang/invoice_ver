package com.bang.invoice_ver.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bang.invoice_ver.utils.StringUtil;

/**
 * 
 * Description: 验证用户是否登录
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2016年8月15日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /** 不拦截校验的访问资源  **/
        String[] excludeRegex = new String[] {".*js/.*", ".*css/.*", ".*images/.*", ".*login$", ".*logout$", ".*unIntcpt-.*", ".*captcha*", ".*cps/.*", ".*.do*"};
        String uri = request.getRequestURI();
        if(StringUtil.matches(uri, excludeRegex) ){
            return true;
        }
        return false;
    }
    
}
