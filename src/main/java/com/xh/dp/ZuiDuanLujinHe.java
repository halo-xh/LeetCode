package com.xh.dp;

/**
 * author  Xiao Hong
 * date  2020/11/20 21:02
 * description
 * <p>
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */

public class ZuiDuanLujinHe {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] mins = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    mins[0][0] = grid[0][0];
                } else if (i != 0 && j == 0) {
                    mins[i][j] = mins[i - 1][j] + grid[i][j];
                } else if (i == 0 && j != 0) {
                    mins[i][j] = mins[i][j - 1] + grid[i][j];
                } else {
                    mins[i][j] = Math.min(mins[i - 1][j], mins[i][j - 1]) + grid[i][j];
                }
            }
        }
        return mins[m - 1][n - 1];
    }
}
