package com.xh.bfs;

/**
 * Created by Xiao Hong on 2021-10-25
 * </p>
 * <p>
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class SearchMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;

    }


}

