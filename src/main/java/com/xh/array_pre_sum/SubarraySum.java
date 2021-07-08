package com.xh.array_pre_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * author  Xiao Hong
 * date  2021/7/8 23:23
 * description https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * {@link NumSubarraysWithSum}
 */

public class SubarraySum {

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        System.out.println(subarraySum(arr, 0));
    }

    public static int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        System.out.println(Arrays.toString(sum));
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1);
        for (int s : sum) {
            int cha = s - k;
            count += map.getOrDefault(cha, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);
        return count;
    }

}
