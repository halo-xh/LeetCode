package com.xh.common;


/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/10 11:22
 * @description
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode n = next;
        StringBuilder builder = new StringBuilder(" " + val);
        while (n != null) {
            builder.append(" -> ").append(n.val);
            n = n.next;
        }
        return builder.toString();
    }
}
