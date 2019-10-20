package com.bang.invoice_ver.utils.test.leetcode;

import java.util.Arrays;

/**
 * 
 * Description: 数字加一，数字拆分成数组，然后对数组进行加一，然后返回；
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月30日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class Test12ArrayPlusOne {
    
    /**
     * 
     * Description: 从最后一位开始，先加一然后对10求余，如果余数不为0则说明没有进位所以直接返回；如果余数为0则对前移指针对下一位加一求余；
     *      如果都为0，则说明是999类型的，所以总位数加1；
     * @param
     * @return int[]
     * @throws
     * @Author wangxinbang
     * Create Date: 2019年8月30日 下午7:50:24
     */
    private static int[] get_res(int[] req_arr){
        for(int i=req_arr.length-1; i>=0; i--){
            req_arr[i] = req_arr[i] + 1;
            req_arr[i] = req_arr[i]%10;
            if(req_arr[i]!=0){
                return req_arr;
            }
        }
        int[] res = new int[req_arr.length + 1]; 
        res[0] = 1;
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {1,2,3,4,9};
        int[] nums3 = {9};
        System.out.println(Arrays.toString(get_res(nums1)));
        System.out.println(Arrays.toString(get_res(nums2)));
        System.out.println(Arrays.toString(get_res(nums3)));
    }

}
