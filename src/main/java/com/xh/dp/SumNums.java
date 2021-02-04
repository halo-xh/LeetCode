package com.xh.dp;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/2/3 11:55
 * @description  https://leetcode-cn.com/problems/qiu-12n-lcof/
 *
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 */
public class SumNums {

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

}
