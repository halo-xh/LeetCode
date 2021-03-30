package com.xh.dp.linerDp;

/**
 * author  Xiao Hong
 * date  2021/3/22 19:46
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */

public class MaxProduct {

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(new int[]{-2, 3, -4}));
    }

    /**
     * 两个数组 分别记录 index i 位置的最大值和最小值 最大的值 是最小值*当前值 或者最大值*当前值
     */
    public int maxProduct(int[] nums) {
        int[] maxs = new int[nums.length];
        int[] mins = new int[nums.length];
        maxs[0] = mins[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxs[i] = Math.max(maxs[i - 1] * nums[i], mins[i - 1] * nums[i]);
            mins[i] = Math.min(maxs[i - 1] * nums[i], mins[i - 1] * nums[i]);
        }
        int max = nums[0];
        for (int i : maxs) {
            max = Math.max(i, max);
        }
        return max;
    }

    /**
     * ||
     * ||
     * \/
     */
    public int maxProduct2(int[] nums) {
        int[] maxs = new int[nums.length];
        int[] mins = new int[nums.length];
        int max = maxs[0] = mins[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxs[i] = Math.max(maxs[i - 1] * nums[i], mins[i - 1] * nums[i]);
            mins[i] = Math.min(maxs[i - 1] * nums[i], mins[i - 1] * nums[i]);
            max = Math.max(maxs[i], max);
        }
        return max;
    }

}
