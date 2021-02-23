package com.xh.dp;

import java.util.List;

/**
 * author  Xiao Hong
 * date  2021/2/20 13:44
 * https://leetcode-cn.com/problems/triangle/
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */

public class MinimumTotal {

    /**
     * 倒推. 从最后一行开始，倒推，上一行的每个位置的最小值取决于最后一行的每个位置最小值
     * * 2
     * * 3 4
     * * 6 5 7
     * * 4 1 8 3
     * * 0 0 0 0 0
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size + 1][size + 1]; // 初始化最后一行为0.
        for (int i = size - 1; i >= 0; i--) {
            int levelSize = triangle.get(i).size();
            for (int j = levelSize - 1; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j); // 例如 [3][0] 取决于 [4][0]\[4][1] + 4
            }
        }
        return dp[0][0];
    }

    //空间优化
    public int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dpmnis = new int[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            int levelSize = triangle.get(i).size();
            for (int j = 0; j < levelSize; j++) {
                dpmnis[j] = Math.min(dpmnis[j], dpmnis[j + 1]) + triangle.get(i).get(j); // 例如 [3][0] 取决于 min([4][0],[4][1]) + 4
            }
        }
        return dpmnis[0];
    }


}
