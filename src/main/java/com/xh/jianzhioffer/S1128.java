package com.xh.jianzhioffer;

import com.xh.common.ListNode;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Created by Xiao Hong on 2021-11-28
 * </p>
 */
public class S1128 {


    /**
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode(-1);
            ListNode node = head;
            while (list1 != null || list2 != null) {
                if (list1 != null && list2 != null) {
                    if (list1.val > list2.val) {
                        node.next = list2;
                        list2 = list2.next;
                    } else {
                        node.next = list1;
                        list1 = list1.next;
                    }
                } else if (list2 != null) {
                    node.next = list2;
                    list2 = list2.next;
                } else {
                    node.next = list1;
                    list1 = list1.next;
                }
                node = node.next;
            }
            return head.next;
        }

        public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
            ListNode head = new ListNode(-1);
            ListNode node = head;
            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    node.next = list2;
                    list2 = list2.next;
                } else {
                    node.next = list1;
                    list1 = list1.next;
                }
                node = node.next;
            }
            // 合并后 list1 和 list2 : 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
            node.next = list1 == null ? list2 : list1;
            return head.next;
        }

    }

    /**
     * https://leetcode-cn.com/problems/single-number/
     */
    public int singleNumber(int[] nums) {
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }

    /**
     * https://leetcode-cn.com/problems/min-stack/
     */
    class MinStack {

        private Integer min = null;

        private ArrayDeque<String> stack = new ArrayDeque<>();

        public MinStack() {

        }

        public void push(int val) {
            if (min == null) {
                min = val;
            } else {
                min = Math.min(val, min);
            }
            stack.push(val + "," + min);
        }

        public void pop() {
            String pop = stack.pop();
        }

        public int top() {
            String peek = stack.peek();
            if (peek != null) {
                String[] split = peek.split(",");
                return Integer.parseInt(split[0]);
            }
            return -1;
        }

        public int getMin() {
            String peek = stack.peek();
            if (peek != null) {
                String[] split = peek.split(",");
                return Integer.parseInt(split[1]);
            }
            return -1;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    /**
     * https://leetcode-cn.com/problems/linked-list-cycle/
     */
    public boolean hasCycle(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if (l2 == l1) {
                return true;
            }
        }
        return false;
    }

}
