package com.xh.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2021/3/15 22:02
 * description
 * https://leetcode-cn.com/problems/spiral-matrix/
 * [
 * [1,2, 3,
 * [5,6, 7,
 * [9,10,11]
 * [9,10,11]
 */

public class SpiralOrder {

    public static void main(String[] args) {
        int[][] res = new int[][]{
                {1, 5}};
        SpiralOrder spiralOrder = new SpiralOrder();
        System.out.println(spiralOrder.spiralOrder(res));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int x = matrix[0].length;
        int y = matrix.length;
        ArrayList<Integer> res = new ArrayList<>(x * y);
        circlePrint(matrix, res, 0, 0, x - 1, y - 1);
        return res;
    }

    private void circlePrint(int[][] arr, List<Integer> res, int x, int y, int xend, int yend) {
        if (xend < x || yend < y) {
            return;
        }
        // 只剩下一列
        if (x == xend) {
            for (int i = y; i <= yend; i++) {
                res.add(arr[i][x]);
            }
            return;
        }
        // 只剩下一行
        if (y == yend) {
            for (int i = x; i <= xend; i++) {
                res.add(arr[y][i]);
            }
            return;
        }
        for (int i = x; i < xend; i++) {
            res.add(arr[y][i]);
        }
        for (int i = y; i < yend; i++) {
            res.add(arr[i][xend]);
        }
        for (int i = xend; i > x; i--) {
            res.add(arr[yend][i]);
        }
        for (int i = yend; i > y; i--) {
            res.add(arr[i][x]);
        }
        circlePrint(arr, res, x + 1, y + 1, xend - 1, yend - 1);
    }
}
