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
        int[] ar = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println(numberOfSubarrays(ar, 2));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int[] sumJi = new int[nums.length + 1];
        sumJi[0] = 1;
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += (num & 1);
            count += (sum >= k) ? sumJi[sum - k] : 0;
            sumJi[sum]++;
        }
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
