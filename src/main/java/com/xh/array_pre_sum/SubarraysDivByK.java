package com.xh.array_pre_sum;

import java.util.HashMap;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/7/9 15:48
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 */
public class SubarraysDivByK {

    public int subarraysDivByK(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int count = 0;
        for (int i = 1; i < sum.length; i++) {
            int key = sum[i] % k;
            count += hashMap.getOrDefault(key, 0);
            hashMap.put(key, hashMap.getOrDefault(key, 0) +1);
        }
        return count;
    }

}
