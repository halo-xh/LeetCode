package com.xh.others.matrix;

/**
 * author  Xiao Hong
 * date  2021/3/21 15:09
 * description
 * https://leetcode-cn.com/problems/set-matrix-zeroes/submissions/
 */

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        boolean x0 = false;
        boolean y0 = false;
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
        for (int i = 1; i < lengthx; i++) {
            for (int j = 1; j < lengthy; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 0; i < lengthx; i++) {
            for (int j = 0; j < lengthy; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
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
