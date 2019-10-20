package com.bang.invoice_ver.utils.test;

/**
 * 
 * Description: 测试不可变对象
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月6日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class TestImmutableObject {

    public static void main(String[] args) {
        Gold gold = new Gold("111", "222");
        System.out.println(gold);
    }
    
}

/** 黄金 **/
final class Gold {
    private final String id;
    private final String weight;
    public Gold(String id, String weight){
        this.id = id;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "id=" + id + ",weight=" + weight;
    }
}
