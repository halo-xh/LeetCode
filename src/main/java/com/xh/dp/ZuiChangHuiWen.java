package com.xh.dp;

/**
 * author  Xiao Hong
 * date  2020/9/22 21:08
 * description
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ZuiChangHuiWen {

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("babad"));

    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int max = 1, start = 0;
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
        }
        // sLen 字串长度
        for (int sLen = 2; sLen <= chars.length; sLen++) {
            // i 左边起点
            for (int i = 0; i < chars.length; i++) {
                // 根据 r - i + 1 = sLen 算出右边索引
                int r = sLen + i - 1;
                // 判断
                if (r >= chars.length) {
                    break;
                }
                // 如果左右相同
                if (chars[i] == chars[r]) {
                    // 长度在3之下 直接true
                    if (r - i < 3) {
                        dp[i][r] = true;
                    } else {
                        // 否则取决于除去左右端点的中间串是否为回文
                        dp[i][r] = dp[i + 1][r - 1];
                    }
                } else {
                    // 不同直接false
                    dp[i][r] = false;
                }
                // 尝试更新最大
                if (dp[i][r] && sLen > max) {
                    start = i;
                    max = sLen;
                }
            }
        }
        return s.substring(start, max + start);
    }


    /**
     * 中心扩散
     */
    public static String longestPalindrome2(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        char[] chars = s.toCharArray();
        // 遍历，分别以遍历到的值向两边扩散
        int start = 0, end = 0;
        for (int i = 0; i < chars.length; i++) {
            int i1 = explanAround(i, i, chars);
            int i2 = explanAround(i, i + 1, chars);
            int max = Math.max(i1, i2);
            if (max > end - start + 1) {
                // a b a
                // 0 1 2
                // a b b a
                // 0 1 2 3
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int explanAround(int l, int r, char[] chars) {
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            l--;
            r++;
        }
        return r - l + 1;
    }
}
