package com.xh.linkedlist;

import com.xh.common.ListNode;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/26 12:05
 * @description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 1->2->3->3->4
 * 1->2->3->4
 */
public class DeleteDuplicates2 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        ListNode listNode1 = deleteDuplicates(listNode);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        while (tmp != null) {
            ListNode p1 = tmp.next;
            while (p1 != null && p1.val == tmp.val) {
                p1 = p1.next;
                tmp.next = p1;
            }
            tmp = p1;
        }
        return head;
    }
}
