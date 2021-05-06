package com.xh.bit;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/5/6 12:17
 * https://leetcode-cn.com/problems/decode-xored-array/
 */
public class DecodeXoredArray {

    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] ans = new int[n];
        ans[0] = first;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;

    }
}
