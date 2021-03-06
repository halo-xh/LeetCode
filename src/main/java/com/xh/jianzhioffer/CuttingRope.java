package com.xh.jianzhioffer;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/4 10:08
 * @description https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
 * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class CuttingRope {

    public static void main(String[] args) {
        System.out.println(cuttingRope(4));
    }

    /**
     * n 最大 等于
     */
    public static int cuttingRope(int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 2;
        }
        int mod = (int) 1e9 + 7;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i / 2; j++) {
                dp[i] = Math.max(dp[i], (dp[j] * dp[i - j])) % mod;
            }
        }
        return dp[n];

    }
}
