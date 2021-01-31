package com.xh.dp;

/**
 * author  Xiao Hong
 * date  2020/9/20 22:47
 * description
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */

public class WangGeZuiDuanLuJin {

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        System.out.println(minPathSum(arr));
    }

    /**
     * 数组法
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] mins = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    mins[i][j] = grid[0][0];
                } else if (i == 0) {
                    mins[i][j] = mins[0][j - 1] + grid[0][j];
                } else if (j == 0) {
                    mins[i][j] = mins[i - 1][0] + grid[i][0];
                } else {
                    mins[i][j] = Math.min(mins[i - 1][j], mins[i][j - 1]) + grid[i][j];
                }

            }
        }
        return mins[m - 1][n - 1];
    }

}
