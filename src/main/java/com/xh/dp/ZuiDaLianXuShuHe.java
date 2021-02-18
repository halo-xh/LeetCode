package com.xh.dp;

/**
 * author  Xiao Hong
 * date  2020/9/20 20:01
 * description
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ZuiDaLianXuShuHe {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int max = arr[0];
        int sum = 0;
        for (int value : arr) {
            sum = Math.max(value + sum, value);
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     *
     * dp[i]代表着以nums[i]为结尾的最大子序和
     * 例如： 3 -1 3 dp[2] 为 2 而不是3, 因为先保证连续。
     *    最后的结果是dp 中的最大值。
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }




        return -1;
    }


}
