package com.bang.invoice_ver.utils.test.leetcode;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * Description: 从给定的一个字符串中查询出不重复的最长子字符串长度
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月31日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class Test19LongestSubString {
    
    /**
     * 
     * Description: 使用map存储字符出现的坐标最大值，遍历String的字符数组，分别去map中查询是否有对应的坐标值i，如果没有则说明之前没有出现过这个字符，
     *      则将它的长度为当前坐标+1（坐标-（-1））,如果有value则用当前坐标值i-value代表这个字符之间目前的最大长度，分别去跟目前缓存的max比较，取较大的值；
     * @param
     * @return int
     * @throws
     * @Author wangxinbang
     * Create Date: 2019年8月31日 下午1:34:26
     */
    private static int getRes(String reqStr){
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int l = reqStr.length();
        for(int i=0; i<l; i++){
            char s = reqStr.charAt(i);
            Integer pos_index = map.get(s);
            if(pos_index == null){
                pos_index = -1;
            }
            max = Math.max(max, i-pos_index);
            map.put(s, i);
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(getRes("abcabc"));
        System.out.println(getRes("ababab"));
        System.out.println(getRes("abcde"));
        System.out.println(getRes("bbbbbb"));
    }

}
