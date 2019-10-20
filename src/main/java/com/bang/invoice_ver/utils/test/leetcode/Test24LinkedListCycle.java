package com.bang.invoice_ver.utils.test.leetcode;

/**
 * 
 * Description: 测试给定的链表上是否有环；
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月31日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class Test24LinkedListCycle {
    
    /**
     * 
     * Description: 在链表的头部建立一个每次走两步的快指针和一个每次走一步的慢指针，然后如果有环两个指针终将走到环上，并且两个指针每次举例减小一步，终将会重合；
     * @param
     * @return boolean
     * @throws
     * @Author wangxinbang
     * Create Date: 2019年8月31日 下午6:28:20
     */
    public static boolean getRes(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(null, 4);
        ListNode l2 = new ListNode(l1, 3);
        ListNode l3 = new ListNode(l2, 2);
        ListNode l4 = new ListNode(l3, 1);
        l1.next = l3;
//        System.out.println(l4.getListString());
        System.out.println(getRes(l4));
    }

}
