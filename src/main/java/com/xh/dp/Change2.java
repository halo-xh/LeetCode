package com.xh.dp;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/6/10 9:40
 * <p>
 * https://leetcode-cn.com/problems/coin-change-2/
 */
public class Change2 {


    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; ++i) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }

}
