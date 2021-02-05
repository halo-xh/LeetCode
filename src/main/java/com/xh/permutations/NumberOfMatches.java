package com.xh.permutations;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/5 16:20
 * @description https://leetcode-cn.com/problems/count-of-matches-in-tournament/
 */


public class NumberOfMatches {


    // 1 2 3 4 5 6 7
    // 0 1 2 3 3 4 6
    public int numberOfMatches(int n) {
//        int res = 0;
//        while (n > 1) {
//            res += n>>1;
//            n = (n >> 1) + (n & 1);
//
//        }
//        return res;
        return n - 1;
    }
}
