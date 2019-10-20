package com.bang.invoice_ver.utils.test;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * Description: 测试Lock和Condition
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月18日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class TestLockAndCondition {

}

/** 仓库类 **/
class Repository<T>{
    
    private final LinkedList<T> list = new LinkedList<T>();
    private final int MAX = 10;
    private Lock lock = new ReentrantLock();
    private Condition fullCondition = lock.newCondition();
    private Condition emptyCondition = lock.newCondition();
    
    public T get(){
        try {
            lock.lock();
            if(list.size() <= 0){
                System.out.println("---仓库为空---");
                fullCondition.await();
            }
            T res = list.removeFirst();
            System.out.println("已取商品");
            emptyCondition.signalAll();
            return res;
        } catch (InterruptedException e) {}
        finally {
            lock.unlock();
        }
        return null;
    }
    
    public void put(T t){
        try {
            lock.lock();
            if(list.size() >= MAX){
                System.out.println("---仓库已满---");
                emptyCondition.await();
            }
            list.add(t);
            System.out.println("新增商品");
            fullCondition.signalAll();
        } catch (Exception e) {
        } finally{
          lock.unlock();  
        }
    }
    
    public static void main(String[] args) {
        final Repository<Integer> rep = new Repository<Integer>();
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    rep.get();
                }
            }
        });
        es.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    rep.put(1);
                }
            }
        });
        
    }
    
}
