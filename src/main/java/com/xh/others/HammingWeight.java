package com.xh.others;

/**
 * author  Xiao Hong
 * date  2021/3/22 19:29
 * description
 * https://leetcode-cn.com/problems/number-of-1-bits/submissions/
 */

public class HammingWeight {

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(3));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }
}
