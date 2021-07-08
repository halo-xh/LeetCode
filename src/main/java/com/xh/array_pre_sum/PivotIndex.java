package com.xh.array_pre_sum;

import java.util.Arrays;

/**
 * author  Xiao Hong
 * date  2021/7/8 22:56
 * description https://leetcode-cn.com/problems/find-pivot-index/
 */

public class PivotIndex {


    public static void main(String[] args) {
        int[] a = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(a));
    }

    public static int pivotIndex(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        System.out.println("sum = " + Arrays.toString(sum));
        int sumall = sum[sum.length - 1];
        for (int i = 1; i < sum.length; i++) {
            if (sum[i] - nums[i - 1] == sumall - sum[i]) {
                return i - 1;
            }
        }
        return -1;
    }
}
