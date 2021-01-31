package com.xh.dp;

/**
 * author  Xiao Hong
 * date  2020/11/22 18:22
 * description
 * <p>
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */

public class JianShengZi {
    public static void main(String[] args) {
        System.out.println(cuttingRope(5));
    }

    public static int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] maxs = new int[n + 1];
        maxs[1] = 1;
        maxs[2] = 2;
        maxs[3] = 3;
        for (int i = 4; i < n + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                maxs[i] = Math.max(maxs[i], maxs[i - j] * maxs[j]);
            }
        }
        return maxs[n];
    }
}
