package com.xh.dp;

import java.util.Arrays;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/15 20:35
 * <p>
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class Rob2 {

    public static void main(String[] args) {
        Rob2 rob2 = new Rob2();
        System.out.println(rob2.rob(new int[]{1, 2, 3, 1}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, nums.length -1)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 1, nums.length )));
        int i = rob1(Arrays.copyOfRange(nums, 0,nums.length - 1));
        int i1 = rob1(Arrays.copyOfRange(nums, 1, nums.length ));
        return Math.max(i,i1);
    }

    public static int rob1(int[] nums) {
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
