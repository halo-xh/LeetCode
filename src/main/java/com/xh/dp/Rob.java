package com.xh.dp;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/15 20:35
 * <p>
 * https://leetcode-cn.com/problems/house-robber/
 *
 * 自己AC。 olalalala
 */
public class Rob {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
