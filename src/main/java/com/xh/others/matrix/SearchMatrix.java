package com.xh.others.matrix;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/30 9:07
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            }else {
                return true;
            }
        }
        return false;
    }
}
