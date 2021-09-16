package com.xh.search;

import java.text.BreakIterator;

/**
 * author  Xiao Hong
 * date  2021/9/16 22:42
 * description
 */

public class BinarySearch {

    private final static int[] arr = new int[]{1, 2, 3, 4, 5, 6};
    private final static int[] arr1 = new int[]{1, 2, 3, 3, 4, 4, 5, 6};
    private final static int[] arr2 = new int[]{4, 5, 6, 1, 2, 3};

    public static void main(String[] args) {
        System.out.println(solution(4, arr1));
        System.out.println(solution2(4, arr1));
    }

    /**
     * solution here
     */
    public static int solution(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid;
            } else {
                return left;
            }
        }
        return -1;
    }


    /**
     * solution here
     */
    public static int solution2(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return left;
            }
        }
        return -1;
    }


    //https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
    public int search(int[] nums, int target) {
        //第一次二分 分割点
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] <= nums[right]) {
                // 向左
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int cut = left;
        if (nums[0] > target) {
            // 右边
            left = cut;
            right = nums.length - 1;
        }
        if (nums[0] <= target) {
            //左边
            left = 0;
            right = cut;
        }
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 向左
                right = mid - 1;
            } else {
                return left;
            }
        }
        return -1;
    }


}
