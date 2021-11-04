package com.xh.search.binarysearch;

/**
 * Created by Xiao Hong on 2021-11-04
 * </p>
 * https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 0;
        int right = num >> 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (mid * mid < num) {
                left = mid +1;
            } else {
                right = mid;
            }
        }
        return right * right == num;
    }

}
