package com.bang.invoice_ver.utils.test.leetcode;

/**
 * 
 * Description: 交换链表两个相邻的值；
 *      输入:1->2->3->4, 输出:2->1->4->3
 * @author wangxinbang
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
------------------------------------------------------------------
 * 2019年8月31日    wangxinbang       1.0        1.0 Version 
 * </pre>
 */
public class Test22SwapNodesInPairs {
    
    /**
     * 
     * Description: 创建一个指向头结点的root节点，然后把root节点拷贝出一份pre节点，然后将pre节点的next和next.next进行交换（前后链表交换）
     *      ，然后将pre指针向后移动到next.next;
     * @param
     * @return ListNode
     * @throws
     * @Author wangxinbang
     * Create Date: 2019年8月31日 下午5:09:36
     */
    private static ListNode getRes(ListNode l){
        ListNode root = new ListNode();
        root.next = l;
        ListNode pre = root;
        ListNode a,b;
        while(pre.next !=null && pre.next.next != null){
            a = pre.next;
            b = a.next;
            pre.next = b;
            a.next = b.next;
            b.next = a;
            pre = a;
        }
        return root.next;
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
