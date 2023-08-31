package com.xh.linkedlist;

import com.xh.common.ListNode;

/**
 * @author Xiao Hong
 * @since 2023-08-31
 * <p>
 * https://leetcode.cn/problems/sort-list/submissions/
 */
public class SortList {


    public static void main(String[] args) {

    }


    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (next != null && next.val < current.val) {
                current.next = next.next;
                next.next = null;
                // 插入 1324 1234
                insert(dummy, next);
            } else {
                current = next;
            }
        }
        return dummy.next;
    }

    private static void insert(ListNode dummy, ListNode next) {
        ListNode pre = dummy;
        ListNode c = pre.next;
        while (c != null) {
            if (c.val > next.val) {
                next.next = c;
                pre.next = next;
                return;
            }
            pre = c;
            c = c.next;
        }
    }

}
