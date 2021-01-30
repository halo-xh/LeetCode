package jianzhioffer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/30 14:57
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class ReversePrint {

    private int[] res;
    private int size;
    private int index =0;

    public int[] reversePrint(ListNode head) {
        reversePrint2(head);
        return res;
    }

    public void reversePrint2(ListNode head) {
        if (head != null) {
            size++;
            reversePrint2(head.next);
            res[index++] = head.val;
        } else {
            /// 只会执行一次。 最后一次 。
            if (res == null) {
                res = new int[size];
            }
        }
    }

    public int[] reversePrint3(ListNode head) {
        int size = 0;
        List list = new ArrayList();
        while (head.next!=null){
            size++;
            list.add(head.val);
        }
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[size -1 -i] = (int) list.get(i);
        }
        return res;

    }










    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
