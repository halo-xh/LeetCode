package com.xh.dfs;

import java.util.*;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/3/31 9:08
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class SubsetsWithDup {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur, ans);
        return new ArrayList<>(ans);
    }

    /**
     * @param nums 原输入数组
     * @param u    当前决策到原输入数组中的哪一位
     * @param cur  当前方案
     * @param ans  最终结果集
     */
    void dfs(int[] nums, int u, List<Integer> cur, Set<List<Integer>> ans) {
        // 所有位置都决策完成，将当前方案放入结果集
        if (nums.length == u) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        // 选择当前位置的元素，往下决策
        cur.add(nums[u]);
        dfs(nums, u + 1, cur, ans);

        // 不选当前位置的元素（回溯），往下决策
        cur.remove(cur.size() - 1);
        dfs(nums, u + 1, cur, ans);
    }

    /**
     * https://leetcode-cn.com/problems/number-of-enclaves/
     */
    public static int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }
        int res = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                res += ints[j];
            }
        }
        return res;
    }

    static int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static void dfs(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        for (int[] mv : move) {
            if (mv[0] + i < grid.length && mv[0] + i > 0 && mv[1] + j > 0 && mv[1] + j < grid[0].length) {
                dfs(grid, mv[0] + i, mv[1] + j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }


}
