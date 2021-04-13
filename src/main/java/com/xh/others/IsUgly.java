package com.xh.others;

/**
 * author  Xiao Hong
 * date  2021/4/10 17:01
 * description
 */

public class IsUgly {

    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n >>= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
}
