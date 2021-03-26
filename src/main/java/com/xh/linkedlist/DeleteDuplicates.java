package com.xh.linkedlist;

import com.xh.common.ListNode;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/25 13:37
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * <p>
 * 1->2->3->3->4
 * 1->2->4
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        ListNode listNode1 = deleteDuplicates2(listNode);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode();
        return dummy.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                tail.next = head;
                tail = head;
            }
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }

}
