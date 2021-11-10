package com.xh.dp;

import java.util.Arrays;
import java.util.List;

/**
 * author  Xiao Hong
 * date  2021/11/10 21:31
 * description
 * https://leetcode-cn.com/circle/article/NfHhXD/
 */

public class DpTest {


    /**
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/
     */
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] res = new int[length + 1];
        for (int i = 0; i < length; i++) {
            int formerMaxLen = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    formerMaxLen = Math.max(formerMaxLen, res[j]);
                }
            }
            res[i] = ++formerMaxLen;
        }
        int rs = 1;
        for (int re : res) {
            rs = Math.max(rs, re);
        }
        return rs;
    }

    /**
     * https://leetcode-cn.com/problems/longest-common-subsequence/
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] res = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    res[i + 1][j + 1] = res[i][j] + 1; // 注意这里 的转移
                } else {
                    res[i + 1][j + 1] = Math.max(res[i][j + 1], res[i + 1][j]);
                }
            }
        }
        return res[chars1.length][chars2.length];
    }

    /**
     * https://leetcode-cn.com/problems/triangle/
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> integers = triangle.get(i);
            for (int j = 0; j < integers.size(); j++) {
                Integer cur = triangle.get(i).get(j);
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j) + cur);
                } else if (j == integers.size() - 1) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + cur);
                } else {
                    triangle.get(i).set(j, Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)) + cur);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer integer : triangle.get(triangle.size() - 1)) {
            min = Math.min(min, integer);
        }
        return min;
    }

    /**
     * https://leetcode-cn.com/problems/maximum-subarray/
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int value : nums) {
            sum = Math.max(value + sum, value);
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * https://leetcode-cn.com/problems/maximum-product-subarray/
     */
    public int maxProduct(int[] nums) {
        return 0;
    }

    /**
     * https://leetcode-cn.com/problems/russian-doll-envelopes/
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return o1[0] - o2[0];
            } else if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return -1;
            }
        });
        int[] res = new int[envelopes.length];
        Arrays.fill(res, 1);
        int max = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    res[i] = Math.max(res[j] + 1, res[i]);
                }
            }
            max = Math.max(res[i], max);
        }
        return max;
    }


}
