package com.bang.invoice_ver.utils.test;


/**
 * 
 * Description: 测试static修饰符
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月10日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class TestStatic {
    
    Person person = new Person("TestStatic");
    
    static{
        System.out.println("teststatic static");
    }
    
    public TestStatic() {
        System.out.println("teststatic constructor");
    }
    
    public static void main(String[] args) throws InterruptedException {
        new MyClass();
    }

}

class Person{
    
    static{
        System.out.println("person static");
    }
    
    public Person(String str) {
        System.out.println("person" + str);
    }
    
}

/** MyClass **/
class MyClass extends TestStatic{
    
    Person person = new Person("MyClass");
    
    static{
        System.out.println("myclass static");
    }
    
    public MyClass() {
        System.out.println("myclass constructor");
    }
    
}
