package com.xh.others;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/29 9:10
 * @description https://leetcode-cn.com/problems/reverse-bits/
 */
public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(3));
    }

    /**
     * int 32位
     * 一个左移一个右移.
     * 遇见n右移末尾为1则RES左移位加1
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            // 末尾为1 则加1
            res += (n & 1);
            n >>= 1;
        }
        return res;
    }
}
