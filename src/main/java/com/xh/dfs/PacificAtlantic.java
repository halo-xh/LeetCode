package com.xh.dfs;

import java.util.*;

public class PacificAtlantic {

    private static final int[][] mv = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    //https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] res1 = new boolean[m][n];
        boolean[][] res2 = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dfs(heights, i, j, res1);
                }
                if (i == m - 1 || j == n - 1) {
                    dfs(heights, i, j, res2);
                }
            }
        }
        List<List<Integer>> finalRes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res1[i][j] && res2[i][j]) {
                    finalRes.add(Arrays.asList(i, j));
                }
            }
        }
        return finalRes;
    }

    private void dfs(int[][] arr, int i, int j, boolean[][] ress) {
        int cur = arr[i][j];
        ress[i][j] = true;
        for (int[] ints : mv) {
            int x = ints[0] + i;
            int y = ints[1] + j;
            if (x >= arr.length || y >= arr[0].length || x < 0 || y < 0) {
                continue;
            }
            if (ress[x][y] || cur > arr[x][y]) {
                continue;
            }
            dfs(arr, x, y, ress);
        }
    }
}
