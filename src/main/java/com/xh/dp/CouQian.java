package com.xh.dp;

/**
 * author  Xiao Hong
 * date  2020/9/22 22:31
 * description
 * {1, 5, 10, 20, 50, 100} 凑1000 多少种方法？
 */

public class CouQian {
    public static void main(String[] args) {
        System.out.println(solution(1000));
        System.out.println(count(5, 1000));

    }

    /**
     * solution here
     */
    public static int solution(int n) {
        int[] money = new int[]{1, 5, 10, 20, 50, 100};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int value : money) {
            for (int j = value; j <= n; ++j) {
                dp[j] = dp[j] + dp[j - value];
            }
        }
        return dp[n];
    }


    public static int count(int i, int n) {
        int[] coins = {1, 5, 10, 20, 50, 100};
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        /*分解成一定不使用coins[i],和一定使用coins[i]两种方案*/
        return count(i - 1, n) + count(i, n - coins[i]);
    }

}
