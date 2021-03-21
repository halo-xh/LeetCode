package com.xh.dp.linerDp;

import java.util.Arrays;

/**
 * author  Xiao Hong
 * date  2021/3/21 18:14
 * description
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcba", "abcbcba"));

    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int[][] arr = new int[c1.length + 1][c2.length + 1];
        for (int i = c1.length - 1; i >= 0; i--) {
            for (int j = c2.length - 1; j >= 0; j--) {
                if (c1[i] == c2[j]) {
                    arr[i][j] = arr[i + 1][j + 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
                }
            }
        }
//        Arrays.stream(arr).forEach(a -> {
//            System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
//        });
        return arr[0][0];
    }


}
