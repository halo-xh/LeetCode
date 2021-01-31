package com.xh.linkedlist;

/**
 * author  Xiao Hong
 * date  2020/9/16 19:50
 * description
 */

public class CheckCircle {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n4;
        System.out.println(chkCircle(n1));
        System.out.println(circleLen(n1));
        System.out.println(getCircleStart(n1));
    }

    /**
     * 双指针法 （Floyd解法）判断有无环
     *
     * @param head node list
     * @return result
     */
    private static boolean chkCircle(Node head) {
        Node slow = head;
        Node fast = head;// 同一起点
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next; //步长为2
            if (slow == fast) { //追及
                return true;
            }
        }
        return false;
    }

    /**
     * 判断有无环 并返回环长度
     *
     * @param head linked list
     * @return length
     */
    private static int circleLen(Node head) {
        Node slow = head;
        Node fast = head;
        int hi = 0;
        int len = 0;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hi++;
                if (hi == 2) {// 第二次相遇
                    return len;
                } else {// 第一次相遇。 清空计数开始真正计算一圈的长度
                    len = 0;
                }
            }
            len++;//计数步长
        }
        return -1;//无环
    }

    /**
     * 判断环的起点
     *
     * @param head linked list
     * @return start node
     */
    private static Node getCircleStart(Node head) {
        Node slow = head;
        Node fast = head;
        boolean cir = false;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cir = true;
                break;
            }
        }
        if (cir) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }


    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
}
