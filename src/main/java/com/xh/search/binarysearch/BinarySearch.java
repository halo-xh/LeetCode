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
            if (target<nums[mid]){
                right = mid -1;
            }else if (target > nums[mid]){
                left = mid +1;
            }else {
                return mid;
            }
        }
        return -1;


    }
}
