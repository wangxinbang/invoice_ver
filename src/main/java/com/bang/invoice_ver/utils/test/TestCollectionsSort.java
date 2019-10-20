package com.bang.invoice_ver.utils.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * Description: 测试集合类排序。
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月5日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class TestCollectionsSort {

    public static void main(String[] args) {
        Book b1 = new Book(2, "资治通鉴", 26);
        Book b2 = new Book(4, "三国志", 21);
        Book b3 = new Book(3, "水浒传", 22);
        Book b4 = new Book(5, "红楼梦", 23);
        Book b5 = new Book(6, "原则", 24);
        Set<Book> ts = new TreeSet<Book>();
        ts.add(b1);
        ts.add(b2);
        ts.add(b3);
        ts.add(b4);
        ts.add(b5);
        System.out.println(ts);
        List<Book> l = new ArrayList<Book>();
        l.add(b1);
        l.add(b2);
        l.add(b3);
        l.add(b4);
        l.add(b5);
        System.out.println(l);
        Collections.sort(l, new BookComparator());
        System.out.println(l);
    }
    
}

class Book1{}

/** 书类 **/
class Book implements Comparable<Book> {

    /** 书id **/
    public int id;
    /** 书名 **/
    public String name;
    /** 价格 **/
    public float price;
    
    public Book(int id, String name, float price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "本书内容：【id："+ this.id +"】【name:" + name + "】【price:" + price + "】"; 
    }
    
    @Override
    public int compareTo(Book o) {
        return this.id - o.id;
    }
}

class BookComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {
        return (int)(o1.price - o2.price);
    }
    
}
