package com.bang.invoice_ver.utils.test.leetcode;

/**
 * 
 * Description: 测试爬楼梯，n阶台阶，一次可以爬一阶或者两阶，一共有多少种走法；
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月30日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class Test13ClimbingStairs {
    
    /**
     * 
     * Description: 面对一阶台阶有两种走法，一种走一阶，一种走两阶；每次走完一次台阶之后判断如果当前位置大于总台阶数说明没有这种走法（最后一阶想走两阶），
     *      如果当前位置等于台阶数说明是一种成功的记一次；
     * @param
     * @return int
     * @throws
     * @Author wangxinbang
     * Create Date: 2019年8月30日 下午8:03:47
     */
    private static int get_res(int now_stairs, int all_stairs){
        if(now_stairs > all_stairs){
            return 0;
        }
        if(now_stairs == all_stairs){
            return 1;
        }
        return get_res(now_stairs + 1, all_stairs) + get_res(now_stairs + 2, all_stairs);
    }
    
    public static void main(String[] args) {
        System.out.println(get_res(0, 2));
        System.out.println(get_res(1, 2));
        System.out.println(get_res(0, 3));
    }

}
