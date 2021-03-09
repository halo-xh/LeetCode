package com.xh.dp;

import java.util.Arrays;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/4 21:00
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 输入：nums = [10,1,2,5,5,3,101,18]
 * 1 1 2 2 2 3 4 4
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4
 * <p>
 * [4,10,4,3,8,9]
 * 0,1,0,3,2,3
 */
public class LengthOfLIS {

    // 调试方法，以观察是否运行正确
    private void printArray(int num, int[] tail) {
        System.out.print("当前数字：" + num);
        System.out.print("\t当前 tail 数组：");
        int len = tail.length;
        for (int i = 0; i < len; i++) {
            if (tail[i] == 0) {
                break;
            }
            System.out.print(tail[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        int lengthOfLIS = lengthOfLIS2(nums);
        System.out.println("最长上升子序列的长度：" + lengthOfLIS);
    }

    // O(n^2)
    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        int[] res = new int[length];
        Arrays.fill(res, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                // 继续遍历 前面所有 , 取值比当前值小的对应的最大的res
                if (nums[i] > nums[j]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
        }
        int max = 0;
        for (int re : res) {
            max = Math.max(re, max);
        }
        return max;
    }

    public static int lengthOfLIS2(int[] nums) {
        int[] lis = new int[nums.length];
        lis[0] = nums[0];
        int lenlis = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lis[lenlis]) {
                // 大于数组的最后一个值（也就是最大值） 直接加在末尾
                lis[++lenlis] = nums[i];
            }
            // 小于 查找第一个比num[i] 大的数
            int left = 0;
            int right = lenlis;
            while (left < right) {
                int mid = left + (right - left) >>> 1;
                if (nums[i] > lis[mid]) {
                    left = mid+1;
                } else {
                    right = mid;
                }
            }
            lis[left] =nums[i];


        }
        return ++lenlis;
    }


}
