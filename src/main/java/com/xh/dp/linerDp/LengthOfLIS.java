package com.xh.dp.linerDp;

import java.util.Arrays;

/**
 * author  Xiao Hong
 * date  2021/3/13 13:24
 * description
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */

public class LengthOfLIS {

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{10, 9, 2, 8, 5, 11, 3, 17, 101, 18}));
    }

    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
        }
        int r = 0;
        for (int re : res) {
            r = Math.max(re, r);
        }
        return r;
    }

    // 21-11-10. 以i为结尾的最长子串
    public int lengthOfLIS2(int[] nums) {
        int length = nums.length;
        int[] res = new int[length + 1];
        for (int i = 0; i < length; i++) {
            int formerMaxLen = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    formerMaxLen = Math.max(formerMaxLen, res[j]);
                }
            }
            res[i] = ++formerMaxLen;
        }
        int rs = 1;
        for (int re : res) {
            rs = Math.max(rs, re);
        }
        return rs;
    }
}
