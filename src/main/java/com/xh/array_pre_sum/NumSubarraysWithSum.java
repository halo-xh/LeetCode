package com.xh.array_pre_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/7/8 16:40
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 */
public class NumSubarraysWithSum {

    public static void main(String[] args) {
        NumSubarraysWithSum numSubarraysWithSum = new NumSubarraysWithSum();
        int[] arr = new int[]{0, 0, 0, 0, 0};
        System.out.println(numSubarraysWithSum.numSubarraysWithSum2(arr, 0));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            count += map.getOrDefault((sum - goal), 0);
        }
        return count;
    }

    public int numSubarraysWithSum2(int[] nums, int goal) {
        int count = 0;
        // 用于记录遍历到的前 j 项差值的个数。key 差值 value：出现的次数。
        Map<Integer, Integer> map = new HashMap<>();
        int[] sumArr = new int[nums.length + 1];
        // 前缀和 数组
        for (int i = 1; i <= nums.length; i++) {
            sumArr[i] += nums[i - 1] + sumArr[i - 1];
        }
        for (int sum : sumArr) {
            // 差值
            int cha = sum - goal;
            // map 中已经存了的（就是前面已经遍历过的
            count += map.getOrDefault(cha, 0);
            // 放入当前值
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
