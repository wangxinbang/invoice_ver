package com.bang.invoice_ver.utils.test;

import java.util.concurrent.ExecutionException;

/**
 * 
 * Description: 测试Thread.interrupt()
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月15日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class TestInterrupt {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
       Thread t = new Thread(new BeIntpt());
       t.start();
       Thread.sleep(1000);
       System.out.println("222" + t.isInterrupted());
       t.interrupt();
       System.out.println("222" + t.isInterrupted());
    }

}

/** 测试被中断 **/
class BeIntpt implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("111");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
    
}
