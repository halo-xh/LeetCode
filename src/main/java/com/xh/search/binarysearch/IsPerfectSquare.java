package com.xh.search.binarysearch;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Xiao Hong on 2021-11-04
 * </p>
 * https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class IsPerfectSquare {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(bs(15, arr));
        System.out.println("---------- = ");
        System.out.println("bs2(18) = " + bs2(808201));
    }


    public static boolean bs(int n, int[] arr) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (n > arr[mid]) {
                left = mid + 1;
            } else if (n < arr[mid]) {
                right = mid;
            } else {
                return true;
            }
            System.out.println("left = " + left);
            System.out.println("right = " + right);
        }
        return false;
    }

    public static boolean bs2(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int k = mid * mid;
            if (n > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
            System.out.println("k = " + k);
            System.out.println("left = " + left);
            System.out.println("right = " + right);
        }
        return false;
    }


    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 0;
        int right = num >> 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (mid * mid < num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right * right == num;
    }

}
