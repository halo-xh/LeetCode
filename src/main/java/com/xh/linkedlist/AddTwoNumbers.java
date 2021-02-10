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
        ListNode head = null;
        boolean add = false;
        while (l1 != null || l2 != null) {
            int val = l1 != null && l2 != null ? l1.val + l2.val : l1 != null && l2 == null ? l1.val : l2.val;
            int nval = add ? val + 1 : val;
            if (val > 9) {
                nval = val % 10;
                add = true;
            }
            head = new ListNode(nval);
            head = head.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return head;

    }
}
