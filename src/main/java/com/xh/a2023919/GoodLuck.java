package com.xh.a2023919;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xiao Hong
 * @since 2023-09-19
 */
public class GoodLuck {

    public static void main(String[] args) {

    }


    //https://leetcode.cn/problems/hanota-lcci/
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A, B, C, A.size());
    }

    public static void move(List<Integer> A, List<Integer> B, List<Integer> C, int size) {
        if (size == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        move(A, C, B, size - 1);
        C.add(A.remove(A.size() - 1));
        System.out.println("A.size() = " + A.size());
        move(B, A, C, size - 1);
    }


    //https://leetcode.cn/problems/different-ways-to-add-parentheses/
    public List<Integer> diffWaysToCompute(String expression) {
        char[] chars = expression.toCharArray();
        return diffWaysToCompute1(0, chars.length, chars);
    }

    public static List<Integer> diffWaysToCompute1(int left, int right, char[] chars) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < right; i++) {
            if (chars[i] == '-' || chars[i] == '+' || chars[i] == '*') {
                List<Integer> r = diffWaysToCompute1(i + 1, right, chars);
                List<Integer> l = diffWaysToCompute1(left, i, chars);
                for (Integer integer : l) {
                    for (Integer integer1 : r) {
                        if (chars[i] == '-') {
                            res.add(integer - integer1);
                        } else if (chars[i] == '+') {
                            res.add(integer + integer1);
                        } else {
                            res.add(integer * integer1);
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.valueOf(new String(Arrays.copyOfRange(chars, left, right))));
        }
        return res;
    }

    //https://leetcode.cn/problems/longest-increasing-subsequence/description/
    public int lengthOfLIS(int[] nums) {
        int[] maxR = new int[nums.length];
        if (nums.length == 1) {
            return 1;
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            maxR[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxR[i] = Math.max(maxR[i], maxR[j] + 1);
                }
            }
            res = Math.max(res, maxR[i]);
        }
        return res;
    }

    //https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, prices[i] - prices[j]);
            }
            res = Math.max(res, max);
        }
        return res;
    }

    //https://leetcode.cn/problems/longest-common-subsequence/description/
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] res = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    res[i + 1][j + 1] = res[i][j] + 1;
                } else {
                    res[i + 1][j + 1] = Math.max(res[i + 1][j], res[i][j + 1]);
                }
            }
        }
        return res[chars1.length][chars2.length];
    }

    //https://leetcode.cn/problems/longest-palindromic-subsequence/description/
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }


}
