package com.xh.permutations;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/6 10:13
 * https://leetcode-cn.com/problems/eight-queens-lcci/
 * https://leetcode-cn.com/problems/n-queens-ii/
 * <p>
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。
 * 这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 *
 * 回溯模板
 * void backtrack(..,..){
 *     //触发结束条件
 *     if(达到边界){
 *        记录数据，返回
 *     }
 *     for 选择 in 选择列表:
 *     1.排除重叠问题
 *     2.做选择
 *     3.backtrack(..,..)回溯
 *     4.撤销选择
 * }
 */
public class SolveNQueens {
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> res = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                String[][] ans = initArr(n);
//                ans[i][j] = "Q";
//                if (!valid(ans,i,j)){
//                    continue;
//                }
//
//            }
//        }
//    }

    int n = 0;
    List<List<String>> lists = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        dfs(0, initArr(n));
        return lists;
    }

    public void dfs(int row, String[][] arr) {
        if (row == n) {
            lists.add(Arrays.stream(arr).map(x -> String.join("", x)).collect(Collectors.toList()));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!valid(arr, row, i)) {
                continue;
            }
            arr[row][i] = "Q";
            dfs(row + 1, arr);
            arr[row][i] = ".";
        }

    }

    public String[][] initArr(int n) {
        String[][] ans = new String[n][n];
        for (int i = 0; i < ans.length; i++) {
            String[] strings = new String[n];
            Arrays.fill(strings, ".");
            ans[i] = strings;
        }
        return ans;
    }

    //遍历判断
    public boolean valid(String[][] partres, int row, int col) {
        // ------ 检查列
        for (int i1 = 0; i1 < row; i1++) {
            if ("Q".equals(partres[i1][col])) {
                return false;
            }
        }
        // 检查 45度角是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(partres[i][j])) {
                return false;
            }
        }
        // 检查 135度角是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if ("Q".equals(partres[i][j])) {
                return false;
            }
        }
        return true;
    }
}
