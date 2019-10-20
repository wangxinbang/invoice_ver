package com.bang.invoice_ver.stat;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * @author jack
 * @Date 2015年12月21日-下午4:16:49
 */
@Configuration
@ComponentScan(basePackages={"com.bang.invoice_ver"})
@ImportResource({"classpath:/config/com/bang/invoice_ver/spring-init.xml", "classpath:/spring-config.xml"}) 
public class AppConfig {	
}