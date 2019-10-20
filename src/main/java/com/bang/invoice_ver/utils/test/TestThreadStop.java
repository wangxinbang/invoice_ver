package com.bang.invoice_ver.utils.test;

import com.bang.invoice_ver.utils.StringUtil;

/**
 * 
 * Description: 测试线程的stop方法
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月4日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class TestThreadStop {

    private static User user = new User();
    
    /** 创建user类 **/
    static class CreateUserThread extends Thread{
        @Override
        public void run() {
            while(true){
                synchronized (TestThreadStop.class) {
                    String k = System.currentTimeMillis()/1000 + "";
                    user.setId(k);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String v = k.intern();
                    user.setName(v);
                }
                Thread.yield();
            }
        }
    }
    
    /** 读取user信息 **/
    static class ReadUserThread implements Runnable{
        @Override
        public void run() {
            while(true){
                synchronized (TestThreadStop.class) {
                    if(StringUtil.isEmpty(user.getId())){
                        continue;
                    }
                    if(Integer.parseInt(user.getId()) != Integer.parseInt(user.getName())){
                        System.out.println(user.toString());
                    }
                }
                Thread.yield();
            }
        }
    }
    
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ReadUserThread()).start();
        while(true){
            Thread t = new CreateUserThread();
            t.start();
            Thread.sleep(100);
            t.stop();
        }
    }
    
}

/** user类 **/
class User{
    String id;
    String name;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User:[id=" + id + ",name=" + name;
    }
}
