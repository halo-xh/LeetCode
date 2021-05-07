package com.xh.bit;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/5/7 12:22
 * @description
 */
public class XorOperation {

    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res ^= (start + i * 2);
        }
        return res;
    }
}
