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

    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

            }
        }
        return 0;
    }
}
