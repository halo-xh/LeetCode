package com.xh.search.binarysearch;

import java.util.Arrays;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/6 15:29
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * <p>
 * // 0,1,0,0,0
 * // 1,1,1,3,4,-1,1
 */
public class SearchInRotatedSortedArray2 {

    // O(log2n)
    public static boolean search22(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[0] > target) {// right part
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            } else {
                if (nums[mid] <= nums[0]) {// left part
                    nums[mid] = Integer.MAX_VALUE;
                }
            }

            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return false;
    }

    // O(n)
    public static boolean search(int[] nums, int target) {
        int split = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                split = i;
                break;
            }
        }

        if (nums[split] < target) {
            // 在后半段
            return search2(Arrays.copyOfRange(nums, split, nums.length), target) != -1;
        } else {
            return search2(Arrays.copyOf(nums, split), target) != -1;
        }

    }

    private static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
