package com.bang.invoice_ver.utils.test.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Description: 给定一个值和一个数组，从数组中查找两个数相加等于这个值的元素坐标；
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月31日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class Test17TwoNumbers {
    
    /**
     * 
     * Description: 将数组先存储到map，key是数组的值，value是数组的下标，然后遍历数组用入参和减去数组内容，使用map的get方法查询得到的值，
     *      如果存在则返回i和数组下标；
     * @param
     * @return int[]
     * @throws
     * @Author wangxinbang
     * Create Date: 2019年8月31日 上午11:54:14
     */
    private static int[] getRes(int[] nums, int value){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
            int subRes = value - nums[i];
            Integer sub = map.get(subRes);
            if(sub != null){
                return new int[]{i, sub};
            }
        }
        throw new RuntimeException("no result");
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(getRes(nums, 18)));
    }
    
}
