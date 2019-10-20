package com.bang.invoice_ver.utils.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * Description: 测试读写锁
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月18日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class TestReadWriteLock {
    
    ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
    
    public static void main(String[] args) {
        final TestReadWriteLock trwl = new TestReadWriteLock();
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(new Runnable() {
            @Override
            public void run() {
                trwl.testWrite(Thread.currentThread());
            }
        });
        es.submit(new Runnable() {
            @Override
            public void run() {
                trwl.testRead(Thread.currentThread());
            }
        });
    }
    
    public void testRead(Thread t){
        try {
            rrwl.readLock().lock();
            System.out.println("---线程 " + t.getName() + "读取开始---");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(20);
                System.out.println("线程 " + t.getName() + "正在读取第" + i + "条信息");
            }
            System.out.println("---线程 " + t.getName() + "读取完毕---");
        } catch (Exception e) {
        } finally {
            rrwl.readLock().unlock();
        }
    }
    

    public void testWrite(Thread t){
        try {
            rrwl.writeLock().lock();
            System.out.println("---线程 " + t.getName() + "写入开始---");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(20);
                System.out.println("线程 " + t.getName() + "正在写入第" + i + "条信息");
            }
            System.out.println("---线程 " + t.getName() + "写入完毕---");
        } catch (Exception e) {
        } finally {
            rrwl.writeLock().unlock();
        }
    }


}
