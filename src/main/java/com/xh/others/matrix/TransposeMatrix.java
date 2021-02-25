package com.xh.others.matrix;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/25 16:55
 * https://leetcode-cn.com/problems/transpose-matrix/
 * 输入：matrix =
 * [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：
 * [[1,4,7],
 * [2,5,8],
 * [3,6,9]]
 *
 * 输入：matrix =
 * [[1,2,3],
 * [4,5,6]]
 * 输出：
 * [[1,4],
 * [2,5],
 * [3,6]]
 */
public class TransposeMatrix {

    public int[][] transpose(int[][] matrix) {
        int[][] res= new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                res[i1][i] = matrix[i][i1];
            }
        }
        return res;
    }
}
