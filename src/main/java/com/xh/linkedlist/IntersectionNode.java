package com.xh.linkedlist;

import com.xh.common.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
public class IntersectionNode {


    /**
     * 链表相交点 求法
     * <p>
     * 相同的速度，走相同长的路程（A+B）最后一定是一起走到结尾。
     * 所以，A走完自己的路要去走B的，B走完自己额路要去走A的。
     * <p>
     * -> 走到尽头见不到你，于是走过你来时的路，等到相遇时才发现，你也走过我来时的路。
     * -> 错的人就算走过了对方的路也还是会错过.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    //反转连表
    //在遍历链表时，将当前节点的 next 指针改为指向前一个节点。
    // 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
    //
    //https://leetcode-cn.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    // 递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 这个递归的结果实际上就是最后一个节点
        ListNode tail = reverseList2(head);
        head.next.next = head;
        head.next = null;
        return tail;

    }

    /**
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode leftNodePre = dummy;
        for (int i = 0; i < left - 1; i++) {
            leftNodePre = leftNodePre.next;
        }
        ListNode rightNode = dummy;
        for (int i = 0; i < right; i++) {
            rightNode = rightNode.next;
        }
        ListNode leftNode = leftNodePre.next;
        ListNode rightNodeAfter = rightNode.next;
        rightNode.next = null;
        leftNodePre.next = null;
        reverseList(leftNode);
        leftNodePre.next = rightNode;
        leftNode.next = rightNodeAfter;
        return dummy.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode leftPre = dummy;
        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
        }
        ListNode cur = leftPre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = leftPre.next;
            leftPre.next = next;
        }
        return dummy.next;
    }


    /**
     * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     * <p>
     * cur -> cur.next-> cur.next.next
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null && cur.next.next != null) {
            ListNode n = cur.next;
            ListNode nn = cur.next.next;
            cur.next = nn;
            n.next = nn.next;
            nn.next = n;
            cur = n;
        }
        return dummyNode.next;
    }

    /**
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
     * <p>
     * 快慢指针
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }

    /**
     * https://leetcode-cn.com/problems/partition-list/
     * <p>
     * 构建两个连表 一个放大的 一个放小的 最后组合
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode();
        ListNode bigger = new ListNode();
        ListNode b = bigger;
        ListNode s = smaller;
        ListNode h = head;
        while (h != null) {
            if (h.val >= x) {
                b.next = h;
                b = b.next;
            } else {
                s.next = h;
                s = s.next;
            }
            h = h.next;
        }
        // 没有这一行会成环
        b.next = null;
        s.next = bigger.next;
        return smaller.next;
    }


    Map<Node, Node> nodeNodeMap = new HashMap<>();
    //https://leetcode-cn.com/problems/copy-list-with-random-pointer/
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!nodeNodeMap.containsKey(head)){
            Node node = new Node(head.val);
            nodeNodeMap.put(head,node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return nodeNodeMap.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    // https://leetcode-cn.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode c = head;
        while (c != null){
            set.add(c);
            c = c.next;
            if (set.contains(c)){
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(0, new ListNode(5, new ListNode(2))))));
//        ListNode node = new ListNode(2, new ListNode(1));
        IntersectionNode intersectionNode = new IntersectionNode();
        System.out.println("intersectionNode.partition(node,2) = " + intersectionNode.partition(node, 2));
    }


}
