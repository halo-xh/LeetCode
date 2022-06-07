package com.xh.search;

import java.text.BreakIterator;
import java.util.HashMap;

/**
 * author  Xiao Hong
 * date  2021/9/16 22:42
 * description
 */

public class BinarySearch {

    private final static int[] arr = new int[]{1, 2, 3, 4, 5, 6};
    private final static int[] arr1 = new int[]{1, 2, 3, 3, 4, 4, 5, 6};
    //    private final static int[] arr2 = new int[]{3,3,7,7,10,11,11};
    private final static int[] arr2 = new int[]{1, 1, 2, 3, 3};

    public static void main(String[] args) {
        System.out.println(solution(4, arr1));
        System.out.println(solution2(4, arr1));
        System.out.println(singleNonDuplicate(arr2));

        System.out.println("tableSizeFor(7) = " + tableSizeFor(3));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
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

    /**
     * 11 22 3 44 55
     * 01 23 4 56 78
     * 如果mid 为奇数
     * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
     */
    public static int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if ((mid & 1) == 0) {
                if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[right];
    }

}
