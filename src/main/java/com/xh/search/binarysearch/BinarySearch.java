package com.xh.search.binarysearch;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/6 14:39
 * @description https://leetcode-cn.com/problems/binary-search/
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * https://leetcode.cn/problems/sqrtx/
     */
    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int l = i + 1, r = numbers.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (target - numbers[i] < numbers[mid]) {
                    r = mid - 1;
                } else if (target - numbers[i] > numbers[mid]) {
                    l = mid + 1;
                } else {
                    return new int[]{i + 1, mid + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        BinarySearch binarySearch = new BinarySearch();
        int search = binarySearch.search2(arr, 4);
        System.out.println("search = " + search);
        System.out.println("binarySearch.mySqrt(4) = " + binarySearch.mySqrt(1));
    }
}
