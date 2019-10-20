package com.bang.invoice_ver.utils.test.leetcode;

/**
 * 
 * Description:  链表反转
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月31日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class Test23ReverseLinkedList {
    
    /**
     * 
     * Description: 创建一个头结点，头结点指向队列的开始，然后建立一个pre指针指向头结点，cur指针指向队列的开始，将队列的开始的next进行缓存，然后将队列开始的next
     *      指向pre，然后将pre赋值成cur，再将cur复制成next；
     * @param
     * @return ListNode
     * @throws
     * @Author wangxinbang
     * Create Date: 2019年8月31日 下午6:46:32
     */
    private static ListNode getRes(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(null, 4);
        ListNode l2 = new ListNode(l1, 3);
        ListNode l3 = new ListNode(l2, 2);
        ListNode l4 = new ListNode(l3, 1);
        System.out.println(l4.getListString());
        System.out.println(getRes(l4).getListString());
    }

}
