package com.xh.others;

import java.util.Arrays;

/**
 * @author xiaohong
 * @date 2022/2/24 9:45
 * <p>
 * https://leetcode-cn.com/problems/where-will-the-ball-fall/
 **/
public class FindBall {

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int j = 0; j < n; j++) {
            int col = j;  // 球的初始列
            for (int[] row : grid) {
                int dir = row[col];
                col += dir;  // 移动球
                if (col < 0 || col == n || row[col] != dir) {  // 到达侧边或 V 形
                    col = -1;
                    break;
                }
            }
            if (col >= 0) {  // 成功到达底部
                ans[j] = col;
            }
        }
        return ans;
    }

}
