package com.xh.bit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/5/12 9:14
 * <p>
 * https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 */
public class XorQueries {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = xor(arr, queries[i][0], queries[i][1]);
        }
        return res;
    }

    private int xor(int[] arr, int start, int end) {
        int res = 0;
        for (int i = start; i < arr.length && i <= end; i++) {
            res ^= arr[i];
        }
        return res;
    }
}
