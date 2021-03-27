package com.xh.linkedlist;

import com.xh.common.ListNode;

/**
 * author  Xiao Hong
 * date  2021/3/27 12:02
 * description
 * <p>
 * https://leetcode-cn.com/problems/rotate-list/
 */

public class RotateRight {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        System.out.println(rotateRight(listNode, 1));
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // 计算有效的 k 值：对于与链表长度成整数倍的「旋转」都是没有意义的（旋转前后链表不变）
        int len = 0;
        ListNode tmp = head;
        while (tmp != null && ++len > 0) tmp = tmp.next;
        k %= len;
        if (k == 0) return head;

        // 使用「快慢指针」找到倒数第 k 个节点（新头结点）：slow 会停在「新头结点」的「前一位」，也就是「新尾结点」
        //ListNode slow = head, fast = head;
        //while (k-- > 0) fast = fast.next;
        //while (fast.next != null) {
        //    slow = slow.next;
        //    fast = fast.next;
        //}
        ListNode slow = head, fast = head.next;
        for (int i = 0; i < len - k - 1; i++) {
            slow = slow.next;
            fast = fast.next;
        }
        // 保存新头结点，并将新尾结点的 next 指针置空
        ListNode nHead = slow.next;
        slow.next = null;
        // 将新链表的前半部分（原链表的后半部分）与原链表的头结点链接上
        fast.next = head;
        return nHead;
    }

    /**
     * 成环
     */
    public ListNode rotateRight3(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // 先将链表成环，并记录链表的长度
        // tmp 会记录住原链表最后一位节点
        int tot = 0;
        ListNode tmp = head;
        while (tmp.next != null && ++tot > 0) tmp = tmp.next;
        tot++;
        k %= tot;
        if (k == 0) return head;

        // 正式成环
        tmp.next = head;

        // 从原链表 head 出发，走 tot - k - 1 步，找到「新尾结点」进行断开，并将其下一个节点作为新节点返回
        k = tot - k - 1;
        while (k-- > 0) head = head.next;
        ListNode nHead = head.next;
        head.next = null;
        return nHead;
//        作者：AC_OIer
//        链接：https://leetcode-cn.com/problems/rotate-list/solution/kuai-man-zhi-zhen-ru-he-fen-bu-zou-jie-j-ns7u/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }


    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        ListNode end = cur;
        int r = k % len;
        cur = head;
        for (int i = 0; i < len - r - 1; i++) {
            cur = cur.next;
        }
        ListNode res = len > 1 ? cur.next : cur;
        cur.next = null;
        end.next = len > 1 ? head : null;
        return res;
    }

}
