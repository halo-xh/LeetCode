package com.xh.others;

/**
 * author  Xiao Hong
 * date  2021/4/28 20:55
 * <p>
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 */

public class JudgeSquareSum {

    public static void main(String[] args) {

    }

    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c / 2);
        for (int a = 0; a <= max; a++) {
            int b = (int) Math.sqrt(c - a * a);
            if (a * a + b * b == c) return true;
        }
        return false;
    }

    /**
     * 费马平方和
     * 费马平方和 : 奇质数能表示为两个平方数之和的充分必要条件是该质数被 4 除余 1 。
     * <p>
     * 翻译过来就是：当且仅当一个自然数的质因数分解中，满足 4k+3 形式的质数次方数均为偶数时，该自然数才能被表示为两个平方数之和。
     * <p>
     * 因此我们对 c 进行质因数分解，再判断满足 4k+3 形式的质因子的次方数是否均为偶数即可。
     */
    public boolean judgeSquareSum2(int c) {
        for (int i = 2, cnt = 0; i * i <= c; i++, cnt = 0) {
            while (c % i == 0 && ++cnt > 0) c /= i;
            if (i % 4 == 3 && cnt % 2 != 0) return false;
        }
        return c % 4 != 3;
    }

}
