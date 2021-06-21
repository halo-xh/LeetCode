package com.xh.dp;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/6/10 9:59
 * @description
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[amount - coin];

            }
        }

        return 0;
    }


}
