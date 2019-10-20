package com.bang.invoice_ver.utils.test;

import java.util.LinkedList;

/**
 * 
 * Description: 生产者消费者模型
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年9月1日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class TestProducerAndConsumer {
    
    public static void main(String[] args) {
        final PRepository<Object> pr = new PRepository<Object>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        pr.put(new Object());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        pr.get();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}

class PRepository<T>{
    
    private final LinkedList<T> list = new LinkedList<T>();
    private final int MAX = 10;
    public T get() throws Exception{
        try{
            synchronized (this) {
                while(list.size() == 0){
                    System.out.println("---仓库已空---");
                    this.wait();
                }
                T t = list.pollFirst();
                System.out.println("---已取元素---");
                this.notifyAll();
                Thread.sleep(300);
                return t;
            }
        }catch(Exception e){
            throw e;
        }
    }

    public void put(T t){
        try{
            synchronized (this) {
                while(list.size() >= MAX){
                    System.out.println("---仓库已满---");
                    this.wait();
                }
                list.add(t);
                System.out.println("---已放元素---");
                this.notifyAll();
                Thread.sleep(300);
            }
        }catch(Exception e){
        }
    }
    
}
