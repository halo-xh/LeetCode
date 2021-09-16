package com.xh.search.binarysearch;

/**
 * author  Xiao Hong
 * date  2021/9/15 21:13
 * description https://leetcode-cn.com/problems/find-peak-element/
 */

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }


}
