package com.xh.dp.linerDp;

/**
 * author  Xiao Hong
 * date  2021/3/30 20:30
 * https://leetcode-cn.com/problems/maximum-subarray/submissions/
 * [-2,1,-3,4,-1,2,1,-5,4]
 */

public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(MaxSubArray.maxSubArray(new int[]{0}));
    }

    public static int maxSubArray(int[] nums) {
        // 表示 已经包括 nums[i] 时 到 index i的子数组的最大值 ------> 无后效性
        int[] arr = new int[nums.length];
        int max = arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.max(nums[i] + arr[i - 1], nums[i]);
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
