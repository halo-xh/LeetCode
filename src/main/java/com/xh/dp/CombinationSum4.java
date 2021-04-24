package com.xh.dp;

/**
 * author  Xiao Hong
 * date  2021/4/24 15:02
 * <p>
 * https://leetcode-cn.com/problems/combination-sum-iv/
 */

public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int u : nums) {
                if (j >= u) f[j] += f[j - u];
            }
        }
        return f[target];
    }
}
