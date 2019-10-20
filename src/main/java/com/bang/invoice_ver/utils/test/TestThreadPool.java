package com.bang.invoice_ver.utils.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * Description: 测试线程池
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月16日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class TestThreadPool {
    
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        es = Executors.newSingleThreadExecutor();
        es = Executors.newCachedThreadPool();
        es = Executors.newScheduledThreadPool(1);
        Thread.interrupted();
        Lock l = new ReentrantLock();
        l.lock();
        l.wait();
        Thread.sleep(1);
        for (int i = 0; i < 5; i++) {
            es.submit(new Thread(new WorkerT()));
        }
        es.shutdown();
    }

}

class WorkerT implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
    
}
