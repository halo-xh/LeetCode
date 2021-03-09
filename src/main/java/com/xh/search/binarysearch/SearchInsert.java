package com.xh.search.binarysearch;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/5 12:48
 * <p>
 * https://leetcode-cn.com/problems/search-insert-position/
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 */
public class SearchInsert {

//
//    public static int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left <= right) { // end left  = right + 1;
//            int mid =  left + ((right - left) >>> 1);
//            if (target > nums[mid]) {
//                left = mid + 1;
//            } else if (target < nums[mid]){
//                right = mid - 1;
//            }else {
//                return mid;
//            }
//        }
//        return -1;
//    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) >>> 1;
            if (target > nums[mid]) {
                left = mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                return mid;
            }
        }
        return left;
    }

}
