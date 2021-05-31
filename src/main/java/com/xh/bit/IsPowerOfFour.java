package com.xh.bit;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/5/31 12:34
 * <p>
 * https://leetcode-cn.com/problems/power-of-four/
 */
public class IsPowerOfFour {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(8));
    }

    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
