package com.bang.invoice_ver.utils.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * Description: 测试向下计数门闩类
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月13日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class TestCountDownLatch {
    
    public static AtomicInteger ai = new AtomicInteger();
    
    public static void main(String[] args) throws InterruptedException {
//        
//        CountDownLatch startCdl = new CountDownLatch(1);
//        CountDownLatch finishCdl = new CountDownLatch(5);
//        ExecutorService es = Executors.newFixedThreadPool(8);
//        for (int i = 0; i < 5; i++) {
//            es.execute(new Worker(startCdl, finishCdl));
//        }
//        System.out.println("ready to start!");
//        Thread.sleep(2000);
//        System.out.println("ai=" + ai.get());
//        startCdl.countDown();
//        System.out.println("ai=" + ai.get());
//        finishCdl.await();
//        System.out.println("ai=" + ai.get());
        System.out.println(Integer.valueOf(1) == Integer.valueOf(1));
        System.out.println(Integer.valueOf(200) == Integer.valueOf(200));
        System.out.println(Integer.valueOf(200) == new Integer(200));
    }
    
}

/** 业务逻辑类 **/
class Worker implements Runnable{
    
    private CountDownLatch startCdl;
    private CountDownLatch finishCdl;
    
    public Worker(CountDownLatch startCdl, CountDownLatch finishCdl) {
        this.startCdl = startCdl;
        this.finishCdl = finishCdl;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            startCdl.await();
            TestCountDownLatch.ai.incrementAndGet();
            finishCdl.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
}

