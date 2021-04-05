package com.xh.others;

import java.util.Arrays;

/**
 * author  Xiao Hong
 * date  2021/4/5 22:19
 * description
 */

public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int idx = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                nums1[idx--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
            } else if (i >= 0) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }
    }
}
