package com.bang.invoice_ver.utils.test.leetcode;

import java.util.Arrays;

/**
 * 
 * Description: 测试合并两个有序数组
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月30日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class Test14MergeSortedArray {
    
    /**
     * 
     * Description: 定义两个指向数组有值部分末尾的指针，进行比较，将较大的值放到最后，然后该指针前移一个单位；
     * @param
     * @return int[]
     * @throws
     * @Author wangxinbang
     * Create Date: 2019年8月30日 下午10:05:22
     */
    private static int[] getRes(int[] arr1, int m, int[]arr2, int n){
        for(int i=(n+m-1); (n>0&&m>0); i--){
            if(arr1[m-1] < arr2[n-1]){
                arr1[i] = arr2[n-1];
                n--;
            }else{
                arr1[i] = arr1[m-1];
                m--;
            }
        }
        if(m==0){
            for(int i=0; i<n; i++){
                arr1[i] = arr2[i];
            }
        }
        return arr1;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1,2,5,6,8,0,0,0};
        int[] arr2 = {2,3,4};
        System.out.println(Arrays.toString(getRes(arr1, arr1.length-arr2.length, arr2, arr2.length)));
    }

}
