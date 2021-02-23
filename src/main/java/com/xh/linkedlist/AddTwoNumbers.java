package com.xh.linkedlist;

import com.xh.common.ListNode;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/10 11:20
 * @description https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        boolean add = false;
        while (l1 != null || l2 != null) {
            int val = l1 != null && l2 != null ? l1.val + l2.val : l1 != null ? l1.val : l2.val;
            int nval = add ? val + 1 : val;
            add = false;
            if (nval > 9) {
                nval = nval % 10;
                add = true;
            }
            current.next = new ListNode(nval);
            current = current.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        // 最后进一位
        if (add) {
            current.next = new ListNode(1);
        }
        return head.next;

    }
}
