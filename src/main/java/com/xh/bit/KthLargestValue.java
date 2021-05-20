package com.xh.bit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/5/19 9:07
 * <p>
 *     5 2
 *     1 6
 *
 *     1^2^6 =
 *      001
 *      010
 *      110
 *
 *      5 5^2
 *      1^5  2^1^5^6=
 *
 *     5 7
 *     4 0
 *
 * https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 */
public class KthLargestValue {

    public static void main(String[] args) {
        System.out.println(5^4^7);
    }

    public int kthLargestValue(int[][] matrix, int k) {
        int length = matrix.length;
        int y = matrix[0].length;
        int[][] pre = new int[length + 1][y + 1];
        List<Integer> all = new ArrayList<>(y);
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < y; j++) {
                pre[i][j] = matrix[i - 1][j - 1] ^ pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1];
                all.add(pre[i][j]);
            }
        }
        Collections.sort(all,Collections.reverseOrder());
        return all.get(k);
    }
}