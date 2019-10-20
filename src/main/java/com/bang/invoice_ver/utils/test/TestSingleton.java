package com.bang.invoice_ver.utils.test;

/**
 * 
 * Description: 单例模式测试
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月10日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class TestSingleton {

}

/** 懒汉模式 **/
class LazySingleton{
    
    private static LazySingleton lazySingleton;
    
    private LazySingleton() {
    }

    public static LazySingleton getLazySingleton(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
    
}

/** 饿汉模式 **/
class HungrySingleton{
    
    private static HungrySingleton hungrySingleton = new HungrySingleton();
    
    private HungrySingleton(){
        
    }
    
    public static HungrySingleton getHungrySingleton(){
        return hungrySingleton;
    }
    
}

/** 线程安全的懒汉模式 **/
class ThreadSafeLazySingleton{
    
    private static ThreadSafeLazySingleton threadSafeLazySingleton;
    
    private ThreadSafeLazySingleton(){
        
    }
    
    public static synchronized ThreadSafeLazySingleton getThreadSafeLazySingleton(){
        if(threadSafeLazySingleton == null){
            threadSafeLazySingleton = new ThreadSafeLazySingleton();
        }
        return threadSafeLazySingleton;
    }
    
}

/** 懒汉模式-双检索 **/
class DoubleCheckLazySingleton{
    
    private static volatile DoubleCheckLazySingleton doubleCheckLazySingleton;
    
    private DoubleCheckLazySingleton(){
        
    }
    
    public static DoubleCheckLazySingleton getDoubleCheckLazySingleton(){
        if(doubleCheckLazySingleton == null){
            synchronized (DoubleCheckLazySingleton.class) {
                if(doubleCheckLazySingleton == null){
                    doubleCheckLazySingleton = new DoubleCheckLazySingleton();
                }
            }
        }
        return doubleCheckLazySingleton;
    }
    
}
