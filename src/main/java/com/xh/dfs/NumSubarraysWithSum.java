package com.xh.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/7/8 16:40
 * @description https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 */
public class NumSubarraysWithSum {
    public static void main(String[] args) {
        NumSubarraysWithSum numSubarraysWithSum = new NumSubarraysWithSum();
        int[] arr = new int[]{0, 0, 0, 0, 0};
        System.out.println(numSubarraysWithSum.numSubarraysWithSum2(arr, 0));
    }

    private int count = 0;
    private int goal;
    private int[] nums;

    public int numSubarraysWithSum(int[] nums, int goal) {
        this.goal = goal;
        this.nums = nums;
        dfs(0, 0, 0);
        return count;
    }


    private void dfs(int currentSum, int start, int end) {
        if (start >= nums.length) {
            return;
        }
        if (end >= nums.length) {
            dfs(0, start + 1, start + 1);
        }
        currentSum += nums[end];
        if (currentSum > goal) {
            dfs(0, start + 1, start + 1);
        }
        if (currentSum == goal) {
            count++;
        }
        dfs(currentSum, start, end + 1);
    }

    // 前缀和啊前缀和 todo.
    public int numSubarraysWithSum2(int[] nums, int t) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int r = sum[i + 1], l = r - t;
            ans += map.getOrDefault(l, 0);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        return ans;
    }

}
