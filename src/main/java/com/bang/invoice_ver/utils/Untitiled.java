package com.bang.invoice_ver.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


class Person{
    static{
        System.out.println("Person static");
    }
    public Person(String str){
        System.out.println("Person : " + str);
    }
}

class MyClass extends Test {
    Person person = new Person("MyClass");
    static{
        System.out.println("myClass static");
    }
    public MyClass(){
        System.out.println("MyClass contructor");
    }
}

class Test {
    BlockingQueue<Integer> lbq = new LinkedBlockingQueue<Integer>();
    private static String str = "aaa";
    Person person = new Person("Test");
    static{
        System.out.println("test static");
    }
    {
        
    }
    public Test(){
        System.out.println("test constructor");
    }
    public static void main(String[] args){
        System.out.println(str);
        str = "bbb";
        System.out.println(str);
        System.out.println(Test.str);
    }
}
