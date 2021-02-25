package com.xh.dp;

/**
 * https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 * <p>
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 */

public class MaxSatisfied {

    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{4, 10, 10}, new int[]{1, 1, 0}, 2));
    }

    /**
     * 先把 customers 中满意的全部加入， 且把满意的值都变为0；
     * 再找 处理后的customers中的连续 X 长度的最大值。
     */
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int length = customers.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
                customers[i] = 0;
            }
        }
        int hh = 0;
        for (int i = 0; i <= length - X; i++) {
            int temp = 0;
            for (int i1 = i; i1 < X + i; i1++) {
                temp += customers[i1];
            }
            hh = Math.max(temp, hh);
        }
        return sum + hh;
    }

}
