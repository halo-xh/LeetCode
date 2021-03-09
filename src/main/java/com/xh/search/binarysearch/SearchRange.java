package com.xh.search.binarysearch;

import java.util.Arrays;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/6 14:42
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 */
public class SearchRange {

    public static void main(String[] args) {
        int a = 3 + (6 - 2) >>> 1;
        System.out.println("a = " + a);
        int[] ints = {2, 3, 3, 5};
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(ints, 9)));
//        System.out.println(Arrays.toString(searchRange1(ints, 9)));
    }

    // o(n)
    public static int[] searchRange1(int[] nums, int target) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && start == -1) {
                start = i;
            }
            if (nums[i] == target && start != -1) {
                end = i;
            }
        }
        return new int[]{start, end};
    }

    //O(log2n)
    public int[] searchRange(int[] nums, int target) {
        int start = findleft(nums, target);
        int end = findright(nums, target);
        if (start > end) {
            return new int[]{-1, -1};
        }
        return new int[]{start, end};

    }


    public int findleft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            /**
             *  此时 即使查找的到中间数就是target 但是，前面也许存在相同数，所以继续向前搜索。 这里同时和return left 对应。
             */
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left; // 返回left。 最后跳出循环时 left = right +1. left在right右边
    }

    public int findright(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            /**
             *  此时 即使查找的到中间数就是target 但是，后面也许存在相同数，所以继续向后搜索。这里同时和return right 对应。
             */
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right; // 返回right
    }

}
