package com.xh.array_pre_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * author  Xiao Hong
 * date  2021/7/8 23:41
 * description  https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 * 也就是变个形而已， 把和改成了奇数个数
 */

public class NumberOfSubarrays {

    public static void main(String[] args) {
        int[] ar = new int[]{1, 1, 2, 1, 1};
        System.out.println(numberOfSubarrays(ar, 3));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int[] sumJi = new int[nums.length + 1];
        for (int i = 1; i < sumJi.length; i++) {
            sumJi[i] = sumJi[i - 1] + (((nums[i - 1] & 1) == 1) ? 1 : 0);
        }
        System.out.println(Arrays.toString(sumJi));
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1);
        for (int j : sumJi) {
            int ct = j - k;
            count += map.getOrDefault(ct, 0);
            map.putIfAbsent(j, map.getOrDefault(j, 0) + 1);
        }
        System.out.println(map);
        return count;
    }

    public static int numberOfSubarrays2(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int odd = 0, ans = 0;
        cnt[0] = 1;
        for (int num : nums) {
            odd += num & 1;
            ans += odd >= k ? cnt[odd - k] : 0;
            cnt[odd] += 1;
        }
        return ans;
    }
}
