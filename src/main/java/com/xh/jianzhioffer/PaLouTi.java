package com.xh.jianzhioffer;

/**
 * author  Xiao Hong
 * date  2020/9/21 0:05
 * description
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */

public class PaLouTi {

    /**
     * O(n)
     */
    public static int climbStairs(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }
        return arr[n - 1];

    }


    /**
     * O(logN)
     * <p>
     * 组合数学。。 大佬。
     */
    public static int mathss(int n) {
        double d = Math.sqrt(5);
        n = n + 1;
        return (int) ((Math.pow((1 + d) / 2, n) - Math.pow((1 - d) / 2, n)) / d + 0.5);
    }


}
