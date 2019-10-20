package com.bang.invoice_ver.utils.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Description: 排序
 * 
 * @author wangxinbang
 * @version 1.0
 * 
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年9月8日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class TestSort {
    
    public static void main(String[] args) {
        Integer[] list = new Integer[]{1,4,8,3,7,5,2,6};
        _quickSort(list, 0, list.length - 1);
        System.out.println(Arrays.asList(list));
        System.out.println(getWS(1000));
    }
    
    public static int getMiddle(Integer[] list, int low, int high) {
        int tmp = list[low];
        while (low < high) {
            while (low < high && list[high] > tmp) {
                high--;
            }
            list[low] = list[high];
            while (low < high && list[low] < tmp) {
                low++;
            }
            list[high] = list[low];
        }
        list[low] = tmp;
        return low;
    }
    public static void _quickSort(Integer[] list, int low, int high) {  
        if (low < high) {  
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二  
            _quickSort(list, low, middle - 1);        //对低字表进行递归排序  
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序  
        }  
    } 
    public static List<Integer> getWS(int c){
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 1 ; i <= c ; i++){
            int sum = 0;
            for(int j = 1 ; j <= i/2 ; j++){
                if(i%j == 0){
                    sum += j;
                }
            }
            if(i == sum){
                list.add(sum);
            }
        }
        return list;
    }
}
