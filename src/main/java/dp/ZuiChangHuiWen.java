package dp;

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
        System.out.println(longestPalindrome("bbcbbd"));

    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len == 0) {
            return s;
        }
        int max = 1;
        int start = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < chars.length; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[i] == chars[j] && (dp[j + 1][i - 1] || i - j < 3)) {
                    dp[j][i] = true;
                    if ((i - j + 1) > max) {
                        max = i - j + 1;
                        start = j;
                    }
                } else {
                    dp[j][i] = false;
                }
            }
        }
        return s.substring(start, start + max);
    }
}
