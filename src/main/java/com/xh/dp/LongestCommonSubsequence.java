package com.xh.dp;

/**
 * author  Xiao Hong
 * date  2021/4/3 21:33
 * description
 */

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int max = 0;
        int[][] res = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    res[i + 1][j + 1] = res[i][j] + 1;
                    max = Math.max(res[i + 1][j + 1], max);
                } else {
                    res[i + 1][j + 1] = Math.max(res[i + 1][j], res[i][j + 1]);
                }
            }
        }
        return max;
    }


}
