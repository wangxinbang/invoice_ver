package com.bang.invoice_ver.utils.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

/**
 * 
 * Description: 从有序数组中删除重复的字段
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月30日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class Test11RemoveDuplicatesFromSortedArray {
    
    /**
     * 
     * Description: 从数组中取出第一个数据，然后将这个数据跟下一个作比较，如果相同则指针后移一位，如果不同则把指针指向的数据放在这个值的下一个位置
     *      ，然后再取出第二个数据重复进行比对 ，最终结果是得到一个把当前数组替换成一个前部分元素是有序不重复的子集合；
     * @param
     * @return int[]
     * @throws
     * @Author wangxinbang
     * Create Date: 2019年8月30日 下午6:46:44
     */
    public static Object[] removeDuplicates(Integer[] nums){
        int i = 0;
        for(int j=1; j<nums.length; j++){
            if (nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
        }
        List<Integer> l = new ArrayList<Integer>(Arrays.asList(nums));
        for(int k=nums.length-1; k>i; k--){
            l.remove(k);
        }
        return l.toArray();
    }
    
    public static void main(String[] args) {
        Integer[] nums = {0,0,0,0,1};
        Integer[] nums1 = {0,0,1,1,1,2,2,3,4,4,4};
        System.out.println(ArrayUtils.toString(removeDuplicates(nums)));
        System.out.println(ArrayUtils.toString(removeDuplicates(nums1)));
    }

}
