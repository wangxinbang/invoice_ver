package com.bang.invoice_ver.utils.test.leetcode;

public class ListNode {
    public ListNode next;
    public int val;
    public ListNode() {
    }
    public ListNode(ListNode next, int val) {
        this.next = next;
        this.val = val;
    }
    public String getListString(){
        StringBuffer sb = new StringBuffer();
        sb.append(val + ",");
        if(this.next != null){
            return sb.append(this.next.getListString()).toString();
        }
        return sb.toString();
    }
}
