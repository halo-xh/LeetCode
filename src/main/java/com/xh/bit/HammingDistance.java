package com.xh.bit;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/5/27 9:16
 * @description
 */
public class HammingDistance {


    public static void main(String[] args) {
        System.out.println(1 ^ 4);
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        int a = x ^ y;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += 1 & (a >> i);
        }
        return res;
    }


    /**
     * https://leetcode-cn.com/problems/base-7/submissions/
     *
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        boolean less0 = num < 0;
        if (less0) num = -num;
        StringBuffer buffer = new StringBuffer();
        do {
            buffer.append(num % 7);
            num /= 7;
        } while (num != 0);
        buffer.reverse();
        return less0 ? "-" + buffer : buffer.toString();
    }
}
