package com.xh.others.matrix;

/**
 * author  Xiao Hong
 * date  2021/3/21 15:09
 * description
 * https://leetcode-cn.com/problems/set-matrix-zeroes/submissions/
 */

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        boolean x0 = false; // 记录第一行有无 0
        boolean y0 = false; // 记录第一列有无 0
        int lengthx = matrix.length;
        int lengthy = matrix[0].length;
        for (int j = 0; j < lengthy; j++) {
            if (matrix[0][j] == 0) {
                x0 = true;
                break;
            }
        }
        for (int i = 0; i < lengthx; i++) {
            if (matrix[i][0] == 0) {
                y0 = true;
                break;
            }
        }
        // 如果某个值为0  则将其对应的第一行的值置为0 对应的第一列的值置为0
        for (int i = 1; i < lengthx; i++) {
            for (int j = 1; j < lengthy; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 根据第一行和第一列的0 将对应的行列都设置为0
        for (int i = 0; i < lengthx; i++) {
            for (int j = 0; j < lengthy; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 最后处理第一行 第一列
        if (x0) {
            for (int i = 0; i < lengthy; i++) {
                matrix[0][i] = 0;
            }
        }
        if (y0) {
            for (int i = 0; i < lengthx; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
