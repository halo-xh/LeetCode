package com.xh.dp;

import java.util.Arrays;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/21 19:06
 * <p>
 * https://leetcode-cn.com/problems/decode-ways/
 * <p>
 * 不难发现对于字符串 s 的某个位置 i 而言，我们只关心「位置 i 自己能否形成独立 item 」和「位置 i 能够与上一位置（i-1）能否形成 item」，
 * 而不关心 i-1 之前的位置。
 */
public class NumDecodings {

    public static void main(String[] args) {
        System.out.println("分享主题空间".substring(0,2));
        NumDecodings decodings = new NumDecodings();
        decodings.numDecodings("1231");
    }

    public int numDecodings(String s) {
        int n = s.length();
        s = " " + s;
        char[] cs = s.toCharArray();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            // a : 代表「当前位置」单独形成 item
            // b : 代表「当前位置」与「前一位置」共同形成 item
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            // 如果 a 属于有效值，那么 f[i] 可以由 f[i - 1] 转移过来
            if (1 <= a && a <= 9) {
                f[i] = f[i - 1];
            }
            // 如果 b 属于有效值，那么 f[i] 可以由 f[i - 2] 或者 f[i - 1] & f[i - 2] 转移过来
            if (10 <= b && b <= 26) {
                f[i] += f[i - 2];
            }
        }
        System.out.println(Arrays.toString(f));
        return f[n];
    }

}
