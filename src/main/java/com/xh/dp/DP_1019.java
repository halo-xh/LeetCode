package com.xh.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2021/10/19 21:44
 * description
 */

public class DP_1019 {


    public static void main(String[] args) {

    }

    /**
     * https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rtwu06/
     */
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                } else if (i > 0) {
                    res[i][j] = res[i - 1][j];
                } else if (j > 0) {
                    res[i][j] = res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }


    /**
     * https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rt1hg6/
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        int[][] res = new int[x][y];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        res[0][0] = 1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i > 0 && j > 0) {
                        res[i][j] = res[i - 1][j] + res[i][j - 1];
                    } else if (i > 0) {
                        res[i][j] = res[i - 1][j];
                    } else if (j > 0) {
                        res[i][j] = res[i][j - 1];
                    }
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return res[x - 1][y - 1];
    }


    /**
     * https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rtcz3i/
     */
    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] res = new int[x][y];
        res[0][0] = grid[0][0];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i > 0 && j > 0) {
                    res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
                } else if (i > 0) {
                    res[i][j] = res[i - 1][j] + grid[i][j];
                } else if (j > 0) {
                    res[i][j] = res[i][j - 1] + grid[i][j];
                }
            }
        }
        return res[x - 1][y - 1];
    }

    /**
     * https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rtfiiv/
     * <p>
     * O(n^2)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int ans = Integer.MAX_VALUE;
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int val = triangle.get(i).get(j);
                f[i][j] = Integer.MAX_VALUE;
                if (j != 0) f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + val);
                if (j != i) f[i][j] = Math.min(f[i][j], f[i - 1][j] + val);
            }
        }
        for (int i = 0; i < n; i++) ans = Math.min(ans, f[n - 1][i]);
        return ans;
    }


}
