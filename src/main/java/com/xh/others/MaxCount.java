package com.xh.others;


/**
 * author  Xiao Hong
 * date  2021/11/7 20:38
 * description https://leetcode-cn.com/problems/range-addition-ii/
 */

public class MaxCount {

    public int maxCount(int m, int n, int[][] ops) {
        int a0 = m;
        int a1 = n;
        for (int[] op : ops) {
            a0 = Math.min(a0, op[0]);
            a1 = Math.min(a1, op[1]);
        }
        return a0 * a1;
    }


}
