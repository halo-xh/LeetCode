package com.xh.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/4/1 11:08
 * https://leetcode-cn.com/problems/clumsy-factorial/
 */
public class Clumsy {

    public static void main(String[] args) {
        System.out.println(clumsy(4));
    }

    public int clumsy1(int N) {
        if (N == 1 || N == 2)
            return N;
        if (N == 3)
            return 6;
        if (N == 4)
            return 7;
        if (N % 4 == 0)
            return N + 1;
        if (N % 4 == 1 || N % 4 == 2)
            return N + 2;
        return N - 1;
    }


    public static int clumsy(int N) {
        char[] cv = new char[]{'*', '/', '+', '-'};
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int j = 0;
        for (int i = N; i > 0; i--) {
            nums.push(i);
        }
        return 0;
    }


    private static int cal(char c, int a, int b) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return a / b;
        }
    }


}
