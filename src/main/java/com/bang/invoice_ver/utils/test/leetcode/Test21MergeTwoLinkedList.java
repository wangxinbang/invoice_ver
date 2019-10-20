package com.bang.invoice_ver.utils.test.leetcode;

/**
 * 
 * Description: 合并两个链表
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月31日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class Test21MergeTwoLinkedList {
    
    /**
     * 
     * Description: 采用递归的算法，比较两个链表的元素，较小值作为头部，较小值的后续节点再继续去比较，直到出现一个链表结束；
     * @param
     * @return ListNode
     * @throws
     * @Author wangxinbang
     * Create Date: 2019年8月31日 下午3:01:16
     */
    private static ListNode getRes(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = getRes(l1.next, l2);
            return l1;
        }else{
            l2.next = getRes(l1, l2.next);
            return l2;
        }
    }
    
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(null, 5);
        ListNode listNode2 = new ListNode(listNode1, 4);
        ListNode listNode3 = new ListNode(listNode2, 1);
        ListNode listNode4 = new ListNode(null, 3);
        ListNode listNode5 = new ListNode(listNode4, 2);
        ListNode listNode6 = new ListNode(listNode5, 0);
        System.out.println(listNode3.getListString());
        System.out.println(listNode6.getListString());
        System.out.println(getRes(listNode3, listNode6).getListString());
    }

}
