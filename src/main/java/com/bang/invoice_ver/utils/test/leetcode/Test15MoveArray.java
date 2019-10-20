package com.bang.invoice_ver.utils.test.leetcode;

import java.util.Arrays;

/**
 * 
 * Description: 测试将数组向右移动k位
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月30日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class Test15MoveArray {
    
    /**
     * 
     * Description: 将数组最后一位取出缓存，然后将数组后移一位（从后向前），再将缓存的元素放在数组的第一个位置；
     * @param
     * @return int[]
     * @throws
     * @Author wangxinbang
     * Create Date: 2019年8月30日 下午10:20:45
     */
    private static int[] getRes(int[] num, int k){
        int l = num.length;
        k = k % l;
        for(int i=0; i<k; i++){
            int temp = num[l-1];
            for(int j=l-1; j>0; j--){
                num[j] = num[j-1];
            }
            num[0] = temp;
        }
        return num;
    }
    
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(getRes(num, 5)));
    }

}
