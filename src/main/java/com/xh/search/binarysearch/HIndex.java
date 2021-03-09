package com.xh.search.binarysearch;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/6 18:09
 * https://leetcode-cn.com/problems/h-index-ii/
 */
public class HIndex {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int pivot, left = 0, right = n - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (citations[pivot] == n - pivot) {
                return n - pivot;
            } else if (citations[pivot] < n - pivot) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return n - left;
    }
}
