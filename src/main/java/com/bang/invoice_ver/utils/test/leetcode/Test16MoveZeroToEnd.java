package com.bang.invoice_ver.utils.test.leetcode;

import java.util.Arrays;

/**
 * 
 * Description: 将数组中所有的0元素移动到末尾；
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月30日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class Test16MoveZeroToEnd {
    
    /**
     * 
     * Description: 创建两个从头开始的指针，A指针用于从前到后遍历整个数组，并把不为0的元素赋值到B指针的位置，然后B指针向后移动一个元素；
     * @param
     * @return int[]
     * @throws
     * @Author wangxinbang
     * Create Date: 2019年8月30日 下午10:43:23
     */
    private static int[] getRes(int[] nums){
        int i=0;
        for(int j=0; j<nums.length; j++){
            if(nums[j]!=0){
                nums[i]=nums[j];
                i++;
            }
        }
        for(int j=i; j<nums.length; j++){
            nums[j]=0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,0,0,3,4,5};
        System.out.println(Arrays.toString(getRes(nums)));
    }
    
}
