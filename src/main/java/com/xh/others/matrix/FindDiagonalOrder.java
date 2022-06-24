package com.xh.others.matrix;

import java.util.*;
import java.util.function.IntFunction;

/**
 * @author Xiao Hong
 * @since 2022-06-14
 * <p>
 * https://leetcode.cn/problems/diagonal-traverse/
 */
public class FindDiagonalOrder {


    public static void main(String[] args) {
        FindDiagonalOrder findDiagonalOrder = new FindDiagonalOrder();
        int[][] a = new int[][]{{1, 2}, {4, 5}};
        int[] diagonalOrder = findDiagonalOrder.findDiagonalOrder(a);
        System.out.println("diagonalOrder = " + Arrays.toString(diagonalOrder));
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int i = 0, j = 0, idx = 0, ct = mat.length * mat[0].length;
        int[] ans = new int[ct];
        boolean forward = true;
        while (ct != idx) {
            if (i < mat.length && j < mat[0].length){
                ans[idx++] = mat[i][j];
            }
            if (forward) {
                // 右上角
                i--;
                j++;
                if (i < 0) {
                    forward = false;
                    i++;
                } else if (j >= mat[0].length) {
                    forward = false;
                    j--;
                    i += 2;
                }
            } else {
                // 左下角
                i++;
                j--;
                if (j < 0) {
                    j++;
                    forward = true;
                } else if (i >= mat.length) {
                    forward = true;
                    i--;
                    j += 2;
                }
            }
        }
        return ans;
    }

    public int[] findDiagonalOrder2(int[][] mat) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            sf(mat, i, 0, integers);
        }
        for (int j = 1; j < mat[0].length; j++) {
            sf(mat, mat.length - 1, j, integers);
        }
        return integers.stream().mapToInt(Integer::intValue).toArray();
    }


    // 看错题了。
    private void sf(int[][] mat, int i, int j, List<Integer> res) {
        while (i >= 0 && i < mat.length && j < mat[0].length) {
            res.add(mat[i][j]);
            i--;
            j++;
        }
    }

}
